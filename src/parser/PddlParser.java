// $ANTLR 3.5.2 Pddl.g 2016-09-05 02:33:13

package parser;


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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "AND_EFFECT", "AND_GD", 
		"ANY_CHAR", "ASSIGN_EFFECT", "BINARY_OP", "COMPARISON_GD", "CONSTANTS", 
		"CONSTRAINT", "COS", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", 
		"EFFECT", "EITHER_TYPE", "EQUALITY_CON", "EVENT", "EXISTS_GD", "FORALL_EFFECT", 
		"FORALL_GD", "FREE_FUNCTIONS", "FUNCTIONS", "FUNC_HEAD", "GLOBAL_CONSTRAINT", 
		"GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", 
		"MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", 
		"NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", 
		"PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", 
		"PROBLEM_NAME", "PROCESS", "REQUIREMENTS", "REQUIRE_KEY", "SIN", "TYPES", 
		"UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'#t'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", 
		"':constraint'", "':constraints'", "':derived'", "':domain'", "':duration'", 
		"':durative-action'", "':effect'", "':event'", "':free_functions'", "':functions'", 
		"':goal'", "':init'", "':metric'", "':objects'", "':parameters'", "':precondition'", 
		"':predicates'", "':process'", "':requirements'", "':types'", "'<'", "'<='", 
		"'='", "'>'", "'>='", "'?duration'", "'^'", "'all'", "'always'", "'always-within'", 
		"'and'", "'assign'", "'at'", "'at-most-once'", "'cos'", "'decrease'", 
		"'define'", "'domain'", "'either'", "'end'", "'exists'", "'forall'", "'hold-after'", 
		"'hold-during'", "'imply'", "'increase'", "'is-violated'", "'maximize'", 
		"'minimize'", "'not'", "'number'", "'or'", "'over'", "'preference'", "'problem'", 
		"'scale-down'", "'scale-up'", "'sin'", "'sometime'", "'sometime-after'", 
		"'sometime-before'", "'start'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int T__130=130;
	public static final int T__131=131;
	public static final int T__132=132;
	public static final int T__133=133;
	public static final int T__134=134;
	public static final int T__135=135;
	public static final int T__136=136;
	public static final int ACTION=4;
	public static final int AND_EFFECT=5;
	public static final int AND_GD=6;
	public static final int ANY_CHAR=7;
	public static final int ASSIGN_EFFECT=8;
	public static final int BINARY_OP=9;
	public static final int COMPARISON_GD=10;
	public static final int CONSTANTS=11;
	public static final int CONSTRAINT=12;
	public static final int COS=13;
	public static final int DIGIT=14;
	public static final int DOMAIN=15;
	public static final int DOMAIN_NAME=16;
	public static final int DURATIVE_ACTION=17;
	public static final int EFFECT=18;
	public static final int EITHER_TYPE=19;
	public static final int EQUALITY_CON=20;
	public static final int EVENT=21;
	public static final int EXISTS_GD=22;
	public static final int FORALL_EFFECT=23;
	public static final int FORALL_GD=24;
	public static final int FREE_FUNCTIONS=25;
	public static final int FUNCTIONS=26;
	public static final int FUNC_HEAD=27;
	public static final int GLOBAL_CONSTRAINT=28;
	public static final int GOAL=29;
	public static final int IMPLY_GD=30;
	public static final int INIT=31;
	public static final int INIT_AT=32;
	public static final int INIT_EQ=33;
	public static final int LETTER=34;
	public static final int LINE_COMMENT=35;
	public static final int MINUS_OP=36;
	public static final int MULTI_OP=37;
	public static final int NAME=38;
	public static final int NOT_EFFECT=39;
	public static final int NOT_GD=40;
	public static final int NOT_PRED_INIT=41;
	public static final int NUMBER=42;
	public static final int OBJECTS=43;
	public static final int OR_GD=44;
	public static final int PRECONDITION=45;
	public static final int PREDICATES=46;
	public static final int PRED_HEAD=47;
	public static final int PRED_INST=48;
	public static final int PROBLEM=49;
	public static final int PROBLEM_CONSTRAINT=50;
	public static final int PROBLEM_DOMAIN=51;
	public static final int PROBLEM_METRIC=52;
	public static final int PROBLEM_NAME=53;
	public static final int PROCESS=54;
	public static final int REQUIREMENTS=55;
	public static final int REQUIRE_KEY=56;
	public static final int SIN=57;
	public static final int TYPES=58;
	public static final int UNARY_MINUS=59;
	public static final int VARIABLE=60;
	public static final int WHEN_EFFECT=61;
	public static final int WHITESPACE=62;

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
	// Pddl.g:98:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			// Pddl.g:98:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==64) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==109) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==64) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==110) ) {
							alt1=1;
						}
						else if ( (LA1_3==127) ) {
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
					// Pddl.g:98:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc363);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// Pddl.g:98:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc367);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "domain"
	// Pddl.g:102:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
	public final PddlParser.domain_return domain() throws RecognitionException {
		PddlParser.domain_return retval = new PddlParser.domain_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
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
			// Pddl.g:103:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			// Pddl.g:103:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,64,FOLLOW_64_in_domain382); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal3);

			string_literal4=(Token)match(input,109,FOLLOW_109_in_domain384); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_109.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain386);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// Pddl.g:104:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==64) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==91) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// Pddl.g:104:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain394);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// Pddl.g:105:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==64) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==92) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// Pddl.g:105:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain403);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// Pddl.g:106:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==64) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==72) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// Pddl.g:106:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain412);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// Pddl.g:107:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==64) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==89) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// Pddl.g:107:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain421);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// Pddl.g:108:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==64) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==82) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// Pddl.g:108:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain430);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// Pddl.g:109:7: ( free_functionsDef )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==64) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==81) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// Pddl.g:109:7: free_functionsDef
					{
					pushFollow(FOLLOW_free_functionsDef_in_domain439);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}

			// Pddl.g:110:7: ( constraints )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==64) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==74) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// Pddl.g:110:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain448);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}

			// Pddl.g:111:7: ( structureDef )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==64) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Pddl.g:111:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain457);
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

			char_literal14=(Token)match(input,65,FOLLOW_65_in_domain466); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal14);

			// AST REWRITE
			// elements: predicatesDef, free_functionsDef, typesDef, constantsDef, domainName, requireDef, structureDef, functionsDef, constraints
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 113:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				// Pddl.g:113:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// Pddl.g:113:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:113:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// Pddl.g:114:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// Pddl.g:114:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// Pddl.g:114:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// Pddl.g:114:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();

				// Pddl.g:115:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// Pddl.g:115:30: ( structureDef )*
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "free_functionsDef"
	// Pddl.g:118:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
	public final PddlParser.free_functionsDef_return free_functionsDef() throws RecognitionException {
		PddlParser.free_functionsDef_return retval = new PddlParser.free_functionsDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal15=null;
		Token string_literal16=null;
		Token char_literal18=null;
		ParserRuleReturnScope functionList17 =null;

		Object char_literal15_tree=null;
		Object string_literal16_tree=null;
		Object char_literal18_tree=null;
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// Pddl.g:119:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			// Pddl.g:119:4: '(' ':free_functions' functionList ')'
			{
			char_literal15=(Token)match(input,64,FOLLOW_64_in_free_functionsDef550); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal15);

			string_literal16=(Token)match(input,81,FOLLOW_81_in_free_functionsDef552); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal16);

			pushFollow(FOLLOW_functionList_in_free_functionsDef554);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());
			char_literal18=(Token)match(input,65,FOLLOW_65_in_free_functionsDef556); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal18);

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
			// 120:2: -> ^( FREE_FUNCTIONS functionList )
			{
				// Pddl.g:120:5: ^( FREE_FUNCTIONS functionList )
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
	// Pddl.g:123:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
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
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// Pddl.g:124:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// Pddl.g:124:7: '(' 'domain' NAME ')'
			{
			char_literal19=(Token)match(input,64,FOLLOW_64_in_domainName579); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal19);

			string_literal20=(Token)match(input,110,FOLLOW_110_in_domainName581); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_110.add(string_literal20);

			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName583); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);

			char_literal22=(Token)match(input,65,FOLLOW_65_in_domainName585); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal22);

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
			// 125:6: -> ^( DOMAIN_NAME NAME )
			{
				// Pddl.g:125:9: ^( DOMAIN_NAME NAME )
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
	// Pddl.g:128:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
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
		RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");

		try {
			// Pddl.g:129:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// Pddl.g:129:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal23=(Token)match(input,64,FOLLOW_64_in_requireDef612); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal23);

			string_literal24=(Token)match(input,91,FOLLOW_91_in_requireDef614); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_91.add(string_literal24);

			// Pddl.g:129:24: ( REQUIRE_KEY )+
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
					// Pddl.g:129:24: REQUIRE_KEY
					{
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef616); if (state.failed) return retval; 
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

			char_literal26=(Token)match(input,65,FOLLOW_65_in_requireDef619); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal26);

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
			// 130:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// Pddl.g:130:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
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
	// Pddl.g:133:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
	public final PddlParser.typesDef_return typesDef() throws RecognitionException {
		PddlParser.typesDef_return retval = new PddlParser.typesDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal27=null;
		Token string_literal28=null;
		Token char_literal30=null;
		ParserRuleReturnScope typedNameList29 =null;

		Object char_literal27_tree=null;
		Object string_literal28_tree=null;
		Object char_literal30_tree=null;
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:134:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// Pddl.g:134:4: '(' ':types' typedNameList ')'
			{
			char_literal27=(Token)match(input,64,FOLLOW_64_in_typesDef640); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal27);

			string_literal28=(Token)match(input,92,FOLLOW_92_in_typesDef642); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_92.add(string_literal28);

			pushFollow(FOLLOW_typedNameList_in_typesDef644);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());
			char_literal30=(Token)match(input,65,FOLLOW_65_in_typesDef646); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal30);

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
			// 135:4: -> ^( TYPES typedNameList )
			{
				// Pddl.g:135:7: ^( TYPES typedNameList )
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
	// Pddl.g:139:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
	public final PddlParser.typedNameList_return typedNameList() throws RecognitionException {
		PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME31=null;
		Token NAME33=null;
		ParserRuleReturnScope singleTypeNameList32 =null;

		Object NAME31_tree=null;
		Object NAME33_tree=null;

		try {
			// Pddl.g:140:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// Pddl.g:140:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:140:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// Pddl.g:140:8: ( NAME )*
					{
					// Pddl.g:140:8: ( NAME )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// Pddl.g:140:8: NAME
							{
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList673); if (state.failed) return retval;
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
					// Pddl.g:140:16: ( singleTypeNameList )+ ( NAME )*
					{
					// Pddl.g:140:16: ( singleTypeNameList )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						alt12 = dfa12.predict(input);
						switch (alt12) {
						case 1 :
							// Pddl.g:140:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList678);
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

					// Pddl.g:140:36: ( NAME )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// Pddl.g:140:36: NAME
							{
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList681); if (state.failed) return retval;
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
	// Pddl.g:143:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME34=null;
		Token char_literal35=null;
		ParserRuleReturnScope t =null;

		Object NAME34_tree=null;
		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Pddl.g:144:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// Pddl.g:144:7: ( ( NAME )+ '-' t= type )
			{
			// Pddl.g:144:7: ( ( NAME )+ '-' t= type )
			// Pddl.g:144:8: ( NAME )+ '-' t= type
			{
			// Pddl.g:144:8: ( NAME )+
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
					// Pddl.g:144:8: NAME
					{
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList701); if (state.failed) return retval; 
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

			char_literal35=(Token)match(input,68,FOLLOW_68_in_singleTypeNameList704); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(char_literal35);

			pushFollow(FOLLOW_type_in_singleTypeNameList708);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: t, NAME
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
			// 145:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_t.hasNext()||stream_NAME.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_NAME.hasNext() ) {
					// Pddl.g:145:7: ^( NAME $t)
					{
					Object root_1 = (Object)adaptor.nil();
					root_1 = (Object)adaptor.becomeRoot(stream_NAME.nextNode(), root_1);
					adaptor.addChild(root_1, stream_t.nextTree());
					adaptor.addChild(root_0, root_1);
					}

				}
				stream_t.reset();
				stream_NAME.reset();

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// Pddl.g:148:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
	public final PddlParser.type_return type() throws RecognitionException {
		PddlParser.type_return retval = new PddlParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal36=null;
		Token string_literal37=null;
		Token char_literal39=null;
		ParserRuleReturnScope primType38 =null;
		ParserRuleReturnScope primType40 =null;

		Object char_literal36_tree=null;
		Object string_literal37_tree=null;
		Object char_literal39_tree=null;
		RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			// Pddl.g:149:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==64) ) {
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
					// Pddl.g:149:4: ( '(' 'either' ( primType )+ ')' )
					{
					// Pddl.g:149:4: ( '(' 'either' ( primType )+ ')' )
					// Pddl.g:149:6: '(' 'either' ( primType )+ ')'
					{
					char_literal36=(Token)match(input,64,FOLLOW_64_in_type735); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal36);

					string_literal37=(Token)match(input,111,FOLLOW_111_in_type737); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_111.add(string_literal37);

					// Pddl.g:149:19: ( primType )+
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
							// Pddl.g:149:19: primType
							{
							pushFollow(FOLLOW_primType_in_type739);
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

					char_literal39=(Token)match(input,65,FOLLOW_65_in_type742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal39);

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
					// 150:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// Pddl.g:150:7: ^( EITHER_TYPE ( primType )+ )
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
					// Pddl.g:151:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type763);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "primType"
	// Pddl.g:154:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try {
			// Pddl.g:154:10: ( NAME )
			// Pddl.g:154:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType773); if (state.failed) return retval;
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
	// Pddl.g:156:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
	public final PddlParser.functionsDef_return functionsDef() throws RecognitionException {
		PddlParser.functionsDef_return retval = new PddlParser.functionsDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal42=null;
		Token string_literal43=null;
		Token char_literal45=null;
		ParserRuleReturnScope functionList44 =null;

		Object char_literal42_tree=null;
		Object string_literal43_tree=null;
		Object char_literal45_tree=null;
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// Pddl.g:157:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// Pddl.g:157:4: '(' ':functions' functionList ')'
			{
			char_literal42=(Token)match(input,64,FOLLOW_64_in_functionsDef783); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal42);

			string_literal43=(Token)match(input,82,FOLLOW_82_in_functionsDef785); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_82.add(string_literal43);

			pushFollow(FOLLOW_functionList_in_functionsDef787);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());
			char_literal45=(Token)match(input,65,FOLLOW_65_in_functionsDef789); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal45);

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
			// 158:2: -> ^( FUNCTIONS functionList )
			{
				// Pddl.g:158:5: ^( FUNCTIONS functionList )
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
	// Pddl.g:161:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws RecognitionException {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal47=null;
		ParserRuleReturnScope atomicFunctionSkeleton46 =null;
		ParserRuleReturnScope functionType48 =null;

		Object char_literal47_tree=null;

		try {
			// Pddl.g:162:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// Pddl.g:162:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:162:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==64) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// Pddl.g:162:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// Pddl.g:162:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==64) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						switch (alt18) {
						case 1 :
							// Pddl.g:162:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList810);
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

					// Pddl.g:162:29: ( '-' functionType )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==68) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// Pddl.g:162:30: '-' functionType
							{
							char_literal47=(Token)match(input,68,FOLLOW_68_in_functionList814); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList816);
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
	// Pddl.g:165:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
	public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws RecognitionException {
		PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal49=null;
		Token char_literal52=null;
		ParserRuleReturnScope functionSymbol50 =null;
		ParserRuleReturnScope typedVariableList51 =null;

		Object char_literal49_tree=null;
		Object char_literal52_tree=null;

		try {
			// Pddl.g:166:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// Pddl.g:166:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal49=(Token)match(input,64,FOLLOW_64_in_atomicFunctionSkeleton832); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton835);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton838);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

			char_literal52=(Token)match(input,65,FOLLOW_65_in_atomicFunctionSkeleton840); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionSymbol"
	// Pddl.g:169:1: functionSymbol : ( NAME | '#t' );
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set53=null;

		Object set53_tree=null;

		try {
			// Pddl.g:169:16: ( NAME | '#t' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set53=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==63 ) {
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
	// Pddl.g:171:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try {
			// Pddl.g:171:14: ( 'number' )
			// Pddl.g:171:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal54=(Token)match(input,123,FOLLOW_123_in_functionType863); if (state.failed) return retval;
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
	// Pddl.g:173:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
	public final PddlParser.constantsDef_return constantsDef() throws RecognitionException {
		PddlParser.constantsDef_return retval = new PddlParser.constantsDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal55=null;
		Token string_literal56=null;
		Token char_literal58=null;
		ParserRuleReturnScope typedNameList57 =null;

		Object char_literal55_tree=null;
		Object string_literal56_tree=null;
		Object char_literal58_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:174:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// Pddl.g:174:4: '(' ':constants' typedNameList ')'
			{
			char_literal55=(Token)match(input,64,FOLLOW_64_in_constantsDef874); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal55);

			string_literal56=(Token)match(input,72,FOLLOW_72_in_constantsDef876); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(string_literal56);

			pushFollow(FOLLOW_typedNameList_in_constantsDef878);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());
			char_literal58=(Token)match(input,65,FOLLOW_65_in_constantsDef880); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal58);

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
			// 175:2: -> ^( CONSTANTS typedNameList )
			{
				// Pddl.g:175:5: ^( CONSTANTS typedNameList )
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
	// Pddl.g:178:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
	public final PddlParser.predicatesDef_return predicatesDef() throws RecognitionException {
		PddlParser.predicatesDef_return retval = new PddlParser.predicatesDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal59=null;
		Token string_literal60=null;
		Token char_literal62=null;
		ParserRuleReturnScope atomicFormulaSkeleton61 =null;

		Object char_literal59_tree=null;
		Object string_literal60_tree=null;
		Object char_literal62_tree=null;
		RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			// Pddl.g:179:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// Pddl.g:179:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal59=(Token)match(input,64,FOLLOW_64_in_predicatesDef900); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal59);

			string_literal60=(Token)match(input,89,FOLLOW_89_in_predicatesDef902); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_89.add(string_literal60);

			// Pddl.g:179:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==64) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// Pddl.g:179:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef904);
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

			char_literal62=(Token)match(input,65,FOLLOW_65_in_predicatesDef907); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal62);

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
			// 180:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// Pddl.g:180:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
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
	// Pddl.g:183:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
	public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws RecognitionException {
		PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal63=null;
		Token char_literal66=null;
		ParserRuleReturnScope predicate64 =null;
		ParserRuleReturnScope typedVariableList65 =null;

		Object char_literal63_tree=null;
		Object char_literal66_tree=null;

		try {
			// Pddl.g:184:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// Pddl.g:184:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal63=(Token)match(input,64,FOLLOW_64_in_atomicFormulaSkeleton928); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton931);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton934);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

			char_literal66=(Token)match(input,65,FOLLOW_65_in_atomicFormulaSkeleton936); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "predicate"
	// Pddl.g:187:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try {
			// Pddl.g:187:11: ( NAME )
			// Pddl.g:187:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate947); if (state.failed) return retval;
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
	// Pddl.g:190:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
	public final PddlParser.typedVariableList_return typedVariableList() throws RecognitionException {
		PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE68=null;
		Token VARIABLE70=null;
		ParserRuleReturnScope singleTypeVarList69 =null;

		Object VARIABLE68_tree=null;
		Object VARIABLE70_tree=null;

		try {
			// Pddl.g:191:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// Pddl.g:191:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:191:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// Pddl.g:191:8: ( VARIABLE )*
					{
					// Pddl.g:191:8: ( VARIABLE )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// Pddl.g:191:8: VARIABLE
							{
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList962); if (state.failed) return retval;
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
					// Pddl.g:191:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// Pddl.g:191:20: ( singleTypeVarList )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						alt23 = dfa23.predict(input);
						switch (alt23) {
						case 1 :
							// Pddl.g:191:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList967);
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

					// Pddl.g:191:39: ( VARIABLE )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// Pddl.g:191:39: VARIABLE
							{
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList970); if (state.failed) return retval;
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
	// Pddl.g:194:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
	public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
		PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE71=null;
		Token char_literal72=null;
		ParserRuleReturnScope t =null;

		Object VARIABLE71_tree=null;
		Object char_literal72_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Pddl.g:195:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// Pddl.g:195:7: ( ( VARIABLE )+ '-' t= type )
			{
			// Pddl.g:195:7: ( ( VARIABLE )+ '-' t= type )
			// Pddl.g:195:8: ( VARIABLE )+ '-' t= type
			{
			// Pddl.g:195:8: ( VARIABLE )+
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
					// Pddl.g:195:8: VARIABLE
					{
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList990); if (state.failed) return retval; 
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

			char_literal72=(Token)match(input,68,FOLLOW_68_in_singleTypeVarList993); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(char_literal72);

			pushFollow(FOLLOW_type_in_singleTypeVarList997);
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
			// 196:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_t.hasNext()||stream_VARIABLE.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_VARIABLE.hasNext() ) {
					// Pddl.g:196:10: ^( VARIABLE $t)
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
	// Pddl.g:199:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
	public final PddlParser.constraints_return constraints() throws RecognitionException {
		PddlParser.constraints_return retval = new PddlParser.constraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal73=null;
		Token string_literal74=null;
		Token char_literal76=null;
		ParserRuleReturnScope conGD75 =null;

		Object char_literal73_tree=null;
		Object string_literal74_tree=null;
		Object char_literal76_tree=null;

		try {
			// Pddl.g:200:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// Pddl.g:200:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal73=(Token)match(input,64,FOLLOW_64_in_constraints1028); if (state.failed) return retval;
			string_literal74=(Token)match(input,74,FOLLOW_74_in_constraints1031); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints1034);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

			char_literal76=(Token)match(input,65,FOLLOW_65_in_constraints1036); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "structureDef"
	// Pddl.g:203:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef );
	public final PddlParser.structureDef_return structureDef() throws RecognitionException {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope actionDef77 =null;
		ParserRuleReturnScope durativeActionDef78 =null;
		ParserRuleReturnScope derivedDef79 =null;
		ParserRuleReturnScope constraintDef80 =null;
		ParserRuleReturnScope processDef81 =null;
		ParserRuleReturnScope eventDef82 =null;


		try {
			// Pddl.g:204:2: ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef )
			int alt27=6;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==64) ) {
				switch ( input.LA(2) ) {
				case 70:
					{
					alt27=1;
					}
					break;
				case 78:
					{
					alt27=2;
					}
					break;
				case 75:
					{
					alt27=3;
					}
					break;
				case 73:
					{
					alt27=4;
					}
					break;
				case 90:
					{
					alt27=5;
					}
					break;
				case 80:
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
					// Pddl.g:204:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef1048);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					// Pddl.g:205:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef1053);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					// Pddl.g:206:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef1058);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

					}
					break;
				case 4 :
					// Pddl.g:207:4: constraintDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constraintDef_in_structureDef1063);
					constraintDef80=constraintDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

					}
					break;
				case 5 :
					// Pddl.g:208:4: processDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_processDef_in_structureDef1068);
					processDef81=processDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, processDef81.getTree());

					}
					break;
				case 6 :
					// Pddl.g:209:4: eventDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_eventDef_in_structureDef1073);
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
	// Pddl.g:215:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws RecognitionException {
		PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// Pddl.g:216:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:216:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal83=(Token)match(input,64,FOLLOW_64_in_actionDef1088); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal83);

			string_literal84=(Token)match(input,70,FOLLOW_70_in_actionDef1090); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(string_literal84);

			pushFollow(FOLLOW_actionSymbol_in_actionDef1092);
			actionSymbol85=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol85.getTree());
			string_literal86=(Token)match(input,87,FOLLOW_87_in_actionDef1101); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal86);

			char_literal87=(Token)match(input,64,FOLLOW_64_in_actionDef1104); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal87);

			pushFollow(FOLLOW_typedVariableList_in_actionDef1106);
			typedVariableList88=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList88.getTree());
			char_literal89=(Token)match(input,65,FOLLOW_65_in_actionDef1108); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal89);

			pushFollow(FOLLOW_actionDefBody_in_actionDef1121);
			actionDefBody90=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody90.getTree());
			char_literal91=(Token)match(input,65,FOLLOW_65_in_actionDef1123); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal91);

			// AST REWRITE
			// elements: actionSymbol, typedVariableList, actionDefBody
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 219:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:219:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:219:33: ( typedVariableList )?
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


	public static class eventDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eventDef"
	// Pddl.g:221:1: eventDef : '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.eventDef_return eventDef() throws RecognitionException {
		PddlParser.eventDef_return retval = new PddlParser.eventDef_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// Pddl.g:222:2: ( '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:222:4: '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal92=(Token)match(input,64,FOLLOW_64_in_eventDef1156); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal92);

			string_literal93=(Token)match(input,80,FOLLOW_80_in_eventDef1158); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal93);

			pushFollow(FOLLOW_actionSymbol_in_eventDef1160);
			actionSymbol94=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol94.getTree());
			string_literal95=(Token)match(input,87,FOLLOW_87_in_eventDef1169); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal95);

			char_literal96=(Token)match(input,64,FOLLOW_64_in_eventDef1172); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal96);

			pushFollow(FOLLOW_typedVariableList_in_eventDef1174);
			typedVariableList97=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList97.getTree());
			char_literal98=(Token)match(input,65,FOLLOW_65_in_eventDef1176); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal98);

			pushFollow(FOLLOW_actionDefBody_in_eventDef1189);
			actionDefBody99=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody99.getTree());
			char_literal100=(Token)match(input,65,FOLLOW_65_in_eventDef1191); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal100);

			// AST REWRITE
			// elements: actionSymbol, actionDefBody, typedVariableList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 225:8: -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:225:11: ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EVENT, "EVENT"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:225:32: ( typedVariableList )?
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
	// $ANTLR end "eventDef"


	public static class processDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "processDef"
	// Pddl.g:227:1: processDef : '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.processDef_return processDef() throws RecognitionException {
		PddlParser.processDef_return retval = new PddlParser.processDef_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// Pddl.g:228:2: ( '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:228:4: '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal101=(Token)match(input,64,FOLLOW_64_in_processDef1224); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal101);

			string_literal102=(Token)match(input,90,FOLLOW_90_in_processDef1226); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_90.add(string_literal102);

			pushFollow(FOLLOW_actionSymbol_in_processDef1228);
			actionSymbol103=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol103.getTree());
			string_literal104=(Token)match(input,87,FOLLOW_87_in_processDef1237); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal104);

			char_literal105=(Token)match(input,64,FOLLOW_64_in_processDef1240); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal105);

			pushFollow(FOLLOW_typedVariableList_in_processDef1242);
			typedVariableList106=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList106.getTree());
			char_literal107=(Token)match(input,65,FOLLOW_65_in_processDef1244); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal107);

			pushFollow(FOLLOW_actionDefBody_in_processDef1257);
			actionDefBody108=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody108.getTree());
			char_literal109=(Token)match(input,65,FOLLOW_65_in_processDef1259); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal109);

			// AST REWRITE
			// elements: actionSymbol, typedVariableList, actionDefBody
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 231:8: -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:231:11: ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCESS, "PROCESS"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:231:34: ( typedVariableList )?
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintDef"
	// Pddl.g:234:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
	public final PddlParser.constraintDef_return constraintDef() throws RecognitionException {
		PddlParser.constraintDef_return retval = new PddlParser.constraintDef_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
		RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");

		try {
			// Pddl.g:235:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
			// Pddl.g:235:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
			{
			char_literal110=(Token)match(input,64,FOLLOW_64_in_constraintDef1293); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal110);

			string_literal111=(Token)match(input,73,FOLLOW_73_in_constraintDef1295); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(string_literal111);

			pushFollow(FOLLOW_constraintSymbol_in_constraintDef1297);
			constraintSymbol112=constraintSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol112.getTree());
			string_literal113=(Token)match(input,87,FOLLOW_87_in_constraintDef1306); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal113);

			char_literal114=(Token)match(input,64,FOLLOW_64_in_constraintDef1309); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal114);

			pushFollow(FOLLOW_typedVariableList_in_constraintDef1311);
			typedVariableList115=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList115.getTree());
			char_literal116=(Token)match(input,65,FOLLOW_65_in_constraintDef1313); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal116);

			pushFollow(FOLLOW_constraintDefBody_in_constraintDef1326);
			constraintDefBody117=constraintDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody117.getTree());
			char_literal118=(Token)match(input,65,FOLLOW_65_in_constraintDef1328); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal118);

			// AST REWRITE
			// elements: constraintDefBody, typedVariableList, constraintSymbol
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 238:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
			{
				// Pddl.g:238:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT"), root_1);
				adaptor.addChild(root_1, stream_constraintSymbol.nextTree());
				// Pddl.g:238:48: ( typedVariableList )?
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionSymbol"
	// Pddl.g:242:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME119=null;

		Object NAME119_tree=null;

		try {
			// Pddl.g:242:14: ( NAME )
			// Pddl.g:242:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME119=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1362); if (state.failed) return retval;
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
	// Pddl.g:244:1: constraintSymbol : NAME ;
	public final PddlParser.constraintSymbol_return constraintSymbol() throws RecognitionException {
		PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME120=null;

		Object NAME120_tree=null;

		try {
			// Pddl.g:244:18: ( NAME )
			// Pddl.g:244:20: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME120=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1371); if (state.failed) return retval;
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
	// Pddl.g:249:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
		PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
		retval.start = input.LT(1);

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
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");

		try {
			// Pddl.g:250:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// Pddl.g:250:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// Pddl.g:250:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==88) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// Pddl.g:250:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal121=(Token)match(input,88,FOLLOW_88_in_actionDefBody1386); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_88.add(string_literal121);

					// Pddl.g:250:22: ( ( '(' ')' ) | goalDesc )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==64) ) {
						int LA28_1 = input.LA(2);
						if ( (LA28_1==65) ) {
							alt28=1;
						}
						else if ( (LA28_1==NAME||(LA28_1 >= 93 && LA28_1 <= 97)||LA28_1==103||(LA28_1 >= 113 && LA28_1 <= 114)||LA28_1==117||LA28_1==122||LA28_1==124) ) {
							alt28=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 28, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
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
							// Pddl.g:250:23: ( '(' ')' )
							{
							// Pddl.g:250:23: ( '(' ')' )
							// Pddl.g:250:24: '(' ')'
							{
							char_literal122=(Token)match(input,64,FOLLOW_64_in_actionDefBody1390); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_64.add(char_literal122);

							char_literal123=(Token)match(input,65,FOLLOW_65_in_actionDefBody1392); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_65.add(char_literal123);

							}

							}
							break;
						case 2 :
							// Pddl.g:250:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1397);
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

			// Pddl.g:251:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==79) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// Pddl.g:251:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal125=(Token)match(input,79,FOLLOW_79_in_actionDefBody1407); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_79.add(string_literal125);

					// Pddl.g:251:16: ( ( '(' ')' ) | effect )
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==64) ) {
						int LA30_1 = input.LA(2);
						if ( (LA30_1==65) ) {
							alt30=1;
						}
						else if ( (LA30_1==NAME||(LA30_1 >= 103 && LA30_1 <= 104)||LA30_1==108||LA30_1==114||LA30_1==118||LA30_1==122||(LA30_1 >= 128 && LA30_1 <= 129)||LA30_1==135) ) {
							alt30=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 30, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
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
							// Pddl.g:251:17: ( '(' ')' )
							{
							// Pddl.g:251:17: ( '(' ')' )
							// Pddl.g:251:18: '(' ')'
							{
							char_literal126=(Token)match(input,64,FOLLOW_64_in_actionDefBody1411); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_64.add(char_literal126);

							char_literal127=(Token)match(input,65,FOLLOW_65_in_actionDefBody1413); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_65.add(char_literal127);

							}

							}
							break;
						case 2 :
							// Pddl.g:251:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1418);
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
			// elements: effect, goalDesc
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 252:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// Pddl.g:252:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:252:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// Pddl.g:252:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// Pddl.g:252:42: ( effect )?
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintDefBody"
	// Pddl.g:255:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
	public final PddlParser.constraintDefBody_return constraintDefBody() throws RecognitionException {
		PddlParser.constraintDefBody_return retval = new PddlParser.constraintDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal129=null;
		Token char_literal130=null;
		Token char_literal131=null;
		ParserRuleReturnScope goalDesc132 =null;

		Object string_literal129_tree=null;
		Object char_literal130_tree=null;
		Object char_literal131_tree=null;
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// Pddl.g:256:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
			// Pddl.g:256:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			{
			// Pddl.g:256:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==71) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// Pddl.g:256:6: ':condition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal129=(Token)match(input,71,FOLLOW_71_in_constraintDefBody1453); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_71.add(string_literal129);

					// Pddl.g:256:19: ( ( '(' ')' ) | goalDesc )
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==64) ) {
						int LA32_1 = input.LA(2);
						if ( (LA32_1==65) ) {
							alt32=1;
						}
						else if ( (LA32_1==NAME||(LA32_1 >= 93 && LA32_1 <= 97)||LA32_1==103||(LA32_1 >= 113 && LA32_1 <= 114)||LA32_1==117||LA32_1==122||LA32_1==124) ) {
							alt32=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 32, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
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
							// Pddl.g:256:20: ( '(' ')' )
							{
							// Pddl.g:256:20: ( '(' ')' )
							// Pddl.g:256:21: '(' ')'
							{
							char_literal130=(Token)match(input,64,FOLLOW_64_in_constraintDefBody1457); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_64.add(char_literal130);

							char_literal131=(Token)match(input,65,FOLLOW_65_in_constraintDefBody1459); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_65.add(char_literal131);

							}

							}
							break;
						case 2 :
							// Pddl.g:256:32: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_constraintDefBody1464);
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
			// 257:4: -> ^( PRECONDITION ( goalDesc )? )
			{
				// Pddl.g:257:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:257:22: ( goalDesc )?
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "goalDesc"
	// Pddl.g:272:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
		PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal134=null;
		Token string_literal135=null;
		Token char_literal137=null;
		Token char_literal138=null;
		Token string_literal139=null;
		Token char_literal141=null;
		Token char_literal142=null;
		Token string_literal143=null;
		Token char_literal145=null;
		Token char_literal146=null;
		Token string_literal147=null;
		Token char_literal150=null;
		Token char_literal151=null;
		Token string_literal152=null;
		Token char_literal153=null;
		Token char_literal155=null;
		Token char_literal157=null;
		Token char_literal158=null;
		Token string_literal159=null;
		Token char_literal160=null;
		Token char_literal162=null;
		Token char_literal164=null;
		ParserRuleReturnScope atomicTermFormula133 =null;
		ParserRuleReturnScope goalDesc136 =null;
		ParserRuleReturnScope goalDesc140 =null;
		ParserRuleReturnScope goalDesc144 =null;
		ParserRuleReturnScope goalDesc148 =null;
		ParserRuleReturnScope goalDesc149 =null;
		ParserRuleReturnScope typedVariableList154 =null;
		ParserRuleReturnScope goalDesc156 =null;
		ParserRuleReturnScope typedVariableList161 =null;
		ParserRuleReturnScope goalDesc163 =null;
		ParserRuleReturnScope fComp165 =null;
		ParserRuleReturnScope equality166 =null;

		Object char_literal134_tree=null;
		Object string_literal135_tree=null;
		Object char_literal137_tree=null;
		Object char_literal138_tree=null;
		Object string_literal139_tree=null;
		Object char_literal141_tree=null;
		Object char_literal142_tree=null;
		Object string_literal143_tree=null;
		Object char_literal145_tree=null;
		Object char_literal146_tree=null;
		Object string_literal147_tree=null;
		Object char_literal150_tree=null;
		Object char_literal151_tree=null;
		Object string_literal152_tree=null;
		Object char_literal153_tree=null;
		Object char_literal155_tree=null;
		Object char_literal157_tree=null;
		Object char_literal158_tree=null;
		Object string_literal159_tree=null;
		Object char_literal160_tree=null;
		Object char_literal162_tree=null;
		Object char_literal164_tree=null;
		RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
		RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
		RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");

		try {
			// Pddl.g:273:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt36=9;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==64) ) {
				switch ( input.LA(2) ) {
				case 103:
					{
					alt36=2;
					}
					break;
				case 124:
					{
					alt36=3;
					}
					break;
				case 122:
					{
					alt36=4;
					}
					break;
				case 117:
					{
					alt36=5;
					}
					break;
				case 113:
					{
					alt36=6;
					}
					break;
				case 114:
					{
					alt36=7;
					}
					break;
				case 95:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA36_13 = input.LA(5);
							if ( (LA36_13==65) ) {
								int LA36_14 = input.LA(6);
								if ( (synpred48_Pddl()) ) {
									alt36=8;
								}
								else if ( (true) ) {
									alt36=9;
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
										new NoViableAltException("", 36, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case NUMBER:
						case 63:
						case 64:
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
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 36, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case NUMBER:
					case 63:
					case 64:
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
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 36, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case NAME:
					{
					alt36=1;
					}
					break;
				case 93:
				case 94:
				case 96:
				case 97:
					{
					alt36=8;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 36, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:273:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1502);
					atomicTermFormula133=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula133.getTree());

					}
					break;
				case 2 :
					// Pddl.g:274:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal134=(Token)match(input,64,FOLLOW_64_in_goalDesc1507); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal134);

					string_literal135=(Token)match(input,103,FOLLOW_103_in_goalDesc1509); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(string_literal135);

					// Pddl.g:274:14: ( goalDesc )*
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==64) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// Pddl.g:274:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1511);
							goalDesc136=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc136.getTree());
							}
							break;

						default :
							break loop34;
						}
					}

					char_literal137=(Token)match(input,65,FOLLOW_65_in_goalDesc1514); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal137);

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
					// 275:12: -> ^( AND_GD ( goalDesc )* )
					{
						// Pddl.g:275:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// Pddl.g:275:24: ( goalDesc )*
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
					// Pddl.g:276:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal138=(Token)match(input,64,FOLLOW_64_in_goalDesc1539); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal138);

					string_literal139=(Token)match(input,124,FOLLOW_124_in_goalDesc1541); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_124.add(string_literal139);

					// Pddl.g:276:13: ( goalDesc )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==64) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// Pddl.g:276:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1543);
							goalDesc140=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc140.getTree());
							}
							break;

						default :
							break loop35;
						}
					}

					char_literal141=(Token)match(input,65,FOLLOW_65_in_goalDesc1546); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal141);

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
					// 277:12: -> ^( OR_GD ( goalDesc )* )
					{
						// Pddl.g:277:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:277:23: ( goalDesc )*
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
					// Pddl.g:278:4: '(' 'not' goalDesc ')'
					{
					char_literal142=(Token)match(input,64,FOLLOW_64_in_goalDesc1571); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal142);

					string_literal143=(Token)match(input,122,FOLLOW_122_in_goalDesc1573); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_122.add(string_literal143);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1575);
					goalDesc144=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc144.getTree());
					char_literal145=(Token)match(input,65,FOLLOW_65_in_goalDesc1577); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal145);

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
					// 279:12: -> ^( NOT_GD goalDesc )
					{
						// Pddl.g:279:15: ^( NOT_GD goalDesc )
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
					// Pddl.g:280:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal146=(Token)match(input,64,FOLLOW_64_in_goalDesc1601); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal146);

					string_literal147=(Token)match(input,117,FOLLOW_117_in_goalDesc1603); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_117.add(string_literal147);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1605);
					goalDesc148=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc148.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1607);
					goalDesc149=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc149.getTree());
					char_literal150=(Token)match(input,65,FOLLOW_65_in_goalDesc1609); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal150);

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
					// 281:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// Pddl.g:281:15: ^( IMPLY_GD goalDesc goalDesc )
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
				case 6 :
					// Pddl.g:282:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal151=(Token)match(input,64,FOLLOW_64_in_goalDesc1635); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal151);

					string_literal152=(Token)match(input,113,FOLLOW_113_in_goalDesc1637); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal152);

					char_literal153=(Token)match(input,64,FOLLOW_64_in_goalDesc1639); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal153);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1641);
					typedVariableList154=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList154.getTree());
					char_literal155=(Token)match(input,65,FOLLOW_65_in_goalDesc1643); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal155);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1645);
					goalDesc156=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc156.getTree());
					char_literal157=(Token)match(input,65,FOLLOW_65_in_goalDesc1647); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal157);

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
					// 283:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// Pddl.g:283:15: ^( EXISTS_GD typedVariableList goalDesc )
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
				case 7 :
					// Pddl.g:284:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal158=(Token)match(input,64,FOLLOW_64_in_goalDesc1673); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal158);

					string_literal159=(Token)match(input,114,FOLLOW_114_in_goalDesc1675); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_114.add(string_literal159);

					char_literal160=(Token)match(input,64,FOLLOW_64_in_goalDesc1677); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal160);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1679);
					typedVariableList161=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList161.getTree());
					char_literal162=(Token)match(input,65,FOLLOW_65_in_goalDesc1681); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal162);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1683);
					goalDesc163=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc163.getTree());
					char_literal164=(Token)match(input,65,FOLLOW_65_in_goalDesc1685); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal164);

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
					// 285:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// Pddl.g:285:15: ^( FORALL_GD typedVariableList goalDesc )
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
				case 8 :
					// Pddl.g:286:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1714);
					fComp165=fComp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fComp.add(fComp165.getTree());
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
					// 287:15: -> ^( COMPARISON_GD fComp )
					{
						// Pddl.g:287:18: ^( COMPARISON_GD fComp )
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
				case 9 :
					// Pddl.g:288:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1741);
					equality166=equality();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_equality.add(equality166.getTree());
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
					// 289:6: -> ^( EQUALITY_CON equality )
					{
						// Pddl.g:289:9: ^( EQUALITY_CON equality )
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
	// Pddl.g:292:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws RecognitionException {
		PddlParser.equality_return retval = new PddlParser.equality_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal167=null;
		Token char_literal168=null;
		Token char_literal171=null;
		ParserRuleReturnScope term169 =null;
		ParserRuleReturnScope term170 =null;

		Object char_literal167_tree=null;
		Object char_literal168_tree=null;
		Object char_literal171_tree=null;

		try {
			// Pddl.g:293:2: ( '(' ! '=' term term ')' !)
			// Pddl.g:293:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal167=(Token)match(input,64,FOLLOW_64_in_equality1769); if (state.failed) return retval;
			char_literal168=(Token)match(input,95,FOLLOW_95_in_equality1772); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal168_tree = (Object)adaptor.create(char_literal168);
			adaptor.addChild(root_0, char_literal168_tree);
			}

			pushFollow(FOLLOW_term_in_equality1774);
			term169=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term169.getTree());

			pushFollow(FOLLOW_term_in_equality1776);
			term170=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term170.getTree());

			char_literal171=(Token)match(input,65,FOLLOW_65_in_equality1778); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fComp"
	// Pddl.g:295:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws RecognitionException {
		PddlParser.fComp_return retval = new PddlParser.fComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal172=null;
		Token char_literal176=null;
		ParserRuleReturnScope binaryComp173 =null;
		ParserRuleReturnScope fExp174 =null;
		ParserRuleReturnScope fExp175 =null;

		Object char_literal172_tree=null;
		Object char_literal176_tree=null;

		try {
			// Pddl.g:296:2: ( '(' ! binaryComp fExp fExp ')' !)
			// Pddl.g:296:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal172=(Token)match(input,64,FOLLOW_64_in_fComp1789); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1792);
			binaryComp173=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp173.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1794);
			fExp174=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp174.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1796);
			fExp175=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp175.getTree());

			char_literal176=(Token)match(input,65,FOLLOW_65_in_fComp1798); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomicTermFormula"
	// Pddl.g:299:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal177=null;
		Token char_literal180=null;
		ParserRuleReturnScope predicate178 =null;
		ParserRuleReturnScope term179 =null;

		Object char_literal177_tree=null;
		Object char_literal180_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// Pddl.g:300:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// Pddl.g:300:4: '(' predicate ( term )* ')'
			{
			char_literal177=(Token)match(input,64,FOLLOW_64_in_atomicTermFormula1810); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal177);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1812);
			predicate178=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate178.getTree());
			// Pddl.g:300:18: ( term )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==NAME||LA37_0==VARIABLE) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// Pddl.g:300:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1814);
					term179=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_term.add(term179.getTree());
					}
					break;

				default :
					break loop37;
				}
			}

			char_literal180=(Token)match(input,65,FOLLOW_65_in_atomicTermFormula1817); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal180);

			// AST REWRITE
			// elements: term, predicate
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 300:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// Pddl.g:300:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:300:53: ( term )*
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// Pddl.g:303:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set181=null;

		Object set181_tree=null;

		try {
			// Pddl.g:303:6: ( NAME | VARIABLE )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set181=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set181));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durativeActionDef"
	// Pddl.g:307:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
		PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal182=null;
		Token string_literal183=null;
		Token string_literal185=null;
		Token char_literal186=null;
		Token char_literal188=null;
		Token char_literal190=null;
		ParserRuleReturnScope actionSymbol184 =null;
		ParserRuleReturnScope typedVariableList187 =null;
		ParserRuleReturnScope daDefBody189 =null;

		Object char_literal182_tree=null;
		Object string_literal183_tree=null;
		Object string_literal185_tree=null;
		Object char_literal186_tree=null;
		Object char_literal188_tree=null;
		Object char_literal190_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// Pddl.g:308:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// Pddl.g:308:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal182=(Token)match(input,64,FOLLOW_64_in_durativeActionDef1854); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal182);

			string_literal183=(Token)match(input,78,FOLLOW_78_in_durativeActionDef1856); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal183);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1858);
			actionSymbol184=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol184.getTree());
			string_literal185=(Token)match(input,87,FOLLOW_87_in_durativeActionDef1867); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal185);

			char_literal186=(Token)match(input,64,FOLLOW_64_in_durativeActionDef1870); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal186);

			// Pddl.g:309:27: ( typedVariableList )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==VARIABLE) ) {
				alt38=1;
			}
			else if ( (LA38_0==65) ) {
				int LA38_2 = input.LA(2);
				if ( (synpred51_Pddl()) ) {
					alt38=1;
				}
			}
			switch (alt38) {
				case 1 :
					// Pddl.g:309:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1873);
					typedVariableList187=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList187.getTree());
					}
					break;

			}

			char_literal188=(Token)match(input,65,FOLLOW_65_in_durativeActionDef1877); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal188);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1890);
			daDefBody189=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody189.getTree());
			char_literal190=(Token)match(input,65,FOLLOW_65_in_durativeActionDef1892); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal190);

			// AST REWRITE
			// elements: typedVariableList, actionSymbol, daDefBody
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 311:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// Pddl.g:311:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
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
	// Pddl.g:314:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
		PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal191=null;
		Token string_literal193=null;
		Token char_literal194=null;
		Token char_literal195=null;
		Token string_literal197=null;
		Token char_literal198=null;
		Token char_literal199=null;
		ParserRuleReturnScope durationConstraint192 =null;
		ParserRuleReturnScope daGD196 =null;
		ParserRuleReturnScope daEffect200 =null;

		Object string_literal191_tree=null;
		Object string_literal193_tree=null;
		Object char_literal194_tree=null;
		Object char_literal195_tree=null;
		Object string_literal197_tree=null;
		Object char_literal198_tree=null;
		Object char_literal199_tree=null;

		try {
			// Pddl.g:315:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt41=3;
			switch ( input.LA(1) ) {
			case 77:
				{
				alt41=1;
				}
				break;
			case 71:
				{
				alt41=2;
				}
				break;
			case 79:
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
					// Pddl.g:315:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal191=(Token)match(input,77,FOLLOW_77_in_daDefBody1925); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal191_tree = (Object)adaptor.create(string_literal191);
					adaptor.addChild(root_0, string_literal191_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody1927);
					durationConstraint192=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint192.getTree());

					}
					break;
				case 2 :
					// Pddl.g:316:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal193=(Token)match(input,71,FOLLOW_71_in_daDefBody1932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal193_tree = (Object)adaptor.create(string_literal193);
					adaptor.addChild(root_0, string_literal193_tree);
					}

					// Pddl.g:316:17: ( ( '(' ')' ) | daGD )
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==64) ) {
						int LA39_1 = input.LA(2);
						if ( (LA39_1==65) ) {
							alt39=1;
						}
						else if ( (LA39_1==103||LA39_1==105||LA39_1==114||(LA39_1 >= 125 && LA39_1 <= 126)) ) {
							alt39=2;
						}

						else {
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
							// Pddl.g:316:18: ( '(' ')' )
							{
							// Pddl.g:316:18: ( '(' ')' )
							// Pddl.g:316:19: '(' ')'
							{
							char_literal194=(Token)match(input,64,FOLLOW_64_in_daDefBody1936); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal194_tree = (Object)adaptor.create(char_literal194);
							adaptor.addChild(root_0, char_literal194_tree);
							}

							char_literal195=(Token)match(input,65,FOLLOW_65_in_daDefBody1938); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal195_tree = (Object)adaptor.create(char_literal195);
							adaptor.addChild(root_0, char_literal195_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:316:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody1943);
							daGD196=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD196.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// Pddl.g:317:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal197=(Token)match(input,79,FOLLOW_79_in_daDefBody1952); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal197_tree = (Object)adaptor.create(string_literal197);
					adaptor.addChild(root_0, string_literal197_tree);
					}

					// Pddl.g:317:17: ( ( '(' ')' ) | daEffect )
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==64) ) {
						int LA40_1 = input.LA(2);
						if ( (LA40_1==65) ) {
							alt40=1;
						}
						else if ( ((LA40_1 >= 103 && LA40_1 <= 105)||LA40_1==108||LA40_1==114||LA40_1==118||(LA40_1 >= 128 && LA40_1 <= 129)||LA40_1==135) ) {
							alt40=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 40, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
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
							// Pddl.g:317:18: ( '(' ')' )
							{
							// Pddl.g:317:18: ( '(' ')' )
							// Pddl.g:317:19: '(' ')'
							{
							char_literal198=(Token)match(input,64,FOLLOW_64_in_daDefBody1956); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal198_tree = (Object)adaptor.create(char_literal198);
							adaptor.addChild(root_0, char_literal198_tree);
							}

							char_literal199=(Token)match(input,65,FOLLOW_65_in_daDefBody1958); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal199_tree = (Object)adaptor.create(char_literal199);
							adaptor.addChild(root_0, char_literal199_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:317:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody1963);
							daEffect200=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect200.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "daGD"
	// Pddl.g:320:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws RecognitionException {
		PddlParser.daGD_return retval = new PddlParser.daGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal202=null;
		Token string_literal203=null;
		Token char_literal205=null;
		Token char_literal206=null;
		Token string_literal207=null;
		Token char_literal208=null;
		Token char_literal210=null;
		Token char_literal212=null;
		ParserRuleReturnScope prefTimedGD201 =null;
		ParserRuleReturnScope daGD204 =null;
		ParserRuleReturnScope typedVariableList209 =null;
		ParserRuleReturnScope daGD211 =null;

		Object char_literal202_tree=null;
		Object string_literal203_tree=null;
		Object char_literal205_tree=null;
		Object char_literal206_tree=null;
		Object string_literal207_tree=null;
		Object char_literal208_tree=null;
		Object char_literal210_tree=null;
		Object char_literal212_tree=null;

		try {
			// Pddl.g:321:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt43=3;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==64) ) {
				switch ( input.LA(2) ) {
				case 105:
				case 125:
				case 126:
					{
					alt43=1;
					}
					break;
				case 103:
					{
					alt43=2;
					}
					break;
				case 114:
					{
					alt43=3;
					}
					break;
				default:
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
					// Pddl.g:321:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD1978);
					prefTimedGD201=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD201.getTree());

					}
					break;
				case 2 :
					// Pddl.g:322:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal202=(Token)match(input,64,FOLLOW_64_in_daGD1983); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal202_tree = (Object)adaptor.create(char_literal202);
					adaptor.addChild(root_0, char_literal202_tree);
					}

					string_literal203=(Token)match(input,103,FOLLOW_103_in_daGD1985); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal203_tree = (Object)adaptor.create(string_literal203);
					adaptor.addChild(root_0, string_literal203_tree);
					}

					// Pddl.g:322:14: ( daGD )*
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( (LA42_0==64) ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// Pddl.g:322:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD1987);
							daGD204=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD204.getTree());

							}
							break;

						default :
							break loop42;
						}
					}

					char_literal205=(Token)match(input,65,FOLLOW_65_in_daGD1990); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal205_tree = (Object)adaptor.create(char_literal205);
					adaptor.addChild(root_0, char_literal205_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:323:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal206=(Token)match(input,64,FOLLOW_64_in_daGD1995); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal206_tree = (Object)adaptor.create(char_literal206);
					adaptor.addChild(root_0, char_literal206_tree);
					}

					string_literal207=(Token)match(input,114,FOLLOW_114_in_daGD1997); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal207_tree = (Object)adaptor.create(string_literal207);
					adaptor.addChild(root_0, string_literal207_tree);
					}

					char_literal208=(Token)match(input,64,FOLLOW_64_in_daGD1999); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal208_tree = (Object)adaptor.create(char_literal208);
					adaptor.addChild(root_0, char_literal208_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD2001);
					typedVariableList209=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList209.getTree());

					char_literal210=(Token)match(input,65,FOLLOW_65_in_daGD2003); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal210_tree = (Object)adaptor.create(char_literal210);
					adaptor.addChild(root_0, char_literal210_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD2005);
					daGD211=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD211.getTree());

					char_literal212=(Token)match(input,65,FOLLOW_65_in_daGD2007); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal212_tree = (Object)adaptor.create(char_literal212);
					adaptor.addChild(root_0, char_literal212_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prefTimedGD"
	// Pddl.g:326:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
		PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal214=null;
		Token string_literal215=null;
		Token NAME216=null;
		Token char_literal218=null;
		ParserRuleReturnScope timedGD213 =null;
		ParserRuleReturnScope timedGD217 =null;

		Object char_literal214_tree=null;
		Object string_literal215_tree=null;
		Object NAME216_tree=null;
		Object char_literal218_tree=null;

		try {
			// Pddl.g:327:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==64) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==105||LA45_1==125) ) {
					alt45=1;
				}
				else if ( (LA45_1==126) ) {
					alt45=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:327:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD2018);
					timedGD213=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD213.getTree());

					}
					break;
				case 2 :
					// Pddl.g:328:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal214=(Token)match(input,64,FOLLOW_64_in_prefTimedGD2023); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (Object)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}

					string_literal215=(Token)match(input,126,FOLLOW_126_in_prefTimedGD2025); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal215_tree = (Object)adaptor.create(string_literal215);
					adaptor.addChild(root_0, string_literal215_tree);
					}

					// Pddl.g:328:21: ( NAME )?
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==NAME) ) {
						alt44=1;
					}
					switch (alt44) {
						case 1 :
							// Pddl.g:328:21: NAME
							{
							NAME216=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD2027); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME216_tree = (Object)adaptor.create(NAME216);
							adaptor.addChild(root_0, NAME216_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD2030);
					timedGD217=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD217.getTree());

					char_literal218=(Token)match(input,65,FOLLOW_65_in_prefTimedGD2032); if (state.failed) return retval;
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
	// Pddl.g:331:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws RecognitionException {
		PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal219=null;
		Token string_literal220=null;
		Token char_literal223=null;
		Token char_literal224=null;
		Token string_literal225=null;
		Token char_literal228=null;
		ParserRuleReturnScope timeSpecifier221 =null;
		ParserRuleReturnScope goalDesc222 =null;
		ParserRuleReturnScope interval226 =null;
		ParserRuleReturnScope goalDesc227 =null;

		Object char_literal219_tree=null;
		Object string_literal220_tree=null;
		Object char_literal223_tree=null;
		Object char_literal224_tree=null;
		Object string_literal225_tree=null;
		Object char_literal228_tree=null;

		try {
			// Pddl.g:332:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==64) ) {
				int LA46_1 = input.LA(2);
				if ( (LA46_1==105) ) {
					alt46=1;
				}
				else if ( (LA46_1==125) ) {
					alt46=2;
				}

				else {
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
					// Pddl.g:332:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal219=(Token)match(input,64,FOLLOW_64_in_timedGD2043); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal219_tree = (Object)adaptor.create(char_literal219);
					adaptor.addChild(root_0, char_literal219_tree);
					}

					string_literal220=(Token)match(input,105,FOLLOW_105_in_timedGD2045); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal220_tree = (Object)adaptor.create(string_literal220);
					adaptor.addChild(root_0, string_literal220_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD2047);
					timeSpecifier221=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier221.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2049);
					goalDesc222=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc222.getTree());

					char_literal223=(Token)match(input,65,FOLLOW_65_in_timedGD2051); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal223_tree = (Object)adaptor.create(char_literal223);
					adaptor.addChild(root_0, char_literal223_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:333:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal224=(Token)match(input,64,FOLLOW_64_in_timedGD2056); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal224_tree = (Object)adaptor.create(char_literal224);
					adaptor.addChild(root_0, char_literal224_tree);
					}

					string_literal225=(Token)match(input,125,FOLLOW_125_in_timedGD2058); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal225_tree = (Object)adaptor.create(string_literal225);
					adaptor.addChild(root_0, string_literal225_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD2060);
					interval226=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval226.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD2062);
					goalDesc227=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc227.getTree());

					char_literal228=(Token)match(input,65,FOLLOW_65_in_timedGD2064); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal228_tree = (Object)adaptor.create(char_literal228);
					adaptor.addChild(root_0, char_literal228_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timeSpecifier"
	// Pddl.g:336:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set229=null;

		Object set229_tree=null;

		try {
			// Pddl.g:336:15: ( 'start' | 'end' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set229=input.LT(1);
			if ( input.LA(1)==112||input.LA(1)==134 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set229));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "interval"
	// Pddl.g:337:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal230=null;

		Object string_literal230_tree=null;

		try {
			// Pddl.g:337:10: ( 'all' )
			// Pddl.g:337:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal230=(Token)match(input,100,FOLLOW_100_in_interval2086); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal230_tree = (Object)adaptor.create(string_literal230);
			adaptor.addChild(root_0, string_literal230_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "derivedDef"
	// Pddl.g:341:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
		PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal231=null;
		Token string_literal232=null;
		Token char_literal235=null;
		ParserRuleReturnScope typedVariableList233 =null;
		ParserRuleReturnScope goalDesc234 =null;

		Object char_literal231_tree=null;
		Object string_literal232_tree=null;
		Object char_literal235_tree=null;

		try {
			// Pddl.g:342:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// Pddl.g:342:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal231=(Token)match(input,64,FOLLOW_64_in_derivedDef2099); if (state.failed) return retval;
			string_literal232=(Token)match(input,75,FOLLOW_75_in_derivedDef2102); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal232_tree = (Object)adaptor.create(string_literal232);
			root_0 = (Object)adaptor.becomeRoot(string_literal232_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef2105);
			typedVariableList233=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList233.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef2107);
			goalDesc234=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc234.getTree());

			char_literal235=(Token)match(input,65,FOLLOW_65_in_derivedDef2109); if (state.failed) return retval;
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExp"
	// Pddl.g:347:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws RecognitionException {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER236=null;
		Token char_literal237=null;
		Token char_literal241=null;
		Token char_literal242=null;
		Token char_literal243=null;
		Token char_literal245=null;
		Token char_literal246=null;
		Token string_literal247=null;
		Token char_literal249=null;
		Token char_literal250=null;
		Token string_literal251=null;
		Token char_literal253=null;
		ParserRuleReturnScope binaryOp238 =null;
		ParserRuleReturnScope fExp239 =null;
		ParserRuleReturnScope fExp2240 =null;
		ParserRuleReturnScope fExp244 =null;
		ParserRuleReturnScope fExp248 =null;
		ParserRuleReturnScope fExp252 =null;
		ParserRuleReturnScope fHead254 =null;

		Object NUMBER236_tree=null;
		Object char_literal237_tree=null;
		Object char_literal241_tree=null;
		Object char_literal242_tree=null;
		Object char_literal243_tree=null;
		Object char_literal245_tree=null;
		Object char_literal246_tree=null;
		Object string_literal247_tree=null;
		Object char_literal249_tree=null;
		Object char_literal250_tree=null;
		Object string_literal251_tree=null;
		Object char_literal253_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			// Pddl.g:348:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | '(' 'sin' fExp ')' -> ^( SIN fExp ) | '(' 'cos' fExp ')' -> ^( COS fExp ) | fHead )
			int alt47=6;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt47=1;
				}
				break;
			case 64:
				{
				int LA47_2 = input.LA(2);
				if ( (synpred64_Pddl()) ) {
					alt47=2;
				}
				else if ( (synpred65_Pddl()) ) {
					alt47=3;
				}
				else if ( (synpred66_Pddl()) ) {
					alt47=4;
				}
				else if ( (synpred67_Pddl()) ) {
					alt47=5;
				}
				else if ( (true) ) {
					alt47=6;
				}

				}
				break;
			case NAME:
			case 63:
				{
				alt47=6;
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
					// Pddl.g:348:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER236=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp2124); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER236_tree = (Object)adaptor.create(NUMBER236);
					adaptor.addChild(root_0, NUMBER236_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:349:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal237=(Token)match(input,64,FOLLOW_64_in_fExp2129); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal237);

					pushFollow(FOLLOW_binaryOp_in_fExp2131);
					binaryOp238=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp238.getTree());
					pushFollow(FOLLOW_fExp_in_fExp2133);
					fExp239=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp239.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp2135);
					fExp2240=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2240.getTree());
					char_literal241=(Token)match(input,65,FOLLOW_65_in_fExp2137); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal241);

					// AST REWRITE
					// elements: fExp2, fExp, binaryOp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 349:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// Pddl.g:349:35: ^( BINARY_OP binaryOp fExp fExp2 )
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
					// Pddl.g:350:4: '(' '-' fExp ')'
					{
					char_literal242=(Token)match(input,64,FOLLOW_64_in_fExp2154); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal242);

					char_literal243=(Token)match(input,68,FOLLOW_68_in_fExp2156); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_68.add(char_literal243);

					pushFollow(FOLLOW_fExp_in_fExp2158);
					fExp244=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp244.getTree());
					char_literal245=(Token)match(input,65,FOLLOW_65_in_fExp2160); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal245);

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
					// 350:21: -> ^( UNARY_MINUS fExp )
					{
						// Pddl.g:350:24: ^( UNARY_MINUS fExp )
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
					// Pddl.g:351:7: '(' 'sin' fExp ')'
					{
					char_literal246=(Token)match(input,64,FOLLOW_64_in_fExp2176); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal246);

					string_literal247=(Token)match(input,130,FOLLOW_130_in_fExp2178); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_130.add(string_literal247);

					pushFollow(FOLLOW_fExp_in_fExp2180);
					fExp248=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp248.getTree());
					char_literal249=(Token)match(input,65,FOLLOW_65_in_fExp2182); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal249);

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
					// 351:26: -> ^( SIN fExp )
					{
						// Pddl.g:351:29: ^( SIN fExp )
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
					// Pddl.g:352:7: '(' 'cos' fExp ')'
					{
					char_literal250=(Token)match(input,64,FOLLOW_64_in_fExp2198); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal250);

					string_literal251=(Token)match(input,107,FOLLOW_107_in_fExp2200); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_107.add(string_literal251);

					pushFollow(FOLLOW_fExp_in_fExp2202);
					fExp252=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp252.getTree());
					char_literal253=(Token)match(input,65,FOLLOW_65_in_fExp2204); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal253);

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
					// 352:26: -> ^( COS fExp )
					{
						// Pddl.g:352:29: ^( COS fExp )
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
					// Pddl.g:353:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp2217);
					fHead254=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead254.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExp2"
	// Pddl.g:358:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fExp255 =null;


		try {
			// Pddl.g:358:7: ( fExp )
			// Pddl.g:358:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp22229);
			fExp255=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp255.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fHead"
	// Pddl.g:360:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal256=null;
		Token char_literal259=null;
		ParserRuleReturnScope functionSymbol257 =null;
		ParserRuleReturnScope term258 =null;
		ParserRuleReturnScope functionSymbol260 =null;

		Object char_literal256_tree=null;
		Object char_literal259_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			// Pddl.g:361:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==64) ) {
				alt49=1;
			}
			else if ( (LA49_0==NAME||LA49_0==63) ) {
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
					// Pddl.g:361:4: '(' functionSymbol ( term )* ')'
					{
					char_literal256=(Token)match(input,64,FOLLOW_64_in_fHead2239); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal256);

					pushFollow(FOLLOW_functionSymbol_in_fHead2241);
					functionSymbol257=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol257.getTree());
					// Pddl.g:361:23: ( term )*
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==NAME||LA48_0==VARIABLE) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// Pddl.g:361:23: term
							{
							pushFollow(FOLLOW_term_in_fHead2243);
							term258=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term258.getTree());
							}
							break;

						default :
							break loop48;
						}
					}

					char_literal259=(Token)match(input,65,FOLLOW_65_in_fHead2246); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal259);

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
					// 361:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// Pddl.g:361:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// Pddl.g:361:63: ( term )*
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
					// Pddl.g:362:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead2262);
					functionSymbol260=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol260.getTree());
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
					// 362:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// Pddl.g:362:22: ^( FUNC_HEAD functionSymbol )
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
	// Pddl.g:365:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal261=null;
		Token string_literal262=null;
		Token char_literal264=null;
		ParserRuleReturnScope cEffect263 =null;
		ParserRuleReturnScope cEffect265 =null;

		Object char_literal261_tree=null;
		Object string_literal262_tree=null;
		Object char_literal264_tree=null;
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			// Pddl.g:366:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==64) ) {
				int LA51_1 = input.LA(2);
				if ( (LA51_1==103) ) {
					alt51=1;
				}
				else if ( (LA51_1==NAME||LA51_1==104||LA51_1==108||LA51_1==114||LA51_1==118||LA51_1==122||(LA51_1 >= 128 && LA51_1 <= 129)||LA51_1==135) ) {
					alt51=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 51, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:366:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal261=(Token)match(input,64,FOLLOW_64_in_effect2281); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal261);

					string_literal262=(Token)match(input,103,FOLLOW_103_in_effect2283); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(string_literal262);

					// Pddl.g:366:14: ( cEffect )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==64) ) {
							alt50=1;
						}

						switch (alt50) {
						case 1 :
							// Pddl.g:366:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect2285);
							cEffect263=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect263.getTree());
							}
							break;

						default :
							break loop50;
						}
					}

					char_literal264=(Token)match(input,65,FOLLOW_65_in_effect2288); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal264);

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
					// 366:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// Pddl.g:366:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:366:43: ( cEffect )*
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
					// Pddl.g:367:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect2302);
					cEffect265=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect265.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cEffect"
	// Pddl.g:370:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal266=null;
		Token string_literal267=null;
		Token char_literal268=null;
		Token char_literal270=null;
		Token char_literal272=null;
		Token char_literal273=null;
		Token string_literal274=null;
		Token char_literal277=null;
		ParserRuleReturnScope typedVariableList269 =null;
		ParserRuleReturnScope effect271 =null;
		ParserRuleReturnScope goalDesc275 =null;
		ParserRuleReturnScope condEffect276 =null;
		ParserRuleReturnScope pEffect278 =null;

		Object char_literal266_tree=null;
		Object string_literal267_tree=null;
		Object char_literal268_tree=null;
		Object char_literal270_tree=null;
		Object char_literal272_tree=null;
		Object char_literal273_tree=null;
		Object string_literal274_tree=null;
		Object char_literal277_tree=null;
		RewriteRuleTokenStream stream_135=new RewriteRuleTokenStream(adaptor,"token 135");
		RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");

		try {
			// Pddl.g:371:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt52=3;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==64) ) {
				switch ( input.LA(2) ) {
				case 114:
					{
					alt52=1;
					}
					break;
				case 135:
					{
					alt52=2;
					}
					break;
				case NAME:
				case 104:
				case 108:
				case 118:
				case 122:
				case 128:
				case 129:
					{
					alt52=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 52, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:371:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal266=(Token)match(input,64,FOLLOW_64_in_cEffect2313); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal266);

					string_literal267=(Token)match(input,114,FOLLOW_114_in_cEffect2315); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_114.add(string_literal267);

					char_literal268=(Token)match(input,64,FOLLOW_64_in_cEffect2317); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal268);

					pushFollow(FOLLOW_typedVariableList_in_cEffect2319);
					typedVariableList269=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList269.getTree());
					char_literal270=(Token)match(input,65,FOLLOW_65_in_cEffect2321); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal270);

					pushFollow(FOLLOW_effect_in_cEffect2323);
					effect271=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect271.getTree());
					char_literal272=(Token)match(input,65,FOLLOW_65_in_cEffect2325); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal272);

					// AST REWRITE
					// elements: typedVariableList, effect
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 372:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// Pddl.g:372:7: ^( FORALL_EFFECT typedVariableList effect )
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
					// Pddl.g:373:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal273=(Token)match(input,64,FOLLOW_64_in_cEffect2343); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal273);

					string_literal274=(Token)match(input,135,FOLLOW_135_in_cEffect2345); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_135.add(string_literal274);

					pushFollow(FOLLOW_goalDesc_in_cEffect2347);
					goalDesc275=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc275.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect2349);
					condEffect276=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect276.getTree());
					char_literal277=(Token)match(input,65,FOLLOW_65_in_cEffect2351); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal277);

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
					// 374:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// Pddl.g:374:7: ^( WHEN_EFFECT goalDesc condEffect )
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
					// Pddl.g:375:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect2369);
					pEffect278=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect278.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pEffect"
	// Pddl.g:378:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal279=null;
		Token char_literal283=null;
		Token char_literal284=null;
		Token string_literal285=null;
		Token char_literal287=null;
		ParserRuleReturnScope assignOp280 =null;
		ParserRuleReturnScope fHead281 =null;
		ParserRuleReturnScope fExp282 =null;
		ParserRuleReturnScope atomicTermFormula286 =null;
		ParserRuleReturnScope atomicTermFormula288 =null;

		Object char_literal279_tree=null;
		Object char_literal283_tree=null;
		Object char_literal284_tree=null;
		Object string_literal285_tree=null;
		Object char_literal287_tree=null;
		RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");

		try {
			// Pddl.g:379:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt53=3;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==64) ) {
				switch ( input.LA(2) ) {
				case 122:
					{
					alt53=2;
					}
					break;
				case 104:
				case 108:
				case 118:
				case 128:
				case 129:
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
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 53, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:379:4: '(' assignOp fHead fExp ')'
					{
					char_literal279=(Token)match(input,64,FOLLOW_64_in_pEffect2380); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal279);

					pushFollow(FOLLOW_assignOp_in_pEffect2382);
					assignOp280=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp280.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect2384);
					fHead281=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead281.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect2386);
					fExp282=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp282.getTree());
					char_literal283=(Token)match(input,65,FOLLOW_65_in_pEffect2388); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal283);

					// AST REWRITE
					// elements: fHead, fExp, assignOp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 380:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// Pddl.g:380:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
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
					// Pddl.g:381:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal284=(Token)match(input,64,FOLLOW_64_in_pEffect2408); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal284);

					string_literal285=(Token)match(input,122,FOLLOW_122_in_pEffect2410); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_122.add(string_literal285);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2412);
					atomicTermFormula286=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula286.getTree());
					char_literal287=(Token)match(input,65,FOLLOW_65_in_pEffect2414); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal287);

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
					// 382:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// Pddl.g:382:7: ^( NOT_EFFECT atomicTermFormula )
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
					// Pddl.g:383:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2430);
					atomicTermFormula288=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula288.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condEffect"
	// Pddl.g:388:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal289=null;
		Token string_literal290=null;
		Token char_literal292=null;
		ParserRuleReturnScope pEffect291 =null;
		ParserRuleReturnScope pEffect293 =null;

		Object char_literal289_tree=null;
		Object string_literal290_tree=null;
		Object char_literal292_tree=null;
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			// Pddl.g:389:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==64) ) {
				int LA55_1 = input.LA(2);
				if ( (LA55_1==103) ) {
					alt55=1;
				}
				else if ( (LA55_1==NAME||LA55_1==104||LA55_1==108||LA55_1==118||LA55_1==122||(LA55_1 >= 128 && LA55_1 <= 129)) ) {
					alt55=2;
				}

				else {
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
					// Pddl.g:389:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal289=(Token)match(input,64,FOLLOW_64_in_condEffect2443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal289);

					string_literal290=(Token)match(input,103,FOLLOW_103_in_condEffect2445); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(string_literal290);

					// Pddl.g:389:14: ( pEffect )*
					loop54:
					while (true) {
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==64) ) {
							alt54=1;
						}

						switch (alt54) {
						case 1 :
							// Pddl.g:389:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2447);
							pEffect291=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect291.getTree());
							}
							break;

						default :
							break loop54;
						}
					}

					char_literal292=(Token)match(input,65,FOLLOW_65_in_condEffect2450); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal292);

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
					// 389:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// Pddl.g:389:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:389:43: ( pEffect )*
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
					// Pddl.g:390:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2464);
					pEffect293=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect293.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryOp"
	// Pddl.g:395:1: binaryOp : ( '*' | '+' | '-' | '/' | '^' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set294=null;

		Object set294_tree=null;

		try {
			// Pddl.g:395:10: ( '*' | '+' | '-' | '/' | '^' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set294=input.LT(1);
			if ( (input.LA(1) >= 66 && input.LA(1) <= 69)||input.LA(1)==99 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set294));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multiOp"
	// Pddl.g:397:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set295=null;

		Object set295_tree=null;

		try {
			// Pddl.g:397:9: ( '*' | '+' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set295=input.LT(1);
			if ( (input.LA(1) >= 66 && input.LA(1) <= 67) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set295));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryComp"
	// Pddl.g:399:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set296=null;

		Object set296_tree=null;

		try {
			// Pddl.g:399:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set296=input.LT(1);
			if ( (input.LA(1) >= 93 && input.LA(1) <= 97) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set296));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignOp"
	// Pddl.g:401:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set297=null;

		Object set297_tree=null;

		try {
			// Pddl.g:401:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set297=input.LT(1);
			if ( input.LA(1)==104||input.LA(1)==108||input.LA(1)==118||(input.LA(1) >= 128 && input.LA(1) <= 129) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set297));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durationConstraint"
	// Pddl.g:406:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal298=null;
		Token string_literal299=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token char_literal303=null;
		ParserRuleReturnScope simpleDurationConstraint300 =null;
		ParserRuleReturnScope simpleDurationConstraint304 =null;

		Object char_literal298_tree=null;
		Object string_literal299_tree=null;
		Object char_literal301_tree=null;
		Object char_literal302_tree=null;
		Object char_literal303_tree=null;

		try {
			// Pddl.g:407:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt57=3;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==64) ) {
				switch ( input.LA(2) ) {
				case 103:
					{
					alt57=1;
					}
					break;
				case 65:
					{
					alt57=2;
					}
					break;
				case 94:
				case 95:
				case 97:
				case 105:
					{
					alt57=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 57, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:407:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal298=(Token)match(input,64,FOLLOW_64_in_durationConstraint2569); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal298_tree = (Object)adaptor.create(char_literal298);
					adaptor.addChild(root_0, char_literal298_tree);
					}

					string_literal299=(Token)match(input,103,FOLLOW_103_in_durationConstraint2571); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal299_tree = (Object)adaptor.create(string_literal299);
					adaptor.addChild(root_0, string_literal299_tree);
					}

					// Pddl.g:407:14: ( simpleDurationConstraint )+
					int cnt56=0;
					loop56:
					while (true) {
						int alt56=2;
						int LA56_0 = input.LA(1);
						if ( (LA56_0==64) ) {
							alt56=1;
						}

						switch (alt56) {
						case 1 :
							// Pddl.g:407:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2573);
							simpleDurationConstraint300=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint300.getTree());

							}
							break;

						default :
							if ( cnt56 >= 1 ) break loop56;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(56, input);
							throw eee;
						}
						cnt56++;
					}

					char_literal301=(Token)match(input,65,FOLLOW_65_in_durationConstraint2576); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:408:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal302=(Token)match(input,64,FOLLOW_64_in_durationConstraint2581); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal302_tree = (Object)adaptor.create(char_literal302);
					adaptor.addChild(root_0, char_literal302_tree);
					}

					char_literal303=(Token)match(input,65,FOLLOW_65_in_durationConstraint2583); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal303_tree = (Object)adaptor.create(char_literal303);
					adaptor.addChild(root_0, char_literal303_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:409:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2588);
					simpleDurationConstraint304=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint304.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "simpleDurationConstraint"
	// Pddl.g:412:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal305=null;
		Token string_literal307=null;
		Token char_literal309=null;
		Token char_literal310=null;
		Token string_literal311=null;
		Token char_literal314=null;
		ParserRuleReturnScope durOp306 =null;
		ParserRuleReturnScope durValue308 =null;
		ParserRuleReturnScope timeSpecifier312 =null;
		ParserRuleReturnScope simpleDurationConstraint313 =null;

		Object char_literal305_tree=null;
		Object string_literal307_tree=null;
		Object char_literal309_tree=null;
		Object char_literal310_tree=null;
		Object string_literal311_tree=null;
		Object char_literal314_tree=null;

		try {
			// Pddl.g:413:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==64) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==105) ) {
					alt58=2;
				}
				else if ( ((LA58_1 >= 94 && LA58_1 <= 95)||LA58_1==97) ) {
					alt58=1;
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
					// Pddl.g:413:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal305=(Token)match(input,64,FOLLOW_64_in_simpleDurationConstraint2599); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal305_tree = (Object)adaptor.create(char_literal305);
					adaptor.addChild(root_0, char_literal305_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2601);
					durOp306=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp306.getTree());

					string_literal307=(Token)match(input,98,FOLLOW_98_in_simpleDurationConstraint2603); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal307_tree = (Object)adaptor.create(string_literal307);
					adaptor.addChild(root_0, string_literal307_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2605);
					durValue308=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue308.getTree());

					char_literal309=(Token)match(input,65,FOLLOW_65_in_simpleDurationConstraint2607); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal309_tree = (Object)adaptor.create(char_literal309);
					adaptor.addChild(root_0, char_literal309_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:414:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal310=(Token)match(input,64,FOLLOW_64_in_simpleDurationConstraint2612); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal310_tree = (Object)adaptor.create(char_literal310);
					adaptor.addChild(root_0, char_literal310_tree);
					}

					string_literal311=(Token)match(input,105,FOLLOW_105_in_simpleDurationConstraint2614); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal311_tree = (Object)adaptor.create(string_literal311);
					adaptor.addChild(root_0, string_literal311_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2616);
					timeSpecifier312=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier312.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2618);
					simpleDurationConstraint313=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint313.getTree());

					char_literal314=(Token)match(input,65,FOLLOW_65_in_simpleDurationConstraint2620); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal314_tree = (Object)adaptor.create(char_literal314);
					adaptor.addChild(root_0, char_literal314_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durOp"
	// Pddl.g:417:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set315=null;

		Object set315_tree=null;

		try {
			// Pddl.g:417:7: ( '<=' | '>=' | '=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set315=input.LT(1);
			if ( (input.LA(1) >= 94 && input.LA(1) <= 95)||input.LA(1)==97 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set315));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "durValue"
	// Pddl.g:419:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER316=null;
		ParserRuleReturnScope fExp317 =null;

		Object NUMBER316_tree=null;

		try {
			// Pddl.g:419:10: ( NUMBER | fExp )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==NUMBER) ) {
				int LA59_1 = input.LA(2);
				if ( (synpred97_Pddl()) ) {
					alt59=1;
				}
				else if ( (true) ) {
					alt59=2;
				}

			}
			else if ( (LA59_0==NAME||(LA59_0 >= 63 && LA59_0 <= 64)) ) {
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
					// Pddl.g:419:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER316=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2647); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER316_tree = (Object)adaptor.create(NUMBER316);
					adaptor.addChild(root_0, NUMBER316_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:419:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2651);
					fExp317=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp317.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "daEffect"
	// Pddl.g:421:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal318=null;
		Token string_literal319=null;
		Token char_literal321=null;
		Token char_literal323=null;
		Token string_literal324=null;
		Token char_literal325=null;
		Token char_literal327=null;
		Token char_literal329=null;
		Token char_literal330=null;
		Token string_literal331=null;
		Token char_literal334=null;
		Token char_literal335=null;
		Token char_literal339=null;
		ParserRuleReturnScope daEffect320 =null;
		ParserRuleReturnScope timedEffect322 =null;
		ParserRuleReturnScope typedVariableList326 =null;
		ParserRuleReturnScope daEffect328 =null;
		ParserRuleReturnScope daGD332 =null;
		ParserRuleReturnScope timedEffect333 =null;
		ParserRuleReturnScope assignOp336 =null;
		ParserRuleReturnScope fHead337 =null;
		ParserRuleReturnScope fExpDA338 =null;

		Object char_literal318_tree=null;
		Object string_literal319_tree=null;
		Object char_literal321_tree=null;
		Object char_literal323_tree=null;
		Object string_literal324_tree=null;
		Object char_literal325_tree=null;
		Object char_literal327_tree=null;
		Object char_literal329_tree=null;
		Object char_literal330_tree=null;
		Object string_literal331_tree=null;
		Object char_literal334_tree=null;
		Object char_literal335_tree=null;
		Object char_literal339_tree=null;

		try {
			// Pddl.g:422:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt61=5;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==64) ) {
				int LA61_1 = input.LA(2);
				if ( (synpred99_Pddl()) ) {
					alt61=1;
				}
				else if ( (synpred100_Pddl()) ) {
					alt61=2;
				}
				else if ( (synpred101_Pddl()) ) {
					alt61=3;
				}
				else if ( (synpred102_Pddl()) ) {
					alt61=4;
				}
				else if ( (true) ) {
					alt61=5;
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
					// Pddl.g:422:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal318=(Token)match(input,64,FOLLOW_64_in_daEffect2661); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal318_tree = (Object)adaptor.create(char_literal318);
					adaptor.addChild(root_0, char_literal318_tree);
					}

					string_literal319=(Token)match(input,103,FOLLOW_103_in_daEffect2663); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal319_tree = (Object)adaptor.create(string_literal319);
					adaptor.addChild(root_0, string_literal319_tree);
					}

					// Pddl.g:422:14: ( daEffect )*
					loop60:
					while (true) {
						int alt60=2;
						int LA60_0 = input.LA(1);
						if ( (LA60_0==64) ) {
							alt60=1;
						}

						switch (alt60) {
						case 1 :
							// Pddl.g:422:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2665);
							daEffect320=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect320.getTree());

							}
							break;

						default :
							break loop60;
						}
					}

					char_literal321=(Token)match(input,65,FOLLOW_65_in_daEffect2668); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal321_tree = (Object)adaptor.create(char_literal321);
					adaptor.addChild(root_0, char_literal321_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:423:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2673);
					timedEffect322=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect322.getTree());

					}
					break;
				case 3 :
					// Pddl.g:424:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal323=(Token)match(input,64,FOLLOW_64_in_daEffect2678); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal323_tree = (Object)adaptor.create(char_literal323);
					adaptor.addChild(root_0, char_literal323_tree);
					}

					string_literal324=(Token)match(input,114,FOLLOW_114_in_daEffect2680); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal324_tree = (Object)adaptor.create(string_literal324);
					adaptor.addChild(root_0, string_literal324_tree);
					}

					char_literal325=(Token)match(input,64,FOLLOW_64_in_daEffect2682); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal325_tree = (Object)adaptor.create(char_literal325);
					adaptor.addChild(root_0, char_literal325_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2684);
					typedVariableList326=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList326.getTree());

					char_literal327=(Token)match(input,65,FOLLOW_65_in_daEffect2686); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal327_tree = (Object)adaptor.create(char_literal327);
					adaptor.addChild(root_0, char_literal327_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2688);
					daEffect328=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect328.getTree());

					char_literal329=(Token)match(input,65,FOLLOW_65_in_daEffect2690); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal329_tree = (Object)adaptor.create(char_literal329);
					adaptor.addChild(root_0, char_literal329_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:425:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal330=(Token)match(input,64,FOLLOW_64_in_daEffect2695); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal330_tree = (Object)adaptor.create(char_literal330);
					adaptor.addChild(root_0, char_literal330_tree);
					}

					string_literal331=(Token)match(input,135,FOLLOW_135_in_daEffect2697); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal331_tree = (Object)adaptor.create(string_literal331);
					adaptor.addChild(root_0, string_literal331_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2699);
					daGD332=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD332.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2701);
					timedEffect333=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect333.getTree());

					char_literal334=(Token)match(input,65,FOLLOW_65_in_daEffect2703); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal334_tree = (Object)adaptor.create(char_literal334);
					adaptor.addChild(root_0, char_literal334_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:426:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal335=(Token)match(input,64,FOLLOW_64_in_daEffect2708); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal335_tree = (Object)adaptor.create(char_literal335);
					adaptor.addChild(root_0, char_literal335_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2710);
					assignOp336=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp336.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2712);
					fHead337=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead337.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2714);
					fExpDA338=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA338.getTree());

					char_literal339=(Token)match(input,65,FOLLOW_65_in_daEffect2716); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal339_tree = (Object)adaptor.create(char_literal339);
					adaptor.addChild(root_0, char_literal339_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timedEffect"
	// Pddl.g:429:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal340=null;
		Token string_literal341=null;
		Token char_literal344=null;
		Token char_literal345=null;
		Token string_literal346=null;
		Token char_literal349=null;
		Token char_literal350=null;
		Token char_literal354=null;
		ParserRuleReturnScope timeSpecifier342 =null;
		ParserRuleReturnScope daEffect343 =null;
		ParserRuleReturnScope timeSpecifier347 =null;
		ParserRuleReturnScope fAssignDA348 =null;
		ParserRuleReturnScope assignOp351 =null;
		ParserRuleReturnScope fHead352 =null;
		ParserRuleReturnScope fExp353 =null;

		Object char_literal340_tree=null;
		Object string_literal341_tree=null;
		Object char_literal344_tree=null;
		Object char_literal345_tree=null;
		Object string_literal346_tree=null;
		Object char_literal349_tree=null;
		Object char_literal350_tree=null;
		Object char_literal354_tree=null;

		try {
			// Pddl.g:430:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt62=3;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==64) ) {
				int LA62_1 = input.LA(2);
				if ( (synpred103_Pddl()) ) {
					alt62=1;
				}
				else if ( (synpred104_Pddl()) ) {
					alt62=2;
				}
				else if ( (true) ) {
					alt62=3;
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
					// Pddl.g:430:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal340=(Token)match(input,64,FOLLOW_64_in_timedEffect2727); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal340_tree = (Object)adaptor.create(char_literal340);
					adaptor.addChild(root_0, char_literal340_tree);
					}

					string_literal341=(Token)match(input,105,FOLLOW_105_in_timedEffect2729); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal341_tree = (Object)adaptor.create(string_literal341);
					adaptor.addChild(root_0, string_literal341_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2731);
					timeSpecifier342=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier342.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2733);
					daEffect343=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect343.getTree());

					char_literal344=(Token)match(input,65,FOLLOW_65_in_timedEffect2735); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal344_tree = (Object)adaptor.create(char_literal344);
					adaptor.addChild(root_0, char_literal344_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:431:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal345=(Token)match(input,64,FOLLOW_64_in_timedEffect2745); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal345_tree = (Object)adaptor.create(char_literal345);
					adaptor.addChild(root_0, char_literal345_tree);
					}

					string_literal346=(Token)match(input,105,FOLLOW_105_in_timedEffect2747); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal346_tree = (Object)adaptor.create(string_literal346);
					adaptor.addChild(root_0, string_literal346_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2749);
					timeSpecifier347=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier347.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2751);
					fAssignDA348=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA348.getTree());

					char_literal349=(Token)match(input,65,FOLLOW_65_in_timedEffect2753); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal349_tree = (Object)adaptor.create(char_literal349);
					adaptor.addChild(root_0, char_literal349_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:432:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal350=(Token)match(input,64,FOLLOW_64_in_timedEffect2758); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal350_tree = (Object)adaptor.create(char_literal350);
					adaptor.addChild(root_0, char_literal350_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2760);
					assignOp351=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp351.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2762);
					fHead352=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead352.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2764);
					fExp353=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp353.getTree());

					char_literal354=(Token)match(input,65,FOLLOW_65_in_timedEffect2766); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal354_tree = (Object)adaptor.create(char_literal354);
					adaptor.addChild(root_0, char_literal354_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fAssignDA"
	// Pddl.g:435:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal355=null;
		Token char_literal359=null;
		ParserRuleReturnScope assignOp356 =null;
		ParserRuleReturnScope fHead357 =null;
		ParserRuleReturnScope fExpDA358 =null;

		Object char_literal355_tree=null;
		Object char_literal359_tree=null;

		try {
			// Pddl.g:436:2: ( '(' assignOp fHead fExpDA ')' )
			// Pddl.g:436:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal355=(Token)match(input,64,FOLLOW_64_in_fAssignDA2786); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal355_tree = (Object)adaptor.create(char_literal355);
			adaptor.addChild(root_0, char_literal355_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2788);
			assignOp356=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp356.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2790);
			fHead357=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead357.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2792);
			fExpDA358=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA358.getTree());

			char_literal359=(Token)match(input,65,FOLLOW_65_in_fAssignDA2794); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal359_tree = (Object)adaptor.create(char_literal359);
			adaptor.addChild(root_0, char_literal359_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fExpDA"
	// Pddl.g:439:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal360=null;
		Token char_literal364=null;
		Token char_literal366=null;
		Token string_literal367=null;
		ParserRuleReturnScope binaryOp361 =null;
		ParserRuleReturnScope fExpDA362 =null;
		ParserRuleReturnScope fExpDA363 =null;
		ParserRuleReturnScope fExpDA365 =null;
		ParserRuleReturnScope fExp368 =null;

		Object char_literal360_tree=null;
		Object char_literal364_tree=null;
		Object char_literal366_tree=null;
		Object string_literal367_tree=null;

		try {
			// Pddl.g:440:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt64=3;
			switch ( input.LA(1) ) {
			case 64:
				{
				int LA64_1 = input.LA(2);
				if ( (synpred106_Pddl()) ) {
					alt64=1;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case 98:
				{
				alt64=2;
				}
				break;
			case NAME:
			case NUMBER:
			case 63:
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
					// Pddl.g:440:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal360=(Token)match(input,64,FOLLOW_64_in_fExpDA2805); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal360_tree = (Object)adaptor.create(char_literal360);
					adaptor.addChild(root_0, char_literal360_tree);
					}

					// Pddl.g:440:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==68) ) {
						int LA63_1 = input.LA(2);
						if ( (synpred105_Pddl()) ) {
							alt63=1;
						}
						else if ( (true) ) {
							alt63=2;
						}

					}
					else if ( ((LA63_0 >= 66 && LA63_0 <= 67)||LA63_0==69||LA63_0==99) ) {
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
							// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
							{
							// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
							// Pddl.g:440:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2809);
							binaryOp361=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp361.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2811);
							fExpDA362=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA362.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2813);
							fExpDA363=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA363.getTree());

							}

							}
							break;
						case 2 :
							// Pddl.g:440:36: ( '-' fExpDA )
							{
							// Pddl.g:440:36: ( '-' fExpDA )
							// Pddl.g:440:37: '-' fExpDA
							{
							char_literal364=(Token)match(input,68,FOLLOW_68_in_fExpDA2819); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal364_tree = (Object)adaptor.create(char_literal364);
							adaptor.addChild(root_0, char_literal364_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2821);
							fExpDA365=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA365.getTree());

							}

							}
							break;

					}

					char_literal366=(Token)match(input,65,FOLLOW_65_in_fExpDA2825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal366_tree = (Object)adaptor.create(char_literal366);
					adaptor.addChild(root_0, char_literal366_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:441:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal367=(Token)match(input,98,FOLLOW_98_in_fExpDA2830); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal367_tree = (Object)adaptor.create(string_literal367);
					adaptor.addChild(root_0, string_literal367_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:442:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA2835);
					fExp368=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp368.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "problem"
	// Pddl.g:447:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal369=null;
		Token string_literal370=null;
		Token char_literal379=null;
		ParserRuleReturnScope problemDecl371 =null;
		ParserRuleReturnScope problemDomain372 =null;
		ParserRuleReturnScope requireDef373 =null;
		ParserRuleReturnScope objectDecl374 =null;
		ParserRuleReturnScope init375 =null;
		ParserRuleReturnScope goal376 =null;
		ParserRuleReturnScope probConstraints377 =null;
		ParserRuleReturnScope metricSpec378 =null;

		Object char_literal369_tree=null;
		Object string_literal370_tree=null;
		Object char_literal379_tree=null;
		RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");

		try {
			// Pddl.g:448:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// Pddl.g:448:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal369=(Token)match(input,64,FOLLOW_64_in_problem2849); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal369);

			string_literal370=(Token)match(input,109,FOLLOW_109_in_problem2851); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_109.add(string_literal370);

			pushFollow(FOLLOW_problemDecl_in_problem2853);
			problemDecl371=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl371.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem2858);
			problemDomain372=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain372.getTree());
			// Pddl.g:450:7: ( requireDef )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==64) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==91) ) {
					alt65=1;
				}
			}
			switch (alt65) {
				case 1 :
					// Pddl.g:450:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem2866);
					requireDef373=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef373.getTree());
					}
					break;

			}

			// Pddl.g:451:7: ( objectDecl )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==64) ) {
				int LA66_1 = input.LA(2);
				if ( (LA66_1==86) ) {
					alt66=1;
				}
			}
			switch (alt66) {
				case 1 :
					// Pddl.g:451:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem2875);
					objectDecl374=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl374.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem2884);
			init375=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init375.getTree());
			pushFollow(FOLLOW_goal_in_problem2892);
			goal376=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal376.getTree());
			// Pddl.g:454:7: ( probConstraints )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==64) ) {
				int LA67_1 = input.LA(2);
				if ( (LA67_1==74) ) {
					alt67=1;
				}
			}
			switch (alt67) {
				case 1 :
					// Pddl.g:454:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem2900);
					probConstraints377=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints377.getTree());
					}
					break;

			}

			// Pddl.g:455:7: ( metricSpec )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==64) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// Pddl.g:455:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem2909);
					metricSpec378=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec378.getTree());
					}
					break;

			}

			char_literal379=(Token)match(input,65,FOLLOW_65_in_problem2925); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal379);

			// AST REWRITE
			// elements: requireDef, goal, init, probConstraints, problemDomain, metricSpec, objectDecl, problemDecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 458:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// Pddl.g:458:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// Pddl.g:458:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:458:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// Pddl.g:459:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// Pddl.g:459:36: ( metricSpec )?
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "problemDecl"
	// Pddl.g:462:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal380=null;
		Token string_literal381=null;
		Token NAME382=null;
		Token char_literal383=null;

		Object char_literal380_tree=null;
		Object string_literal381_tree=null;
		Object NAME382_tree=null;
		Object char_literal383_tree=null;
		RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// Pddl.g:463:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// Pddl.g:463:7: '(' 'problem' NAME ')'
			{
			char_literal380=(Token)match(input,64,FOLLOW_64_in_problemDecl2982); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal380);

			string_literal381=(Token)match(input,127,FOLLOW_127_in_problemDecl2984); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_127.add(string_literal381);

			NAME382=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2986); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME382);

			char_literal383=(Token)match(input,65,FOLLOW_65_in_problemDecl2988); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal383);

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
			// 464:5: -> ^( PROBLEM_NAME NAME )
			{
				// Pddl.g:464:8: ^( PROBLEM_NAME NAME )
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
	// Pddl.g:467:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal384=null;
		Token string_literal385=null;
		Token NAME386=null;
		Token char_literal387=null;

		Object char_literal384_tree=null;
		Object string_literal385_tree=null;
		Object NAME386_tree=null;
		Object char_literal387_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// Pddl.g:468:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// Pddl.g:468:4: '(' ':domain' NAME ')'
			{
			char_literal384=(Token)match(input,64,FOLLOW_64_in_problemDomain3014); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal384);

			string_literal385=(Token)match(input,76,FOLLOW_76_in_problemDomain3016); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal385);

			NAME386=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain3018); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME386);

			char_literal387=(Token)match(input,65,FOLLOW_65_in_problemDomain3020); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal387);

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
			// 469:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// Pddl.g:469:5: ^( PROBLEM_DOMAIN NAME )
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
	// Pddl.g:472:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal388=null;
		Token string_literal389=null;
		Token char_literal391=null;
		ParserRuleReturnScope typedNameList390 =null;

		Object char_literal388_tree=null;
		Object string_literal389_tree=null;
		Object char_literal391_tree=null;
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:473:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// Pddl.g:473:4: '(' ':objects' typedNameList ')'
			{
			char_literal388=(Token)match(input,64,FOLLOW_64_in_objectDecl3040); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal388);

			string_literal389=(Token)match(input,86,FOLLOW_86_in_objectDecl3042); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_86.add(string_literal389);

			pushFollow(FOLLOW_typedNameList_in_objectDecl3044);
			typedNameList390=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList390.getTree());
			char_literal391=(Token)match(input,65,FOLLOW_65_in_objectDecl3046); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal391);

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
			// 474:2: -> ^( OBJECTS typedNameList )
			{
				// Pddl.g:474:5: ^( OBJECTS typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECTS, "OBJECTS"), root_1);
                                if (stream_typedNameList.hasNext()){
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
	// Pddl.g:477:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal392=null;
		Token string_literal393=null;
		Token char_literal395=null;
		ParserRuleReturnScope initEl394 =null;

		Object char_literal392_tree=null;
		Object string_literal393_tree=null;
		Object char_literal395_tree=null;
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try {
			// Pddl.g:478:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
			// Pddl.g:478:4: '(' ':init' ( initEl )* ')'
			{
			char_literal392=(Token)match(input,64,FOLLOW_64_in_init3066); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal392);

			string_literal393=(Token)match(input,84,FOLLOW_84_in_init3068); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_84.add(string_literal393);

			// Pddl.g:478:16: ( initEl )*
			loop69:
			while (true) {
				int alt69=2;
				int LA69_0 = input.LA(1);
				if ( (LA69_0==64) ) {
					alt69=1;
				}

				switch (alt69) {
				case 1 :
					// Pddl.g:478:16: initEl
					{
					pushFollow(FOLLOW_initEl_in_init3070);
					initEl394=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl394.getTree());
					}
					break;

				default :
					break loop69;
				}
			}

			char_literal395=(Token)match(input,65,FOLLOW_65_in_init3073); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal395);

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
			// 479:2: -> ^( INIT ( initEl )* )
			{
				// Pddl.g:479:5: ^( INIT ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
				// Pddl.g:479:12: ( initEl )*
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "initEl"
	// Pddl.g:482:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal397=null;
		Token char_literal398=null;
		Token NUMBER400=null;
		Token char_literal401=null;
		Token char_literal402=null;
		Token string_literal403=null;
		Token NUMBER404=null;
		Token char_literal406=null;
		ParserRuleReturnScope nameLiteral396 =null;
		ParserRuleReturnScope fHead399 =null;
		ParserRuleReturnScope nameLiteral405 =null;

		Object char_literal397_tree=null;
		Object char_literal398_tree=null;
		Object NUMBER400_tree=null;
		Object char_literal401_tree=null;
		Object char_literal402_tree=null;
		Object string_literal403_tree=null;
		Object NUMBER404_tree=null;
		Object char_literal406_tree=null;
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			// Pddl.g:483:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
			int alt70=3;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==64) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 122:
					{
					alt70=1;
					}
					break;
				case 95:
					{
					alt70=2;
					}
					break;
				case 105:
					{
					alt70=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 70, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:483:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl3094);
					nameLiteral396=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral396.getTree());

					}
					break;
				case 2 :
					// Pddl.g:484:4: '(' '=' fHead NUMBER ')'
					{
					char_literal397=(Token)match(input,64,FOLLOW_64_in_initEl3099); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal397);

					char_literal398=(Token)match(input,95,FOLLOW_95_in_initEl3101); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_95.add(char_literal398);

					pushFollow(FOLLOW_fHead_in_initEl3103);
					fHead399=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead399.getTree());
					NUMBER400=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3105); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER400);

					char_literal401=(Token)match(input,65,FOLLOW_65_in_initEl3107); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal401);

					// AST REWRITE
					// elements: fHead, NUMBER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 484:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// Pddl.g:484:40: ^( INIT_EQ fHead NUMBER )
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
					// Pddl.g:485:4: '(' 'at' NUMBER nameLiteral ')'
					{
					char_literal402=(Token)match(input,64,FOLLOW_64_in_initEl3130); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal402);

					string_literal403=(Token)match(input,105,FOLLOW_105_in_initEl3132); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_105.add(string_literal403);

					NUMBER404=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3134); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER404);

					pushFollow(FOLLOW_nameLiteral_in_initEl3136);
					nameLiteral405=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral405.getTree());
					char_literal406=(Token)match(input,65,FOLLOW_65_in_initEl3138); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal406);

					// AST REWRITE
					// elements: NUMBER, nameLiteral
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 485:37: -> ^( INIT_AT NUMBER nameLiteral )
					{
						// Pddl.g:485:40: ^( INIT_AT NUMBER nameLiteral )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT_AT, "INIT_AT"), root_1);
						adaptor.addChild(root_1, stream_NUMBER.nextNode());
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nameLiteral"
	// Pddl.g:488:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal408=null;
		Token string_literal409=null;
		Token char_literal411=null;
		ParserRuleReturnScope atomicNameFormula407 =null;
		ParserRuleReturnScope atomicNameFormula410 =null;

		Object char_literal408_tree=null;
		Object string_literal409_tree=null;
		Object char_literal411_tree=null;
		RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			// Pddl.g:489:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==64) ) {
				int LA71_1 = input.LA(2);
				if ( (LA71_1==122) ) {
					alt71=2;
				}
				else if ( (LA71_1==NAME) ) {
					alt71=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 71, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:489:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3160);
					atomicNameFormula407=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula407.getTree());

					}
					break;
				case 2 :
					// Pddl.g:490:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal408=(Token)match(input,64,FOLLOW_64_in_nameLiteral3165); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal408);

					string_literal409=(Token)match(input,122,FOLLOW_122_in_nameLiteral3167); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_122.add(string_literal409);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3169);
					atomicNameFormula410=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula410.getTree());
					char_literal411=(Token)match(input,65,FOLLOW_65_in_nameLiteral3171); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal411);

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
					// 490:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// Pddl.g:490:39: ^( NOT_PRED_INIT atomicNameFormula )
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
	// Pddl.g:493:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal412=null;
		Token NAME414=null;
		Token char_literal415=null;
		ParserRuleReturnScope predicate413 =null;

		Object char_literal412_tree=null;
		Object NAME414_tree=null;
		Object char_literal415_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// Pddl.g:494:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// Pddl.g:494:4: '(' predicate ( NAME )* ')'
			{
			char_literal412=(Token)match(input,64,FOLLOW_64_in_atomicNameFormula3190); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal412);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula3192);
			predicate413=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate413.getTree());
			// Pddl.g:494:18: ( NAME )*
			loop72:
			while (true) {
				int alt72=2;
				int LA72_0 = input.LA(1);
				if ( (LA72_0==NAME) ) {
					alt72=1;
				}

				switch (alt72) {
				case 1 :
					// Pddl.g:494:18: NAME
					{
					NAME414=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula3194); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME414);

					}
					break;

				default :
					break loop72;
				}
			}

			char_literal415=(Token)match(input,65,FOLLOW_65_in_atomicNameFormula3197); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal415);

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
			// 494:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// Pddl.g:494:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:494:53: ( NAME )*
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
	// Pddl.g:501:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal416=null;
		Token string_literal417=null;
		Token char_literal419=null;
		ParserRuleReturnScope goalDesc418 =null;

		Object char_literal416_tree=null;
		Object string_literal417_tree=null;
		Object char_literal419_tree=null;
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// Pddl.g:501:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// Pddl.g:501:8: '(' ':goal' goalDesc ')'
			{
			char_literal416=(Token)match(input,64,FOLLOW_64_in_goal3222); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal416);

			string_literal417=(Token)match(input,83,FOLLOW_83_in_goal3224); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_83.add(string_literal417);

			pushFollow(FOLLOW_goalDesc_in_goal3226);
			goalDesc418=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc418.getTree());
			char_literal419=(Token)match(input,65,FOLLOW_65_in_goal3228); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal419);

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
			// 501:33: -> ^( GOAL goalDesc )
			{
				// Pddl.g:501:36: ^( GOAL goalDesc )
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
	// Pddl.g:503:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal420=null;
		Token string_literal421=null;
		Token char_literal423=null;
		ParserRuleReturnScope prefConGD422 =null;

		Object char_literal420_tree=null;
		Object string_literal421_tree=null;
		Object char_literal423_tree=null;
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			// Pddl.g:504:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// Pddl.g:504:4: '(' ':constraints' prefConGD ')'
			{
			char_literal420=(Token)match(input,64,FOLLOW_64_in_probConstraints3246); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal420);

			string_literal421=(Token)match(input,74,FOLLOW_74_in_probConstraints3248); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_74.add(string_literal421);

			pushFollow(FOLLOW_prefConGD_in_probConstraints3251);
			prefConGD422=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD422.getTree());
			char_literal423=(Token)match(input,65,FOLLOW_65_in_probConstraints3253); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal423);

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
			// 505:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// Pddl.g:505:7: ^( PROBLEM_CONSTRAINT prefConGD )
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
	// Pddl.g:508:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal424=null;
		Token string_literal425=null;
		Token char_literal427=null;
		Token char_literal428=null;
		Token string_literal429=null;
		Token char_literal430=null;
		Token char_literal432=null;
		Token char_literal434=null;
		Token char_literal435=null;
		Token string_literal436=null;
		Token NAME437=null;
		Token char_literal439=null;
		ParserRuleReturnScope prefConGD426 =null;
		ParserRuleReturnScope typedVariableList431 =null;
		ParserRuleReturnScope prefConGD433 =null;
		ParserRuleReturnScope conGD438 =null;
		ParserRuleReturnScope conGD440 =null;

		Object char_literal424_tree=null;
		Object string_literal425_tree=null;
		Object char_literal427_tree=null;
		Object char_literal428_tree=null;
		Object string_literal429_tree=null;
		Object char_literal430_tree=null;
		Object char_literal432_tree=null;
		Object char_literal434_tree=null;
		Object char_literal435_tree=null;
		Object string_literal436_tree=null;
		Object NAME437_tree=null;
		Object char_literal439_tree=null;

		try {
			// Pddl.g:509:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt75=4;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==64) ) {
				int LA75_1 = input.LA(2);
				if ( (synpred118_Pddl()) ) {
					alt75=1;
				}
				else if ( (synpred119_Pddl()) ) {
					alt75=2;
				}
				else if ( (synpred121_Pddl()) ) {
					alt75=3;
				}
				else if ( (true) ) {
					alt75=4;
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
					// Pddl.g:509:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal424=(Token)match(input,64,FOLLOW_64_in_prefConGD3275); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal424_tree = (Object)adaptor.create(char_literal424);
					adaptor.addChild(root_0, char_literal424_tree);
					}

					string_literal425=(Token)match(input,103,FOLLOW_103_in_prefConGD3277); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal425_tree = (Object)adaptor.create(string_literal425);
					adaptor.addChild(root_0, string_literal425_tree);
					}

					// Pddl.g:509:14: ( prefConGD )*
					loop73:
					while (true) {
						int alt73=2;
						int LA73_0 = input.LA(1);
						if ( (LA73_0==64) ) {
							alt73=1;
						}

						switch (alt73) {
						case 1 :
							// Pddl.g:509:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD3279);
							prefConGD426=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD426.getTree());

							}
							break;

						default :
							break loop73;
						}
					}

					char_literal427=(Token)match(input,65,FOLLOW_65_in_prefConGD3282); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal427_tree = (Object)adaptor.create(char_literal427);
					adaptor.addChild(root_0, char_literal427_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:510:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal428=(Token)match(input,64,FOLLOW_64_in_prefConGD3287); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal428_tree = (Object)adaptor.create(char_literal428);
					adaptor.addChild(root_0, char_literal428_tree);
					}

					string_literal429=(Token)match(input,114,FOLLOW_114_in_prefConGD3289); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal429_tree = (Object)adaptor.create(string_literal429);
					adaptor.addChild(root_0, string_literal429_tree);
					}

					char_literal430=(Token)match(input,64,FOLLOW_64_in_prefConGD3291); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal430_tree = (Object)adaptor.create(char_literal430);
					adaptor.addChild(root_0, char_literal430_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD3293);
					typedVariableList431=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList431.getTree());

					char_literal432=(Token)match(input,65,FOLLOW_65_in_prefConGD3295); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal432_tree = (Object)adaptor.create(char_literal432);
					adaptor.addChild(root_0, char_literal432_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD3297);
					prefConGD433=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD433.getTree());

					char_literal434=(Token)match(input,65,FOLLOW_65_in_prefConGD3299); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal434_tree = (Object)adaptor.create(char_literal434);
					adaptor.addChild(root_0, char_literal434_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:511:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal435=(Token)match(input,64,FOLLOW_64_in_prefConGD3304); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal435_tree = (Object)adaptor.create(char_literal435);
					adaptor.addChild(root_0, char_literal435_tree);
					}

					string_literal436=(Token)match(input,126,FOLLOW_126_in_prefConGD3306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal436_tree = (Object)adaptor.create(string_literal436);
					adaptor.addChild(root_0, string_literal436_tree);
					}

					// Pddl.g:511:21: ( NAME )?
					int alt74=2;
					int LA74_0 = input.LA(1);
					if ( (LA74_0==NAME) ) {
						alt74=1;
					}
					switch (alt74) {
						case 1 :
							// Pddl.g:511:21: NAME
							{
							NAME437=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3308); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME437_tree = (Object)adaptor.create(NAME437);
							adaptor.addChild(root_0, NAME437_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD3311);
					conGD438=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD438.getTree());

					char_literal439=(Token)match(input,65,FOLLOW_65_in_prefConGD3313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal439_tree = (Object)adaptor.create(char_literal439);
					adaptor.addChild(root_0, char_literal439_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:512:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD3318);
					conGD440=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD440.getTree());

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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "metricSpec"
	// Pddl.g:515:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal441=null;
		Token string_literal442=null;
		Token char_literal445=null;
		ParserRuleReturnScope optimization443 =null;
		ParserRuleReturnScope metricFExp444 =null;

		Object char_literal441_tree=null;
		Object string_literal442_tree=null;
		Object char_literal445_tree=null;
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");

		try {
			// Pddl.g:516:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// Pddl.g:516:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal441=(Token)match(input,64,FOLLOW_64_in_metricSpec3329); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(char_literal441);

			string_literal442=(Token)match(input,85,FOLLOW_85_in_metricSpec3331); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal442);

			pushFollow(FOLLOW_optimization_in_metricSpec3333);
			optimization443=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization443.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec3335);
			metricFExp444=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp444.getTree());
			char_literal445=(Token)match(input,65,FOLLOW_65_in_metricSpec3337); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(char_literal445);

			// AST REWRITE
			// elements: metricFExp, optimization
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 517:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// Pddl.g:517:7: ^( PROBLEM_METRIC optimization metricFExp )
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
	// Pddl.g:520:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set446=null;

		Object set446_tree=null;

		try {
			// Pddl.g:520:14: ( 'minimize' | 'maximize' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set446=input.LT(1);
			if ( (input.LA(1) >= 120 && input.LA(1) <= 121) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set446));
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "metricFExp"
	// Pddl.g:522:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal447=null;
		Token char_literal451=null;
		Token char_literal452=null;
		Token char_literal456=null;
		Token char_literal457=null;
		Token char_literal458=null;
		Token char_literal460=null;
		Token NUMBER461=null;
		Token char_literal463=null;
		Token string_literal464=null;
		Token NAME465=null;
		Token char_literal466=null;
		ParserRuleReturnScope binaryOp448 =null;
		ParserRuleReturnScope metricFExp449 =null;
		ParserRuleReturnScope metricFExp450 =null;
		ParserRuleReturnScope multiOp453 =null;
		ParserRuleReturnScope metricFExp454 =null;
		ParserRuleReturnScope metricFExp455 =null;
		ParserRuleReturnScope metricFExp459 =null;
		ParserRuleReturnScope fHead462 =null;

		Object char_literal447_tree=null;
		Object char_literal451_tree=null;
		Object char_literal452_tree=null;
		Object char_literal456_tree=null;
		Object char_literal457_tree=null;
		Object char_literal458_tree=null;
		Object char_literal460_tree=null;
		Object NUMBER461_tree=null;
		Object char_literal463_tree=null;
		Object string_literal464_tree=null;
		Object NAME465_tree=null;
		Object char_literal466_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");

		try {
			// Pddl.g:523:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt77=6;
			switch ( input.LA(1) ) {
			case 64:
				{
				int LA77_1 = input.LA(2);
				if ( (synpred123_Pddl()) ) {
					alt77=1;
				}
				else if ( (synpred125_Pddl()) ) {
					alt77=2;
				}
				else if ( (synpred126_Pddl()) ) {
					alt77=3;
				}
				else if ( (synpred128_Pddl()) ) {
					alt77=5;
				}
				else if ( (true) ) {
					alt77=6;
				}

				}
				break;
			case NUMBER:
				{
				alt77=4;
				}
				break;
			case NAME:
			case 63:
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
					// Pddl.g:523:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal447=(Token)match(input,64,FOLLOW_64_in_metricFExp3374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal447);

					pushFollow(FOLLOW_binaryOp_in_metricFExp3376);
					binaryOp448=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp448.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3378);
					metricFExp449=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp449.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3380);
					metricFExp450=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp450.getTree());
					char_literal451=(Token)match(input,65,FOLLOW_65_in_metricFExp3382); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal451);

					// AST REWRITE
					// elements: binaryOp, metricFExp, metricFExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 524:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// Pddl.g:524:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
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
					// Pddl.g:525:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal452=(Token)match(input,64,FOLLOW_64_in_metricFExp3404); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal452);

					pushFollow(FOLLOW_multiOp_in_metricFExp3406);
					multiOp453=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp453.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3408);
					metricFExp454=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp454.getTree());
					// Pddl.g:525:27: ( metricFExp )+
					int cnt76=0;
					loop76:
					while (true) {
						int alt76=2;
						int LA76_0 = input.LA(1);
						if ( (LA76_0==NAME||LA76_0==NUMBER||(LA76_0 >= 63 && LA76_0 <= 64)) ) {
							alt76=1;
						}

						switch (alt76) {
						case 1 :
							// Pddl.g:525:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3410);
							metricFExp455=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp455.getTree());
							}
							break;

						default :
							if ( cnt76 >= 1 ) break loop76;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(76, input);
							throw eee;
						}
						cnt76++;
					}

					char_literal456=(Token)match(input,65,FOLLOW_65_in_metricFExp3413); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal456);

					// AST REWRITE
					// elements: metricFExp, metricFExp, multiOp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 526:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// Pddl.g:526:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
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
					// Pddl.g:527:4: '(' '-' metricFExp ')'
					{
					char_literal457=(Token)match(input,64,FOLLOW_64_in_metricFExp3437); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_64.add(char_literal457);

					char_literal458=(Token)match(input,68,FOLLOW_68_in_metricFExp3439); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_68.add(char_literal458);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3441);
					metricFExp459=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp459.getTree());
					char_literal460=(Token)match(input,65,FOLLOW_65_in_metricFExp3443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_65.add(char_literal460);

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
					// 528:4: -> ^( MINUS_OP metricFExp )
					{
						// Pddl.g:528:7: ^( MINUS_OP metricFExp )
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
					// Pddl.g:529:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER461=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3460); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER461_tree = (Object)adaptor.create(NUMBER461);
					adaptor.addChild(root_0, NUMBER461_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:530:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3465);
					fHead462=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead462.getTree());

					}
					break;
				case 6 :
					// Pddl.g:532:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal463=(Token)match(input,64,FOLLOW_64_in_metricFExp3480); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal463_tree = (Object)adaptor.create(char_literal463);
					adaptor.addChild(root_0, char_literal463_tree);
					}

					string_literal464=(Token)match(input,119,FOLLOW_119_in_metricFExp3482); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal464_tree = (Object)adaptor.create(string_literal464);
					adaptor.addChild(root_0, string_literal464_tree);
					}

					NAME465=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3484); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME465_tree = (Object)adaptor.create(NAME465);
					adaptor.addChild(root_0, NAME465_tree);
					}

					char_literal466=(Token)match(input,65,FOLLOW_65_in_metricFExp3486); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal466_tree = (Object)adaptor.create(char_literal466);
					adaptor.addChild(root_0, char_literal466_tree);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "conGD"
	// Pddl.g:537:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal467=null;
		Token string_literal468=null;
		Token char_literal470=null;
		Token char_literal471=null;
		Token string_literal472=null;
		Token char_literal473=null;
		Token char_literal475=null;
		Token char_literal477=null;
		Token char_literal478=null;
		Token string_literal479=null;
		Token string_literal480=null;
		Token char_literal482=null;
		Token char_literal483=null;
		Token string_literal484=null;
		Token char_literal486=null;
		Token char_literal487=null;
		Token string_literal488=null;
		Token char_literal490=null;
		Token char_literal491=null;
		Token string_literal492=null;
		Token NUMBER493=null;
		Token char_literal495=null;
		Token char_literal496=null;
		Token string_literal497=null;
		Token char_literal499=null;
		Token char_literal500=null;
		Token string_literal501=null;
		Token char_literal504=null;
		Token char_literal505=null;
		Token string_literal506=null;
		Token char_literal509=null;
		Token char_literal510=null;
		Token string_literal511=null;
		Token NUMBER512=null;
		Token char_literal515=null;
		Token char_literal516=null;
		Token string_literal517=null;
		Token NUMBER518=null;
		Token NUMBER519=null;
		Token char_literal521=null;
		Token char_literal522=null;
		Token string_literal523=null;
		Token NUMBER524=null;
		Token char_literal526=null;
		ParserRuleReturnScope conGD469 =null;
		ParserRuleReturnScope typedVariableList474 =null;
		ParserRuleReturnScope conGD476 =null;
		ParserRuleReturnScope goalDesc481 =null;
		ParserRuleReturnScope goalDesc485 =null;
		ParserRuleReturnScope goalDesc489 =null;
		ParserRuleReturnScope goalDesc494 =null;
		ParserRuleReturnScope goalDesc498 =null;
		ParserRuleReturnScope goalDesc502 =null;
		ParserRuleReturnScope goalDesc503 =null;
		ParserRuleReturnScope goalDesc507 =null;
		ParserRuleReturnScope goalDesc508 =null;
		ParserRuleReturnScope goalDesc513 =null;
		ParserRuleReturnScope goalDesc514 =null;
		ParserRuleReturnScope goalDesc520 =null;
		ParserRuleReturnScope goalDesc525 =null;

		Object char_literal467_tree=null;
		Object string_literal468_tree=null;
		Object char_literal470_tree=null;
		Object char_literal471_tree=null;
		Object string_literal472_tree=null;
		Object char_literal473_tree=null;
		Object char_literal475_tree=null;
		Object char_literal477_tree=null;
		Object char_literal478_tree=null;
		Object string_literal479_tree=null;
		Object string_literal480_tree=null;
		Object char_literal482_tree=null;
		Object char_literal483_tree=null;
		Object string_literal484_tree=null;
		Object char_literal486_tree=null;
		Object char_literal487_tree=null;
		Object string_literal488_tree=null;
		Object char_literal490_tree=null;
		Object char_literal491_tree=null;
		Object string_literal492_tree=null;
		Object NUMBER493_tree=null;
		Object char_literal495_tree=null;
		Object char_literal496_tree=null;
		Object string_literal497_tree=null;
		Object char_literal499_tree=null;
		Object char_literal500_tree=null;
		Object string_literal501_tree=null;
		Object char_literal504_tree=null;
		Object char_literal505_tree=null;
		Object string_literal506_tree=null;
		Object char_literal509_tree=null;
		Object char_literal510_tree=null;
		Object string_literal511_tree=null;
		Object NUMBER512_tree=null;
		Object char_literal515_tree=null;
		Object char_literal516_tree=null;
		Object string_literal517_tree=null;
		Object NUMBER518_tree=null;
		Object NUMBER519_tree=null;
		Object char_literal521_tree=null;
		Object char_literal522_tree=null;
		Object string_literal523_tree=null;
		Object NUMBER524_tree=null;
		Object char_literal526_tree=null;

		try {
			// Pddl.g:538:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt79=12;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==64) ) {
				switch ( input.LA(2) ) {
				case 103:
					{
					alt79=1;
					}
					break;
				case 114:
					{
					alt79=2;
					}
					break;
				case 105:
					{
					alt79=3;
					}
					break;
				case 101:
					{
					alt79=4;
					}
					break;
				case 131:
					{
					alt79=5;
					}
					break;
				case 136:
					{
					alt79=6;
					}
					break;
				case 106:
					{
					alt79=7;
					}
					break;
				case 132:
					{
					alt79=8;
					}
					break;
				case 133:
					{
					alt79=9;
					}
					break;
				case 102:
					{
					alt79=10;
					}
					break;
				case 116:
					{
					alt79=11;
					}
					break;
				case 115:
					{
					alt79=12;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 79, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// Pddl.g:538:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal467=(Token)match(input,64,FOLLOW_64_in_conGD3500); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}

					string_literal468=(Token)match(input,103,FOLLOW_103_in_conGD3502); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal468_tree = (Object)adaptor.create(string_literal468);
					adaptor.addChild(root_0, string_literal468_tree);
					}

					// Pddl.g:538:14: ( conGD )*
					loop78:
					while (true) {
						int alt78=2;
						int LA78_0 = input.LA(1);
						if ( (LA78_0==64) ) {
							alt78=1;
						}

						switch (alt78) {
						case 1 :
							// Pddl.g:538:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3504);
							conGD469=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD469.getTree());

							}
							break;

						default :
							break loop78;
						}
					}

					char_literal470=(Token)match(input,65,FOLLOW_65_in_conGD3507); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal470_tree = (Object)adaptor.create(char_literal470);
					adaptor.addChild(root_0, char_literal470_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:539:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal471=(Token)match(input,64,FOLLOW_64_in_conGD3512); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal471_tree = (Object)adaptor.create(char_literal471);
					adaptor.addChild(root_0, char_literal471_tree);
					}

					string_literal472=(Token)match(input,114,FOLLOW_114_in_conGD3514); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal472_tree = (Object)adaptor.create(string_literal472);
					adaptor.addChild(root_0, string_literal472_tree);
					}

					char_literal473=(Token)match(input,64,FOLLOW_64_in_conGD3516); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal473_tree = (Object)adaptor.create(char_literal473);
					adaptor.addChild(root_0, char_literal473_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3518);
					typedVariableList474=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList474.getTree());

					char_literal475=(Token)match(input,65,FOLLOW_65_in_conGD3520); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal475_tree = (Object)adaptor.create(char_literal475);
					adaptor.addChild(root_0, char_literal475_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3522);
					conGD476=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD476.getTree());

					char_literal477=(Token)match(input,65,FOLLOW_65_in_conGD3524); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal477_tree = (Object)adaptor.create(char_literal477);
					adaptor.addChild(root_0, char_literal477_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:540:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal478=(Token)match(input,64,FOLLOW_64_in_conGD3529); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal478_tree = (Object)adaptor.create(char_literal478);
					adaptor.addChild(root_0, char_literal478_tree);
					}

					string_literal479=(Token)match(input,105,FOLLOW_105_in_conGD3531); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal479_tree = (Object)adaptor.create(string_literal479);
					adaptor.addChild(root_0, string_literal479_tree);
					}

					string_literal480=(Token)match(input,112,FOLLOW_112_in_conGD3533); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal480_tree = (Object)adaptor.create(string_literal480);
					adaptor.addChild(root_0, string_literal480_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3535);
					goalDesc481=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc481.getTree());

					char_literal482=(Token)match(input,65,FOLLOW_65_in_conGD3537); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal482_tree = (Object)adaptor.create(char_literal482);
					adaptor.addChild(root_0, char_literal482_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:541:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal483=(Token)match(input,64,FOLLOW_64_in_conGD3563); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal483_tree = (Object)adaptor.create(char_literal483);
					adaptor.addChild(root_0, char_literal483_tree);
					}

					string_literal484=(Token)match(input,101,FOLLOW_101_in_conGD3565); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal484_tree = (Object)adaptor.create(string_literal484);
					adaptor.addChild(root_0, string_literal484_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3567);
					goalDesc485=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc485.getTree());

					char_literal486=(Token)match(input,65,FOLLOW_65_in_conGD3569); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal486_tree = (Object)adaptor.create(char_literal486);
					adaptor.addChild(root_0, char_literal486_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:542:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal487=(Token)match(input,64,FOLLOW_64_in_conGD3574); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal487_tree = (Object)adaptor.create(char_literal487);
					adaptor.addChild(root_0, char_literal487_tree);
					}

					string_literal488=(Token)match(input,131,FOLLOW_131_in_conGD3576); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal488_tree = (Object)adaptor.create(string_literal488);
					adaptor.addChild(root_0, string_literal488_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3578);
					goalDesc489=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc489.getTree());

					char_literal490=(Token)match(input,65,FOLLOW_65_in_conGD3580); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal490_tree = (Object)adaptor.create(char_literal490);
					adaptor.addChild(root_0, char_literal490_tree);
					}

					}
					break;
				case 6 :
					// Pddl.g:543:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal491=(Token)match(input,64,FOLLOW_64_in_conGD3586); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal491_tree = (Object)adaptor.create(char_literal491);
					adaptor.addChild(root_0, char_literal491_tree);
					}

					string_literal492=(Token)match(input,136,FOLLOW_136_in_conGD3588); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal492_tree = (Object)adaptor.create(string_literal492);
					adaptor.addChild(root_0, string_literal492_tree);
					}

					NUMBER493=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3590); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER493_tree = (Object)adaptor.create(NUMBER493);
					adaptor.addChild(root_0, NUMBER493_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3592);
					goalDesc494=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc494.getTree());

					char_literal495=(Token)match(input,65,FOLLOW_65_in_conGD3594); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal495_tree = (Object)adaptor.create(char_literal495);
					adaptor.addChild(root_0, char_literal495_tree);
					}

					}
					break;
				case 7 :
					// Pddl.g:544:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal496=(Token)match(input,64,FOLLOW_64_in_conGD3599); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal496_tree = (Object)adaptor.create(char_literal496);
					adaptor.addChild(root_0, char_literal496_tree);
					}

					string_literal497=(Token)match(input,106,FOLLOW_106_in_conGD3601); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal497_tree = (Object)adaptor.create(string_literal497);
					adaptor.addChild(root_0, string_literal497_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3603);
					goalDesc498=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc498.getTree());

					char_literal499=(Token)match(input,65,FOLLOW_65_in_conGD3605); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal499_tree = (Object)adaptor.create(char_literal499);
					adaptor.addChild(root_0, char_literal499_tree);
					}

					}
					break;
				case 8 :
					// Pddl.g:545:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal500=(Token)match(input,64,FOLLOW_64_in_conGD3610); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal500_tree = (Object)adaptor.create(char_literal500);
					adaptor.addChild(root_0, char_literal500_tree);
					}

					string_literal501=(Token)match(input,132,FOLLOW_132_in_conGD3612); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal501_tree = (Object)adaptor.create(string_literal501);
					adaptor.addChild(root_0, string_literal501_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3614);
					goalDesc502=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc502.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3616);
					goalDesc503=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc503.getTree());

					char_literal504=(Token)match(input,65,FOLLOW_65_in_conGD3618); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal504_tree = (Object)adaptor.create(char_literal504);
					adaptor.addChild(root_0, char_literal504_tree);
					}

					}
					break;
				case 9 :
					// Pddl.g:546:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal505=(Token)match(input,64,FOLLOW_64_in_conGD3623); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal505_tree = (Object)adaptor.create(char_literal505);
					adaptor.addChild(root_0, char_literal505_tree);
					}

					string_literal506=(Token)match(input,133,FOLLOW_133_in_conGD3625); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal506_tree = (Object)adaptor.create(string_literal506);
					adaptor.addChild(root_0, string_literal506_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3627);
					goalDesc507=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc507.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3629);
					goalDesc508=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc508.getTree());

					char_literal509=(Token)match(input,65,FOLLOW_65_in_conGD3631); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal509_tree = (Object)adaptor.create(char_literal509);
					adaptor.addChild(root_0, char_literal509_tree);
					}

					}
					break;
				case 10 :
					// Pddl.g:547:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal510=(Token)match(input,64,FOLLOW_64_in_conGD3636); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal510_tree = (Object)adaptor.create(char_literal510);
					adaptor.addChild(root_0, char_literal510_tree);
					}

					string_literal511=(Token)match(input,102,FOLLOW_102_in_conGD3638); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal511_tree = (Object)adaptor.create(string_literal511);
					adaptor.addChild(root_0, string_literal511_tree);
					}

					NUMBER512=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3640); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER512_tree = (Object)adaptor.create(NUMBER512);
					adaptor.addChild(root_0, NUMBER512_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3642);
					goalDesc513=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc513.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3644);
					goalDesc514=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc514.getTree());

					char_literal515=(Token)match(input,65,FOLLOW_65_in_conGD3646); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal515_tree = (Object)adaptor.create(char_literal515);
					adaptor.addChild(root_0, char_literal515_tree);
					}

					}
					break;
				case 11 :
					// Pddl.g:548:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal516=(Token)match(input,64,FOLLOW_64_in_conGD3651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal516_tree = (Object)adaptor.create(char_literal516);
					adaptor.addChild(root_0, char_literal516_tree);
					}

					string_literal517=(Token)match(input,116,FOLLOW_116_in_conGD3653); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal517_tree = (Object)adaptor.create(string_literal517);
					adaptor.addChild(root_0, string_literal517_tree);
					}

					NUMBER518=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3655); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER518_tree = (Object)adaptor.create(NUMBER518);
					adaptor.addChild(root_0, NUMBER518_tree);
					}

					NUMBER519=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3657); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER519_tree = (Object)adaptor.create(NUMBER519);
					adaptor.addChild(root_0, NUMBER519_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3659);
					goalDesc520=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc520.getTree());

					char_literal521=(Token)match(input,65,FOLLOW_65_in_conGD3661); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal521_tree = (Object)adaptor.create(char_literal521);
					adaptor.addChild(root_0, char_literal521_tree);
					}

					}
					break;
				case 12 :
					// Pddl.g:549:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal522=(Token)match(input,64,FOLLOW_64_in_conGD3666); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal522_tree = (Object)adaptor.create(char_literal522);
					adaptor.addChild(root_0, char_literal522_tree);
					}

					string_literal523=(Token)match(input,115,FOLLOW_115_in_conGD3668); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal523_tree = (Object)adaptor.create(string_literal523);
					adaptor.addChild(root_0, string_literal523_tree);
					}

					NUMBER524=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3670); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER524_tree = (Object)adaptor.create(NUMBER524);
					adaptor.addChild(root_0, NUMBER524_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3672);
					goalDesc525=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc525.getTree());

					char_literal526=(Token)match(input,65,FOLLOW_65_in_conGD3674); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal526_tree = (Object)adaptor.create(char_literal526);
					adaptor.addChild(root_0, char_literal526_tree);
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
		// Pddl.g:162:5: ( atomicFunctionSkeleton )
		// Pddl.g:162:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl810);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred48_Pddl
	public final void synpred48_Pddl_fragment() throws RecognitionException {
		// Pddl.g:286:7: ( fComp )
		// Pddl.g:286:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred48_Pddl1714);
		fComp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred48_Pddl

	// $ANTLR start synpred51_Pddl
	public final void synpred51_Pddl_fragment() throws RecognitionException {
		// Pddl.g:309:28: ( typedVariableList )
		// Pddl.g:309:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred51_Pddl1873);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred51_Pddl

	// $ANTLR start synpred64_Pddl
	public final void synpred64_Pddl_fragment() throws RecognitionException {
		// Pddl.g:349:4: ( '(' binaryOp fExp fExp2 ')' )
		// Pddl.g:349:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,64,FOLLOW_64_in_synpred64_Pddl2129); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred64_Pddl2131);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred64_Pddl2133);
		fExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp2_in_synpred64_Pddl2135);
		fExp2();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred64_Pddl2137); if (state.failed) return;

		}

	}
	// $ANTLR end synpred64_Pddl

	// $ANTLR start synpred65_Pddl
	public final void synpred65_Pddl_fragment() throws RecognitionException {
		// Pddl.g:350:4: ( '(' '-' fExp ')' )
		// Pddl.g:350:4: '(' '-' fExp ')'
		{
		match(input,64,FOLLOW_64_in_synpred65_Pddl2154); if (state.failed) return;

		match(input,68,FOLLOW_68_in_synpred65_Pddl2156); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred65_Pddl2158);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred65_Pddl2160); if (state.failed) return;

		}

	}
	// $ANTLR end synpred65_Pddl

	// $ANTLR start synpred66_Pddl
	public final void synpred66_Pddl_fragment() throws RecognitionException {
		// Pddl.g:351:7: ( '(' 'sin' fExp ')' )
		// Pddl.g:351:7: '(' 'sin' fExp ')'
		{
		match(input,64,FOLLOW_64_in_synpred66_Pddl2176); if (state.failed) return;

		match(input,130,FOLLOW_130_in_synpred66_Pddl2178); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred66_Pddl2180);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred66_Pddl2182); if (state.failed) return;

		}

	}
	// $ANTLR end synpred66_Pddl

	// $ANTLR start synpred67_Pddl
	public final void synpred67_Pddl_fragment() throws RecognitionException {
		// Pddl.g:352:7: ( '(' 'cos' fExp ')' )
		// Pddl.g:352:7: '(' 'cos' fExp ')'
		{
		match(input,64,FOLLOW_64_in_synpred67_Pddl2198); if (state.failed) return;

		match(input,107,FOLLOW_107_in_synpred67_Pddl2200); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred67_Pddl2202);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred67_Pddl2204); if (state.failed) return;

		}

	}
	// $ANTLR end synpred67_Pddl

	// $ANTLR start synpred97_Pddl
	public final void synpred97_Pddl_fragment() throws RecognitionException {
		// Pddl.g:419:12: ( NUMBER )
		// Pddl.g:419:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred97_Pddl2647); if (state.failed) return;

		}

	}
	// $ANTLR end synpred97_Pddl

	// $ANTLR start synpred99_Pddl
	public final void synpred99_Pddl_fragment() throws RecognitionException {
		// Pddl.g:422:4: ( '(' 'and' ( daEffect )* ')' )
		// Pddl.g:422:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,64,FOLLOW_64_in_synpred99_Pddl2661); if (state.failed) return;

		match(input,103,FOLLOW_103_in_synpred99_Pddl2663); if (state.failed) return;

		// Pddl.g:422:14: ( daEffect )*
		loop96:
		while (true) {
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==64) ) {
				alt96=1;
			}

			switch (alt96) {
			case 1 :
				// Pddl.g:422:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred99_Pddl2665);
				daEffect();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop96;
			}
		}

		match(input,65,FOLLOW_65_in_synpred99_Pddl2668); if (state.failed) return;

		}

	}
	// $ANTLR end synpred99_Pddl

	// $ANTLR start synpred100_Pddl
	public final void synpred100_Pddl_fragment() throws RecognitionException {
		// Pddl.g:423:4: ( timedEffect )
		// Pddl.g:423:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred100_Pddl2673);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred100_Pddl

	// $ANTLR start synpred101_Pddl
	public final void synpred101_Pddl_fragment() throws RecognitionException {
		// Pddl.g:424:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// Pddl.g:424:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,64,FOLLOW_64_in_synpred101_Pddl2678); if (state.failed) return;

		match(input,114,FOLLOW_114_in_synpred101_Pddl2680); if (state.failed) return;

		match(input,64,FOLLOW_64_in_synpred101_Pddl2682); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred101_Pddl2684);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred101_Pddl2686); if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred101_Pddl2688);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred101_Pddl2690); if (state.failed) return;

		}

	}
	// $ANTLR end synpred101_Pddl

	// $ANTLR start synpred102_Pddl
	public final void synpred102_Pddl_fragment() throws RecognitionException {
		// Pddl.g:425:4: ( '(' 'when' daGD timedEffect ')' )
		// Pddl.g:425:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,64,FOLLOW_64_in_synpred102_Pddl2695); if (state.failed) return;

		match(input,135,FOLLOW_135_in_synpred102_Pddl2697); if (state.failed) return;

		pushFollow(FOLLOW_daGD_in_synpred102_Pddl2699);
		daGD();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_timedEffect_in_synpred102_Pddl2701);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred102_Pddl2703); if (state.failed) return;

		}

	}
	// $ANTLR end synpred102_Pddl

	// $ANTLR start synpred103_Pddl
	public final void synpred103_Pddl_fragment() throws RecognitionException {
		// Pddl.g:430:4: ( '(' 'at' timeSpecifier daEffect ')' )
		// Pddl.g:430:4: '(' 'at' timeSpecifier daEffect ')'
		{
		match(input,64,FOLLOW_64_in_synpred103_Pddl2727); if (state.failed) return;

		match(input,105,FOLLOW_105_in_synpred103_Pddl2729); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred103_Pddl2731);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred103_Pddl2733);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred103_Pddl2735); if (state.failed) return;

		}

	}
	// $ANTLR end synpred103_Pddl

	// $ANTLR start synpred104_Pddl
	public final void synpred104_Pddl_fragment() throws RecognitionException {
		// Pddl.g:431:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		// Pddl.g:431:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		match(input,64,FOLLOW_64_in_synpred104_Pddl2745); if (state.failed) return;

		match(input,105,FOLLOW_105_in_synpred104_Pddl2747); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred104_Pddl2749);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fAssignDA_in_synpred104_Pddl2751);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred104_Pddl2753); if (state.failed) return;

		}

	}
	// $ANTLR end synpred104_Pddl

	// $ANTLR start synpred105_Pddl
	public final void synpred105_Pddl_fragment() throws RecognitionException {
		// Pddl.g:440:9: ( ( binaryOp fExpDA fExpDA ) )
		// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
		{
		// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
		// Pddl.g:440:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred105_Pddl2809);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred105_Pddl2811);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred105_Pddl2813);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred105_Pddl

	// $ANTLR start synpred106_Pddl
	public final void synpred106_Pddl_fragment() throws RecognitionException {
		// Pddl.g:440:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// Pddl.g:440:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,64,FOLLOW_64_in_synpred106_Pddl2805); if (state.failed) return;

		// Pddl.g:440:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt97=2;
		int LA97_0 = input.LA(1);
		if ( (LA97_0==68) ) {
			int LA97_1 = input.LA(2);
			if ( (synpred105_Pddl()) ) {
				alt97=1;
			}
			else if ( (true) ) {
				alt97=2;
			}

		}
		else if ( ((LA97_0 >= 66 && LA97_0 <= 67)||LA97_0==69||LA97_0==99) ) {
			alt97=1;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 97, 0, input);
			throw nvae;
		}

		switch (alt97) {
			case 1 :
				// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
				{
				// Pddl.g:440:9: ( binaryOp fExpDA fExpDA )
				// Pddl.g:440:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred106_Pddl2809);
				binaryOp();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred106_Pddl2811);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred106_Pddl2813);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;
			case 2 :
				// Pddl.g:440:36: ( '-' fExpDA )
				{
				// Pddl.g:440:36: ( '-' fExpDA )
				// Pddl.g:440:37: '-' fExpDA
				{
				match(input,68,FOLLOW_68_in_synpred106_Pddl2819); if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred106_Pddl2821);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;

		}

		match(input,65,FOLLOW_65_in_synpred106_Pddl2825); if (state.failed) return;

		}

	}
	// $ANTLR end synpred106_Pddl

	// $ANTLR start synpred118_Pddl
	public final void synpred118_Pddl_fragment() throws RecognitionException {
		// Pddl.g:509:4: ( '(' 'and' ( prefConGD )* ')' )
		// Pddl.g:509:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,64,FOLLOW_64_in_synpred118_Pddl3275); if (state.failed) return;

		match(input,103,FOLLOW_103_in_synpred118_Pddl3277); if (state.failed) return;

		// Pddl.g:509:14: ( prefConGD )*
		loop98:
		while (true) {
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==64) ) {
				alt98=1;
			}

			switch (alt98) {
			case 1 :
				// Pddl.g:509:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred118_Pddl3279);
				prefConGD();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop98;
			}
		}

		match(input,65,FOLLOW_65_in_synpred118_Pddl3282); if (state.failed) return;

		}

	}
	// $ANTLR end synpred118_Pddl

	// $ANTLR start synpred119_Pddl
	public final void synpred119_Pddl_fragment() throws RecognitionException {
		// Pddl.g:510:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// Pddl.g:510:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,64,FOLLOW_64_in_synpred119_Pddl3287); if (state.failed) return;

		match(input,114,FOLLOW_114_in_synpred119_Pddl3289); if (state.failed) return;

		match(input,64,FOLLOW_64_in_synpred119_Pddl3291); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred119_Pddl3293);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred119_Pddl3295); if (state.failed) return;

		pushFollow(FOLLOW_prefConGD_in_synpred119_Pddl3297);
		prefConGD();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred119_Pddl3299); if (state.failed) return;

		}

	}
	// $ANTLR end synpred119_Pddl

	// $ANTLR start synpred121_Pddl
	public final void synpred121_Pddl_fragment() throws RecognitionException {
		// Pddl.g:511:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// Pddl.g:511:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,64,FOLLOW_64_in_synpred121_Pddl3304); if (state.failed) return;

		match(input,126,FOLLOW_126_in_synpred121_Pddl3306); if (state.failed) return;

		// Pddl.g:511:21: ( NAME )?
		int alt99=2;
		int LA99_0 = input.LA(1);
		if ( (LA99_0==NAME) ) {
			alt99=1;
		}
		switch (alt99) {
			case 1 :
				// Pddl.g:511:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred121_Pddl3308); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred121_Pddl3311);
		conGD();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred121_Pddl3313); if (state.failed) return;

		}

	}
	// $ANTLR end synpred121_Pddl

	// $ANTLR start synpred123_Pddl
	public final void synpred123_Pddl_fragment() throws RecognitionException {
		// Pddl.g:523:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// Pddl.g:523:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,64,FOLLOW_64_in_synpred123_Pddl3374); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred123_Pddl3376);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred123_Pddl3378);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred123_Pddl3380);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred123_Pddl3382); if (state.failed) return;

		}

	}
	// $ANTLR end synpred123_Pddl

	// $ANTLR start synpred125_Pddl
	public final void synpred125_Pddl_fragment() throws RecognitionException {
		// Pddl.g:525:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// Pddl.g:525:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,64,FOLLOW_64_in_synpred125_Pddl3404); if (state.failed) return;

		pushFollow(FOLLOW_multiOp_in_synpred125_Pddl3406);
		multiOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred125_Pddl3408);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		// Pddl.g:525:27: ( metricFExp )+
		int cnt100=0;
		loop100:
		while (true) {
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==NAME||LA100_0==NUMBER||(LA100_0 >= 63 && LA100_0 <= 64)) ) {
				alt100=1;
			}

			switch (alt100) {
			case 1 :
				// Pddl.g:525:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred125_Pddl3410);
				metricFExp();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt100 >= 1 ) break loop100;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(100, input);
				throw eee;
			}
			cnt100++;
		}

		match(input,65,FOLLOW_65_in_synpred125_Pddl3413); if (state.failed) return;

		}

	}
	// $ANTLR end synpred125_Pddl

	// $ANTLR start synpred126_Pddl
	public final void synpred126_Pddl_fragment() throws RecognitionException {
		// Pddl.g:527:4: ( '(' '-' metricFExp ')' )
		// Pddl.g:527:4: '(' '-' metricFExp ')'
		{
		match(input,64,FOLLOW_64_in_synpred126_Pddl3437); if (state.failed) return;

		match(input,68,FOLLOW_68_in_synpred126_Pddl3439); if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred126_Pddl3441);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,65,FOLLOW_65_in_synpred126_Pddl3443); if (state.failed) return;

		}

	}
	// $ANTLR end synpred126_Pddl

	// $ANTLR start synpred128_Pddl
	public final void synpred128_Pddl_fragment() throws RecognitionException {
		// Pddl.g:530:4: ( fHead )
		// Pddl.g:530:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred128_Pddl3465);
		fHead();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred128_Pddl

	// Delegated rules

	public final boolean synpred66_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred66_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred126_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred126_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred125_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred125_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred65_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred65_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred51_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred51_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred103_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred103_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred67_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred67_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred123_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred123_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred48_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred48_Pddl_fragment(); // can never throw exception
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
		"\2\46\2\uffff";
	static final String DFA14_maxS =
		"\1\101\1\104\2\uffff";
	static final String DFA14_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA14_specialS =
		"\4\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\32\uffff\1\2",
			"\1\1\32\uffff\1\2\2\uffff\1\3",
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
			return "140:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\46\2\uffff";
	static final String DFA12_maxS =
		"\1\101\1\104\2\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA12_specialS =
		"\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\1\32\uffff\1\2",
			"\1\1\32\uffff\1\2\2\uffff\1\3",
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
			return "()+ loopback of 140:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\74\2\uffff";
	static final String DFA25_maxS =
		"\1\101\1\104\2\uffff";
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
			return "191:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\74\2\uffff";
	static final String DFA23_maxS =
		"\1\101\1\104\2\uffff";
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
			return "()+ loopback of 191:20: ( singleTypeVarList )+";
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_domain382 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_domain384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_domainName_in_domain386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_requireDef_in_domain394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_typesDef_in_domain403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_constantsDef_in_domain412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_predicatesDef_in_domain421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_functionsDef_in_domain430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_constraints_in_domain448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_structureDef_in_domain457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_domain466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_free_functionsDef550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_free_functionsDef552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_free_functionsDef556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_domainName579 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_domainName581 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NAME_in_domainName583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_domainName585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_requireDef612 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_requireDef614 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef616 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_requireDef619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_typesDef640 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_typesDef642 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_typesDef646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList673 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList678 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList681 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList701 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_singleTypeNameList704 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_type735 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_type737 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_primType_in_type739 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_type742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_functionsDef783 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_functionsDef785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_functionList_in_functionsDef787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_functionsDef789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList810 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000011L});
	public static final BitSet FOLLOW_68_in_functionList814 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_functionType_in_functionList816 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_atomicFunctionSkeleton832 = new BitSet(new long[]{0x8000004000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton835 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_atomicFunctionSkeleton840 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_123_in_functionType863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_constantsDef874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_constantsDef876 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constantsDef880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_predicatesDef900 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_predicatesDef902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_predicatesDef907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_atomicFormulaSkeleton928 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton931 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_atomicFormulaSkeleton936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList962 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList967 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList970 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList990 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_singleTypeVarList993 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_constraints1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_constraints1031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_conGD_in_constraints1034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constraints1036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1053 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraintDef_in_structureDef1063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_processDef_in_structureDef1068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eventDef_in_structureDef1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_actionDef1088 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDef1090 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_actionDef1101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_actionDef1104 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_actionDef1108 = new BitSet(new long[]{0x0000000000000000L,0x0000000001008002L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_actionDef1123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_eventDef1156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_eventDef1158 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_eventDef1160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_eventDef1169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_eventDef1172 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_eventDef1174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_eventDef1176 = new BitSet(new long[]{0x0000000000000000L,0x0000000001008002L});
	public static final BitSet FOLLOW_actionDefBody_in_eventDef1189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_eventDef1191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_processDef1224 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_processDef1226 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_processDef1228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_processDef1237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_processDef1240 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_processDef1242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_processDef1244 = new BitSet(new long[]{0x0000000000000000L,0x0000000001008002L});
	public static final BitSet FOLLOW_actionDefBody_in_processDef1257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_processDef1259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_constraintDef1293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_constraintDef1295 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_constraintDef1306 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_constraintDef1309 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_constraintDef1311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constraintDef1313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000082L});
	public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constraintDef1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_constraintSymbol1371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_actionDefBody1386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_actionDefBody1390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_actionDefBody1392 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_actionDefBody1407 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_actionDefBody1411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_actionDefBody1413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_constraintDefBody1453 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_constraintDefBody1457 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constraintDefBody1459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1507 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_goalDesc1509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_goalDesc1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1539 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_124_in_goalDesc1541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1543 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_goalDesc1546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1571 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_goalDesc1573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1575 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1601 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_goalDesc1603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1635 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_goalDesc1637 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_goalDesc1639 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goalDesc1673 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_goalDesc1675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_goalDesc1677 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1679 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goalDesc1685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_equality1769 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_equality1772 = new BitSet(new long[]{0x1000004000000000L});
	public static final BitSet FOLLOW_term_in_equality1774 = new BitSet(new long[]{0x1000004000000000L});
	public static final BitSet FOLLOW_term_in_equality1776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_equality1778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fComp1789 = new BitSet(new long[]{0x0000000000000000L,0x00000003E0000000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1792 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fComp1794 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fComp1796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fComp1798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_atomicTermFormula1810 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1812 = new BitSet(new long[]{0x1000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1814 = new BitSet(new long[]{0x1000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_atomicTermFormula1817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_durativeActionDef1854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_durativeActionDef1856 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1858 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_durativeActionDef1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_durativeActionDef1870 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1873 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_durativeActionDef1877 = new BitSet(new long[]{0x0000000000000000L,0x000000000000A080L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_durativeActionDef1892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_daDefBody1925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody1927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_daDefBody1932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_daDefBody1936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daDefBody1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_daDefBody1952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_daDefBody1956 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daDefBody1958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody1963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD1978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daGD1983 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_daGD1985 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_daGD_in_daGD1987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_daGD1990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daGD1995 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_daGD1997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_daGD1999 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD2001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daGD2003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daGD_in_daGD2005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daGD2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_prefTimedGD2023 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_prefTimedGD2025 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD2027 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_prefTimedGD2032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_timedGD2043 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_timedGD2045 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD2047 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_timedGD2051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_timedGD2056 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_timedGD2058 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_interval_in_timedGD2060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_timedGD2064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_100_in_interval2086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_derivedDef2099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_derivedDef2102 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef2105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef2107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_derivedDef2109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp2124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fExp2129 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_fExp2131 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fExp2133 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp2_in_fExp2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fExp2137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fExp2154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_fExp2156 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fExp2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fExp2160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fExp2176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_130_in_fExp2178 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fExp2180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fExp2182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fExp2198 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_fExp2200 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_fExp2202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fExp2204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp2217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp22229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fHead2239 = new BitSet(new long[]{0x8000004000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2241 = new BitSet(new long[]{0x1000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_fHead2243 = new BitSet(new long[]{0x1000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fHead2246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_effect2281 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_effect2283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_cEffect_in_effect2285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_effect2288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect2302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_cEffect2313 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_cEffect2315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_cEffect2317 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect2319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_cEffect2321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_effect_in_cEffect2323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_cEffect2325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_cEffect2343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_135_in_cEffect2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect2347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_condEffect_in_cEffect2349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_cEffect2351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_pEffect2380 = new BitSet(new long[]{0x0000000000000000L,0x0040110000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2382 = new BitSet(new long[]{0x8000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fHead_in_pEffect2384 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_pEffect2386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_pEffect2388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_pEffect2408 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_pEffect2410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_pEffect2414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_condEffect2443 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_condEffect2445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_condEffect2450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_durationConstraint2569 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_durationConstraint2571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_durationConstraint2576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_durationConstraint2581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_durationConstraint2583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_simpleDurationConstraint2599 = new BitSet(new long[]{0x0000000000000000L,0x00000002C0000000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2601 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_simpleDurationConstraint2603 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_simpleDurationConstraint2607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_simpleDurationConstraint2612 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_simpleDurationConstraint2614 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_simpleDurationConstraint2620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daEffect2661 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_daEffect2663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2665 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_daEffect2668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daEffect2678 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_daEffect2680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_daEffect2682 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daEffect2686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daEffect2690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daEffect2695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_135_in_daEffect2697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daGD_in_daEffect2699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daEffect2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daEffect2708 = new BitSet(new long[]{0x0000000000000000L,0x0040110000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2710 = new BitSet(new long[]{0x8000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fHead_in_daEffect2712 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_daEffect2716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_timedEffect2727 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_timedEffect2729 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_timedEffect2735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_timedEffect2745 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_timedEffect2747 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_timedEffect2753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_timedEffect2758 = new BitSet(new long[]{0x0000000000000000L,0x0040110000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2760 = new BitSet(new long[]{0x8000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2762 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_timedEffect2766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fAssignDA2786 = new BitSet(new long[]{0x0000000000000000L,0x0040110000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2788 = new BitSet(new long[]{0x8000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2790 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fAssignDA2794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_fExpDA2805 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2809 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2811 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_fExpDA2819 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_fExpDA2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_98_in_fExpDA2830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_problem2849 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_problem2851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_problemDecl_in_problem2853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_problemDomain_in_problem2858 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_requireDef_in_problem2866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_objectDecl_in_problem2875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_init_in_problem2884 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goal_in_problem2892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_probConstraints_in_problem2900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_metricSpec_in_problem2909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_problem2925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_problemDecl2982 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_127_in_problemDecl2984 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl2986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_problemDecl2988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_problemDomain3014 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_problemDomain3016 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain3018 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_problemDomain3020 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_objectDecl3040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_objectDecl3042 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl3044 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_objectDecl3046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_init3066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_init3068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_initEl_in_init3070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_init3073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_initEl3099 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_initEl3101 = new BitSet(new long[]{0x8000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fHead_in_initEl3103 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_initEl3107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_initEl3130 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_initEl3132 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_initEl3138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_nameLiteral3165 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_nameLiteral3167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_nameLiteral3171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_atomicNameFormula3190 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula3192 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula3194 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_atomicNameFormula3197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_goal3222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_goal3224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_goal3226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_goal3228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_probConstraints3246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_probConstraints3248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints3251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_probConstraints3253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_prefConGD3275 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_prefConGD3277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_prefConGD3282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_prefConGD3287 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_prefConGD3289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_prefConGD3291 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD3293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_prefConGD3295 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_prefConGD3299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_prefConGD3304 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_prefConGD3306 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_NAME_in_prefConGD3308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_prefConGD3313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_metricSpec3329 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_metricSpec3331 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec3333 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec3335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_metricSpec3337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_metricFExp3374 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3376 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3378 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_metricFExp3382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_metricFExp3404 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3406 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3408 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3410 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_metricFExp3413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_metricFExp3437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_metricFExp3439 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_metricFExp3443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_metricFExp3480 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_metricFExp3482 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_metricFExp3486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3500 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_conGD3502 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_conGD_in_conGD3504 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_conGD3507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3512 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_conGD3514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_conGD3516 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_conGD_in_conGD3522 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3529 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_conGD3531 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_conGD3533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3563 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_conGD3565 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3567 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3574 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_conGD3576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3586 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_136_in_conGD3588 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3599 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_106_in_conGD3601 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_132_in_conGD3612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3614 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_133_in_conGD3625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3636 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_conGD3638 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3651 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_conGD3653 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3655 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3657 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_conGD3666 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_conGD3668 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_conGD3674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred48_Pddl1714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred51_Pddl1873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred64_Pddl2129 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_synpred64_Pddl2131 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_synpred64_Pddl2133 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp2_in_synpred64_Pddl2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred64_Pddl2137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred65_Pddl2154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_synpred65_Pddl2156 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_synpred65_Pddl2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred65_Pddl2160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred66_Pddl2176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_130_in_synpred66_Pddl2178 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_synpred66_Pddl2180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred66_Pddl2182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred67_Pddl2198 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_synpred67_Pddl2200 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fExp_in_synpred67_Pddl2202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred67_Pddl2204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred97_Pddl2647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred99_Pddl2661 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_synpred99_Pddl2663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_daEffect_in_synpred99_Pddl2665 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_synpred99_Pddl2668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred100_Pddl2673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred101_Pddl2678 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_synpred101_Pddl2680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_synpred101_Pddl2682 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred101_Pddl2684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred101_Pddl2686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daEffect_in_synpred101_Pddl2688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred101_Pddl2690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred102_Pddl2695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_135_in_synpred102_Pddl2697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daGD_in_synpred102_Pddl2699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_timedEffect_in_synpred102_Pddl2701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred102_Pddl2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred103_Pddl2727 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_synpred103_Pddl2729 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred103_Pddl2731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_daEffect_in_synpred103_Pddl2733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred103_Pddl2735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred104_Pddl2745 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_synpred104_Pddl2747 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred104_Pddl2749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred104_Pddl2751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred104_Pddl2753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred105_Pddl2809 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_synpred105_Pddl2811 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_synpred105_Pddl2813 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred106_Pddl2805 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_synpred106_Pddl2809 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_synpred106_Pddl2811 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_synpred106_Pddl2813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_synpred106_Pddl2819 = new BitSet(new long[]{0x8000044000000000L,0x0000000400000001L});
	public static final BitSet FOLLOW_fExpDA_in_synpred106_Pddl2821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred106_Pddl2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred118_Pddl3275 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_synpred118_Pddl3277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_prefConGD_in_synpred118_Pddl3279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_synpred118_Pddl3282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred119_Pddl3287 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_synpred119_Pddl3289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_synpred119_Pddl3291 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred119_Pddl3293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred119_Pddl3295 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_prefConGD_in_synpred119_Pddl3297 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred119_Pddl3299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred121_Pddl3304 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_synpred121_Pddl3306 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_NAME_in_synpred121_Pddl3308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_conGD_in_synpred121_Pddl3311 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred121_Pddl3313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred123_Pddl3374 = new BitSet(new long[]{0x0000000000000000L,0x000000080000003CL});
	public static final BitSet FOLLOW_binaryOp_in_synpred123_Pddl3376 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_synpred123_Pddl3378 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_synpred123_Pddl3380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred123_Pddl3382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred125_Pddl3404 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
	public static final BitSet FOLLOW_multiOp_in_synpred125_Pddl3406 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_synpred125_Pddl3408 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_synpred125_Pddl3410 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_65_in_synpred125_Pddl3413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_synpred126_Pddl3437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_synpred126_Pddl3439 = new BitSet(new long[]{0x8000044000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_metricFExp_in_synpred126_Pddl3441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_synpred126_Pddl3443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred128_Pddl3465 = new BitSet(new long[]{0x0000000000000002L});
}
