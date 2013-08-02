// $ANTLR 3.4 Pddl.g 2013-07-08 15:50:09
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PddlParser extends Parser {

    public static final String[] tokenNames = new String[]{
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "AND_EFFECT", "AND_GD", "ANY_CHAR", "ASSIGN_EFFECT", "BINARY_OP", "BINARY_OP2", "COMPARISON_GD", "CONSTANTS", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", "EITHER_TYPE", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", "FUNCTIONS", "FUNC_HEAD", "GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", "MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", "NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", "PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", "REQUIREMENTS", "REQUIRE_KEY", "TYPES", "UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", "':constraints'", "':derived'", "':domain'", "':duration'", "':durative-action'", "':effect'", "':functions'", "':goal'", "':init'", "':metric'", "':objects'", "':parameters'", "':precondition'", "':predicates'", "':requirements'", "':types'", "'<'", "'<='", "'='", "'>'", "'>='", "'?duration'", "'all'", "'always'", "'always-within'", "'and'", "'assign'", "'at'", "'at-most-once'", "'decrease'", "'define'", "'domain'", "'either'", "'end'", "'exists'", "'forall'", "'hold-after'", "'hold-during'", "'imply'", "'increase'", "'is-violated'", "'maximize'", "'minimize'", "'not'", "'number'", "'or'", "'over'", "'preference'", "'problem'", "'scale-down'", "'scale-up'", "'sometime'", "'sometime-after'", "'sometime-before'", "'start'", "'when'", "'within'"
    };
    public static final int EOF = -1;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int T__59 = 59;
    public static final int T__60 = 60;
    public static final int T__61 = 61;
    public static final int T__62 = 62;
    public static final int T__63 = 63;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__68 = 68;
    public static final int T__69 = 69;
    public static final int T__70 = 70;
    public static final int T__71 = 71;
    public static final int T__72 = 72;
    public static final int T__73 = 73;
    public static final int T__74 = 74;
    public static final int T__75 = 75;
    public static final int T__76 = 76;
    public static final int T__77 = 77;
    public static final int T__78 = 78;
    public static final int T__79 = 79;
    public static final int T__80 = 80;
    public static final int T__81 = 81;
    public static final int T__82 = 82;
    public static final int T__83 = 83;
    public static final int T__84 = 84;
    public static final int T__85 = 85;
    public static final int T__86 = 86;
    public static final int T__87 = 87;
    public static final int T__88 = 88;
    public static final int T__89 = 89;
    public static final int T__90 = 90;
    public static final int T__91 = 91;
    public static final int T__92 = 92;
    public static final int T__93 = 93;
    public static final int T__94 = 94;
    public static final int T__95 = 95;
    public static final int T__96 = 96;
    public static final int T__97 = 97;
    public static final int T__98 = 98;
    public static final int T__99 = 99;
    public static final int T__100 = 100;
    public static final int T__101 = 101;
    public static final int T__102 = 102;
    public static final int T__103 = 103;
    public static final int T__104 = 104;
    public static final int T__105 = 105;
    public static final int T__106 = 106;
    public static final int T__107 = 107;
    public static final int T__108 = 108;
    public static final int T__109 = 109;
    public static final int T__110 = 110;
    public static final int T__111 = 111;
    public static final int T__112 = 112;
    public static final int T__113 = 113;
    public static final int T__114 = 114;
    public static final int T__115 = 115;
    public static final int T__116 = 116;
    public static final int T__117 = 117;
    public static final int T__118 = 118;
    public static final int T__119 = 119;
    public static final int T__120 = 120;
    public static final int T__121 = 121;
    public static final int ACTION = 4;
    public static final int AND_EFFECT = 5;
    public static final int AND_GD = 6;
    public static final int ANY_CHAR = 7;
    public static final int ASSIGN_EFFECT = 8;
    public static final int BINARY_OP = 9;
    public static final int BINARY_OP2 = 10;
    public static final int COMPARISON_GD = 11;
    public static final int CONSTANTS = 12;
    public static final int DIGIT = 13;
    public static final int DOMAIN = 14;
    public static final int DOMAIN_NAME = 15;
    public static final int DURATIVE_ACTION = 16;
    public static final int EFFECT = 17;
    public static final int EITHER_TYPE = 18;
    public static final int EXISTS_GD = 19;
    public static final int FORALL_EFFECT = 20;
    public static final int FORALL_GD = 21;
    public static final int FUNCTIONS = 22;
    public static final int FUNC_HEAD = 23;
    public static final int GOAL = 24;
    public static final int IMPLY_GD = 25;
    public static final int INIT = 26;
    public static final int INIT_AT = 27;
    public static final int INIT_EQ = 28;
    public static final int LETTER = 29;
    public static final int LINE_COMMENT = 30;
    public static final int MINUS_OP = 31;
    public static final int MULTI_OP = 32;
    public static final int NAME = 33;
    public static final int NOT_EFFECT = 34;
    public static final int NOT_GD = 35;
    public static final int NOT_PRED_INIT = 36;
    public static final int NUMBER = 37;
    public static final int OBJECTS = 38;
    public static final int OR_GD = 39;
    public static final int PRECONDITION = 40;
    public static final int PREDICATES = 41;
    public static final int PRED_HEAD = 42;
    public static final int PRED_INST = 43;
    public static final int PROBLEM = 44;
    public static final int PROBLEM_CONSTRAINT = 45;
    public static final int PROBLEM_DOMAIN = 46;
    public static final int PROBLEM_METRIC = 47;
    public static final int PROBLEM_NAME = 48;
    public static final int REQUIREMENTS = 49;
    public static final int REQUIRE_KEY = 50;
    public static final int TYPES = 51;
    public static final int UNARY_MINUS = 52;
    public static final int VARIABLE = 53;
    public static final int WHEN_EFFECT = 54;
    public static final int WHITESPACE = 55;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[]{};
    }

    // delegators
    public PddlParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public PddlParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() {
        return PddlParser.tokenNames;
    }

    public String getGrammarFileName() {
        return "Pddl.g";
    }
    private boolean wasError = false;

    public void reportError(RecognitionException e) {
        wasError = true;
        super.reportError(e);
    }

    public boolean invalidGrammar() {
        return wasError;
    }

    public static class pddlDoc_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "pddlDoc"
    // Pddl.g:89:1: pddlDoc : ( domain | problem );
    public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
        PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.domain_return domain1 = null;

        PddlParser.problem_return problem2 = null;



        try {
            // Pddl.g:89:9: ( domain | problem )
            int alt1 = 2;
            int LA1_0 = input.LA(1);

            if ((LA1_0 == 56)) {
                int LA1_1 = input.LA(2);

                if ((LA1_1 == 95)) {
                    int LA1_2 = input.LA(3);

                    if ((LA1_2 == 56)) {
                        int LA1_3 = input.LA(4);

                        if ((LA1_3 == 96)) {
                            alt1 = 1;
                        } else if ((LA1_3 == 113)) {
                            alt1 = 2;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 1, 3, input);

                            throw nvae;

                        }
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1: // Pddl.g:89:11: domain
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_domain_in_pddlDoc311);
                    domain1 = domain();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, domain1.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:89:20: problem
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_problem_in_pddlDoc315);
                    problem2 = problem();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, problem2.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pddlDoc"

    public static class domain_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "domain"
    // Pddl.g:93:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ) ;
    public final PddlParser.domain_return domain() throws RecognitionException {
        PddlParser.domain_return retval = new PddlParser.domain_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal3 = null;
        Token string_literal4 = null;
        Token char_literal13 = null;
        PddlParser.domainName_return domainName5 = null;

        PddlParser.requireDef_return requireDef6 = null;

        PddlParser.typesDef_return typesDef7 = null;

        PddlParser.constantsDef_return constantsDef8 = null;

        PddlParser.predicatesDef_return predicatesDef9 = null;

        PddlParser.functionsDef_return functionsDef10 = null;

        PddlParser.constraints_return constraints11 = null;

        PddlParser.structureDef_return structureDef12 = null;


        Object char_literal3_tree = null;
        Object string_literal4_tree = null;
        Object char_literal13_tree = null;
        RewriteRuleTokenStream stream_95 = new RewriteRuleTokenStream(adaptor, "token 95");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_constantsDef = new RewriteRuleSubtreeStream(adaptor, "rule constantsDef");
        RewriteRuleSubtreeStream stream_requireDef = new RewriteRuleSubtreeStream(adaptor, "rule requireDef");
        RewriteRuleSubtreeStream stream_predicatesDef = new RewriteRuleSubtreeStream(adaptor, "rule predicatesDef");
        RewriteRuleSubtreeStream stream_constraints = new RewriteRuleSubtreeStream(adaptor, "rule constraints");
        RewriteRuleSubtreeStream stream_structureDef = new RewriteRuleSubtreeStream(adaptor, "rule structureDef");
        RewriteRuleSubtreeStream stream_domainName = new RewriteRuleSubtreeStream(adaptor, "rule domainName");
        RewriteRuleSubtreeStream stream_functionsDef = new RewriteRuleSubtreeStream(adaptor, "rule functionsDef");
        RewriteRuleSubtreeStream stream_typesDef = new RewriteRuleSubtreeStream(adaptor, "rule typesDef");
        try {
            // Pddl.g:94:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ) )
            // Pddl.g:94:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')'
            {
                char_literal3 = (Token) match(input, 56, FOLLOW_56_in_domain330);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal3);
                }


                string_literal4 = (Token) match(input, 95, FOLLOW_95_in_domain332);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_95.add(string_literal4);
                }


                pushFollow(FOLLOW_domainName_in_domain334);
                domainName5 = domainName();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_domainName.add(domainName5.getTree());
                }

                // Pddl.g:95:7: ( requireDef )?
                int alt2 = 2;
                int LA2_0 = input.LA(1);

                if ((LA2_0 == 56)) {
                    int LA2_1 = input.LA(2);

                    if ((LA2_1 == 79)) {
                        alt2 = 1;
                    }
                }
                switch (alt2) {
                    case 1: // Pddl.g:95:7: requireDef
                    {
                        pushFollow(FOLLOW_requireDef_in_domain342);
                        requireDef6 = requireDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_requireDef.add(requireDef6.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:96:7: ( typesDef )?
                int alt3 = 2;
                int LA3_0 = input.LA(1);

                if ((LA3_0 == 56)) {
                    int LA3_1 = input.LA(2);

                    if ((LA3_1 == 80)) {
                        alt3 = 1;
                    }
                }
                switch (alt3) {
                    case 1: // Pddl.g:96:7: typesDef
                    {
                        pushFollow(FOLLOW_typesDef_in_domain351);
                        typesDef7 = typesDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_typesDef.add(typesDef7.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:97:7: ( constantsDef )?
                int alt4 = 2;
                int LA4_0 = input.LA(1);

                if ((LA4_0 == 56)) {
                    int LA4_1 = input.LA(2);

                    if ((LA4_1 == 64)) {
                        alt4 = 1;
                    }
                }
                switch (alt4) {
                    case 1: // Pddl.g:97:7: constantsDef
                    {
                        pushFollow(FOLLOW_constantsDef_in_domain360);
                        constantsDef8 = constantsDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_constantsDef.add(constantsDef8.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:98:7: ( predicatesDef )?
                int alt5 = 2;
                int LA5_0 = input.LA(1);

                if ((LA5_0 == 56)) {
                    int LA5_1 = input.LA(2);

                    if ((LA5_1 == 78)) {
                        alt5 = 1;
                    }
                }
                switch (alt5) {
                    case 1: // Pddl.g:98:7: predicatesDef
                    {
                        pushFollow(FOLLOW_predicatesDef_in_domain369);
                        predicatesDef9 = predicatesDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_predicatesDef.add(predicatesDef9.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:99:7: ( functionsDef )?
                int alt6 = 2;
                int LA6_0 = input.LA(1);

                if ((LA6_0 == 56)) {
                    int LA6_1 = input.LA(2);

                    if ((LA6_1 == 71)) {
                        alt6 = 1;
                    }
                }
                switch (alt6) {
                    case 1: // Pddl.g:99:7: functionsDef
                    {
                        pushFollow(FOLLOW_functionsDef_in_domain378);
                        functionsDef10 = functionsDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_functionsDef.add(functionsDef10.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:100:7: ( constraints )?
                int alt7 = 2;
                int LA7_0 = input.LA(1);

                if ((LA7_0 == 56)) {
                    int LA7_1 = input.LA(2);

                    if ((LA7_1 == 65)) {
                        alt7 = 1;
                    }
                }
                switch (alt7) {
                    case 1: // Pddl.g:100:7: constraints
                    {
                        pushFollow(FOLLOW_constraints_in_domain387);
                        constraints11 = constraints();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_constraints.add(constraints11.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:101:7: ( structureDef )*
                loop8:
                do {
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);

                    if ((LA8_0 == 56)) {
                        alt8 = 1;
                    }


                    switch (alt8) {
                        case 1: // Pddl.g:101:7: structureDef
                        {
                            pushFollow(FOLLOW_structureDef_in_domain396);
                            structureDef12 = structureDef();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_structureDef.add(structureDef12.getTree());
                            }

                        }
                        break;

                        default:
                            break loop8;
                    }
                } while (true);


                char_literal13 = (Token) match(input, 57, FOLLOW_57_in_domain405);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal13);
                }


                // AST REWRITE
                // elements: constraints, constantsDef, typesDef, requireDef, predicatesDef, functionsDef, domainName, structureDef
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 103:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* )
                    {
                        // Pddl.g:103:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(DOMAIN, "DOMAIN"), root_1);

                            adaptor.addChild(root_1, stream_domainName.nextTree());

                            // Pddl.g:103:30: ( requireDef )?
                            if (stream_requireDef.hasNext()) {
                                adaptor.addChild(root_1, stream_requireDef.nextTree());

                            }
                            stream_requireDef.reset();

                            // Pddl.g:103:42: ( typesDef )?
                            if (stream_typesDef.hasNext()) {
                                adaptor.addChild(root_1, stream_typesDef.nextTree());

                            }
                            stream_typesDef.reset();

                            // Pddl.g:104:17: ( constantsDef )?
                            if (stream_constantsDef.hasNext()) {
                                adaptor.addChild(root_1, stream_constantsDef.nextTree());

                            }
                            stream_constantsDef.reset();

                            // Pddl.g:104:31: ( predicatesDef )?
                            if (stream_predicatesDef.hasNext()) {
                                adaptor.addChild(root_1, stream_predicatesDef.nextTree());

                            }
                            stream_predicatesDef.reset();

                            // Pddl.g:104:46: ( functionsDef )?
                            if (stream_functionsDef.hasNext()) {
                                adaptor.addChild(root_1, stream_functionsDef.nextTree());

                            }
                            stream_functionsDef.reset();

                            // Pddl.g:105:17: ( constraints )?
                            if (stream_constraints.hasNext()) {
                                adaptor.addChild(root_1, stream_constraints.nextTree());

                            }
                            stream_constraints.reset();

                            // Pddl.g:105:30: ( structureDef )*
                            while (stream_structureDef.hasNext()) {
                                adaptor.addChild(root_1, stream_structureDef.nextTree());

                            }
                            stream_structureDef.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "domain"

    public static class domainName_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "domainName"
    // Pddl.g:108:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
    public final PddlParser.domainName_return domainName() throws RecognitionException {
        PddlParser.domainName_return retval = new PddlParser.domainName_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal14 = null;
        Token string_literal15 = null;
        Token NAME16 = null;
        Token char_literal17 = null;

        Object char_literal14_tree = null;
        Object string_literal15_tree = null;
        Object NAME16_tree = null;
        Object char_literal17_tree = null;
        RewriteRuleTokenStream stream_96 = new RewriteRuleTokenStream(adaptor, "token 96");
        RewriteRuleTokenStream stream_NAME = new RewriteRuleTokenStream(adaptor, "token NAME");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");

        try {
            // Pddl.g:109:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
            // Pddl.g:109:7: '(' 'domain' NAME ')'
            {
                char_literal14 = (Token) match(input, 56, FOLLOW_56_in_domainName489);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal14);
                }


                string_literal15 = (Token) match(input, 96, FOLLOW_96_in_domainName491);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_96.add(string_literal15);
                }


                NAME16 = (Token) match(input, NAME, FOLLOW_NAME_in_domainName493);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_NAME.add(NAME16);
                }


                char_literal17 = (Token) match(input, 57, FOLLOW_57_in_domainName495);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal17);
                }


                // AST REWRITE
                // elements: NAME
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 110:6: -> ^( DOMAIN_NAME NAME )
                    {
                        // Pddl.g:110:9: ^( DOMAIN_NAME NAME )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(DOMAIN_NAME, "DOMAIN_NAME"), root_1);

                            adaptor.addChild(root_1,
                                    stream_NAME.nextNode());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "domainName"

    public static class requireDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "requireDef"
    // Pddl.g:113:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
    public final PddlParser.requireDef_return requireDef() throws RecognitionException {
        PddlParser.requireDef_return retval = new PddlParser.requireDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal18 = null;
        Token string_literal19 = null;
        Token REQUIRE_KEY20 = null;
        Token char_literal21 = null;

        Object char_literal18_tree = null;
        Object string_literal19_tree = null;
        Object REQUIRE_KEY20_tree = null;
        Object char_literal21_tree = null;
        RewriteRuleTokenStream stream_79 = new RewriteRuleTokenStream(adaptor, "token 79");
        RewriteRuleTokenStream stream_REQUIRE_KEY = new RewriteRuleTokenStream(adaptor, "token REQUIRE_KEY");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");

        try {
            // Pddl.g:114:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
            // Pddl.g:114:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
            {
                char_literal18 = (Token) match(input, 56, FOLLOW_56_in_requireDef522);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal18);
                }


                string_literal19 = (Token) match(input, 79, FOLLOW_79_in_requireDef524);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_79.add(string_literal19);
                }


                // Pddl.g:114:24: ( REQUIRE_KEY )+
                int cnt9 = 0;
                loop9:
                do {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);

                    if ((LA9_0 == REQUIRE_KEY)) {
                        alt9 = 1;
                    }


                    switch (alt9) {
                        case 1: // Pddl.g:114:24: REQUIRE_KEY
                        {
                            REQUIRE_KEY20 = (Token) match(input, REQUIRE_KEY, FOLLOW_REQUIRE_KEY_in_requireDef526);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_REQUIRE_KEY.add(REQUIRE_KEY20);
                            }


                        }
                        break;

                        default:
                            if (cnt9 >= 1) {
                                break loop9;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee =
                                    new EarlyExitException(9, input);
                            throw eee;
                    }
                    cnt9++;
                } while (true);


                char_literal21 = (Token) match(input, 57, FOLLOW_57_in_requireDef529);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal21);
                }


                // AST REWRITE
                // elements: REQUIRE_KEY
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 115:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
                    {
                        // Pddl.g:115:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(REQUIREMENTS, "REQUIREMENTS"), root_1);

                            if (!(stream_REQUIRE_KEY.hasNext())) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_REQUIRE_KEY.hasNext()) {
                                adaptor.addChild(root_1,
                                        stream_REQUIRE_KEY.nextNode());

                            }
                            stream_REQUIRE_KEY.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "requireDef"

    public static class typesDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "typesDef"
    // Pddl.g:118:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
    public final PddlParser.typesDef_return typesDef() throws RecognitionException {
        PddlParser.typesDef_return retval = new PddlParser.typesDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal22 = null;
        Token string_literal23 = null;
        Token char_literal25 = null;
        PddlParser.typedNameList_return typedNameList24 = null;


        Object char_literal22_tree = null;
        Object string_literal23_tree = null;
        Object char_literal25_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_80 = new RewriteRuleTokenStream(adaptor, "token 80");
        RewriteRuleSubtreeStream stream_typedNameList = new RewriteRuleSubtreeStream(adaptor, "rule typedNameList");
        try {
            // Pddl.g:119:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
            // Pddl.g:119:4: '(' ':types' typedNameList ')'
            {
                char_literal22 = (Token) match(input, 56, FOLLOW_56_in_typesDef550);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal22);
                }


                string_literal23 = (Token) match(input, 80, FOLLOW_80_in_typesDef552);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_80.add(string_literal23);
                }


                pushFollow(FOLLOW_typedNameList_in_typesDef554);
                typedNameList24 = typedNameList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_typedNameList.add(typedNameList24.getTree());
                }

                char_literal25 = (Token) match(input, 57, FOLLOW_57_in_typesDef556);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal25);
                }


                // AST REWRITE
                // elements: typedNameList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 120:4: -> ^( TYPES typedNameList )
                    {
                        // Pddl.g:120:7: ^( TYPES typedNameList )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(TYPES, "TYPES"), root_1);

                            adaptor.addChild(root_1, stream_typedNameList.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typesDef"

    public static class typedNameList_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "typedNameList"
    // Pddl.g:124:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
    public final PddlParser.typedNameList_return typedNameList() throws RecognitionException {
        PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME26 = null;
        Token NAME28 = null;
        PddlParser.singleTypeNameList_return singleTypeNameList27 = null;


        Object NAME26_tree = null;
        Object NAME28_tree = null;

        try {
            // Pddl.g:125:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
            // Pddl.g:125:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
            {
                root_0 = (Object) adaptor.nil();


                // Pddl.g:125:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
                int alt13 = 2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
                    case 1: // Pddl.g:125:8: ( NAME )*
                    {
                        // Pddl.g:125:8: ( NAME )*
                        loop10:
                        do {
                            int alt10 = 2;
                            int LA10_0 = input.LA(1);

                            if ((LA10_0 == NAME)) {
                                alt10 = 1;
                            }


                            switch (alt10) {
                                case 1: // Pddl.g:125:8: NAME
                                {
                                    NAME26 = (Token) match(input, NAME, FOLLOW_NAME_in_typedNameList583);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        NAME26_tree =
                                                (Object) adaptor.create(NAME26);
                                        adaptor.addChild(root_0, NAME26_tree);
                                    }

                                }
                                break;

                                default:
                                    break loop10;
                            }
                        } while (true);


                    }
                    break;
                    case 2: // Pddl.g:125:16: ( singleTypeNameList )+ ( NAME )*
                    {
                        // Pddl.g:125:16: ( singleTypeNameList )+
                        int cnt11 = 0;
                        loop11:
                        do {
                            int alt11 = 2;
                            alt11 = dfa11.predict(input);
                            switch (alt11) {
                                case 1: // Pddl.g:125:16: singleTypeNameList
                                {
                                    pushFollow(FOLLOW_singleTypeNameList_in_typedNameList588);
                                    singleTypeNameList27 = singleTypeNameList();

                                    state._fsp--;
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        adaptor.addChild(root_0, singleTypeNameList27.getTree());
                                    }

                                }
                                break;

                                default:
                                    if (cnt11 >= 1) {
                                        break loop11;
                                    }
                                    if (state.backtracking > 0) {
                                        state.failed = true;
                                        return retval;
                                    }
                                    EarlyExitException eee =
                                            new EarlyExitException(11, input);
                                    throw eee;
                            }
                            cnt11++;
                        } while (true);


                        // Pddl.g:125:36: ( NAME )*
                        loop12:
                        do {
                            int alt12 = 2;
                            int LA12_0 = input.LA(1);

                            if ((LA12_0 == NAME)) {
                                alt12 = 1;
                            }


                            switch (alt12) {
                                case 1: // Pddl.g:125:36: NAME
                                {
                                    NAME28 = (Token) match(input, NAME, FOLLOW_NAME_in_typedNameList591);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        NAME28_tree =
                                                (Object) adaptor.create(NAME28);
                                        adaptor.addChild(root_0, NAME28_tree);
                                    }

                                }
                                break;

                                default:
                                    break loop12;
                            }
                        } while (true);


                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typedNameList"

    public static class singleTypeNameList_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "singleTypeNameList"
    // Pddl.g:128:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
    public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
        PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME29 = null;
        Token char_literal30 = null;
        PddlParser.type_return t = null;


        Object NAME29_tree = null;
        Object char_literal30_tree = null;
        RewriteRuleTokenStream stream_NAME = new RewriteRuleTokenStream(adaptor, "token NAME");
        RewriteRuleTokenStream stream_60 = new RewriteRuleTokenStream(adaptor, "token 60");
        RewriteRuleSubtreeStream stream_type = new RewriteRuleSubtreeStream(adaptor, "rule type");
        try {
            // Pddl.g:129:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
            // Pddl.g:129:7: ( ( NAME )+ '-' t= type )
            {
                // Pddl.g:129:7: ( ( NAME )+ '-' t= type )
                // Pddl.g:129:8: ( NAME )+ '-' t= type
                {
                    // Pddl.g:129:8: ( NAME )+
                    int cnt14 = 0;
                    loop14:
                    do {
                        int alt14 = 2;
                        int LA14_0 = input.LA(1);

                        if ((LA14_0 == NAME)) {
                            alt14 = 1;
                        }


                        switch (alt14) {
                            case 1: // Pddl.g:129:8: NAME
                            {
                                NAME29 = (Token) match(input, NAME, FOLLOW_NAME_in_singleTypeNameList611);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_NAME.add(NAME29);
                                }


                            }
                            break;

                            default:
                                if (cnt14 >= 1) {
                                    break loop14;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee =
                                        new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    char_literal30 = (Token) match(input, 60, FOLLOW_60_in_singleTypeNameList614);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_60.add(char_literal30);
                    }


                    pushFollow(FOLLOW_type_in_singleTypeNameList618);
                    t = type();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_type.add(t.getTree());
                    }

                }


                // AST REWRITE
                // elements: NAME, t
                // token labels: 
                // rule labels: retval, t
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);
                    RewriteRuleSubtreeStream stream_t = new RewriteRuleSubtreeStream(adaptor, "rule t", t != null ? t.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 130:4: -> ( ^( NAME $t) )+
                    {
                        if (!(stream_NAME.hasNext() || stream_t.hasNext())) {
                            throw new RewriteEarlyExitException();
                        }
                        while (stream_NAME.hasNext() || stream_t.hasNext()) {
                            // Pddl.g:130:7: ^( NAME $t)
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        stream_NAME.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_t.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_NAME.reset();
                        stream_t.reset();

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "singleTypeNameList"

    public static class type_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "type"
    // Pddl.g:133:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
    public final PddlParser.type_return type() throws RecognitionException {
        PddlParser.type_return retval = new PddlParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal31 = null;
        Token string_literal32 = null;
        Token char_literal34 = null;
        PddlParser.primType_return primType33 = null;

        PddlParser.primType_return primType35 = null;


        Object char_literal31_tree = null;
        Object string_literal32_tree = null;
        Object char_literal34_tree = null;
        RewriteRuleTokenStream stream_97 = new RewriteRuleTokenStream(adaptor, "token 97");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_primType = new RewriteRuleSubtreeStream(adaptor, "rule primType");
        try {
            // Pddl.g:134:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
            int alt16 = 2;
            int LA16_0 = input.LA(1);

            if ((LA16_0 == 56)) {
                alt16 = 1;
            } else if ((LA16_0 == NAME)) {
                alt16 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1: // Pddl.g:134:4: ( '(' 'either' ( primType )+ ')' )
                {
                    // Pddl.g:134:4: ( '(' 'either' ( primType )+ ')' )
                    // Pddl.g:134:6: '(' 'either' ( primType )+ ')'
                    {
                        char_literal31 = (Token) match(input, 56, FOLLOW_56_in_type645);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_56.add(char_literal31);
                        }


                        string_literal32 = (Token) match(input, 97, FOLLOW_97_in_type647);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_97.add(string_literal32);
                        }


                        // Pddl.g:134:19: ( primType )+
                        int cnt15 = 0;
                        loop15:
                        do {
                            int alt15 = 2;
                            int LA15_0 = input.LA(1);

                            if ((LA15_0 == NAME)) {
                                alt15 = 1;
                            }


                            switch (alt15) {
                                case 1: // Pddl.g:134:19: primType
                                {
                                    pushFollow(FOLLOW_primType_in_type649);
                                    primType33 = primType();

                                    state._fsp--;
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_primType.add(primType33.getTree());
                                    }

                                }
                                break;

                                default:
                                    if (cnt15 >= 1) {
                                        break loop15;
                                    }
                                    if (state.backtracking > 0) {
                                        state.failed = true;
                                        return retval;
                                    }
                                    EarlyExitException eee =
                                            new EarlyExitException(15, input);
                                    throw eee;
                            }
                            cnt15++;
                        } while (true);


                        char_literal34 = (Token) match(input, 57, FOLLOW_57_in_type652);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_57.add(char_literal34);
                        }


                    }


                    // AST REWRITE
                    // elements: primType
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 135:4: -> ^( EITHER_TYPE ( primType )+ )
                        {
                            // Pddl.g:135:7: ^( EITHER_TYPE ( primType )+ )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(EITHER_TYPE, "EITHER_TYPE"), root_1);

                                if (!(stream_primType.hasNext())) {
                                    throw new RewriteEarlyExitException();
                                }
                                while (stream_primType.hasNext()) {
                                    adaptor.addChild(root_1, stream_primType.nextTree());

                                }
                                stream_primType.reset();

                                adaptor.addChild(root_0, root_1);
                            }



                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:136:4: primType
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_primType_in_type673);
                    primType35 = primType();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, primType35.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class primType_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "primType"
    // Pddl.g:139:1: primType : NAME ;
    public final PddlParser.primType_return primType() throws RecognitionException {
        PddlParser.primType_return retval = new PddlParser.primType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME36 = null;

        Object NAME36_tree = null;

        try {
            // Pddl.g:139:10: ( NAME )
            // Pddl.g:139:12: NAME
            {
                root_0 = (Object) adaptor.nil();


                NAME36 = (Token) match(input, NAME, FOLLOW_NAME_in_primType683);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    NAME36_tree =
                            (Object) adaptor.create(NAME36);
                    adaptor.addChild(root_0, NAME36_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "primType"

    public static class functionsDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "functionsDef"
    // Pddl.g:141:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
    public final PddlParser.functionsDef_return functionsDef() throws RecognitionException {
        PddlParser.functionsDef_return retval = new PddlParser.functionsDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal37 = null;
        Token string_literal38 = null;
        Token char_literal40 = null;
        PddlParser.functionList_return functionList39 = null;


        Object char_literal37_tree = null;
        Object string_literal38_tree = null;
        Object char_literal40_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_71 = new RewriteRuleTokenStream(adaptor, "token 71");
        RewriteRuleSubtreeStream stream_functionList = new RewriteRuleSubtreeStream(adaptor, "rule functionList");
        try {
            // Pddl.g:142:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
            // Pddl.g:142:4: '(' ':functions' functionList ')'
            {
                char_literal37 = (Token) match(input, 56, FOLLOW_56_in_functionsDef693);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal37);
                }


                string_literal38 = (Token) match(input, 71, FOLLOW_71_in_functionsDef695);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_71.add(string_literal38);
                }


                pushFollow(FOLLOW_functionList_in_functionsDef697);
                functionList39 = functionList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_functionList.add(functionList39.getTree());
                }

                char_literal40 = (Token) match(input, 57, FOLLOW_57_in_functionsDef699);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal40);
                }


                // AST REWRITE
                // elements: functionList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 143:2: -> ^( FUNCTIONS functionList )
                    {
                        // Pddl.g:143:5: ^( FUNCTIONS functionList )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(FUNCTIONS, "FUNCTIONS"), root_1);

                            adaptor.addChild(root_1, stream_functionList.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionsDef"

    public static class functionList_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "functionList"
    // Pddl.g:146:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
    public final PddlParser.functionList_return functionList() throws RecognitionException {
        PddlParser.functionList_return retval = new PddlParser.functionList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal42 = null;
        PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton41 = null;

        PddlParser.functionType_return functionType43 = null;


        Object char_literal42_tree = null;

        try {
            // Pddl.g:147:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
            // Pddl.g:147:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
            {
                root_0 = (Object) adaptor.nil();


                // Pddl.g:147:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
                loop19:
                do {
                    int alt19 = 2;
                    int LA19_0 = input.LA(1);

                    if ((LA19_0 == 56)) {
                        alt19 = 1;
                    }


                    switch (alt19) {
                        case 1: // Pddl.g:147:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
                        {
                            // Pddl.g:147:5: ( atomicFunctionSkeleton )+
                            int cnt17 = 0;
                            loop17:
                            do {
                                int alt17 = 2;
                                int LA17_0 = input.LA(1);

                                if ((LA17_0 == 56)) {
                                    int LA17_2 = input.LA(2);

                                    if ((synpred17_Pddl())) {
                                        alt17 = 1;
                                    }


                                }


                                switch (alt17) {
                                    case 1: // Pddl.g:147:5: atomicFunctionSkeleton
                                    {
                                        pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList720);
                                        atomicFunctionSkeleton41 = atomicFunctionSkeleton();

                                        state._fsp--;
                                        if (state.failed) {
                                            return retval;
                                        }
                                        if (state.backtracking == 0) {
                                            adaptor.addChild(root_0, atomicFunctionSkeleton41.getTree());
                                        }

                                    }
                                    break;

                                    default:
                                        if (cnt17 >= 1) {
                                            break loop17;
                                        }
                                        if (state.backtracking > 0) {
                                            state.failed = true;
                                            return retval;
                                        }
                                        EarlyExitException eee =
                                                new EarlyExitException(17, input);
                                        throw eee;
                                }
                                cnt17++;
                            } while (true);


                            // Pddl.g:147:29: ( '-' functionType )?
                            int alt18 = 2;
                            int LA18_0 = input.LA(1);

                            if ((LA18_0 == 60)) {
                                alt18 = 1;
                            }
                            switch (alt18) {
                                case 1: // Pddl.g:147:30: '-' functionType
                                {
                                    char_literal42 = (Token) match(input, 60, FOLLOW_60_in_functionList724);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        char_literal42_tree =
                                                (Object) adaptor.create(char_literal42);
                                        adaptor.addChild(root_0, char_literal42_tree);
                                    }

                                    pushFollow(FOLLOW_functionType_in_functionList726);
                                    functionType43 = functionType();

                                    state._fsp--;
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        adaptor.addChild(root_0, functionType43.getTree());
                                    }

                                }
                                break;

                            }


                        }
                        break;

                        default:
                            break loop19;
                    }
                } while (true);


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionList"

    public static class atomicFunctionSkeleton_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "atomicFunctionSkeleton"
    // Pddl.g:150:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
    public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws RecognitionException {
        PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal44 = null;
        Token char_literal47 = null;
        PddlParser.functionSymbol_return functionSymbol45 = null;

        PddlParser.typedVariableList_return typedVariableList46 = null;


        Object char_literal44_tree = null;
        Object char_literal47_tree = null;

        try {
            // Pddl.g:151:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
            // Pddl.g:151:4: '(' ! functionSymbol ^ typedVariableList ')' !
            {
                root_0 = (Object) adaptor.nil();


                char_literal44 = (Token) match(input, 56, FOLLOW_56_in_atomicFunctionSkeleton742);
                if (state.failed) {
                    return retval;
                }

                pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton745);
                functionSymbol45 = functionSymbol();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    root_0 = (Object) adaptor.becomeRoot(functionSymbol45.getTree(), root_0);
                }

                pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton748);
                typedVariableList46 = typedVariableList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, typedVariableList46.getTree());
                }

                char_literal47 = (Token) match(input, 57, FOLLOW_57_in_atomicFunctionSkeleton750);
                if (state.failed) {
                    return retval;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicFunctionSkeleton"

    public static class functionSymbol_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "functionSymbol"
    // Pddl.g:154:1: functionSymbol : NAME ;
    public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
        PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME48 = null;

        Object NAME48_tree = null;

        try {
            // Pddl.g:154:16: ( NAME )
            // Pddl.g:154:18: NAME
            {
                root_0 = (Object) adaptor.nil();


                NAME48 = (Token) match(input, NAME, FOLLOW_NAME_in_functionSymbol761);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    NAME48_tree =
                            (Object) adaptor.create(NAME48);
                    adaptor.addChild(root_0, NAME48_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionSymbol"

    public static class functionType_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "functionType"
    // Pddl.g:156:1: functionType : 'number' ;
    public final PddlParser.functionType_return functionType() throws RecognitionException {
        PddlParser.functionType_return retval = new PddlParser.functionType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal49 = null;

        Object string_literal49_tree = null;

        try {
            // Pddl.g:156:14: ( 'number' )
            // Pddl.g:156:16: 'number'
            {
                root_0 = (Object) adaptor.nil();


                string_literal49 = (Token) match(input, 109, FOLLOW_109_in_functionType770);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    string_literal49_tree =
                            (Object) adaptor.create(string_literal49);
                    adaptor.addChild(root_0, string_literal49_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionType"

    public static class constantsDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "constantsDef"
    // Pddl.g:158:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
    public final PddlParser.constantsDef_return constantsDef() throws RecognitionException {
        PddlParser.constantsDef_return retval = new PddlParser.constantsDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal50 = null;
        Token string_literal51 = null;
        Token char_literal53 = null;
        PddlParser.typedNameList_return typedNameList52 = null;


        Object char_literal50_tree = null;
        Object string_literal51_tree = null;
        Object char_literal53_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_64 = new RewriteRuleTokenStream(adaptor, "token 64");
        RewriteRuleSubtreeStream stream_typedNameList = new RewriteRuleSubtreeStream(adaptor, "rule typedNameList");
        try {
            // Pddl.g:159:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
            // Pddl.g:159:4: '(' ':constants' typedNameList ')'
            {
                char_literal50 = (Token) match(input, 56, FOLLOW_56_in_constantsDef781);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal50);
                }


                string_literal51 = (Token) match(input, 64, FOLLOW_64_in_constantsDef783);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_64.add(string_literal51);
                }


                pushFollow(FOLLOW_typedNameList_in_constantsDef785);
                typedNameList52 = typedNameList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_typedNameList.add(typedNameList52.getTree());
                }

                char_literal53 = (Token) match(input, 57, FOLLOW_57_in_constantsDef787);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal53);
                }


                // AST REWRITE
                // elements: typedNameList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 160:2: -> ^( CONSTANTS typedNameList )
                    {
                        // Pddl.g:160:5: ^( CONSTANTS typedNameList )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(CONSTANTS, "CONSTANTS"), root_1);

                            adaptor.addChild(root_1, stream_typedNameList.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constantsDef"

    public static class predicatesDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "predicatesDef"
    // Pddl.g:163:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
    public final PddlParser.predicatesDef_return predicatesDef() throws RecognitionException {
        PddlParser.predicatesDef_return retval = new PddlParser.predicatesDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal54 = null;
        Token string_literal55 = null;
        Token char_literal57 = null;
        PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton56 = null;


        Object char_literal54_tree = null;
        Object string_literal55_tree = null;
        Object char_literal57_tree = null;
        RewriteRuleTokenStream stream_78 = new RewriteRuleTokenStream(adaptor, "token 78");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_atomicFormulaSkeleton = new RewriteRuleSubtreeStream(adaptor, "rule atomicFormulaSkeleton");
        try {
            // Pddl.g:164:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
            // Pddl.g:164:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
            {
                char_literal54 = (Token) match(input, 56, FOLLOW_56_in_predicatesDef807);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal54);
                }


                string_literal55 = (Token) match(input, 78, FOLLOW_78_in_predicatesDef809);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_78.add(string_literal55);
                }


                // Pddl.g:164:22: ( atomicFormulaSkeleton )+
                int cnt20 = 0;
                loop20:
                do {
                    int alt20 = 2;
                    int LA20_0 = input.LA(1);

                    if ((LA20_0 == 56)) {
                        alt20 = 1;
                    }


                    switch (alt20) {
                        case 1: // Pddl.g:164:22: atomicFormulaSkeleton
                        {
                            pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef811);
                            atomicFormulaSkeleton56 = atomicFormulaSkeleton();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_atomicFormulaSkeleton.add(atomicFormulaSkeleton56.getTree());
                            }

                        }
                        break;

                        default:
                            if (cnt20 >= 1) {
                                break loop20;
                            }
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            EarlyExitException eee =
                                    new EarlyExitException(20, input);
                            throw eee;
                    }
                    cnt20++;
                } while (true);


                char_literal57 = (Token) match(input, 57, FOLLOW_57_in_predicatesDef814);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal57);
                }


                // AST REWRITE
                // elements: atomicFormulaSkeleton
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 165:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
                    {
                        // Pddl.g:165:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PREDICATES, "PREDICATES"), root_1);

                            if (!(stream_atomicFormulaSkeleton.hasNext())) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_atomicFormulaSkeleton.hasNext()) {
                                adaptor.addChild(root_1, stream_atomicFormulaSkeleton.nextTree());

                            }
                            stream_atomicFormulaSkeleton.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicatesDef"

    public static class atomicFormulaSkeleton_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "atomicFormulaSkeleton"
    // Pddl.g:168:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
    public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws RecognitionException {
        PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal58 = null;
        Token char_literal61 = null;
        PddlParser.predicate_return predicate59 = null;

        PddlParser.typedVariableList_return typedVariableList60 = null;


        Object char_literal58_tree = null;
        Object char_literal61_tree = null;

        try {
            // Pddl.g:169:2: ( '(' ! predicate ^ typedVariableList ')' !)
            // Pddl.g:169:4: '(' ! predicate ^ typedVariableList ')' !
            {
                root_0 = (Object) adaptor.nil();


                char_literal58 = (Token) match(input, 56, FOLLOW_56_in_atomicFormulaSkeleton835);
                if (state.failed) {
                    return retval;
                }

                pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton838);
                predicate59 = predicate();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    root_0 = (Object) adaptor.becomeRoot(predicate59.getTree(), root_0);
                }

                pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton841);
                typedVariableList60 = typedVariableList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, typedVariableList60.getTree());
                }

                char_literal61 = (Token) match(input, 57, FOLLOW_57_in_atomicFormulaSkeleton843);
                if (state.failed) {
                    return retval;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicFormulaSkeleton"

    public static class predicate_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "predicate"
    // Pddl.g:172:1: predicate : NAME ;
    public final PddlParser.predicate_return predicate() throws RecognitionException {
        PddlParser.predicate_return retval = new PddlParser.predicate_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME62 = null;

        Object NAME62_tree = null;

        try {
            // Pddl.g:172:11: ( NAME )
            // Pddl.g:172:13: NAME
            {
                root_0 = (Object) adaptor.nil();


                NAME62 = (Token) match(input, NAME, FOLLOW_NAME_in_predicate854);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    NAME62_tree =
                            (Object) adaptor.create(NAME62);
                    adaptor.addChild(root_0, NAME62_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class typedVariableList_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "typedVariableList"
    // Pddl.g:175:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
    public final PddlParser.typedVariableList_return typedVariableList() throws RecognitionException {
        PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VARIABLE63 = null;
        Token VARIABLE65 = null;
        PddlParser.singleTypeVarList_return singleTypeVarList64 = null;


        Object VARIABLE63_tree = null;
        Object VARIABLE65_tree = null;

        try {
            // Pddl.g:176:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
            // Pddl.g:176:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
            {
                root_0 = (Object) adaptor.nil();


                // Pddl.g:176:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
                int alt24 = 2;
                alt24 = dfa24.predict(input);
                switch (alt24) {
                    case 1: // Pddl.g:176:8: ( VARIABLE )*
                    {
                        // Pddl.g:176:8: ( VARIABLE )*
                        loop21:
                        do {
                            int alt21 = 2;
                            int LA21_0 = input.LA(1);

                            if ((LA21_0 == VARIABLE)) {
                                alt21 = 1;
                            }


                            switch (alt21) {
                                case 1: // Pddl.g:176:8: VARIABLE
                                {
                                    VARIABLE63 = (Token) match(input, VARIABLE, FOLLOW_VARIABLE_in_typedVariableList869);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        VARIABLE63_tree =
                                                (Object) adaptor.create(VARIABLE63);
                                        adaptor.addChild(root_0, VARIABLE63_tree);
                                    }

                                }
                                break;

                                default:
                                    break loop21;
                            }
                        } while (true);


                    }
                    break;
                    case 2: // Pddl.g:176:20: ( singleTypeVarList )+ ( VARIABLE )*
                    {
                        // Pddl.g:176:20: ( singleTypeVarList )+
                        int cnt22 = 0;
                        loop22:
                        do {
                            int alt22 = 2;
                            alt22 = dfa22.predict(input);
                            switch (alt22) {
                                case 1: // Pddl.g:176:20: singleTypeVarList
                                {
                                    pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList874);
                                    singleTypeVarList64 = singleTypeVarList();

                                    state._fsp--;
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        adaptor.addChild(root_0, singleTypeVarList64.getTree());
                                    }

                                }
                                break;

                                default:
                                    if (cnt22 >= 1) {
                                        break loop22;
                                    }
                                    if (state.backtracking > 0) {
                                        state.failed = true;
                                        return retval;
                                    }
                                    EarlyExitException eee =
                                            new EarlyExitException(22, input);
                                    throw eee;
                            }
                            cnt22++;
                        } while (true);


                        // Pddl.g:176:39: ( VARIABLE )*
                        loop23:
                        do {
                            int alt23 = 2;
                            int LA23_0 = input.LA(1);

                            if ((LA23_0 == VARIABLE)) {
                                alt23 = 1;
                            }


                            switch (alt23) {
                                case 1: // Pddl.g:176:39: VARIABLE
                                {
                                    VARIABLE65 = (Token) match(input, VARIABLE, FOLLOW_VARIABLE_in_typedVariableList877);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        VARIABLE65_tree =
                                                (Object) adaptor.create(VARIABLE65);
                                        adaptor.addChild(root_0, VARIABLE65_tree);
                                    }

                                }
                                break;

                                default:
                                    break loop23;
                            }
                        } while (true);


                    }
                    break;

                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typedVariableList"

    public static class singleTypeVarList_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "singleTypeVarList"
    // Pddl.g:179:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
    public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
        PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VARIABLE66 = null;
        Token char_literal67 = null;
        PddlParser.type_return t = null;


        Object VARIABLE66_tree = null;
        Object char_literal67_tree = null;
        RewriteRuleTokenStream stream_VARIABLE = new RewriteRuleTokenStream(adaptor, "token VARIABLE");
        RewriteRuleTokenStream stream_60 = new RewriteRuleTokenStream(adaptor, "token 60");
        RewriteRuleSubtreeStream stream_type = new RewriteRuleSubtreeStream(adaptor, "rule type");
        try {
            // Pddl.g:180:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
            // Pddl.g:180:7: ( ( VARIABLE )+ '-' t= type )
            {
                // Pddl.g:180:7: ( ( VARIABLE )+ '-' t= type )
                // Pddl.g:180:8: ( VARIABLE )+ '-' t= type
                {
                    // Pddl.g:180:8: ( VARIABLE )+
                    int cnt25 = 0;
                    loop25:
                    do {
                        int alt25 = 2;
                        int LA25_0 = input.LA(1);

                        if ((LA25_0 == VARIABLE)) {
                            alt25 = 1;
                        }


                        switch (alt25) {
                            case 1: // Pddl.g:180:8: VARIABLE
                            {
                                VARIABLE66 = (Token) match(input, VARIABLE, FOLLOW_VARIABLE_in_singleTypeVarList897);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_VARIABLE.add(VARIABLE66);
                                }


                            }
                            break;

                            default:
                                if (cnt25 >= 1) {
                                    break loop25;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee =
                                        new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    char_literal67 = (Token) match(input, 60, FOLLOW_60_in_singleTypeVarList900);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_60.add(char_literal67);
                    }


                    pushFollow(FOLLOW_type_in_singleTypeVarList904);
                    t = type();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_type.add(t.getTree());
                    }

                }


                // AST REWRITE
                // elements: VARIABLE, t
                // token labels: 
                // rule labels: retval, t
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);
                    RewriteRuleSubtreeStream stream_t = new RewriteRuleSubtreeStream(adaptor, "rule t", t != null ? t.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 181:7: -> ( ^( VARIABLE $t) )+
                    {
                        if (!(stream_VARIABLE.hasNext() || stream_t.hasNext())) {
                            throw new RewriteEarlyExitException();
                        }
                        while (stream_VARIABLE.hasNext() || stream_t.hasNext()) {
                            // Pddl.g:181:10: ^( VARIABLE $t)
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        stream_VARIABLE.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_t.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_VARIABLE.reset();
                        stream_t.reset();

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "singleTypeVarList"

    public static class constraints_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "constraints"
    // Pddl.g:184:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
    public final PddlParser.constraints_return constraints() throws RecognitionException {
        PddlParser.constraints_return retval = new PddlParser.constraints_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal68 = null;
        Token string_literal69 = null;
        Token char_literal71 = null;
        PddlParser.conGD_return conGD70 = null;


        Object char_literal68_tree = null;
        Object string_literal69_tree = null;
        Object char_literal71_tree = null;

        try {
            // Pddl.g:185:2: ( '(' ! ':constraints' ^ conGD ')' !)
            // Pddl.g:185:4: '(' ! ':constraints' ^ conGD ')' !
            {
                root_0 = (Object) adaptor.nil();


                char_literal68 = (Token) match(input, 56, FOLLOW_56_in_constraints935);
                if (state.failed) {
                    return retval;
                }

                string_literal69 = (Token) match(input, 65, FOLLOW_65_in_constraints938);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    string_literal69_tree =
                            (Object) adaptor.create(string_literal69);
                    root_0 = (Object) adaptor.becomeRoot(string_literal69_tree, root_0);
                }

                pushFollow(FOLLOW_conGD_in_constraints941);
                conGD70 = conGD();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, conGD70.getTree());
                }

                char_literal71 = (Token) match(input, 57, FOLLOW_57_in_constraints943);
                if (state.failed) {
                    return retval;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraints"

    public static class structureDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "structureDef"
    // Pddl.g:188:1: structureDef : ( actionDef | durativeActionDef | derivedDef );
    public final PddlParser.structureDef_return structureDef() throws RecognitionException {
        PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.actionDef_return actionDef72 = null;

        PddlParser.durativeActionDef_return durativeActionDef73 = null;

        PddlParser.derivedDef_return derivedDef74 = null;



        try {
            // Pddl.g:189:2: ( actionDef | durativeActionDef | derivedDef )
            int alt26 = 3;
            int LA26_0 = input.LA(1);

            if ((LA26_0 == 56)) {
                switch (input.LA(2)) {
                    case 62: {
                        alt26 = 1;
                    }
                    break;
                    case 69: {
                        alt26 = 2;
                    }
                    break;
                    case 66: {
                        alt26 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 26, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1: // Pddl.g:189:4: actionDef
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_actionDef_in_structureDef955);
                    actionDef72 = actionDef();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, actionDef72.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:190:4: durativeActionDef
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_durativeActionDef_in_structureDef960);
                    durativeActionDef73 = durativeActionDef();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, durativeActionDef73.getTree());
                    }

                }
                break;
                case 3: // Pddl.g:191:4: derivedDef
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_derivedDef_in_structureDef965);
                    derivedDef74 = derivedDef();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, derivedDef74.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "structureDef"

    public static class actionDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "actionDef"
    // Pddl.g:197:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol typedVariableList actionDefBody ) ;
    public final PddlParser.actionDef_return actionDef() throws RecognitionException {
        PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal75 = null;
        Token string_literal76 = null;
        Token string_literal78 = null;
        Token char_literal79 = null;
        Token char_literal81 = null;
        Token char_literal83 = null;
        PddlParser.actionSymbol_return actionSymbol77 = null;

        PddlParser.typedVariableList_return typedVariableList80 = null;

        PddlParser.actionDefBody_return actionDefBody82 = null;


        Object char_literal75_tree = null;
        Object string_literal76_tree = null;
        Object string_literal78_tree = null;
        Object char_literal79_tree = null;
        Object char_literal81_tree = null;
        Object char_literal83_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_62 = new RewriteRuleTokenStream(adaptor, "token 62");
        RewriteRuleTokenStream stream_76 = new RewriteRuleTokenStream(adaptor, "token 76");
        RewriteRuleSubtreeStream stream_actionSymbol = new RewriteRuleSubtreeStream(adaptor, "rule actionSymbol");
        RewriteRuleSubtreeStream stream_typedVariableList = new RewriteRuleSubtreeStream(adaptor, "rule typedVariableList");
        RewriteRuleSubtreeStream stream_actionDefBody = new RewriteRuleSubtreeStream(adaptor, "rule actionDefBody");
        try {
            // Pddl.g:198:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol typedVariableList actionDefBody ) )
            // Pddl.g:198:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
            {
                char_literal75 = (Token) match(input, 56, FOLLOW_56_in_actionDef980);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal75);
                }


                string_literal76 = (Token) match(input, 62, FOLLOW_62_in_actionDef982);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_62.add(string_literal76);
                }


                pushFollow(FOLLOW_actionSymbol_in_actionDef984);
                actionSymbol77 = actionSymbol();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_actionSymbol.add(actionSymbol77.getTree());
                }

                string_literal78 = (Token) match(input, 76, FOLLOW_76_in_actionDef993);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_76.add(string_literal78);
                }


                char_literal79 = (Token) match(input, 56, FOLLOW_56_in_actionDef995);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal79);
                }


                pushFollow(FOLLOW_typedVariableList_in_actionDef997);
                typedVariableList80 = typedVariableList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_typedVariableList.add(typedVariableList80.getTree());
                }

                char_literal81 = (Token) match(input, 57, FOLLOW_57_in_actionDef999);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal81);
                }


                pushFollow(FOLLOW_actionDefBody_in_actionDef1012);
                actionDefBody82 = actionDefBody();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_actionDefBody.add(actionDefBody82.getTree());
                }

                char_literal83 = (Token) match(input, 57, FOLLOW_57_in_actionDef1014);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal83);
                }


                // AST REWRITE
                // elements: actionSymbol, actionDefBody, typedVariableList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 201:8: -> ^( ACTION actionSymbol typedVariableList actionDefBody )
                    {
                        // Pddl.g:201:11: ^( ACTION actionSymbol typedVariableList actionDefBody )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(ACTION, "ACTION"), root_1);

                            adaptor.addChild(root_1, stream_actionSymbol.nextTree());

                            adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                            adaptor.addChild(root_1, stream_actionDefBody.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionDef"

    public static class actionSymbol_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "actionSymbol"
    // Pddl.g:204:1: actionSymbol : NAME ;
    public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
        PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME84 = null;

        Object NAME84_tree = null;

        try {
            // Pddl.g:204:14: ( NAME )
            // Pddl.g:204:16: NAME
            {
                root_0 = (Object) adaptor.nil();


                NAME84 = (Token) match(input, NAME, FOLLOW_NAME_in_actionSymbol1046);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    NAME84_tree =
                            (Object) adaptor.create(NAME84);
                    adaptor.addChild(root_0, NAME84_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionSymbol"

    public static class actionDefBody_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "actionDefBody"
    // Pddl.g:210:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
    public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
        PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal85 = null;
        Token char_literal86 = null;
        Token char_literal87 = null;
        Token string_literal89 = null;
        Token char_literal90 = null;
        Token char_literal91 = null;
        PddlParser.goalDesc_return goalDesc88 = null;

        PddlParser.effect_return effect92 = null;


        Object string_literal85_tree = null;
        Object char_literal86_tree = null;
        Object char_literal87_tree = null;
        Object string_literal89_tree = null;
        Object char_literal90_tree = null;
        Object char_literal91_tree = null;
        RewriteRuleTokenStream stream_77 = new RewriteRuleTokenStream(adaptor, "token 77");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_70 = new RewriteRuleTokenStream(adaptor, "token 70");
        RewriteRuleSubtreeStream stream_effect = new RewriteRuleSubtreeStream(adaptor, "rule effect");
        RewriteRuleSubtreeStream stream_goalDesc = new RewriteRuleSubtreeStream(adaptor, "rule goalDesc");
        try {
            // Pddl.g:211:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
            // Pddl.g:211:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
            {
                // Pddl.g:211:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
                int alt28 = 2;
                int LA28_0 = input.LA(1);

                if ((LA28_0 == 77)) {
                    alt28 = 1;
                }
                switch (alt28) {
                    case 1: // Pddl.g:211:6: ':precondition' ( ( '(' ')' ) | goalDesc )
                    {
                        string_literal85 = (Token) match(input, 77, FOLLOW_77_in_actionDefBody1062);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_77.add(string_literal85);
                        }


                        // Pddl.g:211:22: ( ( '(' ')' ) | goalDesc )
                        int alt27 = 2;
                        int LA27_0 = input.LA(1);

                        if ((LA27_0 == 56)) {
                            int LA27_1 = input.LA(2);

                            if ((LA27_1 == 57)) {
                                alt27 = 1;
                            } else if ((LA27_1 == NAME || (LA27_1 >= 81 && LA27_1 <= 85) || LA27_1 == 90 || (LA27_1 >= 99 && LA27_1 <= 100) || LA27_1 == 103 || LA27_1 == 108 || LA27_1 == 110)) {
                                alt27 = 2;
                            } else {
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 27, 1, input);

                                throw nvae;

                            }
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 27, 0, input);

                            throw nvae;

                        }
                        switch (alt27) {
                            case 1: // Pddl.g:211:23: ( '(' ')' )
                            {
                                // Pddl.g:211:23: ( '(' ')' )
                                // Pddl.g:211:24: '(' ')'
                                {
                                    char_literal86 = (Token) match(input, 56, FOLLOW_56_in_actionDefBody1066);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_56.add(char_literal86);
                                    }


                                    char_literal87 = (Token) match(input, 57, FOLLOW_57_in_actionDefBody1068);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_57.add(char_literal87);
                                    }


                                }


                            }
                            break;
                            case 2: // Pddl.g:211:35: goalDesc
                            {
                                pushFollow(FOLLOW_goalDesc_in_actionDefBody1073);
                                goalDesc88 = goalDesc();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_goalDesc.add(goalDesc88.getTree());
                                }

                            }
                            break;

                        }


                    }
                    break;

                }


                // Pddl.g:212:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
                int alt30 = 2;
                int LA30_0 = input.LA(1);

                if ((LA30_0 == 70)) {
                    alt30 = 1;
                }
                switch (alt30) {
                    case 1: // Pddl.g:212:6: ':effect' ( ( '(' ')' ) | effect )
                    {
                        string_literal89 = (Token) match(input, 70, FOLLOW_70_in_actionDefBody1083);
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_70.add(string_literal89);
                        }


                        // Pddl.g:212:16: ( ( '(' ')' ) | effect )
                        int alt29 = 2;
                        int LA29_0 = input.LA(1);

                        if ((LA29_0 == 56)) {
                            int LA29_1 = input.LA(2);

                            if ((LA29_1 == 57)) {
                                alt29 = 1;
                            } else if ((LA29_1 == NAME || (LA29_1 >= 90 && LA29_1 <= 91) || LA29_1 == 94 || LA29_1 == 100 || LA29_1 == 104 || LA29_1 == 108 || (LA29_1 >= 114 && LA29_1 <= 115) || LA29_1 == 120)) {
                                alt29 = 2;
                            } else {
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 29, 1, input);

                                throw nvae;

                            }
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 29, 0, input);

                            throw nvae;

                        }
                        switch (alt29) {
                            case 1: // Pddl.g:212:17: ( '(' ')' )
                            {
                                // Pddl.g:212:17: ( '(' ')' )
                                // Pddl.g:212:18: '(' ')'
                                {
                                    char_literal90 = (Token) match(input, 56, FOLLOW_56_in_actionDefBody1087);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_56.add(char_literal90);
                                    }


                                    char_literal91 = (Token) match(input, 57, FOLLOW_57_in_actionDefBody1089);
                                    if (state.failed) {
                                        return retval;
                                    }
                                    if (state.backtracking == 0) {
                                        stream_57.add(char_literal91);
                                    }


                                }


                            }
                            break;
                            case 2: // Pddl.g:212:29: effect
                            {
                                pushFollow(FOLLOW_effect_in_actionDefBody1094);
                                effect92 = effect();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_effect.add(effect92.getTree());
                                }

                            }
                            break;

                        }


                    }
                    break;

                }


                // AST REWRITE
                // elements: effect, goalDesc
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 213:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
                    {
                        // Pddl.g:213:7: ^( PRECONDITION ( goalDesc )? )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PRECONDITION, "PRECONDITION"), root_1);

                            // Pddl.g:213:22: ( goalDesc )?
                            if (stream_goalDesc.hasNext()) {
                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                            }
                            stream_goalDesc.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                        // Pddl.g:213:33: ^( EFFECT ( effect )? )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(EFFECT, "EFFECT"), root_1);

                            // Pddl.g:213:42: ( effect )?
                            if (stream_effect.hasNext()) {
                                adaptor.addChild(root_1, stream_effect.nextTree());

                            }
                            stream_effect.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionDefBody"

    public static class goalDesc_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "goalDesc"
    // Pddl.g:227:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) );
    public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
        PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal94 = null;
        Token string_literal95 = null;
        Token char_literal97 = null;
        Token char_literal98 = null;
        Token string_literal99 = null;
        Token char_literal101 = null;
        Token char_literal102 = null;
        Token string_literal103 = null;
        Token char_literal105 = null;
        Token char_literal106 = null;
        Token string_literal107 = null;
        Token char_literal110 = null;
        Token char_literal111 = null;
        Token string_literal112 = null;
        Token char_literal113 = null;
        Token char_literal115 = null;
        Token char_literal117 = null;
        Token char_literal118 = null;
        Token string_literal119 = null;
        Token char_literal120 = null;
        Token char_literal122 = null;
        Token char_literal124 = null;
        PddlParser.atomicTermFormula_return atomicTermFormula93 = null;

        PddlParser.goalDesc_return goalDesc96 = null;

        PddlParser.goalDesc_return goalDesc100 = null;

        PddlParser.goalDesc_return goalDesc104 = null;

        PddlParser.goalDesc_return goalDesc108 = null;

        PddlParser.goalDesc_return goalDesc109 = null;

        PddlParser.typedVariableList_return typedVariableList114 = null;

        PddlParser.goalDesc_return goalDesc116 = null;

        PddlParser.typedVariableList_return typedVariableList121 = null;

        PddlParser.goalDesc_return goalDesc123 = null;

        PddlParser.fComp_return fComp125 = null;


        Object char_literal94_tree = null;
        Object string_literal95_tree = null;
        Object char_literal97_tree = null;
        Object char_literal98_tree = null;
        Object string_literal99_tree = null;
        Object char_literal101_tree = null;
        Object char_literal102_tree = null;
        Object string_literal103_tree = null;
        Object char_literal105_tree = null;
        Object char_literal106_tree = null;
        Object string_literal107_tree = null;
        Object char_literal110_tree = null;
        Object char_literal111_tree = null;
        Object string_literal112_tree = null;
        Object char_literal113_tree = null;
        Object char_literal115_tree = null;
        Object char_literal117_tree = null;
        Object char_literal118_tree = null;
        Object string_literal119_tree = null;
        Object char_literal120_tree = null;
        Object char_literal122_tree = null;
        Object char_literal124_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_108 = new RewriteRuleTokenStream(adaptor, "token 108");
        RewriteRuleTokenStream stream_110 = new RewriteRuleTokenStream(adaptor, "token 110");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_90 = new RewriteRuleTokenStream(adaptor, "token 90");
        RewriteRuleTokenStream stream_103 = new RewriteRuleTokenStream(adaptor, "token 103");
        RewriteRuleTokenStream stream_99 = new RewriteRuleTokenStream(adaptor, "token 99");
        RewriteRuleTokenStream stream_100 = new RewriteRuleTokenStream(adaptor, "token 100");
        RewriteRuleSubtreeStream stream_fComp = new RewriteRuleSubtreeStream(adaptor, "rule fComp");
        RewriteRuleSubtreeStream stream_goalDesc = new RewriteRuleSubtreeStream(adaptor, "rule goalDesc");
        RewriteRuleSubtreeStream stream_typedVariableList = new RewriteRuleSubtreeStream(adaptor, "rule typedVariableList");
        try {
            // Pddl.g:228:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) )
            int alt33 = 8;
            int LA33_0 = input.LA(1);

            if ((LA33_0 == 56)) {
                switch (input.LA(2)) {
                    case 90: {
                        alt33 = 2;
                    }
                    break;
                    case 110: {
                        alt33 = 3;
                    }
                    break;
                    case 108: {
                        alt33 = 4;
                    }
                    break;
                    case 103: {
                        alt33 = 5;
                    }
                    break;
                    case 99: {
                        alt33 = 6;
                    }
                    break;
                    case 100: {
                        alt33 = 7;
                    }
                    break;
                    case NAME: {
                        alt33 = 1;
                    }
                    break;
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85: {
                        alt33 = 8;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 33, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1: // Pddl.g:228:4: atomicTermFormula
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1138);
                    atomicTermFormula93 = atomicTermFormula();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, atomicTermFormula93.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:229:4: '(' 'and' ( goalDesc )* ')'
                {
                    char_literal94 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1143);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal94);
                    }


                    string_literal95 = (Token) match(input, 90, FOLLOW_90_in_goalDesc1145);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_90.add(string_literal95);
                    }


                    // Pddl.g:229:14: ( goalDesc )*
                    loop31:
                    do {
                        int alt31 = 2;
                        int LA31_0 = input.LA(1);

                        if ((LA31_0 == 56)) {
                            alt31 = 1;
                        }


                        switch (alt31) {
                            case 1: // Pddl.g:229:14: goalDesc
                            {
                                pushFollow(FOLLOW_goalDesc_in_goalDesc1147);
                                goalDesc96 = goalDesc();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_goalDesc.add(goalDesc96.getTree());
                                }

                            }
                            break;

                            default:
                                break loop31;
                        }
                    } while (true);


                    char_literal97 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1150);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal97);
                    }


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 230:12: -> ^( AND_GD ( goalDesc )* )
                        {
                            // Pddl.g:230:15: ^( AND_GD ( goalDesc )* )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(AND_GD, "AND_GD"), root_1);

                                // Pddl.g:230:24: ( goalDesc )*
                                while (stream_goalDesc.hasNext()) {
                                    adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                }
                                stream_goalDesc.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:231:4: '(' 'or' ( goalDesc )* ')'
                {
                    char_literal98 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1175);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal98);
                    }


                    string_literal99 = (Token) match(input, 110, FOLLOW_110_in_goalDesc1177);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_110.add(string_literal99);
                    }


                    // Pddl.g:231:13: ( goalDesc )*
                    loop32:
                    do {
                        int alt32 = 2;
                        int LA32_0 = input.LA(1);

                        if ((LA32_0 == 56)) {
                            alt32 = 1;
                        }


                        switch (alt32) {
                            case 1: // Pddl.g:231:13: goalDesc
                            {
                                pushFollow(FOLLOW_goalDesc_in_goalDesc1179);
                                goalDesc100 = goalDesc();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_goalDesc.add(goalDesc100.getTree());
                                }

                            }
                            break;

                            default:
                                break loop32;
                        }
                    } while (true);


                    char_literal101 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1182);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal101);
                    }


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 232:12: -> ^( OR_GD ( goalDesc )* )
                        {
                            // Pddl.g:232:15: ^( OR_GD ( goalDesc )* )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(OR_GD, "OR_GD"), root_1);

                                // Pddl.g:232:23: ( goalDesc )*
                                while (stream_goalDesc.hasNext()) {
                                    adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                }
                                stream_goalDesc.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 4: // Pddl.g:233:4: '(' 'not' goalDesc ')'
                {
                    char_literal102 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1207);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal102);
                    }


                    string_literal103 = (Token) match(input, 108, FOLLOW_108_in_goalDesc1209);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_108.add(string_literal103);
                    }


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1211);
                    goalDesc104 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc104.getTree());
                    }

                    char_literal105 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1213);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal105);
                    }


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 234:12: -> ^( NOT_GD goalDesc )
                        {
                            // Pddl.g:234:15: ^( NOT_GD goalDesc )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(NOT_GD, "NOT_GD"), root_1);

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 5: // Pddl.g:235:4: '(' 'imply' goalDesc goalDesc ')'
                {
                    char_literal106 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1237);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal106);
                    }


                    string_literal107 = (Token) match(input, 103, FOLLOW_103_in_goalDesc1239);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_103.add(string_literal107);
                    }


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1241);
                    goalDesc108 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc108.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_goalDesc1243);
                    goalDesc109 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc109.getTree());
                    }

                    char_literal110 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1245);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal110);
                    }


                    // AST REWRITE
                    // elements: goalDesc, goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 236:12: -> ^( IMPLY_GD goalDesc goalDesc )
                        {
                            // Pddl.g:236:15: ^( IMPLY_GD goalDesc goalDesc )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(IMPLY_GD, "IMPLY_GD"), root_1);

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 6: // Pddl.g:237:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
                {
                    char_literal111 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1271);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal111);
                    }


                    string_literal112 = (Token) match(input, 99, FOLLOW_99_in_goalDesc1273);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_99.add(string_literal112);
                    }


                    char_literal113 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1275);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal113);
                    }


                    pushFollow(FOLLOW_typedVariableList_in_goalDesc1277);
                    typedVariableList114 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_typedVariableList.add(typedVariableList114.getTree());
                    }

                    char_literal115 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1279);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal115);
                    }


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1281);
                    goalDesc116 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc116.getTree());
                    }

                    char_literal117 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1283);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal117);
                    }


                    // AST REWRITE
                    // elements: goalDesc, typedVariableList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 238:12: -> ^( EXISTS_GD typedVariableList goalDesc )
                        {
                            // Pddl.g:238:15: ^( EXISTS_GD typedVariableList goalDesc )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(EXISTS_GD, "EXISTS_GD"), root_1);

                                adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 7: // Pddl.g:239:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
                {
                    char_literal118 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1309);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal118);
                    }


                    string_literal119 = (Token) match(input, 100, FOLLOW_100_in_goalDesc1311);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_100.add(string_literal119);
                    }


                    char_literal120 = (Token) match(input, 56, FOLLOW_56_in_goalDesc1313);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal120);
                    }


                    pushFollow(FOLLOW_typedVariableList_in_goalDesc1315);
                    typedVariableList121 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_typedVariableList.add(typedVariableList121.getTree());
                    }

                    char_literal122 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1317);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal122);
                    }


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1319);
                    goalDesc123 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc123.getTree());
                    }

                    char_literal124 = (Token) match(input, 57, FOLLOW_57_in_goalDesc1321);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal124);
                    }


                    // AST REWRITE
                    // elements: goalDesc, typedVariableList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 240:12: -> ^( FORALL_GD typedVariableList goalDesc )
                        {
                            // Pddl.g:240:15: ^( FORALL_GD typedVariableList goalDesc )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(FORALL_GD, "FORALL_GD"), root_1);

                                adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 8: // Pddl.g:241:7: fComp
                {
                    pushFollow(FOLLOW_fComp_in_goalDesc1350);
                    fComp125 = fComp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fComp.add(fComp125.getTree());
                    }

                    // AST REWRITE
                    // elements: fComp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 242:15: -> ^( COMPARISON_GD fComp )
                        {
                            // Pddl.g:242:18: ^( COMPARISON_GD fComp )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(COMPARISON_GD, "COMPARISON_GD"), root_1);

                                adaptor.addChild(root_1, stream_fComp.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "goalDesc"

    public static class fComp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fComp"
    // Pddl.g:245:1: fComp : '(' ! binaryComp fExp fExp ')' !;
    public final PddlParser.fComp_return fComp() throws RecognitionException {
        PddlParser.fComp_return retval = new PddlParser.fComp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal126 = null;
        Token char_literal130 = null;
        PddlParser.binaryComp_return binaryComp127 = null;

        PddlParser.fExp_return fExp128 = null;

        PddlParser.fExp_return fExp129 = null;


        Object char_literal126_tree = null;
        Object char_literal130_tree = null;

        try {
            // Pddl.g:246:2: ( '(' ! binaryComp fExp fExp ')' !)
            // Pddl.g:246:4: '(' ! binaryComp fExp fExp ')' !
            {
                root_0 = (Object) adaptor.nil();


                char_literal126 = (Token) match(input, 56, FOLLOW_56_in_fComp1386);
                if (state.failed) {
                    return retval;
                }

                pushFollow(FOLLOW_binaryComp_in_fComp1389);
                binaryComp127 = binaryComp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, binaryComp127.getTree());
                }

                pushFollow(FOLLOW_fExp_in_fComp1391);
                fExp128 = fExp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, fExp128.getTree());
                }

                pushFollow(FOLLOW_fExp_in_fComp1393);
                fExp129 = fExp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, fExp129.getTree());
                }

                char_literal130 = (Token) match(input, 57, FOLLOW_57_in_fComp1395);
                if (state.failed) {
                    return retval;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fComp"

    public static class atomicTermFormula_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "atomicTermFormula"
    // Pddl.g:249:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
    public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
        PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal131 = null;
        Token char_literal134 = null;
        PddlParser.predicate_return predicate132 = null;

        PddlParser.term_return term133 = null;


        Object char_literal131_tree = null;
        Object char_literal134_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_term = new RewriteRuleSubtreeStream(adaptor, "rule term");
        RewriteRuleSubtreeStream stream_predicate = new RewriteRuleSubtreeStream(adaptor, "rule predicate");
        try {
            // Pddl.g:250:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
            // Pddl.g:250:4: '(' predicate ( term )* ')'
            {
                char_literal131 = (Token) match(input, 56, FOLLOW_56_in_atomicTermFormula1407);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal131);
                }


                pushFollow(FOLLOW_predicate_in_atomicTermFormula1409);
                predicate132 = predicate();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_predicate.add(predicate132.getTree());
                }

                // Pddl.g:250:18: ( term )*
                loop34:
                do {
                    int alt34 = 2;
                    int LA34_0 = input.LA(1);

                    if ((LA34_0 == NAME || LA34_0 == VARIABLE)) {
                        alt34 = 1;
                    }


                    switch (alt34) {
                        case 1: // Pddl.g:250:18: term
                        {
                            pushFollow(FOLLOW_term_in_atomicTermFormula1411);
                            term133 = term();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_term.add(term133.getTree());
                            }

                        }
                        break;

                        default:
                            break loop34;
                    }
                } while (true);


                char_literal134 = (Token) match(input, 57, FOLLOW_57_in_atomicTermFormula1414);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal134);
                }


                // AST REWRITE
                // elements: predicate, term
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 250:28: -> ^( PRED_HEAD predicate ( term )* )
                    {
                        // Pddl.g:250:31: ^( PRED_HEAD predicate ( term )* )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);

                            adaptor.addChild(root_1, stream_predicate.nextTree());

                            // Pddl.g:250:53: ( term )*
                            while (stream_term.hasNext()) {
                                adaptor.addChild(root_1, stream_term.nextTree());

                            }
                            stream_term.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicTermFormula"

    public static class term_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "term"
    // Pddl.g:253:1: term : ( NAME | VARIABLE );
    public final PddlParser.term_return term() throws RecognitionException {
        PddlParser.term_return retval = new PddlParser.term_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set135 = null;

        Object set135_tree = null;

        try {
            // Pddl.g:253:6: ( NAME | VARIABLE )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set135 = (Token) input.LT(1);

                if (input.LA(1) == NAME || input.LA(1) == VARIABLE) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set135));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class durativeActionDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "durativeActionDef"
    // Pddl.g:257:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' typedVariableList ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
    public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
        PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal136 = null;
        Token string_literal137 = null;
        Token string_literal139 = null;
        Token char_literal140 = null;
        Token char_literal142 = null;
        Token char_literal144 = null;
        PddlParser.actionSymbol_return actionSymbol138 = null;

        PddlParser.typedVariableList_return typedVariableList141 = null;

        PddlParser.daDefBody_return daDefBody143 = null;


        Object char_literal136_tree = null;
        Object string_literal137_tree = null;
        Object string_literal139_tree = null;
        Object char_literal140_tree = null;
        Object char_literal142_tree = null;
        Object char_literal144_tree = null;
        RewriteRuleTokenStream stream_69 = new RewriteRuleTokenStream(adaptor, "token 69");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_76 = new RewriteRuleTokenStream(adaptor, "token 76");
        RewriteRuleSubtreeStream stream_actionSymbol = new RewriteRuleSubtreeStream(adaptor, "rule actionSymbol");
        RewriteRuleSubtreeStream stream_daDefBody = new RewriteRuleSubtreeStream(adaptor, "rule daDefBody");
        RewriteRuleSubtreeStream stream_typedVariableList = new RewriteRuleSubtreeStream(adaptor, "rule typedVariableList");
        try {
            // Pddl.g:258:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' typedVariableList ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
            // Pddl.g:258:4: '(' ':durative-action' actionSymbol ':parameters' '(' typedVariableList ')' daDefBody ')'
            {
                char_literal136 = (Token) match(input, 56, FOLLOW_56_in_durativeActionDef1452);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal136);
                }


                string_literal137 = (Token) match(input, 69, FOLLOW_69_in_durativeActionDef1454);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_69.add(string_literal137);
                }


                pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1456);
                actionSymbol138 = actionSymbol();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_actionSymbol.add(actionSymbol138.getTree());
                }

                string_literal139 = (Token) match(input, 76, FOLLOW_76_in_durativeActionDef1465);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_76.add(string_literal139);
                }


                char_literal140 = (Token) match(input, 56, FOLLOW_56_in_durativeActionDef1467);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal140);
                }


                pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1469);
                typedVariableList141 = typedVariableList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_typedVariableList.add(typedVariableList141.getTree());
                }

                char_literal142 = (Token) match(input, 57, FOLLOW_57_in_durativeActionDef1471);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal142);
                }


                pushFollow(FOLLOW_daDefBody_in_durativeActionDef1484);
                daDefBody143 = daDefBody();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_daDefBody.add(daDefBody143.getTree());
                }

                char_literal144 = (Token) match(input, 57, FOLLOW_57_in_durativeActionDef1486);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal144);
                }


                // AST REWRITE
                // elements: daDefBody, actionSymbol, typedVariableList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 261:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
                    {
                        // Pddl.g:261:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(DURATIVE_ACTION, "DURATIVE_ACTION"), root_1);

                            adaptor.addChild(root_1, stream_actionSymbol.nextTree());

                            adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                            adaptor.addChild(root_1, stream_daDefBody.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durativeActionDef"

    public static class daDefBody_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "daDefBody"
    // Pddl.g:264:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
    public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
        PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal145 = null;
        Token string_literal147 = null;
        Token char_literal148 = null;
        Token char_literal149 = null;
        Token string_literal151 = null;
        Token char_literal152 = null;
        Token char_literal153 = null;
        PddlParser.durationConstraint_return durationConstraint146 = null;

        PddlParser.daGD_return daGD150 = null;

        PddlParser.daEffect_return daEffect154 = null;


        Object string_literal145_tree = null;
        Object string_literal147_tree = null;
        Object char_literal148_tree = null;
        Object char_literal149_tree = null;
        Object string_literal151_tree = null;
        Object char_literal152_tree = null;
        Object char_literal153_tree = null;

        try {
            // Pddl.g:265:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
            int alt37 = 3;
            switch (input.LA(1)) {
                case 68: {
                    alt37 = 1;
                }
                break;
                case 63: {
                    alt37 = 2;
                }
                break;
                case 70: {
                    alt37 = 3;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                    throw nvae;

            }

            switch (alt37) {
                case 1: // Pddl.g:265:4: ':duration' durationConstraint
                {
                    root_0 = (Object) adaptor.nil();


                    string_literal145 = (Token) match(input, 68, FOLLOW_68_in_daDefBody1519);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal145_tree =
                                (Object) adaptor.create(string_literal145);
                        adaptor.addChild(root_0, string_literal145_tree);
                    }

                    pushFollow(FOLLOW_durationConstraint_in_daDefBody1521);
                    durationConstraint146 = durationConstraint();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, durationConstraint146.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:266:4: ':condition' ( ( '(' ')' ) | daGD )
                {
                    root_0 = (Object) adaptor.nil();


                    string_literal147 = (Token) match(input, 63, FOLLOW_63_in_daDefBody1526);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal147_tree =
                                (Object) adaptor.create(string_literal147);
                        adaptor.addChild(root_0, string_literal147_tree);
                    }

                    // Pddl.g:266:17: ( ( '(' ')' ) | daGD )
                    int alt35 = 2;
                    int LA35_0 = input.LA(1);

                    if ((LA35_0 == 56)) {
                        int LA35_1 = input.LA(2);

                        if ((LA35_1 == 57)) {
                            alt35 = 1;
                        } else if ((LA35_1 == 90 || LA35_1 == 92 || LA35_1 == 100 || (LA35_1 >= 111 && LA35_1 <= 112))) {
                            alt35 = 2;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 35, 1, input);

                            throw nvae;

                        }
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 35, 0, input);

                        throw nvae;

                    }
                    switch (alt35) {
                        case 1: // Pddl.g:266:18: ( '(' ')' )
                        {
                            // Pddl.g:266:18: ( '(' ')' )
                            // Pddl.g:266:19: '(' ')'
                            {
                                char_literal148 = (Token) match(input, 56, FOLLOW_56_in_daDefBody1530);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    char_literal148_tree =
                                            (Object) adaptor.create(char_literal148);
                                    adaptor.addChild(root_0, char_literal148_tree);
                                }

                                char_literal149 = (Token) match(input, 57, FOLLOW_57_in_daDefBody1532);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    char_literal149_tree =
                                            (Object) adaptor.create(char_literal149);
                                    adaptor.addChild(root_0, char_literal149_tree);
                                }

                            }


                        }
                        break;
                        case 2: // Pddl.g:266:30: daGD
                        {
                            pushFollow(FOLLOW_daGD_in_daDefBody1537);
                            daGD150 = daGD();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                adaptor.addChild(root_0, daGD150.getTree());
                            }

                        }
                        break;

                    }


                }
                break;
                case 3: // Pddl.g:267:7: ':effect' ( ( '(' ')' ) | daEffect )
                {
                    root_0 = (Object) adaptor.nil();


                    string_literal151 = (Token) match(input, 70, FOLLOW_70_in_daDefBody1546);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal151_tree =
                                (Object) adaptor.create(string_literal151);
                        adaptor.addChild(root_0, string_literal151_tree);
                    }

                    // Pddl.g:267:17: ( ( '(' ')' ) | daEffect )
                    int alt36 = 2;
                    int LA36_0 = input.LA(1);

                    if ((LA36_0 == 56)) {
                        int LA36_1 = input.LA(2);

                        if ((LA36_1 == 57)) {
                            alt36 = 1;
                        } else if (((LA36_1 >= 90 && LA36_1 <= 92) || LA36_1 == 94 || LA36_1 == 100 || LA36_1 == 104 || (LA36_1 >= 114 && LA36_1 <= 115) || LA36_1 == 120)) {
                            alt36 = 2;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 36, 1, input);

                            throw nvae;

                        }
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 36, 0, input);

                        throw nvae;

                    }
                    switch (alt36) {
                        case 1: // Pddl.g:267:18: ( '(' ')' )
                        {
                            // Pddl.g:267:18: ( '(' ')' )
                            // Pddl.g:267:19: '(' ')'
                            {
                                char_literal152 = (Token) match(input, 56, FOLLOW_56_in_daDefBody1550);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    char_literal152_tree =
                                            (Object) adaptor.create(char_literal152);
                                    adaptor.addChild(root_0, char_literal152_tree);
                                }

                                char_literal153 = (Token) match(input, 57, FOLLOW_57_in_daDefBody1552);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    char_literal153_tree =
                                            (Object) adaptor.create(char_literal153);
                                    adaptor.addChild(root_0, char_literal153_tree);
                                }

                            }


                        }
                        break;
                        case 2: // Pddl.g:267:30: daEffect
                        {
                            pushFollow(FOLLOW_daEffect_in_daDefBody1557);
                            daEffect154 = daEffect();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                adaptor.addChild(root_0, daEffect154.getTree());
                            }

                        }
                        break;

                    }


                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daDefBody"

    public static class daGD_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "daGD"
    // Pddl.g:270:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
    public final PddlParser.daGD_return daGD() throws RecognitionException {
        PddlParser.daGD_return retval = new PddlParser.daGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal156 = null;
        Token string_literal157 = null;
        Token char_literal159 = null;
        Token char_literal160 = null;
        Token string_literal161 = null;
        Token char_literal162 = null;
        Token char_literal164 = null;
        Token char_literal166 = null;
        PddlParser.prefTimedGD_return prefTimedGD155 = null;

        PddlParser.daGD_return daGD158 = null;

        PddlParser.typedVariableList_return typedVariableList163 = null;

        PddlParser.daGD_return daGD165 = null;


        Object char_literal156_tree = null;
        Object string_literal157_tree = null;
        Object char_literal159_tree = null;
        Object char_literal160_tree = null;
        Object string_literal161_tree = null;
        Object char_literal162_tree = null;
        Object char_literal164_tree = null;
        Object char_literal166_tree = null;

        try {
            // Pddl.g:271:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
            int alt39 = 3;
            int LA39_0 = input.LA(1);

            if ((LA39_0 == 56)) {
                switch (input.LA(2)) {
                    case 92:
                    case 111:
                    case 112: {
                        alt39 = 1;
                    }
                    break;
                    case 90: {
                        alt39 = 2;
                    }
                    break;
                    case 100: {
                        alt39 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 39, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1: // Pddl.g:271:4: prefTimedGD
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_prefTimedGD_in_daGD1572);
                    prefTimedGD155 = prefTimedGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, prefTimedGD155.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:272:4: '(' 'and' ( daGD )* ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal156 = (Token) match(input, 56, FOLLOW_56_in_daGD1577);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal156_tree =
                                (Object) adaptor.create(char_literal156);
                        adaptor.addChild(root_0, char_literal156_tree);
                    }

                    string_literal157 = (Token) match(input, 90, FOLLOW_90_in_daGD1579);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal157_tree =
                                (Object) adaptor.create(string_literal157);
                        adaptor.addChild(root_0, string_literal157_tree);
                    }

                    // Pddl.g:272:14: ( daGD )*
                    loop38:
                    do {
                        int alt38 = 2;
                        int LA38_0 = input.LA(1);

                        if ((LA38_0 == 56)) {
                            alt38 = 1;
                        }


                        switch (alt38) {
                            case 1: // Pddl.g:272:14: daGD
                            {
                                pushFollow(FOLLOW_daGD_in_daGD1581);
                                daGD158 = daGD();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, daGD158.getTree());
                                }

                            }
                            break;

                            default:
                                break loop38;
                        }
                    } while (true);


                    char_literal159 = (Token) match(input, 57, FOLLOW_57_in_daGD1584);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal159_tree =
                                (Object) adaptor.create(char_literal159);
                        adaptor.addChild(root_0, char_literal159_tree);
                    }

                }
                break;
                case 3: // Pddl.g:273:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal160 = (Token) match(input, 56, FOLLOW_56_in_daGD1589);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal160_tree =
                                (Object) adaptor.create(char_literal160);
                        adaptor.addChild(root_0, char_literal160_tree);
                    }

                    string_literal161 = (Token) match(input, 100, FOLLOW_100_in_daGD1591);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal161_tree =
                                (Object) adaptor.create(string_literal161);
                        adaptor.addChild(root_0, string_literal161_tree);
                    }

                    char_literal162 = (Token) match(input, 56, FOLLOW_56_in_daGD1593);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal162_tree =
                                (Object) adaptor.create(char_literal162);
                        adaptor.addChild(root_0, char_literal162_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_daGD1595);
                    typedVariableList163 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, typedVariableList163.getTree());
                    }

                    char_literal164 = (Token) match(input, 57, FOLLOW_57_in_daGD1597);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal164_tree =
                                (Object) adaptor.create(char_literal164);
                        adaptor.addChild(root_0, char_literal164_tree);
                    }

                    pushFollow(FOLLOW_daGD_in_daGD1599);
                    daGD165 = daGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, daGD165.getTree());
                    }

                    char_literal166 = (Token) match(input, 57, FOLLOW_57_in_daGD1601);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal166_tree =
                                (Object) adaptor.create(char_literal166);
                        adaptor.addChild(root_0, char_literal166_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daGD"

    public static class prefTimedGD_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "prefTimedGD"
    // Pddl.g:276:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
    public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
        PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal168 = null;
        Token string_literal169 = null;
        Token NAME170 = null;
        Token char_literal172 = null;
        PddlParser.timedGD_return timedGD167 = null;

        PddlParser.timedGD_return timedGD171 = null;


        Object char_literal168_tree = null;
        Object string_literal169_tree = null;
        Object NAME170_tree = null;
        Object char_literal172_tree = null;

        try {
            // Pddl.g:277:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
            int alt41 = 2;
            int LA41_0 = input.LA(1);

            if ((LA41_0 == 56)) {
                int LA41_1 = input.LA(2);

                if ((LA41_1 == 92 || LA41_1 == 111)) {
                    alt41 = 1;
                } else if ((LA41_1 == 112)) {
                    alt41 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 41, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1: // Pddl.g:277:4: timedGD
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_timedGD_in_prefTimedGD1612);
                    timedGD167 = timedGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timedGD167.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:278:4: '(' 'preference' ( NAME )? timedGD ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal168 = (Token) match(input, 56, FOLLOW_56_in_prefTimedGD1617);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal168_tree =
                                (Object) adaptor.create(char_literal168);
                        adaptor.addChild(root_0, char_literal168_tree);
                    }

                    string_literal169 = (Token) match(input, 112, FOLLOW_112_in_prefTimedGD1619);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal169_tree =
                                (Object) adaptor.create(string_literal169);
                        adaptor.addChild(root_0, string_literal169_tree);
                    }

                    // Pddl.g:278:21: ( NAME )?
                    int alt40 = 2;
                    int LA40_0 = input.LA(1);

                    if ((LA40_0 == NAME)) {
                        alt40 = 1;
                    }
                    switch (alt40) {
                        case 1: // Pddl.g:278:21: NAME
                        {
                            NAME170 = (Token) match(input, NAME, FOLLOW_NAME_in_prefTimedGD1621);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                NAME170_tree =
                                        (Object) adaptor.create(NAME170);
                                adaptor.addChild(root_0, NAME170_tree);
                            }

                        }
                        break;

                    }


                    pushFollow(FOLLOW_timedGD_in_prefTimedGD1624);
                    timedGD171 = timedGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timedGD171.getTree());
                    }

                    char_literal172 = (Token) match(input, 57, FOLLOW_57_in_prefTimedGD1626);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal172_tree =
                                (Object) adaptor.create(char_literal172);
                        adaptor.addChild(root_0, char_literal172_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prefTimedGD"

    public static class timedGD_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "timedGD"
    // Pddl.g:281:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
    public final PddlParser.timedGD_return timedGD() throws RecognitionException {
        PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal173 = null;
        Token string_literal174 = null;
        Token char_literal177 = null;
        Token char_literal178 = null;
        Token string_literal179 = null;
        Token char_literal182 = null;
        PddlParser.timeSpecifier_return timeSpecifier175 = null;

        PddlParser.goalDesc_return goalDesc176 = null;

        PddlParser.interval_return interval180 = null;

        PddlParser.goalDesc_return goalDesc181 = null;


        Object char_literal173_tree = null;
        Object string_literal174_tree = null;
        Object char_literal177_tree = null;
        Object char_literal178_tree = null;
        Object string_literal179_tree = null;
        Object char_literal182_tree = null;

        try {
            // Pddl.g:282:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
            int alt42 = 2;
            int LA42_0 = input.LA(1);

            if ((LA42_0 == 56)) {
                int LA42_1 = input.LA(2);

                if ((LA42_1 == 92)) {
                    alt42 = 1;
                } else if ((LA42_1 == 111)) {
                    alt42 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 42, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1: // Pddl.g:282:4: '(' 'at' timeSpecifier goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal173 = (Token) match(input, 56, FOLLOW_56_in_timedGD1637);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal173_tree =
                                (Object) adaptor.create(char_literal173);
                        adaptor.addChild(root_0, char_literal173_tree);
                    }

                    string_literal174 = (Token) match(input, 92, FOLLOW_92_in_timedGD1639);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal174_tree =
                                (Object) adaptor.create(string_literal174);
                        adaptor.addChild(root_0, string_literal174_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedGD1641);
                    timeSpecifier175 = timeSpecifier();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timeSpecifier175.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_timedGD1643);
                    goalDesc176 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc176.getTree());
                    }

                    char_literal177 = (Token) match(input, 57, FOLLOW_57_in_timedGD1645);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal177_tree =
                                (Object) adaptor.create(char_literal177);
                        adaptor.addChild(root_0, char_literal177_tree);
                    }

                }
                break;
                case 2: // Pddl.g:283:4: '(' 'over' interval goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal178 = (Token) match(input, 56, FOLLOW_56_in_timedGD1650);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal178_tree =
                                (Object) adaptor.create(char_literal178);
                        adaptor.addChild(root_0, char_literal178_tree);
                    }

                    string_literal179 = (Token) match(input, 111, FOLLOW_111_in_timedGD1652);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal179_tree =
                                (Object) adaptor.create(string_literal179);
                        adaptor.addChild(root_0, string_literal179_tree);
                    }

                    pushFollow(FOLLOW_interval_in_timedGD1654);
                    interval180 = interval();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, interval180.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_timedGD1656);
                    goalDesc181 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc181.getTree());
                    }

                    char_literal182 = (Token) match(input, 57, FOLLOW_57_in_timedGD1658);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal182_tree =
                                (Object) adaptor.create(char_literal182);
                        adaptor.addChild(root_0, char_literal182_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timedGD"

    public static class timeSpecifier_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "timeSpecifier"
    // Pddl.g:286:1: timeSpecifier : ( 'start' | 'end' );
    public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
        PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set183 = null;

        Object set183_tree = null;

        try {
            // Pddl.g:286:15: ( 'start' | 'end' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set183 = (Token) input.LT(1);

                if (input.LA(1) == 98 || input.LA(1) == 119) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set183));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timeSpecifier"

    public static class interval_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "interval"
    // Pddl.g:287:1: interval : 'all' ;
    public final PddlParser.interval_return interval() throws RecognitionException {
        PddlParser.interval_return retval = new PddlParser.interval_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal184 = null;

        Object string_literal184_tree = null;

        try {
            // Pddl.g:287:10: ( 'all' )
            // Pddl.g:287:12: 'all'
            {
                root_0 = (Object) adaptor.nil();


                string_literal184 = (Token) match(input, 87, FOLLOW_87_in_interval1680);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    string_literal184_tree =
                            (Object) adaptor.create(string_literal184);
                    adaptor.addChild(root_0, string_literal184_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interval"

    public static class derivedDef_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "derivedDef"
    // Pddl.g:291:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
    public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
        PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal185 = null;
        Token string_literal186 = null;
        Token char_literal189 = null;
        PddlParser.typedVariableList_return typedVariableList187 = null;

        PddlParser.goalDesc_return goalDesc188 = null;


        Object char_literal185_tree = null;
        Object string_literal186_tree = null;
        Object char_literal189_tree = null;

        try {
            // Pddl.g:292:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
            // Pddl.g:292:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
            {
                root_0 = (Object) adaptor.nil();


                char_literal185 = (Token) match(input, 56, FOLLOW_56_in_derivedDef1693);
                if (state.failed) {
                    return retval;
                }

                string_literal186 = (Token) match(input, 66, FOLLOW_66_in_derivedDef1696);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    string_literal186_tree =
                            (Object) adaptor.create(string_literal186);
                    root_0 = (Object) adaptor.becomeRoot(string_literal186_tree, root_0);
                }

                pushFollow(FOLLOW_typedVariableList_in_derivedDef1699);
                typedVariableList187 = typedVariableList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, typedVariableList187.getTree());
                }

                pushFollow(FOLLOW_goalDesc_in_derivedDef1701);
                goalDesc188 = goalDesc();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, goalDesc188.getTree());
                }

                char_literal189 = (Token) match(input, 57, FOLLOW_57_in_derivedDef1703);
                if (state.failed) {
                    return retval;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "derivedDef"

    public static class fExp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fExp"
    // Pddl.g:297:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
    public final PddlParser.fExp_return fExp() throws RecognitionException {
        PddlParser.fExp_return retval = new PddlParser.fExp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUMBER190 = null;
        Token char_literal191 = null;
        Token char_literal195 = null;
        Token char_literal196 = null;
        Token char_literal197 = null;
        Token char_literal199 = null;
        PddlParser.binaryOp_return binaryOp192 = null;

        PddlParser.fExp_return fExp193 = null;

        PddlParser.fExp2_return fExp2194 = null;

        PddlParser.fExp_return fExp198 = null;

        PddlParser.fHead_return fHead200 = null;


        Object NUMBER190_tree = null;
        Object char_literal191_tree = null;
        Object char_literal195_tree = null;
        Object char_literal196_tree = null;
        Object char_literal197_tree = null;
        Object char_literal199_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_60 = new RewriteRuleTokenStream(adaptor, "token 60");
        RewriteRuleSubtreeStream stream_fExp2 = new RewriteRuleSubtreeStream(adaptor, "rule fExp2");
        RewriteRuleSubtreeStream stream_fExp = new RewriteRuleSubtreeStream(adaptor, "rule fExp");
        RewriteRuleSubtreeStream stream_binaryOp = new RewriteRuleSubtreeStream(adaptor, "rule binaryOp");
        try {
            // Pddl.g:298:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
            int alt43 = 4;
            switch (input.LA(1)) {
                case NUMBER: {
                    alt43 = 1;
                }
                break;
                case 56: {
                    int LA43_2 = input.LA(2);

                    if ((synpred55_Pddl())) {
                        alt43 = 2;
                    } else if ((synpred56_Pddl())) {
                        alt43 = 3;
                    } else if ((true)) {
                        alt43 = 4;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 43, 2, input);

                        throw nvae;

                    }
                }
                break;
                case NAME: {
                    alt43 = 4;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                    throw nvae;

            }

            switch (alt43) {
                case 1: // Pddl.g:298:4: NUMBER
                {
                    root_0 = (Object) adaptor.nil();


                    NUMBER190 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_fExp1718);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER190_tree =
                                (Object) adaptor.create(NUMBER190);
                        adaptor.addChild(root_0, NUMBER190_tree);
                    }

                }
                break;
                case 2: // Pddl.g:299:4: '(' binaryOp fExp fExp2 ')'
                {
                    char_literal191 = (Token) match(input, 56, FOLLOW_56_in_fExp1723);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal191);
                    }


                    pushFollow(FOLLOW_binaryOp_in_fExp1725);
                    binaryOp192 = binaryOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_binaryOp.add(binaryOp192.getTree());
                    }

                    pushFollow(FOLLOW_fExp_in_fExp1727);
                    fExp193 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fExp.add(fExp193.getTree());
                    }

                    pushFollow(FOLLOW_fExp2_in_fExp1729);
                    fExp2194 = fExp2();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fExp2.add(fExp2194.getTree());
                    }

                    char_literal195 = (Token) match(input, 57, FOLLOW_57_in_fExp1731);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal195);
                    }


                    // AST REWRITE
                    // elements: fExp, fExp2, binaryOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 299:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
                        {
                            // Pddl.g:299:35: ^( BINARY_OP binaryOp fExp fExp2 )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(BINARY_OP, "BINARY_OP"), root_1);

                                adaptor.addChild(root_1, stream_binaryOp.nextTree());

                                adaptor.addChild(root_1, stream_fExp.nextTree());

                                adaptor.addChild(root_1, stream_fExp2.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:300:4: '(' '-' fExp ')'
                {
                    char_literal196 = (Token) match(input, 56, FOLLOW_56_in_fExp1748);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal196);
                    }


                    char_literal197 = (Token) match(input, 60, FOLLOW_60_in_fExp1750);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_60.add(char_literal197);
                    }


                    pushFollow(FOLLOW_fExp_in_fExp1752);
                    fExp198 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fExp.add(fExp198.getTree());
                    }

                    char_literal199 = (Token) match(input, 57, FOLLOW_57_in_fExp1754);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal199);
                    }


                    // AST REWRITE
                    // elements: fExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 300:21: -> ^( UNARY_MINUS fExp )
                        {
                            // Pddl.g:300:24: ^( UNARY_MINUS fExp )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);

                                adaptor.addChild(root_1, stream_fExp.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 4: // Pddl.g:301:4: fHead
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_fHead_in_fExp1767);
                    fHead200 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fHead200.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExp"

    public static class fExp2_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fExp2"
    // Pddl.g:306:1: fExp2 : fExp ;
    public final PddlParser.fExp2_return fExp2() throws RecognitionException {
        PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.fExp_return fExp201 = null;



        try {
            // Pddl.g:306:7: ( fExp )
            // Pddl.g:306:9: fExp
            {
                root_0 = (Object) adaptor.nil();


                pushFollow(FOLLOW_fExp_in_fExp21779);
                fExp201 = fExp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, fExp201.getTree());
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExp2"

    public static class fHead_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fHead"
    // Pddl.g:308:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
    public final PddlParser.fHead_return fHead() throws RecognitionException {
        PddlParser.fHead_return retval = new PddlParser.fHead_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal202 = null;
        Token char_literal205 = null;
        PddlParser.functionSymbol_return functionSymbol203 = null;

        PddlParser.term_return term204 = null;

        PddlParser.functionSymbol_return functionSymbol206 = null;


        Object char_literal202_tree = null;
        Object char_literal205_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_term = new RewriteRuleSubtreeStream(adaptor, "rule term");
        RewriteRuleSubtreeStream stream_functionSymbol = new RewriteRuleSubtreeStream(adaptor, "rule functionSymbol");
        try {
            // Pddl.g:309:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
            int alt45 = 2;
            int LA45_0 = input.LA(1);

            if ((LA45_0 == 56)) {
                alt45 = 1;
            } else if ((LA45_0 == NAME)) {
                alt45 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1: // Pddl.g:309:4: '(' functionSymbol ( term )* ')'
                {
                    char_literal202 = (Token) match(input, 56, FOLLOW_56_in_fHead1789);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal202);
                    }


                    pushFollow(FOLLOW_functionSymbol_in_fHead1791);
                    functionSymbol203 = functionSymbol();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_functionSymbol.add(functionSymbol203.getTree());
                    }

                    // Pddl.g:309:23: ( term )*
                    loop44:
                    do {
                        int alt44 = 2;
                        int LA44_0 = input.LA(1);

                        if ((LA44_0 == NAME || LA44_0 == VARIABLE)) {
                            alt44 = 1;
                        }


                        switch (alt44) {
                            case 1: // Pddl.g:309:23: term
                            {
                                pushFollow(FOLLOW_term_in_fHead1793);
                                term204 = term();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_term.add(term204.getTree());
                                }

                            }
                            break;

                            default:
                                break loop44;
                        }
                    } while (true);


                    char_literal205 = (Token) match(input, 57, FOLLOW_57_in_fHead1796);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal205);
                    }


                    // AST REWRITE
                    // elements: term, functionSymbol
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 309:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
                        {
                            // Pddl.g:309:36: ^( FUNC_HEAD functionSymbol ( term )* )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);

                                adaptor.addChild(root_1, stream_functionSymbol.nextTree());

                                // Pddl.g:309:63: ( term )*
                                while (stream_term.hasNext()) {
                                    adaptor.addChild(root_1, stream_term.nextTree());

                                }
                                stream_term.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:310:4: functionSymbol
                {
                    pushFollow(FOLLOW_functionSymbol_in_fHead1812);
                    functionSymbol206 = functionSymbol();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_functionSymbol.add(functionSymbol206.getTree());
                    }

                    // AST REWRITE
                    // elements: functionSymbol
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 310:19: -> ^( FUNC_HEAD functionSymbol )
                        {
                            // Pddl.g:310:22: ^( FUNC_HEAD functionSymbol )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);

                                adaptor.addChild(root_1, stream_functionSymbol.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fHead"

    public static class effect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "effect"
    // Pddl.g:313:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
    public final PddlParser.effect_return effect() throws RecognitionException {
        PddlParser.effect_return retval = new PddlParser.effect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal207 = null;
        Token string_literal208 = null;
        Token char_literal210 = null;
        PddlParser.cEffect_return cEffect209 = null;

        PddlParser.cEffect_return cEffect211 = null;


        Object char_literal207_tree = null;
        Object string_literal208_tree = null;
        Object char_literal210_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_90 = new RewriteRuleTokenStream(adaptor, "token 90");
        RewriteRuleSubtreeStream stream_cEffect = new RewriteRuleSubtreeStream(adaptor, "rule cEffect");
        try {
            // Pddl.g:314:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
            int alt47 = 2;
            int LA47_0 = input.LA(1);

            if ((LA47_0 == 56)) {
                int LA47_1 = input.LA(2);

                if ((LA47_1 == 90)) {
                    alt47 = 1;
                } else if ((LA47_1 == NAME || LA47_1 == 91 || LA47_1 == 94 || LA47_1 == 100 || LA47_1 == 104 || LA47_1 == 108 || (LA47_1 >= 114 && LA47_1 <= 115) || LA47_1 == 120)) {
                    alt47 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1: // Pddl.g:314:4: '(' 'and' ( cEffect )* ')'
                {
                    char_literal207 = (Token) match(input, 56, FOLLOW_56_in_effect1831);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal207);
                    }


                    string_literal208 = (Token) match(input, 90, FOLLOW_90_in_effect1833);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_90.add(string_literal208);
                    }


                    // Pddl.g:314:14: ( cEffect )*
                    loop46:
                    do {
                        int alt46 = 2;
                        int LA46_0 = input.LA(1);

                        if ((LA46_0 == 56)) {
                            alt46 = 1;
                        }


                        switch (alt46) {
                            case 1: // Pddl.g:314:14: cEffect
                            {
                                pushFollow(FOLLOW_cEffect_in_effect1835);
                                cEffect209 = cEffect();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_cEffect.add(cEffect209.getTree());
                                }

                            }
                            break;

                            default:
                                break loop46;
                        }
                    } while (true);


                    char_literal210 = (Token) match(input, 57, FOLLOW_57_in_effect1838);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal210);
                    }


                    // AST REWRITE
                    // elements: cEffect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 314:27: -> ^( AND_EFFECT ( cEffect )* )
                        {
                            // Pddl.g:314:30: ^( AND_EFFECT ( cEffect )* )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);

                                // Pddl.g:314:43: ( cEffect )*
                                while (stream_cEffect.hasNext()) {
                                    adaptor.addChild(root_1, stream_cEffect.nextTree());

                                }
                                stream_cEffect.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:315:4: cEffect
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_cEffect_in_effect1852);
                    cEffect211 = cEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, cEffect211.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "effect"

    public static class cEffect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "cEffect"
    // Pddl.g:318:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
    public final PddlParser.cEffect_return cEffect() throws RecognitionException {
        PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal212 = null;
        Token string_literal213 = null;
        Token char_literal214 = null;
        Token char_literal216 = null;
        Token char_literal218 = null;
        Token char_literal219 = null;
        Token string_literal220 = null;
        Token char_literal223 = null;
        PddlParser.typedVariableList_return typedVariableList215 = null;

        PddlParser.effect_return effect217 = null;

        PddlParser.goalDesc_return goalDesc221 = null;

        PddlParser.condEffect_return condEffect222 = null;

        PddlParser.pEffect_return pEffect224 = null;


        Object char_literal212_tree = null;
        Object string_literal213_tree = null;
        Object char_literal214_tree = null;
        Object char_literal216_tree = null;
        Object char_literal218_tree = null;
        Object char_literal219_tree = null;
        Object string_literal220_tree = null;
        Object char_literal223_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_120 = new RewriteRuleTokenStream(adaptor, "token 120");
        RewriteRuleTokenStream stream_100 = new RewriteRuleTokenStream(adaptor, "token 100");
        RewriteRuleSubtreeStream stream_effect = new RewriteRuleSubtreeStream(adaptor, "rule effect");
        RewriteRuleSubtreeStream stream_condEffect = new RewriteRuleSubtreeStream(adaptor, "rule condEffect");
        RewriteRuleSubtreeStream stream_goalDesc = new RewriteRuleSubtreeStream(adaptor, "rule goalDesc");
        RewriteRuleSubtreeStream stream_typedVariableList = new RewriteRuleSubtreeStream(adaptor, "rule typedVariableList");
        try {
            // Pddl.g:319:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
            int alt48 = 3;
            int LA48_0 = input.LA(1);

            if ((LA48_0 == 56)) {
                switch (input.LA(2)) {
                    case 100: {
                        alt48 = 1;
                    }
                    break;
                    case 120: {
                        alt48 = 2;
                    }
                    break;
                    case NAME:
                    case 91:
                    case 94:
                    case 104:
                    case 108:
                    case 114:
                    case 115: {
                        alt48 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 48, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1: // Pddl.g:319:4: '(' 'forall' '(' typedVariableList ')' effect ')'
                {
                    char_literal212 = (Token) match(input, 56, FOLLOW_56_in_cEffect1863);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal212);
                    }


                    string_literal213 = (Token) match(input, 100, FOLLOW_100_in_cEffect1865);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_100.add(string_literal213);
                    }


                    char_literal214 = (Token) match(input, 56, FOLLOW_56_in_cEffect1867);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal214);
                    }


                    pushFollow(FOLLOW_typedVariableList_in_cEffect1869);
                    typedVariableList215 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_typedVariableList.add(typedVariableList215.getTree());
                    }

                    char_literal216 = (Token) match(input, 57, FOLLOW_57_in_cEffect1871);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal216);
                    }


                    pushFollow(FOLLOW_effect_in_cEffect1873);
                    effect217 = effect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_effect.add(effect217.getTree());
                    }

                    char_literal218 = (Token) match(input, 57, FOLLOW_57_in_cEffect1875);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal218);
                    }


                    // AST REWRITE
                    // elements: typedVariableList, effect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 320:4: -> ^( FORALL_EFFECT typedVariableList effect )
                        {
                            // Pddl.g:320:7: ^( FORALL_EFFECT typedVariableList effect )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(FORALL_EFFECT, "FORALL_EFFECT"), root_1);

                                adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                                adaptor.addChild(root_1, stream_effect.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:321:4: '(' 'when' goalDesc condEffect ')'
                {
                    char_literal219 = (Token) match(input, 56, FOLLOW_56_in_cEffect1893);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal219);
                    }


                    string_literal220 = (Token) match(input, 120, FOLLOW_120_in_cEffect1895);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_120.add(string_literal220);
                    }


                    pushFollow(FOLLOW_goalDesc_in_cEffect1897);
                    goalDesc221 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_goalDesc.add(goalDesc221.getTree());
                    }

                    pushFollow(FOLLOW_condEffect_in_cEffect1899);
                    condEffect222 = condEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_condEffect.add(condEffect222.getTree());
                    }

                    char_literal223 = (Token) match(input, 57, FOLLOW_57_in_cEffect1901);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal223);
                    }


                    // AST REWRITE
                    // elements: goalDesc, condEffect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 322:4: -> ^( WHEN_EFFECT goalDesc condEffect )
                        {
                            // Pddl.g:322:7: ^( WHEN_EFFECT goalDesc condEffect )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(WHEN_EFFECT, "WHEN_EFFECT"), root_1);

                                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                                adaptor.addChild(root_1, stream_condEffect.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:323:4: pEffect
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_pEffect_in_cEffect1919);
                    pEffect224 = pEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, pEffect224.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cEffect"

    public static class pEffect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "pEffect"
    // Pddl.g:326:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
    public final PddlParser.pEffect_return pEffect() throws RecognitionException {
        PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal225 = null;
        Token char_literal229 = null;
        Token char_literal230 = null;
        Token string_literal231 = null;
        Token char_literal233 = null;
        PddlParser.assignOp_return assignOp226 = null;

        PddlParser.fHead_return fHead227 = null;

        PddlParser.fExp_return fExp228 = null;

        PddlParser.atomicTermFormula_return atomicTermFormula232 = null;

        PddlParser.atomicTermFormula_return atomicTermFormula234 = null;


        Object char_literal225_tree = null;
        Object char_literal229_tree = null;
        Object char_literal230_tree = null;
        Object string_literal231_tree = null;
        Object char_literal233_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_108 = new RewriteRuleTokenStream(adaptor, "token 108");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_fHead = new RewriteRuleSubtreeStream(adaptor, "rule fHead");
        RewriteRuleSubtreeStream stream_assignOp = new RewriteRuleSubtreeStream(adaptor, "rule assignOp");
        RewriteRuleSubtreeStream stream_atomicTermFormula = new RewriteRuleSubtreeStream(adaptor, "rule atomicTermFormula");
        RewriteRuleSubtreeStream stream_fExp = new RewriteRuleSubtreeStream(adaptor, "rule fExp");
        try {
            // Pddl.g:327:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
            int alt49 = 3;
            int LA49_0 = input.LA(1);

            if ((LA49_0 == 56)) {
                switch (input.LA(2)) {
                    case 108: {
                        alt49 = 2;
                    }
                    break;
                    case 91:
                    case 94:
                    case 104:
                    case 114:
                    case 115: {
                        alt49 = 1;
                    }
                    break;
                    case NAME: {
                        alt49 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 49, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1: // Pddl.g:327:4: '(' assignOp fHead fExp ')'
                {
                    char_literal225 = (Token) match(input, 56, FOLLOW_56_in_pEffect1930);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal225);
                    }


                    pushFollow(FOLLOW_assignOp_in_pEffect1932);
                    assignOp226 = assignOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_assignOp.add(assignOp226.getTree());
                    }

                    pushFollow(FOLLOW_fHead_in_pEffect1934);
                    fHead227 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fHead.add(fHead227.getTree());
                    }

                    pushFollow(FOLLOW_fExp_in_pEffect1936);
                    fExp228 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fExp.add(fExp228.getTree());
                    }

                    char_literal229 = (Token) match(input, 57, FOLLOW_57_in_pEffect1938);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal229);
                    }


                    // AST REWRITE
                    // elements: fExp, fHead, assignOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 328:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
                        {
                            // Pddl.g:328:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(ASSIGN_EFFECT, "ASSIGN_EFFECT"), root_1);

                                adaptor.addChild(root_1, stream_assignOp.nextTree());

                                adaptor.addChild(root_1, stream_fHead.nextTree());

                                adaptor.addChild(root_1, stream_fExp.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:329:4: '(' 'not' atomicTermFormula ')'
                {
                    char_literal230 = (Token) match(input, 56, FOLLOW_56_in_pEffect1958);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal230);
                    }


                    string_literal231 = (Token) match(input, 108, FOLLOW_108_in_pEffect1960);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_108.add(string_literal231);
                    }


                    pushFollow(FOLLOW_atomicTermFormula_in_pEffect1962);
                    atomicTermFormula232 = atomicTermFormula();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomicTermFormula.add(atomicTermFormula232.getTree());
                    }

                    char_literal233 = (Token) match(input, 57, FOLLOW_57_in_pEffect1964);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal233);
                    }


                    // AST REWRITE
                    // elements: atomicTermFormula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 330:4: -> ^( NOT_EFFECT atomicTermFormula )
                        {
                            // Pddl.g:330:7: ^( NOT_EFFECT atomicTermFormula )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(NOT_EFFECT, "NOT_EFFECT"), root_1);

                                adaptor.addChild(root_1, stream_atomicTermFormula.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:331:4: atomicTermFormula
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_atomicTermFormula_in_pEffect1980);
                    atomicTermFormula234 = atomicTermFormula();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, atomicTermFormula234.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pEffect"

    public static class condEffect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "condEffect"
    // Pddl.g:336:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
    public final PddlParser.condEffect_return condEffect() throws RecognitionException {
        PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal235 = null;
        Token string_literal236 = null;
        Token char_literal238 = null;
        PddlParser.pEffect_return pEffect237 = null;

        PddlParser.pEffect_return pEffect239 = null;


        Object char_literal235_tree = null;
        Object string_literal236_tree = null;
        Object char_literal238_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_90 = new RewriteRuleTokenStream(adaptor, "token 90");
        RewriteRuleSubtreeStream stream_pEffect = new RewriteRuleSubtreeStream(adaptor, "rule pEffect");
        try {
            // Pddl.g:337:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
            int alt51 = 2;
            int LA51_0 = input.LA(1);

            if ((LA51_0 == 56)) {
                int LA51_1 = input.LA(2);

                if ((LA51_1 == 90)) {
                    alt51 = 1;
                } else if ((LA51_1 == NAME || LA51_1 == 91 || LA51_1 == 94 || LA51_1 == 104 || LA51_1 == 108 || (LA51_1 >= 114 && LA51_1 <= 115))) {
                    alt51 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 51, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 51, 0, input);

                throw nvae;

            }
            switch (alt51) {
                case 1: // Pddl.g:337:4: '(' 'and' ( pEffect )* ')'
                {
                    char_literal235 = (Token) match(input, 56, FOLLOW_56_in_condEffect1993);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal235);
                    }


                    string_literal236 = (Token) match(input, 90, FOLLOW_90_in_condEffect1995);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_90.add(string_literal236);
                    }


                    // Pddl.g:337:14: ( pEffect )*
                    loop50:
                    do {
                        int alt50 = 2;
                        int LA50_0 = input.LA(1);

                        if ((LA50_0 == 56)) {
                            alt50 = 1;
                        }


                        switch (alt50) {
                            case 1: // Pddl.g:337:14: pEffect
                            {
                                pushFollow(FOLLOW_pEffect_in_condEffect1997);
                                pEffect237 = pEffect();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_pEffect.add(pEffect237.getTree());
                                }

                            }
                            break;

                            default:
                                break loop50;
                        }
                    } while (true);


                    char_literal238 = (Token) match(input, 57, FOLLOW_57_in_condEffect2000);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal238);
                    }


                    // AST REWRITE
                    // elements: pEffect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 337:27: -> ^( AND_EFFECT ( pEffect )* )
                        {
                            // Pddl.g:337:30: ^( AND_EFFECT ( pEffect )* )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);

                                // Pddl.g:337:43: ( pEffect )*
                                while (stream_pEffect.hasNext()) {
                                    adaptor.addChild(root_1, stream_pEffect.nextTree());

                                }
                                stream_pEffect.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:338:4: pEffect
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_pEffect_in_condEffect2014);
                    pEffect239 = pEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, pEffect239.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condEffect"

    public static class binaryOp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "binaryOp"
    // Pddl.g:342:1: binaryOp : ( '*' | '+' | '-' | '/' );
    public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
        PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set240 = null;

        Object set240_tree = null;

        try {
            // Pddl.g:342:10: ( '*' | '+' | '-' | '/' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set240 = (Token) input.LT(1);

                if ((input.LA(1) >= 58 && input.LA(1) <= 61)) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set240));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "binaryOp"

    public static class multiOp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "multiOp"
    // Pddl.g:344:1: multiOp : ( '*' | '+' );
    public final PddlParser.multiOp_return multiOp() throws RecognitionException {
        PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set241 = null;

        Object set241_tree = null;

        try {
            // Pddl.g:344:9: ( '*' | '+' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set241 = (Token) input.LT(1);

                if ((input.LA(1) >= 58 && input.LA(1) <= 59)) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set241));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multiOp"

    public static class binaryComp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "binaryComp"
    // Pddl.g:346:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
    public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
        PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set242 = null;

        Object set242_tree = null;

        try {
            // Pddl.g:346:12: ( '>' | '<' | '=' | '>=' | '<=' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set242 = (Token) input.LT(1);

                if ((input.LA(1) >= 81 && input.LA(1) <= 85)) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set242));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "binaryComp"

    public static class assignOp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "assignOp"
    // Pddl.g:348:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
    public final PddlParser.assignOp_return assignOp() throws RecognitionException {
        PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set243 = null;

        Object set243_tree = null;

        try {
            // Pddl.g:348:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set243 = (Token) input.LT(1);

                if (input.LA(1) == 91 || input.LA(1) == 94 || input.LA(1) == 104 || (input.LA(1) >= 114 && input.LA(1) <= 115)) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set243));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignOp"

    public static class durationConstraint_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "durationConstraint"
    // Pddl.g:353:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
    public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
        PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal244 = null;
        Token string_literal245 = null;
        Token char_literal247 = null;
        Token char_literal248 = null;
        Token char_literal249 = null;
        PddlParser.simpleDurationConstraint_return simpleDurationConstraint246 = null;

        PddlParser.simpleDurationConstraint_return simpleDurationConstraint250 = null;


        Object char_literal244_tree = null;
        Object string_literal245_tree = null;
        Object char_literal247_tree = null;
        Object char_literal248_tree = null;
        Object char_literal249_tree = null;

        try {
            // Pddl.g:354:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
            int alt53 = 3;
            int LA53_0 = input.LA(1);

            if ((LA53_0 == 56)) {
                switch (input.LA(2)) {
                    case 90: {
                        alt53 = 1;
                    }
                    break;
                    case 57: {
                        alt53 = 2;
                    }
                    break;
                    case 82:
                    case 83:
                    case 85:
                    case 92: {
                        alt53 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 53, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1: // Pddl.g:354:4: '(' 'and' ( simpleDurationConstraint )+ ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal244 = (Token) match(input, 56, FOLLOW_56_in_durationConstraint2115);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal244_tree =
                                (Object) adaptor.create(char_literal244);
                        adaptor.addChild(root_0, char_literal244_tree);
                    }

                    string_literal245 = (Token) match(input, 90, FOLLOW_90_in_durationConstraint2117);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal245_tree =
                                (Object) adaptor.create(string_literal245);
                        adaptor.addChild(root_0, string_literal245_tree);
                    }

                    // Pddl.g:354:14: ( simpleDurationConstraint )+
                    int cnt52 = 0;
                    loop52:
                    do {
                        int alt52 = 2;
                        int LA52_0 = input.LA(1);

                        if ((LA52_0 == 56)) {
                            alt52 = 1;
                        }


                        switch (alt52) {
                            case 1: // Pddl.g:354:14: simpleDurationConstraint
                            {
                                pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2119);
                                simpleDurationConstraint246 = simpleDurationConstraint();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, simpleDurationConstraint246.getTree());
                                }

                            }
                            break;

                            default:
                                if (cnt52 >= 1) {
                                    break loop52;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee =
                                        new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);


                    char_literal247 = (Token) match(input, 57, FOLLOW_57_in_durationConstraint2122);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal247_tree =
                                (Object) adaptor.create(char_literal247);
                        adaptor.addChild(root_0, char_literal247_tree);
                    }

                }
                break;
                case 2: // Pddl.g:355:4: '(' ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal248 = (Token) match(input, 56, FOLLOW_56_in_durationConstraint2127);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal248_tree =
                                (Object) adaptor.create(char_literal248);
                        adaptor.addChild(root_0, char_literal248_tree);
                    }

                    char_literal249 = (Token) match(input, 57, FOLLOW_57_in_durationConstraint2129);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal249_tree =
                                (Object) adaptor.create(char_literal249);
                        adaptor.addChild(root_0, char_literal249_tree);
                    }

                }
                break;
                case 3: // Pddl.g:356:4: simpleDurationConstraint
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2134);
                    simpleDurationConstraint250 = simpleDurationConstraint();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, simpleDurationConstraint250.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durationConstraint"

    public static class simpleDurationConstraint_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "simpleDurationConstraint"
    // Pddl.g:359:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
    public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
        PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal251 = null;
        Token string_literal253 = null;
        Token char_literal255 = null;
        Token char_literal256 = null;
        Token string_literal257 = null;
        Token char_literal260 = null;
        PddlParser.durOp_return durOp252 = null;

        PddlParser.durValue_return durValue254 = null;

        PddlParser.timeSpecifier_return timeSpecifier258 = null;

        PddlParser.simpleDurationConstraint_return simpleDurationConstraint259 = null;


        Object char_literal251_tree = null;
        Object string_literal253_tree = null;
        Object char_literal255_tree = null;
        Object char_literal256_tree = null;
        Object string_literal257_tree = null;
        Object char_literal260_tree = null;

        try {
            // Pddl.g:360:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
            int alt54 = 2;
            int LA54_0 = input.LA(1);

            if ((LA54_0 == 56)) {
                int LA54_1 = input.LA(2);

                if ((LA54_1 == 92)) {
                    alt54 = 2;
                } else if (((LA54_1 >= 82 && LA54_1 <= 83) || LA54_1 == 85)) {
                    alt54 = 1;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 54, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1: // Pddl.g:360:4: '(' durOp '?duration' durValue ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal251 = (Token) match(input, 56, FOLLOW_56_in_simpleDurationConstraint2145);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal251_tree =
                                (Object) adaptor.create(char_literal251);
                        adaptor.addChild(root_0, char_literal251_tree);
                    }

                    pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2147);
                    durOp252 = durOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, durOp252.getTree());
                    }

                    string_literal253 = (Token) match(input, 86, FOLLOW_86_in_simpleDurationConstraint2149);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal253_tree =
                                (Object) adaptor.create(string_literal253);
                        adaptor.addChild(root_0, string_literal253_tree);
                    }

                    pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2151);
                    durValue254 = durValue();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, durValue254.getTree());
                    }

                    char_literal255 = (Token) match(input, 57, FOLLOW_57_in_simpleDurationConstraint2153);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal255_tree =
                                (Object) adaptor.create(char_literal255);
                        adaptor.addChild(root_0, char_literal255_tree);
                    }

                }
                break;
                case 2: // Pddl.g:361:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal256 = (Token) match(input, 56, FOLLOW_56_in_simpleDurationConstraint2158);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal256_tree =
                                (Object) adaptor.create(char_literal256);
                        adaptor.addChild(root_0, char_literal256_tree);
                    }

                    string_literal257 = (Token) match(input, 92, FOLLOW_92_in_simpleDurationConstraint2160);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal257_tree =
                                (Object) adaptor.create(string_literal257);
                        adaptor.addChild(root_0, string_literal257_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2162);
                    timeSpecifier258 = timeSpecifier();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timeSpecifier258.getTree());
                    }

                    pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2164);
                    simpleDurationConstraint259 = simpleDurationConstraint();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, simpleDurationConstraint259.getTree());
                    }

                    char_literal260 = (Token) match(input, 57, FOLLOW_57_in_simpleDurationConstraint2166);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal260_tree =
                                (Object) adaptor.create(char_literal260);
                        adaptor.addChild(root_0, char_literal260_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleDurationConstraint"

    public static class durOp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "durOp"
    // Pddl.g:364:1: durOp : ( '<=' | '>=' | '=' );
    public final PddlParser.durOp_return durOp() throws RecognitionException {
        PddlParser.durOp_return retval = new PddlParser.durOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set261 = null;

        Object set261_tree = null;

        try {
            // Pddl.g:364:7: ( '<=' | '>=' | '=' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set261 = (Token) input.LT(1);

                if ((input.LA(1) >= 82 && input.LA(1) <= 83) || input.LA(1) == 85) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set261));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durOp"

    public static class durValue_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "durValue"
    // Pddl.g:366:1: durValue : ( NUMBER | fExp );
    public final PddlParser.durValue_return durValue() throws RecognitionException {
        PddlParser.durValue_return retval = new PddlParser.durValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUMBER262 = null;
        PddlParser.fExp_return fExp263 = null;


        Object NUMBER262_tree = null;

        try {
            // Pddl.g:366:10: ( NUMBER | fExp )
            int alt55 = 2;
            int LA55_0 = input.LA(1);

            if ((LA55_0 == NUMBER)) {
                int LA55_1 = input.LA(2);

                if ((synpred85_Pddl())) {
                    alt55 = 1;
                } else if ((true)) {
                    alt55 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 55, 1, input);

                    throw nvae;

                }
            } else if ((LA55_0 == NAME || LA55_0 == 56)) {
                alt55 = 2;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1: // Pddl.g:366:12: NUMBER
                {
                    root_0 = (Object) adaptor.nil();


                    NUMBER262 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_durValue2193);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER262_tree =
                                (Object) adaptor.create(NUMBER262);
                        adaptor.addChild(root_0, NUMBER262_tree);
                    }

                }
                break;
                case 2: // Pddl.g:366:21: fExp
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_fExp_in_durValue2197);
                    fExp263 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fExp263.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durValue"

    public static class daEffect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "daEffect"
    // Pddl.g:368:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
    public final PddlParser.daEffect_return daEffect() throws RecognitionException {
        PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal264 = null;
        Token string_literal265 = null;
        Token char_literal267 = null;
        Token char_literal269 = null;
        Token string_literal270 = null;
        Token char_literal271 = null;
        Token char_literal273 = null;
        Token char_literal275 = null;
        Token char_literal276 = null;
        Token string_literal277 = null;
        Token char_literal280 = null;
        Token char_literal281 = null;
        Token char_literal285 = null;
        PddlParser.daEffect_return daEffect266 = null;

        PddlParser.timedEffect_return timedEffect268 = null;

        PddlParser.typedVariableList_return typedVariableList272 = null;

        PddlParser.daEffect_return daEffect274 = null;

        PddlParser.daGD_return daGD278 = null;

        PddlParser.timedEffect_return timedEffect279 = null;

        PddlParser.assignOp_return assignOp282 = null;

        PddlParser.fHead_return fHead283 = null;

        PddlParser.fExpDA_return fExpDA284 = null;


        Object char_literal264_tree = null;
        Object string_literal265_tree = null;
        Object char_literal267_tree = null;
        Object char_literal269_tree = null;
        Object string_literal270_tree = null;
        Object char_literal271_tree = null;
        Object char_literal273_tree = null;
        Object char_literal275_tree = null;
        Object char_literal276_tree = null;
        Object string_literal277_tree = null;
        Object char_literal280_tree = null;
        Object char_literal281_tree = null;
        Object char_literal285_tree = null;

        try {
            // Pddl.g:369:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
            int alt57 = 5;
            int LA57_0 = input.LA(1);

            if ((LA57_0 == 56)) {
                int LA57_1 = input.LA(2);

                if ((synpred87_Pddl())) {
                    alt57 = 1;
                } else if ((synpred88_Pddl())) {
                    alt57 = 2;
                } else if ((synpred89_Pddl())) {
                    alt57 = 3;
                } else if ((synpred90_Pddl())) {
                    alt57 = 4;
                } else if ((true)) {
                    alt57 = 5;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 57, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1: // Pddl.g:369:4: '(' 'and' ( daEffect )* ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal264 = (Token) match(input, 56, FOLLOW_56_in_daEffect2207);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal264_tree =
                                (Object) adaptor.create(char_literal264);
                        adaptor.addChild(root_0, char_literal264_tree);
                    }

                    string_literal265 = (Token) match(input, 90, FOLLOW_90_in_daEffect2209);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal265_tree =
                                (Object) adaptor.create(string_literal265);
                        adaptor.addChild(root_0, string_literal265_tree);
                    }

                    // Pddl.g:369:14: ( daEffect )*
                    loop56:
                    do {
                        int alt56 = 2;
                        int LA56_0 = input.LA(1);

                        if ((LA56_0 == 56)) {
                            alt56 = 1;
                        }


                        switch (alt56) {
                            case 1: // Pddl.g:369:14: daEffect
                            {
                                pushFollow(FOLLOW_daEffect_in_daEffect2211);
                                daEffect266 = daEffect();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, daEffect266.getTree());
                                }

                            }
                            break;

                            default:
                                break loop56;
                        }
                    } while (true);


                    char_literal267 = (Token) match(input, 57, FOLLOW_57_in_daEffect2214);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal267_tree =
                                (Object) adaptor.create(char_literal267);
                        adaptor.addChild(root_0, char_literal267_tree);
                    }

                }
                break;
                case 2: // Pddl.g:370:4: timedEffect
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_timedEffect_in_daEffect2219);
                    timedEffect268 = timedEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timedEffect268.getTree());
                    }

                }
                break;
                case 3: // Pddl.g:371:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal269 = (Token) match(input, 56, FOLLOW_56_in_daEffect2224);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal269_tree =
                                (Object) adaptor.create(char_literal269);
                        adaptor.addChild(root_0, char_literal269_tree);
                    }

                    string_literal270 = (Token) match(input, 100, FOLLOW_100_in_daEffect2226);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal270_tree =
                                (Object) adaptor.create(string_literal270);
                        adaptor.addChild(root_0, string_literal270_tree);
                    }

                    char_literal271 = (Token) match(input, 56, FOLLOW_56_in_daEffect2228);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal271_tree =
                                (Object) adaptor.create(char_literal271);
                        adaptor.addChild(root_0, char_literal271_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_daEffect2230);
                    typedVariableList272 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, typedVariableList272.getTree());
                    }

                    char_literal273 = (Token) match(input, 57, FOLLOW_57_in_daEffect2232);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal273_tree =
                                (Object) adaptor.create(char_literal273);
                        adaptor.addChild(root_0, char_literal273_tree);
                    }

                    pushFollow(FOLLOW_daEffect_in_daEffect2234);
                    daEffect274 = daEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, daEffect274.getTree());
                    }

                    char_literal275 = (Token) match(input, 57, FOLLOW_57_in_daEffect2236);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal275_tree =
                                (Object) adaptor.create(char_literal275);
                        adaptor.addChild(root_0, char_literal275_tree);
                    }

                }
                break;
                case 4: // Pddl.g:372:4: '(' 'when' daGD timedEffect ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal276 = (Token) match(input, 56, FOLLOW_56_in_daEffect2241);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal276_tree =
                                (Object) adaptor.create(char_literal276);
                        adaptor.addChild(root_0, char_literal276_tree);
                    }

                    string_literal277 = (Token) match(input, 120, FOLLOW_120_in_daEffect2243);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal277_tree =
                                (Object) adaptor.create(string_literal277);
                        adaptor.addChild(root_0, string_literal277_tree);
                    }

                    pushFollow(FOLLOW_daGD_in_daEffect2245);
                    daGD278 = daGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, daGD278.getTree());
                    }

                    pushFollow(FOLLOW_timedEffect_in_daEffect2247);
                    timedEffect279 = timedEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timedEffect279.getTree());
                    }

                    char_literal280 = (Token) match(input, 57, FOLLOW_57_in_daEffect2249);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal280_tree =
                                (Object) adaptor.create(char_literal280);
                        adaptor.addChild(root_0, char_literal280_tree);
                    }

                }
                break;
                case 5: // Pddl.g:373:4: '(' assignOp fHead fExpDA ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal281 = (Token) match(input, 56, FOLLOW_56_in_daEffect2254);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal281_tree =
                                (Object) adaptor.create(char_literal281);
                        adaptor.addChild(root_0, char_literal281_tree);
                    }

                    pushFollow(FOLLOW_assignOp_in_daEffect2256);
                    assignOp282 = assignOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, assignOp282.getTree());
                    }

                    pushFollow(FOLLOW_fHead_in_daEffect2258);
                    fHead283 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fHead283.getTree());
                    }

                    pushFollow(FOLLOW_fExpDA_in_daEffect2260);
                    fExpDA284 = fExpDA();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fExpDA284.getTree());
                    }

                    char_literal285 = (Token) match(input, 57, FOLLOW_57_in_daEffect2262);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal285_tree =
                                (Object) adaptor.create(char_literal285);
                        adaptor.addChild(root_0, char_literal285_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daEffect"

    public static class timedEffect_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "timedEffect"
    // Pddl.g:376:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
    public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
        PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal286 = null;
        Token string_literal287 = null;
        Token char_literal290 = null;
        Token char_literal291 = null;
        Token string_literal292 = null;
        Token char_literal295 = null;
        Token char_literal296 = null;
        Token char_literal300 = null;
        PddlParser.timeSpecifier_return timeSpecifier288 = null;

        PddlParser.daEffect_return daEffect289 = null;

        PddlParser.timeSpecifier_return timeSpecifier293 = null;

        PddlParser.fAssignDA_return fAssignDA294 = null;

        PddlParser.assignOp_return assignOp297 = null;

        PddlParser.fHead_return fHead298 = null;

        PddlParser.fExp_return fExp299 = null;


        Object char_literal286_tree = null;
        Object string_literal287_tree = null;
        Object char_literal290_tree = null;
        Object char_literal291_tree = null;
        Object string_literal292_tree = null;
        Object char_literal295_tree = null;
        Object char_literal296_tree = null;
        Object char_literal300_tree = null;

        try {
            // Pddl.g:377:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
            int alt58 = 3;
            int LA58_0 = input.LA(1);

            if ((LA58_0 == 56)) {
                int LA58_1 = input.LA(2);

                if ((synpred91_Pddl())) {
                    alt58 = 1;
                } else if ((synpred92_Pddl())) {
                    alt58 = 2;
                } else if ((true)) {
                    alt58 = 3;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1: // Pddl.g:377:4: '(' 'at' timeSpecifier daEffect ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal286 = (Token) match(input, 56, FOLLOW_56_in_timedEffect2273);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal286_tree =
                                (Object) adaptor.create(char_literal286);
                        adaptor.addChild(root_0, char_literal286_tree);
                    }

                    string_literal287 = (Token) match(input, 92, FOLLOW_92_in_timedEffect2275);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal287_tree =
                                (Object) adaptor.create(string_literal287);
                        adaptor.addChild(root_0, string_literal287_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedEffect2277);
                    timeSpecifier288 = timeSpecifier();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timeSpecifier288.getTree());
                    }

                    pushFollow(FOLLOW_daEffect_in_timedEffect2279);
                    daEffect289 = daEffect();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, daEffect289.getTree());
                    }

                    char_literal290 = (Token) match(input, 57, FOLLOW_57_in_timedEffect2281);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal290_tree =
                                (Object) adaptor.create(char_literal290);
                        adaptor.addChild(root_0, char_literal290_tree);
                    }

                }
                break;
                case 2: // Pddl.g:378:4: '(' 'at' timeSpecifier fAssignDA ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal291 = (Token) match(input, 56, FOLLOW_56_in_timedEffect2291);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal291_tree =
                                (Object) adaptor.create(char_literal291);
                        adaptor.addChild(root_0, char_literal291_tree);
                    }

                    string_literal292 = (Token) match(input, 92, FOLLOW_92_in_timedEffect2293);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal292_tree =
                                (Object) adaptor.create(string_literal292);
                        adaptor.addChild(root_0, string_literal292_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedEffect2295);
                    timeSpecifier293 = timeSpecifier();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, timeSpecifier293.getTree());
                    }

                    pushFollow(FOLLOW_fAssignDA_in_timedEffect2297);
                    fAssignDA294 = fAssignDA();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fAssignDA294.getTree());
                    }

                    char_literal295 = (Token) match(input, 57, FOLLOW_57_in_timedEffect2299);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal295_tree =
                                (Object) adaptor.create(char_literal295);
                        adaptor.addChild(root_0, char_literal295_tree);
                    }

                }
                break;
                case 3: // Pddl.g:379:4: '(' assignOp fHead fExp ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal296 = (Token) match(input, 56, FOLLOW_56_in_timedEffect2304);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal296_tree =
                                (Object) adaptor.create(char_literal296);
                        adaptor.addChild(root_0, char_literal296_tree);
                    }

                    pushFollow(FOLLOW_assignOp_in_timedEffect2306);
                    assignOp297 = assignOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, assignOp297.getTree());
                    }

                    pushFollow(FOLLOW_fHead_in_timedEffect2308);
                    fHead298 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fHead298.getTree());
                    }

                    pushFollow(FOLLOW_fExp_in_timedEffect2310);
                    fExp299 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fExp299.getTree());
                    }

                    char_literal300 = (Token) match(input, 57, FOLLOW_57_in_timedEffect2312);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal300_tree =
                                (Object) adaptor.create(char_literal300);
                        adaptor.addChild(root_0, char_literal300_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timedEffect"

    public static class fAssignDA_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fAssignDA"
    // Pddl.g:382:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
    public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
        PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal301 = null;
        Token char_literal305 = null;
        PddlParser.assignOp_return assignOp302 = null;

        PddlParser.fHead_return fHead303 = null;

        PddlParser.fExpDA_return fExpDA304 = null;


        Object char_literal301_tree = null;
        Object char_literal305_tree = null;

        try {
            // Pddl.g:383:2: ( '(' assignOp fHead fExpDA ')' )
            // Pddl.g:383:4: '(' assignOp fHead fExpDA ')'
            {
                root_0 = (Object) adaptor.nil();


                char_literal301 = (Token) match(input, 56, FOLLOW_56_in_fAssignDA2332);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    char_literal301_tree =
                            (Object) adaptor.create(char_literal301);
                    adaptor.addChild(root_0, char_literal301_tree);
                }

                pushFollow(FOLLOW_assignOp_in_fAssignDA2334);
                assignOp302 = assignOp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, assignOp302.getTree());
                }

                pushFollow(FOLLOW_fHead_in_fAssignDA2336);
                fHead303 = fHead();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, fHead303.getTree());
                }

                pushFollow(FOLLOW_fExpDA_in_fAssignDA2338);
                fExpDA304 = fExpDA();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    adaptor.addChild(root_0, fExpDA304.getTree());
                }

                char_literal305 = (Token) match(input, 57, FOLLOW_57_in_fAssignDA2340);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    char_literal305_tree =
                            (Object) adaptor.create(char_literal305);
                    adaptor.addChild(root_0, char_literal305_tree);
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fAssignDA"

    public static class fExpDA_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "fExpDA"
    // Pddl.g:386:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
    public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
        PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal306 = null;
        Token char_literal310 = null;
        Token char_literal312 = null;
        Token string_literal313 = null;
        PddlParser.binaryOp_return binaryOp307 = null;

        PddlParser.fExpDA_return fExpDA308 = null;

        PddlParser.fExpDA_return fExpDA309 = null;

        PddlParser.fExpDA_return fExpDA311 = null;

        PddlParser.fExp_return fExp314 = null;


        Object char_literal306_tree = null;
        Object char_literal310_tree = null;
        Object char_literal312_tree = null;
        Object string_literal313_tree = null;

        try {
            // Pddl.g:387:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
            int alt60 = 3;
            switch (input.LA(1)) {
                case 56: {
                    int LA60_1 = input.LA(2);

                    if ((synpred94_Pddl())) {
                        alt60 = 1;
                    } else if ((true)) {
                        alt60 = 3;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 60, 1, input);

                        throw nvae;

                    }
                }
                break;
                case 86: {
                    alt60 = 2;
                }
                break;
                case NAME:
                case NUMBER: {
                    alt60 = 3;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                    throw nvae;

            }

            switch (alt60) {
                case 1: // Pddl.g:387:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal306 = (Token) match(input, 56, FOLLOW_56_in_fExpDA2351);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal306_tree =
                                (Object) adaptor.create(char_literal306);
                        adaptor.addChild(root_0, char_literal306_tree);
                    }

                    // Pddl.g:387:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
                    int alt59 = 2;
                    int LA59_0 = input.LA(1);

                    if ((LA59_0 == 60)) {
                        int LA59_1 = input.LA(2);

                        if ((synpred93_Pddl())) {
                            alt59 = 1;
                        } else if ((true)) {
                            alt59 = 2;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return retval;
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 59, 1, input);

                            throw nvae;

                        }
                    } else if (((LA59_0 >= 58 && LA59_0 <= 59) || LA59_0 == 61)) {
                        alt59 = 1;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 59, 0, input);

                        throw nvae;

                    }
                    switch (alt59) {
                        case 1: // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
                        {
                            // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
                            // Pddl.g:387:10: binaryOp fExpDA fExpDA
                            {
                                pushFollow(FOLLOW_binaryOp_in_fExpDA2355);
                                binaryOp307 = binaryOp();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, binaryOp307.getTree());
                                }

                                pushFollow(FOLLOW_fExpDA_in_fExpDA2357);
                                fExpDA308 = fExpDA();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, fExpDA308.getTree());
                                }

                                pushFollow(FOLLOW_fExpDA_in_fExpDA2359);
                                fExpDA309 = fExpDA();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, fExpDA309.getTree());
                                }

                            }


                        }
                        break;
                        case 2: // Pddl.g:387:36: ( '-' fExpDA )
                        {
                            // Pddl.g:387:36: ( '-' fExpDA )
                            // Pddl.g:387:37: '-' fExpDA
                            {
                                char_literal310 = (Token) match(input, 60, FOLLOW_60_in_fExpDA2365);
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    char_literal310_tree =
                                            (Object) adaptor.create(char_literal310);
                                    adaptor.addChild(root_0, char_literal310_tree);
                                }

                                pushFollow(FOLLOW_fExpDA_in_fExpDA2367);
                                fExpDA311 = fExpDA();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, fExpDA311.getTree());
                                }

                            }


                        }
                        break;

                    }


                    char_literal312 = (Token) match(input, 57, FOLLOW_57_in_fExpDA2371);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal312_tree =
                                (Object) adaptor.create(char_literal312);
                        adaptor.addChild(root_0, char_literal312_tree);
                    }

                }
                break;
                case 2: // Pddl.g:388:4: '?duration'
                {
                    root_0 = (Object) adaptor.nil();


                    string_literal313 = (Token) match(input, 86, FOLLOW_86_in_fExpDA2376);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal313_tree =
                                (Object) adaptor.create(string_literal313);
                        adaptor.addChild(root_0, string_literal313_tree);
                    }

                }
                break;
                case 3: // Pddl.g:389:4: fExp
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_fExp_in_fExpDA2381);
                    fExp314 = fExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fExp314.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExpDA"

    public static class problem_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "problem"
    // Pddl.g:394:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
    public final PddlParser.problem_return problem() throws RecognitionException {
        PddlParser.problem_return retval = new PddlParser.problem_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal315 = null;
        Token string_literal316 = null;
        Token char_literal325 = null;
        PddlParser.problemDecl_return problemDecl317 = null;

        PddlParser.problemDomain_return problemDomain318 = null;

        PddlParser.requireDef_return requireDef319 = null;

        PddlParser.objectDecl_return objectDecl320 = null;

        PddlParser.init_return init321 = null;

        PddlParser.goal_return goal322 = null;

        PddlParser.probConstraints_return probConstraints323 = null;

        PddlParser.metricSpec_return metricSpec324 = null;


        Object char_literal315_tree = null;
        Object string_literal316_tree = null;
        Object char_literal325_tree = null;
        RewriteRuleTokenStream stream_95 = new RewriteRuleTokenStream(adaptor, "token 95");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_metricSpec = new RewriteRuleSubtreeStream(adaptor, "rule metricSpec");
        RewriteRuleSubtreeStream stream_objectDecl = new RewriteRuleSubtreeStream(adaptor, "rule objectDecl");
        RewriteRuleSubtreeStream stream_problemDecl = new RewriteRuleSubtreeStream(adaptor, "rule problemDecl");
        RewriteRuleSubtreeStream stream_probConstraints = new RewriteRuleSubtreeStream(adaptor, "rule probConstraints");
        RewriteRuleSubtreeStream stream_requireDef = new RewriteRuleSubtreeStream(adaptor, "rule requireDef");
        RewriteRuleSubtreeStream stream_init = new RewriteRuleSubtreeStream(adaptor, "rule init");
        RewriteRuleSubtreeStream stream_problemDomain = new RewriteRuleSubtreeStream(adaptor, "rule problemDomain");
        RewriteRuleSubtreeStream stream_goal = new RewriteRuleSubtreeStream(adaptor, "rule goal");
        try {
            // Pddl.g:395:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
            // Pddl.g:395:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
            {
                char_literal315 = (Token) match(input, 56, FOLLOW_56_in_problem2395);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal315);
                }


                string_literal316 = (Token) match(input, 95, FOLLOW_95_in_problem2397);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_95.add(string_literal316);
                }


                pushFollow(FOLLOW_problemDecl_in_problem2399);
                problemDecl317 = problemDecl();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_problemDecl.add(problemDecl317.getTree());
                }

                pushFollow(FOLLOW_problemDomain_in_problem2404);
                problemDomain318 = problemDomain();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_problemDomain.add(problemDomain318.getTree());
                }

                // Pddl.g:397:7: ( requireDef )?
                int alt61 = 2;
                int LA61_0 = input.LA(1);

                if ((LA61_0 == 56)) {
                    int LA61_1 = input.LA(2);

                    if ((LA61_1 == 79)) {
                        alt61 = 1;
                    }
                }
                switch (alt61) {
                    case 1: // Pddl.g:397:7: requireDef
                    {
                        pushFollow(FOLLOW_requireDef_in_problem2412);
                        requireDef319 = requireDef();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_requireDef.add(requireDef319.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:398:7: ( objectDecl )?
                int alt62 = 2;
                int LA62_0 = input.LA(1);

                if ((LA62_0 == 56)) {
                    int LA62_1 = input.LA(2);

                    if ((LA62_1 == 75)) {
                        alt62 = 1;
                    }
                }
                switch (alt62) {
                    case 1: // Pddl.g:398:7: objectDecl
                    {
                        pushFollow(FOLLOW_objectDecl_in_problem2421);
                        objectDecl320 = objectDecl();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_objectDecl.add(objectDecl320.getTree());
                        }

                    }
                    break;

                }


                pushFollow(FOLLOW_init_in_problem2430);
                init321 = init();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_init.add(init321.getTree());
                }

                pushFollow(FOLLOW_goal_in_problem2438);
                goal322 = goal();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_goal.add(goal322.getTree());
                }

                // Pddl.g:401:7: ( probConstraints )?
                int alt63 = 2;
                int LA63_0 = input.LA(1);

                if ((LA63_0 == 56)) {
                    int LA63_1 = input.LA(2);

                    if ((LA63_1 == 65)) {
                        alt63 = 1;
                    }
                }
                switch (alt63) {
                    case 1: // Pddl.g:401:7: probConstraints
                    {
                        pushFollow(FOLLOW_probConstraints_in_problem2446);
                        probConstraints323 = probConstraints();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_probConstraints.add(probConstraints323.getTree());
                        }

                    }
                    break;

                }


                // Pddl.g:402:7: ( metricSpec )?
                int alt64 = 2;
                int LA64_0 = input.LA(1);

                if ((LA64_0 == 56)) {
                    alt64 = 1;
                }
                switch (alt64) {
                    case 1: // Pddl.g:402:7: metricSpec
                    {
                        pushFollow(FOLLOW_metricSpec_in_problem2455);
                        metricSpec324 = metricSpec();

                        state._fsp--;
                        if (state.failed) {
                            return retval;
                        }
                        if (state.backtracking == 0) {
                            stream_metricSpec.add(metricSpec324.getTree());
                        }

                    }
                    break;

                }


                char_literal325 = (Token) match(input, 57, FOLLOW_57_in_problem2471);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal325);
                }


                // AST REWRITE
                // elements: probConstraints, metricSpec, problemDecl, objectDecl, init, goal, requireDef, problemDomain
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 405:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
                    {
                        // Pddl.g:405:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PROBLEM, "PROBLEM"), root_1);

                            adaptor.addChild(root_1, stream_problemDecl.nextTree());

                            adaptor.addChild(root_1, stream_problemDomain.nextTree());

                            // Pddl.g:405:46: ( requireDef )?
                            if (stream_requireDef.hasNext()) {
                                adaptor.addChild(root_1, stream_requireDef.nextTree());

                            }
                            stream_requireDef.reset();

                            // Pddl.g:405:58: ( objectDecl )?
                            if (stream_objectDecl.hasNext()) {
                                adaptor.addChild(root_1, stream_objectDecl.nextTree());

                            }
                            stream_objectDecl.reset();

                            adaptor.addChild(root_1, stream_init.nextTree());

                            adaptor.addChild(root_1, stream_goal.nextTree());

                            // Pddl.g:406:19: ( probConstraints )?
                            if (stream_probConstraints.hasNext()) {
                                adaptor.addChild(root_1, stream_probConstraints.nextTree());

                            }
                            stream_probConstraints.reset();

                            // Pddl.g:406:36: ( metricSpec )?
                            if (stream_metricSpec.hasNext()) {
                                adaptor.addChild(root_1, stream_metricSpec.nextTree());

                            }
                            stream_metricSpec.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problem"

    public static class problemDecl_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "problemDecl"
    // Pddl.g:409:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
    public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
        PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal326 = null;
        Token string_literal327 = null;
        Token NAME328 = null;
        Token char_literal329 = null;

        Object char_literal326_tree = null;
        Object string_literal327_tree = null;
        Object NAME328_tree = null;
        Object char_literal329_tree = null;
        RewriteRuleTokenStream stream_NAME = new RewriteRuleTokenStream(adaptor, "token NAME");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_113 = new RewriteRuleTokenStream(adaptor, "token 113");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");

        try {
            // Pddl.g:410:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
            // Pddl.g:410:7: '(' 'problem' NAME ')'
            {
                char_literal326 = (Token) match(input, 56, FOLLOW_56_in_problemDecl2528);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal326);
                }


                string_literal327 = (Token) match(input, 113, FOLLOW_113_in_problemDecl2530);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_113.add(string_literal327);
                }


                NAME328 = (Token) match(input, NAME, FOLLOW_NAME_in_problemDecl2532);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_NAME.add(NAME328);
                }


                char_literal329 = (Token) match(input, 57, FOLLOW_57_in_problemDecl2534);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal329);
                }


                // AST REWRITE
                // elements: NAME
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 411:5: -> ^( PROBLEM_NAME NAME )
                    {
                        // Pddl.g:411:8: ^( PROBLEM_NAME NAME )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PROBLEM_NAME, "PROBLEM_NAME"), root_1);

                            adaptor.addChild(root_1,
                                    stream_NAME.nextNode());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problemDecl"

    public static class problemDomain_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "problemDomain"
    // Pddl.g:414:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
    public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
        PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal330 = null;
        Token string_literal331 = null;
        Token NAME332 = null;
        Token char_literal333 = null;

        Object char_literal330_tree = null;
        Object string_literal331_tree = null;
        Object NAME332_tree = null;
        Object char_literal333_tree = null;
        RewriteRuleTokenStream stream_67 = new RewriteRuleTokenStream(adaptor, "token 67");
        RewriteRuleTokenStream stream_NAME = new RewriteRuleTokenStream(adaptor, "token NAME");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");

        try {
            // Pddl.g:415:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
            // Pddl.g:415:4: '(' ':domain' NAME ')'
            {
                char_literal330 = (Token) match(input, 56, FOLLOW_56_in_problemDomain2560);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal330);
                }


                string_literal331 = (Token) match(input, 67, FOLLOW_67_in_problemDomain2562);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_67.add(string_literal331);
                }


                NAME332 = (Token) match(input, NAME, FOLLOW_NAME_in_problemDomain2564);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_NAME.add(NAME332);
                }


                char_literal333 = (Token) match(input, 57, FOLLOW_57_in_problemDomain2566);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal333);
                }


                // AST REWRITE
                // elements: NAME
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 416:2: -> ^( PROBLEM_DOMAIN NAME )
                    {
                        // Pddl.g:416:5: ^( PROBLEM_DOMAIN NAME )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PROBLEM_DOMAIN, "PROBLEM_DOMAIN"), root_1);

                            adaptor.addChild(root_1,
                                    stream_NAME.nextNode());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problemDomain"

    public static class objectDecl_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "objectDecl"
    // Pddl.g:419:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
    public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
        PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal334 = null;
        Token string_literal335 = null;
        Token char_literal337 = null;
        PddlParser.typedNameList_return typedNameList336 = null;


        Object char_literal334_tree = null;
        Object string_literal335_tree = null;
        Object char_literal337_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_75 = new RewriteRuleTokenStream(adaptor, "token 75");
        RewriteRuleSubtreeStream stream_typedNameList = new RewriteRuleSubtreeStream(adaptor, "rule typedNameList");
        try {
            // Pddl.g:420:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
            // Pddl.g:420:4: '(' ':objects' typedNameList ')'
            {
                char_literal334 = (Token) match(input, 56, FOLLOW_56_in_objectDecl2586);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal334);
                }


                string_literal335 = (Token) match(input, 75, FOLLOW_75_in_objectDecl2588);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_75.add(string_literal335);
                }


                pushFollow(FOLLOW_typedNameList_in_objectDecl2590);
                typedNameList336 = typedNameList();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_typedNameList.add(typedNameList336.getTree());
                }

                char_literal337 = (Token) match(input, 57, FOLLOW_57_in_objectDecl2592);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal337);
                }


                // AST REWRITE
                // elements: typedNameList
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 421:2: -> ^( OBJECTS typedNameList )
                    {
                        // Pddl.g:421:5: ^( OBJECTS typedNameList )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(OBJECTS, "OBJECTS"), root_1);

                            adaptor.addChild(root_1, stream_typedNameList.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objectDecl"

    public static class init_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "init"
    // Pddl.g:424:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
    public final PddlParser.init_return init() throws RecognitionException {
        PddlParser.init_return retval = new PddlParser.init_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal338 = null;
        Token string_literal339 = null;
        Token char_literal341 = null;
        PddlParser.initEl_return initEl340 = null;


        Object char_literal338_tree = null;
        Object string_literal339_tree = null;
        Object char_literal341_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_73 = new RewriteRuleTokenStream(adaptor, "token 73");
        RewriteRuleSubtreeStream stream_initEl = new RewriteRuleSubtreeStream(adaptor, "rule initEl");
        try {
            // Pddl.g:425:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
            // Pddl.g:425:4: '(' ':init' ( initEl )* ')'
            {
                char_literal338 = (Token) match(input, 56, FOLLOW_56_in_init2612);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal338);
                }


                string_literal339 = (Token) match(input, 73, FOLLOW_73_in_init2614);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_73.add(string_literal339);
                }


                // Pddl.g:425:16: ( initEl )*
                loop65:
                do {
                    int alt65 = 2;
                    int LA65_0 = input.LA(1);

                    if ((LA65_0 == 56)) {
                        alt65 = 1;
                    }


                    switch (alt65) {
                        case 1: // Pddl.g:425:16: initEl
                        {
                            pushFollow(FOLLOW_initEl_in_init2616);
                            initEl340 = initEl();

                            state._fsp--;
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_initEl.add(initEl340.getTree());
                            }

                        }
                        break;

                        default:
                            break loop65;
                    }
                } while (true);


                char_literal341 = (Token) match(input, 57, FOLLOW_57_in_init2619);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal341);
                }


                // AST REWRITE
                // elements: initEl
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 426:2: -> ^( INIT ( initEl )* )
                    {
                        // Pddl.g:426:5: ^( INIT ( initEl )* )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(INIT, "INIT"), root_1);

                            // Pddl.g:426:12: ( initEl )*
                            while (stream_initEl.hasNext()) {
                                adaptor.addChild(root_1, stream_initEl.nextTree());

                            }
                            stream_initEl.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "init"

    public static class initEl_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "initEl"
    // Pddl.g:429:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
    public final PddlParser.initEl_return initEl() throws RecognitionException {
        PddlParser.initEl_return retval = new PddlParser.initEl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal343 = null;
        Token char_literal344 = null;
        Token NUMBER346 = null;
        Token char_literal347 = null;
        Token char_literal348 = null;
        Token string_literal349 = null;
        Token NUMBER350 = null;
        Token char_literal352 = null;
        PddlParser.nameLiteral_return nameLiteral342 = null;

        PddlParser.fHead_return fHead345 = null;

        PddlParser.nameLiteral_return nameLiteral351 = null;


        Object char_literal343_tree = null;
        Object char_literal344_tree = null;
        Object NUMBER346_tree = null;
        Object char_literal347_tree = null;
        Object char_literal348_tree = null;
        Object string_literal349_tree = null;
        Object NUMBER350_tree = null;
        Object char_literal352_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_92 = new RewriteRuleTokenStream(adaptor, "token 92");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_83 = new RewriteRuleTokenStream(adaptor, "token 83");
        RewriteRuleTokenStream stream_NUMBER = new RewriteRuleTokenStream(adaptor, "token NUMBER");
        RewriteRuleSubtreeStream stream_fHead = new RewriteRuleSubtreeStream(adaptor, "rule fHead");
        RewriteRuleSubtreeStream stream_nameLiteral = new RewriteRuleSubtreeStream(adaptor, "rule nameLiteral");
        try {
            // Pddl.g:430:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
            int alt66 = 3;
            int LA66_0 = input.LA(1);

            if ((LA66_0 == 56)) {
                switch (input.LA(2)) {
                    case NAME:
                    case 108: {
                        alt66 = 1;
                    }
                    break;
                    case 83: {
                        alt66 = 2;
                    }
                    break;
                    case 92: {
                        alt66 = 3;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 66, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1: // Pddl.g:430:4: nameLiteral
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_nameLiteral_in_initEl2640);
                    nameLiteral342 = nameLiteral();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, nameLiteral342.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:431:4: '(' '=' fHead NUMBER ')'
                {
                    char_literal343 = (Token) match(input, 56, FOLLOW_56_in_initEl2645);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal343);
                    }


                    char_literal344 = (Token) match(input, 83, FOLLOW_83_in_initEl2647);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_83.add(char_literal344);
                    }


                    pushFollow(FOLLOW_fHead_in_initEl2649);
                    fHead345 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_fHead.add(fHead345.getTree());
                    }

                    NUMBER346 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_initEl2651);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NUMBER.add(NUMBER346);
                    }


                    char_literal347 = (Token) match(input, 57, FOLLOW_57_in_initEl2653);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal347);
                    }


                    // AST REWRITE
                    // elements: fHead, NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 431:37: -> ^( INIT_EQ fHead NUMBER )
                        {
                            // Pddl.g:431:40: ^( INIT_EQ fHead NUMBER )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(INIT_EQ, "INIT_EQ"), root_1);

                                adaptor.addChild(root_1, stream_fHead.nextTree());

                                adaptor.addChild(root_1,
                                        stream_NUMBER.nextNode());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:432:4: '(' 'at' NUMBER nameLiteral ')'
                {
                    char_literal348 = (Token) match(input, 56, FOLLOW_56_in_initEl2676);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal348);
                    }


                    string_literal349 = (Token) match(input, 92, FOLLOW_92_in_initEl2678);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_92.add(string_literal349);
                    }


                    NUMBER350 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_initEl2680);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_NUMBER.add(NUMBER350);
                    }


                    pushFollow(FOLLOW_nameLiteral_in_initEl2682);
                    nameLiteral351 = nameLiteral();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_nameLiteral.add(nameLiteral351.getTree());
                    }

                    char_literal352 = (Token) match(input, 57, FOLLOW_57_in_initEl2684);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal352);
                    }


                    // AST REWRITE
                    // elements: NUMBER, nameLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 432:37: -> ^( INIT_AT NUMBER nameLiteral )
                        {
                            // Pddl.g:432:40: ^( INIT_AT NUMBER nameLiteral )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(INIT_AT, "INIT_AT"), root_1);

                                adaptor.addChild(root_1,
                                        stream_NUMBER.nextNode());

                                adaptor.addChild(root_1, stream_nameLiteral.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initEl"

    public static class nameLiteral_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "nameLiteral"
    // Pddl.g:435:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
    public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
        PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal354 = null;
        Token string_literal355 = null;
        Token char_literal357 = null;
        PddlParser.atomicNameFormula_return atomicNameFormula353 = null;

        PddlParser.atomicNameFormula_return atomicNameFormula356 = null;


        Object char_literal354_tree = null;
        Object string_literal355_tree = null;
        Object char_literal357_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_108 = new RewriteRuleTokenStream(adaptor, "token 108");
        RewriteRuleSubtreeStream stream_atomicNameFormula = new RewriteRuleSubtreeStream(adaptor, "rule atomicNameFormula");
        try {
            // Pddl.g:436:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
            int alt67 = 2;
            int LA67_0 = input.LA(1);

            if ((LA67_0 == 56)) {
                int LA67_1 = input.LA(2);

                if ((LA67_1 == 108)) {
                    alt67 = 2;
                } else if ((LA67_1 == NAME)) {
                    alt67 = 1;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 67, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1: // Pddl.g:436:4: atomicNameFormula
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2706);
                    atomicNameFormula353 = atomicNameFormula();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, atomicNameFormula353.getTree());
                    }

                }
                break;
                case 2: // Pddl.g:437:4: '(' 'not' atomicNameFormula ')'
                {
                    char_literal354 = (Token) match(input, 56, FOLLOW_56_in_nameLiteral2711);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal354);
                    }


                    string_literal355 = (Token) match(input, 108, FOLLOW_108_in_nameLiteral2713);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_108.add(string_literal355);
                    }


                    pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2715);
                    atomicNameFormula356 = atomicNameFormula();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_atomicNameFormula.add(atomicNameFormula356.getTree());
                    }

                    char_literal357 = (Token) match(input, 57, FOLLOW_57_in_nameLiteral2717);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal357);
                    }


                    // AST REWRITE
                    // elements: atomicNameFormula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 437:36: -> ^( NOT_PRED_INIT atomicNameFormula )
                        {
                            // Pddl.g:437:39: ^( NOT_PRED_INIT atomicNameFormula )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(NOT_PRED_INIT, "NOT_PRED_INIT"), root_1);

                                adaptor.addChild(root_1, stream_atomicNameFormula.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nameLiteral"

    public static class atomicNameFormula_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "atomicNameFormula"
    // Pddl.g:440:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
    public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
        PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal358 = null;
        Token NAME360 = null;
        Token char_literal361 = null;
        PddlParser.predicate_return predicate359 = null;


        Object char_literal358_tree = null;
        Object NAME360_tree = null;
        Object char_literal361_tree = null;
        RewriteRuleTokenStream stream_NAME = new RewriteRuleTokenStream(adaptor, "token NAME");
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleSubtreeStream stream_predicate = new RewriteRuleSubtreeStream(adaptor, "rule predicate");
        try {
            // Pddl.g:441:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
            // Pddl.g:441:4: '(' predicate ( NAME )* ')'
            {
                char_literal358 = (Token) match(input, 56, FOLLOW_56_in_atomicNameFormula2736);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal358);
                }


                pushFollow(FOLLOW_predicate_in_atomicNameFormula2738);
                predicate359 = predicate();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_predicate.add(predicate359.getTree());
                }

                // Pddl.g:441:18: ( NAME )*
                loop68:
                do {
                    int alt68 = 2;
                    int LA68_0 = input.LA(1);

                    if ((LA68_0 == NAME)) {
                        alt68 = 1;
                    }


                    switch (alt68) {
                        case 1: // Pddl.g:441:18: NAME
                        {
                            NAME360 = (Token) match(input, NAME, FOLLOW_NAME_in_atomicNameFormula2740);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                stream_NAME.add(NAME360);
                            }


                        }
                        break;

                        default:
                            break loop68;
                    }
                } while (true);


                char_literal361 = (Token) match(input, 57, FOLLOW_57_in_atomicNameFormula2743);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal361);
                }


                // AST REWRITE
                // elements: predicate, NAME
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 441:28: -> ^( PRED_INST predicate ( NAME )* )
                    {
                        // Pddl.g:441:31: ^( PRED_INST predicate ( NAME )* )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PRED_INST, "PRED_INST"), root_1);

                            adaptor.addChild(root_1, stream_predicate.nextTree());

                            // Pddl.g:441:53: ( NAME )*
                            while (stream_NAME.hasNext()) {
                                adaptor.addChild(root_1,
                                        stream_NAME.nextNode());

                            }
                            stream_NAME.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicNameFormula"

    public static class goal_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "goal"
    // Pddl.g:448:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
    public final PddlParser.goal_return goal() throws RecognitionException {
        PddlParser.goal_return retval = new PddlParser.goal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal362 = null;
        Token string_literal363 = null;
        Token char_literal365 = null;
        PddlParser.goalDesc_return goalDesc364 = null;


        Object char_literal362_tree = null;
        Object string_literal363_tree = null;
        Object char_literal365_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_72 = new RewriteRuleTokenStream(adaptor, "token 72");
        RewriteRuleSubtreeStream stream_goalDesc = new RewriteRuleSubtreeStream(adaptor, "rule goalDesc");
        try {
            // Pddl.g:448:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
            // Pddl.g:448:8: '(' ':goal' goalDesc ')'
            {
                char_literal362 = (Token) match(input, 56, FOLLOW_56_in_goal2768);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal362);
                }


                string_literal363 = (Token) match(input, 72, FOLLOW_72_in_goal2770);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_72.add(string_literal363);
                }


                pushFollow(FOLLOW_goalDesc_in_goal2772);
                goalDesc364 = goalDesc();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_goalDesc.add(goalDesc364.getTree());
                }

                char_literal365 = (Token) match(input, 57, FOLLOW_57_in_goal2774);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal365);
                }


                // AST REWRITE
                // elements: goalDesc
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 448:33: -> ^( GOAL goalDesc )
                    {
                        // Pddl.g:448:36: ^( GOAL goalDesc )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(GOAL, "GOAL"), root_1);

                            adaptor.addChild(root_1, stream_goalDesc.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "goal"

    public static class probConstraints_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "probConstraints"
    // Pddl.g:450:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
    public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
        PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal366 = null;
        Token string_literal367 = null;
        Token char_literal369 = null;
        PddlParser.prefConGD_return prefConGD368 = null;


        Object char_literal366_tree = null;
        Object string_literal367_tree = null;
        Object char_literal369_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_65 = new RewriteRuleTokenStream(adaptor, "token 65");
        RewriteRuleSubtreeStream stream_prefConGD = new RewriteRuleSubtreeStream(adaptor, "rule prefConGD");
        try {
            // Pddl.g:451:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
            // Pddl.g:451:4: '(' ':constraints' prefConGD ')'
            {
                char_literal366 = (Token) match(input, 56, FOLLOW_56_in_probConstraints2792);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal366);
                }


                string_literal367 = (Token) match(input, 65, FOLLOW_65_in_probConstraints2794);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_65.add(string_literal367);
                }


                pushFollow(FOLLOW_prefConGD_in_probConstraints2797);
                prefConGD368 = prefConGD();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_prefConGD.add(prefConGD368.getTree());
                }

                char_literal369 = (Token) match(input, 57, FOLLOW_57_in_probConstraints2799);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal369);
                }


                // AST REWRITE
                // elements: prefConGD
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 452:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
                    {
                        // Pddl.g:452:7: ^( PROBLEM_CONSTRAINT prefConGD )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PROBLEM_CONSTRAINT, "PROBLEM_CONSTRAINT"), root_1);

                            adaptor.addChild(root_1, stream_prefConGD.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "probConstraints"

    public static class prefConGD_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "prefConGD"
    // Pddl.g:455:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
    public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
        PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal370 = null;
        Token string_literal371 = null;
        Token char_literal373 = null;
        Token char_literal374 = null;
        Token string_literal375 = null;
        Token char_literal376 = null;
        Token char_literal378 = null;
        Token char_literal380 = null;
        Token char_literal381 = null;
        Token string_literal382 = null;
        Token NAME383 = null;
        Token char_literal385 = null;
        PddlParser.prefConGD_return prefConGD372 = null;

        PddlParser.typedVariableList_return typedVariableList377 = null;

        PddlParser.prefConGD_return prefConGD379 = null;

        PddlParser.conGD_return conGD384 = null;

        PddlParser.conGD_return conGD386 = null;


        Object char_literal370_tree = null;
        Object string_literal371_tree = null;
        Object char_literal373_tree = null;
        Object char_literal374_tree = null;
        Object string_literal375_tree = null;
        Object char_literal376_tree = null;
        Object char_literal378_tree = null;
        Object char_literal380_tree = null;
        Object char_literal381_tree = null;
        Object string_literal382_tree = null;
        Object NAME383_tree = null;
        Object char_literal385_tree = null;

        try {
            // Pddl.g:456:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
            int alt71 = 4;
            int LA71_0 = input.LA(1);

            if ((LA71_0 == 56)) {
                int LA71_1 = input.LA(2);

                if ((synpred106_Pddl())) {
                    alt71 = 1;
                } else if ((synpred107_Pddl())) {
                    alt71 = 2;
                } else if ((synpred109_Pddl())) {
                    alt71 = 3;
                } else if ((true)) {
                    alt71 = 4;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 71, 1, input);

                    throw nvae;

                }
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1: // Pddl.g:456:4: '(' 'and' ( prefConGD )* ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal370 = (Token) match(input, 56, FOLLOW_56_in_prefConGD2821);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal370_tree =
                                (Object) adaptor.create(char_literal370);
                        adaptor.addChild(root_0, char_literal370_tree);
                    }

                    string_literal371 = (Token) match(input, 90, FOLLOW_90_in_prefConGD2823);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal371_tree =
                                (Object) adaptor.create(string_literal371);
                        adaptor.addChild(root_0, string_literal371_tree);
                    }

                    // Pddl.g:456:14: ( prefConGD )*
                    loop69:
                    do {
                        int alt69 = 2;
                        int LA69_0 = input.LA(1);

                        if ((LA69_0 == 56)) {
                            alt69 = 1;
                        }


                        switch (alt69) {
                            case 1: // Pddl.g:456:14: prefConGD
                            {
                                pushFollow(FOLLOW_prefConGD_in_prefConGD2825);
                                prefConGD372 = prefConGD();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, prefConGD372.getTree());
                                }

                            }
                            break;

                            default:
                                break loop69;
                        }
                    } while (true);


                    char_literal373 = (Token) match(input, 57, FOLLOW_57_in_prefConGD2828);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal373_tree =
                                (Object) adaptor.create(char_literal373);
                        adaptor.addChild(root_0, char_literal373_tree);
                    }

                }
                break;
                case 2: // Pddl.g:457:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal374 = (Token) match(input, 56, FOLLOW_56_in_prefConGD2833);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal374_tree =
                                (Object) adaptor.create(char_literal374);
                        adaptor.addChild(root_0, char_literal374_tree);
                    }

                    string_literal375 = (Token) match(input, 100, FOLLOW_100_in_prefConGD2835);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal375_tree =
                                (Object) adaptor.create(string_literal375);
                        adaptor.addChild(root_0, string_literal375_tree);
                    }

                    char_literal376 = (Token) match(input, 56, FOLLOW_56_in_prefConGD2837);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal376_tree =
                                (Object) adaptor.create(char_literal376);
                        adaptor.addChild(root_0, char_literal376_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_prefConGD2839);
                    typedVariableList377 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, typedVariableList377.getTree());
                    }

                    char_literal378 = (Token) match(input, 57, FOLLOW_57_in_prefConGD2841);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal378_tree =
                                (Object) adaptor.create(char_literal378);
                        adaptor.addChild(root_0, char_literal378_tree);
                    }

                    pushFollow(FOLLOW_prefConGD_in_prefConGD2843);
                    prefConGD379 = prefConGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, prefConGD379.getTree());
                    }

                    char_literal380 = (Token) match(input, 57, FOLLOW_57_in_prefConGD2845);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal380_tree =
                                (Object) adaptor.create(char_literal380);
                        adaptor.addChild(root_0, char_literal380_tree);
                    }

                }
                break;
                case 3: // Pddl.g:458:4: '(' 'preference' ( NAME )? conGD ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal381 = (Token) match(input, 56, FOLLOW_56_in_prefConGD2850);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal381_tree =
                                (Object) adaptor.create(char_literal381);
                        adaptor.addChild(root_0, char_literal381_tree);
                    }

                    string_literal382 = (Token) match(input, 112, FOLLOW_112_in_prefConGD2852);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal382_tree =
                                (Object) adaptor.create(string_literal382);
                        adaptor.addChild(root_0, string_literal382_tree);
                    }

                    // Pddl.g:458:21: ( NAME )?
                    int alt70 = 2;
                    int LA70_0 = input.LA(1);

                    if ((LA70_0 == NAME)) {
                        alt70 = 1;
                    }
                    switch (alt70) {
                        case 1: // Pddl.g:458:21: NAME
                        {
                            NAME383 = (Token) match(input, NAME, FOLLOW_NAME_in_prefConGD2854);
                            if (state.failed) {
                                return retval;
                            }
                            if (state.backtracking == 0) {
                                NAME383_tree =
                                        (Object) adaptor.create(NAME383);
                                adaptor.addChild(root_0, NAME383_tree);
                            }

                        }
                        break;

                    }


                    pushFollow(FOLLOW_conGD_in_prefConGD2857);
                    conGD384 = conGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, conGD384.getTree());
                    }

                    char_literal385 = (Token) match(input, 57, FOLLOW_57_in_prefConGD2859);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal385_tree =
                                (Object) adaptor.create(char_literal385);
                        adaptor.addChild(root_0, char_literal385_tree);
                    }

                }
                break;
                case 4: // Pddl.g:459:4: conGD
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_conGD_in_prefConGD2864);
                    conGD386 = conGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, conGD386.getTree());
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prefConGD"

    public static class metricSpec_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "metricSpec"
    // Pddl.g:462:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
    public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
        PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal387 = null;
        Token string_literal388 = null;
        Token char_literal391 = null;
        PddlParser.optimization_return optimization389 = null;

        PddlParser.metricFExp_return metricFExp390 = null;


        Object char_literal387_tree = null;
        Object string_literal388_tree = null;
        Object char_literal391_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_74 = new RewriteRuleTokenStream(adaptor, "token 74");
        RewriteRuleSubtreeStream stream_optimization = new RewriteRuleSubtreeStream(adaptor, "rule optimization");
        RewriteRuleSubtreeStream stream_metricFExp = new RewriteRuleSubtreeStream(adaptor, "rule metricFExp");
        try {
            // Pddl.g:463:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
            // Pddl.g:463:4: '(' ':metric' optimization metricFExp ')'
            {
                char_literal387 = (Token) match(input, 56, FOLLOW_56_in_metricSpec2875);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_56.add(char_literal387);
                }


                string_literal388 = (Token) match(input, 74, FOLLOW_74_in_metricSpec2877);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_74.add(string_literal388);
                }


                pushFollow(FOLLOW_optimization_in_metricSpec2879);
                optimization389 = optimization();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_optimization.add(optimization389.getTree());
                }

                pushFollow(FOLLOW_metricFExp_in_metricSpec2881);
                metricFExp390 = metricFExp();

                state._fsp--;
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_metricFExp.add(metricFExp390.getTree());
                }

                char_literal391 = (Token) match(input, 57, FOLLOW_57_in_metricSpec2883);
                if (state.failed) {
                    return retval;
                }
                if (state.backtracking == 0) {
                    stream_57.add(char_literal391);
                }


                // AST REWRITE
                // elements: metricFExp, optimization
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                if (state.backtracking == 0) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                    root_0 = (Object) adaptor.nil();
                    // 464:4: -> ^( PROBLEM_METRIC optimization metricFExp )
                    {
                        // Pddl.g:464:7: ^( PROBLEM_METRIC optimization metricFExp )
                        {
                            Object root_1 = (Object) adaptor.nil();
                            root_1 = (Object) adaptor.becomeRoot(
                                    (Object) adaptor.create(PROBLEM_METRIC, "PROBLEM_METRIC"), root_1);

                            adaptor.addChild(root_1, stream_optimization.nextTree());

                            adaptor.addChild(root_1, stream_metricFExp.nextTree());

                            adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                }

            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metricSpec"

    public static class optimization_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "optimization"
    // Pddl.g:467:1: optimization : ( 'minimize' | 'maximize' );
    public final PddlParser.optimization_return optimization() throws RecognitionException {
        PddlParser.optimization_return retval = new PddlParser.optimization_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set392 = null;

        Object set392_tree = null;

        try {
            // Pddl.g:467:14: ( 'minimize' | 'maximize' )
            // Pddl.g:
            {
                root_0 = (Object) adaptor.nil();


                set392 = (Token) input.LT(1);

                if ((input.LA(1) >= 106 && input.LA(1) <= 107)) {
                    input.consume();
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0,
                                (Object) adaptor.create(set392));
                    }
                    state.errorRecovery = false;
                    state.failed = false;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }


            }

            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optimization"

    public static class metricFExp_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "metricFExp"
    // Pddl.g:469:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
    public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
        PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal393 = null;
        Token char_literal397 = null;
        Token char_literal398 = null;
        Token char_literal402 = null;
        Token char_literal403 = null;
        Token char_literal404 = null;
        Token char_literal406 = null;
        Token NUMBER407 = null;
        Token char_literal409 = null;
        Token string_literal410 = null;
        Token NAME411 = null;
        Token char_literal412 = null;
        PddlParser.binaryOp_return binaryOp394 = null;

        PddlParser.metricFExp_return metricFExp395 = null;

        PddlParser.metricFExp_return metricFExp396 = null;

        PddlParser.multiOp_return multiOp399 = null;

        PddlParser.metricFExp_return metricFExp400 = null;

        PddlParser.metricFExp_return metricFExp401 = null;

        PddlParser.metricFExp_return metricFExp405 = null;

        PddlParser.fHead_return fHead408 = null;


        Object char_literal393_tree = null;
        Object char_literal397_tree = null;
        Object char_literal398_tree = null;
        Object char_literal402_tree = null;
        Object char_literal403_tree = null;
        Object char_literal404_tree = null;
        Object char_literal406_tree = null;
        Object NUMBER407_tree = null;
        Object char_literal409_tree = null;
        Object string_literal410_tree = null;
        Object NAME411_tree = null;
        Object char_literal412_tree = null;
        RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
        RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
        RewriteRuleTokenStream stream_60 = new RewriteRuleTokenStream(adaptor, "token 60");
        RewriteRuleSubtreeStream stream_multiOp = new RewriteRuleSubtreeStream(adaptor, "rule multiOp");
        RewriteRuleSubtreeStream stream_metricFExp = new RewriteRuleSubtreeStream(adaptor, "rule metricFExp");
        RewriteRuleSubtreeStream stream_binaryOp = new RewriteRuleSubtreeStream(adaptor, "rule binaryOp");
        try {
            // Pddl.g:470:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
            int alt73 = 6;
            switch (input.LA(1)) {
                case 56: {
                    int LA73_1 = input.LA(2);

                    if ((synpred111_Pddl())) {
                        alt73 = 1;
                    } else if ((synpred113_Pddl())) {
                        alt73 = 2;
                    } else if ((synpred114_Pddl())) {
                        alt73 = 3;
                    } else if ((synpred116_Pddl())) {
                        alt73 = 5;
                    } else if ((true)) {
                        alt73 = 6;
                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 73, 1, input);

                        throw nvae;

                    }
                }
                break;
                case NUMBER: {
                    alt73 = 4;
                }
                break;
                case NAME: {
                    alt73 = 5;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 73, 0, input);

                    throw nvae;

            }

            switch (alt73) {
                case 1: // Pddl.g:470:4: '(' binaryOp metricFExp metricFExp ')'
                {
                    char_literal393 = (Token) match(input, 56, FOLLOW_56_in_metricFExp2920);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal393);
                    }


                    pushFollow(FOLLOW_binaryOp_in_metricFExp2922);
                    binaryOp394 = binaryOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_binaryOp.add(binaryOp394.getTree());
                    }

                    pushFollow(FOLLOW_metricFExp_in_metricFExp2924);
                    metricFExp395 = metricFExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_metricFExp.add(metricFExp395.getTree());
                    }

                    pushFollow(FOLLOW_metricFExp_in_metricFExp2926);
                    metricFExp396 = metricFExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_metricFExp.add(metricFExp396.getTree());
                    }

                    char_literal397 = (Token) match(input, 57, FOLLOW_57_in_metricFExp2928);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal397);
                    }


                    // AST REWRITE
                    // elements: binaryOp, metricFExp, metricFExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 471:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
                        {
                            // Pddl.g:471:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(BINARY_OP, "BINARY_OP"), root_1);

                                adaptor.addChild(root_1, stream_binaryOp.nextTree());

                                adaptor.addChild(root_1, stream_metricFExp.nextTree());

                                adaptor.addChild(root_1, stream_metricFExp.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 2: // Pddl.g:472:4: '(' multiOp metricFExp ( metricFExp )+ ')'
                {
                    char_literal398 = (Token) match(input, 56, FOLLOW_56_in_metricFExp2950);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal398);
                    }


                    pushFollow(FOLLOW_multiOp_in_metricFExp2952);
                    multiOp399 = multiOp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_multiOp.add(multiOp399.getTree());
                    }

                    pushFollow(FOLLOW_metricFExp_in_metricFExp2954);
                    metricFExp400 = metricFExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_metricFExp.add(metricFExp400.getTree());
                    }

                    // Pddl.g:472:27: ( metricFExp )+
                    int cnt72 = 0;
                    loop72:
                    do {
                        int alt72 = 2;
                        int LA72_0 = input.LA(1);

                        if ((LA72_0 == NAME || LA72_0 == NUMBER || LA72_0 == 56)) {
                            alt72 = 1;
                        }


                        switch (alt72) {
                            case 1: // Pddl.g:472:27: metricFExp
                            {
                                pushFollow(FOLLOW_metricFExp_in_metricFExp2956);
                                metricFExp401 = metricFExp();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    stream_metricFExp.add(metricFExp401.getTree());
                                }

                            }
                            break;

                            default:
                                if (cnt72 >= 1) {
                                    break loop72;
                                }
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return retval;
                                }
                                EarlyExitException eee =
                                        new EarlyExitException(72, input);
                                throw eee;
                        }
                        cnt72++;
                    } while (true);


                    char_literal402 = (Token) match(input, 57, FOLLOW_57_in_metricFExp2959);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal402);
                    }


                    // AST REWRITE
                    // elements: metricFExp, metricFExp, multiOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 473:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
                        {
                            // Pddl.g:473:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(MULTI_OP, "MULTI_OP"), root_1);

                                adaptor.addChild(root_1, stream_multiOp.nextTree());

                                adaptor.addChild(root_1, stream_metricFExp.nextTree());

                                if (!(stream_metricFExp.hasNext())) {
                                    throw new RewriteEarlyExitException();
                                }
                                while (stream_metricFExp.hasNext()) {
                                    adaptor.addChild(root_1, stream_metricFExp.nextTree());

                                }
                                stream_metricFExp.reset();

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 3: // Pddl.g:474:4: '(' '-' metricFExp ')'
                {
                    char_literal403 = (Token) match(input, 56, FOLLOW_56_in_metricFExp2983);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_56.add(char_literal403);
                    }


                    char_literal404 = (Token) match(input, 60, FOLLOW_60_in_metricFExp2985);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_60.add(char_literal404);
                    }


                    pushFollow(FOLLOW_metricFExp_in_metricFExp2987);
                    metricFExp405 = metricFExp();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_metricFExp.add(metricFExp405.getTree());
                    }

                    char_literal406 = (Token) match(input, 57, FOLLOW_57_in_metricFExp2989);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        stream_57.add(char_literal406);
                    }


                    // AST REWRITE
                    // elements: metricFExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if (state.backtracking == 0) {

                        retval.tree = root_0;
                        RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval", retval != null ? retval.tree : null);

                        root_0 = (Object) adaptor.nil();
                        // 475:4: -> ^( MINUS_OP metricFExp )
                        {
                            // Pddl.g:475:7: ^( MINUS_OP metricFExp )
                            {
                                Object root_1 = (Object) adaptor.nil();
                                root_1 = (Object) adaptor.becomeRoot(
                                        (Object) adaptor.create(MINUS_OP, "MINUS_OP"), root_1);

                                adaptor.addChild(root_1, stream_metricFExp.nextTree());

                                adaptor.addChild(root_0, root_1);
                            }

                        }


                        retval.tree = root_0;
                    }

                }
                break;
                case 4: // Pddl.g:476:4: NUMBER
                {
                    root_0 = (Object) adaptor.nil();


                    NUMBER407 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_metricFExp3006);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER407_tree =
                                (Object) adaptor.create(NUMBER407);
                        adaptor.addChild(root_0, NUMBER407_tree);
                    }

                }
                break;
                case 5: // Pddl.g:477:4: fHead
                {
                    root_0 = (Object) adaptor.nil();


                    pushFollow(FOLLOW_fHead_in_metricFExp3011);
                    fHead408 = fHead();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, fHead408.getTree());
                    }

                }
                break;
                case 6: // Pddl.g:479:4: '(' 'is-violated' NAME ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal409 = (Token) match(input, 56, FOLLOW_56_in_metricFExp3026);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal409_tree =
                                (Object) adaptor.create(char_literal409);
                        adaptor.addChild(root_0, char_literal409_tree);
                    }

                    string_literal410 = (Token) match(input, 105, FOLLOW_105_in_metricFExp3028);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal410_tree =
                                (Object) adaptor.create(string_literal410);
                        adaptor.addChild(root_0, string_literal410_tree);
                    }

                    NAME411 = (Token) match(input, NAME, FOLLOW_NAME_in_metricFExp3030);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NAME411_tree =
                                (Object) adaptor.create(NAME411);
                        adaptor.addChild(root_0, NAME411_tree);
                    }

                    char_literal412 = (Token) match(input, 57, FOLLOW_57_in_metricFExp3032);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal412_tree =
                                (Object) adaptor.create(char_literal412);
                        adaptor.addChild(root_0, char_literal412_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metricFExp"

    public static class conGD_return extends ParserRuleReturnScope {

        Object tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "conGD"
    // Pddl.g:484:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
    public final PddlParser.conGD_return conGD() throws RecognitionException {
        PddlParser.conGD_return retval = new PddlParser.conGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal413 = null;
        Token string_literal414 = null;
        Token char_literal416 = null;
        Token char_literal417 = null;
        Token string_literal418 = null;
        Token char_literal419 = null;
        Token char_literal421 = null;
        Token char_literal423 = null;
        Token char_literal424 = null;
        Token string_literal425 = null;
        Token string_literal426 = null;
        Token char_literal428 = null;
        Token char_literal429 = null;
        Token string_literal430 = null;
        Token char_literal432 = null;
        Token char_literal433 = null;
        Token string_literal434 = null;
        Token char_literal436 = null;
        Token char_literal437 = null;
        Token string_literal438 = null;
        Token NUMBER439 = null;
        Token char_literal441 = null;
        Token char_literal442 = null;
        Token string_literal443 = null;
        Token char_literal445 = null;
        Token char_literal446 = null;
        Token string_literal447 = null;
        Token char_literal450 = null;
        Token char_literal451 = null;
        Token string_literal452 = null;
        Token char_literal455 = null;
        Token char_literal456 = null;
        Token string_literal457 = null;
        Token NUMBER458 = null;
        Token char_literal461 = null;
        Token char_literal462 = null;
        Token string_literal463 = null;
        Token NUMBER464 = null;
        Token NUMBER465 = null;
        Token char_literal467 = null;
        Token char_literal468 = null;
        Token string_literal469 = null;
        Token NUMBER470 = null;
        Token char_literal472 = null;
        PddlParser.conGD_return conGD415 = null;

        PddlParser.typedVariableList_return typedVariableList420 = null;

        PddlParser.conGD_return conGD422 = null;

        PddlParser.goalDesc_return goalDesc427 = null;

        PddlParser.goalDesc_return goalDesc431 = null;

        PddlParser.goalDesc_return goalDesc435 = null;

        PddlParser.goalDesc_return goalDesc440 = null;

        PddlParser.goalDesc_return goalDesc444 = null;

        PddlParser.goalDesc_return goalDesc448 = null;

        PddlParser.goalDesc_return goalDesc449 = null;

        PddlParser.goalDesc_return goalDesc453 = null;

        PddlParser.goalDesc_return goalDesc454 = null;

        PddlParser.goalDesc_return goalDesc459 = null;

        PddlParser.goalDesc_return goalDesc460 = null;

        PddlParser.goalDesc_return goalDesc466 = null;

        PddlParser.goalDesc_return goalDesc471 = null;


        Object char_literal413_tree = null;
        Object string_literal414_tree = null;
        Object char_literal416_tree = null;
        Object char_literal417_tree = null;
        Object string_literal418_tree = null;
        Object char_literal419_tree = null;
        Object char_literal421_tree = null;
        Object char_literal423_tree = null;
        Object char_literal424_tree = null;
        Object string_literal425_tree = null;
        Object string_literal426_tree = null;
        Object char_literal428_tree = null;
        Object char_literal429_tree = null;
        Object string_literal430_tree = null;
        Object char_literal432_tree = null;
        Object char_literal433_tree = null;
        Object string_literal434_tree = null;
        Object char_literal436_tree = null;
        Object char_literal437_tree = null;
        Object string_literal438_tree = null;
        Object NUMBER439_tree = null;
        Object char_literal441_tree = null;
        Object char_literal442_tree = null;
        Object string_literal443_tree = null;
        Object char_literal445_tree = null;
        Object char_literal446_tree = null;
        Object string_literal447_tree = null;
        Object char_literal450_tree = null;
        Object char_literal451_tree = null;
        Object string_literal452_tree = null;
        Object char_literal455_tree = null;
        Object char_literal456_tree = null;
        Object string_literal457_tree = null;
        Object NUMBER458_tree = null;
        Object char_literal461_tree = null;
        Object char_literal462_tree = null;
        Object string_literal463_tree = null;
        Object NUMBER464_tree = null;
        Object NUMBER465_tree = null;
        Object char_literal467_tree = null;
        Object char_literal468_tree = null;
        Object string_literal469_tree = null;
        Object NUMBER470_tree = null;
        Object char_literal472_tree = null;

        try {
            // Pddl.g:485:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
            int alt75 = 12;
            int LA75_0 = input.LA(1);

            if ((LA75_0 == 56)) {
                switch (input.LA(2)) {
                    case 90: {
                        alt75 = 1;
                    }
                    break;
                    case 100: {
                        alt75 = 2;
                    }
                    break;
                    case 92: {
                        alt75 = 3;
                    }
                    break;
                    case 88: {
                        alt75 = 4;
                    }
                    break;
                    case 116: {
                        alt75 = 5;
                    }
                    break;
                    case 121: {
                        alt75 = 6;
                    }
                    break;
                    case 93: {
                        alt75 = 7;
                    }
                    break;
                    case 117: {
                        alt75 = 8;
                    }
                    break;
                    case 118: {
                        alt75 = 9;
                    }
                    break;
                    case 89: {
                        alt75 = 10;
                    }
                    break;
                    case 102: {
                        alt75 = 11;
                    }
                    break;
                    case 101: {
                        alt75 = 12;
                    }
                    break;
                    default:
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return retval;
                        }
                        NoViableAltException nvae =
                                new NoViableAltException("", 75, 1, input);

                        throw nvae;

                }

            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return retval;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1: // Pddl.g:485:4: '(' 'and' ( conGD )* ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal413 = (Token) match(input, 56, FOLLOW_56_in_conGD3046);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal413_tree =
                                (Object) adaptor.create(char_literal413);
                        adaptor.addChild(root_0, char_literal413_tree);
                    }

                    string_literal414 = (Token) match(input, 90, FOLLOW_90_in_conGD3048);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal414_tree =
                                (Object) adaptor.create(string_literal414);
                        adaptor.addChild(root_0, string_literal414_tree);
                    }

                    // Pddl.g:485:14: ( conGD )*
                    loop74:
                    do {
                        int alt74 = 2;
                        int LA74_0 = input.LA(1);

                        if ((LA74_0 == 56)) {
                            alt74 = 1;
                        }


                        switch (alt74) {
                            case 1: // Pddl.g:485:14: conGD
                            {
                                pushFollow(FOLLOW_conGD_in_conGD3050);
                                conGD415 = conGD();

                                state._fsp--;
                                if (state.failed) {
                                    return retval;
                                }
                                if (state.backtracking == 0) {
                                    adaptor.addChild(root_0, conGD415.getTree());
                                }

                            }
                            break;

                            default:
                                break loop74;
                        }
                    } while (true);


                    char_literal416 = (Token) match(input, 57, FOLLOW_57_in_conGD3053);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal416_tree =
                                (Object) adaptor.create(char_literal416);
                        adaptor.addChild(root_0, char_literal416_tree);
                    }

                }
                break;
                case 2: // Pddl.g:486:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal417 = (Token) match(input, 56, FOLLOW_56_in_conGD3058);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal417_tree =
                                (Object) adaptor.create(char_literal417);
                        adaptor.addChild(root_0, char_literal417_tree);
                    }

                    string_literal418 = (Token) match(input, 100, FOLLOW_100_in_conGD3060);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal418_tree =
                                (Object) adaptor.create(string_literal418);
                        adaptor.addChild(root_0, string_literal418_tree);
                    }

                    char_literal419 = (Token) match(input, 56, FOLLOW_56_in_conGD3062);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal419_tree =
                                (Object) adaptor.create(char_literal419);
                        adaptor.addChild(root_0, char_literal419_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_conGD3064);
                    typedVariableList420 = typedVariableList();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, typedVariableList420.getTree());
                    }

                    char_literal421 = (Token) match(input, 57, FOLLOW_57_in_conGD3066);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal421_tree =
                                (Object) adaptor.create(char_literal421);
                        adaptor.addChild(root_0, char_literal421_tree);
                    }

                    pushFollow(FOLLOW_conGD_in_conGD3068);
                    conGD422 = conGD();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, conGD422.getTree());
                    }

                    char_literal423 = (Token) match(input, 57, FOLLOW_57_in_conGD3070);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal423_tree =
                                (Object) adaptor.create(char_literal423);
                        adaptor.addChild(root_0, char_literal423_tree);
                    }

                }
                break;
                case 3: // Pddl.g:487:4: '(' 'at' 'end' goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal424 = (Token) match(input, 56, FOLLOW_56_in_conGD3075);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal424_tree =
                                (Object) adaptor.create(char_literal424);
                        adaptor.addChild(root_0, char_literal424_tree);
                    }

                    string_literal425 = (Token) match(input, 92, FOLLOW_92_in_conGD3077);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal425_tree =
                                (Object) adaptor.create(string_literal425);
                        adaptor.addChild(root_0, string_literal425_tree);
                    }

                    string_literal426 = (Token) match(input, 98, FOLLOW_98_in_conGD3079);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal426_tree =
                                (Object) adaptor.create(string_literal426);
                        adaptor.addChild(root_0, string_literal426_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3081);
                    goalDesc427 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc427.getTree());
                    }

                    char_literal428 = (Token) match(input, 57, FOLLOW_57_in_conGD3083);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal428_tree =
                                (Object) adaptor.create(char_literal428);
                        adaptor.addChild(root_0, char_literal428_tree);
                    }

                }
                break;
                case 4: // Pddl.g:488:7: '(' 'always' goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal429 = (Token) match(input, 56, FOLLOW_56_in_conGD3091);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal429_tree =
                                (Object) adaptor.create(char_literal429);
                        adaptor.addChild(root_0, char_literal429_tree);
                    }

                    string_literal430 = (Token) match(input, 88, FOLLOW_88_in_conGD3093);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal430_tree =
                                (Object) adaptor.create(string_literal430);
                        adaptor.addChild(root_0, string_literal430_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3095);
                    goalDesc431 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc431.getTree());
                    }

                    char_literal432 = (Token) match(input, 57, FOLLOW_57_in_conGD3097);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal432_tree =
                                (Object) adaptor.create(char_literal432);
                        adaptor.addChild(root_0, char_literal432_tree);
                    }

                }
                break;
                case 5: // Pddl.g:489:4: '(' 'sometime' goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal433 = (Token) match(input, 56, FOLLOW_56_in_conGD3102);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal433_tree =
                                (Object) adaptor.create(char_literal433);
                        adaptor.addChild(root_0, char_literal433_tree);
                    }

                    string_literal434 = (Token) match(input, 116, FOLLOW_116_in_conGD3104);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal434_tree =
                                (Object) adaptor.create(string_literal434);
                        adaptor.addChild(root_0, string_literal434_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3106);
                    goalDesc435 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc435.getTree());
                    }

                    char_literal436 = (Token) match(input, 57, FOLLOW_57_in_conGD3108);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal436_tree =
                                (Object) adaptor.create(char_literal436);
                        adaptor.addChild(root_0, char_literal436_tree);
                    }

                }
                break;
                case 6: // Pddl.g:490:5: '(' 'within' NUMBER goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal437 = (Token) match(input, 56, FOLLOW_56_in_conGD3114);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal437_tree =
                                (Object) adaptor.create(char_literal437);
                        adaptor.addChild(root_0, char_literal437_tree);
                    }

                    string_literal438 = (Token) match(input, 121, FOLLOW_121_in_conGD3116);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal438_tree =
                                (Object) adaptor.create(string_literal438);
                        adaptor.addChild(root_0, string_literal438_tree);
                    }

                    NUMBER439 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_conGD3118);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER439_tree =
                                (Object) adaptor.create(NUMBER439);
                        adaptor.addChild(root_0, NUMBER439_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3120);
                    goalDesc440 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc440.getTree());
                    }

                    char_literal441 = (Token) match(input, 57, FOLLOW_57_in_conGD3122);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal441_tree =
                                (Object) adaptor.create(char_literal441);
                        adaptor.addChild(root_0, char_literal441_tree);
                    }

                }
                break;
                case 7: // Pddl.g:491:4: '(' 'at-most-once' goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal442 = (Token) match(input, 56, FOLLOW_56_in_conGD3127);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal442_tree =
                                (Object) adaptor.create(char_literal442);
                        adaptor.addChild(root_0, char_literal442_tree);
                    }

                    string_literal443 = (Token) match(input, 93, FOLLOW_93_in_conGD3129);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal443_tree =
                                (Object) adaptor.create(string_literal443);
                        adaptor.addChild(root_0, string_literal443_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3131);
                    goalDesc444 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc444.getTree());
                    }

                    char_literal445 = (Token) match(input, 57, FOLLOW_57_in_conGD3133);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal445_tree =
                                (Object) adaptor.create(char_literal445);
                        adaptor.addChild(root_0, char_literal445_tree);
                    }

                }
                break;
                case 8: // Pddl.g:492:4: '(' 'sometime-after' goalDesc goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal446 = (Token) match(input, 56, FOLLOW_56_in_conGD3138);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal446_tree =
                                (Object) adaptor.create(char_literal446);
                        adaptor.addChild(root_0, char_literal446_tree);
                    }

                    string_literal447 = (Token) match(input, 117, FOLLOW_117_in_conGD3140);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal447_tree =
                                (Object) adaptor.create(string_literal447);
                        adaptor.addChild(root_0, string_literal447_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3142);
                    goalDesc448 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc448.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3144);
                    goalDesc449 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc449.getTree());
                    }

                    char_literal450 = (Token) match(input, 57, FOLLOW_57_in_conGD3146);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal450_tree =
                                (Object) adaptor.create(char_literal450);
                        adaptor.addChild(root_0, char_literal450_tree);
                    }

                }
                break;
                case 9: // Pddl.g:493:4: '(' 'sometime-before' goalDesc goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal451 = (Token) match(input, 56, FOLLOW_56_in_conGD3151);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal451_tree =
                                (Object) adaptor.create(char_literal451);
                        adaptor.addChild(root_0, char_literal451_tree);
                    }

                    string_literal452 = (Token) match(input, 118, FOLLOW_118_in_conGD3153);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal452_tree =
                                (Object) adaptor.create(string_literal452);
                        adaptor.addChild(root_0, string_literal452_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3155);
                    goalDesc453 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc453.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3157);
                    goalDesc454 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc454.getTree());
                    }

                    char_literal455 = (Token) match(input, 57, FOLLOW_57_in_conGD3159);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal455_tree =
                                (Object) adaptor.create(char_literal455);
                        adaptor.addChild(root_0, char_literal455_tree);
                    }

                }
                break;
                case 10: // Pddl.g:494:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal456 = (Token) match(input, 56, FOLLOW_56_in_conGD3164);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal456_tree =
                                (Object) adaptor.create(char_literal456);
                        adaptor.addChild(root_0, char_literal456_tree);
                    }

                    string_literal457 = (Token) match(input, 89, FOLLOW_89_in_conGD3166);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal457_tree =
                                (Object) adaptor.create(string_literal457);
                        adaptor.addChild(root_0, string_literal457_tree);
                    }

                    NUMBER458 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_conGD3168);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER458_tree =
                                (Object) adaptor.create(NUMBER458);
                        adaptor.addChild(root_0, NUMBER458_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3170);
                    goalDesc459 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc459.getTree());
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3172);
                    goalDesc460 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc460.getTree());
                    }

                    char_literal461 = (Token) match(input, 57, FOLLOW_57_in_conGD3174);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal461_tree =
                                (Object) adaptor.create(char_literal461);
                        adaptor.addChild(root_0, char_literal461_tree);
                    }

                }
                break;
                case 11: // Pddl.g:495:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal462 = (Token) match(input, 56, FOLLOW_56_in_conGD3179);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal462_tree =
                                (Object) adaptor.create(char_literal462);
                        adaptor.addChild(root_0, char_literal462_tree);
                    }

                    string_literal463 = (Token) match(input, 102, FOLLOW_102_in_conGD3181);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal463_tree =
                                (Object) adaptor.create(string_literal463);
                        adaptor.addChild(root_0, string_literal463_tree);
                    }

                    NUMBER464 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_conGD3183);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER464_tree =
                                (Object) adaptor.create(NUMBER464);
                        adaptor.addChild(root_0, NUMBER464_tree);
                    }

                    NUMBER465 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_conGD3185);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER465_tree =
                                (Object) adaptor.create(NUMBER465);
                        adaptor.addChild(root_0, NUMBER465_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3187);
                    goalDesc466 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc466.getTree());
                    }

                    char_literal467 = (Token) match(input, 57, FOLLOW_57_in_conGD3189);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal467_tree =
                                (Object) adaptor.create(char_literal467);
                        adaptor.addChild(root_0, char_literal467_tree);
                    }

                }
                break;
                case 12: // Pddl.g:496:4: '(' 'hold-after' NUMBER goalDesc ')'
                {
                    root_0 = (Object) adaptor.nil();


                    char_literal468 = (Token) match(input, 56, FOLLOW_56_in_conGD3194);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal468_tree =
                                (Object) adaptor.create(char_literal468);
                        adaptor.addChild(root_0, char_literal468_tree);
                    }

                    string_literal469 = (Token) match(input, 101, FOLLOW_101_in_conGD3196);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        string_literal469_tree =
                                (Object) adaptor.create(string_literal469);
                        adaptor.addChild(root_0, string_literal469_tree);
                    }

                    NUMBER470 = (Token) match(input, NUMBER, FOLLOW_NUMBER_in_conGD3198);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        NUMBER470_tree =
                                (Object) adaptor.create(NUMBER470);
                        adaptor.addChild(root_0, NUMBER470_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3200);
                    goalDesc471 = goalDesc();

                    state._fsp--;
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        adaptor.addChild(root_0, goalDesc471.getTree());
                    }

                    char_literal472 = (Token) match(input, 57, FOLLOW_57_in_conGD3202);
                    if (state.failed) {
                        return retval;
                    }
                    if (state.backtracking == 0) {
                        char_literal472_tree =
                                (Object) adaptor.create(char_literal472);
                        adaptor.addChild(root_0, char_literal472_tree);
                    }

                }
                break;

            }
            retval.stop = input.LT(-1);


            if (state.backtracking == 0) {

                retval.tree = (Object) adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        } finally {
            // do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "conGD"

    // $ANTLR start synpred17_Pddl
    public final void synpred17_Pddl_fragment() throws RecognitionException {
        // Pddl.g:147:5: ( atomicFunctionSkeleton )
        // Pddl.g:147:5: atomicFunctionSkeleton
        {
            pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred17_Pddl720);
            atomicFunctionSkeleton();

            state._fsp--;
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred17_Pddl

    // $ANTLR start synpred55_Pddl
    public final void synpred55_Pddl_fragment() throws RecognitionException {
        // Pddl.g:299:4: ( '(' binaryOp fExp fExp2 ')' )
        // Pddl.g:299:4: '(' binaryOp fExp fExp2 ')'
        {
            match(input, 56, FOLLOW_56_in_synpred55_Pddl1723);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_binaryOp_in_synpred55_Pddl1725);
            binaryOp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_fExp_in_synpred55_Pddl1727);
            fExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_fExp2_in_synpred55_Pddl1729);
            fExp2();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred55_Pddl1731);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred55_Pddl

    // $ANTLR start synpred56_Pddl
    public final void synpred56_Pddl_fragment() throws RecognitionException {
        // Pddl.g:300:4: ( '(' '-' fExp ')' )
        // Pddl.g:300:4: '(' '-' fExp ')'
        {
            match(input, 56, FOLLOW_56_in_synpred56_Pddl1748);
            if (state.failed) {
                return;
            }

            match(input, 60, FOLLOW_60_in_synpred56_Pddl1750);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_fExp_in_synpred56_Pddl1752);
            fExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred56_Pddl1754);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred56_Pddl

    // $ANTLR start synpred85_Pddl
    public final void synpred85_Pddl_fragment() throws RecognitionException {
        // Pddl.g:366:12: ( NUMBER )
        // Pddl.g:366:12: NUMBER
        {
            match(input, NUMBER, FOLLOW_NUMBER_in_synpred85_Pddl2193);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred85_Pddl

    // $ANTLR start synpred87_Pddl
    public final void synpred87_Pddl_fragment() throws RecognitionException {
        // Pddl.g:369:4: ( '(' 'and' ( daEffect )* ')' )
        // Pddl.g:369:4: '(' 'and' ( daEffect )* ')'
        {
            match(input, 56, FOLLOW_56_in_synpred87_Pddl2207);
            if (state.failed) {
                return;
            }

            match(input, 90, FOLLOW_90_in_synpred87_Pddl2209);
            if (state.failed) {
                return;
            }

            // Pddl.g:369:14: ( daEffect )*
            loop91:
            do {
                int alt91 = 2;
                int LA91_0 = input.LA(1);

                if ((LA91_0 == 56)) {
                    alt91 = 1;
                }


                switch (alt91) {
                    case 1: // Pddl.g:369:14: daEffect
                    {
                        pushFollow(FOLLOW_daEffect_in_synpred87_Pddl2211);
                        daEffect();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                    }
                    break;

                    default:
                        break loop91;
                }
            } while (true);


            match(input, 57, FOLLOW_57_in_synpred87_Pddl2214);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred87_Pddl

    // $ANTLR start synpred88_Pddl
    public final void synpred88_Pddl_fragment() throws RecognitionException {
        // Pddl.g:370:4: ( timedEffect )
        // Pddl.g:370:4: timedEffect
        {
            pushFollow(FOLLOW_timedEffect_in_synpred88_Pddl2219);
            timedEffect();

            state._fsp--;
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred88_Pddl

    // $ANTLR start synpred89_Pddl
    public final void synpred89_Pddl_fragment() throws RecognitionException {
        // Pddl.g:371:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
        // Pddl.g:371:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
        {
            match(input, 56, FOLLOW_56_in_synpred89_Pddl2224);
            if (state.failed) {
                return;
            }

            match(input, 100, FOLLOW_100_in_synpred89_Pddl2226);
            if (state.failed) {
                return;
            }

            match(input, 56, FOLLOW_56_in_synpred89_Pddl2228);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_typedVariableList_in_synpred89_Pddl2230);
            typedVariableList();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred89_Pddl2232);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_daEffect_in_synpred89_Pddl2234);
            daEffect();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred89_Pddl2236);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred89_Pddl

    // $ANTLR start synpred90_Pddl
    public final void synpred90_Pddl_fragment() throws RecognitionException {
        // Pddl.g:372:4: ( '(' 'when' daGD timedEffect ')' )
        // Pddl.g:372:4: '(' 'when' daGD timedEffect ')'
        {
            match(input, 56, FOLLOW_56_in_synpred90_Pddl2241);
            if (state.failed) {
                return;
            }

            match(input, 120, FOLLOW_120_in_synpred90_Pddl2243);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_daGD_in_synpred90_Pddl2245);
            daGD();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_timedEffect_in_synpred90_Pddl2247);
            timedEffect();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred90_Pddl2249);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred90_Pddl

    // $ANTLR start synpred91_Pddl
    public final void synpred91_Pddl_fragment() throws RecognitionException {
        // Pddl.g:377:4: ( '(' 'at' timeSpecifier daEffect ')' )
        // Pddl.g:377:4: '(' 'at' timeSpecifier daEffect ')'
        {
            match(input, 56, FOLLOW_56_in_synpred91_Pddl2273);
            if (state.failed) {
                return;
            }

            match(input, 92, FOLLOW_92_in_synpred91_Pddl2275);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_timeSpecifier_in_synpred91_Pddl2277);
            timeSpecifier();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_daEffect_in_synpred91_Pddl2279);
            daEffect();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred91_Pddl2281);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred91_Pddl

    // $ANTLR start synpred92_Pddl
    public final void synpred92_Pddl_fragment() throws RecognitionException {
        // Pddl.g:378:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
        // Pddl.g:378:4: '(' 'at' timeSpecifier fAssignDA ')'
        {
            match(input, 56, FOLLOW_56_in_synpred92_Pddl2291);
            if (state.failed) {
                return;
            }

            match(input, 92, FOLLOW_92_in_synpred92_Pddl2293);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_timeSpecifier_in_synpred92_Pddl2295);
            timeSpecifier();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_fAssignDA_in_synpred92_Pddl2297);
            fAssignDA();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred92_Pddl2299);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred92_Pddl

    // $ANTLR start synpred93_Pddl
    public final void synpred93_Pddl_fragment() throws RecognitionException {
        // Pddl.g:387:9: ( ( binaryOp fExpDA fExpDA ) )
        // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
        {
            // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
            // Pddl.g:387:10: binaryOp fExpDA fExpDA
            {
                pushFollow(FOLLOW_binaryOp_in_synpred93_Pddl2355);
                binaryOp();

                state._fsp--;
                if (state.failed) {
                    return;
                }

                pushFollow(FOLLOW_fExpDA_in_synpred93_Pddl2357);
                fExpDA();

                state._fsp--;
                if (state.failed) {
                    return;
                }

                pushFollow(FOLLOW_fExpDA_in_synpred93_Pddl2359);
                fExpDA();

                state._fsp--;
                if (state.failed) {
                    return;
                }

            }


        }

    }
    // $ANTLR end synpred93_Pddl

    // $ANTLR start synpred94_Pddl
    public final void synpred94_Pddl_fragment() throws RecognitionException {
        // Pddl.g:387:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
        // Pddl.g:387:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
        {
            match(input, 56, FOLLOW_56_in_synpred94_Pddl2351);
            if (state.failed) {
                return;
            }

            // Pddl.g:387:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
            int alt92 = 2;
            int LA92_0 = input.LA(1);

            if ((LA92_0 == 60)) {
                int LA92_1 = input.LA(2);

                if ((synpred93_Pddl())) {
                    alt92 = 1;
                } else if ((true)) {
                    alt92 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 92, 1, input);

                    throw nvae;

                }
            } else if (((LA92_0 >= 58 && LA92_0 <= 59) || LA92_0 == 61)) {
                alt92 = 1;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 92, 0, input);

                throw nvae;

            }
            switch (alt92) {
                case 1: // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
                {
                    // Pddl.g:387:9: ( binaryOp fExpDA fExpDA )
                    // Pddl.g:387:10: binaryOp fExpDA fExpDA
                    {
                        pushFollow(FOLLOW_binaryOp_in_synpred94_Pddl2355);
                        binaryOp();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                        pushFollow(FOLLOW_fExpDA_in_synpred94_Pddl2357);
                        fExpDA();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                        pushFollow(FOLLOW_fExpDA_in_synpred94_Pddl2359);
                        fExpDA();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                    }


                }
                break;
                case 2: // Pddl.g:387:36: ( '-' fExpDA )
                {
                    // Pddl.g:387:36: ( '-' fExpDA )
                    // Pddl.g:387:37: '-' fExpDA
                    {
                        match(input, 60, FOLLOW_60_in_synpred94_Pddl2365);
                        if (state.failed) {
                            return;
                        }

                        pushFollow(FOLLOW_fExpDA_in_synpred94_Pddl2367);
                        fExpDA();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                    }


                }
                break;

            }


            match(input, 57, FOLLOW_57_in_synpred94_Pddl2371);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred94_Pddl

    // $ANTLR start synpred106_Pddl
    public final void synpred106_Pddl_fragment() throws RecognitionException {
        // Pddl.g:456:4: ( '(' 'and' ( prefConGD )* ')' )
        // Pddl.g:456:4: '(' 'and' ( prefConGD )* ')'
        {
            match(input, 56, FOLLOW_56_in_synpred106_Pddl2821);
            if (state.failed) {
                return;
            }

            match(input, 90, FOLLOW_90_in_synpred106_Pddl2823);
            if (state.failed) {
                return;
            }

            // Pddl.g:456:14: ( prefConGD )*
            loop93:
            do {
                int alt93 = 2;
                int LA93_0 = input.LA(1);

                if ((LA93_0 == 56)) {
                    alt93 = 1;
                }


                switch (alt93) {
                    case 1: // Pddl.g:456:14: prefConGD
                    {
                        pushFollow(FOLLOW_prefConGD_in_synpred106_Pddl2825);
                        prefConGD();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                    }
                    break;

                    default:
                        break loop93;
                }
            } while (true);


            match(input, 57, FOLLOW_57_in_synpred106_Pddl2828);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred106_Pddl

    // $ANTLR start synpred107_Pddl
    public final void synpred107_Pddl_fragment() throws RecognitionException {
        // Pddl.g:457:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
        // Pddl.g:457:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
        {
            match(input, 56, FOLLOW_56_in_synpred107_Pddl2833);
            if (state.failed) {
                return;
            }

            match(input, 100, FOLLOW_100_in_synpred107_Pddl2835);
            if (state.failed) {
                return;
            }

            match(input, 56, FOLLOW_56_in_synpred107_Pddl2837);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_typedVariableList_in_synpred107_Pddl2839);
            typedVariableList();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred107_Pddl2841);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_prefConGD_in_synpred107_Pddl2843);
            prefConGD();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred107_Pddl2845);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred107_Pddl

    // $ANTLR start synpred109_Pddl
    public final void synpred109_Pddl_fragment() throws RecognitionException {
        // Pddl.g:458:4: ( '(' 'preference' ( NAME )? conGD ')' )
        // Pddl.g:458:4: '(' 'preference' ( NAME )? conGD ')'
        {
            match(input, 56, FOLLOW_56_in_synpred109_Pddl2850);
            if (state.failed) {
                return;
            }

            match(input, 112, FOLLOW_112_in_synpred109_Pddl2852);
            if (state.failed) {
                return;
            }

            // Pddl.g:458:21: ( NAME )?
            int alt94 = 2;
            int LA94_0 = input.LA(1);

            if ((LA94_0 == NAME)) {
                alt94 = 1;
            }
            switch (alt94) {
                case 1: // Pddl.g:458:21: NAME
                {
                    match(input, NAME, FOLLOW_NAME_in_synpred109_Pddl2854);
                    if (state.failed) {
                        return;
                    }

                }
                break;

            }


            pushFollow(FOLLOW_conGD_in_synpred109_Pddl2857);
            conGD();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred109_Pddl2859);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred109_Pddl

    // $ANTLR start synpred111_Pddl
    public final void synpred111_Pddl_fragment() throws RecognitionException {
        // Pddl.g:470:4: ( '(' binaryOp metricFExp metricFExp ')' )
        // Pddl.g:470:4: '(' binaryOp metricFExp metricFExp ')'
        {
            match(input, 56, FOLLOW_56_in_synpred111_Pddl2920);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_binaryOp_in_synpred111_Pddl2922);
            binaryOp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_metricFExp_in_synpred111_Pddl2924);
            metricFExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_metricFExp_in_synpred111_Pddl2926);
            metricFExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred111_Pddl2928);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred111_Pddl

    // $ANTLR start synpred113_Pddl
    public final void synpred113_Pddl_fragment() throws RecognitionException {
        // Pddl.g:472:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
        // Pddl.g:472:4: '(' multiOp metricFExp ( metricFExp )+ ')'
        {
            match(input, 56, FOLLOW_56_in_synpred113_Pddl2950);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_multiOp_in_synpred113_Pddl2952);
            multiOp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_metricFExp_in_synpred113_Pddl2954);
            metricFExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            // Pddl.g:472:27: ( metricFExp )+
            int cnt95 = 0;
            loop95:
            do {
                int alt95 = 2;
                int LA95_0 = input.LA(1);

                if ((LA95_0 == NAME || LA95_0 == NUMBER || LA95_0 == 56)) {
                    alt95 = 1;
                }


                switch (alt95) {
                    case 1: // Pddl.g:472:27: metricFExp
                    {
                        pushFollow(FOLLOW_metricFExp_in_synpred113_Pddl2956);
                        metricFExp();

                        state._fsp--;
                        if (state.failed) {
                            return;
                        }

                    }
                    break;

                    default:
                        if (cnt95 >= 1) {
                            break loop95;
                        }
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return;
                        }
                        EarlyExitException eee =
                                new EarlyExitException(95, input);
                        throw eee;
                }
                cnt95++;
            } while (true);


            match(input, 57, FOLLOW_57_in_synpred113_Pddl2959);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred113_Pddl

    // $ANTLR start synpred114_Pddl
    public final void synpred114_Pddl_fragment() throws RecognitionException {
        // Pddl.g:474:4: ( '(' '-' metricFExp ')' )
        // Pddl.g:474:4: '(' '-' metricFExp ')'
        {
            match(input, 56, FOLLOW_56_in_synpred114_Pddl2983);
            if (state.failed) {
                return;
            }

            match(input, 60, FOLLOW_60_in_synpred114_Pddl2985);
            if (state.failed) {
                return;
            }

            pushFollow(FOLLOW_metricFExp_in_synpred114_Pddl2987);
            metricFExp();

            state._fsp--;
            if (state.failed) {
                return;
            }

            match(input, 57, FOLLOW_57_in_synpred114_Pddl2989);
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred114_Pddl

    // $ANTLR start synpred116_Pddl
    public final void synpred116_Pddl_fragment() throws RecognitionException {
        // Pddl.g:477:4: ( fHead )
        // Pddl.g:477:4: fHead
        {
            pushFollow(FOLLOW_fHead_in_synpred116_Pddl3011);
            fHead();

            state._fsp--;
            if (state.failed) {
                return;
            }

        }

    }
    // $ANTLR end synpred116_Pddl

    // Delegated rules
    public final boolean synpred94_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred113_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred88_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred106_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred56_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred114_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred85_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred87_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred17_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred89_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred111_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred55_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred93_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred109_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred107_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred91_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred92_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred90_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }

    public final boolean synpred116_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA13_eotS =
            "\4\uffff";
    static final String DFA13_eofS =
            "\4\uffff";
    static final String DFA13_minS =
            "\2\41\2\uffff";
    static final String DFA13_maxS =
            "\1\71\1\74\2\uffff";
    static final String DFA13_acceptS =
            "\2\uffff\1\1\1\2";
    static final String DFA13_specialS =
            "\4\uffff}>";
    static final String[] DFA13_transitionS = {
        "\1\1\27\uffff\1\2",
        "\1\1\27\uffff\1\2\2\uffff\1\3",
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
        for (int i = 0; i < numStates; i++) {
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
            return "125:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
        }
    }
    static final String DFA11_eotS =
            "\4\uffff";
    static final String DFA11_eofS =
            "\4\uffff";
    static final String DFA11_minS =
            "\2\41\2\uffff";
    static final String DFA11_maxS =
            "\1\71\1\74\2\uffff";
    static final String DFA11_acceptS =
            "\2\uffff\1\2\1\1";
    static final String DFA11_specialS =
            "\4\uffff}>";
    static final String[] DFA11_transitionS = {
        "\1\1\27\uffff\1\2",
        "\1\1\27\uffff\1\2\2\uffff\1\3",
        "",
        ""
    };
    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }

        public String getDescription() {
            return "()+ loopback of 125:16: ( singleTypeNameList )+";
        }
    }
    static final String DFA24_eotS =
            "\4\uffff";
    static final String DFA24_eofS =
            "\4\uffff";
    static final String DFA24_minS =
            "\2\65\2\uffff";
    static final String DFA24_maxS =
            "\1\71\1\74\2\uffff";
    static final String DFA24_acceptS =
            "\2\uffff\1\1\1\2";
    static final String DFA24_specialS =
            "\4\uffff}>";
    static final String[] DFA24_transitionS = {
        "\1\1\2\uffff\2\2",
        "\1\1\2\uffff\2\2\2\uffff\1\3",
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
        for (int i = 0; i < numStates; i++) {
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
            return "176:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
        }
    }
    static final String DFA22_eotS =
            "\4\uffff";
    static final String DFA22_eofS =
            "\4\uffff";
    static final String DFA22_minS =
            "\2\65\2\uffff";
    static final String DFA22_maxS =
            "\1\71\1\74\2\uffff";
    static final String DFA22_acceptS =
            "\2\uffff\1\2\1\1";
    static final String DFA22_specialS =
            "\4\uffff}>";
    static final String[] DFA22_transitionS = {
        "\1\1\2\uffff\2\2",
        "\1\1\2\uffff\2\2\2\uffff\1\3",
        "",
        ""
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
        for (int i = 0; i < numStates; i++) {
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
            return "()+ loopback of 176:20: ( singleTypeVarList )+";
        }
    }
    public static final BitSet FOLLOW_domain_in_pddlDoc311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_problem_in_pddlDoc315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_domain330 = new BitSet(new long[]{0x0000000000000000L, 0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_domain332 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_domainName_in_domain334 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_requireDef_in_domain342 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_typesDef_in_domain351 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_constantsDef_in_domain360 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_predicatesDef_in_domain369 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_functionsDef_in_domain378 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_constraints_in_domain387 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_structureDef_in_domain396 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_domain405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_domainName489 = new BitSet(new long[]{0x0000000000000000L, 0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_domainName491 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_NAME_in_domainName493 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_domainName495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_requireDef522 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_requireDef524 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef526 = new BitSet(new long[]{0x0204000000000000L});
    public static final BitSet FOLLOW_57_in_requireDef529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_typesDef550 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_typesDef552 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_typedNameList_in_typesDef554 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_typesDef556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_typedNameList583 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList588 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_NAME_in_typedNameList591 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_NAME_in_singleTypeNameList611 = new BitSet(new long[]{0x1000000200000000L});
    public static final BitSet FOLLOW_60_in_singleTypeNameList614 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_type_in_singleTypeNameList618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_type645 = new BitSet(new long[]{0x0000000000000000L, 0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_type647 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_primType_in_type649 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_57_in_type652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primType_in_type673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_primType683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_functionsDef693 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_functionsDef695 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_functionList_in_functionsDef697 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_functionsDef699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList720 = new BitSet(new long[]{0x1100000000000002L});
    public static final BitSet FOLLOW_60_in_functionList724 = new BitSet(new long[]{0x0000000000000000L, 0x0000200000000000L});
    public static final BitSet FOLLOW_functionType_in_functionList726 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_atomicFunctionSkeleton742 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton745 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton748 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_atomicFunctionSkeleton750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_functionSymbol761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_functionType770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_constantsDef781 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_constantsDef783 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_typedNameList_in_constantsDef785 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_constantsDef787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_predicatesDef807 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_predicatesDef809 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef811 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_predicatesDef814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_atomicFormulaSkeleton835 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton838 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton841 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_atomicFormulaSkeleton843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_predicate854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_typedVariableList869 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList874 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_typedVariableList877 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList897 = new BitSet(new long[]{0x1020000000000000L});
    public static final BitSet FOLLOW_60_in_singleTypeVarList900 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_type_in_singleTypeVarList904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_constraints935 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_constraints938 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_conGD_in_constraints941 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_constraints943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actionDef_in_structureDef955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_durativeActionDef_in_structureDef960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedDef_in_structureDef965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_actionDef980 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_actionDef982 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_actionSymbol_in_actionDef984 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_actionDef993 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_actionDef995 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_actionDef997 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_actionDef999 = new BitSet(new long[]{0x0200000000000000L, 0x0000000000002040L});
    public static final BitSet FOLLOW_actionDefBody_in_actionDef1012 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_actionDef1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_actionSymbol1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_actionDefBody1062 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_actionDefBody1066 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_actionDefBody1068 = new BitSet(new long[]{0x0000000000000002L, 0x0000000000000040L});
    public static final BitSet FOLLOW_goalDesc_in_actionDefBody1073 = new BitSet(new long[]{0x0000000000000002L, 0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_actionDefBody1083 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_actionDefBody1087 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_actionDefBody1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_effect_in_actionDefBody1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1143 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_goalDesc1145 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1147 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1175 = new BitSet(new long[]{0x0000000000000000L, 0x0000400000000000L});
    public static final BitSet FOLLOW_110_in_goalDesc1177 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1179 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1207 = new BitSet(new long[]{0x0000000000000000L, 0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_goalDesc1209 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1211 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1237 = new BitSet(new long[]{0x0000000000000000L, 0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_goalDesc1239 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1241 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1243 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1271 = new BitSet(new long[]{0x0000000000000000L, 0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_goalDesc1273 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_goalDesc1275 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_goalDesc1277 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1279 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1281 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goalDesc1309 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_goalDesc1311 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_goalDesc1313 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_goalDesc1315 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1317 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1319 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goalDesc1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fComp_in_goalDesc1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fComp1386 = new BitSet(new long[]{0x0000000000000000L, 0x00000000003E0000L});
    public static final BitSet FOLLOW_binaryComp_in_fComp1389 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_fComp1391 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_fComp1393 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_fComp1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_atomicTermFormula1407 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_predicate_in_atomicTermFormula1409 = new BitSet(new long[]{0x0220000200000000L});
    public static final BitSet FOLLOW_term_in_atomicTermFormula1411 = new BitSet(new long[]{0x0220000200000000L});
    public static final BitSet FOLLOW_57_in_atomicTermFormula1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_durativeActionDef1452 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_durativeActionDef1454 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1456 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_durativeActionDef1465 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_durativeActionDef1467 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1469 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_durativeActionDef1471 = new BitSet(new long[]{0x8000000000000000L, 0x0000000000000050L});
    public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1484 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_durativeActionDef1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_daDefBody1519 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_durationConstraint_in_daDefBody1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_daDefBody1526 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_daDefBody1530 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daDefBody1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_daGD_in_daDefBody1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_daDefBody1546 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_daDefBody1550 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daDefBody1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_daEffect_in_daDefBody1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefTimedGD_in_daGD1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daGD1577 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_daGD1579 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_daGD_in_daGD1581 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_daGD1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daGD1589 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_daGD1591 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_daGD1593 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_daGD1595 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daGD1597 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daGD_in_daGD1599 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daGD1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedGD_in_prefTimedGD1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_prefTimedGD1617 = new BitSet(new long[]{0x0000000000000000L, 0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_prefTimedGD1619 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_NAME_in_prefTimedGD1621 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_timedGD_in_prefTimedGD1624 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_prefTimedGD1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_timedGD1637 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_timedGD1639 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedGD1641 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_timedGD1643 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_timedGD1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_timedGD1650 = new BitSet(new long[]{0x0000000000000000L, 0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_timedGD1652 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000800000L});
    public static final BitSet FOLLOW_interval_in_timedGD1654 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_timedGD1656 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_timedGD1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_interval1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_derivedDef1693 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_derivedDef1696 = new BitSet(new long[]{0x0120000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_derivedDef1699 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_derivedDef1701 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_derivedDef1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_fExp1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fExp1723 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_fExp1725 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_fExp1727 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp2_in_fExp1729 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_fExp1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fExp1748 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_fExp1750 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_fExp1752 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_fExp1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_fExp1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_fExp21779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fHead1789 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_functionSymbol_in_fHead1791 = new BitSet(new long[]{0x0220000200000000L});
    public static final BitSet FOLLOW_term_in_fHead1793 = new BitSet(new long[]{0x0220000200000000L});
    public static final BitSet FOLLOW_57_in_fHead1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSymbol_in_fHead1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_effect1831 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_effect1833 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_cEffect_in_effect1835 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_effect1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cEffect_in_effect1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_cEffect1863 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_cEffect1865 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_cEffect1867 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_cEffect1869 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_cEffect1871 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_effect_in_cEffect1873 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_cEffect1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_cEffect1893 = new BitSet(new long[]{0x0000000000000000L, 0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_cEffect1895 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_cEffect1897 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_condEffect_in_cEffect1899 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_cEffect1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pEffect_in_cEffect1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_pEffect1930 = new BitSet(new long[]{0x0000000000000000L, 0x000C010048000000L});
    public static final BitSet FOLLOW_assignOp_in_pEffect1932 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_fHead_in_pEffect1934 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_pEffect1936 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_pEffect1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_pEffect1958 = new BitSet(new long[]{0x0000000000000000L, 0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_pEffect1960 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_atomicTermFormula_in_pEffect1962 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_pEffect1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTermFormula_in_pEffect1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_condEffect1993 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_condEffect1995 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_pEffect_in_condEffect1997 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_condEffect2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pEffect_in_condEffect2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_durationConstraint2115 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_durationConstraint2117 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2119 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_durationConstraint2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_durationConstraint2127 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_durationConstraint2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_simpleDurationConstraint2145 = new BitSet(new long[]{0x0000000000000000L, 0x00000000002C0000L});
    public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2147 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_simpleDurationConstraint2149 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2151 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_simpleDurationConstraint2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_simpleDurationConstraint2158 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_simpleDurationConstraint2160 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2162 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2164 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_simpleDurationConstraint2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_durValue2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_durValue2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daEffect2207 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_daEffect2209 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_daEffect_in_daEffect2211 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_daEffect2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedEffect_in_daEffect2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daEffect2224 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_daEffect2226 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_daEffect2228 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_daEffect2230 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daEffect2232 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daEffect_in_daEffect2234 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daEffect2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daEffect2241 = new BitSet(new long[]{0x0000000000000000L, 0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_daEffect2243 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daGD_in_daEffect2245 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_timedEffect_in_daEffect2247 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daEffect2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_daEffect2254 = new BitSet(new long[]{0x0000000000000000L, 0x000C010048000000L});
    public static final BitSet FOLLOW_assignOp_in_daEffect2256 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_fHead_in_daEffect2258 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_daEffect2260 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_daEffect2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_timedEffect2273 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_timedEffect2275 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2277 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daEffect_in_timedEffect2279 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_timedEffect2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_timedEffect2291 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_timedEffect2293 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2295 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_fAssignDA_in_timedEffect2297 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_timedEffect2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_timedEffect2304 = new BitSet(new long[]{0x0000000000000000L, 0x000C010048000000L});
    public static final BitSet FOLLOW_assignOp_in_timedEffect2306 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_fHead_in_timedEffect2308 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_timedEffect2310 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_timedEffect2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fAssignDA2332 = new BitSet(new long[]{0x0000000000000000L, 0x000C010048000000L});
    public static final BitSet FOLLOW_assignOp_in_fAssignDA2334 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_fHead_in_fAssignDA2336 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_fAssignDA2338 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_fAssignDA2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fExpDA2351 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_fExpDA2355 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2357 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2359 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_60_in_fExpDA2365 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2367 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_fExpDA2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_fExpDA2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_fExpDA2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_problem2395 = new BitSet(new long[]{0x0000000000000000L, 0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_problem2397 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_problemDecl_in_problem2399 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_problemDomain_in_problem2404 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_requireDef_in_problem2412 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_objectDecl_in_problem2421 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_init_in_problem2430 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goal_in_problem2438 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_probConstraints_in_problem2446 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_metricSpec_in_problem2455 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_problem2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_problemDecl2528 = new BitSet(new long[]{0x0000000000000000L, 0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_problemDecl2530 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_NAME_in_problemDecl2532 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_problemDecl2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_problemDomain2560 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_problemDomain2562 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_NAME_in_problemDomain2564 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_problemDomain2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_objectDecl2586 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_objectDecl2588 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_typedNameList_in_objectDecl2590 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_objectDecl2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_init2612 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_init2614 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_initEl_in_init2616 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_init2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameLiteral_in_initEl2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_initEl2645 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_initEl2647 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_fHead_in_initEl2649 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_initEl2651 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_initEl2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_initEl2676 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_initEl2678 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_initEl2680 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_nameLiteral_in_initEl2682 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_initEl2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_nameLiteral2711 = new BitSet(new long[]{0x0000000000000000L, 0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_nameLiteral2713 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2715 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_nameLiteral2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_atomicNameFormula2736 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_predicate_in_atomicNameFormula2738 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_NAME_in_atomicNameFormula2740 = new BitSet(new long[]{0x0200000200000000L});
    public static final BitSet FOLLOW_57_in_atomicNameFormula2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_goal2768 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_goal2770 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goal2772 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_goal2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_probConstraints2792 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_probConstraints2794 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_probConstraints2797 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_probConstraints2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_prefConGD2821 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_prefConGD2823 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_prefConGD2825 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_prefConGD2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_prefConGD2833 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_prefConGD2835 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_prefConGD2837 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_prefConGD2839 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_prefConGD2841 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_prefConGD2843 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_prefConGD2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_prefConGD2850 = new BitSet(new long[]{0x0000000000000000L, 0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_prefConGD2852 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_NAME_in_prefConGD2854 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_conGD_in_prefConGD2857 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_prefConGD2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conGD_in_prefConGD2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_metricSpec2875 = new BitSet(new long[]{0x0000000000000000L, 0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_metricSpec2877 = new BitSet(new long[]{0x0000000000000000L, 0x00000C0000000000L});
    public static final BitSet FOLLOW_optimization_in_metricSpec2879 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricSpec2881 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_metricSpec2883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_metricFExp2920 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_metricFExp2922 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp2924 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp2926 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_metricFExp2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_metricFExp2950 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_multiOp_in_metricFExp2952 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp2954 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp2956 = new BitSet(new long[]{0x0300002200000000L});
    public static final BitSet FOLLOW_57_in_metricFExp2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_metricFExp2983 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_metricFExp2985 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp2987 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_metricFExp2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_metricFExp3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_metricFExp3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_metricFExp3026 = new BitSet(new long[]{0x0000000000000000L, 0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_metricFExp3028 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_NAME_in_metricFExp3030 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_metricFExp3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3046 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_conGD3048 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_conGD_in_conGD3050 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3058 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_conGD3060 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_conGD3062 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_conGD3064 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3066 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_conGD_in_conGD3068 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3075 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_conGD3077 = new BitSet(new long[]{0x0000000000000000L, 0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_conGD3079 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3081 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3091 = new BitSet(new long[]{0x0000000000000000L, 0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_conGD3093 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3095 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3102 = new BitSet(new long[]{0x0000000000000000L, 0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_conGD3104 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3106 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3114 = new BitSet(new long[]{0x0000000000000000L, 0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_conGD3116 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3118 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3120 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3127 = new BitSet(new long[]{0x0000000000000000L, 0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_conGD3129 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3131 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3138 = new BitSet(new long[]{0x0000000000000000L, 0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_conGD3140 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3142 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3144 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3151 = new BitSet(new long[]{0x0000000000000000L, 0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_conGD3153 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3155 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3157 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3164 = new BitSet(new long[]{0x0000000000000000L, 0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_conGD3166 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3168 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3170 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3172 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3179 = new BitSet(new long[]{0x0000000000000000L, 0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_conGD3181 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3183 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3185 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3187 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_conGD3194 = new BitSet(new long[]{0x0000000000000000L, 0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_conGD3196 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3198 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3200 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_conGD3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred17_Pddl720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred55_Pddl1723 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_synpred55_Pddl1725 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_synpred55_Pddl1727 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp2_in_synpred55_Pddl1729 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred55_Pddl1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred56_Pddl1748 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_synpred56_Pddl1750 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_fExp_in_synpred56_Pddl1752 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred56_Pddl1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_synpred85_Pddl2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred87_Pddl2207 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_synpred87_Pddl2209 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred87_Pddl2211 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_synpred87_Pddl2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedEffect_in_synpred88_Pddl2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred89_Pddl2224 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_synpred89_Pddl2226 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred89_Pddl2228 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_synpred89_Pddl2230 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred89_Pddl2232 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred89_Pddl2234 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred89_Pddl2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred90_Pddl2241 = new BitSet(new long[]{0x0000000000000000L, 0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred90_Pddl2243 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daGD_in_synpred90_Pddl2245 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_timedEffect_in_synpred90_Pddl2247 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred90_Pddl2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred91_Pddl2273 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_synpred91_Pddl2275 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_synpred91_Pddl2277 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred91_Pddl2279 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred91_Pddl2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred92_Pddl2291 = new BitSet(new long[]{0x0000000000000000L, 0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_synpred92_Pddl2293 = new BitSet(new long[]{0x0000000000000000L, 0x0080000400000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_synpred92_Pddl2295 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_fAssignDA_in_synpred92_Pddl2297 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred92_Pddl2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred93_Pddl2355 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred93_Pddl2357 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred93_Pddl2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred94_Pddl2351 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_synpred94_Pddl2355 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred94_Pddl2357 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred94_Pddl2359 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_60_in_synpred94_Pddl2365 = new BitSet(new long[]{0x0100002200000000L, 0x0000000000400000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred94_Pddl2367 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred94_Pddl2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred106_Pddl2821 = new BitSet(new long[]{0x0000000000000000L, 0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_synpred106_Pddl2823 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_synpred106_Pddl2825 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_57_in_synpred106_Pddl2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred107_Pddl2833 = new BitSet(new long[]{0x0000000000000000L, 0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_synpred107_Pddl2835 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred107_Pddl2837 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_synpred107_Pddl2839 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred107_Pddl2841 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_synpred107_Pddl2843 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred107_Pddl2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred109_Pddl2850 = new BitSet(new long[]{0x0000000000000000L, 0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_synpred109_Pddl2852 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_NAME_in_synpred109_Pddl2854 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_conGD_in_synpred109_Pddl2857 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred109_Pddl2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred111_Pddl2920 = new BitSet(new long[]{0x3C00000000000000L});
    public static final BitSet FOLLOW_binaryOp_in_synpred111_Pddl2922 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred111_Pddl2924 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred111_Pddl2926 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred111_Pddl2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred113_Pddl2950 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_multiOp_in_synpred113_Pddl2952 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred113_Pddl2954 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred113_Pddl2956 = new BitSet(new long[]{0x0300002200000000L});
    public static final BitSet FOLLOW_57_in_synpred113_Pddl2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred114_Pddl2983 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_synpred114_Pddl2985 = new BitSet(new long[]{0x0100002200000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred114_Pddl2987 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred114_Pddl2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_synpred116_Pddl3011 = new BitSet(new long[]{0x0000000000000002L});
}