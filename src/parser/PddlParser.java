// $ANTLR 3.4 Pddl.g 2015-12-02 12:12:54

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
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "AND_EFFECT", "AND_GD", "ANY_CHAR", "ASSIGN_EFFECT", "BINARY_OP", "COMPARISON_GD", "CONSTANTS", "CONSTRAINT", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", "EITHER_TYPE", "EQUALITY_CON", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", "FREE_FUNCTIONS", "FUNCTIONS", "FUNC_HEAD", "GLOBAL_CONSTRAINT", "GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", "MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", "NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", "PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", "PROCESS", "REQUIREMENTS", "REQUIRE_KEY", "TYPES", "UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'#t'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", "':constraint'", "':constraints'", "':derived'", "':domain'", "':duration'", "':durative-action'", "':effect'", "':free_functions'", "':functions'", "':goal'", "':init'", "':metric'", "':objects'", "':parameters'", "':precondition'", "':predicates'", "':process'", "':requirements'", "':types'", "'<'", "'<='", "'='", "'>'", "'>='", "'?duration'", "'all'", "'always'", "'always-within'", "'and'", "'assign'", "'at'", "'at-most-once'", "'decrease'", "'define'", "'domain'", "'either'", "'end'", "'exists'", "'forall'", "'hold-after'", "'hold-during'", "'imply'", "'increase'", "'is-violated'", "'maximize'", "'minimize'", "'not'", "'number'", "'or'", "'over'", "'preference'", "'problem'", "'scale-down'", "'scale-up'", "'sometime'", "'sometime-after'", "'sometime-before'", "'start'", "'when'", "'within'"
    };

    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__120=120;
    public static final int T__121=121;
    public static final int T__122=122;
    public static final int T__123=123;
    public static final int T__124=124;
    public static final int T__125=125;
    public static final int T__126=126;
    public static final int T__127=127;
    public static final int T__128=128;
    public static final int T__129=129;
    public static final int ACTION=4;
    public static final int AND_EFFECT=5;
    public static final int AND_GD=6;
    public static final int ANY_CHAR=7;
    public static final int ASSIGN_EFFECT=8;
    public static final int BINARY_OP=9;
    public static final int COMPARISON_GD=10;
    public static final int CONSTANTS=11;
    public static final int CONSTRAINT=12;
    public static final int DIGIT=13;
    public static final int DOMAIN=14;
    public static final int DOMAIN_NAME=15;
    public static final int DURATIVE_ACTION=16;
    public static final int EFFECT=17;
    public static final int EITHER_TYPE=18;
    public static final int EQUALITY_CON=19;
    public static final int EXISTS_GD=20;
    public static final int FORALL_EFFECT=21;
    public static final int FORALL_GD=22;
    public static final int FREE_FUNCTIONS=23;
    public static final int FUNCTIONS=24;
    public static final int FUNC_HEAD=25;
    public static final int GLOBAL_CONSTRAINT=26;
    public static final int GOAL=27;
    public static final int IMPLY_GD=28;
    public static final int INIT=29;
    public static final int INIT_AT=30;
    public static final int INIT_EQ=31;
    public static final int LETTER=32;
    public static final int LINE_COMMENT=33;
    public static final int MINUS_OP=34;
    public static final int MULTI_OP=35;
    public static final int NAME=36;
    public static final int NOT_EFFECT=37;
    public static final int NOT_GD=38;
    public static final int NOT_PRED_INIT=39;
    public static final int NUMBER=40;
    public static final int OBJECTS=41;
    public static final int OR_GD=42;
    public static final int PRECONDITION=43;
    public static final int PREDICATES=44;
    public static final int PRED_HEAD=45;
    public static final int PRED_INST=46;
    public static final int PROBLEM=47;
    public static final int PROBLEM_CONSTRAINT=48;
    public static final int PROBLEM_DOMAIN=49;
    public static final int PROBLEM_METRIC=50;
    public static final int PROBLEM_NAME=51;
    public static final int PROCESS=52;
    public static final int REQUIREMENTS=53;
    public static final int REQUIRE_KEY=54;
    public static final int TYPES=55;
    public static final int UNARY_MINUS=56;
    public static final int VARIABLE=57;
    public static final int WHEN_EFFECT=58;
    public static final int WHITESPACE=59;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
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
    public String[] getTokenNames() { return PddlParser.tokenNames; }
    public String getGrammarFileName() { return "Pddl.g"; }


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
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pddlDoc"
    // Pddl.g:95:1: pddlDoc : ( domain | problem );
    public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
        PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.domain_return domain1 =null;

        PddlParser.problem_return problem2 =null;



        try {
            // Pddl.g:95:9: ( domain | problem )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==61) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==103) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==61) ) {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3==104) ) {
                            alt1=1;
                        }
                        else if ( (LA1_3==121) ) {
                            alt1=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Pddl.g:95:11: domain
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_domain_in_pddlDoc348);
                    domain1=domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:95:20: problem
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_problem_in_pddlDoc352);
                    problem2=problem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, problem2.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pddlDoc"


    public static class domain_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "domain"
    // Pddl.g:99:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
    public final PddlParser.domain_return domain() throws RecognitionException {
        PddlParser.domain_return retval = new PddlParser.domain_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal3=null;
        Token string_literal4=null;
        Token char_literal14=null;
        PddlParser.domainName_return domainName5 =null;

        PddlParser.requireDef_return requireDef6 =null;

        PddlParser.typesDef_return typesDef7 =null;

        PddlParser.constantsDef_return constantsDef8 =null;

        PddlParser.predicatesDef_return predicatesDef9 =null;

        PddlParser.functionsDef_return functionsDef10 =null;

        PddlParser.free_functionsDef_return free_functionsDef11 =null;

        PddlParser.constraints_return constraints12 =null;

        PddlParser.structureDef_return structureDef13 =null;


        Object char_literal3_tree=null;
        Object string_literal4_tree=null;
        Object char_literal14_tree=null;
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typesDef=new RewriteRuleSubtreeStream(adaptor,"rule typesDef");
        RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
        RewriteRuleSubtreeStream stream_free_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule free_functionsDef");
        RewriteRuleSubtreeStream stream_domainName=new RewriteRuleSubtreeStream(adaptor,"rule domainName");
        RewriteRuleSubtreeStream stream_predicatesDef=new RewriteRuleSubtreeStream(adaptor,"rule predicatesDef");
        RewriteRuleSubtreeStream stream_constantsDef=new RewriteRuleSubtreeStream(adaptor,"rule constantsDef");
        RewriteRuleSubtreeStream stream_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule functionsDef");
        RewriteRuleSubtreeStream stream_constraints=new RewriteRuleSubtreeStream(adaptor,"rule constraints");
        RewriteRuleSubtreeStream stream_structureDef=new RewriteRuleSubtreeStream(adaptor,"rule structureDef");
        try {
            // Pddl.g:100:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
            // Pddl.g:100:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
            {
            char_literal3=(Token)match(input,61,FOLLOW_61_in_domain367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal3);


            string_literal4=(Token)match(input,103,FOLLOW_103_in_domain369); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(string_literal4);


            pushFollow(FOLLOW_domainName_in_domain371);
            domainName5=domainName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());

            // Pddl.g:101:7: ( requireDef )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==61) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==87) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // Pddl.g:101:7: requireDef
                    {
                    pushFollow(FOLLOW_requireDef_in_domain379);
                    requireDef6=requireDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());

                    }
                    break;

            }


            // Pddl.g:102:7: ( typesDef )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==61) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==88) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // Pddl.g:102:7: typesDef
                    {
                    pushFollow(FOLLOW_typesDef_in_domain388);
                    typesDef7=typesDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());

                    }
                    break;

            }


            // Pddl.g:103:7: ( constantsDef )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==61) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==69) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // Pddl.g:103:7: constantsDef
                    {
                    pushFollow(FOLLOW_constantsDef_in_domain397);
                    constantsDef8=constantsDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());

                    }
                    break;

            }


            // Pddl.g:104:7: ( predicatesDef )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==61) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==85) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // Pddl.g:104:7: predicatesDef
                    {
                    pushFollow(FOLLOW_predicatesDef_in_domain406);
                    predicatesDef9=predicatesDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());

                    }
                    break;

            }


            // Pddl.g:105:7: ( functionsDef )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==61) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==78) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // Pddl.g:105:7: functionsDef
                    {
                    pushFollow(FOLLOW_functionsDef_in_domain415);
                    functionsDef10=functionsDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());

                    }
                    break;

            }


            // Pddl.g:106:7: ( free_functionsDef )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==61) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==77) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // Pddl.g:106:7: free_functionsDef
                    {
                    pushFollow(FOLLOW_free_functionsDef_in_domain424);
                    free_functionsDef11=free_functionsDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());

                    }
                    break;

            }


            // Pddl.g:107:7: ( constraints )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==61) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==71) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // Pddl.g:107:7: constraints
                    {
                    pushFollow(FOLLOW_constraints_in_domain433);
                    constraints12=constraints();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());

                    }
                    break;

            }


            // Pddl.g:108:7: ( structureDef )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==61) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Pddl.g:108:7: structureDef
            	    {
            	    pushFollow(FOLLOW_structureDef_in_domain442);
            	    structureDef13=structureDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_structureDef.add(structureDef13.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            char_literal14=(Token)match(input,62,FOLLOW_62_in_domain451); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal14);


            // AST REWRITE
            // elements: functionsDef, constraints, typesDef, domainName, constantsDef, requireDef, free_functionsDef, predicatesDef, structureDef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 110:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
            {
                // Pddl.g:110:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DOMAIN, "DOMAIN")
                , root_1);

                adaptor.addChild(root_1, stream_domainName.nextTree());

                // Pddl.g:110:30: ( requireDef )?
                if ( stream_requireDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_requireDef.nextTree());

                }
                stream_requireDef.reset();

                // Pddl.g:110:42: ( typesDef )?
                if ( stream_typesDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_typesDef.nextTree());

                }
                stream_typesDef.reset();

                // Pddl.g:111:17: ( constantsDef )?
                if ( stream_constantsDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_constantsDef.nextTree());

                }
                stream_constantsDef.reset();

                // Pddl.g:111:31: ( predicatesDef )?
                if ( stream_predicatesDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_predicatesDef.nextTree());

                }
                stream_predicatesDef.reset();

                // Pddl.g:111:46: ( functionsDef )?
                if ( stream_functionsDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionsDef.nextTree());

                }
                stream_functionsDef.reset();

                // Pddl.g:111:60: ( free_functionsDef )?
                if ( stream_free_functionsDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_free_functionsDef.nextTree());

                }
                stream_free_functionsDef.reset();

                // Pddl.g:112:17: ( constraints )?
                if ( stream_constraints.hasNext() ) {
                    adaptor.addChild(root_1, stream_constraints.nextTree());

                }
                stream_constraints.reset();

                // Pddl.g:112:30: ( structureDef )*
                while ( stream_structureDef.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "domain"


    public static class free_functionsDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "free_functionsDef"
    // Pddl.g:115:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
    public final PddlParser.free_functionsDef_return free_functionsDef() throws RecognitionException {
        PddlParser.free_functionsDef_return retval = new PddlParser.free_functionsDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal15=null;
        Token string_literal16=null;
        Token char_literal18=null;
        PddlParser.functionList_return functionList17 =null;


        Object char_literal15_tree=null;
        Object string_literal16_tree=null;
        Object char_literal18_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");
        try {
            // Pddl.g:116:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
            // Pddl.g:116:4: '(' ':free_functions' functionList ')'
            {
            char_literal15=(Token)match(input,61,FOLLOW_61_in_free_functionsDef535); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal15);


            string_literal16=(Token)match(input,77,FOLLOW_77_in_free_functionsDef537); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_77.add(string_literal16);


            pushFollow(FOLLOW_functionList_in_free_functionsDef539);
            functionList17=functionList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());

            char_literal18=(Token)match(input,62,FOLLOW_62_in_free_functionsDef541); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal18);


            // AST REWRITE
            // elements: functionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 117:2: -> ^( FREE_FUNCTIONS functionList )
            {
                // Pddl.g:117:5: ^( FREE_FUNCTIONS functionList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FREE_FUNCTIONS, "FREE_FUNCTIONS")
                , root_1);

                adaptor.addChild(root_1, stream_functionList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "free_functionsDef"


    public static class domainName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "domainName"
    // Pddl.g:120:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
    public final PddlParser.domainName_return domainName() throws RecognitionException {
        PddlParser.domainName_return retval = new PddlParser.domainName_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal19=null;
        Token string_literal20=null;
        Token NAME21=null;
        Token char_literal22=null;

        Object char_literal19_tree=null;
        Object string_literal20_tree=null;
        Object NAME21_tree=null;
        Object char_literal22_tree=null;
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // Pddl.g:121:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
            // Pddl.g:121:7: '(' 'domain' NAME ')'
            {
            char_literal19=(Token)match(input,61,FOLLOW_61_in_domainName564); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal19);


            string_literal20=(Token)match(input,104,FOLLOW_104_in_domainName566); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_104.add(string_literal20);


            NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName568); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME21);


            char_literal22=(Token)match(input,62,FOLLOW_62_in_domainName570); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal22);


            // AST REWRITE
            // elements: NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 122:6: -> ^( DOMAIN_NAME NAME )
            {
                // Pddl.g:122:9: ^( DOMAIN_NAME NAME )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DOMAIN_NAME, "DOMAIN_NAME")
                , root_1);

                adaptor.addChild(root_1, 
                stream_NAME.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "domainName"


    public static class requireDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "requireDef"
    // Pddl.g:125:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
    public final PddlParser.requireDef_return requireDef() throws RecognitionException {
        PddlParser.requireDef_return retval = new PddlParser.requireDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal23=null;
        Token string_literal24=null;
        Token REQUIRE_KEY25=null;
        Token char_literal26=null;

        Object char_literal23_tree=null;
        Object string_literal24_tree=null;
        Object REQUIRE_KEY25_tree=null;
        Object char_literal26_tree=null;
        RewriteRuleTokenStream stream_REQUIRE_KEY=new RewriteRuleTokenStream(adaptor,"token REQUIRE_KEY");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");

        try {
            // Pddl.g:126:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
            // Pddl.g:126:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
            {
            char_literal23=(Token)match(input,61,FOLLOW_61_in_requireDef597); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal23);


            string_literal24=(Token)match(input,87,FOLLOW_87_in_requireDef599); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(string_literal24);


            // Pddl.g:126:24: ( REQUIRE_KEY )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==REQUIRE_KEY) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Pddl.g:126:24: REQUIRE_KEY
            	    {
            	    REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef601); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_REQUIRE_KEY.add(REQUIRE_KEY25);


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            char_literal26=(Token)match(input,62,FOLLOW_62_in_requireDef604); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal26);


            // AST REWRITE
            // elements: REQUIRE_KEY
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 127:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
            {
                // Pddl.g:127:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(REQUIREMENTS, "REQUIREMENTS")
                , root_1);

                if ( !(stream_REQUIRE_KEY.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_REQUIRE_KEY.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_REQUIRE_KEY.nextNode()
                    );

                }
                stream_REQUIRE_KEY.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "requireDef"


    public static class typesDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typesDef"
    // Pddl.g:130:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
    public final PddlParser.typesDef_return typesDef() throws RecognitionException {
        PddlParser.typesDef_return retval = new PddlParser.typesDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal27=null;
        Token string_literal28=null;
        Token char_literal30=null;
        PddlParser.typedNameList_return typedNameList29 =null;


        Object char_literal27_tree=null;
        Object string_literal28_tree=null;
        Object char_literal30_tree=null;
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");
        try {
            // Pddl.g:131:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
            // Pddl.g:131:4: '(' ':types' typedNameList ')'
            {
            char_literal27=(Token)match(input,61,FOLLOW_61_in_typesDef625); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal27);


            string_literal28=(Token)match(input,88,FOLLOW_88_in_typesDef627); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_88.add(string_literal28);


            pushFollow(FOLLOW_typedNameList_in_typesDef629);
            typedNameList29=typedNameList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());

            char_literal30=(Token)match(input,62,FOLLOW_62_in_typesDef631); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal30);


            // AST REWRITE
            // elements: typedNameList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 132:4: -> ^( TYPES typedNameList )
            {
                // Pddl.g:132:7: ^( TYPES typedNameList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TYPES, "TYPES")
                , root_1);

                adaptor.addChild(root_1, stream_typedNameList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typesDef"


    public static class typedNameList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typedNameList"
    // Pddl.g:136:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
    public final PddlParser.typedNameList_return typedNameList() throws RecognitionException {
        PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME31=null;
        Token NAME33=null;
        PddlParser.singleTypeNameList_return singleTypeNameList32 =null;


        Object NAME31_tree=null;
        Object NAME33_tree=null;

        try {
            // Pddl.g:137:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
            // Pddl.g:137:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();


            // Pddl.g:137:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // Pddl.g:137:8: ( NAME )*
                    {
                    // Pddl.g:137:8: ( NAME )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==NAME) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Pddl.g:137:8: NAME
                    	    {
                    	    NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList658); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME31_tree = 
                    	    (Object)adaptor.create(NAME31)
                    	    ;
                    	    adaptor.addChild(root_0, NAME31_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Pddl.g:137:16: ( singleTypeNameList )+ ( NAME )*
                    {
                    // Pddl.g:137:16: ( singleTypeNameList )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        alt12 = dfa12.predict(input);
                        switch (alt12) {
                    	case 1 :
                    	    // Pddl.g:137:16: singleTypeNameList
                    	    {
                    	    pushFollow(FOLLOW_singleTypeNameList_in_typedNameList663);
                    	    singleTypeNameList32=singleTypeNameList();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeNameList32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    // Pddl.g:137:36: ( NAME )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==NAME) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // Pddl.g:137:36: NAME
                    	    {
                    	    NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList666); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NAME33_tree = 
                    	    (Object)adaptor.create(NAME33)
                    	    ;
                    	    adaptor.addChild(root_0, NAME33_tree);
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


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typedNameList"


    public static class singleTypeNameList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "singleTypeNameList"
    // Pddl.g:140:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
    public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
        PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME34=null;
        Token char_literal35=null;
        PddlParser.type_return t =null;


        Object NAME34_tree=null;
        Object char_literal35_tree=null;
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Pddl.g:141:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
            // Pddl.g:141:7: ( ( NAME )+ '-' t= type )
            {
            // Pddl.g:141:7: ( ( NAME )+ '-' t= type )
            // Pddl.g:141:8: ( NAME )+ '-' t= type
            {
            // Pddl.g:141:8: ( NAME )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==NAME) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Pddl.g:141:8: NAME
            	    {
            	    NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList686); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME34);


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            char_literal35=(Token)match(input,65,FOLLOW_65_in_singleTypeNameList689); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(char_literal35);


            pushFollow(FOLLOW_type_in_singleTypeNameList693);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(t.getTree());

            }


            // AST REWRITE
            // elements: NAME, t
            // token labels: 
            // rule labels: t, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 142:4: -> ( ^( NAME $t) )+
            {
                if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
                    // Pddl.g:142:7: ^( NAME $t)
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot(
                    stream_NAME.nextNode()
                    , root_1);

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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "singleTypeNameList"


    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // Pddl.g:145:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
    public final PddlParser.type_return type() throws RecognitionException {
        PddlParser.type_return retval = new PddlParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal36=null;
        Token string_literal37=null;
        Token char_literal39=null;
        PddlParser.primType_return primType38 =null;

        PddlParser.primType_return primType40 =null;


        Object char_literal36_tree=null;
        Object string_literal37_tree=null;
        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");
        try {
            // Pddl.g:146:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==61) ) {
                alt17=1;
            }
            else if ( (LA17_0==NAME) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // Pddl.g:146:4: ( '(' 'either' ( primType )+ ')' )
                    {
                    // Pddl.g:146:4: ( '(' 'either' ( primType )+ ')' )
                    // Pddl.g:146:6: '(' 'either' ( primType )+ ')'
                    {
                    char_literal36=(Token)match(input,61,FOLLOW_61_in_type720); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal36);


                    string_literal37=(Token)match(input,105,FOLLOW_105_in_type722); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_105.add(string_literal37);


                    // Pddl.g:146:19: ( primType )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==NAME) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Pddl.g:146:19: primType
                    	    {
                    	    pushFollow(FOLLOW_primType_in_type724);
                    	    primType38=primType();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_primType.add(primType38.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    char_literal39=(Token)match(input,62,FOLLOW_62_in_type727); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal39);


                    }


                    // AST REWRITE
                    // elements: primType
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 147:4: -> ^( EITHER_TYPE ( primType )+ )
                    {
                        // Pddl.g:147:7: ^( EITHER_TYPE ( primType )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EITHER_TYPE, "EITHER_TYPE")
                        , root_1);

                        if ( !(stream_primType.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_primType.hasNext() ) {
                            adaptor.addChild(root_1, stream_primType.nextTree());

                        }
                        stream_primType.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                        adaptor.addChild(root_0, new String("debug"));

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:148:4: primType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_primType_in_type748);
                    primType40=primType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primType40.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class primType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "primType"
    // Pddl.g:151:1: primType : NAME ;
    public final PddlParser.primType_return primType() throws RecognitionException {
        PddlParser.primType_return retval = new PddlParser.primType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME41=null;

        Object NAME41_tree=null;

        try {
            // Pddl.g:151:10: ( NAME )
            // Pddl.g:151:12: NAME
            {
            root_0 = (Object)adaptor.nil();


            NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType758); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME41_tree = 
            (Object)adaptor.create(NAME41)
            ;
            adaptor.addChild(root_0, NAME41_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "primType"


    public static class functionsDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionsDef"
    // Pddl.g:153:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
    public final PddlParser.functionsDef_return functionsDef() throws RecognitionException {
        PddlParser.functionsDef_return retval = new PddlParser.functionsDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal42=null;
        Token string_literal43=null;
        Token char_literal45=null;
        PddlParser.functionList_return functionList44 =null;


        Object char_literal42_tree=null;
        Object string_literal43_tree=null;
        Object char_literal45_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");
        try {
            // Pddl.g:154:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
            // Pddl.g:154:4: '(' ':functions' functionList ')'
            {
            char_literal42=(Token)match(input,61,FOLLOW_61_in_functionsDef768); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal42);


            string_literal43=(Token)match(input,78,FOLLOW_78_in_functionsDef770); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_78.add(string_literal43);


            pushFollow(FOLLOW_functionList_in_functionsDef772);
            functionList44=functionList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());

            char_literal45=(Token)match(input,62,FOLLOW_62_in_functionsDef774); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal45);


            // AST REWRITE
            // elements: functionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 155:2: -> ^( FUNCTIONS functionList )
            {
                // Pddl.g:155:5: ^( FUNCTIONS functionList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FUNCTIONS, "FUNCTIONS")
                , root_1);

                adaptor.addChild(root_1, stream_functionList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionsDef"


    public static class functionList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionList"
    // Pddl.g:158:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
    public final PddlParser.functionList_return functionList() throws RecognitionException {
        PddlParser.functionList_return retval = new PddlParser.functionList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal47=null;
        PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton46 =null;

        PddlParser.functionType_return functionType48 =null;


        Object char_literal47_tree=null;

        try {
            // Pddl.g:159:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
            // Pddl.g:159:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
            {
            root_0 = (Object)adaptor.nil();


            // Pddl.g:159:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==61) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Pddl.g:159:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
            	    {
            	    // Pddl.g:159:5: ( atomicFunctionSkeleton )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==61) ) {
            	            int LA18_2 = input.LA(2);

            	            if ( (synpred18_Pddl()) ) {
            	                alt18=1;
            	            }


            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // Pddl.g:159:5: atomicFunctionSkeleton
            	    	    {
            	    	    pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList795);
            	    	    atomicFunctionSkeleton46=atomicFunctionSkeleton();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicFunctionSkeleton46.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt18 >= 1 ) break loop18;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);


            	    // Pddl.g:159:29: ( '-' functionType )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==65) ) {
            	        alt19=1;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // Pddl.g:159:30: '-' functionType
            	            {
            	            char_literal47=(Token)match(input,65,FOLLOW_65_in_functionList799); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal47_tree = 
            	            (Object)adaptor.create(char_literal47)
            	            ;
            	            adaptor.addChild(root_0, char_literal47_tree);
            	            }

            	            pushFollow(FOLLOW_functionType_in_functionList801);
            	            functionType48=functionType();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionType48.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionList"


    public static class atomicFunctionSkeleton_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atomicFunctionSkeleton"
    // Pddl.g:162:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
    public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws RecognitionException {
        PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal49=null;
        Token char_literal52=null;
        PddlParser.functionSymbol_return functionSymbol50 =null;

        PddlParser.typedVariableList_return typedVariableList51 =null;


        Object char_literal49_tree=null;
        Object char_literal52_tree=null;

        try {
            // Pddl.g:163:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
            // Pddl.g:163:4: '(' ! functionSymbol ^ typedVariableList ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal49=(Token)match(input,61,FOLLOW_61_in_atomicFunctionSkeleton817); if (state.failed) return retval;

            pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton820);
            functionSymbol50=functionSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);

            pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton823);
            typedVariableList51=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

            char_literal52=(Token)match(input,62,FOLLOW_62_in_atomicFunctionSkeleton825); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicFunctionSkeleton"


    public static class functionSymbol_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionSymbol"
    // Pddl.g:166:1: functionSymbol : ( NAME | '#t' );
    public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
        PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set53=null;

        Object set53_tree=null;

        try {
            // Pddl.g:166:16: ( NAME | '#t' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set53=(Token)input.LT(1);

            if ( input.LA(1)==NAME||input.LA(1)==60 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set53)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionSymbol"


    public static class functionType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionType"
    // Pddl.g:168:1: functionType : 'number' ;
    public final PddlParser.functionType_return functionType() throws RecognitionException {
        PddlParser.functionType_return retval = new PddlParser.functionType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal54=null;

        Object string_literal54_tree=null;

        try {
            // Pddl.g:168:14: ( 'number' )
            // Pddl.g:168:16: 'number'
            {
            root_0 = (Object)adaptor.nil();


            string_literal54=(Token)match(input,117,FOLLOW_117_in_functionType848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal54_tree = 
            (Object)adaptor.create(string_literal54)
            ;
            adaptor.addChild(root_0, string_literal54_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionType"


    public static class constantsDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constantsDef"
    // Pddl.g:170:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
    public final PddlParser.constantsDef_return constantsDef() throws RecognitionException {
        PddlParser.constantsDef_return retval = new PddlParser.constantsDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal55=null;
        Token string_literal56=null;
        Token char_literal58=null;
        PddlParser.typedNameList_return typedNameList57 =null;


        Object char_literal55_tree=null;
        Object string_literal56_tree=null;
        Object char_literal58_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");
        try {
            // Pddl.g:171:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
            // Pddl.g:171:4: '(' ':constants' typedNameList ')'
            {
            char_literal55=(Token)match(input,61,FOLLOW_61_in_constantsDef859); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal55);


            string_literal56=(Token)match(input,69,FOLLOW_69_in_constantsDef861); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal56);


            pushFollow(FOLLOW_typedNameList_in_constantsDef863);
            typedNameList57=typedNameList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());

            char_literal58=(Token)match(input,62,FOLLOW_62_in_constantsDef865); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal58);


            // AST REWRITE
            // elements: typedNameList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 172:2: -> ^( CONSTANTS typedNameList )
            {
                // Pddl.g:172:5: ^( CONSTANTS typedNameList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONSTANTS, "CONSTANTS")
                , root_1);

                adaptor.addChild(root_1, stream_typedNameList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constantsDef"


    public static class predicatesDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "predicatesDef"
    // Pddl.g:175:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
    public final PddlParser.predicatesDef_return predicatesDef() throws RecognitionException {
        PddlParser.predicatesDef_return retval = new PddlParser.predicatesDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal59=null;
        Token string_literal60=null;
        Token char_literal62=null;
        PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton61 =null;


        Object char_literal59_tree=null;
        Object string_literal60_tree=null;
        Object char_literal62_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");
        try {
            // Pddl.g:176:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
            // Pddl.g:176:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
            {
            char_literal59=(Token)match(input,61,FOLLOW_61_in_predicatesDef885); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal59);


            string_literal60=(Token)match(input,85,FOLLOW_85_in_predicatesDef887); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(string_literal60);


            // Pddl.g:176:22: ( atomicFormulaSkeleton )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==61) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Pddl.g:176:22: atomicFormulaSkeleton
            	    {
            	    pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef889);
            	    atomicFormulaSkeleton61=atomicFormulaSkeleton();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_atomicFormulaSkeleton.add(atomicFormulaSkeleton61.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            char_literal62=(Token)match(input,62,FOLLOW_62_in_predicatesDef892); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal62);


            // AST REWRITE
            // elements: atomicFormulaSkeleton
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 177:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
            {
                // Pddl.g:177:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PREDICATES, "PREDICATES")
                , root_1);

                if ( !(stream_atomicFormulaSkeleton.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_atomicFormulaSkeleton.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicatesDef"


    public static class atomicFormulaSkeleton_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atomicFormulaSkeleton"
    // Pddl.g:180:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
    public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws RecognitionException {
        PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal63=null;
        Token char_literal66=null;
        PddlParser.predicate_return predicate64 =null;

        PddlParser.typedVariableList_return typedVariableList65 =null;


        Object char_literal63_tree=null;
        Object char_literal66_tree=null;

        try {
            // Pddl.g:181:2: ( '(' ! predicate ^ typedVariableList ')' !)
            // Pddl.g:181:4: '(' ! predicate ^ typedVariableList ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal63=(Token)match(input,61,FOLLOW_61_in_atomicFormulaSkeleton913); if (state.failed) return retval;

            pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton916);
            predicate64=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);

            pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton919);
            typedVariableList65=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

            char_literal66=(Token)match(input,62,FOLLOW_62_in_atomicFormulaSkeleton921); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicFormulaSkeleton"


    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "predicate"
    // Pddl.g:184:1: predicate : NAME ;
    public final PddlParser.predicate_return predicate() throws RecognitionException {
        PddlParser.predicate_return retval = new PddlParser.predicate_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME67=null;

        Object NAME67_tree=null;

        try {
            // Pddl.g:184:11: ( NAME )
            // Pddl.g:184:13: NAME
            {
            root_0 = (Object)adaptor.nil();


            NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate932); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME67_tree = 
            (Object)adaptor.create(NAME67)
            ;
            adaptor.addChild(root_0, NAME67_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicate"


    public static class typedVariableList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typedVariableList"
    // Pddl.g:187:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
    public final PddlParser.typedVariableList_return typedVariableList() throws RecognitionException {
        PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VARIABLE68=null;
        Token VARIABLE70=null;
        PddlParser.singleTypeVarList_return singleTypeVarList69 =null;


        Object VARIABLE68_tree=null;
        Object VARIABLE70_tree=null;

        try {
            // Pddl.g:188:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
            // Pddl.g:188:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
            {
            root_0 = (Object)adaptor.nil();


            // Pddl.g:188:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // Pddl.g:188:8: ( VARIABLE )*
                    {
                    // Pddl.g:188:8: ( VARIABLE )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==VARIABLE) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // Pddl.g:188:8: VARIABLE
                    	    {
                    	    VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList947); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    VARIABLE68_tree = 
                    	    (Object)adaptor.create(VARIABLE68)
                    	    ;
                    	    adaptor.addChild(root_0, VARIABLE68_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Pddl.g:188:20: ( singleTypeVarList )+ ( VARIABLE )*
                    {
                    // Pddl.g:188:20: ( singleTypeVarList )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // Pddl.g:188:20: singleTypeVarList
                    	    {
                    	    pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList952);
                    	    singleTypeVarList69=singleTypeVarList();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeVarList69.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    // Pddl.g:188:39: ( VARIABLE )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==VARIABLE) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // Pddl.g:188:39: VARIABLE
                    	    {
                    	    VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList955); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    VARIABLE70_tree = 
                    	    (Object)adaptor.create(VARIABLE70)
                    	    ;
                    	    adaptor.addChild(root_0, VARIABLE70_tree);
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


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typedVariableList"


    public static class singleTypeVarList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "singleTypeVarList"
    // Pddl.g:191:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
    public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
        PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VARIABLE71=null;
        Token char_literal72=null;
        PddlParser.type_return t =null;


        Object VARIABLE71_tree=null;
        Object char_literal72_tree=null;
        RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // Pddl.g:192:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
            // Pddl.g:192:7: ( ( VARIABLE )+ '-' t= type )
            {
            // Pddl.g:192:7: ( ( VARIABLE )+ '-' t= type )
            // Pddl.g:192:8: ( VARIABLE )+ '-' t= type
            {
            // Pddl.g:192:8: ( VARIABLE )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==VARIABLE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // Pddl.g:192:8: VARIABLE
            	    {
            	    VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList975); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE71);


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            char_literal72=(Token)match(input,65,FOLLOW_65_in_singleTypeVarList978); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(char_literal72);


            pushFollow(FOLLOW_type_in_singleTypeVarList982);
            t=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(t.getTree());

            }


            // AST REWRITE
            // elements: t, VARIABLE
            // token labels: 
            // rule labels: t, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 193:7: -> ( ^( VARIABLE $t) )+
            {
                if ( !(stream_t.hasNext()||stream_VARIABLE.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_t.hasNext()||stream_VARIABLE.hasNext() ) {
                    // Pddl.g:193:10: ^( VARIABLE $t)
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot(
                    stream_VARIABLE.nextNode()
                    , root_1);

                    adaptor.addChild(root_1, stream_t.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_t.reset();
                stream_VARIABLE.reset();

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "singleTypeVarList"


    public static class constraints_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraints"
    // Pddl.g:196:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
    public final PddlParser.constraints_return constraints() throws RecognitionException {
        PddlParser.constraints_return retval = new PddlParser.constraints_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal73=null;
        Token string_literal74=null;
        Token char_literal76=null;
        PddlParser.conGD_return conGD75 =null;


        Object char_literal73_tree=null;
        Object string_literal74_tree=null;
        Object char_literal76_tree=null;

        try {
            // Pddl.g:197:2: ( '(' ! ':constraints' ^ conGD ')' !)
            // Pddl.g:197:4: '(' ! ':constraints' ^ conGD ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal73=(Token)match(input,61,FOLLOW_61_in_constraints1013); if (state.failed) return retval;

            string_literal74=(Token)match(input,71,FOLLOW_71_in_constraints1016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal74_tree = 
            (Object)adaptor.create(string_literal74)
            ;
            root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
            }

            pushFollow(FOLLOW_conGD_in_constraints1019);
            conGD75=conGD();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

            char_literal76=(Token)match(input,62,FOLLOW_62_in_constraints1021); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraints"


    public static class structureDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "structureDef"
    // Pddl.g:200:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef );
    public final PddlParser.structureDef_return structureDef() throws RecognitionException {
        PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.actionDef_return actionDef77 =null;

        PddlParser.durativeActionDef_return durativeActionDef78 =null;

        PddlParser.derivedDef_return derivedDef79 =null;

        PddlParser.constraintDef_return constraintDef80 =null;

        PddlParser.processDef_return processDef81 =null;



        try {
            // Pddl.g:201:2: ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef )
            int alt27=5;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==61) ) {
                switch ( input.LA(2) ) {
                case 67:
                    {
                    alt27=1;
                    }
                    break;
                case 75:
                    {
                    alt27=2;
                    }
                    break;
                case 72:
                    {
                    alt27=3;
                    }
                    break;
                case 70:
                    {
                    alt27=4;
                    }
                    break;
                case 86:
                    {
                    alt27=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // Pddl.g:201:4: actionDef
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_actionDef_in_structureDef1033);
                    actionDef77=actionDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:202:4: durativeActionDef
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_durativeActionDef_in_structureDef1038);
                    durativeActionDef78=durativeActionDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

                    }
                    break;
                case 3 :
                    // Pddl.g:203:4: derivedDef
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_derivedDef_in_structureDef1043);
                    derivedDef79=derivedDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

                    }
                    break;
                case 4 :
                    // Pddl.g:204:4: constraintDef
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_constraintDef_in_structureDef1048);
                    constraintDef80=constraintDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

                    }
                    break;
                case 5 :
                    // Pddl.g:205:4: processDef
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_processDef_in_structureDef1053);
                    processDef81=processDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, processDef81.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "structureDef"


    public static class actionDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actionDef"
    // Pddl.g:211:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
    public final PddlParser.actionDef_return actionDef() throws RecognitionException {
        PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal82=null;
        Token string_literal83=null;
        Token string_literal85=null;
        Token char_literal86=null;
        Token char_literal88=null;
        Token char_literal90=null;
        PddlParser.actionSymbol_return actionSymbol84 =null;

        PddlParser.typedVariableList_return typedVariableList87 =null;

        PddlParser.actionDefBody_return actionDefBody89 =null;


        Object char_literal82_tree=null;
        Object string_literal83_tree=null;
        Object string_literal85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal88_tree=null;
        Object char_literal90_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
        RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
        try {
            // Pddl.g:212:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
            // Pddl.g:212:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
            {
            char_literal82=(Token)match(input,61,FOLLOW_61_in_actionDef1068); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal82);


            string_literal83=(Token)match(input,67,FOLLOW_67_in_actionDef1070); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_67.add(string_literal83);


            pushFollow(FOLLOW_actionSymbol_in_actionDef1072);
            actionSymbol84=actionSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol84.getTree());

            string_literal85=(Token)match(input,83,FOLLOW_83_in_actionDef1081); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal85);


            char_literal86=(Token)match(input,61,FOLLOW_61_in_actionDef1084); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal86);


            pushFollow(FOLLOW_typedVariableList_in_actionDef1086);
            typedVariableList87=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList87.getTree());

            char_literal88=(Token)match(input,62,FOLLOW_62_in_actionDef1088); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal88);


            pushFollow(FOLLOW_actionDefBody_in_actionDef1101);
            actionDefBody89=actionDefBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody89.getTree());

            char_literal90=(Token)match(input,62,FOLLOW_62_in_actionDef1103); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal90);


            // AST REWRITE
            // elements: actionSymbol, actionDefBody, typedVariableList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 215:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
            {
                // Pddl.g:215:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ACTION, "ACTION")
                , root_1);

                adaptor.addChild(root_1, stream_actionSymbol.nextTree());

                // Pddl.g:215:33: ( typedVariableList )?
                if ( stream_typedVariableList.hasNext() ) {
                    adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                }
                stream_typedVariableList.reset();

                adaptor.addChild(root_1, stream_actionDefBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionDef"


    public static class processDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "processDef"
    // Pddl.g:217:1: processDef : '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) ;
    public final PddlParser.processDef_return processDef() throws RecognitionException {
        PddlParser.processDef_return retval = new PddlParser.processDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal91=null;
        Token string_literal92=null;
        Token string_literal94=null;
        Token char_literal95=null;
        Token char_literal97=null;
        Token char_literal99=null;
        PddlParser.actionSymbol_return actionSymbol93 =null;

        PddlParser.typedVariableList_return typedVariableList96 =null;

        PddlParser.actionDefBody_return actionDefBody98 =null;


        Object char_literal91_tree=null;
        Object string_literal92_tree=null;
        Object string_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
        RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
        try {
            // Pddl.g:218:2: ( '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) )
            // Pddl.g:218:4: '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
            {
            char_literal91=(Token)match(input,61,FOLLOW_61_in_processDef1136); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal91);


            string_literal92=(Token)match(input,86,FOLLOW_86_in_processDef1138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(string_literal92);


            pushFollow(FOLLOW_actionSymbol_in_processDef1140);
            actionSymbol93=actionSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol93.getTree());

            string_literal94=(Token)match(input,83,FOLLOW_83_in_processDef1149); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal94);


            char_literal95=(Token)match(input,61,FOLLOW_61_in_processDef1152); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal95);


            pushFollow(FOLLOW_typedVariableList_in_processDef1154);
            typedVariableList96=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList96.getTree());

            char_literal97=(Token)match(input,62,FOLLOW_62_in_processDef1156); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal97);


            pushFollow(FOLLOW_actionDefBody_in_processDef1169);
            actionDefBody98=actionDefBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody98.getTree());

            char_literal99=(Token)match(input,62,FOLLOW_62_in_processDef1171); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal99);


            // AST REWRITE
            // elements: actionSymbol, typedVariableList, actionDefBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 221:8: -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
            {
                // Pddl.g:221:11: ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROCESS, "PROCESS")
                , root_1);

                adaptor.addChild(root_1, stream_actionSymbol.nextTree());

                // Pddl.g:221:34: ( typedVariableList )?
                if ( stream_typedVariableList.hasNext() ) {
                    adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                }
                stream_typedVariableList.reset();

                adaptor.addChild(root_1, stream_actionDefBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "processDef"


    public static class constraintDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraintDef"
    // Pddl.g:224:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
    public final PddlParser.constraintDef_return constraintDef() throws RecognitionException {
        PddlParser.constraintDef_return retval = new PddlParser.constraintDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal100=null;
        Token string_literal101=null;
        Token string_literal103=null;
        Token char_literal104=null;
        Token char_literal106=null;
        Token char_literal108=null;
        PddlParser.constraintSymbol_return constraintSymbol102 =null;

        PddlParser.typedVariableList_return typedVariableList105 =null;

        PddlParser.constraintDefBody_return constraintDefBody107 =null;


        Object char_literal100_tree=null;
        Object string_literal101_tree=null;
        Object string_literal103_tree=null;
        Object char_literal104_tree=null;
        Object char_literal106_tree=null;
        Object char_literal108_tree=null;
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
        RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");
        try {
            // Pddl.g:225:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
            // Pddl.g:225:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
            {
            char_literal100=(Token)match(input,61,FOLLOW_61_in_constraintDef1205); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal100);


            string_literal101=(Token)match(input,70,FOLLOW_70_in_constraintDef1207); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_70.add(string_literal101);


            pushFollow(FOLLOW_constraintSymbol_in_constraintDef1209);
            constraintSymbol102=constraintSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol102.getTree());

            string_literal103=(Token)match(input,83,FOLLOW_83_in_constraintDef1218); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal103);


            char_literal104=(Token)match(input,61,FOLLOW_61_in_constraintDef1221); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal104);


            pushFollow(FOLLOW_typedVariableList_in_constraintDef1223);
            typedVariableList105=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList105.getTree());

            char_literal106=(Token)match(input,62,FOLLOW_62_in_constraintDef1225); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal106);


            pushFollow(FOLLOW_constraintDefBody_in_constraintDef1238);
            constraintDefBody107=constraintDefBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody107.getTree());

            char_literal108=(Token)match(input,62,FOLLOW_62_in_constraintDef1240); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal108);


            // AST REWRITE
            // elements: constraintDefBody, typedVariableList, constraintSymbol
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 228:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
            {
                // Pddl.g:228:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT")
                , root_1);

                adaptor.addChild(root_1, stream_constraintSymbol.nextTree());

                // Pddl.g:228:48: ( typedVariableList )?
                if ( stream_typedVariableList.hasNext() ) {
                    adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                }
                stream_typedVariableList.reset();

                adaptor.addChild(root_1, stream_constraintDefBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraintDef"


    public static class actionSymbol_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actionSymbol"
    // Pddl.g:232:1: actionSymbol : NAME ;
    public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
        PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME109=null;

        Object NAME109_tree=null;

        try {
            // Pddl.g:232:14: ( NAME )
            // Pddl.g:232:16: NAME
            {
            root_0 = (Object)adaptor.nil();


            NAME109=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME109_tree = 
            (Object)adaptor.create(NAME109)
            ;
            adaptor.addChild(root_0, NAME109_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionSymbol"


    public static class constraintSymbol_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraintSymbol"
    // Pddl.g:234:1: constraintSymbol : NAME ;
    public final PddlParser.constraintSymbol_return constraintSymbol() throws RecognitionException {
        PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NAME110=null;

        Object NAME110_tree=null;

        try {
            // Pddl.g:234:18: ( NAME )
            // Pddl.g:234:20: NAME
            {
            root_0 = (Object)adaptor.nil();


            NAME110=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1283); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME110_tree = 
            (Object)adaptor.create(NAME110)
            ;
            adaptor.addChild(root_0, NAME110_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraintSymbol"


    public static class actionDefBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actionDefBody"
    // Pddl.g:239:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
    public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
        PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        Token string_literal115=null;
        Token char_literal116=null;
        Token char_literal117=null;
        PddlParser.goalDesc_return goalDesc114 =null;

        PddlParser.effect_return effect118 =null;


        Object string_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;
        Object string_literal115_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
        RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
        try {
            // Pddl.g:240:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
            // Pddl.g:240:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
            {
            // Pddl.g:240:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==84) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Pddl.g:240:6: ':precondition' ( ( '(' ')' ) | goalDesc )
                    {
                    string_literal111=(Token)match(input,84,FOLLOW_84_in_actionDefBody1298); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_84.add(string_literal111);


                    // Pddl.g:240:22: ( ( '(' ')' ) | goalDesc )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==61) ) {
                        int LA28_1 = input.LA(2);

                        if ( (LA28_1==62) ) {
                            alt28=1;
                        }
                        else if ( (LA28_1==NAME||(LA28_1 >= 89 && LA28_1 <= 93)||LA28_1==98||(LA28_1 >= 107 && LA28_1 <= 108)||LA28_1==111||LA28_1==116||LA28_1==118) ) {
                            alt28=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;

                    }
                    switch (alt28) {
                        case 1 :
                            // Pddl.g:240:23: ( '(' ')' )
                            {
                            // Pddl.g:240:23: ( '(' ')' )
                            // Pddl.g:240:24: '(' ')'
                            {
                            char_literal112=(Token)match(input,61,FOLLOW_61_in_actionDefBody1302); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_61.add(char_literal112);


                            char_literal113=(Token)match(input,62,FOLLOW_62_in_actionDefBody1304); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_62.add(char_literal113);


                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:240:35: goalDesc
                            {
                            pushFollow(FOLLOW_goalDesc_in_actionDefBody1309);
                            goalDesc114=goalDesc();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc114.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // Pddl.g:241:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==76) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Pddl.g:241:6: ':effect' ( ( '(' ')' ) | effect )
                    {
                    string_literal115=(Token)match(input,76,FOLLOW_76_in_actionDefBody1319); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_76.add(string_literal115);


                    // Pddl.g:241:16: ( ( '(' ')' ) | effect )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==61) ) {
                        int LA30_1 = input.LA(2);

                        if ( (LA30_1==62) ) {
                            alt30=1;
                        }
                        else if ( (LA30_1==NAME||(LA30_1 >= 98 && LA30_1 <= 99)||LA30_1==102||LA30_1==108||LA30_1==112||LA30_1==116||(LA30_1 >= 122 && LA30_1 <= 123)||LA30_1==128) ) {
                            alt30=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;

                    }
                    switch (alt30) {
                        case 1 :
                            // Pddl.g:241:17: ( '(' ')' )
                            {
                            // Pddl.g:241:17: ( '(' ')' )
                            // Pddl.g:241:18: '(' ')'
                            {
                            char_literal116=(Token)match(input,61,FOLLOW_61_in_actionDefBody1323); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_61.add(char_literal116);


                            char_literal117=(Token)match(input,62,FOLLOW_62_in_actionDefBody1325); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_62.add(char_literal117);


                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:241:29: effect
                            {
                            pushFollow(FOLLOW_effect_in_actionDefBody1330);
                            effect118=effect();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_effect.add(effect118.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // AST REWRITE
            // elements: goalDesc, effect
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 242:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
            {
                // Pddl.g:242:7: ^( PRECONDITION ( goalDesc )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PRECONDITION, "PRECONDITION")
                , root_1);

                // Pddl.g:242:22: ( goalDesc )?
                if ( stream_goalDesc.hasNext() ) {
                    adaptor.addChild(root_1, stream_goalDesc.nextTree());

                }
                stream_goalDesc.reset();

                adaptor.addChild(root_0, root_1);
                }

                // Pddl.g:242:33: ^( EFFECT ( effect )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EFFECT, "EFFECT")
                , root_1);

                // Pddl.g:242:42: ( effect )?
                if ( stream_effect.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionDefBody"


    public static class constraintDefBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constraintDefBody"
    // Pddl.g:245:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
    public final PddlParser.constraintDefBody_return constraintDefBody() throws RecognitionException {
        PddlParser.constraintDefBody_return retval = new PddlParser.constraintDefBody_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal119=null;
        Token char_literal120=null;
        Token char_literal121=null;
        PddlParser.goalDesc_return goalDesc122 =null;


        Object string_literal119_tree=null;
        Object char_literal120_tree=null;
        Object char_literal121_tree=null;
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
        try {
            // Pddl.g:246:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
            // Pddl.g:246:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
            {
            // Pddl.g:246:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==68) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Pddl.g:246:6: ':condition' ( ( '(' ')' ) | goalDesc )
                    {
                    string_literal119=(Token)match(input,68,FOLLOW_68_in_constraintDefBody1365); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_68.add(string_literal119);


                    // Pddl.g:246:19: ( ( '(' ')' ) | goalDesc )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==61) ) {
                        int LA32_1 = input.LA(2);

                        if ( (LA32_1==62) ) {
                            alt32=1;
                        }
                        else if ( (LA32_1==NAME||(LA32_1 >= 89 && LA32_1 <= 93)||LA32_1==98||(LA32_1 >= 107 && LA32_1 <= 108)||LA32_1==111||LA32_1==116||LA32_1==118) ) {
                            alt32=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 32, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;

                    }
                    switch (alt32) {
                        case 1 :
                            // Pddl.g:246:20: ( '(' ')' )
                            {
                            // Pddl.g:246:20: ( '(' ')' )
                            // Pddl.g:246:21: '(' ')'
                            {
                            char_literal120=(Token)match(input,61,FOLLOW_61_in_constraintDefBody1369); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_61.add(char_literal120);


                            char_literal121=(Token)match(input,62,FOLLOW_62_in_constraintDefBody1371); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_62.add(char_literal121);


                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:246:32: goalDesc
                            {
                            pushFollow(FOLLOW_goalDesc_in_constraintDefBody1376);
                            goalDesc122=goalDesc();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc122.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // AST REWRITE
            // elements: goalDesc
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:4: -> ^( PRECONDITION ( goalDesc )? )
            {
                // Pddl.g:247:7: ^( PRECONDITION ( goalDesc )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PRECONDITION, "PRECONDITION")
                , root_1);

                // Pddl.g:247:22: ( goalDesc )?
                if ( stream_goalDesc.hasNext() ) {
                    adaptor.addChild(root_1, stream_goalDesc.nextTree());

                }
                stream_goalDesc.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraintDefBody"


    public static class goalDesc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "goalDesc"
    // Pddl.g:262:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
    public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
        PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal124=null;
        Token string_literal125=null;
        Token char_literal127=null;
        Token char_literal128=null;
        Token string_literal129=null;
        Token char_literal131=null;
        Token char_literal132=null;
        Token string_literal133=null;
        Token char_literal135=null;
        Token char_literal136=null;
        Token string_literal137=null;
        Token char_literal140=null;
        Token char_literal141=null;
        Token string_literal142=null;
        Token char_literal143=null;
        Token char_literal145=null;
        Token char_literal147=null;
        Token char_literal148=null;
        Token string_literal149=null;
        Token char_literal150=null;
        Token char_literal152=null;
        Token char_literal154=null;
        PddlParser.atomicTermFormula_return atomicTermFormula123 =null;

        PddlParser.goalDesc_return goalDesc126 =null;

        PddlParser.goalDesc_return goalDesc130 =null;

        PddlParser.goalDesc_return goalDesc134 =null;

        PddlParser.goalDesc_return goalDesc138 =null;

        PddlParser.goalDesc_return goalDesc139 =null;

        PddlParser.typedVariableList_return typedVariableList144 =null;

        PddlParser.goalDesc_return goalDesc146 =null;

        PddlParser.typedVariableList_return typedVariableList151 =null;

        PddlParser.goalDesc_return goalDesc153 =null;

        PddlParser.fComp_return fComp155 =null;

        PddlParser.equality_return equality156 =null;


        Object char_literal124_tree=null;
        Object string_literal125_tree=null;
        Object char_literal127_tree=null;
        Object char_literal128_tree=null;
        Object string_literal129_tree=null;
        Object char_literal131_tree=null;
        Object char_literal132_tree=null;
        Object string_literal133_tree=null;
        Object char_literal135_tree=null;
        Object char_literal136_tree=null;
        Object string_literal137_tree=null;
        Object char_literal140_tree=null;
        Object char_literal141_tree=null;
        Object string_literal142_tree=null;
        Object char_literal143_tree=null;
        Object char_literal145_tree=null;
        Object char_literal147_tree=null;
        Object char_literal148_tree=null;
        Object string_literal149_tree=null;
        Object char_literal150_tree=null;
        Object char_literal152_tree=null;
        Object char_literal154_tree=null;
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
        RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");
        try {
            // Pddl.g:263:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
            int alt36=9;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==61) ) {
                switch ( input.LA(2) ) {
                case 98:
                    {
                    alt36=2;
                    }
                    break;
                case 118:
                    {
                    alt36=3;
                    }
                    break;
                case 116:
                    {
                    alt36=4;
                    }
                    break;
                case 111:
                    {
                    alt36=5;
                    }
                    break;
                case 107:
                    {
                    alt36=6;
                    }
                    break;
                case 108:
                    {
                    alt36=7;
                    }
                    break;
                case 91:
                    {
                    switch ( input.LA(3) ) {
                    case NAME:
                        {
                        switch ( input.LA(4) ) {
                        case NAME:
                            {
                            int LA36_13 = input.LA(5);

                            if ( (LA36_13==62) ) {
                                int LA36_14 = input.LA(6);

                                if ( (synpred47_Pddl()) ) {
                                    alt36=8;
                                }
                                else if ( (true) ) {
                                    alt36=9;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 36, 14, input);

                                    throw nvae;

                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 36, 13, input);

                                throw nvae;

                            }
                            }
                            break;
                        case NUMBER:
                        case 60:
                        case 61:
                            {
                            alt36=8;
                            }
                            break;
                        case VARIABLE:
                            {
                            alt36=9;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 11, input);

                            throw nvae;

                        }

                        }
                        break;
                    case NUMBER:
                    case 60:
                    case 61:
                        {
                        alt36=8;
                        }
                        break;
                    case VARIABLE:
                        {
                        alt36=9;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 8, input);

                        throw nvae;

                    }

                    }
                    break;
                case NAME:
                    {
                    alt36=1;
                    }
                    break;
                case 89:
                case 90:
                case 92:
                case 93:
                    {
                    alt36=8;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // Pddl.g:263:4: atomicTermFormula
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1414);
                    atomicTermFormula123=atomicTermFormula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula123.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:264:4: '(' 'and' ( goalDesc )* ')'
                    {
                    char_literal124=(Token)match(input,61,FOLLOW_61_in_goalDesc1419); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal124);


                    string_literal125=(Token)match(input,98,FOLLOW_98_in_goalDesc1421); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(string_literal125);


                    // Pddl.g:264:14: ( goalDesc )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==61) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // Pddl.g:264:14: goalDesc
                    	    {
                    	    pushFollow(FOLLOW_goalDesc_in_goalDesc1423);
                    	    goalDesc126=goalDesc();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc126.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    char_literal127=(Token)match(input,62,FOLLOW_62_in_goalDesc1426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal127);


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 265:12: -> ^( AND_GD ( goalDesc )* )
                    {
                        // Pddl.g:265:15: ^( AND_GD ( goalDesc )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(AND_GD, "AND_GD")
                        , root_1);

                        // Pddl.g:265:24: ( goalDesc )*
                        while ( stream_goalDesc.hasNext() ) {
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
                case 3 :
                    // Pddl.g:266:4: '(' 'or' ( goalDesc )* ')'
                    {
                    char_literal128=(Token)match(input,61,FOLLOW_61_in_goalDesc1451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal128);


                    string_literal129=(Token)match(input,118,FOLLOW_118_in_goalDesc1453); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_118.add(string_literal129);


                    // Pddl.g:266:13: ( goalDesc )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==61) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // Pddl.g:266:13: goalDesc
                    	    {
                    	    pushFollow(FOLLOW_goalDesc_in_goalDesc1455);
                    	    goalDesc130=goalDesc();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc130.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    char_literal131=(Token)match(input,62,FOLLOW_62_in_goalDesc1458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal131);


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 267:12: -> ^( OR_GD ( goalDesc )* )
                    {
                        // Pddl.g:267:15: ^( OR_GD ( goalDesc )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(OR_GD, "OR_GD")
                        , root_1);

                        // Pddl.g:267:23: ( goalDesc )*
                        while ( stream_goalDesc.hasNext() ) {
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
                case 4 :
                    // Pddl.g:268:4: '(' 'not' goalDesc ')'
                    {
                    char_literal132=(Token)match(input,61,FOLLOW_61_in_goalDesc1483); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal132);


                    string_literal133=(Token)match(input,116,FOLLOW_116_in_goalDesc1485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_116.add(string_literal133);


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1487);
                    goalDesc134=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc134.getTree());

                    char_literal135=(Token)match(input,62,FOLLOW_62_in_goalDesc1489); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal135);


                    // AST REWRITE
                    // elements: goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 269:12: -> ^( NOT_GD goalDesc )
                    {
                        // Pddl.g:269:15: ^( NOT_GD goalDesc )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(NOT_GD, "NOT_GD")
                        , root_1);

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // Pddl.g:270:4: '(' 'imply' goalDesc goalDesc ')'
                    {
                    char_literal136=(Token)match(input,61,FOLLOW_61_in_goalDesc1513); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal136);


                    string_literal137=(Token)match(input,111,FOLLOW_111_in_goalDesc1515); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_111.add(string_literal137);


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1517);
                    goalDesc138=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc138.getTree());

                    pushFollow(FOLLOW_goalDesc_in_goalDesc1519);
                    goalDesc139=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc139.getTree());

                    char_literal140=(Token)match(input,62,FOLLOW_62_in_goalDesc1521); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal140);


                    // AST REWRITE
                    // elements: goalDesc, goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 271:12: -> ^( IMPLY_GD goalDesc goalDesc )
                    {
                        // Pddl.g:271:15: ^( IMPLY_GD goalDesc goalDesc )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(IMPLY_GD, "IMPLY_GD")
                        , root_1);

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 6 :
                    // Pddl.g:272:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
                    {
                    char_literal141=(Token)match(input,61,FOLLOW_61_in_goalDesc1547); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal141);


                    string_literal142=(Token)match(input,107,FOLLOW_107_in_goalDesc1549); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_107.add(string_literal142);


                    char_literal143=(Token)match(input,61,FOLLOW_61_in_goalDesc1551); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal143);


                    pushFollow(FOLLOW_typedVariableList_in_goalDesc1553);
                    typedVariableList144=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList144.getTree());

                    char_literal145=(Token)match(input,62,FOLLOW_62_in_goalDesc1555); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal145);


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1557);
                    goalDesc146=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc146.getTree());

                    char_literal147=(Token)match(input,62,FOLLOW_62_in_goalDesc1559); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal147);


                    // AST REWRITE
                    // elements: goalDesc, typedVariableList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 273:12: -> ^( EXISTS_GD typedVariableList goalDesc )
                    {
                        // Pddl.g:273:15: ^( EXISTS_GD typedVariableList goalDesc )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EXISTS_GD, "EXISTS_GD")
                        , root_1);

                        adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 7 :
                    // Pddl.g:274:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
                    {
                    char_literal148=(Token)match(input,61,FOLLOW_61_in_goalDesc1585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal148);


                    string_literal149=(Token)match(input,108,FOLLOW_108_in_goalDesc1587); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_108.add(string_literal149);


                    char_literal150=(Token)match(input,61,FOLLOW_61_in_goalDesc1589); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal150);


                    pushFollow(FOLLOW_typedVariableList_in_goalDesc1591);
                    typedVariableList151=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList151.getTree());

                    char_literal152=(Token)match(input,62,FOLLOW_62_in_goalDesc1593); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal152);


                    pushFollow(FOLLOW_goalDesc_in_goalDesc1595);
                    goalDesc153=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc153.getTree());

                    char_literal154=(Token)match(input,62,FOLLOW_62_in_goalDesc1597); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal154);


                    // AST REWRITE
                    // elements: goalDesc, typedVariableList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 275:12: -> ^( FORALL_GD typedVariableList goalDesc )
                    {
                        // Pddl.g:275:15: ^( FORALL_GD typedVariableList goalDesc )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FORALL_GD, "FORALL_GD")
                        , root_1);

                        adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 8 :
                    // Pddl.g:276:7: fComp
                    {
                    pushFollow(FOLLOW_fComp_in_goalDesc1626);
                    fComp155=fComp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fComp.add(fComp155.getTree());

                    // AST REWRITE
                    // elements: fComp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 277:15: -> ^( COMPARISON_GD fComp )
                    {
                        // Pddl.g:277:18: ^( COMPARISON_GD fComp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(COMPARISON_GD, "COMPARISON_GD")
                        , root_1);

                        adaptor.addChild(root_1, stream_fComp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 9 :
                    // Pddl.g:278:4: equality
                    {
                    pushFollow(FOLLOW_equality_in_goalDesc1653);
                    equality156=equality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_equality.add(equality156.getTree());

                    // AST REWRITE
                    // elements: equality
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 279:6: -> ^( EQUALITY_CON equality )
                    {
                        // Pddl.g:279:9: ^( EQUALITY_CON equality )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(EQUALITY_CON, "EQUALITY_CON")
                        , root_1);

                        adaptor.addChild(root_1, stream_equality.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "goalDesc"


    public static class equality_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "equality"
    // Pddl.g:282:1: equality : '(' ! '=' term term ')' !;
    public final PddlParser.equality_return equality() throws RecognitionException {
        PddlParser.equality_return retval = new PddlParser.equality_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal157=null;
        Token char_literal158=null;
        Token char_literal161=null;
        PddlParser.term_return term159 =null;

        PddlParser.term_return term160 =null;


        Object char_literal157_tree=null;
        Object char_literal158_tree=null;
        Object char_literal161_tree=null;

        try {
            // Pddl.g:283:2: ( '(' ! '=' term term ')' !)
            // Pddl.g:283:4: '(' ! '=' term term ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal157=(Token)match(input,61,FOLLOW_61_in_equality1681); if (state.failed) return retval;

            char_literal158=(Token)match(input,91,FOLLOW_91_in_equality1684); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal158_tree = 
            (Object)adaptor.create(char_literal158)
            ;
            adaptor.addChild(root_0, char_literal158_tree);
            }

            pushFollow(FOLLOW_term_in_equality1686);
            term159=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term159.getTree());

            pushFollow(FOLLOW_term_in_equality1688);
            term160=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term160.getTree());

            char_literal161=(Token)match(input,62,FOLLOW_62_in_equality1690); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "equality"


    public static class fComp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fComp"
    // Pddl.g:285:1: fComp : '(' ! binaryComp fExp fExp ')' !;
    public final PddlParser.fComp_return fComp() throws RecognitionException {
        PddlParser.fComp_return retval = new PddlParser.fComp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal162=null;
        Token char_literal166=null;
        PddlParser.binaryComp_return binaryComp163 =null;

        PddlParser.fExp_return fExp164 =null;

        PddlParser.fExp_return fExp165 =null;


        Object char_literal162_tree=null;
        Object char_literal166_tree=null;

        try {
            // Pddl.g:286:2: ( '(' ! binaryComp fExp fExp ')' !)
            // Pddl.g:286:4: '(' ! binaryComp fExp fExp ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal162=(Token)match(input,61,FOLLOW_61_in_fComp1701); if (state.failed) return retval;

            pushFollow(FOLLOW_binaryComp_in_fComp1704);
            binaryComp163=binaryComp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp163.getTree());

            pushFollow(FOLLOW_fExp_in_fComp1706);
            fExp164=fExp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp164.getTree());

            pushFollow(FOLLOW_fExp_in_fComp1708);
            fExp165=fExp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp165.getTree());

            char_literal166=(Token)match(input,62,FOLLOW_62_in_fComp1710); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fComp"


    public static class atomicTermFormula_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atomicTermFormula"
    // Pddl.g:289:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
    public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
        PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal167=null;
        Token char_literal170=null;
        PddlParser.predicate_return predicate168 =null;

        PddlParser.term_return term169 =null;


        Object char_literal167_tree=null;
        Object char_literal170_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        try {
            // Pddl.g:290:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
            // Pddl.g:290:4: '(' predicate ( term )* ')'
            {
            char_literal167=(Token)match(input,61,FOLLOW_61_in_atomicTermFormula1722); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal167);


            pushFollow(FOLLOW_predicate_in_atomicTermFormula1724);
            predicate168=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_predicate.add(predicate168.getTree());

            // Pddl.g:290:18: ( term )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==NAME||LA37_0==VARIABLE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Pddl.g:290:18: term
            	    {
            	    pushFollow(FOLLOW_term_in_atomicTermFormula1726);
            	    term169=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_term.add(term169.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            char_literal170=(Token)match(input,62,FOLLOW_62_in_atomicTermFormula1729); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal170);


            // AST REWRITE
            // elements: predicate, term
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 290:28: -> ^( PRED_HEAD predicate ( term )* )
            {
                // Pddl.g:290:31: ^( PRED_HEAD predicate ( term )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PRED_HEAD, "PRED_HEAD")
                , root_1);

                adaptor.addChild(root_1, stream_predicate.nextTree());

                // Pddl.g:290:53: ( term )*
                while ( stream_term.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicTermFormula"


    public static class term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // Pddl.g:293:1: term : ( NAME | VARIABLE );
    public final PddlParser.term_return term() throws RecognitionException {
        PddlParser.term_return retval = new PddlParser.term_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set171=null;

        Object set171_tree=null;

        try {
            // Pddl.g:293:6: ( NAME | VARIABLE )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set171=(Token)input.LT(1);

            if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set171)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"


    public static class durativeActionDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "durativeActionDef"
    // Pddl.g:297:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
    public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
        PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal172=null;
        Token string_literal173=null;
        Token string_literal175=null;
        Token char_literal176=null;
        Token char_literal178=null;
        Token char_literal180=null;
        PddlParser.actionSymbol_return actionSymbol174 =null;

        PddlParser.typedVariableList_return typedVariableList177 =null;

        PddlParser.daDefBody_return daDefBody179 =null;


        Object char_literal172_tree=null;
        Object string_literal173_tree=null;
        Object string_literal175_tree=null;
        Object char_literal176_tree=null;
        Object char_literal178_tree=null;
        Object char_literal180_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
        try {
            // Pddl.g:298:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
            // Pddl.g:298:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
            {
            char_literal172=(Token)match(input,61,FOLLOW_61_in_durativeActionDef1766); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal172);


            string_literal173=(Token)match(input,75,FOLLOW_75_in_durativeActionDef1768); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_75.add(string_literal173);


            pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1770);
            actionSymbol174=actionSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol174.getTree());

            string_literal175=(Token)match(input,83,FOLLOW_83_in_durativeActionDef1779); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_83.add(string_literal175);


            char_literal176=(Token)match(input,61,FOLLOW_61_in_durativeActionDef1782); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal176);


            // Pddl.g:299:27: ( typedVariableList )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==VARIABLE) ) {
                alt38=1;
            }
            else if ( (LA38_0==62) ) {
                int LA38_2 = input.LA(2);

                if ( (synpred50_Pddl()) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // Pddl.g:299:28: typedVariableList
                    {
                    pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1785);
                    typedVariableList177=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList177.getTree());

                    }
                    break;

            }


            char_literal178=(Token)match(input,62,FOLLOW_62_in_durativeActionDef1789); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal178);


            pushFollow(FOLLOW_daDefBody_in_durativeActionDef1802);
            daDefBody179=daDefBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody179.getTree());

            char_literal180=(Token)match(input,62,FOLLOW_62_in_durativeActionDef1804); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal180);


            // AST REWRITE
            // elements: actionSymbol, typedVariableList, daDefBody
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 301:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
            {
                // Pddl.g:301:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DURATIVE_ACTION, "DURATIVE_ACTION")
                , root_1);

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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durativeActionDef"


    public static class daDefBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "daDefBody"
    // Pddl.g:304:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
    public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
        PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal181=null;
        Token string_literal183=null;
        Token char_literal184=null;
        Token char_literal185=null;
        Token string_literal187=null;
        Token char_literal188=null;
        Token char_literal189=null;
        PddlParser.durationConstraint_return durationConstraint182 =null;

        PddlParser.daGD_return daGD186 =null;

        PddlParser.daEffect_return daEffect190 =null;


        Object string_literal181_tree=null;
        Object string_literal183_tree=null;
        Object char_literal184_tree=null;
        Object char_literal185_tree=null;
        Object string_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal189_tree=null;

        try {
            // Pddl.g:305:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt41=1;
                }
                break;
            case 68:
                {
                alt41=2;
                }
                break;
            case 76:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // Pddl.g:305:4: ':duration' durationConstraint
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal181=(Token)match(input,74,FOLLOW_74_in_daDefBody1837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal181_tree = 
                    (Object)adaptor.create(string_literal181)
                    ;
                    adaptor.addChild(root_0, string_literal181_tree);
                    }

                    pushFollow(FOLLOW_durationConstraint_in_daDefBody1839);
                    durationConstraint182=durationConstraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint182.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:306:4: ':condition' ( ( '(' ')' ) | daGD )
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal183=(Token)match(input,68,FOLLOW_68_in_daDefBody1844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal183_tree = 
                    (Object)adaptor.create(string_literal183)
                    ;
                    adaptor.addChild(root_0, string_literal183_tree);
                    }

                    // Pddl.g:306:17: ( ( '(' ')' ) | daGD )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==61) ) {
                        int LA39_1 = input.LA(2);

                        if ( (LA39_1==62) ) {
                            alt39=1;
                        }
                        else if ( (LA39_1==98||LA39_1==100||LA39_1==108||(LA39_1 >= 119 && LA39_1 <= 120)) ) {
                            alt39=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 39, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;

                    }
                    switch (alt39) {
                        case 1 :
                            // Pddl.g:306:18: ( '(' ')' )
                            {
                            // Pddl.g:306:18: ( '(' ')' )
                            // Pddl.g:306:19: '(' ')'
                            {
                            char_literal184=(Token)match(input,61,FOLLOW_61_in_daDefBody1848); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal184_tree = 
                            (Object)adaptor.create(char_literal184)
                            ;
                            adaptor.addChild(root_0, char_literal184_tree);
                            }

                            char_literal185=(Token)match(input,62,FOLLOW_62_in_daDefBody1850); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal185_tree = 
                            (Object)adaptor.create(char_literal185)
                            ;
                            adaptor.addChild(root_0, char_literal185_tree);
                            }

                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:306:30: daGD
                            {
                            pushFollow(FOLLOW_daGD_in_daDefBody1855);
                            daGD186=daGD();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD186.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // Pddl.g:307:7: ':effect' ( ( '(' ')' ) | daEffect )
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal187=(Token)match(input,76,FOLLOW_76_in_daDefBody1864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal187_tree = 
                    (Object)adaptor.create(string_literal187)
                    ;
                    adaptor.addChild(root_0, string_literal187_tree);
                    }

                    // Pddl.g:307:17: ( ( '(' ')' ) | daEffect )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==61) ) {
                        int LA40_1 = input.LA(2);

                        if ( (LA40_1==62) ) {
                            alt40=1;
                        }
                        else if ( ((LA40_1 >= 98 && LA40_1 <= 100)||LA40_1==102||LA40_1==108||LA40_1==112||(LA40_1 >= 122 && LA40_1 <= 123)||LA40_1==128) ) {
                            alt40=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;

                    }
                    switch (alt40) {
                        case 1 :
                            // Pddl.g:307:18: ( '(' ')' )
                            {
                            // Pddl.g:307:18: ( '(' ')' )
                            // Pddl.g:307:19: '(' ')'
                            {
                            char_literal188=(Token)match(input,61,FOLLOW_61_in_daDefBody1868); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal188_tree = 
                            (Object)adaptor.create(char_literal188)
                            ;
                            adaptor.addChild(root_0, char_literal188_tree);
                            }

                            char_literal189=(Token)match(input,62,FOLLOW_62_in_daDefBody1870); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal189_tree = 
                            (Object)adaptor.create(char_literal189)
                            ;
                            adaptor.addChild(root_0, char_literal189_tree);
                            }

                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:307:30: daEffect
                            {
                            pushFollow(FOLLOW_daEffect_in_daDefBody1875);
                            daEffect190=daEffect();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect190.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daDefBody"


    public static class daGD_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "daGD"
    // Pddl.g:310:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
    public final PddlParser.daGD_return daGD() throws RecognitionException {
        PddlParser.daGD_return retval = new PddlParser.daGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal192=null;
        Token string_literal193=null;
        Token char_literal195=null;
        Token char_literal196=null;
        Token string_literal197=null;
        Token char_literal198=null;
        Token char_literal200=null;
        Token char_literal202=null;
        PddlParser.prefTimedGD_return prefTimedGD191 =null;

        PddlParser.daGD_return daGD194 =null;

        PddlParser.typedVariableList_return typedVariableList199 =null;

        PddlParser.daGD_return daGD201 =null;


        Object char_literal192_tree=null;
        Object string_literal193_tree=null;
        Object char_literal195_tree=null;
        Object char_literal196_tree=null;
        Object string_literal197_tree=null;
        Object char_literal198_tree=null;
        Object char_literal200_tree=null;
        Object char_literal202_tree=null;

        try {
            // Pddl.g:311:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==61) ) {
                switch ( input.LA(2) ) {
                case 100:
                case 119:
                case 120:
                    {
                    alt43=1;
                    }
                    break;
                case 98:
                    {
                    alt43=2;
                    }
                    break;
                case 108:
                    {
                    alt43=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // Pddl.g:311:4: prefTimedGD
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_prefTimedGD_in_daGD1890);
                    prefTimedGD191=prefTimedGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD191.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:312:4: '(' 'and' ( daGD )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal192=(Token)match(input,61,FOLLOW_61_in_daGD1895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal192_tree = 
                    (Object)adaptor.create(char_literal192)
                    ;
                    adaptor.addChild(root_0, char_literal192_tree);
                    }

                    string_literal193=(Token)match(input,98,FOLLOW_98_in_daGD1897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal193_tree = 
                    (Object)adaptor.create(string_literal193)
                    ;
                    adaptor.addChild(root_0, string_literal193_tree);
                    }

                    // Pddl.g:312:14: ( daGD )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==61) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // Pddl.g:312:14: daGD
                    	    {
                    	    pushFollow(FOLLOW_daGD_in_daGD1899);
                    	    daGD194=daGD();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD194.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    char_literal195=(Token)match(input,62,FOLLOW_62_in_daGD1902); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal195_tree = 
                    (Object)adaptor.create(char_literal195)
                    ;
                    adaptor.addChild(root_0, char_literal195_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:313:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal196=(Token)match(input,61,FOLLOW_61_in_daGD1907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal196_tree = 
                    (Object)adaptor.create(char_literal196)
                    ;
                    adaptor.addChild(root_0, char_literal196_tree);
                    }

                    string_literal197=(Token)match(input,108,FOLLOW_108_in_daGD1909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal197_tree = 
                    (Object)adaptor.create(string_literal197)
                    ;
                    adaptor.addChild(root_0, string_literal197_tree);
                    }

                    char_literal198=(Token)match(input,61,FOLLOW_61_in_daGD1911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal198_tree = 
                    (Object)adaptor.create(char_literal198)
                    ;
                    adaptor.addChild(root_0, char_literal198_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_daGD1913);
                    typedVariableList199=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList199.getTree());

                    char_literal200=(Token)match(input,62,FOLLOW_62_in_daGD1915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal200_tree = 
                    (Object)adaptor.create(char_literal200)
                    ;
                    adaptor.addChild(root_0, char_literal200_tree);
                    }

                    pushFollow(FOLLOW_daGD_in_daGD1917);
                    daGD201=daGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD201.getTree());

                    char_literal202=(Token)match(input,62,FOLLOW_62_in_daGD1919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal202_tree = 
                    (Object)adaptor.create(char_literal202)
                    ;
                    adaptor.addChild(root_0, char_literal202_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daGD"


    public static class prefTimedGD_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prefTimedGD"
    // Pddl.g:316:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
    public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
        PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal204=null;
        Token string_literal205=null;
        Token NAME206=null;
        Token char_literal208=null;
        PddlParser.timedGD_return timedGD203 =null;

        PddlParser.timedGD_return timedGD207 =null;


        Object char_literal204_tree=null;
        Object string_literal205_tree=null;
        Object NAME206_tree=null;
        Object char_literal208_tree=null;

        try {
            // Pddl.g:317:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==61) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==100||LA45_1==119) ) {
                    alt45=1;
                }
                else if ( (LA45_1==120) ) {
                    alt45=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // Pddl.g:317:4: timedGD
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_timedGD_in_prefTimedGD1930);
                    timedGD203=timedGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD203.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:318:4: '(' 'preference' ( NAME )? timedGD ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal204=(Token)match(input,61,FOLLOW_61_in_prefTimedGD1935); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal204_tree = 
                    (Object)adaptor.create(char_literal204)
                    ;
                    adaptor.addChild(root_0, char_literal204_tree);
                    }

                    string_literal205=(Token)match(input,120,FOLLOW_120_in_prefTimedGD1937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal205_tree = 
                    (Object)adaptor.create(string_literal205)
                    ;
                    adaptor.addChild(root_0, string_literal205_tree);
                    }

                    // Pddl.g:318:21: ( NAME )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==NAME) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // Pddl.g:318:21: NAME
                            {
                            NAME206=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD1939); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NAME206_tree = 
                            (Object)adaptor.create(NAME206)
                            ;
                            adaptor.addChild(root_0, NAME206_tree);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_timedGD_in_prefTimedGD1942);
                    timedGD207=timedGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD207.getTree());

                    char_literal208=(Token)match(input,62,FOLLOW_62_in_prefTimedGD1944); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal208_tree = 
                    (Object)adaptor.create(char_literal208)
                    ;
                    adaptor.addChild(root_0, char_literal208_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prefTimedGD"


    public static class timedGD_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "timedGD"
    // Pddl.g:321:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
    public final PddlParser.timedGD_return timedGD() throws RecognitionException {
        PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal209=null;
        Token string_literal210=null;
        Token char_literal213=null;
        Token char_literal214=null;
        Token string_literal215=null;
        Token char_literal218=null;
        PddlParser.timeSpecifier_return timeSpecifier211 =null;

        PddlParser.goalDesc_return goalDesc212 =null;

        PddlParser.interval_return interval216 =null;

        PddlParser.goalDesc_return goalDesc217 =null;


        Object char_literal209_tree=null;
        Object string_literal210_tree=null;
        Object char_literal213_tree=null;
        Object char_literal214_tree=null;
        Object string_literal215_tree=null;
        Object char_literal218_tree=null;

        try {
            // Pddl.g:322:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==61) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==100) ) {
                    alt46=1;
                }
                else if ( (LA46_1==119) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // Pddl.g:322:4: '(' 'at' timeSpecifier goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal209=(Token)match(input,61,FOLLOW_61_in_timedGD1955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal209_tree = 
                    (Object)adaptor.create(char_literal209)
                    ;
                    adaptor.addChild(root_0, char_literal209_tree);
                    }

                    string_literal210=(Token)match(input,100,FOLLOW_100_in_timedGD1957); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal210_tree = 
                    (Object)adaptor.create(string_literal210)
                    ;
                    adaptor.addChild(root_0, string_literal210_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedGD1959);
                    timeSpecifier211=timeSpecifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier211.getTree());

                    pushFollow(FOLLOW_goalDesc_in_timedGD1961);
                    goalDesc212=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc212.getTree());

                    char_literal213=(Token)match(input,62,FOLLOW_62_in_timedGD1963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal213_tree = 
                    (Object)adaptor.create(char_literal213)
                    ;
                    adaptor.addChild(root_0, char_literal213_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:323:4: '(' 'over' interval goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal214=(Token)match(input,61,FOLLOW_61_in_timedGD1968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal214_tree = 
                    (Object)adaptor.create(char_literal214)
                    ;
                    adaptor.addChild(root_0, char_literal214_tree);
                    }

                    string_literal215=(Token)match(input,119,FOLLOW_119_in_timedGD1970); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = 
                    (Object)adaptor.create(string_literal215)
                    ;
                    adaptor.addChild(root_0, string_literal215_tree);
                    }

                    pushFollow(FOLLOW_interval_in_timedGD1972);
                    interval216=interval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, interval216.getTree());

                    pushFollow(FOLLOW_goalDesc_in_timedGD1974);
                    goalDesc217=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc217.getTree());

                    char_literal218=(Token)match(input,62,FOLLOW_62_in_timedGD1976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal218_tree = 
                    (Object)adaptor.create(char_literal218)
                    ;
                    adaptor.addChild(root_0, char_literal218_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timedGD"


    public static class timeSpecifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "timeSpecifier"
    // Pddl.g:326:1: timeSpecifier : ( 'start' | 'end' );
    public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
        PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set219=null;

        Object set219_tree=null;

        try {
            // Pddl.g:326:15: ( 'start' | 'end' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set219=(Token)input.LT(1);

            if ( input.LA(1)==106||input.LA(1)==127 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set219)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timeSpecifier"


    public static class interval_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "interval"
    // Pddl.g:327:1: interval : 'all' ;
    public final PddlParser.interval_return interval() throws RecognitionException {
        PddlParser.interval_return retval = new PddlParser.interval_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal220=null;

        Object string_literal220_tree=null;

        try {
            // Pddl.g:327:10: ( 'all' )
            // Pddl.g:327:12: 'all'
            {
            root_0 = (Object)adaptor.nil();


            string_literal220=(Token)match(input,95,FOLLOW_95_in_interval1998); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal220_tree = 
            (Object)adaptor.create(string_literal220)
            ;
            adaptor.addChild(root_0, string_literal220_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "interval"


    public static class derivedDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "derivedDef"
    // Pddl.g:331:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
    public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
        PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal221=null;
        Token string_literal222=null;
        Token char_literal225=null;
        PddlParser.typedVariableList_return typedVariableList223 =null;

        PddlParser.goalDesc_return goalDesc224 =null;


        Object char_literal221_tree=null;
        Object string_literal222_tree=null;
        Object char_literal225_tree=null;

        try {
            // Pddl.g:332:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
            // Pddl.g:332:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
            {
            root_0 = (Object)adaptor.nil();


            char_literal221=(Token)match(input,61,FOLLOW_61_in_derivedDef2011); if (state.failed) return retval;

            string_literal222=(Token)match(input,72,FOLLOW_72_in_derivedDef2014); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal222_tree = 
            (Object)adaptor.create(string_literal222)
            ;
            root_0 = (Object)adaptor.becomeRoot(string_literal222_tree, root_0);
            }

            pushFollow(FOLLOW_typedVariableList_in_derivedDef2017);
            typedVariableList223=typedVariableList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList223.getTree());

            pushFollow(FOLLOW_goalDesc_in_derivedDef2019);
            goalDesc224=goalDesc();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc224.getTree());

            char_literal225=(Token)match(input,62,FOLLOW_62_in_derivedDef2021); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "derivedDef"


    public static class fExp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fExp"
    // Pddl.g:337:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
    public final PddlParser.fExp_return fExp() throws RecognitionException {
        PddlParser.fExp_return retval = new PddlParser.fExp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUMBER226=null;
        Token char_literal227=null;
        Token char_literal231=null;
        Token char_literal232=null;
        Token char_literal233=null;
        Token char_literal235=null;
        PddlParser.binaryOp_return binaryOp228 =null;

        PddlParser.fExp_return fExp229 =null;

        PddlParser.fExp2_return fExp2230 =null;

        PddlParser.fExp_return fExp234 =null;

        PddlParser.fHead_return fHead236 =null;


        Object NUMBER226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal231_tree=null;
        Object char_literal232_tree=null;
        Object char_literal233_tree=null;
        Object char_literal235_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
        RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
        RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
        try {
            // Pddl.g:338:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
            int alt47=4;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt47=1;
                }
                break;
            case 61:
                {
                int LA47_2 = input.LA(2);

                if ( (synpred63_Pddl()) ) {
                    alt47=2;
                }
                else if ( (synpred64_Pddl()) ) {
                    alt47=3;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;

                }
                }
                break;
            case NAME:
            case 60:
                {
                alt47=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // Pddl.g:338:4: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();


                    NUMBER226=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp2036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER226_tree = 
                    (Object)adaptor.create(NUMBER226)
                    ;
                    adaptor.addChild(root_0, NUMBER226_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:339:4: '(' binaryOp fExp fExp2 ')'
                    {
                    char_literal227=(Token)match(input,61,FOLLOW_61_in_fExp2041); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal227);


                    pushFollow(FOLLOW_binaryOp_in_fExp2043);
                    binaryOp228=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp228.getTree());

                    pushFollow(FOLLOW_fExp_in_fExp2045);
                    fExp229=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fExp.add(fExp229.getTree());

                    pushFollow(FOLLOW_fExp2_in_fExp2047);
                    fExp2230=fExp2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fExp2.add(fExp2230.getTree());

                    char_literal231=(Token)match(input,62,FOLLOW_62_in_fExp2049); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal231);


                    // AST REWRITE
                    // elements: fExp2, binaryOp, fExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 339:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
                    {
                        // Pddl.g:339:35: ^( BINARY_OP binaryOp fExp fExp2 )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(BINARY_OP, "BINARY_OP")
                        , root_1);

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
                case 3 :
                    // Pddl.g:340:4: '(' '-' fExp ')'
                    {
                    char_literal232=(Token)match(input,61,FOLLOW_61_in_fExp2066); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal232);


                    char_literal233=(Token)match(input,65,FOLLOW_65_in_fExp2068); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(char_literal233);


                    pushFollow(FOLLOW_fExp_in_fExp2070);
                    fExp234=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fExp.add(fExp234.getTree());

                    char_literal235=(Token)match(input,62,FOLLOW_62_in_fExp2072); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal235);


                    // AST REWRITE
                    // elements: fExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 340:21: -> ^( UNARY_MINUS fExp )
                    {
                        // Pddl.g:340:24: ^( UNARY_MINUS fExp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS")
                        , root_1);

                        adaptor.addChild(root_1, stream_fExp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // Pddl.g:341:4: fHead
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_fHead_in_fExp2085);
                    fHead236=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead236.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExp"


    public static class fExp2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fExp2"
    // Pddl.g:346:1: fExp2 : fExp ;
    public final PddlParser.fExp2_return fExp2() throws RecognitionException {
        PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        PddlParser.fExp_return fExp237 =null;



        try {
            // Pddl.g:346:7: ( fExp )
            // Pddl.g:346:9: fExp
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_fExp_in_fExp22097);
            fExp237=fExp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp237.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExp2"


    public static class fHead_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fHead"
    // Pddl.g:348:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
    public final PddlParser.fHead_return fHead() throws RecognitionException {
        PddlParser.fHead_return retval = new PddlParser.fHead_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal238=null;
        Token char_literal241=null;
        PddlParser.functionSymbol_return functionSymbol239 =null;

        PddlParser.term_return term240 =null;

        PddlParser.functionSymbol_return functionSymbol242 =null;


        Object char_literal238_tree=null;
        Object char_literal241_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");
        try {
            // Pddl.g:349:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==61) ) {
                alt49=1;
            }
            else if ( (LA49_0==NAME||LA49_0==60) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // Pddl.g:349:4: '(' functionSymbol ( term )* ')'
                    {
                    char_literal238=(Token)match(input,61,FOLLOW_61_in_fHead2107); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal238);


                    pushFollow(FOLLOW_functionSymbol_in_fHead2109);
                    functionSymbol239=functionSymbol();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol239.getTree());

                    // Pddl.g:349:23: ( term )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==NAME||LA48_0==VARIABLE) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // Pddl.g:349:23: term
                    	    {
                    	    pushFollow(FOLLOW_term_in_fHead2111);
                    	    term240=term();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_term.add(term240.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    char_literal241=(Token)match(input,62,FOLLOW_62_in_fHead2114); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal241);


                    // AST REWRITE
                    // elements: functionSymbol, term
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 349:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
                    {
                        // Pddl.g:349:36: ^( FUNC_HEAD functionSymbol ( term )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD")
                        , root_1);

                        adaptor.addChild(root_1, stream_functionSymbol.nextTree());

                        // Pddl.g:349:63: ( term )*
                        while ( stream_term.hasNext() ) {
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
                case 2 :
                    // Pddl.g:350:4: functionSymbol
                    {
                    pushFollow(FOLLOW_functionSymbol_in_fHead2130);
                    functionSymbol242=functionSymbol();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol242.getTree());

                    // AST REWRITE
                    // elements: functionSymbol
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 350:19: -> ^( FUNC_HEAD functionSymbol )
                    {
                        // Pddl.g:350:22: ^( FUNC_HEAD functionSymbol )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD")
                        , root_1);

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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fHead"


    public static class effect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "effect"
    // Pddl.g:353:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
    public final PddlParser.effect_return effect() throws RecognitionException {
        PddlParser.effect_return retval = new PddlParser.effect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal243=null;
        Token string_literal244=null;
        Token char_literal246=null;
        PddlParser.cEffect_return cEffect245 =null;

        PddlParser.cEffect_return cEffect247 =null;


        Object char_literal243_tree=null;
        Object string_literal244_tree=null;
        Object char_literal246_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");
        try {
            // Pddl.g:354:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==61) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==98) ) {
                    alt51=1;
                }
                else if ( (LA51_1==NAME||LA51_1==99||LA51_1==102||LA51_1==108||LA51_1==112||LA51_1==116||(LA51_1 >= 122 && LA51_1 <= 123)||LA51_1==128) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }
            switch (alt51) {
                case 1 :
                    // Pddl.g:354:4: '(' 'and' ( cEffect )* ')'
                    {
                    char_literal243=(Token)match(input,61,FOLLOW_61_in_effect2149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal243);


                    string_literal244=(Token)match(input,98,FOLLOW_98_in_effect2151); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(string_literal244);


                    // Pddl.g:354:14: ( cEffect )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==61) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // Pddl.g:354:14: cEffect
                    	    {
                    	    pushFollow(FOLLOW_cEffect_in_effect2153);
                    	    cEffect245=cEffect();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_cEffect.add(cEffect245.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    char_literal246=(Token)match(input,62,FOLLOW_62_in_effect2156); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal246);


                    // AST REWRITE
                    // elements: cEffect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 354:27: -> ^( AND_EFFECT ( cEffect )* )
                    {
                        // Pddl.g:354:30: ^( AND_EFFECT ( cEffect )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(AND_EFFECT, "AND_EFFECT")
                        , root_1);

                        // Pddl.g:354:43: ( cEffect )*
                        while ( stream_cEffect.hasNext() ) {
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
                case 2 :
                    // Pddl.g:355:4: cEffect
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_cEffect_in_effect2170);
                    cEffect247=cEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect247.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "effect"


    public static class cEffect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cEffect"
    // Pddl.g:358:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
    public final PddlParser.cEffect_return cEffect() throws RecognitionException {
        PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal248=null;
        Token string_literal249=null;
        Token char_literal250=null;
        Token char_literal252=null;
        Token char_literal254=null;
        Token char_literal255=null;
        Token string_literal256=null;
        Token char_literal259=null;
        PddlParser.typedVariableList_return typedVariableList251 =null;

        PddlParser.effect_return effect253 =null;

        PddlParser.goalDesc_return goalDesc257 =null;

        PddlParser.condEffect_return condEffect258 =null;

        PddlParser.pEffect_return pEffect260 =null;


        Object char_literal248_tree=null;
        Object string_literal249_tree=null;
        Object char_literal250_tree=null;
        Object char_literal252_tree=null;
        Object char_literal254_tree=null;
        Object char_literal255_tree=null;
        Object string_literal256_tree=null;
        Object char_literal259_tree=null;
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
        RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
        RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
        RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");
        try {
            // Pddl.g:359:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
            int alt52=3;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==61) ) {
                switch ( input.LA(2) ) {
                case 108:
                    {
                    alt52=1;
                    }
                    break;
                case 128:
                    {
                    alt52=2;
                    }
                    break;
                case NAME:
                case 99:
                case 102:
                case 112:
                case 116:
                case 122:
                case 123:
                    {
                    alt52=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // Pddl.g:359:4: '(' 'forall' '(' typedVariableList ')' effect ')'
                    {
                    char_literal248=(Token)match(input,61,FOLLOW_61_in_cEffect2181); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal248);


                    string_literal249=(Token)match(input,108,FOLLOW_108_in_cEffect2183); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_108.add(string_literal249);


                    char_literal250=(Token)match(input,61,FOLLOW_61_in_cEffect2185); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal250);


                    pushFollow(FOLLOW_typedVariableList_in_cEffect2187);
                    typedVariableList251=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList251.getTree());

                    char_literal252=(Token)match(input,62,FOLLOW_62_in_cEffect2189); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal252);


                    pushFollow(FOLLOW_effect_in_cEffect2191);
                    effect253=effect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_effect.add(effect253.getTree());

                    char_literal254=(Token)match(input,62,FOLLOW_62_in_cEffect2193); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal254);


                    // AST REWRITE
                    // elements: typedVariableList, effect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 360:4: -> ^( FORALL_EFFECT typedVariableList effect )
                    {
                        // Pddl.g:360:7: ^( FORALL_EFFECT typedVariableList effect )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(FORALL_EFFECT, "FORALL_EFFECT")
                        , root_1);

                        adaptor.addChild(root_1, stream_typedVariableList.nextTree());

                        adaptor.addChild(root_1, stream_effect.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:361:4: '(' 'when' goalDesc condEffect ')'
                    {
                    char_literal255=(Token)match(input,61,FOLLOW_61_in_cEffect2211); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal255);


                    string_literal256=(Token)match(input,128,FOLLOW_128_in_cEffect2213); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_128.add(string_literal256);


                    pushFollow(FOLLOW_goalDesc_in_cEffect2215);
                    goalDesc257=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc257.getTree());

                    pushFollow(FOLLOW_condEffect_in_cEffect2217);
                    condEffect258=condEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condEffect.add(condEffect258.getTree());

                    char_literal259=(Token)match(input,62,FOLLOW_62_in_cEffect2219); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal259);


                    // AST REWRITE
                    // elements: condEffect, goalDesc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 362:4: -> ^( WHEN_EFFECT goalDesc condEffect )
                    {
                        // Pddl.g:362:7: ^( WHEN_EFFECT goalDesc condEffect )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(WHEN_EFFECT, "WHEN_EFFECT")
                        , root_1);

                        adaptor.addChild(root_1, stream_goalDesc.nextTree());

                        adaptor.addChild(root_1, stream_condEffect.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:363:4: pEffect
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pEffect_in_cEffect2237);
                    pEffect260=pEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect260.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cEffect"


    public static class pEffect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pEffect"
    // Pddl.g:366:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
    public final PddlParser.pEffect_return pEffect() throws RecognitionException {
        PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal261=null;
        Token char_literal265=null;
        Token char_literal266=null;
        Token string_literal267=null;
        Token char_literal269=null;
        PddlParser.assignOp_return assignOp262 =null;

        PddlParser.fHead_return fHead263 =null;

        PddlParser.fExp_return fExp264 =null;

        PddlParser.atomicTermFormula_return atomicTermFormula268 =null;

        PddlParser.atomicTermFormula_return atomicTermFormula270 =null;


        Object char_literal261_tree=null;
        Object char_literal265_tree=null;
        Object char_literal266_tree=null;
        Object string_literal267_tree=null;
        Object char_literal269_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
        RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
        RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
        RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
        try {
            // Pddl.g:367:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==61) ) {
                switch ( input.LA(2) ) {
                case 116:
                    {
                    alt53=2;
                    }
                    break;
                case 99:
                case 102:
                case 112:
                case 122:
                case 123:
                    {
                    alt53=1;
                    }
                    break;
                case NAME:
                    {
                    alt53=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // Pddl.g:367:4: '(' assignOp fHead fExp ')'
                    {
                    char_literal261=(Token)match(input,61,FOLLOW_61_in_pEffect2248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal261);


                    pushFollow(FOLLOW_assignOp_in_pEffect2250);
                    assignOp262=assignOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOp.add(assignOp262.getTree());

                    pushFollow(FOLLOW_fHead_in_pEffect2252);
                    fHead263=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fHead.add(fHead263.getTree());

                    pushFollow(FOLLOW_fExp_in_pEffect2254);
                    fExp264=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fExp.add(fExp264.getTree());

                    char_literal265=(Token)match(input,62,FOLLOW_62_in_pEffect2256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal265);


                    // AST REWRITE
                    // elements: fExp, assignOp, fHead
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 368:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
                    {
                        // Pddl.g:368:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(ASSIGN_EFFECT, "ASSIGN_EFFECT")
                        , root_1);

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
                case 2 :
                    // Pddl.g:369:4: '(' 'not' atomicTermFormula ')'
                    {
                    char_literal266=(Token)match(input,61,FOLLOW_61_in_pEffect2276); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal266);


                    string_literal267=(Token)match(input,116,FOLLOW_116_in_pEffect2278); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_116.add(string_literal267);


                    pushFollow(FOLLOW_atomicTermFormula_in_pEffect2280);
                    atomicTermFormula268=atomicTermFormula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula268.getTree());

                    char_literal269=(Token)match(input,62,FOLLOW_62_in_pEffect2282); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal269);


                    // AST REWRITE
                    // elements: atomicTermFormula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 370:4: -> ^( NOT_EFFECT atomicTermFormula )
                    {
                        // Pddl.g:370:7: ^( NOT_EFFECT atomicTermFormula )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(NOT_EFFECT, "NOT_EFFECT")
                        , root_1);

                        adaptor.addChild(root_1, stream_atomicTermFormula.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:371:4: atomicTermFormula
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_atomicTermFormula_in_pEffect2298);
                    atomicTermFormula270=atomicTermFormula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula270.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pEffect"


    public static class condEffect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condEffect"
    // Pddl.g:376:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
    public final PddlParser.condEffect_return condEffect() throws RecognitionException {
        PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal271=null;
        Token string_literal272=null;
        Token char_literal274=null;
        PddlParser.pEffect_return pEffect273 =null;

        PddlParser.pEffect_return pEffect275 =null;


        Object char_literal271_tree=null;
        Object string_literal272_tree=null;
        Object char_literal274_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");
        try {
            // Pddl.g:377:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==61) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==98) ) {
                    alt55=1;
                }
                else if ( (LA55_1==NAME||LA55_1==99||LA55_1==102||LA55_1==112||LA55_1==116||(LA55_1 >= 122 && LA55_1 <= 123)) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // Pddl.g:377:4: '(' 'and' ( pEffect )* ')'
                    {
                    char_literal271=(Token)match(input,61,FOLLOW_61_in_condEffect2311); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal271);


                    string_literal272=(Token)match(input,98,FOLLOW_98_in_condEffect2313); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_98.add(string_literal272);


                    // Pddl.g:377:14: ( pEffect )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==61) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // Pddl.g:377:14: pEffect
                    	    {
                    	    pushFollow(FOLLOW_pEffect_in_condEffect2315);
                    	    pEffect273=pEffect();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_pEffect.add(pEffect273.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    char_literal274=(Token)match(input,62,FOLLOW_62_in_condEffect2318); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal274);


                    // AST REWRITE
                    // elements: pEffect
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 377:27: -> ^( AND_EFFECT ( pEffect )* )
                    {
                        // Pddl.g:377:30: ^( AND_EFFECT ( pEffect )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(AND_EFFECT, "AND_EFFECT")
                        , root_1);

                        // Pddl.g:377:43: ( pEffect )*
                        while ( stream_pEffect.hasNext() ) {
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
                case 2 :
                    // Pddl.g:378:4: pEffect
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pEffect_in_condEffect2332);
                    pEffect275=pEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect275.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condEffect"


    public static class binaryOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "binaryOp"
    // Pddl.g:382:1: binaryOp : ( '*' | '+' | '-' | '/' );
    public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
        PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set276=null;

        Object set276_tree=null;

        try {
            // Pddl.g:382:10: ( '*' | '+' | '-' | '/' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set276=(Token)input.LT(1);

            if ( (input.LA(1) >= 63 && input.LA(1) <= 66) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set276)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "binaryOp"


    public static class multiOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multiOp"
    // Pddl.g:384:1: multiOp : ( '*' | '+' );
    public final PddlParser.multiOp_return multiOp() throws RecognitionException {
        PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set277=null;

        Object set277_tree=null;

        try {
            // Pddl.g:384:9: ( '*' | '+' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set277=(Token)input.LT(1);

            if ( (input.LA(1) >= 63 && input.LA(1) <= 64) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set277)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multiOp"


    public static class binaryComp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "binaryComp"
    // Pddl.g:386:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
    public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
        PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set278=null;

        Object set278_tree=null;

        try {
            // Pddl.g:386:12: ( '>' | '<' | '=' | '>=' | '<=' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set278=(Token)input.LT(1);

            if ( (input.LA(1) >= 89 && input.LA(1) <= 93) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set278)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "binaryComp"


    public static class assignOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignOp"
    // Pddl.g:388:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
    public final PddlParser.assignOp_return assignOp() throws RecognitionException {
        PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set279=null;

        Object set279_tree=null;

        try {
            // Pddl.g:388:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set279=(Token)input.LT(1);

            if ( input.LA(1)==99||input.LA(1)==102||input.LA(1)==112||(input.LA(1) >= 122 && input.LA(1) <= 123) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set279)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignOp"


    public static class durationConstraint_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "durationConstraint"
    // Pddl.g:393:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
    public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
        PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal280=null;
        Token string_literal281=null;
        Token char_literal283=null;
        Token char_literal284=null;
        Token char_literal285=null;
        PddlParser.simpleDurationConstraint_return simpleDurationConstraint282 =null;

        PddlParser.simpleDurationConstraint_return simpleDurationConstraint286 =null;


        Object char_literal280_tree=null;
        Object string_literal281_tree=null;
        Object char_literal283_tree=null;
        Object char_literal284_tree=null;
        Object char_literal285_tree=null;

        try {
            // Pddl.g:394:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
            int alt57=3;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==61) ) {
                switch ( input.LA(2) ) {
                case 98:
                    {
                    alt57=1;
                    }
                    break;
                case 62:
                    {
                    alt57=2;
                    }
                    break;
                case 90:
                case 91:
                case 93:
                case 100:
                    {
                    alt57=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // Pddl.g:394:4: '(' 'and' ( simpleDurationConstraint )+ ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal280=(Token)match(input,61,FOLLOW_61_in_durationConstraint2433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal280_tree = 
                    (Object)adaptor.create(char_literal280)
                    ;
                    adaptor.addChild(root_0, char_literal280_tree);
                    }

                    string_literal281=(Token)match(input,98,FOLLOW_98_in_durationConstraint2435); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal281_tree = 
                    (Object)adaptor.create(string_literal281)
                    ;
                    adaptor.addChild(root_0, string_literal281_tree);
                    }

                    // Pddl.g:394:14: ( simpleDurationConstraint )+
                    int cnt56=0;
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==61) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // Pddl.g:394:14: simpleDurationConstraint
                    	    {
                    	    pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2437);
                    	    simpleDurationConstraint282=simpleDurationConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint282.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt56 >= 1 ) break loop56;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(56, input);
                                throw eee;
                        }
                        cnt56++;
                    } while (true);


                    char_literal283=(Token)match(input,62,FOLLOW_62_in_durationConstraint2440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal283_tree = 
                    (Object)adaptor.create(char_literal283)
                    ;
                    adaptor.addChild(root_0, char_literal283_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:395:4: '(' ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal284=(Token)match(input,61,FOLLOW_61_in_durationConstraint2445); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal284_tree = 
                    (Object)adaptor.create(char_literal284)
                    ;
                    adaptor.addChild(root_0, char_literal284_tree);
                    }

                    char_literal285=(Token)match(input,62,FOLLOW_62_in_durationConstraint2447); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal285_tree = 
                    (Object)adaptor.create(char_literal285)
                    ;
                    adaptor.addChild(root_0, char_literal285_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:396:4: simpleDurationConstraint
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2452);
                    simpleDurationConstraint286=simpleDurationConstraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint286.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durationConstraint"


    public static class simpleDurationConstraint_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleDurationConstraint"
    // Pddl.g:399:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
    public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
        PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal287=null;
        Token string_literal289=null;
        Token char_literal291=null;
        Token char_literal292=null;
        Token string_literal293=null;
        Token char_literal296=null;
        PddlParser.durOp_return durOp288 =null;

        PddlParser.durValue_return durValue290 =null;

        PddlParser.timeSpecifier_return timeSpecifier294 =null;

        PddlParser.simpleDurationConstraint_return simpleDurationConstraint295 =null;


        Object char_literal287_tree=null;
        Object string_literal289_tree=null;
        Object char_literal291_tree=null;
        Object char_literal292_tree=null;
        Object string_literal293_tree=null;
        Object char_literal296_tree=null;

        try {
            // Pddl.g:400:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==61) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==100) ) {
                    alt58=2;
                }
                else if ( ((LA58_1 >= 90 && LA58_1 <= 91)||LA58_1==93) ) {
                    alt58=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // Pddl.g:400:4: '(' durOp '?duration' durValue ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal287=(Token)match(input,61,FOLLOW_61_in_simpleDurationConstraint2463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal287_tree = 
                    (Object)adaptor.create(char_literal287)
                    ;
                    adaptor.addChild(root_0, char_literal287_tree);
                    }

                    pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2465);
                    durOp288=durOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp288.getTree());

                    string_literal289=(Token)match(input,94,FOLLOW_94_in_simpleDurationConstraint2467); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal289_tree = 
                    (Object)adaptor.create(string_literal289)
                    ;
                    adaptor.addChild(root_0, string_literal289_tree);
                    }

                    pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2469);
                    durValue290=durValue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue290.getTree());

                    char_literal291=(Token)match(input,62,FOLLOW_62_in_simpleDurationConstraint2471); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal291_tree = 
                    (Object)adaptor.create(char_literal291)
                    ;
                    adaptor.addChild(root_0, char_literal291_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:401:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal292=(Token)match(input,61,FOLLOW_61_in_simpleDurationConstraint2476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal292_tree = 
                    (Object)adaptor.create(char_literal292)
                    ;
                    adaptor.addChild(root_0, char_literal292_tree);
                    }

                    string_literal293=(Token)match(input,100,FOLLOW_100_in_simpleDurationConstraint2478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal293_tree = 
                    (Object)adaptor.create(string_literal293)
                    ;
                    adaptor.addChild(root_0, string_literal293_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2480);
                    timeSpecifier294=timeSpecifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier294.getTree());

                    pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2482);
                    simpleDurationConstraint295=simpleDurationConstraint();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint295.getTree());

                    char_literal296=(Token)match(input,62,FOLLOW_62_in_simpleDurationConstraint2484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal296_tree = 
                    (Object)adaptor.create(char_literal296)
                    ;
                    adaptor.addChild(root_0, char_literal296_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleDurationConstraint"


    public static class durOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "durOp"
    // Pddl.g:404:1: durOp : ( '<=' | '>=' | '=' );
    public final PddlParser.durOp_return durOp() throws RecognitionException {
        PddlParser.durOp_return retval = new PddlParser.durOp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set297=null;

        Object set297_tree=null;

        try {
            // Pddl.g:404:7: ( '<=' | '>=' | '=' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set297=(Token)input.LT(1);

            if ( (input.LA(1) >= 90 && input.LA(1) <= 91)||input.LA(1)==93 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set297)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durOp"


    public static class durValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "durValue"
    // Pddl.g:406:1: durValue : ( NUMBER | fExp );
    public final PddlParser.durValue_return durValue() throws RecognitionException {
        PddlParser.durValue_return retval = new PddlParser.durValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUMBER298=null;
        PddlParser.fExp_return fExp299 =null;


        Object NUMBER298_tree=null;

        try {
            // Pddl.g:406:10: ( NUMBER | fExp )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==NUMBER) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred93_Pddl()) ) {
                    alt59=1;
                }
                else if ( (true) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA59_0==NAME||(LA59_0 >= 60 && LA59_0 <= 61)) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // Pddl.g:406:12: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();


                    NUMBER298=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER298_tree = 
                    (Object)adaptor.create(NUMBER298)
                    ;
                    adaptor.addChild(root_0, NUMBER298_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:406:21: fExp
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_fExp_in_durValue2515);
                    fExp299=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp299.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "durValue"


    public static class daEffect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "daEffect"
    // Pddl.g:408:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
    public final PddlParser.daEffect_return daEffect() throws RecognitionException {
        PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal300=null;
        Token string_literal301=null;
        Token char_literal303=null;
        Token char_literal305=null;
        Token string_literal306=null;
        Token char_literal307=null;
        Token char_literal309=null;
        Token char_literal311=null;
        Token char_literal312=null;
        Token string_literal313=null;
        Token char_literal316=null;
        Token char_literal317=null;
        Token char_literal321=null;
        PddlParser.daEffect_return daEffect302 =null;

        PddlParser.timedEffect_return timedEffect304 =null;

        PddlParser.typedVariableList_return typedVariableList308 =null;

        PddlParser.daEffect_return daEffect310 =null;

        PddlParser.daGD_return daGD314 =null;

        PddlParser.timedEffect_return timedEffect315 =null;

        PddlParser.assignOp_return assignOp318 =null;

        PddlParser.fHead_return fHead319 =null;

        PddlParser.fExpDA_return fExpDA320 =null;


        Object char_literal300_tree=null;
        Object string_literal301_tree=null;
        Object char_literal303_tree=null;
        Object char_literal305_tree=null;
        Object string_literal306_tree=null;
        Object char_literal307_tree=null;
        Object char_literal309_tree=null;
        Object char_literal311_tree=null;
        Object char_literal312_tree=null;
        Object string_literal313_tree=null;
        Object char_literal316_tree=null;
        Object char_literal317_tree=null;
        Object char_literal321_tree=null;

        try {
            // Pddl.g:409:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
            int alt61=5;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==61) ) {
                int LA61_1 = input.LA(2);

                if ( (synpred95_Pddl()) ) {
                    alt61=1;
                }
                else if ( (synpred96_Pddl()) ) {
                    alt61=2;
                }
                else if ( (synpred97_Pddl()) ) {
                    alt61=3;
                }
                else if ( (synpred98_Pddl()) ) {
                    alt61=4;
                }
                else if ( (true) ) {
                    alt61=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // Pddl.g:409:4: '(' 'and' ( daEffect )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal300=(Token)match(input,61,FOLLOW_61_in_daEffect2525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal300_tree = 
                    (Object)adaptor.create(char_literal300)
                    ;
                    adaptor.addChild(root_0, char_literal300_tree);
                    }

                    string_literal301=(Token)match(input,98,FOLLOW_98_in_daEffect2527); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal301_tree = 
                    (Object)adaptor.create(string_literal301)
                    ;
                    adaptor.addChild(root_0, string_literal301_tree);
                    }

                    // Pddl.g:409:14: ( daEffect )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==61) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // Pddl.g:409:14: daEffect
                    	    {
                    	    pushFollow(FOLLOW_daEffect_in_daEffect2529);
                    	    daEffect302=daEffect();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect302.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    char_literal303=(Token)match(input,62,FOLLOW_62_in_daEffect2532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal303_tree = 
                    (Object)adaptor.create(char_literal303)
                    ;
                    adaptor.addChild(root_0, char_literal303_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:410:4: timedEffect
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_timedEffect_in_daEffect2537);
                    timedEffect304=timedEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect304.getTree());

                    }
                    break;
                case 3 :
                    // Pddl.g:411:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal305=(Token)match(input,61,FOLLOW_61_in_daEffect2542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal305_tree = 
                    (Object)adaptor.create(char_literal305)
                    ;
                    adaptor.addChild(root_0, char_literal305_tree);
                    }

                    string_literal306=(Token)match(input,108,FOLLOW_108_in_daEffect2544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal306_tree = 
                    (Object)adaptor.create(string_literal306)
                    ;
                    adaptor.addChild(root_0, string_literal306_tree);
                    }

                    char_literal307=(Token)match(input,61,FOLLOW_61_in_daEffect2546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal307_tree = 
                    (Object)adaptor.create(char_literal307)
                    ;
                    adaptor.addChild(root_0, char_literal307_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_daEffect2548);
                    typedVariableList308=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList308.getTree());

                    char_literal309=(Token)match(input,62,FOLLOW_62_in_daEffect2550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal309_tree = 
                    (Object)adaptor.create(char_literal309)
                    ;
                    adaptor.addChild(root_0, char_literal309_tree);
                    }

                    pushFollow(FOLLOW_daEffect_in_daEffect2552);
                    daEffect310=daEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect310.getTree());

                    char_literal311=(Token)match(input,62,FOLLOW_62_in_daEffect2554); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal311_tree = 
                    (Object)adaptor.create(char_literal311)
                    ;
                    adaptor.addChild(root_0, char_literal311_tree);
                    }

                    }
                    break;
                case 4 :
                    // Pddl.g:412:4: '(' 'when' daGD timedEffect ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal312=(Token)match(input,61,FOLLOW_61_in_daEffect2559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal312_tree = 
                    (Object)adaptor.create(char_literal312)
                    ;
                    adaptor.addChild(root_0, char_literal312_tree);
                    }

                    string_literal313=(Token)match(input,128,FOLLOW_128_in_daEffect2561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal313_tree = 
                    (Object)adaptor.create(string_literal313)
                    ;
                    adaptor.addChild(root_0, string_literal313_tree);
                    }

                    pushFollow(FOLLOW_daGD_in_daEffect2563);
                    daGD314=daGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD314.getTree());

                    pushFollow(FOLLOW_timedEffect_in_daEffect2565);
                    timedEffect315=timedEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect315.getTree());

                    char_literal316=(Token)match(input,62,FOLLOW_62_in_daEffect2567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal316_tree = 
                    (Object)adaptor.create(char_literal316)
                    ;
                    adaptor.addChild(root_0, char_literal316_tree);
                    }

                    }
                    break;
                case 5 :
                    // Pddl.g:413:4: '(' assignOp fHead fExpDA ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal317=(Token)match(input,61,FOLLOW_61_in_daEffect2572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal317_tree = 
                    (Object)adaptor.create(char_literal317)
                    ;
                    adaptor.addChild(root_0, char_literal317_tree);
                    }

                    pushFollow(FOLLOW_assignOp_in_daEffect2574);
                    assignOp318=assignOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp318.getTree());

                    pushFollow(FOLLOW_fHead_in_daEffect2576);
                    fHead319=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead319.getTree());

                    pushFollow(FOLLOW_fExpDA_in_daEffect2578);
                    fExpDA320=fExpDA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA320.getTree());

                    char_literal321=(Token)match(input,62,FOLLOW_62_in_daEffect2580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal321_tree = 
                    (Object)adaptor.create(char_literal321)
                    ;
                    adaptor.addChild(root_0, char_literal321_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "daEffect"


    public static class timedEffect_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "timedEffect"
    // Pddl.g:416:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
    public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
        PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal322=null;
        Token string_literal323=null;
        Token char_literal326=null;
        Token char_literal327=null;
        Token string_literal328=null;
        Token char_literal331=null;
        Token char_literal332=null;
        Token char_literal336=null;
        PddlParser.timeSpecifier_return timeSpecifier324 =null;

        PddlParser.daEffect_return daEffect325 =null;

        PddlParser.timeSpecifier_return timeSpecifier329 =null;

        PddlParser.fAssignDA_return fAssignDA330 =null;

        PddlParser.assignOp_return assignOp333 =null;

        PddlParser.fHead_return fHead334 =null;

        PddlParser.fExp_return fExp335 =null;


        Object char_literal322_tree=null;
        Object string_literal323_tree=null;
        Object char_literal326_tree=null;
        Object char_literal327_tree=null;
        Object string_literal328_tree=null;
        Object char_literal331_tree=null;
        Object char_literal332_tree=null;
        Object char_literal336_tree=null;

        try {
            // Pddl.g:417:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==61) ) {
                int LA62_1 = input.LA(2);

                if ( (synpred99_Pddl()) ) {
                    alt62=1;
                }
                else if ( (synpred100_Pddl()) ) {
                    alt62=2;
                }
                else if ( (true) ) {
                    alt62=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // Pddl.g:417:4: '(' 'at' timeSpecifier daEffect ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal322=(Token)match(input,61,FOLLOW_61_in_timedEffect2591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal322_tree = 
                    (Object)adaptor.create(char_literal322)
                    ;
                    adaptor.addChild(root_0, char_literal322_tree);
                    }

                    string_literal323=(Token)match(input,100,FOLLOW_100_in_timedEffect2593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal323_tree = 
                    (Object)adaptor.create(string_literal323)
                    ;
                    adaptor.addChild(root_0, string_literal323_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedEffect2595);
                    timeSpecifier324=timeSpecifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier324.getTree());

                    pushFollow(FOLLOW_daEffect_in_timedEffect2597);
                    daEffect325=daEffect();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect325.getTree());

                    char_literal326=(Token)match(input,62,FOLLOW_62_in_timedEffect2599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal326_tree = 
                    (Object)adaptor.create(char_literal326)
                    ;
                    adaptor.addChild(root_0, char_literal326_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:418:4: '(' 'at' timeSpecifier fAssignDA ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal327=(Token)match(input,61,FOLLOW_61_in_timedEffect2609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal327_tree = 
                    (Object)adaptor.create(char_literal327)
                    ;
                    adaptor.addChild(root_0, char_literal327_tree);
                    }

                    string_literal328=(Token)match(input,100,FOLLOW_100_in_timedEffect2611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal328_tree = 
                    (Object)adaptor.create(string_literal328)
                    ;
                    adaptor.addChild(root_0, string_literal328_tree);
                    }

                    pushFollow(FOLLOW_timeSpecifier_in_timedEffect2613);
                    timeSpecifier329=timeSpecifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier329.getTree());

                    pushFollow(FOLLOW_fAssignDA_in_timedEffect2615);
                    fAssignDA330=fAssignDA();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA330.getTree());

                    char_literal331=(Token)match(input,62,FOLLOW_62_in_timedEffect2617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal331_tree = 
                    (Object)adaptor.create(char_literal331)
                    ;
                    adaptor.addChild(root_0, char_literal331_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:419:4: '(' assignOp fHead fExp ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal332=(Token)match(input,61,FOLLOW_61_in_timedEffect2622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal332_tree = 
                    (Object)adaptor.create(char_literal332)
                    ;
                    adaptor.addChild(root_0, char_literal332_tree);
                    }

                    pushFollow(FOLLOW_assignOp_in_timedEffect2624);
                    assignOp333=assignOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp333.getTree());

                    pushFollow(FOLLOW_fHead_in_timedEffect2626);
                    fHead334=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead334.getTree());

                    pushFollow(FOLLOW_fExp_in_timedEffect2628);
                    fExp335=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp335.getTree());

                    char_literal336=(Token)match(input,62,FOLLOW_62_in_timedEffect2630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal336_tree = 
                    (Object)adaptor.create(char_literal336)
                    ;
                    adaptor.addChild(root_0, char_literal336_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "timedEffect"


    public static class fAssignDA_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fAssignDA"
    // Pddl.g:422:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
    public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
        PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal337=null;
        Token char_literal341=null;
        PddlParser.assignOp_return assignOp338 =null;

        PddlParser.fHead_return fHead339 =null;

        PddlParser.fExpDA_return fExpDA340 =null;


        Object char_literal337_tree=null;
        Object char_literal341_tree=null;

        try {
            // Pddl.g:423:2: ( '(' assignOp fHead fExpDA ')' )
            // Pddl.g:423:4: '(' assignOp fHead fExpDA ')'
            {
            root_0 = (Object)adaptor.nil();


            char_literal337=(Token)match(input,61,FOLLOW_61_in_fAssignDA2650); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal337_tree = 
            (Object)adaptor.create(char_literal337)
            ;
            adaptor.addChild(root_0, char_literal337_tree);
            }

            pushFollow(FOLLOW_assignOp_in_fAssignDA2652);
            assignOp338=assignOp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp338.getTree());

            pushFollow(FOLLOW_fHead_in_fAssignDA2654);
            fHead339=fHead();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead339.getTree());

            pushFollow(FOLLOW_fExpDA_in_fAssignDA2656);
            fExpDA340=fExpDA();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA340.getTree());

            char_literal341=(Token)match(input,62,FOLLOW_62_in_fAssignDA2658); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal341_tree = 
            (Object)adaptor.create(char_literal341)
            ;
            adaptor.addChild(root_0, char_literal341_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fAssignDA"


    public static class fExpDA_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fExpDA"
    // Pddl.g:426:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
    public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
        PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal342=null;
        Token char_literal346=null;
        Token char_literal348=null;
        Token string_literal349=null;
        PddlParser.binaryOp_return binaryOp343 =null;

        PddlParser.fExpDA_return fExpDA344 =null;

        PddlParser.fExpDA_return fExpDA345 =null;

        PddlParser.fExpDA_return fExpDA347 =null;

        PddlParser.fExp_return fExp350 =null;


        Object char_literal342_tree=null;
        Object char_literal346_tree=null;
        Object char_literal348_tree=null;
        Object string_literal349_tree=null;

        try {
            // Pddl.g:427:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                int LA64_1 = input.LA(2);

                if ( (synpred102_Pddl()) ) {
                    alt64=1;
                }
                else if ( (true) ) {
                    alt64=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
                }
                break;
            case 94:
                {
                alt64=2;
                }
                break;
            case NAME:
            case NUMBER:
            case 60:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // Pddl.g:427:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal342=(Token)match(input,61,FOLLOW_61_in_fExpDA2669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal342_tree = 
                    (Object)adaptor.create(char_literal342)
                    ;
                    adaptor.addChild(root_0, char_literal342_tree);
                    }

                    // Pddl.g:427:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==65) ) {
                        int LA63_1 = input.LA(2);

                        if ( (synpred101_Pddl()) ) {
                            alt63=1;
                        }
                        else if ( (true) ) {
                            alt63=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 63, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( ((LA63_0 >= 63 && LA63_0 <= 64)||LA63_0==66) ) {
                        alt63=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;

                    }
                    switch (alt63) {
                        case 1 :
                            // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
                            {
                            // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
                            // Pddl.g:427:10: binaryOp fExpDA fExpDA
                            {
                            pushFollow(FOLLOW_binaryOp_in_fExpDA2673);
                            binaryOp343=binaryOp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp343.getTree());

                            pushFollow(FOLLOW_fExpDA_in_fExpDA2675);
                            fExpDA344=fExpDA();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA344.getTree());

                            pushFollow(FOLLOW_fExpDA_in_fExpDA2677);
                            fExpDA345=fExpDA();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA345.getTree());

                            }


                            }
                            break;
                        case 2 :
                            // Pddl.g:427:36: ( '-' fExpDA )
                            {
                            // Pddl.g:427:36: ( '-' fExpDA )
                            // Pddl.g:427:37: '-' fExpDA
                            {
                            char_literal346=(Token)match(input,65,FOLLOW_65_in_fExpDA2683); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal346_tree = 
                            (Object)adaptor.create(char_literal346)
                            ;
                            adaptor.addChild(root_0, char_literal346_tree);
                            }

                            pushFollow(FOLLOW_fExpDA_in_fExpDA2685);
                            fExpDA347=fExpDA();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA347.getTree());

                            }


                            }
                            break;

                    }


                    char_literal348=(Token)match(input,62,FOLLOW_62_in_fExpDA2689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal348_tree = 
                    (Object)adaptor.create(char_literal348)
                    ;
                    adaptor.addChild(root_0, char_literal348_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:428:4: '?duration'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal349=(Token)match(input,94,FOLLOW_94_in_fExpDA2694); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal349_tree = 
                    (Object)adaptor.create(string_literal349)
                    ;
                    adaptor.addChild(root_0, string_literal349_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:429:4: fExp
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_fExp_in_fExpDA2699);
                    fExp350=fExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp350.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fExpDA"


    public static class problem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "problem"
    // Pddl.g:434:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
    public final PddlParser.problem_return problem() throws RecognitionException {
        PddlParser.problem_return retval = new PddlParser.problem_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal351=null;
        Token string_literal352=null;
        Token char_literal361=null;
        PddlParser.problemDecl_return problemDecl353 =null;

        PddlParser.problemDomain_return problemDomain354 =null;

        PddlParser.requireDef_return requireDef355 =null;

        PddlParser.objectDecl_return objectDecl356 =null;

        PddlParser.init_return init357 =null;

        PddlParser.goal_return goal358 =null;

        PddlParser.probConstraints_return probConstraints359 =null;

        PddlParser.metricSpec_return metricSpec360 =null;


        Object char_literal351_tree=null;
        Object string_literal352_tree=null;
        Object char_literal361_tree=null;
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
        RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
        RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");
        RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
        RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
        RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
        RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
        RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");
        try {
            // Pddl.g:435:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
            // Pddl.g:435:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
            {
            char_literal351=(Token)match(input,61,FOLLOW_61_in_problem2713); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal351);


            string_literal352=(Token)match(input,103,FOLLOW_103_in_problem2715); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_103.add(string_literal352);


            pushFollow(FOLLOW_problemDecl_in_problem2717);
            problemDecl353=problemDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl353.getTree());

            pushFollow(FOLLOW_problemDomain_in_problem2722);
            problemDomain354=problemDomain();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain354.getTree());

            // Pddl.g:437:7: ( requireDef )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==61) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==87) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // Pddl.g:437:7: requireDef
                    {
                    pushFollow(FOLLOW_requireDef_in_problem2730);
                    requireDef355=requireDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_requireDef.add(requireDef355.getTree());

                    }
                    break;

            }


            // Pddl.g:438:7: ( objectDecl )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==61) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==82) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // Pddl.g:438:7: objectDecl
                    {
                    pushFollow(FOLLOW_objectDecl_in_problem2739);
                    objectDecl356=objectDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl356.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_init_in_problem2748);
            init357=init();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_init.add(init357.getTree());

            pushFollow(FOLLOW_goal_in_problem2756);
            goal358=goal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_goal.add(goal358.getTree());

            // Pddl.g:441:7: ( probConstraints )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==61) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==71) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // Pddl.g:441:7: probConstraints
                    {
                    pushFollow(FOLLOW_probConstraints_in_problem2764);
                    probConstraints359=probConstraints();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints359.getTree());

                    }
                    break;

            }


            // Pddl.g:442:7: ( metricSpec )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==61) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // Pddl.g:442:7: metricSpec
                    {
                    pushFollow(FOLLOW_metricSpec_in_problem2773);
                    metricSpec360=metricSpec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec360.getTree());

                    }
                    break;

            }


            char_literal361=(Token)match(input,62,FOLLOW_62_in_problem2789); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal361);


            // AST REWRITE
            // elements: objectDecl, problemDecl, probConstraints, metricSpec, init, problemDomain, requireDef, goal
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 445:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
            {
                // Pddl.g:445:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROBLEM, "PROBLEM")
                , root_1);

                adaptor.addChild(root_1, stream_problemDecl.nextTree());

                adaptor.addChild(root_1, stream_problemDomain.nextTree());

                // Pddl.g:445:46: ( requireDef )?
                if ( stream_requireDef.hasNext() ) {
                    adaptor.addChild(root_1, stream_requireDef.nextTree());

                }
                stream_requireDef.reset();

                // Pddl.g:445:58: ( objectDecl )?
                if ( stream_objectDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_objectDecl.nextTree());

                }
                stream_objectDecl.reset();

                adaptor.addChild(root_1, stream_init.nextTree());

                adaptor.addChild(root_1, stream_goal.nextTree());

                // Pddl.g:446:19: ( probConstraints )?
                if ( stream_probConstraints.hasNext() ) {
                    adaptor.addChild(root_1, stream_probConstraints.nextTree());

                }
                stream_probConstraints.reset();

                // Pddl.g:446:36: ( metricSpec )?
                if ( stream_metricSpec.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problem"


    public static class problemDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "problemDecl"
    // Pddl.g:449:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
    public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
        PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal362=null;
        Token string_literal363=null;
        Token NAME364=null;
        Token char_literal365=null;

        Object char_literal362_tree=null;
        Object string_literal363_tree=null;
        Object NAME364_tree=null;
        Object char_literal365_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // Pddl.g:450:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
            // Pddl.g:450:7: '(' 'problem' NAME ')'
            {
            char_literal362=(Token)match(input,61,FOLLOW_61_in_problemDecl2846); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal362);


            string_literal363=(Token)match(input,121,FOLLOW_121_in_problemDecl2848); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(string_literal363);


            NAME364=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2850); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME364);


            char_literal365=(Token)match(input,62,FOLLOW_62_in_problemDecl2852); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal365);


            // AST REWRITE
            // elements: NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 451:5: -> ^( PROBLEM_NAME NAME )
            {
                // Pddl.g:451:8: ^( PROBLEM_NAME NAME )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROBLEM_NAME, "PROBLEM_NAME")
                , root_1);

                adaptor.addChild(root_1, 
                stream_NAME.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problemDecl"


    public static class problemDomain_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "problemDomain"
    // Pddl.g:454:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
    public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
        PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal366=null;
        Token string_literal367=null;
        Token NAME368=null;
        Token char_literal369=null;

        Object char_literal366_tree=null;
        Object string_literal367_tree=null;
        Object NAME368_tree=null;
        Object char_literal369_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // Pddl.g:455:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
            // Pddl.g:455:4: '(' ':domain' NAME ')'
            {
            char_literal366=(Token)match(input,61,FOLLOW_61_in_problemDomain2878); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal366);


            string_literal367=(Token)match(input,73,FOLLOW_73_in_problemDomain2880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_73.add(string_literal367);


            NAME368=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain2882); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(NAME368);


            char_literal369=(Token)match(input,62,FOLLOW_62_in_problemDomain2884); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal369);


            // AST REWRITE
            // elements: NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 456:2: -> ^( PROBLEM_DOMAIN NAME )
            {
                // Pddl.g:456:5: ^( PROBLEM_DOMAIN NAME )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROBLEM_DOMAIN, "PROBLEM_DOMAIN")
                , root_1);

                adaptor.addChild(root_1, 
                stream_NAME.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "problemDomain"


    public static class objectDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectDecl"
    // Pddl.g:459:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
    public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
        PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal370=null;
        Token string_literal371=null;
        Token char_literal373=null;
        PddlParser.typedNameList_return typedNameList372 =null;


        Object char_literal370_tree=null;
        Object string_literal371_tree=null;
        Object char_literal373_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");
        try {
            // Pddl.g:460:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
            // Pddl.g:460:4: '(' ':objects' typedNameList ')'
            {
            char_literal370=(Token)match(input,61,FOLLOW_61_in_objectDecl2904); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal370);


            string_literal371=(Token)match(input,82,FOLLOW_82_in_objectDecl2906); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_82.add(string_literal371);


            pushFollow(FOLLOW_typedNameList_in_objectDecl2908);
            typedNameList372=typedNameList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList372.getTree());

            char_literal373=(Token)match(input,62,FOLLOW_62_in_objectDecl2910); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal373);


            // AST REWRITE
            // elements: typedNameList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 461:2: -> ^( OBJECTS typedNameList )
            {
                // Pddl.g:461:5: ^( OBJECTS typedNameList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(OBJECTS, "OBJECTS")
                , root_1);

                adaptor.addChild(root_1, stream_typedNameList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objectDecl"


    public static class init_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "init"
    // Pddl.g:464:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
    public final PddlParser.init_return init() throws RecognitionException {
        PddlParser.init_return retval = new PddlParser.init_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal374=null;
        Token string_literal375=null;
        Token char_literal377=null;
        PddlParser.initEl_return initEl376 =null;


        Object char_literal374_tree=null;
        Object string_literal375_tree=null;
        Object char_literal377_tree=null;
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");
        try {
            // Pddl.g:465:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
            // Pddl.g:465:4: '(' ':init' ( initEl )* ')'
            {
            char_literal374=(Token)match(input,61,FOLLOW_61_in_init2930); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal374);


            string_literal375=(Token)match(input,80,FOLLOW_80_in_init2932); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_80.add(string_literal375);


            // Pddl.g:465:16: ( initEl )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==61) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // Pddl.g:465:16: initEl
            	    {
            	    pushFollow(FOLLOW_initEl_in_init2934);
            	    initEl376=initEl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_initEl.add(initEl376.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            char_literal377=(Token)match(input,62,FOLLOW_62_in_init2937); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal377);


            // AST REWRITE
            // elements: initEl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 466:2: -> ^( INIT ( initEl )* )
            {
                // Pddl.g:466:5: ^( INIT ( initEl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(INIT, "INIT")
                , root_1);

                // Pddl.g:466:12: ( initEl )*
                while ( stream_initEl.hasNext() ) {
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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "init"


    public static class initEl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "initEl"
    // Pddl.g:469:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
    public final PddlParser.initEl_return initEl() throws RecognitionException {
        PddlParser.initEl_return retval = new PddlParser.initEl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal379=null;
        Token char_literal380=null;
        Token NUMBER382=null;
        Token char_literal383=null;
        Token char_literal384=null;
        Token string_literal385=null;
        Token NUMBER386=null;
        Token char_literal388=null;
        PddlParser.nameLiteral_return nameLiteral378 =null;

        PddlParser.fHead_return fHead381 =null;

        PddlParser.nameLiteral_return nameLiteral387 =null;


        Object char_literal379_tree=null;
        Object char_literal380_tree=null;
        Object NUMBER382_tree=null;
        Object char_literal383_tree=null;
        Object char_literal384_tree=null;
        Object string_literal385_tree=null;
        Object NUMBER386_tree=null;
        Object char_literal388_tree=null;
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
        RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");
        try {
            // Pddl.g:470:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
            int alt70=3;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==61) ) {
                switch ( input.LA(2) ) {
                case NAME:
                case 116:
                    {
                    alt70=1;
                    }
                    break;
                case 91:
                    {
                    alt70=2;
                    }
                    break;
                case 100:
                    {
                    alt70=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // Pddl.g:470:4: nameLiteral
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_nameLiteral_in_initEl2958);
                    nameLiteral378=nameLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral378.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:471:4: '(' '=' fHead NUMBER ')'
                    {
                    char_literal379=(Token)match(input,61,FOLLOW_61_in_initEl2963); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal379);


                    char_literal380=(Token)match(input,91,FOLLOW_91_in_initEl2965); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_91.add(char_literal380);


                    pushFollow(FOLLOW_fHead_in_initEl2967);
                    fHead381=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fHead.add(fHead381.getTree());

                    NUMBER382=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2969); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER382);


                    char_literal383=(Token)match(input,62,FOLLOW_62_in_initEl2971); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal383);


                    // AST REWRITE
                    // elements: fHead, NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 471:37: -> ^( INIT_EQ fHead NUMBER )
                    {
                        // Pddl.g:471:40: ^( INIT_EQ fHead NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(INIT_EQ, "INIT_EQ")
                        , root_1);

                        adaptor.addChild(root_1, stream_fHead.nextTree());

                        adaptor.addChild(root_1, 
                        stream_NUMBER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:472:4: '(' 'at' NUMBER nameLiteral ')'
                    {
                    char_literal384=(Token)match(input,61,FOLLOW_61_in_initEl2994); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal384);


                    string_literal385=(Token)match(input,100,FOLLOW_100_in_initEl2996); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_100.add(string_literal385);


                    NUMBER386=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2998); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER386);


                    pushFollow(FOLLOW_nameLiteral_in_initEl3000);
                    nameLiteral387=nameLiteral();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral387.getTree());

                    char_literal388=(Token)match(input,62,FOLLOW_62_in_initEl3002); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal388);


                    // AST REWRITE
                    // elements: NUMBER, nameLiteral
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 472:37: -> ^( INIT_AT NUMBER nameLiteral )
                    {
                        // Pddl.g:472:40: ^( INIT_AT NUMBER nameLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(INIT_AT, "INIT_AT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_NUMBER.nextNode()
                        );

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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initEl"


    public static class nameLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nameLiteral"
    // Pddl.g:475:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
    public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
        PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal390=null;
        Token string_literal391=null;
        Token char_literal393=null;
        PddlParser.atomicNameFormula_return atomicNameFormula389 =null;

        PddlParser.atomicNameFormula_return atomicNameFormula392 =null;


        Object char_literal390_tree=null;
        Object string_literal391_tree=null;
        Object char_literal393_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");
        try {
            // Pddl.g:476:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==61) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==116) ) {
                    alt71=2;
                }
                else if ( (LA71_1==NAME) ) {
                    alt71=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // Pddl.g:476:4: atomicNameFormula
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3024);
                    atomicNameFormula389=atomicNameFormula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula389.getTree());

                    }
                    break;
                case 2 :
                    // Pddl.g:477:4: '(' 'not' atomicNameFormula ')'
                    {
                    char_literal390=(Token)match(input,61,FOLLOW_61_in_nameLiteral3029); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal390);


                    string_literal391=(Token)match(input,116,FOLLOW_116_in_nameLiteral3031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_116.add(string_literal391);


                    pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3033);
                    atomicNameFormula392=atomicNameFormula();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula392.getTree());

                    char_literal393=(Token)match(input,62,FOLLOW_62_in_nameLiteral3035); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal393);


                    // AST REWRITE
                    // elements: atomicNameFormula
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 477:36: -> ^( NOT_PRED_INIT atomicNameFormula )
                    {
                        // Pddl.g:477:39: ^( NOT_PRED_INIT atomicNameFormula )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(NOT_PRED_INIT, "NOT_PRED_INIT")
                        , root_1);

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


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nameLiteral"


    public static class atomicNameFormula_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atomicNameFormula"
    // Pddl.g:480:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
    public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
        PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal394=null;
        Token NAME396=null;
        Token char_literal397=null;
        PddlParser.predicate_return predicate395 =null;


        Object char_literal394_tree=null;
        Object NAME396_tree=null;
        Object char_literal397_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        try {
            // Pddl.g:481:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
            // Pddl.g:481:4: '(' predicate ( NAME )* ')'
            {
            char_literal394=(Token)match(input,61,FOLLOW_61_in_atomicNameFormula3054); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal394);


            pushFollow(FOLLOW_predicate_in_atomicNameFormula3056);
            predicate395=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_predicate.add(predicate395.getTree());

            // Pddl.g:481:18: ( NAME )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==NAME) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // Pddl.g:481:18: NAME
            	    {
            	    NAME396=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula3058); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(NAME396);


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            char_literal397=(Token)match(input,62,FOLLOW_62_in_atomicNameFormula3061); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal397);


            // AST REWRITE
            // elements: predicate, NAME
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 481:28: -> ^( PRED_INST predicate ( NAME )* )
            {
                // Pddl.g:481:31: ^( PRED_INST predicate ( NAME )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PRED_INST, "PRED_INST")
                , root_1);

                adaptor.addChild(root_1, stream_predicate.nextTree());

                // Pddl.g:481:53: ( NAME )*
                while ( stream_NAME.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_NAME.nextNode()
                    );

                }
                stream_NAME.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atomicNameFormula"


    public static class goal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "goal"
    // Pddl.g:488:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
    public final PddlParser.goal_return goal() throws RecognitionException {
        PddlParser.goal_return retval = new PddlParser.goal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal398=null;
        Token string_literal399=null;
        Token char_literal401=null;
        PddlParser.goalDesc_return goalDesc400 =null;


        Object char_literal398_tree=null;
        Object string_literal399_tree=null;
        Object char_literal401_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
        try {
            // Pddl.g:488:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
            // Pddl.g:488:8: '(' ':goal' goalDesc ')'
            {
            char_literal398=(Token)match(input,61,FOLLOW_61_in_goal3086); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal398);


            string_literal399=(Token)match(input,79,FOLLOW_79_in_goal3088); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_79.add(string_literal399);


            pushFollow(FOLLOW_goalDesc_in_goal3090);
            goalDesc400=goalDesc();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc400.getTree());

            char_literal401=(Token)match(input,62,FOLLOW_62_in_goal3092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal401);


            // AST REWRITE
            // elements: goalDesc
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 488:33: -> ^( GOAL goalDesc )
            {
                // Pddl.g:488:36: ^( GOAL goalDesc )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(GOAL, "GOAL")
                , root_1);

                adaptor.addChild(root_1, stream_goalDesc.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "goal"


    public static class probConstraints_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "probConstraints"
    // Pddl.g:490:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
    public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
        PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal402=null;
        Token string_literal403=null;
        Token char_literal405=null;
        PddlParser.prefConGD_return prefConGD404 =null;


        Object char_literal402_tree=null;
        Object string_literal403_tree=null;
        Object char_literal405_tree=null;
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");
        try {
            // Pddl.g:491:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
            // Pddl.g:491:4: '(' ':constraints' prefConGD ')'
            {
            char_literal402=(Token)match(input,61,FOLLOW_61_in_probConstraints3110); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal402);


            string_literal403=(Token)match(input,71,FOLLOW_71_in_probConstraints3112); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal403);


            pushFollow(FOLLOW_prefConGD_in_probConstraints3115);
            prefConGD404=prefConGD();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD404.getTree());

            char_literal405=(Token)match(input,62,FOLLOW_62_in_probConstraints3117); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal405);


            // AST REWRITE
            // elements: prefConGD
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 492:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
            {
                // Pddl.g:492:7: ^( PROBLEM_CONSTRAINT prefConGD )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROBLEM_CONSTRAINT, "PROBLEM_CONSTRAINT")
                , root_1);

                adaptor.addChild(root_1, stream_prefConGD.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "probConstraints"


    public static class prefConGD_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prefConGD"
    // Pddl.g:495:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
    public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
        PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal406=null;
        Token string_literal407=null;
        Token char_literal409=null;
        Token char_literal410=null;
        Token string_literal411=null;
        Token char_literal412=null;
        Token char_literal414=null;
        Token char_literal416=null;
        Token char_literal417=null;
        Token string_literal418=null;
        Token NAME419=null;
        Token char_literal421=null;
        PddlParser.prefConGD_return prefConGD408 =null;

        PddlParser.typedVariableList_return typedVariableList413 =null;

        PddlParser.prefConGD_return prefConGD415 =null;

        PddlParser.conGD_return conGD420 =null;

        PddlParser.conGD_return conGD422 =null;


        Object char_literal406_tree=null;
        Object string_literal407_tree=null;
        Object char_literal409_tree=null;
        Object char_literal410_tree=null;
        Object string_literal411_tree=null;
        Object char_literal412_tree=null;
        Object char_literal414_tree=null;
        Object char_literal416_tree=null;
        Object char_literal417_tree=null;
        Object string_literal418_tree=null;
        Object NAME419_tree=null;
        Object char_literal421_tree=null;

        try {
            // Pddl.g:496:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
            int alt75=4;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==61) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred114_Pddl()) ) {
                    alt75=1;
                }
                else if ( (synpred115_Pddl()) ) {
                    alt75=2;
                }
                else if ( (synpred117_Pddl()) ) {
                    alt75=3;
                }
                else if ( (true) ) {
                    alt75=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // Pddl.g:496:4: '(' 'and' ( prefConGD )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal406=(Token)match(input,61,FOLLOW_61_in_prefConGD3139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal406_tree = 
                    (Object)adaptor.create(char_literal406)
                    ;
                    adaptor.addChild(root_0, char_literal406_tree);
                    }

                    string_literal407=(Token)match(input,98,FOLLOW_98_in_prefConGD3141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal407_tree = 
                    (Object)adaptor.create(string_literal407)
                    ;
                    adaptor.addChild(root_0, string_literal407_tree);
                    }

                    // Pddl.g:496:14: ( prefConGD )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==61) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // Pddl.g:496:14: prefConGD
                    	    {
                    	    pushFollow(FOLLOW_prefConGD_in_prefConGD3143);
                    	    prefConGD408=prefConGD();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD408.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    char_literal409=(Token)match(input,62,FOLLOW_62_in_prefConGD3146); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal409_tree = 
                    (Object)adaptor.create(char_literal409)
                    ;
                    adaptor.addChild(root_0, char_literal409_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:497:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal410=(Token)match(input,61,FOLLOW_61_in_prefConGD3151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal410_tree = 
                    (Object)adaptor.create(char_literal410)
                    ;
                    adaptor.addChild(root_0, char_literal410_tree);
                    }

                    string_literal411=(Token)match(input,108,FOLLOW_108_in_prefConGD3153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal411_tree = 
                    (Object)adaptor.create(string_literal411)
                    ;
                    adaptor.addChild(root_0, string_literal411_tree);
                    }

                    char_literal412=(Token)match(input,61,FOLLOW_61_in_prefConGD3155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal412_tree = 
                    (Object)adaptor.create(char_literal412)
                    ;
                    adaptor.addChild(root_0, char_literal412_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_prefConGD3157);
                    typedVariableList413=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList413.getTree());

                    char_literal414=(Token)match(input,62,FOLLOW_62_in_prefConGD3159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal414_tree = 
                    (Object)adaptor.create(char_literal414)
                    ;
                    adaptor.addChild(root_0, char_literal414_tree);
                    }

                    pushFollow(FOLLOW_prefConGD_in_prefConGD3161);
                    prefConGD415=prefConGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD415.getTree());

                    char_literal416=(Token)match(input,62,FOLLOW_62_in_prefConGD3163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal416_tree = 
                    (Object)adaptor.create(char_literal416)
                    ;
                    adaptor.addChild(root_0, char_literal416_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:498:4: '(' 'preference' ( NAME )? conGD ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal417=(Token)match(input,61,FOLLOW_61_in_prefConGD3168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal417_tree = 
                    (Object)adaptor.create(char_literal417)
                    ;
                    adaptor.addChild(root_0, char_literal417_tree);
                    }

                    string_literal418=(Token)match(input,120,FOLLOW_120_in_prefConGD3170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal418_tree = 
                    (Object)adaptor.create(string_literal418)
                    ;
                    adaptor.addChild(root_0, string_literal418_tree);
                    }

                    // Pddl.g:498:21: ( NAME )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==NAME) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // Pddl.g:498:21: NAME
                            {
                            NAME419=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3172); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NAME419_tree = 
                            (Object)adaptor.create(NAME419)
                            ;
                            adaptor.addChild(root_0, NAME419_tree);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_conGD_in_prefConGD3175);
                    conGD420=conGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD420.getTree());

                    char_literal421=(Token)match(input,62,FOLLOW_62_in_prefConGD3177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal421_tree = 
                    (Object)adaptor.create(char_literal421)
                    ;
                    adaptor.addChild(root_0, char_literal421_tree);
                    }

                    }
                    break;
                case 4 :
                    // Pddl.g:499:4: conGD
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_conGD_in_prefConGD3182);
                    conGD422=conGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD422.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prefConGD"


    public static class metricSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metricSpec"
    // Pddl.g:502:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
    public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
        PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal423=null;
        Token string_literal424=null;
        Token char_literal427=null;
        PddlParser.optimization_return optimization425 =null;

        PddlParser.metricFExp_return metricFExp426 =null;


        Object char_literal423_tree=null;
        Object string_literal424_tree=null;
        Object char_literal427_tree=null;
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
        RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");
        try {
            // Pddl.g:503:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
            // Pddl.g:503:4: '(' ':metric' optimization metricFExp ')'
            {
            char_literal423=(Token)match(input,61,FOLLOW_61_in_metricSpec3193); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(char_literal423);


            string_literal424=(Token)match(input,81,FOLLOW_81_in_metricSpec3195); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_81.add(string_literal424);


            pushFollow(FOLLOW_optimization_in_metricSpec3197);
            optimization425=optimization();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_optimization.add(optimization425.getTree());

            pushFollow(FOLLOW_metricFExp_in_metricSpec3199);
            metricFExp426=metricFExp();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp426.getTree());

            char_literal427=(Token)match(input,62,FOLLOW_62_in_metricSpec3201); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal427);


            // AST REWRITE
            // elements: optimization, metricFExp
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 504:4: -> ^( PROBLEM_METRIC optimization metricFExp )
            {
                // Pddl.g:504:7: ^( PROBLEM_METRIC optimization metricFExp )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROBLEM_METRIC, "PROBLEM_METRIC")
                , root_1);

                adaptor.addChild(root_1, stream_optimization.nextTree());

                adaptor.addChild(root_1, stream_metricFExp.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metricSpec"


    public static class optimization_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "optimization"
    // Pddl.g:507:1: optimization : ( 'minimize' | 'maximize' );
    public final PddlParser.optimization_return optimization() throws RecognitionException {
        PddlParser.optimization_return retval = new PddlParser.optimization_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set428=null;

        Object set428_tree=null;

        try {
            // Pddl.g:507:14: ( 'minimize' | 'maximize' )
            // Pddl.g:
            {
            root_0 = (Object)adaptor.nil();


            set428=(Token)input.LT(1);

            if ( (input.LA(1) >= 114 && input.LA(1) <= 115) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set428)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optimization"


    public static class metricFExp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "metricFExp"
    // Pddl.g:509:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
    public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
        PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal429=null;
        Token char_literal433=null;
        Token char_literal434=null;
        Token char_literal438=null;
        Token char_literal439=null;
        Token char_literal440=null;
        Token char_literal442=null;
        Token NUMBER443=null;
        Token char_literal445=null;
        Token string_literal446=null;
        Token NAME447=null;
        Token char_literal448=null;
        PddlParser.binaryOp_return binaryOp430 =null;

        PddlParser.metricFExp_return metricFExp431 =null;

        PddlParser.metricFExp_return metricFExp432 =null;

        PddlParser.multiOp_return multiOp435 =null;

        PddlParser.metricFExp_return metricFExp436 =null;

        PddlParser.metricFExp_return metricFExp437 =null;

        PddlParser.metricFExp_return metricFExp441 =null;

        PddlParser.fHead_return fHead444 =null;


        Object char_literal429_tree=null;
        Object char_literal433_tree=null;
        Object char_literal434_tree=null;
        Object char_literal438_tree=null;
        Object char_literal439_tree=null;
        Object char_literal440_tree=null;
        Object char_literal442_tree=null;
        Object NUMBER443_tree=null;
        Object char_literal445_tree=null;
        Object string_literal446_tree=null;
        Object NAME447_tree=null;
        Object char_literal448_tree=null;
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
        RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
        RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");
        try {
            // Pddl.g:510:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
            int alt77=6;
            switch ( input.LA(1) ) {
            case 61:
                {
                int LA77_1 = input.LA(2);

                if ( (synpred119_Pddl()) ) {
                    alt77=1;
                }
                else if ( (synpred121_Pddl()) ) {
                    alt77=2;
                }
                else if ( (synpred122_Pddl()) ) {
                    alt77=3;
                }
                else if ( (synpred124_Pddl()) ) {
                    alt77=5;
                }
                else if ( (true) ) {
                    alt77=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 1, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                alt77=4;
                }
                break;
            case NAME:
            case 60:
                {
                alt77=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }

            switch (alt77) {
                case 1 :
                    // Pddl.g:510:4: '(' binaryOp metricFExp metricFExp ')'
                    {
                    char_literal429=(Token)match(input,61,FOLLOW_61_in_metricFExp3238); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal429);


                    pushFollow(FOLLOW_binaryOp_in_metricFExp3240);
                    binaryOp430=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp430.getTree());

                    pushFollow(FOLLOW_metricFExp_in_metricFExp3242);
                    metricFExp431=metricFExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp431.getTree());

                    pushFollow(FOLLOW_metricFExp_in_metricFExp3244);
                    metricFExp432=metricFExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp432.getTree());

                    char_literal433=(Token)match(input,62,FOLLOW_62_in_metricFExp3246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal433);


                    // AST REWRITE
                    // elements: metricFExp, metricFExp, binaryOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 511:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
                    {
                        // Pddl.g:511:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(BINARY_OP, "BINARY_OP")
                        , root_1);

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
                case 2 :
                    // Pddl.g:512:4: '(' multiOp metricFExp ( metricFExp )+ ')'
                    {
                    char_literal434=(Token)match(input,61,FOLLOW_61_in_metricFExp3268); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal434);


                    pushFollow(FOLLOW_multiOp_in_metricFExp3270);
                    multiOp435=multiOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_multiOp.add(multiOp435.getTree());

                    pushFollow(FOLLOW_metricFExp_in_metricFExp3272);
                    metricFExp436=metricFExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp436.getTree());

                    // Pddl.g:512:27: ( metricFExp )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==NAME||LA76_0==NUMBER||(LA76_0 >= 60 && LA76_0 <= 61)) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // Pddl.g:512:27: metricFExp
                    	    {
                    	    pushFollow(FOLLOW_metricFExp_in_metricFExp3274);
                    	    metricFExp437=metricFExp();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp437.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);


                    char_literal438=(Token)match(input,62,FOLLOW_62_in_metricFExp3277); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal438);


                    // AST REWRITE
                    // elements: metricFExp, metricFExp, multiOp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 513:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
                    {
                        // Pddl.g:513:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(MULTI_OP, "MULTI_OP")
                        , root_1);

                        adaptor.addChild(root_1, stream_multiOp.nextTree());

                        adaptor.addChild(root_1, stream_metricFExp.nextTree());

                        if ( !(stream_metricFExp.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_metricFExp.hasNext() ) {
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
                case 3 :
                    // Pddl.g:514:4: '(' '-' metricFExp ')'
                    {
                    char_literal439=(Token)match(input,61,FOLLOW_61_in_metricFExp3301); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(char_literal439);


                    char_literal440=(Token)match(input,65,FOLLOW_65_in_metricFExp3303); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(char_literal440);


                    pushFollow(FOLLOW_metricFExp_in_metricFExp3305);
                    metricFExp441=metricFExp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp441.getTree());

                    char_literal442=(Token)match(input,62,FOLLOW_62_in_metricFExp3307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal442);


                    // AST REWRITE
                    // elements: metricFExp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 515:4: -> ^( MINUS_OP metricFExp )
                    {
                        // Pddl.g:515:7: ^( MINUS_OP metricFExp )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(MINUS_OP, "MINUS_OP")
                        , root_1);

                        adaptor.addChild(root_1, stream_metricFExp.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // Pddl.g:516:4: NUMBER
                    {
                    root_0 = (Object)adaptor.nil();


                    NUMBER443=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER443_tree = 
                    (Object)adaptor.create(NUMBER443)
                    ;
                    adaptor.addChild(root_0, NUMBER443_tree);
                    }

                    }
                    break;
                case 5 :
                    // Pddl.g:517:4: fHead
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_fHead_in_metricFExp3329);
                    fHead444=fHead();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead444.getTree());

                    }
                    break;
                case 6 :
                    // Pddl.g:519:4: '(' 'is-violated' NAME ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal445=(Token)match(input,61,FOLLOW_61_in_metricFExp3344); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal445_tree = 
                    (Object)adaptor.create(char_literal445)
                    ;
                    adaptor.addChild(root_0, char_literal445_tree);
                    }

                    string_literal446=(Token)match(input,113,FOLLOW_113_in_metricFExp3346); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal446_tree = 
                    (Object)adaptor.create(string_literal446)
                    ;
                    adaptor.addChild(root_0, string_literal446_tree);
                    }

                    NAME447=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME447_tree = 
                    (Object)adaptor.create(NAME447)
                    ;
                    adaptor.addChild(root_0, NAME447_tree);
                    }

                    char_literal448=(Token)match(input,62,FOLLOW_62_in_metricFExp3350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal448_tree = 
                    (Object)adaptor.create(char_literal448)
                    ;
                    adaptor.addChild(root_0, char_literal448_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "metricFExp"


    public static class conGD_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "conGD"
    // Pddl.g:524:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
    public final PddlParser.conGD_return conGD() throws RecognitionException {
        PddlParser.conGD_return retval = new PddlParser.conGD_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal449=null;
        Token string_literal450=null;
        Token char_literal452=null;
        Token char_literal453=null;
        Token string_literal454=null;
        Token char_literal455=null;
        Token char_literal457=null;
        Token char_literal459=null;
        Token char_literal460=null;
        Token string_literal461=null;
        Token string_literal462=null;
        Token char_literal464=null;
        Token char_literal465=null;
        Token string_literal466=null;
        Token char_literal468=null;
        Token char_literal469=null;
        Token string_literal470=null;
        Token char_literal472=null;
        Token char_literal473=null;
        Token string_literal474=null;
        Token NUMBER475=null;
        Token char_literal477=null;
        Token char_literal478=null;
        Token string_literal479=null;
        Token char_literal481=null;
        Token char_literal482=null;
        Token string_literal483=null;
        Token char_literal486=null;
        Token char_literal487=null;
        Token string_literal488=null;
        Token char_literal491=null;
        Token char_literal492=null;
        Token string_literal493=null;
        Token NUMBER494=null;
        Token char_literal497=null;
        Token char_literal498=null;
        Token string_literal499=null;
        Token NUMBER500=null;
        Token NUMBER501=null;
        Token char_literal503=null;
        Token char_literal504=null;
        Token string_literal505=null;
        Token NUMBER506=null;
        Token char_literal508=null;
        PddlParser.conGD_return conGD451 =null;

        PddlParser.typedVariableList_return typedVariableList456 =null;

        PddlParser.conGD_return conGD458 =null;

        PddlParser.goalDesc_return goalDesc463 =null;

        PddlParser.goalDesc_return goalDesc467 =null;

        PddlParser.goalDesc_return goalDesc471 =null;

        PddlParser.goalDesc_return goalDesc476 =null;

        PddlParser.goalDesc_return goalDesc480 =null;

        PddlParser.goalDesc_return goalDesc484 =null;

        PddlParser.goalDesc_return goalDesc485 =null;

        PddlParser.goalDesc_return goalDesc489 =null;

        PddlParser.goalDesc_return goalDesc490 =null;

        PddlParser.goalDesc_return goalDesc495 =null;

        PddlParser.goalDesc_return goalDesc496 =null;

        PddlParser.goalDesc_return goalDesc502 =null;

        PddlParser.goalDesc_return goalDesc507 =null;


        Object char_literal449_tree=null;
        Object string_literal450_tree=null;
        Object char_literal452_tree=null;
        Object char_literal453_tree=null;
        Object string_literal454_tree=null;
        Object char_literal455_tree=null;
        Object char_literal457_tree=null;
        Object char_literal459_tree=null;
        Object char_literal460_tree=null;
        Object string_literal461_tree=null;
        Object string_literal462_tree=null;
        Object char_literal464_tree=null;
        Object char_literal465_tree=null;
        Object string_literal466_tree=null;
        Object char_literal468_tree=null;
        Object char_literal469_tree=null;
        Object string_literal470_tree=null;
        Object char_literal472_tree=null;
        Object char_literal473_tree=null;
        Object string_literal474_tree=null;
        Object NUMBER475_tree=null;
        Object char_literal477_tree=null;
        Object char_literal478_tree=null;
        Object string_literal479_tree=null;
        Object char_literal481_tree=null;
        Object char_literal482_tree=null;
        Object string_literal483_tree=null;
        Object char_literal486_tree=null;
        Object char_literal487_tree=null;
        Object string_literal488_tree=null;
        Object char_literal491_tree=null;
        Object char_literal492_tree=null;
        Object string_literal493_tree=null;
        Object NUMBER494_tree=null;
        Object char_literal497_tree=null;
        Object char_literal498_tree=null;
        Object string_literal499_tree=null;
        Object NUMBER500_tree=null;
        Object NUMBER501_tree=null;
        Object char_literal503_tree=null;
        Object char_literal504_tree=null;
        Object string_literal505_tree=null;
        Object NUMBER506_tree=null;
        Object char_literal508_tree=null;

        try {
            // Pddl.g:525:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
            int alt79=12;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==61) ) {
                switch ( input.LA(2) ) {
                case 98:
                    {
                    alt79=1;
                    }
                    break;
                case 108:
                    {
                    alt79=2;
                    }
                    break;
                case 100:
                    {
                    alt79=3;
                    }
                    break;
                case 96:
                    {
                    alt79=4;
                    }
                    break;
                case 124:
                    {
                    alt79=5;
                    }
                    break;
                case 129:
                    {
                    alt79=6;
                    }
                    break;
                case 101:
                    {
                    alt79=7;
                    }
                    break;
                case 125:
                    {
                    alt79=8;
                    }
                    break;
                case 126:
                    {
                    alt79=9;
                    }
                    break;
                case 97:
                    {
                    alt79=10;
                    }
                    break;
                case 110:
                    {
                    alt79=11;
                    }
                    break;
                case 109:
                    {
                    alt79=12;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }
            switch (alt79) {
                case 1 :
                    // Pddl.g:525:4: '(' 'and' ( conGD )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal449=(Token)match(input,61,FOLLOW_61_in_conGD3364); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal449_tree = 
                    (Object)adaptor.create(char_literal449)
                    ;
                    adaptor.addChild(root_0, char_literal449_tree);
                    }

                    string_literal450=(Token)match(input,98,FOLLOW_98_in_conGD3366); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal450_tree = 
                    (Object)adaptor.create(string_literal450)
                    ;
                    adaptor.addChild(root_0, string_literal450_tree);
                    }

                    // Pddl.g:525:14: ( conGD )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==61) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // Pddl.g:525:14: conGD
                    	    {
                    	    pushFollow(FOLLOW_conGD_in_conGD3368);
                    	    conGD451=conGD();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD451.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);


                    char_literal452=(Token)match(input,62,FOLLOW_62_in_conGD3371); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal452_tree = 
                    (Object)adaptor.create(char_literal452)
                    ;
                    adaptor.addChild(root_0, char_literal452_tree);
                    }

                    }
                    break;
                case 2 :
                    // Pddl.g:526:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal453=(Token)match(input,61,FOLLOW_61_in_conGD3376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal453_tree = 
                    (Object)adaptor.create(char_literal453)
                    ;
                    adaptor.addChild(root_0, char_literal453_tree);
                    }

                    string_literal454=(Token)match(input,108,FOLLOW_108_in_conGD3378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal454_tree = 
                    (Object)adaptor.create(string_literal454)
                    ;
                    adaptor.addChild(root_0, string_literal454_tree);
                    }

                    char_literal455=(Token)match(input,61,FOLLOW_61_in_conGD3380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal455_tree = 
                    (Object)adaptor.create(char_literal455)
                    ;
                    adaptor.addChild(root_0, char_literal455_tree);
                    }

                    pushFollow(FOLLOW_typedVariableList_in_conGD3382);
                    typedVariableList456=typedVariableList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList456.getTree());

                    char_literal457=(Token)match(input,62,FOLLOW_62_in_conGD3384); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal457_tree = 
                    (Object)adaptor.create(char_literal457)
                    ;
                    adaptor.addChild(root_0, char_literal457_tree);
                    }

                    pushFollow(FOLLOW_conGD_in_conGD3386);
                    conGD458=conGD();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD458.getTree());

                    char_literal459=(Token)match(input,62,FOLLOW_62_in_conGD3388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal459_tree = 
                    (Object)adaptor.create(char_literal459)
                    ;
                    adaptor.addChild(root_0, char_literal459_tree);
                    }

                    }
                    break;
                case 3 :
                    // Pddl.g:527:4: '(' 'at' 'end' goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal460=(Token)match(input,61,FOLLOW_61_in_conGD3393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal460_tree = 
                    (Object)adaptor.create(char_literal460)
                    ;
                    adaptor.addChild(root_0, char_literal460_tree);
                    }

                    string_literal461=(Token)match(input,100,FOLLOW_100_in_conGD3395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal461_tree = 
                    (Object)adaptor.create(string_literal461)
                    ;
                    adaptor.addChild(root_0, string_literal461_tree);
                    }

                    string_literal462=(Token)match(input,106,FOLLOW_106_in_conGD3397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal462_tree = 
                    (Object)adaptor.create(string_literal462)
                    ;
                    adaptor.addChild(root_0, string_literal462_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3399);
                    goalDesc463=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc463.getTree());

                    char_literal464=(Token)match(input,62,FOLLOW_62_in_conGD3401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal464_tree = 
                    (Object)adaptor.create(char_literal464)
                    ;
                    adaptor.addChild(root_0, char_literal464_tree);
                    }

                    }
                    break;
                case 4 :
                    // Pddl.g:528:25: '(' 'always' goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal465=(Token)match(input,61,FOLLOW_61_in_conGD3427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal465_tree = 
                    (Object)adaptor.create(char_literal465)
                    ;
                    adaptor.addChild(root_0, char_literal465_tree);
                    }

                    string_literal466=(Token)match(input,96,FOLLOW_96_in_conGD3429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal466_tree = 
                    (Object)adaptor.create(string_literal466)
                    ;
                    adaptor.addChild(root_0, string_literal466_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3431);
                    goalDesc467=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc467.getTree());

                    char_literal468=(Token)match(input,62,FOLLOW_62_in_conGD3433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal468_tree = 
                    (Object)adaptor.create(char_literal468)
                    ;
                    adaptor.addChild(root_0, char_literal468_tree);
                    }

                    }
                    break;
                case 5 :
                    // Pddl.g:529:4: '(' 'sometime' goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal469=(Token)match(input,61,FOLLOW_61_in_conGD3438); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal469_tree = 
                    (Object)adaptor.create(char_literal469)
                    ;
                    adaptor.addChild(root_0, char_literal469_tree);
                    }

                    string_literal470=(Token)match(input,124,FOLLOW_124_in_conGD3440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal470_tree = 
                    (Object)adaptor.create(string_literal470)
                    ;
                    adaptor.addChild(root_0, string_literal470_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3442);
                    goalDesc471=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc471.getTree());

                    char_literal472=(Token)match(input,62,FOLLOW_62_in_conGD3444); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal472_tree = 
                    (Object)adaptor.create(char_literal472)
                    ;
                    adaptor.addChild(root_0, char_literal472_tree);
                    }

                    }
                    break;
                case 6 :
                    // Pddl.g:530:5: '(' 'within' NUMBER goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal473=(Token)match(input,61,FOLLOW_61_in_conGD3450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal473_tree = 
                    (Object)adaptor.create(char_literal473)
                    ;
                    adaptor.addChild(root_0, char_literal473_tree);
                    }

                    string_literal474=(Token)match(input,129,FOLLOW_129_in_conGD3452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal474_tree = 
                    (Object)adaptor.create(string_literal474)
                    ;
                    adaptor.addChild(root_0, string_literal474_tree);
                    }

                    NUMBER475=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3454); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER475_tree = 
                    (Object)adaptor.create(NUMBER475)
                    ;
                    adaptor.addChild(root_0, NUMBER475_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3456);
                    goalDesc476=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc476.getTree());

                    char_literal477=(Token)match(input,62,FOLLOW_62_in_conGD3458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal477_tree = 
                    (Object)adaptor.create(char_literal477)
                    ;
                    adaptor.addChild(root_0, char_literal477_tree);
                    }

                    }
                    break;
                case 7 :
                    // Pddl.g:531:4: '(' 'at-most-once' goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal478=(Token)match(input,61,FOLLOW_61_in_conGD3463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal478_tree = 
                    (Object)adaptor.create(char_literal478)
                    ;
                    adaptor.addChild(root_0, char_literal478_tree);
                    }

                    string_literal479=(Token)match(input,101,FOLLOW_101_in_conGD3465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal479_tree = 
                    (Object)adaptor.create(string_literal479)
                    ;
                    adaptor.addChild(root_0, string_literal479_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3467);
                    goalDesc480=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc480.getTree());

                    char_literal481=(Token)match(input,62,FOLLOW_62_in_conGD3469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal481_tree = 
                    (Object)adaptor.create(char_literal481)
                    ;
                    adaptor.addChild(root_0, char_literal481_tree);
                    }

                    }
                    break;
                case 8 :
                    // Pddl.g:532:4: '(' 'sometime-after' goalDesc goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal482=(Token)match(input,61,FOLLOW_61_in_conGD3474); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal482_tree = 
                    (Object)adaptor.create(char_literal482)
                    ;
                    adaptor.addChild(root_0, char_literal482_tree);
                    }

                    string_literal483=(Token)match(input,125,FOLLOW_125_in_conGD3476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal483_tree = 
                    (Object)adaptor.create(string_literal483)
                    ;
                    adaptor.addChild(root_0, string_literal483_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3478);
                    goalDesc484=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc484.getTree());

                    pushFollow(FOLLOW_goalDesc_in_conGD3480);
                    goalDesc485=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc485.getTree());

                    char_literal486=(Token)match(input,62,FOLLOW_62_in_conGD3482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal486_tree = 
                    (Object)adaptor.create(char_literal486)
                    ;
                    adaptor.addChild(root_0, char_literal486_tree);
                    }

                    }
                    break;
                case 9 :
                    // Pddl.g:533:4: '(' 'sometime-before' goalDesc goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal487=(Token)match(input,61,FOLLOW_61_in_conGD3487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal487_tree = 
                    (Object)adaptor.create(char_literal487)
                    ;
                    adaptor.addChild(root_0, char_literal487_tree);
                    }

                    string_literal488=(Token)match(input,126,FOLLOW_126_in_conGD3489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal488_tree = 
                    (Object)adaptor.create(string_literal488)
                    ;
                    adaptor.addChild(root_0, string_literal488_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3491);
                    goalDesc489=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc489.getTree());

                    pushFollow(FOLLOW_goalDesc_in_conGD3493);
                    goalDesc490=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc490.getTree());

                    char_literal491=(Token)match(input,62,FOLLOW_62_in_conGD3495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal491_tree = 
                    (Object)adaptor.create(char_literal491)
                    ;
                    adaptor.addChild(root_0, char_literal491_tree);
                    }

                    }
                    break;
                case 10 :
                    // Pddl.g:534:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal492=(Token)match(input,61,FOLLOW_61_in_conGD3500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal492_tree = 
                    (Object)adaptor.create(char_literal492)
                    ;
                    adaptor.addChild(root_0, char_literal492_tree);
                    }

                    string_literal493=(Token)match(input,97,FOLLOW_97_in_conGD3502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal493_tree = 
                    (Object)adaptor.create(string_literal493)
                    ;
                    adaptor.addChild(root_0, string_literal493_tree);
                    }

                    NUMBER494=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER494_tree = 
                    (Object)adaptor.create(NUMBER494)
                    ;
                    adaptor.addChild(root_0, NUMBER494_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3506);
                    goalDesc495=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc495.getTree());

                    pushFollow(FOLLOW_goalDesc_in_conGD3508);
                    goalDesc496=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc496.getTree());

                    char_literal497=(Token)match(input,62,FOLLOW_62_in_conGD3510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal497_tree = 
                    (Object)adaptor.create(char_literal497)
                    ;
                    adaptor.addChild(root_0, char_literal497_tree);
                    }

                    }
                    break;
                case 11 :
                    // Pddl.g:535:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal498=(Token)match(input,61,FOLLOW_61_in_conGD3515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal498_tree = 
                    (Object)adaptor.create(char_literal498)
                    ;
                    adaptor.addChild(root_0, char_literal498_tree);
                    }

                    string_literal499=(Token)match(input,110,FOLLOW_110_in_conGD3517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal499_tree = 
                    (Object)adaptor.create(string_literal499)
                    ;
                    adaptor.addChild(root_0, string_literal499_tree);
                    }

                    NUMBER500=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER500_tree = 
                    (Object)adaptor.create(NUMBER500)
                    ;
                    adaptor.addChild(root_0, NUMBER500_tree);
                    }

                    NUMBER501=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER501_tree = 
                    (Object)adaptor.create(NUMBER501)
                    ;
                    adaptor.addChild(root_0, NUMBER501_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3523);
                    goalDesc502=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc502.getTree());

                    char_literal503=(Token)match(input,62,FOLLOW_62_in_conGD3525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal503_tree = 
                    (Object)adaptor.create(char_literal503)
                    ;
                    adaptor.addChild(root_0, char_literal503_tree);
                    }

                    }
                    break;
                case 12 :
                    // Pddl.g:536:4: '(' 'hold-after' NUMBER goalDesc ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal504=(Token)match(input,61,FOLLOW_61_in_conGD3530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal504_tree = 
                    (Object)adaptor.create(char_literal504)
                    ;
                    adaptor.addChild(root_0, char_literal504_tree);
                    }

                    string_literal505=(Token)match(input,109,FOLLOW_109_in_conGD3532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal505_tree = 
                    (Object)adaptor.create(string_literal505)
                    ;
                    adaptor.addChild(root_0, string_literal505_tree);
                    }

                    NUMBER506=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUMBER506_tree = 
                    (Object)adaptor.create(NUMBER506)
                    ;
                    adaptor.addChild(root_0, NUMBER506_tree);
                    }

                    pushFollow(FOLLOW_goalDesc_in_conGD3536);
                    goalDesc507=goalDesc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc507.getTree());

                    char_literal508=(Token)match(input,62,FOLLOW_62_in_conGD3538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal508_tree = 
                    (Object)adaptor.create(char_literal508)
                    ;
                    adaptor.addChild(root_0, char_literal508_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "conGD"

    // $ANTLR start synpred18_Pddl
    public final void synpred18_Pddl_fragment() throws RecognitionException {
        // Pddl.g:159:5: ( atomicFunctionSkeleton )
        // Pddl.g:159:5: atomicFunctionSkeleton
        {
        pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl795);
        atomicFunctionSkeleton();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred18_Pddl

    // $ANTLR start synpred47_Pddl
    public final void synpred47_Pddl_fragment() throws RecognitionException {
        // Pddl.g:276:7: ( fComp )
        // Pddl.g:276:7: fComp
        {
        pushFollow(FOLLOW_fComp_in_synpred47_Pddl1626);
        fComp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred47_Pddl

    // $ANTLR start synpred50_Pddl
    public final void synpred50_Pddl_fragment() throws RecognitionException {
        // Pddl.g:299:28: ( typedVariableList )
        // Pddl.g:299:28: typedVariableList
        {
        pushFollow(FOLLOW_typedVariableList_in_synpred50_Pddl1785);
        typedVariableList();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred50_Pddl

    // $ANTLR start synpred63_Pddl
    public final void synpred63_Pddl_fragment() throws RecognitionException {
        // Pddl.g:339:4: ( '(' binaryOp fExp fExp2 ')' )
        // Pddl.g:339:4: '(' binaryOp fExp fExp2 ')'
        {
        match(input,61,FOLLOW_61_in_synpred63_Pddl2041); if (state.failed) return ;

        pushFollow(FOLLOW_binaryOp_in_synpred63_Pddl2043);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_fExp_in_synpred63_Pddl2045);
        fExp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_fExp2_in_synpred63_Pddl2047);
        fExp2();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred63_Pddl2049); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred63_Pddl

    // $ANTLR start synpred64_Pddl
    public final void synpred64_Pddl_fragment() throws RecognitionException {
        // Pddl.g:340:4: ( '(' '-' fExp ')' )
        // Pddl.g:340:4: '(' '-' fExp ')'
        {
        match(input,61,FOLLOW_61_in_synpred64_Pddl2066); if (state.failed) return ;

        match(input,65,FOLLOW_65_in_synpred64_Pddl2068); if (state.failed) return ;

        pushFollow(FOLLOW_fExp_in_synpred64_Pddl2070);
        fExp();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred64_Pddl2072); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred64_Pddl

    // $ANTLR start synpred93_Pddl
    public final void synpred93_Pddl_fragment() throws RecognitionException {
        // Pddl.g:406:12: ( NUMBER )
        // Pddl.g:406:12: NUMBER
        {
        match(input,NUMBER,FOLLOW_NUMBER_in_synpred93_Pddl2511); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred93_Pddl

    // $ANTLR start synpred95_Pddl
    public final void synpred95_Pddl_fragment() throws RecognitionException {
        // Pddl.g:409:4: ( '(' 'and' ( daEffect )* ')' )
        // Pddl.g:409:4: '(' 'and' ( daEffect )* ')'
        {
        match(input,61,FOLLOW_61_in_synpred95_Pddl2525); if (state.failed) return ;

        match(input,98,FOLLOW_98_in_synpred95_Pddl2527); if (state.failed) return ;

        // Pddl.g:409:14: ( daEffect )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==61) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // Pddl.g:409:14: daEffect
        	    {
        	    pushFollow(FOLLOW_daEffect_in_synpred95_Pddl2529);
        	    daEffect();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);


        match(input,62,FOLLOW_62_in_synpred95_Pddl2532); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred95_Pddl

    // $ANTLR start synpred96_Pddl
    public final void synpred96_Pddl_fragment() throws RecognitionException {
        // Pddl.g:410:4: ( timedEffect )
        // Pddl.g:410:4: timedEffect
        {
        pushFollow(FOLLOW_timedEffect_in_synpred96_Pddl2537);
        timedEffect();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_Pddl

    // $ANTLR start synpred97_Pddl
    public final void synpred97_Pddl_fragment() throws RecognitionException {
        // Pddl.g:411:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
        // Pddl.g:411:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
        {
        match(input,61,FOLLOW_61_in_synpred97_Pddl2542); if (state.failed) return ;

        match(input,108,FOLLOW_108_in_synpred97_Pddl2544); if (state.failed) return ;

        match(input,61,FOLLOW_61_in_synpred97_Pddl2546); if (state.failed) return ;

        pushFollow(FOLLOW_typedVariableList_in_synpred97_Pddl2548);
        typedVariableList();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred97_Pddl2550); if (state.failed) return ;

        pushFollow(FOLLOW_daEffect_in_synpred97_Pddl2552);
        daEffect();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred97_Pddl2554); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred97_Pddl

    // $ANTLR start synpred98_Pddl
    public final void synpred98_Pddl_fragment() throws RecognitionException {
        // Pddl.g:412:4: ( '(' 'when' daGD timedEffect ')' )
        // Pddl.g:412:4: '(' 'when' daGD timedEffect ')'
        {
        match(input,61,FOLLOW_61_in_synpred98_Pddl2559); if (state.failed) return ;

        match(input,128,FOLLOW_128_in_synpred98_Pddl2561); if (state.failed) return ;

        pushFollow(FOLLOW_daGD_in_synpred98_Pddl2563);
        daGD();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_timedEffect_in_synpred98_Pddl2565);
        timedEffect();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred98_Pddl2567); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred98_Pddl

    // $ANTLR start synpred99_Pddl
    public final void synpred99_Pddl_fragment() throws RecognitionException {
        // Pddl.g:417:4: ( '(' 'at' timeSpecifier daEffect ')' )
        // Pddl.g:417:4: '(' 'at' timeSpecifier daEffect ')'
        {
        match(input,61,FOLLOW_61_in_synpred99_Pddl2591); if (state.failed) return ;

        match(input,100,FOLLOW_100_in_synpred99_Pddl2593); if (state.failed) return ;

        pushFollow(FOLLOW_timeSpecifier_in_synpred99_Pddl2595);
        timeSpecifier();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_daEffect_in_synpred99_Pddl2597);
        daEffect();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred99_Pddl2599); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_Pddl

    // $ANTLR start synpred100_Pddl
    public final void synpred100_Pddl_fragment() throws RecognitionException {
        // Pddl.g:418:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
        // Pddl.g:418:4: '(' 'at' timeSpecifier fAssignDA ')'
        {
        match(input,61,FOLLOW_61_in_synpred100_Pddl2609); if (state.failed) return ;

        match(input,100,FOLLOW_100_in_synpred100_Pddl2611); if (state.failed) return ;

        pushFollow(FOLLOW_timeSpecifier_in_synpred100_Pddl2613);
        timeSpecifier();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_fAssignDA_in_synpred100_Pddl2615);
        fAssignDA();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred100_Pddl2617); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred100_Pddl

    // $ANTLR start synpred101_Pddl
    public final void synpred101_Pddl_fragment() throws RecognitionException {
        // Pddl.g:427:9: ( ( binaryOp fExpDA fExpDA ) )
        // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
        {
        // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
        // Pddl.g:427:10: binaryOp fExpDA fExpDA
        {
        pushFollow(FOLLOW_binaryOp_in_synpred101_Pddl2673);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_fExpDA_in_synpred101_Pddl2675);
        fExpDA();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_fExpDA_in_synpred101_Pddl2677);
        fExpDA();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred101_Pddl

    // $ANTLR start synpred102_Pddl
    public final void synpred102_Pddl_fragment() throws RecognitionException {
        // Pddl.g:427:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
        // Pddl.g:427:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
        {
        match(input,61,FOLLOW_61_in_synpred102_Pddl2669); if (state.failed) return ;

        // Pddl.g:427:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
        int alt97=2;
        int LA97_0 = input.LA(1);

        if ( (LA97_0==65) ) {
            int LA97_1 = input.LA(2);

            if ( (synpred101_Pddl()) ) {
                alt97=1;
            }
            else if ( (true) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 1, input);

                throw nvae;

            }
        }
        else if ( ((LA97_0 >= 63 && LA97_0 <= 64)||LA97_0==66) ) {
            alt97=1;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 97, 0, input);

            throw nvae;

        }
        switch (alt97) {
            case 1 :
                // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
                {
                // Pddl.g:427:9: ( binaryOp fExpDA fExpDA )
                // Pddl.g:427:10: binaryOp fExpDA fExpDA
                {
                pushFollow(FOLLOW_binaryOp_in_synpred102_Pddl2673);
                binaryOp();

                state._fsp--;
                if (state.failed) return ;

                pushFollow(FOLLOW_fExpDA_in_synpred102_Pddl2675);
                fExpDA();

                state._fsp--;
                if (state.failed) return ;

                pushFollow(FOLLOW_fExpDA_in_synpred102_Pddl2677);
                fExpDA();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // Pddl.g:427:36: ( '-' fExpDA )
                {
                // Pddl.g:427:36: ( '-' fExpDA )
                // Pddl.g:427:37: '-' fExpDA
                {
                match(input,65,FOLLOW_65_in_synpred102_Pddl2683); if (state.failed) return ;

                pushFollow(FOLLOW_fExpDA_in_synpred102_Pddl2685);
                fExpDA();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }


        match(input,62,FOLLOW_62_in_synpred102_Pddl2689); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred102_Pddl

    // $ANTLR start synpred114_Pddl
    public final void synpred114_Pddl_fragment() throws RecognitionException {
        // Pddl.g:496:4: ( '(' 'and' ( prefConGD )* ')' )
        // Pddl.g:496:4: '(' 'and' ( prefConGD )* ')'
        {
        match(input,61,FOLLOW_61_in_synpred114_Pddl3139); if (state.failed) return ;

        match(input,98,FOLLOW_98_in_synpred114_Pddl3141); if (state.failed) return ;

        // Pddl.g:496:14: ( prefConGD )*
        loop98:
        do {
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==61) ) {
                alt98=1;
            }


            switch (alt98) {
        	case 1 :
        	    // Pddl.g:496:14: prefConGD
        	    {
        	    pushFollow(FOLLOW_prefConGD_in_synpred114_Pddl3143);
        	    prefConGD();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop98;
            }
        } while (true);


        match(input,62,FOLLOW_62_in_synpred114_Pddl3146); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_Pddl

    // $ANTLR start synpred115_Pddl
    public final void synpred115_Pddl_fragment() throws RecognitionException {
        // Pddl.g:497:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
        // Pddl.g:497:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
        {
        match(input,61,FOLLOW_61_in_synpred115_Pddl3151); if (state.failed) return ;

        match(input,108,FOLLOW_108_in_synpred115_Pddl3153); if (state.failed) return ;

        match(input,61,FOLLOW_61_in_synpred115_Pddl3155); if (state.failed) return ;

        pushFollow(FOLLOW_typedVariableList_in_synpred115_Pddl3157);
        typedVariableList();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred115_Pddl3159); if (state.failed) return ;

        pushFollow(FOLLOW_prefConGD_in_synpred115_Pddl3161);
        prefConGD();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred115_Pddl3163); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_Pddl

    // $ANTLR start synpred117_Pddl
    public final void synpred117_Pddl_fragment() throws RecognitionException {
        // Pddl.g:498:4: ( '(' 'preference' ( NAME )? conGD ')' )
        // Pddl.g:498:4: '(' 'preference' ( NAME )? conGD ')'
        {
        match(input,61,FOLLOW_61_in_synpred117_Pddl3168); if (state.failed) return ;

        match(input,120,FOLLOW_120_in_synpred117_Pddl3170); if (state.failed) return ;

        // Pddl.g:498:21: ( NAME )?
        int alt99=2;
        int LA99_0 = input.LA(1);

        if ( (LA99_0==NAME) ) {
            alt99=1;
        }
        switch (alt99) {
            case 1 :
                // Pddl.g:498:21: NAME
                {
                match(input,NAME,FOLLOW_NAME_in_synpred117_Pddl3172); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_conGD_in_synpred117_Pddl3175);
        conGD();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred117_Pddl3177); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_Pddl

    // $ANTLR start synpred119_Pddl
    public final void synpred119_Pddl_fragment() throws RecognitionException {
        // Pddl.g:510:4: ( '(' binaryOp metricFExp metricFExp ')' )
        // Pddl.g:510:4: '(' binaryOp metricFExp metricFExp ')'
        {
        match(input,61,FOLLOW_61_in_synpred119_Pddl3238); if (state.failed) return ;

        pushFollow(FOLLOW_binaryOp_in_synpred119_Pddl3240);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_metricFExp_in_synpred119_Pddl3242);
        metricFExp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_metricFExp_in_synpred119_Pddl3244);
        metricFExp();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred119_Pddl3246); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_Pddl

    // $ANTLR start synpred121_Pddl
    public final void synpred121_Pddl_fragment() throws RecognitionException {
        // Pddl.g:512:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
        // Pddl.g:512:4: '(' multiOp metricFExp ( metricFExp )+ ')'
        {
        match(input,61,FOLLOW_61_in_synpred121_Pddl3268); if (state.failed) return ;

        pushFollow(FOLLOW_multiOp_in_synpred121_Pddl3270);
        multiOp();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_metricFExp_in_synpred121_Pddl3272);
        metricFExp();

        state._fsp--;
        if (state.failed) return ;

        // Pddl.g:512:27: ( metricFExp )+
        int cnt100=0;
        loop100:
        do {
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==NAME||LA100_0==NUMBER||(LA100_0 >= 60 && LA100_0 <= 61)) ) {
                alt100=1;
            }


            switch (alt100) {
        	case 1 :
        	    // Pddl.g:512:27: metricFExp
        	    {
        	    pushFollow(FOLLOW_metricFExp_in_synpred121_Pddl3274);
        	    metricFExp();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt100 >= 1 ) break loop100;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(100, input);
                    throw eee;
            }
            cnt100++;
        } while (true);


        match(input,62,FOLLOW_62_in_synpred121_Pddl3277); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_Pddl

    // $ANTLR start synpred122_Pddl
    public final void synpred122_Pddl_fragment() throws RecognitionException {
        // Pddl.g:514:4: ( '(' '-' metricFExp ')' )
        // Pddl.g:514:4: '(' '-' metricFExp ')'
        {
        match(input,61,FOLLOW_61_in_synpred122_Pddl3301); if (state.failed) return ;

        match(input,65,FOLLOW_65_in_synpred122_Pddl3303); if (state.failed) return ;

        pushFollow(FOLLOW_metricFExp_in_synpred122_Pddl3305);
        metricFExp();

        state._fsp--;
        if (state.failed) return ;

        match(input,62,FOLLOW_62_in_synpred122_Pddl3307); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_Pddl

    // $ANTLR start synpred124_Pddl
    public final void synpred124_Pddl_fragment() throws RecognitionException {
        // Pddl.g:517:4: ( fHead )
        // Pddl.g:517:4: fHead
        {
        pushFollow(FOLLOW_fHead_in_synpred124_Pddl3329);
        fHead();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred124_Pddl

    // Delegated rules

    public final boolean synpred63_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred95_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_Pddl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_Pddl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA14_eotS =
        "\4\uffff";
    static final String DFA14_eofS =
        "\4\uffff";
    static final String DFA14_minS =
        "\2\44\2\uffff";
    static final String DFA14_maxS =
        "\1\76\1\101\2\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA14_specialS =
        "\4\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\31\uffff\1\2",
            "\1\1\31\uffff\1\2\2\uffff\1\3",
            "",
            ""
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
            return "137:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
        }
    }
    static final String DFA12_eotS =
        "\4\uffff";
    static final String DFA12_eofS =
        "\4\uffff";
    static final String DFA12_minS =
        "\2\44\2\uffff";
    static final String DFA12_maxS =
        "\1\76\1\101\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\31\uffff\1\2",
            "\1\1\31\uffff\1\2\2\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()+ loopback of 137:16: ( singleTypeNameList )+";
        }
    }
    static final String DFA25_eotS =
        "\4\uffff";
    static final String DFA25_eofS =
        "\2\2\2\uffff";
    static final String DFA25_minS =
        "\2\71\2\uffff";
    static final String DFA25_maxS =
        "\1\76\1\101\2\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA25_specialS =
        "\4\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\3\uffff\2\2",
            "\1\1\3\uffff\2\2\2\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "188:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
        }
    }
    static final String DFA23_eotS =
        "\4\uffff";
    static final String DFA23_eofS =
        "\2\2\2\uffff";
    static final String DFA23_minS =
        "\2\71\2\uffff";
    static final String DFA23_maxS =
        "\1\76\1\101\2\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA23_specialS =
        "\4\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\3\uffff\2\2",
            "\1\1\3\uffff\2\2\2\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()+ loopback of 188:20: ( singleTypeVarList )+";
        }
    }
 

    public static final BitSet FOLLOW_domain_in_pddlDoc348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_problem_in_pddlDoc352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_domain367 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_domain369 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_domainName_in_domain371 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_requireDef_in_domain379 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_typesDef_in_domain388 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_constantsDef_in_domain397 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_predicatesDef_in_domain406 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_functionsDef_in_domain415 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_free_functionsDef_in_domain424 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_constraints_in_domain433 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_structureDef_in_domain442 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_domain451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_free_functionsDef535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_free_functionsDef537 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_functionList_in_free_functionsDef539 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_free_functionsDef541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_domainName564 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_domainName566 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NAME_in_domainName568 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_domainName570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_requireDef597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_requireDef599 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef601 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_62_in_requireDef604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_typesDef625 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_typesDef627 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_typedNameList_in_typesDef629 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_typesDef631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_typedNameList658 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList663 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_NAME_in_typedNameList666 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_NAME_in_singleTypeNameList686 = new BitSet(new long[]{0x0000001000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_singleTypeNameList689 = new BitSet(new long[]{0x2000001000000000L});
    public static final BitSet FOLLOW_type_in_singleTypeNameList693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_type720 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_type722 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_primType_in_type724 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_62_in_type727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primType_in_type748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_primType758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_functionsDef768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_functionsDef770 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_functionList_in_functionsDef772 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_functionsDef774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList795 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_functionList799 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_functionType_in_functionList801 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_atomicFunctionSkeleton817 = new BitSet(new long[]{0x1000001000000000L});
    public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton820 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton823 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_atomicFunctionSkeleton825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_functionType848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_constantsDef859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_constantsDef861 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_typedNameList_in_constantsDef863 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_constantsDef865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_predicatesDef885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_predicatesDef887 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef889 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_predicatesDef892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_atomicFormulaSkeleton913 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton916 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton919 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_atomicFormulaSkeleton921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_predicate932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_typedVariableList947 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList952 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_typedVariableList955 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList975 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_singleTypeVarList978 = new BitSet(new long[]{0x2000001000000000L});
    public static final BitSet FOLLOW_type_in_singleTypeVarList982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_constraints1013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_constraints1016 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_conGD_in_constraints1019 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_constraints1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actionDef_in_structureDef1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_durativeActionDef_in_structureDef1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedDef_in_structureDef1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constraintDef_in_structureDef1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_processDef_in_structureDef1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_actionDef1068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_actionDef1070 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_actionSymbol_in_actionDef1072 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_actionDef1081 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_actionDef1084 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_actionDef1086 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_actionDef1088 = new BitSet(new long[]{0x4000000000000000L,0x0000000000101000L});
    public static final BitSet FOLLOW_actionDefBody_in_actionDef1101 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_actionDef1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_processDef1136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_processDef1138 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_actionSymbol_in_processDef1140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_processDef1149 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_processDef1152 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_processDef1154 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_processDef1156 = new BitSet(new long[]{0x4000000000000000L,0x0000000000101000L});
    public static final BitSet FOLLOW_actionDefBody_in_processDef1169 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_processDef1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_constraintDef1205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_constraintDef1207 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_constraintDef1218 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_constraintDef1221 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_constraintDef1223 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_constraintDef1225 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1238 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_constraintDef1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_actionSymbol1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_constraintSymbol1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_actionDefBody1298 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_actionDefBody1302 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_actionDefBody1304 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_goalDesc_in_actionDefBody1309 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_actionDefBody1319 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_actionDefBody1323 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_actionDefBody1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_effect_in_actionDefBody1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_constraintDefBody1365 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_constraintDefBody1369 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_constraintDefBody1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1419 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_goalDesc1421 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1423 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1451 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_goalDesc1453 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1455 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1483 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_goalDesc1485 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1487 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1513 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_goalDesc1515 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1517 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1519 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1547 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_goalDesc1549 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_goalDesc1551 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_goalDesc1553 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1555 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1557 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goalDesc1585 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_goalDesc1587 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_goalDesc1589 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_goalDesc1591 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1593 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goalDesc1595 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goalDesc1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fComp_in_goalDesc1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equality_in_goalDesc1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_equality1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_equality1684 = new BitSet(new long[]{0x0200001000000000L});
    public static final BitSet FOLLOW_term_in_equality1686 = new BitSet(new long[]{0x0200001000000000L});
    public static final BitSet FOLLOW_term_in_equality1688 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_equality1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fComp1701 = new BitSet(new long[]{0x0000000000000000L,0x000000003E000000L});
    public static final BitSet FOLLOW_binaryComp_in_fComp1704 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_fComp1706 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_fComp1708 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_fComp1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_atomicTermFormula1722 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_predicate_in_atomicTermFormula1724 = new BitSet(new long[]{0x4200001000000000L});
    public static final BitSet FOLLOW_term_in_atomicTermFormula1726 = new BitSet(new long[]{0x4200001000000000L});
    public static final BitSet FOLLOW_62_in_atomicTermFormula1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_durativeActionDef1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_durativeActionDef1768 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_durativeActionDef1779 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_durativeActionDef1782 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1785 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_durativeActionDef1789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001410L});
    public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1802 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_durativeActionDef1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_daDefBody1837 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_durationConstraint_in_daDefBody1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_daDefBody1844 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_daDefBody1848 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daDefBody1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_daGD_in_daDefBody1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_daDefBody1864 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_daDefBody1868 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daDefBody1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_daEffect_in_daDefBody1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefTimedGD_in_daGD1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daGD1895 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_daGD1897 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_daGD_in_daGD1899 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_daGD1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daGD1907 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_daGD1909 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_daGD1911 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_daGD1913 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daGD1915 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daGD_in_daGD1917 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daGD1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedGD_in_prefTimedGD1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_prefTimedGD1935 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_prefTimedGD1937 = new BitSet(new long[]{0x2000001000000000L});
    public static final BitSet FOLLOW_NAME_in_prefTimedGD1939 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_timedGD_in_prefTimedGD1942 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_prefTimedGD1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_timedGD1955 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_timedGD1957 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedGD1959 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_timedGD1961 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_timedGD1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_timedGD1968 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_timedGD1970 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_interval_in_timedGD1972 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_timedGD1974 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_timedGD1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_interval1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_derivedDef2011 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_derivedDef2014 = new BitSet(new long[]{0x2200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_derivedDef2017 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_derivedDef2019 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_derivedDef2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_fExp2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fExp2041 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_fExp2043 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_fExp2045 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp2_in_fExp2047 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_fExp2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fExp2066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_fExp2068 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_fExp2070 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_fExp2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_fExp2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_fExp22097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fHead2107 = new BitSet(new long[]{0x1000001000000000L});
    public static final BitSet FOLLOW_functionSymbol_in_fHead2109 = new BitSet(new long[]{0x4200001000000000L});
    public static final BitSet FOLLOW_term_in_fHead2111 = new BitSet(new long[]{0x4200001000000000L});
    public static final BitSet FOLLOW_62_in_fHead2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSymbol_in_fHead2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_effect2149 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_effect2151 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_cEffect_in_effect2153 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_effect2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cEffect_in_effect2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_cEffect2181 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_cEffect2183 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_cEffect2185 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_cEffect2187 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_cEffect2189 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_effect_in_cEffect2191 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_cEffect2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_cEffect2211 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_cEffect2213 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_cEffect2215 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_condEffect_in_cEffect2217 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_cEffect2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pEffect_in_cEffect2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_pEffect2248 = new BitSet(new long[]{0x0000000000000000L,0x0C01004800000000L});
    public static final BitSet FOLLOW_assignOp_in_pEffect2250 = new BitSet(new long[]{0x3000001000000000L});
    public static final BitSet FOLLOW_fHead_in_pEffect2252 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_pEffect2254 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_pEffect2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_pEffect2276 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_pEffect2278 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2280 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_pEffect2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_condEffect2311 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_condEffect2313 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_pEffect_in_condEffect2315 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_condEffect2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pEffect_in_condEffect2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_durationConstraint2433 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_durationConstraint2435 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2437 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_durationConstraint2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_durationConstraint2445 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_durationConstraint2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_simpleDurationConstraint2463 = new BitSet(new long[]{0x0000000000000000L,0x000000002C000000L});
    public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2465 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_simpleDurationConstraint2467 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2469 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_simpleDurationConstraint2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_simpleDurationConstraint2476 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_simpleDurationConstraint2478 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2480 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2482 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_simpleDurationConstraint2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_durValue2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_durValue2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daEffect2525 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_daEffect2527 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_daEffect2529 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_daEffect2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedEffect_in_daEffect2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daEffect2542 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_daEffect2544 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_daEffect2546 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_daEffect2548 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daEffect2550 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_daEffect2552 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daEffect2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daEffect2559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_daEffect2561 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daGD_in_daEffect2563 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_timedEffect_in_daEffect2565 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daEffect2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_daEffect2572 = new BitSet(new long[]{0x0000000000000000L,0x0C01004800000000L});
    public static final BitSet FOLLOW_assignOp_in_daEffect2574 = new BitSet(new long[]{0x3000001000000000L});
    public static final BitSet FOLLOW_fHead_in_daEffect2576 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_daEffect2578 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_daEffect2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_timedEffect2591 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_timedEffect2593 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2595 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_timedEffect2597 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_timedEffect2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_timedEffect2609 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_timedEffect2611 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2613 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_fAssignDA_in_timedEffect2615 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_timedEffect2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_timedEffect2622 = new BitSet(new long[]{0x0000000000000000L,0x0C01004800000000L});
    public static final BitSet FOLLOW_assignOp_in_timedEffect2624 = new BitSet(new long[]{0x3000001000000000L});
    public static final BitSet FOLLOW_fHead_in_timedEffect2626 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_timedEffect2628 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_timedEffect2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fAssignDA2650 = new BitSet(new long[]{0x0000000000000000L,0x0C01004800000000L});
    public static final BitSet FOLLOW_assignOp_in_fAssignDA2652 = new BitSet(new long[]{0x3000001000000000L});
    public static final BitSet FOLLOW_fHead_in_fAssignDA2654 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_fAssignDA2656 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_fAssignDA2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_fExpDA2669 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_fExpDA2673 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2675 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2677 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_65_in_fExpDA2683 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_fExpDA2685 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_fExpDA2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_fExpDA2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fExp_in_fExpDA2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_problem2713 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_problem2715 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_problemDecl_in_problem2717 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_problemDomain_in_problem2722 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_requireDef_in_problem2730 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_objectDecl_in_problem2739 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_init_in_problem2748 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goal_in_problem2756 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_probConstraints_in_problem2764 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_metricSpec_in_problem2773 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_problem2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_problemDecl2846 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_problemDecl2848 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NAME_in_problemDecl2850 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_problemDecl2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_problemDomain2878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_problemDomain2880 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NAME_in_problemDomain2882 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_problemDomain2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_objectDecl2904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_objectDecl2906 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_typedNameList_in_objectDecl2908 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_objectDecl2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_init2930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_init2932 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_initEl_in_init2934 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_init2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameLiteral_in_initEl2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_initEl2963 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_initEl2965 = new BitSet(new long[]{0x3000001000000000L});
    public static final BitSet FOLLOW_fHead_in_initEl2967 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_initEl2969 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_initEl2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_initEl2994 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_initEl2996 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_initEl2998 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_nameLiteral_in_initEl3000 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_initEl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_nameLiteral3029 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_nameLiteral3031 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3033 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_nameLiteral3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_atomicNameFormula3054 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_predicate_in_atomicNameFormula3056 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_NAME_in_atomicNameFormula3058 = new BitSet(new long[]{0x4000001000000000L});
    public static final BitSet FOLLOW_62_in_atomicNameFormula3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_goal3086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_goal3088 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_goal3090 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_goal3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_probConstraints3110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_probConstraints3112 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_probConstraints3115 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_probConstraints3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_prefConGD3139 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_prefConGD3141 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_prefConGD3143 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_prefConGD3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_prefConGD3151 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_prefConGD3153 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_prefConGD3155 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_prefConGD3157 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_prefConGD3159 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_prefConGD3161 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_prefConGD3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_prefConGD3168 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_prefConGD3170 = new BitSet(new long[]{0x2000001000000000L});
    public static final BitSet FOLLOW_NAME_in_prefConGD3172 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_conGD_in_prefConGD3175 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_prefConGD3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conGD_in_prefConGD3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_metricSpec3193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_metricSpec3195 = new BitSet(new long[]{0x0000000000000000L,0x000C000000000000L});
    public static final BitSet FOLLOW_optimization_in_metricSpec3197 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricSpec3199 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_metricSpec3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_metricFExp3238 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_metricFExp3240 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp3242 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp3244 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_metricFExp3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_metricFExp3268 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_multiOp_in_metricFExp3270 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp3272 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp3274 = new BitSet(new long[]{0x7000011000000000L});
    public static final BitSet FOLLOW_62_in_metricFExp3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_metricFExp3301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_metricFExp3303 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_metricFExp3305 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_metricFExp3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_metricFExp3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_metricFExp3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_metricFExp3344 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_metricFExp3346 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NAME_in_metricFExp3348 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_metricFExp3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3364 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_conGD3366 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_conGD_in_conGD3368 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3376 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_conGD3378 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_conGD3380 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_conGD3382 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3384 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_conGD_in_conGD3386 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3393 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_conGD3395 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_conGD3397 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3399 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3427 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_conGD3429 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3431 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3438 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_conGD3440 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3442 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_conGD3452 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3454 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3456 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3463 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_conGD3465 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3467 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3474 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_conGD3476 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3478 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3480 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3487 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_conGD3489 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3491 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3493 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3500 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_conGD3502 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3504 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3506 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3508 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3515 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_110_in_conGD3517 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3519 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3521 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3523 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_conGD3530 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_conGD3532 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_NUMBER_in_conGD3534 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_goalDesc_in_conGD3536 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_conGD3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fComp_in_synpred47_Pddl1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typedVariableList_in_synpred50_Pddl1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred63_Pddl2041 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_synpred63_Pddl2043 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_synpred63_Pddl2045 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp2_in_synpred63_Pddl2047 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred63_Pddl2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred64_Pddl2066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred64_Pddl2068 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_fExp_in_synpred64_Pddl2070 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred64_Pddl2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_synpred93_Pddl2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred95_Pddl2525 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_synpred95_Pddl2527 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred95_Pddl2529 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred95_Pddl2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timedEffect_in_synpred96_Pddl2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred97_Pddl2542 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_synpred97_Pddl2544 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_synpred97_Pddl2546 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_synpred97_Pddl2548 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred97_Pddl2550 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred97_Pddl2552 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred97_Pddl2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred98_Pddl2559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_synpred98_Pddl2561 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daGD_in_synpred98_Pddl2563 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_timedEffect_in_synpred98_Pddl2565 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred98_Pddl2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred99_Pddl2591 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_synpred99_Pddl2593 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_synpred99_Pddl2595 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_daEffect_in_synpred99_Pddl2597 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred99_Pddl2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred100_Pddl2609 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_synpred100_Pddl2611 = new BitSet(new long[]{0x0000000000000000L,0x8000040000000000L});
    public static final BitSet FOLLOW_timeSpecifier_in_synpred100_Pddl2613 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_fAssignDA_in_synpred100_Pddl2615 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred100_Pddl2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred101_Pddl2673 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred101_Pddl2675 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred101_Pddl2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred102_Pddl2669 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_synpred102_Pddl2673 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred102_Pddl2675 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred102_Pddl2677 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_65_in_synpred102_Pddl2683 = new BitSet(new long[]{0x3000011000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_fExpDA_in_synpred102_Pddl2685 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred102_Pddl2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred114_Pddl3139 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_synpred114_Pddl3141 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_synpred114_Pddl3143 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred114_Pddl3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred115_Pddl3151 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_synpred115_Pddl3153 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_synpred115_Pddl3155 = new BitSet(new long[]{0x4200000000000000L});
    public static final BitSet FOLLOW_typedVariableList_in_synpred115_Pddl3157 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred115_Pddl3159 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_prefConGD_in_synpred115_Pddl3161 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred115_Pddl3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred117_Pddl3168 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred117_Pddl3170 = new BitSet(new long[]{0x2000001000000000L});
    public static final BitSet FOLLOW_NAME_in_synpred117_Pddl3172 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_conGD_in_synpred117_Pddl3175 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred117_Pddl3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred119_Pddl3238 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_binaryOp_in_synpred119_Pddl3240 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred119_Pddl3242 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred119_Pddl3244 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred119_Pddl3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred121_Pddl3268 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_multiOp_in_synpred121_Pddl3270 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred121_Pddl3272 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred121_Pddl3274 = new BitSet(new long[]{0x7000011000000000L});
    public static final BitSet FOLLOW_62_in_synpred121_Pddl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred122_Pddl3301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred122_Pddl3303 = new BitSet(new long[]{0x3000011000000000L});
    public static final BitSet FOLLOW_metricFExp_in_synpred122_Pddl3305 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_synpred122_Pddl3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fHead_in_synpred124_Pddl3329 = new BitSet(new long[]{0x0000000000000002L});

}