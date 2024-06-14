package de.uni_hildesheim.sse.vil.buildlang.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVilBuildLanguageLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=5;
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
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=7;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=8;
    public static final int RULE_EXPONENT=6;
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

    public InternalVilBuildLanguageLexer() {;} 
    public InternalVilBuildLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalVilBuildLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalVilBuildLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:11:7: ( '=' )
            // InternalVilBuildLanguage.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12:7: ( ':' )
            // InternalVilBuildLanguage.g:12:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:13:7: ( 'import' )
            // InternalVilBuildLanguage.g:13:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:14:7: ( 'and' )
            // InternalVilBuildLanguage.g:14:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:15:7: ( 'or' )
            // InternalVilBuildLanguage.g:15:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:16:7: ( 'xor' )
            // InternalVilBuildLanguage.g:16:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:17:7: ( 'implies' )
            // InternalVilBuildLanguage.g:17:9: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:18:7: ( 'iff' )
            // InternalVilBuildLanguage.g:18:9: 'iff'
            {
            match("iff"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:19:7: ( '==' )
            // InternalVilBuildLanguage.g:19:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:20:7: ( '<>' )
            // InternalVilBuildLanguage.g:20:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:21:7: ( '!=' )
            // InternalVilBuildLanguage.g:21:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:22:7: ( '>' )
            // InternalVilBuildLanguage.g:22:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:23:7: ( '<' )
            // InternalVilBuildLanguage.g:23:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:24:7: ( '>=' )
            // InternalVilBuildLanguage.g:24:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:25:7: ( '<=' )
            // InternalVilBuildLanguage.g:25:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:26:7: ( '+' )
            // InternalVilBuildLanguage.g:26:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:27:7: ( '-' )
            // InternalVilBuildLanguage.g:27:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:28:7: ( '*' )
            // InternalVilBuildLanguage.g:28:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:29:7: ( '/' )
            // InternalVilBuildLanguage.g:29:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:30:7: ( 'not' )
            // InternalVilBuildLanguage.g:30:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:31:7: ( '!' )
            // InternalVilBuildLanguage.g:31:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:32:7: ( '.' )
            // InternalVilBuildLanguage.g:32:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:33:7: ( '->' )
            // InternalVilBuildLanguage.g:33:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:34:7: ( 'true' )
            // InternalVilBuildLanguage.g:34:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:35:7: ( 'false' )
            // InternalVilBuildLanguage.g:35:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:36:7: ( 'version' )
            // InternalVilBuildLanguage.g:36:9: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:37:7: ( 'requireVTL' )
            // InternalVilBuildLanguage.g:37:9: 'requireVTL'
            {
            match("requireVTL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:38:7: ( ';' )
            // InternalVilBuildLanguage.g:38:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:39:7: ( 'vilScript' )
            // InternalVilBuildLanguage.g:39:9: 'vilScript'
            {
            match("vilScript"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:40:7: ( '(' )
            // InternalVilBuildLanguage.g:40:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:41:7: ( ')' )
            // InternalVilBuildLanguage.g:41:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:42:7: ( '{' )
            // InternalVilBuildLanguage.g:42:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:43:7: ( '}' )
            // InternalVilBuildLanguage.g:43:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:44:7: ( 'extends' )
            // InternalVilBuildLanguage.g:44:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:45:7: ( 'load' )
            // InternalVilBuildLanguage.g:45:9: 'load'
            {
            match("load"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:46:7: ( 'properties' )
            // InternalVilBuildLanguage.g:46:9: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:47:7: ( ',' )
            // InternalVilBuildLanguage.g:47:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:48:7: ( 'instantiate' )
            // InternalVilBuildLanguage.g:48:9: 'instantiate'
            {
            match("instantiate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:49:7: ( 'map' )
            // InternalVilBuildLanguage.g:49:9: 'map'
            {
            match("map"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:50:7: ( 'for' )
            // InternalVilBuildLanguage.g:50:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:51:7: ( 'while' )
            // InternalVilBuildLanguage.g:51:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:52:7: ( 'if' )
            // InternalVilBuildLanguage.g:52:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:53:7: ( 'else' )
            // InternalVilBuildLanguage.g:53:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:54:7: ( 'join' )
            // InternalVilBuildLanguage.g:54:9: 'join'
            {
            match("join"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:55:7: ( 'with' )
            // InternalVilBuildLanguage.g:55:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:56:7: ( 'execute' )
            // InternalVilBuildLanguage.g:56:9: 'execute'
            {
            match("execute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:57:7: ( 'compound' )
            // InternalVilBuildLanguage.g:57:9: 'compound'
            {
            match("compound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:58:7: ( 'refines' )
            // InternalVilBuildLanguage.g:58:9: 'refines'
            {
            match("refines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:59:7: ( 'typedef' )
            // InternalVilBuildLanguage.g:59:9: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:60:7: ( '@advice' )
            // InternalVilBuildLanguage.g:60:9: '@advice'
            {
            match("@advice"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:61:7: ( 'super' )
            // InternalVilBuildLanguage.g:61:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:62:7: ( 'new' )
            // InternalVilBuildLanguage.g:62:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:63:7: ( '[' )
            // InternalVilBuildLanguage.g:63:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:64:7: ( ']' )
            // InternalVilBuildLanguage.g:64:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:65:7: ( '|' )
            // InternalVilBuildLanguage.g:65:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:66:7: ( '@' )
            // InternalVilBuildLanguage.g:66:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:67:7: ( 'protected' )
            // InternalVilBuildLanguage.g:67:9: 'protected'
            {
            match("protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:68:7: ( 'exclude' )
            // InternalVilBuildLanguage.g:68:9: 'exclude'
            {
            match("exclude"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:69:7: ( 'const' )
            // InternalVilBuildLanguage.g:69:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:70:7: ( 'abstract' )
            // InternalVilBuildLanguage.g:70:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:71:7: ( 'insert' )
            // InternalVilBuildLanguage.g:71:9: 'insert'
            {
            match("insert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:72:7: ( '::' )
            // InternalVilBuildLanguage.g:72:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:73:7: ( 'null' )
            // InternalVilBuildLanguage.g:73:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:74:7: ( 'setOf' )
            // InternalVilBuildLanguage.g:74:9: 'setOf'
            {
            match("setOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:75:7: ( 'sequenceOf' )
            // InternalVilBuildLanguage.g:75:9: 'sequenceOf'
            {
            match("sequenceOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:76:7: ( 'mapOf' )
            // InternalVilBuildLanguage.g:76:9: 'mapOf'
            {
            match("mapOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:77:7: ( 'callOf' )
            // InternalVilBuildLanguage.g:77:9: 'callOf'
            {
            match("callOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "RULE_VERSION"
    public final void mRULE_VERSION() throws RecognitionException {
        try {
            int _type = RULE_VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12870:14: ( 'v' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )* )
            // InternalVilBuildLanguage.g:12870:16: 'v' ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )*
            {
            match('v'); 
            // InternalVilBuildLanguage.g:12870:20: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:12870:21: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // InternalVilBuildLanguage.g:12870:32: ( '.' ( '0' .. '9' )+ )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='.') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:12870:33: '.' ( '0' .. '9' )+
            	    {
            	    match('.'); 
            	    // InternalVilBuildLanguage.g:12870:37: ( '0' .. '9' )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalVilBuildLanguage.g:12870:38: '0' .. '9'
            	    	    {
            	    	    matchRange('0','9'); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VERSION"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12872:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalVilBuildLanguage.g:12872:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalVilBuildLanguage.g:12872:39: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12874:13: ( ( '-' )? ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? | ( '0' .. '9' )+ RULE_EXPONENT ) )
            // InternalVilBuildLanguage.g:12874:15: ( '-' )? ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? | ( '0' .. '9' )+ RULE_EXPONENT )
            {
            // InternalVilBuildLanguage.g:12874:15: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVilBuildLanguage.g:12874:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalVilBuildLanguage.g:12874:20: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? | ( '0' .. '9' )+ RULE_EXPONENT )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalVilBuildLanguage.g:12874:21: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )?
                    {
                    // InternalVilBuildLanguage.g:12874:21: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:12874:22: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    // InternalVilBuildLanguage.g:12874:33: ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalVilBuildLanguage.g:12874:34: '.' ( '0' .. '9' )* ( RULE_EXPONENT )?
                            {
                            match('.'); 
                            // InternalVilBuildLanguage.g:12874:38: ( '0' .. '9' )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // InternalVilBuildLanguage.g:12874:39: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);

                            // InternalVilBuildLanguage.g:12874:50: ( RULE_EXPONENT )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0=='E'||LA8_0=='e') ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // InternalVilBuildLanguage.g:12874:50: RULE_EXPONENT
                                    {
                                    mRULE_EXPONENT(); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:12874:67: '.' ( '0' .. '9' )+ ( RULE_EXPONENT )?
                    {
                    match('.'); 
                    // InternalVilBuildLanguage.g:12874:71: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:12874:72: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    // InternalVilBuildLanguage.g:12874:83: ( RULE_EXPONENT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalVilBuildLanguage.g:12874:83: RULE_EXPONENT
                            {
                            mRULE_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:12874:98: ( '0' .. '9' )+ RULE_EXPONENT
                    {
                    // InternalVilBuildLanguage.g:12874:98: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:12874:99: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    mRULE_EXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            int _type = RULE_EXPONENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12876:15: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // InternalVilBuildLanguage.g:12876:17: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalVilBuildLanguage.g:12876:27: ( '+' | '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='+'||LA14_0=='-') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVilBuildLanguage.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:12876:38: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:12876:39: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12878:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalVilBuildLanguage.g:12878:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalVilBuildLanguage.g:12878:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\"') ) {
                alt18=1;
            }
            else if ( (LA18_0=='\'') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalVilBuildLanguage.g:12878:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalVilBuildLanguage.g:12878:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop16:
                    do {
                        int alt16=3;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='\\') ) {
                            alt16=1;
                        }
                        else if ( ((LA16_0>='\u0000' && LA16_0<='!')||(LA16_0>='#' && LA16_0<='[')||(LA16_0>=']' && LA16_0<='\uFFFF')) ) {
                            alt16=2;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:12878:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVilBuildLanguage.g:12878:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:12878:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalVilBuildLanguage.g:12878:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop17:
                    do {
                        int alt17=3;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='\\') ) {
                            alt17=1;
                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<='&')||(LA17_0>='(' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                            alt17=2;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:12878:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVilBuildLanguage.g:12878:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12880:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalVilBuildLanguage.g:12880:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalVilBuildLanguage.g:12880:24: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='*') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='/') ) {
                        alt19=2;
                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=')')||(LA19_0>='+' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:12880:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12882:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalVilBuildLanguage.g:12882:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalVilBuildLanguage.g:12882:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:12882:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalVilBuildLanguage.g:12882:40: ( ( '\\r' )? '\\n' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\n'||LA22_0=='\r') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalVilBuildLanguage.g:12882:41: ( '\\r' )? '\\n'
                    {
                    // InternalVilBuildLanguage.g:12882:41: ( '\\r' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='\r') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalVilBuildLanguage.g:12882:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12884:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalVilBuildLanguage.g:12884:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalVilBuildLanguage.g:12884:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\t' && LA23_0<='\n')||LA23_0=='\r'||LA23_0==' ') ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVilBuildLanguage.g:12886:16: ( . )
            // InternalVilBuildLanguage.g:12886:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalVilBuildLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | RULE_VERSION | RULE_ID | RULE_NUMBER | RULE_EXPONENT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt24=76;
        alt24 = dfa24.predict(input);
        switch (alt24) {
            case 1 :
                // InternalVilBuildLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalVilBuildLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalVilBuildLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalVilBuildLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalVilBuildLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalVilBuildLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalVilBuildLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalVilBuildLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalVilBuildLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalVilBuildLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalVilBuildLanguage.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalVilBuildLanguage.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalVilBuildLanguage.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalVilBuildLanguage.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalVilBuildLanguage.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalVilBuildLanguage.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalVilBuildLanguage.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalVilBuildLanguage.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalVilBuildLanguage.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalVilBuildLanguage.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalVilBuildLanguage.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalVilBuildLanguage.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalVilBuildLanguage.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalVilBuildLanguage.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalVilBuildLanguage.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalVilBuildLanguage.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalVilBuildLanguage.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalVilBuildLanguage.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalVilBuildLanguage.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalVilBuildLanguage.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalVilBuildLanguage.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalVilBuildLanguage.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalVilBuildLanguage.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalVilBuildLanguage.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalVilBuildLanguage.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalVilBuildLanguage.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalVilBuildLanguage.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalVilBuildLanguage.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalVilBuildLanguage.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalVilBuildLanguage.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalVilBuildLanguage.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalVilBuildLanguage.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalVilBuildLanguage.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalVilBuildLanguage.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalVilBuildLanguage.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalVilBuildLanguage.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalVilBuildLanguage.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalVilBuildLanguage.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalVilBuildLanguage.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalVilBuildLanguage.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalVilBuildLanguage.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalVilBuildLanguage.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalVilBuildLanguage.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalVilBuildLanguage.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalVilBuildLanguage.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalVilBuildLanguage.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalVilBuildLanguage.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalVilBuildLanguage.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalVilBuildLanguage.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalVilBuildLanguage.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalVilBuildLanguage.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalVilBuildLanguage.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalVilBuildLanguage.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalVilBuildLanguage.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalVilBuildLanguage.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalVilBuildLanguage.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // InternalVilBuildLanguage.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // InternalVilBuildLanguage.g:1:412: RULE_VERSION
                {
                mRULE_VERSION(); 

                }
                break;
            case 69 :
                // InternalVilBuildLanguage.g:1:425: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 70 :
                // InternalVilBuildLanguage.g:1:433: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 71 :
                // InternalVilBuildLanguage.g:1:445: RULE_EXPONENT
                {
                mRULE_EXPONENT(); 

                }
                break;
            case 72 :
                // InternalVilBuildLanguage.g:1:459: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 73 :
                // InternalVilBuildLanguage.g:1:471: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 74 :
                // InternalVilBuildLanguage.g:1:487: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 75 :
                // InternalVilBuildLanguage.g:1:503: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 76 :
                // InternalVilBuildLanguage.g:1:511: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA13_eotS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA13_eofS =
        "\5\uffff";
    static final String DFA13_minS =
        "\1\56\1\60\3\uffff";
    static final String DFA13_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA13_specialS =
        "\5\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\2\1\uffff\12\1",
            "\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
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
            return "12874:20: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* ( RULE_EXPONENT )? )? | '.' ( '0' .. '9' )+ ( RULE_EXPONENT )? | ( '0' .. '9' )+ RULE_EXPONENT )";
        }
    }
    static final String DFA24_eotS =
        "\1\uffff\1\56\1\60\4\64\1\73\1\75\1\77\1\uffff\1\103\1\uffff\1\107\1\64\1\113\4\64\5\uffff\3\64\1\uffff\4\64\1\147\1\64\3\uffff\1\64\2\uffff\2\54\6\uffff\1\64\1\161\1\64\1\uffff\2\64\1\165\1\64\17\uffff\3\64\1\uffff\6\64\1\u0080\1\64\5\uffff\3\64\1\uffff\2\64\1\uffff\6\64\2\uffff\2\64\5\uffff\1\64\1\u0095\1\uffff\1\64\1\u0098\1\64\1\uffff\1\u009a\1\u009b\1\u009c\4\64\1\u00a1\2\64\1\uffff\10\64\1\u00ae\13\64\1\uffff\2\64\1\uffff\1\64\3\uffff\1\u00bd\1\u00be\2\64\1\uffff\7\64\1\u00c8\1\u00c9\3\64\1\uffff\1\64\1\u00ce\1\u00cf\13\64\2\uffff\1\64\1\u00dc\7\64\2\uffff\2\64\1\u00e6\1\u00e7\2\uffff\1\64\1\u00e9\1\64\1\u00eb\1\u00ec\1\64\1\u00ee\2\64\1\u00f1\2\64\1\uffff\11\64\2\uffff\1\64\1\uffff\1\u00fe\2\uffff\1\64\1\uffff\1\u0100\1\64\1\uffff\1\64\1\u0103\1\u0104\2\64\1\u0107\1\u0108\1\u0109\1\u010a\3\64\1\uffff\1\64\1\uffff\1\64\1\u0110\2\uffff\2\64\4\uffff\2\64\1\u0115\2\64\1\uffff\1\u0118\2\64\1\u011b\1\uffff\2\64\1\uffff\1\u011e\1\u011f\1\uffff\1\u0120\1\u0121\4\uffff";
    static final String DFA24_eofS =
        "\u0122\uffff";
    static final String DFA24_minS =
        "\1\0\1\75\1\72\1\146\1\142\1\162\1\157\3\75\1\uffff\1\56\1\uffff\1\52\1\145\1\60\1\162\1\141\1\60\1\145\5\uffff\1\53\1\157\1\162\1\uffff\1\141\1\150\1\157\2\141\1\145\3\uffff\1\53\2\uffff\2\0\6\uffff\1\160\1\60\1\163\1\uffff\1\144\1\163\1\60\1\162\17\uffff\1\164\1\167\1\154\1\uffff\1\165\1\160\1\154\2\162\1\154\1\60\1\146\5\uffff\1\143\1\163\1\60\1\uffff\1\141\1\157\1\uffff\1\160\1\151\1\164\1\151\1\155\1\154\2\uffff\1\160\1\161\5\uffff\1\154\1\60\1\uffff\1\145\1\60\1\164\1\uffff\3\60\1\154\2\145\1\163\1\60\1\163\1\123\1\uffff\1\165\1\151\1\145\1\143\1\154\1\145\1\144\1\160\1\60\1\154\1\150\1\156\1\160\1\163\1\154\1\145\1\117\1\165\1\162\1\151\1\uffff\1\141\1\162\1\uffff\1\162\3\uffff\2\60\1\144\1\145\1\uffff\1\151\1\143\1\151\2\156\2\165\2\60\2\145\1\146\1\uffff\1\145\2\60\1\157\1\164\1\117\1\162\1\146\1\145\1\164\1\145\1\156\1\164\1\141\2\uffff\1\145\1\60\1\157\2\162\1\145\1\144\1\164\1\144\2\uffff\1\162\1\143\2\60\2\uffff\1\165\1\60\1\146\2\60\1\156\1\60\1\163\1\164\1\60\1\143\1\146\1\uffff\1\156\1\151\1\145\2\163\2\145\2\164\2\uffff\1\156\1\uffff\1\60\2\uffff\1\143\1\uffff\1\60\1\151\1\uffff\1\164\2\60\1\160\1\126\4\60\1\151\1\145\1\144\1\uffff\1\145\1\uffff\1\141\1\60\2\uffff\1\164\1\124\4\uffff\1\145\1\144\1\60\1\117\1\164\1\uffff\1\60\1\114\1\163\1\60\1\uffff\1\146\1\145\1\uffff\2\60\1\uffff\2\60\4\uffff";
    static final String DFA24_maxS =
        "\1\uffff\1\75\1\72\2\156\1\162\1\157\1\76\2\75\1\uffff\1\76\1\uffff\1\57\1\165\1\71\1\171\1\157\1\151\1\145\5\uffff\1\170\1\157\1\162\1\uffff\1\141\1\151\2\157\1\141\1\165\3\uffff\1\71\2\uffff\2\uffff\6\uffff\1\160\1\172\1\163\1\uffff\1\144\1\163\1\172\1\162\17\uffff\1\164\1\167\1\154\1\uffff\1\165\1\160\1\154\2\162\1\154\1\172\1\161\5\uffff\1\164\1\163\1\71\1\uffff\1\141\1\157\1\uffff\1\160\1\151\1\164\1\151\1\156\1\154\2\uffff\1\160\1\164\5\uffff\1\157\1\172\1\uffff\1\164\1\172\1\164\1\uffff\3\172\1\154\2\145\1\163\1\172\1\163\1\123\1\uffff\1\165\1\151\1\145\1\143\1\154\1\145\1\144\1\164\1\172\1\154\1\150\1\156\1\160\1\163\1\154\1\145\1\117\1\165\1\162\1\151\1\uffff\1\141\1\162\1\uffff\1\162\3\uffff\2\172\1\144\1\145\1\uffff\1\151\1\143\1\151\2\156\2\165\2\172\2\145\1\146\1\uffff\1\145\2\172\1\157\1\164\1\117\1\162\1\146\1\145\1\164\1\145\1\156\1\164\1\141\2\uffff\1\145\1\172\1\157\2\162\1\145\1\144\1\164\1\144\2\uffff\1\162\1\143\2\172\2\uffff\1\165\1\172\1\146\2\172\1\156\1\172\1\163\1\164\1\172\1\143\1\146\1\uffff\1\156\1\151\1\145\2\163\2\145\2\164\2\uffff\1\156\1\uffff\1\172\2\uffff\1\143\1\uffff\1\172\1\151\1\uffff\1\164\2\172\1\160\1\126\4\172\1\151\1\145\1\144\1\uffff\1\145\1\uffff\1\141\1\172\2\uffff\1\164\1\124\4\uffff\1\145\1\144\1\172\1\117\1\164\1\uffff\1\172\1\114\1\163\1\172\1\uffff\1\146\1\145\1\uffff\2\172\1\uffff\2\172\4\uffff";
    static final String DFA24_acceptS =
        "\12\uffff\1\20\1\uffff\1\22\7\uffff\1\34\1\36\1\37\1\40\1\41\3\uffff\1\45\6\uffff\1\65\1\66\1\67\1\uffff\1\106\1\105\2\uffff\1\113\1\114\1\11\1\1\1\76\1\2\3\uffff\1\105\4\uffff\1\12\1\17\1\15\1\13\1\25\1\16\1\14\1\20\1\27\1\106\1\21\1\22\1\111\1\112\1\23\3\uffff\1\26\10\uffff\1\34\1\36\1\37\1\40\1\41\3\uffff\1\107\2\uffff\1\45\6\uffff\1\62\1\70\2\uffff\1\65\1\66\1\67\1\110\1\113\2\uffff\1\52\3\uffff\1\5\12\uffff\1\104\24\uffff\1\10\2\uffff\1\4\1\uffff\1\6\1\24\1\64\4\uffff\1\50\14\uffff\1\47\16\uffff\1\77\1\30\11\uffff\1\53\1\43\4\uffff\1\55\1\54\14\uffff\1\31\11\uffff\1\102\1\51\1\uffff\1\73\1\uffff\1\63\1\100\1\uffff\1\3\2\uffff\1\75\14\uffff\1\103\1\uffff\1\7\2\uffff\1\61\1\32\2\uffff\1\60\1\42\1\56\1\72\5\uffff\1\74\4\uffff\1\57\2\uffff\1\35\2\uffff\1\71\2\uffff\1\33\1\44\1\101\1\46";
    static final String DFA24_specialS =
        "\1\2\50\uffff\1\0\1\1\u00f7\uffff}>";
    static final String[] DFA24_transitionS = {
            "\11\54\2\53\2\54\1\53\22\54\1\53\1\10\1\51\1\54\1\50\2\54\1\52\1\25\1\26\1\14\1\12\1\34\1\13\1\17\1\15\12\47\1\2\1\24\1\7\1\1\1\11\1\54\1\41\4\50\1\46\25\50\1\43\1\54\1\44\1\54\1\50\1\54\1\4\1\50\1\40\1\50\1\31\1\21\2\50\1\3\1\37\1\50\1\32\1\35\1\16\1\5\1\33\1\50\1\23\1\42\1\20\1\50\1\22\1\36\1\6\2\50\1\27\1\45\1\30\uff82\54",
            "\1\55",
            "\1\57",
            "\1\62\6\uffff\1\61\1\63",
            "\1\66\13\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\72\1\71",
            "\1\74",
            "\1\76",
            "",
            "\1\102\1\uffff\12\102\4\uffff\1\101",
            "",
            "\1\105\4\uffff\1\106",
            "\1\111\11\uffff\1\110\5\uffff\1\112",
            "\12\102",
            "\1\114\6\uffff\1\115",
            "\1\116\15\uffff\1\117",
            "\12\122\53\uffff\1\120\3\uffff\1\121",
            "\1\123",
            "",
            "",
            "",
            "",
            "",
            "\1\134\1\uffff\1\134\2\uffff\12\133\62\uffff\1\132\13\uffff\1\131",
            "\1\135",
            "\1\136",
            "",
            "\1\140",
            "\1\141\1\142",
            "\1\143",
            "\1\145\15\uffff\1\144",
            "\1\146",
            "\1\151\17\uffff\1\150",
            "",
            "",
            "",
            "\1\134\1\uffff\1\134\2\uffff\12\133",
            "",
            "",
            "\0\155",
            "\0\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\160\24\64",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\166",
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
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\12\122\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0082\12\uffff\1\u0081",
            "",
            "",
            "",
            "",
            "",
            "\1\u0085\1\uffff\1\u0084\16\uffff\1\u0083",
            "\1\u0086",
            "\12\133",
            "",
            "\1\u0087",
            "\1\u0088",
            "",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\1\u008e",
            "\1\u008f",
            "",
            "",
            "\1\u0090",
            "\1\u0092\2\uffff\1\u0091",
            "",
            "",
            "",
            "",
            "",
            "\1\u0094\2\uffff\1\u0093",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u0097\16\uffff\1\u0096",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0099",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00a2",
            "\1\u00a3",
            "",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab\3\uffff\1\u00ac",
            "\12\64\7\uffff\16\64\1\u00ad\13\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "",
            "",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00bf",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "",
            "\1\u00db",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "",
            "\1\u00e4",
            "\1\u00e5",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\u00e8",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00ea",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00ed",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00ef",
            "\1\u00f0",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "",
            "",
            "\1\u00fd",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\u00ff",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0101",
            "",
            "\1\u0102",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0105",
            "\1\u0106",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "\1\u010e",
            "",
            "\1\u010f",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\u0111",
            "\1\u0112",
            "",
            "",
            "",
            "",
            "\1\u0113",
            "\1\u0114",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0116",
            "\1\u0117",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0119",
            "\1\u011a",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u011c",
            "\1\u011d",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | RULE_VERSION | RULE_ID | RULE_NUMBER | RULE_EXPONENT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_41 = input.LA(1);

                        s = -1;
                        if ( ((LA24_41>='\u0000' && LA24_41<='\uFFFF')) ) {s = 109;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_42 = input.LA(1);

                        s = -1;
                        if ( ((LA24_42>='\u0000' && LA24_42<='\uFFFF')) ) {s = 109;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_0 = input.LA(1);

                        s = -1;
                        if ( (LA24_0=='=') ) {s = 1;}

                        else if ( (LA24_0==':') ) {s = 2;}

                        else if ( (LA24_0=='i') ) {s = 3;}

                        else if ( (LA24_0=='a') ) {s = 4;}

                        else if ( (LA24_0=='o') ) {s = 5;}

                        else if ( (LA24_0=='x') ) {s = 6;}

                        else if ( (LA24_0=='<') ) {s = 7;}

                        else if ( (LA24_0=='!') ) {s = 8;}

                        else if ( (LA24_0=='>') ) {s = 9;}

                        else if ( (LA24_0=='+') ) {s = 10;}

                        else if ( (LA24_0=='-') ) {s = 11;}

                        else if ( (LA24_0=='*') ) {s = 12;}

                        else if ( (LA24_0=='/') ) {s = 13;}

                        else if ( (LA24_0=='n') ) {s = 14;}

                        else if ( (LA24_0=='.') ) {s = 15;}

                        else if ( (LA24_0=='t') ) {s = 16;}

                        else if ( (LA24_0=='f') ) {s = 17;}

                        else if ( (LA24_0=='v') ) {s = 18;}

                        else if ( (LA24_0=='r') ) {s = 19;}

                        else if ( (LA24_0==';') ) {s = 20;}

                        else if ( (LA24_0=='(') ) {s = 21;}

                        else if ( (LA24_0==')') ) {s = 22;}

                        else if ( (LA24_0=='{') ) {s = 23;}

                        else if ( (LA24_0=='}') ) {s = 24;}

                        else if ( (LA24_0=='e') ) {s = 25;}

                        else if ( (LA24_0=='l') ) {s = 26;}

                        else if ( (LA24_0=='p') ) {s = 27;}

                        else if ( (LA24_0==',') ) {s = 28;}

                        else if ( (LA24_0=='m') ) {s = 29;}

                        else if ( (LA24_0=='w') ) {s = 30;}

                        else if ( (LA24_0=='j') ) {s = 31;}

                        else if ( (LA24_0=='c') ) {s = 32;}

                        else if ( (LA24_0=='@') ) {s = 33;}

                        else if ( (LA24_0=='s') ) {s = 34;}

                        else if ( (LA24_0=='[') ) {s = 35;}

                        else if ( (LA24_0==']') ) {s = 36;}

                        else if ( (LA24_0=='|') ) {s = 37;}

                        else if ( (LA24_0=='E') ) {s = 38;}

                        else if ( ((LA24_0>='0' && LA24_0<='9')) ) {s = 39;}

                        else if ( (LA24_0=='$'||(LA24_0>='A' && LA24_0<='D')||(LA24_0>='F' && LA24_0<='Z')||LA24_0=='_'||LA24_0=='b'||LA24_0=='d'||(LA24_0>='g' && LA24_0<='h')||LA24_0=='k'||LA24_0=='q'||LA24_0=='u'||(LA24_0>='y' && LA24_0<='z')) ) {s = 40;}

                        else if ( (LA24_0=='\"') ) {s = 41;}

                        else if ( (LA24_0=='\'') ) {s = 42;}

                        else if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {s = 43;}

                        else if ( ((LA24_0>='\u0000' && LA24_0<='\b')||(LA24_0>='\u000B' && LA24_0<='\f')||(LA24_0>='\u000E' && LA24_0<='\u001F')||LA24_0=='#'||(LA24_0>='%' && LA24_0<='&')||LA24_0=='?'||LA24_0=='\\'||LA24_0=='^'||LA24_0=='`'||(LA24_0>='~' && LA24_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}