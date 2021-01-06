// $ANTLR 3.5.2 Pddl.g 2021-01-06 09:42:28

package com.hstairs.ppmajal.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class PddlParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "ACTION", "AND_EFFECT", 
		"AND_GD", "ANY_CHAR", "ASSIGN_EFFECT", "ATAN", "ATAN2", "BELIEF", "BINARY_OP", 
		"COMPARISON_GD", "CONSTANTS", "CONSTRAINT", "COS", "DIGIT", "DOMAIN", 
		"DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", "EITHER_TYPE", "EQUALITY_CON", 
		"EVENT", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", "FORMULAINIT", "FREE_FUNCTIONS", 
		"FUNCTIONS", "FUNC_HEAD", "GLOBAL_CONSTRAINT", "GOAL", "IMPLY_GD", "INIT", 
		"INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", "MINUS_OP", "MULTI_OP", 
		"NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", "NUMBER", "OBJECTS", 
		"ONEOF", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", "PRED_INST", 
		"PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", 
		"PROCESS", "REQUIREMENTS", "REQUIRE_KEY", "SIN", "TAN", "TYPES", "UNARY_MINUS", 
		"UNKNOWN", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'#t'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", 
		"':constraint'", "':constraints'", "':derived'", "':domain'", "':duration'", 
		"':durative-action'", "':effect'", "':event'", "':free_functions'", "':functions'", 
		"':goal'", "':init'", "':metric'", "':objects'", "':parameters'", "':precondition'", 
		"':predicates'", "':process'", "':requirements'", "':types'", "'<'", "'<='", 
		"'='", "'>'", "'>='", "'?duration'", "'^'", "'__at__'", "'abs'", "'all'", 
		"'always'", "'always-within'", "'and'", "'assign'", "'at-most-once'", 
		"'atan'", "'atan2'", "'cos'", "'decrease'", "'define'", "'domain'", "'either'", 
		"'end'", "'exists'", "'forall'", "'hold-after'", "'hold-during'", "'imply'", 
		"'increase'", "'is-violated'", "'maximize'", "'minimize'", "'not'", "'number'", 
		"'oneof'", "'or'", "'over'", "'preference'", "'problem'", "'scale-down'", 
		"'scale-up'", "'sin'", "'sometime'", "'sometime-after'", "'sometime-before'", 
		"'start'", "'tan'", "'unknown'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int T__130=130;
	public static final int T__131=131;
	public static final int T__132=132;
	public static final int T__133=133;
	public static final int T__134=134;
	public static final int T__135=135;
	public static final int T__136=136;
	public static final int T__137=137;
	public static final int T__138=138;
	public static final int T__139=139;
	public static final int T__140=140;
	public static final int T__141=141;
	public static final int T__142=142;
	public static final int T__143=143;
	public static final int T__144=144;
	public static final int T__145=145;
	public static final int T__146=146;
	public static final int T__147=147;
	public static final int T__148=148;
	public static final int T__149=149;
	public static final int T__150=150;
	public static final int ABS=4;
	public static final int ACTION=5;
	public static final int AND_EFFECT=6;
	public static final int AND_GD=7;
	public static final int ANY_CHAR=8;
	public static final int ASSIGN_EFFECT=9;
	public static final int ATAN=10;
	public static final int ATAN2=11;
	public static final int BELIEF=12;
	public static final int BINARY_OP=13;
	public static final int COMPARISON_GD=14;
	public static final int CONSTANTS=15;
	public static final int CONSTRAINT=16;
	public static final int COS=17;
	public static final int DIGIT=18;
	public static final int DOMAIN=19;
	public static final int DOMAIN_NAME=20;
	public static final int DURATIVE_ACTION=21;
	public static final int EFFECT=22;
	public static final int EITHER_TYPE=23;
	public static final int EQUALITY_CON=24;
	public static final int EVENT=25;
	public static final int EXISTS_GD=26;
	public static final int FORALL_EFFECT=27;
	public static final int FORALL_GD=28;
	public static final int FORMULAINIT=29;
	public static final int FREE_FUNCTIONS=30;
	public static final int FUNCTIONS=31;
	public static final int FUNC_HEAD=32;
	public static final int GLOBAL_CONSTRAINT=33;
	public static final int GOAL=34;
	public static final int IMPLY_GD=35;
	public static final int INIT=36;
	public static final int INIT_AT=37;
	public static final int INIT_EQ=38;
	public static final int LETTER=39;
	public static final int LINE_COMMENT=40;
	public static final int MINUS_OP=41;
	public static final int MULTI_OP=42;
	public static final int NAME=43;
	public static final int NOT_EFFECT=44;
	public static final int NOT_GD=45;
	public static final int NOT_PRED_INIT=46;
	public static final int NUMBER=47;
	public static final int OBJECTS=48;
	public static final int ONEOF=49;
	public static final int OR_GD=50;
	public static final int PRECONDITION=51;
	public static final int PREDICATES=52;
	public static final int PRED_HEAD=53;
	public static final int PRED_INST=54;
	public static final int PROBLEM=55;
	public static final int PROBLEM_CONSTRAINT=56;
	public static final int PROBLEM_DOMAIN=57;
	public static final int PROBLEM_METRIC=58;
	public static final int PROBLEM_NAME=59;
	public static final int PROCESS=60;
	public static final int REQUIREMENTS=61;
	public static final int REQUIRE_KEY=62;
	public static final int SIN=63;
	public static final int TAN=64;
	public static final int TYPES=65;
	public static final int UNARY_MINUS=66;
	public static final int UNKNOWN=67;
	public static final int VARIABLE=68;
	public static final int WHEN_EFFECT=69;
	public static final int WHITESPACE=70;

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
		this.state.ruleMemo = new HashMap[232+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return PddlParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Pddl.g"; }


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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pddlDoc"
	// Pddl.g:108:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);
		int pddlDoc_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// Pddl.g:108:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==72) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==120) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==72) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==121) ) {
							alt1=1;
						}
						else if ( (LA1_3==139) ) {
							alt1=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:108:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc413);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// Pddl.g:108:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc417);
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
			if ( state.backtracking>0 ) { memoize(input, 1, pddlDoc_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "pddlDoc"


	public static class domain_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "domain"
	// Pddl.g:112:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
	public final PddlParser.domain_return domain() throws RecognitionException {
		PddlParser.domain_return retval = new PddlParser.domain_return();
		retval.start = input.LT(1);
		int domain_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal3=null;
		Token string_literal4=null;
		Token char_literal14=null;
		ParserRuleReturnScope domainName5 =null;
		ParserRuleReturnScope requireDef6 =null;
		ParserRuleReturnScope typesDef7 =null;
		ParserRuleReturnScope constantsDef8 =null;
		ParserRuleReturnScope predicatesDef9 =null;
		ParserRuleReturnScope functionsDef10 =null;
		ParserRuleReturnScope free_functionsDef11 =null;
		ParserRuleReturnScope constraints12 =null;
		ParserRuleReturnScope structureDef13 =null;

		Object char_literal3_tree=null;
		Object string_literal4_tree=null;
		Object char_literal14_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// Pddl.g:113:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			// Pddl.g:113:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,72,FOLLOW_72_in_domain432); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal3);

			string_literal4=(Token)match(input,120,FOLLOW_120_in_domain434); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_120.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain436);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// Pddl.g:114:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==72) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==99) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// Pddl.g:114:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain444);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// Pddl.g:115:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==72) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==100) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// Pddl.g:115:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain453);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// Pddl.g:116:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==72) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==80) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// Pddl.g:116:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain462);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// Pddl.g:117:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==72) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==97) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// Pddl.g:117:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain471);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// Pddl.g:118:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==72) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==90) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// Pddl.g:118:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain480);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// Pddl.g:119:7: ( free_functionsDef )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==72) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==89) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// Pddl.g:119:7: free_functionsDef
					{
					pushFollow(FOLLOW_free_functionsDef_in_domain489);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}

			// Pddl.g:120:7: ( constraints )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==72) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==82) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// Pddl.g:120:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain498);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}

			// Pddl.g:121:7: ( structureDef )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==72) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Pddl.g:121:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain507);
					structureDef13=structureDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_structureDef.add(structureDef13.getTree());
					}
					break;

				default :
					break loop9;
				}
			}

			char_literal14=(Token)match(input,73,FOLLOW_73_in_domain516); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal14);

			// AST REWRITE
			// elements: functionsDef, constantsDef, domainName, structureDef, free_functionsDef, typesDef, predicatesDef, requireDef, constraints
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 123:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				// Pddl.g:123:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// Pddl.g:123:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:123:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// Pddl.g:124:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// Pddl.g:124:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// Pddl.g:124:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// Pddl.g:124:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();

				// Pddl.g:125:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// Pddl.g:125:30: ( structureDef )*
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
			if ( state.backtracking>0 ) { memoize(input, 2, domain_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "domain"


	public static class free_functionsDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "free_functionsDef"
	// Pddl.g:128:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
	public final PddlParser.free_functionsDef_return free_functionsDef() throws RecognitionException {
		PddlParser.free_functionsDef_return retval = new PddlParser.free_functionsDef_return();
		retval.start = input.LT(1);
		int free_functionsDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal15=null;
		Token string_literal16=null;
		Token char_literal18=null;
		ParserRuleReturnScope functionList17 =null;

		Object char_literal15_tree=null;
		Object string_literal16_tree=null;
		Object char_literal18_tree=null;
		RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// Pddl.g:129:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			// Pddl.g:129:4: '(' ':free_functions' functionList ')'
			{
			char_literal15=(Token)match(input,72,FOLLOW_72_in_free_functionsDef600); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal15);

			string_literal16=(Token)match(input,89,FOLLOW_89_in_free_functionsDef602); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_89.add(string_literal16);

			pushFollow(FOLLOW_functionList_in_free_functionsDef604);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());
			char_literal18=(Token)match(input,73,FOLLOW_73_in_free_functionsDef606); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal18);

			// AST REWRITE
			// elements: functionList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 130:2: -> ^( FREE_FUNCTIONS functionList )
			{
				// Pddl.g:130:5: ^( FREE_FUNCTIONS functionList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FREE_FUNCTIONS, "FREE_FUNCTIONS"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 3, free_functionsDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "free_functionsDef"


	public static class domainName_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "domainName"
	// Pddl.g:133:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
	public final PddlParser.domainName_return domainName() throws RecognitionException {
		PddlParser.domainName_return retval = new PddlParser.domainName_return();
		retval.start = input.LT(1);
		int domainName_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal19=null;
		Token string_literal20=null;
		Token NAME21=null;
		Token char_literal22=null;

		Object char_literal19_tree=null;
		Object string_literal20_tree=null;
		Object NAME21_tree=null;
		Object char_literal22_tree=null;
		RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// Pddl.g:134:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// Pddl.g:134:7: '(' 'domain' NAME ')'
			{
			char_literal19=(Token)match(input,72,FOLLOW_72_in_domainName629); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal19);

			string_literal20=(Token)match(input,121,FOLLOW_121_in_domainName631); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_121.add(string_literal20);

			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName633); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);

			char_literal22=(Token)match(input,73,FOLLOW_73_in_domainName635); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal22);

			// AST REWRITE
			// elements: NAME
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 135:6: -> ^( DOMAIN_NAME NAME )
			{
				// Pddl.g:135:9: ^( DOMAIN_NAME NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN_NAME, "DOMAIN_NAME"), root_1);
				adaptor.addChild(root_1, stream_NAME.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 4, domainName_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "domainName"


	public static class requireDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "requireDef"
	// Pddl.g:138:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
	public final PddlParser.requireDef_return requireDef() throws RecognitionException {
		PddlParser.requireDef_return retval = new PddlParser.requireDef_return();
		retval.start = input.LT(1);
		int requireDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal23=null;
		Token string_literal24=null;
		Token REQUIRE_KEY25=null;
		Token char_literal26=null;

		Object char_literal23_tree=null;
		Object string_literal24_tree=null;
		Object REQUIRE_KEY25_tree=null;
		Object char_literal26_tree=null;
		RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
		RewriteRuleTokenStream stream_REQUIRE_KEY=new RewriteRuleTokenStream(adaptor,"token REQUIRE_KEY");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// Pddl.g:139:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// Pddl.g:139:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal23=(Token)match(input,72,FOLLOW_72_in_requireDef662); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal23);

			string_literal24=(Token)match(input,99,FOLLOW_99_in_requireDef664); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_99.add(string_literal24);

			// Pddl.g:139:24: ( REQUIRE_KEY )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==REQUIRE_KEY) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// Pddl.g:139:24: REQUIRE_KEY
					{
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef666); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_REQUIRE_KEY.add(REQUIRE_KEY25);

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			char_literal26=(Token)match(input,73,FOLLOW_73_in_requireDef669); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal26);

			// AST REWRITE
			// elements: REQUIRE_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 140:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// Pddl.g:140:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REQUIREMENTS, "REQUIREMENTS"), root_1);
				if ( !(stream_REQUIRE_KEY.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_REQUIRE_KEY.hasNext() ) {
					adaptor.addChild(root_1, stream_REQUIRE_KEY.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 5, requireDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "requireDef"


	public static class typesDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "typesDef"
	// Pddl.g:143:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
	public final PddlParser.typesDef_return typesDef() throws RecognitionException {
		PddlParser.typesDef_return retval = new PddlParser.typesDef_return();
		retval.start = input.LT(1);
		int typesDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal27=null;
		Token string_literal28=null;
		Token char_literal30=null;
		ParserRuleReturnScope typedNameList29 =null;

		Object char_literal27_tree=null;
		Object string_literal28_tree=null;
		Object char_literal30_tree=null;
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// Pddl.g:144:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// Pddl.g:144:4: '(' ':types' typedNameList ')'
			{
			char_literal27=(Token)match(input,72,FOLLOW_72_in_typesDef690); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal27);

			string_literal28=(Token)match(input,100,FOLLOW_100_in_typesDef692); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_100.add(string_literal28);

			pushFollow(FOLLOW_typedNameList_in_typesDef694);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());
			char_literal30=(Token)match(input,73,FOLLOW_73_in_typesDef696); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal30);

			// AST REWRITE
			// elements: typedNameList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 145:4: -> ^( TYPES typedNameList )
			{
				// Pddl.g:145:7: ^( TYPES typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPES, "TYPES"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 6, typesDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "typesDef"


	public static class typedNameList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "typedNameList"
	// Pddl.g:149:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
	public final PddlParser.typedNameList_return typedNameList() throws RecognitionException {
		PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
		retval.start = input.LT(1);
		int typedNameList_StartIndex = input.index();

		Object root_0 = null;

		Token NAME31=null;
		Token NAME33=null;
		ParserRuleReturnScope singleTypeNameList32 =null;

		Object NAME31_tree=null;
		Object NAME33_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// Pddl.g:150:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// Pddl.g:150:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:150:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// Pddl.g:150:8: ( NAME )*
					{
					// Pddl.g:150:8: ( NAME )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Pddl.g:150:8: NAME
							{
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList723); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME31_tree = (Object)adaptor.create(NAME31);
							adaptor.addChild(root_0, NAME31_tree);
							}

							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;
				case 2 :
					// Pddl.g:150:16: ( singleTypeNameList )+ ( NAME )*
					{
					// Pddl.g:150:16: ( singleTypeNameList )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						alt12 = dfa12.predict(input);
						switch (alt12) {
						case 1 :
							// Pddl.g:150:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList728);
							singleTypeNameList32=singleTypeNameList();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeNameList32.getTree());

							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					// Pddl.g:150:36: ( NAME )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// Pddl.g:150:36: NAME
							{
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList731); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME33_tree = (Object)adaptor.create(NAME33);
							adaptor.addChild(root_0, NAME33_tree);
							}

							}
							break;

						default :
							break loop13;
						}
					}

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
			if ( state.backtracking>0 ) { memoize(input, 7, typedNameList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "typedNameList"


	public static class singleTypeNameList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "singleTypeNameList"
	// Pddl.g:153:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);
		int singleTypeNameList_StartIndex = input.index();

		Object root_0 = null;

		Token NAME34=null;
		Token char_literal35=null;
		ParserRuleReturnScope t =null;

		Object NAME34_tree=null;
		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// Pddl.g:154:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// Pddl.g:154:7: ( ( NAME )+ '-' t= type )
			{
			// Pddl.g:154:7: ( ( NAME )+ '-' t= type )
			// Pddl.g:154:8: ( NAME )+ '-' t= type
			{
			// Pddl.g:154:8: ( NAME )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==NAME) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Pddl.g:154:8: NAME
					{
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList751); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME34);

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			char_literal35=(Token)match(input,76,FOLLOW_76_in_singleTypeNameList754); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(char_literal35);

			pushFollow(FOLLOW_type_in_singleTypeNameList758);
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
			RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 155:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
					// Pddl.g:155:7: ^( NAME $t)
					{
					Object root_1 = (Object)adaptor.nil();
					root_1 = (Object)adaptor.becomeRoot(stream_NAME.nextNode(), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 8, singleTypeNameList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "singleTypeNameList"


	public static class type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// Pddl.g:158:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
	public final PddlParser.type_return type() throws RecognitionException {
		PddlParser.type_return retval = new PddlParser.type_return();
		retval.start = input.LT(1);
		int type_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal36=null;
		Token string_literal37=null;
		Token char_literal39=null;
		ParserRuleReturnScope primType38 =null;
		ParserRuleReturnScope primType40 =null;

		Object char_literal36_tree=null;
		Object string_literal37_tree=null;
		Object char_literal39_tree=null;
		RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// Pddl.g:159:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==72) ) {
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
					// Pddl.g:159:4: ( '(' 'either' ( primType )+ ')' )
					{
					// Pddl.g:159:4: ( '(' 'either' ( primType )+ ')' )
					// Pddl.g:159:6: '(' 'either' ( primType )+ ')'
					{
					char_literal36=(Token)match(input,72,FOLLOW_72_in_type785); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal36);

					string_literal37=(Token)match(input,122,FOLLOW_122_in_type787); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_122.add(string_literal37);

					// Pddl.g:159:19: ( primType )+
					int cnt16=0;
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==NAME) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// Pddl.g:159:19: primType
							{
							pushFollow(FOLLOW_primType_in_type789);
							primType38=primType();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_primType.add(primType38.getTree());
							}
							break;

						default :
							if ( cnt16 >= 1 ) break loop16;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(16, input);
							throw eee;
						}
						cnt16++;
					}

					char_literal39=(Token)match(input,73,FOLLOW_73_in_type792); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal39);

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
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 160:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// Pddl.g:160:7: ^( EITHER_TYPE ( primType )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EITHER_TYPE, "EITHER_TYPE"), root_1);
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
					// Pddl.g:161:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type813);
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
			if ( state.backtracking>0 ) { memoize(input, 9, type_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "type"


	public static class primType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "primType"
	// Pddl.g:164:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);
		int primType_StartIndex = input.index();

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// Pddl.g:164:10: ( NAME )
			// Pddl.g:164:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType823); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME41_tree = (Object)adaptor.create(NAME41);
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
			if ( state.backtracking>0 ) { memoize(input, 10, primType_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "primType"


	public static class functionsDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionsDef"
	// Pddl.g:166:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
	public final PddlParser.functionsDef_return functionsDef() throws RecognitionException {
		PddlParser.functionsDef_return retval = new PddlParser.functionsDef_return();
		retval.start = input.LT(1);
		int functionsDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal42=null;
		Token string_literal43=null;
		Token char_literal45=null;
		ParserRuleReturnScope functionList44 =null;

		Object char_literal42_tree=null;
		Object string_literal43_tree=null;
		Object char_literal45_tree=null;
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// Pddl.g:167:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// Pddl.g:167:4: '(' ':functions' functionList ')'
			{
			char_literal42=(Token)match(input,72,FOLLOW_72_in_functionsDef833); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal42);

			string_literal43=(Token)match(input,90,FOLLOW_90_in_functionsDef835); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_90.add(string_literal43);

			pushFollow(FOLLOW_functionList_in_functionsDef837);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());
			char_literal45=(Token)match(input,73,FOLLOW_73_in_functionsDef839); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal45);

			// AST REWRITE
			// elements: functionList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 168:2: -> ^( FUNCTIONS functionList )
			{
				// Pddl.g:168:5: ^( FUNCTIONS functionList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONS, "FUNCTIONS"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 11, functionsDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "functionsDef"


	public static class functionList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionList"
	// Pddl.g:171:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws RecognitionException {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);
		int functionList_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal47=null;
		ParserRuleReturnScope atomicFunctionSkeleton46 =null;
		ParserRuleReturnScope functionType48 =null;

		Object char_literal47_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// Pddl.g:172:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// Pddl.g:172:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:172:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==72) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// Pddl.g:172:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// Pddl.g:172:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==72) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						switch (alt18) {
						case 1 :
							// Pddl.g:172:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList860);
							atomicFunctionSkeleton46=atomicFunctionSkeleton();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicFunctionSkeleton46.getTree());

							}
							break;

						default :
							if ( cnt18 >= 1 ) break loop18;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(18, input);
							throw eee;
						}
						cnt18++;
					}

					// Pddl.g:172:29: ( '-' functionType )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==76) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// Pddl.g:172:30: '-' functionType
							{
							char_literal47=(Token)match(input,76,FOLLOW_76_in_functionList864); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList866);
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
			if ( state.backtracking>0 ) { memoize(input, 12, functionList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "functionList"


	public static class atomicFunctionSkeleton_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomicFunctionSkeleton"
	// Pddl.g:175:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
	public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws RecognitionException {
		PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
		retval.start = input.LT(1);
		int atomicFunctionSkeleton_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal49=null;
		Token char_literal52=null;
		ParserRuleReturnScope functionSymbol50 =null;
		ParserRuleReturnScope typedVariableList51 =null;

		Object char_literal49_tree=null;
		Object char_literal52_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// Pddl.g:176:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// Pddl.g:176:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal49=(Token)match(input,72,FOLLOW_72_in_atomicFunctionSkeleton882); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton885);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton888);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

			char_literal52=(Token)match(input,73,FOLLOW_73_in_atomicFunctionSkeleton890); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 13, atomicFunctionSkeleton_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "atomicFunctionSkeleton"


	public static class functionSymbol_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionSymbol"
	// Pddl.g:179:1: functionSymbol : ( NAME | '#t' );
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);
		int functionSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token set53=null;

		Object set53_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// Pddl.g:179:16: ( NAME | '#t' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set53=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==71 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set53));
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
			if ( state.backtracking>0 ) { memoize(input, 14, functionSymbol_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "functionSymbol"


	public static class functionType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionType"
	// Pddl.g:181:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);
		int functionType_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// Pddl.g:181:14: ( 'number' )
			// Pddl.g:181:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal54=(Token)match(input,134,FOLLOW_134_in_functionType913); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal54_tree = (Object)adaptor.create(string_literal54);
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
			if ( state.backtracking>0 ) { memoize(input, 15, functionType_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "functionType"


	public static class constantsDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constantsDef"
	// Pddl.g:183:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
	public final PddlParser.constantsDef_return constantsDef() throws RecognitionException {
		PddlParser.constantsDef_return retval = new PddlParser.constantsDef_return();
		retval.start = input.LT(1);
		int constantsDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal55=null;
		Token string_literal56=null;
		Token char_literal58=null;
		ParserRuleReturnScope typedNameList57 =null;

		Object char_literal55_tree=null;
		Object string_literal56_tree=null;
		Object char_literal58_tree=null;
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// Pddl.g:184:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// Pddl.g:184:4: '(' ':constants' typedNameList ')'
			{
			char_literal55=(Token)match(input,72,FOLLOW_72_in_constantsDef924); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal55);

			string_literal56=(Token)match(input,80,FOLLOW_80_in_constantsDef926); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal56);

			pushFollow(FOLLOW_typedNameList_in_constantsDef928);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());
			char_literal58=(Token)match(input,73,FOLLOW_73_in_constantsDef930); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal58);

			// AST REWRITE
			// elements: typedNameList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 185:2: -> ^( CONSTANTS typedNameList )
			{
				// Pddl.g:185:5: ^( CONSTANTS typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTANTS, "CONSTANTS"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 16, constantsDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constantsDef"


	public static class predicatesDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "predicatesDef"
	// Pddl.g:188:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
	public final PddlParser.predicatesDef_return predicatesDef() throws RecognitionException {
		PddlParser.predicatesDef_return retval = new PddlParser.predicatesDef_return();
		retval.start = input.LT(1);
		int predicatesDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal59=null;
		Token string_literal60=null;
		Token char_literal62=null;
		ParserRuleReturnScope atomicFormulaSkeleton61 =null;

		Object char_literal59_tree=null;
		Object string_literal60_tree=null;
		Object char_literal62_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// Pddl.g:189:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// Pddl.g:189:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal59=(Token)match(input,72,FOLLOW_72_in_predicatesDef950); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal59);

			string_literal60=(Token)match(input,97,FOLLOW_97_in_predicatesDef952); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_97.add(string_literal60);

			// Pddl.g:189:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==72) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Pddl.g:189:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef954);
					atomicFormulaSkeleton61=atomicFormulaSkeleton();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicFormulaSkeleton.add(atomicFormulaSkeleton61.getTree());
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
			}

			char_literal62=(Token)match(input,73,FOLLOW_73_in_predicatesDef957); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal62);

			// AST REWRITE
			// elements: atomicFormulaSkeleton
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 190:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// Pddl.g:190:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PREDICATES, "PREDICATES"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 17, predicatesDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "predicatesDef"


	public static class atomicFormulaSkeleton_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomicFormulaSkeleton"
	// Pddl.g:193:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
	public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws RecognitionException {
		PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
		retval.start = input.LT(1);
		int atomicFormulaSkeleton_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal63=null;
		Token char_literal66=null;
		ParserRuleReturnScope predicate64 =null;
		ParserRuleReturnScope typedVariableList65 =null;

		Object char_literal63_tree=null;
		Object char_literal66_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

			// Pddl.g:194:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// Pddl.g:194:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal63=(Token)match(input,72,FOLLOW_72_in_atomicFormulaSkeleton978); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton981);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton984);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

			char_literal66=(Token)match(input,73,FOLLOW_73_in_atomicFormulaSkeleton986); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 18, atomicFormulaSkeleton_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "atomicFormulaSkeleton"


	public static class predicate_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "predicate"
	// Pddl.g:197:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);
		int predicate_StartIndex = input.index();

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

			// Pddl.g:197:11: ( NAME )
			// Pddl.g:197:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate997); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME67_tree = (Object)adaptor.create(NAME67);
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
			if ( state.backtracking>0 ) { memoize(input, 19, predicate_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "predicate"


	public static class typedVariableList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "typedVariableList"
	// Pddl.g:200:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
	public final PddlParser.typedVariableList_return typedVariableList() throws RecognitionException {
		PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
		retval.start = input.LT(1);
		int typedVariableList_StartIndex = input.index();

		Object root_0 = null;

		Token VARIABLE68=null;
		Token VARIABLE70=null;
		ParserRuleReturnScope singleTypeVarList69 =null;

		Object VARIABLE68_tree=null;
		Object VARIABLE70_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

			// Pddl.g:201:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// Pddl.g:201:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:201:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// Pddl.g:201:8: ( VARIABLE )*
					{
					// Pddl.g:201:8: ( VARIABLE )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// Pddl.g:201:8: VARIABLE
							{
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList1012); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							VARIABLE68_tree = (Object)adaptor.create(VARIABLE68);
							adaptor.addChild(root_0, VARIABLE68_tree);
							}

							}
							break;

						default :
							break loop22;
						}
					}

					}
					break;
				case 2 :
					// Pddl.g:201:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// Pddl.g:201:20: ( singleTypeVarList )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						alt23 = dfa23.predict(input);
						switch (alt23) {
						case 1 :
							// Pddl.g:201:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList1017);
							singleTypeVarList69=singleTypeVarList();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeVarList69.getTree());

							}
							break;

						default :
							if ( cnt23 >= 1 ) break loop23;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(23, input);
							throw eee;
						}
						cnt23++;
					}

					// Pddl.g:201:39: ( VARIABLE )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// Pddl.g:201:39: VARIABLE
							{
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList1020); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							VARIABLE70_tree = (Object)adaptor.create(VARIABLE70);
							adaptor.addChild(root_0, VARIABLE70_tree);
							}

							}
							break;

						default :
							break loop24;
						}
					}

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
			if ( state.backtracking>0 ) { memoize(input, 20, typedVariableList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "typedVariableList"


	public static class singleTypeVarList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "singleTypeVarList"
	// Pddl.g:204:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
	public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
		PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
		retval.start = input.LT(1);
		int singleTypeVarList_StartIndex = input.index();

		Object root_0 = null;

		Token VARIABLE71=null;
		Token char_literal72=null;
		ParserRuleReturnScope t =null;

		Object VARIABLE71_tree=null;
		Object char_literal72_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

			// Pddl.g:205:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// Pddl.g:205:7: ( ( VARIABLE )+ '-' t= type )
			{
			// Pddl.g:205:7: ( ( VARIABLE )+ '-' t= type )
			// Pddl.g:205:8: ( VARIABLE )+ '-' t= type
			{
			// Pddl.g:205:8: ( VARIABLE )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==VARIABLE) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// Pddl.g:205:8: VARIABLE
					{
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList1040); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE71);

					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
			}

			char_literal72=(Token)match(input,76,FOLLOW_76_in_singleTypeVarList1043); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(char_literal72);

			pushFollow(FOLLOW_type_in_singleTypeVarList1047);
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
			RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 206:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_t.hasNext()||stream_VARIABLE.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_VARIABLE.hasNext() ) {
					// Pddl.g:206:10: ^( VARIABLE $t)
					{
					Object root_1 = (Object)adaptor.nil();
					root_1 = (Object)adaptor.becomeRoot(stream_VARIABLE.nextNode(), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 21, singleTypeVarList_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "singleTypeVarList"


	public static class constraints_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraints"
	// Pddl.g:209:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
	public final PddlParser.constraints_return constraints() throws RecognitionException {
		PddlParser.constraints_return retval = new PddlParser.constraints_return();
		retval.start = input.LT(1);
		int constraints_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal73=null;
		Token string_literal74=null;
		Token char_literal76=null;
		ParserRuleReturnScope conGD75 =null;

		Object char_literal73_tree=null;
		Object string_literal74_tree=null;
		Object char_literal76_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

			// Pddl.g:210:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// Pddl.g:210:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal73=(Token)match(input,72,FOLLOW_72_in_constraints1078); if (state.failed) return retval;
			string_literal74=(Token)match(input,82,FOLLOW_82_in_constraints1081); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints1084);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

			char_literal76=(Token)match(input,73,FOLLOW_73_in_constraints1086); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 22, constraints_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constraints"


	public static class structureDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "structureDef"
	// Pddl.g:213:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef );
	public final PddlParser.structureDef_return structureDef() throws RecognitionException {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);
		int structureDef_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope actionDef77 =null;
		ParserRuleReturnScope durativeActionDef78 =null;
		ParserRuleReturnScope derivedDef79 =null;
		ParserRuleReturnScope constraintDef80 =null;
		ParserRuleReturnScope processDef81 =null;
		ParserRuleReturnScope eventDef82 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }

			// Pddl.g:214:2: ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef )
			int alt27=6;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==72) ) {
				switch ( input.LA(2) ) {
				case 78:
					{
					alt27=1;
					}
					break;
				case 86:
					{
					alt27=2;
					}
					break;
				case 83:
					{
					alt27=3;
					}
					break;
				case 81:
					{
					alt27=4;
					}
					break;
				case 98:
					{
					alt27=5;
					}
					break;
				case 88:
					{
					alt27=6;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:214:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef1098);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					// Pddl.g:215:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef1103);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					// Pddl.g:216:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef1108);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

					}
					break;
				case 4 :
					// Pddl.g:217:4: constraintDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constraintDef_in_structureDef1113);
					constraintDef80=constraintDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

					}
					break;
				case 5 :
					// Pddl.g:218:4: processDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_processDef_in_structureDef1118);
					processDef81=processDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, processDef81.getTree());

					}
					break;
				case 6 :
					// Pddl.g:219:4: eventDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_eventDef_in_structureDef1123);
					eventDef82=eventDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, eventDef82.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 23, structureDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "structureDef"


	public static class actionDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionDef"
	// Pddl.g:225:1: actionDef : '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws RecognitionException {
		PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
		retval.start = input.LT(1);
		int actionDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal83=null;
		Token string_literal84=null;
		Token string_literal86=null;
		Token char_literal87=null;
		Token char_literal89=null;
		Token char_literal91=null;
		ParserRuleReturnScope actionSymbol85 =null;
		ParserRuleReturnScope typedVariableList88 =null;
		ParserRuleReturnScope actionDefBody90 =null;

		Object char_literal83_tree=null;
		Object string_literal84_tree=null;
		Object string_literal86_tree=null;
		Object char_literal87_tree=null;
		Object char_literal89_tree=null;
		Object char_literal91_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

			// Pddl.g:226:2: ( '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:226:4: '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')'
			{
			char_literal83=(Token)match(input,72,FOLLOW_72_in_actionDef1138); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal83);

			string_literal84=(Token)match(input,78,FOLLOW_78_in_actionDef1140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal84);

			pushFollow(FOLLOW_actionSymbol_in_actionDef1142);
			actionSymbol85=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol85.getTree());
			// Pddl.g:227:8: ( ':parameters' '(' typedVariableList ')' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==95) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// Pddl.g:227:9: ':parameters' '(' typedVariableList ')'
					{
					string_literal86=(Token)match(input,95,FOLLOW_95_in_actionDef1152); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_95.add(string_literal86);

					char_literal87=(Token)match(input,72,FOLLOW_72_in_actionDef1155); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal87);

					pushFollow(FOLLOW_typedVariableList_in_actionDef1157);
					typedVariableList88=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList88.getTree());
					char_literal89=(Token)match(input,73,FOLLOW_73_in_actionDef1159); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal89);

					}
					break;

			}

			pushFollow(FOLLOW_actionDefBody_in_actionDef1174);
			actionDefBody90=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody90.getTree());
			char_literal91=(Token)match(input,73,FOLLOW_73_in_actionDef1176); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal91);

			// AST REWRITE
			// elements: actionDefBody, typedVariableList, actionSymbol
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 229:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:229:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:229:33: ( typedVariableList )?
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
			if ( state.backtracking>0 ) { memoize(input, 24, actionDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "actionDef"


	public static class eventDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eventDef"
	// Pddl.g:231:1: eventDef : '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.eventDef_return eventDef() throws RecognitionException {
		PddlParser.eventDef_return retval = new PddlParser.eventDef_return();
		retval.start = input.LT(1);
		int eventDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal92=null;
		Token string_literal93=null;
		Token string_literal95=null;
		Token char_literal96=null;
		Token char_literal98=null;
		Token char_literal100=null;
		ParserRuleReturnScope actionSymbol94 =null;
		ParserRuleReturnScope typedVariableList97 =null;
		ParserRuleReturnScope actionDefBody99 =null;

		Object char_literal92_tree=null;
		Object string_literal93_tree=null;
		Object string_literal95_tree=null;
		Object char_literal96_tree=null;
		Object char_literal98_tree=null;
		Object char_literal100_tree=null;
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

			// Pddl.g:232:2: ( '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:232:4: '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal92=(Token)match(input,72,FOLLOW_72_in_eventDef1209); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal92);

			string_literal93=(Token)match(input,88,FOLLOW_88_in_eventDef1211); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_88.add(string_literal93);

			pushFollow(FOLLOW_actionSymbol_in_eventDef1213);
			actionSymbol94=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol94.getTree());
			string_literal95=(Token)match(input,95,FOLLOW_95_in_eventDef1222); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal95);

			char_literal96=(Token)match(input,72,FOLLOW_72_in_eventDef1225); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal96);

			pushFollow(FOLLOW_typedVariableList_in_eventDef1227);
			typedVariableList97=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList97.getTree());
			char_literal98=(Token)match(input,73,FOLLOW_73_in_eventDef1229); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal98);

			pushFollow(FOLLOW_actionDefBody_in_eventDef1242);
			actionDefBody99=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody99.getTree());
			char_literal100=(Token)match(input,73,FOLLOW_73_in_eventDef1244); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal100);

			// AST REWRITE
			// elements: actionDefBody, actionSymbol, typedVariableList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 235:8: -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:235:11: ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EVENT, "EVENT"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:235:32: ( typedVariableList )?
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
			if ( state.backtracking>0 ) { memoize(input, 25, eventDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "eventDef"


	public static class processDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "processDef"
	// Pddl.g:237:1: processDef : '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.processDef_return processDef() throws RecognitionException {
		PddlParser.processDef_return retval = new PddlParser.processDef_return();
		retval.start = input.LT(1);
		int processDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal101=null;
		Token string_literal102=null;
		Token string_literal104=null;
		Token char_literal105=null;
		Token char_literal107=null;
		Token char_literal109=null;
		ParserRuleReturnScope actionSymbol103 =null;
		ParserRuleReturnScope typedVariableList106 =null;
		ParserRuleReturnScope actionDefBody108 =null;

		Object char_literal101_tree=null;
		Object string_literal102_tree=null;
		Object string_literal104_tree=null;
		Object char_literal105_tree=null;
		Object char_literal107_tree=null;
		Object char_literal109_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

			// Pddl.g:238:2: ( '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:238:4: '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal101=(Token)match(input,72,FOLLOW_72_in_processDef1277); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal101);

			string_literal102=(Token)match(input,98,FOLLOW_98_in_processDef1279); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_98.add(string_literal102);

			pushFollow(FOLLOW_actionSymbol_in_processDef1281);
			actionSymbol103=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol103.getTree());
			string_literal104=(Token)match(input,95,FOLLOW_95_in_processDef1290); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal104);

			char_literal105=(Token)match(input,72,FOLLOW_72_in_processDef1293); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal105);

			pushFollow(FOLLOW_typedVariableList_in_processDef1295);
			typedVariableList106=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList106.getTree());
			char_literal107=(Token)match(input,73,FOLLOW_73_in_processDef1297); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal107);

			pushFollow(FOLLOW_actionDefBody_in_processDef1310);
			actionDefBody108=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody108.getTree());
			char_literal109=(Token)match(input,73,FOLLOW_73_in_processDef1312); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal109);

			// AST REWRITE
			// elements: typedVariableList, actionSymbol, actionDefBody
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 241:8: -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:241:11: ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCESS, "PROCESS"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:241:34: ( typedVariableList )?
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
			if ( state.backtracking>0 ) { memoize(input, 26, processDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "processDef"


	public static class constraintDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintDef"
	// Pddl.g:244:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
	public final PddlParser.constraintDef_return constraintDef() throws RecognitionException {
		PddlParser.constraintDef_return retval = new PddlParser.constraintDef_return();
		retval.start = input.LT(1);
		int constraintDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal110=null;
		Token string_literal111=null;
		Token string_literal113=null;
		Token char_literal114=null;
		Token char_literal116=null;
		Token char_literal118=null;
		ParserRuleReturnScope constraintSymbol112 =null;
		ParserRuleReturnScope typedVariableList115 =null;
		ParserRuleReturnScope constraintDefBody117 =null;

		Object char_literal110_tree=null;
		Object string_literal111_tree=null;
		Object string_literal113_tree=null;
		Object char_literal114_tree=null;
		Object char_literal116_tree=null;
		Object char_literal118_tree=null;
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
		RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

			// Pddl.g:245:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
			// Pddl.g:245:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
			{
			char_literal110=(Token)match(input,72,FOLLOW_72_in_constraintDef1346); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal110);

			string_literal111=(Token)match(input,81,FOLLOW_81_in_constraintDef1348); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal111);

			pushFollow(FOLLOW_constraintSymbol_in_constraintDef1350);
			constraintSymbol112=constraintSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol112.getTree());
			string_literal113=(Token)match(input,95,FOLLOW_95_in_constraintDef1359); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal113);

			char_literal114=(Token)match(input,72,FOLLOW_72_in_constraintDef1362); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal114);

			pushFollow(FOLLOW_typedVariableList_in_constraintDef1364);
			typedVariableList115=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList115.getTree());
			char_literal116=(Token)match(input,73,FOLLOW_73_in_constraintDef1366); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal116);

			pushFollow(FOLLOW_constraintDefBody_in_constraintDef1379);
			constraintDefBody117=constraintDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody117.getTree());
			char_literal118=(Token)match(input,73,FOLLOW_73_in_constraintDef1381); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal118);

			// AST REWRITE
			// elements: typedVariableList, constraintDefBody, constraintSymbol
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 248:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
			{
				// Pddl.g:248:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT"), root_1);
				adaptor.addChild(root_1, stream_constraintSymbol.nextTree());
				// Pddl.g:248:48: ( typedVariableList )?
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
			if ( state.backtracking>0 ) { memoize(input, 27, constraintDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constraintDef"


	public static class actionSymbol_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionSymbol"
	// Pddl.g:252:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);
		int actionSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token NAME119=null;

		Object NAME119_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

			// Pddl.g:252:14: ( NAME )
			// Pddl.g:252:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME119=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1415); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME119_tree = (Object)adaptor.create(NAME119);
			adaptor.addChild(root_0, NAME119_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 28, actionSymbol_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "actionSymbol"


	public static class constraintSymbol_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintSymbol"
	// Pddl.g:254:1: constraintSymbol : NAME ;
	public final PddlParser.constraintSymbol_return constraintSymbol() throws RecognitionException {
		PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
		retval.start = input.LT(1);
		int constraintSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token NAME120=null;

		Object NAME120_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

			// Pddl.g:254:18: ( NAME )
			// Pddl.g:254:20: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME120=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1424); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME120_tree = (Object)adaptor.create(NAME120);
			adaptor.addChild(root_0, NAME120_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 29, constraintSymbol_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constraintSymbol"


	public static class actionDefBody_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionDefBody"
	// Pddl.g:259:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
		PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
		retval.start = input.LT(1);
		int actionDefBody_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal121=null;
		Token char_literal122=null;
		Token char_literal123=null;
		Token string_literal125=null;
		Token char_literal126=null;
		Token char_literal127=null;
		ParserRuleReturnScope goalDesc124 =null;
		ParserRuleReturnScope effect128 =null;

		Object string_literal121_tree=null;
		Object char_literal122_tree=null;
		Object char_literal123_tree=null;
		Object string_literal125_tree=null;
		Object char_literal126_tree=null;
		Object char_literal127_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

			// Pddl.g:260:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// Pddl.g:260:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// Pddl.g:260:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==96) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// Pddl.g:260:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal121=(Token)match(input,96,FOLLOW_96_in_actionDefBody1439); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_96.add(string_literal121);

					// Pddl.g:260:22: ( ( '(' ')' ) | goalDesc )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==72) ) {
						int LA29_1 = input.LA(2);
						if ( (LA29_1==73) ) {
							alt29=1;
						}
						else if ( (LA29_1==NAME||(LA29_1 >= 101 && LA29_1 <= 105)||LA29_1==113||(LA29_1 >= 124 && LA29_1 <= 125)||LA29_1==128||LA29_1==133||(LA29_1 >= 135 && LA29_1 <= 136)) ) {
							alt29=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 29, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 29, 0, input);
						throw nvae;
					}

					switch (alt29) {
						case 1 :
							// Pddl.g:260:23: ( '(' ')' )
							{
							// Pddl.g:260:23: ( '(' ')' )
							// Pddl.g:260:24: '(' ')'
							{
							char_literal122=(Token)match(input,72,FOLLOW_72_in_actionDefBody1443); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal122);

							char_literal123=(Token)match(input,73,FOLLOW_73_in_actionDefBody1445); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_73.add(char_literal123);

							}

							}
							break;
						case 2 :
							// Pddl.g:260:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1450);
							goalDesc124=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc124.getTree());
							}
							break;

					}

					}
					break;

			}

			// Pddl.g:261:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==87) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// Pddl.g:261:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal125=(Token)match(input,87,FOLLOW_87_in_actionDefBody1460); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_87.add(string_literal125);

					// Pddl.g:261:16: ( ( '(' ')' ) | effect )
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==72) ) {
						int LA31_1 = input.LA(2);
						if ( (LA31_1==73) ) {
							alt31=1;
						}
						else if ( (LA31_1==NAME||(LA31_1 >= 113 && LA31_1 <= 114)||LA31_1==119||LA31_1==125||LA31_1==129||LA31_1==133||(LA31_1 >= 140 && LA31_1 <= 141)||LA31_1==149) ) {
							alt31=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 31, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
						throw nvae;
					}

					switch (alt31) {
						case 1 :
							// Pddl.g:261:17: ( '(' ')' )
							{
							// Pddl.g:261:17: ( '(' ')' )
							// Pddl.g:261:18: '(' ')'
							{
							char_literal126=(Token)match(input,72,FOLLOW_72_in_actionDefBody1464); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal126);

							char_literal127=(Token)match(input,73,FOLLOW_73_in_actionDefBody1466); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_73.add(char_literal127);

							}

							}
							break;
						case 2 :
							// Pddl.g:261:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1471);
							effect128=effect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_effect.add(effect128.getTree());
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 262:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// Pddl.g:262:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:262:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// Pddl.g:262:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// Pddl.g:262:42: ( effect )?
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
			if ( state.backtracking>0 ) { memoize(input, 30, actionDefBody_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "actionDefBody"


	public static class constraintDefBody_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintDefBody"
	// Pddl.g:265:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
	public final PddlParser.constraintDefBody_return constraintDefBody() throws RecognitionException {
		PddlParser.constraintDefBody_return retval = new PddlParser.constraintDefBody_return();
		retval.start = input.LT(1);
		int constraintDefBody_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal129=null;
		Token char_literal130=null;
		Token char_literal131=null;
		ParserRuleReturnScope goalDesc132 =null;

		Object string_literal129_tree=null;
		Object char_literal130_tree=null;
		Object char_literal131_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

			// Pddl.g:266:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
			// Pddl.g:266:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			{
			// Pddl.g:266:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==79) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// Pddl.g:266:6: ':condition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal129=(Token)match(input,79,FOLLOW_79_in_constraintDefBody1506); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_79.add(string_literal129);

					// Pddl.g:266:19: ( ( '(' ')' ) | goalDesc )
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==72) ) {
						int LA33_1 = input.LA(2);
						if ( (LA33_1==73) ) {
							alt33=1;
						}
						else if ( (LA33_1==NAME||(LA33_1 >= 101 && LA33_1 <= 105)||LA33_1==113||(LA33_1 >= 124 && LA33_1 <= 125)||LA33_1==128||LA33_1==133||(LA33_1 >= 135 && LA33_1 <= 136)) ) {
							alt33=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 33, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
						throw nvae;
					}

					switch (alt33) {
						case 1 :
							// Pddl.g:266:20: ( '(' ')' )
							{
							// Pddl.g:266:20: ( '(' ')' )
							// Pddl.g:266:21: '(' ')'
							{
							char_literal130=(Token)match(input,72,FOLLOW_72_in_constraintDefBody1510); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_72.add(char_literal130);

							char_literal131=(Token)match(input,73,FOLLOW_73_in_constraintDefBody1512); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_73.add(char_literal131);

							}

							}
							break;
						case 2 :
							// Pddl.g:266:32: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_constraintDefBody1517);
							goalDesc132=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc132.getTree());
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
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 267:4: -> ^( PRECONDITION ( goalDesc )? )
			{
				// Pddl.g:267:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:267:22: ( goalDesc )?
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
			if ( state.backtracking>0 ) { memoize(input, 31, constraintDefBody_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constraintDefBody"


	public static class belief_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "belief"
	// Pddl.g:282:1: belief : goalDesc ( initEl )* -> ^( BELIEF goalDesc ( initEl )* ) ;
	public final PddlParser.belief_return belief() throws RecognitionException {
		PddlParser.belief_return retval = new PddlParser.belief_return();
		retval.start = input.LT(1);
		int belief_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope goalDesc133 =null;
		ParserRuleReturnScope initEl134 =null;

		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

			// Pddl.g:283:2: ( goalDesc ( initEl )* -> ^( BELIEF goalDesc ( initEl )* ) )
			// Pddl.g:283:4: goalDesc ( initEl )*
			{
			pushFollow(FOLLOW_goalDesc_in_belief1555);
			goalDesc133=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc133.getTree());
			// Pddl.g:284:4: ( initEl )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==72) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// Pddl.g:284:4: initEl
					{
					pushFollow(FOLLOW_initEl_in_belief1560);
					initEl134=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl134.getTree());
					}
					break;

				default :
					break loop35;
				}
			}

			// AST REWRITE
			// elements: initEl, goalDesc
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 284:12: -> ^( BELIEF goalDesc ( initEl )* )
			{
				// Pddl.g:284:15: ^( BELIEF goalDesc ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BELIEF, "BELIEF"), root_1);
				adaptor.addChild(root_1, stream_goalDesc.nextTree());
				// Pddl.g:284:33: ( initEl )*
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
			if ( state.backtracking>0 ) { memoize(input, 32, belief_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "belief"


	public static class goalDesc_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "goalDesc"
	// Pddl.g:287:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'oneof' ( goalDesc )* ')' -> ^( ONEOF ( goalDesc )* ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
		PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
		retval.start = input.LT(1);
		int goalDesc_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal136=null;
		Token string_literal137=null;
		Token char_literal139=null;
		Token char_literal140=null;
		Token string_literal141=null;
		Token char_literal143=null;
		Token char_literal144=null;
		Token string_literal145=null;
		Token char_literal147=null;
		Token char_literal148=null;
		Token string_literal149=null;
		Token char_literal151=null;
		Token char_literal152=null;
		Token string_literal153=null;
		Token char_literal156=null;
		Token char_literal157=null;
		Token string_literal158=null;
		Token char_literal159=null;
		Token char_literal161=null;
		Token char_literal163=null;
		Token char_literal164=null;
		Token string_literal165=null;
		Token char_literal166=null;
		Token char_literal168=null;
		Token char_literal170=null;
		ParserRuleReturnScope atomicTermFormula135 =null;
		ParserRuleReturnScope goalDesc138 =null;
		ParserRuleReturnScope goalDesc142 =null;
		ParserRuleReturnScope goalDesc146 =null;
		ParserRuleReturnScope goalDesc150 =null;
		ParserRuleReturnScope goalDesc154 =null;
		ParserRuleReturnScope goalDesc155 =null;
		ParserRuleReturnScope typedVariableList160 =null;
		ParserRuleReturnScope goalDesc162 =null;
		ParserRuleReturnScope typedVariableList167 =null;
		ParserRuleReturnScope goalDesc169 =null;
		ParserRuleReturnScope fComp171 =null;
		ParserRuleReturnScope equality172 =null;

		Object char_literal136_tree=null;
		Object string_literal137_tree=null;
		Object char_literal139_tree=null;
		Object char_literal140_tree=null;
		Object string_literal141_tree=null;
		Object char_literal143_tree=null;
		Object char_literal144_tree=null;
		Object string_literal145_tree=null;
		Object char_literal147_tree=null;
		Object char_literal148_tree=null;
		Object string_literal149_tree=null;
		Object char_literal151_tree=null;
		Object char_literal152_tree=null;
		Object string_literal153_tree=null;
		Object char_literal156_tree=null;
		Object char_literal157_tree=null;
		Object string_literal158_tree=null;
		Object char_literal159_tree=null;
		Object char_literal161_tree=null;
		Object char_literal163_tree=null;
		Object char_literal164_tree=null;
		Object string_literal165_tree=null;
		Object char_literal166_tree=null;
		Object char_literal168_tree=null;
		Object char_literal170_tree=null;
		RewriteRuleTokenStream stream_133=new RewriteRuleTokenStream(adaptor,"token 133");
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_135=new RewriteRuleTokenStream(adaptor,"token 135");
		RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
		RewriteRuleTokenStream stream_136=new RewriteRuleTokenStream(adaptor,"token 136");
		RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
		RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

			// Pddl.g:288:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'oneof' ( goalDesc )* ')' -> ^( ONEOF ( goalDesc )* ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt39=10;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==72) ) {
				switch ( input.LA(2) ) {
				case 113:
					{
					alt39=2;
					}
					break;
				case 136:
					{
					alt39=3;
					}
					break;
				case 133:
					{
					alt39=4;
					}
					break;
				case 135:
					{
					alt39=5;
					}
					break;
				case 128:
					{
					alt39=6;
					}
					break;
				case 124:
					{
					alt39=7;
					}
					break;
				case 125:
					{
					alt39=8;
					}
					break;
				case 103:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA39_14 = input.LA(5);
							if ( (LA39_14==73) ) {
								int LA39_15 = input.LA(6);
								if ( (synpred52_Pddl()) ) {
									alt39=9;
								}
								else if ( (true) ) {
									alt39=10;
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 39, 14, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case NUMBER:
						case 71:
						case 72:
							{
							alt39=9;
							}
							break;
						case VARIABLE:
							{
							alt39=10;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 39, 12, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case NUMBER:
					case 71:
					case 72:
						{
						alt39=9;
						}
						break;
					case VARIABLE:
						{
						alt39=10;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 39, 9, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case NAME:
					{
					alt39=1;
					}
					break;
				case 101:
				case 102:
				case 104:
				case 105:
					{
					alt39=9;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 39, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:288:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1582);
					atomicTermFormula135=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula135.getTree());

					}
					break;
				case 2 :
					// Pddl.g:289:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal136=(Token)match(input,72,FOLLOW_72_in_goalDesc1587); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal136);

					string_literal137=(Token)match(input,113,FOLLOW_113_in_goalDesc1589); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal137);

					// Pddl.g:289:14: ( goalDesc )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==72) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// Pddl.g:289:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1591);
							goalDesc138=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc138.getTree());
							}
							break;

						default :
							break loop36;
						}
					}

					char_literal139=(Token)match(input,73,FOLLOW_73_in_goalDesc1594); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal139);

					// AST REWRITE
					// elements: goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 290:12: -> ^( AND_GD ( goalDesc )* )
					{
						// Pddl.g:290:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// Pddl.g:290:24: ( goalDesc )*
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
					// Pddl.g:291:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal140=(Token)match(input,72,FOLLOW_72_in_goalDesc1619); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal140);

					string_literal141=(Token)match(input,136,FOLLOW_136_in_goalDesc1621); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_136.add(string_literal141);

					// Pddl.g:291:13: ( goalDesc )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==72) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// Pddl.g:291:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1623);
							goalDesc142=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc142.getTree());
							}
							break;

						default :
							break loop37;
						}
					}

					char_literal143=(Token)match(input,73,FOLLOW_73_in_goalDesc1626); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal143);

					// AST REWRITE
					// elements: goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 292:12: -> ^( OR_GD ( goalDesc )* )
					{
						// Pddl.g:292:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:292:23: ( goalDesc )*
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
					// Pddl.g:293:4: '(' 'not' goalDesc ')'
					{
					char_literal144=(Token)match(input,72,FOLLOW_72_in_goalDesc1651); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal144);

					string_literal145=(Token)match(input,133,FOLLOW_133_in_goalDesc1653); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_133.add(string_literal145);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1655);
					goalDesc146=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc146.getTree());
					char_literal147=(Token)match(input,73,FOLLOW_73_in_goalDesc1657); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal147);

					// AST REWRITE
					// elements: goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 294:12: -> ^( NOT_GD goalDesc )
					{
						// Pddl.g:294:15: ^( NOT_GD goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_GD, "NOT_GD"), root_1);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// Pddl.g:295:4: '(' 'oneof' ( goalDesc )* ')'
					{
					char_literal148=(Token)match(input,72,FOLLOW_72_in_goalDesc1681); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal148);

					string_literal149=(Token)match(input,135,FOLLOW_135_in_goalDesc1683); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_135.add(string_literal149);

					// Pddl.g:295:17: ( goalDesc )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==72) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// Pddl.g:295:17: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1686);
							goalDesc150=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc150.getTree());
							}
							break;

						default :
							break loop38;
						}
					}

					char_literal151=(Token)match(input,73,FOLLOW_73_in_goalDesc1689); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal151);

					// AST REWRITE
					// elements: goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 295:32: -> ^( ONEOF ( goalDesc )* )
					{
						// Pddl.g:295:35: ^( ONEOF ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONEOF, "ONEOF"), root_1);
						// Pddl.g:295:43: ( goalDesc )*
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
				case 6 :
					// Pddl.g:296:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal152=(Token)match(input,72,FOLLOW_72_in_goalDesc1704); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal152);

					string_literal153=(Token)match(input,128,FOLLOW_128_in_goalDesc1706); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_128.add(string_literal153);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1708);
					goalDesc154=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc154.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1710);
					goalDesc155=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc155.getTree());
					char_literal156=(Token)match(input,73,FOLLOW_73_in_goalDesc1712); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal156);

					// AST REWRITE
					// elements: goalDesc, goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 297:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// Pddl.g:297:15: ^( IMPLY_GD goalDesc goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMPLY_GD, "IMPLY_GD"), root_1);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// Pddl.g:298:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal157=(Token)match(input,72,FOLLOW_72_in_goalDesc1738); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal157);

					string_literal158=(Token)match(input,124,FOLLOW_124_in_goalDesc1740); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_124.add(string_literal158);

					char_literal159=(Token)match(input,72,FOLLOW_72_in_goalDesc1742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal159);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1744);
					typedVariableList160=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList160.getTree());
					char_literal161=(Token)match(input,73,FOLLOW_73_in_goalDesc1746); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal161);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1748);
					goalDesc162=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc162.getTree());
					char_literal163=(Token)match(input,73,FOLLOW_73_in_goalDesc1750); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal163);

					// AST REWRITE
					// elements: typedVariableList, goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 299:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// Pddl.g:299:15: ^( EXISTS_GD typedVariableList goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXISTS_GD, "EXISTS_GD"), root_1);
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
					// Pddl.g:300:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal164=(Token)match(input,72,FOLLOW_72_in_goalDesc1776); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal164);

					string_literal165=(Token)match(input,125,FOLLOW_125_in_goalDesc1778); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_125.add(string_literal165);

					char_literal166=(Token)match(input,72,FOLLOW_72_in_goalDesc1780); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal166);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1782);
					typedVariableList167=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList167.getTree());
					char_literal168=(Token)match(input,73,FOLLOW_73_in_goalDesc1784); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal168);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1786);
					goalDesc169=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc169.getTree());
					char_literal170=(Token)match(input,73,FOLLOW_73_in_goalDesc1788); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal170);

					// AST REWRITE
					// elements: goalDesc, typedVariableList
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 301:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// Pddl.g:301:15: ^( FORALL_GD typedVariableList goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORALL_GD, "FORALL_GD"), root_1);
						adaptor.addChild(root_1, stream_typedVariableList.nextTree());
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// Pddl.g:302:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1817);
					fComp171=fComp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fComp.add(fComp171.getTree());
					// AST REWRITE
					// elements: fComp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 303:15: -> ^( COMPARISON_GD fComp )
					{
						// Pddl.g:303:18: ^( COMPARISON_GD fComp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARISON_GD, "COMPARISON_GD"), root_1);
						adaptor.addChild(root_1, stream_fComp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// Pddl.g:304:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1844);
					equality172=equality();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_equality.add(equality172.getTree());
					// AST REWRITE
					// elements: equality
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 305:6: -> ^( EQUALITY_CON equality )
					{
						// Pddl.g:305:9: ^( EQUALITY_CON equality )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EQUALITY_CON, "EQUALITY_CON"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 33, goalDesc_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "goalDesc"


	public static class equality_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "equality"
	// Pddl.g:308:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws RecognitionException {
		PddlParser.equality_return retval = new PddlParser.equality_return();
		retval.start = input.LT(1);
		int equality_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal173=null;
		Token char_literal174=null;
		Token char_literal177=null;
		ParserRuleReturnScope term175 =null;
		ParserRuleReturnScope term176 =null;

		Object char_literal173_tree=null;
		Object char_literal174_tree=null;
		Object char_literal177_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }

			// Pddl.g:309:2: ( '(' ! '=' term term ')' !)
			// Pddl.g:309:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal173=(Token)match(input,72,FOLLOW_72_in_equality1872); if (state.failed) return retval;
			char_literal174=(Token)match(input,103,FOLLOW_103_in_equality1875); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal174_tree = (Object)adaptor.create(char_literal174);
			adaptor.addChild(root_0, char_literal174_tree);
			}

			pushFollow(FOLLOW_term_in_equality1877);
			term175=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term175.getTree());

			pushFollow(FOLLOW_term_in_equality1879);
			term176=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term176.getTree());

			char_literal177=(Token)match(input,73,FOLLOW_73_in_equality1881); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 34, equality_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "equality"


	public static class fComp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fComp"
	// Pddl.g:311:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws RecognitionException {
		PddlParser.fComp_return retval = new PddlParser.fComp_return();
		retval.start = input.LT(1);
		int fComp_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal178=null;
		Token char_literal182=null;
		ParserRuleReturnScope binaryComp179 =null;
		ParserRuleReturnScope fExp180 =null;
		ParserRuleReturnScope fExp181 =null;

		Object char_literal178_tree=null;
		Object char_literal182_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }

			// Pddl.g:312:2: ( '(' ! binaryComp fExp fExp ')' !)
			// Pddl.g:312:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal178=(Token)match(input,72,FOLLOW_72_in_fComp1892); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1895);
			binaryComp179=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp179.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1897);
			fExp180=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp180.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1899);
			fExp181=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp181.getTree());

			char_literal182=(Token)match(input,73,FOLLOW_73_in_fComp1901); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 35, fComp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fComp"


	public static class atomicTermFormula_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomicTermFormula"
	// Pddl.g:315:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);
		int atomicTermFormula_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal183=null;
		Token char_literal186=null;
		ParserRuleReturnScope predicate184 =null;
		ParserRuleReturnScope term185 =null;

		Object char_literal183_tree=null;
		Object char_literal186_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

			// Pddl.g:316:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// Pddl.g:316:4: '(' predicate ( term )* ')'
			{
			char_literal183=(Token)match(input,72,FOLLOW_72_in_atomicTermFormula1913); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal183);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1915);
			predicate184=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate184.getTree());
			// Pddl.g:316:18: ( term )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==NAME||LA40_0==VARIABLE) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Pddl.g:316:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1917);
					term185=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_term.add(term185.getTree());
					}
					break;

				default :
					break loop40;
				}
			}

			char_literal186=(Token)match(input,73,FOLLOW_73_in_atomicTermFormula1920); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal186);

			// AST REWRITE
			// elements: predicate, term
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 316:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// Pddl.g:316:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:316:53: ( term )*
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
			if ( state.backtracking>0 ) { memoize(input, 36, atomicTermFormula_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "atomicTermFormula"


	public static class term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// Pddl.g:319:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);
		int term_StartIndex = input.index();

		Object root_0 = null;

		Token set187=null;

		Object set187_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

			// Pddl.g:319:6: ( NAME | VARIABLE )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set187=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set187));
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
			if ( state.backtracking>0 ) { memoize(input, 37, term_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "term"


	public static class durativeActionDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durativeActionDef"
	// Pddl.g:323:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
		PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
		retval.start = input.LT(1);
		int durativeActionDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal188=null;
		Token string_literal189=null;
		Token string_literal191=null;
		Token char_literal192=null;
		Token char_literal194=null;
		Token char_literal196=null;
		ParserRuleReturnScope actionSymbol190 =null;
		ParserRuleReturnScope typedVariableList193 =null;
		ParserRuleReturnScope daDefBody195 =null;

		Object char_literal188_tree=null;
		Object string_literal189_tree=null;
		Object string_literal191_tree=null;
		Object char_literal192_tree=null;
		Object char_literal194_tree=null;
		Object char_literal196_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

			// Pddl.g:324:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// Pddl.g:324:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal188=(Token)match(input,72,FOLLOW_72_in_durativeActionDef1957); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal188);

			string_literal189=(Token)match(input,86,FOLLOW_86_in_durativeActionDef1959); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_86.add(string_literal189);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1961);
			actionSymbol190=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol190.getTree());
			string_literal191=(Token)match(input,95,FOLLOW_95_in_durativeActionDef1970); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal191);

			char_literal192=(Token)match(input,72,FOLLOW_72_in_durativeActionDef1973); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal192);

			// Pddl.g:325:27: ( typedVariableList )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==VARIABLE) ) {
				alt41=1;
			}
			else if ( (LA41_0==73) ) {
				int LA41_2 = input.LA(2);
				if ( (synpred55_Pddl()) ) {
					alt41=1;
				}
			}
			switch (alt41) {
				case 1 :
					// Pddl.g:325:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1976);
					typedVariableList193=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList193.getTree());
					}
					break;

			}

			char_literal194=(Token)match(input,73,FOLLOW_73_in_durativeActionDef1980); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal194);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1993);
			daDefBody195=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody195.getTree());
			char_literal196=(Token)match(input,73,FOLLOW_73_in_durativeActionDef1995); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal196);

			// AST REWRITE
			// elements: actionSymbol, daDefBody, typedVariableList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 327:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// Pddl.g:327:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DURATIVE_ACTION, "DURATIVE_ACTION"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 38, durativeActionDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "durativeActionDef"


	public static class daDefBody_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "daDefBody"
	// Pddl.g:330:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
		PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
		retval.start = input.LT(1);
		int daDefBody_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal197=null;
		Token string_literal199=null;
		Token char_literal200=null;
		Token char_literal201=null;
		Token string_literal203=null;
		Token char_literal204=null;
		Token char_literal205=null;
		ParserRuleReturnScope durationConstraint198 =null;
		ParserRuleReturnScope daGD202 =null;
		ParserRuleReturnScope daEffect206 =null;

		Object string_literal197_tree=null;
		Object string_literal199_tree=null;
		Object char_literal200_tree=null;
		Object char_literal201_tree=null;
		Object string_literal203_tree=null;
		Object char_literal204_tree=null;
		Object char_literal205_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }

			// Pddl.g:331:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt44=3;
			switch ( input.LA(1) ) {
			case 85:
				{
				alt44=1;
				}
				break;
			case 79:
				{
				alt44=2;
				}
				break;
			case 87:
				{
				alt44=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// Pddl.g:331:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal197=(Token)match(input,85,FOLLOW_85_in_daDefBody2028); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal197_tree = (Object)adaptor.create(string_literal197);
					adaptor.addChild(root_0, string_literal197_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody2030);
					durationConstraint198=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint198.getTree());

					}
					break;
				case 2 :
					// Pddl.g:332:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal199=(Token)match(input,79,FOLLOW_79_in_daDefBody2035); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal199_tree = (Object)adaptor.create(string_literal199);
					adaptor.addChild(root_0, string_literal199_tree);
					}

					// Pddl.g:332:17: ( ( '(' ')' ) | daGD )
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==72) ) {
						int LA42_1 = input.LA(2);
						if ( (LA42_1==73) ) {
							alt42=1;
						}
						else if ( (LA42_1==108||LA42_1==113||LA42_1==125||(LA42_1 >= 137 && LA42_1 <= 138)) ) {
							alt42=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 42, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 42, 0, input);
						throw nvae;
					}

					switch (alt42) {
						case 1 :
							// Pddl.g:332:18: ( '(' ')' )
							{
							// Pddl.g:332:18: ( '(' ')' )
							// Pddl.g:332:19: '(' ')'
							{
							char_literal200=(Token)match(input,72,FOLLOW_72_in_daDefBody2039); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal200_tree = (Object)adaptor.create(char_literal200);
							adaptor.addChild(root_0, char_literal200_tree);
							}

							char_literal201=(Token)match(input,73,FOLLOW_73_in_daDefBody2041); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal201_tree = (Object)adaptor.create(char_literal201);
							adaptor.addChild(root_0, char_literal201_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:332:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody2046);
							daGD202=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD202.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// Pddl.g:333:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal203=(Token)match(input,87,FOLLOW_87_in_daDefBody2055); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal203_tree = (Object)adaptor.create(string_literal203);
					adaptor.addChild(root_0, string_literal203_tree);
					}

					// Pddl.g:333:17: ( ( '(' ')' ) | daEffect )
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==72) ) {
						int LA43_1 = input.LA(2);
						if ( (LA43_1==73) ) {
							alt43=1;
						}
						else if ( (LA43_1==108||(LA43_1 >= 113 && LA43_1 <= 114)||LA43_1==119||LA43_1==125||LA43_1==129||(LA43_1 >= 140 && LA43_1 <= 141)||LA43_1==149) ) {
							alt43=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 43, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
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
							// Pddl.g:333:18: ( '(' ')' )
							{
							// Pddl.g:333:18: ( '(' ')' )
							// Pddl.g:333:19: '(' ')'
							{
							char_literal204=(Token)match(input,72,FOLLOW_72_in_daDefBody2059); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal204_tree = (Object)adaptor.create(char_literal204);
							adaptor.addChild(root_0, char_literal204_tree);
							}

							char_literal205=(Token)match(input,73,FOLLOW_73_in_daDefBody2061); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal205_tree = (Object)adaptor.create(char_literal205);
							adaptor.addChild(root_0, char_literal205_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:333:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody2066);
							daEffect206=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect206.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 39, daDefBody_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "daDefBody"


	public static class daGD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "daGD"
	// Pddl.g:336:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws RecognitionException {
		PddlParser.daGD_return retval = new PddlParser.daGD_return();
		retval.start = input.LT(1);
		int daGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal208=null;
		Token string_literal209=null;
		Token char_literal211=null;
		Token char_literal212=null;
		Token string_literal213=null;
		Token char_literal214=null;
		Token char_literal216=null;
		Token char_literal218=null;
		ParserRuleReturnScope prefTimedGD207 =null;
		ParserRuleReturnScope daGD210 =null;
		ParserRuleReturnScope typedVariableList215 =null;
		ParserRuleReturnScope daGD217 =null;

		Object char_literal208_tree=null;
		Object string_literal209_tree=null;
		Object char_literal211_tree=null;
		Object char_literal212_tree=null;
		Object string_literal213_tree=null;
		Object char_literal214_tree=null;
		Object char_literal216_tree=null;
		Object char_literal218_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }

			// Pddl.g:337:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt46=3;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==72) ) {
				switch ( input.LA(2) ) {
				case 108:
				case 137:
				case 138:
					{
					alt46=1;
					}
					break;
				case 113:
					{
					alt46=2;
					}
					break;
				case 125:
					{
					alt46=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:337:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD2081);
					prefTimedGD207=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD207.getTree());

					}
					break;
				case 2 :
					// Pddl.g:338:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal208=(Token)match(input,72,FOLLOW_72_in_daGD2086); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal208_tree = (Object)adaptor.create(char_literal208);
					adaptor.addChild(root_0, char_literal208_tree);
					}

					string_literal209=(Token)match(input,113,FOLLOW_113_in_daGD2088); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal209_tree = (Object)adaptor.create(string_literal209);
					adaptor.addChild(root_0, string_literal209_tree);
					}

					// Pddl.g:338:14: ( daGD )*
					loop45:
					while (true) {
						int alt45=2;
						int LA45_0 = input.LA(1);
						if ( (LA45_0==72) ) {
							alt45=1;
						}

						switch (alt45) {
						case 1 :
							// Pddl.g:338:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD2090);
							daGD210=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD210.getTree());

							}
							break;

						default :
							break loop45;
						}
					}

					char_literal211=(Token)match(input,73,FOLLOW_73_in_daGD2093); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal211_tree = (Object)adaptor.create(char_literal211);
					adaptor.addChild(root_0, char_literal211_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:339:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal212=(Token)match(input,72,FOLLOW_72_in_daGD2098); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal212_tree = (Object)adaptor.create(char_literal212);
					adaptor.addChild(root_0, char_literal212_tree);
					}

					string_literal213=(Token)match(input,125,FOLLOW_125_in_daGD2100); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal213_tree = (Object)adaptor.create(string_literal213);
					adaptor.addChild(root_0, string_literal213_tree);
					}

					char_literal214=(Token)match(input,72,FOLLOW_72_in_daGD2102); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (Object)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD2104);
					typedVariableList215=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList215.getTree());

					char_literal216=(Token)match(input,73,FOLLOW_73_in_daGD2106); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal216_tree = (Object)adaptor.create(char_literal216);
					adaptor.addChild(root_0, char_literal216_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD2108);
					daGD217=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD217.getTree());

					char_literal218=(Token)match(input,73,FOLLOW_73_in_daGD2110); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal218_tree = (Object)adaptor.create(char_literal218);
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
			if ( state.backtracking>0 ) { memoize(input, 40, daGD_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "daGD"


	public static class prefTimedGD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prefTimedGD"
	// Pddl.g:342:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
		PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
		retval.start = input.LT(1);
		int prefTimedGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal220=null;
		Token string_literal221=null;
		Token NAME222=null;
		Token char_literal224=null;
		ParserRuleReturnScope timedGD219 =null;
		ParserRuleReturnScope timedGD223 =null;

		Object char_literal220_tree=null;
		Object string_literal221_tree=null;
		Object NAME222_tree=null;
		Object char_literal224_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }

			// Pddl.g:343:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==72) ) {
				int LA48_1 = input.LA(2);
				if ( (LA48_1==108||LA48_1==137) ) {
					alt48=1;
				}
				else if ( (LA48_1==138) ) {
					alt48=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 48, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// Pddl.g:343:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD2121);
					timedGD219=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD219.getTree());

					}
					break;
				case 2 :
					// Pddl.g:344:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal220=(Token)match(input,72,FOLLOW_72_in_prefTimedGD2126); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal220_tree = (Object)adaptor.create(char_literal220);
					adaptor.addChild(root_0, char_literal220_tree);
					}

					string_literal221=(Token)match(input,138,FOLLOW_138_in_prefTimedGD2128); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal221_tree = (Object)adaptor.create(string_literal221);
					adaptor.addChild(root_0, string_literal221_tree);
					}

					// Pddl.g:344:21: ( NAME )?
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==NAME) ) {
						alt47=1;
					}
					switch (alt47) {
						case 1 :
							// Pddl.g:344:21: NAME
							{
							NAME222=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD2130); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME222_tree = (Object)adaptor.create(NAME222);
							adaptor.addChild(root_0, NAME222_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD2133);
					timedGD223=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD223.getTree());

					char_literal224=(Token)match(input,73,FOLLOW_73_in_prefTimedGD2135); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal224_tree = (Object)adaptor.create(char_literal224);
					adaptor.addChild(root_0, char_literal224_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 41, prefTimedGD_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "prefTimedGD"


	public static class timedGD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timedGD"
	// Pddl.g:347:1: timedGD : ( '(' '__at__' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws RecognitionException {
		PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
		retval.start = input.LT(1);
		int timedGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal225=null;
		Token string_literal226=null;
		Token char_literal229=null;
		Token char_literal230=null;
		Token string_literal231=null;
		Token char_literal234=null;
		ParserRuleReturnScope timeSpecifier227 =null;
		ParserRuleReturnScope goalDesc228 =null;
		ParserRuleReturnScope interval232 =null;
		ParserRuleReturnScope goalDesc233 =null;

		Object char_literal225_tree=null;
		Object string_literal226_tree=null;
		Object char_literal229_tree=null;
		Object char_literal230_tree=null;
		Object string_literal231_tree=null;
		Object char_literal234_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }

			// Pddl.g:348:2: ( '(' '__at__' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==72) ) {
				int LA49_1 = input.LA(2);
				if ( (LA49_1==108) ) {
					alt49=1;
				}
				else if ( (LA49_1==137) ) {
					alt49=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 49, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// Pddl.g:348:4: '(' '__at__' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal225=(Token)match(input,72,FOLLOW_72_in_timedGD2146); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal225_tree = (Object)adaptor.create(char_literal225);
					adaptor.addChild(root_0, char_literal225_tree);
					}

					string_literal226=(Token)match(input,108,FOLLOW_108_in_timedGD2148); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal226_tree = (Object)adaptor.create(string_literal226);
					adaptor.addChild(root_0, string_literal226_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD2150);
					timeSpecifier227=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier227.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2152);
					goalDesc228=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc228.getTree());

					char_literal229=(Token)match(input,73,FOLLOW_73_in_timedGD2154); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal229_tree = (Object)adaptor.create(char_literal229);
					adaptor.addChild(root_0, char_literal229_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:349:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal230=(Token)match(input,72,FOLLOW_72_in_timedGD2159); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal230_tree = (Object)adaptor.create(char_literal230);
					adaptor.addChild(root_0, char_literal230_tree);
					}

					string_literal231=(Token)match(input,137,FOLLOW_137_in_timedGD2161); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal231_tree = (Object)adaptor.create(string_literal231);
					adaptor.addChild(root_0, string_literal231_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD2163);
					interval232=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval232.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2165);
					goalDesc233=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc233.getTree());

					char_literal234=(Token)match(input,73,FOLLOW_73_in_timedGD2167); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal234_tree = (Object)adaptor.create(char_literal234);
					adaptor.addChild(root_0, char_literal234_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 42, timedGD_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "timedGD"


	public static class timeSpecifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timeSpecifier"
	// Pddl.g:352:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);
		int timeSpecifier_StartIndex = input.index();

		Object root_0 = null;

		Token set235=null;

		Object set235_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }

			// Pddl.g:352:15: ( 'start' | 'end' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set235=input.LT(1);
			if ( input.LA(1)==123||input.LA(1)==146 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set235));
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
			if ( state.backtracking>0 ) { memoize(input, 43, timeSpecifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "timeSpecifier"


	public static class interval_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "interval"
	// Pddl.g:353:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);
		int interval_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal236=null;

		Object string_literal236_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }

			// Pddl.g:353:10: ( 'all' )
			// Pddl.g:353:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal236=(Token)match(input,110,FOLLOW_110_in_interval2189); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal236_tree = (Object)adaptor.create(string_literal236);
			adaptor.addChild(root_0, string_literal236_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 44, interval_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "interval"


	public static class derivedDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "derivedDef"
	// Pddl.g:357:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
		PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
		retval.start = input.LT(1);
		int derivedDef_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal237=null;
		Token string_literal238=null;
		Token char_literal241=null;
		ParserRuleReturnScope typedVariableList239 =null;
		ParserRuleReturnScope goalDesc240 =null;

		Object char_literal237_tree=null;
		Object string_literal238_tree=null;
		Object char_literal241_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }

			// Pddl.g:358:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// Pddl.g:358:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal237=(Token)match(input,72,FOLLOW_72_in_derivedDef2202); if (state.failed) return retval;
			string_literal238=(Token)match(input,83,FOLLOW_83_in_derivedDef2205); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal238_tree = (Object)adaptor.create(string_literal238);
			root_0 = (Object)adaptor.becomeRoot(string_literal238_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef2208);
			typedVariableList239=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList239.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef2210);
			goalDesc240=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc240.getTree());

			char_literal241=(Token)match(input,73,FOLLOW_73_in_derivedDef2212); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 45, derivedDef_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "derivedDef"


	public static class fExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExp"
	// Pddl.g:363:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | '(' 'atan2' fExp ')' -> ^( ATAN2 fExp ) | '(' 'atan' fExp ')' -> ^( ATAN fExp ) | '(' 'tan' fExp ')' -> ^( TAN fExp ) | '(' 'abs' fExp ')' -> ^( ABS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws RecognitionException {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);
		int fExp_StartIndex = input.index();

		Object root_0 = null;

		Token NUMBER242=null;
		Token char_literal243=null;
		Token char_literal247=null;
		Token char_literal248=null;
		Token char_literal249=null;
		Token char_literal251=null;
		Token char_literal252=null;
		Token string_literal253=null;
		Token char_literal255=null;
		Token char_literal256=null;
		Token string_literal257=null;
		Token char_literal259=null;
		Token char_literal260=null;
		Token string_literal261=null;
		Token char_literal263=null;
		Token char_literal264=null;
		Token string_literal265=null;
		Token char_literal267=null;
		Token char_literal268=null;
		Token string_literal269=null;
		Token char_literal271=null;
		Token char_literal272=null;
		Token string_literal273=null;
		Token char_literal275=null;
		ParserRuleReturnScope binaryOp244 =null;
		ParserRuleReturnScope fExp245 =null;
		ParserRuleReturnScope fExp2246 =null;
		ParserRuleReturnScope fExp250 =null;
		ParserRuleReturnScope fExp254 =null;
		ParserRuleReturnScope fExp258 =null;
		ParserRuleReturnScope fExp262 =null;
		ParserRuleReturnScope fExp266 =null;
		ParserRuleReturnScope fExp270 =null;
		ParserRuleReturnScope fExp274 =null;
		ParserRuleReturnScope fHead276 =null;

		Object NUMBER242_tree=null;
		Object char_literal243_tree=null;
		Object char_literal247_tree=null;
		Object char_literal248_tree=null;
		Object char_literal249_tree=null;
		Object char_literal251_tree=null;
		Object char_literal252_tree=null;
		Object string_literal253_tree=null;
		Object char_literal255_tree=null;
		Object char_literal256_tree=null;
		Object string_literal257_tree=null;
		Object char_literal259_tree=null;
		Object char_literal260_tree=null;
		Object string_literal261_tree=null;
		Object char_literal263_tree=null;
		Object char_literal264_tree=null;
		Object string_literal265_tree=null;
		Object char_literal267_tree=null;
		Object char_literal268_tree=null;
		Object string_literal269_tree=null;
		Object char_literal271_tree=null;
		Object char_literal272_tree=null;
		Object string_literal273_tree=null;
		Object char_literal275_tree=null;
		RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
		RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
		RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
		RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleTokenStream stream_142=new RewriteRuleTokenStream(adaptor,"token 142");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }

			// Pddl.g:364:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | '(' 'atan2' fExp ')' -> ^( ATAN2 fExp ) | '(' 'atan' fExp ')' -> ^( ATAN fExp ) | '(' 'tan' fExp ')' -> ^( TAN fExp ) | '(' 'abs' fExp ')' -> ^( ABS fExp ) | fHead )
			int alt50=10;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt50=1;
				}
				break;
			case 72:
				{
				int LA50_2 = input.LA(2);
				if ( (synpred68_Pddl()) ) {
					alt50=2;
				}
				else if ( (synpred69_Pddl()) ) {
					alt50=3;
				}
				else if ( (synpred70_Pddl()) ) {
					alt50=4;
				}
				else if ( (synpred71_Pddl()) ) {
					alt50=5;
				}
				else if ( (synpred72_Pddl()) ) {
					alt50=6;
				}
				else if ( (synpred73_Pddl()) ) {
					alt50=7;
				}
				else if ( (synpred74_Pddl()) ) {
					alt50=8;
				}
				else if ( (synpred75_Pddl()) ) {
					alt50=9;
				}
				else if ( (true) ) {
					alt50=10;
				}

				}
				break;
			case NAME:
			case 71:
				{
				alt50=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// Pddl.g:364:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER242=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp2227); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER242_tree = (Object)adaptor.create(NUMBER242);
					adaptor.addChild(root_0, NUMBER242_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:365:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal243=(Token)match(input,72,FOLLOW_72_in_fExp2232); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal243);

					pushFollow(FOLLOW_binaryOp_in_fExp2234);
					binaryOp244=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp244.getTree());
					pushFollow(FOLLOW_fExp_in_fExp2236);
					fExp245=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp245.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp2238);
					fExp2246=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2246.getTree());
					char_literal247=(Token)match(input,73,FOLLOW_73_in_fExp2240); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal247);

					// AST REWRITE
					// elements: fExp2, binaryOp, fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 365:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// Pddl.g:365:35: ^( BINARY_OP binaryOp fExp fExp2 )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BINARY_OP, "BINARY_OP"), root_1);
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
					// Pddl.g:366:4: '(' '-' fExp ')'
					{
					char_literal248=(Token)match(input,72,FOLLOW_72_in_fExp2257); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal248);

					char_literal249=(Token)match(input,76,FOLLOW_76_in_fExp2259); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(char_literal249);

					pushFollow(FOLLOW_fExp_in_fExp2261);
					fExp250=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp250.getTree());
					char_literal251=(Token)match(input,73,FOLLOW_73_in_fExp2263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal251);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 366:21: -> ^( UNARY_MINUS fExp )
					{
						// Pddl.g:366:24: ^( UNARY_MINUS fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// Pddl.g:367:4: '(' 'sin' fExp ')'
					{
					char_literal252=(Token)match(input,72,FOLLOW_72_in_fExp2276); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal252);

					string_literal253=(Token)match(input,142,FOLLOW_142_in_fExp2278); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_142.add(string_literal253);

					pushFollow(FOLLOW_fExp_in_fExp2280);
					fExp254=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp254.getTree());
					char_literal255=(Token)match(input,73,FOLLOW_73_in_fExp2282); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal255);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 367:23: -> ^( SIN fExp )
					{
						// Pddl.g:367:26: ^( SIN fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SIN, "SIN"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// Pddl.g:368:4: '(' 'cos' fExp ')'
					{
					char_literal256=(Token)match(input,72,FOLLOW_72_in_fExp2295); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal256);

					string_literal257=(Token)match(input,118,FOLLOW_118_in_fExp2297); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_118.add(string_literal257);

					pushFollow(FOLLOW_fExp_in_fExp2299);
					fExp258=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp258.getTree());
					char_literal259=(Token)match(input,73,FOLLOW_73_in_fExp2301); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal259);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 368:23: -> ^( COS fExp )
					{
						// Pddl.g:368:26: ^( COS fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COS, "COS"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// Pddl.g:369:4: '(' 'atan2' fExp ')'
					{
					char_literal260=(Token)match(input,72,FOLLOW_72_in_fExp2314); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal260);

					string_literal261=(Token)match(input,117,FOLLOW_117_in_fExp2316); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_117.add(string_literal261);

					pushFollow(FOLLOW_fExp_in_fExp2318);
					fExp262=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp262.getTree());
					char_literal263=(Token)match(input,73,FOLLOW_73_in_fExp2320); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal263);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 369:25: -> ^( ATAN2 fExp )
					{
						// Pddl.g:369:28: ^( ATAN2 fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATAN2, "ATAN2"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// Pddl.g:370:4: '(' 'atan' fExp ')'
					{
					char_literal264=(Token)match(input,72,FOLLOW_72_in_fExp2333); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal264);

					string_literal265=(Token)match(input,116,FOLLOW_116_in_fExp2335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_116.add(string_literal265);

					pushFollow(FOLLOW_fExp_in_fExp2337);
					fExp266=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp266.getTree());
					char_literal267=(Token)match(input,73,FOLLOW_73_in_fExp2339); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal267);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 370:24: -> ^( ATAN fExp )
					{
						// Pddl.g:370:27: ^( ATAN fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATAN, "ATAN"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// Pddl.g:371:4: '(' 'tan' fExp ')'
					{
					char_literal268=(Token)match(input,72,FOLLOW_72_in_fExp2352); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal268);

					string_literal269=(Token)match(input,147,FOLLOW_147_in_fExp2354); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_147.add(string_literal269);

					pushFollow(FOLLOW_fExp_in_fExp2356);
					fExp270=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp270.getTree());
					char_literal271=(Token)match(input,73,FOLLOW_73_in_fExp2358); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal271);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 371:23: -> ^( TAN fExp )
					{
						// Pddl.g:371:26: ^( TAN fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TAN, "TAN"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					// Pddl.g:372:4: '(' 'abs' fExp ')'
					{
					char_literal272=(Token)match(input,72,FOLLOW_72_in_fExp2371); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal272);

					string_literal273=(Token)match(input,109,FOLLOW_109_in_fExp2373); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_109.add(string_literal273);

					pushFollow(FOLLOW_fExp_in_fExp2375);
					fExp274=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp274.getTree());
					char_literal275=(Token)match(input,73,FOLLOW_73_in_fExp2377); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal275);

					// AST REWRITE
					// elements: fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 372:23: -> ^( ABS fExp )
					{
						// Pddl.g:372:26: ^( ABS fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ABS, "ABS"), root_1);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 10 :
					// Pddl.g:373:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp2390);
					fHead276=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead276.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 46, fExp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fExp"


	public static class fExp2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExp2"
	// Pddl.g:378:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);
		int fExp2_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope fExp277 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }

			// Pddl.g:378:7: ( fExp )
			// Pddl.g:378:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp22402);
			fExp277=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp277.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 47, fExp2_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fExp2"


	public static class fHead_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fHead"
	// Pddl.g:380:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);
		int fHead_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal278=null;
		Token char_literal281=null;
		ParserRuleReturnScope functionSymbol279 =null;
		ParserRuleReturnScope term280 =null;
		ParserRuleReturnScope functionSymbol282 =null;

		Object char_literal278_tree=null;
		Object char_literal281_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }

			// Pddl.g:381:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==72) ) {
				alt52=1;
			}
			else if ( (LA52_0==NAME||LA52_0==71) ) {
				alt52=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// Pddl.g:381:4: '(' functionSymbol ( term )* ')'
					{
					char_literal278=(Token)match(input,72,FOLLOW_72_in_fHead2412); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal278);

					pushFollow(FOLLOW_functionSymbol_in_fHead2414);
					functionSymbol279=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol279.getTree());
					// Pddl.g:381:23: ( term )*
					loop51:
					while (true) {
						int alt51=2;
						int LA51_0 = input.LA(1);
						if ( (LA51_0==NAME||LA51_0==VARIABLE) ) {
							alt51=1;
						}

						switch (alt51) {
						case 1 :
							// Pddl.g:381:23: term
							{
							pushFollow(FOLLOW_term_in_fHead2416);
							term280=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term280.getTree());
							}
							break;

						default :
							break loop51;
						}
					}

					char_literal281=(Token)match(input,73,FOLLOW_73_in_fHead2419); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal281);

					// AST REWRITE
					// elements: term, functionSymbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 381:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// Pddl.g:381:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// Pddl.g:381:63: ( term )*
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
					// Pddl.g:382:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead2435);
					functionSymbol282=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol282.getTree());
					// AST REWRITE
					// elements: functionSymbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 382:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// Pddl.g:382:22: ^( FUNC_HEAD functionSymbol )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 48, fHead_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fHead"


	public static class effect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "effect"
	// Pddl.g:385:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);
		int effect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal283=null;
		Token string_literal284=null;
		Token char_literal286=null;
		ParserRuleReturnScope cEffect285 =null;
		ParserRuleReturnScope cEffect287 =null;

		Object char_literal283_tree=null;
		Object string_literal284_tree=null;
		Object char_literal286_tree=null;
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }

			// Pddl.g:386:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==72) ) {
				int LA54_1 = input.LA(2);
				if ( (LA54_1==113) ) {
					alt54=1;
				}
				else if ( (LA54_1==NAME||LA54_1==114||LA54_1==119||LA54_1==125||LA54_1==129||LA54_1==133||(LA54_1 >= 140 && LA54_1 <= 141)||LA54_1==149) ) {
					alt54=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 54, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}

			switch (alt54) {
				case 1 :
					// Pddl.g:386:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal283=(Token)match(input,72,FOLLOW_72_in_effect2454); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal283);

					string_literal284=(Token)match(input,113,FOLLOW_113_in_effect2456); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal284);

					// Pddl.g:386:14: ( cEffect )*
					loop53:
					while (true) {
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( (LA53_0==72) ) {
							alt53=1;
						}

						switch (alt53) {
						case 1 :
							// Pddl.g:386:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect2458);
							cEffect285=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect285.getTree());
							}
							break;

						default :
							break loop53;
						}
					}

					char_literal286=(Token)match(input,73,FOLLOW_73_in_effect2461); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal286);

					// AST REWRITE
					// elements: cEffect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 386:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// Pddl.g:386:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:386:43: ( cEffect )*
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
					// Pddl.g:387:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect2475);
					cEffect287=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect287.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 49, effect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "effect"


	public static class cEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cEffect"
	// Pddl.g:390:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);
		int cEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal288=null;
		Token string_literal289=null;
		Token char_literal290=null;
		Token char_literal292=null;
		Token char_literal294=null;
		Token char_literal295=null;
		Token string_literal296=null;
		Token char_literal299=null;
		ParserRuleReturnScope typedVariableList291 =null;
		ParserRuleReturnScope effect293 =null;
		ParserRuleReturnScope goalDesc297 =null;
		ParserRuleReturnScope condEffect298 =null;
		ParserRuleReturnScope pEffect300 =null;

		Object char_literal288_tree=null;
		Object string_literal289_tree=null;
		Object char_literal290_tree=null;
		Object char_literal292_tree=null;
		Object char_literal294_tree=null;
		Object char_literal295_tree=null;
		Object string_literal296_tree=null;
		Object char_literal299_tree=null;
		RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
		RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }

			// Pddl.g:391:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt55=3;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==72) ) {
				switch ( input.LA(2) ) {
				case 125:
					{
					alt55=1;
					}
					break;
				case 149:
					{
					alt55=2;
					}
					break;
				case NAME:
				case 114:
				case 119:
				case 129:
				case 133:
				case 140:
				case 141:
					{
					alt55=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 55, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:391:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal288=(Token)match(input,72,FOLLOW_72_in_cEffect2486); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal288);

					string_literal289=(Token)match(input,125,FOLLOW_125_in_cEffect2488); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_125.add(string_literal289);

					char_literal290=(Token)match(input,72,FOLLOW_72_in_cEffect2490); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal290);

					pushFollow(FOLLOW_typedVariableList_in_cEffect2492);
					typedVariableList291=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList291.getTree());
					char_literal292=(Token)match(input,73,FOLLOW_73_in_cEffect2494); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal292);

					pushFollow(FOLLOW_effect_in_cEffect2496);
					effect293=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect293.getTree());
					char_literal294=(Token)match(input,73,FOLLOW_73_in_cEffect2498); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal294);

					// AST REWRITE
					// elements: effect, typedVariableList
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 392:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// Pddl.g:392:7: ^( FORALL_EFFECT typedVariableList effect )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORALL_EFFECT, "FORALL_EFFECT"), root_1);
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
					// Pddl.g:393:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal295=(Token)match(input,72,FOLLOW_72_in_cEffect2516); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal295);

					string_literal296=(Token)match(input,149,FOLLOW_149_in_cEffect2518); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_149.add(string_literal296);

					pushFollow(FOLLOW_goalDesc_in_cEffect2520);
					goalDesc297=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc297.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect2522);
					condEffect298=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect298.getTree());
					char_literal299=(Token)match(input,73,FOLLOW_73_in_cEffect2524); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal299);

					// AST REWRITE
					// elements: goalDesc, condEffect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 394:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// Pddl.g:394:7: ^( WHEN_EFFECT goalDesc condEffect )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHEN_EFFECT, "WHEN_EFFECT"), root_1);
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
					// Pddl.g:395:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect2542);
					pEffect300=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect300.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 50, cEffect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "cEffect"


	public static class pEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pEffect"
	// Pddl.g:398:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);
		int pEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal301=null;
		Token char_literal305=null;
		Token char_literal306=null;
		Token string_literal307=null;
		Token char_literal309=null;
		ParserRuleReturnScope assignOp302 =null;
		ParserRuleReturnScope fHead303 =null;
		ParserRuleReturnScope fExp304 =null;
		ParserRuleReturnScope atomicTermFormula308 =null;
		ParserRuleReturnScope atomicTermFormula310 =null;

		Object char_literal301_tree=null;
		Object char_literal305_tree=null;
		Object char_literal306_tree=null;
		Object string_literal307_tree=null;
		Object char_literal309_tree=null;
		RewriteRuleTokenStream stream_133=new RewriteRuleTokenStream(adaptor,"token 133");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }

			// Pddl.g:399:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt56=3;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==72) ) {
				switch ( input.LA(2) ) {
				case 133:
					{
					alt56=2;
					}
					break;
				case 114:
				case 119:
				case 129:
				case 140:
				case 141:
					{
					alt56=1;
					}
					break;
				case NAME:
					{
					alt56=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 56, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// Pddl.g:399:4: '(' assignOp fHead fExp ')'
					{
					char_literal301=(Token)match(input,72,FOLLOW_72_in_pEffect2553); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal301);

					pushFollow(FOLLOW_assignOp_in_pEffect2555);
					assignOp302=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp302.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect2557);
					fHead303=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead303.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect2559);
					fExp304=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp304.getTree());
					char_literal305=(Token)match(input,73,FOLLOW_73_in_pEffect2561); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal305);

					// AST REWRITE
					// elements: assignOp, fExp, fHead
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 400:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// Pddl.g:400:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_EFFECT, "ASSIGN_EFFECT"), root_1);
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
					// Pddl.g:401:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal306=(Token)match(input,72,FOLLOW_72_in_pEffect2581); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal306);

					string_literal307=(Token)match(input,133,FOLLOW_133_in_pEffect2583); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_133.add(string_literal307);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2585);
					atomicTermFormula308=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula308.getTree());
					char_literal309=(Token)match(input,73,FOLLOW_73_in_pEffect2587); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal309);

					// AST REWRITE
					// elements: atomicTermFormula
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 402:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// Pddl.g:402:7: ^( NOT_EFFECT atomicTermFormula )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_EFFECT, "NOT_EFFECT"), root_1);
						adaptor.addChild(root_1, stream_atomicTermFormula.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// Pddl.g:403:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2603);
					atomicTermFormula310=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula310.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 51, pEffect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "pEffect"


	public static class condEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condEffect"
	// Pddl.g:408:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);
		int condEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal311=null;
		Token string_literal312=null;
		Token char_literal314=null;
		ParserRuleReturnScope pEffect313 =null;
		ParserRuleReturnScope pEffect315 =null;

		Object char_literal311_tree=null;
		Object string_literal312_tree=null;
		Object char_literal314_tree=null;
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }

			// Pddl.g:409:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==72) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==113) ) {
					alt58=1;
				}
				else if ( (LA58_1==NAME||LA58_1==114||LA58_1==119||LA58_1==129||LA58_1==133||(LA58_1 >= 140 && LA58_1 <= 141)) ) {
					alt58=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 58, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:409:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal311=(Token)match(input,72,FOLLOW_72_in_condEffect2616); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal311);

					string_literal312=(Token)match(input,113,FOLLOW_113_in_condEffect2618); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal312);

					// Pddl.g:409:14: ( pEffect )*
					loop57:
					while (true) {
						int alt57=2;
						int LA57_0 = input.LA(1);
						if ( (LA57_0==72) ) {
							alt57=1;
						}

						switch (alt57) {
						case 1 :
							// Pddl.g:409:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2620);
							pEffect313=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect313.getTree());
							}
							break;

						default :
							break loop57;
						}
					}

					char_literal314=(Token)match(input,73,FOLLOW_73_in_condEffect2623); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal314);

					// AST REWRITE
					// elements: pEffect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 409:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// Pddl.g:409:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:409:43: ( pEffect )*
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
					// Pddl.g:410:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2637);
					pEffect315=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect315.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 52, condEffect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "condEffect"


	public static class binaryOp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryOp"
	// Pddl.g:415:1: binaryOp : ( '*' | '+' | '-' | '/' | '^' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);
		int binaryOp_StartIndex = input.index();

		Object root_0 = null;

		Token set316=null;

		Object set316_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }

			// Pddl.g:415:10: ( '*' | '+' | '-' | '/' | '^' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set316=input.LT(1);
			if ( (input.LA(1) >= 74 && input.LA(1) <= 77)||input.LA(1)==107 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set316));
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
			if ( state.backtracking>0 ) { memoize(input, 53, binaryOp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "binaryOp"


	public static class multiOp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multiOp"
	// Pddl.g:417:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);
		int multiOp_StartIndex = input.index();

		Object root_0 = null;

		Token set317=null;

		Object set317_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }

			// Pddl.g:417:9: ( '*' | '+' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set317=input.LT(1);
			if ( (input.LA(1) >= 74 && input.LA(1) <= 75) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set317));
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
			if ( state.backtracking>0 ) { memoize(input, 54, multiOp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "multiOp"


	public static class binaryComp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryComp"
	// Pddl.g:419:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);
		int binaryComp_StartIndex = input.index();

		Object root_0 = null;

		Token set318=null;

		Object set318_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }

			// Pddl.g:419:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set318=input.LT(1);
			if ( (input.LA(1) >= 101 && input.LA(1) <= 105) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set318));
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
			if ( state.backtracking>0 ) { memoize(input, 55, binaryComp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "binaryComp"


	public static class assignOp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignOp"
	// Pddl.g:421:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);
		int assignOp_StartIndex = input.index();

		Object root_0 = null;

		Token set319=null;

		Object set319_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }

			// Pddl.g:421:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set319=input.LT(1);
			if ( input.LA(1)==114||input.LA(1)==119||input.LA(1)==129||(input.LA(1) >= 140 && input.LA(1) <= 141) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set319));
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
			if ( state.backtracking>0 ) { memoize(input, 56, assignOp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "assignOp"


	public static class durationConstraint_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durationConstraint"
	// Pddl.g:426:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);
		int durationConstraint_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal320=null;
		Token string_literal321=null;
		Token char_literal323=null;
		Token char_literal324=null;
		Token char_literal325=null;
		ParserRuleReturnScope simpleDurationConstraint322 =null;
		ParserRuleReturnScope simpleDurationConstraint326 =null;

		Object char_literal320_tree=null;
		Object string_literal321_tree=null;
		Object char_literal323_tree=null;
		Object char_literal324_tree=null;
		Object char_literal325_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }

			// Pddl.g:427:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt60=3;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==72) ) {
				switch ( input.LA(2) ) {
				case 113:
					{
					alt60=1;
					}
					break;
				case 73:
					{
					alt60=2;
					}
					break;
				case 102:
				case 103:
				case 105:
				case 108:
					{
					alt60=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 60, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}

			switch (alt60) {
				case 1 :
					// Pddl.g:427:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal320=(Token)match(input,72,FOLLOW_72_in_durationConstraint2742); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal320_tree = (Object)adaptor.create(char_literal320);
					adaptor.addChild(root_0, char_literal320_tree);
					}

					string_literal321=(Token)match(input,113,FOLLOW_113_in_durationConstraint2744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal321_tree = (Object)adaptor.create(string_literal321);
					adaptor.addChild(root_0, string_literal321_tree);
					}

					// Pddl.g:427:14: ( simpleDurationConstraint )+
					int cnt59=0;
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( (LA59_0==72) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// Pddl.g:427:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2746);
							simpleDurationConstraint322=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint322.getTree());

							}
							break;

						default :
							if ( cnt59 >= 1 ) break loop59;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(59, input);
							throw eee;
						}
						cnt59++;
					}

					char_literal323=(Token)match(input,73,FOLLOW_73_in_durationConstraint2749); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal323_tree = (Object)adaptor.create(char_literal323);
					adaptor.addChild(root_0, char_literal323_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:428:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal324=(Token)match(input,72,FOLLOW_72_in_durationConstraint2754); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal324_tree = (Object)adaptor.create(char_literal324);
					adaptor.addChild(root_0, char_literal324_tree);
					}

					char_literal325=(Token)match(input,73,FOLLOW_73_in_durationConstraint2756); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal325_tree = (Object)adaptor.create(char_literal325);
					adaptor.addChild(root_0, char_literal325_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:429:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2761);
					simpleDurationConstraint326=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint326.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 57, durationConstraint_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "durationConstraint"


	public static class simpleDurationConstraint_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "simpleDurationConstraint"
	// Pddl.g:432:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' '__at__' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);
		int simpleDurationConstraint_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal327=null;
		Token string_literal329=null;
		Token char_literal331=null;
		Token char_literal332=null;
		Token string_literal333=null;
		Token char_literal336=null;
		ParserRuleReturnScope durOp328 =null;
		ParserRuleReturnScope durValue330 =null;
		ParserRuleReturnScope timeSpecifier334 =null;
		ParserRuleReturnScope simpleDurationConstraint335 =null;

		Object char_literal327_tree=null;
		Object string_literal329_tree=null;
		Object char_literal331_tree=null;
		Object char_literal332_tree=null;
		Object string_literal333_tree=null;
		Object char_literal336_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }

			// Pddl.g:433:2: ( '(' durOp '?duration' durValue ')' | '(' '__at__' timeSpecifier simpleDurationConstraint ')' )
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==72) ) {
				int LA61_1 = input.LA(2);
				if ( (LA61_1==108) ) {
					alt61=2;
				}
				else if ( ((LA61_1 >= 102 && LA61_1 <= 103)||LA61_1==105) ) {
					alt61=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 61, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:433:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal327=(Token)match(input,72,FOLLOW_72_in_simpleDurationConstraint2772); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal327_tree = (Object)adaptor.create(char_literal327);
					adaptor.addChild(root_0, char_literal327_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2774);
					durOp328=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp328.getTree());

					string_literal329=(Token)match(input,106,FOLLOW_106_in_simpleDurationConstraint2776); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal329_tree = (Object)adaptor.create(string_literal329);
					adaptor.addChild(root_0, string_literal329_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2778);
					durValue330=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue330.getTree());

					char_literal331=(Token)match(input,73,FOLLOW_73_in_simpleDurationConstraint2780); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal331_tree = (Object)adaptor.create(char_literal331);
					adaptor.addChild(root_0, char_literal331_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:434:4: '(' '__at__' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal332=(Token)match(input,72,FOLLOW_72_in_simpleDurationConstraint2785); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal332_tree = (Object)adaptor.create(char_literal332);
					adaptor.addChild(root_0, char_literal332_tree);
					}

					string_literal333=(Token)match(input,108,FOLLOW_108_in_simpleDurationConstraint2787); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal333_tree = (Object)adaptor.create(string_literal333);
					adaptor.addChild(root_0, string_literal333_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2789);
					timeSpecifier334=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier334.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2791);
					simpleDurationConstraint335=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint335.getTree());

					char_literal336=(Token)match(input,73,FOLLOW_73_in_simpleDurationConstraint2793); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal336_tree = (Object)adaptor.create(char_literal336);
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
			if ( state.backtracking>0 ) { memoize(input, 58, simpleDurationConstraint_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "simpleDurationConstraint"


	public static class durOp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durOp"
	// Pddl.g:437:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);
		int durOp_StartIndex = input.index();

		Object root_0 = null;

		Token set337=null;

		Object set337_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }

			// Pddl.g:437:7: ( '<=' | '>=' | '=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set337=input.LT(1);
			if ( (input.LA(1) >= 102 && input.LA(1) <= 103)||input.LA(1)==105 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set337));
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
			if ( state.backtracking>0 ) { memoize(input, 59, durOp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "durOp"


	public static class durValue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durValue"
	// Pddl.g:439:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);
		int durValue_StartIndex = input.index();

		Object root_0 = null;

		Token NUMBER338=null;
		ParserRuleReturnScope fExp339 =null;

		Object NUMBER338_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }

			// Pddl.g:439:10: ( NUMBER | fExp )
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==NUMBER) ) {
				int LA62_1 = input.LA(2);
				if ( (synpred105_Pddl()) ) {
					alt62=1;
				}
				else if ( (true) ) {
					alt62=2;
				}

			}
			else if ( (LA62_0==NAME||(LA62_0 >= 71 && LA62_0 <= 72)) ) {
				alt62=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}

			switch (alt62) {
				case 1 :
					// Pddl.g:439:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER338=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2820); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER338_tree = (Object)adaptor.create(NUMBER338);
					adaptor.addChild(root_0, NUMBER338_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:439:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2824);
					fExp339=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp339.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 60, durValue_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "durValue"


	public static class daEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "daEffect"
	// Pddl.g:441:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);
		int daEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal340=null;
		Token string_literal341=null;
		Token char_literal343=null;
		Token char_literal345=null;
		Token string_literal346=null;
		Token char_literal347=null;
		Token char_literal349=null;
		Token char_literal351=null;
		Token char_literal352=null;
		Token string_literal353=null;
		Token char_literal356=null;
		Token char_literal357=null;
		Token char_literal361=null;
		ParserRuleReturnScope daEffect342 =null;
		ParserRuleReturnScope timedEffect344 =null;
		ParserRuleReturnScope typedVariableList348 =null;
		ParserRuleReturnScope daEffect350 =null;
		ParserRuleReturnScope daGD354 =null;
		ParserRuleReturnScope timedEffect355 =null;
		ParserRuleReturnScope assignOp358 =null;
		ParserRuleReturnScope fHead359 =null;
		ParserRuleReturnScope fExpDA360 =null;

		Object char_literal340_tree=null;
		Object string_literal341_tree=null;
		Object char_literal343_tree=null;
		Object char_literal345_tree=null;
		Object string_literal346_tree=null;
		Object char_literal347_tree=null;
		Object char_literal349_tree=null;
		Object char_literal351_tree=null;
		Object char_literal352_tree=null;
		Object string_literal353_tree=null;
		Object char_literal356_tree=null;
		Object char_literal357_tree=null;
		Object char_literal361_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }

			// Pddl.g:442:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt64=5;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==72) ) {
				int LA64_1 = input.LA(2);
				if ( (synpred107_Pddl()) ) {
					alt64=1;
				}
				else if ( (synpred108_Pddl()) ) {
					alt64=2;
				}
				else if ( (synpred109_Pddl()) ) {
					alt64=3;
				}
				else if ( (synpred110_Pddl()) ) {
					alt64=4;
				}
				else if ( (true) ) {
					alt64=5;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}

			switch (alt64) {
				case 1 :
					// Pddl.g:442:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal340=(Token)match(input,72,FOLLOW_72_in_daEffect2834); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal340_tree = (Object)adaptor.create(char_literal340);
					adaptor.addChild(root_0, char_literal340_tree);
					}

					string_literal341=(Token)match(input,113,FOLLOW_113_in_daEffect2836); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal341_tree = (Object)adaptor.create(string_literal341);
					adaptor.addChild(root_0, string_literal341_tree);
					}

					// Pddl.g:442:14: ( daEffect )*
					loop63:
					while (true) {
						int alt63=2;
						int LA63_0 = input.LA(1);
						if ( (LA63_0==72) ) {
							alt63=1;
						}

						switch (alt63) {
						case 1 :
							// Pddl.g:442:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2838);
							daEffect342=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect342.getTree());

							}
							break;

						default :
							break loop63;
						}
					}

					char_literal343=(Token)match(input,73,FOLLOW_73_in_daEffect2841); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal343_tree = (Object)adaptor.create(char_literal343);
					adaptor.addChild(root_0, char_literal343_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:443:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2846);
					timedEffect344=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect344.getTree());

					}
					break;
				case 3 :
					// Pddl.g:444:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal345=(Token)match(input,72,FOLLOW_72_in_daEffect2851); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal345_tree = (Object)adaptor.create(char_literal345);
					adaptor.addChild(root_0, char_literal345_tree);
					}

					string_literal346=(Token)match(input,125,FOLLOW_125_in_daEffect2853); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal346_tree = (Object)adaptor.create(string_literal346);
					adaptor.addChild(root_0, string_literal346_tree);
					}

					char_literal347=(Token)match(input,72,FOLLOW_72_in_daEffect2855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal347_tree = (Object)adaptor.create(char_literal347);
					adaptor.addChild(root_0, char_literal347_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2857);
					typedVariableList348=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList348.getTree());

					char_literal349=(Token)match(input,73,FOLLOW_73_in_daEffect2859); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal349_tree = (Object)adaptor.create(char_literal349);
					adaptor.addChild(root_0, char_literal349_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2861);
					daEffect350=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect350.getTree());

					char_literal351=(Token)match(input,73,FOLLOW_73_in_daEffect2863); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal351_tree = (Object)adaptor.create(char_literal351);
					adaptor.addChild(root_0, char_literal351_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:445:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal352=(Token)match(input,72,FOLLOW_72_in_daEffect2868); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal352_tree = (Object)adaptor.create(char_literal352);
					adaptor.addChild(root_0, char_literal352_tree);
					}

					string_literal353=(Token)match(input,149,FOLLOW_149_in_daEffect2870); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal353_tree = (Object)adaptor.create(string_literal353);
					adaptor.addChild(root_0, string_literal353_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2872);
					daGD354=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD354.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2874);
					timedEffect355=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect355.getTree());

					char_literal356=(Token)match(input,73,FOLLOW_73_in_daEffect2876); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal356_tree = (Object)adaptor.create(char_literal356);
					adaptor.addChild(root_0, char_literal356_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:446:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal357=(Token)match(input,72,FOLLOW_72_in_daEffect2881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal357_tree = (Object)adaptor.create(char_literal357);
					adaptor.addChild(root_0, char_literal357_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2883);
					assignOp358=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp358.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2885);
					fHead359=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead359.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2887);
					fExpDA360=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA360.getTree());

					char_literal361=(Token)match(input,73,FOLLOW_73_in_daEffect2889); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal361_tree = (Object)adaptor.create(char_literal361);
					adaptor.addChild(root_0, char_literal361_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 61, daEffect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "daEffect"


	public static class timedEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timedEffect"
	// Pddl.g:449:1: timedEffect : ( '(' '__at__' timeSpecifier daEffect ')' | '(' '__at__' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);
		int timedEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal362=null;
		Token string_literal363=null;
		Token char_literal366=null;
		Token char_literal367=null;
		Token string_literal368=null;
		Token char_literal371=null;
		Token char_literal372=null;
		Token char_literal376=null;
		ParserRuleReturnScope timeSpecifier364 =null;
		ParserRuleReturnScope daEffect365 =null;
		ParserRuleReturnScope timeSpecifier369 =null;
		ParserRuleReturnScope fAssignDA370 =null;
		ParserRuleReturnScope assignOp373 =null;
		ParserRuleReturnScope fHead374 =null;
		ParserRuleReturnScope fExp375 =null;

		Object char_literal362_tree=null;
		Object string_literal363_tree=null;
		Object char_literal366_tree=null;
		Object char_literal367_tree=null;
		Object string_literal368_tree=null;
		Object char_literal371_tree=null;
		Object char_literal372_tree=null;
		Object char_literal376_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }

			// Pddl.g:450:2: ( '(' '__at__' timeSpecifier daEffect ')' | '(' '__at__' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt65=3;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==72) ) {
				int LA65_1 = input.LA(2);
				if ( (synpred111_Pddl()) ) {
					alt65=1;
				}
				else if ( (synpred112_Pddl()) ) {
					alt65=2;
				}
				else if ( (true) ) {
					alt65=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}

			switch (alt65) {
				case 1 :
					// Pddl.g:450:4: '(' '__at__' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal362=(Token)match(input,72,FOLLOW_72_in_timedEffect2900); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal362_tree = (Object)adaptor.create(char_literal362);
					adaptor.addChild(root_0, char_literal362_tree);
					}

					string_literal363=(Token)match(input,108,FOLLOW_108_in_timedEffect2902); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal363_tree = (Object)adaptor.create(string_literal363);
					adaptor.addChild(root_0, string_literal363_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2904);
					timeSpecifier364=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier364.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2906);
					daEffect365=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect365.getTree());

					char_literal366=(Token)match(input,73,FOLLOW_73_in_timedEffect2908); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal366_tree = (Object)adaptor.create(char_literal366);
					adaptor.addChild(root_0, char_literal366_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:451:4: '(' '__at__' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal367=(Token)match(input,72,FOLLOW_72_in_timedEffect2918); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal367_tree = (Object)adaptor.create(char_literal367);
					adaptor.addChild(root_0, char_literal367_tree);
					}

					string_literal368=(Token)match(input,108,FOLLOW_108_in_timedEffect2920); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal368_tree = (Object)adaptor.create(string_literal368);
					adaptor.addChild(root_0, string_literal368_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2922);
					timeSpecifier369=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier369.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2924);
					fAssignDA370=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA370.getTree());

					char_literal371=(Token)match(input,73,FOLLOW_73_in_timedEffect2926); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal371_tree = (Object)adaptor.create(char_literal371);
					adaptor.addChild(root_0, char_literal371_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:452:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal372=(Token)match(input,72,FOLLOW_72_in_timedEffect2931); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal372_tree = (Object)adaptor.create(char_literal372);
					adaptor.addChild(root_0, char_literal372_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2933);
					assignOp373=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp373.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2935);
					fHead374=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead374.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2937);
					fExp375=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp375.getTree());

					char_literal376=(Token)match(input,73,FOLLOW_73_in_timedEffect2939); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal376_tree = (Object)adaptor.create(char_literal376);
					adaptor.addChild(root_0, char_literal376_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 62, timedEffect_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "timedEffect"


	public static class fAssignDA_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fAssignDA"
	// Pddl.g:455:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);
		int fAssignDA_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal377=null;
		Token char_literal381=null;
		ParserRuleReturnScope assignOp378 =null;
		ParserRuleReturnScope fHead379 =null;
		ParserRuleReturnScope fExpDA380 =null;

		Object char_literal377_tree=null;
		Object char_literal381_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }

			// Pddl.g:456:2: ( '(' assignOp fHead fExpDA ')' )
			// Pddl.g:456:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal377=(Token)match(input,72,FOLLOW_72_in_fAssignDA2959); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal377_tree = (Object)adaptor.create(char_literal377);
			adaptor.addChild(root_0, char_literal377_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2961);
			assignOp378=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp378.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2963);
			fHead379=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead379.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2965);
			fExpDA380=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA380.getTree());

			char_literal381=(Token)match(input,73,FOLLOW_73_in_fAssignDA2967); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal381_tree = (Object)adaptor.create(char_literal381);
			adaptor.addChild(root_0, char_literal381_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 63, fAssignDA_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fAssignDA"


	public static class fExpDA_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExpDA"
	// Pddl.g:459:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);
		int fExpDA_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal382=null;
		Token char_literal386=null;
		Token char_literal388=null;
		Token string_literal389=null;
		ParserRuleReturnScope binaryOp383 =null;
		ParserRuleReturnScope fExpDA384 =null;
		ParserRuleReturnScope fExpDA385 =null;
		ParserRuleReturnScope fExpDA387 =null;
		ParserRuleReturnScope fExp390 =null;

		Object char_literal382_tree=null;
		Object char_literal386_tree=null;
		Object char_literal388_tree=null;
		Object string_literal389_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }

			// Pddl.g:460:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt67=3;
			switch ( input.LA(1) ) {
			case 72:
				{
				int LA67_1 = input.LA(2);
				if ( (synpred114_Pddl()) ) {
					alt67=1;
				}
				else if ( (true) ) {
					alt67=3;
				}

				}
				break;
			case 106:
				{
				alt67=2;
				}
				break;
			case NAME:
			case NUMBER:
			case 71:
				{
				alt67=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}
			switch (alt67) {
				case 1 :
					// Pddl.g:460:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal382=(Token)match(input,72,FOLLOW_72_in_fExpDA2978); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal382_tree = (Object)adaptor.create(char_literal382);
					adaptor.addChild(root_0, char_literal382_tree);
					}

					// Pddl.g:460:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt66=2;
					int LA66_0 = input.LA(1);
					if ( (LA66_0==76) ) {
						int LA66_1 = input.LA(2);
						if ( (synpred113_Pddl()) ) {
							alt66=1;
						}
						else if ( (true) ) {
							alt66=2;
						}

					}
					else if ( ((LA66_0 >= 74 && LA66_0 <= 75)||LA66_0==77||LA66_0==107) ) {
						alt66=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 66, 0, input);
						throw nvae;
					}

					switch (alt66) {
						case 1 :
							// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
							{
							// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
							// Pddl.g:460:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2982);
							binaryOp383=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp383.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2984);
							fExpDA384=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA384.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2986);
							fExpDA385=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA385.getTree());

							}

							}
							break;
						case 2 :
							// Pddl.g:460:36: ( '-' fExpDA )
							{
							// Pddl.g:460:36: ( '-' fExpDA )
							// Pddl.g:460:37: '-' fExpDA
							{
							char_literal386=(Token)match(input,76,FOLLOW_76_in_fExpDA2992); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal386_tree = (Object)adaptor.create(char_literal386);
							adaptor.addChild(root_0, char_literal386_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2994);
							fExpDA387=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA387.getTree());

							}

							}
							break;

					}

					char_literal388=(Token)match(input,73,FOLLOW_73_in_fExpDA2998); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal388_tree = (Object)adaptor.create(char_literal388);
					adaptor.addChild(root_0, char_literal388_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:461:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal389=(Token)match(input,106,FOLLOW_106_in_fExpDA3003); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal389_tree = (Object)adaptor.create(string_literal389);
					adaptor.addChild(root_0, string_literal389_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:462:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA3008);
					fExp390=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp390.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 64, fExpDA_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "fExpDA"


	public static class problem_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "problem"
	// Pddl.g:467:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);
		int problem_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal391=null;
		Token string_literal392=null;
		Token char_literal401=null;
		ParserRuleReturnScope problemDecl393 =null;
		ParserRuleReturnScope problemDomain394 =null;
		ParserRuleReturnScope requireDef395 =null;
		ParserRuleReturnScope objectDecl396 =null;
		ParserRuleReturnScope init397 =null;
		ParserRuleReturnScope goal398 =null;
		ParserRuleReturnScope probConstraints399 =null;
		ParserRuleReturnScope metricSpec400 =null;

		Object char_literal391_tree=null;
		Object string_literal392_tree=null;
		Object char_literal401_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }

			// Pddl.g:468:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// Pddl.g:468:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal391=(Token)match(input,72,FOLLOW_72_in_problem3022); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal391);

			string_literal392=(Token)match(input,120,FOLLOW_120_in_problem3024); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_120.add(string_literal392);

			pushFollow(FOLLOW_problemDecl_in_problem3026);
			problemDecl393=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl393.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem3031);
			problemDomain394=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain394.getTree());
			// Pddl.g:470:7: ( requireDef )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==72) ) {
				int LA68_1 = input.LA(2);
				if ( (LA68_1==99) ) {
					alt68=1;
				}
			}
			switch (alt68) {
				case 1 :
					// Pddl.g:470:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem3039);
					requireDef395=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef395.getTree());
					}
					break;

			}

			// Pddl.g:471:7: ( objectDecl )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==72) ) {
				int LA69_1 = input.LA(2);
				if ( (LA69_1==94) ) {
					alt69=1;
				}
			}
			switch (alt69) {
				case 1 :
					// Pddl.g:471:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem3048);
					objectDecl396=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl396.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem3057);
			init397=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init397.getTree());
			pushFollow(FOLLOW_goal_in_problem3065);
			goal398=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal398.getTree());
			// Pddl.g:474:7: ( probConstraints )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==72) ) {
				int LA70_1 = input.LA(2);
				if ( (LA70_1==82) ) {
					alt70=1;
				}
			}
			switch (alt70) {
				case 1 :
					// Pddl.g:474:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem3073);
					probConstraints399=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints399.getTree());
					}
					break;

			}

			// Pddl.g:475:7: ( metricSpec )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==72) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// Pddl.g:475:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem3082);
					metricSpec400=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec400.getTree());
					}
					break;

			}

			char_literal401=(Token)match(input,73,FOLLOW_73_in_problem3098); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal401);

			// AST REWRITE
			// elements: problemDecl, objectDecl, probConstraints, problemDomain, goal, init, metricSpec, requireDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 478:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// Pddl.g:478:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// Pddl.g:478:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:478:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// Pddl.g:479:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// Pddl.g:479:36: ( metricSpec )?
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
			if ( state.backtracking>0 ) { memoize(input, 65, problem_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "problem"


	public static class problemDecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "problemDecl"
	// Pddl.g:482:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);
		int problemDecl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal402=null;
		Token string_literal403=null;
		Token NAME404=null;
		Token char_literal405=null;

		Object char_literal402_tree=null;
		Object string_literal403_tree=null;
		Object NAME404_tree=null;
		Object char_literal405_tree=null;
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }

			// Pddl.g:483:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// Pddl.g:483:7: '(' 'problem' NAME ')'
			{
			char_literal402=(Token)match(input,72,FOLLOW_72_in_problemDecl3155); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal402);

			string_literal403=(Token)match(input,139,FOLLOW_139_in_problemDecl3157); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(string_literal403);

			NAME404=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl3159); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME404);

			char_literal405=(Token)match(input,73,FOLLOW_73_in_problemDecl3161); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal405);

			// AST REWRITE
			// elements: NAME
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 484:5: -> ^( PROBLEM_NAME NAME )
			{
				// Pddl.g:484:8: ^( PROBLEM_NAME NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_NAME, "PROBLEM_NAME"), root_1);
				adaptor.addChild(root_1, stream_NAME.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 66, problemDecl_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "problemDecl"


	public static class problemDomain_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "problemDomain"
	// Pddl.g:487:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);
		int problemDomain_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal406=null;
		Token string_literal407=null;
		Token NAME408=null;
		Token char_literal409=null;

		Object char_literal406_tree=null;
		Object string_literal407_tree=null;
		Object NAME408_tree=null;
		Object char_literal409_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }

			// Pddl.g:488:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// Pddl.g:488:4: '(' ':domain' NAME ')'
			{
			char_literal406=(Token)match(input,72,FOLLOW_72_in_problemDomain3187); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal406);

			string_literal407=(Token)match(input,84,FOLLOW_84_in_problemDomain3189); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_84.add(string_literal407);

			NAME408=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain3191); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME408);

			char_literal409=(Token)match(input,73,FOLLOW_73_in_problemDomain3193); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal409);

			// AST REWRITE
			// elements: NAME
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 489:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// Pddl.g:489:5: ^( PROBLEM_DOMAIN NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_DOMAIN, "PROBLEM_DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_NAME.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 67, problemDomain_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "problemDomain"


	public static class objectDecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "objectDecl"
	// Pddl.g:492:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);
		int objectDecl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal410=null;
		Token string_literal411=null;
		Token char_literal413=null;
		ParserRuleReturnScope typedNameList412 =null;

		Object char_literal410_tree=null;
		Object string_literal411_tree=null;
		Object char_literal413_tree=null;
		RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }

			// Pddl.g:493:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// Pddl.g:493:4: '(' ':objects' typedNameList ')'
			{
			char_literal410=(Token)match(input,72,FOLLOW_72_in_objectDecl3213); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal410);

			string_literal411=(Token)match(input,94,FOLLOW_94_in_objectDecl3215); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_94.add(string_literal411);

			pushFollow(FOLLOW_typedNameList_in_objectDecl3217);
			typedNameList412=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList412.getTree());
			char_literal413=(Token)match(input,73,FOLLOW_73_in_objectDecl3219); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal413);

			// AST REWRITE
			// elements: typedNameList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
	                           // 494:2: -> ^( OBJECTS typedNameList )
                            {
                                // Pddl.g:494:5: ^( OBJECTS typedNameList )
                                {
                                    Object root_1 = (Object) adaptor.nil();
                                    root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(OBJECTS, "OBJECTS"), root_1);

                                    if (stream_typedNameList.hasNext()) {//This is a hack to handle empty lists. Something could be probably done in the parser
                                        adaptor.addChild(root_1, stream_typedNameList.nextTree());
                                        adaptor.addChild(root_0, root_1);
                                    }

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
			if ( state.backtracking>0 ) { memoize(input, 68, objectDecl_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "objectDecl"


	public static class init_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "init"
	// Pddl.g:497:1: init : ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) );
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);
		int init_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal414=null;
		Token string_literal415=null;
		Token char_literal417=null;
		Token char_literal418=null;
		Token string_literal419=null;
		Token char_literal421=null;
		ParserRuleReturnScope initEl416 =null;
		ParserRuleReturnScope belief420 =null;

		Object char_literal414_tree=null;
		Object string_literal415_tree=null;
		Object char_literal417_tree=null;
		Object char_literal418_tree=null;
		Object string_literal419_tree=null;
		Object char_literal421_tree=null;
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");
		RewriteRuleSubtreeStream stream_belief=new RewriteRuleSubtreeStream(adaptor,"rule belief");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }

			// Pddl.g:498:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) )
			int alt73=2;
			alt73 = dfa73.predict(input);
			switch (alt73) {
				case 1 :
					// Pddl.g:498:4: '(' ':init' ( initEl )* ')'
					{
					char_literal414=(Token)match(input,72,FOLLOW_72_in_init3239); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal414);

					string_literal415=(Token)match(input,92,FOLLOW_92_in_init3241); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal415);

					// Pddl.g:498:16: ( initEl )*
					loop72:
					while (true) {
						int alt72=2;
						int LA72_0 = input.LA(1);
						if ( (LA72_0==72) ) {
							alt72=1;
						}

						switch (alt72) {
						case 1 :
							// Pddl.g:498:16: initEl
							{
							pushFollow(FOLLOW_initEl_in_init3243);
							initEl416=initEl();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_initEl.add(initEl416.getTree());
							}
							break;

						default :
							break loop72;
						}
					}

					char_literal417=(Token)match(input,73,FOLLOW_73_in_init3246); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal417);

					// AST REWRITE
					// elements: initEl
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 499:2: -> ^( INIT ( initEl )* )
					{
						// Pddl.g:499:5: ^( INIT ( initEl )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
						// Pddl.g:499:12: ( initEl )*
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
					break;
				case 2 :
					// Pddl.g:500:4: '(' ':init' belief ')'
					{
					char_literal418=(Token)match(input,72,FOLLOW_72_in_init3261); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal418);

					string_literal419=(Token)match(input,92,FOLLOW_92_in_init3263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal419);

					pushFollow(FOLLOW_belief_in_init3265);
					belief420=belief();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_belief.add(belief420.getTree());
					char_literal421=(Token)match(input,73,FOLLOW_73_in_init3267); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal421);

					// AST REWRITE
					// elements: belief
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 500:27: -> ^( FORMULAINIT belief )
					{
						// Pddl.g:500:30: ^( FORMULAINIT belief )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMULAINIT, "FORMULAINIT"), root_1);
						adaptor.addChild(root_1, stream_belief.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 69, init_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "init"


	public static class initEl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "initEl"
	// Pddl.g:503:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'unknown' atomicNameFormula ')' -> ^( UNKNOWN atomicNameFormula ) | '(' 'oneof' ( atomicNameFormula )* ')' -> ^( ONEOF ( atomicNameFormula )* ) | '(' 'or' ( nameLiteral )* ')' -> ^( OR_GD ( nameLiteral )* ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);
		int initEl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal423=null;
		Token char_literal424=null;
		Token NUMBER426=null;
		Token char_literal427=null;
		Token char_literal428=null;
		Token string_literal429=null;
		Token char_literal431=null;
		Token char_literal432=null;
		Token string_literal433=null;
		Token char_literal435=null;
		Token char_literal436=null;
		Token string_literal437=null;
		Token char_literal439=null;
		ParserRuleReturnScope nameLiteral422 =null;
		ParserRuleReturnScope fHead425 =null;
		ParserRuleReturnScope atomicNameFormula430 =null;
		ParserRuleReturnScope atomicNameFormula434 =null;
		ParserRuleReturnScope nameLiteral438 =null;

		Object char_literal423_tree=null;
		Object char_literal424_tree=null;
		Object NUMBER426_tree=null;
		Object char_literal427_tree=null;
		Object char_literal428_tree=null;
		Object string_literal429_tree=null;
		Object char_literal431_tree=null;
		Object char_literal432_tree=null;
		Object string_literal433_tree=null;
		Object char_literal435_tree=null;
		Object char_literal436_tree=null;
		Object string_literal437_tree=null;
		Object char_literal439_tree=null;
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_135=new RewriteRuleTokenStream(adaptor,"token 135");
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_136=new RewriteRuleTokenStream(adaptor,"token 136");
		RewriteRuleTokenStream stream_148=new RewriteRuleTokenStream(adaptor,"token 148");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }

			// Pddl.g:504:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'unknown' atomicNameFormula ')' -> ^( UNKNOWN atomicNameFormula ) | '(' 'oneof' ( atomicNameFormula )* ')' -> ^( ONEOF ( atomicNameFormula )* ) | '(' 'or' ( nameLiteral )* ')' -> ^( OR_GD ( nameLiteral )* ) )
			int alt76=5;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==72) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 133:
					{
					alt76=1;
					}
					break;
				case 103:
					{
					alt76=2;
					}
					break;
				case 148:
					{
					alt76=3;
					}
					break;
				case 135:
					{
					alt76=4;
					}
					break;
				case 136:
					{
					alt76=5;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 76, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}

			switch (alt76) {
				case 1 :
					// Pddl.g:504:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl3286);
					nameLiteral422=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral422.getTree());

					}
					break;
				case 2 :
					// Pddl.g:505:4: '(' '=' fHead NUMBER ')'
					{
					char_literal423=(Token)match(input,72,FOLLOW_72_in_initEl3291); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal423);

					char_literal424=(Token)match(input,103,FOLLOW_103_in_initEl3293); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(char_literal424);

					pushFollow(FOLLOW_fHead_in_initEl3295);
					fHead425=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead425.getTree());
					NUMBER426=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3297); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER426);

					char_literal427=(Token)match(input,73,FOLLOW_73_in_initEl3299); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal427);

					// AST REWRITE
					// elements: NUMBER, fHead
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 505:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// Pddl.g:505:40: ^( INIT_EQ fHead NUMBER )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT_EQ, "INIT_EQ"), root_1);
						adaptor.addChild(root_1, stream_fHead.nextTree());
						adaptor.addChild(root_1, stream_NUMBER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// Pddl.g:507:4: '(' 'unknown' atomicNameFormula ')'
					{
					char_literal428=(Token)match(input,72,FOLLOW_72_in_initEl3323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal428);

					string_literal429=(Token)match(input,148,FOLLOW_148_in_initEl3325); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_148.add(string_literal429);

					pushFollow(FOLLOW_atomicNameFormula_in_initEl3328);
					atomicNameFormula430=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula430.getTree());
					char_literal431=(Token)match(input,73,FOLLOW_73_in_initEl3330); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal431);

					// AST REWRITE
					// elements: atomicNameFormula
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 507:42: -> ^( UNKNOWN atomicNameFormula )
					{
						// Pddl.g:507:45: ^( UNKNOWN atomicNameFormula )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNKNOWN, "UNKNOWN"), root_1);
						adaptor.addChild(root_1, stream_atomicNameFormula.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// Pddl.g:508:4: '(' 'oneof' ( atomicNameFormula )* ')'
					{
					char_literal432=(Token)match(input,72,FOLLOW_72_in_initEl3344); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal432);

					string_literal433=(Token)match(input,135,FOLLOW_135_in_initEl3346); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_135.add(string_literal433);

					// Pddl.g:508:17: ( atomicNameFormula )*
					loop74:
					while (true) {
						int alt74=2;
						int LA74_0 = input.LA(1);
						if ( (LA74_0==72) ) {
							alt74=1;
						}

						switch (alt74) {
						case 1 :
							// Pddl.g:508:17: atomicNameFormula
							{
							pushFollow(FOLLOW_atomicNameFormula_in_initEl3349);
							atomicNameFormula434=atomicNameFormula();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula434.getTree());
							}
							break;

						default :
							break loop74;
						}
					}

					char_literal435=(Token)match(input,73,FOLLOW_73_in_initEl3352); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal435);

					// AST REWRITE
					// elements: atomicNameFormula
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 508:41: -> ^( ONEOF ( atomicNameFormula )* )
					{
						// Pddl.g:508:44: ^( ONEOF ( atomicNameFormula )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONEOF, "ONEOF"), root_1);
						// Pddl.g:508:52: ( atomicNameFormula )*
						while ( stream_atomicNameFormula.hasNext() ) {
							adaptor.addChild(root_1, stream_atomicNameFormula.nextTree());
						}
						stream_atomicNameFormula.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// Pddl.g:509:4: '(' 'or' ( nameLiteral )* ')'
					{
					char_literal436=(Token)match(input,72,FOLLOW_72_in_initEl3367); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal436);

					string_literal437=(Token)match(input,136,FOLLOW_136_in_initEl3369); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_136.add(string_literal437);

					// Pddl.g:509:14: ( nameLiteral )*
					loop75:
					while (true) {
						int alt75=2;
						int LA75_0 = input.LA(1);
						if ( (LA75_0==72) ) {
							alt75=1;
						}

						switch (alt75) {
						case 1 :
							// Pddl.g:509:14: nameLiteral
							{
							pushFollow(FOLLOW_nameLiteral_in_initEl3372);
							nameLiteral438=nameLiteral();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral438.getTree());
							}
							break;

						default :
							break loop75;
						}
					}

					char_literal439=(Token)match(input,73,FOLLOW_73_in_initEl3375); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal439);

					// AST REWRITE
					// elements: nameLiteral
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 509:32: -> ^( OR_GD ( nameLiteral )* )
					{
						// Pddl.g:509:35: ^( OR_GD ( nameLiteral )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:509:43: ( nameLiteral )*
						while ( stream_nameLiteral.hasNext() ) {
							adaptor.addChild(root_1, stream_nameLiteral.nextTree());
						}
						stream_nameLiteral.reset();

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
			if ( state.backtracking>0 ) { memoize(input, 70, initEl_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "initEl"


	public static class nameLiteral_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nameLiteral"
	// Pddl.g:512:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);
		int nameLiteral_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal441=null;
		Token string_literal442=null;
		Token char_literal444=null;
		ParserRuleReturnScope atomicNameFormula440 =null;
		ParserRuleReturnScope atomicNameFormula443 =null;

		Object char_literal441_tree=null;
		Object string_literal442_tree=null;
		Object char_literal444_tree=null;
		RewriteRuleTokenStream stream_133=new RewriteRuleTokenStream(adaptor,"token 133");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }

			// Pddl.g:513:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==72) ) {
				int LA77_1 = input.LA(2);
				if ( (LA77_1==133) ) {
					alt77=2;
				}
				else if ( (LA77_1==NAME) ) {
					alt77=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 77, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 77, 0, input);
				throw nvae;
			}

			switch (alt77) {
				case 1 :
					// Pddl.g:513:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3396);
					atomicNameFormula440=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula440.getTree());

					}
					break;
				case 2 :
					// Pddl.g:514:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal441=(Token)match(input,72,FOLLOW_72_in_nameLiteral3401); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal441);

					string_literal442=(Token)match(input,133,FOLLOW_133_in_nameLiteral3403); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_133.add(string_literal442);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3405);
					atomicNameFormula443=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula443.getTree());
					char_literal444=(Token)match(input,73,FOLLOW_73_in_nameLiteral3407); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal444);

					// AST REWRITE
					// elements: atomicNameFormula
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 514:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// Pddl.g:514:39: ^( NOT_PRED_INIT atomicNameFormula )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_PRED_INIT, "NOT_PRED_INIT"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 71, nameLiteral_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "nameLiteral"


	public static class atomicNameFormula_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomicNameFormula"
	// Pddl.g:517:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);
		int atomicNameFormula_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal445=null;
		Token NAME447=null;
		Token char_literal448=null;
		ParserRuleReturnScope predicate446 =null;

		Object char_literal445_tree=null;
		Object NAME447_tree=null;
		Object char_literal448_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }

			// Pddl.g:518:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// Pddl.g:518:4: '(' predicate ( NAME )* ')'
			{
			char_literal445=(Token)match(input,72,FOLLOW_72_in_atomicNameFormula3426); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal445);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula3428);
			predicate446=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate446.getTree());
			// Pddl.g:518:18: ( NAME )*
			loop78:
			while (true) {
				int alt78=2;
				int LA78_0 = input.LA(1);
				if ( (LA78_0==NAME) ) {
					alt78=1;
				}

				switch (alt78) {
				case 1 :
					// Pddl.g:518:18: NAME
					{
					NAME447=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula3430); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME447);

					}
					break;

				default :
					break loop78;
				}
			}

			char_literal448=(Token)match(input,73,FOLLOW_73_in_atomicNameFormula3433); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal448);

			// AST REWRITE
			// elements: predicate, NAME
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 518:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// Pddl.g:518:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:518:53: ( NAME )*
				while ( stream_NAME.hasNext() ) {
					adaptor.addChild(root_1, stream_NAME.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 72, atomicNameFormula_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "atomicNameFormula"


	public static class goal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "goal"
	// Pddl.g:525:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);
		int goal_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal449=null;
		Token string_literal450=null;
		Token char_literal452=null;
		ParserRuleReturnScope goalDesc451 =null;

		Object char_literal449_tree=null;
		Object string_literal450_tree=null;
		Object char_literal452_tree=null;
		RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }

			// Pddl.g:525:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// Pddl.g:525:8: '(' ':goal' goalDesc ')'
			{
			char_literal449=(Token)match(input,72,FOLLOW_72_in_goal3458); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal449);

			string_literal450=(Token)match(input,91,FOLLOW_91_in_goal3460); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_91.add(string_literal450);

			pushFollow(FOLLOW_goalDesc_in_goal3462);
			goalDesc451=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc451.getTree());
			char_literal452=(Token)match(input,73,FOLLOW_73_in_goal3465); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal452);

			// AST REWRITE
			// elements: goalDesc
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 525:34: -> ^( GOAL goalDesc )
			{
				// Pddl.g:525:37: ^( GOAL goalDesc )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GOAL, "GOAL"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 73, goal_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "goal"


	public static class probConstraints_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "probConstraints"
	// Pddl.g:527:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);
		int probConstraints_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal453=null;
		Token string_literal454=null;
		Token char_literal456=null;
		ParserRuleReturnScope prefConGD455 =null;

		Object char_literal453_tree=null;
		Object string_literal454_tree=null;
		Object char_literal456_tree=null;
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }

			// Pddl.g:528:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// Pddl.g:528:4: '(' ':constraints' prefConGD ')'
			{
			char_literal453=(Token)match(input,72,FOLLOW_72_in_probConstraints3483); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal453);

			string_literal454=(Token)match(input,82,FOLLOW_82_in_probConstraints3485); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_82.add(string_literal454);

			pushFollow(FOLLOW_prefConGD_in_probConstraints3488);
			prefConGD455=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD455.getTree());
			char_literal456=(Token)match(input,73,FOLLOW_73_in_probConstraints3490); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal456);

			// AST REWRITE
			// elements: prefConGD
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 529:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// Pddl.g:529:7: ^( PROBLEM_CONSTRAINT prefConGD )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_CONSTRAINT, "PROBLEM_CONSTRAINT"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 74, probConstraints_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "probConstraints"


	public static class prefConGD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prefConGD"
	// Pddl.g:532:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);
		int prefConGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal457=null;
		Token string_literal458=null;
		Token char_literal460=null;
		Token char_literal461=null;
		Token string_literal462=null;
		Token char_literal463=null;
		Token char_literal465=null;
		Token char_literal467=null;
		Token char_literal468=null;
		Token string_literal469=null;
		Token NAME470=null;
		Token char_literal472=null;
		ParserRuleReturnScope prefConGD459 =null;
		ParserRuleReturnScope typedVariableList464 =null;
		ParserRuleReturnScope prefConGD466 =null;
		ParserRuleReturnScope conGD471 =null;
		ParserRuleReturnScope conGD473 =null;

		Object char_literal457_tree=null;
		Object string_literal458_tree=null;
		Object char_literal460_tree=null;
		Object char_literal461_tree=null;
		Object string_literal462_tree=null;
		Object char_literal463_tree=null;
		Object char_literal465_tree=null;
		Object char_literal467_tree=null;
		Object char_literal468_tree=null;
		Object string_literal469_tree=null;
		Object NAME470_tree=null;
		Object char_literal472_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }

			// Pddl.g:533:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt81=4;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==72) ) {
				int LA81_1 = input.LA(2);
				if ( (synpred131_Pddl()) ) {
					alt81=1;
				}
				else if ( (synpred132_Pddl()) ) {
					alt81=2;
				}
				else if ( (synpred134_Pddl()) ) {
					alt81=3;
				}
				else if ( (true) ) {
					alt81=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 81, 0, input);
				throw nvae;
			}

			switch (alt81) {
				case 1 :
					// Pddl.g:533:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal457=(Token)match(input,72,FOLLOW_72_in_prefConGD3512); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal457_tree = (Object)adaptor.create(char_literal457);
					adaptor.addChild(root_0, char_literal457_tree);
					}

					string_literal458=(Token)match(input,113,FOLLOW_113_in_prefConGD3514); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal458_tree = (Object)adaptor.create(string_literal458);
					adaptor.addChild(root_0, string_literal458_tree);
					}

					// Pddl.g:533:14: ( prefConGD )*
					loop79:
					while (true) {
						int alt79=2;
						int LA79_0 = input.LA(1);
						if ( (LA79_0==72) ) {
							alt79=1;
						}

						switch (alt79) {
						case 1 :
							// Pddl.g:533:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD3516);
							prefConGD459=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD459.getTree());

							}
							break;

						default :
							break loop79;
						}
					}

					char_literal460=(Token)match(input,73,FOLLOW_73_in_prefConGD3519); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal460_tree = (Object)adaptor.create(char_literal460);
					adaptor.addChild(root_0, char_literal460_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:534:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal461=(Token)match(input,72,FOLLOW_72_in_prefConGD3524); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal461_tree = (Object)adaptor.create(char_literal461);
					adaptor.addChild(root_0, char_literal461_tree);
					}

					string_literal462=(Token)match(input,125,FOLLOW_125_in_prefConGD3526); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal462_tree = (Object)adaptor.create(string_literal462);
					adaptor.addChild(root_0, string_literal462_tree);
					}

					char_literal463=(Token)match(input,72,FOLLOW_72_in_prefConGD3528); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal463_tree = (Object)adaptor.create(char_literal463);
					adaptor.addChild(root_0, char_literal463_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD3530);
					typedVariableList464=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList464.getTree());

					char_literal465=(Token)match(input,73,FOLLOW_73_in_prefConGD3532); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal465_tree = (Object)adaptor.create(char_literal465);
					adaptor.addChild(root_0, char_literal465_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD3534);
					prefConGD466=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD466.getTree());

					char_literal467=(Token)match(input,73,FOLLOW_73_in_prefConGD3536); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:535:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal468=(Token)match(input,72,FOLLOW_72_in_prefConGD3541); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal468_tree = (Object)adaptor.create(char_literal468);
					adaptor.addChild(root_0, char_literal468_tree);
					}

					string_literal469=(Token)match(input,138,FOLLOW_138_in_prefConGD3543); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal469_tree = (Object)adaptor.create(string_literal469);
					adaptor.addChild(root_0, string_literal469_tree);
					}

					// Pddl.g:535:21: ( NAME )?
					int alt80=2;
					int LA80_0 = input.LA(1);
					if ( (LA80_0==NAME) ) {
						alt80=1;
					}
					switch (alt80) {
						case 1 :
							// Pddl.g:535:21: NAME
							{
							NAME470=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3545); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME470_tree = (Object)adaptor.create(NAME470);
							adaptor.addChild(root_0, NAME470_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD3548);
					conGD471=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD471.getTree());

					char_literal472=(Token)match(input,73,FOLLOW_73_in_prefConGD3550); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal472_tree = (Object)adaptor.create(char_literal472);
					adaptor.addChild(root_0, char_literal472_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:536:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD3555);
					conGD473=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD473.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 75, prefConGD_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "prefConGD"


	public static class metricSpec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "metricSpec"
	// Pddl.g:539:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);
		int metricSpec_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal474=null;
		Token string_literal475=null;
		Token char_literal478=null;
		ParserRuleReturnScope optimization476 =null;
		ParserRuleReturnScope metricFExp477 =null;

		Object char_literal474_tree=null;
		Object string_literal475_tree=null;
		Object char_literal478_tree=null;
		RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }

			// Pddl.g:540:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// Pddl.g:540:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal474=(Token)match(input,72,FOLLOW_72_in_metricSpec3566); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(char_literal474);

			string_literal475=(Token)match(input,93,FOLLOW_93_in_metricSpec3568); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_93.add(string_literal475);

			pushFollow(FOLLOW_optimization_in_metricSpec3570);
			optimization476=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization476.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec3572);
			metricFExp477=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp477.getTree());
			char_literal478=(Token)match(input,73,FOLLOW_73_in_metricSpec3574); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal478);

			// AST REWRITE
			// elements: optimization, metricFExp
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 541:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// Pddl.g:541:7: ^( PROBLEM_METRIC optimization metricFExp )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_METRIC, "PROBLEM_METRIC"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 76, metricSpec_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "metricSpec"


	public static class optimization_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "optimization"
	// Pddl.g:544:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);
		int optimization_StartIndex = input.index();

		Object root_0 = null;

		Token set479=null;

		Object set479_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }

			// Pddl.g:544:14: ( 'minimize' | 'maximize' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set479=input.LT(1);
			if ( (input.LA(1) >= 131 && input.LA(1) <= 132) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set479));
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
			if ( state.backtracking>0 ) { memoize(input, 77, optimization_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "optimization"


	public static class metricFExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "metricFExp"
	// Pddl.g:546:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);
		int metricFExp_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal480=null;
		Token char_literal484=null;
		Token char_literal485=null;
		Token char_literal489=null;
		Token char_literal490=null;
		Token char_literal491=null;
		Token char_literal493=null;
		Token NUMBER494=null;
		Token char_literal496=null;
		Token string_literal497=null;
		Token NAME498=null;
		Token char_literal499=null;
		ParserRuleReturnScope binaryOp481 =null;
		ParserRuleReturnScope metricFExp482 =null;
		ParserRuleReturnScope metricFExp483 =null;
		ParserRuleReturnScope multiOp486 =null;
		ParserRuleReturnScope metricFExp487 =null;
		ParserRuleReturnScope metricFExp488 =null;
		ParserRuleReturnScope metricFExp492 =null;
		ParserRuleReturnScope fHead495 =null;

		Object char_literal480_tree=null;
		Object char_literal484_tree=null;
		Object char_literal485_tree=null;
		Object char_literal489_tree=null;
		Object char_literal490_tree=null;
		Object char_literal491_tree=null;
		Object char_literal493_tree=null;
		Object NUMBER494_tree=null;
		Object char_literal496_tree=null;
		Object string_literal497_tree=null;
		Object NAME498_tree=null;
		Object char_literal499_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }

			// Pddl.g:547:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt83=6;
			switch ( input.LA(1) ) {
			case 72:
				{
				int LA83_1 = input.LA(2);
				if ( (synpred136_Pddl()) ) {
					alt83=1;
				}
				else if ( (synpred138_Pddl()) ) {
					alt83=2;
				}
				else if ( (synpred139_Pddl()) ) {
					alt83=3;
				}
				else if ( (synpred141_Pddl()) ) {
					alt83=5;
				}
				else if ( (true) ) {
					alt83=6;
				}

				}
				break;
			case NUMBER:
				{
				alt83=4;
				}
				break;
			case NAME:
			case 71:
				{
				alt83=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 83, 0, input);
				throw nvae;
			}
			switch (alt83) {
				case 1 :
					// Pddl.g:547:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal480=(Token)match(input,72,FOLLOW_72_in_metricFExp3611); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal480);

					pushFollow(FOLLOW_binaryOp_in_metricFExp3613);
					binaryOp481=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp481.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3615);
					metricFExp482=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp482.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3617);
					metricFExp483=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp483.getTree());
					char_literal484=(Token)match(input,73,FOLLOW_73_in_metricFExp3619); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal484);

					// AST REWRITE
					// elements: metricFExp, binaryOp, metricFExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 548:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// Pddl.g:548:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BINARY_OP, "BINARY_OP"), root_1);
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
					// Pddl.g:549:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal485=(Token)match(input,72,FOLLOW_72_in_metricFExp3641); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal485);

					pushFollow(FOLLOW_multiOp_in_metricFExp3643);
					multiOp486=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp486.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3645);
					metricFExp487=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp487.getTree());
					// Pddl.g:549:27: ( metricFExp )+
					int cnt82=0;
					loop82:
					while (true) {
						int alt82=2;
						int LA82_0 = input.LA(1);
						if ( (LA82_0==NAME||LA82_0==NUMBER||(LA82_0 >= 71 && LA82_0 <= 72)) ) {
							alt82=1;
						}

						switch (alt82) {
						case 1 :
							// Pddl.g:549:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3647);
							metricFExp488=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp488.getTree());
							}
							break;

						default :
							if ( cnt82 >= 1 ) break loop82;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(82, input);
							throw eee;
						}
						cnt82++;
					}

					char_literal489=(Token)match(input,73,FOLLOW_73_in_metricFExp3650); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal489);

					// AST REWRITE
					// elements: multiOp, metricFExp, metricFExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 550:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// Pddl.g:550:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MULTI_OP, "MULTI_OP"), root_1);
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
					// Pddl.g:551:4: '(' '-' metricFExp ')'
					{
					char_literal490=(Token)match(input,72,FOLLOW_72_in_metricFExp3674); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_72.add(char_literal490);

					char_literal491=(Token)match(input,76,FOLLOW_76_in_metricFExp3676); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(char_literal491);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3678);
					metricFExp492=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp492.getTree());
					char_literal493=(Token)match(input,73,FOLLOW_73_in_metricFExp3680); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal493);

					// AST REWRITE
					// elements: metricFExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 552:4: -> ^( MINUS_OP metricFExp )
					{
						// Pddl.g:552:7: ^( MINUS_OP metricFExp )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS_OP, "MINUS_OP"), root_1);
						adaptor.addChild(root_1, stream_metricFExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// Pddl.g:553:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER494=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3697); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER494_tree = (Object)adaptor.create(NUMBER494);
					adaptor.addChild(root_0, NUMBER494_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:554:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3702);
					fHead495=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead495.getTree());

					}
					break;
				case 6 :
					// Pddl.g:556:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal496=(Token)match(input,72,FOLLOW_72_in_metricFExp3717); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal496_tree = (Object)adaptor.create(char_literal496);
					adaptor.addChild(root_0, char_literal496_tree);
					}

					string_literal497=(Token)match(input,130,FOLLOW_130_in_metricFExp3719); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal497_tree = (Object)adaptor.create(string_literal497);
					adaptor.addChild(root_0, string_literal497_tree);
					}

					NAME498=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3721); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME498_tree = (Object)adaptor.create(NAME498);
					adaptor.addChild(root_0, NAME498_tree);
					}

					char_literal499=(Token)match(input,73,FOLLOW_73_in_metricFExp3723); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal499_tree = (Object)adaptor.create(char_literal499);
					adaptor.addChild(root_0, char_literal499_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 78, metricFExp_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "metricFExp"


	public static class conGD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "conGD"
	// Pddl.g:561:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' '__at__' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);
		int conGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal500=null;
		Token string_literal501=null;
		Token char_literal503=null;
		Token char_literal504=null;
		Token string_literal505=null;
		Token char_literal506=null;
		Token char_literal508=null;
		Token char_literal510=null;
		Token char_literal511=null;
		Token string_literal512=null;
		Token string_literal513=null;
		Token char_literal515=null;
		Token char_literal516=null;
		Token string_literal517=null;
		Token char_literal519=null;
		Token char_literal520=null;
		Token string_literal521=null;
		Token char_literal523=null;
		Token char_literal524=null;
		Token string_literal525=null;
		Token NUMBER526=null;
		Token char_literal528=null;
		Token char_literal529=null;
		Token string_literal530=null;
		Token char_literal532=null;
		Token char_literal533=null;
		Token string_literal534=null;
		Token char_literal537=null;
		Token char_literal538=null;
		Token string_literal539=null;
		Token char_literal542=null;
		Token char_literal543=null;
		Token string_literal544=null;
		Token NUMBER545=null;
		Token char_literal548=null;
		Token char_literal549=null;
		Token string_literal550=null;
		Token NUMBER551=null;
		Token NUMBER552=null;
		Token char_literal554=null;
		Token char_literal555=null;
		Token string_literal556=null;
		Token NUMBER557=null;
		Token char_literal559=null;
		ParserRuleReturnScope conGD502 =null;
		ParserRuleReturnScope typedVariableList507 =null;
		ParserRuleReturnScope conGD509 =null;
		ParserRuleReturnScope goalDesc514 =null;
		ParserRuleReturnScope goalDesc518 =null;
		ParserRuleReturnScope goalDesc522 =null;
		ParserRuleReturnScope goalDesc527 =null;
		ParserRuleReturnScope goalDesc531 =null;
		ParserRuleReturnScope goalDesc535 =null;
		ParserRuleReturnScope goalDesc536 =null;
		ParserRuleReturnScope goalDesc540 =null;
		ParserRuleReturnScope goalDesc541 =null;
		ParserRuleReturnScope goalDesc546 =null;
		ParserRuleReturnScope goalDesc547 =null;
		ParserRuleReturnScope goalDesc553 =null;
		ParserRuleReturnScope goalDesc558 =null;

		Object char_literal500_tree=null;
		Object string_literal501_tree=null;
		Object char_literal503_tree=null;
		Object char_literal504_tree=null;
		Object string_literal505_tree=null;
		Object char_literal506_tree=null;
		Object char_literal508_tree=null;
		Object char_literal510_tree=null;
		Object char_literal511_tree=null;
		Object string_literal512_tree=null;
		Object string_literal513_tree=null;
		Object char_literal515_tree=null;
		Object char_literal516_tree=null;
		Object string_literal517_tree=null;
		Object char_literal519_tree=null;
		Object char_literal520_tree=null;
		Object string_literal521_tree=null;
		Object char_literal523_tree=null;
		Object char_literal524_tree=null;
		Object string_literal525_tree=null;
		Object NUMBER526_tree=null;
		Object char_literal528_tree=null;
		Object char_literal529_tree=null;
		Object string_literal530_tree=null;
		Object char_literal532_tree=null;
		Object char_literal533_tree=null;
		Object string_literal534_tree=null;
		Object char_literal537_tree=null;
		Object char_literal538_tree=null;
		Object string_literal539_tree=null;
		Object char_literal542_tree=null;
		Object char_literal543_tree=null;
		Object string_literal544_tree=null;
		Object NUMBER545_tree=null;
		Object char_literal548_tree=null;
		Object char_literal549_tree=null;
		Object string_literal550_tree=null;
		Object NUMBER551_tree=null;
		Object NUMBER552_tree=null;
		Object char_literal554_tree=null;
		Object char_literal555_tree=null;
		Object string_literal556_tree=null;
		Object NUMBER557_tree=null;
		Object char_literal559_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }

			// Pddl.g:562:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' '__at__' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt85=12;
			int LA85_0 = input.LA(1);
			if ( (LA85_0==72) ) {
				switch ( input.LA(2) ) {
				case 113:
					{
					alt85=1;
					}
					break;
				case 125:
					{
					alt85=2;
					}
					break;
				case 108:
					{
					alt85=3;
					}
					break;
				case 111:
					{
					alt85=4;
					}
					break;
				case 143:
					{
					alt85=5;
					}
					break;
				case 150:
					{
					alt85=6;
					}
					break;
				case 115:
					{
					alt85=7;
					}
					break;
				case 144:
					{
					alt85=8;
					}
					break;
				case 145:
					{
					alt85=9;
					}
					break;
				case 112:
					{
					alt85=10;
					}
					break;
				case 127:
					{
					alt85=11;
					}
					break;
				case 126:
					{
					alt85=12;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 85, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 85, 0, input);
				throw nvae;
			}

			switch (alt85) {
				case 1 :
					// Pddl.g:562:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal500=(Token)match(input,72,FOLLOW_72_in_conGD3737); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal500_tree = (Object)adaptor.create(char_literal500);
					adaptor.addChild(root_0, char_literal500_tree);
					}

					string_literal501=(Token)match(input,113,FOLLOW_113_in_conGD3739); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal501_tree = (Object)adaptor.create(string_literal501);
					adaptor.addChild(root_0, string_literal501_tree);
					}

					// Pddl.g:562:14: ( conGD )*
					loop84:
					while (true) {
						int alt84=2;
						int LA84_0 = input.LA(1);
						if ( (LA84_0==72) ) {
							alt84=1;
						}

						switch (alt84) {
						case 1 :
							// Pddl.g:562:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3741);
							conGD502=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD502.getTree());

							}
							break;

						default :
							break loop84;
						}
					}

					char_literal503=(Token)match(input,73,FOLLOW_73_in_conGD3744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal503_tree = (Object)adaptor.create(char_literal503);
					adaptor.addChild(root_0, char_literal503_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:563:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal504=(Token)match(input,72,FOLLOW_72_in_conGD3749); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal504_tree = (Object)adaptor.create(char_literal504);
					adaptor.addChild(root_0, char_literal504_tree);
					}

					string_literal505=(Token)match(input,125,FOLLOW_125_in_conGD3751); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal505_tree = (Object)adaptor.create(string_literal505);
					adaptor.addChild(root_0, string_literal505_tree);
					}

					char_literal506=(Token)match(input,72,FOLLOW_72_in_conGD3753); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal506_tree = (Object)adaptor.create(char_literal506);
					adaptor.addChild(root_0, char_literal506_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3755);
					typedVariableList507=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList507.getTree());

					char_literal508=(Token)match(input,73,FOLLOW_73_in_conGD3757); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal508_tree = (Object)adaptor.create(char_literal508);
					adaptor.addChild(root_0, char_literal508_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3759);
					conGD509=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD509.getTree());

					char_literal510=(Token)match(input,73,FOLLOW_73_in_conGD3761); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal510_tree = (Object)adaptor.create(char_literal510);
					adaptor.addChild(root_0, char_literal510_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:564:4: '(' '__at__' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal511=(Token)match(input,72,FOLLOW_72_in_conGD3766); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal511_tree = (Object)adaptor.create(char_literal511);
					adaptor.addChild(root_0, char_literal511_tree);
					}

					string_literal512=(Token)match(input,108,FOLLOW_108_in_conGD3768); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal512_tree = (Object)adaptor.create(string_literal512);
					adaptor.addChild(root_0, string_literal512_tree);
					}

					string_literal513=(Token)match(input,123,FOLLOW_123_in_conGD3770); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal513_tree = (Object)adaptor.create(string_literal513);
					adaptor.addChild(root_0, string_literal513_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3772);
					goalDesc514=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc514.getTree());

					char_literal515=(Token)match(input,73,FOLLOW_73_in_conGD3774); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal515_tree = (Object)adaptor.create(char_literal515);
					adaptor.addChild(root_0, char_literal515_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:565:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal516=(Token)match(input,72,FOLLOW_72_in_conGD3800); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal516_tree = (Object)adaptor.create(char_literal516);
					adaptor.addChild(root_0, char_literal516_tree);
					}

					string_literal517=(Token)match(input,111,FOLLOW_111_in_conGD3802); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal517_tree = (Object)adaptor.create(string_literal517);
					adaptor.addChild(root_0, string_literal517_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3804);
					goalDesc518=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc518.getTree());

					char_literal519=(Token)match(input,73,FOLLOW_73_in_conGD3806); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal519_tree = (Object)adaptor.create(char_literal519);
					adaptor.addChild(root_0, char_literal519_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:566:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal520=(Token)match(input,72,FOLLOW_72_in_conGD3811); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal520_tree = (Object)adaptor.create(char_literal520);
					adaptor.addChild(root_0, char_literal520_tree);
					}

					string_literal521=(Token)match(input,143,FOLLOW_143_in_conGD3813); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal521_tree = (Object)adaptor.create(string_literal521);
					adaptor.addChild(root_0, string_literal521_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3815);
					goalDesc522=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc522.getTree());

					char_literal523=(Token)match(input,73,FOLLOW_73_in_conGD3817); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal523_tree = (Object)adaptor.create(char_literal523);
					adaptor.addChild(root_0, char_literal523_tree);
					}

					}
					break;
				case 6 :
					// Pddl.g:567:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal524=(Token)match(input,72,FOLLOW_72_in_conGD3823); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal524_tree = (Object)adaptor.create(char_literal524);
					adaptor.addChild(root_0, char_literal524_tree);
					}

					string_literal525=(Token)match(input,150,FOLLOW_150_in_conGD3825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal525_tree = (Object)adaptor.create(string_literal525);
					adaptor.addChild(root_0, string_literal525_tree);
					}

					NUMBER526=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3827); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER526_tree = (Object)adaptor.create(NUMBER526);
					adaptor.addChild(root_0, NUMBER526_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3829);
					goalDesc527=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc527.getTree());

					char_literal528=(Token)match(input,73,FOLLOW_73_in_conGD3831); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal528_tree = (Object)adaptor.create(char_literal528);
					adaptor.addChild(root_0, char_literal528_tree);
					}

					}
					break;
				case 7 :
					// Pddl.g:568:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal529=(Token)match(input,72,FOLLOW_72_in_conGD3836); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal529_tree = (Object)adaptor.create(char_literal529);
					adaptor.addChild(root_0, char_literal529_tree);
					}

					string_literal530=(Token)match(input,115,FOLLOW_115_in_conGD3838); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal530_tree = (Object)adaptor.create(string_literal530);
					adaptor.addChild(root_0, string_literal530_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3840);
					goalDesc531=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc531.getTree());

					char_literal532=(Token)match(input,73,FOLLOW_73_in_conGD3842); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal532_tree = (Object)adaptor.create(char_literal532);
					adaptor.addChild(root_0, char_literal532_tree);
					}

					}
					break;
				case 8 :
					// Pddl.g:569:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal533=(Token)match(input,72,FOLLOW_72_in_conGD3847); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal533_tree = (Object)adaptor.create(char_literal533);
					adaptor.addChild(root_0, char_literal533_tree);
					}

					string_literal534=(Token)match(input,144,FOLLOW_144_in_conGD3849); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal534_tree = (Object)adaptor.create(string_literal534);
					adaptor.addChild(root_0, string_literal534_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3851);
					goalDesc535=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc535.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3853);
					goalDesc536=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc536.getTree());

					char_literal537=(Token)match(input,73,FOLLOW_73_in_conGD3855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal537_tree = (Object)adaptor.create(char_literal537);
					adaptor.addChild(root_0, char_literal537_tree);
					}

					}
					break;
				case 9 :
					// Pddl.g:570:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal538=(Token)match(input,72,FOLLOW_72_in_conGD3860); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal538_tree = (Object)adaptor.create(char_literal538);
					adaptor.addChild(root_0, char_literal538_tree);
					}

					string_literal539=(Token)match(input,145,FOLLOW_145_in_conGD3862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal539_tree = (Object)adaptor.create(string_literal539);
					adaptor.addChild(root_0, string_literal539_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3864);
					goalDesc540=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc540.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3866);
					goalDesc541=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc541.getTree());

					char_literal542=(Token)match(input,73,FOLLOW_73_in_conGD3868); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal542_tree = (Object)adaptor.create(char_literal542);
					adaptor.addChild(root_0, char_literal542_tree);
					}

					}
					break;
				case 10 :
					// Pddl.g:571:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal543=(Token)match(input,72,FOLLOW_72_in_conGD3873); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal543_tree = (Object)adaptor.create(char_literal543);
					adaptor.addChild(root_0, char_literal543_tree);
					}

					string_literal544=(Token)match(input,112,FOLLOW_112_in_conGD3875); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal544_tree = (Object)adaptor.create(string_literal544);
					adaptor.addChild(root_0, string_literal544_tree);
					}

					NUMBER545=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3877); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER545_tree = (Object)adaptor.create(NUMBER545);
					adaptor.addChild(root_0, NUMBER545_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3879);
					goalDesc546=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc546.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3881);
					goalDesc547=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc547.getTree());

					char_literal548=(Token)match(input,73,FOLLOW_73_in_conGD3883); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal548_tree = (Object)adaptor.create(char_literal548);
					adaptor.addChild(root_0, char_literal548_tree);
					}

					}
					break;
				case 11 :
					// Pddl.g:572:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal549=(Token)match(input,72,FOLLOW_72_in_conGD3888); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal549_tree = (Object)adaptor.create(char_literal549);
					adaptor.addChild(root_0, char_literal549_tree);
					}

					string_literal550=(Token)match(input,127,FOLLOW_127_in_conGD3890); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal550_tree = (Object)adaptor.create(string_literal550);
					adaptor.addChild(root_0, string_literal550_tree);
					}

					NUMBER551=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3892); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER551_tree = (Object)adaptor.create(NUMBER551);
					adaptor.addChild(root_0, NUMBER551_tree);
					}

					NUMBER552=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3894); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER552_tree = (Object)adaptor.create(NUMBER552);
					adaptor.addChild(root_0, NUMBER552_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3896);
					goalDesc553=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc553.getTree());

					char_literal554=(Token)match(input,73,FOLLOW_73_in_conGD3898); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal554_tree = (Object)adaptor.create(char_literal554);
					adaptor.addChild(root_0, char_literal554_tree);
					}

					}
					break;
				case 12 :
					// Pddl.g:573:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal555=(Token)match(input,72,FOLLOW_72_in_conGD3903); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal555_tree = (Object)adaptor.create(char_literal555);
					adaptor.addChild(root_0, char_literal555_tree);
					}

					string_literal556=(Token)match(input,126,FOLLOW_126_in_conGD3905); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal556_tree = (Object)adaptor.create(string_literal556);
					adaptor.addChild(root_0, string_literal556_tree);
					}

					NUMBER557=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3907); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER557_tree = (Object)adaptor.create(NUMBER557);
					adaptor.addChild(root_0, NUMBER557_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3909);
					goalDesc558=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc558.getTree());

					char_literal559=(Token)match(input,73,FOLLOW_73_in_conGD3911); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal559_tree = (Object)adaptor.create(char_literal559);
					adaptor.addChild(root_0, char_literal559_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 79, conGD_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "conGD"

	// $ANTLR start synpred18_Pddl
	public final void synpred18_Pddl_fragment() throws RecognitionException {
		// Pddl.g:172:5: ( atomicFunctionSkeleton )
		// Pddl.g:172:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl860);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred52_Pddl
	public final void synpred52_Pddl_fragment() throws RecognitionException {
		// Pddl.g:302:7: ( fComp )
		// Pddl.g:302:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred52_Pddl1817);
		fComp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred52_Pddl

	// $ANTLR start synpred55_Pddl
	public final void synpred55_Pddl_fragment() throws RecognitionException {
		// Pddl.g:325:28: ( typedVariableList )
		// Pddl.g:325:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred55_Pddl1976);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred55_Pddl

	// $ANTLR start synpred68_Pddl
	public final void synpred68_Pddl_fragment() throws RecognitionException {
		// Pddl.g:365:4: ( '(' binaryOp fExp fExp2 ')' )
		// Pddl.g:365:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,72,FOLLOW_72_in_synpred68_Pddl2232); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred68_Pddl2234);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred68_Pddl2236);
		fExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp2_in_synpred68_Pddl2238);
		fExp2();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred68_Pddl2240); if (state.failed) return;

		}

	}
	// $ANTLR end synpred68_Pddl

	// $ANTLR start synpred69_Pddl
	public final void synpred69_Pddl_fragment() throws RecognitionException {
		// Pddl.g:366:4: ( '(' '-' fExp ')' )
		// Pddl.g:366:4: '(' '-' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred69_Pddl2257); if (state.failed) return;

		match(input,76,FOLLOW_76_in_synpred69_Pddl2259); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred69_Pddl2261);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred69_Pddl2263); if (state.failed) return;

		}

	}
	// $ANTLR end synpred69_Pddl

	// $ANTLR start synpred70_Pddl
	public final void synpred70_Pddl_fragment() throws RecognitionException {
		// Pddl.g:367:4: ( '(' 'sin' fExp ')' )
		// Pddl.g:367:4: '(' 'sin' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred70_Pddl2276); if (state.failed) return;

		match(input,142,FOLLOW_142_in_synpred70_Pddl2278); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred70_Pddl2280);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred70_Pddl2282); if (state.failed) return;

		}

	}
	// $ANTLR end synpred70_Pddl

	// $ANTLR start synpred71_Pddl
	public final void synpred71_Pddl_fragment() throws RecognitionException {
		// Pddl.g:368:4: ( '(' 'cos' fExp ')' )
		// Pddl.g:368:4: '(' 'cos' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred71_Pddl2295); if (state.failed) return;

		match(input,118,FOLLOW_118_in_synpred71_Pddl2297); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred71_Pddl2299);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred71_Pddl2301); if (state.failed) return;

		}

	}
	// $ANTLR end synpred71_Pddl

	// $ANTLR start synpred72_Pddl
	public final void synpred72_Pddl_fragment() throws RecognitionException {
		// Pddl.g:369:4: ( '(' 'atan2' fExp ')' )
		// Pddl.g:369:4: '(' 'atan2' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred72_Pddl2314); if (state.failed) return;

		match(input,117,FOLLOW_117_in_synpred72_Pddl2316); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred72_Pddl2318);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred72_Pddl2320); if (state.failed) return;

		}

	}
	// $ANTLR end synpred72_Pddl

	// $ANTLR start synpred73_Pddl
	public final void synpred73_Pddl_fragment() throws RecognitionException {
		// Pddl.g:370:4: ( '(' 'atan' fExp ')' )
		// Pddl.g:370:4: '(' 'atan' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred73_Pddl2333); if (state.failed) return;

		match(input,116,FOLLOW_116_in_synpred73_Pddl2335); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred73_Pddl2337);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred73_Pddl2339); if (state.failed) return;

		}

	}
	// $ANTLR end synpred73_Pddl

	// $ANTLR start synpred74_Pddl
	public final void synpred74_Pddl_fragment() throws RecognitionException {
		// Pddl.g:371:4: ( '(' 'tan' fExp ')' )
		// Pddl.g:371:4: '(' 'tan' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred74_Pddl2352); if (state.failed) return;

		match(input,147,FOLLOW_147_in_synpred74_Pddl2354); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred74_Pddl2356);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred74_Pddl2358); if (state.failed) return;

		}

	}
	// $ANTLR end synpred74_Pddl

	// $ANTLR start synpred75_Pddl
	public final void synpred75_Pddl_fragment() throws RecognitionException {
		// Pddl.g:372:4: ( '(' 'abs' fExp ')' )
		// Pddl.g:372:4: '(' 'abs' fExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred75_Pddl2371); if (state.failed) return;

		match(input,109,FOLLOW_109_in_synpred75_Pddl2373); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred75_Pddl2375);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred75_Pddl2377); if (state.failed) return;

		}

	}
	// $ANTLR end synpred75_Pddl

	// $ANTLR start synpred105_Pddl
	public final void synpred105_Pddl_fragment() throws RecognitionException {
		// Pddl.g:439:12: ( NUMBER )
		// Pddl.g:439:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred105_Pddl2820); if (state.failed) return;

		}

	}
	// $ANTLR end synpred105_Pddl

	// $ANTLR start synpred107_Pddl
	public final void synpred107_Pddl_fragment() throws RecognitionException {
		// Pddl.g:442:4: ( '(' 'and' ( daEffect )* ')' )
		// Pddl.g:442:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,72,FOLLOW_72_in_synpred107_Pddl2834); if (state.failed) return;

		match(input,113,FOLLOW_113_in_synpred107_Pddl2836); if (state.failed) return;

		// Pddl.g:442:14: ( daEffect )*
		loop103:
		while (true) {
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==72) ) {
				alt103=1;
			}

			switch (alt103) {
			case 1 :
				// Pddl.g:442:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred107_Pddl2838);
				daEffect();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop103;
			}
		}

		match(input,73,FOLLOW_73_in_synpred107_Pddl2841); if (state.failed) return;

		}

	}
	// $ANTLR end synpred107_Pddl

	// $ANTLR start synpred108_Pddl
	public final void synpred108_Pddl_fragment() throws RecognitionException {
		// Pddl.g:443:4: ( timedEffect )
		// Pddl.g:443:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred108_Pddl2846);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred108_Pddl

	// $ANTLR start synpred109_Pddl
	public final void synpred109_Pddl_fragment() throws RecognitionException {
		// Pddl.g:444:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// Pddl.g:444:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,72,FOLLOW_72_in_synpred109_Pddl2851); if (state.failed) return;

		match(input,125,FOLLOW_125_in_synpred109_Pddl2853); if (state.failed) return;

		match(input,72,FOLLOW_72_in_synpred109_Pddl2855); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred109_Pddl2857);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred109_Pddl2859); if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred109_Pddl2861);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred109_Pddl2863); if (state.failed) return;

		}

	}
	// $ANTLR end synpred109_Pddl

	// $ANTLR start synpred110_Pddl
	public final void synpred110_Pddl_fragment() throws RecognitionException {
		// Pddl.g:445:4: ( '(' 'when' daGD timedEffect ')' )
		// Pddl.g:445:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,72,FOLLOW_72_in_synpred110_Pddl2868); if (state.failed) return;

		match(input,149,FOLLOW_149_in_synpred110_Pddl2870); if (state.failed) return;

		pushFollow(FOLLOW_daGD_in_synpred110_Pddl2872);
		daGD();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_timedEffect_in_synpred110_Pddl2874);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred110_Pddl2876); if (state.failed) return;

		}

	}
	// $ANTLR end synpred110_Pddl

	// $ANTLR start synpred111_Pddl
	public final void synpred111_Pddl_fragment() throws RecognitionException {
		// Pddl.g:450:4: ( '(' '__at__' timeSpecifier daEffect ')' )
		// Pddl.g:450:4: '(' '__at__' timeSpecifier daEffect ')'
		{
		match(input,72,FOLLOW_72_in_synpred111_Pddl2900); if (state.failed) return;

		match(input,108,FOLLOW_108_in_synpred111_Pddl2902); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred111_Pddl2904);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred111_Pddl2906);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred111_Pddl2908); if (state.failed) return;

		}

	}
	// $ANTLR end synpred111_Pddl

	// $ANTLR start synpred112_Pddl
	public final void synpred112_Pddl_fragment() throws RecognitionException {
		// Pddl.g:451:4: ( '(' '__at__' timeSpecifier fAssignDA ')' )
		// Pddl.g:451:4: '(' '__at__' timeSpecifier fAssignDA ')'
		{
		match(input,72,FOLLOW_72_in_synpred112_Pddl2918); if (state.failed) return;

		match(input,108,FOLLOW_108_in_synpred112_Pddl2920); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred112_Pddl2922);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fAssignDA_in_synpred112_Pddl2924);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred112_Pddl2926); if (state.failed) return;

		}

	}
	// $ANTLR end synpred112_Pddl

	// $ANTLR start synpred113_Pddl
	public final void synpred113_Pddl_fragment() throws RecognitionException {
		// Pddl.g:460:9: ( ( binaryOp fExpDA fExpDA ) )
		// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
		{
		// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
		// Pddl.g:460:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred113_Pddl2982);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred113_Pddl2984);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred113_Pddl2986);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred113_Pddl

	// $ANTLR start synpred114_Pddl
	public final void synpred114_Pddl_fragment() throws RecognitionException {
		// Pddl.g:460:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// Pddl.g:460:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,72,FOLLOW_72_in_synpred114_Pddl2978); if (state.failed) return;

		// Pddl.g:460:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt104=2;
		int LA104_0 = input.LA(1);
		if ( (LA104_0==76) ) {
			int LA104_1 = input.LA(2);
			if ( (synpred113_Pddl()) ) {
				alt104=1;
			}
			else if ( (true) ) {
				alt104=2;
			}

		}
		else if ( ((LA104_0 >= 74 && LA104_0 <= 75)||LA104_0==77||LA104_0==107) ) {
			alt104=1;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 104, 0, input);
			throw nvae;
		}

		switch (alt104) {
			case 1 :
				// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
				{
				// Pddl.g:460:9: ( binaryOp fExpDA fExpDA )
				// Pddl.g:460:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred114_Pddl2982);
				binaryOp();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred114_Pddl2984);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred114_Pddl2986);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;
			case 2 :
				// Pddl.g:460:36: ( '-' fExpDA )
				{
				// Pddl.g:460:36: ( '-' fExpDA )
				// Pddl.g:460:37: '-' fExpDA
				{
				match(input,76,FOLLOW_76_in_synpred114_Pddl2992); if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred114_Pddl2994);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;

		}

		match(input,73,FOLLOW_73_in_synpred114_Pddl2998); if (state.failed) return;

		}

	}
	// $ANTLR end synpred114_Pddl

	// $ANTLR start synpred121_Pddl
	public final void synpred121_Pddl_fragment() throws RecognitionException {
		// Pddl.g:498:4: ( '(' ':init' ( initEl )* ')' )
		// Pddl.g:498:4: '(' ':init' ( initEl )* ')'
		{
		match(input,72,FOLLOW_72_in_synpred121_Pddl3239); if (state.failed) return;

		match(input,92,FOLLOW_92_in_synpred121_Pddl3241); if (state.failed) return;

		// Pddl.g:498:16: ( initEl )*
		loop105:
		while (true) {
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==72) ) {
				alt105=1;
			}

			switch (alt105) {
			case 1 :
				// Pddl.g:498:16: initEl
				{
				pushFollow(FOLLOW_initEl_in_synpred121_Pddl3243);
				initEl();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop105;
			}
		}

		match(input,73,FOLLOW_73_in_synpred121_Pddl3246); if (state.failed) return;

		}

	}
	// $ANTLR end synpred121_Pddl

	// $ANTLR start synpred131_Pddl
	public final void synpred131_Pddl_fragment() throws RecognitionException {
		// Pddl.g:533:4: ( '(' 'and' ( prefConGD )* ')' )
		// Pddl.g:533:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,72,FOLLOW_72_in_synpred131_Pddl3512); if (state.failed) return;

		match(input,113,FOLLOW_113_in_synpred131_Pddl3514); if (state.failed) return;

		// Pddl.g:533:14: ( prefConGD )*
		loop107:
		while (true) {
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==72) ) {
				alt107=1;
			}

			switch (alt107) {
			case 1 :
				// Pddl.g:533:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred131_Pddl3516);
				prefConGD();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop107;
			}
		}

		match(input,73,FOLLOW_73_in_synpred131_Pddl3519); if (state.failed) return;

		}

	}
	// $ANTLR end synpred131_Pddl

	// $ANTLR start synpred132_Pddl
	public final void synpred132_Pddl_fragment() throws RecognitionException {
		// Pddl.g:534:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// Pddl.g:534:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,72,FOLLOW_72_in_synpred132_Pddl3524); if (state.failed) return;

		match(input,125,FOLLOW_125_in_synpred132_Pddl3526); if (state.failed) return;

		match(input,72,FOLLOW_72_in_synpred132_Pddl3528); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred132_Pddl3530);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred132_Pddl3532); if (state.failed) return;

		pushFollow(FOLLOW_prefConGD_in_synpred132_Pddl3534);
		prefConGD();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred132_Pddl3536); if (state.failed) return;

		}

	}
	// $ANTLR end synpred132_Pddl

	// $ANTLR start synpred134_Pddl
	public final void synpred134_Pddl_fragment() throws RecognitionException {
		// Pddl.g:535:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// Pddl.g:535:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,72,FOLLOW_72_in_synpred134_Pddl3541); if (state.failed) return;

		match(input,138,FOLLOW_138_in_synpred134_Pddl3543); if (state.failed) return;

		// Pddl.g:535:21: ( NAME )?
		int alt108=2;
		int LA108_0 = input.LA(1);
		if ( (LA108_0==NAME) ) {
			alt108=1;
		}
		switch (alt108) {
			case 1 :
				// Pddl.g:535:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred134_Pddl3545); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred134_Pddl3548);
		conGD();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred134_Pddl3550); if (state.failed) return;

		}

	}
	// $ANTLR end synpred134_Pddl

	// $ANTLR start synpred136_Pddl
	public final void synpred136_Pddl_fragment() throws RecognitionException {
		// Pddl.g:547:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// Pddl.g:547:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred136_Pddl3611); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred136_Pddl3613);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred136_Pddl3615);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred136_Pddl3617);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred136_Pddl3619); if (state.failed) return;

		}

	}
	// $ANTLR end synpred136_Pddl

	// $ANTLR start synpred138_Pddl
	public final void synpred138_Pddl_fragment() throws RecognitionException {
		// Pddl.g:549:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// Pddl.g:549:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,72,FOLLOW_72_in_synpred138_Pddl3641); if (state.failed) return;

		pushFollow(FOLLOW_multiOp_in_synpred138_Pddl3643);
		multiOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred138_Pddl3645);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		// Pddl.g:549:27: ( metricFExp )+
		int cnt109=0;
		loop109:
		while (true) {
			int alt109=2;
			int LA109_0 = input.LA(1);
			if ( (LA109_0==NAME||LA109_0==NUMBER||(LA109_0 >= 71 && LA109_0 <= 72)) ) {
				alt109=1;
			}

			switch (alt109) {
			case 1 :
				// Pddl.g:549:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred138_Pddl3647);
				metricFExp();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt109 >= 1 ) break loop109;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(109, input);
				throw eee;
			}
			cnt109++;
		}

		match(input,73,FOLLOW_73_in_synpred138_Pddl3650); if (state.failed) return;

		}

	}
	// $ANTLR end synpred138_Pddl

	// $ANTLR start synpred139_Pddl
	public final void synpred139_Pddl_fragment() throws RecognitionException {
		// Pddl.g:551:4: ( '(' '-' metricFExp ')' )
		// Pddl.g:551:4: '(' '-' metricFExp ')'
		{
		match(input,72,FOLLOW_72_in_synpred139_Pddl3674); if (state.failed) return;

		match(input,76,FOLLOW_76_in_synpred139_Pddl3676); if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred139_Pddl3678);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred139_Pddl3680); if (state.failed) return;

		}

	}
	// $ANTLR end synpred139_Pddl

	// $ANTLR start synpred141_Pddl
	public final void synpred141_Pddl_fragment() throws RecognitionException {
		// Pddl.g:554:4: ( fHead )
		// Pddl.g:554:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred141_Pddl3702);
		fHead();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred141_Pddl

	// Delegated rules

	public final boolean synpred112_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred112_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred71_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred71_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred55_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred55_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred109_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred109_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred52_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred52_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred138_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred138_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred134_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred134_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred131_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred131_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred74_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred74_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred107_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred107_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred69_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred69_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred108_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred108_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred105_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred105_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred136_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred136_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred141_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred141_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred70_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred70_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred111_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred111_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred68_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred68_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred73_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred73_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred75_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred75_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred72_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred72_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred132_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred132_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred113_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred113_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred110_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred110_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred139_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred139_Pddl_fragment(); // can never throw exception
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
	protected DFA73 dfa73 = new DFA73(this);
	static final String DFA14_eotS =
		"\4\uffff";
	static final String DFA14_eofS =
		"\4\uffff";
	static final String DFA14_minS =
		"\2\53\2\uffff";
	static final String DFA14_maxS =
		"\1\111\1\114\2\uffff";
	static final String DFA14_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA14_specialS =
		"\4\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\35\uffff\1\2",
			"\1\1\35\uffff\1\2\2\uffff\1\3",
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

	protected class DFA14 extends DFA {

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
		@Override
		public String getDescription() {
			return "150:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\53\2\uffff";
	static final String DFA12_maxS =
		"\1\111\1\114\2\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA12_specialS =
		"\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\1\35\uffff\1\2",
			"\1\1\35\uffff\1\2\2\uffff\1\3",
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

	protected class DFA12 extends DFA {

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
		@Override
		public String getDescription() {
			return "()+ loopback of 150:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\104\2\uffff";
	static final String DFA25_maxS =
		"\1\111\1\114\2\uffff";
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

	protected class DFA25 extends DFA {

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
		@Override
		public String getDescription() {
			return "201:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\104\2\uffff";
	static final String DFA23_maxS =
		"\1\111\1\114\2\uffff";
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

	protected class DFA23 extends DFA {

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
		@Override
		public String getDescription() {
			return "()+ loopback of 201:20: ( singleTypeVarList )+";
		}
	}

	static final String DFA73_eotS =
		"\137\uffff";
	static final String DFA73_eofS =
		"\137\uffff";
	static final String DFA73_minS =
		"\1\110\1\134\1\110\1\53\1\uffff\1\110\1\53\2\110\1\uffff\6\53\1\110\1"+
		"\53\1\110\1\53\1\110\2\53\1\111\1\53\1\0\1\53\1\110\1\53\2\0\1\53\1\111"+
		"\2\53\1\110\1\53\2\110\1\53\3\110\3\53\2\110\1\0\2\53\1\57\2\53\1\110"+
		"\1\53\1\110\1\53\1\110\1\53\1\0\2\53\1\111\2\53\1\0\1\110\1\53\2\0\1\53"+
		"\1\111\1\53\1\111\1\53\1\57\1\110\1\53\1\111\1\53\1\110\2\53\3\110\1\0"+
		"\1\110\1\53\2\0\1\53\1\111\1\110";
	static final String DFA73_maxS =
		"\1\110\1\134\1\111\1\u0094\1\uffff\2\110\2\111\1\uffff\1\111\1\u0088\1"+
		"\u0093\2\110\1\u0088\1\111\1\u0088\7\111\1\0\1\u0094\1\110\1\111\2\0\3"+
		"\111\1\110\3\111\3\110\3\111\1\u0088\3\111\1\0\1\53\1\107\1\57\2\53\1"+
		"\111\1\u0085\4\111\1\0\5\111\1\0\1\110\1\111\2\0\5\111\1\57\5\111\1\53"+
		"\4\111\1\0\2\111\2\0\3\111";
	static final String DFA73_acceptS =
		"\4\uffff\1\1\4\uffff\1\2\125\uffff";
	static final String DFA73_specialS =
		"\31\uffff\1\1\3\uffff\1\2\1\0\21\uffff\1\4\13\uffff\1\5\5\uffff\1\7\2"+
		"\uffff\1\11\1\12\20\uffff\1\10\2\uffff\1\6\1\3\3\uffff}>";
	static final String[] DFA73_transitionS = {
			"\1\1",
			"\1\2",
			"\1\3\1\4",
			"\1\12\71\uffff\2\11\1\6\2\11\7\uffff\1\11\12\uffff\2\11\2\uffff\1\11"+
			"\4\uffff\1\5\1\uffff\1\7\1\10\13\uffff\1\4",
			"",
			"\1\13",
			"\1\15\3\uffff\1\11\24\uffff\1\11\2\uffff\1\16\1\14",
			"\1\17\1\20",
			"\1\21\1\22",
			"",
			"\1\23\30\uffff\1\11\4\uffff\1\24",
			"\1\25\71\uffff\5\11\7\uffff\1\11\12\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\26\33\uffff\1\26\2\uffff\4\11\35\uffff\1\11\1\uffff\1\11\6\uffff"+
			"\3\11\27\uffff\1\11\4\uffff\1\11",
			"\1\11\3\uffff\1\27\24\uffff\1\11\2\uffff\2\11",
			"\1\11\3\uffff\1\27\27\uffff\2\11",
			"\1\30\71\uffff\5\11\7\uffff\1\11\12\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\32\1\31",
			"\1\34\71\uffff\5\11\7\uffff\1\11\12\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\33\1\uffff\2\11",
			"\1\32\1\35",
			"\1\23\30\uffff\1\11\4\uffff\1\24",
			"\1\32\1\36",
			"\1\37\30\uffff\1\11\4\uffff\1\40",
			"\1\41\30\uffff\1\41\4\uffff\1\42",
			"\1\43",
			"\1\44\30\uffff\1\11\4\uffff\1\45",
			"\1\uffff",
			"\1\53\73\uffff\1\47\35\uffff\1\46\1\uffff\1\51\1\52\13\uffff\1\50",
			"\1\54",
			"\1\55\30\uffff\1\11\4\uffff\1\56",
			"\1\uffff",
			"\1\uffff",
			"\1\37\30\uffff\1\11\4\uffff\1\40",
			"\1\57",
			"\1\41\30\uffff\1\41\4\uffff\1\42",
			"\1\11\3\uffff\1\27\27\uffff\2\11",
			"\1\32\1\60",
			"\1\44\30\uffff\1\11\4\uffff\1\45",
			"\1\17\1\20",
			"\1\61",
			"\1\63\33\uffff\1\63\1\62",
			"\1\64",
			"\1\65\1\66",
			"\1\67\1\70",
			"\1\71\35\uffff\1\72",
			"\1\73\71\uffff\5\11\7\uffff\1\11\12\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\55\30\uffff\1\11\4\uffff\1\56",
			"\1\21\1\22",
			"\1\32\1\74",
			"\1\uffff",
			"\1\75",
			"\1\76\33\uffff\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\32\1\102",
			"\1\104\131\uffff\1\103",
			"\1\32\1\105",
			"\1\71\35\uffff\1\72",
			"\1\32\1\106",
			"\1\107\30\uffff\1\11\4\uffff\1\110",
			"\1\uffff",
			"\1\111\35\uffff\1\112",
			"\1\113\30\uffff\1\113\4\uffff\1\114",
			"\1\115",
			"\1\116\35\uffff\1\117",
			"\1\120\35\uffff\1\121",
			"\1\uffff",
			"\1\122",
			"\1\123\35\uffff\1\124",
			"\1\uffff",
			"\1\uffff",
			"\1\107\30\uffff\1\11\4\uffff\1\110",
			"\1\125",
			"\1\111\35\uffff\1\112",
			"\1\126",
			"\1\113\30\uffff\1\113\4\uffff\1\114",
			"\1\77",
			"\1\32\1\127",
			"\1\116\35\uffff\1\117",
			"\1\130",
			"\1\120\35\uffff\1\121",
			"\1\65\1\66",
			"\1\131",
			"\1\123\35\uffff\1\124",
			"\1\67\1\70",
			"\1\21\1\22",
			"\1\32\1\132",
			"\1\uffff",
			"\1\32\1\133",
			"\1\134\35\uffff\1\135",
			"\1\uffff",
			"\1\uffff",
			"\1\134\35\uffff\1\135",
			"\1\136",
			"\1\67\1\70"
	};

	static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
	static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
	static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
	static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
	static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
	static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
	static final short[][] DFA73_transition;

	static {
		int numStates = DFA73_transitionS.length;
		DFA73_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
		}
	}

	protected class DFA73 extends DFA {

		public DFA73(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 73;
			this.eot = DFA73_eot;
			this.eof = DFA73_eof;
			this.min = DFA73_min;
			this.max = DFA73_max;
			this.accept = DFA73_accept;
			this.special = DFA73_special;
			this.transition = DFA73_transition;
		}
		@Override
		public String getDescription() {
			return "497:1: init : ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA73_30 = input.LA(1);
						 
						int index73_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_30);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA73_25 = input.LA(1);
						 
						int index73_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_25);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA73_29 = input.LA(1);
						 
						int index73_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_29);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA73_91 = input.LA(1);
						 
						int index73_91 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_91);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA73_48 = input.LA(1);
						 
						int index73_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_48);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA73_60 = input.LA(1);
						 
						int index73_60 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_60);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA73_90 = input.LA(1);
						 
						int index73_90 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_90);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA73_66 = input.LA(1);
						 
						int index73_66 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_66);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA73_87 = input.LA(1);
						 
						int index73_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_87);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA73_69 = input.LA(1);
						 
						int index73_69 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_69);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA73_70 = input.LA(1);
						 
						int index73_70 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred121_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_70);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 73, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_domain432 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_domain434 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_domainName_in_domain436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_requireDef_in_domain444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_typesDef_in_domain453 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_constantsDef_in_domain462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_predicatesDef_in_domain471 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_functionsDef_in_domain480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_constraints_in_domain498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_structureDef_in_domain507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_domain516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_free_functionsDef600 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_free_functionsDef602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef604 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_free_functionsDef606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_domainName629 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_121_in_domainName631 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NAME_in_domainName633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_domainName635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_requireDef662 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_requireDef664 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef666 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_requireDef669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_typesDef690 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_typesDef692 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_typesDef696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList723 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList728 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList731 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList751 = new BitSet(new long[]{0x0000080000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_singleTypeNameList754 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_type785 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_type787 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_primType_in_type789 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_type792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_functionsDef833 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_functionsDef835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_functionList_in_functionsDef837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_functionsDef839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList860 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001100L});
	public static final BitSet FOLLOW_76_in_functionList864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_functionType_in_functionList866 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_atomicFunctionSkeleton882 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_atomicFunctionSkeleton890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_134_in_functionType913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_constantsDef924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_constantsDef926 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef928 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constantsDef930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_predicatesDef950 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_predicatesDef952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef954 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_predicatesDef957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_atomicFormulaSkeleton978 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton984 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_atomicFormulaSkeleton986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList1012 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList1017 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList1020 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList1040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001010L});
	public static final BitSet FOLLOW_76_in_singleTypeVarList1043 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList1047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_constraints1078 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_constraints1081 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_conGD_in_constraints1084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constraints1086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraintDef_in_structureDef1113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_processDef_in_structureDef1118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eventDef_in_structureDef1123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_actionDef1138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_actionDef1140 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1142 = new BitSet(new long[]{0x0000000000000000L,0x0000000180800200L});
	public static final BitSet FOLLOW_95_in_actionDef1152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_actionDef1155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_actionDef1159 = new BitSet(new long[]{0x0000000000000000L,0x0000000100800200L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_actionDef1176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_eventDef1209 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_eventDef1211 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_eventDef1213 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_eventDef1222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_eventDef1225 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_eventDef1227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_eventDef1229 = new BitSet(new long[]{0x0000000000000000L,0x0000000100800200L});
	public static final BitSet FOLLOW_actionDefBody_in_eventDef1242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_eventDef1244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_processDef1277 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_processDef1279 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_processDef1281 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_processDef1290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_processDef1293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_processDef1295 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_processDef1297 = new BitSet(new long[]{0x0000000000000000L,0x0000000100800200L});
	public static final BitSet FOLLOW_actionDefBody_in_processDef1310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_processDef1312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_constraintDef1346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_constraintDef1348 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_constraintDef1359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_constraintDef1362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_constraintDef1364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constraintDef1366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008200L});
	public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constraintDef1381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_constraintSymbol1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_96_in_actionDefBody1439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_actionDefBody1443 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_actionDefBody1445 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1450 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_actionDefBody1460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_actionDefBody1464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_actionDefBody1466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_constraintDefBody1506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_constraintDefBody1510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constraintDefBody1512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_belief1555 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_initEl_in_belief1560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1587 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_goalDesc1589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_goalDesc1594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1619 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_136_in_goalDesc1621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_goalDesc1626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_goalDesc1653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1655 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_135_in_goalDesc1683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_goalDesc1689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_128_in_goalDesc1706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1738 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_124_in_goalDesc1740 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_goalDesc1742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goalDesc1776 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_goalDesc1778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_goalDesc1780 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goalDesc1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_equality1872 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_equality1875 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_term_in_equality1877 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_term_in_equality1879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_equality1881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fComp1892 = new BitSet(new long[]{0x0000000000000000L,0x000003E000000000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1895 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fComp1897 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fComp1899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fComp1901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_atomicTermFormula1913 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1915 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1917 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_73_in_atomicTermFormula1920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_durativeActionDef1957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_durativeActionDef1959 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1961 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_durativeActionDef1970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_durativeActionDef1973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_durativeActionDef1980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A08000L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_durativeActionDef1995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_daDefBody2028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody2030 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_daDefBody2035 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_daDefBody2039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daDefBody2041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody2046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_87_in_daDefBody2055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_daDefBody2059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daDefBody2061 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody2066 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD2081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daGD2086 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_daGD2088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_daGD_in_daGD2090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_daGD2093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daGD2098 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_daGD2100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_daGD2102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD2104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daGD2106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daGD_in_daGD2108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daGD2110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_prefTimedGD2126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_138_in_prefTimedGD2128 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD2130 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2133 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_prefTimedGD2135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_timedGD2146 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_timedGD2148 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD2150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_timedGD2154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_timedGD2159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_137_in_timedGD2161 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_interval_in_timedGD2163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_timedGD2167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_110_in_interval2189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_derivedDef2202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_derivedDef2205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000110L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef2208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef2210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_derivedDef2212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp2227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2232 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_fExp2234 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2236 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp2_in_fExp2238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_fExp2259 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_142_in_fExp2278 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2295 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_fExp2297 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2299 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2314 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_fExp2316 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2333 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_fExp2335 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_147_in_fExp2354 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExp2371 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_fExp2373 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_fExp2375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp2390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp22402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fHead2412 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2414 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_term_in_fHead2416 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_73_in_fHead2419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_effect2454 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_effect2456 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_cEffect_in_effect2458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_effect2461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect2475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_cEffect2486 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_cEffect2488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_cEffect2490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect2492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_cEffect2494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_effect_in_cEffect2496 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_cEffect2498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_cEffect2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_149_in_cEffect2518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect2520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_condEffect_in_cEffect2522 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_cEffect2524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_pEffect2553 = new BitSet(new long[]{0x0000000000000000L,0x0084000000000000L,0x0000000000003002L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2555 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fHead_in_pEffect2557 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_pEffect2559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_pEffect2561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_pEffect2581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_pEffect2583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_pEffect2587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_condEffect2616 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_condEffect2618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_condEffect2623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_durationConstraint2742 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_durationConstraint2744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_durationConstraint2749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_durationConstraint2754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_durationConstraint2756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_simpleDurationConstraint2772 = new BitSet(new long[]{0x0000000000000000L,0x000002C000000000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2774 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_106_in_simpleDurationConstraint2776 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_simpleDurationConstraint2780 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_simpleDurationConstraint2785 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_simpleDurationConstraint2787 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_simpleDurationConstraint2793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daEffect2834 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_daEffect2836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_daEffect2841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daEffect2851 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_daEffect2853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_daEffect2855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daEffect2859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daEffect2863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daEffect2868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_149_in_daEffect2870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daGD_in_daEffect2872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daEffect2876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daEffect2881 = new BitSet(new long[]{0x0000000000000000L,0x0084000000000000L,0x0000000000003002L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2883 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fHead_in_daEffect2885 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2887 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_daEffect2889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_timedEffect2900 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_timedEffect2902 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_timedEffect2908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_timedEffect2918 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_timedEffect2920 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_timedEffect2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_timedEffect2931 = new BitSet(new long[]{0x0000000000000000L,0x0084000000000000L,0x0000000000003002L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2933 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2935 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_timedEffect2939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fAssignDA2959 = new BitSet(new long[]{0x0000000000000000L,0x0084000000000000L,0x0000000000003002L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2961 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2963 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2965 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fAssignDA2967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_fExpDA2978 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2982 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2984 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_76_in_fExpDA2992 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExpDA2998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_106_in_fExpDA3003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA3008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_problem3022 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_problem3024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_problemDecl_in_problem3026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_problemDomain_in_problem3031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_requireDef_in_problem3039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_objectDecl_in_problem3048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_init_in_problem3057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goal_in_problem3065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_probConstraints_in_problem3073 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_metricSpec_in_problem3082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_problem3098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_problemDecl3155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_problemDecl3157 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl3159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_problemDecl3161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_problemDomain3187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_problemDomain3189 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain3191 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_problemDomain3193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_objectDecl3213 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_objectDecl3215 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl3217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_objectDecl3219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_init3239 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_init3241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_initEl_in_init3243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_init3246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_init3261 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_init3263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_belief_in_init3265 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_init3267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_initEl3291 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_initEl3293 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fHead_in_initEl3295 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_initEl3299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_initEl3323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_148_in_initEl3325 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_atomicNameFormula_in_initEl3328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_initEl3330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_initEl3344 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_135_in_initEl3346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_atomicNameFormula_in_initEl3349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_initEl3352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_initEl3367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_136_in_initEl3369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_initEl3375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_nameLiteral3401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_nameLiteral3403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_nameLiteral3407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_atomicNameFormula3426 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula3428 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula3430 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_atomicNameFormula3433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_goal3458 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_goal3460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_goal3462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_goal3465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_probConstraints3483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_probConstraints3485 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints3488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_probConstraints3490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_prefConGD3512 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_prefConGD3514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_prefConGD3519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_prefConGD3524 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_prefConGD3526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_prefConGD3528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD3530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_prefConGD3532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_prefConGD3536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_prefConGD3541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_138_in_prefConGD3543 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_NAME_in_prefConGD3545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_prefConGD3550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_metricSpec3566 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_93_in_metricSpec3568 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optimization_in_metricSpec3570 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec3572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_metricSpec3574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_metricFExp3611 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3613 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3615 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_metricFExp3619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_metricFExp3641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3643 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3645 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3647 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000380L});
	public static final BitSet FOLLOW_73_in_metricFExp3650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_metricFExp3674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_metricFExp3676 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_metricFExp3680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_metricFExp3717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_130_in_metricFExp3719 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_metricFExp3723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3737 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_conGD3739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_conGD_in_conGD3741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_conGD3744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3749 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_conGD3751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_conGD3753 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_conGD_in_conGD3759 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3766 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_conGD3768 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_conGD3770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3800 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_conGD3802 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3806 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_conGD3813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_150_in_conGD3825 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3829 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3836 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_conGD3838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3840 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_144_in_conGD3849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_145_in_conGD3862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3873 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_conGD3875 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3888 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_127_in_conGD3890 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3892 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_conGD3903 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_conGD3905 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3907 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_conGD3911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred52_Pddl1817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred55_Pddl1976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred68_Pddl2232 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_synpred68_Pddl2234 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred68_Pddl2236 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp2_in_synpred68_Pddl2238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred68_Pddl2240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred69_Pddl2257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_synpred69_Pddl2259 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred69_Pddl2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred69_Pddl2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred70_Pddl2276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_142_in_synpred70_Pddl2278 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred70_Pddl2280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred70_Pddl2282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred71_Pddl2295 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_synpred71_Pddl2297 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred71_Pddl2299 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred71_Pddl2301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred72_Pddl2314 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_synpred72_Pddl2316 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred72_Pddl2318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred72_Pddl2320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred73_Pddl2333 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_synpred73_Pddl2335 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred73_Pddl2337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred73_Pddl2339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred74_Pddl2352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_147_in_synpred74_Pddl2354 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred74_Pddl2356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred74_Pddl2358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred75_Pddl2371 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_synpred75_Pddl2373 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_fExp_in_synpred75_Pddl2375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred75_Pddl2377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred105_Pddl2820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred107_Pddl2834 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_synpred107_Pddl2836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_daEffect_in_synpred107_Pddl2838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_synpred107_Pddl2841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred108_Pddl2846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred109_Pddl2851 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_synpred109_Pddl2853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_synpred109_Pddl2855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred109_Pddl2857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred109_Pddl2859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daEffect_in_synpred109_Pddl2861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred109_Pddl2863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred110_Pddl2868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_149_in_synpred110_Pddl2870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daGD_in_synpred110_Pddl2872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_timedEffect_in_synpred110_Pddl2874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred110_Pddl2876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred111_Pddl2900 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_synpred111_Pddl2902 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred111_Pddl2904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_daEffect_in_synpred111_Pddl2906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred111_Pddl2908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred112_Pddl2918 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_synpred112_Pddl2920 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred112_Pddl2922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred112_Pddl2924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred112_Pddl2926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred113_Pddl2982 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_synpred113_Pddl2984 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_synpred113_Pddl2986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred114_Pddl2978 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_synpred114_Pddl2982 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_synpred114_Pddl2984 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_synpred114_Pddl2986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_76_in_synpred114_Pddl2992 = new BitSet(new long[]{0x0000880000000000L,0x0000040000000180L});
	public static final BitSet FOLLOW_fExpDA_in_synpred114_Pddl2994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred114_Pddl2998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred121_Pddl3239 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_synpred121_Pddl3241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_initEl_in_synpred121_Pddl3243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_synpred121_Pddl3246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred131_Pddl3512 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_synpred131_Pddl3514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_prefConGD_in_synpred131_Pddl3516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
	public static final BitSet FOLLOW_73_in_synpred131_Pddl3519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred132_Pddl3524 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_synpred132_Pddl3526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_synpred132_Pddl3528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000210L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred132_Pddl3530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred132_Pddl3532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_prefConGD_in_synpred132_Pddl3534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred132_Pddl3536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred134_Pddl3541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_138_in_synpred134_Pddl3543 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_NAME_in_synpred134_Pddl3545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_conGD_in_synpred134_Pddl3548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred134_Pddl3550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred136_Pddl3611 = new BitSet(new long[]{0x0000000000000000L,0x0000080000003C00L});
	public static final BitSet FOLLOW_binaryOp_in_synpred136_Pddl3613 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_synpred136_Pddl3615 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_synpred136_Pddl3617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred136_Pddl3619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred138_Pddl3641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
	public static final BitSet FOLLOW_multiOp_in_synpred138_Pddl3643 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_synpred138_Pddl3645 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_synpred138_Pddl3647 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000380L});
	public static final BitSet FOLLOW_73_in_synpred138_Pddl3650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_synpred139_Pddl3674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_synpred139_Pddl3676 = new BitSet(new long[]{0x0000880000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_metricFExp_in_synpred139_Pddl3678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred139_Pddl3680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred141_Pddl3702 = new BitSet(new long[]{0x0000000000000002L});
}
