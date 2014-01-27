package de.uni_hildesheim.sse.vil.expressions.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import de.uni_hildesheim.sse.vil.expressions.services.ExpressionDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_VERSION", "RULE_EXPONENT", "RULE_STRING", "RULE_NUMBER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'=='", "'>'", "'<'", "'>='", "'<='", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'true'", "'false'", "'@advice'", "'('", "')'", "'with'", "','", "'version'", "';'", "'import'", "'super'", "'.'", "'new'", "'['", "']'", "'='", "'{'", "'}'", "'::'", "'setOf'", "'sequenceOf'", "'mapOf'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_VERSION=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=8;
    public static final int T__14=14;
    public static final int T__13=13;
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
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_EXPONENT=6;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalExpressionDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionDslParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g"; }


     
     	private ExpressionDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ExpressionDslGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleLanguageUnit"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:60:1: entryRuleLanguageUnit : ruleLanguageUnit EOF ;
    public final void entryRuleLanguageUnit() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:61:1: ( ruleLanguageUnit EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:62:1: ruleLanguageUnit EOF
            {
             before(grammarAccess.getLanguageUnitRule()); 
            pushFollow(FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit61);
            ruleLanguageUnit();

            state._fsp--;

             after(grammarAccess.getLanguageUnitRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLanguageUnit68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLanguageUnit"


    // $ANTLR start "ruleLanguageUnit"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:69:1: ruleLanguageUnit : ( ( rule__LanguageUnit__Group__0 ) ) ;
    public final void ruleLanguageUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:73:2: ( ( ( rule__LanguageUnit__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:74:1: ( ( rule__LanguageUnit__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:74:1: ( ( rule__LanguageUnit__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:75:1: ( rule__LanguageUnit__Group__0 )
            {
             before(grammarAccess.getLanguageUnitAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:76:1: ( rule__LanguageUnit__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:76:2: rule__LanguageUnit__Group__0
            {
            pushFollow(FOLLOW_rule__LanguageUnit__Group__0_in_ruleLanguageUnit94);
            rule__LanguageUnit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLanguageUnitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguageUnit"


    // $ANTLR start "entryRuleAdvice"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:90:1: entryRuleAdvice : ruleAdvice EOF ;
    public final void entryRuleAdvice() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:91:1: ( ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:92:1: ruleAdvice EOF
            {
             before(grammarAccess.getAdviceRule()); 
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice123);
            ruleAdvice();

            state._fsp--;

             after(grammarAccess.getAdviceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice130); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdvice"


    // $ANTLR start "ruleAdvice"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:99:1: ruleAdvice : ( ( rule__Advice__Group__0 ) ) ;
    public final void ruleAdvice() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:103:2: ( ( ( rule__Advice__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:104:1: ( ( rule__Advice__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:104:1: ( ( rule__Advice__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:105:1: ( rule__Advice__Group__0 )
            {
             before(grammarAccess.getAdviceAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:106:1: ( rule__Advice__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:106:2: rule__Advice__Group__0
            {
            pushFollow(FOLLOW_rule__Advice__Group__0_in_ruleAdvice156);
            rule__Advice__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdviceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdvice"


    // $ANTLR start "entryRuleVersionSpec"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:118:1: entryRuleVersionSpec : ruleVersionSpec EOF ;
    public final void entryRuleVersionSpec() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:119:1: ( ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:120:1: ruleVersionSpec EOF
            {
             before(grammarAccess.getVersionSpecRule()); 
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec183);
            ruleVersionSpec();

            state._fsp--;

             after(grammarAccess.getVersionSpecRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersionSpec"


    // $ANTLR start "ruleVersionSpec"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:127:1: ruleVersionSpec : ( ( rule__VersionSpec__Group__0 ) ) ;
    public final void ruleVersionSpec() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:131:2: ( ( ( rule__VersionSpec__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:132:1: ( ( rule__VersionSpec__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:132:1: ( ( rule__VersionSpec__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:133:1: ( rule__VersionSpec__Group__0 )
            {
             before(grammarAccess.getVersionSpecAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:134:1: ( rule__VersionSpec__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:134:2: rule__VersionSpec__Group__0
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__0_in_ruleVersionSpec216);
            rule__VersionSpec__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionSpecAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersionSpec"


    // $ANTLR start "entryRuleVersionedId"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:146:1: entryRuleVersionedId : ruleVersionedId EOF ;
    public final void entryRuleVersionedId() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:147:1: ( ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:148:1: ruleVersionedId EOF
            {
             before(grammarAccess.getVersionedIdRule()); 
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId243);
            ruleVersionedId();

            state._fsp--;

             after(grammarAccess.getVersionedIdRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId250); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersionedId"


    // $ANTLR start "ruleVersionedId"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:155:1: ruleVersionedId : ( ( rule__VersionedId__Group__0 ) ) ;
    public final void ruleVersionedId() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:159:2: ( ( ( rule__VersionedId__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:160:1: ( ( rule__VersionedId__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:160:1: ( ( rule__VersionedId__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:161:1: ( rule__VersionedId__Group__0 )
            {
             before(grammarAccess.getVersionedIdAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:162:1: ( rule__VersionedId__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:162:2: rule__VersionedId__Group__0
            {
            pushFollow(FOLLOW_rule__VersionedId__Group__0_in_ruleVersionedId276);
            rule__VersionedId__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionedIdAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersionedId"


    // $ANTLR start "entryRuleVersionOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:174:1: entryRuleVersionOperator : ruleVersionOperator EOF ;
    public final void entryRuleVersionOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:175:1: ( ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:176:1: ruleVersionOperator EOF
            {
             before(grammarAccess.getVersionOperatorRule()); 
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator303);
            ruleVersionOperator();

            state._fsp--;

             after(grammarAccess.getVersionOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator310); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersionOperator"


    // $ANTLR start "ruleVersionOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:183:1: ruleVersionOperator : ( ( rule__VersionOperator__Alternatives ) ) ;
    public final void ruleVersionOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:187:2: ( ( ( rule__VersionOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:188:1: ( ( rule__VersionOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:188:1: ( ( rule__VersionOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:189:1: ( rule__VersionOperator__Alternatives )
            {
             before(grammarAccess.getVersionOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:190:1: ( rule__VersionOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:190:2: rule__VersionOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__VersionOperator__Alternatives_in_ruleVersionOperator336);
            rule__VersionOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVersionOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersionOperator"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:204:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:205:1: ( ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:206:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter365);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter372); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:213:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:217:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:218:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:218:1: ( ( rule__Parameter__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:219:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:220:1: ( rule__Parameter__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:220:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter398);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleVersionStmt"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:232:1: entryRuleVersionStmt : ruleVersionStmt EOF ;
    public final void entryRuleVersionStmt() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:233:1: ( ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:234:1: ruleVersionStmt EOF
            {
             before(grammarAccess.getVersionStmtRule()); 
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt425);
            ruleVersionStmt();

            state._fsp--;

             after(grammarAccess.getVersionStmtRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt432); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVersionStmt"


    // $ANTLR start "ruleVersionStmt"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:241:1: ruleVersionStmt : ( ( rule__VersionStmt__Group__0 ) ) ;
    public final void ruleVersionStmt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:245:2: ( ( ( rule__VersionStmt__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:246:1: ( ( rule__VersionStmt__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:246:1: ( ( rule__VersionStmt__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:247:1: ( rule__VersionStmt__Group__0 )
            {
             before(grammarAccess.getVersionStmtAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:248:1: ( rule__VersionStmt__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:248:2: rule__VersionStmt__Group__0
            {
            pushFollow(FOLLOW_rule__VersionStmt__Group__0_in_ruleVersionStmt458);
            rule__VersionStmt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVersionStmtAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVersionStmt"


    // $ANTLR start "entryRuleImport"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:260:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:261:1: ( ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:262:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport485);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport492); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:269:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:273:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:274:1: ( ( rule__Import__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:274:1: ( ( rule__Import__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:275:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:276:1: ( rule__Import__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:276:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport518);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:290:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:291:1: ( ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:292:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression547);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression554); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:299:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:303:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:304:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:304:1: ( ( rule__Expression__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:305:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:306:1: ( rule__Expression__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:306:2: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_rule__Expression__Alternatives_in_ruleExpression580);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogicalExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:318:1: entryRuleLogicalExpression : ruleLogicalExpression EOF ;
    public final void entryRuleLogicalExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:319:1: ( ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:320:1: ruleLogicalExpression EOF
            {
             before(grammarAccess.getLogicalExpressionRule()); 
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression607);
            ruleLogicalExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression614); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:327:1: ruleLogicalExpression : ( ( rule__LogicalExpression__Group__0 ) ) ;
    public final void ruleLogicalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:331:2: ( ( ( rule__LogicalExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:332:1: ( ( rule__LogicalExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:332:1: ( ( rule__LogicalExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:333:1: ( rule__LogicalExpression__Group__0 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:334:1: ( rule__LogicalExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:334:2: rule__LogicalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__LogicalExpression__Group__0_in_ruleLogicalExpression640);
            rule__LogicalExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:346:1: entryRuleLogicalExpressionPart : ruleLogicalExpressionPart EOF ;
    public final void entryRuleLogicalExpressionPart() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:347:1: ( ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:348:1: ruleLogicalExpressionPart EOF
            {
             before(grammarAccess.getLogicalExpressionPartRule()); 
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart667);
            ruleLogicalExpressionPart();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart674); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalExpressionPart"


    // $ANTLR start "ruleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:355:1: ruleLogicalExpressionPart : ( ( rule__LogicalExpressionPart__Group__0 ) ) ;
    public final void ruleLogicalExpressionPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:359:2: ( ( ( rule__LogicalExpressionPart__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:360:1: ( ( rule__LogicalExpressionPart__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:360:1: ( ( rule__LogicalExpressionPart__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:361:1: ( rule__LogicalExpressionPart__Group__0 )
            {
             before(grammarAccess.getLogicalExpressionPartAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:362:1: ( rule__LogicalExpressionPart__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:362:2: rule__LogicalExpressionPart__Group__0
            {
            pushFollow(FOLLOW_rule__LogicalExpressionPart__Group__0_in_ruleLogicalExpressionPart700);
            rule__LogicalExpressionPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalExpressionPart"


    // $ANTLR start "entryRuleLogicalOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:374:1: entryRuleLogicalOperator : ruleLogicalOperator EOF ;
    public final void entryRuleLogicalOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:375:1: ( ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:376:1: ruleLogicalOperator EOF
            {
             before(grammarAccess.getLogicalOperatorRule()); 
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator727);
            ruleLogicalOperator();

            state._fsp--;

             after(grammarAccess.getLogicalOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator734); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicalOperator"


    // $ANTLR start "ruleLogicalOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:383:1: ruleLogicalOperator : ( ( rule__LogicalOperator__Alternatives ) ) ;
    public final void ruleLogicalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:387:2: ( ( ( rule__LogicalOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:388:1: ( ( rule__LogicalOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:388:1: ( ( rule__LogicalOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:389:1: ( rule__LogicalOperator__Alternatives )
            {
             before(grammarAccess.getLogicalOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:390:1: ( rule__LogicalOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:390:2: rule__LogicalOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__LogicalOperator__Alternatives_in_ruleLogicalOperator760);
            rule__LogicalOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLogicalOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicalOperator"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:402:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:403:1: ( ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:404:1: ruleEqualityExpression EOF
            {
             before(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression787);
            ruleEqualityExpression();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression794); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:411:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:415:2: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:416:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:416:1: ( ( rule__EqualityExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:417:1: ( rule__EqualityExpression__Group__0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:418:1: ( rule__EqualityExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:418:2: rule__EqualityExpression__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression820);
            rule__EqualityExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleEqualityExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:430:1: entryRuleEqualityExpressionPart : ruleEqualityExpressionPart EOF ;
    public final void entryRuleEqualityExpressionPart() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:431:1: ( ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:432:1: ruleEqualityExpressionPart EOF
            {
             before(grammarAccess.getEqualityExpressionPartRule()); 
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart847);
            ruleEqualityExpressionPart();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart854); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqualityExpressionPart"


    // $ANTLR start "ruleEqualityExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:439:1: ruleEqualityExpressionPart : ( ( rule__EqualityExpressionPart__Group__0 ) ) ;
    public final void ruleEqualityExpressionPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:443:2: ( ( ( rule__EqualityExpressionPart__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:444:1: ( ( rule__EqualityExpressionPart__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:444:1: ( ( rule__EqualityExpressionPart__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:445:1: ( rule__EqualityExpressionPart__Group__0 )
            {
             before(grammarAccess.getEqualityExpressionPartAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:446:1: ( rule__EqualityExpressionPart__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:446:2: rule__EqualityExpressionPart__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpressionPart__Group__0_in_ruleEqualityExpressionPart880);
            rule__EqualityExpressionPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityExpressionPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualityExpressionPart"


    // $ANTLR start "entryRuleEqualityOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:458:1: entryRuleEqualityOperator : ruleEqualityOperator EOF ;
    public final void entryRuleEqualityOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:459:1: ( ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:460:1: ruleEqualityOperator EOF
            {
             before(grammarAccess.getEqualityOperatorRule()); 
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator907);
            ruleEqualityOperator();

            state._fsp--;

             after(grammarAccess.getEqualityOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator914); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqualityOperator"


    // $ANTLR start "ruleEqualityOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:467:1: ruleEqualityOperator : ( ( rule__EqualityOperator__Alternatives ) ) ;
    public final void ruleEqualityOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:471:2: ( ( ( rule__EqualityOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:472:1: ( ( rule__EqualityOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:472:1: ( ( rule__EqualityOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:473:1: ( rule__EqualityOperator__Alternatives )
            {
             before(grammarAccess.getEqualityOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:474:1: ( rule__EqualityOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:474:2: rule__EqualityOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__EqualityOperator__Alternatives_in_ruleEqualityOperator940);
            rule__EqualityOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEqualityOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:486:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:487:1: ( ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:488:1: ruleRelationalExpression EOF
            {
             before(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression967);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression974); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:495:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:499:2: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:500:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:500:1: ( ( rule__RelationalExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:501:1: ( rule__RelationalExpression__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:502:1: ( rule__RelationalExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:502:2: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression1000);
            rule__RelationalExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleRelationalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:514:1: entryRuleRelationalExpressionPart : ruleRelationalExpressionPart EOF ;
    public final void entryRuleRelationalExpressionPart() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:515:1: ( ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:516:1: ruleRelationalExpressionPart EOF
            {
             before(grammarAccess.getRelationalExpressionPartRule()); 
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1027);
            ruleRelationalExpressionPart();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart1034); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalExpressionPart"


    // $ANTLR start "ruleRelationalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:523:1: ruleRelationalExpressionPart : ( ( rule__RelationalExpressionPart__Group__0 ) ) ;
    public final void ruleRelationalExpressionPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:527:2: ( ( ( rule__RelationalExpressionPart__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:528:1: ( ( rule__RelationalExpressionPart__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:528:1: ( ( rule__RelationalExpressionPart__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:529:1: ( rule__RelationalExpressionPart__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionPartAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:530:1: ( rule__RelationalExpressionPart__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:530:2: rule__RelationalExpressionPart__Group__0
            {
            pushFollow(FOLLOW_rule__RelationalExpressionPart__Group__0_in_ruleRelationalExpressionPart1060);
            rule__RelationalExpressionPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpressionPart"


    // $ANTLR start "entryRuleRelationalOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:542:1: entryRuleRelationalOperator : ruleRelationalOperator EOF ;
    public final void entryRuleRelationalOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:543:1: ( ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:544:1: ruleRelationalOperator EOF
            {
             before(grammarAccess.getRelationalOperatorRule()); 
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1087);
            ruleRelationalOperator();

            state._fsp--;

             after(grammarAccess.getRelationalOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator1094); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:551:1: ruleRelationalOperator : ( ( rule__RelationalOperator__Alternatives ) ) ;
    public final void ruleRelationalOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:555:2: ( ( ( rule__RelationalOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:556:1: ( ( rule__RelationalOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:556:1: ( ( rule__RelationalOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:557:1: ( rule__RelationalOperator__Alternatives )
            {
             before(grammarAccess.getRelationalOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:558:1: ( rule__RelationalOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:558:2: rule__RelationalOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1120);
            rule__RelationalOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRelationalOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:570:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:571:1: ( ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:572:1: ruleAdditiveExpression EOF
            {
             before(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1147);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1154); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:579:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:583:2: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:584:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:584:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:585:1: ( rule__AdditiveExpression__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:586:1: ( rule__AdditiveExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:586:2: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression1180);
            rule__AdditiveExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:598:1: entryRuleAdditiveExpressionPart : ruleAdditiveExpressionPart EOF ;
    public final void entryRuleAdditiveExpressionPart() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:599:1: ( ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:600:1: ruleAdditiveExpressionPart EOF
            {
             before(grammarAccess.getAdditiveExpressionPartRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart1207);
            ruleAdditiveExpressionPart();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart1214); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveExpressionPart"


    // $ANTLR start "ruleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:607:1: ruleAdditiveExpressionPart : ( ( rule__AdditiveExpressionPart__Group__0 ) ) ;
    public final void ruleAdditiveExpressionPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:611:2: ( ( ( rule__AdditiveExpressionPart__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:612:1: ( ( rule__AdditiveExpressionPart__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:612:1: ( ( rule__AdditiveExpressionPart__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:613:1: ( rule__AdditiveExpressionPart__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionPartAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:614:1: ( rule__AdditiveExpressionPart__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:614:2: rule__AdditiveExpressionPart__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpressionPart__Group__0_in_ruleAdditiveExpressionPart1240);
            rule__AdditiveExpressionPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpressionPart"


    // $ANTLR start "entryRuleAdditiveOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:626:1: entryRuleAdditiveOperator : ruleAdditiveOperator EOF ;
    public final void entryRuleAdditiveOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:627:1: ( ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:628:1: ruleAdditiveOperator EOF
            {
             before(grammarAccess.getAdditiveOperatorRule()); 
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator1267);
            ruleAdditiveOperator();

            state._fsp--;

             after(grammarAccess.getAdditiveOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator1274); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:635:1: ruleAdditiveOperator : ( ( rule__AdditiveOperator__Alternatives ) ) ;
    public final void ruleAdditiveOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:639:2: ( ( ( rule__AdditiveOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:640:1: ( ( rule__AdditiveOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:640:1: ( ( rule__AdditiveOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:641:1: ( rule__AdditiveOperator__Alternatives )
            {
             before(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:642:1: ( rule__AdditiveOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:642:2: rule__AdditiveOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1300);
            rule__AdditiveOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:654:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:655:1: ( ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:656:1: ruleMultiplicativeExpression EOF
            {
             before(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1327);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1334); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:663:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:667:2: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:668:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:668:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:669:1: ( rule__MultiplicativeExpression__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:670:1: ( rule__MultiplicativeExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:670:2: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression1360);
            rule__MultiplicativeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:682:1: entryRuleMultiplicativeExpressionPart : ruleMultiplicativeExpressionPart EOF ;
    public final void entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:683:1: ( ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:684:1: ruleMultiplicativeExpressionPart EOF
            {
             before(grammarAccess.getMultiplicativeExpressionPartRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart1387);
            ruleMultiplicativeExpressionPart();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart1394); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeExpressionPart"


    // $ANTLR start "ruleMultiplicativeExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:691:1: ruleMultiplicativeExpressionPart : ( ( rule__MultiplicativeExpressionPart__Group__0 ) ) ;
    public final void ruleMultiplicativeExpressionPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:695:2: ( ( ( rule__MultiplicativeExpressionPart__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:696:1: ( ( rule__MultiplicativeExpressionPart__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:696:1: ( ( rule__MultiplicativeExpressionPart__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:697:1: ( rule__MultiplicativeExpressionPart__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionPartAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:698:1: ( rule__MultiplicativeExpressionPart__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:698:2: rule__MultiplicativeExpressionPart__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__Group__0_in_ruleMultiplicativeExpressionPart1420);
            rule__MultiplicativeExpressionPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpressionPart"


    // $ANTLR start "entryRuleMultiplicativeOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:710:1: entryRuleMultiplicativeOperator : ruleMultiplicativeOperator EOF ;
    public final void entryRuleMultiplicativeOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:711:1: ( ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:712:1: ruleMultiplicativeOperator EOF
            {
             before(grammarAccess.getMultiplicativeOperatorRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator1447);
            ruleMultiplicativeOperator();

            state._fsp--;

             after(grammarAccess.getMultiplicativeOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator1454); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:719:1: ruleMultiplicativeOperator : ( ( rule__MultiplicativeOperator__Alternatives ) ) ;
    public final void ruleMultiplicativeOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:723:2: ( ( ( rule__MultiplicativeOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:724:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:724:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:725:1: ( rule__MultiplicativeOperator__Alternatives )
            {
             before(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:726:1: ( rule__MultiplicativeOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:726:2: rule__MultiplicativeOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1480);
            rule__MultiplicativeOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:738:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:739:1: ( ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:740:1: ruleUnaryExpression EOF
            {
             before(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1507);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1514); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:747:1: ruleUnaryExpression : ( ( rule__UnaryExpression__Group__0 ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:751:2: ( ( ( rule__UnaryExpression__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:752:1: ( ( rule__UnaryExpression__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:752:1: ( ( rule__UnaryExpression__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:753:1: ( rule__UnaryExpression__Group__0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:754:1: ( rule__UnaryExpression__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:754:2: rule__UnaryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group__0_in_ruleUnaryExpression1540);
            rule__UnaryExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:766:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:767:1: ( ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:768:1: ruleUnaryOperator EOF
            {
             before(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator1567);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator1574); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:775:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:779:2: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:780:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:780:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:781:1: ( rule__UnaryOperator__Alternatives )
            {
             before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:782:1: ( rule__UnaryOperator__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:782:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1600);
            rule__UnaryOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePostfixExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:794:1: entryRulePostfixExpression : rulePostfixExpression EOF ;
    public final void entryRulePostfixExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:795:1: ( rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:796:1: rulePostfixExpression EOF
            {
             before(grammarAccess.getPostfixExpressionRule()); 
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression1627);
            rulePostfixExpression();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression1634); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:803:1: rulePostfixExpression : ( ( rule__PostfixExpression__LeftAssignment ) ) ;
    public final void rulePostfixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:807:2: ( ( ( rule__PostfixExpression__LeftAssignment ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:808:1: ( ( rule__PostfixExpression__LeftAssignment ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:808:1: ( ( rule__PostfixExpression__LeftAssignment ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:809:1: ( rule__PostfixExpression__LeftAssignment )
            {
             before(grammarAccess.getPostfixExpressionAccess().getLeftAssignment()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:810:1: ( rule__PostfixExpression__LeftAssignment )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:810:2: rule__PostfixExpression__LeftAssignment
            {
            pushFollow(FOLLOW_rule__PostfixExpression__LeftAssignment_in_rulePostfixExpression1660);
            rule__PostfixExpression__LeftAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPostfixExpressionAccess().getLeftAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:822:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:823:1: ( rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:824:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1687);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1694); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:831:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:835:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:836:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:836:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:837:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:838:1: ( rule__PrimaryExpression__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:838:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression1720);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleExpressionOrQualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:850:1: entryRuleExpressionOrQualifiedExecution : ruleExpressionOrQualifiedExecution EOF ;
    public final void entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:851:1: ( ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:852:1: ruleExpressionOrQualifiedExecution EOF
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution1747);
            ruleExpressionOrQualifiedExecution();

            state._fsp--;

             after(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution1754); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionOrQualifiedExecution"


    // $ANTLR start "ruleExpressionOrQualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:859:1: ruleExpressionOrQualifiedExecution : ( ( rule__ExpressionOrQualifiedExecution__Group__0 ) ) ;
    public final void ruleExpressionOrQualifiedExecution() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:863:2: ( ( ( rule__ExpressionOrQualifiedExecution__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:864:1: ( ( rule__ExpressionOrQualifiedExecution__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:864:1: ( ( rule__ExpressionOrQualifiedExecution__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:865:1: ( rule__ExpressionOrQualifiedExecution__Group__0 )
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:866:1: ( rule__ExpressionOrQualifiedExecution__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:866:2: rule__ExpressionOrQualifiedExecution__Group__0
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group__0_in_ruleExpressionOrQualifiedExecution1780);
            rule__ExpressionOrQualifiedExecution__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:878:1: entryRuleUnqualifiedExecution : ruleUnqualifiedExecution EOF ;
    public final void entryRuleUnqualifiedExecution() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:879:1: ( ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:880:1: ruleUnqualifiedExecution EOF
            {
             before(grammarAccess.getUnqualifiedExecutionRule()); 
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution1807);
            ruleUnqualifiedExecution();

            state._fsp--;

             after(grammarAccess.getUnqualifiedExecutionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution1814); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnqualifiedExecution"


    // $ANTLR start "ruleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:887:1: ruleUnqualifiedExecution : ( ( rule__UnqualifiedExecution__Group__0 ) ) ;
    public final void ruleUnqualifiedExecution() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:891:2: ( ( ( rule__UnqualifiedExecution__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:892:1: ( ( rule__UnqualifiedExecution__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:892:1: ( ( rule__UnqualifiedExecution__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:893:1: ( rule__UnqualifiedExecution__Group__0 )
            {
             before(grammarAccess.getUnqualifiedExecutionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:894:1: ( rule__UnqualifiedExecution__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:894:2: rule__UnqualifiedExecution__Group__0
            {
            pushFollow(FOLLOW_rule__UnqualifiedExecution__Group__0_in_ruleUnqualifiedExecution1840);
            rule__UnqualifiedExecution__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnqualifiedExecutionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:906:1: entryRuleSuperExecution : ruleSuperExecution EOF ;
    public final void entryRuleSuperExecution() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:907:1: ( ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:908:1: ruleSuperExecution EOF
            {
             before(grammarAccess.getSuperExecutionRule()); 
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution1867);
            ruleSuperExecution();

            state._fsp--;

             after(grammarAccess.getSuperExecutionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution1874); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuperExecution"


    // $ANTLR start "ruleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:915:1: ruleSuperExecution : ( ( rule__SuperExecution__Group__0 ) ) ;
    public final void ruleSuperExecution() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:919:2: ( ( ( rule__SuperExecution__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:920:1: ( ( rule__SuperExecution__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:920:1: ( ( rule__SuperExecution__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:921:1: ( rule__SuperExecution__Group__0 )
            {
             before(grammarAccess.getSuperExecutionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:922:1: ( rule__SuperExecution__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:922:2: rule__SuperExecution__Group__0
            {
            pushFollow(FOLLOW_rule__SuperExecution__Group__0_in_ruleSuperExecution1900);
            rule__SuperExecution__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSuperExecutionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:934:1: entryRuleConstructorExecution : ruleConstructorExecution EOF ;
    public final void entryRuleConstructorExecution() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:935:1: ( ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:936:1: ruleConstructorExecution EOF
            {
             before(grammarAccess.getConstructorExecutionRule()); 
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution1927);
            ruleConstructorExecution();

            state._fsp--;

             after(grammarAccess.getConstructorExecutionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution1934); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstructorExecution"


    // $ANTLR start "ruleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:943:1: ruleConstructorExecution : ( ( rule__ConstructorExecution__Group__0 ) ) ;
    public final void ruleConstructorExecution() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:947:2: ( ( ( rule__ConstructorExecution__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:948:1: ( ( rule__ConstructorExecution__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:948:1: ( ( rule__ConstructorExecution__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:949:1: ( rule__ConstructorExecution__Group__0 )
            {
             before(grammarAccess.getConstructorExecutionAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:950:1: ( rule__ConstructorExecution__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:950:2: rule__ConstructorExecution__Group__0
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__0_in_ruleConstructorExecution1960);
            rule__ConstructorExecution__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstructorExecutionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:962:1: entryRuleSubCall : ruleSubCall EOF ;
    public final void entryRuleSubCall() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:963:1: ( ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:964:1: ruleSubCall EOF
            {
             before(grammarAccess.getSubCallRule()); 
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall1987);
            ruleSubCall();

            state._fsp--;

             after(grammarAccess.getSubCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall1994); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubCall"


    // $ANTLR start "ruleSubCall"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:971:1: ruleSubCall : ( ( rule__SubCall__Alternatives ) ) ;
    public final void ruleSubCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:975:2: ( ( ( rule__SubCall__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:976:1: ( ( rule__SubCall__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:976:1: ( ( rule__SubCall__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:977:1: ( rule__SubCall__Alternatives )
            {
             before(grammarAccess.getSubCallAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:978:1: ( rule__SubCall__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:978:2: rule__SubCall__Alternatives
            {
            pushFollow(FOLLOW_rule__SubCall__Alternatives_in_ruleSubCall2020);
            rule__SubCall__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSubCallAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubCall"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:990:1: entryRuleCall : ruleCall EOF ;
    public final void entryRuleCall() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:991:1: ( ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:992:1: ruleCall EOF
            {
             before(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall2047);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall2054); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:999:1: ruleCall : ( ( rule__Call__Group__0 ) ) ;
    public final void ruleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1003:2: ( ( ( rule__Call__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1004:1: ( ( rule__Call__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1004:1: ( ( rule__Call__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1005:1: ( rule__Call__Group__0 )
            {
             before(grammarAccess.getCallAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1006:1: ( rule__Call__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1006:2: rule__Call__Group__0
            {
            pushFollow(FOLLOW_rule__Call__Group__0_in_ruleCall2080);
            rule__Call__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleArgumentList"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1018:1: entryRuleArgumentList : ruleArgumentList EOF ;
    public final void entryRuleArgumentList() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1019:1: ( ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1020:1: ruleArgumentList EOF
            {
             before(grammarAccess.getArgumentListRule()); 
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList2107);
            ruleArgumentList();

            state._fsp--;

             after(grammarAccess.getArgumentListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList2114); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArgumentList"


    // $ANTLR start "ruleArgumentList"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1027:1: ruleArgumentList : ( ( rule__ArgumentList__Group__0 ) ) ;
    public final void ruleArgumentList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1031:2: ( ( ( rule__ArgumentList__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1032:1: ( ( rule__ArgumentList__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1032:1: ( ( rule__ArgumentList__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1033:1: ( rule__ArgumentList__Group__0 )
            {
             before(grammarAccess.getArgumentListAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1034:1: ( rule__ArgumentList__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1034:2: rule__ArgumentList__Group__0
            {
            pushFollow(FOLLOW_rule__ArgumentList__Group__0_in_ruleArgumentList2140);
            rule__ArgumentList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArgumentListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1046:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1047:1: ( ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1048:1: ruleNamedArgument EOF
            {
             before(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument2167);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getNamedArgumentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument2174); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1055:1: ruleNamedArgument : ( ( rule__NamedArgument__Group__0 ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1059:2: ( ( ( rule__NamedArgument__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1060:1: ( ( rule__NamedArgument__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1060:1: ( ( rule__NamedArgument__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1061:1: ( rule__NamedArgument__Group__0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1062:1: ( rule__NamedArgument__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1062:2: rule__NamedArgument__Group__0
            {
            pushFollow(FOLLOW_rule__NamedArgument__Group__0_in_ruleNamedArgument2200);
            rule__NamedArgument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleQualifiedPrefix"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1074:1: entryRuleQualifiedPrefix : ruleQualifiedPrefix EOF ;
    public final void entryRuleQualifiedPrefix() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1075:1: ( ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1076:1: ruleQualifiedPrefix EOF
            {
             before(grammarAccess.getQualifiedPrefixRule()); 
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix2227);
            ruleQualifiedPrefix();

            state._fsp--;

             after(grammarAccess.getQualifiedPrefixRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix2234); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedPrefix"


    // $ANTLR start "ruleQualifiedPrefix"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1083:1: ruleQualifiedPrefix : ( ( rule__QualifiedPrefix__Group__0 ) ) ;
    public final void ruleQualifiedPrefix() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1087:2: ( ( ( rule__QualifiedPrefix__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1088:1: ( ( rule__QualifiedPrefix__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1088:1: ( ( rule__QualifiedPrefix__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1089:1: ( rule__QualifiedPrefix__Group__0 )
            {
             before(grammarAccess.getQualifiedPrefixAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1090:1: ( rule__QualifiedPrefix__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1090:2: rule__QualifiedPrefix__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__Group__0_in_ruleQualifiedPrefix2260);
            rule__QualifiedPrefix__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedPrefixAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1102:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1103:1: ( ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1104:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2287);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2294); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1111:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1115:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1116:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1116:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1117:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1118:1: ( rule__QualifiedName__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1118:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2320);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1130:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1131:1: ( ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1132:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant2347);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant2354); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1139:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1143:2: ( ( ( rule__Constant__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1144:1: ( ( rule__Constant__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1144:1: ( ( rule__Constant__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1145:1: ( rule__Constant__Alternatives )
            {
             before(grammarAccess.getConstantAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1146:1: ( rule__Constant__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1146:2: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_in_ruleConstant2380);
            rule__Constant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleNumValue"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1158:1: entryRuleNumValue : ruleNumValue EOF ;
    public final void entryRuleNumValue() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1159:1: ( ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1160:1: ruleNumValue EOF
            {
             before(grammarAccess.getNumValueRule()); 
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue2407);
            ruleNumValue();

            state._fsp--;

             after(grammarAccess.getNumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue2414); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumValue"


    // $ANTLR start "ruleNumValue"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1167:1: ruleNumValue : ( ( rule__NumValue__ValAssignment ) ) ;
    public final void ruleNumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1171:2: ( ( ( rule__NumValue__ValAssignment ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1172:1: ( ( rule__NumValue__ValAssignment ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1172:1: ( ( rule__NumValue__ValAssignment ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1173:1: ( rule__NumValue__ValAssignment )
            {
             before(grammarAccess.getNumValueAccess().getValAssignment()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1174:1: ( rule__NumValue__ValAssignment )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1174:2: rule__NumValue__ValAssignment
            {
            pushFollow(FOLLOW_rule__NumValue__ValAssignment_in_ruleNumValue2440);
            rule__NumValue__ValAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNumValueAccess().getValAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumValue"


    // $ANTLR start "entryRuleIdentifier"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1186:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1187:1: ( ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1188:1: ruleIdentifier EOF
            {
             before(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier2467);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getIdentifierRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier2474); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1195:1: ruleIdentifier : ( ( rule__Identifier__Alternatives ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1199:2: ( ( ( rule__Identifier__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1200:1: ( ( rule__Identifier__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1200:1: ( ( rule__Identifier__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1201:1: ( rule__Identifier__Alternatives )
            {
             before(grammarAccess.getIdentifierAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1202:1: ( rule__Identifier__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1202:2: rule__Identifier__Alternatives
            {
            pushFollow(FOLLOW_rule__Identifier__Alternatives_in_ruleIdentifier2500);
            rule__Identifier__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleType"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1214:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1215:1: ( ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1216:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType2527);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType2534); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1223:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1227:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1228:1: ( ( rule__Type__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1228:1: ( ( rule__Type__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1229:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1230:1: ( rule__Type__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1230:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType2560);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeParameters"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1242:1: entryRuleTypeParameters : ruleTypeParameters EOF ;
    public final void entryRuleTypeParameters() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1243:1: ( ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1244:1: ruleTypeParameters EOF
            {
             before(grammarAccess.getTypeParametersRule()); 
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters2587);
            ruleTypeParameters();

            state._fsp--;

             after(grammarAccess.getTypeParametersRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters2594); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeParameters"


    // $ANTLR start "ruleTypeParameters"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1251:1: ruleTypeParameters : ( ( rule__TypeParameters__Group__0 ) ) ;
    public final void ruleTypeParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1255:2: ( ( ( rule__TypeParameters__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1256:1: ( ( rule__TypeParameters__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1256:1: ( ( rule__TypeParameters__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1257:1: ( rule__TypeParameters__Group__0 )
            {
             before(grammarAccess.getTypeParametersAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1258:1: ( rule__TypeParameters__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1258:2: rule__TypeParameters__Group__0
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group__0_in_ruleTypeParameters2620);
            rule__TypeParameters__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeParametersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeParameters"


    // $ANTLR start "entryRuleContainerInitializer"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1270:1: entryRuleContainerInitializer : ruleContainerInitializer EOF ;
    public final void entryRuleContainerInitializer() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1271:1: ( ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1272:1: ruleContainerInitializer EOF
            {
             before(grammarAccess.getContainerInitializerRule()); 
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer2647);
            ruleContainerInitializer();

            state._fsp--;

             after(grammarAccess.getContainerInitializerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer2654); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContainerInitializer"


    // $ANTLR start "ruleContainerInitializer"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1279:1: ruleContainerInitializer : ( ( rule__ContainerInitializer__Group__0 ) ) ;
    public final void ruleContainerInitializer() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1283:2: ( ( ( rule__ContainerInitializer__Group__0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1284:1: ( ( rule__ContainerInitializer__Group__0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1284:1: ( ( rule__ContainerInitializer__Group__0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1285:1: ( rule__ContainerInitializer__Group__0 )
            {
             before(grammarAccess.getContainerInitializerAccess().getGroup()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1286:1: ( rule__ContainerInitializer__Group__0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1286:2: rule__ContainerInitializer__Group__0
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group__0_in_ruleContainerInitializer2680);
            rule__ContainerInitializer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContainerInitializerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContainerInitializer"


    // $ANTLR start "entryRuleContainerInitializerExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1298:1: entryRuleContainerInitializerExpression : ruleContainerInitializerExpression EOF ;
    public final void entryRuleContainerInitializerExpression() throws RecognitionException {
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1299:1: ( ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1300:1: ruleContainerInitializerExpression EOF
            {
             before(grammarAccess.getContainerInitializerExpressionRule()); 
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression2707);
            ruleContainerInitializerExpression();

            state._fsp--;

             after(grammarAccess.getContainerInitializerExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression2714); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContainerInitializerExpression"


    // $ANTLR start "ruleContainerInitializerExpression"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1307:1: ruleContainerInitializerExpression : ( ( rule__ContainerInitializerExpression__Alternatives ) ) ;
    public final void ruleContainerInitializerExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1311:2: ( ( ( rule__ContainerInitializerExpression__Alternatives ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1312:1: ( ( rule__ContainerInitializerExpression__Alternatives ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1312:1: ( ( rule__ContainerInitializerExpression__Alternatives ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1313:1: ( rule__ContainerInitializerExpression__Alternatives )
            {
             before(grammarAccess.getContainerInitializerExpressionAccess().getAlternatives()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1314:1: ( rule__ContainerInitializerExpression__Alternatives )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1314:2: rule__ContainerInitializerExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ContainerInitializerExpression__Alternatives_in_ruleContainerInitializerExpression2740);
            rule__ContainerInitializerExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContainerInitializerExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContainerInitializerExpression"


    // $ANTLR start "rule__VersionOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1326:1: rule__VersionOperator__Alternatives : ( ( '==' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) );
    public final void rule__VersionOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1330:1: ( ( '==' ) | ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1331:1: ( '==' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1331:1: ( '==' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1332:1: '=='
                    {
                     before(grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                    match(input,13,FOLLOW_13_in_rule__VersionOperator__Alternatives2777); 
                     after(grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1339:6: ( '>' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1339:6: ( '>' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1340:1: '>'
                    {
                     before(grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                    match(input,14,FOLLOW_14_in_rule__VersionOperator__Alternatives2797); 
                     after(grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1347:6: ( '<' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1347:6: ( '<' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1348:1: '<'
                    {
                     before(grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                    match(input,15,FOLLOW_15_in_rule__VersionOperator__Alternatives2817); 
                     after(grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1355:6: ( '>=' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1355:6: ( '>=' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1356:1: '>='
                    {
                     before(grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                    match(input,16,FOLLOW_16_in_rule__VersionOperator__Alternatives2837); 
                     after(grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1363:6: ( '<=' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1363:6: ( '<=' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1364:1: '<='
                    {
                     before(grammarAccess.getVersionOperatorAccess().getLessThanSignEqualsSignKeyword_4()); 
                    match(input,17,FOLLOW_17_in_rule__VersionOperator__Alternatives2857); 
                     after(grammarAccess.getVersionOperatorAccess().getLessThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionOperator__Alternatives"


    // $ANTLR start "rule__Expression__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1376:1: rule__Expression__Alternatives : ( ( ( rule__Expression__ExprAssignment_0 ) ) | ( ( rule__Expression__InitAssignment_1 ) ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1380:1: ( ( ( rule__Expression__ExprAssignment_0 ) ) | ( ( rule__Expression__InitAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_NUMBER)||LA2_0==24||(LA2_0>=27 && LA2_0<=30)||LA2_0==32||LA2_0==39||LA2_0==41) ) {
                alt2=1;
            }
            else if ( (LA2_0==45) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1381:1: ( ( rule__Expression__ExprAssignment_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1381:1: ( ( rule__Expression__ExprAssignment_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1382:1: ( rule__Expression__ExprAssignment_0 )
                    {
                     before(grammarAccess.getExpressionAccess().getExprAssignment_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1383:1: ( rule__Expression__ExprAssignment_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1383:2: rule__Expression__ExprAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Expression__ExprAssignment_0_in_rule__Expression__Alternatives2891);
                    rule__Expression__ExprAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getExprAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1387:6: ( ( rule__Expression__InitAssignment_1 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1387:6: ( ( rule__Expression__InitAssignment_1 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1388:1: ( rule__Expression__InitAssignment_1 )
                    {
                     before(grammarAccess.getExpressionAccess().getInitAssignment_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1389:1: ( rule__Expression__InitAssignment_1 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1389:2: rule__Expression__InitAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Expression__InitAssignment_1_in_rule__Expression__Alternatives2909);
                    rule__Expression__InitAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getInitAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__LogicalOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1398:1: rule__LogicalOperator__Alternatives : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );
    public final void rule__LogicalOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1402:1: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 20:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1403:1: ( 'and' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1403:1: ( 'and' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1404:1: 'and'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__LogicalOperator__Alternatives2943); 
                     after(grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1411:6: ( 'or' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1411:6: ( 'or' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1412:1: 'or'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__LogicalOperator__Alternatives2963); 
                     after(grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1419:6: ( 'xor' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1419:6: ( 'xor' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1420:1: 'xor'
                    {
                     before(grammarAccess.getLogicalOperatorAccess().getXorKeyword_2()); 
                    match(input,20,FOLLOW_20_in_rule__LogicalOperator__Alternatives2983); 
                     after(grammarAccess.getLogicalOperatorAccess().getXorKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalOperator__Alternatives"


    // $ANTLR start "rule__EqualityOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1432:1: rule__EqualityOperator__Alternatives : ( ( '==' ) | ( '<>' ) | ( '!=' ) );
    public final void rule__EqualityOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1436:1: ( ( '==' ) | ( '<>' ) | ( '!=' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case 22:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1437:1: ( '==' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1437:1: ( '==' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1438:1: '=='
                    {
                     before(grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                    match(input,13,FOLLOW_13_in_rule__EqualityOperator__Alternatives3018); 
                     after(grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1445:6: ( '<>' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1445:6: ( '<>' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1446:1: '<>'
                    {
                     before(grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__EqualityOperator__Alternatives3038); 
                     after(grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1453:6: ( '!=' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1453:6: ( '!=' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1454:1: '!='
                    {
                     before(grammarAccess.getEqualityOperatorAccess().getExclamationMarkEqualsSignKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__EqualityOperator__Alternatives3058); 
                     after(grammarAccess.getEqualityOperatorAccess().getExclamationMarkEqualsSignKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityOperator__Alternatives"


    // $ANTLR start "rule__RelationalOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1466:1: rule__RelationalOperator__Alternatives : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) );
    public final void rule__RelationalOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1470:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt5=1;
                }
                break;
            case 15:
                {
                alt5=2;
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            case 17:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1471:1: ( '>' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1471:1: ( '>' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1472:1: '>'
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                    match(input,14,FOLLOW_14_in_rule__RelationalOperator__Alternatives3093); 
                     after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1479:6: ( '<' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1479:6: ( '<' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1480:1: '<'
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                    match(input,15,FOLLOW_15_in_rule__RelationalOperator__Alternatives3113); 
                     after(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1487:6: ( '>=' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1487:6: ( '>=' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1488:1: '>='
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                    match(input,16,FOLLOW_16_in_rule__RelationalOperator__Alternatives3133); 
                     after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1495:6: ( '<=' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1495:6: ( '<=' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1496:1: '<='
                    {
                     before(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_3()); 
                    match(input,17,FOLLOW_17_in_rule__RelationalOperator__Alternatives3153); 
                     after(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalOperator__Alternatives"


    // $ANTLR start "rule__AdditiveOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1508:1: rule__AdditiveOperator__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__AdditiveOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1512:1: ( ( '+' ) | ( '-' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            else if ( (LA6_0==24) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1513:1: ( '+' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1513:1: ( '+' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1514:1: '+'
                    {
                     before(grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                    match(input,23,FOLLOW_23_in_rule__AdditiveOperator__Alternatives3188); 
                     after(grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1521:6: ( '-' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1521:6: ( '-' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1522:1: '-'
                    {
                     before(grammarAccess.getAdditiveOperatorAccess().getHyphenMinusKeyword_1()); 
                    match(input,24,FOLLOW_24_in_rule__AdditiveOperator__Alternatives3208); 
                     after(grammarAccess.getAdditiveOperatorAccess().getHyphenMinusKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveOperator__Alternatives"


    // $ANTLR start "rule__MultiplicativeOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1534:1: rule__MultiplicativeOperator__Alternatives : ( ( '*' ) | ( '/' ) );
    public final void rule__MultiplicativeOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1538:1: ( ( '*' ) | ( '/' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1539:1: ( '*' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1539:1: ( '*' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1540:1: '*'
                    {
                     before(grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                    match(input,25,FOLLOW_25_in_rule__MultiplicativeOperator__Alternatives3243); 
                     after(grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1547:6: ( '/' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1547:6: ( '/' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1548:1: '/'
                    {
                     before(grammarAccess.getMultiplicativeOperatorAccess().getSolidusKeyword_1()); 
                    match(input,26,FOLLOW_26_in_rule__MultiplicativeOperator__Alternatives3263); 
                     after(grammarAccess.getMultiplicativeOperatorAccess().getSolidusKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeOperator__Alternatives"


    // $ANTLR start "rule__UnaryOperator__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1560:1: rule__UnaryOperator__Alternatives : ( ( 'not' ) | ( '!' ) | ( '-' ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1564:1: ( ( 'not' ) | ( '!' ) | ( '-' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt8=1;
                }
                break;
            case 28:
                {
                alt8=2;
                }
                break;
            case 24:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1565:1: ( 'not' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1565:1: ( 'not' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1566:1: 'not'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                    match(input,27,FOLLOW_27_in_rule__UnaryOperator__Alternatives3298); 
                     after(grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1573:6: ( '!' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1573:6: ( '!' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1574:1: '!'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                    match(input,28,FOLLOW_28_in_rule__UnaryOperator__Alternatives3318); 
                     after(grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1581:6: ( '-' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1581:6: ( '-' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1582:1: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_2()); 
                    match(input,24,FOLLOW_24_in_rule__UnaryOperator__Alternatives3338); 
                     after(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1594:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__OtherExAssignment_0 ) ) | ( ( rule__PrimaryExpression__UnqExAssignment_1 ) ) | ( ( rule__PrimaryExpression__SuperExAssignment_2 ) ) | ( ( rule__PrimaryExpression__NewExAssignment_3 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1598:1: ( ( ( rule__PrimaryExpression__OtherExAssignment_0 ) ) | ( ( rule__PrimaryExpression__UnqExAssignment_1 ) ) | ( ( rule__PrimaryExpression__SuperExAssignment_2 ) ) | ( ( rule__PrimaryExpression__NewExAssignment_3 ) ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1599:1: ( ( rule__PrimaryExpression__OtherExAssignment_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1599:1: ( ( rule__PrimaryExpression__OtherExAssignment_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1600:1: ( rule__PrimaryExpression__OtherExAssignment_0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getOtherExAssignment_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1601:1: ( rule__PrimaryExpression__OtherExAssignment_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1601:2: rule__PrimaryExpression__OtherExAssignment_0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__OtherExAssignment_0_in_rule__PrimaryExpression__Alternatives3372);
                    rule__PrimaryExpression__OtherExAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getOtherExAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1605:6: ( ( rule__PrimaryExpression__UnqExAssignment_1 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1605:6: ( ( rule__PrimaryExpression__UnqExAssignment_1 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1606:1: ( rule__PrimaryExpression__UnqExAssignment_1 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getUnqExAssignment_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1607:1: ( rule__PrimaryExpression__UnqExAssignment_1 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1607:2: rule__PrimaryExpression__UnqExAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__UnqExAssignment_1_in_rule__PrimaryExpression__Alternatives3390);
                    rule__PrimaryExpression__UnqExAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getUnqExAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1611:6: ( ( rule__PrimaryExpression__SuperExAssignment_2 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1611:6: ( ( rule__PrimaryExpression__SuperExAssignment_2 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1612:1: ( rule__PrimaryExpression__SuperExAssignment_2 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getSuperExAssignment_2()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1613:1: ( rule__PrimaryExpression__SuperExAssignment_2 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1613:2: rule__PrimaryExpression__SuperExAssignment_2
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__SuperExAssignment_2_in_rule__PrimaryExpression__Alternatives3408);
                    rule__PrimaryExpression__SuperExAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getSuperExAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1617:6: ( ( rule__PrimaryExpression__NewExAssignment_3 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1617:6: ( ( rule__PrimaryExpression__NewExAssignment_3 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1618:1: ( rule__PrimaryExpression__NewExAssignment_3 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getNewExAssignment_3()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1619:1: ( rule__PrimaryExpression__NewExAssignment_3 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1619:2: rule__PrimaryExpression__NewExAssignment_3
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__NewExAssignment_3_in_rule__PrimaryExpression__Alternatives3426);
                    rule__PrimaryExpression__NewExAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getNewExAssignment_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Alternatives_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1628:1: rule__ExpressionOrQualifiedExecution__Alternatives_0 : ( ( ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 ) ) | ( ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 ) ) );
    public final void rule__ExpressionOrQualifiedExecution__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1632:1: ( ( ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 ) ) | ( ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_NUMBER)||(LA10_0>=29 && LA10_0<=30)) ) {
                alt10=1;
            }
            else if ( (LA10_0==32) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1633:1: ( ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1633:1: ( ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1634:1: ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 )
                    {
                     before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValAssignment_0_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1635:1: ( rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1635:2: rule__ExpressionOrQualifiedExecution__ValAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__ValAssignment_0_0_in_rule__ExpressionOrQualifiedExecution__Alternatives_03459);
                    rule__ExpressionOrQualifiedExecution__ValAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1639:6: ( ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1639:6: ( ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1640:1: ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 )
                    {
                     before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup_0_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1641:1: ( rule__ExpressionOrQualifiedExecution__Group_0_1__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1641:2: rule__ExpressionOrQualifiedExecution__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__0_in_rule__ExpressionOrQualifiedExecution__Alternatives_03477);
                    rule__ExpressionOrQualifiedExecution__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Alternatives_0"


    // $ANTLR start "rule__SubCall__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1650:1: rule__SubCall__Alternatives : ( ( ( rule__SubCall__Group_0__0 ) ) | ( ( rule__SubCall__Group_1__0 ) ) );
    public final void rule__SubCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1654:1: ( ( ( rule__SubCall__Group_0__0 ) ) | ( ( rule__SubCall__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==40) ) {
                alt11=1;
            }
            else if ( (LA11_0==42) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1655:1: ( ( rule__SubCall__Group_0__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1655:1: ( ( rule__SubCall__Group_0__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1656:1: ( rule__SubCall__Group_0__0 )
                    {
                     before(grammarAccess.getSubCallAccess().getGroup_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1657:1: ( rule__SubCall__Group_0__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1657:2: rule__SubCall__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__SubCall__Group_0__0_in_rule__SubCall__Alternatives3510);
                    rule__SubCall__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubCallAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1661:6: ( ( rule__SubCall__Group_1__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1661:6: ( ( rule__SubCall__Group_1__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1662:1: ( rule__SubCall__Group_1__0 )
                    {
                     before(grammarAccess.getSubCallAccess().getGroup_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1663:1: ( rule__SubCall__Group_1__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1663:2: rule__SubCall__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SubCall__Group_1__0_in_rule__SubCall__Alternatives3528);
                    rule__SubCall__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSubCallAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1672:1: rule__Constant__Alternatives : ( ( ( rule__Constant__NValueAssignment_0 ) ) | ( ( rule__Constant__SValueAssignment_1 ) ) | ( ( rule__Constant__QValueAssignment_2 ) ) | ( ( rule__Constant__BValueAssignment_3 ) ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1676:1: ( ( ( rule__Constant__NValueAssignment_0 ) ) | ( ( rule__Constant__SValueAssignment_1 ) ) | ( ( rule__Constant__QValueAssignment_2 ) ) | ( ( rule__Constant__BValueAssignment_3 ) ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt12=1;
                }
                break;
            case RULE_STRING:
                {
                alt12=2;
                }
                break;
            case RULE_ID:
            case RULE_VERSION:
            case RULE_EXPONENT:
                {
                alt12=3;
                }
                break;
            case 29:
            case 30:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1677:1: ( ( rule__Constant__NValueAssignment_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1677:1: ( ( rule__Constant__NValueAssignment_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1678:1: ( rule__Constant__NValueAssignment_0 )
                    {
                     before(grammarAccess.getConstantAccess().getNValueAssignment_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1679:1: ( rule__Constant__NValueAssignment_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1679:2: rule__Constant__NValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Constant__NValueAssignment_0_in_rule__Constant__Alternatives3561);
                    rule__Constant__NValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getNValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1683:6: ( ( rule__Constant__SValueAssignment_1 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1683:6: ( ( rule__Constant__SValueAssignment_1 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1684:1: ( rule__Constant__SValueAssignment_1 )
                    {
                     before(grammarAccess.getConstantAccess().getSValueAssignment_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1685:1: ( rule__Constant__SValueAssignment_1 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1685:2: rule__Constant__SValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Constant__SValueAssignment_1_in_rule__Constant__Alternatives3579);
                    rule__Constant__SValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getSValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1689:6: ( ( rule__Constant__QValueAssignment_2 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1689:6: ( ( rule__Constant__QValueAssignment_2 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1690:1: ( rule__Constant__QValueAssignment_2 )
                    {
                     before(grammarAccess.getConstantAccess().getQValueAssignment_2()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1691:1: ( rule__Constant__QValueAssignment_2 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1691:2: rule__Constant__QValueAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Constant__QValueAssignment_2_in_rule__Constant__Alternatives3597);
                    rule__Constant__QValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getQValueAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1695:6: ( ( rule__Constant__BValueAssignment_3 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1695:6: ( ( rule__Constant__BValueAssignment_3 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1696:1: ( rule__Constant__BValueAssignment_3 )
                    {
                     before(grammarAccess.getConstantAccess().getBValueAssignment_3()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1697:1: ( rule__Constant__BValueAssignment_3 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1697:2: rule__Constant__BValueAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Constant__BValueAssignment_3_in_rule__Constant__Alternatives3615);
                    rule__Constant__BValueAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getConstantAccess().getBValueAssignment_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Alternatives"


    // $ANTLR start "rule__Constant__BValueAlternatives_3_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1706:1: rule__Constant__BValueAlternatives_3_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Constant__BValueAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1710:1: ( ( 'true' ) | ( 'false' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1711:1: ( 'true' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1711:1: ( 'true' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1712:1: 'true'
                    {
                     before(grammarAccess.getConstantAccess().getBValueTrueKeyword_3_0_0()); 
                    match(input,29,FOLLOW_29_in_rule__Constant__BValueAlternatives_3_03649); 
                     after(grammarAccess.getConstantAccess().getBValueTrueKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1719:6: ( 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1719:6: ( 'false' )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1720:1: 'false'
                    {
                     before(grammarAccess.getConstantAccess().getBValueFalseKeyword_3_0_1()); 
                    match(input,30,FOLLOW_30_in_rule__Constant__BValueAlternatives_3_03669); 
                     after(grammarAccess.getConstantAccess().getBValueFalseKeyword_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__BValueAlternatives_3_0"


    // $ANTLR start "rule__Identifier__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1732:1: rule__Identifier__Alternatives : ( ( RULE_ID ) | ( RULE_VERSION ) | ( RULE_EXPONENT ) );
    public final void rule__Identifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1736:1: ( ( RULE_ID ) | ( RULE_VERSION ) | ( RULE_EXPONENT ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case RULE_VERSION:
                {
                alt14=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1737:1: ( RULE_ID )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1737:1: ( RULE_ID )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1738:1: RULE_ID
                    {
                     before(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Identifier__Alternatives3703); 
                     after(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1743:6: ( RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1743:6: ( RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1744:1: RULE_VERSION
                    {
                     before(grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                    match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_rule__Identifier__Alternatives3720); 
                     after(grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1749:6: ( RULE_EXPONENT )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1749:6: ( RULE_EXPONENT )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1750:1: RULE_EXPONENT
                    {
                     before(grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                    match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_rule__Identifier__Alternatives3737); 
                     after(grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__Alternatives"


    // $ANTLR start "rule__Type__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1760:1: rule__Type__Alternatives : ( ( ( rule__Type__NameAssignment_0 ) ) | ( ( rule__Type__Group_1__0 ) ) | ( ( rule__Type__Group_2__0 ) ) | ( ( rule__Type__Group_3__0 ) ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1764:1: ( ( ( rule__Type__NameAssignment_0 ) ) | ( ( rule__Type__Group_1__0 ) ) | ( ( rule__Type__Group_2__0 ) ) | ( ( rule__Type__Group_3__0 ) ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_VERSION:
            case RULE_EXPONENT:
                {
                alt15=1;
                }
                break;
            case 48:
                {
                alt15=2;
                }
                break;
            case 49:
                {
                alt15=3;
                }
                break;
            case 50:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1765:1: ( ( rule__Type__NameAssignment_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1765:1: ( ( rule__Type__NameAssignment_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1766:1: ( rule__Type__NameAssignment_0 )
                    {
                     before(grammarAccess.getTypeAccess().getNameAssignment_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1767:1: ( rule__Type__NameAssignment_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1767:2: rule__Type__NameAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Type__NameAssignment_0_in_rule__Type__Alternatives3769);
                    rule__Type__NameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1771:6: ( ( rule__Type__Group_1__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1771:6: ( ( rule__Type__Group_1__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1772:1: ( rule__Type__Group_1__0 )
                    {
                     before(grammarAccess.getTypeAccess().getGroup_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1773:1: ( rule__Type__Group_1__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1773:2: rule__Type__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Type__Group_1__0_in_rule__Type__Alternatives3787);
                    rule__Type__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1777:6: ( ( rule__Type__Group_2__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1777:6: ( ( rule__Type__Group_2__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1778:1: ( rule__Type__Group_2__0 )
                    {
                     before(grammarAccess.getTypeAccess().getGroup_2()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1779:1: ( rule__Type__Group_2__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1779:2: rule__Type__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Type__Group_2__0_in_rule__Type__Alternatives3805);
                    rule__Type__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1783:6: ( ( rule__Type__Group_3__0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1783:6: ( ( rule__Type__Group_3__0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1784:1: ( rule__Type__Group_3__0 )
                    {
                     before(grammarAccess.getTypeAccess().getGroup_3()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1785:1: ( rule__Type__Group_3__0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1785:2: rule__Type__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Type__Group_3__0_in_rule__Type__Alternatives3823);
                    rule__Type__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeAccess().getGroup_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__ContainerInitializerExpression__Alternatives"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1794:1: rule__ContainerInitializerExpression__Alternatives : ( ( ( rule__ContainerInitializerExpression__LogicalAssignment_0 ) ) | ( ( rule__ContainerInitializerExpression__ContainerAssignment_1 ) ) );
    public final void rule__ContainerInitializerExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1798:1: ( ( ( rule__ContainerInitializerExpression__LogicalAssignment_0 ) ) | ( ( rule__ContainerInitializerExpression__ContainerAssignment_1 ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_NUMBER)||LA16_0==24||(LA16_0>=27 && LA16_0<=30)||LA16_0==32||LA16_0==39||LA16_0==41) ) {
                alt16=1;
            }
            else if ( (LA16_0==45) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1799:1: ( ( rule__ContainerInitializerExpression__LogicalAssignment_0 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1799:1: ( ( rule__ContainerInitializerExpression__LogicalAssignment_0 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1800:1: ( rule__ContainerInitializerExpression__LogicalAssignment_0 )
                    {
                     before(grammarAccess.getContainerInitializerExpressionAccess().getLogicalAssignment_0()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1801:1: ( rule__ContainerInitializerExpression__LogicalAssignment_0 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1801:2: rule__ContainerInitializerExpression__LogicalAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ContainerInitializerExpression__LogicalAssignment_0_in_rule__ContainerInitializerExpression__Alternatives3856);
                    rule__ContainerInitializerExpression__LogicalAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getContainerInitializerExpressionAccess().getLogicalAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1805:6: ( ( rule__ContainerInitializerExpression__ContainerAssignment_1 ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1805:6: ( ( rule__ContainerInitializerExpression__ContainerAssignment_1 ) )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1806:1: ( rule__ContainerInitializerExpression__ContainerAssignment_1 )
                    {
                     before(grammarAccess.getContainerInitializerExpressionAccess().getContainerAssignment_1()); 
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1807:1: ( rule__ContainerInitializerExpression__ContainerAssignment_1 )
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1807:2: rule__ContainerInitializerExpression__ContainerAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ContainerInitializerExpression__ContainerAssignment_1_in_rule__ContainerInitializerExpression__Alternatives3874);
                    rule__ContainerInitializerExpression__ContainerAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getContainerInitializerExpressionAccess().getContainerAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializerExpression__Alternatives"


    // $ANTLR start "rule__LanguageUnit__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1818:1: rule__LanguageUnit__Group__0 : rule__LanguageUnit__Group__0__Impl rule__LanguageUnit__Group__1 ;
    public final void rule__LanguageUnit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1822:1: ( rule__LanguageUnit__Group__0__Impl rule__LanguageUnit__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1823:2: rule__LanguageUnit__Group__0__Impl rule__LanguageUnit__Group__1
            {
            pushFollow(FOLLOW_rule__LanguageUnit__Group__0__Impl_in_rule__LanguageUnit__Group__03905);
            rule__LanguageUnit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LanguageUnit__Group__1_in_rule__LanguageUnit__Group__03908);
            rule__LanguageUnit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__0"


    // $ANTLR start "rule__LanguageUnit__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1830:1: rule__LanguageUnit__Group__0__Impl : ( ( rule__LanguageUnit__AdvicesAssignment_0 )* ) ;
    public final void rule__LanguageUnit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1834:1: ( ( ( rule__LanguageUnit__AdvicesAssignment_0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1835:1: ( ( rule__LanguageUnit__AdvicesAssignment_0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1835:1: ( ( rule__LanguageUnit__AdvicesAssignment_0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1836:1: ( rule__LanguageUnit__AdvicesAssignment_0 )*
            {
             before(grammarAccess.getLanguageUnitAccess().getAdvicesAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1837:1: ( rule__LanguageUnit__AdvicesAssignment_0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==31) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1837:2: rule__LanguageUnit__AdvicesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__LanguageUnit__AdvicesAssignment_0_in_rule__LanguageUnit__Group__0__Impl3935);
            	    rule__LanguageUnit__AdvicesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getLanguageUnitAccess().getAdvicesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__0__Impl"


    // $ANTLR start "rule__LanguageUnit__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1847:1: rule__LanguageUnit__Group__1 : rule__LanguageUnit__Group__1__Impl rule__LanguageUnit__Group__2 ;
    public final void rule__LanguageUnit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1851:1: ( rule__LanguageUnit__Group__1__Impl rule__LanguageUnit__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1852:2: rule__LanguageUnit__Group__1__Impl rule__LanguageUnit__Group__2
            {
            pushFollow(FOLLOW_rule__LanguageUnit__Group__1__Impl_in_rule__LanguageUnit__Group__13966);
            rule__LanguageUnit__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LanguageUnit__Group__2_in_rule__LanguageUnit__Group__13969);
            rule__LanguageUnit__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__1"


    // $ANTLR start "rule__LanguageUnit__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1859:1: rule__LanguageUnit__Group__1__Impl : ( ( rule__LanguageUnit__NameAssignment_1 ) ) ;
    public final void rule__LanguageUnit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1863:1: ( ( ( rule__LanguageUnit__NameAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1864:1: ( ( rule__LanguageUnit__NameAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1864:1: ( ( rule__LanguageUnit__NameAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1865:1: ( rule__LanguageUnit__NameAssignment_1 )
            {
             before(grammarAccess.getLanguageUnitAccess().getNameAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1866:1: ( rule__LanguageUnit__NameAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1866:2: rule__LanguageUnit__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__LanguageUnit__NameAssignment_1_in_rule__LanguageUnit__Group__1__Impl3996);
            rule__LanguageUnit__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLanguageUnitAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__1__Impl"


    // $ANTLR start "rule__LanguageUnit__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1876:1: rule__LanguageUnit__Group__2 : rule__LanguageUnit__Group__2__Impl rule__LanguageUnit__Group__3 ;
    public final void rule__LanguageUnit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1880:1: ( rule__LanguageUnit__Group__2__Impl rule__LanguageUnit__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1881:2: rule__LanguageUnit__Group__2__Impl rule__LanguageUnit__Group__3
            {
            pushFollow(FOLLOW_rule__LanguageUnit__Group__2__Impl_in_rule__LanguageUnit__Group__24026);
            rule__LanguageUnit__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LanguageUnit__Group__3_in_rule__LanguageUnit__Group__24029);
            rule__LanguageUnit__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__2"


    // $ANTLR start "rule__LanguageUnit__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1888:1: rule__LanguageUnit__Group__2__Impl : ( ( rule__LanguageUnit__VersionAssignment_2 )? ) ;
    public final void rule__LanguageUnit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1892:1: ( ( ( rule__LanguageUnit__VersionAssignment_2 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1893:1: ( ( rule__LanguageUnit__VersionAssignment_2 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1893:1: ( ( rule__LanguageUnit__VersionAssignment_2 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1894:1: ( rule__LanguageUnit__VersionAssignment_2 )?
            {
             before(grammarAccess.getLanguageUnitAccess().getVersionAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1895:1: ( rule__LanguageUnit__VersionAssignment_2 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1895:2: rule__LanguageUnit__VersionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__LanguageUnit__VersionAssignment_2_in_rule__LanguageUnit__Group__2__Impl4056);
                    rule__LanguageUnit__VersionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLanguageUnitAccess().getVersionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__2__Impl"


    // $ANTLR start "rule__LanguageUnit__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1905:1: rule__LanguageUnit__Group__3 : rule__LanguageUnit__Group__3__Impl ;
    public final void rule__LanguageUnit__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1909:1: ( rule__LanguageUnit__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1910:2: rule__LanguageUnit__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__LanguageUnit__Group__3__Impl_in_rule__LanguageUnit__Group__34087);
            rule__LanguageUnit__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__3"


    // $ANTLR start "rule__LanguageUnit__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1916:1: rule__LanguageUnit__Group__3__Impl : ( ( rule__LanguageUnit__ImportsAssignment_3 )* ) ;
    public final void rule__LanguageUnit__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1920:1: ( ( ( rule__LanguageUnit__ImportsAssignment_3 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1921:1: ( ( rule__LanguageUnit__ImportsAssignment_3 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1921:1: ( ( rule__LanguageUnit__ImportsAssignment_3 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1922:1: ( rule__LanguageUnit__ImportsAssignment_3 )*
            {
             before(grammarAccess.getLanguageUnitAccess().getImportsAssignment_3()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1923:1: ( rule__LanguageUnit__ImportsAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==38) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1923:2: rule__LanguageUnit__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__LanguageUnit__ImportsAssignment_3_in_rule__LanguageUnit__Group__3__Impl4114);
            	    rule__LanguageUnit__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getLanguageUnitAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__Group__3__Impl"


    // $ANTLR start "rule__Advice__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1943:1: rule__Advice__Group__0 : rule__Advice__Group__0__Impl rule__Advice__Group__1 ;
    public final void rule__Advice__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1947:1: ( rule__Advice__Group__0__Impl rule__Advice__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1948:2: rule__Advice__Group__0__Impl rule__Advice__Group__1
            {
            pushFollow(FOLLOW_rule__Advice__Group__0__Impl_in_rule__Advice__Group__04155);
            rule__Advice__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Advice__Group__1_in_rule__Advice__Group__04158);
            rule__Advice__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__0"


    // $ANTLR start "rule__Advice__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1955:1: rule__Advice__Group__0__Impl : ( '@advice' ) ;
    public final void rule__Advice__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1959:1: ( ( '@advice' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1960:1: ( '@advice' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1960:1: ( '@advice' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1961:1: '@advice'
            {
             before(grammarAccess.getAdviceAccess().getAdviceKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Advice__Group__0__Impl4186); 
             after(grammarAccess.getAdviceAccess().getAdviceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__0__Impl"


    // $ANTLR start "rule__Advice__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1974:1: rule__Advice__Group__1 : rule__Advice__Group__1__Impl rule__Advice__Group__2 ;
    public final void rule__Advice__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1978:1: ( rule__Advice__Group__1__Impl rule__Advice__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1979:2: rule__Advice__Group__1__Impl rule__Advice__Group__2
            {
            pushFollow(FOLLOW_rule__Advice__Group__1__Impl_in_rule__Advice__Group__14217);
            rule__Advice__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Advice__Group__2_in_rule__Advice__Group__14220);
            rule__Advice__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__1"


    // $ANTLR start "rule__Advice__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1986:1: rule__Advice__Group__1__Impl : ( '(' ) ;
    public final void rule__Advice__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1990:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1991:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1991:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:1992:1: '('
            {
             before(grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__Advice__Group__1__Impl4248); 
             after(grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__1__Impl"


    // $ANTLR start "rule__Advice__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2005:1: rule__Advice__Group__2 : rule__Advice__Group__2__Impl rule__Advice__Group__3 ;
    public final void rule__Advice__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2009:1: ( rule__Advice__Group__2__Impl rule__Advice__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2010:2: rule__Advice__Group__2__Impl rule__Advice__Group__3
            {
            pushFollow(FOLLOW_rule__Advice__Group__2__Impl_in_rule__Advice__Group__24279);
            rule__Advice__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Advice__Group__3_in_rule__Advice__Group__24282);
            rule__Advice__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__2"


    // $ANTLR start "rule__Advice__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2017:1: rule__Advice__Group__2__Impl : ( ( rule__Advice__NameAssignment_2 ) ) ;
    public final void rule__Advice__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2021:1: ( ( ( rule__Advice__NameAssignment_2 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2022:1: ( ( rule__Advice__NameAssignment_2 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2022:1: ( ( rule__Advice__NameAssignment_2 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2023:1: ( rule__Advice__NameAssignment_2 )
            {
             before(grammarAccess.getAdviceAccess().getNameAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2024:1: ( rule__Advice__NameAssignment_2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2024:2: rule__Advice__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Advice__NameAssignment_2_in_rule__Advice__Group__2__Impl4309);
            rule__Advice__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAdviceAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__2__Impl"


    // $ANTLR start "rule__Advice__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2034:1: rule__Advice__Group__3 : rule__Advice__Group__3__Impl rule__Advice__Group__4 ;
    public final void rule__Advice__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2038:1: ( rule__Advice__Group__3__Impl rule__Advice__Group__4 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2039:2: rule__Advice__Group__3__Impl rule__Advice__Group__4
            {
            pushFollow(FOLLOW_rule__Advice__Group__3__Impl_in_rule__Advice__Group__34339);
            rule__Advice__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Advice__Group__4_in_rule__Advice__Group__34342);
            rule__Advice__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__3"


    // $ANTLR start "rule__Advice__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2046:1: rule__Advice__Group__3__Impl : ( ')' ) ;
    public final void rule__Advice__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2050:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2051:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2051:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2052:1: ')'
            {
             before(grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__Advice__Group__3__Impl4370); 
             after(grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__3__Impl"


    // $ANTLR start "rule__Advice__Group__4"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2065:1: rule__Advice__Group__4 : rule__Advice__Group__4__Impl ;
    public final void rule__Advice__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2069:1: ( rule__Advice__Group__4__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2070:2: rule__Advice__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Advice__Group__4__Impl_in_rule__Advice__Group__44401);
            rule__Advice__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__4"


    // $ANTLR start "rule__Advice__Group__4__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2076:1: rule__Advice__Group__4__Impl : ( ( rule__Advice__VersionSpecAssignment_4 )? ) ;
    public final void rule__Advice__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2080:1: ( ( ( rule__Advice__VersionSpecAssignment_4 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2081:1: ( ( rule__Advice__VersionSpecAssignment_4 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2081:1: ( ( rule__Advice__VersionSpecAssignment_4 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2082:1: ( rule__Advice__VersionSpecAssignment_4 )?
            {
             before(grammarAccess.getAdviceAccess().getVersionSpecAssignment_4()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2083:1: ( rule__Advice__VersionSpecAssignment_4 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2083:2: rule__Advice__VersionSpecAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Advice__VersionSpecAssignment_4_in_rule__Advice__Group__4__Impl4428);
                    rule__Advice__VersionSpecAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAdviceAccess().getVersionSpecAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__Group__4__Impl"


    // $ANTLR start "rule__VersionSpec__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2103:1: rule__VersionSpec__Group__0 : rule__VersionSpec__Group__0__Impl rule__VersionSpec__Group__1 ;
    public final void rule__VersionSpec__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2107:1: ( rule__VersionSpec__Group__0__Impl rule__VersionSpec__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2108:2: rule__VersionSpec__Group__0__Impl rule__VersionSpec__Group__1
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__0__Impl_in_rule__VersionSpec__Group__04469);
            rule__VersionSpec__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionSpec__Group__1_in_rule__VersionSpec__Group__04472);
            rule__VersionSpec__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__0"


    // $ANTLR start "rule__VersionSpec__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2115:1: rule__VersionSpec__Group__0__Impl : ( 'with' ) ;
    public final void rule__VersionSpec__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2119:1: ( ( 'with' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2120:1: ( 'with' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2120:1: ( 'with' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2121:1: 'with'
            {
             before(grammarAccess.getVersionSpecAccess().getWithKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__VersionSpec__Group__0__Impl4500); 
             after(grammarAccess.getVersionSpecAccess().getWithKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__0__Impl"


    // $ANTLR start "rule__VersionSpec__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2134:1: rule__VersionSpec__Group__1 : rule__VersionSpec__Group__1__Impl rule__VersionSpec__Group__2 ;
    public final void rule__VersionSpec__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2138:1: ( rule__VersionSpec__Group__1__Impl rule__VersionSpec__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2139:2: rule__VersionSpec__Group__1__Impl rule__VersionSpec__Group__2
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__1__Impl_in_rule__VersionSpec__Group__14531);
            rule__VersionSpec__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionSpec__Group__2_in_rule__VersionSpec__Group__14534);
            rule__VersionSpec__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__1"


    // $ANTLR start "rule__VersionSpec__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2146:1: rule__VersionSpec__Group__1__Impl : ( '(' ) ;
    public final void rule__VersionSpec__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2150:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2151:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2151:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2152:1: '('
            {
             before(grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__VersionSpec__Group__1__Impl4562); 
             after(grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__1__Impl"


    // $ANTLR start "rule__VersionSpec__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2165:1: rule__VersionSpec__Group__2 : rule__VersionSpec__Group__2__Impl rule__VersionSpec__Group__3 ;
    public final void rule__VersionSpec__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2169:1: ( rule__VersionSpec__Group__2__Impl rule__VersionSpec__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2170:2: rule__VersionSpec__Group__2__Impl rule__VersionSpec__Group__3
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__2__Impl_in_rule__VersionSpec__Group__24593);
            rule__VersionSpec__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionSpec__Group__3_in_rule__VersionSpec__Group__24596);
            rule__VersionSpec__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__2"


    // $ANTLR start "rule__VersionSpec__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2177:1: rule__VersionSpec__Group__2__Impl : ( ( rule__VersionSpec__ConflictsAssignment_2 ) ) ;
    public final void rule__VersionSpec__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2181:1: ( ( ( rule__VersionSpec__ConflictsAssignment_2 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2182:1: ( ( rule__VersionSpec__ConflictsAssignment_2 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2182:1: ( ( rule__VersionSpec__ConflictsAssignment_2 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2183:1: ( rule__VersionSpec__ConflictsAssignment_2 )
            {
             before(grammarAccess.getVersionSpecAccess().getConflictsAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2184:1: ( rule__VersionSpec__ConflictsAssignment_2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2184:2: rule__VersionSpec__ConflictsAssignment_2
            {
            pushFollow(FOLLOW_rule__VersionSpec__ConflictsAssignment_2_in_rule__VersionSpec__Group__2__Impl4623);
            rule__VersionSpec__ConflictsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVersionSpecAccess().getConflictsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__2__Impl"


    // $ANTLR start "rule__VersionSpec__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2194:1: rule__VersionSpec__Group__3 : rule__VersionSpec__Group__3__Impl rule__VersionSpec__Group__4 ;
    public final void rule__VersionSpec__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2198:1: ( rule__VersionSpec__Group__3__Impl rule__VersionSpec__Group__4 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2199:2: rule__VersionSpec__Group__3__Impl rule__VersionSpec__Group__4
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__3__Impl_in_rule__VersionSpec__Group__34653);
            rule__VersionSpec__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionSpec__Group__4_in_rule__VersionSpec__Group__34656);
            rule__VersionSpec__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__3"


    // $ANTLR start "rule__VersionSpec__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2206:1: rule__VersionSpec__Group__3__Impl : ( ( rule__VersionSpec__Group_3__0 )* ) ;
    public final void rule__VersionSpec__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2210:1: ( ( ( rule__VersionSpec__Group_3__0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2211:1: ( ( rule__VersionSpec__Group_3__0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2211:1: ( ( rule__VersionSpec__Group_3__0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2212:1: ( rule__VersionSpec__Group_3__0 )*
            {
             before(grammarAccess.getVersionSpecAccess().getGroup_3()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2213:1: ( rule__VersionSpec__Group_3__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==35) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2213:2: rule__VersionSpec__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__VersionSpec__Group_3__0_in_rule__VersionSpec__Group__3__Impl4683);
            	    rule__VersionSpec__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getVersionSpecAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__3__Impl"


    // $ANTLR start "rule__VersionSpec__Group__4"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2223:1: rule__VersionSpec__Group__4 : rule__VersionSpec__Group__4__Impl ;
    public final void rule__VersionSpec__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2227:1: ( rule__VersionSpec__Group__4__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2228:2: rule__VersionSpec__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group__4__Impl_in_rule__VersionSpec__Group__44714);
            rule__VersionSpec__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__4"


    // $ANTLR start "rule__VersionSpec__Group__4__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2234:1: rule__VersionSpec__Group__4__Impl : ( ')' ) ;
    public final void rule__VersionSpec__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2238:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2239:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2239:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2240:1: ')'
            {
             before(grammarAccess.getVersionSpecAccess().getRightParenthesisKeyword_4()); 
            match(input,33,FOLLOW_33_in_rule__VersionSpec__Group__4__Impl4742); 
             after(grammarAccess.getVersionSpecAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group__4__Impl"


    // $ANTLR start "rule__VersionSpec__Group_3__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2263:1: rule__VersionSpec__Group_3__0 : rule__VersionSpec__Group_3__0__Impl rule__VersionSpec__Group_3__1 ;
    public final void rule__VersionSpec__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2267:1: ( rule__VersionSpec__Group_3__0__Impl rule__VersionSpec__Group_3__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2268:2: rule__VersionSpec__Group_3__0__Impl rule__VersionSpec__Group_3__1
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group_3__0__Impl_in_rule__VersionSpec__Group_3__04783);
            rule__VersionSpec__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionSpec__Group_3__1_in_rule__VersionSpec__Group_3__04786);
            rule__VersionSpec__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group_3__0"


    // $ANTLR start "rule__VersionSpec__Group_3__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2275:1: rule__VersionSpec__Group_3__0__Impl : ( ',' ) ;
    public final void rule__VersionSpec__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2279:1: ( ( ',' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2280:1: ( ',' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2280:1: ( ',' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2281:1: ','
            {
             before(grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0()); 
            match(input,35,FOLLOW_35_in_rule__VersionSpec__Group_3__0__Impl4814); 
             after(grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group_3__0__Impl"


    // $ANTLR start "rule__VersionSpec__Group_3__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2294:1: rule__VersionSpec__Group_3__1 : rule__VersionSpec__Group_3__1__Impl ;
    public final void rule__VersionSpec__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2298:1: ( rule__VersionSpec__Group_3__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2299:2: rule__VersionSpec__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VersionSpec__Group_3__1__Impl_in_rule__VersionSpec__Group_3__14845);
            rule__VersionSpec__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group_3__1"


    // $ANTLR start "rule__VersionSpec__Group_3__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2305:1: rule__VersionSpec__Group_3__1__Impl : ( ( rule__VersionSpec__ConflictsAssignment_3_1 ) ) ;
    public final void rule__VersionSpec__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2309:1: ( ( ( rule__VersionSpec__ConflictsAssignment_3_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2310:1: ( ( rule__VersionSpec__ConflictsAssignment_3_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2310:1: ( ( rule__VersionSpec__ConflictsAssignment_3_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2311:1: ( rule__VersionSpec__ConflictsAssignment_3_1 )
            {
             before(grammarAccess.getVersionSpecAccess().getConflictsAssignment_3_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2312:1: ( rule__VersionSpec__ConflictsAssignment_3_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2312:2: rule__VersionSpec__ConflictsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__VersionSpec__ConflictsAssignment_3_1_in_rule__VersionSpec__Group_3__1__Impl4872);
            rule__VersionSpec__ConflictsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVersionSpecAccess().getConflictsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__Group_3__1__Impl"


    // $ANTLR start "rule__VersionedId__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2326:1: rule__VersionedId__Group__0 : rule__VersionedId__Group__0__Impl rule__VersionedId__Group__1 ;
    public final void rule__VersionedId__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2330:1: ( rule__VersionedId__Group__0__Impl rule__VersionedId__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2331:2: rule__VersionedId__Group__0__Impl rule__VersionedId__Group__1
            {
            pushFollow(FOLLOW_rule__VersionedId__Group__0__Impl_in_rule__VersionedId__Group__04906);
            rule__VersionedId__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionedId__Group__1_in_rule__VersionedId__Group__04909);
            rule__VersionedId__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__0"


    // $ANTLR start "rule__VersionedId__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2338:1: rule__VersionedId__Group__0__Impl : ( 'version' ) ;
    public final void rule__VersionedId__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2342:1: ( ( 'version' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2343:1: ( 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2343:1: ( 'version' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2344:1: 'version'
            {
             before(grammarAccess.getVersionedIdAccess().getVersionKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__VersionedId__Group__0__Impl4937); 
             after(grammarAccess.getVersionedIdAccess().getVersionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__0__Impl"


    // $ANTLR start "rule__VersionedId__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2357:1: rule__VersionedId__Group__1 : rule__VersionedId__Group__1__Impl rule__VersionedId__Group__2 ;
    public final void rule__VersionedId__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2361:1: ( rule__VersionedId__Group__1__Impl rule__VersionedId__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2362:2: rule__VersionedId__Group__1__Impl rule__VersionedId__Group__2
            {
            pushFollow(FOLLOW_rule__VersionedId__Group__1__Impl_in_rule__VersionedId__Group__14968);
            rule__VersionedId__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionedId__Group__2_in_rule__VersionedId__Group__14971);
            rule__VersionedId__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__1"


    // $ANTLR start "rule__VersionedId__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2369:1: rule__VersionedId__Group__1__Impl : ( ( rule__VersionedId__OpAssignment_1 ) ) ;
    public final void rule__VersionedId__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2373:1: ( ( ( rule__VersionedId__OpAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2374:1: ( ( rule__VersionedId__OpAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2374:1: ( ( rule__VersionedId__OpAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2375:1: ( rule__VersionedId__OpAssignment_1 )
            {
             before(grammarAccess.getVersionedIdAccess().getOpAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2376:1: ( rule__VersionedId__OpAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2376:2: rule__VersionedId__OpAssignment_1
            {
            pushFollow(FOLLOW_rule__VersionedId__OpAssignment_1_in_rule__VersionedId__Group__1__Impl4998);
            rule__VersionedId__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVersionedIdAccess().getOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__1__Impl"


    // $ANTLR start "rule__VersionedId__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2386:1: rule__VersionedId__Group__2 : rule__VersionedId__Group__2__Impl ;
    public final void rule__VersionedId__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2390:1: ( rule__VersionedId__Group__2__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2391:2: rule__VersionedId__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VersionedId__Group__2__Impl_in_rule__VersionedId__Group__25028);
            rule__VersionedId__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__2"


    // $ANTLR start "rule__VersionedId__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2397:1: rule__VersionedId__Group__2__Impl : ( ( rule__VersionedId__VersionAssignment_2 ) ) ;
    public final void rule__VersionedId__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2401:1: ( ( ( rule__VersionedId__VersionAssignment_2 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2402:1: ( ( rule__VersionedId__VersionAssignment_2 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2402:1: ( ( rule__VersionedId__VersionAssignment_2 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2403:1: ( rule__VersionedId__VersionAssignment_2 )
            {
             before(grammarAccess.getVersionedIdAccess().getVersionAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2404:1: ( rule__VersionedId__VersionAssignment_2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2404:2: rule__VersionedId__VersionAssignment_2
            {
            pushFollow(FOLLOW_rule__VersionedId__VersionAssignment_2_in_rule__VersionedId__Group__2__Impl5055);
            rule__VersionedId__VersionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVersionedIdAccess().getVersionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2422:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2426:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2427:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05093);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05096);
            rule__Parameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2434:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__TypeAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2438:1: ( ( ( rule__Parameter__TypeAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2439:1: ( ( rule__Parameter__TypeAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2439:1: ( ( rule__Parameter__TypeAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2440:1: ( rule__Parameter__TypeAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2441:1: ( rule__Parameter__TypeAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2441:2: rule__Parameter__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__TypeAssignment_0_in_rule__Parameter__Group__0__Impl5123);
            rule__Parameter__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2451:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2455:1: ( rule__Parameter__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2456:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15153);
            rule__Parameter__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2462:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2466:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2467:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2467:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2468:1: ( rule__Parameter__NameAssignment_1 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2469:1: ( rule__Parameter__NameAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2469:2: rule__Parameter__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl5180);
            rule__Parameter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__VersionStmt__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2483:1: rule__VersionStmt__Group__0 : rule__VersionStmt__Group__0__Impl rule__VersionStmt__Group__1 ;
    public final void rule__VersionStmt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2487:1: ( rule__VersionStmt__Group__0__Impl rule__VersionStmt__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2488:2: rule__VersionStmt__Group__0__Impl rule__VersionStmt__Group__1
            {
            pushFollow(FOLLOW_rule__VersionStmt__Group__0__Impl_in_rule__VersionStmt__Group__05214);
            rule__VersionStmt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionStmt__Group__1_in_rule__VersionStmt__Group__05217);
            rule__VersionStmt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__0"


    // $ANTLR start "rule__VersionStmt__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2495:1: rule__VersionStmt__Group__0__Impl : ( 'version' ) ;
    public final void rule__VersionStmt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2499:1: ( ( 'version' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2500:1: ( 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2500:1: ( 'version' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2501:1: 'version'
            {
             before(grammarAccess.getVersionStmtAccess().getVersionKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__VersionStmt__Group__0__Impl5245); 
             after(grammarAccess.getVersionStmtAccess().getVersionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__0__Impl"


    // $ANTLR start "rule__VersionStmt__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2514:1: rule__VersionStmt__Group__1 : rule__VersionStmt__Group__1__Impl rule__VersionStmt__Group__2 ;
    public final void rule__VersionStmt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2518:1: ( rule__VersionStmt__Group__1__Impl rule__VersionStmt__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2519:2: rule__VersionStmt__Group__1__Impl rule__VersionStmt__Group__2
            {
            pushFollow(FOLLOW_rule__VersionStmt__Group__1__Impl_in_rule__VersionStmt__Group__15276);
            rule__VersionStmt__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VersionStmt__Group__2_in_rule__VersionStmt__Group__15279);
            rule__VersionStmt__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__1"


    // $ANTLR start "rule__VersionStmt__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2526:1: rule__VersionStmt__Group__1__Impl : ( ( rule__VersionStmt__VersionAssignment_1 ) ) ;
    public final void rule__VersionStmt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2530:1: ( ( ( rule__VersionStmt__VersionAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2531:1: ( ( rule__VersionStmt__VersionAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2531:1: ( ( rule__VersionStmt__VersionAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2532:1: ( rule__VersionStmt__VersionAssignment_1 )
            {
             before(grammarAccess.getVersionStmtAccess().getVersionAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2533:1: ( rule__VersionStmt__VersionAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2533:2: rule__VersionStmt__VersionAssignment_1
            {
            pushFollow(FOLLOW_rule__VersionStmt__VersionAssignment_1_in_rule__VersionStmt__Group__1__Impl5306);
            rule__VersionStmt__VersionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVersionStmtAccess().getVersionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__1__Impl"


    // $ANTLR start "rule__VersionStmt__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2543:1: rule__VersionStmt__Group__2 : rule__VersionStmt__Group__2__Impl ;
    public final void rule__VersionStmt__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2547:1: ( rule__VersionStmt__Group__2__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2548:2: rule__VersionStmt__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VersionStmt__Group__2__Impl_in_rule__VersionStmt__Group__25336);
            rule__VersionStmt__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__2"


    // $ANTLR start "rule__VersionStmt__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2554:1: rule__VersionStmt__Group__2__Impl : ( ';' ) ;
    public final void rule__VersionStmt__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2558:1: ( ( ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2559:1: ( ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2559:1: ( ';' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2560:1: ';'
            {
             before(grammarAccess.getVersionStmtAccess().getSemicolonKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__VersionStmt__Group__2__Impl5364); 
             after(grammarAccess.getVersionStmtAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__Group__2__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2579:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2583:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2584:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05401);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05404);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2591:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2595:1: ( ( 'import' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2596:1: ( 'import' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2596:1: ( 'import' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2597:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Import__Group__0__Impl5432); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2610:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2614:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2615:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15463);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15466);
            rule__Import__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2622:1: rule__Import__Group__1__Impl : ( ( rule__Import__NameAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2626:1: ( ( ( rule__Import__NameAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2627:1: ( ( rule__Import__NameAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2627:1: ( ( rule__Import__NameAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2628:1: ( rule__Import__NameAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getNameAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2629:1: ( rule__Import__NameAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2629:2: rule__Import__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__NameAssignment_1_in_rule__Import__Group__1__Impl5493);
            rule__Import__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2639:1: rule__Import__Group__2 : rule__Import__Group__2__Impl rule__Import__Group__3 ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2643:1: ( rule__Import__Group__2__Impl rule__Import__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2644:2: rule__Import__Group__2__Impl rule__Import__Group__3
            {
            pushFollow(FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25523);
            rule__Import__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__3_in_rule__Import__Group__25526);
            rule__Import__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2651:1: rule__Import__Group__2__Impl : ( ( rule__Import__VersionSpecAssignment_2 )? ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2655:1: ( ( ( rule__Import__VersionSpecAssignment_2 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2656:1: ( ( rule__Import__VersionSpecAssignment_2 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2656:1: ( ( rule__Import__VersionSpecAssignment_2 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2657:1: ( rule__Import__VersionSpecAssignment_2 )?
            {
             before(grammarAccess.getImportAccess().getVersionSpecAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2658:1: ( rule__Import__VersionSpecAssignment_2 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2658:2: rule__Import__VersionSpecAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Import__VersionSpecAssignment_2_in_rule__Import__Group__2__Impl5553);
                    rule__Import__VersionSpecAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImportAccess().getVersionSpecAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Import__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2668:1: rule__Import__Group__3 : rule__Import__Group__3__Impl ;
    public final void rule__Import__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2672:1: ( rule__Import__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2673:2: rule__Import__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__3__Impl_in_rule__Import__Group__35584);
            rule__Import__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3"


    // $ANTLR start "rule__Import__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2679:1: rule__Import__Group__3__Impl : ( ';' ) ;
    public final void rule__Import__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2683:1: ( ( ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2684:1: ( ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2684:1: ( ';' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2685:1: ';'
            {
             before(grammarAccess.getImportAccess().getSemicolonKeyword_3()); 
            match(input,37,FOLLOW_37_in_rule__Import__Group__3__Impl5612); 
             after(grammarAccess.getImportAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3__Impl"


    // $ANTLR start "rule__LogicalExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2708:1: rule__LogicalExpression__Group__0 : rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1 ;
    public final void rule__LogicalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2712:1: ( rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2713:2: rule__LogicalExpression__Group__0__Impl rule__LogicalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalExpression__Group__0__Impl_in_rule__LogicalExpression__Group__05653);
            rule__LogicalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LogicalExpression__Group__1_in_rule__LogicalExpression__Group__05656);
            rule__LogicalExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__0"


    // $ANTLR start "rule__LogicalExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2720:1: rule__LogicalExpression__Group__0__Impl : ( ( rule__LogicalExpression__LeftAssignment_0 ) ) ;
    public final void rule__LogicalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2724:1: ( ( ( rule__LogicalExpression__LeftAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2725:1: ( ( rule__LogicalExpression__LeftAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2725:1: ( ( rule__LogicalExpression__LeftAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2726:1: ( rule__LogicalExpression__LeftAssignment_0 )
            {
             before(grammarAccess.getLogicalExpressionAccess().getLeftAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2727:1: ( rule__LogicalExpression__LeftAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2727:2: rule__LogicalExpression__LeftAssignment_0
            {
            pushFollow(FOLLOW_rule__LogicalExpression__LeftAssignment_0_in_rule__LogicalExpression__Group__0__Impl5683);
            rule__LogicalExpression__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__0__Impl"


    // $ANTLR start "rule__LogicalExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2737:1: rule__LogicalExpression__Group__1 : rule__LogicalExpression__Group__1__Impl ;
    public final void rule__LogicalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2741:1: ( rule__LogicalExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2742:2: rule__LogicalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalExpression__Group__1__Impl_in_rule__LogicalExpression__Group__15713);
            rule__LogicalExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__1"


    // $ANTLR start "rule__LogicalExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2748:1: rule__LogicalExpression__Group__1__Impl : ( ( rule__LogicalExpression__RightAssignment_1 )* ) ;
    public final void rule__LogicalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2752:1: ( ( ( rule__LogicalExpression__RightAssignment_1 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2753:1: ( ( rule__LogicalExpression__RightAssignment_1 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2753:1: ( ( rule__LogicalExpression__RightAssignment_1 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2754:1: ( rule__LogicalExpression__RightAssignment_1 )*
            {
             before(grammarAccess.getLogicalExpressionAccess().getRightAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2755:1: ( rule__LogicalExpression__RightAssignment_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=18 && LA23_0<=20)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2755:2: rule__LogicalExpression__RightAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__LogicalExpression__RightAssignment_1_in_rule__LogicalExpression__Group__1__Impl5740);
            	    rule__LogicalExpression__RightAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getLogicalExpressionAccess().getRightAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__Group__1__Impl"


    // $ANTLR start "rule__LogicalExpressionPart__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2769:1: rule__LogicalExpressionPart__Group__0 : rule__LogicalExpressionPart__Group__0__Impl rule__LogicalExpressionPart__Group__1 ;
    public final void rule__LogicalExpressionPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2773:1: ( rule__LogicalExpressionPart__Group__0__Impl rule__LogicalExpressionPart__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2774:2: rule__LogicalExpressionPart__Group__0__Impl rule__LogicalExpressionPart__Group__1
            {
            pushFollow(FOLLOW_rule__LogicalExpressionPart__Group__0__Impl_in_rule__LogicalExpressionPart__Group__05775);
            rule__LogicalExpressionPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LogicalExpressionPart__Group__1_in_rule__LogicalExpressionPart__Group__05778);
            rule__LogicalExpressionPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__Group__0"


    // $ANTLR start "rule__LogicalExpressionPart__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2781:1: rule__LogicalExpressionPart__Group__0__Impl : ( ( rule__LogicalExpressionPart__OpAssignment_0 ) ) ;
    public final void rule__LogicalExpressionPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2785:1: ( ( ( rule__LogicalExpressionPart__OpAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2786:1: ( ( rule__LogicalExpressionPart__OpAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2786:1: ( ( rule__LogicalExpressionPart__OpAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2787:1: ( rule__LogicalExpressionPart__OpAssignment_0 )
            {
             before(grammarAccess.getLogicalExpressionPartAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2788:1: ( rule__LogicalExpressionPart__OpAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2788:2: rule__LogicalExpressionPart__OpAssignment_0
            {
            pushFollow(FOLLOW_rule__LogicalExpressionPart__OpAssignment_0_in_rule__LogicalExpressionPart__Group__0__Impl5805);
            rule__LogicalExpressionPart__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionPartAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__Group__0__Impl"


    // $ANTLR start "rule__LogicalExpressionPart__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2798:1: rule__LogicalExpressionPart__Group__1 : rule__LogicalExpressionPart__Group__1__Impl ;
    public final void rule__LogicalExpressionPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2802:1: ( rule__LogicalExpressionPart__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2803:2: rule__LogicalExpressionPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__LogicalExpressionPart__Group__1__Impl_in_rule__LogicalExpressionPart__Group__15835);
            rule__LogicalExpressionPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__Group__1"


    // $ANTLR start "rule__LogicalExpressionPart__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2809:1: rule__LogicalExpressionPart__Group__1__Impl : ( ( rule__LogicalExpressionPart__ExAssignment_1 ) ) ;
    public final void rule__LogicalExpressionPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2813:1: ( ( ( rule__LogicalExpressionPart__ExAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2814:1: ( ( rule__LogicalExpressionPart__ExAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2814:1: ( ( rule__LogicalExpressionPart__ExAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2815:1: ( rule__LogicalExpressionPart__ExAssignment_1 )
            {
             before(grammarAccess.getLogicalExpressionPartAccess().getExAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2816:1: ( rule__LogicalExpressionPart__ExAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2816:2: rule__LogicalExpressionPart__ExAssignment_1
            {
            pushFollow(FOLLOW_rule__LogicalExpressionPart__ExAssignment_1_in_rule__LogicalExpressionPart__Group__1__Impl5862);
            rule__LogicalExpressionPart__ExAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLogicalExpressionPartAccess().getExAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2830:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2834:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2835:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__05896);
            rule__EqualityExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__05899);
            rule__EqualityExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__0"


    // $ANTLR start "rule__EqualityExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2842:1: rule__EqualityExpression__Group__0__Impl : ( ( rule__EqualityExpression__LeftAssignment_0 ) ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2846:1: ( ( ( rule__EqualityExpression__LeftAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2847:1: ( ( rule__EqualityExpression__LeftAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2847:1: ( ( rule__EqualityExpression__LeftAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2848:1: ( rule__EqualityExpression__LeftAssignment_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getLeftAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2849:1: ( rule__EqualityExpression__LeftAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2849:2: rule__EqualityExpression__LeftAssignment_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__LeftAssignment_0_in_rule__EqualityExpression__Group__0__Impl5926);
            rule__EqualityExpression__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2859:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2863:1: ( rule__EqualityExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2864:2: rule__EqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__15956);
            rule__EqualityExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__1"


    // $ANTLR start "rule__EqualityExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2870:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__RightAssignment_1 )? ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2874:1: ( ( ( rule__EqualityExpression__RightAssignment_1 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2875:1: ( ( rule__EqualityExpression__RightAssignment_1 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2875:1: ( ( rule__EqualityExpression__RightAssignment_1 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2876:1: ( rule__EqualityExpression__RightAssignment_1 )?
            {
             before(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2877:1: ( rule__EqualityExpression__RightAssignment_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==13||(LA24_0>=21 && LA24_0<=22)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2877:2: rule__EqualityExpression__RightAssignment_1
                    {
                    pushFollow(FOLLOW_rule__EqualityExpression__RightAssignment_1_in_rule__EqualityExpression__Group__1__Impl5983);
                    rule__EqualityExpression__RightAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpressionPart__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2891:1: rule__EqualityExpressionPart__Group__0 : rule__EqualityExpressionPart__Group__0__Impl rule__EqualityExpressionPart__Group__1 ;
    public final void rule__EqualityExpressionPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2895:1: ( rule__EqualityExpressionPart__Group__0__Impl rule__EqualityExpressionPart__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2896:2: rule__EqualityExpressionPart__Group__0__Impl rule__EqualityExpressionPart__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpressionPart__Group__0__Impl_in_rule__EqualityExpressionPart__Group__06018);
            rule__EqualityExpressionPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EqualityExpressionPart__Group__1_in_rule__EqualityExpressionPart__Group__06021);
            rule__EqualityExpressionPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__Group__0"


    // $ANTLR start "rule__EqualityExpressionPart__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2903:1: rule__EqualityExpressionPart__Group__0__Impl : ( ( rule__EqualityExpressionPart__OpAssignment_0 ) ) ;
    public final void rule__EqualityExpressionPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2907:1: ( ( ( rule__EqualityExpressionPart__OpAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2908:1: ( ( rule__EqualityExpressionPart__OpAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2908:1: ( ( rule__EqualityExpressionPart__OpAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2909:1: ( rule__EqualityExpressionPart__OpAssignment_0 )
            {
             before(grammarAccess.getEqualityExpressionPartAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2910:1: ( rule__EqualityExpressionPart__OpAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2910:2: rule__EqualityExpressionPart__OpAssignment_0
            {
            pushFollow(FOLLOW_rule__EqualityExpressionPart__OpAssignment_0_in_rule__EqualityExpressionPart__Group__0__Impl6048);
            rule__EqualityExpressionPart__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityExpressionPartAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpressionPart__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2920:1: rule__EqualityExpressionPart__Group__1 : rule__EqualityExpressionPart__Group__1__Impl ;
    public final void rule__EqualityExpressionPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2924:1: ( rule__EqualityExpressionPart__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2925:2: rule__EqualityExpressionPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpressionPart__Group__1__Impl_in_rule__EqualityExpressionPart__Group__16078);
            rule__EqualityExpressionPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__Group__1"


    // $ANTLR start "rule__EqualityExpressionPart__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2931:1: rule__EqualityExpressionPart__Group__1__Impl : ( ( rule__EqualityExpressionPart__ExAssignment_1 ) ) ;
    public final void rule__EqualityExpressionPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2935:1: ( ( ( rule__EqualityExpressionPart__ExAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2936:1: ( ( rule__EqualityExpressionPart__ExAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2936:1: ( ( rule__EqualityExpressionPart__ExAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2937:1: ( rule__EqualityExpressionPart__ExAssignment_1 )
            {
             before(grammarAccess.getEqualityExpressionPartAccess().getExAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2938:1: ( rule__EqualityExpressionPart__ExAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2938:2: rule__EqualityExpressionPart__ExAssignment_1
            {
            pushFollow(FOLLOW_rule__EqualityExpressionPart__ExAssignment_1_in_rule__EqualityExpressionPart__Group__1__Impl6105);
            rule__EqualityExpressionPart__ExAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEqualityExpressionPartAccess().getExAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__Group__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2952:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2956:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2957:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__06139);
            rule__RelationalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__06142);
            rule__RelationalExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0"


    // $ANTLR start "rule__RelationalExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2964:1: rule__RelationalExpression__Group__0__Impl : ( ( rule__RelationalExpression__LeftAssignment_0 ) ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2968:1: ( ( ( rule__RelationalExpression__LeftAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2969:1: ( ( rule__RelationalExpression__LeftAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2969:1: ( ( rule__RelationalExpression__LeftAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2970:1: ( rule__RelationalExpression__LeftAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2971:1: ( rule__RelationalExpression__LeftAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2971:2: rule__RelationalExpression__LeftAssignment_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__LeftAssignment_0_in_rule__RelationalExpression__Group__0__Impl6169);
            rule__RelationalExpression__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2981:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2985:1: ( rule__RelationalExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2986:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__16199);
            rule__RelationalExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1"


    // $ANTLR start "rule__RelationalExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2992:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__RightAssignment_1 )? ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2996:1: ( ( ( rule__RelationalExpression__RightAssignment_1 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2997:1: ( ( rule__RelationalExpression__RightAssignment_1 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2997:1: ( ( rule__RelationalExpression__RightAssignment_1 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2998:1: ( rule__RelationalExpression__RightAssignment_1 )?
            {
             before(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2999:1: ( rule__RelationalExpression__RightAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=14 && LA25_0<=17)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:2999:2: rule__RelationalExpression__RightAssignment_1
                    {
                    pushFollow(FOLLOW_rule__RelationalExpression__RightAssignment_1_in_rule__RelationalExpression__Group__1__Impl6226);
                    rule__RelationalExpression__RightAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1__Impl"


    // $ANTLR start "rule__RelationalExpressionPart__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3013:1: rule__RelationalExpressionPart__Group__0 : rule__RelationalExpressionPart__Group__0__Impl rule__RelationalExpressionPart__Group__1 ;
    public final void rule__RelationalExpressionPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3017:1: ( rule__RelationalExpressionPart__Group__0__Impl rule__RelationalExpressionPart__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3018:2: rule__RelationalExpressionPart__Group__0__Impl rule__RelationalExpressionPart__Group__1
            {
            pushFollow(FOLLOW_rule__RelationalExpressionPart__Group__0__Impl_in_rule__RelationalExpressionPart__Group__06261);
            rule__RelationalExpressionPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RelationalExpressionPart__Group__1_in_rule__RelationalExpressionPart__Group__06264);
            rule__RelationalExpressionPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__Group__0"


    // $ANTLR start "rule__RelationalExpressionPart__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3025:1: rule__RelationalExpressionPart__Group__0__Impl : ( ( rule__RelationalExpressionPart__OpAssignment_0 ) ) ;
    public final void rule__RelationalExpressionPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3029:1: ( ( ( rule__RelationalExpressionPart__OpAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3030:1: ( ( rule__RelationalExpressionPart__OpAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3030:1: ( ( rule__RelationalExpressionPart__OpAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3031:1: ( rule__RelationalExpressionPart__OpAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionPartAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3032:1: ( rule__RelationalExpressionPart__OpAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3032:2: rule__RelationalExpressionPart__OpAssignment_0
            {
            pushFollow(FOLLOW_rule__RelationalExpressionPart__OpAssignment_0_in_rule__RelationalExpressionPart__Group__0__Impl6291);
            rule__RelationalExpressionPart__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionPartAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__Group__0__Impl"


    // $ANTLR start "rule__RelationalExpressionPart__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3042:1: rule__RelationalExpressionPart__Group__1 : rule__RelationalExpressionPart__Group__1__Impl ;
    public final void rule__RelationalExpressionPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3046:1: ( rule__RelationalExpressionPart__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3047:2: rule__RelationalExpressionPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpressionPart__Group__1__Impl_in_rule__RelationalExpressionPart__Group__16321);
            rule__RelationalExpressionPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__Group__1"


    // $ANTLR start "rule__RelationalExpressionPart__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3053:1: rule__RelationalExpressionPart__Group__1__Impl : ( ( rule__RelationalExpressionPart__ExAssignment_1 ) ) ;
    public final void rule__RelationalExpressionPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3057:1: ( ( ( rule__RelationalExpressionPart__ExAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3058:1: ( ( rule__RelationalExpressionPart__ExAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3058:1: ( ( rule__RelationalExpressionPart__ExAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3059:1: ( rule__RelationalExpressionPart__ExAssignment_1 )
            {
             before(grammarAccess.getRelationalExpressionPartAccess().getExAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3060:1: ( rule__RelationalExpressionPart__ExAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3060:2: rule__RelationalExpressionPart__ExAssignment_1
            {
            pushFollow(FOLLOW_rule__RelationalExpressionPart__ExAssignment_1_in_rule__RelationalExpressionPart__Group__1__Impl6348);
            rule__RelationalExpressionPart__ExAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelationalExpressionPartAccess().getExAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3074:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3078:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3079:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__06382);
            rule__AdditiveExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__06385);
            rule__AdditiveExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0"


    // $ANTLR start "rule__AdditiveExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3086:1: rule__AdditiveExpression__Group__0__Impl : ( ( rule__AdditiveExpression__LeftAssignment_0 ) ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3090:1: ( ( ( rule__AdditiveExpression__LeftAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3091:1: ( ( rule__AdditiveExpression__LeftAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3091:1: ( ( rule__AdditiveExpression__LeftAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3092:1: ( rule__AdditiveExpression__LeftAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getLeftAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3093:1: ( rule__AdditiveExpression__LeftAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3093:2: rule__AdditiveExpression__LeftAssignment_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__LeftAssignment_0_in_rule__AdditiveExpression__Group__0__Impl6412);
            rule__AdditiveExpression__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3103:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3107:1: ( rule__AdditiveExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3108:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__16442);
            rule__AdditiveExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1"


    // $ANTLR start "rule__AdditiveExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3114:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__RightAssignment_1 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3118:1: ( ( ( rule__AdditiveExpression__RightAssignment_1 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3119:1: ( ( rule__AdditiveExpression__RightAssignment_1 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3119:1: ( ( rule__AdditiveExpression__RightAssignment_1 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3120:1: ( rule__AdditiveExpression__RightAssignment_1 )*
            {
             before(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3121:1: ( rule__AdditiveExpression__RightAssignment_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=23 && LA26_0<=24)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3121:2: rule__AdditiveExpression__RightAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpression__RightAssignment_1_in_rule__AdditiveExpression__Group__1__Impl6469);
            	    rule__AdditiveExpression__RightAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpressionPart__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3135:1: rule__AdditiveExpressionPart__Group__0 : rule__AdditiveExpressionPart__Group__0__Impl rule__AdditiveExpressionPart__Group__1 ;
    public final void rule__AdditiveExpressionPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3139:1: ( rule__AdditiveExpressionPart__Group__0__Impl rule__AdditiveExpressionPart__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3140:2: rule__AdditiveExpressionPart__Group__0__Impl rule__AdditiveExpressionPart__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpressionPart__Group__0__Impl_in_rule__AdditiveExpressionPart__Group__06504);
            rule__AdditiveExpressionPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpressionPart__Group__1_in_rule__AdditiveExpressionPart__Group__06507);
            rule__AdditiveExpressionPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__Group__0"


    // $ANTLR start "rule__AdditiveExpressionPart__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3147:1: rule__AdditiveExpressionPart__Group__0__Impl : ( ( rule__AdditiveExpressionPart__OpAssignment_0 ) ) ;
    public final void rule__AdditiveExpressionPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3151:1: ( ( ( rule__AdditiveExpressionPart__OpAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3152:1: ( ( rule__AdditiveExpressionPart__OpAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3152:1: ( ( rule__AdditiveExpressionPart__OpAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3153:1: ( rule__AdditiveExpressionPart__OpAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionPartAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3154:1: ( rule__AdditiveExpressionPart__OpAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3154:2: rule__AdditiveExpressionPart__OpAssignment_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpressionPart__OpAssignment_0_in_rule__AdditiveExpressionPart__Group__0__Impl6534);
            rule__AdditiveExpressionPart__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionPartAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpressionPart__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3164:1: rule__AdditiveExpressionPart__Group__1 : rule__AdditiveExpressionPart__Group__1__Impl ;
    public final void rule__AdditiveExpressionPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3168:1: ( rule__AdditiveExpressionPart__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3169:2: rule__AdditiveExpressionPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpressionPart__Group__1__Impl_in_rule__AdditiveExpressionPart__Group__16564);
            rule__AdditiveExpressionPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__Group__1"


    // $ANTLR start "rule__AdditiveExpressionPart__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3175:1: rule__AdditiveExpressionPart__Group__1__Impl : ( ( rule__AdditiveExpressionPart__ExAssignment_1 ) ) ;
    public final void rule__AdditiveExpressionPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3179:1: ( ( ( rule__AdditiveExpressionPart__ExAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3180:1: ( ( rule__AdditiveExpressionPart__ExAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3180:1: ( ( rule__AdditiveExpressionPart__ExAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3181:1: ( rule__AdditiveExpressionPart__ExAssignment_1 )
            {
             before(grammarAccess.getAdditiveExpressionPartAccess().getExAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3182:1: ( rule__AdditiveExpressionPart__ExAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3182:2: rule__AdditiveExpressionPart__ExAssignment_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpressionPart__ExAssignment_1_in_rule__AdditiveExpressionPart__Group__1__Impl6591);
            rule__AdditiveExpressionPart__ExAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAdditiveExpressionPartAccess().getExAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3196:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3200:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3201:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__06625);
            rule__MultiplicativeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__06628);
            rule__MultiplicativeExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3208:1: rule__MultiplicativeExpression__Group__0__Impl : ( ( rule__MultiplicativeExpression__LeftAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3212:1: ( ( ( rule__MultiplicativeExpression__LeftAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3213:1: ( ( rule__MultiplicativeExpression__LeftAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3213:1: ( ( rule__MultiplicativeExpression__LeftAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3214:1: ( rule__MultiplicativeExpression__LeftAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getLeftAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3215:1: ( rule__MultiplicativeExpression__LeftAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3215:2: rule__MultiplicativeExpression__LeftAssignment_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__LeftAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl6655);
            rule__MultiplicativeExpression__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3225:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3229:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3230:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__16685);
            rule__MultiplicativeExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3236:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__RightAssignment_1 )? ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3240:1: ( ( ( rule__MultiplicativeExpression__RightAssignment_1 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3241:1: ( ( rule__MultiplicativeExpression__RightAssignment_1 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3241:1: ( ( rule__MultiplicativeExpression__RightAssignment_1 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3242:1: ( rule__MultiplicativeExpression__RightAssignment_1 )?
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3243:1: ( rule__MultiplicativeExpression__RightAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=25 && LA27_0<=26)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3243:2: rule__MultiplicativeExpression__RightAssignment_1
                    {
                    pushFollow(FOLLOW_rule__MultiplicativeExpression__RightAssignment_1_in_rule__MultiplicativeExpression__Group__1__Impl6712);
                    rule__MultiplicativeExpression__RightAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpressionPart__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3257:1: rule__MultiplicativeExpressionPart__Group__0 : rule__MultiplicativeExpressionPart__Group__0__Impl rule__MultiplicativeExpressionPart__Group__1 ;
    public final void rule__MultiplicativeExpressionPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3261:1: ( rule__MultiplicativeExpressionPart__Group__0__Impl rule__MultiplicativeExpressionPart__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3262:2: rule__MultiplicativeExpressionPart__Group__0__Impl rule__MultiplicativeExpressionPart__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__Group__0__Impl_in_rule__MultiplicativeExpressionPart__Group__06747);
            rule__MultiplicativeExpressionPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__Group__1_in_rule__MultiplicativeExpressionPart__Group__06750);
            rule__MultiplicativeExpressionPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__Group__0"


    // $ANTLR start "rule__MultiplicativeExpressionPart__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3269:1: rule__MultiplicativeExpressionPart__Group__0__Impl : ( ( rule__MultiplicativeExpressionPart__OpAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpressionPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3273:1: ( ( ( rule__MultiplicativeExpressionPart__OpAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3274:1: ( ( rule__MultiplicativeExpressionPart__OpAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3274:1: ( ( rule__MultiplicativeExpressionPart__OpAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3275:1: ( rule__MultiplicativeExpressionPart__OpAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionPartAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3276:1: ( rule__MultiplicativeExpressionPart__OpAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3276:2: rule__MultiplicativeExpressionPart__OpAssignment_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__OpAssignment_0_in_rule__MultiplicativeExpressionPart__Group__0__Impl6777);
            rule__MultiplicativeExpressionPart__OpAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionPartAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpressionPart__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3286:1: rule__MultiplicativeExpressionPart__Group__1 : rule__MultiplicativeExpressionPart__Group__1__Impl ;
    public final void rule__MultiplicativeExpressionPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3290:1: ( rule__MultiplicativeExpressionPart__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3291:2: rule__MultiplicativeExpressionPart__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__Group__1__Impl_in_rule__MultiplicativeExpressionPart__Group__16807);
            rule__MultiplicativeExpressionPart__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__Group__1"


    // $ANTLR start "rule__MultiplicativeExpressionPart__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3297:1: rule__MultiplicativeExpressionPart__Group__1__Impl : ( ( rule__MultiplicativeExpressionPart__ExprAssignment_1 ) ) ;
    public final void rule__MultiplicativeExpressionPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3301:1: ( ( ( rule__MultiplicativeExpressionPart__ExprAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3302:1: ( ( rule__MultiplicativeExpressionPart__ExprAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3302:1: ( ( rule__MultiplicativeExpressionPart__ExprAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3303:1: ( rule__MultiplicativeExpressionPart__ExprAssignment_1 )
            {
             before(grammarAccess.getMultiplicativeExpressionPartAccess().getExprAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3304:1: ( rule__MultiplicativeExpressionPart__ExprAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3304:2: rule__MultiplicativeExpressionPart__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpressionPart__ExprAssignment_1_in_rule__MultiplicativeExpressionPart__Group__1__Impl6834);
            rule__MultiplicativeExpressionPart__ExprAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionPartAccess().getExprAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__Group__1__Impl"


    // $ANTLR start "rule__UnaryExpression__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3318:1: rule__UnaryExpression__Group__0 : rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1 ;
    public final void rule__UnaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3322:1: ( rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3323:2: rule__UnaryExpression__Group__0__Impl rule__UnaryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group__0__Impl_in_rule__UnaryExpression__Group__06868);
            rule__UnaryExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UnaryExpression__Group__1_in_rule__UnaryExpression__Group__06871);
            rule__UnaryExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__0"


    // $ANTLR start "rule__UnaryExpression__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3330:1: rule__UnaryExpression__Group__0__Impl : ( ( rule__UnaryExpression__OpAssignment_0 )? ) ;
    public final void rule__UnaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3334:1: ( ( ( rule__UnaryExpression__OpAssignment_0 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3335:1: ( ( rule__UnaryExpression__OpAssignment_0 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3335:1: ( ( rule__UnaryExpression__OpAssignment_0 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3336:1: ( rule__UnaryExpression__OpAssignment_0 )?
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3337:1: ( rule__UnaryExpression__OpAssignment_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==24||(LA28_0>=27 && LA28_0<=28)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3337:2: rule__UnaryExpression__OpAssignment_0
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__OpAssignment_0_in_rule__UnaryExpression__Group__0__Impl6898);
                    rule__UnaryExpression__OpAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__0__Impl"


    // $ANTLR start "rule__UnaryExpression__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3347:1: rule__UnaryExpression__Group__1 : rule__UnaryExpression__Group__1__Impl ;
    public final void rule__UnaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3351:1: ( rule__UnaryExpression__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3352:2: rule__UnaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group__1__Impl_in_rule__UnaryExpression__Group__16929);
            rule__UnaryExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__1"


    // $ANTLR start "rule__UnaryExpression__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3358:1: rule__UnaryExpression__Group__1__Impl : ( ( rule__UnaryExpression__ExprAssignment_1 ) ) ;
    public final void rule__UnaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3362:1: ( ( ( rule__UnaryExpression__ExprAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3363:1: ( ( rule__UnaryExpression__ExprAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3363:1: ( ( rule__UnaryExpression__ExprAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3364:1: ( rule__UnaryExpression__ExprAssignment_1 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3365:1: ( rule__UnaryExpression__ExprAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3365:2: rule__UnaryExpression__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__ExprAssignment_1_in_rule__UnaryExpression__Group__1__Impl6956);
            rule__UnaryExpression__ExprAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group__1__Impl"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3379:1: rule__ExpressionOrQualifiedExecution__Group__0 : rule__ExpressionOrQualifiedExecution__Group__0__Impl rule__ExpressionOrQualifiedExecution__Group__1 ;
    public final void rule__ExpressionOrQualifiedExecution__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3383:1: ( rule__ExpressionOrQualifiedExecution__Group__0__Impl rule__ExpressionOrQualifiedExecution__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3384:2: rule__ExpressionOrQualifiedExecution__Group__0__Impl rule__ExpressionOrQualifiedExecution__Group__1
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group__0__Impl_in_rule__ExpressionOrQualifiedExecution__Group__06990);
            rule__ExpressionOrQualifiedExecution__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group__1_in_rule__ExpressionOrQualifiedExecution__Group__06993);
            rule__ExpressionOrQualifiedExecution__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group__0"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3391:1: rule__ExpressionOrQualifiedExecution__Group__0__Impl : ( ( rule__ExpressionOrQualifiedExecution__Alternatives_0 ) ) ;
    public final void rule__ExpressionOrQualifiedExecution__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3395:1: ( ( ( rule__ExpressionOrQualifiedExecution__Alternatives_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3396:1: ( ( rule__ExpressionOrQualifiedExecution__Alternatives_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3396:1: ( ( rule__ExpressionOrQualifiedExecution__Alternatives_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3397:1: ( rule__ExpressionOrQualifiedExecution__Alternatives_0 )
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getAlternatives_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3398:1: ( rule__ExpressionOrQualifiedExecution__Alternatives_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3398:2: rule__ExpressionOrQualifiedExecution__Alternatives_0
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Alternatives_0_in_rule__ExpressionOrQualifiedExecution__Group__0__Impl7020);
            rule__ExpressionOrQualifiedExecution__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group__0__Impl"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3408:1: rule__ExpressionOrQualifiedExecution__Group__1 : rule__ExpressionOrQualifiedExecution__Group__1__Impl ;
    public final void rule__ExpressionOrQualifiedExecution__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3412:1: ( rule__ExpressionOrQualifiedExecution__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3413:2: rule__ExpressionOrQualifiedExecution__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group__1__Impl_in_rule__ExpressionOrQualifiedExecution__Group__17050);
            rule__ExpressionOrQualifiedExecution__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group__1"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3419:1: rule__ExpressionOrQualifiedExecution__Group__1__Impl : ( ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )* ) ;
    public final void rule__ExpressionOrQualifiedExecution__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3423:1: ( ( ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3424:1: ( ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3424:1: ( ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3425:1: ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )*
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3426:1: ( rule__ExpressionOrQualifiedExecution__CallsAssignment_1 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==40||LA29_0==42) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3426:2: rule__ExpressionOrQualifiedExecution__CallsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__CallsAssignment_1_in_rule__ExpressionOrQualifiedExecution__Group__1__Impl7077);
            	    rule__ExpressionOrQualifiedExecution__CallsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group__1__Impl"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3440:1: rule__ExpressionOrQualifiedExecution__Group_0_1__0 : rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__1 ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3444:1: ( rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3445:2: rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__07112);
            rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__1_in_rule__ExpressionOrQualifiedExecution__Group_0_1__07115);
            rule__ExpressionOrQualifiedExecution__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__0"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3452:1: rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl : ( '(' ) ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3456:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3457:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3457:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3458:1: '('
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0()); 
            match(input,32,FOLLOW_32_in_rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl7143); 
             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3471:1: rule__ExpressionOrQualifiedExecution__Group_0_1__1 : rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__2 ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3475:1: ( rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3476:2: rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl rule__ExpressionOrQualifiedExecution__Group_0_1__2
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__17174);
            rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__2_in_rule__ExpressionOrQualifiedExecution__Group_0_1__17177);
            rule__ExpressionOrQualifiedExecution__Group_0_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__1"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3483:1: rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl : ( ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 ) ) ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3487:1: ( ( ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3488:1: ( ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3488:1: ( ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3489:1: ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 )
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisAssignment_0_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3490:1: ( rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3490:2: rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1_in_rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl7204);
            rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3500:1: rule__ExpressionOrQualifiedExecution__Group_0_1__2 : rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3504:1: ( rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3505:2: rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__27234);
            rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__2"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3511:1: rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl : ( ')' ) ;
    public final void rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3515:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3516:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3516:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3517:1: ')'
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2()); 
            match(input,33,FOLLOW_33_in_rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl7262); 
             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl"


    // $ANTLR start "rule__UnqualifiedExecution__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3536:1: rule__UnqualifiedExecution__Group__0 : rule__UnqualifiedExecution__Group__0__Impl rule__UnqualifiedExecution__Group__1 ;
    public final void rule__UnqualifiedExecution__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3540:1: ( rule__UnqualifiedExecution__Group__0__Impl rule__UnqualifiedExecution__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3541:2: rule__UnqualifiedExecution__Group__0__Impl rule__UnqualifiedExecution__Group__1
            {
            pushFollow(FOLLOW_rule__UnqualifiedExecution__Group__0__Impl_in_rule__UnqualifiedExecution__Group__07299);
            rule__UnqualifiedExecution__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UnqualifiedExecution__Group__1_in_rule__UnqualifiedExecution__Group__07302);
            rule__UnqualifiedExecution__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__Group__0"


    // $ANTLR start "rule__UnqualifiedExecution__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3548:1: rule__UnqualifiedExecution__Group__0__Impl : ( ( rule__UnqualifiedExecution__CallAssignment_0 ) ) ;
    public final void rule__UnqualifiedExecution__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3552:1: ( ( ( rule__UnqualifiedExecution__CallAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3553:1: ( ( rule__UnqualifiedExecution__CallAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3553:1: ( ( rule__UnqualifiedExecution__CallAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3554:1: ( rule__UnqualifiedExecution__CallAssignment_0 )
            {
             before(grammarAccess.getUnqualifiedExecutionAccess().getCallAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3555:1: ( rule__UnqualifiedExecution__CallAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3555:2: rule__UnqualifiedExecution__CallAssignment_0
            {
            pushFollow(FOLLOW_rule__UnqualifiedExecution__CallAssignment_0_in_rule__UnqualifiedExecution__Group__0__Impl7329);
            rule__UnqualifiedExecution__CallAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getUnqualifiedExecutionAccess().getCallAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__Group__0__Impl"


    // $ANTLR start "rule__UnqualifiedExecution__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3565:1: rule__UnqualifiedExecution__Group__1 : rule__UnqualifiedExecution__Group__1__Impl ;
    public final void rule__UnqualifiedExecution__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3569:1: ( rule__UnqualifiedExecution__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3570:2: rule__UnqualifiedExecution__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UnqualifiedExecution__Group__1__Impl_in_rule__UnqualifiedExecution__Group__17359);
            rule__UnqualifiedExecution__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__Group__1"


    // $ANTLR start "rule__UnqualifiedExecution__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3576:1: rule__UnqualifiedExecution__Group__1__Impl : ( ( rule__UnqualifiedExecution__CallsAssignment_1 )* ) ;
    public final void rule__UnqualifiedExecution__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3580:1: ( ( ( rule__UnqualifiedExecution__CallsAssignment_1 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3581:1: ( ( rule__UnqualifiedExecution__CallsAssignment_1 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3581:1: ( ( rule__UnqualifiedExecution__CallsAssignment_1 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3582:1: ( rule__UnqualifiedExecution__CallsAssignment_1 )*
            {
             before(grammarAccess.getUnqualifiedExecutionAccess().getCallsAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3583:1: ( rule__UnqualifiedExecution__CallsAssignment_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==40||LA30_0==42) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3583:2: rule__UnqualifiedExecution__CallsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__UnqualifiedExecution__CallsAssignment_1_in_rule__UnqualifiedExecution__Group__1__Impl7386);
            	    rule__UnqualifiedExecution__CallsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getUnqualifiedExecutionAccess().getCallsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__Group__1__Impl"


    // $ANTLR start "rule__SuperExecution__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3597:1: rule__SuperExecution__Group__0 : rule__SuperExecution__Group__0__Impl rule__SuperExecution__Group__1 ;
    public final void rule__SuperExecution__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3601:1: ( rule__SuperExecution__Group__0__Impl rule__SuperExecution__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3602:2: rule__SuperExecution__Group__0__Impl rule__SuperExecution__Group__1
            {
            pushFollow(FOLLOW_rule__SuperExecution__Group__0__Impl_in_rule__SuperExecution__Group__07421);
            rule__SuperExecution__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuperExecution__Group__1_in_rule__SuperExecution__Group__07424);
            rule__SuperExecution__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__0"


    // $ANTLR start "rule__SuperExecution__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3609:1: rule__SuperExecution__Group__0__Impl : ( 'super' ) ;
    public final void rule__SuperExecution__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3613:1: ( ( 'super' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3614:1: ( 'super' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3614:1: ( 'super' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3615:1: 'super'
            {
             before(grammarAccess.getSuperExecutionAccess().getSuperKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__SuperExecution__Group__0__Impl7452); 
             after(grammarAccess.getSuperExecutionAccess().getSuperKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__0__Impl"


    // $ANTLR start "rule__SuperExecution__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3628:1: rule__SuperExecution__Group__1 : rule__SuperExecution__Group__1__Impl rule__SuperExecution__Group__2 ;
    public final void rule__SuperExecution__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3632:1: ( rule__SuperExecution__Group__1__Impl rule__SuperExecution__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3633:2: rule__SuperExecution__Group__1__Impl rule__SuperExecution__Group__2
            {
            pushFollow(FOLLOW_rule__SuperExecution__Group__1__Impl_in_rule__SuperExecution__Group__17483);
            rule__SuperExecution__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuperExecution__Group__2_in_rule__SuperExecution__Group__17486);
            rule__SuperExecution__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__1"


    // $ANTLR start "rule__SuperExecution__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3640:1: rule__SuperExecution__Group__1__Impl : ( '.' ) ;
    public final void rule__SuperExecution__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3644:1: ( ( '.' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3645:1: ( '.' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3645:1: ( '.' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3646:1: '.'
            {
             before(grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__SuperExecution__Group__1__Impl7514); 
             after(grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__1__Impl"


    // $ANTLR start "rule__SuperExecution__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3659:1: rule__SuperExecution__Group__2 : rule__SuperExecution__Group__2__Impl rule__SuperExecution__Group__3 ;
    public final void rule__SuperExecution__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3663:1: ( rule__SuperExecution__Group__2__Impl rule__SuperExecution__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3664:2: rule__SuperExecution__Group__2__Impl rule__SuperExecution__Group__3
            {
            pushFollow(FOLLOW_rule__SuperExecution__Group__2__Impl_in_rule__SuperExecution__Group__27545);
            rule__SuperExecution__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuperExecution__Group__3_in_rule__SuperExecution__Group__27548);
            rule__SuperExecution__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__2"


    // $ANTLR start "rule__SuperExecution__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3671:1: rule__SuperExecution__Group__2__Impl : ( ( rule__SuperExecution__CallAssignment_2 ) ) ;
    public final void rule__SuperExecution__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3675:1: ( ( ( rule__SuperExecution__CallAssignment_2 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3676:1: ( ( rule__SuperExecution__CallAssignment_2 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3676:1: ( ( rule__SuperExecution__CallAssignment_2 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3677:1: ( rule__SuperExecution__CallAssignment_2 )
            {
             before(grammarAccess.getSuperExecutionAccess().getCallAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3678:1: ( rule__SuperExecution__CallAssignment_2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3678:2: rule__SuperExecution__CallAssignment_2
            {
            pushFollow(FOLLOW_rule__SuperExecution__CallAssignment_2_in_rule__SuperExecution__Group__2__Impl7575);
            rule__SuperExecution__CallAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSuperExecutionAccess().getCallAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__2__Impl"


    // $ANTLR start "rule__SuperExecution__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3688:1: rule__SuperExecution__Group__3 : rule__SuperExecution__Group__3__Impl ;
    public final void rule__SuperExecution__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3692:1: ( rule__SuperExecution__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3693:2: rule__SuperExecution__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__SuperExecution__Group__3__Impl_in_rule__SuperExecution__Group__37605);
            rule__SuperExecution__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__3"


    // $ANTLR start "rule__SuperExecution__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3699:1: rule__SuperExecution__Group__3__Impl : ( ( rule__SuperExecution__CallsAssignment_3 )* ) ;
    public final void rule__SuperExecution__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3703:1: ( ( ( rule__SuperExecution__CallsAssignment_3 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3704:1: ( ( rule__SuperExecution__CallsAssignment_3 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3704:1: ( ( rule__SuperExecution__CallsAssignment_3 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3705:1: ( rule__SuperExecution__CallsAssignment_3 )*
            {
             before(grammarAccess.getSuperExecutionAccess().getCallsAssignment_3()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3706:1: ( rule__SuperExecution__CallsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==40||LA31_0==42) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3706:2: rule__SuperExecution__CallsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__SuperExecution__CallsAssignment_3_in_rule__SuperExecution__Group__3__Impl7632);
            	    rule__SuperExecution__CallsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getSuperExecutionAccess().getCallsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__Group__3__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3724:1: rule__ConstructorExecution__Group__0 : rule__ConstructorExecution__Group__0__Impl rule__ConstructorExecution__Group__1 ;
    public final void rule__ConstructorExecution__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3728:1: ( rule__ConstructorExecution__Group__0__Impl rule__ConstructorExecution__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3729:2: rule__ConstructorExecution__Group__0__Impl rule__ConstructorExecution__Group__1
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__0__Impl_in_rule__ConstructorExecution__Group__07671);
            rule__ConstructorExecution__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstructorExecution__Group__1_in_rule__ConstructorExecution__Group__07674);
            rule__ConstructorExecution__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__0"


    // $ANTLR start "rule__ConstructorExecution__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3736:1: rule__ConstructorExecution__Group__0__Impl : ( 'new' ) ;
    public final void rule__ConstructorExecution__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3740:1: ( ( 'new' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3741:1: ( 'new' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3741:1: ( 'new' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3742:1: 'new'
            {
             before(grammarAccess.getConstructorExecutionAccess().getNewKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__ConstructorExecution__Group__0__Impl7702); 
             after(grammarAccess.getConstructorExecutionAccess().getNewKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__0__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3755:1: rule__ConstructorExecution__Group__1 : rule__ConstructorExecution__Group__1__Impl rule__ConstructorExecution__Group__2 ;
    public final void rule__ConstructorExecution__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3759:1: ( rule__ConstructorExecution__Group__1__Impl rule__ConstructorExecution__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3760:2: rule__ConstructorExecution__Group__1__Impl rule__ConstructorExecution__Group__2
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__1__Impl_in_rule__ConstructorExecution__Group__17733);
            rule__ConstructorExecution__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstructorExecution__Group__2_in_rule__ConstructorExecution__Group__17736);
            rule__ConstructorExecution__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__1"


    // $ANTLR start "rule__ConstructorExecution__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3767:1: rule__ConstructorExecution__Group__1__Impl : ( ( rule__ConstructorExecution__TypeAssignment_1 ) ) ;
    public final void rule__ConstructorExecution__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3771:1: ( ( ( rule__ConstructorExecution__TypeAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3772:1: ( ( rule__ConstructorExecution__TypeAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3772:1: ( ( rule__ConstructorExecution__TypeAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3773:1: ( rule__ConstructorExecution__TypeAssignment_1 )
            {
             before(grammarAccess.getConstructorExecutionAccess().getTypeAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3774:1: ( rule__ConstructorExecution__TypeAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3774:2: rule__ConstructorExecution__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__TypeAssignment_1_in_rule__ConstructorExecution__Group__1__Impl7763);
            rule__ConstructorExecution__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstructorExecutionAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__1__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3784:1: rule__ConstructorExecution__Group__2 : rule__ConstructorExecution__Group__2__Impl rule__ConstructorExecution__Group__3 ;
    public final void rule__ConstructorExecution__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3788:1: ( rule__ConstructorExecution__Group__2__Impl rule__ConstructorExecution__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3789:2: rule__ConstructorExecution__Group__2__Impl rule__ConstructorExecution__Group__3
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__2__Impl_in_rule__ConstructorExecution__Group__27793);
            rule__ConstructorExecution__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstructorExecution__Group__3_in_rule__ConstructorExecution__Group__27796);
            rule__ConstructorExecution__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__2"


    // $ANTLR start "rule__ConstructorExecution__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3796:1: rule__ConstructorExecution__Group__2__Impl : ( '(' ) ;
    public final void rule__ConstructorExecution__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3800:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3801:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3801:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3802:1: '('
            {
             before(grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ConstructorExecution__Group__2__Impl7824); 
             after(grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__2__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3815:1: rule__ConstructorExecution__Group__3 : rule__ConstructorExecution__Group__3__Impl rule__ConstructorExecution__Group__4 ;
    public final void rule__ConstructorExecution__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3819:1: ( rule__ConstructorExecution__Group__3__Impl rule__ConstructorExecution__Group__4 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3820:2: rule__ConstructorExecution__Group__3__Impl rule__ConstructorExecution__Group__4
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__3__Impl_in_rule__ConstructorExecution__Group__37855);
            rule__ConstructorExecution__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstructorExecution__Group__4_in_rule__ConstructorExecution__Group__37858);
            rule__ConstructorExecution__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__3"


    // $ANTLR start "rule__ConstructorExecution__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3827:1: rule__ConstructorExecution__Group__3__Impl : ( ( rule__ConstructorExecution__ParamAssignment_3 )? ) ;
    public final void rule__ConstructorExecution__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3831:1: ( ( ( rule__ConstructorExecution__ParamAssignment_3 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3832:1: ( ( rule__ConstructorExecution__ParamAssignment_3 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3832:1: ( ( rule__ConstructorExecution__ParamAssignment_3 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3833:1: ( rule__ConstructorExecution__ParamAssignment_3 )?
            {
             before(grammarAccess.getConstructorExecutionAccess().getParamAssignment_3()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3834:1: ( rule__ConstructorExecution__ParamAssignment_3 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_NUMBER)||LA32_0==24||(LA32_0>=27 && LA32_0<=30)||LA32_0==32||LA32_0==39||LA32_0==41||LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3834:2: rule__ConstructorExecution__ParamAssignment_3
                    {
                    pushFollow(FOLLOW_rule__ConstructorExecution__ParamAssignment_3_in_rule__ConstructorExecution__Group__3__Impl7885);
                    rule__ConstructorExecution__ParamAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstructorExecutionAccess().getParamAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__3__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__4"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3844:1: rule__ConstructorExecution__Group__4 : rule__ConstructorExecution__Group__4__Impl rule__ConstructorExecution__Group__5 ;
    public final void rule__ConstructorExecution__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3848:1: ( rule__ConstructorExecution__Group__4__Impl rule__ConstructorExecution__Group__5 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3849:2: rule__ConstructorExecution__Group__4__Impl rule__ConstructorExecution__Group__5
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__4__Impl_in_rule__ConstructorExecution__Group__47916);
            rule__ConstructorExecution__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstructorExecution__Group__5_in_rule__ConstructorExecution__Group__47919);
            rule__ConstructorExecution__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__4"


    // $ANTLR start "rule__ConstructorExecution__Group__4__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3856:1: rule__ConstructorExecution__Group__4__Impl : ( ')' ) ;
    public final void rule__ConstructorExecution__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3860:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3861:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3861:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3862:1: ')'
            {
             before(grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4()); 
            match(input,33,FOLLOW_33_in_rule__ConstructorExecution__Group__4__Impl7947); 
             after(grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__4__Impl"


    // $ANTLR start "rule__ConstructorExecution__Group__5"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3875:1: rule__ConstructorExecution__Group__5 : rule__ConstructorExecution__Group__5__Impl ;
    public final void rule__ConstructorExecution__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3879:1: ( rule__ConstructorExecution__Group__5__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3880:2: rule__ConstructorExecution__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ConstructorExecution__Group__5__Impl_in_rule__ConstructorExecution__Group__57978);
            rule__ConstructorExecution__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__5"


    // $ANTLR start "rule__ConstructorExecution__Group__5__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3886:1: rule__ConstructorExecution__Group__5__Impl : ( ( rule__ConstructorExecution__CallsAssignment_5 )* ) ;
    public final void rule__ConstructorExecution__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3890:1: ( ( ( rule__ConstructorExecution__CallsAssignment_5 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3891:1: ( ( rule__ConstructorExecution__CallsAssignment_5 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3891:1: ( ( rule__ConstructorExecution__CallsAssignment_5 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3892:1: ( rule__ConstructorExecution__CallsAssignment_5 )*
            {
             before(grammarAccess.getConstructorExecutionAccess().getCallsAssignment_5()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3893:1: ( rule__ConstructorExecution__CallsAssignment_5 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==40||LA33_0==42) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3893:2: rule__ConstructorExecution__CallsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__ConstructorExecution__CallsAssignment_5_in_rule__ConstructorExecution__Group__5__Impl8005);
            	    rule__ConstructorExecution__CallsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getConstructorExecutionAccess().getCallsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__Group__5__Impl"


    // $ANTLR start "rule__SubCall__Group_0__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3915:1: rule__SubCall__Group_0__0 : rule__SubCall__Group_0__0__Impl rule__SubCall__Group_0__1 ;
    public final void rule__SubCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3919:1: ( rule__SubCall__Group_0__0__Impl rule__SubCall__Group_0__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3920:2: rule__SubCall__Group_0__0__Impl rule__SubCall__Group_0__1
            {
            pushFollow(FOLLOW_rule__SubCall__Group_0__0__Impl_in_rule__SubCall__Group_0__08048);
            rule__SubCall__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubCall__Group_0__1_in_rule__SubCall__Group_0__08051);
            rule__SubCall__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_0__0"


    // $ANTLR start "rule__SubCall__Group_0__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3927:1: rule__SubCall__Group_0__0__Impl : ( '.' ) ;
    public final void rule__SubCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3931:1: ( ( '.' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3932:1: ( '.' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3932:1: ( '.' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3933:1: '.'
            {
             before(grammarAccess.getSubCallAccess().getFullStopKeyword_0_0()); 
            match(input,40,FOLLOW_40_in_rule__SubCall__Group_0__0__Impl8079); 
             after(grammarAccess.getSubCallAccess().getFullStopKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_0__0__Impl"


    // $ANTLR start "rule__SubCall__Group_0__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3946:1: rule__SubCall__Group_0__1 : rule__SubCall__Group_0__1__Impl ;
    public final void rule__SubCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3950:1: ( rule__SubCall__Group_0__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3951:2: rule__SubCall__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__SubCall__Group_0__1__Impl_in_rule__SubCall__Group_0__18110);
            rule__SubCall__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_0__1"


    // $ANTLR start "rule__SubCall__Group_0__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3957:1: rule__SubCall__Group_0__1__Impl : ( ( rule__SubCall__CallAssignment_0_1 ) ) ;
    public final void rule__SubCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3961:1: ( ( ( rule__SubCall__CallAssignment_0_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3962:1: ( ( rule__SubCall__CallAssignment_0_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3962:1: ( ( rule__SubCall__CallAssignment_0_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3963:1: ( rule__SubCall__CallAssignment_0_1 )
            {
             before(grammarAccess.getSubCallAccess().getCallAssignment_0_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3964:1: ( rule__SubCall__CallAssignment_0_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3964:2: rule__SubCall__CallAssignment_0_1
            {
            pushFollow(FOLLOW_rule__SubCall__CallAssignment_0_1_in_rule__SubCall__Group_0__1__Impl8137);
            rule__SubCall__CallAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSubCallAccess().getCallAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_0__1__Impl"


    // $ANTLR start "rule__SubCall__Group_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3978:1: rule__SubCall__Group_1__0 : rule__SubCall__Group_1__0__Impl rule__SubCall__Group_1__1 ;
    public final void rule__SubCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3982:1: ( rule__SubCall__Group_1__0__Impl rule__SubCall__Group_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3983:2: rule__SubCall__Group_1__0__Impl rule__SubCall__Group_1__1
            {
            pushFollow(FOLLOW_rule__SubCall__Group_1__0__Impl_in_rule__SubCall__Group_1__08171);
            rule__SubCall__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubCall__Group_1__1_in_rule__SubCall__Group_1__08174);
            rule__SubCall__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__0"


    // $ANTLR start "rule__SubCall__Group_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3990:1: rule__SubCall__Group_1__0__Impl : ( '[' ) ;
    public final void rule__SubCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3994:1: ( ( '[' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3995:1: ( '[' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3995:1: ( '[' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:3996:1: '['
            {
             before(grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,42,FOLLOW_42_in_rule__SubCall__Group_1__0__Impl8202); 
             after(grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__0__Impl"


    // $ANTLR start "rule__SubCall__Group_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4009:1: rule__SubCall__Group_1__1 : rule__SubCall__Group_1__1__Impl rule__SubCall__Group_1__2 ;
    public final void rule__SubCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4013:1: ( rule__SubCall__Group_1__1__Impl rule__SubCall__Group_1__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4014:2: rule__SubCall__Group_1__1__Impl rule__SubCall__Group_1__2
            {
            pushFollow(FOLLOW_rule__SubCall__Group_1__1__Impl_in_rule__SubCall__Group_1__18233);
            rule__SubCall__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubCall__Group_1__2_in_rule__SubCall__Group_1__18236);
            rule__SubCall__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__1"


    // $ANTLR start "rule__SubCall__Group_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4021:1: rule__SubCall__Group_1__1__Impl : ( ( rule__SubCall__ArrayExAssignment_1_1 ) ) ;
    public final void rule__SubCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4025:1: ( ( ( rule__SubCall__ArrayExAssignment_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4026:1: ( ( rule__SubCall__ArrayExAssignment_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4026:1: ( ( rule__SubCall__ArrayExAssignment_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4027:1: ( rule__SubCall__ArrayExAssignment_1_1 )
            {
             before(grammarAccess.getSubCallAccess().getArrayExAssignment_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4028:1: ( rule__SubCall__ArrayExAssignment_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4028:2: rule__SubCall__ArrayExAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SubCall__ArrayExAssignment_1_1_in_rule__SubCall__Group_1__1__Impl8263);
            rule__SubCall__ArrayExAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSubCallAccess().getArrayExAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__1__Impl"


    // $ANTLR start "rule__SubCall__Group_1__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4038:1: rule__SubCall__Group_1__2 : rule__SubCall__Group_1__2__Impl ;
    public final void rule__SubCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4042:1: ( rule__SubCall__Group_1__2__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4043:2: rule__SubCall__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__SubCall__Group_1__2__Impl_in_rule__SubCall__Group_1__28293);
            rule__SubCall__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__2"


    // $ANTLR start "rule__SubCall__Group_1__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4049:1: rule__SubCall__Group_1__2__Impl : ( ']' ) ;
    public final void rule__SubCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4053:1: ( ( ']' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4054:1: ( ']' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4054:1: ( ']' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4055:1: ']'
            {
             before(grammarAccess.getSubCallAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,43,FOLLOW_43_in_rule__SubCall__Group_1__2__Impl8321); 
             after(grammarAccess.getSubCallAccess().getRightSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__Group_1__2__Impl"


    // $ANTLR start "rule__Call__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4074:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4078:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4079:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08358);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08361);
            rule__Call__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__0"


    // $ANTLR start "rule__Call__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4086:1: rule__Call__Group__0__Impl : ( ( rule__Call__NameAssignment_0 ) ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4090:1: ( ( ( rule__Call__NameAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4091:1: ( ( rule__Call__NameAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4091:1: ( ( rule__Call__NameAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4092:1: ( rule__Call__NameAssignment_0 )
            {
             before(grammarAccess.getCallAccess().getNameAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4093:1: ( rule__Call__NameAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4093:2: rule__Call__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Call__NameAssignment_0_in_rule__Call__Group__0__Impl8388);
            rule__Call__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__0__Impl"


    // $ANTLR start "rule__Call__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4103:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4107:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4108:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18418);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18421);
            rule__Call__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__1"


    // $ANTLR start "rule__Call__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4115:1: rule__Call__Group__1__Impl : ( '(' ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4119:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4120:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4120:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4121:1: '('
            {
             before(grammarAccess.getCallAccess().getLeftParenthesisKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__Call__Group__1__Impl8449); 
             after(grammarAccess.getCallAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__1__Impl"


    // $ANTLR start "rule__Call__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4134:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4138:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4139:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28480);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28483);
            rule__Call__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__2"


    // $ANTLR start "rule__Call__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4146:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParamAssignment_2 )? ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4150:1: ( ( ( rule__Call__ParamAssignment_2 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4151:1: ( ( rule__Call__ParamAssignment_2 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4151:1: ( ( rule__Call__ParamAssignment_2 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4152:1: ( rule__Call__ParamAssignment_2 )?
            {
             before(grammarAccess.getCallAccess().getParamAssignment_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4153:1: ( rule__Call__ParamAssignment_2 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_NUMBER)||LA34_0==24||(LA34_0>=27 && LA34_0<=30)||LA34_0==32||LA34_0==39||LA34_0==41||LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4153:2: rule__Call__ParamAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Call__ParamAssignment_2_in_rule__Call__Group__2__Impl8510);
                    rule__Call__ParamAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallAccess().getParamAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__2__Impl"


    // $ANTLR start "rule__Call__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4163:1: rule__Call__Group__3 : rule__Call__Group__3__Impl ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4167:1: ( rule__Call__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4168:2: rule__Call__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38541);
            rule__Call__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__3"


    // $ANTLR start "rule__Call__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4174:1: rule__Call__Group__3__Impl : ( ')' ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4178:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4179:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4179:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4180:1: ')'
            {
             before(grammarAccess.getCallAccess().getRightParenthesisKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__Call__Group__3__Impl8569); 
             after(grammarAccess.getCallAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__3__Impl"


    // $ANTLR start "rule__ArgumentList__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4201:1: rule__ArgumentList__Group__0 : rule__ArgumentList__Group__0__Impl rule__ArgumentList__Group__1 ;
    public final void rule__ArgumentList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4205:1: ( rule__ArgumentList__Group__0__Impl rule__ArgumentList__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4206:2: rule__ArgumentList__Group__0__Impl rule__ArgumentList__Group__1
            {
            pushFollow(FOLLOW_rule__ArgumentList__Group__0__Impl_in_rule__ArgumentList__Group__08608);
            rule__ArgumentList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArgumentList__Group__1_in_rule__ArgumentList__Group__08611);
            rule__ArgumentList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group__0"


    // $ANTLR start "rule__ArgumentList__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4213:1: rule__ArgumentList__Group__0__Impl : ( ( rule__ArgumentList__ParamAssignment_0 ) ) ;
    public final void rule__ArgumentList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4217:1: ( ( ( rule__ArgumentList__ParamAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4218:1: ( ( rule__ArgumentList__ParamAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4218:1: ( ( rule__ArgumentList__ParamAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4219:1: ( rule__ArgumentList__ParamAssignment_0 )
            {
             before(grammarAccess.getArgumentListAccess().getParamAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4220:1: ( rule__ArgumentList__ParamAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4220:2: rule__ArgumentList__ParamAssignment_0
            {
            pushFollow(FOLLOW_rule__ArgumentList__ParamAssignment_0_in_rule__ArgumentList__Group__0__Impl8638);
            rule__ArgumentList__ParamAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArgumentListAccess().getParamAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group__0__Impl"


    // $ANTLR start "rule__ArgumentList__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4230:1: rule__ArgumentList__Group__1 : rule__ArgumentList__Group__1__Impl ;
    public final void rule__ArgumentList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4234:1: ( rule__ArgumentList__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4235:2: rule__ArgumentList__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgumentList__Group__1__Impl_in_rule__ArgumentList__Group__18668);
            rule__ArgumentList__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group__1"


    // $ANTLR start "rule__ArgumentList__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4241:1: rule__ArgumentList__Group__1__Impl : ( ( rule__ArgumentList__Group_1__0 )* ) ;
    public final void rule__ArgumentList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4245:1: ( ( ( rule__ArgumentList__Group_1__0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4246:1: ( ( rule__ArgumentList__Group_1__0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4246:1: ( ( rule__ArgumentList__Group_1__0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4247:1: ( rule__ArgumentList__Group_1__0 )*
            {
             before(grammarAccess.getArgumentListAccess().getGroup_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4248:1: ( rule__ArgumentList__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==35) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4248:2: rule__ArgumentList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ArgumentList__Group_1__0_in_rule__ArgumentList__Group__1__Impl8695);
            	    rule__ArgumentList__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getArgumentListAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group__1__Impl"


    // $ANTLR start "rule__ArgumentList__Group_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4262:1: rule__ArgumentList__Group_1__0 : rule__ArgumentList__Group_1__0__Impl rule__ArgumentList__Group_1__1 ;
    public final void rule__ArgumentList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4266:1: ( rule__ArgumentList__Group_1__0__Impl rule__ArgumentList__Group_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4267:2: rule__ArgumentList__Group_1__0__Impl rule__ArgumentList__Group_1__1
            {
            pushFollow(FOLLOW_rule__ArgumentList__Group_1__0__Impl_in_rule__ArgumentList__Group_1__08730);
            rule__ArgumentList__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArgumentList__Group_1__1_in_rule__ArgumentList__Group_1__08733);
            rule__ArgumentList__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group_1__0"


    // $ANTLR start "rule__ArgumentList__Group_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4274:1: rule__ArgumentList__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4278:1: ( ( ',' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4279:1: ( ',' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4279:1: ( ',' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4280:1: ','
            {
             before(grammarAccess.getArgumentListAccess().getCommaKeyword_1_0()); 
            match(input,35,FOLLOW_35_in_rule__ArgumentList__Group_1__0__Impl8761); 
             after(grammarAccess.getArgumentListAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group_1__0__Impl"


    // $ANTLR start "rule__ArgumentList__Group_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4293:1: rule__ArgumentList__Group_1__1 : rule__ArgumentList__Group_1__1__Impl ;
    public final void rule__ArgumentList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4297:1: ( rule__ArgumentList__Group_1__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4298:2: rule__ArgumentList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgumentList__Group_1__1__Impl_in_rule__ArgumentList__Group_1__18792);
            rule__ArgumentList__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group_1__1"


    // $ANTLR start "rule__ArgumentList__Group_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4304:1: rule__ArgumentList__Group_1__1__Impl : ( ( rule__ArgumentList__ParamAssignment_1_1 ) ) ;
    public final void rule__ArgumentList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4308:1: ( ( ( rule__ArgumentList__ParamAssignment_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4309:1: ( ( rule__ArgumentList__ParamAssignment_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4309:1: ( ( rule__ArgumentList__ParamAssignment_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4310:1: ( rule__ArgumentList__ParamAssignment_1_1 )
            {
             before(grammarAccess.getArgumentListAccess().getParamAssignment_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4311:1: ( rule__ArgumentList__ParamAssignment_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4311:2: rule__ArgumentList__ParamAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ArgumentList__ParamAssignment_1_1_in_rule__ArgumentList__Group_1__1__Impl8819);
            rule__ArgumentList__ParamAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getArgumentListAccess().getParamAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__Group_1__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4325:1: rule__NamedArgument__Group__0 : rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 ;
    public final void rule__NamedArgument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4329:1: ( rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4330:2: rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1
            {
            pushFollow(FOLLOW_rule__NamedArgument__Group__0__Impl_in_rule__NamedArgument__Group__08853);
            rule__NamedArgument__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedArgument__Group__1_in_rule__NamedArgument__Group__08856);
            rule__NamedArgument__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0"


    // $ANTLR start "rule__NamedArgument__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4337:1: rule__NamedArgument__Group__0__Impl : ( ( rule__NamedArgument__Group_0__0 )? ) ;
    public final void rule__NamedArgument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4341:1: ( ( ( rule__NamedArgument__Group_0__0 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4342:1: ( ( rule__NamedArgument__Group_0__0 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4342:1: ( ( rule__NamedArgument__Group_0__0 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4343:1: ( rule__NamedArgument__Group_0__0 )?
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4344:1: ( rule__NamedArgument__Group_0__0 )?
            int alt36=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==44) ) {
                        alt36=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (LA36_2==44) ) {
                        alt36=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (LA36_3==44) ) {
                        alt36=1;
                    }
                    }
                    break;
            }

            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4344:2: rule__NamedArgument__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__NamedArgument__Group_0__0_in_rule__NamedArgument__Group__0__Impl8883);
                    rule__NamedArgument__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNamedArgumentAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4354:1: rule__NamedArgument__Group__1 : rule__NamedArgument__Group__1__Impl ;
    public final void rule__NamedArgument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4358:1: ( rule__NamedArgument__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4359:2: rule__NamedArgument__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NamedArgument__Group__1__Impl_in_rule__NamedArgument__Group__18914);
            rule__NamedArgument__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1"


    // $ANTLR start "rule__NamedArgument__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4365:1: rule__NamedArgument__Group__1__Impl : ( ( rule__NamedArgument__ExAssignment_1 ) ) ;
    public final void rule__NamedArgument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4369:1: ( ( ( rule__NamedArgument__ExAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4370:1: ( ( rule__NamedArgument__ExAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4370:1: ( ( rule__NamedArgument__ExAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4371:1: ( rule__NamedArgument__ExAssignment_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getExAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4372:1: ( rule__NamedArgument__ExAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4372:2: rule__NamedArgument__ExAssignment_1
            {
            pushFollow(FOLLOW_rule__NamedArgument__ExAssignment_1_in_rule__NamedArgument__Group__1__Impl8941);
            rule__NamedArgument__ExAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getExAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4386:1: rule__NamedArgument__Group_0__0 : rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 ;
    public final void rule__NamedArgument__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4390:1: ( rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4391:2: rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1
            {
            pushFollow(FOLLOW_rule__NamedArgument__Group_0__0__Impl_in_rule__NamedArgument__Group_0__08975);
            rule__NamedArgument__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedArgument__Group_0__1_in_rule__NamedArgument__Group_0__08978);
            rule__NamedArgument__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__0"


    // $ANTLR start "rule__NamedArgument__Group_0__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4398:1: rule__NamedArgument__Group_0__0__Impl : ( ( rule__NamedArgument__NameAssignment_0_0 ) ) ;
    public final void rule__NamedArgument__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4402:1: ( ( ( rule__NamedArgument__NameAssignment_0_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4403:1: ( ( rule__NamedArgument__NameAssignment_0_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4403:1: ( ( rule__NamedArgument__NameAssignment_0_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4404:1: ( rule__NamedArgument__NameAssignment_0_0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getNameAssignment_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4405:1: ( rule__NamedArgument__NameAssignment_0_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4405:2: rule__NamedArgument__NameAssignment_0_0
            {
            pushFollow(FOLLOW_rule__NamedArgument__NameAssignment_0_0_in_rule__NamedArgument__Group_0__0__Impl9005);
            rule__NamedArgument__NameAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getNameAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4415:1: rule__NamedArgument__Group_0__1 : rule__NamedArgument__Group_0__1__Impl ;
    public final void rule__NamedArgument__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4419:1: ( rule__NamedArgument__Group_0__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4420:2: rule__NamedArgument__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__NamedArgument__Group_0__1__Impl_in_rule__NamedArgument__Group_0__19035);
            rule__NamedArgument__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__1"


    // $ANTLR start "rule__NamedArgument__Group_0__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4426:1: rule__NamedArgument__Group_0__1__Impl : ( '=' ) ;
    public final void rule__NamedArgument__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4430:1: ( ( '=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4431:1: ( '=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4431:1: ( '=' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4432:1: '='
            {
             before(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1()); 
            match(input,44,FOLLOW_44_in_rule__NamedArgument__Group_0__1__Impl9063); 
             after(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__1__Impl"


    // $ANTLR start "rule__QualifiedPrefix__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4449:1: rule__QualifiedPrefix__Group__0 : rule__QualifiedPrefix__Group__0__Impl rule__QualifiedPrefix__Group__1 ;
    public final void rule__QualifiedPrefix__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4453:1: ( rule__QualifiedPrefix__Group__0__Impl rule__QualifiedPrefix__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4454:2: rule__QualifiedPrefix__Group__0__Impl rule__QualifiedPrefix__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__Group__0__Impl_in_rule__QualifiedPrefix__Group__09098);
            rule__QualifiedPrefix__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedPrefix__Group__1_in_rule__QualifiedPrefix__Group__09101);
            rule__QualifiedPrefix__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group__0"


    // $ANTLR start "rule__QualifiedPrefix__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4461:1: rule__QualifiedPrefix__Group__0__Impl : ( ( rule__QualifiedPrefix__QnameAssignment_0 ) ) ;
    public final void rule__QualifiedPrefix__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4465:1: ( ( ( rule__QualifiedPrefix__QnameAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4466:1: ( ( rule__QualifiedPrefix__QnameAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4466:1: ( ( rule__QualifiedPrefix__QnameAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4467:1: ( rule__QualifiedPrefix__QnameAssignment_0 )
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4468:1: ( rule__QualifiedPrefix__QnameAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4468:2: rule__QualifiedPrefix__QnameAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__QnameAssignment_0_in_rule__QualifiedPrefix__Group__0__Impl9128);
            rule__QualifiedPrefix__QnameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group__0__Impl"


    // $ANTLR start "rule__QualifiedPrefix__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4478:1: rule__QualifiedPrefix__Group__1 : rule__QualifiedPrefix__Group__1__Impl ;
    public final void rule__QualifiedPrefix__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4482:1: ( rule__QualifiedPrefix__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4483:2: rule__QualifiedPrefix__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__Group__1__Impl_in_rule__QualifiedPrefix__Group__19158);
            rule__QualifiedPrefix__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group__1"


    // $ANTLR start "rule__QualifiedPrefix__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4489:1: rule__QualifiedPrefix__Group__1__Impl : ( ( rule__QualifiedPrefix__Group_1__0 )* ) ;
    public final void rule__QualifiedPrefix__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4493:1: ( ( ( rule__QualifiedPrefix__Group_1__0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4494:1: ( ( rule__QualifiedPrefix__Group_1__0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4494:1: ( ( rule__QualifiedPrefix__Group_1__0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4495:1: ( rule__QualifiedPrefix__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedPrefixAccess().getGroup_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4496:1: ( rule__QualifiedPrefix__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==47) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4496:2: rule__QualifiedPrefix__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedPrefix__Group_1__0_in_rule__QualifiedPrefix__Group__1__Impl9185);
            	    rule__QualifiedPrefix__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getQualifiedPrefixAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group__1__Impl"


    // $ANTLR start "rule__QualifiedPrefix__Group_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4510:1: rule__QualifiedPrefix__Group_1__0 : rule__QualifiedPrefix__Group_1__0__Impl rule__QualifiedPrefix__Group_1__1 ;
    public final void rule__QualifiedPrefix__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4514:1: ( rule__QualifiedPrefix__Group_1__0__Impl rule__QualifiedPrefix__Group_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4515:2: rule__QualifiedPrefix__Group_1__0__Impl rule__QualifiedPrefix__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__Group_1__0__Impl_in_rule__QualifiedPrefix__Group_1__09220);
            rule__QualifiedPrefix__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedPrefix__Group_1__1_in_rule__QualifiedPrefix__Group_1__09223);
            rule__QualifiedPrefix__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group_1__0"


    // $ANTLR start "rule__QualifiedPrefix__Group_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4522:1: rule__QualifiedPrefix__Group_1__0__Impl : ( ( rule__QualifiedPrefix__QnameAssignment_1_0 ) ) ;
    public final void rule__QualifiedPrefix__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4526:1: ( ( ( rule__QualifiedPrefix__QnameAssignment_1_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4527:1: ( ( rule__QualifiedPrefix__QnameAssignment_1_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4527:1: ( ( rule__QualifiedPrefix__QnameAssignment_1_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4528:1: ( rule__QualifiedPrefix__QnameAssignment_1_0 )
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4529:1: ( rule__QualifiedPrefix__QnameAssignment_1_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4529:2: rule__QualifiedPrefix__QnameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__QnameAssignment_1_0_in_rule__QualifiedPrefix__Group_1__0__Impl9250);
            rule__QualifiedPrefix__QnameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedPrefix__Group_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4539:1: rule__QualifiedPrefix__Group_1__1 : rule__QualifiedPrefix__Group_1__1__Impl ;
    public final void rule__QualifiedPrefix__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4543:1: ( rule__QualifiedPrefix__Group_1__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4544:2: rule__QualifiedPrefix__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__Group_1__1__Impl_in_rule__QualifiedPrefix__Group_1__19280);
            rule__QualifiedPrefix__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group_1__1"


    // $ANTLR start "rule__QualifiedPrefix__Group_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4550:1: rule__QualifiedPrefix__Group_1__1__Impl : ( ( rule__QualifiedPrefix__QnameAssignment_1_1 ) ) ;
    public final void rule__QualifiedPrefix__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4554:1: ( ( ( rule__QualifiedPrefix__QnameAssignment_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4555:1: ( ( rule__QualifiedPrefix__QnameAssignment_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4555:1: ( ( rule__QualifiedPrefix__QnameAssignment_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4556:1: ( rule__QualifiedPrefix__QnameAssignment_1_1 )
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4557:1: ( rule__QualifiedPrefix__QnameAssignment_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4557:2: rule__QualifiedPrefix__QnameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__QualifiedPrefix__QnameAssignment_1_1_in_rule__QualifiedPrefix__Group_1__1__Impl9307);
            rule__QualifiedPrefix__QnameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4571:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4575:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4576:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__09341);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__09344);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4583:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PrefixAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4587:1: ( ( ( rule__QualifiedName__PrefixAssignment_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4588:1: ( ( rule__QualifiedName__PrefixAssignment_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4588:1: ( ( rule__QualifiedName__PrefixAssignment_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4589:1: ( rule__QualifiedName__PrefixAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPrefixAssignment_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4590:1: ( rule__QualifiedName__PrefixAssignment_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4590:2: rule__QualifiedName__PrefixAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PrefixAssignment_0_in_rule__QualifiedName__Group__0__Impl9371);
            rule__QualifiedName__PrefixAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getPrefixAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4600:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4604:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4605:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__19401);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4611:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )? ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4615:1: ( ( ( rule__QualifiedName__Group_1__0 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4616:1: ( ( rule__QualifiedName__Group_1__0 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4616:1: ( ( rule__QualifiedName__Group_1__0 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4617:1: ( rule__QualifiedName__Group_1__0 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4618:1: ( rule__QualifiedName__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==40) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA38_3 = input.LA(3);

                        if ( (LA38_3==EOF||(LA38_3>=13 && LA38_3<=26)||LA38_3==33||LA38_3==35||LA38_3==40||(LA38_3>=42 && LA38_3<=43)||LA38_3==46) ) {
                            alt38=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA38_4 = input.LA(3);

                        if ( (LA38_4==EOF||(LA38_4>=13 && LA38_4<=26)||LA38_4==33||LA38_4==35||LA38_4==40||(LA38_4>=42 && LA38_4<=43)||LA38_4==46) ) {
                            alt38=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA38_5 = input.LA(3);

                        if ( (LA38_5==EOF||(LA38_5>=13 && LA38_5<=26)||LA38_5==33||LA38_5==35||LA38_5==40||(LA38_5>=42 && LA38_5<=43)||LA38_5==46) ) {
                            alt38=1;
                        }
                        }
                        break;
                }

            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4618:2: rule__QualifiedName__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl9428);
                    rule__QualifiedName__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4632:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4636:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4637:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__09463);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__09466);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4644:1: rule__QualifiedName__Group_1__0__Impl : ( ( rule__QualifiedName__QnameAssignment_1_0 ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4648:1: ( ( ( rule__QualifiedName__QnameAssignment_1_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4649:1: ( ( rule__QualifiedName__QnameAssignment_1_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4649:1: ( ( rule__QualifiedName__QnameAssignment_1_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4650:1: ( rule__QualifiedName__QnameAssignment_1_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4651:1: ( rule__QualifiedName__QnameAssignment_1_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4651:2: rule__QualifiedName__QnameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__QnameAssignment_1_0_in_rule__QualifiedName__Group_1__0__Impl9493);
            rule__QualifiedName__QnameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4661:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4665:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4666:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__19523);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4672:1: rule__QualifiedName__Group_1__1__Impl : ( ( rule__QualifiedName__QnameAssignment_1_1 ) ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4676:1: ( ( ( rule__QualifiedName__QnameAssignment_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4677:1: ( ( rule__QualifiedName__QnameAssignment_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4677:1: ( ( rule__QualifiedName__QnameAssignment_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4678:1: ( rule__QualifiedName__QnameAssignment_1_1 )
            {
             before(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4679:1: ( rule__QualifiedName__QnameAssignment_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4679:2: rule__QualifiedName__QnameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__QualifiedName__QnameAssignment_1_1_in_rule__QualifiedName__Group_1__1__Impl9550);
            rule__QualifiedName__QnameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Type__Group_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4693:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4697:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4698:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__09584);
            rule__Type__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__09587);
            rule__Type__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4705:1: rule__Type__Group_1__0__Impl : ( ( rule__Type__SetAssignment_1_0 ) ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4709:1: ( ( ( rule__Type__SetAssignment_1_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4710:1: ( ( rule__Type__SetAssignment_1_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4710:1: ( ( rule__Type__SetAssignment_1_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4711:1: ( rule__Type__SetAssignment_1_0 )
            {
             before(grammarAccess.getTypeAccess().getSetAssignment_1_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4712:1: ( rule__Type__SetAssignment_1_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4712:2: rule__Type__SetAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Type__SetAssignment_1_0_in_rule__Type__Group_1__0__Impl9614);
            rule__Type__SetAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSetAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4722:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4726:1: ( rule__Type__Group_1__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4727:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__19644);
            rule__Type__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4733:1: rule__Type__Group_1__1__Impl : ( ( rule__Type__ParamAssignment_1_1 ) ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4737:1: ( ( ( rule__Type__ParamAssignment_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4738:1: ( ( rule__Type__ParamAssignment_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4738:1: ( ( rule__Type__ParamAssignment_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4739:1: ( rule__Type__ParamAssignment_1_1 )
            {
             before(grammarAccess.getTypeAccess().getParamAssignment_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4740:1: ( rule__Type__ParamAssignment_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4740:2: rule__Type__ParamAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Type__ParamAssignment_1_1_in_rule__Type__Group_1__1__Impl9671);
            rule__Type__ParamAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getParamAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__Type__Group_2__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4754:1: rule__Type__Group_2__0 : rule__Type__Group_2__0__Impl rule__Type__Group_2__1 ;
    public final void rule__Type__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4758:1: ( rule__Type__Group_2__0__Impl rule__Type__Group_2__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4759:2: rule__Type__Group_2__0__Impl rule__Type__Group_2__1
            {
            pushFollow(FOLLOW_rule__Type__Group_2__0__Impl_in_rule__Type__Group_2__09705);
            rule__Type__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Type__Group_2__1_in_rule__Type__Group_2__09708);
            rule__Type__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_2__0"


    // $ANTLR start "rule__Type__Group_2__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4766:1: rule__Type__Group_2__0__Impl : ( ( rule__Type__SeqAssignment_2_0 ) ) ;
    public final void rule__Type__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4770:1: ( ( ( rule__Type__SeqAssignment_2_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4771:1: ( ( rule__Type__SeqAssignment_2_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4771:1: ( ( rule__Type__SeqAssignment_2_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4772:1: ( rule__Type__SeqAssignment_2_0 )
            {
             before(grammarAccess.getTypeAccess().getSeqAssignment_2_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4773:1: ( rule__Type__SeqAssignment_2_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4773:2: rule__Type__SeqAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Type__SeqAssignment_2_0_in_rule__Type__Group_2__0__Impl9735);
            rule__Type__SeqAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSeqAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_2__0__Impl"


    // $ANTLR start "rule__Type__Group_2__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4783:1: rule__Type__Group_2__1 : rule__Type__Group_2__1__Impl ;
    public final void rule__Type__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4787:1: ( rule__Type__Group_2__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4788:2: rule__Type__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group_2__1__Impl_in_rule__Type__Group_2__19765);
            rule__Type__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_2__1"


    // $ANTLR start "rule__Type__Group_2__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4794:1: rule__Type__Group_2__1__Impl : ( ( rule__Type__ParamAssignment_2_1 ) ) ;
    public final void rule__Type__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4798:1: ( ( ( rule__Type__ParamAssignment_2_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4799:1: ( ( rule__Type__ParamAssignment_2_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4799:1: ( ( rule__Type__ParamAssignment_2_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4800:1: ( rule__Type__ParamAssignment_2_1 )
            {
             before(grammarAccess.getTypeAccess().getParamAssignment_2_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4801:1: ( rule__Type__ParamAssignment_2_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4801:2: rule__Type__ParamAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Type__ParamAssignment_2_1_in_rule__Type__Group_2__1__Impl9792);
            rule__Type__ParamAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getParamAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_2__1__Impl"


    // $ANTLR start "rule__Type__Group_3__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4815:1: rule__Type__Group_3__0 : rule__Type__Group_3__0__Impl rule__Type__Group_3__1 ;
    public final void rule__Type__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4819:1: ( rule__Type__Group_3__0__Impl rule__Type__Group_3__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4820:2: rule__Type__Group_3__0__Impl rule__Type__Group_3__1
            {
            pushFollow(FOLLOW_rule__Type__Group_3__0__Impl_in_rule__Type__Group_3__09826);
            rule__Type__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Type__Group_3__1_in_rule__Type__Group_3__09829);
            rule__Type__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_3__0"


    // $ANTLR start "rule__Type__Group_3__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4827:1: rule__Type__Group_3__0__Impl : ( ( rule__Type__MapAssignment_3_0 ) ) ;
    public final void rule__Type__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4831:1: ( ( ( rule__Type__MapAssignment_3_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4832:1: ( ( rule__Type__MapAssignment_3_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4832:1: ( ( rule__Type__MapAssignment_3_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4833:1: ( rule__Type__MapAssignment_3_0 )
            {
             before(grammarAccess.getTypeAccess().getMapAssignment_3_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4834:1: ( rule__Type__MapAssignment_3_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4834:2: rule__Type__MapAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Type__MapAssignment_3_0_in_rule__Type__Group_3__0__Impl9856);
            rule__Type__MapAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getMapAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_3__0__Impl"


    // $ANTLR start "rule__Type__Group_3__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4844:1: rule__Type__Group_3__1 : rule__Type__Group_3__1__Impl ;
    public final void rule__Type__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4848:1: ( rule__Type__Group_3__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4849:2: rule__Type__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group_3__1__Impl_in_rule__Type__Group_3__19886);
            rule__Type__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_3__1"


    // $ANTLR start "rule__Type__Group_3__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4855:1: rule__Type__Group_3__1__Impl : ( ( rule__Type__ParamAssignment_3_1 ) ) ;
    public final void rule__Type__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4859:1: ( ( ( rule__Type__ParamAssignment_3_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4860:1: ( ( rule__Type__ParamAssignment_3_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4860:1: ( ( rule__Type__ParamAssignment_3_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4861:1: ( rule__Type__ParamAssignment_3_1 )
            {
             before(grammarAccess.getTypeAccess().getParamAssignment_3_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4862:1: ( rule__Type__ParamAssignment_3_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4862:2: rule__Type__ParamAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Type__ParamAssignment_3_1_in_rule__Type__Group_3__1__Impl9913);
            rule__Type__ParamAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getParamAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_3__1__Impl"


    // $ANTLR start "rule__TypeParameters__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4876:1: rule__TypeParameters__Group__0 : rule__TypeParameters__Group__0__Impl rule__TypeParameters__Group__1 ;
    public final void rule__TypeParameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4880:1: ( rule__TypeParameters__Group__0__Impl rule__TypeParameters__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4881:2: rule__TypeParameters__Group__0__Impl rule__TypeParameters__Group__1
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group__0__Impl_in_rule__TypeParameters__Group__09947);
            rule__TypeParameters__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeParameters__Group__1_in_rule__TypeParameters__Group__09950);
            rule__TypeParameters__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__0"


    // $ANTLR start "rule__TypeParameters__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4888:1: rule__TypeParameters__Group__0__Impl : ( '(' ) ;
    public final void rule__TypeParameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4892:1: ( ( '(' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4893:1: ( '(' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4893:1: ( '(' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4894:1: '('
            {
             before(grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__TypeParameters__Group__0__Impl9978); 
             after(grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__0__Impl"


    // $ANTLR start "rule__TypeParameters__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4907:1: rule__TypeParameters__Group__1 : rule__TypeParameters__Group__1__Impl rule__TypeParameters__Group__2 ;
    public final void rule__TypeParameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4911:1: ( rule__TypeParameters__Group__1__Impl rule__TypeParameters__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4912:2: rule__TypeParameters__Group__1__Impl rule__TypeParameters__Group__2
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group__1__Impl_in_rule__TypeParameters__Group__110009);
            rule__TypeParameters__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeParameters__Group__2_in_rule__TypeParameters__Group__110012);
            rule__TypeParameters__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__1"


    // $ANTLR start "rule__TypeParameters__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4919:1: rule__TypeParameters__Group__1__Impl : ( ( rule__TypeParameters__ParamAssignment_1 ) ) ;
    public final void rule__TypeParameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4923:1: ( ( ( rule__TypeParameters__ParamAssignment_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4924:1: ( ( rule__TypeParameters__ParamAssignment_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4924:1: ( ( rule__TypeParameters__ParamAssignment_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4925:1: ( rule__TypeParameters__ParamAssignment_1 )
            {
             before(grammarAccess.getTypeParametersAccess().getParamAssignment_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4926:1: ( rule__TypeParameters__ParamAssignment_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4926:2: rule__TypeParameters__ParamAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeParameters__ParamAssignment_1_in_rule__TypeParameters__Group__1__Impl10039);
            rule__TypeParameters__ParamAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeParametersAccess().getParamAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__1__Impl"


    // $ANTLR start "rule__TypeParameters__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4936:1: rule__TypeParameters__Group__2 : rule__TypeParameters__Group__2__Impl rule__TypeParameters__Group__3 ;
    public final void rule__TypeParameters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4940:1: ( rule__TypeParameters__Group__2__Impl rule__TypeParameters__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4941:2: rule__TypeParameters__Group__2__Impl rule__TypeParameters__Group__3
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group__2__Impl_in_rule__TypeParameters__Group__210069);
            rule__TypeParameters__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeParameters__Group__3_in_rule__TypeParameters__Group__210072);
            rule__TypeParameters__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__2"


    // $ANTLR start "rule__TypeParameters__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4948:1: rule__TypeParameters__Group__2__Impl : ( ( rule__TypeParameters__Group_2__0 )* ) ;
    public final void rule__TypeParameters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4952:1: ( ( ( rule__TypeParameters__Group_2__0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4953:1: ( ( rule__TypeParameters__Group_2__0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4953:1: ( ( rule__TypeParameters__Group_2__0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4954:1: ( rule__TypeParameters__Group_2__0 )*
            {
             before(grammarAccess.getTypeParametersAccess().getGroup_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4955:1: ( rule__TypeParameters__Group_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==35) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4955:2: rule__TypeParameters__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TypeParameters__Group_2__0_in_rule__TypeParameters__Group__2__Impl10099);
            	    rule__TypeParameters__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getTypeParametersAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__2__Impl"


    // $ANTLR start "rule__TypeParameters__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4965:1: rule__TypeParameters__Group__3 : rule__TypeParameters__Group__3__Impl ;
    public final void rule__TypeParameters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4969:1: ( rule__TypeParameters__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4970:2: rule__TypeParameters__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group__3__Impl_in_rule__TypeParameters__Group__310130);
            rule__TypeParameters__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__3"


    // $ANTLR start "rule__TypeParameters__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4976:1: rule__TypeParameters__Group__3__Impl : ( ')' ) ;
    public final void rule__TypeParameters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4980:1: ( ( ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4981:1: ( ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4981:1: ( ')' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:4982:1: ')'
            {
             before(grammarAccess.getTypeParametersAccess().getRightParenthesisKeyword_3()); 
            match(input,33,FOLLOW_33_in_rule__TypeParameters__Group__3__Impl10158); 
             after(grammarAccess.getTypeParametersAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group__3__Impl"


    // $ANTLR start "rule__TypeParameters__Group_2__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5003:1: rule__TypeParameters__Group_2__0 : rule__TypeParameters__Group_2__0__Impl rule__TypeParameters__Group_2__1 ;
    public final void rule__TypeParameters__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5007:1: ( rule__TypeParameters__Group_2__0__Impl rule__TypeParameters__Group_2__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5008:2: rule__TypeParameters__Group_2__0__Impl rule__TypeParameters__Group_2__1
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group_2__0__Impl_in_rule__TypeParameters__Group_2__010197);
            rule__TypeParameters__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeParameters__Group_2__1_in_rule__TypeParameters__Group_2__010200);
            rule__TypeParameters__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group_2__0"


    // $ANTLR start "rule__TypeParameters__Group_2__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5015:1: rule__TypeParameters__Group_2__0__Impl : ( ',' ) ;
    public final void rule__TypeParameters__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5019:1: ( ( ',' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5020:1: ( ',' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5020:1: ( ',' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5021:1: ','
            {
             before(grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0()); 
            match(input,35,FOLLOW_35_in_rule__TypeParameters__Group_2__0__Impl10228); 
             after(grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group_2__0__Impl"


    // $ANTLR start "rule__TypeParameters__Group_2__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5034:1: rule__TypeParameters__Group_2__1 : rule__TypeParameters__Group_2__1__Impl ;
    public final void rule__TypeParameters__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5038:1: ( rule__TypeParameters__Group_2__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5039:2: rule__TypeParameters__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeParameters__Group_2__1__Impl_in_rule__TypeParameters__Group_2__110259);
            rule__TypeParameters__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group_2__1"


    // $ANTLR start "rule__TypeParameters__Group_2__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5045:1: rule__TypeParameters__Group_2__1__Impl : ( ( rule__TypeParameters__ParamAssignment_2_1 ) ) ;
    public final void rule__TypeParameters__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5049:1: ( ( ( rule__TypeParameters__ParamAssignment_2_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5050:1: ( ( rule__TypeParameters__ParamAssignment_2_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5050:1: ( ( rule__TypeParameters__ParamAssignment_2_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5051:1: ( rule__TypeParameters__ParamAssignment_2_1 )
            {
             before(grammarAccess.getTypeParametersAccess().getParamAssignment_2_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5052:1: ( rule__TypeParameters__ParamAssignment_2_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5052:2: rule__TypeParameters__ParamAssignment_2_1
            {
            pushFollow(FOLLOW_rule__TypeParameters__ParamAssignment_2_1_in_rule__TypeParameters__Group_2__1__Impl10286);
            rule__TypeParameters__ParamAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeParametersAccess().getParamAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__Group_2__1__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5066:1: rule__ContainerInitializer__Group__0 : rule__ContainerInitializer__Group__0__Impl rule__ContainerInitializer__Group__1 ;
    public final void rule__ContainerInitializer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5070:1: ( rule__ContainerInitializer__Group__0__Impl rule__ContainerInitializer__Group__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5071:2: rule__ContainerInitializer__Group__0__Impl rule__ContainerInitializer__Group__1
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group__0__Impl_in_rule__ContainerInitializer__Group__010320);
            rule__ContainerInitializer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContainerInitializer__Group__1_in_rule__ContainerInitializer__Group__010323);
            rule__ContainerInitializer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__0"


    // $ANTLR start "rule__ContainerInitializer__Group__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5078:1: rule__ContainerInitializer__Group__0__Impl : ( () ) ;
    public final void rule__ContainerInitializer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5082:1: ( ( () ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5083:1: ( () )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5083:1: ( () )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5084:1: ()
            {
             before(grammarAccess.getContainerInitializerAccess().getContainerInitializerAction_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5085:1: ()
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5087:1: 
            {
            }

             after(grammarAccess.getContainerInitializerAccess().getContainerInitializerAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__0__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5097:1: rule__ContainerInitializer__Group__1 : rule__ContainerInitializer__Group__1__Impl rule__ContainerInitializer__Group__2 ;
    public final void rule__ContainerInitializer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5101:1: ( rule__ContainerInitializer__Group__1__Impl rule__ContainerInitializer__Group__2 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5102:2: rule__ContainerInitializer__Group__1__Impl rule__ContainerInitializer__Group__2
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group__1__Impl_in_rule__ContainerInitializer__Group__110381);
            rule__ContainerInitializer__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContainerInitializer__Group__2_in_rule__ContainerInitializer__Group__110384);
            rule__ContainerInitializer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__1"


    // $ANTLR start "rule__ContainerInitializer__Group__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5109:1: rule__ContainerInitializer__Group__1__Impl : ( '{' ) ;
    public final void rule__ContainerInitializer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5113:1: ( ( '{' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5114:1: ( '{' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5114:1: ( '{' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5115:1: '{'
            {
             before(grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__ContainerInitializer__Group__1__Impl10412); 
             after(grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__1__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group__2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5128:1: rule__ContainerInitializer__Group__2 : rule__ContainerInitializer__Group__2__Impl rule__ContainerInitializer__Group__3 ;
    public final void rule__ContainerInitializer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5132:1: ( rule__ContainerInitializer__Group__2__Impl rule__ContainerInitializer__Group__3 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5133:2: rule__ContainerInitializer__Group__2__Impl rule__ContainerInitializer__Group__3
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group__2__Impl_in_rule__ContainerInitializer__Group__210443);
            rule__ContainerInitializer__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContainerInitializer__Group__3_in_rule__ContainerInitializer__Group__210446);
            rule__ContainerInitializer__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__2"


    // $ANTLR start "rule__ContainerInitializer__Group__2__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5140:1: rule__ContainerInitializer__Group__2__Impl : ( ( rule__ContainerInitializer__Group_2__0 )? ) ;
    public final void rule__ContainerInitializer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5144:1: ( ( ( rule__ContainerInitializer__Group_2__0 )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5145:1: ( ( rule__ContainerInitializer__Group_2__0 )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5145:1: ( ( rule__ContainerInitializer__Group_2__0 )? )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5146:1: ( rule__ContainerInitializer__Group_2__0 )?
            {
             before(grammarAccess.getContainerInitializerAccess().getGroup_2()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5147:1: ( rule__ContainerInitializer__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_NUMBER)||LA40_0==24||(LA40_0>=27 && LA40_0<=30)||LA40_0==32||LA40_0==39||LA40_0==41||LA40_0==45) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5147:2: rule__ContainerInitializer__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ContainerInitializer__Group_2__0_in_rule__ContainerInitializer__Group__2__Impl10473);
                    rule__ContainerInitializer__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContainerInitializerAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__2__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group__3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5157:1: rule__ContainerInitializer__Group__3 : rule__ContainerInitializer__Group__3__Impl ;
    public final void rule__ContainerInitializer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5161:1: ( rule__ContainerInitializer__Group__3__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5162:2: rule__ContainerInitializer__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group__3__Impl_in_rule__ContainerInitializer__Group__310504);
            rule__ContainerInitializer__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__3"


    // $ANTLR start "rule__ContainerInitializer__Group__3__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5168:1: rule__ContainerInitializer__Group__3__Impl : ( '}' ) ;
    public final void rule__ContainerInitializer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5172:1: ( ( '}' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5173:1: ( '}' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5173:1: ( '}' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5174:1: '}'
            {
             before(grammarAccess.getContainerInitializerAccess().getRightCurlyBracketKeyword_3()); 
            match(input,46,FOLLOW_46_in_rule__ContainerInitializer__Group__3__Impl10532); 
             after(grammarAccess.getContainerInitializerAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group__3__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group_2__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5195:1: rule__ContainerInitializer__Group_2__0 : rule__ContainerInitializer__Group_2__0__Impl rule__ContainerInitializer__Group_2__1 ;
    public final void rule__ContainerInitializer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5199:1: ( rule__ContainerInitializer__Group_2__0__Impl rule__ContainerInitializer__Group_2__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5200:2: rule__ContainerInitializer__Group_2__0__Impl rule__ContainerInitializer__Group_2__1
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2__0__Impl_in_rule__ContainerInitializer__Group_2__010571);
            rule__ContainerInitializer__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2__1_in_rule__ContainerInitializer__Group_2__010574);
            rule__ContainerInitializer__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2__0"


    // $ANTLR start "rule__ContainerInitializer__Group_2__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5207:1: rule__ContainerInitializer__Group_2__0__Impl : ( ( rule__ContainerInitializer__ExprsAssignment_2_0 ) ) ;
    public final void rule__ContainerInitializer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5211:1: ( ( ( rule__ContainerInitializer__ExprsAssignment_2_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5212:1: ( ( rule__ContainerInitializer__ExprsAssignment_2_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5212:1: ( ( rule__ContainerInitializer__ExprsAssignment_2_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5213:1: ( rule__ContainerInitializer__ExprsAssignment_2_0 )
            {
             before(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5214:1: ( rule__ContainerInitializer__ExprsAssignment_2_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5214:2: rule__ContainerInitializer__ExprsAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__ExprsAssignment_2_0_in_rule__ContainerInitializer__Group_2__0__Impl10601);
            rule__ContainerInitializer__ExprsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2__0__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group_2__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5224:1: rule__ContainerInitializer__Group_2__1 : rule__ContainerInitializer__Group_2__1__Impl ;
    public final void rule__ContainerInitializer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5228:1: ( rule__ContainerInitializer__Group_2__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5229:2: rule__ContainerInitializer__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2__1__Impl_in_rule__ContainerInitializer__Group_2__110631);
            rule__ContainerInitializer__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2__1"


    // $ANTLR start "rule__ContainerInitializer__Group_2__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5235:1: rule__ContainerInitializer__Group_2__1__Impl : ( ( rule__ContainerInitializer__Group_2_1__0 )* ) ;
    public final void rule__ContainerInitializer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5239:1: ( ( ( rule__ContainerInitializer__Group_2_1__0 )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5240:1: ( ( rule__ContainerInitializer__Group_2_1__0 )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5240:1: ( ( rule__ContainerInitializer__Group_2_1__0 )* )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5241:1: ( rule__ContainerInitializer__Group_2_1__0 )*
            {
             before(grammarAccess.getContainerInitializerAccess().getGroup_2_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5242:1: ( rule__ContainerInitializer__Group_2_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==35) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5242:2: rule__ContainerInitializer__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ContainerInitializer__Group_2_1__0_in_rule__ContainerInitializer__Group_2__1__Impl10658);
            	    rule__ContainerInitializer__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getContainerInitializerAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2__1__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group_2_1__0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5256:1: rule__ContainerInitializer__Group_2_1__0 : rule__ContainerInitializer__Group_2_1__0__Impl rule__ContainerInitializer__Group_2_1__1 ;
    public final void rule__ContainerInitializer__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5260:1: ( rule__ContainerInitializer__Group_2_1__0__Impl rule__ContainerInitializer__Group_2_1__1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5261:2: rule__ContainerInitializer__Group_2_1__0__Impl rule__ContainerInitializer__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2_1__0__Impl_in_rule__ContainerInitializer__Group_2_1__010693);
            rule__ContainerInitializer__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2_1__1_in_rule__ContainerInitializer__Group_2_1__010696);
            rule__ContainerInitializer__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2_1__0"


    // $ANTLR start "rule__ContainerInitializer__Group_2_1__0__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5268:1: rule__ContainerInitializer__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ContainerInitializer__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5272:1: ( ( ',' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5273:1: ( ',' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5273:1: ( ',' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5274:1: ','
            {
             before(grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0()); 
            match(input,35,FOLLOW_35_in_rule__ContainerInitializer__Group_2_1__0__Impl10724); 
             after(grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2_1__0__Impl"


    // $ANTLR start "rule__ContainerInitializer__Group_2_1__1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5287:1: rule__ContainerInitializer__Group_2_1__1 : rule__ContainerInitializer__Group_2_1__1__Impl ;
    public final void rule__ContainerInitializer__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5291:1: ( rule__ContainerInitializer__Group_2_1__1__Impl )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5292:2: rule__ContainerInitializer__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__Group_2_1__1__Impl_in_rule__ContainerInitializer__Group_2_1__110755);
            rule__ContainerInitializer__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2_1__1"


    // $ANTLR start "rule__ContainerInitializer__Group_2_1__1__Impl"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5298:1: rule__ContainerInitializer__Group_2_1__1__Impl : ( ( rule__ContainerInitializer__ExprsAssignment_2_1_1 ) ) ;
    public final void rule__ContainerInitializer__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5302:1: ( ( ( rule__ContainerInitializer__ExprsAssignment_2_1_1 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5303:1: ( ( rule__ContainerInitializer__ExprsAssignment_2_1_1 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5303:1: ( ( rule__ContainerInitializer__ExprsAssignment_2_1_1 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5304:1: ( rule__ContainerInitializer__ExprsAssignment_2_1_1 )
            {
             before(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_1_1()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5305:1: ( rule__ContainerInitializer__ExprsAssignment_2_1_1 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5305:2: rule__ContainerInitializer__ExprsAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ContainerInitializer__ExprsAssignment_2_1_1_in_rule__ContainerInitializer__Group_2_1__1__Impl10782);
            rule__ContainerInitializer__ExprsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__Group_2_1__1__Impl"


    // $ANTLR start "rule__LanguageUnit__AdvicesAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5320:1: rule__LanguageUnit__AdvicesAssignment_0 : ( ruleAdvice ) ;
    public final void rule__LanguageUnit__AdvicesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5324:1: ( ( ruleAdvice ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5325:1: ( ruleAdvice )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5325:1: ( ruleAdvice )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5326:1: ruleAdvice
            {
             before(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdvice_in_rule__LanguageUnit__AdvicesAssignment_010821);
            ruleAdvice();

            state._fsp--;

             after(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__AdvicesAssignment_0"


    // $ANTLR start "rule__LanguageUnit__NameAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5335:1: rule__LanguageUnit__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LanguageUnit__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5339:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5340:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5340:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5341:1: ruleIdentifier
            {
             before(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__LanguageUnit__NameAssignment_110852);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__NameAssignment_1"


    // $ANTLR start "rule__LanguageUnit__VersionAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5350:1: rule__LanguageUnit__VersionAssignment_2 : ( ruleVersionStmt ) ;
    public final void rule__LanguageUnit__VersionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5354:1: ( ( ruleVersionStmt ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5355:1: ( ruleVersionStmt )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5355:1: ( ruleVersionStmt )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5356:1: ruleVersionStmt
            {
             before(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVersionStmt_in_rule__LanguageUnit__VersionAssignment_210883);
            ruleVersionStmt();

            state._fsp--;

             after(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__VersionAssignment_2"


    // $ANTLR start "rule__LanguageUnit__ImportsAssignment_3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5365:1: rule__LanguageUnit__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__LanguageUnit__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5369:1: ( ( ruleImport ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5370:1: ( ruleImport )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5370:1: ( ruleImport )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5371:1: ruleImport
            {
             before(grammarAccess.getLanguageUnitAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__LanguageUnit__ImportsAssignment_310914);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getLanguageUnitAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageUnit__ImportsAssignment_3"


    // $ANTLR start "rule__Advice__NameAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5384:1: rule__Advice__NameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__Advice__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5388:1: ( ( ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5389:1: ( ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5389:1: ( ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5390:1: ruleQualifiedName
            {
             before(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Advice__NameAssignment_210949);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__NameAssignment_2"


    // $ANTLR start "rule__Advice__VersionSpecAssignment_4"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5399:1: rule__Advice__VersionSpecAssignment_4 : ( ruleVersionSpec ) ;
    public final void rule__Advice__VersionSpecAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5403:1: ( ( ruleVersionSpec ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5404:1: ( ruleVersionSpec )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5404:1: ( ruleVersionSpec )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5405:1: ruleVersionSpec
            {
             before(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleVersionSpec_in_rule__Advice__VersionSpecAssignment_410980);
            ruleVersionSpec();

            state._fsp--;

             after(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Advice__VersionSpecAssignment_4"


    // $ANTLR start "rule__VersionSpec__ConflictsAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5414:1: rule__VersionSpec__ConflictsAssignment_2 : ( ruleVersionedId ) ;
    public final void rule__VersionSpec__ConflictsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5418:1: ( ( ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5419:1: ( ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5419:1: ( ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5420:1: ruleVersionedId
            {
             before(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVersionedId_in_rule__VersionSpec__ConflictsAssignment_211011);
            ruleVersionedId();

            state._fsp--;

             after(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__ConflictsAssignment_2"


    // $ANTLR start "rule__VersionSpec__ConflictsAssignment_3_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5429:1: rule__VersionSpec__ConflictsAssignment_3_1 : ( ruleVersionedId ) ;
    public final void rule__VersionSpec__ConflictsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5433:1: ( ( ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5434:1: ( ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5434:1: ( ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5435:1: ruleVersionedId
            {
             before(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleVersionedId_in_rule__VersionSpec__ConflictsAssignment_3_111042);
            ruleVersionedId();

            state._fsp--;

             after(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionSpec__ConflictsAssignment_3_1"


    // $ANTLR start "rule__VersionedId__OpAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5444:1: rule__VersionedId__OpAssignment_1 : ( ruleVersionOperator ) ;
    public final void rule__VersionedId__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5448:1: ( ( ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5449:1: ( ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5449:1: ( ruleVersionOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5450:1: ruleVersionOperator
            {
             before(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVersionOperator_in_rule__VersionedId__OpAssignment_111073);
            ruleVersionOperator();

            state._fsp--;

             after(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__OpAssignment_1"


    // $ANTLR start "rule__VersionedId__VersionAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5459:1: rule__VersionedId__VersionAssignment_2 : ( RULE_VERSION ) ;
    public final void rule__VersionedId__VersionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5463:1: ( ( RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5464:1: ( RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5464:1: ( RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5465:1: RULE_VERSION
            {
             before(grammarAccess.getVersionedIdAccess().getVersionVERSIONTerminalRuleCall_2_0()); 
            match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_rule__VersionedId__VersionAssignment_211104); 
             after(grammarAccess.getVersionedIdAccess().getVersionVERSIONTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionedId__VersionAssignment_2"


    // $ANTLR start "rule__Parameter__TypeAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5476:1: rule__Parameter__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Parameter__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5480:1: ( ( ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5481:1: ( ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5481:1: ( ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5482:1: ruleType
            {
             before(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_011137);
            ruleType();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__TypeAssignment_0"


    // $ANTLR start "rule__Parameter__NameAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5491:1: rule__Parameter__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5495:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5496:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5496:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5497:1: ruleIdentifier
            {
             before(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__Parameter__NameAssignment_111168);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_1"


    // $ANTLR start "rule__VersionStmt__VersionAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5506:1: rule__VersionStmt__VersionAssignment_1 : ( RULE_VERSION ) ;
    public final void rule__VersionStmt__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5510:1: ( ( RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5511:1: ( RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5511:1: ( RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5512:1: RULE_VERSION
            {
             before(grammarAccess.getVersionStmtAccess().getVersionVERSIONTerminalRuleCall_1_0()); 
            match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_rule__VersionStmt__VersionAssignment_111199); 
             after(grammarAccess.getVersionStmtAccess().getVersionVERSIONTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VersionStmt__VersionAssignment_1"


    // $ANTLR start "rule__Import__NameAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5521:1: rule__Import__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Import__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5525:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5526:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5526:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5527:1: ruleIdentifier
            {
             before(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__Import__NameAssignment_111230);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__NameAssignment_1"


    // $ANTLR start "rule__Import__VersionSpecAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5536:1: rule__Import__VersionSpecAssignment_2 : ( ruleVersionSpec ) ;
    public final void rule__Import__VersionSpecAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5540:1: ( ( ruleVersionSpec ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5541:1: ( ruleVersionSpec )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5541:1: ( ruleVersionSpec )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5542:1: ruleVersionSpec
            {
             before(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVersionSpec_in_rule__Import__VersionSpecAssignment_211261);
            ruleVersionSpec();

            state._fsp--;

             after(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__VersionSpecAssignment_2"


    // $ANTLR start "rule__Expression__ExprAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5553:1: rule__Expression__ExprAssignment_0 : ( ruleLogicalExpression ) ;
    public final void rule__Expression__ExprAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5557:1: ( ( ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5558:1: ( ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5558:1: ( ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5559:1: ruleLogicalExpression
            {
             before(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLogicalExpression_in_rule__Expression__ExprAssignment_011294);
            ruleLogicalExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__ExprAssignment_0"


    // $ANTLR start "rule__Expression__InitAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5568:1: rule__Expression__InitAssignment_1 : ( ruleContainerInitializer ) ;
    public final void rule__Expression__InitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5572:1: ( ( ruleContainerInitializer ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5573:1: ( ruleContainerInitializer )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5573:1: ( ruleContainerInitializer )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5574:1: ruleContainerInitializer
            {
             before(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContainerInitializer_in_rule__Expression__InitAssignment_111325);
            ruleContainerInitializer();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__InitAssignment_1"


    // $ANTLR start "rule__LogicalExpression__LeftAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5583:1: rule__LogicalExpression__LeftAssignment_0 : ( ruleEqualityExpression ) ;
    public final void rule__LogicalExpression__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5587:1: ( ( ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5588:1: ( ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5588:1: ( ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5589:1: ruleEqualityExpression
            {
             before(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__LogicalExpression__LeftAssignment_011356);
            ruleEqualityExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__LeftAssignment_0"


    // $ANTLR start "rule__LogicalExpression__RightAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5598:1: rule__LogicalExpression__RightAssignment_1 : ( ruleLogicalExpressionPart ) ;
    public final void rule__LogicalExpression__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5602:1: ( ( ruleLogicalExpressionPart ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5603:1: ( ruleLogicalExpressionPart )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5603:1: ( ruleLogicalExpressionPart )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5604:1: ruleLogicalExpressionPart
            {
             before(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_rule__LogicalExpression__RightAssignment_111387);
            ruleLogicalExpressionPart();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpression__RightAssignment_1"


    // $ANTLR start "rule__LogicalExpressionPart__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5613:1: rule__LogicalExpressionPart__OpAssignment_0 : ( ruleLogicalOperator ) ;
    public final void rule__LogicalExpressionPart__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5617:1: ( ( ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5618:1: ( ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5618:1: ( ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5619:1: ruleLogicalOperator
            {
             before(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLogicalOperator_in_rule__LogicalExpressionPart__OpAssignment_011418);
            ruleLogicalOperator();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__OpAssignment_0"


    // $ANTLR start "rule__LogicalExpressionPart__ExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5628:1: rule__LogicalExpressionPart__ExAssignment_1 : ( ruleEqualityExpression ) ;
    public final void rule__LogicalExpressionPart__ExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5632:1: ( ( ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5633:1: ( ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5633:1: ( ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5634:1: ruleEqualityExpression
            {
             before(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__LogicalExpressionPart__ExAssignment_111449);
            ruleEqualityExpression();

            state._fsp--;

             after(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicalExpressionPart__ExAssignment_1"


    // $ANTLR start "rule__EqualityExpression__LeftAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5643:1: rule__EqualityExpression__LeftAssignment_0 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5647:1: ( ( ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5648:1: ( ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5648:1: ( ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5649:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__LeftAssignment_011480);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__LeftAssignment_0"


    // $ANTLR start "rule__EqualityExpression__RightAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5658:1: rule__EqualityExpression__RightAssignment_1 : ( ruleEqualityExpressionPart ) ;
    public final void rule__EqualityExpression__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5662:1: ( ( ruleEqualityExpressionPart ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5663:1: ( ruleEqualityExpressionPart )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5663:1: ( ruleEqualityExpressionPart )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5664:1: ruleEqualityExpressionPart
            {
             before(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_rule__EqualityExpression__RightAssignment_111511);
            ruleEqualityExpressionPart();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__RightAssignment_1"


    // $ANTLR start "rule__EqualityExpressionPart__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5673:1: rule__EqualityExpressionPart__OpAssignment_0 : ( ruleEqualityOperator ) ;
    public final void rule__EqualityExpressionPart__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5677:1: ( ( ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5678:1: ( ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5678:1: ( ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5679:1: ruleEqualityOperator
            {
             before(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEqualityOperator_in_rule__EqualityExpressionPart__OpAssignment_011542);
            ruleEqualityOperator();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__OpAssignment_0"


    // $ANTLR start "rule__EqualityExpressionPart__ExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5688:1: rule__EqualityExpressionPart__ExAssignment_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpressionPart__ExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5692:1: ( ( ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5693:1: ( ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5693:1: ( ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5694:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpressionPart__ExAssignment_111573);
            ruleRelationalExpression();

            state._fsp--;

             after(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpressionPart__ExAssignment_1"


    // $ANTLR start "rule__RelationalExpression__LeftAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5703:1: rule__RelationalExpression__LeftAssignment_0 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpression__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5707:1: ( ( ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5708:1: ( ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5708:1: ( ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5709:1: ruleAdditiveExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__RelationalExpression__LeftAssignment_011604);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__LeftAssignment_0"


    // $ANTLR start "rule__RelationalExpression__RightAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5718:1: rule__RelationalExpression__RightAssignment_1 : ( ruleRelationalExpressionPart ) ;
    public final void rule__RelationalExpression__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5722:1: ( ( ruleRelationalExpressionPart ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5723:1: ( ruleRelationalExpressionPart )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5723:1: ( ruleRelationalExpressionPart )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5724:1: ruleRelationalExpressionPart
            {
             before(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_rule__RelationalExpression__RightAssignment_111635);
            ruleRelationalExpressionPart();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__RightAssignment_1"


    // $ANTLR start "rule__RelationalExpressionPart__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5733:1: rule__RelationalExpressionPart__OpAssignment_0 : ( ruleRelationalOperator ) ;
    public final void rule__RelationalExpressionPart__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5737:1: ( ( ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5738:1: ( ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5738:1: ( ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5739:1: ruleRelationalOperator
            {
             before(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRelationalOperator_in_rule__RelationalExpressionPart__OpAssignment_011666);
            ruleRelationalOperator();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__OpAssignment_0"


    // $ANTLR start "rule__RelationalExpressionPart__ExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5748:1: rule__RelationalExpressionPart__ExAssignment_1 : ( ruleAdditiveExpression ) ;
    public final void rule__RelationalExpressionPart__ExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5752:1: ( ( ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5753:1: ( ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5753:1: ( ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5754:1: ruleAdditiveExpression
            {
             before(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__RelationalExpressionPart__ExAssignment_111697);
            ruleAdditiveExpression();

            state._fsp--;

             after(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpressionPart__ExAssignment_1"


    // $ANTLR start "rule__AdditiveExpression__LeftAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5763:1: rule__AdditiveExpression__LeftAssignment_0 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5767:1: ( ( ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5768:1: ( ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5768:1: ( ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5769:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__LeftAssignment_011728);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__LeftAssignment_0"


    // $ANTLR start "rule__AdditiveExpression__RightAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5778:1: rule__AdditiveExpression__RightAssignment_1 : ( ruleAdditiveExpressionPart ) ;
    public final void rule__AdditiveExpression__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5782:1: ( ( ruleAdditiveExpressionPart ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5783:1: ( ruleAdditiveExpressionPart )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5783:1: ( ruleAdditiveExpressionPart )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5784:1: ruleAdditiveExpressionPart
            {
             before(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_rule__AdditiveExpression__RightAssignment_111759);
            ruleAdditiveExpressionPart();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__RightAssignment_1"


    // $ANTLR start "rule__AdditiveExpressionPart__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5793:1: rule__AdditiveExpressionPart__OpAssignment_0 : ( ruleAdditiveOperator ) ;
    public final void rule__AdditiveExpressionPart__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5797:1: ( ( ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5798:1: ( ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5798:1: ( ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5799:1: ruleAdditiveOperator
            {
             before(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpressionPart__OpAssignment_011790);
            ruleAdditiveOperator();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__OpAssignment_0"


    // $ANTLR start "rule__AdditiveExpressionPart__ExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5808:1: rule__AdditiveExpressionPart__ExAssignment_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpressionPart__ExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5812:1: ( ( ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5813:1: ( ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5813:1: ( ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5814:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpressionPart__ExAssignment_111821);
            ruleMultiplicativeExpression();

            state._fsp--;

             after(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpressionPart__ExAssignment_1"


    // $ANTLR start "rule__MultiplicativeExpression__LeftAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5823:1: rule__MultiplicativeExpression__LeftAssignment_0 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5827:1: ( ( ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5828:1: ( ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5828:1: ( ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5829:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__LeftAssignment_011852);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__LeftAssignment_0"


    // $ANTLR start "rule__MultiplicativeExpression__RightAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5838:1: rule__MultiplicativeExpression__RightAssignment_1 : ( ruleMultiplicativeExpressionPart ) ;
    public final void rule__MultiplicativeExpression__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5842:1: ( ( ruleMultiplicativeExpressionPart ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5843:1: ( ruleMultiplicativeExpressionPart )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5843:1: ( ruleMultiplicativeExpressionPart )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5844:1: ruleMultiplicativeExpressionPart
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_rule__MultiplicativeExpression__RightAssignment_111883);
            ruleMultiplicativeExpressionPart();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__RightAssignment_1"


    // $ANTLR start "rule__MultiplicativeExpressionPart__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5853:1: rule__MultiplicativeExpressionPart__OpAssignment_0 : ( ruleMultiplicativeOperator ) ;
    public final void rule__MultiplicativeExpressionPart__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5857:1: ( ( ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5858:1: ( ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5858:1: ( ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5859:1: ruleMultiplicativeOperator
            {
             before(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpressionPart__OpAssignment_011914);
            ruleMultiplicativeOperator();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__OpAssignment_0"


    // $ANTLR start "rule__MultiplicativeExpressionPart__ExprAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5868:1: rule__MultiplicativeExpressionPart__ExprAssignment_1 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpressionPart__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5872:1: ( ( ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5873:1: ( ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5873:1: ( ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5874:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpressionPart__ExprAssignment_111945);
            ruleUnaryExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpressionPart__ExprAssignment_1"


    // $ANTLR start "rule__UnaryExpression__OpAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5883:1: rule__UnaryExpression__OpAssignment_0 : ( ruleUnaryOperator ) ;
    public final void rule__UnaryExpression__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5887:1: ( ( ruleUnaryOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5888:1: ( ruleUnaryOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5888:1: ( ruleUnaryOperator )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5889:1: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__UnaryExpression__OpAssignment_011976);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__OpAssignment_0"


    // $ANTLR start "rule__UnaryExpression__ExprAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5898:1: rule__UnaryExpression__ExprAssignment_1 : ( rulePostfixExpression ) ;
    public final void rule__UnaryExpression__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5902:1: ( ( rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5903:1: ( rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5903:1: ( rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5904:1: rulePostfixExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePostfixExpression_in_rule__UnaryExpression__ExprAssignment_112007);
            rulePostfixExpression();

            state._fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__ExprAssignment_1"


    // $ANTLR start "rule__PostfixExpression__LeftAssignment"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5913:1: rule__PostfixExpression__LeftAssignment : ( rulePrimaryExpression ) ;
    public final void rule__PostfixExpression__LeftAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5917:1: ( ( rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5918:1: ( rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5918:1: ( rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5919:1: rulePrimaryExpression
            {
             before(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__LeftAssignment12038);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PostfixExpression__LeftAssignment"


    // $ANTLR start "rule__PrimaryExpression__OtherExAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5928:1: rule__PrimaryExpression__OtherExAssignment_0 : ( ruleExpressionOrQualifiedExecution ) ;
    public final void rule__PrimaryExpression__OtherExAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5932:1: ( ( ruleExpressionOrQualifiedExecution ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5933:1: ( ruleExpressionOrQualifiedExecution )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5933:1: ( ruleExpressionOrQualifiedExecution )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5934:1: ruleExpressionOrQualifiedExecution
            {
             before(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rule__PrimaryExpression__OtherExAssignment_012069);
            ruleExpressionOrQualifiedExecution();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__OtherExAssignment_0"


    // $ANTLR start "rule__PrimaryExpression__UnqExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5943:1: rule__PrimaryExpression__UnqExAssignment_1 : ( ruleUnqualifiedExecution ) ;
    public final void rule__PrimaryExpression__UnqExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5947:1: ( ( ruleUnqualifiedExecution ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5948:1: ( ruleUnqualifiedExecution )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5948:1: ( ruleUnqualifiedExecution )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5949:1: ruleUnqualifiedExecution
            {
             before(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rule__PrimaryExpression__UnqExAssignment_112100);
            ruleUnqualifiedExecution();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__UnqExAssignment_1"


    // $ANTLR start "rule__PrimaryExpression__SuperExAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5958:1: rule__PrimaryExpression__SuperExAssignment_2 : ( ruleSuperExecution ) ;
    public final void rule__PrimaryExpression__SuperExAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5962:1: ( ( ruleSuperExecution ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5963:1: ( ruleSuperExecution )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5963:1: ( ruleSuperExecution )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5964:1: ruleSuperExecution
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuperExecution_in_rule__PrimaryExpression__SuperExAssignment_212131);
            ruleSuperExecution();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__SuperExAssignment_2"


    // $ANTLR start "rule__PrimaryExpression__NewExAssignment_3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5973:1: rule__PrimaryExpression__NewExAssignment_3 : ( ruleConstructorExecution ) ;
    public final void rule__PrimaryExpression__NewExAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5977:1: ( ( ruleConstructorExecution ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5978:1: ( ruleConstructorExecution )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5978:1: ( ruleConstructorExecution )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5979:1: ruleConstructorExecution
            {
             before(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleConstructorExecution_in_rule__PrimaryExpression__NewExAssignment_312162);
            ruleConstructorExecution();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__NewExAssignment_3"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__ValAssignment_0_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5988:1: rule__ExpressionOrQualifiedExecution__ValAssignment_0_0 : ( ruleConstant ) ;
    public final void rule__ExpressionOrQualifiedExecution__ValAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5992:1: ( ( ruleConstant ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5993:1: ( ruleConstant )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5993:1: ( ruleConstant )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:5994:1: ruleConstant
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleConstant_in_rule__ExpressionOrQualifiedExecution__ValAssignment_0_012193);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__ValAssignment_0_0"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6003:1: rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1 : ( ruleExpression ) ;
    public final void rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6007:1: ( ( ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6008:1: ( ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6008:1: ( ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6009:1: ruleExpression
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_112224);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1"


    // $ANTLR start "rule__ExpressionOrQualifiedExecution__CallsAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6018:1: rule__ExpressionOrQualifiedExecution__CallsAssignment_1 : ( ruleSubCall ) ;
    public final void rule__ExpressionOrQualifiedExecution__CallsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6022:1: ( ( ruleSubCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6023:1: ( ruleSubCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6023:1: ( ruleSubCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6024:1: ruleSubCall
            {
             before(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSubCall_in_rule__ExpressionOrQualifiedExecution__CallsAssignment_112255);
            ruleSubCall();

            state._fsp--;

             after(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionOrQualifiedExecution__CallsAssignment_1"


    // $ANTLR start "rule__UnqualifiedExecution__CallAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6033:1: rule__UnqualifiedExecution__CallAssignment_0 : ( ruleCall ) ;
    public final void rule__UnqualifiedExecution__CallAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6037:1: ( ( ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6038:1: ( ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6038:1: ( ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6039:1: ruleCall
            {
             before(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleCall_in_rule__UnqualifiedExecution__CallAssignment_012286);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__CallAssignment_0"


    // $ANTLR start "rule__UnqualifiedExecution__CallsAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6048:1: rule__UnqualifiedExecution__CallsAssignment_1 : ( ruleSubCall ) ;
    public final void rule__UnqualifiedExecution__CallsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6052:1: ( ( ruleSubCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6053:1: ( ruleSubCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6053:1: ( ruleSubCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6054:1: ruleSubCall
            {
             before(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSubCall_in_rule__UnqualifiedExecution__CallsAssignment_112317);
            ruleSubCall();

            state._fsp--;

             after(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnqualifiedExecution__CallsAssignment_1"


    // $ANTLR start "rule__SuperExecution__CallAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6063:1: rule__SuperExecution__CallAssignment_2 : ( ruleCall ) ;
    public final void rule__SuperExecution__CallAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6067:1: ( ( ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6068:1: ( ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6068:1: ( ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6069:1: ruleCall
            {
             before(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleCall_in_rule__SuperExecution__CallAssignment_212348);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__CallAssignment_2"


    // $ANTLR start "rule__SuperExecution__CallsAssignment_3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6078:1: rule__SuperExecution__CallsAssignment_3 : ( ruleSubCall ) ;
    public final void rule__SuperExecution__CallsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6082:1: ( ( ruleSubCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6083:1: ( ruleSubCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6083:1: ( ruleSubCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6084:1: ruleSubCall
            {
             before(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSubCall_in_rule__SuperExecution__CallsAssignment_312379);
            ruleSubCall();

            state._fsp--;

             after(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuperExecution__CallsAssignment_3"


    // $ANTLR start "rule__ConstructorExecution__TypeAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6093:1: rule__ConstructorExecution__TypeAssignment_1 : ( ruleType ) ;
    public final void rule__ConstructorExecution__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6097:1: ( ( ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6098:1: ( ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6098:1: ( ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6099:1: ruleType
            {
             before(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__ConstructorExecution__TypeAssignment_112410);
            ruleType();

            state._fsp--;

             after(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__TypeAssignment_1"


    // $ANTLR start "rule__ConstructorExecution__ParamAssignment_3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6108:1: rule__ConstructorExecution__ParamAssignment_3 : ( ruleArgumentList ) ;
    public final void rule__ConstructorExecution__ParamAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6112:1: ( ( ruleArgumentList ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6113:1: ( ruleArgumentList )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6113:1: ( ruleArgumentList )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6114:1: ruleArgumentList
            {
             before(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleArgumentList_in_rule__ConstructorExecution__ParamAssignment_312441);
            ruleArgumentList();

            state._fsp--;

             after(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__ParamAssignment_3"


    // $ANTLR start "rule__ConstructorExecution__CallsAssignment_5"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6123:1: rule__ConstructorExecution__CallsAssignment_5 : ( ruleSubCall ) ;
    public final void rule__ConstructorExecution__CallsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6127:1: ( ( ruleSubCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6128:1: ( ruleSubCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6128:1: ( ruleSubCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6129:1: ruleSubCall
            {
             before(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSubCall_in_rule__ConstructorExecution__CallsAssignment_512472);
            ruleSubCall();

            state._fsp--;

             after(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstructorExecution__CallsAssignment_5"


    // $ANTLR start "rule__SubCall__CallAssignment_0_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6138:1: rule__SubCall__CallAssignment_0_1 : ( ruleCall ) ;
    public final void rule__SubCall__CallAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6142:1: ( ( ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6143:1: ( ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6143:1: ( ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6144:1: ruleCall
            {
             before(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleCall_in_rule__SubCall__CallAssignment_0_112503);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__CallAssignment_0_1"


    // $ANTLR start "rule__SubCall__ArrayExAssignment_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6153:1: rule__SubCall__ArrayExAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__SubCall__ArrayExAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6157:1: ( ( ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6158:1: ( ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6158:1: ( ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6159:1: ruleExpression
            {
             before(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__SubCall__ArrayExAssignment_1_112534);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubCall__ArrayExAssignment_1_1"


    // $ANTLR start "rule__Call__NameAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6168:1: rule__Call__NameAssignment_0 : ( ruleQualifiedPrefix ) ;
    public final void rule__Call__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6172:1: ( ( ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6173:1: ( ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6173:1: ( ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6174:1: ruleQualifiedPrefix
            {
             before(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_rule__Call__NameAssignment_012565);
            ruleQualifiedPrefix();

            state._fsp--;

             after(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__NameAssignment_0"


    // $ANTLR start "rule__Call__ParamAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6183:1: rule__Call__ParamAssignment_2 : ( ruleArgumentList ) ;
    public final void rule__Call__ParamAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6187:1: ( ( ruleArgumentList ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6188:1: ( ruleArgumentList )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6188:1: ( ruleArgumentList )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6189:1: ruleArgumentList
            {
             before(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleArgumentList_in_rule__Call__ParamAssignment_212596);
            ruleArgumentList();

            state._fsp--;

             after(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__ParamAssignment_2"


    // $ANTLR start "rule__ArgumentList__ParamAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6198:1: rule__ArgumentList__ParamAssignment_0 : ( ruleNamedArgument ) ;
    public final void rule__ArgumentList__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6202:1: ( ( ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6203:1: ( ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6203:1: ( ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6204:1: ruleNamedArgument
            {
             before(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNamedArgument_in_rule__ArgumentList__ParamAssignment_012627);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__ParamAssignment_0"


    // $ANTLR start "rule__ArgumentList__ParamAssignment_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6213:1: rule__ArgumentList__ParamAssignment_1_1 : ( ruleNamedArgument ) ;
    public final void rule__ArgumentList__ParamAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6217:1: ( ( ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6218:1: ( ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6218:1: ( ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6219:1: ruleNamedArgument
            {
             before(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleNamedArgument_in_rule__ArgumentList__ParamAssignment_1_112658);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentList__ParamAssignment_1_1"


    // $ANTLR start "rule__NamedArgument__NameAssignment_0_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6228:1: rule__NamedArgument__NameAssignment_0_0 : ( ruleIdentifier ) ;
    public final void rule__NamedArgument__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6232:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6233:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6233:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6234:1: ruleIdentifier
            {
             before(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__NamedArgument__NameAssignment_0_012689);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__NameAssignment_0_0"


    // $ANTLR start "rule__NamedArgument__ExAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6243:1: rule__NamedArgument__ExAssignment_1 : ( ruleExpression ) ;
    public final void rule__NamedArgument__ExAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6247:1: ( ( ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6248:1: ( ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6248:1: ( ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6249:1: ruleExpression
            {
             before(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__NamedArgument__ExAssignment_112720);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ExAssignment_1"


    // $ANTLR start "rule__QualifiedPrefix__QnameAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6258:1: rule__QualifiedPrefix__QnameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__QualifiedPrefix__QnameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6262:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6263:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6263:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6264:1: ruleIdentifier
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__QualifiedPrefix__QnameAssignment_012751);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__QnameAssignment_0"


    // $ANTLR start "rule__QualifiedPrefix__QnameAssignment_1_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6273:1: rule__QualifiedPrefix__QnameAssignment_1_0 : ( ( '::' ) ) ;
    public final void rule__QualifiedPrefix__QnameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6277:1: ( ( ( '::' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6278:1: ( ( '::' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6278:1: ( ( '::' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6279:1: ( '::' )
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameColonColonKeyword_1_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6280:1: ( '::' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6281:1: '::'
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameColonColonKeyword_1_0_0()); 
            match(input,47,FOLLOW_47_in_rule__QualifiedPrefix__QnameAssignment_1_012787); 
             after(grammarAccess.getQualifiedPrefixAccess().getQnameColonColonKeyword_1_0_0()); 

            }

             after(grammarAccess.getQualifiedPrefixAccess().getQnameColonColonKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__QnameAssignment_1_0"


    // $ANTLR start "rule__QualifiedPrefix__QnameAssignment_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6296:1: rule__QualifiedPrefix__QnameAssignment_1_1 : ( ruleIdentifier ) ;
    public final void rule__QualifiedPrefix__QnameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6300:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6301:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6301:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6302:1: ruleIdentifier
            {
             before(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__QualifiedPrefix__QnameAssignment_1_112826);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedPrefix__QnameAssignment_1_1"


    // $ANTLR start "rule__QualifiedName__PrefixAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6311:1: rule__QualifiedName__PrefixAssignment_0 : ( ruleQualifiedPrefix ) ;
    public final void rule__QualifiedName__PrefixAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6315:1: ( ( ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6316:1: ( ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6316:1: ( ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6317:1: ruleQualifiedPrefix
            {
             before(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_rule__QualifiedName__PrefixAssignment_012857);
            ruleQualifiedPrefix();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__PrefixAssignment_0"


    // $ANTLR start "rule__QualifiedName__QnameAssignment_1_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6326:1: rule__QualifiedName__QnameAssignment_1_0 : ( ( '.' ) ) ;
    public final void rule__QualifiedName__QnameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6330:1: ( ( ( '.' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6331:1: ( ( '.' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6331:1: ( ( '.' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6332:1: ( '.' )
            {
             before(grammarAccess.getQualifiedNameAccess().getQnameFullStopKeyword_1_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6333:1: ( '.' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6334:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getQnameFullStopKeyword_1_0_0()); 
            match(input,40,FOLLOW_40_in_rule__QualifiedName__QnameAssignment_1_012893); 
             after(grammarAccess.getQualifiedNameAccess().getQnameFullStopKeyword_1_0_0()); 

            }

             after(grammarAccess.getQualifiedNameAccess().getQnameFullStopKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__QnameAssignment_1_0"


    // $ANTLR start "rule__QualifiedName__QnameAssignment_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6349:1: rule__QualifiedName__QnameAssignment_1_1 : ( ruleIdentifier ) ;
    public final void rule__QualifiedName__QnameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6353:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6354:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6354:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6355:1: ruleIdentifier
            {
             before(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__QualifiedName__QnameAssignment_1_112932);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__QnameAssignment_1_1"


    // $ANTLR start "rule__Constant__NValueAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6364:1: rule__Constant__NValueAssignment_0 : ( ruleNumValue ) ;
    public final void rule__Constant__NValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6368:1: ( ( ruleNumValue ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6369:1: ( ruleNumValue )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6369:1: ( ruleNumValue )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6370:1: ruleNumValue
            {
             before(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNumValue_in_rule__Constant__NValueAssignment_012963);
            ruleNumValue();

            state._fsp--;

             after(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__NValueAssignment_0"


    // $ANTLR start "rule__Constant__SValueAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6379:1: rule__Constant__SValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Constant__SValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6383:1: ( ( RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6384:1: ( RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6384:1: ( RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6385:1: RULE_STRING
            {
             before(grammarAccess.getConstantAccess().getSValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Constant__SValueAssignment_112994); 
             after(grammarAccess.getConstantAccess().getSValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__SValueAssignment_1"


    // $ANTLR start "rule__Constant__QValueAssignment_2"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6394:1: rule__Constant__QValueAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__Constant__QValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6398:1: ( ( ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6399:1: ( ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6399:1: ( ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6400:1: ruleQualifiedName
            {
             before(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Constant__QValueAssignment_213025);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__QValueAssignment_2"


    // $ANTLR start "rule__Constant__BValueAssignment_3"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6409:1: rule__Constant__BValueAssignment_3 : ( ( rule__Constant__BValueAlternatives_3_0 ) ) ;
    public final void rule__Constant__BValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6413:1: ( ( ( rule__Constant__BValueAlternatives_3_0 ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6414:1: ( ( rule__Constant__BValueAlternatives_3_0 ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6414:1: ( ( rule__Constant__BValueAlternatives_3_0 ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6415:1: ( rule__Constant__BValueAlternatives_3_0 )
            {
             before(grammarAccess.getConstantAccess().getBValueAlternatives_3_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6416:1: ( rule__Constant__BValueAlternatives_3_0 )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6416:2: rule__Constant__BValueAlternatives_3_0
            {
            pushFollow(FOLLOW_rule__Constant__BValueAlternatives_3_0_in_rule__Constant__BValueAssignment_313056);
            rule__Constant__BValueAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getBValueAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__BValueAssignment_3"


    // $ANTLR start "rule__NumValue__ValAssignment"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6425:1: rule__NumValue__ValAssignment : ( RULE_NUMBER ) ;
    public final void rule__NumValue__ValAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6429:1: ( ( RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6430:1: ( RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6430:1: ( RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6431:1: RULE_NUMBER
            {
             before(grammarAccess.getNumValueAccess().getValNUMBERTerminalRuleCall_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__NumValue__ValAssignment13089); 
             after(grammarAccess.getNumValueAccess().getValNUMBERTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumValue__ValAssignment"


    // $ANTLR start "rule__Type__NameAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6440:1: rule__Type__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__Type__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6444:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6445:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6445:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6446:1: ruleIdentifier
            {
             before(grammarAccess.getTypeAccess().getNameIdentifierParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__Type__NameAssignment_013120);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getNameIdentifierParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__NameAssignment_0"


    // $ANTLR start "rule__Type__SetAssignment_1_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6455:1: rule__Type__SetAssignment_1_0 : ( ( 'setOf' ) ) ;
    public final void rule__Type__SetAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6459:1: ( ( ( 'setOf' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6460:1: ( ( 'setOf' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6460:1: ( ( 'setOf' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6461:1: ( 'setOf' )
            {
             before(grammarAccess.getTypeAccess().getSetSetOfKeyword_1_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6462:1: ( 'setOf' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6463:1: 'setOf'
            {
             before(grammarAccess.getTypeAccess().getSetSetOfKeyword_1_0_0()); 
            match(input,48,FOLLOW_48_in_rule__Type__SetAssignment_1_013156); 
             after(grammarAccess.getTypeAccess().getSetSetOfKeyword_1_0_0()); 

            }

             after(grammarAccess.getTypeAccess().getSetSetOfKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__SetAssignment_1_0"


    // $ANTLR start "rule__Type__ParamAssignment_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6478:1: rule__Type__ParamAssignment_1_1 : ( ruleTypeParameters ) ;
    public final void rule__Type__ParamAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6482:1: ( ( ruleTypeParameters ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6483:1: ( ruleTypeParameters )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6483:1: ( ruleTypeParameters )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6484:1: ruleTypeParameters
            {
             before(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_1_113195);
            ruleTypeParameters();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__ParamAssignment_1_1"


    // $ANTLR start "rule__Type__SeqAssignment_2_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6493:1: rule__Type__SeqAssignment_2_0 : ( ( 'sequenceOf' ) ) ;
    public final void rule__Type__SeqAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6497:1: ( ( ( 'sequenceOf' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6498:1: ( ( 'sequenceOf' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6498:1: ( ( 'sequenceOf' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6499:1: ( 'sequenceOf' )
            {
             before(grammarAccess.getTypeAccess().getSeqSequenceOfKeyword_2_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6500:1: ( 'sequenceOf' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6501:1: 'sequenceOf'
            {
             before(grammarAccess.getTypeAccess().getSeqSequenceOfKeyword_2_0_0()); 
            match(input,49,FOLLOW_49_in_rule__Type__SeqAssignment_2_013231); 
             after(grammarAccess.getTypeAccess().getSeqSequenceOfKeyword_2_0_0()); 

            }

             after(grammarAccess.getTypeAccess().getSeqSequenceOfKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__SeqAssignment_2_0"


    // $ANTLR start "rule__Type__ParamAssignment_2_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6516:1: rule__Type__ParamAssignment_2_1 : ( ruleTypeParameters ) ;
    public final void rule__Type__ParamAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6520:1: ( ( ruleTypeParameters ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6521:1: ( ruleTypeParameters )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6521:1: ( ruleTypeParameters )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6522:1: ruleTypeParameters
            {
             before(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_2_113270);
            ruleTypeParameters();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__ParamAssignment_2_1"


    // $ANTLR start "rule__Type__MapAssignment_3_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6531:1: rule__Type__MapAssignment_3_0 : ( ( 'mapOf' ) ) ;
    public final void rule__Type__MapAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6535:1: ( ( ( 'mapOf' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6536:1: ( ( 'mapOf' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6536:1: ( ( 'mapOf' ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6537:1: ( 'mapOf' )
            {
             before(grammarAccess.getTypeAccess().getMapMapOfKeyword_3_0_0()); 
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6538:1: ( 'mapOf' )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6539:1: 'mapOf'
            {
             before(grammarAccess.getTypeAccess().getMapMapOfKeyword_3_0_0()); 
            match(input,50,FOLLOW_50_in_rule__Type__MapAssignment_3_013306); 
             after(grammarAccess.getTypeAccess().getMapMapOfKeyword_3_0_0()); 

            }

             after(grammarAccess.getTypeAccess().getMapMapOfKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__MapAssignment_3_0"


    // $ANTLR start "rule__Type__ParamAssignment_3_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6554:1: rule__Type__ParamAssignment_3_1 : ( ruleTypeParameters ) ;
    public final void rule__Type__ParamAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6558:1: ( ( ruleTypeParameters ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6559:1: ( ruleTypeParameters )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6559:1: ( ruleTypeParameters )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6560:1: ruleTypeParameters
            {
             before(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_3_113345);
            ruleTypeParameters();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__ParamAssignment_3_1"


    // $ANTLR start "rule__TypeParameters__ParamAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6569:1: rule__TypeParameters__ParamAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__TypeParameters__ParamAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6573:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6574:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6574:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6575:1: ruleIdentifier
            {
             before(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__TypeParameters__ParamAssignment_113376);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__ParamAssignment_1"


    // $ANTLR start "rule__TypeParameters__ParamAssignment_2_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6584:1: rule__TypeParameters__ParamAssignment_2_1 : ( ruleIdentifier ) ;
    public final void rule__TypeParameters__ParamAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6588:1: ( ( ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6589:1: ( ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6589:1: ( ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6590:1: ruleIdentifier
            {
             before(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleIdentifier_in_rule__TypeParameters__ParamAssignment_2_113407);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeParameters__ParamAssignment_2_1"


    // $ANTLR start "rule__ContainerInitializer__ExprsAssignment_2_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6599:1: rule__ContainerInitializer__ExprsAssignment_2_0 : ( ruleContainerInitializerExpression ) ;
    public final void rule__ContainerInitializer__ExprsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6603:1: ( ( ruleContainerInitializerExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6604:1: ( ruleContainerInitializerExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6604:1: ( ruleContainerInitializerExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6605:1: ruleContainerInitializerExpression
            {
             before(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_rule__ContainerInitializer__ExprsAssignment_2_013438);
            ruleContainerInitializerExpression();

            state._fsp--;

             after(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__ExprsAssignment_2_0"


    // $ANTLR start "rule__ContainerInitializer__ExprsAssignment_2_1_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6614:1: rule__ContainerInitializer__ExprsAssignment_2_1_1 : ( ruleContainerInitializerExpression ) ;
    public final void rule__ContainerInitializer__ExprsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6618:1: ( ( ruleContainerInitializerExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6619:1: ( ruleContainerInitializerExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6619:1: ( ruleContainerInitializerExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6620:1: ruleContainerInitializerExpression
            {
             before(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_rule__ContainerInitializer__ExprsAssignment_2_1_113469);
            ruleContainerInitializerExpression();

            state._fsp--;

             after(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializer__ExprsAssignment_2_1_1"


    // $ANTLR start "rule__ContainerInitializerExpression__LogicalAssignment_0"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6629:1: rule__ContainerInitializerExpression__LogicalAssignment_0 : ( ruleLogicalExpression ) ;
    public final void rule__ContainerInitializerExpression__LogicalAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6633:1: ( ( ruleLogicalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6634:1: ( ruleLogicalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6634:1: ( ruleLogicalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6635:1: ruleLogicalExpression
            {
             before(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleLogicalExpression_in_rule__ContainerInitializerExpression__LogicalAssignment_013500);
            ruleLogicalExpression();

            state._fsp--;

             after(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializerExpression__LogicalAssignment_0"


    // $ANTLR start "rule__ContainerInitializerExpression__ContainerAssignment_1"
    // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6644:1: rule__ContainerInitializerExpression__ContainerAssignment_1 : ( ruleContainerInitializer ) ;
    public final void rule__ContainerInitializerExpression__ContainerAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6648:1: ( ( ruleContainerInitializer ) )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6649:1: ( ruleContainerInitializer )
            {
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6649:1: ( ruleContainerInitializer )
            // ../de.uni_hildesheim.sse.vil.expressions.ui/src-gen/de/uni_hildesheim/sse/vil/expressions/ui/contentassist/antlr/internal/InternalExpressionDsl.g:6650:1: ruleContainerInitializer
            {
             before(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContainerInitializer_in_rule__ContainerInitializerExpression__ContainerAssignment_113531);
            ruleContainerInitializer();

            state._fsp--;

             after(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContainerInitializerExpression__ContainerAssignment_1"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\14\uffff";
    static final String DFA9_eofS =
        "\2\uffff\3\1\4\uffff\3\1";
    static final String DFA9_minS =
        "\1\4\1\uffff\3\15\2\uffff\1\4\1\uffff\3\15";
    static final String DFA9_maxS =
        "\1\51\1\uffff\3\57\2\uffff\1\6\1\uffff\3\57";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\4\1\uffff\1\2\3\uffff";
    static final String DFA9_specialS =
        "\14\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\3\1\4\2\1\24\uffff\2\1\1\uffff\1\1\6\uffff\1\5\1\uffff"+
            "\1\6",
            "",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7",
            "",
            "",
            "\1\11\1\12\1\13",
            "",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7",
            "\16\1\5\uffff\1\10\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff\2\1"+
            "\2\uffff\1\1\1\7"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1594:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__OtherExAssignment_0 ) ) | ( ( rule__PrimaryExpression__UnqExAssignment_1 ) ) | ( ( rule__PrimaryExpression__SuperExAssignment_2 ) ) | ( ( rule__PrimaryExpression__NewExAssignment_3 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__0_in_ruleLanguageUnit94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__0_in_ruleAdvice156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__0_in_ruleVersionSpec216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__0_in_ruleVersionedId276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionOperator__Alternatives_in_ruleVersionOperator336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__0_in_ruleVersionStmt458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpression__Group__0_in_ruleLogicalExpression640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__Group__0_in_ruleLogicalExpressionPart700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalOperator__Alternatives_in_ruleLogicalOperator760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__Group__0_in_ruleEqualityExpressionPart880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityOperator__Alternatives_in_ruleEqualityOperator940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__Group__0_in_ruleRelationalExpressionPart1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalOperator__Alternatives_in_ruleRelationalOperator1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__Group__0_in_ruleAdditiveExpressionPart1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator1267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__Group__0_in_ruleMultiplicativeExpressionPart1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator1447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group__0_in_ruleUnaryExpression1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator1567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression1627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PostfixExpression__LeftAssignment_in_rulePostfixExpression1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution1747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group__0_in_ruleExpressionOrQualifiedExecution1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution1807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution1814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__Group__0_in_ruleUnqualifiedExecution1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution1867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__0_in_ruleSuperExecution1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution1927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__0_in_ruleConstructorExecution1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall1987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Alternatives_in_ruleSubCall2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall2047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0_in_ruleCall2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList2107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group__0_in_ruleArgumentList2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument2167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group__0_in_ruleNamedArgument2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix2227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group__0_in_ruleQualifiedPrefix2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant2347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_in_ruleConstant2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue2407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumValue__ValAssignment_in_ruleNumValue2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier2467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Identifier__Alternatives_in_ruleIdentifier2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType2527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters2587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__0_in_ruleTypeParameters2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer2647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__0_in_ruleContainerInitializer2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression2707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializerExpression__Alternatives_in_ruleContainerInitializerExpression2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VersionOperator__Alternatives2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VersionOperator__Alternatives2797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VersionOperator__Alternatives2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VersionOperator__Alternatives2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VersionOperator__Alternatives2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__ExprAssignment_0_in_rule__Expression__Alternatives2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__InitAssignment_1_in_rule__Expression__Alternatives2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LogicalOperator__Alternatives2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LogicalOperator__Alternatives2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LogicalOperator__Alternatives2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__EqualityOperator__Alternatives3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__EqualityOperator__Alternatives3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__EqualityOperator__Alternatives3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RelationalOperator__Alternatives3093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RelationalOperator__Alternatives3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__RelationalOperator__Alternatives3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__RelationalOperator__Alternatives3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__AdditiveOperator__Alternatives3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__AdditiveOperator__Alternatives3208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicativeOperator__Alternatives3243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MultiplicativeOperator__Alternatives3263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__UnaryOperator__Alternatives3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__UnaryOperator__Alternatives3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__UnaryOperator__Alternatives3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__OtherExAssignment_0_in_rule__PrimaryExpression__Alternatives3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__UnqExAssignment_1_in_rule__PrimaryExpression__Alternatives3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__SuperExAssignment_2_in_rule__PrimaryExpression__Alternatives3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__NewExAssignment_3_in_rule__PrimaryExpression__Alternatives3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__ValAssignment_0_0_in_rule__ExpressionOrQualifiedExecution__Alternatives_03459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__0_in_rule__ExpressionOrQualifiedExecution__Alternatives_03477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_0__0_in_rule__SubCall__Alternatives3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__0_in_rule__SubCall__Alternatives3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__NValueAssignment_0_in_rule__Constant__Alternatives3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__SValueAssignment_1_in_rule__Constant__Alternatives3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__QValueAssignment_2_in_rule__Constant__Alternatives3597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__BValueAssignment_3_in_rule__Constant__Alternatives3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Constant__BValueAlternatives_3_03649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Constant__BValueAlternatives_3_03669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Identifier__Alternatives3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_rule__Identifier__Alternatives3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_rule__Identifier__Alternatives3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__NameAssignment_0_in_rule__Type__Alternatives3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__0_in_rule__Type__Alternatives3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_2__0_in_rule__Type__Alternatives3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_3__0_in_rule__Type__Alternatives3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializerExpression__LogicalAssignment_0_in_rule__ContainerInitializerExpression__Alternatives3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializerExpression__ContainerAssignment_1_in_rule__ContainerInitializerExpression__Alternatives3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__0__Impl_in_rule__LanguageUnit__Group__03905 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__1_in_rule__LanguageUnit__Group__03908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__AdvicesAssignment_0_in_rule__LanguageUnit__Group__0__Impl3935 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__1__Impl_in_rule__LanguageUnit__Group__13966 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__2_in_rule__LanguageUnit__Group__13969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__NameAssignment_1_in_rule__LanguageUnit__Group__1__Impl3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__2__Impl_in_rule__LanguageUnit__Group__24026 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__3_in_rule__LanguageUnit__Group__24029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__VersionAssignment_2_in_rule__LanguageUnit__Group__2__Impl4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__Group__3__Impl_in_rule__LanguageUnit__Group__34087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LanguageUnit__ImportsAssignment_3_in_rule__LanguageUnit__Group__3__Impl4114 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__0__Impl_in_rule__Advice__Group__04155 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Advice__Group__1_in_rule__Advice__Group__04158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Advice__Group__0__Impl4186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__1__Impl_in_rule__Advice__Group__14217 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__Advice__Group__2_in_rule__Advice__Group__14220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Advice__Group__1__Impl4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__2__Impl_in_rule__Advice__Group__24279 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Advice__Group__3_in_rule__Advice__Group__24282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__NameAssignment_2_in_rule__Advice__Group__2__Impl4309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__3__Impl_in_rule__Advice__Group__34339 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Advice__Group__4_in_rule__Advice__Group__34342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Advice__Group__3__Impl4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__Group__4__Impl_in_rule__Advice__Group__44401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Advice__VersionSpecAssignment_4_in_rule__Advice__Group__4__Impl4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__0__Impl_in_rule__VersionSpec__Group__04469 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__1_in_rule__VersionSpec__Group__04472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VersionSpec__Group__0__Impl4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__1__Impl_in_rule__VersionSpec__Group__14531 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__2_in_rule__VersionSpec__Group__14534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__VersionSpec__Group__1__Impl4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__2__Impl_in_rule__VersionSpec__Group__24593 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__3_in_rule__VersionSpec__Group__24596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__ConflictsAssignment_2_in_rule__VersionSpec__Group__2__Impl4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__3__Impl_in_rule__VersionSpec__Group__34653 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__4_in_rule__VersionSpec__Group__34656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group_3__0_in_rule__VersionSpec__Group__3__Impl4683 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group__4__Impl_in_rule__VersionSpec__Group__44714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__VersionSpec__Group__4__Impl4742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group_3__0__Impl_in_rule__VersionSpec__Group_3__04783 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group_3__1_in_rule__VersionSpec__Group_3__04786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VersionSpec__Group_3__0__Impl4814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__Group_3__1__Impl_in_rule__VersionSpec__Group_3__14845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionSpec__ConflictsAssignment_3_1_in_rule__VersionSpec__Group_3__1__Impl4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__0__Impl_in_rule__VersionedId__Group__04906 = new BitSet(new long[]{0x000000000003E000L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__1_in_rule__VersionedId__Group__04909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__VersionedId__Group__0__Impl4937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__1__Impl_in_rule__VersionedId__Group__14968 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__2_in_rule__VersionedId__Group__14971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__OpAssignment_1_in_rule__VersionedId__Group__1__Impl4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__Group__2__Impl_in_rule__VersionedId__Group__25028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionedId__VersionAssignment_2_in_rule__VersionedId__Group__2__Impl5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05093 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_0_in_rule__Parameter__Group__0__Impl5123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__0__Impl_in_rule__VersionStmt__Group__05214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__1_in_rule__VersionStmt__Group__05217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__VersionStmt__Group__0__Impl5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__1__Impl_in_rule__VersionStmt__Group__15276 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__2_in_rule__VersionStmt__Group__15279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionStmt__VersionAssignment_1_in_rule__VersionStmt__Group__1__Impl5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VersionStmt__Group__2__Impl_in_rule__VersionStmt__Group__25336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__VersionStmt__Group__2__Impl5364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__05401 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__05404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Import__Group__0__Impl5432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__15463 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_rule__Import__Group__2_in_rule__Import__Group__15466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__NameAssignment_1_in_rule__Import__Group__1__Impl5493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__2__Impl_in_rule__Import__Group__25523 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_rule__Import__Group__3_in_rule__Import__Group__25526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__VersionSpecAssignment_2_in_rule__Import__Group__2__Impl5553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__3__Impl_in_rule__Import__Group__35584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Import__Group__3__Impl5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpression__Group__0__Impl_in_rule__LogicalExpression__Group__05653 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_rule__LogicalExpression__Group__1_in_rule__LogicalExpression__Group__05656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpression__LeftAssignment_0_in_rule__LogicalExpression__Group__0__Impl5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpression__Group__1__Impl_in_rule__LogicalExpression__Group__15713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpression__RightAssignment_1_in_rule__LogicalExpression__Group__1__Impl5740 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__Group__0__Impl_in_rule__LogicalExpressionPart__Group__05775 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__Group__1_in_rule__LogicalExpressionPart__Group__05778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__OpAssignment_0_in_rule__LogicalExpressionPart__Group__0__Impl5805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__Group__1__Impl_in_rule__LogicalExpressionPart__Group__15835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LogicalExpressionPart__ExAssignment_1_in_rule__LogicalExpressionPart__Group__1__Impl5862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__05896 = new BitSet(new long[]{0x0000000000602000L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__05899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__LeftAssignment_0_in_rule__EqualityExpression__Group__0__Impl5926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__15956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__RightAssignment_1_in_rule__EqualityExpression__Group__1__Impl5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__Group__0__Impl_in_rule__EqualityExpressionPart__Group__06018 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__Group__1_in_rule__EqualityExpressionPart__Group__06021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__OpAssignment_0_in_rule__EqualityExpressionPart__Group__0__Impl6048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__Group__1__Impl_in_rule__EqualityExpressionPart__Group__16078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpressionPart__ExAssignment_1_in_rule__EqualityExpressionPart__Group__1__Impl6105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__06139 = new BitSet(new long[]{0x000000000003C000L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__06142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__LeftAssignment_0_in_rule__RelationalExpression__Group__0__Impl6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__16199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__RightAssignment_1_in_rule__RelationalExpression__Group__1__Impl6226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__Group__0__Impl_in_rule__RelationalExpressionPart__Group__06261 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__Group__1_in_rule__RelationalExpressionPart__Group__06264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__OpAssignment_0_in_rule__RelationalExpressionPart__Group__0__Impl6291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__Group__1__Impl_in_rule__RelationalExpressionPart__Group__16321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpressionPart__ExAssignment_1_in_rule__RelationalExpressionPart__Group__1__Impl6348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__06382 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__06385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__LeftAssignment_0_in_rule__AdditiveExpression__Group__0__Impl6412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__16442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__RightAssignment_1_in_rule__AdditiveExpression__Group__1__Impl6469 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__Group__0__Impl_in_rule__AdditiveExpressionPart__Group__06504 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__Group__1_in_rule__AdditiveExpressionPart__Group__06507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__OpAssignment_0_in_rule__AdditiveExpressionPart__Group__0__Impl6534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__Group__1__Impl_in_rule__AdditiveExpressionPart__Group__16564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpressionPart__ExAssignment_1_in_rule__AdditiveExpressionPart__Group__1__Impl6591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__06625 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__06628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__LeftAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl6655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__16685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__RightAssignment_1_in_rule__MultiplicativeExpression__Group__1__Impl6712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__Group__0__Impl_in_rule__MultiplicativeExpressionPart__Group__06747 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__Group__1_in_rule__MultiplicativeExpressionPart__Group__06750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__OpAssignment_0_in_rule__MultiplicativeExpressionPart__Group__0__Impl6777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__Group__1__Impl_in_rule__MultiplicativeExpressionPart__Group__16807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpressionPart__ExprAssignment_1_in_rule__MultiplicativeExpressionPart__Group__1__Impl6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group__0__Impl_in_rule__UnaryExpression__Group__06868 = new BitSet(new long[]{0x00000281790001F0L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group__1_in_rule__UnaryExpression__Group__06871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__OpAssignment_0_in_rule__UnaryExpression__Group__0__Impl6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group__1__Impl_in_rule__UnaryExpression__Group__16929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__ExprAssignment_1_in_rule__UnaryExpression__Group__1__Impl6956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group__0__Impl_in_rule__ExpressionOrQualifiedExecution__Group__06990 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group__1_in_rule__ExpressionOrQualifiedExecution__Group__06993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Alternatives_0_in_rule__ExpressionOrQualifiedExecution__Group__0__Impl7020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group__1__Impl_in_rule__ExpressionOrQualifiedExecution__Group__17050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__CallsAssignment_1_in_rule__ExpressionOrQualifiedExecution__Group__1__Impl7077 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__07112 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__1_in_rule__ExpressionOrQualifiedExecution__Group_0_1__07115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ExpressionOrQualifiedExecution__Group_0_1__0__Impl7143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__17174 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__2_in_rule__ExpressionOrQualifiedExecution__Group_0_1__17177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1_in_rule__ExpressionOrQualifiedExecution__Group_0_1__1__Impl7204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl_in_rule__ExpressionOrQualifiedExecution__Group_0_1__27234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ExpressionOrQualifiedExecution__Group_0_1__2__Impl7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__Group__0__Impl_in_rule__UnqualifiedExecution__Group__07299 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__Group__1_in_rule__UnqualifiedExecution__Group__07302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__CallAssignment_0_in_rule__UnqualifiedExecution__Group__0__Impl7329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__Group__1__Impl_in_rule__UnqualifiedExecution__Group__17359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnqualifiedExecution__CallsAssignment_1_in_rule__UnqualifiedExecution__Group__1__Impl7386 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__0__Impl_in_rule__SuperExecution__Group__07421 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__1_in_rule__SuperExecution__Group__07424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SuperExecution__Group__0__Impl7452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__1__Impl_in_rule__SuperExecution__Group__17483 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__2_in_rule__SuperExecution__Group__17486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__SuperExecution__Group__1__Impl7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__2__Impl_in_rule__SuperExecution__Group__27545 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__3_in_rule__SuperExecution__Group__27548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__CallAssignment_2_in_rule__SuperExecution__Group__2__Impl7575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__Group__3__Impl_in_rule__SuperExecution__Group__37605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuperExecution__CallsAssignment_3_in_rule__SuperExecution__Group__3__Impl7632 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__0__Impl_in_rule__ConstructorExecution__Group__07671 = new BitSet(new long[]{0x0007000000000070L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__1_in_rule__ConstructorExecution__Group__07674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ConstructorExecution__Group__0__Impl7702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__1__Impl_in_rule__ConstructorExecution__Group__17733 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__2_in_rule__ConstructorExecution__Group__17736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__TypeAssignment_1_in_rule__ConstructorExecution__Group__1__Impl7763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__2__Impl_in_rule__ConstructorExecution__Group__27793 = new BitSet(new long[]{0x00002283790001F0L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__3_in_rule__ConstructorExecution__Group__27796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ConstructorExecution__Group__2__Impl7824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__3__Impl_in_rule__ConstructorExecution__Group__37855 = new BitSet(new long[]{0x00002283790001F0L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__4_in_rule__ConstructorExecution__Group__37858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__ParamAssignment_3_in_rule__ConstructorExecution__Group__3__Impl7885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__4__Impl_in_rule__ConstructorExecution__Group__47916 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__5_in_rule__ConstructorExecution__Group__47919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ConstructorExecution__Group__4__Impl7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__Group__5__Impl_in_rule__ConstructorExecution__Group__57978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstructorExecution__CallsAssignment_5_in_rule__ConstructorExecution__Group__5__Impl8005 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_0__0__Impl_in_rule__SubCall__Group_0__08048 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__SubCall__Group_0__1_in_rule__SubCall__Group_0__08051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__SubCall__Group_0__0__Impl8079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_0__1__Impl_in_rule__SubCall__Group_0__18110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__CallAssignment_0_1_in_rule__SubCall__Group_0__1__Impl8137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__0__Impl_in_rule__SubCall__Group_1__08171 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__1_in_rule__SubCall__Group_1__08174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__SubCall__Group_1__0__Impl8202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__1__Impl_in_rule__SubCall__Group_1__18233 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__2_in_rule__SubCall__Group_1__18236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__ArrayExAssignment_1_1_in_rule__SubCall__Group_1__1__Impl8263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubCall__Group_1__2__Impl_in_rule__SubCall__Group_1__28293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__SubCall__Group_1__2__Impl8321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08358 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__NameAssignment_0_in_rule__Call__Group__0__Impl8388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18418 = new BitSet(new long[]{0x00002283790001F0L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Call__Group__1__Impl8449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28480 = new BitSet(new long[]{0x00002283790001F0L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParamAssignment_2_in_rule__Call__Group__2__Impl8510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Call__Group__3__Impl8569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group__0__Impl_in_rule__ArgumentList__Group__08608 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group__1_in_rule__ArgumentList__Group__08611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__ParamAssignment_0_in_rule__ArgumentList__Group__0__Impl8638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group__1__Impl_in_rule__ArgumentList__Group__18668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group_1__0_in_rule__ArgumentList__Group__1__Impl8695 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group_1__0__Impl_in_rule__ArgumentList__Group_1__08730 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group_1__1_in_rule__ArgumentList__Group_1__08733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ArgumentList__Group_1__0__Impl8761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__Group_1__1__Impl_in_rule__ArgumentList__Group_1__18792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgumentList__ParamAssignment_1_1_in_rule__ArgumentList__Group_1__1__Impl8819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group__0__Impl_in_rule__NamedArgument__Group__08853 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group__1_in_rule__NamedArgument__Group__08856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group_0__0_in_rule__NamedArgument__Group__0__Impl8883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group__1__Impl_in_rule__NamedArgument__Group__18914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__ExAssignment_1_in_rule__NamedArgument__Group__1__Impl8941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group_0__0__Impl_in_rule__NamedArgument__Group_0__08975 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group_0__1_in_rule__NamedArgument__Group_0__08978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__NameAssignment_0_0_in_rule__NamedArgument__Group_0__0__Impl9005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedArgument__Group_0__1__Impl_in_rule__NamedArgument__Group_0__19035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__NamedArgument__Group_0__1__Impl9063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group__0__Impl_in_rule__QualifiedPrefix__Group__09098 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group__1_in_rule__QualifiedPrefix__Group__09101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__QnameAssignment_0_in_rule__QualifiedPrefix__Group__0__Impl9128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group__1__Impl_in_rule__QualifiedPrefix__Group__19158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group_1__0_in_rule__QualifiedPrefix__Group__1__Impl9185 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group_1__0__Impl_in_rule__QualifiedPrefix__Group_1__09220 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group_1__1_in_rule__QualifiedPrefix__Group_1__09223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__QnameAssignment_1_0_in_rule__QualifiedPrefix__Group_1__0__Impl9250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__Group_1__1__Impl_in_rule__QualifiedPrefix__Group_1__19280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedPrefix__QnameAssignment_1_1_in_rule__QualifiedPrefix__Group_1__1__Impl9307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__09341 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__09344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PrefixAssignment_0_in_rule__QualifiedName__Group__0__Impl9371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__19401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl9428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__09463 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__09466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__QnameAssignment_1_0_in_rule__QualifiedName__Group_1__0__Impl9493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__19523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__QnameAssignment_1_1_in_rule__QualifiedName__Group_1__1__Impl9550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__09584 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__09587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SetAssignment_1_0_in_rule__Type__Group_1__0__Impl9614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__19644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__ParamAssignment_1_1_in_rule__Type__Group_1__1__Impl9671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_2__0__Impl_in_rule__Type__Group_2__09705 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Type__Group_2__1_in_rule__Type__Group_2__09708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SeqAssignment_2_0_in_rule__Type__Group_2__0__Impl9735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_2__1__Impl_in_rule__Type__Group_2__19765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__ParamAssignment_2_1_in_rule__Type__Group_2__1__Impl9792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_3__0__Impl_in_rule__Type__Group_3__09826 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Type__Group_3__1_in_rule__Type__Group_3__09829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__MapAssignment_3_0_in_rule__Type__Group_3__0__Impl9856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_3__1__Impl_in_rule__Type__Group_3__19886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__ParamAssignment_3_1_in_rule__Type__Group_3__1__Impl9913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__0__Impl_in_rule__TypeParameters__Group__09947 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__1_in_rule__TypeParameters__Group__09950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__TypeParameters__Group__0__Impl9978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__1__Impl_in_rule__TypeParameters__Group__110009 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__2_in_rule__TypeParameters__Group__110012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__ParamAssignment_1_in_rule__TypeParameters__Group__1__Impl10039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__2__Impl_in_rule__TypeParameters__Group__210069 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__3_in_rule__TypeParameters__Group__210072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group_2__0_in_rule__TypeParameters__Group__2__Impl10099 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group__3__Impl_in_rule__TypeParameters__Group__310130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__TypeParameters__Group__3__Impl10158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group_2__0__Impl_in_rule__TypeParameters__Group_2__010197 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group_2__1_in_rule__TypeParameters__Group_2__010200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__TypeParameters__Group_2__0__Impl10228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__Group_2__1__Impl_in_rule__TypeParameters__Group_2__110259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeParameters__ParamAssignment_2_1_in_rule__TypeParameters__Group_2__1__Impl10286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__0__Impl_in_rule__ContainerInitializer__Group__010320 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__1_in_rule__ContainerInitializer__Group__010323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__1__Impl_in_rule__ContainerInitializer__Group__110381 = new BitSet(new long[]{0x00006281790001F0L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__2_in_rule__ContainerInitializer__Group__110384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ContainerInitializer__Group__1__Impl10412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__2__Impl_in_rule__ContainerInitializer__Group__210443 = new BitSet(new long[]{0x00006281790001F0L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__3_in_rule__ContainerInitializer__Group__210446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2__0_in_rule__ContainerInitializer__Group__2__Impl10473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group__3__Impl_in_rule__ContainerInitializer__Group__310504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ContainerInitializer__Group__3__Impl10532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2__0__Impl_in_rule__ContainerInitializer__Group_2__010571 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2__1_in_rule__ContainerInitializer__Group_2__010574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__ExprsAssignment_2_0_in_rule__ContainerInitializer__Group_2__0__Impl10601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2__1__Impl_in_rule__ContainerInitializer__Group_2__110631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2_1__0_in_rule__ContainerInitializer__Group_2__1__Impl10658 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2_1__0__Impl_in_rule__ContainerInitializer__Group_2_1__010693 = new BitSet(new long[]{0x00002281790001F0L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2_1__1_in_rule__ContainerInitializer__Group_2_1__010696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ContainerInitializer__Group_2_1__0__Impl10724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__Group_2_1__1__Impl_in_rule__ContainerInitializer__Group_2_1__110755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContainerInitializer__ExprsAssignment_2_1_1_in_rule__ContainerInitializer__Group_2_1__1__Impl10782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_rule__LanguageUnit__AdvicesAssignment_010821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__LanguageUnit__NameAssignment_110852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_rule__LanguageUnit__VersionAssignment_210883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__LanguageUnit__ImportsAssignment_310914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Advice__NameAssignment_210949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_rule__Advice__VersionSpecAssignment_410980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_rule__VersionSpec__ConflictsAssignment_211011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_rule__VersionSpec__ConflictsAssignment_3_111042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_rule__VersionedId__OpAssignment_111073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_rule__VersionedId__VersionAssignment_211104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_011137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__Parameter__NameAssignment_111168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_rule__VersionStmt__VersionAssignment_111199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__Import__NameAssignment_111230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_rule__Import__VersionSpecAssignment_211261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_rule__Expression__ExprAssignment_011294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_rule__Expression__InitAssignment_111325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__LogicalExpression__LeftAssignment_011356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_rule__LogicalExpression__RightAssignment_111387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_rule__LogicalExpressionPart__OpAssignment_011418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__LogicalExpressionPart__ExAssignment_111449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__LeftAssignment_011480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_rule__EqualityExpression__RightAssignment_111511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_rule__EqualityExpressionPart__OpAssignment_011542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpressionPart__ExAssignment_111573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__RelationalExpression__LeftAssignment_011604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_rule__RelationalExpression__RightAssignment_111635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_rule__RelationalExpressionPart__OpAssignment_011666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__RelationalExpressionPart__ExAssignment_111697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__LeftAssignment_011728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_rule__AdditiveExpression__RightAssignment_111759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpressionPart__OpAssignment_011790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpressionPart__ExAssignment_111821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__LeftAssignment_011852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_rule__MultiplicativeExpression__RightAssignment_111883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpressionPart__OpAssignment_011914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpressionPart__ExprAssignment_111945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__UnaryExpression__OpAssignment_011976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_rule__UnaryExpression__ExprAssignment_112007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__LeftAssignment12038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rule__PrimaryExpression__OtherExAssignment_012069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rule__PrimaryExpression__UnqExAssignment_112100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rule__PrimaryExpression__SuperExAssignment_212131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rule__PrimaryExpression__NewExAssignment_312162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__ExpressionOrQualifiedExecution__ValAssignment_0_012193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_112224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_rule__ExpressionOrQualifiedExecution__CallsAssignment_112255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__UnqualifiedExecution__CallAssignment_012286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_rule__UnqualifiedExecution__CallsAssignment_112317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuperExecution__CallAssignment_212348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_rule__SuperExecution__CallsAssignment_312379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__ConstructorExecution__TypeAssignment_112410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_rule__ConstructorExecution__ParamAssignment_312441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_rule__ConstructorExecution__CallsAssignment_512472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SubCall__CallAssignment_0_112503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__SubCall__ArrayExAssignment_1_112534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_rule__Call__NameAssignment_012565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_rule__Call__ParamAssignment_212596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_rule__ArgumentList__ParamAssignment_012627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_rule__ArgumentList__ParamAssignment_1_112658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__NamedArgument__NameAssignment_0_012689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__NamedArgument__ExAssignment_112720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__QualifiedPrefix__QnameAssignment_012751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__QualifiedPrefix__QnameAssignment_1_012787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__QualifiedPrefix__QnameAssignment_1_112826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_rule__QualifiedName__PrefixAssignment_012857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__QualifiedName__QnameAssignment_1_012893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__QualifiedName__QnameAssignment_1_112932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_rule__Constant__NValueAssignment_012963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Constant__SValueAssignment_112994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Constant__QValueAssignment_213025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__BValueAlternatives_3_0_in_rule__Constant__BValueAssignment_313056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__NumValue__ValAssignment13089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__Type__NameAssignment_013120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__Type__SetAssignment_1_013156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_1_113195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Type__SeqAssignment_2_013231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_2_113270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Type__MapAssignment_3_013306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_rule__Type__ParamAssignment_3_113345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__TypeParameters__ParamAssignment_113376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_rule__TypeParameters__ParamAssignment_2_113407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_rule__ContainerInitializer__ExprsAssignment_2_013438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_rule__ContainerInitializer__ExprsAssignment_2_1_113469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_rule__ContainerInitializerExpression__LogicalAssignment_013500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_rule__ContainerInitializerExpression__ContainerAssignment_113531 = new BitSet(new long[]{0x0000000000000002L});

}