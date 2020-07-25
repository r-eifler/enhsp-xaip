// $ANTLR 3.5.2 Pddl.g 2020-07-24 15:09:25

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
		"AND_GD", "ANY_CHAR", "ASSIGN_EFFECT", "BELIEF", "BINARY_OP", "COMPARISON_GD", 
		"CONSTANTS", "CONSTRAINT", "COS", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", 
		"EFFECT", "EITHER_TYPE", "EQUALITY_CON", "EVENT", "EXISTS_GD", "FORALL_EFFECT", 
		"FORALL_GD", "FORMULAINIT", "FREE_FUNCTIONS", "FUNCTIONS", "FUNC_HEAD", 
		"GLOBAL_CONSTRAINT", "GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", 
		"LETTER", "LINE_COMMENT", "MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", 
		"NOT_GD", "NOT_PRED_INIT", "NUMBER", "OBJECTS", "ONEOF", "OR_GD", "PRECONDITION", 
		"PREDICATES", "PRED_HEAD", "PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", 
		"PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", "PROCESS", "REQUIREMENTS", 
		"REQUIRE_KEY", "SIN", "TYPES", "UNARY_MINUS", "UNKNOWN", "VARIABLE", "WHEN_EFFECT", 
		"WHITESPACE", "'#t'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':action'", 
		"':condition'", "':constants'", "':constraint'", "':constraints'", "':derived'", 
		"':domain'", "':duration'", "':durative-action'", "':effect'", "':event'", 
		"':free_functions'", "':functions'", "':goal'", "':init'", "':metric'", 
		"':objects'", "':parameters'", "':precondition'", "':predicates'", "':process'", 
		"':requirements'", "':types'", "'<'", "'<='", "'='", "'>'", "'>='", "'?duration'", 
		"'^'", "'abs'", "'all'", "'always'", "'always-within'", "'and'", "'assign'", 
		"'at'", "'at-most-once'", "'cos'", "'decrease'", "'define'", "'domain'", 
		"'either'", "'end'", "'exists'", "'forall'", "'hold-after'", "'hold-during'", 
		"'imply'", "'increase'", "'is-violated'", "'maximize'", "'minimize'", 
		"'not'", "'number'", "'oneof'", "'or'", "'over'", "'preference'", "'problem'", 
		"'scale-down'", "'scale-up'", "'sin'", "'sometime'", "'sometime-after'", 
		"'sometime-before'", "'start'", "'unknown'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int ABS=4;
	public static final int ACTION=5;
	public static final int AND_EFFECT=6;
	public static final int AND_GD=7;
	public static final int ANY_CHAR=8;
	public static final int ASSIGN_EFFECT=9;
	public static final int BELIEF=10;
	public static final int BINARY_OP=11;
	public static final int COMPARISON_GD=12;
	public static final int CONSTANTS=13;
	public static final int CONSTRAINT=14;
	public static final int COS=15;
	public static final int DIGIT=16;
	public static final int DOMAIN=17;
	public static final int DOMAIN_NAME=18;
	public static final int DURATIVE_ACTION=19;
	public static final int EFFECT=20;
	public static final int EITHER_TYPE=21;
	public static final int EQUALITY_CON=22;
	public static final int EVENT=23;
	public static final int EXISTS_GD=24;
	public static final int FORALL_EFFECT=25;
	public static final int FORALL_GD=26;
	public static final int FORMULAINIT=27;
	public static final int FREE_FUNCTIONS=28;
	public static final int FUNCTIONS=29;
	public static final int FUNC_HEAD=30;
	public static final int GLOBAL_CONSTRAINT=31;
	public static final int GOAL=32;
	public static final int IMPLY_GD=33;
	public static final int INIT=34;
	public static final int INIT_AT=35;
	public static final int INIT_EQ=36;
	public static final int LETTER=37;
	public static final int LINE_COMMENT=38;
	public static final int MINUS_OP=39;
	public static final int MULTI_OP=40;
	public static final int NAME=41;
	public static final int NOT_EFFECT=42;
	public static final int NOT_GD=43;
	public static final int NOT_PRED_INIT=44;
	public static final int NUMBER=45;
	public static final int OBJECTS=46;
	public static final int ONEOF=47;
	public static final int OR_GD=48;
	public static final int PRECONDITION=49;
	public static final int PREDICATES=50;
	public static final int PRED_HEAD=51;
	public static final int PRED_INST=52;
	public static final int PROBLEM=53;
	public static final int PROBLEM_CONSTRAINT=54;
	public static final int PROBLEM_DOMAIN=55;
	public static final int PROBLEM_METRIC=56;
	public static final int PROBLEM_NAME=57;
	public static final int PROCESS=58;
	public static final int REQUIREMENTS=59;
	public static final int REQUIRE_KEY=60;
	public static final int SIN=61;
	public static final int TYPES=62;
	public static final int UNARY_MINUS=63;
	public static final int UNKNOWN=64;
	public static final int VARIABLE=65;
	public static final int WHEN_EFFECT=66;
	public static final int WHITESPACE=67;

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
		this.state.ruleMemo = new HashMap[229+1];


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
	// Pddl.g:105:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);
		int pddlDoc_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// Pddl.g:105:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==69) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==115) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==69) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==116) ) {
							alt1=1;
						}
						else if ( (LA1_3==134) ) {
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
					// Pddl.g:105:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc401);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// Pddl.g:105:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc405);
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
	// Pddl.g:109:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
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

			// Pddl.g:110:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			// Pddl.g:110:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,69,FOLLOW_69_in_domain420); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal3);

			string_literal4=(Token)match(input,115,FOLLOW_115_in_domain422); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_115.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain424);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// Pddl.g:111:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==69) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==96) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// Pddl.g:111:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain432);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// Pddl.g:112:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==69) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==97) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// Pddl.g:112:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain441);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// Pddl.g:113:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==69) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==77) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// Pddl.g:113:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain450);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// Pddl.g:114:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==69) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==94) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// Pddl.g:114:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain459);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// Pddl.g:115:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==69) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==87) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// Pddl.g:115:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain468);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// Pddl.g:116:7: ( free_functionsDef )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==69) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==86) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// Pddl.g:116:7: free_functionsDef
					{
					pushFollow(FOLLOW_free_functionsDef_in_domain477);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}

			// Pddl.g:117:7: ( constraints )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==69) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==79) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// Pddl.g:117:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain486);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}

			// Pddl.g:118:7: ( structureDef )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==69) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Pddl.g:118:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain495);
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

			char_literal14=(Token)match(input,70,FOLLOW_70_in_domain504); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal14);

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
			// 120:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				// Pddl.g:120:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// Pddl.g:120:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:120:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// Pddl.g:121:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// Pddl.g:121:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// Pddl.g:121:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// Pddl.g:121:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();

				// Pddl.g:122:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// Pddl.g:122:30: ( structureDef )*
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
	// Pddl.g:125:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// Pddl.g:126:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			// Pddl.g:126:4: '(' ':free_functions' functionList ')'
			{
			char_literal15=(Token)match(input,69,FOLLOW_69_in_free_functionsDef588); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal15);

			string_literal16=(Token)match(input,86,FOLLOW_86_in_free_functionsDef590); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_86.add(string_literal16);

			pushFollow(FOLLOW_functionList_in_free_functionsDef592);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());
			char_literal18=(Token)match(input,70,FOLLOW_70_in_free_functionsDef594); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal18);

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
			// 127:2: -> ^( FREE_FUNCTIONS functionList )
			{
				// Pddl.g:127:5: ^( FREE_FUNCTIONS functionList )
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
	// Pddl.g:130:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// Pddl.g:131:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// Pddl.g:131:7: '(' 'domain' NAME ')'
			{
			char_literal19=(Token)match(input,69,FOLLOW_69_in_domainName617); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal19);

			string_literal20=(Token)match(input,116,FOLLOW_116_in_domainName619); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_116.add(string_literal20);

			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName621); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);

			char_literal22=(Token)match(input,70,FOLLOW_70_in_domainName623); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal22);

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
			// 132:6: -> ^( DOMAIN_NAME NAME )
			{
				// Pddl.g:132:9: ^( DOMAIN_NAME NAME )
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
	// Pddl.g:135:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
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
		RewriteRuleTokenStream stream_REQUIRE_KEY=new RewriteRuleTokenStream(adaptor,"token REQUIRE_KEY");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// Pddl.g:136:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// Pddl.g:136:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal23=(Token)match(input,69,FOLLOW_69_in_requireDef650); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal23);

			string_literal24=(Token)match(input,96,FOLLOW_96_in_requireDef652); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_96.add(string_literal24);

			// Pddl.g:136:24: ( REQUIRE_KEY )+
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
					// Pddl.g:136:24: REQUIRE_KEY
					{
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef654); if (state.failed) return retval; 
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

			char_literal26=(Token)match(input,70,FOLLOW_70_in_requireDef657); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal26);

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
			// 137:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// Pddl.g:137:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
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
	// Pddl.g:140:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// Pddl.g:141:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// Pddl.g:141:4: '(' ':types' typedNameList ')'
			{
			char_literal27=(Token)match(input,69,FOLLOW_69_in_typesDef678); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal27);

			string_literal28=(Token)match(input,97,FOLLOW_97_in_typesDef680); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_97.add(string_literal28);

			pushFollow(FOLLOW_typedNameList_in_typesDef682);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());
			char_literal30=(Token)match(input,70,FOLLOW_70_in_typesDef684); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal30);

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
			// 142:4: -> ^( TYPES typedNameList )
			{
				// Pddl.g:142:7: ^( TYPES typedNameList )
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
	// Pddl.g:146:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
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

			// Pddl.g:147:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// Pddl.g:147:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:147:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// Pddl.g:147:8: ( NAME )*
					{
					// Pddl.g:147:8: ( NAME )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Pddl.g:147:8: NAME
							{
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList711); if (state.failed) return retval;
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
					// Pddl.g:147:16: ( singleTypeNameList )+ ( NAME )*
					{
					// Pddl.g:147:16: ( singleTypeNameList )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						alt12 = dfa12.predict(input);
						switch (alt12) {
						case 1 :
							// Pddl.g:147:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList716);
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

					// Pddl.g:147:36: ( NAME )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// Pddl.g:147:36: NAME
							{
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList719); if (state.failed) return retval;
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
	// Pddl.g:150:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
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
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// Pddl.g:151:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// Pddl.g:151:7: ( ( NAME )+ '-' t= type )
			{
			// Pddl.g:151:7: ( ( NAME )+ '-' t= type )
			// Pddl.g:151:8: ( NAME )+ '-' t= type
			{
			// Pddl.g:151:8: ( NAME )+
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
					// Pddl.g:151:8: NAME
					{
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList739); if (state.failed) return retval; 
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

			char_literal35=(Token)match(input,73,FOLLOW_73_in_singleTypeNameList742); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal35);

			pushFollow(FOLLOW_type_in_singleTypeNameList746);
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
			// 152:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
					// Pddl.g:152:7: ^( NAME $t)
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
	// Pddl.g:155:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// Pddl.g:156:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==69) ) {
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
					// Pddl.g:156:4: ( '(' 'either' ( primType )+ ')' )
					{
					// Pddl.g:156:4: ( '(' 'either' ( primType )+ ')' )
					// Pddl.g:156:6: '(' 'either' ( primType )+ ')'
					{
					char_literal36=(Token)match(input,69,FOLLOW_69_in_type773); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal36);

					string_literal37=(Token)match(input,117,FOLLOW_117_in_type775); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_117.add(string_literal37);

					// Pddl.g:156:19: ( primType )+
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
							// Pddl.g:156:19: primType
							{
							pushFollow(FOLLOW_primType_in_type777);
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

					char_literal39=(Token)match(input,70,FOLLOW_70_in_type780); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal39);

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
					// 157:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// Pddl.g:157:7: ^( EITHER_TYPE ( primType )+ )
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
					// Pddl.g:158:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type801);
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
	// Pddl.g:161:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);
		int primType_StartIndex = input.index();

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// Pddl.g:161:10: ( NAME )
			// Pddl.g:161:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType811); if (state.failed) return retval;
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
	// Pddl.g:163:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// Pddl.g:164:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// Pddl.g:164:4: '(' ':functions' functionList ')'
			{
			char_literal42=(Token)match(input,69,FOLLOW_69_in_functionsDef821); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal42);

			string_literal43=(Token)match(input,87,FOLLOW_87_in_functionsDef823); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal43);

			pushFollow(FOLLOW_functionList_in_functionsDef825);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());
			char_literal45=(Token)match(input,70,FOLLOW_70_in_functionsDef827); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal45);

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
			// 165:2: -> ^( FUNCTIONS functionList )
			{
				// Pddl.g:165:5: ^( FUNCTIONS functionList )
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
	// Pddl.g:168:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
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

			// Pddl.g:169:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// Pddl.g:169:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:169:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==69) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// Pddl.g:169:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// Pddl.g:169:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==69) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						switch (alt18) {
						case 1 :
							// Pddl.g:169:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList848);
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

					// Pddl.g:169:29: ( '-' functionType )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==73) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// Pddl.g:169:30: '-' functionType
							{
							char_literal47=(Token)match(input,73,FOLLOW_73_in_functionList852); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList854);
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
	// Pddl.g:172:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
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

			// Pddl.g:173:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// Pddl.g:173:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal49=(Token)match(input,69,FOLLOW_69_in_atomicFunctionSkeleton870); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton873);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton876);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

			char_literal52=(Token)match(input,70,FOLLOW_70_in_atomicFunctionSkeleton878); if (state.failed) return retval;
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
	// Pddl.g:176:1: functionSymbol : ( NAME | '#t' );
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);
		int functionSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token set53=null;

		Object set53_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// Pddl.g:176:16: ( NAME | '#t' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set53=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==68 ) {
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
	// Pddl.g:178:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);
		int functionType_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// Pddl.g:178:14: ( 'number' )
			// Pddl.g:178:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal54=(Token)match(input,129,FOLLOW_129_in_functionType901); if (state.failed) return retval;
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
	// Pddl.g:180:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
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
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// Pddl.g:181:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// Pddl.g:181:4: '(' ':constants' typedNameList ')'
			{
			char_literal55=(Token)match(input,69,FOLLOW_69_in_constantsDef912); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal55);

			string_literal56=(Token)match(input,77,FOLLOW_77_in_constantsDef914); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_77.add(string_literal56);

			pushFollow(FOLLOW_typedNameList_in_constantsDef916);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());
			char_literal58=(Token)match(input,70,FOLLOW_70_in_constantsDef918); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal58);

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
			// 182:2: -> ^( CONSTANTS typedNameList )
			{
				// Pddl.g:182:5: ^( CONSTANTS typedNameList )
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
	// Pddl.g:185:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// Pddl.g:186:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// Pddl.g:186:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal59=(Token)match(input,69,FOLLOW_69_in_predicatesDef938); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal59);

			string_literal60=(Token)match(input,94,FOLLOW_94_in_predicatesDef940); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_94.add(string_literal60);

			// Pddl.g:186:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==69) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Pddl.g:186:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef942);
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

			char_literal62=(Token)match(input,70,FOLLOW_70_in_predicatesDef945); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal62);

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
			// 187:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// Pddl.g:187:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
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
	// Pddl.g:190:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
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

			// Pddl.g:191:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// Pddl.g:191:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal63=(Token)match(input,69,FOLLOW_69_in_atomicFormulaSkeleton966); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton969);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton972);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

			char_literal66=(Token)match(input,70,FOLLOW_70_in_atomicFormulaSkeleton974); if (state.failed) return retval;
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
	// Pddl.g:194:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);
		int predicate_StartIndex = input.index();

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

			// Pddl.g:194:11: ( NAME )
			// Pddl.g:194:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate985); if (state.failed) return retval;
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
	// Pddl.g:197:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
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

			// Pddl.g:198:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// Pddl.g:198:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:198:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// Pddl.g:198:8: ( VARIABLE )*
					{
					// Pddl.g:198:8: ( VARIABLE )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// Pddl.g:198:8: VARIABLE
							{
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList1000); if (state.failed) return retval;
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
					// Pddl.g:198:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// Pddl.g:198:20: ( singleTypeVarList )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						alt23 = dfa23.predict(input);
						switch (alt23) {
						case 1 :
							// Pddl.g:198:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList1005);
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

					// Pddl.g:198:39: ( VARIABLE )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// Pddl.g:198:39: VARIABLE
							{
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList1008); if (state.failed) return retval;
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
	// Pddl.g:201:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
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
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

			// Pddl.g:202:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// Pddl.g:202:7: ( ( VARIABLE )+ '-' t= type )
			{
			// Pddl.g:202:7: ( ( VARIABLE )+ '-' t= type )
			// Pddl.g:202:8: ( VARIABLE )+ '-' t= type
			{
			// Pddl.g:202:8: ( VARIABLE )+
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
					// Pddl.g:202:8: VARIABLE
					{
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList1028); if (state.failed) return retval; 
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

			char_literal72=(Token)match(input,73,FOLLOW_73_in_singleTypeVarList1031); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(char_literal72);

			pushFollow(FOLLOW_type_in_singleTypeVarList1035);
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
			// 203:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_t.hasNext()||stream_VARIABLE.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_VARIABLE.hasNext() ) {
					// Pddl.g:203:10: ^( VARIABLE $t)
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
	// Pddl.g:206:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
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

			// Pddl.g:207:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// Pddl.g:207:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal73=(Token)match(input,69,FOLLOW_69_in_constraints1066); if (state.failed) return retval;
			string_literal74=(Token)match(input,79,FOLLOW_79_in_constraints1069); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints1072);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

			char_literal76=(Token)match(input,70,FOLLOW_70_in_constraints1074); if (state.failed) return retval;
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
	// Pddl.g:210:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef );
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

			// Pddl.g:211:2: ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef )
			int alt27=6;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==69) ) {
				switch ( input.LA(2) ) {
				case 75:
					{
					alt27=1;
					}
					break;
				case 83:
					{
					alt27=2;
					}
					break;
				case 80:
					{
					alt27=3;
					}
					break;
				case 78:
					{
					alt27=4;
					}
					break;
				case 95:
					{
					alt27=5;
					}
					break;
				case 85:
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
					// Pddl.g:211:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef1086);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					// Pddl.g:212:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef1091);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					// Pddl.g:213:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef1096);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

					}
					break;
				case 4 :
					// Pddl.g:214:4: constraintDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constraintDef_in_structureDef1101);
					constraintDef80=constraintDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

					}
					break;
				case 5 :
					// Pddl.g:215:4: processDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_processDef_in_structureDef1106);
					processDef81=processDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, processDef81.getTree());

					}
					break;
				case 6 :
					// Pddl.g:216:4: eventDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_eventDef_in_structureDef1111);
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
	// Pddl.g:222:1: actionDef : '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

			// Pddl.g:223:2: ( '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:223:4: '(' ':action' actionSymbol ( ':parameters' '(' typedVariableList ')' )? actionDefBody ')'
			{
			char_literal83=(Token)match(input,69,FOLLOW_69_in_actionDef1126); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal83);

			string_literal84=(Token)match(input,75,FOLLOW_75_in_actionDef1128); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_75.add(string_literal84);

			pushFollow(FOLLOW_actionSymbol_in_actionDef1130);
			actionSymbol85=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol85.getTree());
			// Pddl.g:224:8: ( ':parameters' '(' typedVariableList ')' )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==92) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// Pddl.g:224:9: ':parameters' '(' typedVariableList ')'
					{
					string_literal86=(Token)match(input,92,FOLLOW_92_in_actionDef1140); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal86);

					char_literal87=(Token)match(input,69,FOLLOW_69_in_actionDef1143); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal87);

					pushFollow(FOLLOW_typedVariableList_in_actionDef1145);
					typedVariableList88=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList88.getTree());
					char_literal89=(Token)match(input,70,FOLLOW_70_in_actionDef1147); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal89);

					}
					break;

			}

			pushFollow(FOLLOW_actionDefBody_in_actionDef1162);
			actionDefBody90=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody90.getTree());
			char_literal91=(Token)match(input,70,FOLLOW_70_in_actionDef1164); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal91);

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
			// 226:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:226:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:226:33: ( typedVariableList )?
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
	// Pddl.g:228:1: eventDef : '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

			// Pddl.g:229:2: ( '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:229:4: '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal92=(Token)match(input,69,FOLLOW_69_in_eventDef1197); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal92);

			string_literal93=(Token)match(input,85,FOLLOW_85_in_eventDef1199); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal93);

			pushFollow(FOLLOW_actionSymbol_in_eventDef1201);
			actionSymbol94=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol94.getTree());
			string_literal95=(Token)match(input,92,FOLLOW_92_in_eventDef1210); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(string_literal95);

			char_literal96=(Token)match(input,69,FOLLOW_69_in_eventDef1213); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal96);

			pushFollow(FOLLOW_typedVariableList_in_eventDef1215);
			typedVariableList97=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList97.getTree());
			char_literal98=(Token)match(input,70,FOLLOW_70_in_eventDef1217); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal98);

			pushFollow(FOLLOW_actionDefBody_in_eventDef1230);
			actionDefBody99=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody99.getTree());
			char_literal100=(Token)match(input,70,FOLLOW_70_in_eventDef1232); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal100);

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
			// 232:8: -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:232:11: ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EVENT, "EVENT"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:232:32: ( typedVariableList )?
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
	// Pddl.g:234:1: processDef : '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

			// Pddl.g:235:2: ( '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:235:4: '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal101=(Token)match(input,69,FOLLOW_69_in_processDef1265); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal101);

			string_literal102=(Token)match(input,95,FOLLOW_95_in_processDef1267); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal102);

			pushFollow(FOLLOW_actionSymbol_in_processDef1269);
			actionSymbol103=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol103.getTree());
			string_literal104=(Token)match(input,92,FOLLOW_92_in_processDef1278); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(string_literal104);

			char_literal105=(Token)match(input,69,FOLLOW_69_in_processDef1281); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal105);

			pushFollow(FOLLOW_typedVariableList_in_processDef1283);
			typedVariableList106=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList106.getTree());
			char_literal107=(Token)match(input,70,FOLLOW_70_in_processDef1285); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal107);

			pushFollow(FOLLOW_actionDefBody_in_processDef1298);
			actionDefBody108=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody108.getTree());
			char_literal109=(Token)match(input,70,FOLLOW_70_in_processDef1300); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal109);

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
			// 238:8: -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:238:11: ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCESS, "PROCESS"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:238:34: ( typedVariableList )?
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
	// Pddl.g:241:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
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
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
		RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

			// Pddl.g:242:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
			// Pddl.g:242:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
			{
			char_literal110=(Token)match(input,69,FOLLOW_69_in_constraintDef1334); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal110);

			string_literal111=(Token)match(input,78,FOLLOW_78_in_constraintDef1336); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal111);

			pushFollow(FOLLOW_constraintSymbol_in_constraintDef1338);
			constraintSymbol112=constraintSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol112.getTree());
			string_literal113=(Token)match(input,92,FOLLOW_92_in_constraintDef1347); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(string_literal113);

			char_literal114=(Token)match(input,69,FOLLOW_69_in_constraintDef1350); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal114);

			pushFollow(FOLLOW_typedVariableList_in_constraintDef1352);
			typedVariableList115=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList115.getTree());
			char_literal116=(Token)match(input,70,FOLLOW_70_in_constraintDef1354); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal116);

			pushFollow(FOLLOW_constraintDefBody_in_constraintDef1367);
			constraintDefBody117=constraintDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody117.getTree());
			char_literal118=(Token)match(input,70,FOLLOW_70_in_constraintDef1369); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal118);

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
			// 245:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
			{
				// Pddl.g:245:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT"), root_1);
				adaptor.addChild(root_1, stream_constraintSymbol.nextTree());
				// Pddl.g:245:48: ( typedVariableList )?
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
	// Pddl.g:249:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);
		int actionSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token NAME119=null;

		Object NAME119_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

			// Pddl.g:249:14: ( NAME )
			// Pddl.g:249:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME119=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1403); if (state.failed) return retval;
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
	// Pddl.g:251:1: constraintSymbol : NAME ;
	public final PddlParser.constraintSymbol_return constraintSymbol() throws RecognitionException {
		PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
		retval.start = input.LT(1);
		int constraintSymbol_StartIndex = input.index();

		Object root_0 = null;

		Token NAME120=null;

		Object NAME120_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

			// Pddl.g:251:18: ( NAME )
			// Pddl.g:251:20: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME120=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1412); if (state.failed) return retval;
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
	// Pddl.g:256:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

			// Pddl.g:257:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// Pddl.g:257:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// Pddl.g:257:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==93) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// Pddl.g:257:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal121=(Token)match(input,93,FOLLOW_93_in_actionDefBody1427); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_93.add(string_literal121);

					// Pddl.g:257:22: ( ( '(' ')' ) | goalDesc )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==69) ) {
						int LA29_1 = input.LA(2);
						if ( (LA29_1==70) ) {
							alt29=1;
						}
						else if ( (LA29_1==NAME||(LA29_1 >= 98 && LA29_1 <= 102)||LA29_1==109||(LA29_1 >= 119 && LA29_1 <= 120)||LA29_1==123||LA29_1==128||(LA29_1 >= 130 && LA29_1 <= 131)) ) {
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
							// Pddl.g:257:23: ( '(' ')' )
							{
							// Pddl.g:257:23: ( '(' ')' )
							// Pddl.g:257:24: '(' ')'
							{
							char_literal122=(Token)match(input,69,FOLLOW_69_in_actionDefBody1431); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_69.add(char_literal122);

							char_literal123=(Token)match(input,70,FOLLOW_70_in_actionDefBody1433); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_70.add(char_literal123);

							}

							}
							break;
						case 2 :
							// Pddl.g:257:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1438);
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

			// Pddl.g:258:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==84) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// Pddl.g:258:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal125=(Token)match(input,84,FOLLOW_84_in_actionDefBody1448); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_84.add(string_literal125);

					// Pddl.g:258:16: ( ( '(' ')' ) | effect )
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==69) ) {
						int LA31_1 = input.LA(2);
						if ( (LA31_1==70) ) {
							alt31=1;
						}
						else if ( (LA31_1==NAME||(LA31_1 >= 109 && LA31_1 <= 110)||LA31_1==114||LA31_1==120||LA31_1==124||LA31_1==128||(LA31_1 >= 135 && LA31_1 <= 136)||LA31_1==143) ) {
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
							// Pddl.g:258:17: ( '(' ')' )
							{
							// Pddl.g:258:17: ( '(' ')' )
							// Pddl.g:258:18: '(' ')'
							{
							char_literal126=(Token)match(input,69,FOLLOW_69_in_actionDefBody1452); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_69.add(char_literal126);

							char_literal127=(Token)match(input,70,FOLLOW_70_in_actionDefBody1454); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_70.add(char_literal127);

							}

							}
							break;
						case 2 :
							// Pddl.g:258:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1459);
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
			// 259:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// Pddl.g:259:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:259:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// Pddl.g:259:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// Pddl.g:259:42: ( effect )?
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
	// Pddl.g:262:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

			// Pddl.g:263:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
			// Pddl.g:263:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			{
			// Pddl.g:263:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==76) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// Pddl.g:263:6: ':condition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal129=(Token)match(input,76,FOLLOW_76_in_constraintDefBody1494); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_76.add(string_literal129);

					// Pddl.g:263:19: ( ( '(' ')' ) | goalDesc )
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==69) ) {
						int LA33_1 = input.LA(2);
						if ( (LA33_1==70) ) {
							alt33=1;
						}
						else if ( (LA33_1==NAME||(LA33_1 >= 98 && LA33_1 <= 102)||LA33_1==109||(LA33_1 >= 119 && LA33_1 <= 120)||LA33_1==123||LA33_1==128||(LA33_1 >= 130 && LA33_1 <= 131)) ) {
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
							// Pddl.g:263:20: ( '(' ')' )
							{
							// Pddl.g:263:20: ( '(' ')' )
							// Pddl.g:263:21: '(' ')'
							{
							char_literal130=(Token)match(input,69,FOLLOW_69_in_constraintDefBody1498); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_69.add(char_literal130);

							char_literal131=(Token)match(input,70,FOLLOW_70_in_constraintDefBody1500); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_70.add(char_literal131);

							}

							}
							break;
						case 2 :
							// Pddl.g:263:32: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_constraintDefBody1505);
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
			// 264:4: -> ^( PRECONDITION ( goalDesc )? )
			{
				// Pddl.g:264:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:264:22: ( goalDesc )?
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
	// Pddl.g:279:1: belief : goalDesc ( initEl )* -> ^( BELIEF goalDesc ( initEl )* ) ;
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

			// Pddl.g:280:2: ( goalDesc ( initEl )* -> ^( BELIEF goalDesc ( initEl )* ) )
			// Pddl.g:280:4: goalDesc ( initEl )*
			{
			pushFollow(FOLLOW_goalDesc_in_belief1543);
			goalDesc133=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc133.getTree());
			// Pddl.g:281:4: ( initEl )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==69) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// Pddl.g:281:4: initEl
					{
					pushFollow(FOLLOW_initEl_in_belief1548);
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
			// 281:12: -> ^( BELIEF goalDesc ( initEl )* )
			{
				// Pddl.g:281:15: ^( BELIEF goalDesc ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BELIEF, "BELIEF"), root_1);
				adaptor.addChild(root_1, stream_goalDesc.nextTree());
				// Pddl.g:281:33: ( initEl )*
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
	// Pddl.g:284:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'oneof' ( goalDesc )* ')' -> ^( ONEOF ( goalDesc )* ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
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
		RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
		RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");
		RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

			// Pddl.g:285:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'oneof' ( goalDesc )* ')' -> ^( ONEOF ( goalDesc )* ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt39=10;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==69) ) {
				switch ( input.LA(2) ) {
				case 109:
					{
					alt39=2;
					}
					break;
				case 131:
					{
					alt39=3;
					}
					break;
				case 128:
					{
					alt39=4;
					}
					break;
				case 130:
					{
					alt39=5;
					}
					break;
				case 123:
					{
					alt39=6;
					}
					break;
				case 119:
					{
					alt39=7;
					}
					break;
				case 120:
					{
					alt39=8;
					}
					break;
				case 100:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA39_14 = input.LA(5);
							if ( (LA39_14==70) ) {
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
						case 68:
						case 69:
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
					case 68:
					case 69:
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
				case 98:
				case 99:
				case 101:
				case 102:
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
					// Pddl.g:285:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1570);
					atomicTermFormula135=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula135.getTree());

					}
					break;
				case 2 :
					// Pddl.g:286:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal136=(Token)match(input,69,FOLLOW_69_in_goalDesc1575); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal136);

					string_literal137=(Token)match(input,109,FOLLOW_109_in_goalDesc1577); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_109.add(string_literal137);

					// Pddl.g:286:14: ( goalDesc )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==69) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// Pddl.g:286:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1579);
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

					char_literal139=(Token)match(input,70,FOLLOW_70_in_goalDesc1582); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal139);

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
					// 287:12: -> ^( AND_GD ( goalDesc )* )
					{
						// Pddl.g:287:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// Pddl.g:287:24: ( goalDesc )*
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
					// Pddl.g:288:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal140=(Token)match(input,69,FOLLOW_69_in_goalDesc1607); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal140);

					string_literal141=(Token)match(input,131,FOLLOW_131_in_goalDesc1609); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_131.add(string_literal141);

					// Pddl.g:288:13: ( goalDesc )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==69) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// Pddl.g:288:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1611);
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

					char_literal143=(Token)match(input,70,FOLLOW_70_in_goalDesc1614); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal143);

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
					// 289:12: -> ^( OR_GD ( goalDesc )* )
					{
						// Pddl.g:289:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:289:23: ( goalDesc )*
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
					// Pddl.g:290:4: '(' 'not' goalDesc ')'
					{
					char_literal144=(Token)match(input,69,FOLLOW_69_in_goalDesc1639); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal144);

					string_literal145=(Token)match(input,128,FOLLOW_128_in_goalDesc1641); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_128.add(string_literal145);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1643);
					goalDesc146=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc146.getTree());
					char_literal147=(Token)match(input,70,FOLLOW_70_in_goalDesc1645); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal147);

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
					// 291:12: -> ^( NOT_GD goalDesc )
					{
						// Pddl.g:291:15: ^( NOT_GD goalDesc )
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
					// Pddl.g:292:4: '(' 'oneof' ( goalDesc )* ')'
					{
					char_literal148=(Token)match(input,69,FOLLOW_69_in_goalDesc1669); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal148);

					string_literal149=(Token)match(input,130,FOLLOW_130_in_goalDesc1671); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_130.add(string_literal149);

					// Pddl.g:292:17: ( goalDesc )*
					loop38:
					while (true) {
						int alt38=2;
						int LA38_0 = input.LA(1);
						if ( (LA38_0==69) ) {
							alt38=1;
						}

						switch (alt38) {
						case 1 :
							// Pddl.g:292:17: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1674);
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

					char_literal151=(Token)match(input,70,FOLLOW_70_in_goalDesc1677); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal151);

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
					// 292:32: -> ^( ONEOF ( goalDesc )* )
					{
						// Pddl.g:292:35: ^( ONEOF ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONEOF, "ONEOF"), root_1);
						// Pddl.g:292:43: ( goalDesc )*
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
					// Pddl.g:293:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal152=(Token)match(input,69,FOLLOW_69_in_goalDesc1692); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal152);

					string_literal153=(Token)match(input,123,FOLLOW_123_in_goalDesc1694); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_123.add(string_literal153);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1696);
					goalDesc154=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc154.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1698);
					goalDesc155=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc155.getTree());
					char_literal156=(Token)match(input,70,FOLLOW_70_in_goalDesc1700); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal156);

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
					// 294:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// Pddl.g:294:15: ^( IMPLY_GD goalDesc goalDesc )
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
					// Pddl.g:295:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal157=(Token)match(input,69,FOLLOW_69_in_goalDesc1726); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal157);

					string_literal158=(Token)match(input,119,FOLLOW_119_in_goalDesc1728); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_119.add(string_literal158);

					char_literal159=(Token)match(input,69,FOLLOW_69_in_goalDesc1730); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal159);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1732);
					typedVariableList160=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList160.getTree());
					char_literal161=(Token)match(input,70,FOLLOW_70_in_goalDesc1734); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal161);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1736);
					goalDesc162=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc162.getTree());
					char_literal163=(Token)match(input,70,FOLLOW_70_in_goalDesc1738); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal163);

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
					// 296:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// Pddl.g:296:15: ^( EXISTS_GD typedVariableList goalDesc )
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
					// Pddl.g:297:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal164=(Token)match(input,69,FOLLOW_69_in_goalDesc1764); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal164);

					string_literal165=(Token)match(input,120,FOLLOW_120_in_goalDesc1766); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_120.add(string_literal165);

					char_literal166=(Token)match(input,69,FOLLOW_69_in_goalDesc1768); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal166);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1770);
					typedVariableList167=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList167.getTree());
					char_literal168=(Token)match(input,70,FOLLOW_70_in_goalDesc1772); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal168);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1774);
					goalDesc169=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc169.getTree());
					char_literal170=(Token)match(input,70,FOLLOW_70_in_goalDesc1776); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal170);

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
					// 298:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// Pddl.g:298:15: ^( FORALL_GD typedVariableList goalDesc )
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
					// Pddl.g:299:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1805);
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
					// 300:15: -> ^( COMPARISON_GD fComp )
					{
						// Pddl.g:300:18: ^( COMPARISON_GD fComp )
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
					// Pddl.g:301:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1832);
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
					// 302:6: -> ^( EQUALITY_CON equality )
					{
						// Pddl.g:302:9: ^( EQUALITY_CON equality )
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
	// Pddl.g:305:1: equality : '(' ! '=' term term ')' !;
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

			// Pddl.g:306:2: ( '(' ! '=' term term ')' !)
			// Pddl.g:306:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal173=(Token)match(input,69,FOLLOW_69_in_equality1860); if (state.failed) return retval;
			char_literal174=(Token)match(input,100,FOLLOW_100_in_equality1863); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal174_tree = (Object)adaptor.create(char_literal174);
			adaptor.addChild(root_0, char_literal174_tree);
			}

			pushFollow(FOLLOW_term_in_equality1865);
			term175=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term175.getTree());

			pushFollow(FOLLOW_term_in_equality1867);
			term176=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term176.getTree());

			char_literal177=(Token)match(input,70,FOLLOW_70_in_equality1869); if (state.failed) return retval;
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
	// Pddl.g:308:1: fComp : '(' ! binaryComp fExp fExp ')' !;
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

			// Pddl.g:309:2: ( '(' ! binaryComp fExp fExp ')' !)
			// Pddl.g:309:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal178=(Token)match(input,69,FOLLOW_69_in_fComp1880); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1883);
			binaryComp179=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp179.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1885);
			fExp180=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp180.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1887);
			fExp181=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp181.getTree());

			char_literal182=(Token)match(input,70,FOLLOW_70_in_fComp1889); if (state.failed) return retval;
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
	// Pddl.g:312:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

			// Pddl.g:313:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// Pddl.g:313:4: '(' predicate ( term )* ')'
			{
			char_literal183=(Token)match(input,69,FOLLOW_69_in_atomicTermFormula1901); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal183);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1903);
			predicate184=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate184.getTree());
			// Pddl.g:313:18: ( term )*
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( (LA40_0==NAME||LA40_0==VARIABLE) ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Pddl.g:313:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1905);
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

			char_literal186=(Token)match(input,70,FOLLOW_70_in_atomicTermFormula1908); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal186);

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
			// 313:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// Pddl.g:313:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:313:53: ( term )*
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
	// Pddl.g:316:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);
		int term_StartIndex = input.index();

		Object root_0 = null;

		Token set187=null;

		Object set187_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

			// Pddl.g:316:6: ( NAME | VARIABLE )
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
	// Pddl.g:320:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

			// Pddl.g:321:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// Pddl.g:321:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal188=(Token)match(input,69,FOLLOW_69_in_durativeActionDef1945); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal188);

			string_literal189=(Token)match(input,83,FOLLOW_83_in_durativeActionDef1947); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_83.add(string_literal189);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1949);
			actionSymbol190=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol190.getTree());
			string_literal191=(Token)match(input,92,FOLLOW_92_in_durativeActionDef1958); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(string_literal191);

			char_literal192=(Token)match(input,69,FOLLOW_69_in_durativeActionDef1961); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal192);

			// Pddl.g:322:27: ( typedVariableList )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==VARIABLE) ) {
				alt41=1;
			}
			else if ( (LA41_0==70) ) {
				int LA41_2 = input.LA(2);
				if ( (synpred55_Pddl()) ) {
					alt41=1;
				}
			}
			switch (alt41) {
				case 1 :
					// Pddl.g:322:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1964);
					typedVariableList193=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList193.getTree());
					}
					break;

			}

			char_literal194=(Token)match(input,70,FOLLOW_70_in_durativeActionDef1968); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal194);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1981);
			daDefBody195=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody195.getTree());
			char_literal196=(Token)match(input,70,FOLLOW_70_in_durativeActionDef1983); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal196);

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
			// 324:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// Pddl.g:324:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
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
	// Pddl.g:327:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
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

			// Pddl.g:328:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt44=3;
			switch ( input.LA(1) ) {
			case 82:
				{
				alt44=1;
				}
				break;
			case 76:
				{
				alt44=2;
				}
				break;
			case 84:
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
					// Pddl.g:328:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal197=(Token)match(input,82,FOLLOW_82_in_daDefBody2016); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal197_tree = (Object)adaptor.create(string_literal197);
					adaptor.addChild(root_0, string_literal197_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody2018);
					durationConstraint198=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint198.getTree());

					}
					break;
				case 2 :
					// Pddl.g:329:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal199=(Token)match(input,76,FOLLOW_76_in_daDefBody2023); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal199_tree = (Object)adaptor.create(string_literal199);
					adaptor.addChild(root_0, string_literal199_tree);
					}

					// Pddl.g:329:17: ( ( '(' ')' ) | daGD )
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==69) ) {
						int LA42_1 = input.LA(2);
						if ( (LA42_1==70) ) {
							alt42=1;
						}
						else if ( (LA42_1==109||LA42_1==111||LA42_1==120||(LA42_1 >= 132 && LA42_1 <= 133)) ) {
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
							// Pddl.g:329:18: ( '(' ')' )
							{
							// Pddl.g:329:18: ( '(' ')' )
							// Pddl.g:329:19: '(' ')'
							{
							char_literal200=(Token)match(input,69,FOLLOW_69_in_daDefBody2027); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal200_tree = (Object)adaptor.create(char_literal200);
							adaptor.addChild(root_0, char_literal200_tree);
							}

							char_literal201=(Token)match(input,70,FOLLOW_70_in_daDefBody2029); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal201_tree = (Object)adaptor.create(char_literal201);
							adaptor.addChild(root_0, char_literal201_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:329:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody2034);
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
					// Pddl.g:330:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal203=(Token)match(input,84,FOLLOW_84_in_daDefBody2043); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal203_tree = (Object)adaptor.create(string_literal203);
					adaptor.addChild(root_0, string_literal203_tree);
					}

					// Pddl.g:330:17: ( ( '(' ')' ) | daEffect )
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==69) ) {
						int LA43_1 = input.LA(2);
						if ( (LA43_1==70) ) {
							alt43=1;
						}
						else if ( ((LA43_1 >= 109 && LA43_1 <= 111)||LA43_1==114||LA43_1==120||LA43_1==124||(LA43_1 >= 135 && LA43_1 <= 136)||LA43_1==143) ) {
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
							// Pddl.g:330:18: ( '(' ')' )
							{
							// Pddl.g:330:18: ( '(' ')' )
							// Pddl.g:330:19: '(' ')'
							{
							char_literal204=(Token)match(input,69,FOLLOW_69_in_daDefBody2047); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal204_tree = (Object)adaptor.create(char_literal204);
							adaptor.addChild(root_0, char_literal204_tree);
							}

							char_literal205=(Token)match(input,70,FOLLOW_70_in_daDefBody2049); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal205_tree = (Object)adaptor.create(char_literal205);
							adaptor.addChild(root_0, char_literal205_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:330:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody2054);
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
	// Pddl.g:333:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
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

			// Pddl.g:334:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt46=3;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==69) ) {
				switch ( input.LA(2) ) {
				case 111:
				case 132:
				case 133:
					{
					alt46=1;
					}
					break;
				case 109:
					{
					alt46=2;
					}
					break;
				case 120:
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
					// Pddl.g:334:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD2069);
					prefTimedGD207=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD207.getTree());

					}
					break;
				case 2 :
					// Pddl.g:335:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal208=(Token)match(input,69,FOLLOW_69_in_daGD2074); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal208_tree = (Object)adaptor.create(char_literal208);
					adaptor.addChild(root_0, char_literal208_tree);
					}

					string_literal209=(Token)match(input,109,FOLLOW_109_in_daGD2076); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal209_tree = (Object)adaptor.create(string_literal209);
					adaptor.addChild(root_0, string_literal209_tree);
					}

					// Pddl.g:335:14: ( daGD )*
					loop45:
					while (true) {
						int alt45=2;
						int LA45_0 = input.LA(1);
						if ( (LA45_0==69) ) {
							alt45=1;
						}

						switch (alt45) {
						case 1 :
							// Pddl.g:335:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD2078);
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

					char_literal211=(Token)match(input,70,FOLLOW_70_in_daGD2081); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal211_tree = (Object)adaptor.create(char_literal211);
					adaptor.addChild(root_0, char_literal211_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:336:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal212=(Token)match(input,69,FOLLOW_69_in_daGD2086); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal212_tree = (Object)adaptor.create(char_literal212);
					adaptor.addChild(root_0, char_literal212_tree);
					}

					string_literal213=(Token)match(input,120,FOLLOW_120_in_daGD2088); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal213_tree = (Object)adaptor.create(string_literal213);
					adaptor.addChild(root_0, string_literal213_tree);
					}

					char_literal214=(Token)match(input,69,FOLLOW_69_in_daGD2090); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (Object)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD2092);
					typedVariableList215=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList215.getTree());

					char_literal216=(Token)match(input,70,FOLLOW_70_in_daGD2094); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal216_tree = (Object)adaptor.create(char_literal216);
					adaptor.addChild(root_0, char_literal216_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD2096);
					daGD217=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD217.getTree());

					char_literal218=(Token)match(input,70,FOLLOW_70_in_daGD2098); if (state.failed) return retval;
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
	// Pddl.g:339:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
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

			// Pddl.g:340:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==69) ) {
				int LA48_1 = input.LA(2);
				if ( (LA48_1==111||LA48_1==132) ) {
					alt48=1;
				}
				else if ( (LA48_1==133) ) {
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
					// Pddl.g:340:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD2109);
					timedGD219=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD219.getTree());

					}
					break;
				case 2 :
					// Pddl.g:341:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal220=(Token)match(input,69,FOLLOW_69_in_prefTimedGD2114); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal220_tree = (Object)adaptor.create(char_literal220);
					adaptor.addChild(root_0, char_literal220_tree);
					}

					string_literal221=(Token)match(input,133,FOLLOW_133_in_prefTimedGD2116); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal221_tree = (Object)adaptor.create(string_literal221);
					adaptor.addChild(root_0, string_literal221_tree);
					}

					// Pddl.g:341:21: ( NAME )?
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==NAME) ) {
						alt47=1;
					}
					switch (alt47) {
						case 1 :
							// Pddl.g:341:21: NAME
							{
							NAME222=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD2118); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME222_tree = (Object)adaptor.create(NAME222);
							adaptor.addChild(root_0, NAME222_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD2121);
					timedGD223=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD223.getTree());

					char_literal224=(Token)match(input,70,FOLLOW_70_in_prefTimedGD2123); if (state.failed) return retval;
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
	// Pddl.g:344:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
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

			// Pddl.g:345:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==69) ) {
				int LA49_1 = input.LA(2);
				if ( (LA49_1==111) ) {
					alt49=1;
				}
				else if ( (LA49_1==132) ) {
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
					// Pddl.g:345:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal225=(Token)match(input,69,FOLLOW_69_in_timedGD2134); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal225_tree = (Object)adaptor.create(char_literal225);
					adaptor.addChild(root_0, char_literal225_tree);
					}

					string_literal226=(Token)match(input,111,FOLLOW_111_in_timedGD2136); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal226_tree = (Object)adaptor.create(string_literal226);
					adaptor.addChild(root_0, string_literal226_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD2138);
					timeSpecifier227=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier227.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2140);
					goalDesc228=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc228.getTree());

					char_literal229=(Token)match(input,70,FOLLOW_70_in_timedGD2142); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal229_tree = (Object)adaptor.create(char_literal229);
					adaptor.addChild(root_0, char_literal229_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:346:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal230=(Token)match(input,69,FOLLOW_69_in_timedGD2147); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal230_tree = (Object)adaptor.create(char_literal230);
					adaptor.addChild(root_0, char_literal230_tree);
					}

					string_literal231=(Token)match(input,132,FOLLOW_132_in_timedGD2149); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal231_tree = (Object)adaptor.create(string_literal231);
					adaptor.addChild(root_0, string_literal231_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD2151);
					interval232=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval232.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2153);
					goalDesc233=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc233.getTree());

					char_literal234=(Token)match(input,70,FOLLOW_70_in_timedGD2155); if (state.failed) return retval;
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
	// Pddl.g:349:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);
		int timeSpecifier_StartIndex = input.index();

		Object root_0 = null;

		Token set235=null;

		Object set235_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }

			// Pddl.g:349:15: ( 'start' | 'end' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set235=input.LT(1);
			if ( input.LA(1)==118||input.LA(1)==141 ) {
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
	// Pddl.g:350:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);
		int interval_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal236=null;

		Object string_literal236_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }

			// Pddl.g:350:10: ( 'all' )
			// Pddl.g:350:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal236=(Token)match(input,106,FOLLOW_106_in_interval2177); if (state.failed) return retval;
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
	// Pddl.g:354:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
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

			// Pddl.g:355:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// Pddl.g:355:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal237=(Token)match(input,69,FOLLOW_69_in_derivedDef2190); if (state.failed) return retval;
			string_literal238=(Token)match(input,80,FOLLOW_80_in_derivedDef2193); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal238_tree = (Object)adaptor.create(string_literal238);
			root_0 = (Object)adaptor.becomeRoot(string_literal238_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef2196);
			typedVariableList239=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList239.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef2198);
			goalDesc240=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc240.getTree());

			char_literal241=(Token)match(input,70,FOLLOW_70_in_derivedDef2200); if (state.failed) return retval;
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
	// Pddl.g:360:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | '(' 'abs' fExp ')' -> ^( ABS fExp ) | fHead );
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
		ParserRuleReturnScope binaryOp244 =null;
		ParserRuleReturnScope fExp245 =null;
		ParserRuleReturnScope fExp2246 =null;
		ParserRuleReturnScope fExp250 =null;
		ParserRuleReturnScope fExp254 =null;
		ParserRuleReturnScope fExp258 =null;
		ParserRuleReturnScope fExp262 =null;
		ParserRuleReturnScope fHead264 =null;

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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_137=new RewriteRuleTokenStream(adaptor,"token 137");
		RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }

			// Pddl.g:361:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | '(' 'abs' fExp ')' -> ^( ABS fExp ) | fHead )
			int alt50=7;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt50=1;
				}
				break;
			case 69:
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
				else if ( (true) ) {
					alt50=7;
				}

				}
				break;
			case NAME:
			case 68:
				{
				alt50=7;
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
					// Pddl.g:361:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER242=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp2215); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER242_tree = (Object)adaptor.create(NUMBER242);
					adaptor.addChild(root_0, NUMBER242_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:362:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal243=(Token)match(input,69,FOLLOW_69_in_fExp2220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal243);

					pushFollow(FOLLOW_binaryOp_in_fExp2222);
					binaryOp244=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp244.getTree());
					pushFollow(FOLLOW_fExp_in_fExp2224);
					fExp245=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp245.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp2226);
					fExp2246=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2246.getTree());
					char_literal247=(Token)match(input,70,FOLLOW_70_in_fExp2228); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal247);

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
					// 362:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// Pddl.g:362:35: ^( BINARY_OP binaryOp fExp fExp2 )
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
					// Pddl.g:363:4: '(' '-' fExp ')'
					{
					char_literal248=(Token)match(input,69,FOLLOW_69_in_fExp2245); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal248);

					char_literal249=(Token)match(input,73,FOLLOW_73_in_fExp2247); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal249);

					pushFollow(FOLLOW_fExp_in_fExp2249);
					fExp250=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp250.getTree());
					char_literal251=(Token)match(input,70,FOLLOW_70_in_fExp2251); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal251);

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
					// 363:21: -> ^( UNARY_MINUS fExp )
					{
						// Pddl.g:363:24: ^( UNARY_MINUS fExp )
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
					// Pddl.g:364:4: '(' 'sin' fExp ')'
					{
					char_literal252=(Token)match(input,69,FOLLOW_69_in_fExp2264); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal252);

					string_literal253=(Token)match(input,137,FOLLOW_137_in_fExp2266); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_137.add(string_literal253);

					pushFollow(FOLLOW_fExp_in_fExp2268);
					fExp254=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp254.getTree());
					char_literal255=(Token)match(input,70,FOLLOW_70_in_fExp2270); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal255);

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
					// 364:23: -> ^( SIN fExp )
					{
						// Pddl.g:364:26: ^( SIN fExp )
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
					// Pddl.g:365:4: '(' 'cos' fExp ')'
					{
					char_literal256=(Token)match(input,69,FOLLOW_69_in_fExp2283); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal256);

					string_literal257=(Token)match(input,113,FOLLOW_113_in_fExp2285); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal257);

					pushFollow(FOLLOW_fExp_in_fExp2287);
					fExp258=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp258.getTree());
					char_literal259=(Token)match(input,70,FOLLOW_70_in_fExp2289); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal259);

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
					// 365:23: -> ^( COS fExp )
					{
						// Pddl.g:365:26: ^( COS fExp )
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
					// Pddl.g:366:4: '(' 'abs' fExp ')'
					{
					char_literal260=(Token)match(input,69,FOLLOW_69_in_fExp2302); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal260);

					string_literal261=(Token)match(input,105,FOLLOW_105_in_fExp2304); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_105.add(string_literal261);

					pushFollow(FOLLOW_fExp_in_fExp2306);
					fExp262=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp262.getTree());
					char_literal263=(Token)match(input,70,FOLLOW_70_in_fExp2308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal263);

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
					// 366:23: -> ^( ABS fExp )
					{
						// Pddl.g:366:26: ^( ABS fExp )
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
				case 7 :
					// Pddl.g:367:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp2321);
					fHead264=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead264.getTree());

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
	// Pddl.g:372:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);
		int fExp2_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope fExp265 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }

			// Pddl.g:372:7: ( fExp )
			// Pddl.g:372:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp22333);
			fExp265=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp265.getTree());

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
	// Pddl.g:374:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);
		int fHead_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal266=null;
		Token char_literal269=null;
		ParserRuleReturnScope functionSymbol267 =null;
		ParserRuleReturnScope term268 =null;
		ParserRuleReturnScope functionSymbol270 =null;

		Object char_literal266_tree=null;
		Object char_literal269_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }

			// Pddl.g:375:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==69) ) {
				alt52=1;
			}
			else if ( (LA52_0==NAME||LA52_0==68) ) {
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
					// Pddl.g:375:4: '(' functionSymbol ( term )* ')'
					{
					char_literal266=(Token)match(input,69,FOLLOW_69_in_fHead2343); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal266);

					pushFollow(FOLLOW_functionSymbol_in_fHead2345);
					functionSymbol267=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol267.getTree());
					// Pddl.g:375:23: ( term )*
					loop51:
					while (true) {
						int alt51=2;
						int LA51_0 = input.LA(1);
						if ( (LA51_0==NAME||LA51_0==VARIABLE) ) {
							alt51=1;
						}

						switch (alt51) {
						case 1 :
							// Pddl.g:375:23: term
							{
							pushFollow(FOLLOW_term_in_fHead2347);
							term268=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term268.getTree());
							}
							break;

						default :
							break loop51;
						}
					}

					char_literal269=(Token)match(input,70,FOLLOW_70_in_fHead2350); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal269);

					// AST REWRITE
					// elements: functionSymbol, term
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 375:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// Pddl.g:375:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// Pddl.g:375:63: ( term )*
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
					// Pddl.g:376:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead2366);
					functionSymbol270=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol270.getTree());
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
					// 376:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// Pddl.g:376:22: ^( FUNC_HEAD functionSymbol )
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
	// Pddl.g:379:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);
		int effect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal271=null;
		Token string_literal272=null;
		Token char_literal274=null;
		ParserRuleReturnScope cEffect273 =null;
		ParserRuleReturnScope cEffect275 =null;

		Object char_literal271_tree=null;
		Object string_literal272_tree=null;
		Object char_literal274_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }

			// Pddl.g:380:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==69) ) {
				int LA54_1 = input.LA(2);
				if ( (LA54_1==109) ) {
					alt54=1;
				}
				else if ( (LA54_1==NAME||LA54_1==110||LA54_1==114||LA54_1==120||LA54_1==124||LA54_1==128||(LA54_1 >= 135 && LA54_1 <= 136)||LA54_1==143) ) {
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
					// Pddl.g:380:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal271=(Token)match(input,69,FOLLOW_69_in_effect2385); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal271);

					string_literal272=(Token)match(input,109,FOLLOW_109_in_effect2387); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_109.add(string_literal272);

					// Pddl.g:380:14: ( cEffect )*
					loop53:
					while (true) {
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( (LA53_0==69) ) {
							alt53=1;
						}

						switch (alt53) {
						case 1 :
							// Pddl.g:380:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect2389);
							cEffect273=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect273.getTree());
							}
							break;

						default :
							break loop53;
						}
					}

					char_literal274=(Token)match(input,70,FOLLOW_70_in_effect2392); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal274);

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
					// 380:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// Pddl.g:380:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:380:43: ( cEffect )*
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
					// Pddl.g:381:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect2406);
					cEffect275=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect275.getTree());

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
	// Pddl.g:384:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);
		int cEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal276=null;
		Token string_literal277=null;
		Token char_literal278=null;
		Token char_literal280=null;
		Token char_literal282=null;
		Token char_literal283=null;
		Token string_literal284=null;
		Token char_literal287=null;
		ParserRuleReturnScope typedVariableList279 =null;
		ParserRuleReturnScope effect281 =null;
		ParserRuleReturnScope goalDesc285 =null;
		ParserRuleReturnScope condEffect286 =null;
		ParserRuleReturnScope pEffect288 =null;

		Object char_literal276_tree=null;
		Object string_literal277_tree=null;
		Object char_literal278_tree=null;
		Object char_literal280_tree=null;
		Object char_literal282_tree=null;
		Object char_literal283_tree=null;
		Object string_literal284_tree=null;
		Object char_literal287_tree=null;
		RewriteRuleTokenStream stream_143=new RewriteRuleTokenStream(adaptor,"token 143");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }

			// Pddl.g:385:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt55=3;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==69) ) {
				switch ( input.LA(2) ) {
				case 120:
					{
					alt55=1;
					}
					break;
				case 143:
					{
					alt55=2;
					}
					break;
				case NAME:
				case 110:
				case 114:
				case 124:
				case 128:
				case 135:
				case 136:
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
					// Pddl.g:385:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal276=(Token)match(input,69,FOLLOW_69_in_cEffect2417); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal276);

					string_literal277=(Token)match(input,120,FOLLOW_120_in_cEffect2419); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_120.add(string_literal277);

					char_literal278=(Token)match(input,69,FOLLOW_69_in_cEffect2421); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal278);

					pushFollow(FOLLOW_typedVariableList_in_cEffect2423);
					typedVariableList279=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList279.getTree());
					char_literal280=(Token)match(input,70,FOLLOW_70_in_cEffect2425); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal280);

					pushFollow(FOLLOW_effect_in_cEffect2427);
					effect281=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect281.getTree());
					char_literal282=(Token)match(input,70,FOLLOW_70_in_cEffect2429); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal282);

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
					// 386:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// Pddl.g:386:7: ^( FORALL_EFFECT typedVariableList effect )
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
					// Pddl.g:387:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal283=(Token)match(input,69,FOLLOW_69_in_cEffect2447); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal283);

					string_literal284=(Token)match(input,143,FOLLOW_143_in_cEffect2449); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_143.add(string_literal284);

					pushFollow(FOLLOW_goalDesc_in_cEffect2451);
					goalDesc285=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc285.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect2453);
					condEffect286=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect286.getTree());
					char_literal287=(Token)match(input,70,FOLLOW_70_in_cEffect2455); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal287);

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
					// 388:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// Pddl.g:388:7: ^( WHEN_EFFECT goalDesc condEffect )
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
					// Pddl.g:389:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect2473);
					pEffect288=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect288.getTree());

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
	// Pddl.g:392:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);
		int pEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal289=null;
		Token char_literal293=null;
		Token char_literal294=null;
		Token string_literal295=null;
		Token char_literal297=null;
		ParserRuleReturnScope assignOp290 =null;
		ParserRuleReturnScope fHead291 =null;
		ParserRuleReturnScope fExp292 =null;
		ParserRuleReturnScope atomicTermFormula296 =null;
		ParserRuleReturnScope atomicTermFormula298 =null;

		Object char_literal289_tree=null;
		Object char_literal293_tree=null;
		Object char_literal294_tree=null;
		Object string_literal295_tree=null;
		Object char_literal297_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }

			// Pddl.g:393:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt56=3;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==69) ) {
				switch ( input.LA(2) ) {
				case 128:
					{
					alt56=2;
					}
					break;
				case 110:
				case 114:
				case 124:
				case 135:
				case 136:
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
					// Pddl.g:393:4: '(' assignOp fHead fExp ')'
					{
					char_literal289=(Token)match(input,69,FOLLOW_69_in_pEffect2484); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal289);

					pushFollow(FOLLOW_assignOp_in_pEffect2486);
					assignOp290=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp290.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect2488);
					fHead291=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead291.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect2490);
					fExp292=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp292.getTree());
					char_literal293=(Token)match(input,70,FOLLOW_70_in_pEffect2492); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal293);

					// AST REWRITE
					// elements: fExp, assignOp, fHead
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 394:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// Pddl.g:394:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
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
					// Pddl.g:395:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal294=(Token)match(input,69,FOLLOW_69_in_pEffect2512); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal294);

					string_literal295=(Token)match(input,128,FOLLOW_128_in_pEffect2514); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_128.add(string_literal295);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2516);
					atomicTermFormula296=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula296.getTree());
					char_literal297=(Token)match(input,70,FOLLOW_70_in_pEffect2518); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal297);

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
					// 396:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// Pddl.g:396:7: ^( NOT_EFFECT atomicTermFormula )
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
					// Pddl.g:397:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2534);
					atomicTermFormula298=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula298.getTree());

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
	// Pddl.g:402:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);
		int condEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal299=null;
		Token string_literal300=null;
		Token char_literal302=null;
		ParserRuleReturnScope pEffect301 =null;
		ParserRuleReturnScope pEffect303 =null;

		Object char_literal299_tree=null;
		Object string_literal300_tree=null;
		Object char_literal302_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }

			// Pddl.g:403:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==69) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==109) ) {
					alt58=1;
				}
				else if ( (LA58_1==NAME||LA58_1==110||LA58_1==114||LA58_1==124||LA58_1==128||(LA58_1 >= 135 && LA58_1 <= 136)) ) {
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
					// Pddl.g:403:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal299=(Token)match(input,69,FOLLOW_69_in_condEffect2547); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal299);

					string_literal300=(Token)match(input,109,FOLLOW_109_in_condEffect2549); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_109.add(string_literal300);

					// Pddl.g:403:14: ( pEffect )*
					loop57:
					while (true) {
						int alt57=2;
						int LA57_0 = input.LA(1);
						if ( (LA57_0==69) ) {
							alt57=1;
						}

						switch (alt57) {
						case 1 :
							// Pddl.g:403:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2551);
							pEffect301=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect301.getTree());
							}
							break;

						default :
							break loop57;
						}
					}

					char_literal302=(Token)match(input,70,FOLLOW_70_in_condEffect2554); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal302);

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
					// 403:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// Pddl.g:403:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:403:43: ( pEffect )*
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
					// Pddl.g:404:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2568);
					pEffect303=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect303.getTree());

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
	// Pddl.g:409:1: binaryOp : ( '*' | '+' | '-' | '/' | '^' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);
		int binaryOp_StartIndex = input.index();

		Object root_0 = null;

		Token set304=null;

		Object set304_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }

			// Pddl.g:409:10: ( '*' | '+' | '-' | '/' | '^' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set304=input.LT(1);
			if ( (input.LA(1) >= 71 && input.LA(1) <= 74)||input.LA(1)==104 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set304));
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
	// Pddl.g:411:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);
		int multiOp_StartIndex = input.index();

		Object root_0 = null;

		Token set305=null;

		Object set305_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }

			// Pddl.g:411:9: ( '*' | '+' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set305=input.LT(1);
			if ( (input.LA(1) >= 71 && input.LA(1) <= 72) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set305));
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
	// Pddl.g:413:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);
		int binaryComp_StartIndex = input.index();

		Object root_0 = null;

		Token set306=null;

		Object set306_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }

			// Pddl.g:413:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set306=input.LT(1);
			if ( (input.LA(1) >= 98 && input.LA(1) <= 102) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set306));
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
	// Pddl.g:415:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);
		int assignOp_StartIndex = input.index();

		Object root_0 = null;

		Token set307=null;

		Object set307_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }

			// Pddl.g:415:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set307=input.LT(1);
			if ( input.LA(1)==110||input.LA(1)==114||input.LA(1)==124||(input.LA(1) >= 135 && input.LA(1) <= 136) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set307));
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
	// Pddl.g:420:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);
		int durationConstraint_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal308=null;
		Token string_literal309=null;
		Token char_literal311=null;
		Token char_literal312=null;
		Token char_literal313=null;
		ParserRuleReturnScope simpleDurationConstraint310 =null;
		ParserRuleReturnScope simpleDurationConstraint314 =null;

		Object char_literal308_tree=null;
		Object string_literal309_tree=null;
		Object char_literal311_tree=null;
		Object char_literal312_tree=null;
		Object char_literal313_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }

			// Pddl.g:421:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt60=3;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==69) ) {
				switch ( input.LA(2) ) {
				case 109:
					{
					alt60=1;
					}
					break;
				case 70:
					{
					alt60=2;
					}
					break;
				case 99:
				case 100:
				case 102:
				case 111:
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
					// Pddl.g:421:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal308=(Token)match(input,69,FOLLOW_69_in_durationConstraint2673); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal308_tree = (Object)adaptor.create(char_literal308);
					adaptor.addChild(root_0, char_literal308_tree);
					}

					string_literal309=(Token)match(input,109,FOLLOW_109_in_durationConstraint2675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal309_tree = (Object)adaptor.create(string_literal309);
					adaptor.addChild(root_0, string_literal309_tree);
					}

					// Pddl.g:421:14: ( simpleDurationConstraint )+
					int cnt59=0;
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( (LA59_0==69) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// Pddl.g:421:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2677);
							simpleDurationConstraint310=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint310.getTree());

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

					char_literal311=(Token)match(input,70,FOLLOW_70_in_durationConstraint2680); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal311_tree = (Object)adaptor.create(char_literal311);
					adaptor.addChild(root_0, char_literal311_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:422:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal312=(Token)match(input,69,FOLLOW_69_in_durationConstraint2685); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal312_tree = (Object)adaptor.create(char_literal312);
					adaptor.addChild(root_0, char_literal312_tree);
					}

					char_literal313=(Token)match(input,70,FOLLOW_70_in_durationConstraint2687); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal313_tree = (Object)adaptor.create(char_literal313);
					adaptor.addChild(root_0, char_literal313_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:423:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2692);
					simpleDurationConstraint314=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint314.getTree());

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
	// Pddl.g:426:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);
		int simpleDurationConstraint_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal315=null;
		Token string_literal317=null;
		Token char_literal319=null;
		Token char_literal320=null;
		Token string_literal321=null;
		Token char_literal324=null;
		ParserRuleReturnScope durOp316 =null;
		ParserRuleReturnScope durValue318 =null;
		ParserRuleReturnScope timeSpecifier322 =null;
		ParserRuleReturnScope simpleDurationConstraint323 =null;

		Object char_literal315_tree=null;
		Object string_literal317_tree=null;
		Object char_literal319_tree=null;
		Object char_literal320_tree=null;
		Object string_literal321_tree=null;
		Object char_literal324_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }

			// Pddl.g:427:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==69) ) {
				int LA61_1 = input.LA(2);
				if ( (LA61_1==111) ) {
					alt61=2;
				}
				else if ( ((LA61_1 >= 99 && LA61_1 <= 100)||LA61_1==102) ) {
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
					// Pddl.g:427:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal315=(Token)match(input,69,FOLLOW_69_in_simpleDurationConstraint2703); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal315_tree = (Object)adaptor.create(char_literal315);
					adaptor.addChild(root_0, char_literal315_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2705);
					durOp316=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp316.getTree());

					string_literal317=(Token)match(input,103,FOLLOW_103_in_simpleDurationConstraint2707); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal317_tree = (Object)adaptor.create(string_literal317);
					adaptor.addChild(root_0, string_literal317_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2709);
					durValue318=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue318.getTree());

					char_literal319=(Token)match(input,70,FOLLOW_70_in_simpleDurationConstraint2711); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal319_tree = (Object)adaptor.create(char_literal319);
					adaptor.addChild(root_0, char_literal319_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:428:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal320=(Token)match(input,69,FOLLOW_69_in_simpleDurationConstraint2716); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal320_tree = (Object)adaptor.create(char_literal320);
					adaptor.addChild(root_0, char_literal320_tree);
					}

					string_literal321=(Token)match(input,111,FOLLOW_111_in_simpleDurationConstraint2718); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal321_tree = (Object)adaptor.create(string_literal321);
					adaptor.addChild(root_0, string_literal321_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2720);
					timeSpecifier322=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier322.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2722);
					simpleDurationConstraint323=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint323.getTree());

					char_literal324=(Token)match(input,70,FOLLOW_70_in_simpleDurationConstraint2724); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal324_tree = (Object)adaptor.create(char_literal324);
					adaptor.addChild(root_0, char_literal324_tree);
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
	// Pddl.g:431:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);
		int durOp_StartIndex = input.index();

		Object root_0 = null;

		Token set325=null;

		Object set325_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }

			// Pddl.g:431:7: ( '<=' | '>=' | '=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set325=input.LT(1);
			if ( (input.LA(1) >= 99 && input.LA(1) <= 100)||input.LA(1)==102 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set325));
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
	// Pddl.g:433:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);
		int durValue_StartIndex = input.index();

		Object root_0 = null;

		Token NUMBER326=null;
		ParserRuleReturnScope fExp327 =null;

		Object NUMBER326_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }

			// Pddl.g:433:10: ( NUMBER | fExp )
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==NUMBER) ) {
				int LA62_1 = input.LA(2);
				if ( (synpred102_Pddl()) ) {
					alt62=1;
				}
				else if ( (true) ) {
					alt62=2;
				}

			}
			else if ( (LA62_0==NAME||(LA62_0 >= 68 && LA62_0 <= 69)) ) {
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
					// Pddl.g:433:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER326=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2751); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER326_tree = (Object)adaptor.create(NUMBER326);
					adaptor.addChild(root_0, NUMBER326_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:433:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2755);
					fExp327=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp327.getTree());

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
	// Pddl.g:435:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);
		int daEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal328=null;
		Token string_literal329=null;
		Token char_literal331=null;
		Token char_literal333=null;
		Token string_literal334=null;
		Token char_literal335=null;
		Token char_literal337=null;
		Token char_literal339=null;
		Token char_literal340=null;
		Token string_literal341=null;
		Token char_literal344=null;
		Token char_literal345=null;
		Token char_literal349=null;
		ParserRuleReturnScope daEffect330 =null;
		ParserRuleReturnScope timedEffect332 =null;
		ParserRuleReturnScope typedVariableList336 =null;
		ParserRuleReturnScope daEffect338 =null;
		ParserRuleReturnScope daGD342 =null;
		ParserRuleReturnScope timedEffect343 =null;
		ParserRuleReturnScope assignOp346 =null;
		ParserRuleReturnScope fHead347 =null;
		ParserRuleReturnScope fExpDA348 =null;

		Object char_literal328_tree=null;
		Object string_literal329_tree=null;
		Object char_literal331_tree=null;
		Object char_literal333_tree=null;
		Object string_literal334_tree=null;
		Object char_literal335_tree=null;
		Object char_literal337_tree=null;
		Object char_literal339_tree=null;
		Object char_literal340_tree=null;
		Object string_literal341_tree=null;
		Object char_literal344_tree=null;
		Object char_literal345_tree=null;
		Object char_literal349_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }

			// Pddl.g:436:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt64=5;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==69) ) {
				int LA64_1 = input.LA(2);
				if ( (synpred104_Pddl()) ) {
					alt64=1;
				}
				else if ( (synpred105_Pddl()) ) {
					alt64=2;
				}
				else if ( (synpred106_Pddl()) ) {
					alt64=3;
				}
				else if ( (synpred107_Pddl()) ) {
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
					// Pddl.g:436:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal328=(Token)match(input,69,FOLLOW_69_in_daEffect2765); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal328_tree = (Object)adaptor.create(char_literal328);
					adaptor.addChild(root_0, char_literal328_tree);
					}

					string_literal329=(Token)match(input,109,FOLLOW_109_in_daEffect2767); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal329_tree = (Object)adaptor.create(string_literal329);
					adaptor.addChild(root_0, string_literal329_tree);
					}

					// Pddl.g:436:14: ( daEffect )*
					loop63:
					while (true) {
						int alt63=2;
						int LA63_0 = input.LA(1);
						if ( (LA63_0==69) ) {
							alt63=1;
						}

						switch (alt63) {
						case 1 :
							// Pddl.g:436:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2769);
							daEffect330=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect330.getTree());

							}
							break;

						default :
							break loop63;
						}
					}

					char_literal331=(Token)match(input,70,FOLLOW_70_in_daEffect2772); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal331_tree = (Object)adaptor.create(char_literal331);
					adaptor.addChild(root_0, char_literal331_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:437:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2777);
					timedEffect332=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect332.getTree());

					}
					break;
				case 3 :
					// Pddl.g:438:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal333=(Token)match(input,69,FOLLOW_69_in_daEffect2782); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal333_tree = (Object)adaptor.create(char_literal333);
					adaptor.addChild(root_0, char_literal333_tree);
					}

					string_literal334=(Token)match(input,120,FOLLOW_120_in_daEffect2784); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal334_tree = (Object)adaptor.create(string_literal334);
					adaptor.addChild(root_0, string_literal334_tree);
					}

					char_literal335=(Token)match(input,69,FOLLOW_69_in_daEffect2786); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal335_tree = (Object)adaptor.create(char_literal335);
					adaptor.addChild(root_0, char_literal335_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2788);
					typedVariableList336=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList336.getTree());

					char_literal337=(Token)match(input,70,FOLLOW_70_in_daEffect2790); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal337_tree = (Object)adaptor.create(char_literal337);
					adaptor.addChild(root_0, char_literal337_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2792);
					daEffect338=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect338.getTree());

					char_literal339=(Token)match(input,70,FOLLOW_70_in_daEffect2794); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal339_tree = (Object)adaptor.create(char_literal339);
					adaptor.addChild(root_0, char_literal339_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:439:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal340=(Token)match(input,69,FOLLOW_69_in_daEffect2799); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal340_tree = (Object)adaptor.create(char_literal340);
					adaptor.addChild(root_0, char_literal340_tree);
					}

					string_literal341=(Token)match(input,143,FOLLOW_143_in_daEffect2801); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal341_tree = (Object)adaptor.create(string_literal341);
					adaptor.addChild(root_0, string_literal341_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2803);
					daGD342=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD342.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2805);
					timedEffect343=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect343.getTree());

					char_literal344=(Token)match(input,70,FOLLOW_70_in_daEffect2807); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal344_tree = (Object)adaptor.create(char_literal344);
					adaptor.addChild(root_0, char_literal344_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:440:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal345=(Token)match(input,69,FOLLOW_69_in_daEffect2812); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal345_tree = (Object)adaptor.create(char_literal345);
					adaptor.addChild(root_0, char_literal345_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2814);
					assignOp346=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp346.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2816);
					fHead347=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead347.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2818);
					fExpDA348=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA348.getTree());

					char_literal349=(Token)match(input,70,FOLLOW_70_in_daEffect2820); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal349_tree = (Object)adaptor.create(char_literal349);
					adaptor.addChild(root_0, char_literal349_tree);
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
	// Pddl.g:443:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);
		int timedEffect_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal350=null;
		Token string_literal351=null;
		Token char_literal354=null;
		Token char_literal355=null;
		Token string_literal356=null;
		Token char_literal359=null;
		Token char_literal360=null;
		Token char_literal364=null;
		ParserRuleReturnScope timeSpecifier352 =null;
		ParserRuleReturnScope daEffect353 =null;
		ParserRuleReturnScope timeSpecifier357 =null;
		ParserRuleReturnScope fAssignDA358 =null;
		ParserRuleReturnScope assignOp361 =null;
		ParserRuleReturnScope fHead362 =null;
		ParserRuleReturnScope fExp363 =null;

		Object char_literal350_tree=null;
		Object string_literal351_tree=null;
		Object char_literal354_tree=null;
		Object char_literal355_tree=null;
		Object string_literal356_tree=null;
		Object char_literal359_tree=null;
		Object char_literal360_tree=null;
		Object char_literal364_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }

			// Pddl.g:444:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt65=3;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==69) ) {
				int LA65_1 = input.LA(2);
				if ( (synpred108_Pddl()) ) {
					alt65=1;
				}
				else if ( (synpred109_Pddl()) ) {
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
					// Pddl.g:444:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal350=(Token)match(input,69,FOLLOW_69_in_timedEffect2831); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal350_tree = (Object)adaptor.create(char_literal350);
					adaptor.addChild(root_0, char_literal350_tree);
					}

					string_literal351=(Token)match(input,111,FOLLOW_111_in_timedEffect2833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal351_tree = (Object)adaptor.create(string_literal351);
					adaptor.addChild(root_0, string_literal351_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2835);
					timeSpecifier352=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier352.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2837);
					daEffect353=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect353.getTree());

					char_literal354=(Token)match(input,70,FOLLOW_70_in_timedEffect2839); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal354_tree = (Object)adaptor.create(char_literal354);
					adaptor.addChild(root_0, char_literal354_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:445:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal355=(Token)match(input,69,FOLLOW_69_in_timedEffect2849); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal355_tree = (Object)adaptor.create(char_literal355);
					adaptor.addChild(root_0, char_literal355_tree);
					}

					string_literal356=(Token)match(input,111,FOLLOW_111_in_timedEffect2851); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal356_tree = (Object)adaptor.create(string_literal356);
					adaptor.addChild(root_0, string_literal356_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2853);
					timeSpecifier357=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier357.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2855);
					fAssignDA358=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA358.getTree());

					char_literal359=(Token)match(input,70,FOLLOW_70_in_timedEffect2857); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal359_tree = (Object)adaptor.create(char_literal359);
					adaptor.addChild(root_0, char_literal359_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:446:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal360=(Token)match(input,69,FOLLOW_69_in_timedEffect2862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal360_tree = (Object)adaptor.create(char_literal360);
					adaptor.addChild(root_0, char_literal360_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2864);
					assignOp361=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp361.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2866);
					fHead362=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead362.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2868);
					fExp363=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp363.getTree());

					char_literal364=(Token)match(input,70,FOLLOW_70_in_timedEffect2870); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal364_tree = (Object)adaptor.create(char_literal364);
					adaptor.addChild(root_0, char_literal364_tree);
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
	// Pddl.g:449:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);
		int fAssignDA_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal365=null;
		Token char_literal369=null;
		ParserRuleReturnScope assignOp366 =null;
		ParserRuleReturnScope fHead367 =null;
		ParserRuleReturnScope fExpDA368 =null;

		Object char_literal365_tree=null;
		Object char_literal369_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }

			// Pddl.g:450:2: ( '(' assignOp fHead fExpDA ')' )
			// Pddl.g:450:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal365=(Token)match(input,69,FOLLOW_69_in_fAssignDA2890); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal365_tree = (Object)adaptor.create(char_literal365);
			adaptor.addChild(root_0, char_literal365_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2892);
			assignOp366=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp366.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2894);
			fHead367=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead367.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2896);
			fExpDA368=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA368.getTree());

			char_literal369=(Token)match(input,70,FOLLOW_70_in_fAssignDA2898); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal369_tree = (Object)adaptor.create(char_literal369);
			adaptor.addChild(root_0, char_literal369_tree);
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
	// Pddl.g:453:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);
		int fExpDA_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal370=null;
		Token char_literal374=null;
		Token char_literal376=null;
		Token string_literal377=null;
		ParserRuleReturnScope binaryOp371 =null;
		ParserRuleReturnScope fExpDA372 =null;
		ParserRuleReturnScope fExpDA373 =null;
		ParserRuleReturnScope fExpDA375 =null;
		ParserRuleReturnScope fExp378 =null;

		Object char_literal370_tree=null;
		Object char_literal374_tree=null;
		Object char_literal376_tree=null;
		Object string_literal377_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }

			// Pddl.g:454:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt67=3;
			switch ( input.LA(1) ) {
			case 69:
				{
				int LA67_1 = input.LA(2);
				if ( (synpred111_Pddl()) ) {
					alt67=1;
				}
				else if ( (true) ) {
					alt67=3;
				}

				}
				break;
			case 103:
				{
				alt67=2;
				}
				break;
			case NAME:
			case NUMBER:
			case 68:
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
					// Pddl.g:454:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal370=(Token)match(input,69,FOLLOW_69_in_fExpDA2909); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal370_tree = (Object)adaptor.create(char_literal370);
					adaptor.addChild(root_0, char_literal370_tree);
					}

					// Pddl.g:454:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt66=2;
					int LA66_0 = input.LA(1);
					if ( (LA66_0==73) ) {
						int LA66_1 = input.LA(2);
						if ( (synpred110_Pddl()) ) {
							alt66=1;
						}
						else if ( (true) ) {
							alt66=2;
						}

					}
					else if ( ((LA66_0 >= 71 && LA66_0 <= 72)||LA66_0==74||LA66_0==104) ) {
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
							// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
							{
							// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
							// Pddl.g:454:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2913);
							binaryOp371=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp371.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2915);
							fExpDA372=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA372.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2917);
							fExpDA373=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA373.getTree());

							}

							}
							break;
						case 2 :
							// Pddl.g:454:36: ( '-' fExpDA )
							{
							// Pddl.g:454:36: ( '-' fExpDA )
							// Pddl.g:454:37: '-' fExpDA
							{
							char_literal374=(Token)match(input,73,FOLLOW_73_in_fExpDA2923); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal374_tree = (Object)adaptor.create(char_literal374);
							adaptor.addChild(root_0, char_literal374_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2925);
							fExpDA375=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA375.getTree());

							}

							}
							break;

					}

					char_literal376=(Token)match(input,70,FOLLOW_70_in_fExpDA2929); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal376_tree = (Object)adaptor.create(char_literal376);
					adaptor.addChild(root_0, char_literal376_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:455:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal377=(Token)match(input,103,FOLLOW_103_in_fExpDA2934); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal377_tree = (Object)adaptor.create(string_literal377);
					adaptor.addChild(root_0, string_literal377_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:456:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA2939);
					fExp378=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp378.getTree());

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
	// Pddl.g:461:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);
		int problem_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal379=null;
		Token string_literal380=null;
		Token char_literal389=null;
		ParserRuleReturnScope problemDecl381 =null;
		ParserRuleReturnScope problemDomain382 =null;
		ParserRuleReturnScope requireDef383 =null;
		ParserRuleReturnScope objectDecl384 =null;
		ParserRuleReturnScope init385 =null;
		ParserRuleReturnScope goal386 =null;
		ParserRuleReturnScope probConstraints387 =null;
		ParserRuleReturnScope metricSpec388 =null;

		Object char_literal379_tree=null;
		Object string_literal380_tree=null;
		Object char_literal389_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
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

			// Pddl.g:462:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// Pddl.g:462:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal379=(Token)match(input,69,FOLLOW_69_in_problem2953); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal379);

			string_literal380=(Token)match(input,115,FOLLOW_115_in_problem2955); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_115.add(string_literal380);

			pushFollow(FOLLOW_problemDecl_in_problem2957);
			problemDecl381=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl381.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem2962);
			problemDomain382=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain382.getTree());
			// Pddl.g:464:7: ( requireDef )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==69) ) {
				int LA68_1 = input.LA(2);
				if ( (LA68_1==96) ) {
					alt68=1;
				}
			}
			switch (alt68) {
				case 1 :
					// Pddl.g:464:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem2970);
					requireDef383=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef383.getTree());
					}
					break;

			}

			// Pddl.g:465:7: ( objectDecl )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==69) ) {
				int LA69_1 = input.LA(2);
				if ( (LA69_1==91) ) {
					alt69=1;
				}
			}
			switch (alt69) {
				case 1 :
					// Pddl.g:465:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem2979);
					objectDecl384=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl384.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem2988);
			init385=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init385.getTree());
			pushFollow(FOLLOW_goal_in_problem2996);
			goal386=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal386.getTree());
			// Pddl.g:468:7: ( probConstraints )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==69) ) {
				int LA70_1 = input.LA(2);
				if ( (LA70_1==79) ) {
					alt70=1;
				}
			}
			switch (alt70) {
				case 1 :
					// Pddl.g:468:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem3004);
					probConstraints387=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints387.getTree());
					}
					break;

			}

			// Pddl.g:469:7: ( metricSpec )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==69) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// Pddl.g:469:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem3013);
					metricSpec388=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec388.getTree());
					}
					break;

			}

			char_literal389=(Token)match(input,70,FOLLOW_70_in_problem3029); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal389);

			// AST REWRITE
			// elements: probConstraints, problemDecl, objectDecl, init, metricSpec, goal, problemDomain, requireDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 472:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// Pddl.g:472:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// Pddl.g:472:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:472:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// Pddl.g:473:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// Pddl.g:473:36: ( metricSpec )?
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
	// Pddl.g:476:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);
		int problemDecl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal390=null;
		Token string_literal391=null;
		Token NAME392=null;
		Token char_literal393=null;

		Object char_literal390_tree=null;
		Object string_literal391_tree=null;
		Object NAME392_tree=null;
		Object char_literal393_tree=null;
		RewriteRuleTokenStream stream_134=new RewriteRuleTokenStream(adaptor,"token 134");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }

			// Pddl.g:477:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// Pddl.g:477:7: '(' 'problem' NAME ')'
			{
			char_literal390=(Token)match(input,69,FOLLOW_69_in_problemDecl3086); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal390);

			string_literal391=(Token)match(input,134,FOLLOW_134_in_problemDecl3088); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_134.add(string_literal391);

			NAME392=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl3090); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME392);

			char_literal393=(Token)match(input,70,FOLLOW_70_in_problemDecl3092); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal393);

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
			// 478:5: -> ^( PROBLEM_NAME NAME )
			{
				// Pddl.g:478:8: ^( PROBLEM_NAME NAME )
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
	// Pddl.g:481:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);
		int problemDomain_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal394=null;
		Token string_literal395=null;
		Token NAME396=null;
		Token char_literal397=null;

		Object char_literal394_tree=null;
		Object string_literal395_tree=null;
		Object NAME396_tree=null;
		Object char_literal397_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }

			// Pddl.g:482:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// Pddl.g:482:4: '(' ':domain' NAME ')'
			{
			char_literal394=(Token)match(input,69,FOLLOW_69_in_problemDomain3118); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal394);

			string_literal395=(Token)match(input,81,FOLLOW_81_in_problemDomain3120); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal395);

			NAME396=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain3122); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME396);

			char_literal397=(Token)match(input,70,FOLLOW_70_in_problemDomain3124); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal397);

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
			// 483:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// Pddl.g:483:5: ^( PROBLEM_DOMAIN NAME )
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
	// Pddl.g:486:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);
		int objectDecl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal398=null;
		Token string_literal399=null;
		Token char_literal401=null;
		ParserRuleReturnScope typedNameList400 =null;

		Object char_literal398_tree=null;
		Object string_literal399_tree=null;
		Object char_literal401_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }

			// Pddl.g:487:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// Pddl.g:487:4: '(' ':objects' typedNameList ')'
			{
			char_literal398=(Token)match(input,69,FOLLOW_69_in_objectDecl3144); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal398);

			string_literal399=(Token)match(input,91,FOLLOW_91_in_objectDecl3146); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_91.add(string_literal399);

			pushFollow(FOLLOW_typedNameList_in_objectDecl3148);
			typedNameList400=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList400.getTree());
			char_literal401=(Token)match(input,70,FOLLOW_70_in_objectDecl3150); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal401);

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
			// 488:2: -> ^( OBJECTS typedNameList )
			{
				// Pddl.g:488:5: ^( OBJECTS typedNameList )
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
	// Pddl.g:491:1: init : ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) );
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);
		int init_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal402=null;
		Token string_literal403=null;
		Token char_literal405=null;
		Token char_literal406=null;
		Token string_literal407=null;
		Token char_literal409=null;
		ParserRuleReturnScope initEl404 =null;
		ParserRuleReturnScope belief408 =null;

		Object char_literal402_tree=null;
		Object string_literal403_tree=null;
		Object char_literal405_tree=null;
		Object char_literal406_tree=null;
		Object string_literal407_tree=null;
		Object char_literal409_tree=null;
		RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");
		RewriteRuleSubtreeStream stream_belief=new RewriteRuleSubtreeStream(adaptor,"rule belief");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }

			// Pddl.g:492:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) )
			int alt73=2;
			alt73 = dfa73.predict(input);
			switch (alt73) {
				case 1 :
					// Pddl.g:492:4: '(' ':init' ( initEl )* ')'
					{
					char_literal402=(Token)match(input,69,FOLLOW_69_in_init3170); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal402);

					string_literal403=(Token)match(input,89,FOLLOW_89_in_init3172); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_89.add(string_literal403);

					// Pddl.g:492:16: ( initEl )*
					loop72:
					while (true) {
						int alt72=2;
						int LA72_0 = input.LA(1);
						if ( (LA72_0==69) ) {
							alt72=1;
						}

						switch (alt72) {
						case 1 :
							// Pddl.g:492:16: initEl
							{
							pushFollow(FOLLOW_initEl_in_init3174);
							initEl404=initEl();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_initEl.add(initEl404.getTree());
							}
							break;

						default :
							break loop72;
						}
					}

					char_literal405=(Token)match(input,70,FOLLOW_70_in_init3177); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal405);

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
					// 493:2: -> ^( INIT ( initEl )* )
					{
						// Pddl.g:493:5: ^( INIT ( initEl )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
						// Pddl.g:493:12: ( initEl )*
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
					// Pddl.g:494:4: '(' ':init' belief ')'
					{
					char_literal406=(Token)match(input,69,FOLLOW_69_in_init3192); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal406);

					string_literal407=(Token)match(input,89,FOLLOW_89_in_init3194); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_89.add(string_literal407);

					pushFollow(FOLLOW_belief_in_init3196);
					belief408=belief();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_belief.add(belief408.getTree());
					char_literal409=(Token)match(input,70,FOLLOW_70_in_init3198); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal409);

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
					// 494:27: -> ^( FORMULAINIT belief )
					{
						// Pddl.g:494:30: ^( FORMULAINIT belief )
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
	// Pddl.g:497:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'unknown' atomicNameFormula ')' -> ^( UNKNOWN atomicNameFormula ) | '(' 'oneof' ( atomicNameFormula )* ')' -> ^( ONEOF ( atomicNameFormula )* ) | '(' 'or' ( nameLiteral )* ')' -> ^( OR_GD ( nameLiteral )* ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);
		int initEl_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal411=null;
		Token char_literal412=null;
		Token NUMBER414=null;
		Token char_literal415=null;
		Token char_literal416=null;
		Token string_literal417=null;
		Token char_literal419=null;
		Token char_literal420=null;
		Token string_literal421=null;
		Token char_literal423=null;
		Token char_literal424=null;
		Token string_literal425=null;
		Token char_literal427=null;
		ParserRuleReturnScope nameLiteral410 =null;
		ParserRuleReturnScope fHead413 =null;
		ParserRuleReturnScope atomicNameFormula418 =null;
		ParserRuleReturnScope atomicNameFormula422 =null;
		ParserRuleReturnScope nameLiteral426 =null;

		Object char_literal411_tree=null;
		Object char_literal412_tree=null;
		Object NUMBER414_tree=null;
		Object char_literal415_tree=null;
		Object char_literal416_tree=null;
		Object string_literal417_tree=null;
		Object char_literal419_tree=null;
		Object char_literal420_tree=null;
		Object string_literal421_tree=null;
		Object char_literal423_tree=null;
		Object char_literal424_tree=null;
		Object string_literal425_tree=null;
		Object char_literal427_tree=null;
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
		RewriteRuleTokenStream stream_142=new RewriteRuleTokenStream(adaptor,"token 142");
		RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }

			// Pddl.g:498:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'unknown' atomicNameFormula ')' -> ^( UNKNOWN atomicNameFormula ) | '(' 'oneof' ( atomicNameFormula )* ')' -> ^( ONEOF ( atomicNameFormula )* ) | '(' 'or' ( nameLiteral )* ')' -> ^( OR_GD ( nameLiteral )* ) )
			int alt76=5;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==69) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 128:
					{
					alt76=1;
					}
					break;
				case 100:
					{
					alt76=2;
					}
					break;
				case 142:
					{
					alt76=3;
					}
					break;
				case 130:
					{
					alt76=4;
					}
					break;
				case 131:
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
					// Pddl.g:498:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl3217);
					nameLiteral410=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral410.getTree());

					}
					break;
				case 2 :
					// Pddl.g:499:4: '(' '=' fHead NUMBER ')'
					{
					char_literal411=(Token)match(input,69,FOLLOW_69_in_initEl3222); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal411);

					char_literal412=(Token)match(input,100,FOLLOW_100_in_initEl3224); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_100.add(char_literal412);

					pushFollow(FOLLOW_fHead_in_initEl3226);
					fHead413=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead413.getTree());
					NUMBER414=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3228); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER414);

					char_literal415=(Token)match(input,70,FOLLOW_70_in_initEl3230); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal415);

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
					// 499:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// Pddl.g:499:40: ^( INIT_EQ fHead NUMBER )
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
					// Pddl.g:501:4: '(' 'unknown' atomicNameFormula ')'
					{
					char_literal416=(Token)match(input,69,FOLLOW_69_in_initEl3254); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal416);

					string_literal417=(Token)match(input,142,FOLLOW_142_in_initEl3256); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_142.add(string_literal417);

					pushFollow(FOLLOW_atomicNameFormula_in_initEl3259);
					atomicNameFormula418=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula418.getTree());
					char_literal419=(Token)match(input,70,FOLLOW_70_in_initEl3261); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal419);

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
					// 501:42: -> ^( UNKNOWN atomicNameFormula )
					{
						// Pddl.g:501:45: ^( UNKNOWN atomicNameFormula )
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
					// Pddl.g:502:4: '(' 'oneof' ( atomicNameFormula )* ')'
					{
					char_literal420=(Token)match(input,69,FOLLOW_69_in_initEl3275); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal420);

					string_literal421=(Token)match(input,130,FOLLOW_130_in_initEl3277); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_130.add(string_literal421);

					// Pddl.g:502:17: ( atomicNameFormula )*
					loop74:
					while (true) {
						int alt74=2;
						int LA74_0 = input.LA(1);
						if ( (LA74_0==69) ) {
							alt74=1;
						}

						switch (alt74) {
						case 1 :
							// Pddl.g:502:17: atomicNameFormula
							{
							pushFollow(FOLLOW_atomicNameFormula_in_initEl3280);
							atomicNameFormula422=atomicNameFormula();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula422.getTree());
							}
							break;

						default :
							break loop74;
						}
					}

					char_literal423=(Token)match(input,70,FOLLOW_70_in_initEl3283); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal423);

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
					// 502:41: -> ^( ONEOF ( atomicNameFormula )* )
					{
						// Pddl.g:502:44: ^( ONEOF ( atomicNameFormula )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ONEOF, "ONEOF"), root_1);
						// Pddl.g:502:52: ( atomicNameFormula )*
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
					// Pddl.g:503:4: '(' 'or' ( nameLiteral )* ')'
					{
					char_literal424=(Token)match(input,69,FOLLOW_69_in_initEl3298); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal424);

					string_literal425=(Token)match(input,131,FOLLOW_131_in_initEl3300); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_131.add(string_literal425);

					// Pddl.g:503:14: ( nameLiteral )*
					loop75:
					while (true) {
						int alt75=2;
						int LA75_0 = input.LA(1);
						if ( (LA75_0==69) ) {
							alt75=1;
						}

						switch (alt75) {
						case 1 :
							// Pddl.g:503:14: nameLiteral
							{
							pushFollow(FOLLOW_nameLiteral_in_initEl3303);
							nameLiteral426=nameLiteral();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral426.getTree());
							}
							break;

						default :
							break loop75;
						}
					}

					char_literal427=(Token)match(input,70,FOLLOW_70_in_initEl3306); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal427);

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
					// 503:32: -> ^( OR_GD ( nameLiteral )* )
					{
						// Pddl.g:503:35: ^( OR_GD ( nameLiteral )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:503:43: ( nameLiteral )*
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
	// Pddl.g:506:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);
		int nameLiteral_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal429=null;
		Token string_literal430=null;
		Token char_literal432=null;
		ParserRuleReturnScope atomicNameFormula428 =null;
		ParserRuleReturnScope atomicNameFormula431 =null;

		Object char_literal429_tree=null;
		Object string_literal430_tree=null;
		Object char_literal432_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }

			// Pddl.g:507:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==69) ) {
				int LA77_1 = input.LA(2);
				if ( (LA77_1==128) ) {
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
					// Pddl.g:507:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3327);
					atomicNameFormula428=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula428.getTree());

					}
					break;
				case 2 :
					// Pddl.g:508:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal429=(Token)match(input,69,FOLLOW_69_in_nameLiteral3332); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal429);

					string_literal430=(Token)match(input,128,FOLLOW_128_in_nameLiteral3334); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_128.add(string_literal430);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3336);
					atomicNameFormula431=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula431.getTree());
					char_literal432=(Token)match(input,70,FOLLOW_70_in_nameLiteral3338); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal432);

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
					// 508:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// Pddl.g:508:39: ^( NOT_PRED_INIT atomicNameFormula )
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
	// Pddl.g:511:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);
		int atomicNameFormula_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal433=null;
		Token NAME435=null;
		Token char_literal436=null;
		ParserRuleReturnScope predicate434 =null;

		Object char_literal433_tree=null;
		Object NAME435_tree=null;
		Object char_literal436_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }

			// Pddl.g:512:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// Pddl.g:512:4: '(' predicate ( NAME )* ')'
			{
			char_literal433=(Token)match(input,69,FOLLOW_69_in_atomicNameFormula3357); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal433);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula3359);
			predicate434=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate434.getTree());
			// Pddl.g:512:18: ( NAME )*
			loop78:
			while (true) {
				int alt78=2;
				int LA78_0 = input.LA(1);
				if ( (LA78_0==NAME) ) {
					alt78=1;
				}

				switch (alt78) {
				case 1 :
					// Pddl.g:512:18: NAME
					{
					NAME435=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula3361); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME435);

					}
					break;

				default :
					break loop78;
				}
			}

			char_literal436=(Token)match(input,70,FOLLOW_70_in_atomicNameFormula3364); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal436);

			// AST REWRITE
			// elements: NAME, predicate
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 512:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// Pddl.g:512:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:512:53: ( NAME )*
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
	// Pddl.g:519:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);
		int goal_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal437=null;
		Token string_literal438=null;
		Token char_literal440=null;
		ParserRuleReturnScope goalDesc439 =null;

		Object char_literal437_tree=null;
		Object string_literal438_tree=null;
		Object char_literal440_tree=null;
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }

			// Pddl.g:519:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// Pddl.g:519:8: '(' ':goal' goalDesc ')'
			{
			char_literal437=(Token)match(input,69,FOLLOW_69_in_goal3389); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal437);

			string_literal438=(Token)match(input,88,FOLLOW_88_in_goal3391); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_88.add(string_literal438);

			pushFollow(FOLLOW_goalDesc_in_goal3393);
			goalDesc439=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc439.getTree());
			char_literal440=(Token)match(input,70,FOLLOW_70_in_goal3396); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal440);

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
			// 519:34: -> ^( GOAL goalDesc )
			{
				// Pddl.g:519:37: ^( GOAL goalDesc )
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
	// Pddl.g:521:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);
		int probConstraints_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal441=null;
		Token string_literal442=null;
		Token char_literal444=null;
		ParserRuleReturnScope prefConGD443 =null;

		Object char_literal441_tree=null;
		Object string_literal442_tree=null;
		Object char_literal444_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }

			// Pddl.g:522:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// Pddl.g:522:4: '(' ':constraints' prefConGD ')'
			{
			char_literal441=(Token)match(input,69,FOLLOW_69_in_probConstraints3414); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal441);

			string_literal442=(Token)match(input,79,FOLLOW_79_in_probConstraints3416); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_79.add(string_literal442);

			pushFollow(FOLLOW_prefConGD_in_probConstraints3419);
			prefConGD443=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD443.getTree());
			char_literal444=(Token)match(input,70,FOLLOW_70_in_probConstraints3421); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal444);

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
			// 523:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// Pddl.g:523:7: ^( PROBLEM_CONSTRAINT prefConGD )
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
	// Pddl.g:526:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);
		int prefConGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal445=null;
		Token string_literal446=null;
		Token char_literal448=null;
		Token char_literal449=null;
		Token string_literal450=null;
		Token char_literal451=null;
		Token char_literal453=null;
		Token char_literal455=null;
		Token char_literal456=null;
		Token string_literal457=null;
		Token NAME458=null;
		Token char_literal460=null;
		ParserRuleReturnScope prefConGD447 =null;
		ParserRuleReturnScope typedVariableList452 =null;
		ParserRuleReturnScope prefConGD454 =null;
		ParserRuleReturnScope conGD459 =null;
		ParserRuleReturnScope conGD461 =null;

		Object char_literal445_tree=null;
		Object string_literal446_tree=null;
		Object char_literal448_tree=null;
		Object char_literal449_tree=null;
		Object string_literal450_tree=null;
		Object char_literal451_tree=null;
		Object char_literal453_tree=null;
		Object char_literal455_tree=null;
		Object char_literal456_tree=null;
		Object string_literal457_tree=null;
		Object NAME458_tree=null;
		Object char_literal460_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return retval; }

			// Pddl.g:527:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt81=4;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==69) ) {
				int LA81_1 = input.LA(2);
				if ( (synpred128_Pddl()) ) {
					alt81=1;
				}
				else if ( (synpred129_Pddl()) ) {
					alt81=2;
				}
				else if ( (synpred131_Pddl()) ) {
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
					// Pddl.g:527:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal445=(Token)match(input,69,FOLLOW_69_in_prefConGD3443); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal445_tree = (Object)adaptor.create(char_literal445);
					adaptor.addChild(root_0, char_literal445_tree);
					}

					string_literal446=(Token)match(input,109,FOLLOW_109_in_prefConGD3445); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal446_tree = (Object)adaptor.create(string_literal446);
					adaptor.addChild(root_0, string_literal446_tree);
					}

					// Pddl.g:527:14: ( prefConGD )*
					loop79:
					while (true) {
						int alt79=2;
						int LA79_0 = input.LA(1);
						if ( (LA79_0==69) ) {
							alt79=1;
						}

						switch (alt79) {
						case 1 :
							// Pddl.g:527:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD3447);
							prefConGD447=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD447.getTree());

							}
							break;

						default :
							break loop79;
						}
					}

					char_literal448=(Token)match(input,70,FOLLOW_70_in_prefConGD3450); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal448_tree = (Object)adaptor.create(char_literal448);
					adaptor.addChild(root_0, char_literal448_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:528:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal449=(Token)match(input,69,FOLLOW_69_in_prefConGD3455); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal449_tree = (Object)adaptor.create(char_literal449);
					adaptor.addChild(root_0, char_literal449_tree);
					}

					string_literal450=(Token)match(input,120,FOLLOW_120_in_prefConGD3457); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal450_tree = (Object)adaptor.create(string_literal450);
					adaptor.addChild(root_0, string_literal450_tree);
					}

					char_literal451=(Token)match(input,69,FOLLOW_69_in_prefConGD3459); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal451_tree = (Object)adaptor.create(char_literal451);
					adaptor.addChild(root_0, char_literal451_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD3461);
					typedVariableList452=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList452.getTree());

					char_literal453=(Token)match(input,70,FOLLOW_70_in_prefConGD3463); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal453_tree = (Object)adaptor.create(char_literal453);
					adaptor.addChild(root_0, char_literal453_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD3465);
					prefConGD454=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD454.getTree());

					char_literal455=(Token)match(input,70,FOLLOW_70_in_prefConGD3467); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal455_tree = (Object)adaptor.create(char_literal455);
					adaptor.addChild(root_0, char_literal455_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:529:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal456=(Token)match(input,69,FOLLOW_69_in_prefConGD3472); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal456_tree = (Object)adaptor.create(char_literal456);
					adaptor.addChild(root_0, char_literal456_tree);
					}

					string_literal457=(Token)match(input,133,FOLLOW_133_in_prefConGD3474); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal457_tree = (Object)adaptor.create(string_literal457);
					adaptor.addChild(root_0, string_literal457_tree);
					}

					// Pddl.g:529:21: ( NAME )?
					int alt80=2;
					int LA80_0 = input.LA(1);
					if ( (LA80_0==NAME) ) {
						alt80=1;
					}
					switch (alt80) {
						case 1 :
							// Pddl.g:529:21: NAME
							{
							NAME458=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3476); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME458_tree = (Object)adaptor.create(NAME458);
							adaptor.addChild(root_0, NAME458_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD3479);
					conGD459=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD459.getTree());

					char_literal460=(Token)match(input,70,FOLLOW_70_in_prefConGD3481); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal460_tree = (Object)adaptor.create(char_literal460);
					adaptor.addChild(root_0, char_literal460_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:530:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD3486);
					conGD461=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD461.getTree());

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
	// Pddl.g:533:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);
		int metricSpec_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal462=null;
		Token string_literal463=null;
		Token char_literal466=null;
		ParserRuleReturnScope optimization464 =null;
		ParserRuleReturnScope metricFExp465 =null;

		Object char_literal462_tree=null;
		Object string_literal463_tree=null;
		Object char_literal466_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return retval; }

			// Pddl.g:534:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// Pddl.g:534:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal462=(Token)match(input,69,FOLLOW_69_in_metricSpec3497); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(char_literal462);

			string_literal463=(Token)match(input,90,FOLLOW_90_in_metricSpec3499); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_90.add(string_literal463);

			pushFollow(FOLLOW_optimization_in_metricSpec3501);
			optimization464=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization464.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec3503);
			metricFExp465=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp465.getTree());
			char_literal466=(Token)match(input,70,FOLLOW_70_in_metricSpec3505); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(char_literal466);

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
			// 535:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// Pddl.g:535:7: ^( PROBLEM_METRIC optimization metricFExp )
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
	// Pddl.g:538:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);
		int optimization_StartIndex = input.index();

		Object root_0 = null;

		Token set467=null;

		Object set467_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return retval; }

			// Pddl.g:538:14: ( 'minimize' | 'maximize' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set467=input.LT(1);
			if ( (input.LA(1) >= 126 && input.LA(1) <= 127) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set467));
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
	// Pddl.g:540:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);
		int metricFExp_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal468=null;
		Token char_literal472=null;
		Token char_literal473=null;
		Token char_literal477=null;
		Token char_literal478=null;
		Token char_literal479=null;
		Token char_literal481=null;
		Token NUMBER482=null;
		Token char_literal484=null;
		Token string_literal485=null;
		Token NAME486=null;
		Token char_literal487=null;
		ParserRuleReturnScope binaryOp469 =null;
		ParserRuleReturnScope metricFExp470 =null;
		ParserRuleReturnScope metricFExp471 =null;
		ParserRuleReturnScope multiOp474 =null;
		ParserRuleReturnScope metricFExp475 =null;
		ParserRuleReturnScope metricFExp476 =null;
		ParserRuleReturnScope metricFExp480 =null;
		ParserRuleReturnScope fHead483 =null;

		Object char_literal468_tree=null;
		Object char_literal472_tree=null;
		Object char_literal473_tree=null;
		Object char_literal477_tree=null;
		Object char_literal478_tree=null;
		Object char_literal479_tree=null;
		Object char_literal481_tree=null;
		Object NUMBER482_tree=null;
		Object char_literal484_tree=null;
		Object string_literal485_tree=null;
		Object NAME486_tree=null;
		Object char_literal487_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return retval; }

			// Pddl.g:541:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt83=6;
			switch ( input.LA(1) ) {
			case 69:
				{
				int LA83_1 = input.LA(2);
				if ( (synpred133_Pddl()) ) {
					alt83=1;
				}
				else if ( (synpred135_Pddl()) ) {
					alt83=2;
				}
				else if ( (synpred136_Pddl()) ) {
					alt83=3;
				}
				else if ( (synpred138_Pddl()) ) {
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
			case 68:
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
					// Pddl.g:541:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal468=(Token)match(input,69,FOLLOW_69_in_metricFExp3542); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal468);

					pushFollow(FOLLOW_binaryOp_in_metricFExp3544);
					binaryOp469=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp469.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3546);
					metricFExp470=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp470.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3548);
					metricFExp471=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp471.getTree());
					char_literal472=(Token)match(input,70,FOLLOW_70_in_metricFExp3550); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal472);

					// AST REWRITE
					// elements: metricFExp, metricFExp, binaryOp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 542:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// Pddl.g:542:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
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
					// Pddl.g:543:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal473=(Token)match(input,69,FOLLOW_69_in_metricFExp3572); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal473);

					pushFollow(FOLLOW_multiOp_in_metricFExp3574);
					multiOp474=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp474.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3576);
					metricFExp475=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp475.getTree());
					// Pddl.g:543:27: ( metricFExp )+
					int cnt82=0;
					loop82:
					while (true) {
						int alt82=2;
						int LA82_0 = input.LA(1);
						if ( (LA82_0==NAME||LA82_0==NUMBER||(LA82_0 >= 68 && LA82_0 <= 69)) ) {
							alt82=1;
						}

						switch (alt82) {
						case 1 :
							// Pddl.g:543:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3578);
							metricFExp476=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp476.getTree());
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

					char_literal477=(Token)match(input,70,FOLLOW_70_in_metricFExp3581); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal477);

					// AST REWRITE
					// elements: metricFExp, multiOp, metricFExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 544:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// Pddl.g:544:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
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
					// Pddl.g:545:4: '(' '-' metricFExp ')'
					{
					char_literal478=(Token)match(input,69,FOLLOW_69_in_metricFExp3605); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(char_literal478);

					char_literal479=(Token)match(input,73,FOLLOW_73_in_metricFExp3607); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_73.add(char_literal479);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3609);
					metricFExp480=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp480.getTree());
					char_literal481=(Token)match(input,70,FOLLOW_70_in_metricFExp3611); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(char_literal481);

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
					// 546:4: -> ^( MINUS_OP metricFExp )
					{
						// Pddl.g:546:7: ^( MINUS_OP metricFExp )
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
					// Pddl.g:547:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER482=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3628); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER482_tree = (Object)adaptor.create(NUMBER482);
					adaptor.addChild(root_0, NUMBER482_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:548:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3633);
					fHead483=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead483.getTree());

					}
					break;
				case 6 :
					// Pddl.g:550:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal484=(Token)match(input,69,FOLLOW_69_in_metricFExp3648); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal484_tree = (Object)adaptor.create(char_literal484);
					adaptor.addChild(root_0, char_literal484_tree);
					}

					string_literal485=(Token)match(input,125,FOLLOW_125_in_metricFExp3650); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal485_tree = (Object)adaptor.create(string_literal485);
					adaptor.addChild(root_0, string_literal485_tree);
					}

					NAME486=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3652); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME486_tree = (Object)adaptor.create(NAME486);
					adaptor.addChild(root_0, NAME486_tree);
					}

					char_literal487=(Token)match(input,70,FOLLOW_70_in_metricFExp3654); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal487_tree = (Object)adaptor.create(char_literal487);
					adaptor.addChild(root_0, char_literal487_tree);
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
	// Pddl.g:555:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);
		int conGD_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal488=null;
		Token string_literal489=null;
		Token char_literal491=null;
		Token char_literal492=null;
		Token string_literal493=null;
		Token char_literal494=null;
		Token char_literal496=null;
		Token char_literal498=null;
		Token char_literal499=null;
		Token string_literal500=null;
		Token string_literal501=null;
		Token char_literal503=null;
		Token char_literal504=null;
		Token string_literal505=null;
		Token char_literal507=null;
		Token char_literal508=null;
		Token string_literal509=null;
		Token char_literal511=null;
		Token char_literal512=null;
		Token string_literal513=null;
		Token NUMBER514=null;
		Token char_literal516=null;
		Token char_literal517=null;
		Token string_literal518=null;
		Token char_literal520=null;
		Token char_literal521=null;
		Token string_literal522=null;
		Token char_literal525=null;
		Token char_literal526=null;
		Token string_literal527=null;
		Token char_literal530=null;
		Token char_literal531=null;
		Token string_literal532=null;
		Token NUMBER533=null;
		Token char_literal536=null;
		Token char_literal537=null;
		Token string_literal538=null;
		Token NUMBER539=null;
		Token NUMBER540=null;
		Token char_literal542=null;
		Token char_literal543=null;
		Token string_literal544=null;
		Token NUMBER545=null;
		Token char_literal547=null;
		ParserRuleReturnScope conGD490 =null;
		ParserRuleReturnScope typedVariableList495 =null;
		ParserRuleReturnScope conGD497 =null;
		ParserRuleReturnScope goalDesc502 =null;
		ParserRuleReturnScope goalDesc506 =null;
		ParserRuleReturnScope goalDesc510 =null;
		ParserRuleReturnScope goalDesc515 =null;
		ParserRuleReturnScope goalDesc519 =null;
		ParserRuleReturnScope goalDesc523 =null;
		ParserRuleReturnScope goalDesc524 =null;
		ParserRuleReturnScope goalDesc528 =null;
		ParserRuleReturnScope goalDesc529 =null;
		ParserRuleReturnScope goalDesc534 =null;
		ParserRuleReturnScope goalDesc535 =null;
		ParserRuleReturnScope goalDesc541 =null;
		ParserRuleReturnScope goalDesc546 =null;

		Object char_literal488_tree=null;
		Object string_literal489_tree=null;
		Object char_literal491_tree=null;
		Object char_literal492_tree=null;
		Object string_literal493_tree=null;
		Object char_literal494_tree=null;
		Object char_literal496_tree=null;
		Object char_literal498_tree=null;
		Object char_literal499_tree=null;
		Object string_literal500_tree=null;
		Object string_literal501_tree=null;
		Object char_literal503_tree=null;
		Object char_literal504_tree=null;
		Object string_literal505_tree=null;
		Object char_literal507_tree=null;
		Object char_literal508_tree=null;
		Object string_literal509_tree=null;
		Object char_literal511_tree=null;
		Object char_literal512_tree=null;
		Object string_literal513_tree=null;
		Object NUMBER514_tree=null;
		Object char_literal516_tree=null;
		Object char_literal517_tree=null;
		Object string_literal518_tree=null;
		Object char_literal520_tree=null;
		Object char_literal521_tree=null;
		Object string_literal522_tree=null;
		Object char_literal525_tree=null;
		Object char_literal526_tree=null;
		Object string_literal527_tree=null;
		Object char_literal530_tree=null;
		Object char_literal531_tree=null;
		Object string_literal532_tree=null;
		Object NUMBER533_tree=null;
		Object char_literal536_tree=null;
		Object char_literal537_tree=null;
		Object string_literal538_tree=null;
		Object NUMBER539_tree=null;
		Object NUMBER540_tree=null;
		Object char_literal542_tree=null;
		Object char_literal543_tree=null;
		Object string_literal544_tree=null;
		Object NUMBER545_tree=null;
		Object char_literal547_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return retval; }

			// Pddl.g:556:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt85=12;
			int LA85_0 = input.LA(1);
			if ( (LA85_0==69) ) {
				switch ( input.LA(2) ) {
				case 109:
					{
					alt85=1;
					}
					break;
				case 120:
					{
					alt85=2;
					}
					break;
				case 111:
					{
					alt85=3;
					}
					break;
				case 107:
					{
					alt85=4;
					}
					break;
				case 138:
					{
					alt85=5;
					}
					break;
				case 144:
					{
					alt85=6;
					}
					break;
				case 112:
					{
					alt85=7;
					}
					break;
				case 139:
					{
					alt85=8;
					}
					break;
				case 140:
					{
					alt85=9;
					}
					break;
				case 108:
					{
					alt85=10;
					}
					break;
				case 122:
					{
					alt85=11;
					}
					break;
				case 121:
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
					// Pddl.g:556:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal488=(Token)match(input,69,FOLLOW_69_in_conGD3668); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal488_tree = (Object)adaptor.create(char_literal488);
					adaptor.addChild(root_0, char_literal488_tree);
					}

					string_literal489=(Token)match(input,109,FOLLOW_109_in_conGD3670); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal489_tree = (Object)adaptor.create(string_literal489);
					adaptor.addChild(root_0, string_literal489_tree);
					}

					// Pddl.g:556:14: ( conGD )*
					loop84:
					while (true) {
						int alt84=2;
						int LA84_0 = input.LA(1);
						if ( (LA84_0==69) ) {
							alt84=1;
						}

						switch (alt84) {
						case 1 :
							// Pddl.g:556:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3672);
							conGD490=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD490.getTree());

							}
							break;

						default :
							break loop84;
						}
					}

					char_literal491=(Token)match(input,70,FOLLOW_70_in_conGD3675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal491_tree = (Object)adaptor.create(char_literal491);
					adaptor.addChild(root_0, char_literal491_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:557:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal492=(Token)match(input,69,FOLLOW_69_in_conGD3680); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal492_tree = (Object)adaptor.create(char_literal492);
					adaptor.addChild(root_0, char_literal492_tree);
					}

					string_literal493=(Token)match(input,120,FOLLOW_120_in_conGD3682); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal493_tree = (Object)adaptor.create(string_literal493);
					adaptor.addChild(root_0, string_literal493_tree);
					}

					char_literal494=(Token)match(input,69,FOLLOW_69_in_conGD3684); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal494_tree = (Object)adaptor.create(char_literal494);
					adaptor.addChild(root_0, char_literal494_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3686);
					typedVariableList495=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList495.getTree());

					char_literal496=(Token)match(input,70,FOLLOW_70_in_conGD3688); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal496_tree = (Object)adaptor.create(char_literal496);
					adaptor.addChild(root_0, char_literal496_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3690);
					conGD497=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD497.getTree());

					char_literal498=(Token)match(input,70,FOLLOW_70_in_conGD3692); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal498_tree = (Object)adaptor.create(char_literal498);
					adaptor.addChild(root_0, char_literal498_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:558:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal499=(Token)match(input,69,FOLLOW_69_in_conGD3697); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal499_tree = (Object)adaptor.create(char_literal499);
					adaptor.addChild(root_0, char_literal499_tree);
					}

					string_literal500=(Token)match(input,111,FOLLOW_111_in_conGD3699); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal500_tree = (Object)adaptor.create(string_literal500);
					adaptor.addChild(root_0, string_literal500_tree);
					}

					string_literal501=(Token)match(input,118,FOLLOW_118_in_conGD3701); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal501_tree = (Object)adaptor.create(string_literal501);
					adaptor.addChild(root_0, string_literal501_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3703);
					goalDesc502=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc502.getTree());

					char_literal503=(Token)match(input,70,FOLLOW_70_in_conGD3705); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal503_tree = (Object)adaptor.create(char_literal503);
					adaptor.addChild(root_0, char_literal503_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:559:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal504=(Token)match(input,69,FOLLOW_69_in_conGD3731); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal504_tree = (Object)adaptor.create(char_literal504);
					adaptor.addChild(root_0, char_literal504_tree);
					}

					string_literal505=(Token)match(input,107,FOLLOW_107_in_conGD3733); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal505_tree = (Object)adaptor.create(string_literal505);
					adaptor.addChild(root_0, string_literal505_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3735);
					goalDesc506=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc506.getTree());

					char_literal507=(Token)match(input,70,FOLLOW_70_in_conGD3737); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal507_tree = (Object)adaptor.create(char_literal507);
					adaptor.addChild(root_0, char_literal507_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:560:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal508=(Token)match(input,69,FOLLOW_69_in_conGD3742); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal508_tree = (Object)adaptor.create(char_literal508);
					adaptor.addChild(root_0, char_literal508_tree);
					}

					string_literal509=(Token)match(input,138,FOLLOW_138_in_conGD3744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal509_tree = (Object)adaptor.create(string_literal509);
					adaptor.addChild(root_0, string_literal509_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3746);
					goalDesc510=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc510.getTree());

					char_literal511=(Token)match(input,70,FOLLOW_70_in_conGD3748); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal511_tree = (Object)adaptor.create(char_literal511);
					adaptor.addChild(root_0, char_literal511_tree);
					}

					}
					break;
				case 6 :
					// Pddl.g:561:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal512=(Token)match(input,69,FOLLOW_69_in_conGD3754); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal512_tree = (Object)adaptor.create(char_literal512);
					adaptor.addChild(root_0, char_literal512_tree);
					}

					string_literal513=(Token)match(input,144,FOLLOW_144_in_conGD3756); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal513_tree = (Object)adaptor.create(string_literal513);
					adaptor.addChild(root_0, string_literal513_tree);
					}

					NUMBER514=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3758); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER514_tree = (Object)adaptor.create(NUMBER514);
					adaptor.addChild(root_0, NUMBER514_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3760);
					goalDesc515=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc515.getTree());

					char_literal516=(Token)match(input,70,FOLLOW_70_in_conGD3762); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal516_tree = (Object)adaptor.create(char_literal516);
					adaptor.addChild(root_0, char_literal516_tree);
					}

					}
					break;
				case 7 :
					// Pddl.g:562:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal517=(Token)match(input,69,FOLLOW_69_in_conGD3767); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal517_tree = (Object)adaptor.create(char_literal517);
					adaptor.addChild(root_0, char_literal517_tree);
					}

					string_literal518=(Token)match(input,112,FOLLOW_112_in_conGD3769); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal518_tree = (Object)adaptor.create(string_literal518);
					adaptor.addChild(root_0, string_literal518_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3771);
					goalDesc519=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc519.getTree());

					char_literal520=(Token)match(input,70,FOLLOW_70_in_conGD3773); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal520_tree = (Object)adaptor.create(char_literal520);
					adaptor.addChild(root_0, char_literal520_tree);
					}

					}
					break;
				case 8 :
					// Pddl.g:563:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal521=(Token)match(input,69,FOLLOW_69_in_conGD3778); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal521_tree = (Object)adaptor.create(char_literal521);
					adaptor.addChild(root_0, char_literal521_tree);
					}

					string_literal522=(Token)match(input,139,FOLLOW_139_in_conGD3780); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal522_tree = (Object)adaptor.create(string_literal522);
					adaptor.addChild(root_0, string_literal522_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3782);
					goalDesc523=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc523.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3784);
					goalDesc524=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc524.getTree());

					char_literal525=(Token)match(input,70,FOLLOW_70_in_conGD3786); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal525_tree = (Object)adaptor.create(char_literal525);
					adaptor.addChild(root_0, char_literal525_tree);
					}

					}
					break;
				case 9 :
					// Pddl.g:564:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal526=(Token)match(input,69,FOLLOW_69_in_conGD3791); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal526_tree = (Object)adaptor.create(char_literal526);
					adaptor.addChild(root_0, char_literal526_tree);
					}

					string_literal527=(Token)match(input,140,FOLLOW_140_in_conGD3793); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal527_tree = (Object)adaptor.create(string_literal527);
					adaptor.addChild(root_0, string_literal527_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3795);
					goalDesc528=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc528.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3797);
					goalDesc529=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc529.getTree());

					char_literal530=(Token)match(input,70,FOLLOW_70_in_conGD3799); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal530_tree = (Object)adaptor.create(char_literal530);
					adaptor.addChild(root_0, char_literal530_tree);
					}

					}
					break;
				case 10 :
					// Pddl.g:565:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal531=(Token)match(input,69,FOLLOW_69_in_conGD3804); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal531_tree = (Object)adaptor.create(char_literal531);
					adaptor.addChild(root_0, char_literal531_tree);
					}

					string_literal532=(Token)match(input,108,FOLLOW_108_in_conGD3806); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal532_tree = (Object)adaptor.create(string_literal532);
					adaptor.addChild(root_0, string_literal532_tree);
					}

					NUMBER533=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3808); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER533_tree = (Object)adaptor.create(NUMBER533);
					adaptor.addChild(root_0, NUMBER533_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3810);
					goalDesc534=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc534.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3812);
					goalDesc535=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc535.getTree());

					char_literal536=(Token)match(input,70,FOLLOW_70_in_conGD3814); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal536_tree = (Object)adaptor.create(char_literal536);
					adaptor.addChild(root_0, char_literal536_tree);
					}

					}
					break;
				case 11 :
					// Pddl.g:566:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal537=(Token)match(input,69,FOLLOW_69_in_conGD3819); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal537_tree = (Object)adaptor.create(char_literal537);
					adaptor.addChild(root_0, char_literal537_tree);
					}

					string_literal538=(Token)match(input,122,FOLLOW_122_in_conGD3821); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal538_tree = (Object)adaptor.create(string_literal538);
					adaptor.addChild(root_0, string_literal538_tree);
					}

					NUMBER539=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3823); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER539_tree = (Object)adaptor.create(NUMBER539);
					adaptor.addChild(root_0, NUMBER539_tree);
					}

					NUMBER540=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER540_tree = (Object)adaptor.create(NUMBER540);
					adaptor.addChild(root_0, NUMBER540_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3827);
					goalDesc541=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc541.getTree());

					char_literal542=(Token)match(input,70,FOLLOW_70_in_conGD3829); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal542_tree = (Object)adaptor.create(char_literal542);
					adaptor.addChild(root_0, char_literal542_tree);
					}

					}
					break;
				case 12 :
					// Pddl.g:567:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal543=(Token)match(input,69,FOLLOW_69_in_conGD3834); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal543_tree = (Object)adaptor.create(char_literal543);
					adaptor.addChild(root_0, char_literal543_tree);
					}

					string_literal544=(Token)match(input,121,FOLLOW_121_in_conGD3836); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal544_tree = (Object)adaptor.create(string_literal544);
					adaptor.addChild(root_0, string_literal544_tree);
					}

					NUMBER545=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3838); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER545_tree = (Object)adaptor.create(NUMBER545);
					adaptor.addChild(root_0, NUMBER545_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3840);
					goalDesc546=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc546.getTree());

					char_literal547=(Token)match(input,70,FOLLOW_70_in_conGD3842); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal547_tree = (Object)adaptor.create(char_literal547);
					adaptor.addChild(root_0, char_literal547_tree);
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
		// Pddl.g:169:5: ( atomicFunctionSkeleton )
		// Pddl.g:169:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl848);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred52_Pddl
	public final void synpred52_Pddl_fragment() throws RecognitionException {
		// Pddl.g:299:7: ( fComp )
		// Pddl.g:299:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred52_Pddl1805);
		fComp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred52_Pddl

	// $ANTLR start synpred55_Pddl
	public final void synpred55_Pddl_fragment() throws RecognitionException {
		// Pddl.g:322:28: ( typedVariableList )
		// Pddl.g:322:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred55_Pddl1964);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred55_Pddl

	// $ANTLR start synpred68_Pddl
	public final void synpred68_Pddl_fragment() throws RecognitionException {
		// Pddl.g:362:4: ( '(' binaryOp fExp fExp2 ')' )
		// Pddl.g:362:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,69,FOLLOW_69_in_synpred68_Pddl2220); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred68_Pddl2222);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred68_Pddl2224);
		fExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp2_in_synpred68_Pddl2226);
		fExp2();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred68_Pddl2228); if (state.failed) return;

		}

	}
	// $ANTLR end synpred68_Pddl

	// $ANTLR start synpred69_Pddl
	public final void synpred69_Pddl_fragment() throws RecognitionException {
		// Pddl.g:363:4: ( '(' '-' fExp ')' )
		// Pddl.g:363:4: '(' '-' fExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred69_Pddl2245); if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred69_Pddl2247); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred69_Pddl2249);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred69_Pddl2251); if (state.failed) return;

		}

	}
	// $ANTLR end synpred69_Pddl

	// $ANTLR start synpred70_Pddl
	public final void synpred70_Pddl_fragment() throws RecognitionException {
		// Pddl.g:364:4: ( '(' 'sin' fExp ')' )
		// Pddl.g:364:4: '(' 'sin' fExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred70_Pddl2264); if (state.failed) return;

		match(input,137,FOLLOW_137_in_synpred70_Pddl2266); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred70_Pddl2268);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred70_Pddl2270); if (state.failed) return;

		}

	}
	// $ANTLR end synpred70_Pddl

	// $ANTLR start synpred71_Pddl
	public final void synpred71_Pddl_fragment() throws RecognitionException {
		// Pddl.g:365:4: ( '(' 'cos' fExp ')' )
		// Pddl.g:365:4: '(' 'cos' fExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred71_Pddl2283); if (state.failed) return;

		match(input,113,FOLLOW_113_in_synpred71_Pddl2285); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred71_Pddl2287);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred71_Pddl2289); if (state.failed) return;

		}

	}
	// $ANTLR end synpred71_Pddl

	// $ANTLR start synpred72_Pddl
	public final void synpred72_Pddl_fragment() throws RecognitionException {
		// Pddl.g:366:4: ( '(' 'abs' fExp ')' )
		// Pddl.g:366:4: '(' 'abs' fExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred72_Pddl2302); if (state.failed) return;

		match(input,105,FOLLOW_105_in_synpred72_Pddl2304); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred72_Pddl2306);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred72_Pddl2308); if (state.failed) return;

		}

	}
	// $ANTLR end synpred72_Pddl

	// $ANTLR start synpred102_Pddl
	public final void synpred102_Pddl_fragment() throws RecognitionException {
		// Pddl.g:433:12: ( NUMBER )
		// Pddl.g:433:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred102_Pddl2751); if (state.failed) return;

		}

	}
	// $ANTLR end synpred102_Pddl

	// $ANTLR start synpred104_Pddl
	public final void synpred104_Pddl_fragment() throws RecognitionException {
		// Pddl.g:436:4: ( '(' 'and' ( daEffect )* ')' )
		// Pddl.g:436:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,69,FOLLOW_69_in_synpred104_Pddl2765); if (state.failed) return;

		match(input,109,FOLLOW_109_in_synpred104_Pddl2767); if (state.failed) return;

		// Pddl.g:436:14: ( daEffect )*
		loop103:
		while (true) {
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==69) ) {
				alt103=1;
			}

			switch (alt103) {
			case 1 :
				// Pddl.g:436:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred104_Pddl2769);
				daEffect();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop103;
			}
		}

		match(input,70,FOLLOW_70_in_synpred104_Pddl2772); if (state.failed) return;

		}

	}
	// $ANTLR end synpred104_Pddl

	// $ANTLR start synpred105_Pddl
	public final void synpred105_Pddl_fragment() throws RecognitionException {
		// Pddl.g:437:4: ( timedEffect )
		// Pddl.g:437:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred105_Pddl2777);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred105_Pddl

	// $ANTLR start synpred106_Pddl
	public final void synpred106_Pddl_fragment() throws RecognitionException {
		// Pddl.g:438:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// Pddl.g:438:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,69,FOLLOW_69_in_synpred106_Pddl2782); if (state.failed) return;

		match(input,120,FOLLOW_120_in_synpred106_Pddl2784); if (state.failed) return;

		match(input,69,FOLLOW_69_in_synpred106_Pddl2786); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred106_Pddl2788);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred106_Pddl2790); if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred106_Pddl2792);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred106_Pddl2794); if (state.failed) return;

		}

	}
	// $ANTLR end synpred106_Pddl

	// $ANTLR start synpred107_Pddl
	public final void synpred107_Pddl_fragment() throws RecognitionException {
		// Pddl.g:439:4: ( '(' 'when' daGD timedEffect ')' )
		// Pddl.g:439:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,69,FOLLOW_69_in_synpred107_Pddl2799); if (state.failed) return;

		match(input,143,FOLLOW_143_in_synpred107_Pddl2801); if (state.failed) return;

		pushFollow(FOLLOW_daGD_in_synpred107_Pddl2803);
		daGD();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_timedEffect_in_synpred107_Pddl2805);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred107_Pddl2807); if (state.failed) return;

		}

	}
	// $ANTLR end synpred107_Pddl

	// $ANTLR start synpred108_Pddl
	public final void synpred108_Pddl_fragment() throws RecognitionException {
		// Pddl.g:444:4: ( '(' 'at' timeSpecifier daEffect ')' )
		// Pddl.g:444:4: '(' 'at' timeSpecifier daEffect ')'
		{
		match(input,69,FOLLOW_69_in_synpred108_Pddl2831); if (state.failed) return;

		match(input,111,FOLLOW_111_in_synpred108_Pddl2833); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred108_Pddl2835);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred108_Pddl2837);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred108_Pddl2839); if (state.failed) return;

		}

	}
	// $ANTLR end synpred108_Pddl

	// $ANTLR start synpred109_Pddl
	public final void synpred109_Pddl_fragment() throws RecognitionException {
		// Pddl.g:445:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		// Pddl.g:445:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		match(input,69,FOLLOW_69_in_synpred109_Pddl2849); if (state.failed) return;

		match(input,111,FOLLOW_111_in_synpred109_Pddl2851); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred109_Pddl2853);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fAssignDA_in_synpred109_Pddl2855);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred109_Pddl2857); if (state.failed) return;

		}

	}
	// $ANTLR end synpred109_Pddl

	// $ANTLR start synpred110_Pddl
	public final void synpred110_Pddl_fragment() throws RecognitionException {
		// Pddl.g:454:9: ( ( binaryOp fExpDA fExpDA ) )
		// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
		{
		// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
		// Pddl.g:454:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred110_Pddl2913);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred110_Pddl2915);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred110_Pddl2917);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred110_Pddl

	// $ANTLR start synpred111_Pddl
	public final void synpred111_Pddl_fragment() throws RecognitionException {
		// Pddl.g:454:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// Pddl.g:454:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,69,FOLLOW_69_in_synpred111_Pddl2909); if (state.failed) return;

		// Pddl.g:454:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt104=2;
		int LA104_0 = input.LA(1);
		if ( (LA104_0==73) ) {
			int LA104_1 = input.LA(2);
			if ( (synpred110_Pddl()) ) {
				alt104=1;
			}
			else if ( (true) ) {
				alt104=2;
			}

		}
		else if ( ((LA104_0 >= 71 && LA104_0 <= 72)||LA104_0==74||LA104_0==104) ) {
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
				// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
				{
				// Pddl.g:454:9: ( binaryOp fExpDA fExpDA )
				// Pddl.g:454:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred111_Pddl2913);
				binaryOp();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred111_Pddl2915);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred111_Pddl2917);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;
			case 2 :
				// Pddl.g:454:36: ( '-' fExpDA )
				{
				// Pddl.g:454:36: ( '-' fExpDA )
				// Pddl.g:454:37: '-' fExpDA
				{
				match(input,73,FOLLOW_73_in_synpred111_Pddl2923); if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred111_Pddl2925);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;

		}

		match(input,70,FOLLOW_70_in_synpred111_Pddl2929); if (state.failed) return;

		}

	}
	// $ANTLR end synpred111_Pddl

	// $ANTLR start synpred118_Pddl
	public final void synpred118_Pddl_fragment() throws RecognitionException {
		// Pddl.g:492:4: ( '(' ':init' ( initEl )* ')' )
		// Pddl.g:492:4: '(' ':init' ( initEl )* ')'
		{
		match(input,69,FOLLOW_69_in_synpred118_Pddl3170); if (state.failed) return;

		match(input,89,FOLLOW_89_in_synpred118_Pddl3172); if (state.failed) return;

		// Pddl.g:492:16: ( initEl )*
		loop105:
		while (true) {
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==69) ) {
				alt105=1;
			}

			switch (alt105) {
			case 1 :
				// Pddl.g:492:16: initEl
				{
				pushFollow(FOLLOW_initEl_in_synpred118_Pddl3174);
				initEl();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop105;
			}
		}

		match(input,70,FOLLOW_70_in_synpred118_Pddl3177); if (state.failed) return;

		}

	}
	// $ANTLR end synpred118_Pddl

	// $ANTLR start synpred128_Pddl
	public final void synpred128_Pddl_fragment() throws RecognitionException {
		// Pddl.g:527:4: ( '(' 'and' ( prefConGD )* ')' )
		// Pddl.g:527:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,69,FOLLOW_69_in_synpred128_Pddl3443); if (state.failed) return;

		match(input,109,FOLLOW_109_in_synpred128_Pddl3445); if (state.failed) return;

		// Pddl.g:527:14: ( prefConGD )*
		loop107:
		while (true) {
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==69) ) {
				alt107=1;
			}

			switch (alt107) {
			case 1 :
				// Pddl.g:527:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred128_Pddl3447);
				prefConGD();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop107;
			}
		}

		match(input,70,FOLLOW_70_in_synpred128_Pddl3450); if (state.failed) return;

		}

	}
	// $ANTLR end synpred128_Pddl

	// $ANTLR start synpred129_Pddl
	public final void synpred129_Pddl_fragment() throws RecognitionException {
		// Pddl.g:528:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// Pddl.g:528:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,69,FOLLOW_69_in_synpred129_Pddl3455); if (state.failed) return;

		match(input,120,FOLLOW_120_in_synpred129_Pddl3457); if (state.failed) return;

		match(input,69,FOLLOW_69_in_synpred129_Pddl3459); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred129_Pddl3461);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred129_Pddl3463); if (state.failed) return;

		pushFollow(FOLLOW_prefConGD_in_synpred129_Pddl3465);
		prefConGD();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred129_Pddl3467); if (state.failed) return;

		}

	}
	// $ANTLR end synpred129_Pddl

	// $ANTLR start synpred131_Pddl
	public final void synpred131_Pddl_fragment() throws RecognitionException {
		// Pddl.g:529:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// Pddl.g:529:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,69,FOLLOW_69_in_synpred131_Pddl3472); if (state.failed) return;

		match(input,133,FOLLOW_133_in_synpred131_Pddl3474); if (state.failed) return;

		// Pddl.g:529:21: ( NAME )?
		int alt108=2;
		int LA108_0 = input.LA(1);
		if ( (LA108_0==NAME) ) {
			alt108=1;
		}
		switch (alt108) {
			case 1 :
				// Pddl.g:529:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred131_Pddl3476); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred131_Pddl3479);
		conGD();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred131_Pddl3481); if (state.failed) return;

		}

	}
	// $ANTLR end synpred131_Pddl

	// $ANTLR start synpred133_Pddl
	public final void synpred133_Pddl_fragment() throws RecognitionException {
		// Pddl.g:541:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// Pddl.g:541:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred133_Pddl3542); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred133_Pddl3544);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred133_Pddl3546);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred133_Pddl3548);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred133_Pddl3550); if (state.failed) return;

		}

	}
	// $ANTLR end synpred133_Pddl

	// $ANTLR start synpred135_Pddl
	public final void synpred135_Pddl_fragment() throws RecognitionException {
		// Pddl.g:543:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// Pddl.g:543:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,69,FOLLOW_69_in_synpred135_Pddl3572); if (state.failed) return;

		pushFollow(FOLLOW_multiOp_in_synpred135_Pddl3574);
		multiOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred135_Pddl3576);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		// Pddl.g:543:27: ( metricFExp )+
		int cnt109=0;
		loop109:
		while (true) {
			int alt109=2;
			int LA109_0 = input.LA(1);
			if ( (LA109_0==NAME||LA109_0==NUMBER||(LA109_0 >= 68 && LA109_0 <= 69)) ) {
				alt109=1;
			}

			switch (alt109) {
			case 1 :
				// Pddl.g:543:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred135_Pddl3578);
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

		match(input,70,FOLLOW_70_in_synpred135_Pddl3581); if (state.failed) return;

		}

	}
	// $ANTLR end synpred135_Pddl

	// $ANTLR start synpred136_Pddl
	public final void synpred136_Pddl_fragment() throws RecognitionException {
		// Pddl.g:545:4: ( '(' '-' metricFExp ')' )
		// Pddl.g:545:4: '(' '-' metricFExp ')'
		{
		match(input,69,FOLLOW_69_in_synpred136_Pddl3605); if (state.failed) return;

		match(input,73,FOLLOW_73_in_synpred136_Pddl3607); if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred136_Pddl3609);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,70,FOLLOW_70_in_synpred136_Pddl3611); if (state.failed) return;

		}

	}
	// $ANTLR end synpred136_Pddl

	// $ANTLR start synpred138_Pddl
	public final void synpred138_Pddl_fragment() throws RecognitionException {
		// Pddl.g:548:4: ( fHead )
		// Pddl.g:548:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred138_Pddl3633);
		fHead();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred138_Pddl

	// Delegated rules

	public final boolean synpred129_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred129_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred106_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred106_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred135_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred135_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred104_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred104_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred118_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred118_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred133_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred133_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred128_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred128_Pddl_fragment(); // can never throw exception
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
	protected DFA73 dfa73 = new DFA73(this);
	static final String DFA14_eotS =
		"\4\uffff";
	static final String DFA14_eofS =
		"\4\uffff";
	static final String DFA14_minS =
		"\2\51\2\uffff";
	static final String DFA14_maxS =
		"\1\106\1\111\2\uffff";
	static final String DFA14_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA14_specialS =
		"\4\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\34\uffff\1\2",
			"\1\1\34\uffff\1\2\2\uffff\1\3",
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
			return "147:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\51\2\uffff";
	static final String DFA12_maxS =
		"\1\106\1\111\2\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA12_specialS =
		"\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\1\34\uffff\1\2",
			"\1\1\34\uffff\1\2\2\uffff\1\3",
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
			return "()+ loopback of 147:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\101\2\uffff";
	static final String DFA25_maxS =
		"\1\106\1\111\2\uffff";
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
			return "198:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\101\2\uffff";
	static final String DFA23_maxS =
		"\1\106\1\111\2\uffff";
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
			return "()+ loopback of 198:20: ( singleTypeVarList )+";
		}
	}

	static final String DFA73_eotS =
		"\137\uffff";
	static final String DFA73_eofS =
		"\137\uffff";
	static final String DFA73_minS =
		"\1\105\1\131\1\105\1\51\1\uffff\1\105\1\51\2\105\1\uffff\6\51\1\105\1"+
		"\51\1\105\1\51\1\105\2\51\1\106\1\51\1\0\1\51\1\105\1\51\2\0\1\51\1\106"+
		"\2\51\1\105\1\51\2\105\1\51\3\105\3\51\2\105\1\0\2\51\1\55\2\51\1\105"+
		"\1\51\1\105\1\51\1\105\1\51\1\0\2\51\1\106\2\51\1\0\1\105\1\51\2\0\1\51"+
		"\1\106\1\51\1\106\1\51\1\55\1\105\1\51\1\106\1\51\1\105\2\51\3\105\1\0"+
		"\1\105\1\51\2\0\1\51\1\106\1\105";
	static final String DFA73_maxS =
		"\1\105\1\131\1\106\1\u008e\1\uffff\2\105\2\106\1\uffff\1\106\1\u0083\1"+
		"\u0089\2\105\1\u0083\1\106\1\u0083\7\106\1\0\1\u008e\1\105\1\106\2\0\3"+
		"\106\1\105\3\106\3\105\3\106\1\u0083\3\106\1\0\1\51\1\104\1\55\2\51\1"+
		"\106\1\u0080\4\106\1\0\5\106\1\0\1\105\1\106\2\0\5\106\1\55\5\106\1\51"+
		"\4\106\1\0\2\106\2\0\3\106";
	static final String DFA73_acceptS =
		"\4\uffff\1\1\4\uffff\1\2\125\uffff";
	static final String DFA73_specialS =
		"\31\uffff\1\1\3\uffff\1\0\1\4\21\uffff\1\5\13\uffff\1\6\5\uffff\1\7\2"+
		"\uffff\1\10\1\11\20\uffff\1\12\2\uffff\1\2\1\3\3\uffff}>";
	static final String[] DFA73_transitionS = {
			"\1\1",
			"\1\2",
			"\1\3\1\4",
			"\1\12\70\uffff\2\11\1\6\2\11\6\uffff\1\11\11\uffff\2\11\2\uffff\1\11"+
			"\4\uffff\1\5\1\uffff\1\7\1\10\12\uffff\1\4",
			"",
			"\1\13",
			"\1\15\3\uffff\1\11\23\uffff\1\11\2\uffff\1\16\1\14",
			"\1\17\1\20",
			"\1\21\1\22",
			"",
			"\1\23\27\uffff\1\11\4\uffff\1\24",
			"\1\25\70\uffff\5\11\6\uffff\1\11\11\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\26\32\uffff\1\26\2\uffff\4\11\35\uffff\2\11\7\uffff\1\11\27\uffff"+
			"\1\11",
			"\1\11\3\uffff\1\27\23\uffff\1\11\2\uffff\2\11",
			"\1\11\3\uffff\1\27\26\uffff\2\11",
			"\1\30\70\uffff\5\11\6\uffff\1\11\11\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\32\1\31",
			"\1\34\70\uffff\5\11\6\uffff\1\11\11\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\33\1\uffff\2\11",
			"\1\32\1\35",
			"\1\23\27\uffff\1\11\4\uffff\1\24",
			"\1\32\1\36",
			"\1\37\27\uffff\1\11\4\uffff\1\40",
			"\1\41\27\uffff\1\41\4\uffff\1\42",
			"\1\43",
			"\1\44\27\uffff\1\11\4\uffff\1\45",
			"\1\uffff",
			"\1\53\72\uffff\1\47\33\uffff\1\46\1\uffff\1\51\1\52\12\uffff\1\50",
			"\1\54",
			"\1\55\27\uffff\1\11\4\uffff\1\56",
			"\1\uffff",
			"\1\uffff",
			"\1\37\27\uffff\1\11\4\uffff\1\40",
			"\1\57",
			"\1\41\27\uffff\1\41\4\uffff\1\42",
			"\1\11\3\uffff\1\27\26\uffff\2\11",
			"\1\32\1\60",
			"\1\44\27\uffff\1\11\4\uffff\1\45",
			"\1\17\1\20",
			"\1\61",
			"\1\63\32\uffff\1\63\1\62",
			"\1\64",
			"\1\65\1\66",
			"\1\67\1\70",
			"\1\71\34\uffff\1\72",
			"\1\73\70\uffff\5\11\6\uffff\1\11\11\uffff\2\11\2\uffff\1\11\4\uffff"+
			"\1\11\1\uffff\2\11",
			"\1\55\27\uffff\1\11\4\uffff\1\56",
			"\1\21\1\22",
			"\1\32\1\74",
			"\1\uffff",
			"\1\75",
			"\1\76\32\uffff\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\32\1\102",
			"\1\104\126\uffff\1\103",
			"\1\32\1\105",
			"\1\71\34\uffff\1\72",
			"\1\32\1\106",
			"\1\107\27\uffff\1\11\4\uffff\1\110",
			"\1\uffff",
			"\1\111\34\uffff\1\112",
			"\1\113\27\uffff\1\113\4\uffff\1\114",
			"\1\115",
			"\1\116\34\uffff\1\117",
			"\1\120\34\uffff\1\121",
			"\1\uffff",
			"\1\122",
			"\1\123\34\uffff\1\124",
			"\1\uffff",
			"\1\uffff",
			"\1\107\27\uffff\1\11\4\uffff\1\110",
			"\1\125",
			"\1\111\34\uffff\1\112",
			"\1\126",
			"\1\113\27\uffff\1\113\4\uffff\1\114",
			"\1\77",
			"\1\32\1\127",
			"\1\116\34\uffff\1\117",
			"\1\130",
			"\1\120\34\uffff\1\121",
			"\1\65\1\66",
			"\1\131",
			"\1\123\34\uffff\1\124",
			"\1\67\1\70",
			"\1\21\1\22",
			"\1\32\1\132",
			"\1\uffff",
			"\1\32\1\133",
			"\1\134\34\uffff\1\135",
			"\1\uffff",
			"\1\uffff",
			"\1\134\34\uffff\1\135",
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
			return "491:1: init : ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) | '(' ':init' belief ')' -> ^( FORMULAINIT belief ) );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA73_29 = input.LA(1);
						 
						int index73_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_29);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA73_25 = input.LA(1);
						 
						int index73_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_25);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA73_90 = input.LA(1);
						 
						int index73_90 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_90);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA73_91 = input.LA(1);
						 
						int index73_91 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_91);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA73_30 = input.LA(1);
						 
						int index73_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_30);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA73_48 = input.LA(1);
						 
						int index73_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_48);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA73_60 = input.LA(1);
						 
						int index73_60 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_60);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA73_66 = input.LA(1);
						 
						int index73_66 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_66);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA73_69 = input.LA(1);
						 
						int index73_69 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_69);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA73_70 = input.LA(1);
						 
						int index73_70 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_70);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA73_87 = input.LA(1);
						 
						int index73_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred118_Pddl()) ) {s = 4;}
						else if ( (true) ) {s = 9;}
						 
						input.seek(index73_87);
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

	public static final BitSet FOLLOW_domain_in_pddlDoc401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_domain420 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_domain422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_domainName_in_domain424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_requireDef_in_domain432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_typesDef_in_domain441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_constantsDef_in_domain450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_predicatesDef_in_domain459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_functionsDef_in_domain468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_constraints_in_domain486 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_structureDef_in_domain495 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_domain504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_free_functionsDef588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_free_functionsDef590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_free_functionsDef594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_domainName617 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_domainName619 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NAME_in_domainName621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_domainName623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_requireDef650 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_96_in_requireDef652 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef654 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_requireDef657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_typesDef678 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_typesDef680 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_typesDef684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList711 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList716 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList719 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList739 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_singleTypeNameList742 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_type773 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_type775 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_primType_in_type777 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_type780 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_functionsDef821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_functionsDef823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_functionList_in_functionsDef825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_functionsDef827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000220L});
	public static final BitSet FOLLOW_73_in_functionList852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_functionType_in_functionList854 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_atomicFunctionSkeleton870 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton873 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_atomicFunctionSkeleton878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_129_in_functionType901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_constantsDef912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_constantsDef914 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constantsDef918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_predicatesDef938 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_predicatesDef940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef942 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_predicatesDef945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_atomicFormulaSkeleton966 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton972 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_atomicFormulaSkeleton974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList1000 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList1005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList1008 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000202L});
	public static final BitSet FOLLOW_73_in_singleTypeVarList1031 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_constraints1066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_constraints1069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_conGD_in_constraints1072 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constraints1074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1091 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraintDef_in_structureDef1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_processDef_in_structureDef1106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eventDef_in_structureDef1111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_actionDef1126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_actionDef1128 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1130 = new BitSet(new long[]{0x0000000000000000L,0x0000000030100040L});
	public static final BitSet FOLLOW_92_in_actionDef1140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_actionDef1143 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDef1147 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100040L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDef1164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_eventDef1197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_eventDef1199 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_eventDef1201 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_eventDef1210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_eventDef1213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_eventDef1215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_eventDef1217 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100040L});
	public static final BitSet FOLLOW_actionDefBody_in_eventDef1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_eventDef1232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_processDef1265 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_processDef1267 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_processDef1269 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_processDef1278 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_processDef1281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_processDef1283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_processDef1285 = new BitSet(new long[]{0x0000000000000000L,0x0000000020100040L});
	public static final BitSet FOLLOW_actionDefBody_in_processDef1298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_processDef1300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_constraintDef1334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_constraintDef1336 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1338 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_constraintDef1347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_constraintDef1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_constraintDef1352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constraintDef1354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001040L});
	public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constraintDef1369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_constraintSymbol1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_93_in_actionDefBody1427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_actionDefBody1431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDefBody1433 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1438 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_actionDefBody1448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_actionDefBody1452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDefBody1454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_constraintDefBody1494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_constraintDefBody1498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constraintDefBody1500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_belief1543 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_initEl_in_belief1548 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1575 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_goalDesc1577 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_goalDesc1582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_goalDesc1609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_goalDesc1614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_128_in_goalDesc1641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_130_in_goalDesc1671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_goalDesc1677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1692 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_goalDesc1694 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1698 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1726 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_goalDesc1728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_goalDesc1730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1734 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goalDesc1764 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_goalDesc1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_goalDesc1768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1774 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goalDesc1776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_equality1860 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_equality1863 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_equality1865 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_equality1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_equality1869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fComp1880 = new BitSet(new long[]{0x0000000000000000L,0x0000007C00000000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1883 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fComp1885 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fComp1887 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fComp1889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_atomicTermFormula1901 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1903 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1905 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_70_in_atomicTermFormula1908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_durativeActionDef1945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_durativeActionDef1947 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1949 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_durativeActionDef1958 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_durativeActionDef1961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_durativeActionDef1968 = new BitSet(new long[]{0x0000000000000000L,0x0000000000141000L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_durativeActionDef1983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_daDefBody2016 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_daDefBody2023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_daDefBody2027 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daDefBody2029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody2034 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_daDefBody2043 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_daDefBody2047 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daDefBody2049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody2054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD2069 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daGD2074 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_daGD2076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_daGD_in_daGD2078 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_daGD2081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daGD2086 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_daGD2088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_daGD2090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD2092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daGD2094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daGD_in_daGD2096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daGD2098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_prefTimedGD2114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_prefTimedGD2116 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_prefTimedGD2123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_timedGD2134 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_timedGD2136 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD2138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_timedGD2142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_timedGD2147 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_132_in_timedGD2149 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_interval_in_timedGD2151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_timedGD2155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_106_in_interval2177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_derivedDef2190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_derivedDef2193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef2196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef2198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_derivedDef2200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp2215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExp2220 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_fExp2222 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fExp2224 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp2_in_fExp2226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExp2228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExp2245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_fExp2247 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fExp2249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExp2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExp2264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_137_in_fExp2266 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fExp2268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExp2270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExp2283 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_fExp2285 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fExp2287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExp2289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExp2302 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_fExp2304 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_fExp2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExp2308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp2321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp22333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fHead2343 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2345 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_term_in_fHead2347 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_70_in_fHead2350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_effect2385 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_effect2387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_cEffect_in_effect2389 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_effect2392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect2406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_cEffect2417 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_cEffect2419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_cEffect2421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect2423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_cEffect2425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_effect_in_cEffect2427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_cEffect2429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_cEffect2447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_cEffect2449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect2451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_condEffect_in_cEffect2453 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_cEffect2455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_pEffect2484 = new BitSet(new long[]{0x0000000000000000L,0x1004400000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2486 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fHead_in_pEffect2488 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_pEffect2490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_pEffect2492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_pEffect2512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_128_in_pEffect2514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_pEffect2518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_condEffect2547 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_condEffect2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_condEffect2554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_durationConstraint2673 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_durationConstraint2675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2677 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_durationConstraint2680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_durationConstraint2685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_durationConstraint2687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_simpleDurationConstraint2703 = new BitSet(new long[]{0x0000000000000000L,0x0000005800000000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2705 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_simpleDurationConstraint2707 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_simpleDurationConstraint2711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_simpleDurationConstraint2716 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_simpleDurationConstraint2718 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2720 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_simpleDurationConstraint2724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daEffect2765 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_daEffect2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_daEffect2772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daEffect2782 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_daEffect2784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_daEffect2786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daEffect2790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daEffect2794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daEffect2799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_daEffect2801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daGD_in_daEffect2803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daEffect2807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daEffect2812 = new BitSet(new long[]{0x0000000000000000L,0x1004400000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2814 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fHead_in_daEffect2816 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2818 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_daEffect2820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_timedEffect2831 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_timedEffect2833 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_timedEffect2839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_timedEffect2849 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_timedEffect2851 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_timedEffect2857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_timedEffect2862 = new BitSet(new long[]{0x0000000000000000L,0x1004400000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2864 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2866 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_timedEffect2870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fAssignDA2890 = new BitSet(new long[]{0x0000000000000000L,0x1004400000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2892 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2894 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fAssignDA2898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_fExpDA2909 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2913 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2915 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_73_in_fExpDA2923 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_fExpDA2929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_fExpDA2934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_problem2953 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_problem2955 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_problemDecl_in_problem2957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_problemDomain_in_problem2962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_requireDef_in_problem2970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_objectDecl_in_problem2979 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_init_in_problem2988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goal_in_problem2996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_probConstraints_in_problem3004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_metricSpec_in_problem3013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_problem3029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_problemDecl3086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_134_in_problemDecl3088 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl3090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_problemDecl3092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_problemDomain3118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_problemDomain3120 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain3122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_problemDomain3124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_objectDecl3144 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_objectDecl3146 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl3148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_objectDecl3150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_init3170 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_init3172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_initEl_in_init3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_init3177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_init3192 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_init3194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_belief_in_init3196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_init3198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_initEl3222 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_initEl3224 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fHead_in_initEl3226 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_initEl3230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_initEl3254 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_142_in_initEl3256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_atomicNameFormula_in_initEl3259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_initEl3261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_initEl3275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_130_in_initEl3277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_atomicNameFormula_in_initEl3280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_initEl3283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_initEl3298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_initEl3300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3303 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_initEl3306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_nameLiteral3332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_128_in_nameLiteral3334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_nameLiteral3338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_atomicNameFormula3357 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula3359 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula3361 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_atomicNameFormula3364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_goal3389 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_goal3391 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_goal3393 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_goal3396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_probConstraints3414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_probConstraints3416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints3419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_probConstraints3421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_prefConGD3443 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_prefConGD3445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_prefConGD3450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_prefConGD3455 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_prefConGD3457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_prefConGD3459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD3461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_prefConGD3463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3465 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_prefConGD3467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_prefConGD3472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_prefConGD3474 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NAME_in_prefConGD3476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_prefConGD3481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_metricSpec3497 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_metricSpec3499 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec3501 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec3503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_metricSpec3505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_metricFExp3542 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3544 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3546 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_metricFExp3550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_metricFExp3572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3574 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3576 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3578 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000070L});
	public static final BitSet FOLLOW_70_in_metricFExp3581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_metricFExp3605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_metricFExp3607 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_metricFExp3611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_metricFExp3648 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_metricFExp3650 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_metricFExp3654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3668 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_conGD3670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_conGD_in_conGD3672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_conGD3675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3680 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_conGD3682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_conGD3684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_conGD_in_conGD3690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3697 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_conGD3699 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_conGD3701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3703 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3731 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_conGD3733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3735 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_138_in_conGD3744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_144_in_conGD3756 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3767 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_conGD3769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3771 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_conGD3780 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_conGD3793 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3804 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_conGD3806 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3808 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3810 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3819 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_conGD3821 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3823 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_conGD3834 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_121_in_conGD3836 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3840 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_conGD3842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred52_Pddl1805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred55_Pddl1964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred68_Pddl2220 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_synpred68_Pddl2222 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_synpred68_Pddl2224 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp2_in_synpred68_Pddl2226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred68_Pddl2228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred69_Pddl2245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred69_Pddl2247 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_synpred69_Pddl2249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred69_Pddl2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred70_Pddl2264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_137_in_synpred70_Pddl2266 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_synpred70_Pddl2268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred70_Pddl2270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred71_Pddl2283 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_synpred71_Pddl2285 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_synpred71_Pddl2287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred71_Pddl2289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred72_Pddl2302 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_synpred72_Pddl2304 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_fExp_in_synpred72_Pddl2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred72_Pddl2308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred102_Pddl2751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred104_Pddl2765 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_synpred104_Pddl2767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_daEffect_in_synpred104_Pddl2769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_synpred104_Pddl2772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred105_Pddl2777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred106_Pddl2782 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_synpred106_Pddl2784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_synpred106_Pddl2786 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred106_Pddl2788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred106_Pddl2790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daEffect_in_synpred106_Pddl2792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred106_Pddl2794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred107_Pddl2799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_synpred107_Pddl2801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daGD_in_synpred107_Pddl2803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_timedEffect_in_synpred107_Pddl2805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred107_Pddl2807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred108_Pddl2831 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_synpred108_Pddl2833 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred108_Pddl2835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_daEffect_in_synpred108_Pddl2837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred108_Pddl2839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred109_Pddl2849 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_synpred109_Pddl2851 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred109_Pddl2853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred109_Pddl2855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred109_Pddl2857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred110_Pddl2913 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_synpred110_Pddl2915 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_synpred110_Pddl2917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred111_Pddl2909 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_synpred111_Pddl2913 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_synpred111_Pddl2915 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_synpred111_Pddl2917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_73_in_synpred111_Pddl2923 = new BitSet(new long[]{0x0000220000000000L,0x0000008000000030L});
	public static final BitSet FOLLOW_fExpDA_in_synpred111_Pddl2925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred111_Pddl2929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred118_Pddl3170 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_synpred118_Pddl3172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_initEl_in_synpred118_Pddl3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_synpred118_Pddl3177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred128_Pddl3443 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_synpred128_Pddl3445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_prefConGD_in_synpred128_Pddl3447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_70_in_synpred128_Pddl3450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred129_Pddl3455 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_synpred129_Pddl3457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_synpred129_Pddl3459 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000042L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred129_Pddl3461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred129_Pddl3463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_prefConGD_in_synpred129_Pddl3465 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred129_Pddl3467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred131_Pddl3472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_synpred131_Pddl3474 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_NAME_in_synpred131_Pddl3476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_conGD_in_synpred131_Pddl3479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred131_Pddl3481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred133_Pddl3542 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000780L});
	public static final BitSet FOLLOW_binaryOp_in_synpred133_Pddl3544 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_synpred133_Pddl3546 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_synpred133_Pddl3548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred133_Pddl3550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred135_Pddl3572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
	public static final BitSet FOLLOW_multiOp_in_synpred135_Pddl3574 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_synpred135_Pddl3576 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_synpred135_Pddl3578 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000070L});
	public static final BitSet FOLLOW_70_in_synpred135_Pddl3581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_synpred136_Pddl3605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_synpred136_Pddl3607 = new BitSet(new long[]{0x0000220000000000L,0x0000000000000030L});
	public static final BitSet FOLLOW_metricFExp_in_synpred136_Pddl3609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_synpred136_Pddl3611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred138_Pddl3633 = new BitSet(new long[]{0x0000000000000002L});
}
