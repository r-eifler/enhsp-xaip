// $ANTLR 3.5 Pddl.g 2014-03-24 16:49:38

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
		"DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", "EITHER_TYPE", 
		"EQUALITY_CON", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", "FUNCTIONS", 
		"FUNC_HEAD", "GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", 
		"LINE_COMMENT", "MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", 
		"NOT_PRED_INIT", "NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", 
		"PRED_HEAD", "PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", 
		"PROBLEM_METRIC", "PROBLEM_NAME", "REQUIREMENTS", "REQUIRE_KEY", "TYPES", 
		"UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", 
		"':constraints'", "':derived'", "':domain'", "':duration'", "':durative-action'", 
		"':effect'", "':functions'", "':goal'", "':init'", "':metric'", "':objects'", 
		"':parameters'", "':precondition'", "':predicates'", "':requirements'", 
		"':types'", "'<'", "'<='", "'='", "'>'", "'>='", "'?duration'", "'all'", 
		"'always'", "'always-within'", "'and'", "'assign'", "'at'", "'at-most-once'", 
		"'decrease'", "'define'", "'domain'", "'either'", "'end'", "'exists'", 
		"'forall'", "'hold-after'", "'hold-during'", "'imply'", "'increase'", 
		"'is-violated'", "'maximize'", "'minimize'", "'not'", "'number'", "'or'", 
		"'over'", "'preference'", "'problem'", "'scale-down'", "'scale-up'", "'sometime'", 
		"'sometime-after'", "'sometime-before'", "'start'", "'when'", "'within'"
	};
	public static final int EOF=-1;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
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
	public static final int ACTION=4;
	public static final int AND_EFFECT=5;
	public static final int AND_GD=6;
	public static final int ANY_CHAR=7;
	public static final int ASSIGN_EFFECT=8;
	public static final int BINARY_OP=9;
	public static final int COMPARISON_GD=10;
	public static final int CONSTANTS=11;
	public static final int DIGIT=12;
	public static final int DOMAIN=13;
	public static final int DOMAIN_NAME=14;
	public static final int DURATIVE_ACTION=15;
	public static final int EFFECT=16;
	public static final int EITHER_TYPE=17;
	public static final int EQUALITY_CON=18;
	public static final int EXISTS_GD=19;
	public static final int FORALL_EFFECT=20;
	public static final int FORALL_GD=21;
	public static final int FUNCTIONS=22;
	public static final int FUNC_HEAD=23;
	public static final int GOAL=24;
	public static final int IMPLY_GD=25;
	public static final int INIT=26;
	public static final int INIT_AT=27;
	public static final int INIT_EQ=28;
	public static final int LETTER=29;
	public static final int LINE_COMMENT=30;
	public static final int MINUS_OP=31;
	public static final int MULTI_OP=32;
	public static final int NAME=33;
	public static final int NOT_EFFECT=34;
	public static final int NOT_GD=35;
	public static final int NOT_PRED_INIT=36;
	public static final int NUMBER=37;
	public static final int OBJECTS=38;
	public static final int OR_GD=39;
	public static final int PRECONDITION=40;
	public static final int PREDICATES=41;
	public static final int PRED_HEAD=42;
	public static final int PRED_INST=43;
	public static final int PROBLEM=44;
	public static final int PROBLEM_CONSTRAINT=45;
	public static final int PROBLEM_DOMAIN=46;
	public static final int PROBLEM_METRIC=47;
	public static final int PROBLEM_NAME=48;
	public static final int REQUIREMENTS=49;
	public static final int REQUIRE_KEY=50;
	public static final int TYPES=51;
	public static final int UNARY_MINUS=52;
	public static final int VARIABLE=53;
	public static final int WHEN_EFFECT=54;
	public static final int WHITESPACE=55;

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
	// Pddl.g:91:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			// Pddl.g:91:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==56) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==95) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==56) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==96) ) {
							alt1=1;
						}
						else if ( (LA1_3==113) ) {
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
					// Pddl.g:91:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc320);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// Pddl.g:91:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc324);
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
	// Pddl.g:95:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ) ;
	public final PddlParser.domain_return domain() throws RecognitionException {
		PddlParser.domain_return retval = new PddlParser.domain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal3=null;
		Token string_literal4=null;
		Token char_literal13=null;
		ParserRuleReturnScope domainName5 =null;
		ParserRuleReturnScope requireDef6 =null;
		ParserRuleReturnScope typesDef7 =null;
		ParserRuleReturnScope constantsDef8 =null;
		ParserRuleReturnScope predicatesDef9 =null;
		ParserRuleReturnScope functionsDef10 =null;
		ParserRuleReturnScope constraints11 =null;
		ParserRuleReturnScope structureDef12 =null;

		Object char_literal3_tree=null;
		Object string_literal4_tree=null;
		Object char_literal13_tree=null;
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_constantsDef=new RewriteRuleSubtreeStream(adaptor,"rule constantsDef");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_predicatesDef=new RewriteRuleSubtreeStream(adaptor,"rule predicatesDef");
		RewriteRuleSubtreeStream stream_constraints=new RewriteRuleSubtreeStream(adaptor,"rule constraints");
		RewriteRuleSubtreeStream stream_structureDef=new RewriteRuleSubtreeStream(adaptor,"rule structureDef");
		RewriteRuleSubtreeStream stream_domainName=new RewriteRuleSubtreeStream(adaptor,"rule domainName");
		RewriteRuleSubtreeStream stream_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule functionsDef");
		RewriteRuleSubtreeStream stream_typesDef=new RewriteRuleSubtreeStream(adaptor,"rule typesDef");

		try {
			// Pddl.g:96:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ) )
			// Pddl.g:96:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,56,FOLLOW_56_in_domain339); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal3);

			string_literal4=(Token)match(input,95,FOLLOW_95_in_domain341); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain343);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// Pddl.g:97:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==56) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==79) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// Pddl.g:97:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain351);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// Pddl.g:98:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==56) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==80) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// Pddl.g:98:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain360);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// Pddl.g:99:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==56) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==64) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// Pddl.g:99:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain369);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// Pddl.g:100:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==56) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==78) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// Pddl.g:100:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain378);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// Pddl.g:101:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==56) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==71) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// Pddl.g:101:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain387);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// Pddl.g:102:7: ( constraints )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==56) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==65) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// Pddl.g:102:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain396);
					constraints11=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints11.getTree());
					}
					break;

			}

			// Pddl.g:103:7: ( structureDef )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==56) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Pddl.g:103:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain405);
					structureDef12=structureDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_structureDef.add(structureDef12.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			char_literal13=(Token)match(input,57,FOLLOW_57_in_domain414); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal13);

			// AST REWRITE
			// elements: constraints, functionsDef, predicatesDef, domainName, structureDef, constantsDef, requireDef, typesDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 105:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* )
			{
				// Pddl.g:105:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// Pddl.g:105:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:105:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// Pddl.g:106:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// Pddl.g:106:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// Pddl.g:106:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// Pddl.g:107:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// Pddl.g:107:30: ( structureDef )*
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


	public static class domainName_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "domainName"
	// Pddl.g:110:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
	public final PddlParser.domainName_return domainName() throws RecognitionException {
		PddlParser.domainName_return retval = new PddlParser.domainName_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal14=null;
		Token string_literal15=null;
		Token NAME16=null;
		Token char_literal17=null;

		Object char_literal14_tree=null;
		Object string_literal15_tree=null;
		Object NAME16_tree=null;
		Object char_literal17_tree=null;
		RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");

		try {
			// Pddl.g:111:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// Pddl.g:111:7: '(' 'domain' NAME ')'
			{
			char_literal14=(Token)match(input,56,FOLLOW_56_in_domainName498); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal14);

			string_literal15=(Token)match(input,96,FOLLOW_96_in_domainName500); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_96.add(string_literal15);

			NAME16=(Token)match(input,NAME,FOLLOW_NAME_in_domainName502); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME16);

			char_literal17=(Token)match(input,57,FOLLOW_57_in_domainName504); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal17);

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
			// 112:6: -> ^( DOMAIN_NAME NAME )
			{
				// Pddl.g:112:9: ^( DOMAIN_NAME NAME )
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
	// Pddl.g:115:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
	public final PddlParser.requireDef_return requireDef() throws RecognitionException {
		PddlParser.requireDef_return retval = new PddlParser.requireDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal18=null;
		Token string_literal19=null;
		Token REQUIRE_KEY20=null;
		Token char_literal21=null;

		Object char_literal18_tree=null;
		Object string_literal19_tree=null;
		Object REQUIRE_KEY20_tree=null;
		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_REQUIRE_KEY=new RewriteRuleTokenStream(adaptor,"token REQUIRE_KEY");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");

		try {
			// Pddl.g:116:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// Pddl.g:116:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal18=(Token)match(input,56,FOLLOW_56_in_requireDef531); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal18);

			string_literal19=(Token)match(input,79,FOLLOW_79_in_requireDef533); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_79.add(string_literal19);

			// Pddl.g:116:24: ( REQUIRE_KEY )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==REQUIRE_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Pddl.g:116:24: REQUIRE_KEY
					{
					REQUIRE_KEY20=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef535); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_REQUIRE_KEY.add(REQUIRE_KEY20);

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			char_literal21=(Token)match(input,57,FOLLOW_57_in_requireDef538); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal21);

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
			// 117:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// Pddl.g:117:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
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
	// Pddl.g:120:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
	public final PddlParser.typesDef_return typesDef() throws RecognitionException {
		PddlParser.typesDef_return retval = new PddlParser.typesDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal22=null;
		Token string_literal23=null;
		Token char_literal25=null;
		ParserRuleReturnScope typedNameList24 =null;

		Object char_literal22_tree=null;
		Object string_literal23_tree=null;
		Object char_literal25_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:121:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// Pddl.g:121:4: '(' ':types' typedNameList ')'
			{
			char_literal22=(Token)match(input,56,FOLLOW_56_in_typesDef559); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal22);

			string_literal23=(Token)match(input,80,FOLLOW_80_in_typesDef561); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal23);

			pushFollow(FOLLOW_typedNameList_in_typesDef563);
			typedNameList24=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList24.getTree());
			char_literal25=(Token)match(input,57,FOLLOW_57_in_typesDef565); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal25);

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
			// 122:4: -> ^( TYPES typedNameList )
			{
				// Pddl.g:122:7: ^( TYPES typedNameList )
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
	// Pddl.g:126:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
	public final PddlParser.typedNameList_return typedNameList() throws RecognitionException {
		PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME26=null;
		Token NAME28=null;
		ParserRuleReturnScope singleTypeNameList27 =null;

		Object NAME26_tree=null;
		Object NAME28_tree=null;

		try {
			// Pddl.g:127:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// Pddl.g:127:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:127:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt13=2;
			alt13 = dfa13.predict(input);
			switch (alt13) {
				case 1 :
					// Pddl.g:127:8: ( NAME )*
					{
					// Pddl.g:127:8: ( NAME )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==NAME) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// Pddl.g:127:8: NAME
							{
							NAME26=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList592); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME26_tree = (Object)adaptor.create(NAME26);
							adaptor.addChild(root_0, NAME26_tree);
							}

							}
							break;

						default :
							break loop10;
						}
					}

					}
					break;
				case 2 :
					// Pddl.g:127:16: ( singleTypeNameList )+ ( NAME )*
					{
					// Pddl.g:127:16: ( singleTypeNameList )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						alt11 = dfa11.predict(input);
						switch (alt11) {
						case 1 :
							// Pddl.g:127:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList597);
							singleTypeNameList27=singleTypeNameList();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeNameList27.getTree());

							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					// Pddl.g:127:36: ( NAME )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==NAME) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// Pddl.g:127:36: NAME
							{
							NAME28=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList600); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME28_tree = (Object)adaptor.create(NAME28);
							adaptor.addChild(root_0, NAME28_tree);
							}

							}
							break;

						default :
							break loop12;
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
	// Pddl.g:130:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME29=null;
		Token char_literal30=null;
		ParserRuleReturnScope t =null;

		Object NAME29_tree=null;
		Object char_literal30_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Pddl.g:131:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// Pddl.g:131:7: ( ( NAME )+ '-' t= type )
			{
			// Pddl.g:131:7: ( ( NAME )+ '-' t= type )
			// Pddl.g:131:8: ( NAME )+ '-' t= type
			{
			// Pddl.g:131:8: ( NAME )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==NAME) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// Pddl.g:131:8: NAME
					{
					NAME29=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList620); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME29);

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			char_literal30=(Token)match(input,60,FOLLOW_60_in_singleTypeNameList623); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal30);

			pushFollow(FOLLOW_type_in_singleTypeNameList627);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: NAME, t
			// token labels: 
			// rule labels: retval, t
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 132:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
					// Pddl.g:132:7: ^( NAME $t)
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
	// Pddl.g:135:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
	public final PddlParser.type_return type() throws RecognitionException {
		PddlParser.type_return retval = new PddlParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal31=null;
		Token string_literal32=null;
		Token char_literal34=null;
		ParserRuleReturnScope primType33 =null;
		ParserRuleReturnScope primType35 =null;

		Object char_literal31_tree=null;
		Object string_literal32_tree=null;
		Object char_literal34_tree=null;
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			// Pddl.g:136:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==56) ) {
				alt16=1;
			}
			else if ( (LA16_0==NAME) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// Pddl.g:136:4: ( '(' 'either' ( primType )+ ')' )
					{
					// Pddl.g:136:4: ( '(' 'either' ( primType )+ ')' )
					// Pddl.g:136:6: '(' 'either' ( primType )+ ')'
					{
					char_literal31=(Token)match(input,56,FOLLOW_56_in_type654); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal31);

					string_literal32=(Token)match(input,97,FOLLOW_97_in_type656); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_97.add(string_literal32);

					// Pddl.g:136:19: ( primType )+
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
							// Pddl.g:136:19: primType
							{
							pushFollow(FOLLOW_primType_in_type658);
							primType33=primType();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_primType.add(primType33.getTree());
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

					char_literal34=(Token)match(input,57,FOLLOW_57_in_type661); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal34);

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
					// 137:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// Pddl.g:137:7: ^( EITHER_TYPE ( primType )+ )
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
					// Pddl.g:138:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type682);
					primType35=primType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, primType35.getTree());

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
	// Pddl.g:141:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME36=null;

		Object NAME36_tree=null;

		try {
			// Pddl.g:141:10: ( NAME )
			// Pddl.g:141:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_primType692); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME36_tree = (Object)adaptor.create(NAME36);
			adaptor.addChild(root_0, NAME36_tree);
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
	// Pddl.g:143:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
	public final PddlParser.functionsDef_return functionsDef() throws RecognitionException {
		PddlParser.functionsDef_return retval = new PddlParser.functionsDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal37=null;
		Token string_literal38=null;
		Token char_literal40=null;
		ParserRuleReturnScope functionList39 =null;

		Object char_literal37_tree=null;
		Object string_literal38_tree=null;
		Object char_literal40_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// Pddl.g:144:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// Pddl.g:144:4: '(' ':functions' functionList ')'
			{
			char_literal37=(Token)match(input,56,FOLLOW_56_in_functionsDef702); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal37);

			string_literal38=(Token)match(input,71,FOLLOW_71_in_functionsDef704); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_71.add(string_literal38);

			pushFollow(FOLLOW_functionList_in_functionsDef706);
			functionList39=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList39.getTree());
			char_literal40=(Token)match(input,57,FOLLOW_57_in_functionsDef708); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal40);

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
			// 145:2: -> ^( FUNCTIONS functionList )
			{
				// Pddl.g:145:5: ^( FUNCTIONS functionList )
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
	// Pddl.g:148:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws RecognitionException {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal42=null;
		ParserRuleReturnScope atomicFunctionSkeleton41 =null;
		ParserRuleReturnScope functionType43 =null;

		Object char_literal42_tree=null;

		try {
			// Pddl.g:149:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// Pddl.g:149:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:149:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==56) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// Pddl.g:149:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// Pddl.g:149:5: ( atomicFunctionSkeleton )+
					int cnt17=0;
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==56) ) {
							int LA17_2 = input.LA(2);
							if ( (synpred17_Pddl()) ) {
								alt17=1;
							}

						}

						switch (alt17) {
						case 1 :
							// Pddl.g:149:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList729);
							atomicFunctionSkeleton41=atomicFunctionSkeleton();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicFunctionSkeleton41.getTree());

							}
							break;

						default :
							if ( cnt17 >= 1 ) break loop17;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(17, input);
							throw eee;
						}
						cnt17++;
					}

					// Pddl.g:149:29: ( '-' functionType )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==60) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// Pddl.g:149:30: '-' functionType
							{
							char_literal42=(Token)match(input,60,FOLLOW_60_in_functionList733); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal42_tree = (Object)adaptor.create(char_literal42);
							adaptor.addChild(root_0, char_literal42_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList735);
							functionType43=functionType();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, functionType43.getTree());

							}
							break;

					}

					}
					break;

				default :
					break loop19;
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
	// Pddl.g:152:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
	public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws RecognitionException {
		PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal44=null;
		Token char_literal47=null;
		ParserRuleReturnScope functionSymbol45 =null;
		ParserRuleReturnScope typedVariableList46 =null;

		Object char_literal44_tree=null;
		Object char_literal47_tree=null;

		try {
			// Pddl.g:153:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// Pddl.g:153:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal44=(Token)match(input,56,FOLLOW_56_in_atomicFunctionSkeleton751); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton754);
			functionSymbol45=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol45.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton757);
			typedVariableList46=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList46.getTree());

			char_literal47=(Token)match(input,57,FOLLOW_57_in_atomicFunctionSkeleton759); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:156:1: functionSymbol : NAME ;
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME48=null;

		Object NAME48_tree=null;

		try {
			// Pddl.g:156:16: ( NAME )
			// Pddl.g:156:18: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME48=(Token)match(input,NAME,FOLLOW_NAME_in_functionSymbol770); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME48_tree = (Object)adaptor.create(NAME48);
			adaptor.addChild(root_0, NAME48_tree);
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
	// Pddl.g:158:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal49=null;

		Object string_literal49_tree=null;

		try {
			// Pddl.g:158:14: ( 'number' )
			// Pddl.g:158:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal49=(Token)match(input,109,FOLLOW_109_in_functionType779); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal49_tree = (Object)adaptor.create(string_literal49);
			adaptor.addChild(root_0, string_literal49_tree);
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
	// Pddl.g:160:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
	public final PddlParser.constantsDef_return constantsDef() throws RecognitionException {
		PddlParser.constantsDef_return retval = new PddlParser.constantsDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal50=null;
		Token string_literal51=null;
		Token char_literal53=null;
		ParserRuleReturnScope typedNameList52 =null;

		Object char_literal50_tree=null;
		Object string_literal51_tree=null;
		Object char_literal53_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:161:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// Pddl.g:161:4: '(' ':constants' typedNameList ')'
			{
			char_literal50=(Token)match(input,56,FOLLOW_56_in_constantsDef790); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal50);

			string_literal51=(Token)match(input,64,FOLLOW_64_in_constantsDef792); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_64.add(string_literal51);

			pushFollow(FOLLOW_typedNameList_in_constantsDef794);
			typedNameList52=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList52.getTree());
			char_literal53=(Token)match(input,57,FOLLOW_57_in_constantsDef796); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal53);

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
			// 162:2: -> ^( CONSTANTS typedNameList )
			{
				// Pddl.g:162:5: ^( CONSTANTS typedNameList )
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
	// Pddl.g:165:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
	public final PddlParser.predicatesDef_return predicatesDef() throws RecognitionException {
		PddlParser.predicatesDef_return retval = new PddlParser.predicatesDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal54=null;
		Token string_literal55=null;
		Token char_literal57=null;
		ParserRuleReturnScope atomicFormulaSkeleton56 =null;

		Object char_literal54_tree=null;
		Object string_literal55_tree=null;
		Object char_literal57_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			// Pddl.g:166:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// Pddl.g:166:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal54=(Token)match(input,56,FOLLOW_56_in_predicatesDef816); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal54);

			string_literal55=(Token)match(input,78,FOLLOW_78_in_predicatesDef818); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal55);

			// Pddl.g:166:22: ( atomicFormulaSkeleton )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==56) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// Pddl.g:166:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef820);
					atomicFormulaSkeleton56=atomicFormulaSkeleton();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicFormulaSkeleton.add(atomicFormulaSkeleton56.getTree());
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			char_literal57=(Token)match(input,57,FOLLOW_57_in_predicatesDef823); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal57);

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
			// 167:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// Pddl.g:167:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
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
	// Pddl.g:170:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
	public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws RecognitionException {
		PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal58=null;
		Token char_literal61=null;
		ParserRuleReturnScope predicate59 =null;
		ParserRuleReturnScope typedVariableList60 =null;

		Object char_literal58_tree=null;
		Object char_literal61_tree=null;

		try {
			// Pddl.g:171:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// Pddl.g:171:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal58=(Token)match(input,56,FOLLOW_56_in_atomicFormulaSkeleton844); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton847);
			predicate59=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate59.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton850);
			typedVariableList60=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList60.getTree());

			char_literal61=(Token)match(input,57,FOLLOW_57_in_atomicFormulaSkeleton852); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:174:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME62=null;

		Object NAME62_tree=null;

		try {
			// Pddl.g:174:11: ( NAME )
			// Pddl.g:174:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME62=(Token)match(input,NAME,FOLLOW_NAME_in_predicate863); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME62_tree = (Object)adaptor.create(NAME62);
			adaptor.addChild(root_0, NAME62_tree);
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
	// Pddl.g:177:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
	public final PddlParser.typedVariableList_return typedVariableList() throws RecognitionException {
		PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE63=null;
		Token VARIABLE65=null;
		ParserRuleReturnScope singleTypeVarList64 =null;

		Object VARIABLE63_tree=null;
		Object VARIABLE65_tree=null;

		try {
			// Pddl.g:178:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// Pddl.g:178:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// Pddl.g:178:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt24=2;
			alt24 = dfa24.predict(input);
			switch (alt24) {
				case 1 :
					// Pddl.g:178:8: ( VARIABLE )*
					{
					// Pddl.g:178:8: ( VARIABLE )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==VARIABLE) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// Pddl.g:178:8: VARIABLE
							{
							VARIABLE63=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList878); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							VARIABLE63_tree = (Object)adaptor.create(VARIABLE63);
							adaptor.addChild(root_0, VARIABLE63_tree);
							}

							}
							break;

						default :
							break loop21;
						}
					}

					}
					break;
				case 2 :
					// Pddl.g:178:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// Pddl.g:178:20: ( singleTypeVarList )+
					int cnt22=0;
					loop22:
					while (true) {
						int alt22=2;
						alt22 = dfa22.predict(input);
						switch (alt22) {
						case 1 :
							// Pddl.g:178:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList883);
							singleTypeVarList64=singleTypeVarList();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, singleTypeVarList64.getTree());

							}
							break;

						default :
							if ( cnt22 >= 1 ) break loop22;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(22, input);
							throw eee;
						}
						cnt22++;
					}

					// Pddl.g:178:39: ( VARIABLE )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==VARIABLE) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// Pddl.g:178:39: VARIABLE
							{
							VARIABLE65=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList886); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							VARIABLE65_tree = (Object)adaptor.create(VARIABLE65);
							adaptor.addChild(root_0, VARIABLE65_tree);
							}

							}
							break;

						default :
							break loop23;
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
	// Pddl.g:181:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
	public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
		PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE66=null;
		Token char_literal67=null;
		ParserRuleReturnScope t =null;

		Object VARIABLE66_tree=null;
		Object char_literal67_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Pddl.g:182:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// Pddl.g:182:7: ( ( VARIABLE )+ '-' t= type )
			{
			// Pddl.g:182:7: ( ( VARIABLE )+ '-' t= type )
			// Pddl.g:182:8: ( VARIABLE )+ '-' t= type
			{
			// Pddl.g:182:8: ( VARIABLE )+
			int cnt25=0;
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==VARIABLE) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// Pddl.g:182:8: VARIABLE
					{
					VARIABLE66=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList906); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE66);

					}
					break;

				default :
					if ( cnt25 >= 1 ) break loop25;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(25, input);
					throw eee;
				}
				cnt25++;
			}

			char_literal67=(Token)match(input,60,FOLLOW_60_in_singleTypeVarList909); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal67);

			pushFollow(FOLLOW_type_in_singleTypeVarList913);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: t, VARIABLE
			// token labels: 
			// rule labels: retval, t
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 183:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_t.hasNext()||stream_VARIABLE.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_VARIABLE.hasNext() ) {
					// Pddl.g:183:10: ^( VARIABLE $t)
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
	// Pddl.g:186:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
	public final PddlParser.constraints_return constraints() throws RecognitionException {
		PddlParser.constraints_return retval = new PddlParser.constraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal68=null;
		Token string_literal69=null;
		Token char_literal71=null;
		ParserRuleReturnScope conGD70 =null;

		Object char_literal68_tree=null;
		Object string_literal69_tree=null;
		Object char_literal71_tree=null;

		try {
			// Pddl.g:187:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// Pddl.g:187:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal68=(Token)match(input,56,FOLLOW_56_in_constraints944); if (state.failed) return retval;
			string_literal69=(Token)match(input,65,FOLLOW_65_in_constraints947); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal69_tree = (Object)adaptor.create(string_literal69);
			root_0 = (Object)adaptor.becomeRoot(string_literal69_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints950);
			conGD70=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD70.getTree());

			char_literal71=(Token)match(input,57,FOLLOW_57_in_constraints952); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:190:1: structureDef : ( actionDef | durativeActionDef | derivedDef );
	public final PddlParser.structureDef_return structureDef() throws RecognitionException {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope actionDef72 =null;
		ParserRuleReturnScope durativeActionDef73 =null;
		ParserRuleReturnScope derivedDef74 =null;


		try {
			// Pddl.g:191:2: ( actionDef | durativeActionDef | derivedDef )
			int alt26=3;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==56) ) {
				switch ( input.LA(2) ) {
				case 62:
					{
					alt26=1;
					}
					break;
				case 69:
					{
					alt26=2;
					}
					break;
				case 66:
					{
					alt26=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// Pddl.g:191:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef964);
					actionDef72=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef72.getTree());

					}
					break;
				case 2 :
					// Pddl.g:192:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef969);
					durativeActionDef73=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef73.getTree());

					}
					break;
				case 3 :
					// Pddl.g:193:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef974);
					derivedDef74=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef74.getTree());

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
	// Pddl.g:199:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws RecognitionException {
		PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal75=null;
		Token string_literal76=null;
		Token string_literal78=null;
		Token char_literal79=null;
		Token char_literal81=null;
		Token char_literal83=null;
		ParserRuleReturnScope actionSymbol77 =null;
		ParserRuleReturnScope typedVariableList80 =null;
		ParserRuleReturnScope actionDefBody82 =null;

		Object char_literal75_tree=null;
		Object string_literal76_tree=null;
		Object string_literal78_tree=null;
		Object char_literal79_tree=null;
		Object char_literal81_tree=null;
		Object char_literal83_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");

		try {
			// Pddl.g:200:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// Pddl.g:200:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal75=(Token)match(input,56,FOLLOW_56_in_actionDef989); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal75);

			string_literal76=(Token)match(input,62,FOLLOW_62_in_actionDef991); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(string_literal76);

			pushFollow(FOLLOW_actionSymbol_in_actionDef993);
			actionSymbol77=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol77.getTree());
			string_literal78=(Token)match(input,76,FOLLOW_76_in_actionDef1002); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal78);

			char_literal79=(Token)match(input,56,FOLLOW_56_in_actionDef1005); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal79);

			pushFollow(FOLLOW_typedVariableList_in_actionDef1007);
			typedVariableList80=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList80.getTree());
			char_literal81=(Token)match(input,57,FOLLOW_57_in_actionDef1009); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal81);

			pushFollow(FOLLOW_actionDefBody_in_actionDef1022);
			actionDefBody82=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody82.getTree());
			char_literal83=(Token)match(input,57,FOLLOW_57_in_actionDef1024); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal83);

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
			// 203:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// Pddl.g:203:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// Pddl.g:203:33: ( typedVariableList )?
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


	public static class actionSymbol_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionSymbol"
	// Pddl.g:206:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME84=null;

		Object NAME84_tree=null;

		try {
			// Pddl.g:206:14: ( NAME )
			// Pddl.g:206:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME84=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1057); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME84_tree = (Object)adaptor.create(NAME84);
			adaptor.addChild(root_0, NAME84_tree);
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


	public static class actionDefBody_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "actionDefBody"
	// Pddl.g:212:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
		PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal85=null;
		Token char_literal86=null;
		Token char_literal87=null;
		Token string_literal89=null;
		Token char_literal90=null;
		Token char_literal91=null;
		ParserRuleReturnScope goalDesc88 =null;
		ParserRuleReturnScope effect92 =null;

		Object string_literal85_tree=null;
		Object char_literal86_tree=null;
		Object char_literal87_tree=null;
		Object string_literal89_tree=null;
		Object char_literal90_tree=null;
		Object char_literal91_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// Pddl.g:213:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// Pddl.g:213:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// Pddl.g:213:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==77) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// Pddl.g:213:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal85=(Token)match(input,77,FOLLOW_77_in_actionDefBody1073); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_77.add(string_literal85);

					// Pddl.g:213:22: ( ( '(' ')' ) | goalDesc )
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==56) ) {
						int LA27_1 = input.LA(2);
						if ( (LA27_1==57) ) {
							alt27=1;
						}
						else if ( (LA27_1==NAME||(LA27_1 >= 81 && LA27_1 <= 85)||LA27_1==90||(LA27_1 >= 99 && LA27_1 <= 100)||LA27_1==103||LA27_1==108||LA27_1==110) ) {
							alt27=2;
						}

						else {
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
							// Pddl.g:213:23: ( '(' ')' )
							{
							// Pddl.g:213:23: ( '(' ')' )
							// Pddl.g:213:24: '(' ')'
							{
							char_literal86=(Token)match(input,56,FOLLOW_56_in_actionDefBody1077); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_56.add(char_literal86);

							char_literal87=(Token)match(input,57,FOLLOW_57_in_actionDefBody1079); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_57.add(char_literal87);

							}

							}
							break;
						case 2 :
							// Pddl.g:213:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1084);
							goalDesc88=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc88.getTree());
							}
							break;

					}

					}
					break;

			}

			// Pddl.g:214:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==70) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// Pddl.g:214:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal89=(Token)match(input,70,FOLLOW_70_in_actionDefBody1094); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_70.add(string_literal89);

					// Pddl.g:214:16: ( ( '(' ')' ) | effect )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==56) ) {
						int LA29_1 = input.LA(2);
						if ( (LA29_1==57) ) {
							alt29=1;
						}
						else if ( (LA29_1==NAME||(LA29_1 >= 90 && LA29_1 <= 91)||LA29_1==94||LA29_1==100||LA29_1==104||LA29_1==108||(LA29_1 >= 114 && LA29_1 <= 115)||LA29_1==120) ) {
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
							// Pddl.g:214:17: ( '(' ')' )
							{
							// Pddl.g:214:17: ( '(' ')' )
							// Pddl.g:214:18: '(' ')'
							{
							char_literal90=(Token)match(input,56,FOLLOW_56_in_actionDefBody1098); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_56.add(char_literal90);

							char_literal91=(Token)match(input,57,FOLLOW_57_in_actionDefBody1100); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_57.add(char_literal91);

							}

							}
							break;
						case 2 :
							// Pddl.g:214:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1105);
							effect92=effect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_effect.add(effect92.getTree());
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
			// 215:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// Pddl.g:215:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// Pddl.g:215:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// Pddl.g:215:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// Pddl.g:215:42: ( effect )?
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


	public static class goalDesc_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "goalDesc"
	// Pddl.g:229:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
		PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal94=null;
		Token string_literal95=null;
		Token char_literal97=null;
		Token char_literal98=null;
		Token string_literal99=null;
		Token char_literal101=null;
		Token char_literal102=null;
		Token string_literal103=null;
		Token char_literal105=null;
		Token char_literal106=null;
		Token string_literal107=null;
		Token char_literal110=null;
		Token char_literal111=null;
		Token string_literal112=null;
		Token char_literal113=null;
		Token char_literal115=null;
		Token char_literal117=null;
		Token char_literal118=null;
		Token string_literal119=null;
		Token char_literal120=null;
		Token char_literal122=null;
		Token char_literal124=null;
		ParserRuleReturnScope atomicTermFormula93 =null;
		ParserRuleReturnScope goalDesc96 =null;
		ParserRuleReturnScope goalDesc100 =null;
		ParserRuleReturnScope goalDesc104 =null;
		ParserRuleReturnScope goalDesc108 =null;
		ParserRuleReturnScope goalDesc109 =null;
		ParserRuleReturnScope typedVariableList114 =null;
		ParserRuleReturnScope goalDesc116 =null;
		ParserRuleReturnScope typedVariableList121 =null;
		ParserRuleReturnScope goalDesc123 =null;
		ParserRuleReturnScope fComp125 =null;
		ParserRuleReturnScope equality126 =null;

		Object char_literal94_tree=null;
		Object string_literal95_tree=null;
		Object char_literal97_tree=null;
		Object char_literal98_tree=null;
		Object string_literal99_tree=null;
		Object char_literal101_tree=null;
		Object char_literal102_tree=null;
		Object string_literal103_tree=null;
		Object char_literal105_tree=null;
		Object char_literal106_tree=null;
		Object string_literal107_tree=null;
		Object char_literal110_tree=null;
		Object char_literal111_tree=null;
		Object string_literal112_tree=null;
		Object char_literal113_tree=null;
		Object char_literal115_tree=null;
		Object char_literal117_tree=null;
		Object char_literal118_tree=null;
		Object string_literal119_tree=null;
		Object char_literal120_tree=null;
		Object char_literal122_tree=null;
		Object char_literal124_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// Pddl.g:230:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt33=9;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==56) ) {
				switch ( input.LA(2) ) {
				case 90:
					{
					alt33=2;
					}
					break;
				case 110:
					{
					alt33=3;
					}
					break;
				case 108:
					{
					alt33=4;
					}
					break;
				case 103:
					{
					alt33=5;
					}
					break;
				case 99:
					{
					alt33=6;
					}
					break;
				case 100:
					{
					alt33=7;
					}
					break;
				case 83:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA33_13 = input.LA(5);
							if ( (LA33_13==57) ) {
								int LA33_14 = input.LA(6);
								if ( (synpred41_Pddl()) ) {
									alt33=8;
								}
								else if ( (true) ) {
									alt33=9;
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
										new NoViableAltException("", 33, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case NUMBER:
						case 56:
							{
							alt33=8;
							}
							break;
						case VARIABLE:
							{
							alt33=9;
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
									new NoViableAltException("", 33, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case NUMBER:
					case 56:
						{
						alt33=8;
						}
						break;
					case VARIABLE:
						{
						alt33=9;
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
								new NoViableAltException("", 33, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case NAME:
					{
					alt33=1;
					}
					break;
				case 81:
				case 82:
				case 84:
				case 85:
					{
					alt33=8;
					}
					break;
				default:
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
					// Pddl.g:230:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1149);
					atomicTermFormula93=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula93.getTree());

					}
					break;
				case 2 :
					// Pddl.g:231:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal94=(Token)match(input,56,FOLLOW_56_in_goalDesc1154); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal94);

					string_literal95=(Token)match(input,90,FOLLOW_90_in_goalDesc1156); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_90.add(string_literal95);

					// Pddl.g:231:14: ( goalDesc )*
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==56) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// Pddl.g:231:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1158);
							goalDesc96=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc96.getTree());
							}
							break;

						default :
							break loop31;
						}
					}

					char_literal97=(Token)match(input,57,FOLLOW_57_in_goalDesc1161); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal97);

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
					// 232:12: -> ^( AND_GD ( goalDesc )* )
					{
						// Pddl.g:232:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// Pddl.g:232:24: ( goalDesc )*
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
					// Pddl.g:233:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal98=(Token)match(input,56,FOLLOW_56_in_goalDesc1186); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal98);

					string_literal99=(Token)match(input,110,FOLLOW_110_in_goalDesc1188); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_110.add(string_literal99);

					// Pddl.g:233:13: ( goalDesc )*
					loop32:
					while (true) {
						int alt32=2;
						int LA32_0 = input.LA(1);
						if ( (LA32_0==56) ) {
							alt32=1;
						}

						switch (alt32) {
						case 1 :
							// Pddl.g:233:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1190);
							goalDesc100=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc100.getTree());
							}
							break;

						default :
							break loop32;
						}
					}

					char_literal101=(Token)match(input,57,FOLLOW_57_in_goalDesc1193); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal101);

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
					// 234:12: -> ^( OR_GD ( goalDesc )* )
					{
						// Pddl.g:234:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// Pddl.g:234:23: ( goalDesc )*
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
					// Pddl.g:235:4: '(' 'not' goalDesc ')'
					{
					char_literal102=(Token)match(input,56,FOLLOW_56_in_goalDesc1218); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal102);

					string_literal103=(Token)match(input,108,FOLLOW_108_in_goalDesc1220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_108.add(string_literal103);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1222);
					goalDesc104=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc104.getTree());
					char_literal105=(Token)match(input,57,FOLLOW_57_in_goalDesc1224); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal105);

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
					// 236:12: -> ^( NOT_GD goalDesc )
					{
						// Pddl.g:236:15: ^( NOT_GD goalDesc )
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
					// Pddl.g:237:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal106=(Token)match(input,56,FOLLOW_56_in_goalDesc1248); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal106);

					string_literal107=(Token)match(input,103,FOLLOW_103_in_goalDesc1250); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(string_literal107);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1252);
					goalDesc108=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc108.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1254);
					goalDesc109=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc109.getTree());
					char_literal110=(Token)match(input,57,FOLLOW_57_in_goalDesc1256); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal110);

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
					// 238:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// Pddl.g:238:15: ^( IMPLY_GD goalDesc goalDesc )
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
					// Pddl.g:239:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal111=(Token)match(input,56,FOLLOW_56_in_goalDesc1282); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal111);

					string_literal112=(Token)match(input,99,FOLLOW_99_in_goalDesc1284); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_99.add(string_literal112);

					char_literal113=(Token)match(input,56,FOLLOW_56_in_goalDesc1286); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal113);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1288);
					typedVariableList114=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList114.getTree());
					char_literal115=(Token)match(input,57,FOLLOW_57_in_goalDesc1290); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal115);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1292);
					goalDesc116=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc116.getTree());
					char_literal117=(Token)match(input,57,FOLLOW_57_in_goalDesc1294); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal117);

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
					// 240:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// Pddl.g:240:15: ^( EXISTS_GD typedVariableList goalDesc )
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
					// Pddl.g:241:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal118=(Token)match(input,56,FOLLOW_56_in_goalDesc1320); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal118);

					string_literal119=(Token)match(input,100,FOLLOW_100_in_goalDesc1322); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_100.add(string_literal119);

					char_literal120=(Token)match(input,56,FOLLOW_56_in_goalDesc1324); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal120);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1326);
					typedVariableList121=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList121.getTree());
					char_literal122=(Token)match(input,57,FOLLOW_57_in_goalDesc1328); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal122);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1330);
					goalDesc123=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc123.getTree());
					char_literal124=(Token)match(input,57,FOLLOW_57_in_goalDesc1332); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal124);

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
					// 242:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// Pddl.g:242:15: ^( FORALL_GD typedVariableList goalDesc )
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
					// Pddl.g:243:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1361);
					fComp125=fComp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fComp.add(fComp125.getTree());
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
					// 244:15: -> ^( COMPARISON_GD fComp )
					{
						// Pddl.g:244:18: ^( COMPARISON_GD fComp )
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
					// Pddl.g:245:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1388);
					equality126=equality();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_equality.add(equality126.getTree());
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
					// 246:6: -> ^( EQUALITY_CON equality )
					{
						// Pddl.g:246:9: ^( EQUALITY_CON equality )
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
	// Pddl.g:249:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws RecognitionException {
		PddlParser.equality_return retval = new PddlParser.equality_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal127=null;
		Token char_literal128=null;
		Token char_literal131=null;
		ParserRuleReturnScope term129 =null;
		ParserRuleReturnScope term130 =null;

		Object char_literal127_tree=null;
		Object char_literal128_tree=null;
		Object char_literal131_tree=null;

		try {
			// Pddl.g:250:2: ( '(' ! '=' term term ')' !)
			// Pddl.g:250:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal127=(Token)match(input,56,FOLLOW_56_in_equality1416); if (state.failed) return retval;
			char_literal128=(Token)match(input,83,FOLLOW_83_in_equality1419); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal128_tree = (Object)adaptor.create(char_literal128);
			adaptor.addChild(root_0, char_literal128_tree);
			}

			pushFollow(FOLLOW_term_in_equality1421);
			term129=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term129.getTree());

			pushFollow(FOLLOW_term_in_equality1423);
			term130=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term130.getTree());

			char_literal131=(Token)match(input,57,FOLLOW_57_in_equality1425); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:252:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws RecognitionException {
		PddlParser.fComp_return retval = new PddlParser.fComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal132=null;
		Token char_literal136=null;
		ParserRuleReturnScope binaryComp133 =null;
		ParserRuleReturnScope fExp134 =null;
		ParserRuleReturnScope fExp135 =null;

		Object char_literal132_tree=null;
		Object char_literal136_tree=null;

		try {
			// Pddl.g:253:2: ( '(' ! binaryComp fExp fExp ')' !)
			// Pddl.g:253:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal132=(Token)match(input,56,FOLLOW_56_in_fComp1436); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1439);
			binaryComp133=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp133.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1441);
			fExp134=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp134.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1443);
			fExp135=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp135.getTree());

			char_literal136=(Token)match(input,57,FOLLOW_57_in_fComp1445); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:256:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal137=null;
		Token char_literal140=null;
		ParserRuleReturnScope predicate138 =null;
		ParserRuleReturnScope term139 =null;

		Object char_literal137_tree=null;
		Object char_literal140_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// Pddl.g:257:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// Pddl.g:257:4: '(' predicate ( term )* ')'
			{
			char_literal137=(Token)match(input,56,FOLLOW_56_in_atomicTermFormula1457); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal137);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1459);
			predicate138=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate138.getTree());
			// Pddl.g:257:18: ( term )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==NAME||LA34_0==VARIABLE) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// Pddl.g:257:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1461);
					term139=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_term.add(term139.getTree());
					}
					break;

				default :
					break loop34;
				}
			}

			char_literal140=(Token)match(input,57,FOLLOW_57_in_atomicTermFormula1464); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal140);

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
			// 257:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// Pddl.g:257:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:257:53: ( term )*
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
	// Pddl.g:260:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set141=null;

		Object set141_tree=null;

		try {
			// Pddl.g:260:6: ( NAME | VARIABLE )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set141=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set141));
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
	// Pddl.g:264:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
		PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal142=null;
		Token string_literal143=null;
		Token string_literal145=null;
		Token char_literal146=null;
		Token char_literal148=null;
		Token char_literal150=null;
		ParserRuleReturnScope actionSymbol144 =null;
		ParserRuleReturnScope typedVariableList147 =null;
		ParserRuleReturnScope daDefBody149 =null;

		Object char_literal142_tree=null;
		Object string_literal143_tree=null;
		Object string_literal145_tree=null;
		Object char_literal146_tree=null;
		Object char_literal148_tree=null;
		Object char_literal150_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// Pddl.g:265:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// Pddl.g:265:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal142=(Token)match(input,56,FOLLOW_56_in_durativeActionDef1502); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal142);

			string_literal143=(Token)match(input,69,FOLLOW_69_in_durativeActionDef1504); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(string_literal143);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1506);
			actionSymbol144=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol144.getTree());
			string_literal145=(Token)match(input,76,FOLLOW_76_in_durativeActionDef1515); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal145);

			char_literal146=(Token)match(input,56,FOLLOW_56_in_durativeActionDef1518); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal146);

			// Pddl.g:266:27: ( typedVariableList )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==VARIABLE) ) {
				alt35=1;
			}
			else if ( (LA35_0==57) ) {
				int LA35_2 = input.LA(2);
				if ( (synpred44_Pddl()) ) {
					alt35=1;
				}
			}
			switch (alt35) {
				case 1 :
					// Pddl.g:266:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1521);
					typedVariableList147=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList147.getTree());
					}
					break;

			}

			char_literal148=(Token)match(input,57,FOLLOW_57_in_durativeActionDef1525); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal148);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1538);
			daDefBody149=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody149.getTree());
			char_literal150=(Token)match(input,57,FOLLOW_57_in_durativeActionDef1540); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal150);

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
			// 268:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// Pddl.g:268:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
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
	// Pddl.g:271:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
		PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal151=null;
		Token string_literal153=null;
		Token char_literal154=null;
		Token char_literal155=null;
		Token string_literal157=null;
		Token char_literal158=null;
		Token char_literal159=null;
		ParserRuleReturnScope durationConstraint152 =null;
		ParserRuleReturnScope daGD156 =null;
		ParserRuleReturnScope daEffect160 =null;

		Object string_literal151_tree=null;
		Object string_literal153_tree=null;
		Object char_literal154_tree=null;
		Object char_literal155_tree=null;
		Object string_literal157_tree=null;
		Object char_literal158_tree=null;
		Object char_literal159_tree=null;

		try {
			// Pddl.g:272:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt38=3;
			switch ( input.LA(1) ) {
			case 68:
				{
				alt38=1;
				}
				break;
			case 63:
				{
				alt38=2;
				}
				break;
			case 70:
				{
				alt38=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// Pddl.g:272:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal151=(Token)match(input,68,FOLLOW_68_in_daDefBody1573); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal151_tree = (Object)adaptor.create(string_literal151);
					adaptor.addChild(root_0, string_literal151_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody1575);
					durationConstraint152=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint152.getTree());

					}
					break;
				case 2 :
					// Pddl.g:273:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal153=(Token)match(input,63,FOLLOW_63_in_daDefBody1580); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal153_tree = (Object)adaptor.create(string_literal153);
					adaptor.addChild(root_0, string_literal153_tree);
					}

					// Pddl.g:273:17: ( ( '(' ')' ) | daGD )
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==56) ) {
						int LA36_1 = input.LA(2);
						if ( (LA36_1==57) ) {
							alt36=1;
						}
						else if ( (LA36_1==90||LA36_1==92||LA36_1==100||(LA36_1 >= 111 && LA36_1 <= 112)) ) {
							alt36=2;
						}

						else {
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
							// Pddl.g:273:18: ( '(' ')' )
							{
							// Pddl.g:273:18: ( '(' ')' )
							// Pddl.g:273:19: '(' ')'
							{
							char_literal154=(Token)match(input,56,FOLLOW_56_in_daDefBody1584); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal154_tree = (Object)adaptor.create(char_literal154);
							adaptor.addChild(root_0, char_literal154_tree);
							}

							char_literal155=(Token)match(input,57,FOLLOW_57_in_daDefBody1586); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal155_tree = (Object)adaptor.create(char_literal155);
							adaptor.addChild(root_0, char_literal155_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:273:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody1591);
							daGD156=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD156.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// Pddl.g:274:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal157=(Token)match(input,70,FOLLOW_70_in_daDefBody1600); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal157_tree = (Object)adaptor.create(string_literal157);
					adaptor.addChild(root_0, string_literal157_tree);
					}

					// Pddl.g:274:17: ( ( '(' ')' ) | daEffect )
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==56) ) {
						int LA37_1 = input.LA(2);
						if ( (LA37_1==57) ) {
							alt37=1;
						}
						else if ( ((LA37_1 >= 90 && LA37_1 <= 92)||LA37_1==94||LA37_1==100||LA37_1==104||(LA37_1 >= 114 && LA37_1 <= 115)||LA37_1==120) ) {
							alt37=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 37, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 37, 0, input);
						throw nvae;
					}

					switch (alt37) {
						case 1 :
							// Pddl.g:274:18: ( '(' ')' )
							{
							// Pddl.g:274:18: ( '(' ')' )
							// Pddl.g:274:19: '(' ')'
							{
							char_literal158=(Token)match(input,56,FOLLOW_56_in_daDefBody1604); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal158_tree = (Object)adaptor.create(char_literal158);
							adaptor.addChild(root_0, char_literal158_tree);
							}

							char_literal159=(Token)match(input,57,FOLLOW_57_in_daDefBody1606); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal159_tree = (Object)adaptor.create(char_literal159);
							adaptor.addChild(root_0, char_literal159_tree);
							}

							}

							}
							break;
						case 2 :
							// Pddl.g:274:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody1611);
							daEffect160=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect160.getTree());

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
	// Pddl.g:277:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws RecognitionException {
		PddlParser.daGD_return retval = new PddlParser.daGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal162=null;
		Token string_literal163=null;
		Token char_literal165=null;
		Token char_literal166=null;
		Token string_literal167=null;
		Token char_literal168=null;
		Token char_literal170=null;
		Token char_literal172=null;
		ParserRuleReturnScope prefTimedGD161 =null;
		ParserRuleReturnScope daGD164 =null;
		ParserRuleReturnScope typedVariableList169 =null;
		ParserRuleReturnScope daGD171 =null;

		Object char_literal162_tree=null;
		Object string_literal163_tree=null;
		Object char_literal165_tree=null;
		Object char_literal166_tree=null;
		Object string_literal167_tree=null;
		Object char_literal168_tree=null;
		Object char_literal170_tree=null;
		Object char_literal172_tree=null;

		try {
			// Pddl.g:278:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt40=3;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==56) ) {
				switch ( input.LA(2) ) {
				case 92:
				case 111:
				case 112:
					{
					alt40=1;
					}
					break;
				case 90:
					{
					alt40=2;
					}
					break;
				case 100:
					{
					alt40=3;
					}
					break;
				default:
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
					// Pddl.g:278:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD1626);
					prefTimedGD161=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD161.getTree());

					}
					break;
				case 2 :
					// Pddl.g:279:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal162=(Token)match(input,56,FOLLOW_56_in_daGD1631); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal162_tree = (Object)adaptor.create(char_literal162);
					adaptor.addChild(root_0, char_literal162_tree);
					}

					string_literal163=(Token)match(input,90,FOLLOW_90_in_daGD1633); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal163_tree = (Object)adaptor.create(string_literal163);
					adaptor.addChild(root_0, string_literal163_tree);
					}

					// Pddl.g:279:14: ( daGD )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==56) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// Pddl.g:279:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD1635);
							daGD164=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD164.getTree());

							}
							break;

						default :
							break loop39;
						}
					}

					char_literal165=(Token)match(input,57,FOLLOW_57_in_daGD1638); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal165_tree = (Object)adaptor.create(char_literal165);
					adaptor.addChild(root_0, char_literal165_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:280:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal166=(Token)match(input,56,FOLLOW_56_in_daGD1643); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal166_tree = (Object)adaptor.create(char_literal166);
					adaptor.addChild(root_0, char_literal166_tree);
					}

					string_literal167=(Token)match(input,100,FOLLOW_100_in_daGD1645); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal167_tree = (Object)adaptor.create(string_literal167);
					adaptor.addChild(root_0, string_literal167_tree);
					}

					char_literal168=(Token)match(input,56,FOLLOW_56_in_daGD1647); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal168_tree = (Object)adaptor.create(char_literal168);
					adaptor.addChild(root_0, char_literal168_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD1649);
					typedVariableList169=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList169.getTree());

					char_literal170=(Token)match(input,57,FOLLOW_57_in_daGD1651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal170_tree = (Object)adaptor.create(char_literal170);
					adaptor.addChild(root_0, char_literal170_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD1653);
					daGD171=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD171.getTree());

					char_literal172=(Token)match(input,57,FOLLOW_57_in_daGD1655); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal172_tree = (Object)adaptor.create(char_literal172);
					adaptor.addChild(root_0, char_literal172_tree);
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
	// Pddl.g:283:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
		PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal174=null;
		Token string_literal175=null;
		Token NAME176=null;
		Token char_literal178=null;
		ParserRuleReturnScope timedGD173 =null;
		ParserRuleReturnScope timedGD177 =null;

		Object char_literal174_tree=null;
		Object string_literal175_tree=null;
		Object NAME176_tree=null;
		Object char_literal178_tree=null;

		try {
			// Pddl.g:284:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==56) ) {
				int LA42_1 = input.LA(2);
				if ( (LA42_1==92||LA42_1==111) ) {
					alt42=1;
				}
				else if ( (LA42_1==112) ) {
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
					// Pddl.g:284:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD1666);
					timedGD173=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD173.getTree());

					}
					break;
				case 2 :
					// Pddl.g:285:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal174=(Token)match(input,56,FOLLOW_56_in_prefTimedGD1671); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal174_tree = (Object)adaptor.create(char_literal174);
					adaptor.addChild(root_0, char_literal174_tree);
					}

					string_literal175=(Token)match(input,112,FOLLOW_112_in_prefTimedGD1673); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal175_tree = (Object)adaptor.create(string_literal175);
					adaptor.addChild(root_0, string_literal175_tree);
					}

					// Pddl.g:285:21: ( NAME )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==NAME) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// Pddl.g:285:21: NAME
							{
							NAME176=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD1675); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME176_tree = (Object)adaptor.create(NAME176);
							adaptor.addChild(root_0, NAME176_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD1678);
					timedGD177=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD177.getTree());

					char_literal178=(Token)match(input,57,FOLLOW_57_in_prefTimedGD1680); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal178_tree = (Object)adaptor.create(char_literal178);
					adaptor.addChild(root_0, char_literal178_tree);
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
	// Pddl.g:288:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws RecognitionException {
		PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal179=null;
		Token string_literal180=null;
		Token char_literal183=null;
		Token char_literal184=null;
		Token string_literal185=null;
		Token char_literal188=null;
		ParserRuleReturnScope timeSpecifier181 =null;
		ParserRuleReturnScope goalDesc182 =null;
		ParserRuleReturnScope interval186 =null;
		ParserRuleReturnScope goalDesc187 =null;

		Object char_literal179_tree=null;
		Object string_literal180_tree=null;
		Object char_literal183_tree=null;
		Object char_literal184_tree=null;
		Object string_literal185_tree=null;
		Object char_literal188_tree=null;

		try {
			// Pddl.g:289:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==56) ) {
				int LA43_1 = input.LA(2);
				if ( (LA43_1==92) ) {
					alt43=1;
				}
				else if ( (LA43_1==111) ) {
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
					// Pddl.g:289:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal179=(Token)match(input,56,FOLLOW_56_in_timedGD1691); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal179_tree = (Object)adaptor.create(char_literal179);
					adaptor.addChild(root_0, char_literal179_tree);
					}

					string_literal180=(Token)match(input,92,FOLLOW_92_in_timedGD1693); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal180_tree = (Object)adaptor.create(string_literal180);
					adaptor.addChild(root_0, string_literal180_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD1695);
					timeSpecifier181=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier181.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1697);
					goalDesc182=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc182.getTree());

					char_literal183=(Token)match(input,57,FOLLOW_57_in_timedGD1699); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal183_tree = (Object)adaptor.create(char_literal183);
					adaptor.addChild(root_0, char_literal183_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:290:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal184=(Token)match(input,56,FOLLOW_56_in_timedGD1704); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal184_tree = (Object)adaptor.create(char_literal184);
					adaptor.addChild(root_0, char_literal184_tree);
					}

					string_literal185=(Token)match(input,111,FOLLOW_111_in_timedGD1706); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal185_tree = (Object)adaptor.create(string_literal185);
					adaptor.addChild(root_0, string_literal185_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD1708);
					interval186=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval186.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1710);
					goalDesc187=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc187.getTree());

					char_literal188=(Token)match(input,57,FOLLOW_57_in_timedGD1712); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal188_tree = (Object)adaptor.create(char_literal188);
					adaptor.addChild(root_0, char_literal188_tree);
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
	// Pddl.g:293:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set189=null;

		Object set189_tree=null;

		try {
			// Pddl.g:293:15: ( 'start' | 'end' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set189=input.LT(1);
			if ( input.LA(1)==98||input.LA(1)==119 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set189));
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
	// Pddl.g:294:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal190=null;

		Object string_literal190_tree=null;

		try {
			// Pddl.g:294:10: ( 'all' )
			// Pddl.g:294:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal190=(Token)match(input,87,FOLLOW_87_in_interval1734); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal190_tree = (Object)adaptor.create(string_literal190);
			adaptor.addChild(root_0, string_literal190_tree);
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
	// Pddl.g:298:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
		PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal191=null;
		Token string_literal192=null;
		Token char_literal195=null;
		ParserRuleReturnScope typedVariableList193 =null;
		ParserRuleReturnScope goalDesc194 =null;

		Object char_literal191_tree=null;
		Object string_literal192_tree=null;
		Object char_literal195_tree=null;

		try {
			// Pddl.g:299:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// Pddl.g:299:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal191=(Token)match(input,56,FOLLOW_56_in_derivedDef1747); if (state.failed) return retval;
			string_literal192=(Token)match(input,66,FOLLOW_66_in_derivedDef1750); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal192_tree = (Object)adaptor.create(string_literal192);
			root_0 = (Object)adaptor.becomeRoot(string_literal192_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef1753);
			typedVariableList193=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList193.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef1755);
			goalDesc194=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc194.getTree());

			char_literal195=(Token)match(input,57,FOLLOW_57_in_derivedDef1757); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:304:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws RecognitionException {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER196=null;
		Token char_literal197=null;
		Token char_literal201=null;
		Token char_literal202=null;
		Token char_literal203=null;
		Token char_literal205=null;
		ParserRuleReturnScope binaryOp198 =null;
		ParserRuleReturnScope fExp199 =null;
		ParserRuleReturnScope fExp2200 =null;
		ParserRuleReturnScope fExp204 =null;
		ParserRuleReturnScope fHead206 =null;

		Object NUMBER196_tree=null;
		Object char_literal197_tree=null;
		Object char_literal201_tree=null;
		Object char_literal202_tree=null;
		Object char_literal203_tree=null;
		Object char_literal205_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");

		try {
			// Pddl.g:305:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
			int alt44=4;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt44=1;
				}
				break;
			case 56:
				{
				int LA44_2 = input.LA(2);
				if ( (synpred57_Pddl()) ) {
					alt44=2;
				}
				else if ( (synpred58_Pddl()) ) {
					alt44=3;
				}
				else if ( (true) ) {
					alt44=4;
				}

				}
				break;
			case NAME:
				{
				alt44=4;
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
					// Pddl.g:305:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER196=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp1772); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER196_tree = (Object)adaptor.create(NUMBER196);
					adaptor.addChild(root_0, NUMBER196_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:306:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal197=(Token)match(input,56,FOLLOW_56_in_fExp1777); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal197);

					pushFollow(FOLLOW_binaryOp_in_fExp1779);
					binaryOp198=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp198.getTree());
					pushFollow(FOLLOW_fExp_in_fExp1781);
					fExp199=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp199.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp1783);
					fExp2200=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2200.getTree());
					char_literal201=(Token)match(input,57,FOLLOW_57_in_fExp1785); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal201);

					// AST REWRITE
					// elements: fExp, binaryOp, fExp2
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 306:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// Pddl.g:306:35: ^( BINARY_OP binaryOp fExp fExp2 )
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
					// Pddl.g:307:4: '(' '-' fExp ')'
					{
					char_literal202=(Token)match(input,56,FOLLOW_56_in_fExp1802); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal202);

					char_literal203=(Token)match(input,60,FOLLOW_60_in_fExp1804); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal203);

					pushFollow(FOLLOW_fExp_in_fExp1806);
					fExp204=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp204.getTree());
					char_literal205=(Token)match(input,57,FOLLOW_57_in_fExp1808); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal205);

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
					// 307:21: -> ^( UNARY_MINUS fExp )
					{
						// Pddl.g:307:24: ^( UNARY_MINUS fExp )
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
					// Pddl.g:308:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp1821);
					fHead206=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead206.getTree());

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
	// Pddl.g:313:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fExp207 =null;


		try {
			// Pddl.g:313:7: ( fExp )
			// Pddl.g:313:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp21833);
			fExp207=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp207.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// Pddl.g:315:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal208=null;
		Token char_literal211=null;
		ParserRuleReturnScope functionSymbol209 =null;
		ParserRuleReturnScope term210 =null;
		ParserRuleReturnScope functionSymbol212 =null;

		Object char_literal208_tree=null;
		Object char_literal211_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			// Pddl.g:316:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==56) ) {
				alt46=1;
			}
			else if ( (LA46_0==NAME) ) {
				alt46=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// Pddl.g:316:4: '(' functionSymbol ( term )* ')'
					{
					char_literal208=(Token)match(input,56,FOLLOW_56_in_fHead1843); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal208);

					pushFollow(FOLLOW_functionSymbol_in_fHead1845);
					functionSymbol209=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol209.getTree());
					// Pddl.g:316:23: ( term )*
					loop45:
					while (true) {
						int alt45=2;
						int LA45_0 = input.LA(1);
						if ( (LA45_0==NAME||LA45_0==VARIABLE) ) {
							alt45=1;
						}

						switch (alt45) {
						case 1 :
							// Pddl.g:316:23: term
							{
							pushFollow(FOLLOW_term_in_fHead1847);
							term210=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term210.getTree());
							}
							break;

						default :
							break loop45;
						}
					}

					char_literal211=(Token)match(input,57,FOLLOW_57_in_fHead1850); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal211);

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
					// 316:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// Pddl.g:316:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// Pddl.g:316:63: ( term )*
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
					// Pddl.g:317:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead1866);
					functionSymbol212=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol212.getTree());
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
					// 317:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// Pddl.g:317:22: ^( FUNC_HEAD functionSymbol )
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
	// Pddl.g:320:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal213=null;
		Token string_literal214=null;
		Token char_literal216=null;
		ParserRuleReturnScope cEffect215 =null;
		ParserRuleReturnScope cEffect217 =null;

		Object char_literal213_tree=null;
		Object string_literal214_tree=null;
		Object char_literal216_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			// Pddl.g:321:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==56) ) {
				int LA48_1 = input.LA(2);
				if ( (LA48_1==90) ) {
					alt48=1;
				}
				else if ( (LA48_1==NAME||LA48_1==91||LA48_1==94||LA48_1==100||LA48_1==104||LA48_1==108||(LA48_1 >= 114 && LA48_1 <= 115)||LA48_1==120) ) {
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
					// Pddl.g:321:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal213=(Token)match(input,56,FOLLOW_56_in_effect1885); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal213);

					string_literal214=(Token)match(input,90,FOLLOW_90_in_effect1887); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_90.add(string_literal214);

					// Pddl.g:321:14: ( cEffect )*
					loop47:
					while (true) {
						int alt47=2;
						int LA47_0 = input.LA(1);
						if ( (LA47_0==56) ) {
							alt47=1;
						}

						switch (alt47) {
						case 1 :
							// Pddl.g:321:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect1889);
							cEffect215=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect215.getTree());
							}
							break;

						default :
							break loop47;
						}
					}

					char_literal216=(Token)match(input,57,FOLLOW_57_in_effect1892); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal216);

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
					// 321:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// Pddl.g:321:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:321:43: ( cEffect )*
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
					// Pddl.g:322:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect1906);
					cEffect217=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect217.getTree());

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
	// Pddl.g:325:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal218=null;
		Token string_literal219=null;
		Token char_literal220=null;
		Token char_literal222=null;
		Token char_literal224=null;
		Token char_literal225=null;
		Token string_literal226=null;
		Token char_literal229=null;
		ParserRuleReturnScope typedVariableList221 =null;
		ParserRuleReturnScope effect223 =null;
		ParserRuleReturnScope goalDesc227 =null;
		ParserRuleReturnScope condEffect228 =null;
		ParserRuleReturnScope pEffect230 =null;

		Object char_literal218_tree=null;
		Object string_literal219_tree=null;
		Object char_literal220_tree=null;
		Object char_literal222_tree=null;
		Object char_literal224_tree=null;
		Object char_literal225_tree=null;
		Object string_literal226_tree=null;
		Object char_literal229_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// Pddl.g:326:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt49=3;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==56) ) {
				switch ( input.LA(2) ) {
				case 100:
					{
					alt49=1;
					}
					break;
				case 120:
					{
					alt49=2;
					}
					break;
				case NAME:
				case 91:
				case 94:
				case 104:
				case 108:
				case 114:
				case 115:
					{
					alt49=3;
					}
					break;
				default:
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
					// Pddl.g:326:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal218=(Token)match(input,56,FOLLOW_56_in_cEffect1917); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal218);

					string_literal219=(Token)match(input,100,FOLLOW_100_in_cEffect1919); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_100.add(string_literal219);

					char_literal220=(Token)match(input,56,FOLLOW_56_in_cEffect1921); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal220);

					pushFollow(FOLLOW_typedVariableList_in_cEffect1923);
					typedVariableList221=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList221.getTree());
					char_literal222=(Token)match(input,57,FOLLOW_57_in_cEffect1925); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal222);

					pushFollow(FOLLOW_effect_in_cEffect1927);
					effect223=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect223.getTree());
					char_literal224=(Token)match(input,57,FOLLOW_57_in_cEffect1929); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal224);

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
					// 327:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// Pddl.g:327:7: ^( FORALL_EFFECT typedVariableList effect )
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
					// Pddl.g:328:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal225=(Token)match(input,56,FOLLOW_56_in_cEffect1947); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal225);

					string_literal226=(Token)match(input,120,FOLLOW_120_in_cEffect1949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_120.add(string_literal226);

					pushFollow(FOLLOW_goalDesc_in_cEffect1951);
					goalDesc227=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc227.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect1953);
					condEffect228=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect228.getTree());
					char_literal229=(Token)match(input,57,FOLLOW_57_in_cEffect1955); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal229);

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
					// 329:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// Pddl.g:329:7: ^( WHEN_EFFECT goalDesc condEffect )
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
					// Pddl.g:330:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect1973);
					pEffect230=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect230.getTree());

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
	// Pddl.g:333:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal231=null;
		Token char_literal235=null;
		Token char_literal236=null;
		Token string_literal237=null;
		Token char_literal239=null;
		ParserRuleReturnScope assignOp232 =null;
		ParserRuleReturnScope fHead233 =null;
		ParserRuleReturnScope fExp234 =null;
		ParserRuleReturnScope atomicTermFormula238 =null;
		ParserRuleReturnScope atomicTermFormula240 =null;

		Object char_literal231_tree=null;
		Object char_literal235_tree=null;
		Object char_literal236_tree=null;
		Object string_literal237_tree=null;
		Object char_literal239_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			// Pddl.g:334:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt50=3;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==56) ) {
				switch ( input.LA(2) ) {
				case 108:
					{
					alt50=2;
					}
					break;
				case 91:
				case 94:
				case 104:
				case 114:
				case 115:
					{
					alt50=1;
					}
					break;
				case NAME:
					{
					alt50=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 50, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}

			switch (alt50) {
				case 1 :
					// Pddl.g:334:4: '(' assignOp fHead fExp ')'
					{
					char_literal231=(Token)match(input,56,FOLLOW_56_in_pEffect1984); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal231);

					pushFollow(FOLLOW_assignOp_in_pEffect1986);
					assignOp232=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp232.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect1988);
					fHead233=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead233.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect1990);
					fExp234=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp234.getTree());
					char_literal235=(Token)match(input,57,FOLLOW_57_in_pEffect1992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal235);

					// AST REWRITE
					// elements: fHead, assignOp, fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 335:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// Pddl.g:335:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
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
					// Pddl.g:336:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal236=(Token)match(input,56,FOLLOW_56_in_pEffect2012); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal236);

					string_literal237=(Token)match(input,108,FOLLOW_108_in_pEffect2014); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_108.add(string_literal237);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2016);
					atomicTermFormula238=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula238.getTree());
					char_literal239=(Token)match(input,57,FOLLOW_57_in_pEffect2018); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal239);

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
					// 337:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// Pddl.g:337:7: ^( NOT_EFFECT atomicTermFormula )
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
					// Pddl.g:338:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2034);
					atomicTermFormula240=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula240.getTree());

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
	// Pddl.g:343:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal241=null;
		Token string_literal242=null;
		Token char_literal244=null;
		ParserRuleReturnScope pEffect243 =null;
		ParserRuleReturnScope pEffect245 =null;

		Object char_literal241_tree=null;
		Object string_literal242_tree=null;
		Object char_literal244_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			// Pddl.g:344:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==56) ) {
				int LA52_1 = input.LA(2);
				if ( (LA52_1==90) ) {
					alt52=1;
				}
				else if ( (LA52_1==NAME||LA52_1==91||LA52_1==94||LA52_1==104||LA52_1==108||(LA52_1 >= 114 && LA52_1 <= 115)) ) {
					alt52=2;
				}

				else {
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
					// Pddl.g:344:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal241=(Token)match(input,56,FOLLOW_56_in_condEffect2047); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal241);

					string_literal242=(Token)match(input,90,FOLLOW_90_in_condEffect2049); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_90.add(string_literal242);

					// Pddl.g:344:14: ( pEffect )*
					loop51:
					while (true) {
						int alt51=2;
						int LA51_0 = input.LA(1);
						if ( (LA51_0==56) ) {
							alt51=1;
						}

						switch (alt51) {
						case 1 :
							// Pddl.g:344:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2051);
							pEffect243=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect243.getTree());
							}
							break;

						default :
							break loop51;
						}
					}

					char_literal244=(Token)match(input,57,FOLLOW_57_in_condEffect2054); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal244);

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
					// 344:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// Pddl.g:344:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// Pddl.g:344:43: ( pEffect )*
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
					// Pddl.g:345:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2068);
					pEffect245=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect245.getTree());

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
	// Pddl.g:349:1: binaryOp : ( '*' | '+' | '-' | '/' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set246=null;

		Object set246_tree=null;

		try {
			// Pddl.g:349:10: ( '*' | '+' | '-' | '/' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set246=input.LT(1);
			if ( (input.LA(1) >= 58 && input.LA(1) <= 61) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set246));
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
	// Pddl.g:351:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set247=null;

		Object set247_tree=null;

		try {
			// Pddl.g:351:9: ( '*' | '+' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set247=input.LT(1);
			if ( (input.LA(1) >= 58 && input.LA(1) <= 59) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set247));
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
	// Pddl.g:353:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set248=null;

		Object set248_tree=null;

		try {
			// Pddl.g:353:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set248=input.LT(1);
			if ( (input.LA(1) >= 81 && input.LA(1) <= 85) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set248));
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
	// Pddl.g:355:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set249=null;

		Object set249_tree=null;

		try {
			// Pddl.g:355:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set249=input.LT(1);
			if ( input.LA(1)==91||input.LA(1)==94||input.LA(1)==104||(input.LA(1) >= 114 && input.LA(1) <= 115) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set249));
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
	// Pddl.g:360:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal250=null;
		Token string_literal251=null;
		Token char_literal253=null;
		Token char_literal254=null;
		Token char_literal255=null;
		ParserRuleReturnScope simpleDurationConstraint252 =null;
		ParserRuleReturnScope simpleDurationConstraint256 =null;

		Object char_literal250_tree=null;
		Object string_literal251_tree=null;
		Object char_literal253_tree=null;
		Object char_literal254_tree=null;
		Object char_literal255_tree=null;

		try {
			// Pddl.g:361:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt54=3;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==56) ) {
				switch ( input.LA(2) ) {
				case 90:
					{
					alt54=1;
					}
					break;
				case 57:
					{
					alt54=2;
					}
					break;
				case 82:
				case 83:
				case 85:
				case 92:
					{
					alt54=3;
					}
					break;
				default:
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
					// Pddl.g:361:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal250=(Token)match(input,56,FOLLOW_56_in_durationConstraint2169); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal250_tree = (Object)adaptor.create(char_literal250);
					adaptor.addChild(root_0, char_literal250_tree);
					}

					string_literal251=(Token)match(input,90,FOLLOW_90_in_durationConstraint2171); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal251_tree = (Object)adaptor.create(string_literal251);
					adaptor.addChild(root_0, string_literal251_tree);
					}

					// Pddl.g:361:14: ( simpleDurationConstraint )+
					int cnt53=0;
					loop53:
					while (true) {
						int alt53=2;
						int LA53_0 = input.LA(1);
						if ( (LA53_0==56) ) {
							alt53=1;
						}

						switch (alt53) {
						case 1 :
							// Pddl.g:361:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2173);
							simpleDurationConstraint252=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint252.getTree());

							}
							break;

						default :
							if ( cnt53 >= 1 ) break loop53;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(53, input);
							throw eee;
						}
						cnt53++;
					}

					char_literal253=(Token)match(input,57,FOLLOW_57_in_durationConstraint2176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal253_tree = (Object)adaptor.create(char_literal253);
					adaptor.addChild(root_0, char_literal253_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:362:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal254=(Token)match(input,56,FOLLOW_56_in_durationConstraint2181); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal254_tree = (Object)adaptor.create(char_literal254);
					adaptor.addChild(root_0, char_literal254_tree);
					}

					char_literal255=(Token)match(input,57,FOLLOW_57_in_durationConstraint2183); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal255_tree = (Object)adaptor.create(char_literal255);
					adaptor.addChild(root_0, char_literal255_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:363:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2188);
					simpleDurationConstraint256=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint256.getTree());

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
	// Pddl.g:366:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal257=null;
		Token string_literal259=null;
		Token char_literal261=null;
		Token char_literal262=null;
		Token string_literal263=null;
		Token char_literal266=null;
		ParserRuleReturnScope durOp258 =null;
		ParserRuleReturnScope durValue260 =null;
		ParserRuleReturnScope timeSpecifier264 =null;
		ParserRuleReturnScope simpleDurationConstraint265 =null;

		Object char_literal257_tree=null;
		Object string_literal259_tree=null;
		Object char_literal261_tree=null;
		Object char_literal262_tree=null;
		Object string_literal263_tree=null;
		Object char_literal266_tree=null;

		try {
			// Pddl.g:367:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==56) ) {
				int LA55_1 = input.LA(2);
				if ( (LA55_1==92) ) {
					alt55=2;
				}
				else if ( ((LA55_1 >= 82 && LA55_1 <= 83)||LA55_1==85) ) {
					alt55=1;
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
					// Pddl.g:367:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal257=(Token)match(input,56,FOLLOW_56_in_simpleDurationConstraint2199); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal257_tree = (Object)adaptor.create(char_literal257);
					adaptor.addChild(root_0, char_literal257_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2201);
					durOp258=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp258.getTree());

					string_literal259=(Token)match(input,86,FOLLOW_86_in_simpleDurationConstraint2203); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal259_tree = (Object)adaptor.create(string_literal259);
					adaptor.addChild(root_0, string_literal259_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2205);
					durValue260=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue260.getTree());

					char_literal261=(Token)match(input,57,FOLLOW_57_in_simpleDurationConstraint2207); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal261_tree = (Object)adaptor.create(char_literal261);
					adaptor.addChild(root_0, char_literal261_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:368:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal262=(Token)match(input,56,FOLLOW_56_in_simpleDurationConstraint2212); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal262_tree = (Object)adaptor.create(char_literal262);
					adaptor.addChild(root_0, char_literal262_tree);
					}

					string_literal263=(Token)match(input,92,FOLLOW_92_in_simpleDurationConstraint2214); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal263_tree = (Object)adaptor.create(string_literal263);
					adaptor.addChild(root_0, string_literal263_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2216);
					timeSpecifier264=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier264.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2218);
					simpleDurationConstraint265=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint265.getTree());

					char_literal266=(Token)match(input,57,FOLLOW_57_in_simpleDurationConstraint2220); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal266_tree = (Object)adaptor.create(char_literal266);
					adaptor.addChild(root_0, char_literal266_tree);
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
	// Pddl.g:371:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set267=null;

		Object set267_tree=null;

		try {
			// Pddl.g:371:7: ( '<=' | '>=' | '=' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set267=input.LT(1);
			if ( (input.LA(1) >= 82 && input.LA(1) <= 83)||input.LA(1)==85 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set267));
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
	// Pddl.g:373:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER268=null;
		ParserRuleReturnScope fExp269 =null;

		Object NUMBER268_tree=null;

		try {
			// Pddl.g:373:10: ( NUMBER | fExp )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==NUMBER) ) {
				int LA56_1 = input.LA(2);
				if ( (synpred87_Pddl()) ) {
					alt56=1;
				}
				else if ( (true) ) {
					alt56=2;
				}

			}
			else if ( (LA56_0==NAME||LA56_0==56) ) {
				alt56=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// Pddl.g:373:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER268=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2247); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER268_tree = (Object)adaptor.create(NUMBER268);
					adaptor.addChild(root_0, NUMBER268_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:373:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2251);
					fExp269=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp269.getTree());

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
	// Pddl.g:375:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal270=null;
		Token string_literal271=null;
		Token char_literal273=null;
		Token char_literal275=null;
		Token string_literal276=null;
		Token char_literal277=null;
		Token char_literal279=null;
		Token char_literal281=null;
		Token char_literal282=null;
		Token string_literal283=null;
		Token char_literal286=null;
		Token char_literal287=null;
		Token char_literal291=null;
		ParserRuleReturnScope daEffect272 =null;
		ParserRuleReturnScope timedEffect274 =null;
		ParserRuleReturnScope typedVariableList278 =null;
		ParserRuleReturnScope daEffect280 =null;
		ParserRuleReturnScope daGD284 =null;
		ParserRuleReturnScope timedEffect285 =null;
		ParserRuleReturnScope assignOp288 =null;
		ParserRuleReturnScope fHead289 =null;
		ParserRuleReturnScope fExpDA290 =null;

		Object char_literal270_tree=null;
		Object string_literal271_tree=null;
		Object char_literal273_tree=null;
		Object char_literal275_tree=null;
		Object string_literal276_tree=null;
		Object char_literal277_tree=null;
		Object char_literal279_tree=null;
		Object char_literal281_tree=null;
		Object char_literal282_tree=null;
		Object string_literal283_tree=null;
		Object char_literal286_tree=null;
		Object char_literal287_tree=null;
		Object char_literal291_tree=null;

		try {
			// Pddl.g:376:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt58=5;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==56) ) {
				int LA58_1 = input.LA(2);
				if ( (synpred89_Pddl()) ) {
					alt58=1;
				}
				else if ( (synpred90_Pddl()) ) {
					alt58=2;
				}
				else if ( (synpred91_Pddl()) ) {
					alt58=3;
				}
				else if ( (synpred92_Pddl()) ) {
					alt58=4;
				}
				else if ( (true) ) {
					alt58=5;
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
					// Pddl.g:376:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal270=(Token)match(input,56,FOLLOW_56_in_daEffect2261); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal270_tree = (Object)adaptor.create(char_literal270);
					adaptor.addChild(root_0, char_literal270_tree);
					}

					string_literal271=(Token)match(input,90,FOLLOW_90_in_daEffect2263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal271_tree = (Object)adaptor.create(string_literal271);
					adaptor.addChild(root_0, string_literal271_tree);
					}

					// Pddl.g:376:14: ( daEffect )*
					loop57:
					while (true) {
						int alt57=2;
						int LA57_0 = input.LA(1);
						if ( (LA57_0==56) ) {
							alt57=1;
						}

						switch (alt57) {
						case 1 :
							// Pddl.g:376:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2265);
							daEffect272=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect272.getTree());

							}
							break;

						default :
							break loop57;
						}
					}

					char_literal273=(Token)match(input,57,FOLLOW_57_in_daEffect2268); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal273_tree = (Object)adaptor.create(char_literal273);
					adaptor.addChild(root_0, char_literal273_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:377:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2273);
					timedEffect274=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect274.getTree());

					}
					break;
				case 3 :
					// Pddl.g:378:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal275=(Token)match(input,56,FOLLOW_56_in_daEffect2278); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal275_tree = (Object)adaptor.create(char_literal275);
					adaptor.addChild(root_0, char_literal275_tree);
					}

					string_literal276=(Token)match(input,100,FOLLOW_100_in_daEffect2280); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal276_tree = (Object)adaptor.create(string_literal276);
					adaptor.addChild(root_0, string_literal276_tree);
					}

					char_literal277=(Token)match(input,56,FOLLOW_56_in_daEffect2282); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal277_tree = (Object)adaptor.create(char_literal277);
					adaptor.addChild(root_0, char_literal277_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2284);
					typedVariableList278=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList278.getTree());

					char_literal279=(Token)match(input,57,FOLLOW_57_in_daEffect2286); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal279_tree = (Object)adaptor.create(char_literal279);
					adaptor.addChild(root_0, char_literal279_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2288);
					daEffect280=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect280.getTree());

					char_literal281=(Token)match(input,57,FOLLOW_57_in_daEffect2290); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal281_tree = (Object)adaptor.create(char_literal281);
					adaptor.addChild(root_0, char_literal281_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:379:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal282=(Token)match(input,56,FOLLOW_56_in_daEffect2295); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal282_tree = (Object)adaptor.create(char_literal282);
					adaptor.addChild(root_0, char_literal282_tree);
					}

					string_literal283=(Token)match(input,120,FOLLOW_120_in_daEffect2297); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal283_tree = (Object)adaptor.create(string_literal283);
					adaptor.addChild(root_0, string_literal283_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2299);
					daGD284=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD284.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2301);
					timedEffect285=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect285.getTree());

					char_literal286=(Token)match(input,57,FOLLOW_57_in_daEffect2303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal286_tree = (Object)adaptor.create(char_literal286);
					adaptor.addChild(root_0, char_literal286_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:380:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal287=(Token)match(input,56,FOLLOW_56_in_daEffect2308); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal287_tree = (Object)adaptor.create(char_literal287);
					adaptor.addChild(root_0, char_literal287_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2310);
					assignOp288=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp288.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2312);
					fHead289=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead289.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2314);
					fExpDA290=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA290.getTree());

					char_literal291=(Token)match(input,57,FOLLOW_57_in_daEffect2316); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal291_tree = (Object)adaptor.create(char_literal291);
					adaptor.addChild(root_0, char_literal291_tree);
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
	// Pddl.g:383:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal292=null;
		Token string_literal293=null;
		Token char_literal296=null;
		Token char_literal297=null;
		Token string_literal298=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token char_literal306=null;
		ParserRuleReturnScope timeSpecifier294 =null;
		ParserRuleReturnScope daEffect295 =null;
		ParserRuleReturnScope timeSpecifier299 =null;
		ParserRuleReturnScope fAssignDA300 =null;
		ParserRuleReturnScope assignOp303 =null;
		ParserRuleReturnScope fHead304 =null;
		ParserRuleReturnScope fExp305 =null;

		Object char_literal292_tree=null;
		Object string_literal293_tree=null;
		Object char_literal296_tree=null;
		Object char_literal297_tree=null;
		Object string_literal298_tree=null;
		Object char_literal301_tree=null;
		Object char_literal302_tree=null;
		Object char_literal306_tree=null;

		try {
			// Pddl.g:384:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt59=3;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==56) ) {
				int LA59_1 = input.LA(2);
				if ( (synpred93_Pddl()) ) {
					alt59=1;
				}
				else if ( (synpred94_Pddl()) ) {
					alt59=2;
				}
				else if ( (true) ) {
					alt59=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// Pddl.g:384:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal292=(Token)match(input,56,FOLLOW_56_in_timedEffect2327); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal292_tree = (Object)adaptor.create(char_literal292);
					adaptor.addChild(root_0, char_literal292_tree);
					}

					string_literal293=(Token)match(input,92,FOLLOW_92_in_timedEffect2329); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal293_tree = (Object)adaptor.create(string_literal293);
					adaptor.addChild(root_0, string_literal293_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2331);
					timeSpecifier294=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier294.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2333);
					daEffect295=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect295.getTree());

					char_literal296=(Token)match(input,57,FOLLOW_57_in_timedEffect2335); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal296_tree = (Object)adaptor.create(char_literal296);
					adaptor.addChild(root_0, char_literal296_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:385:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal297=(Token)match(input,56,FOLLOW_56_in_timedEffect2345); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal297_tree = (Object)adaptor.create(char_literal297);
					adaptor.addChild(root_0, char_literal297_tree);
					}

					string_literal298=(Token)match(input,92,FOLLOW_92_in_timedEffect2347); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal298_tree = (Object)adaptor.create(string_literal298);
					adaptor.addChild(root_0, string_literal298_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2349);
					timeSpecifier299=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier299.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2351);
					fAssignDA300=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA300.getTree());

					char_literal301=(Token)match(input,57,FOLLOW_57_in_timedEffect2353); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:386:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal302=(Token)match(input,56,FOLLOW_56_in_timedEffect2358); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal302_tree = (Object)adaptor.create(char_literal302);
					adaptor.addChild(root_0, char_literal302_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2360);
					assignOp303=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp303.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2362);
					fHead304=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead304.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2364);
					fExp305=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp305.getTree());

					char_literal306=(Token)match(input,57,FOLLOW_57_in_timedEffect2366); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal306_tree = (Object)adaptor.create(char_literal306);
					adaptor.addChild(root_0, char_literal306_tree);
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
	// Pddl.g:389:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal307=null;
		Token char_literal311=null;
		ParserRuleReturnScope assignOp308 =null;
		ParserRuleReturnScope fHead309 =null;
		ParserRuleReturnScope fExpDA310 =null;

		Object char_literal307_tree=null;
		Object char_literal311_tree=null;

		try {
			// Pddl.g:390:2: ( '(' assignOp fHead fExpDA ')' )
			// Pddl.g:390:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal307=(Token)match(input,56,FOLLOW_56_in_fAssignDA2386); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal307_tree = (Object)adaptor.create(char_literal307);
			adaptor.addChild(root_0, char_literal307_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2388);
			assignOp308=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp308.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2390);
			fHead309=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead309.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2392);
			fExpDA310=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA310.getTree());

			char_literal311=(Token)match(input,57,FOLLOW_57_in_fAssignDA2394); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal311_tree = (Object)adaptor.create(char_literal311);
			adaptor.addChild(root_0, char_literal311_tree);
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
	// Pddl.g:393:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal312=null;
		Token char_literal316=null;
		Token char_literal318=null;
		Token string_literal319=null;
		ParserRuleReturnScope binaryOp313 =null;
		ParserRuleReturnScope fExpDA314 =null;
		ParserRuleReturnScope fExpDA315 =null;
		ParserRuleReturnScope fExpDA317 =null;
		ParserRuleReturnScope fExp320 =null;

		Object char_literal312_tree=null;
		Object char_literal316_tree=null;
		Object char_literal318_tree=null;
		Object string_literal319_tree=null;

		try {
			// Pddl.g:394:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt61=3;
			switch ( input.LA(1) ) {
			case 56:
				{
				int LA61_1 = input.LA(2);
				if ( (synpred96_Pddl()) ) {
					alt61=1;
				}
				else if ( (true) ) {
					alt61=3;
				}

				}
				break;
			case 86:
				{
				alt61=2;
				}
				break;
			case NAME:
			case NUMBER:
				{
				alt61=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}
			switch (alt61) {
				case 1 :
					// Pddl.g:394:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal312=(Token)match(input,56,FOLLOW_56_in_fExpDA2405); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal312_tree = (Object)adaptor.create(char_literal312);
					adaptor.addChild(root_0, char_literal312_tree);
					}

					// Pddl.g:394:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==60) ) {
						int LA60_1 = input.LA(2);
						if ( (synpred95_Pddl()) ) {
							alt60=1;
						}
						else if ( (true) ) {
							alt60=2;
						}

					}
					else if ( ((LA60_0 >= 58 && LA60_0 <= 59)||LA60_0==61) ) {
						alt60=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 60, 0, input);
						throw nvae;
					}

					switch (alt60) {
						case 1 :
							// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
							{
							// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
							// Pddl.g:394:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2409);
							binaryOp313=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp313.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2411);
							fExpDA314=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA314.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2413);
							fExpDA315=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA315.getTree());

							}

							}
							break;
						case 2 :
							// Pddl.g:394:36: ( '-' fExpDA )
							{
							// Pddl.g:394:36: ( '-' fExpDA )
							// Pddl.g:394:37: '-' fExpDA
							{
							char_literal316=(Token)match(input,60,FOLLOW_60_in_fExpDA2419); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal316_tree = (Object)adaptor.create(char_literal316);
							adaptor.addChild(root_0, char_literal316_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2421);
							fExpDA317=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA317.getTree());

							}

							}
							break;

					}

					char_literal318=(Token)match(input,57,FOLLOW_57_in_fExpDA2425); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal318_tree = (Object)adaptor.create(char_literal318);
					adaptor.addChild(root_0, char_literal318_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:395:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal319=(Token)match(input,86,FOLLOW_86_in_fExpDA2430); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal319_tree = (Object)adaptor.create(string_literal319);
					adaptor.addChild(root_0, string_literal319_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:396:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA2435);
					fExp320=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp320.getTree());

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
	// Pddl.g:401:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal321=null;
		Token string_literal322=null;
		Token char_literal331=null;
		ParserRuleReturnScope problemDecl323 =null;
		ParserRuleReturnScope problemDomain324 =null;
		ParserRuleReturnScope requireDef325 =null;
		ParserRuleReturnScope objectDecl326 =null;
		ParserRuleReturnScope init327 =null;
		ParserRuleReturnScope goal328 =null;
		ParserRuleReturnScope probConstraints329 =null;
		ParserRuleReturnScope metricSpec330 =null;

		Object char_literal321_tree=null;
		Object string_literal322_tree=null;
		Object char_literal331_tree=null;
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");

		try {
			// Pddl.g:402:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// Pddl.g:402:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal321=(Token)match(input,56,FOLLOW_56_in_problem2449); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal321);

			string_literal322=(Token)match(input,95,FOLLOW_95_in_problem2451); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_95.add(string_literal322);

			pushFollow(FOLLOW_problemDecl_in_problem2453);
			problemDecl323=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl323.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem2458);
			problemDomain324=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain324.getTree());
			// Pddl.g:404:7: ( requireDef )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==56) ) {
				int LA62_1 = input.LA(2);
				if ( (LA62_1==79) ) {
					alt62=1;
				}
			}
			switch (alt62) {
				case 1 :
					// Pddl.g:404:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem2466);
					requireDef325=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef325.getTree());
					}
					break;

			}

			// Pddl.g:405:7: ( objectDecl )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==56) ) {
				int LA63_1 = input.LA(2);
				if ( (LA63_1==75) ) {
					alt63=1;
				}
			}
			switch (alt63) {
				case 1 :
					// Pddl.g:405:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem2475);
					objectDecl326=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl326.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem2484);
			init327=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init327.getTree());
			pushFollow(FOLLOW_goal_in_problem2492);
			goal328=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal328.getTree());
			// Pddl.g:408:7: ( probConstraints )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==56) ) {
				int LA64_1 = input.LA(2);
				if ( (LA64_1==65) ) {
					alt64=1;
				}
			}
			switch (alt64) {
				case 1 :
					// Pddl.g:408:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem2500);
					probConstraints329=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints329.getTree());
					}
					break;

			}

			// Pddl.g:409:7: ( metricSpec )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==56) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// Pddl.g:409:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem2509);
					metricSpec330=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec330.getTree());
					}
					break;

			}

			char_literal331=(Token)match(input,57,FOLLOW_57_in_problem2525); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal331);

			// AST REWRITE
			// elements: probConstraints, goal, init, requireDef, problemDomain, metricSpec, objectDecl, problemDecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 412:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// Pddl.g:412:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// Pddl.g:412:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// Pddl.g:412:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// Pddl.g:413:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// Pddl.g:413:36: ( metricSpec )?
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
	// Pddl.g:416:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal332=null;
		Token string_literal333=null;
		Token NAME334=null;
		Token char_literal335=null;

		Object char_literal332_tree=null;
		Object string_literal333_tree=null;
		Object NAME334_tree=null;
		Object char_literal335_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");

		try {
			// Pddl.g:417:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// Pddl.g:417:7: '(' 'problem' NAME ')'
			{
			char_literal332=(Token)match(input,56,FOLLOW_56_in_problemDecl2582); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal332);

			string_literal333=(Token)match(input,113,FOLLOW_113_in_problemDecl2584); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_113.add(string_literal333);

			NAME334=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2586); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME334);

			char_literal335=(Token)match(input,57,FOLLOW_57_in_problemDecl2588); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal335);

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
			// 418:5: -> ^( PROBLEM_NAME NAME )
			{
				// Pddl.g:418:8: ^( PROBLEM_NAME NAME )
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
	// Pddl.g:421:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal336=null;
		Token string_literal337=null;
		Token NAME338=null;
		Token char_literal339=null;

		Object char_literal336_tree=null;
		Object string_literal337_tree=null;
		Object NAME338_tree=null;
		Object char_literal339_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");

		try {
			// Pddl.g:422:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// Pddl.g:422:4: '(' ':domain' NAME ')'
			{
			char_literal336=(Token)match(input,56,FOLLOW_56_in_problemDomain2614); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal336);

			string_literal337=(Token)match(input,67,FOLLOW_67_in_problemDomain2616); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_67.add(string_literal337);

			NAME338=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain2618); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME338);

			char_literal339=(Token)match(input,57,FOLLOW_57_in_problemDomain2620); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal339);

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
			// 423:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// Pddl.g:423:5: ^( PROBLEM_DOMAIN NAME )
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
	// Pddl.g:426:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal340=null;
		Token string_literal341=null;
		Token char_literal343=null;
		ParserRuleReturnScope typedNameList342 =null;

		Object char_literal340_tree=null;
		Object string_literal341_tree=null;
		Object char_literal343_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// Pddl.g:427:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// Pddl.g:427:4: '(' ':objects' typedNameList ')'
			{
			char_literal340=(Token)match(input,56,FOLLOW_56_in_objectDecl2640); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal340);

			string_literal341=(Token)match(input,75,FOLLOW_75_in_objectDecl2642); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_75.add(string_literal341);

			pushFollow(FOLLOW_typedNameList_in_objectDecl2644);
			typedNameList342=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList342.getTree());
			char_literal343=(Token)match(input,57,FOLLOW_57_in_objectDecl2646); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal343);

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
			// 428:2: -> ^( OBJECTS typedNameList )
			{
				// Pddl.g:428:5: ^( OBJECTS typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECTS, "OBJECTS"), root_1);
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
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "init"
	// Pddl.g:431:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal344=null;
		Token string_literal345=null;
		Token char_literal347=null;
		ParserRuleReturnScope initEl346 =null;

		Object char_literal344_tree=null;
		Object string_literal345_tree=null;
		Object char_literal347_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try {
			// Pddl.g:432:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
			// Pddl.g:432:4: '(' ':init' ( initEl )* ')'
			{
			char_literal344=(Token)match(input,56,FOLLOW_56_in_init2666); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal344);

			string_literal345=(Token)match(input,73,FOLLOW_73_in_init2668); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(string_literal345);

			// Pddl.g:432:16: ( initEl )*
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==56) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// Pddl.g:432:16: initEl
					{
					pushFollow(FOLLOW_initEl_in_init2670);
					initEl346=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl346.getTree());
					}
					break;

				default :
					break loop66;
				}
			}

			char_literal347=(Token)match(input,57,FOLLOW_57_in_init2673); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal347);

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
			// 433:2: -> ^( INIT ( initEl )* )
			{
				// Pddl.g:433:5: ^( INIT ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
				// Pddl.g:433:12: ( initEl )*
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
	// Pddl.g:436:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal349=null;
		Token char_literal350=null;
		Token NUMBER352=null;
		Token char_literal353=null;
		Token char_literal354=null;
		Token string_literal355=null;
		Token NUMBER356=null;
		Token char_literal358=null;
		ParserRuleReturnScope nameLiteral348 =null;
		ParserRuleReturnScope fHead351 =null;
		ParserRuleReturnScope nameLiteral357 =null;

		Object char_literal349_tree=null;
		Object char_literal350_tree=null;
		Object NUMBER352_tree=null;
		Object char_literal353_tree=null;
		Object char_literal354_tree=null;
		Object string_literal355_tree=null;
		Object NUMBER356_tree=null;
		Object char_literal358_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			// Pddl.g:437:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
			int alt67=3;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==56) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 108:
					{
					alt67=1;
					}
					break;
				case 83:
					{
					alt67=2;
					}
					break;
				case 92:
					{
					alt67=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 67, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// Pddl.g:437:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl2694);
					nameLiteral348=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral348.getTree());

					}
					break;
				case 2 :
					// Pddl.g:438:4: '(' '=' fHead NUMBER ')'
					{
					char_literal349=(Token)match(input,56,FOLLOW_56_in_initEl2699); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal349);

					char_literal350=(Token)match(input,83,FOLLOW_83_in_initEl2701); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_83.add(char_literal350);

					pushFollow(FOLLOW_fHead_in_initEl2703);
					fHead351=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead351.getTree());
					NUMBER352=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2705); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER352);

					char_literal353=(Token)match(input,57,FOLLOW_57_in_initEl2707); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal353);

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
					// 438:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// Pddl.g:438:40: ^( INIT_EQ fHead NUMBER )
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
					// Pddl.g:439:4: '(' 'at' NUMBER nameLiteral ')'
					{
					char_literal354=(Token)match(input,56,FOLLOW_56_in_initEl2730); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal354);

					string_literal355=(Token)match(input,92,FOLLOW_92_in_initEl2732); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal355);

					NUMBER356=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2734); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER356);

					pushFollow(FOLLOW_nameLiteral_in_initEl2736);
					nameLiteral357=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral357.getTree());
					char_literal358=(Token)match(input,57,FOLLOW_57_in_initEl2738); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal358);

					// AST REWRITE
					// elements: nameLiteral, NUMBER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 439:37: -> ^( INIT_AT NUMBER nameLiteral )
					{
						// Pddl.g:439:40: ^( INIT_AT NUMBER nameLiteral )
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
	// Pddl.g:442:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal360=null;
		Token string_literal361=null;
		Token char_literal363=null;
		ParserRuleReturnScope atomicNameFormula359 =null;
		ParserRuleReturnScope atomicNameFormula362 =null;

		Object char_literal360_tree=null;
		Object string_literal361_tree=null;
		Object char_literal363_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			// Pddl.g:443:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==56) ) {
				int LA68_1 = input.LA(2);
				if ( (LA68_1==108) ) {
					alt68=2;
				}
				else if ( (LA68_1==NAME) ) {
					alt68=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 68, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// Pddl.g:443:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2760);
					atomicNameFormula359=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula359.getTree());

					}
					break;
				case 2 :
					// Pddl.g:444:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal360=(Token)match(input,56,FOLLOW_56_in_nameLiteral2765); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal360);

					string_literal361=(Token)match(input,108,FOLLOW_108_in_nameLiteral2767); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_108.add(string_literal361);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2769);
					atomicNameFormula362=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula362.getTree());
					char_literal363=(Token)match(input,57,FOLLOW_57_in_nameLiteral2771); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal363);

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
					// 444:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// Pddl.g:444:39: ^( NOT_PRED_INIT atomicNameFormula )
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
	// Pddl.g:447:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal364=null;
		Token NAME366=null;
		Token char_literal367=null;
		ParserRuleReturnScope predicate365 =null;

		Object char_literal364_tree=null;
		Object NAME366_tree=null;
		Object char_literal367_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// Pddl.g:448:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// Pddl.g:448:4: '(' predicate ( NAME )* ')'
			{
			char_literal364=(Token)match(input,56,FOLLOW_56_in_atomicNameFormula2790); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal364);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula2792);
			predicate365=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate365.getTree());
			// Pddl.g:448:18: ( NAME )*
			loop69:
			while (true) {
				int alt69=2;
				int LA69_0 = input.LA(1);
				if ( (LA69_0==NAME) ) {
					alt69=1;
				}

				switch (alt69) {
				case 1 :
					// Pddl.g:448:18: NAME
					{
					NAME366=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula2794); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME366);

					}
					break;

				default :
					break loop69;
				}
			}

			char_literal367=(Token)match(input,57,FOLLOW_57_in_atomicNameFormula2797); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal367);

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
			// 448:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// Pddl.g:448:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// Pddl.g:448:53: ( NAME )*
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
	// Pddl.g:455:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal368=null;
		Token string_literal369=null;
		Token char_literal371=null;
		ParserRuleReturnScope goalDesc370 =null;

		Object char_literal368_tree=null;
		Object string_literal369_tree=null;
		Object char_literal371_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// Pddl.g:455:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// Pddl.g:455:8: '(' ':goal' goalDesc ')'
			{
			char_literal368=(Token)match(input,56,FOLLOW_56_in_goal2822); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal368);

			string_literal369=(Token)match(input,72,FOLLOW_72_in_goal2824); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(string_literal369);

			pushFollow(FOLLOW_goalDesc_in_goal2826);
			goalDesc370=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc370.getTree());
			char_literal371=(Token)match(input,57,FOLLOW_57_in_goal2828); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal371);

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
			// 455:33: -> ^( GOAL goalDesc )
			{
				// Pddl.g:455:36: ^( GOAL goalDesc )
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
	// Pddl.g:457:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal372=null;
		Token string_literal373=null;
		Token char_literal375=null;
		ParserRuleReturnScope prefConGD374 =null;

		Object char_literal372_tree=null;
		Object string_literal373_tree=null;
		Object char_literal375_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			// Pddl.g:458:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// Pddl.g:458:4: '(' ':constraints' prefConGD ')'
			{
			char_literal372=(Token)match(input,56,FOLLOW_56_in_probConstraints2846); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal372);

			string_literal373=(Token)match(input,65,FOLLOW_65_in_probConstraints2848); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(string_literal373);

			pushFollow(FOLLOW_prefConGD_in_probConstraints2851);
			prefConGD374=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD374.getTree());
			char_literal375=(Token)match(input,57,FOLLOW_57_in_probConstraints2853); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal375);

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
			// 459:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// Pddl.g:459:7: ^( PROBLEM_CONSTRAINT prefConGD )
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
	// Pddl.g:462:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal376=null;
		Token string_literal377=null;
		Token char_literal379=null;
		Token char_literal380=null;
		Token string_literal381=null;
		Token char_literal382=null;
		Token char_literal384=null;
		Token char_literal386=null;
		Token char_literal387=null;
		Token string_literal388=null;
		Token NAME389=null;
		Token char_literal391=null;
		ParserRuleReturnScope prefConGD378 =null;
		ParserRuleReturnScope typedVariableList383 =null;
		ParserRuleReturnScope prefConGD385 =null;
		ParserRuleReturnScope conGD390 =null;
		ParserRuleReturnScope conGD392 =null;

		Object char_literal376_tree=null;
		Object string_literal377_tree=null;
		Object char_literal379_tree=null;
		Object char_literal380_tree=null;
		Object string_literal381_tree=null;
		Object char_literal382_tree=null;
		Object char_literal384_tree=null;
		Object char_literal386_tree=null;
		Object char_literal387_tree=null;
		Object string_literal388_tree=null;
		Object NAME389_tree=null;
		Object char_literal391_tree=null;

		try {
			// Pddl.g:463:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt72=4;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==56) ) {
				int LA72_1 = input.LA(2);
				if ( (synpred108_Pddl()) ) {
					alt72=1;
				}
				else if ( (synpred109_Pddl()) ) {
					alt72=2;
				}
				else if ( (synpred111_Pddl()) ) {
					alt72=3;
				}
				else if ( (true) ) {
					alt72=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// Pddl.g:463:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal376=(Token)match(input,56,FOLLOW_56_in_prefConGD2875); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal376_tree = (Object)adaptor.create(char_literal376);
					adaptor.addChild(root_0, char_literal376_tree);
					}

					string_literal377=(Token)match(input,90,FOLLOW_90_in_prefConGD2877); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal377_tree = (Object)adaptor.create(string_literal377);
					adaptor.addChild(root_0, string_literal377_tree);
					}

					// Pddl.g:463:14: ( prefConGD )*
					loop70:
					while (true) {
						int alt70=2;
						int LA70_0 = input.LA(1);
						if ( (LA70_0==56) ) {
							alt70=1;
						}

						switch (alt70) {
						case 1 :
							// Pddl.g:463:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD2879);
							prefConGD378=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD378.getTree());

							}
							break;

						default :
							break loop70;
						}
					}

					char_literal379=(Token)match(input,57,FOLLOW_57_in_prefConGD2882); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal379_tree = (Object)adaptor.create(char_literal379);
					adaptor.addChild(root_0, char_literal379_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:464:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal380=(Token)match(input,56,FOLLOW_56_in_prefConGD2887); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal380_tree = (Object)adaptor.create(char_literal380);
					adaptor.addChild(root_0, char_literal380_tree);
					}

					string_literal381=(Token)match(input,100,FOLLOW_100_in_prefConGD2889); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal381_tree = (Object)adaptor.create(string_literal381);
					adaptor.addChild(root_0, string_literal381_tree);
					}

					char_literal382=(Token)match(input,56,FOLLOW_56_in_prefConGD2891); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal382_tree = (Object)adaptor.create(char_literal382);
					adaptor.addChild(root_0, char_literal382_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD2893);
					typedVariableList383=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList383.getTree());

					char_literal384=(Token)match(input,57,FOLLOW_57_in_prefConGD2895); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal384_tree = (Object)adaptor.create(char_literal384);
					adaptor.addChild(root_0, char_literal384_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD2897);
					prefConGD385=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD385.getTree());

					char_literal386=(Token)match(input,57,FOLLOW_57_in_prefConGD2899); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal386_tree = (Object)adaptor.create(char_literal386);
					adaptor.addChild(root_0, char_literal386_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:465:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal387=(Token)match(input,56,FOLLOW_56_in_prefConGD2904); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal387_tree = (Object)adaptor.create(char_literal387);
					adaptor.addChild(root_0, char_literal387_tree);
					}

					string_literal388=(Token)match(input,112,FOLLOW_112_in_prefConGD2906); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal388_tree = (Object)adaptor.create(string_literal388);
					adaptor.addChild(root_0, string_literal388_tree);
					}

					// Pddl.g:465:21: ( NAME )?
					int alt71=2;
					int LA71_0 = input.LA(1);
					if ( (LA71_0==NAME) ) {
						alt71=1;
					}
					switch (alt71) {
						case 1 :
							// Pddl.g:465:21: NAME
							{
							NAME389=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD2908); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME389_tree = (Object)adaptor.create(NAME389);
							adaptor.addChild(root_0, NAME389_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD2911);
					conGD390=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD390.getTree());

					char_literal391=(Token)match(input,57,FOLLOW_57_in_prefConGD2913); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal391_tree = (Object)adaptor.create(char_literal391);
					adaptor.addChild(root_0, char_literal391_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:466:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD2918);
					conGD392=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD392.getTree());

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
	// Pddl.g:469:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal393=null;
		Token string_literal394=null;
		Token char_literal397=null;
		ParserRuleReturnScope optimization395 =null;
		ParserRuleReturnScope metricFExp396 =null;

		Object char_literal393_tree=null;
		Object string_literal394_tree=null;
		Object char_literal397_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");

		try {
			// Pddl.g:470:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// Pddl.g:470:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal393=(Token)match(input,56,FOLLOW_56_in_metricSpec2929); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_56.add(char_literal393);

			string_literal394=(Token)match(input,74,FOLLOW_74_in_metricSpec2931); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_74.add(string_literal394);

			pushFollow(FOLLOW_optimization_in_metricSpec2933);
			optimization395=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization395.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec2935);
			metricFExp396=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp396.getTree());
			char_literal397=(Token)match(input,57,FOLLOW_57_in_metricSpec2937); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal397);

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
			// 471:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// Pddl.g:471:7: ^( PROBLEM_METRIC optimization metricFExp )
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
	// Pddl.g:474:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set398=null;

		Object set398_tree=null;

		try {
			// Pddl.g:474:14: ( 'minimize' | 'maximize' )
			// Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set398=input.LT(1);
			if ( (input.LA(1) >= 106 && input.LA(1) <= 107) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set398));
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
	// Pddl.g:476:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal399=null;
		Token char_literal403=null;
		Token char_literal404=null;
		Token char_literal408=null;
		Token char_literal409=null;
		Token char_literal410=null;
		Token char_literal412=null;
		Token NUMBER413=null;
		Token char_literal415=null;
		Token string_literal416=null;
		Token NAME417=null;
		Token char_literal418=null;
		ParserRuleReturnScope binaryOp400 =null;
		ParserRuleReturnScope metricFExp401 =null;
		ParserRuleReturnScope metricFExp402 =null;
		ParserRuleReturnScope multiOp405 =null;
		ParserRuleReturnScope metricFExp406 =null;
		ParserRuleReturnScope metricFExp407 =null;
		ParserRuleReturnScope metricFExp411 =null;
		ParserRuleReturnScope fHead414 =null;

		Object char_literal399_tree=null;
		Object char_literal403_tree=null;
		Object char_literal404_tree=null;
		Object char_literal408_tree=null;
		Object char_literal409_tree=null;
		Object char_literal410_tree=null;
		Object char_literal412_tree=null;
		Object NUMBER413_tree=null;
		Object char_literal415_tree=null;
		Object string_literal416_tree=null;
		Object NAME417_tree=null;
		Object char_literal418_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");

		try {
			// Pddl.g:477:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt74=6;
			switch ( input.LA(1) ) {
			case 56:
				{
				int LA74_1 = input.LA(2);
				if ( (synpred113_Pddl()) ) {
					alt74=1;
				}
				else if ( (synpred115_Pddl()) ) {
					alt74=2;
				}
				else if ( (synpred116_Pddl()) ) {
					alt74=3;
				}
				else if ( (synpred118_Pddl()) ) {
					alt74=5;
				}
				else if ( (true) ) {
					alt74=6;
				}

				}
				break;
			case NUMBER:
				{
				alt74=4;
				}
				break;
			case NAME:
				{
				alt74=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 74, 0, input);
				throw nvae;
			}
			switch (alt74) {
				case 1 :
					// Pddl.g:477:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal399=(Token)match(input,56,FOLLOW_56_in_metricFExp2974); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal399);

					pushFollow(FOLLOW_binaryOp_in_metricFExp2976);
					binaryOp400=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp400.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp2978);
					metricFExp401=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp401.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp2980);
					metricFExp402=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp402.getTree());
					char_literal403=(Token)match(input,57,FOLLOW_57_in_metricFExp2982); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal403);

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
					// 478:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// Pddl.g:478:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
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
					// Pddl.g:479:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal404=(Token)match(input,56,FOLLOW_56_in_metricFExp3004); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal404);

					pushFollow(FOLLOW_multiOp_in_metricFExp3006);
					multiOp405=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp405.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3008);
					metricFExp406=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp406.getTree());
					// Pddl.g:479:27: ( metricFExp )+
					int cnt73=0;
					loop73:
					while (true) {
						int alt73=2;
						int LA73_0 = input.LA(1);
						if ( (LA73_0==NAME||LA73_0==NUMBER||LA73_0==56) ) {
							alt73=1;
						}

						switch (alt73) {
						case 1 :
							// Pddl.g:479:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3010);
							metricFExp407=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp407.getTree());
							}
							break;

						default :
							if ( cnt73 >= 1 ) break loop73;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(73, input);
							throw eee;
						}
						cnt73++;
					}

					char_literal408=(Token)match(input,57,FOLLOW_57_in_metricFExp3013); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal408);

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
					// 480:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// Pddl.g:480:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
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
					// Pddl.g:481:4: '(' '-' metricFExp ')'
					{
					char_literal409=(Token)match(input,56,FOLLOW_56_in_metricFExp3037); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(char_literal409);

					char_literal410=(Token)match(input,60,FOLLOW_60_in_metricFExp3039); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal410);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3041);
					metricFExp411=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp411.getTree());
					char_literal412=(Token)match(input,57,FOLLOW_57_in_metricFExp3043); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal412);

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
					// 482:4: -> ^( MINUS_OP metricFExp )
					{
						// Pddl.g:482:7: ^( MINUS_OP metricFExp )
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
					// Pddl.g:483:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER413=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3060); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER413_tree = (Object)adaptor.create(NUMBER413);
					adaptor.addChild(root_0, NUMBER413_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:484:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3065);
					fHead414=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead414.getTree());

					}
					break;
				case 6 :
					// Pddl.g:486:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal415=(Token)match(input,56,FOLLOW_56_in_metricFExp3080); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal415_tree = (Object)adaptor.create(char_literal415);
					adaptor.addChild(root_0, char_literal415_tree);
					}

					string_literal416=(Token)match(input,105,FOLLOW_105_in_metricFExp3082); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal416_tree = (Object)adaptor.create(string_literal416);
					adaptor.addChild(root_0, string_literal416_tree);
					}

					NAME417=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3084); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME417_tree = (Object)adaptor.create(NAME417);
					adaptor.addChild(root_0, NAME417_tree);
					}

					char_literal418=(Token)match(input,57,FOLLOW_57_in_metricFExp3086); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal418_tree = (Object)adaptor.create(char_literal418);
					adaptor.addChild(root_0, char_literal418_tree);
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
	// Pddl.g:491:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal419=null;
		Token string_literal420=null;
		Token char_literal422=null;
		Token char_literal423=null;
		Token string_literal424=null;
		Token char_literal425=null;
		Token char_literal427=null;
		Token char_literal429=null;
		Token char_literal430=null;
		Token string_literal431=null;
		Token string_literal432=null;
		Token char_literal434=null;
		Token char_literal435=null;
		Token string_literal436=null;
		Token char_literal438=null;
		Token char_literal439=null;
		Token string_literal440=null;
		Token char_literal442=null;
		Token char_literal443=null;
		Token string_literal444=null;
		Token NUMBER445=null;
		Token char_literal447=null;
		Token char_literal448=null;
		Token string_literal449=null;
		Token char_literal451=null;
		Token char_literal452=null;
		Token string_literal453=null;
		Token char_literal456=null;
		Token char_literal457=null;
		Token string_literal458=null;
		Token char_literal461=null;
		Token char_literal462=null;
		Token string_literal463=null;
		Token NUMBER464=null;
		Token char_literal467=null;
		Token char_literal468=null;
		Token string_literal469=null;
		Token NUMBER470=null;
		Token NUMBER471=null;
		Token char_literal473=null;
		Token char_literal474=null;
		Token string_literal475=null;
		Token NUMBER476=null;
		Token char_literal478=null;
		ParserRuleReturnScope conGD421 =null;
		ParserRuleReturnScope typedVariableList426 =null;
		ParserRuleReturnScope conGD428 =null;
		ParserRuleReturnScope goalDesc433 =null;
		ParserRuleReturnScope goalDesc437 =null;
		ParserRuleReturnScope goalDesc441 =null;
		ParserRuleReturnScope goalDesc446 =null;
		ParserRuleReturnScope goalDesc450 =null;
		ParserRuleReturnScope goalDesc454 =null;
		ParserRuleReturnScope goalDesc455 =null;
		ParserRuleReturnScope goalDesc459 =null;
		ParserRuleReturnScope goalDesc460 =null;
		ParserRuleReturnScope goalDesc465 =null;
		ParserRuleReturnScope goalDesc466 =null;
		ParserRuleReturnScope goalDesc472 =null;
		ParserRuleReturnScope goalDesc477 =null;

		Object char_literal419_tree=null;
		Object string_literal420_tree=null;
		Object char_literal422_tree=null;
		Object char_literal423_tree=null;
		Object string_literal424_tree=null;
		Object char_literal425_tree=null;
		Object char_literal427_tree=null;
		Object char_literal429_tree=null;
		Object char_literal430_tree=null;
		Object string_literal431_tree=null;
		Object string_literal432_tree=null;
		Object char_literal434_tree=null;
		Object char_literal435_tree=null;
		Object string_literal436_tree=null;
		Object char_literal438_tree=null;
		Object char_literal439_tree=null;
		Object string_literal440_tree=null;
		Object char_literal442_tree=null;
		Object char_literal443_tree=null;
		Object string_literal444_tree=null;
		Object NUMBER445_tree=null;
		Object char_literal447_tree=null;
		Object char_literal448_tree=null;
		Object string_literal449_tree=null;
		Object char_literal451_tree=null;
		Object char_literal452_tree=null;
		Object string_literal453_tree=null;
		Object char_literal456_tree=null;
		Object char_literal457_tree=null;
		Object string_literal458_tree=null;
		Object char_literal461_tree=null;
		Object char_literal462_tree=null;
		Object string_literal463_tree=null;
		Object NUMBER464_tree=null;
		Object char_literal467_tree=null;
		Object char_literal468_tree=null;
		Object string_literal469_tree=null;
		Object NUMBER470_tree=null;
		Object NUMBER471_tree=null;
		Object char_literal473_tree=null;
		Object char_literal474_tree=null;
		Object string_literal475_tree=null;
		Object NUMBER476_tree=null;
		Object char_literal478_tree=null;

		try {
			// Pddl.g:492:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt76=12;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==56) ) {
				switch ( input.LA(2) ) {
				case 90:
					{
					alt76=1;
					}
					break;
				case 100:
					{
					alt76=2;
					}
					break;
				case 92:
					{
					alt76=3;
					}
					break;
				case 88:
					{
					alt76=4;
					}
					break;
				case 116:
					{
					alt76=5;
					}
					break;
				case 121:
					{
					alt76=6;
					}
					break;
				case 93:
					{
					alt76=7;
					}
					break;
				case 117:
					{
					alt76=8;
					}
					break;
				case 118:
					{
					alt76=9;
					}
					break;
				case 89:
					{
					alt76=10;
					}
					break;
				case 102:
					{
					alt76=11;
					}
					break;
				case 101:
					{
					alt76=12;
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
					// Pddl.g:492:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal419=(Token)match(input,56,FOLLOW_56_in_conGD3100); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal419_tree = (Object)adaptor.create(char_literal419);
					adaptor.addChild(root_0, char_literal419_tree);
					}

					string_literal420=(Token)match(input,90,FOLLOW_90_in_conGD3102); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal420_tree = (Object)adaptor.create(string_literal420);
					adaptor.addChild(root_0, string_literal420_tree);
					}

					// Pddl.g:492:14: ( conGD )*
					loop75:
					while (true) {
						int alt75=2;
						int LA75_0 = input.LA(1);
						if ( (LA75_0==56) ) {
							alt75=1;
						}

						switch (alt75) {
						case 1 :
							// Pddl.g:492:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3104);
							conGD421=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD421.getTree());

							}
							break;

						default :
							break loop75;
						}
					}

					char_literal422=(Token)match(input,57,FOLLOW_57_in_conGD3107); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal422_tree = (Object)adaptor.create(char_literal422);
					adaptor.addChild(root_0, char_literal422_tree);
					}

					}
					break;
				case 2 :
					// Pddl.g:493:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal423=(Token)match(input,56,FOLLOW_56_in_conGD3112); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal423_tree = (Object)adaptor.create(char_literal423);
					adaptor.addChild(root_0, char_literal423_tree);
					}

					string_literal424=(Token)match(input,100,FOLLOW_100_in_conGD3114); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal424_tree = (Object)adaptor.create(string_literal424);
					adaptor.addChild(root_0, string_literal424_tree);
					}

					char_literal425=(Token)match(input,56,FOLLOW_56_in_conGD3116); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal425_tree = (Object)adaptor.create(char_literal425);
					adaptor.addChild(root_0, char_literal425_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3118);
					typedVariableList426=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList426.getTree());

					char_literal427=(Token)match(input,57,FOLLOW_57_in_conGD3120); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal427_tree = (Object)adaptor.create(char_literal427);
					adaptor.addChild(root_0, char_literal427_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3122);
					conGD428=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD428.getTree());

					char_literal429=(Token)match(input,57,FOLLOW_57_in_conGD3124); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal429_tree = (Object)adaptor.create(char_literal429);
					adaptor.addChild(root_0, char_literal429_tree);
					}

					}
					break;
				case 3 :
					// Pddl.g:494:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal430=(Token)match(input,56,FOLLOW_56_in_conGD3129); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal430_tree = (Object)adaptor.create(char_literal430);
					adaptor.addChild(root_0, char_literal430_tree);
					}

					string_literal431=(Token)match(input,92,FOLLOW_92_in_conGD3131); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal431_tree = (Object)adaptor.create(string_literal431);
					adaptor.addChild(root_0, string_literal431_tree);
					}

					string_literal432=(Token)match(input,98,FOLLOW_98_in_conGD3133); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal432_tree = (Object)adaptor.create(string_literal432);
					adaptor.addChild(root_0, string_literal432_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3135);
					goalDesc433=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc433.getTree());

					char_literal434=(Token)match(input,57,FOLLOW_57_in_conGD3137); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal434_tree = (Object)adaptor.create(char_literal434);
					adaptor.addChild(root_0, char_literal434_tree);
					}

					}
					break;
				case 4 :
					// Pddl.g:495:7: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal435=(Token)match(input,56,FOLLOW_56_in_conGD3145); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal435_tree = (Object)adaptor.create(char_literal435);
					adaptor.addChild(root_0, char_literal435_tree);
					}

					string_literal436=(Token)match(input,88,FOLLOW_88_in_conGD3147); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal436_tree = (Object)adaptor.create(string_literal436);
					adaptor.addChild(root_0, string_literal436_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3149);
					goalDesc437=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc437.getTree());

					char_literal438=(Token)match(input,57,FOLLOW_57_in_conGD3151); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal438_tree = (Object)adaptor.create(char_literal438);
					adaptor.addChild(root_0, char_literal438_tree);
					}

					}
					break;
				case 5 :
					// Pddl.g:496:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal439=(Token)match(input,56,FOLLOW_56_in_conGD3156); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal439_tree = (Object)adaptor.create(char_literal439);
					adaptor.addChild(root_0, char_literal439_tree);
					}

					string_literal440=(Token)match(input,116,FOLLOW_116_in_conGD3158); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal440_tree = (Object)adaptor.create(string_literal440);
					adaptor.addChild(root_0, string_literal440_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3160);
					goalDesc441=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc441.getTree());

					char_literal442=(Token)match(input,57,FOLLOW_57_in_conGD3162); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal442_tree = (Object)adaptor.create(char_literal442);
					adaptor.addChild(root_0, char_literal442_tree);
					}

					}
					break;
				case 6 :
					// Pddl.g:497:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal443=(Token)match(input,56,FOLLOW_56_in_conGD3168); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal443_tree = (Object)adaptor.create(char_literal443);
					adaptor.addChild(root_0, char_literal443_tree);
					}

					string_literal444=(Token)match(input,121,FOLLOW_121_in_conGD3170); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal444_tree = (Object)adaptor.create(string_literal444);
					adaptor.addChild(root_0, string_literal444_tree);
					}

					NUMBER445=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3172); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER445_tree = (Object)adaptor.create(NUMBER445);
					adaptor.addChild(root_0, NUMBER445_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3174);
					goalDesc446=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc446.getTree());

					char_literal447=(Token)match(input,57,FOLLOW_57_in_conGD3176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal447_tree = (Object)adaptor.create(char_literal447);
					adaptor.addChild(root_0, char_literal447_tree);
					}

					}
					break;
				case 7 :
					// Pddl.g:498:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal448=(Token)match(input,56,FOLLOW_56_in_conGD3181); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal448_tree = (Object)adaptor.create(char_literal448);
					adaptor.addChild(root_0, char_literal448_tree);
					}

					string_literal449=(Token)match(input,93,FOLLOW_93_in_conGD3183); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal449_tree = (Object)adaptor.create(string_literal449);
					adaptor.addChild(root_0, string_literal449_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3185);
					goalDesc450=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc450.getTree());

					char_literal451=(Token)match(input,57,FOLLOW_57_in_conGD3187); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal451_tree = (Object)adaptor.create(char_literal451);
					adaptor.addChild(root_0, char_literal451_tree);
					}

					}
					break;
				case 8 :
					// Pddl.g:499:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal452=(Token)match(input,56,FOLLOW_56_in_conGD3192); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal452_tree = (Object)adaptor.create(char_literal452);
					adaptor.addChild(root_0, char_literal452_tree);
					}

					string_literal453=(Token)match(input,117,FOLLOW_117_in_conGD3194); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal453_tree = (Object)adaptor.create(string_literal453);
					adaptor.addChild(root_0, string_literal453_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3196);
					goalDesc454=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc454.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3198);
					goalDesc455=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc455.getTree());

					char_literal456=(Token)match(input,57,FOLLOW_57_in_conGD3200); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal456_tree = (Object)adaptor.create(char_literal456);
					adaptor.addChild(root_0, char_literal456_tree);
					}

					}
					break;
				case 9 :
					// Pddl.g:500:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal457=(Token)match(input,56,FOLLOW_56_in_conGD3205); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal457_tree = (Object)adaptor.create(char_literal457);
					adaptor.addChild(root_0, char_literal457_tree);
					}

					string_literal458=(Token)match(input,118,FOLLOW_118_in_conGD3207); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal458_tree = (Object)adaptor.create(string_literal458);
					adaptor.addChild(root_0, string_literal458_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3209);
					goalDesc459=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc459.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3211);
					goalDesc460=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc460.getTree());

					char_literal461=(Token)match(input,57,FOLLOW_57_in_conGD3213); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal461_tree = (Object)adaptor.create(char_literal461);
					adaptor.addChild(root_0, char_literal461_tree);
					}

					}
					break;
				case 10 :
					// Pddl.g:501:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal462=(Token)match(input,56,FOLLOW_56_in_conGD3218); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal462_tree = (Object)adaptor.create(char_literal462);
					adaptor.addChild(root_0, char_literal462_tree);
					}

					string_literal463=(Token)match(input,89,FOLLOW_89_in_conGD3220); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal463_tree = (Object)adaptor.create(string_literal463);
					adaptor.addChild(root_0, string_literal463_tree);
					}

					NUMBER464=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3222); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER464_tree = (Object)adaptor.create(NUMBER464);
					adaptor.addChild(root_0, NUMBER464_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3224);
					goalDesc465=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc465.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3226);
					goalDesc466=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc466.getTree());

					char_literal467=(Token)match(input,57,FOLLOW_57_in_conGD3228); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}

					}
					break;
				case 11 :
					// Pddl.g:502:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal468=(Token)match(input,56,FOLLOW_56_in_conGD3233); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal468_tree = (Object)adaptor.create(char_literal468);
					adaptor.addChild(root_0, char_literal468_tree);
					}

					string_literal469=(Token)match(input,102,FOLLOW_102_in_conGD3235); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal469_tree = (Object)adaptor.create(string_literal469);
					adaptor.addChild(root_0, string_literal469_tree);
					}

					NUMBER470=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3237); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER470_tree = (Object)adaptor.create(NUMBER470);
					adaptor.addChild(root_0, NUMBER470_tree);
					}

					NUMBER471=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER471_tree = (Object)adaptor.create(NUMBER471);
					adaptor.addChild(root_0, NUMBER471_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3241);
					goalDesc472=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc472.getTree());

					char_literal473=(Token)match(input,57,FOLLOW_57_in_conGD3243); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal473_tree = (Object)adaptor.create(char_literal473);
					adaptor.addChild(root_0, char_literal473_tree);
					}

					}
					break;
				case 12 :
					// Pddl.g:503:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal474=(Token)match(input,56,FOLLOW_56_in_conGD3248); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal474_tree = (Object)adaptor.create(char_literal474);
					adaptor.addChild(root_0, char_literal474_tree);
					}

					string_literal475=(Token)match(input,101,FOLLOW_101_in_conGD3250); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal475_tree = (Object)adaptor.create(string_literal475);
					adaptor.addChild(root_0, string_literal475_tree);
					}

					NUMBER476=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3252); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER476_tree = (Object)adaptor.create(NUMBER476);
					adaptor.addChild(root_0, NUMBER476_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3254);
					goalDesc477=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc477.getTree());

					char_literal478=(Token)match(input,57,FOLLOW_57_in_conGD3256); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal478_tree = (Object)adaptor.create(char_literal478);
					adaptor.addChild(root_0, char_literal478_tree);
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

	// $ANTLR start synpred17_Pddl
	public final void synpred17_Pddl_fragment() throws RecognitionException {
		// Pddl.g:149:5: ( atomicFunctionSkeleton )
		// Pddl.g:149:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred17_Pddl729);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred17_Pddl

	// $ANTLR start synpred41_Pddl
	public final void synpred41_Pddl_fragment() throws RecognitionException {
		// Pddl.g:243:7: ( fComp )
		// Pddl.g:243:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred41_Pddl1361);
		fComp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred41_Pddl

	// $ANTLR start synpred44_Pddl
	public final void synpred44_Pddl_fragment() throws RecognitionException {
		// Pddl.g:266:28: ( typedVariableList )
		// Pddl.g:266:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred44_Pddl1521);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred44_Pddl

	// $ANTLR start synpred57_Pddl
	public final void synpred57_Pddl_fragment() throws RecognitionException {
		// Pddl.g:306:4: ( '(' binaryOp fExp fExp2 ')' )
		// Pddl.g:306:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,56,FOLLOW_56_in_synpred57_Pddl1777); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred57_Pddl1779);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred57_Pddl1781);
		fExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp2_in_synpred57_Pddl1783);
		fExp2();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred57_Pddl1785); if (state.failed) return;

		}

	}
	// $ANTLR end synpred57_Pddl

	// $ANTLR start synpred58_Pddl
	public final void synpred58_Pddl_fragment() throws RecognitionException {
		// Pddl.g:307:4: ( '(' '-' fExp ')' )
		// Pddl.g:307:4: '(' '-' fExp ')'
		{
		match(input,56,FOLLOW_56_in_synpred58_Pddl1802); if (state.failed) return;

		match(input,60,FOLLOW_60_in_synpred58_Pddl1804); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred58_Pddl1806);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred58_Pddl1808); if (state.failed) return;

		}

	}
	// $ANTLR end synpred58_Pddl

	// $ANTLR start synpred87_Pddl
	public final void synpred87_Pddl_fragment() throws RecognitionException {
		// Pddl.g:373:12: ( NUMBER )
		// Pddl.g:373:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred87_Pddl2247); if (state.failed) return;

		}

	}
	// $ANTLR end synpred87_Pddl

	// $ANTLR start synpred89_Pddl
	public final void synpred89_Pddl_fragment() throws RecognitionException {
		// Pddl.g:376:4: ( '(' 'and' ( daEffect )* ')' )
		// Pddl.g:376:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,56,FOLLOW_56_in_synpred89_Pddl2261); if (state.failed) return;

		match(input,90,FOLLOW_90_in_synpred89_Pddl2263); if (state.failed) return;

		// Pddl.g:376:14: ( daEffect )*
		loop92:
		while (true) {
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==56) ) {
				alt92=1;
			}

			switch (alt92) {
			case 1 :
				// Pddl.g:376:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred89_Pddl2265);
				daEffect();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop92;
			}
		}

		match(input,57,FOLLOW_57_in_synpred89_Pddl2268); if (state.failed) return;

		}

	}
	// $ANTLR end synpred89_Pddl

	// $ANTLR start synpred90_Pddl
	public final void synpred90_Pddl_fragment() throws RecognitionException {
		// Pddl.g:377:4: ( timedEffect )
		// Pddl.g:377:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred90_Pddl2273);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred90_Pddl

	// $ANTLR start synpred91_Pddl
	public final void synpred91_Pddl_fragment() throws RecognitionException {
		// Pddl.g:378:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// Pddl.g:378:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,56,FOLLOW_56_in_synpred91_Pddl2278); if (state.failed) return;

		match(input,100,FOLLOW_100_in_synpred91_Pddl2280); if (state.failed) return;

		match(input,56,FOLLOW_56_in_synpred91_Pddl2282); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred91_Pddl2284);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred91_Pddl2286); if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred91_Pddl2288);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred91_Pddl2290); if (state.failed) return;

		}

	}
	// $ANTLR end synpred91_Pddl

	// $ANTLR start synpred92_Pddl
	public final void synpred92_Pddl_fragment() throws RecognitionException {
		// Pddl.g:379:4: ( '(' 'when' daGD timedEffect ')' )
		// Pddl.g:379:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,56,FOLLOW_56_in_synpred92_Pddl2295); if (state.failed) return;

		match(input,120,FOLLOW_120_in_synpred92_Pddl2297); if (state.failed) return;

		pushFollow(FOLLOW_daGD_in_synpred92_Pddl2299);
		daGD();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_timedEffect_in_synpred92_Pddl2301);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred92_Pddl2303); if (state.failed) return;

		}

	}
	// $ANTLR end synpred92_Pddl

	// $ANTLR start synpred93_Pddl
	public final void synpred93_Pddl_fragment() throws RecognitionException {
		// Pddl.g:384:4: ( '(' 'at' timeSpecifier daEffect ')' )
		// Pddl.g:384:4: '(' 'at' timeSpecifier daEffect ')'
		{
		match(input,56,FOLLOW_56_in_synpred93_Pddl2327); if (state.failed) return;

		match(input,92,FOLLOW_92_in_synpred93_Pddl2329); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred93_Pddl2331);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred93_Pddl2333);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred93_Pddl2335); if (state.failed) return;

		}

	}
	// $ANTLR end synpred93_Pddl

	// $ANTLR start synpred94_Pddl
	public final void synpred94_Pddl_fragment() throws RecognitionException {
		// Pddl.g:385:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		// Pddl.g:385:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		match(input,56,FOLLOW_56_in_synpred94_Pddl2345); if (state.failed) return;

		match(input,92,FOLLOW_92_in_synpred94_Pddl2347); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred94_Pddl2349);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fAssignDA_in_synpred94_Pddl2351);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred94_Pddl2353); if (state.failed) return;

		}

	}
	// $ANTLR end synpred94_Pddl

	// $ANTLR start synpred95_Pddl
	public final void synpred95_Pddl_fragment() throws RecognitionException {
		// Pddl.g:394:9: ( ( binaryOp fExpDA fExpDA ) )
		// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
		{
		// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
		// Pddl.g:394:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred95_Pddl2409);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred95_Pddl2411);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred95_Pddl2413);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred95_Pddl

	// $ANTLR start synpred96_Pddl
	public final void synpred96_Pddl_fragment() throws RecognitionException {
		// Pddl.g:394:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// Pddl.g:394:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,56,FOLLOW_56_in_synpred96_Pddl2405); if (state.failed) return;

		// Pddl.g:394:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt93=2;
		int LA93_0 = input.LA(1);
		if ( (LA93_0==60) ) {
			int LA93_1 = input.LA(2);
			if ( (synpred95_Pddl()) ) {
				alt93=1;
			}
			else if ( (true) ) {
				alt93=2;
			}

		}
		else if ( ((LA93_0 >= 58 && LA93_0 <= 59)||LA93_0==61) ) {
			alt93=1;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 93, 0, input);
			throw nvae;
		}

		switch (alt93) {
			case 1 :
				// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
				{
				// Pddl.g:394:9: ( binaryOp fExpDA fExpDA )
				// Pddl.g:394:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred96_Pddl2409);
				binaryOp();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred96_Pddl2411);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred96_Pddl2413);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;
			case 2 :
				// Pddl.g:394:36: ( '-' fExpDA )
				{
				// Pddl.g:394:36: ( '-' fExpDA )
				// Pddl.g:394:37: '-' fExpDA
				{
				match(input,60,FOLLOW_60_in_synpred96_Pddl2419); if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred96_Pddl2421);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;

		}

		match(input,57,FOLLOW_57_in_synpred96_Pddl2425); if (state.failed) return;

		}

	}
	// $ANTLR end synpred96_Pddl

	// $ANTLR start synpred108_Pddl
	public final void synpred108_Pddl_fragment() throws RecognitionException {
		// Pddl.g:463:4: ( '(' 'and' ( prefConGD )* ')' )
		// Pddl.g:463:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,56,FOLLOW_56_in_synpred108_Pddl2875); if (state.failed) return;

		match(input,90,FOLLOW_90_in_synpred108_Pddl2877); if (state.failed) return;

		// Pddl.g:463:14: ( prefConGD )*
		loop94:
		while (true) {
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==56) ) {
				alt94=1;
			}

			switch (alt94) {
			case 1 :
				// Pddl.g:463:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred108_Pddl2879);
				prefConGD();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop94;
			}
		}

		match(input,57,FOLLOW_57_in_synpred108_Pddl2882); if (state.failed) return;

		}

	}
	// $ANTLR end synpred108_Pddl

	// $ANTLR start synpred109_Pddl
	public final void synpred109_Pddl_fragment() throws RecognitionException {
		// Pddl.g:464:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// Pddl.g:464:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,56,FOLLOW_56_in_synpred109_Pddl2887); if (state.failed) return;

		match(input,100,FOLLOW_100_in_synpred109_Pddl2889); if (state.failed) return;

		match(input,56,FOLLOW_56_in_synpred109_Pddl2891); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred109_Pddl2893);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred109_Pddl2895); if (state.failed) return;

		pushFollow(FOLLOW_prefConGD_in_synpred109_Pddl2897);
		prefConGD();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred109_Pddl2899); if (state.failed) return;

		}

	}
	// $ANTLR end synpred109_Pddl

	// $ANTLR start synpred111_Pddl
	public final void synpred111_Pddl_fragment() throws RecognitionException {
		// Pddl.g:465:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// Pddl.g:465:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,56,FOLLOW_56_in_synpred111_Pddl2904); if (state.failed) return;

		match(input,112,FOLLOW_112_in_synpred111_Pddl2906); if (state.failed) return;

		// Pddl.g:465:21: ( NAME )?
		int alt95=2;
		int LA95_0 = input.LA(1);
		if ( (LA95_0==NAME) ) {
			alt95=1;
		}
		switch (alt95) {
			case 1 :
				// Pddl.g:465:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred111_Pddl2908); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred111_Pddl2911);
		conGD();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred111_Pddl2913); if (state.failed) return;

		}

	}
	// $ANTLR end synpred111_Pddl

	// $ANTLR start synpred113_Pddl
	public final void synpred113_Pddl_fragment() throws RecognitionException {
		// Pddl.g:477:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// Pddl.g:477:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,56,FOLLOW_56_in_synpred113_Pddl2974); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred113_Pddl2976);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred113_Pddl2978);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred113_Pddl2980);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred113_Pddl2982); if (state.failed) return;

		}

	}
	// $ANTLR end synpred113_Pddl

	// $ANTLR start synpred115_Pddl
	public final void synpred115_Pddl_fragment() throws RecognitionException {
		// Pddl.g:479:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// Pddl.g:479:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,56,FOLLOW_56_in_synpred115_Pddl3004); if (state.failed) return;

		pushFollow(FOLLOW_multiOp_in_synpred115_Pddl3006);
		multiOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred115_Pddl3008);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		// Pddl.g:479:27: ( metricFExp )+
		int cnt96=0;
		loop96:
		while (true) {
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==NAME||LA96_0==NUMBER||LA96_0==56) ) {
				alt96=1;
			}

			switch (alt96) {
			case 1 :
				// Pddl.g:479:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred115_Pddl3010);
				metricFExp();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt96 >= 1 ) break loop96;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(96, input);
				throw eee;
			}
			cnt96++;
		}

		match(input,57,FOLLOW_57_in_synpred115_Pddl3013); if (state.failed) return;

		}

	}
	// $ANTLR end synpred115_Pddl

	// $ANTLR start synpred116_Pddl
	public final void synpred116_Pddl_fragment() throws RecognitionException {
		// Pddl.g:481:4: ( '(' '-' metricFExp ')' )
		// Pddl.g:481:4: '(' '-' metricFExp ')'
		{
		match(input,56,FOLLOW_56_in_synpred116_Pddl3037); if (state.failed) return;

		match(input,60,FOLLOW_60_in_synpred116_Pddl3039); if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred116_Pddl3041);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred116_Pddl3043); if (state.failed) return;

		}

	}
	// $ANTLR end synpred116_Pddl

	// $ANTLR start synpred118_Pddl
	public final void synpred118_Pddl_fragment() throws RecognitionException {
		// Pddl.g:484:4: ( fHead )
		// Pddl.g:484:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred118_Pddl3065);
		fHead();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred118_Pddl

	// Delegated rules

	public final boolean synpred94_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred94_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred87_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred87_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred17_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred89_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred89_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred58_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred58_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred91_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred91_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred44_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred92_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred92_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred90_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred90_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred116_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred116_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred41_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred41_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred57_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred57_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
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
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

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
		@Override
		public String getDescription() {
			return "127:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
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
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

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
		@Override
		public String getDescription() {
			return "()+ loopback of 127:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA24_eotS =
		"\4\uffff";
	static final String DFA24_eofS =
		"\2\2\2\uffff";
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
		for (int i=0; i<numStates; i++) {
			DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
		}
	}

	protected class DFA24 extends DFA {

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
		@Override
		public String getDescription() {
			return "178:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA22_eotS =
		"\4\uffff";
	static final String DFA22_eofS =
		"\2\2\2\uffff";
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
		for (int i=0; i<numStates; i++) {
			DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
		}
	}

	protected class DFA22 extends DFA {

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
		@Override
		public String getDescription() {
			return "()+ loopback of 178:20: ( singleTypeVarList )+";
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_domain339 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_domain341 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_domainName_in_domain343 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_requireDef_in_domain351 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_typesDef_in_domain360 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_constantsDef_in_domain369 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_predicatesDef_in_domain378 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_functionsDef_in_domain387 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_constraints_in_domain396 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_structureDef_in_domain405 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_domain414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_domainName498 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_96_in_domainName500 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_NAME_in_domainName502 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_domainName504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_requireDef531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_requireDef533 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef535 = new BitSet(new long[]{0x0204000000000000L});
	public static final BitSet FOLLOW_57_in_requireDef538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_typesDef559 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_typesDef561 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef563 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_typesDef565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList592 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList597 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList600 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList620 = new BitSet(new long[]{0x1000000200000000L});
	public static final BitSet FOLLOW_60_in_singleTypeNameList623 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_type654 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_type656 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_primType_in_type658 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_57_in_type661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_functionsDef702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_functionsDef704 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_functionList_in_functionsDef706 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_functionsDef708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList729 = new BitSet(new long[]{0x1100000000000002L});
	public static final BitSet FOLLOW_60_in_functionList733 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_functionType_in_functionList735 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_56_in_atomicFunctionSkeleton751 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton754 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton757 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_atomicFunctionSkeleton759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_functionSymbol770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_109_in_functionType779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_constantsDef790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_constantsDef792 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef794 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_constantsDef796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_predicatesDef816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_predicatesDef818 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef820 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_predicatesDef823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_atomicFormulaSkeleton844 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton847 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton850 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_atomicFormulaSkeleton852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList878 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList883 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList886 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList906 = new BitSet(new long[]{0x1020000000000000L});
	public static final BitSet FOLLOW_60_in_singleTypeVarList909 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_constraints944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constraints947 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_conGD_in_constraints950 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_constraints952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_actionDef989 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_actionDef991 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_actionDef1002 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_actionDef1005 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1007 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDef1009 = new BitSet(new long[]{0x0200000000000000L,0x0000000000002040L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1022 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDef1024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_actionDefBody1073 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_actionDefBody1077 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDefBody1079 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1084 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_actionDefBody1094 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_actionDefBody1098 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDefBody1100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1154 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_goalDesc1156 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1158 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1186 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_goalDesc1188 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1190 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1218 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_goalDesc1220 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1222 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1248 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_goalDesc1250 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1252 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1254 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1282 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_goalDesc1284 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_goalDesc1286 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1288 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1290 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1292 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goalDesc1320 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_goalDesc1322 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_goalDesc1324 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1326 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1328 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1330 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_equality1416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_equality1419 = new BitSet(new long[]{0x0020000200000000L});
	public static final BitSet FOLLOW_term_in_equality1421 = new BitSet(new long[]{0x0020000200000000L});
	public static final BitSet FOLLOW_term_in_equality1423 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_equality1425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fComp1436 = new BitSet(new long[]{0x0000000000000000L,0x00000000003E0000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1439 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1441 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1443 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_fComp1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_atomicTermFormula1457 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1459 = new BitSet(new long[]{0x0220000200000000L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1461 = new BitSet(new long[]{0x0220000200000000L});
	public static final BitSet FOLLOW_57_in_atomicTermFormula1464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_durativeActionDef1502 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_durativeActionDef1504 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_durativeActionDef1515 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_durativeActionDef1518 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1521 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_durativeActionDef1525 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000050L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1538 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_durativeActionDef1540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_daDefBody1573 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody1575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_daDefBody1580 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_daDefBody1584 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daDefBody1586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody1591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_daDefBody1600 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_daDefBody1604 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daDefBody1606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody1611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD1626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daGD1631 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_daGD1633 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1635 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_daGD1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daGD1643 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_daGD1645 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_daGD1647 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD1649 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daGD1651 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1653 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daGD1655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_prefTimedGD1671 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_prefTimedGD1673 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD1675 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1678 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_prefTimedGD1680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_timedGD1691 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_timedGD1693 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD1695 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1697 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_timedGD1699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_timedGD1704 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_timedGD1706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_interval_in_timedGD1708 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1710 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_timedGD1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_87_in_interval1734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_derivedDef1747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_derivedDef1750 = new BitSet(new long[]{0x0120000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef1753 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef1755 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_derivedDef1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp1772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fExp1777 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_fExp1779 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1781 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp2_in_fExp1783 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_fExp1785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fExp1802 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fExp1804 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1806 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_fExp1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp1821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp21833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fHead1843 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead1845 = new BitSet(new long[]{0x0220000200000000L});
	public static final BitSet FOLLOW_term_in_fHead1847 = new BitSet(new long[]{0x0220000200000000L});
	public static final BitSet FOLLOW_57_in_fHead1850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead1866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_effect1885 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_effect1887 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_cEffect_in_effect1889 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_effect1892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect1906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_cEffect1917 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_cEffect1919 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_cEffect1921 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect1923 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_cEffect1925 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_effect_in_cEffect1927 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_cEffect1929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_cEffect1947 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_cEffect1949 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect1951 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_condEffect_in_cEffect1953 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_cEffect1955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect1973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_pEffect1984 = new BitSet(new long[]{0x0000000000000000L,0x000C010048000000L});
	public static final BitSet FOLLOW_assignOp_in_pEffect1986 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_fHead_in_pEffect1988 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_pEffect1990 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_pEffect1992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_pEffect2012 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_pEffect2014 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2016 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_pEffect2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2034 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_condEffect2047 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_condEffect2049 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2051 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_condEffect2054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_durationConstraint2169 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_durationConstraint2171 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2173 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_durationConstraint2176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_durationConstraint2181 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_durationConstraint2183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_simpleDurationConstraint2199 = new BitSet(new long[]{0x0000000000000000L,0x00000000002C0000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_simpleDurationConstraint2203 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2205 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_simpleDurationConstraint2207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_simpleDurationConstraint2212 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_simpleDurationConstraint2214 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2216 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2218 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_simpleDurationConstraint2220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daEffect2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_daEffect2263 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2265 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daEffect2278 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_daEffect2280 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_daEffect2282 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2284 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2286 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2288 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daEffect2295 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_daEffect2297 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daGD_in_daEffect2299 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2301 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_daEffect2308 = new BitSet(new long[]{0x0000000000000000L,0x000C010048000000L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2310 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_fHead_in_daEffect2312 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2314 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_timedEffect2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_timedEffect2329 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2331 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2333 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_timedEffect2335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_timedEffect2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_timedEffect2347 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2349 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2351 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_timedEffect2353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_timedEffect2358 = new BitSet(new long[]{0x0000000000000000L,0x000C010048000000L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2360 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2362 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2364 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_timedEffect2366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fAssignDA2386 = new BitSet(new long[]{0x0000000000000000L,0x000C010048000000L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2388 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2390 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2392 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_fAssignDA2394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_fExpDA2405 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2409 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2411 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2413 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_60_in_fExpDA2419 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2421 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_fExpDA2425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_fExpDA2430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_problem2449 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_problem2451 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_problemDecl_in_problem2453 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_problemDomain_in_problem2458 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_requireDef_in_problem2466 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_objectDecl_in_problem2475 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_init_in_problem2484 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goal_in_problem2492 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_probConstraints_in_problem2500 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_metricSpec_in_problem2509 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_problem2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_problemDecl2582 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_problemDecl2584 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl2586 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_problemDecl2588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_problemDomain2614 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_problemDomain2616 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain2618 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_problemDomain2620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_objectDecl2640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_objectDecl2642 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl2644 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_objectDecl2646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_init2666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_init2668 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_initEl_in_init2670 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_init2673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_initEl2699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_initEl2701 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_fHead_in_initEl2703 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2705 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_initEl2707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_initEl2730 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_initEl2732 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2734 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2736 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_initEl2738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_nameLiteral2765 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_nameLiteral2767 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2769 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_nameLiteral2771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_atomicNameFormula2790 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula2792 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula2794 = new BitSet(new long[]{0x0200000200000000L});
	public static final BitSet FOLLOW_57_in_atomicNameFormula2797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_goal2822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_goal2824 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goal2826 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goal2828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_probConstraints2846 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_probConstraints2848 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints2851 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_probConstraints2853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_prefConGD2875 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_prefConGD2877 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD2879 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_prefConGD2882 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_prefConGD2887 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_prefConGD2889 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_prefConGD2891 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD2893 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_prefConGD2895 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD2897 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_prefConGD2899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_prefConGD2904 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_prefConGD2906 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_NAME_in_prefConGD2908 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_conGD_in_prefConGD2911 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_prefConGD2913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD2918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_metricSpec2929 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_metricSpec2931 = new BitSet(new long[]{0x0000000000000000L,0x00000C0000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec2933 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec2935 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_metricSpec2937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_metricFExp2974 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp2976 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp2978 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp2980 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_metricFExp2982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_metricFExp3004 = new BitSet(new long[]{0x0C00000000000000L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3006 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3008 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3010 = new BitSet(new long[]{0x0300002200000000L});
	public static final BitSet FOLLOW_57_in_metricFExp3013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_metricFExp3037 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_metricFExp3039 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3041 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_metricFExp3043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_metricFExp3080 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_metricFExp3082 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3084 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_metricFExp3086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3100 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_conGD3102 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3104 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3112 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_conGD3114 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_conGD3116 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3118 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3120 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3122 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3129 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_conGD3131 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_conGD3133 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3135 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3145 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_conGD3147 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3149 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3156 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_conGD3158 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3160 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3168 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_121_in_conGD3170 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3172 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3174 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3181 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_93_in_conGD3183 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3185 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3192 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_conGD3194 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3196 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3198 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3205 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_conGD3207 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3209 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3211 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3218 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_conGD3220 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3222 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3224 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3226 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3233 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_conGD3235 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3237 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3239 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3241 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_conGD3248 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_conGD3250 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3252 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3254 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred17_Pddl729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred41_Pddl1361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred44_Pddl1521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred57_Pddl1777 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred57_Pddl1779 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_synpred57_Pddl1781 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp2_in_synpred57_Pddl1783 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred57_Pddl1785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred58_Pddl1802 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred58_Pddl1804 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_fExp_in_synpred58_Pddl1806 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred58_Pddl1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred87_Pddl2247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred89_Pddl2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_synpred89_Pddl2263 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred89_Pddl2265 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_synpred89_Pddl2268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred90_Pddl2273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred91_Pddl2278 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_synpred91_Pddl2280 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_synpred91_Pddl2282 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred91_Pddl2284 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred91_Pddl2286 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred91_Pddl2288 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred91_Pddl2290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred92_Pddl2295 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_synpred92_Pddl2297 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daGD_in_synpred92_Pddl2299 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_synpred92_Pddl2301 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred92_Pddl2303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred93_Pddl2327 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_synpred93_Pddl2329 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred93_Pddl2331 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred93_Pddl2333 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred93_Pddl2335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred94_Pddl2345 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_synpred94_Pddl2347 = new BitSet(new long[]{0x0000000000000000L,0x0080000400000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred94_Pddl2349 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred94_Pddl2351 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred94_Pddl2353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred95_Pddl2409 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred95_Pddl2411 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred95_Pddl2413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred96_Pddl2405 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred96_Pddl2409 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred96_Pddl2411 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred96_Pddl2413 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_60_in_synpred96_Pddl2419 = new BitSet(new long[]{0x0100002200000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred96_Pddl2421 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred96_Pddl2425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred108_Pddl2875 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_synpred108_Pddl2877 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred108_Pddl2879 = new BitSet(new long[]{0x0300000000000000L});
	public static final BitSet FOLLOW_57_in_synpred108_Pddl2882 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred109_Pddl2887 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_synpred109_Pddl2889 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_synpred109_Pddl2891 = new BitSet(new long[]{0x0220000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred109_Pddl2893 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred109_Pddl2895 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred109_Pddl2897 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred109_Pddl2899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred111_Pddl2904 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_synpred111_Pddl2906 = new BitSet(new long[]{0x0100000200000000L});
	public static final BitSet FOLLOW_NAME_in_synpred111_Pddl2908 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_conGD_in_synpred111_Pddl2911 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred111_Pddl2913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred113_Pddl2974 = new BitSet(new long[]{0x3C00000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred113_Pddl2976 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred113_Pddl2978 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred113_Pddl2980 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred113_Pddl2982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred115_Pddl3004 = new BitSet(new long[]{0x0C00000000000000L});
	public static final BitSet FOLLOW_multiOp_in_synpred115_Pddl3006 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred115_Pddl3008 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred115_Pddl3010 = new BitSet(new long[]{0x0300002200000000L});
	public static final BitSet FOLLOW_57_in_synpred115_Pddl3013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_synpred116_Pddl3037 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred116_Pddl3039 = new BitSet(new long[]{0x0100002200000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred116_Pddl3041 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred116_Pddl3043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred118_Pddl3065 = new BitSet(new long[]{0x0000000000000002L});
}
