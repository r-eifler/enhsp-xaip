// $ANTLR 3.5 /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g 2015-06-27 10:34:07

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
		"CONSTRAINT", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", 
		"EITHER_TYPE", "EQUALITY_CON", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", 
		"FREE_FUNCTIONS", "FUNCTIONS", "FUNC_HEAD", "GLOBAL_CONSTRAINT", "GOAL", 
		"IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", "MINUS_OP", 
		"MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", "NUMBER", 
		"OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", "PRED_INST", 
		"PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", 
		"REQUIREMENTS", "REQUIRE_KEY", "TYPES", "UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", 
		"WHITESPACE", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", 
		"':constants'", "':constraint'", "':constraints'", "':derived'", "':domain'", 
		"':duration'", "':durative-action'", "':effect'", "':free_functions'", 
		"':functions'", "':goal'", "':init'", "':metric'", "':objects'", "':parameters'", 
		"':precondition'", "':predicates'", "':requirements'", "':types'", "'<'", 
		"'<='", "'='", "'>'", "'>='", "'?duration'", "'all'", "'always'", "'always-within'", 
		"'and'", "'assign'", "'at'", "'at-most-once'", "'decrease'", "'define'", 
		"'domain'", "'either'", "'end'", "'exists'", "'forall'", "'hold-after'", 
		"'hold-during'", "'imply'", "'increase'", "'is-violated'", "'maximize'", 
		"'minimize'", "'not'", "'number'", "'or'", "'over'", "'preference'", "'problem'", 
		"'scale-down'", "'scale-up'", "'sometime'", "'sometime-after'", "'sometime-before'", 
		"'start'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int T__122=122;
	public static final int T__123=123;
	public static final int T__124=124;
	public static final int T__125=125;
	public static final int T__126=126;
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
	public static final int REQUIREMENTS=52;
	public static final int REQUIRE_KEY=53;
	public static final int TYPES=54;
	public static final int UNARY_MINUS=55;
	public static final int VARIABLE=56;
	public static final int WHEN_EFFECT=57;
	public static final int WHITESPACE=58;

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
	@Override public String getGrammarFileName() { return "/home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g"; }


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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:94:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:94:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==59) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==100) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==59) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==101) ) {
							alt1=1;
						}
						else if ( (LA1_3==118) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:94:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc341);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:94:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc345);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:98:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
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
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:99:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:99:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,59,FOLLOW_59_in_domain360); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal3);

			string_literal4=(Token)match(input,100,FOLLOW_100_in_domain362); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_100.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain364);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:100:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==59) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==84) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:100:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain372);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:101:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==59) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==85) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:101:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain381);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:102:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==59) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==67) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:102:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain390);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:103:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==59) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==83) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:103:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain399);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:104:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==59) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==76) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:104:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain408);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:105:7: ( free_functionsDef )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==59) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==75) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:105:7: free_functionsDef
					{
					pushFollow(FOLLOW_free_functionsDef_in_domain417);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:106:7: ( constraints )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==59) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==69) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:106:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain426);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:107:7: ( structureDef )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==59) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:107:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain435);
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

			char_literal14=(Token)match(input,60,FOLLOW_60_in_domain444); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal14);

			// AST REWRITE
			// elements: domainName, constantsDef, constraints, structureDef, requireDef, functionsDef, typesDef, predicatesDef, free_functionsDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 109:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:109:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:109:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:109:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:110:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:110:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:110:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:110:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:111:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:111:30: ( structureDef )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:114:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:115:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:115:4: '(' ':free_functions' functionList ')'
			{
			char_literal15=(Token)match(input,59,FOLLOW_59_in_free_functionsDef528); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal15);

			string_literal16=(Token)match(input,75,FOLLOW_75_in_free_functionsDef530); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_75.add(string_literal16);

			pushFollow(FOLLOW_functionList_in_free_functionsDef532);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());
			char_literal18=(Token)match(input,60,FOLLOW_60_in_free_functionsDef534); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal18);

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
			// 116:2: -> ^( FREE_FUNCTIONS functionList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:116:5: ^( FREE_FUNCTIONS functionList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:119:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
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
		RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:120:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:120:7: '(' 'domain' NAME ')'
			{
			char_literal19=(Token)match(input,59,FOLLOW_59_in_domainName557); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal19);

			string_literal20=(Token)match(input,101,FOLLOW_101_in_domainName559); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_101.add(string_literal20);

			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName561); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);

			char_literal22=(Token)match(input,60,FOLLOW_60_in_domainName563); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal22);

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
			// 121:6: -> ^( DOMAIN_NAME NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:121:9: ^( DOMAIN_NAME NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:124:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:125:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:125:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal23=(Token)match(input,59,FOLLOW_59_in_requireDef590); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal23);

			string_literal24=(Token)match(input,84,FOLLOW_84_in_requireDef592); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_84.add(string_literal24);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:125:24: ( REQUIRE_KEY )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:125:24: REQUIRE_KEY
					{
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef594); if (state.failed) return retval; 
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

			char_literal26=(Token)match(input,60,FOLLOW_60_in_requireDef597); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal26);

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
			// 126:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:126:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:129:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:130:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:130:4: '(' ':types' typedNameList ')'
			{
			char_literal27=(Token)match(input,59,FOLLOW_59_in_typesDef618); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal27);

			string_literal28=(Token)match(input,85,FOLLOW_85_in_typesDef620); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal28);

			pushFollow(FOLLOW_typedNameList_in_typesDef622);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());
			char_literal30=(Token)match(input,60,FOLLOW_60_in_typesDef624); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal30);

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
			// 131:4: -> ^( TYPES typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:131:7: ^( TYPES typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:135:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:8: ( NAME )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:8: ( NAME )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:8: NAME
							{
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList651); if (state.failed) return retval;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:16: ( singleTypeNameList )+ ( NAME )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:16: ( singleTypeNameList )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						alt12 = dfa12.predict(input);
						switch (alt12) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList656);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:36: ( NAME )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:136:36: NAME
							{
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList659); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:139:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME34=null;
		Token char_literal35=null;
		ParserRuleReturnScope t =null;

		Object NAME34_tree=null;
		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:7: ( ( NAME )+ '-' t= type )
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:7: ( ( NAME )+ '-' t= type )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:8: ( NAME )+ '-' t= type
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:8: ( NAME )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:140:8: NAME
					{
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList679); if (state.failed) return retval; 
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

			char_literal35=(Token)match(input,63,FOLLOW_63_in_singleTypeNameList682); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal35);

			pushFollow(FOLLOW_type_in_singleTypeNameList686);
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
			// 141:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:141:7: ^( NAME $t)
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:144:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
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
		RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==59) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:4: ( '(' 'either' ( primType )+ ')' )
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:4: ( '(' 'either' ( primType )+ ')' )
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:6: '(' 'either' ( primType )+ ')'
					{
					char_literal36=(Token)match(input,59,FOLLOW_59_in_type713); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal36);

					string_literal37=(Token)match(input,102,FOLLOW_102_in_type715); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_102.add(string_literal37);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:19: ( primType )+
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:19: primType
							{
							pushFollow(FOLLOW_primType_in_type717);
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

					char_literal39=(Token)match(input,60,FOLLOW_60_in_type720); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal39);

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
					// 146:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:146:7: ^( EITHER_TYPE ( primType )+ )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:147:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type741);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:150:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:150:10: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:150:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType751); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:152:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:153:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:153:4: '(' ':functions' functionList ')'
			{
			char_literal42=(Token)match(input,59,FOLLOW_59_in_functionsDef761); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal42);

			string_literal43=(Token)match(input,76,FOLLOW_76_in_functionsDef763); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal43);

			pushFollow(FOLLOW_functionList_in_functionsDef765);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());
			char_literal45=(Token)match(input,60,FOLLOW_60_in_functionsDef767); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal45);

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
			// 154:2: -> ^( FUNCTIONS functionList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:154:5: ^( FUNCTIONS functionList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:157:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws RecognitionException {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal47=null;
		ParserRuleReturnScope atomicFunctionSkeleton46 =null;
		ParserRuleReturnScope functionType48 =null;

		Object char_literal47_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==59) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==59) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						switch (alt18) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList788);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:29: ( '-' functionType )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==63) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:30: '-' functionType
							{
							char_literal47=(Token)match(input,63,FOLLOW_63_in_functionList792); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList794);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:161:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:162:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:162:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal49=(Token)match(input,59,FOLLOW_59_in_atomicFunctionSkeleton810); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton813);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton816);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

			char_literal52=(Token)match(input,60,FOLLOW_60_in_atomicFunctionSkeleton818); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:1: functionSymbol : NAME ;
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME53=null;

		Object NAME53_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:16: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:18: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME53=(Token)match(input,NAME,FOLLOW_NAME_in_functionSymbol829); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME53_tree = (Object)adaptor.create(NAME53);
			adaptor.addChild(root_0, NAME53_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:167:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:167:14: ( 'number' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:167:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal54=(Token)match(input,114,FOLLOW_114_in_functionType838); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:169:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
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
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:170:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:170:4: '(' ':constants' typedNameList ')'
			{
			char_literal55=(Token)match(input,59,FOLLOW_59_in_constantsDef849); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal55);

			string_literal56=(Token)match(input,67,FOLLOW_67_in_constantsDef851); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_67.add(string_literal56);

			pushFollow(FOLLOW_typedNameList_in_constantsDef853);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());
			char_literal58=(Token)match(input,60,FOLLOW_60_in_constantsDef855); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal58);

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
			// 171:2: -> ^( CONSTANTS typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:171:5: ^( CONSTANTS typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:174:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:175:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:175:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal59=(Token)match(input,59,FOLLOW_59_in_predicatesDef875); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal59);

			string_literal60=(Token)match(input,83,FOLLOW_83_in_predicatesDef877); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_83.add(string_literal60);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:175:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==59) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:175:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef879);
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

			char_literal62=(Token)match(input,60,FOLLOW_60_in_predicatesDef882); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal62);

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
			// 176:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:176:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:179:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:180:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:180:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal63=(Token)match(input,59,FOLLOW_59_in_atomicFormulaSkeleton903); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton906);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton909);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

			char_literal66=(Token)match(input,60,FOLLOW_60_in_atomicFormulaSkeleton911); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:183:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:183:11: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:183:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate922); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:186:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:8: ( VARIABLE )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:8: ( VARIABLE )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:8: VARIABLE
							{
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList937); if (state.failed) return retval;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:20: ( singleTypeVarList )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						alt23 = dfa23.predict(input);
						switch (alt23) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList942);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:39: ( VARIABLE )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:187:39: VARIABLE
							{
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList945); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:190:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
	public final PddlParser.singleTypeVarList_return singleTypeVarList() throws RecognitionException {
		PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE71=null;
		Token char_literal72=null;
		ParserRuleReturnScope t =null;

		Object VARIABLE71_tree=null;
		Object char_literal72_tree=null;
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:7: ( ( VARIABLE )+ '-' t= type )
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:7: ( ( VARIABLE )+ '-' t= type )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:8: ( VARIABLE )+ '-' t= type
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:8: ( VARIABLE )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:191:8: VARIABLE
					{
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList965); if (state.failed) return retval; 
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

			char_literal72=(Token)match(input,63,FOLLOW_63_in_singleTypeVarList968); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal72);

			pushFollow(FOLLOW_type_in_singleTypeVarList972);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: VARIABLE, t
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
			// 192:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_VARIABLE.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_VARIABLE.hasNext()||stream_t.hasNext() ) {
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:192:10: ^( VARIABLE $t)
					{
					Object root_1 = (Object)adaptor.nil();
					root_1 = (Object)adaptor.becomeRoot(stream_VARIABLE.nextNode(), root_1);
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

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:195:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:196:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:196:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal73=(Token)match(input,59,FOLLOW_59_in_constraints1003); if (state.failed) return retval;
			string_literal74=(Token)match(input,69,FOLLOW_69_in_constraints1006); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints1009);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

			char_literal76=(Token)match(input,60,FOLLOW_60_in_constraints1011); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:199:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef );
	public final PddlParser.structureDef_return structureDef() throws RecognitionException {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope actionDef77 =null;
		ParserRuleReturnScope durativeActionDef78 =null;
		ParserRuleReturnScope derivedDef79 =null;
		ParserRuleReturnScope constraintDef80 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:200:2: ( actionDef | durativeActionDef | derivedDef | constraintDef )
			int alt27=4;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==59) ) {
				switch ( input.LA(2) ) {
				case 65:
					{
					alt27=1;
					}
					break;
				case 73:
					{
					alt27=2;
					}
					break;
				case 70:
					{
					alt27=3;
					}
					break;
				case 68:
					{
					alt27=4;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:200:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef1023);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:201:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef1028);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:202:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef1033);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:203:4: constraintDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constraintDef_in_structureDef1038);
					constraintDef80=constraintDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:209:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws RecognitionException {
		PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal81=null;
		Token string_literal82=null;
		Token string_literal84=null;
		Token char_literal85=null;
		Token char_literal87=null;
		Token char_literal89=null;
		ParserRuleReturnScope actionSymbol83 =null;
		ParserRuleReturnScope typedVariableList86 =null;
		ParserRuleReturnScope actionDefBody88 =null;

		Object char_literal81_tree=null;
		Object string_literal82_tree=null;
		Object string_literal84_tree=null;
		Object char_literal85_tree=null;
		Object char_literal87_tree=null;
		Object char_literal89_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:210:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:210:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal81=(Token)match(input,59,FOLLOW_59_in_actionDef1053); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal81);

			string_literal82=(Token)match(input,65,FOLLOW_65_in_actionDef1055); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(string_literal82);

			pushFollow(FOLLOW_actionSymbol_in_actionDef1057);
			actionSymbol83=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol83.getTree());
			string_literal84=(Token)match(input,81,FOLLOW_81_in_actionDef1066); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal84);

			char_literal85=(Token)match(input,59,FOLLOW_59_in_actionDef1069); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal85);

			pushFollow(FOLLOW_typedVariableList_in_actionDef1071);
			typedVariableList86=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList86.getTree());
			char_literal87=(Token)match(input,60,FOLLOW_60_in_actionDef1073); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal87);

			pushFollow(FOLLOW_actionDefBody_in_actionDef1086);
			actionDefBody88=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody88.getTree());
			char_literal89=(Token)match(input,60,FOLLOW_60_in_actionDef1088); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal89);

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
			// 213:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:213:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:213:33: ( typedVariableList )?
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


	public static class constraintDef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constraintDef"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:216:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
	public final PddlParser.constraintDef_return constraintDef() throws RecognitionException {
		PddlParser.constraintDef_return retval = new PddlParser.constraintDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal90=null;
		Token string_literal91=null;
		Token string_literal93=null;
		Token char_literal94=null;
		Token char_literal96=null;
		Token char_literal98=null;
		ParserRuleReturnScope constraintSymbol92 =null;
		ParserRuleReturnScope typedVariableList95 =null;
		ParserRuleReturnScope constraintDefBody97 =null;

		Object char_literal90_tree=null;
		Object string_literal91_tree=null;
		Object string_literal93_tree=null;
		Object char_literal94_tree=null;
		Object char_literal96_tree=null;
		Object char_literal98_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
		RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:217:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:217:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
			{
			char_literal90=(Token)match(input,59,FOLLOW_59_in_constraintDef1122); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal90);

			string_literal91=(Token)match(input,68,FOLLOW_68_in_constraintDef1124); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(string_literal91);

			pushFollow(FOLLOW_constraintSymbol_in_constraintDef1126);
			constraintSymbol92=constraintSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol92.getTree());
			string_literal93=(Token)match(input,81,FOLLOW_81_in_constraintDef1135); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal93);

			char_literal94=(Token)match(input,59,FOLLOW_59_in_constraintDef1138); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal94);

			pushFollow(FOLLOW_typedVariableList_in_constraintDef1140);
			typedVariableList95=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList95.getTree());
			char_literal96=(Token)match(input,60,FOLLOW_60_in_constraintDef1142); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal96);

			pushFollow(FOLLOW_constraintDefBody_in_constraintDef1155);
			constraintDefBody97=constraintDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody97.getTree());
			char_literal98=(Token)match(input,60,FOLLOW_60_in_constraintDef1157); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal98);

			// AST REWRITE
			// elements: typedVariableList, constraintSymbol, constraintDefBody
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 220:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT"), root_1);
				adaptor.addChild(root_1, stream_constraintSymbol.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:48: ( typedVariableList )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:224:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME99=null;

		Object NAME99_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:224:14: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:224:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME99=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1191); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME99_tree = (Object)adaptor.create(NAME99);
			adaptor.addChild(root_0, NAME99_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:226:1: constraintSymbol : NAME ;
	public final PddlParser.constraintSymbol_return constraintSymbol() throws RecognitionException {
		PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME100=null;

		Object NAME100_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:226:18: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:226:20: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME100=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1200); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME100_tree = (Object)adaptor.create(NAME100);
			adaptor.addChild(root_0, NAME100_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:231:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
		PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal101=null;
		Token char_literal102=null;
		Token char_literal103=null;
		Token string_literal105=null;
		Token char_literal106=null;
		Token char_literal107=null;
		ParserRuleReturnScope goalDesc104 =null;
		ParserRuleReturnScope effect108 =null;

		Object string_literal101_tree=null;
		Object char_literal102_tree=null;
		Object char_literal103_tree=null;
		Object string_literal105_tree=null;
		Object char_literal106_tree=null;
		Object char_literal107_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==82) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal101=(Token)match(input,82,FOLLOW_82_in_actionDefBody1215); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_82.add(string_literal101);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:22: ( ( '(' ')' ) | goalDesc )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==59) ) {
						int LA28_1 = input.LA(2);
						if ( (LA28_1==60) ) {
							alt28=1;
						}
						else if ( (LA28_1==NAME||(LA28_1 >= 86 && LA28_1 <= 90)||LA28_1==95||(LA28_1 >= 104 && LA28_1 <= 105)||LA28_1==108||LA28_1==113||LA28_1==115) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:23: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:23: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:24: '(' ')'
							{
							char_literal102=(Token)match(input,59,FOLLOW_59_in_actionDefBody1219); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_59.add(char_literal102);

							char_literal103=(Token)match(input,60,FOLLOW_60_in_actionDefBody1221); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_60.add(char_literal103);

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:232:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1226);
							goalDesc104=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc104.getTree());
							}
							break;

					}

					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==74) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal105=(Token)match(input,74,FOLLOW_74_in_actionDefBody1236); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_74.add(string_literal105);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:16: ( ( '(' ')' ) | effect )
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==59) ) {
						int LA30_1 = input.LA(2);
						if ( (LA30_1==60) ) {
							alt30=1;
						}
						else if ( (LA30_1==NAME||(LA30_1 >= 95 && LA30_1 <= 96)||LA30_1==99||LA30_1==105||LA30_1==109||LA30_1==113||(LA30_1 >= 119 && LA30_1 <= 120)||LA30_1==125) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:17: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:17: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:18: '(' ')'
							{
							char_literal106=(Token)match(input,59,FOLLOW_59_in_actionDefBody1240); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_59.add(char_literal106);

							char_literal107=(Token)match(input,60,FOLLOW_60_in_actionDefBody1242); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_60.add(char_literal107);

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:233:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1247);
							effect108=effect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_effect.add(effect108.getTree());
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
			// 234:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:234:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:234:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:234:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:234:42: ( effect )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:237:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
	public final PddlParser.constraintDefBody_return constraintDefBody() throws RecognitionException {
		PddlParser.constraintDefBody_return retval = new PddlParser.constraintDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal109=null;
		Token char_literal110=null;
		Token char_literal111=null;
		ParserRuleReturnScope goalDesc112 =null;

		Object string_literal109_tree=null;
		Object char_literal110_tree=null;
		Object char_literal111_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==66) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:6: ':condition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal109=(Token)match(input,66,FOLLOW_66_in_constraintDefBody1282); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_66.add(string_literal109);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:19: ( ( '(' ')' ) | goalDesc )
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==59) ) {
						int LA32_1 = input.LA(2);
						if ( (LA32_1==60) ) {
							alt32=1;
						}
						else if ( (LA32_1==NAME||(LA32_1 >= 86 && LA32_1 <= 90)||LA32_1==95||(LA32_1 >= 104 && LA32_1 <= 105)||LA32_1==108||LA32_1==113||LA32_1==115) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:20: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:20: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:21: '(' ')'
							{
							char_literal110=(Token)match(input,59,FOLLOW_59_in_constraintDefBody1286); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_59.add(char_literal110);

							char_literal111=(Token)match(input,60,FOLLOW_60_in_constraintDefBody1288); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_60.add(char_literal111);

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:32: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_constraintDefBody1293);
							goalDesc112=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc112.getTree());
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
			// 239:4: -> ^( PRECONDITION ( goalDesc )? )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:239:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:239:22: ( goalDesc )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:254:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
		PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal114=null;
		Token string_literal115=null;
		Token char_literal117=null;
		Token char_literal118=null;
		Token string_literal119=null;
		Token char_literal121=null;
		Token char_literal122=null;
		Token string_literal123=null;
		Token char_literal125=null;
		Token char_literal126=null;
		Token string_literal127=null;
		Token char_literal130=null;
		Token char_literal131=null;
		Token string_literal132=null;
		Token char_literal133=null;
		Token char_literal135=null;
		Token char_literal137=null;
		Token char_literal138=null;
		Token string_literal139=null;
		Token char_literal140=null;
		Token char_literal142=null;
		Token char_literal144=null;
		ParserRuleReturnScope atomicTermFormula113 =null;
		ParserRuleReturnScope goalDesc116 =null;
		ParserRuleReturnScope goalDesc120 =null;
		ParserRuleReturnScope goalDesc124 =null;
		ParserRuleReturnScope goalDesc128 =null;
		ParserRuleReturnScope goalDesc129 =null;
		ParserRuleReturnScope typedVariableList134 =null;
		ParserRuleReturnScope goalDesc136 =null;
		ParserRuleReturnScope typedVariableList141 =null;
		ParserRuleReturnScope goalDesc143 =null;
		ParserRuleReturnScope fComp145 =null;
		ParserRuleReturnScope equality146 =null;

		Object char_literal114_tree=null;
		Object string_literal115_tree=null;
		Object char_literal117_tree=null;
		Object char_literal118_tree=null;
		Object string_literal119_tree=null;
		Object char_literal121_tree=null;
		Object char_literal122_tree=null;
		Object string_literal123_tree=null;
		Object char_literal125_tree=null;
		Object char_literal126_tree=null;
		Object string_literal127_tree=null;
		Object char_literal130_tree=null;
		Object char_literal131_tree=null;
		Object string_literal132_tree=null;
		Object char_literal133_tree=null;
		Object char_literal135_tree=null;
		Object char_literal137_tree=null;
		Object char_literal138_tree=null;
		Object string_literal139_tree=null;
		Object char_literal140_tree=null;
		Object char_literal142_tree=null;
		Object char_literal144_tree=null;
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
		RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
		RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
		RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:255:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt36=9;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==59) ) {
				switch ( input.LA(2) ) {
				case 95:
					{
					alt36=2;
					}
					break;
				case 115:
					{
					alt36=3;
					}
					break;
				case 113:
					{
					alt36=4;
					}
					break;
				case 108:
					{
					alt36=5;
					}
					break;
				case 104:
					{
					alt36=6;
					}
					break;
				case 105:
					{
					alt36=7;
					}
					break;
				case 88:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA36_13 = input.LA(5);
							if ( (LA36_13==60) ) {
								int LA36_14 = input.LA(6);
								if ( (synpred45_Pddl()) ) {
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
						case 59:
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
					case 59:
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
				case 86:
				case 87:
				case 89:
				case 90:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:255:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1331);
					atomicTermFormula113=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula113.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:256:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal114=(Token)match(input,59,FOLLOW_59_in_goalDesc1336); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal114);

					string_literal115=(Token)match(input,95,FOLLOW_95_in_goalDesc1338); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_95.add(string_literal115);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:256:14: ( goalDesc )*
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==59) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:256:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1340);
							goalDesc116=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc116.getTree());
							}
							break;

						default :
							break loop34;
						}
					}

					char_literal117=(Token)match(input,60,FOLLOW_60_in_goalDesc1343); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal117);

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
					// 257:12: -> ^( AND_GD ( goalDesc )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:257:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:257:24: ( goalDesc )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:258:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal118=(Token)match(input,59,FOLLOW_59_in_goalDesc1368); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal118);

					string_literal119=(Token)match(input,115,FOLLOW_115_in_goalDesc1370); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_115.add(string_literal119);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:258:13: ( goalDesc )*
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( (LA35_0==59) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:258:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1372);
							goalDesc120=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc120.getTree());
							}
							break;

						default :
							break loop35;
						}
					}

					char_literal121=(Token)match(input,60,FOLLOW_60_in_goalDesc1375); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal121);

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
					// 259:12: -> ^( OR_GD ( goalDesc )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:259:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:259:23: ( goalDesc )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:260:4: '(' 'not' goalDesc ')'
					{
					char_literal122=(Token)match(input,59,FOLLOW_59_in_goalDesc1400); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal122);

					string_literal123=(Token)match(input,113,FOLLOW_113_in_goalDesc1402); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal123);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1404);
					goalDesc124=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc124.getTree());
					char_literal125=(Token)match(input,60,FOLLOW_60_in_goalDesc1406); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal125);

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
					// 261:12: -> ^( NOT_GD goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:261:15: ^( NOT_GD goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:262:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal126=(Token)match(input,59,FOLLOW_59_in_goalDesc1430); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal126);

					string_literal127=(Token)match(input,108,FOLLOW_108_in_goalDesc1432); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_108.add(string_literal127);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1434);
					goalDesc128=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc128.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1436);
					goalDesc129=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc129.getTree());
					char_literal130=(Token)match(input,60,FOLLOW_60_in_goalDesc1438); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal130);

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
					// 263:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:263:15: ^( IMPLY_GD goalDesc goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal131=(Token)match(input,59,FOLLOW_59_in_goalDesc1464); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal131);

					string_literal132=(Token)match(input,104,FOLLOW_104_in_goalDesc1466); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_104.add(string_literal132);

					char_literal133=(Token)match(input,59,FOLLOW_59_in_goalDesc1468); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal133);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1470);
					typedVariableList134=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList134.getTree());
					char_literal135=(Token)match(input,60,FOLLOW_60_in_goalDesc1472); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal135);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1474);
					goalDesc136=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc136.getTree());
					char_literal137=(Token)match(input,60,FOLLOW_60_in_goalDesc1476); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal137);

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
					// 265:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:265:15: ^( EXISTS_GD typedVariableList goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:266:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal138=(Token)match(input,59,FOLLOW_59_in_goalDesc1502); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal138);

					string_literal139=(Token)match(input,105,FOLLOW_105_in_goalDesc1504); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_105.add(string_literal139);

					char_literal140=(Token)match(input,59,FOLLOW_59_in_goalDesc1506); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal140);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1508);
					typedVariableList141=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList141.getTree());
					char_literal142=(Token)match(input,60,FOLLOW_60_in_goalDesc1510); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal142);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1512);
					goalDesc143=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc143.getTree());
					char_literal144=(Token)match(input,60,FOLLOW_60_in_goalDesc1514); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal144);

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
					// 267:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:267:15: ^( FORALL_GD typedVariableList goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:268:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1543);
					fComp145=fComp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fComp.add(fComp145.getTree());
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
					// 269:15: -> ^( COMPARISON_GD fComp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:269:18: ^( COMPARISON_GD fComp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:270:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1570);
					equality146=equality();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_equality.add(equality146.getTree());
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
					// 271:6: -> ^( EQUALITY_CON equality )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:271:9: ^( EQUALITY_CON equality )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:274:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws RecognitionException {
		PddlParser.equality_return retval = new PddlParser.equality_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal147=null;
		Token char_literal148=null;
		Token char_literal151=null;
		ParserRuleReturnScope term149 =null;
		ParserRuleReturnScope term150 =null;

		Object char_literal147_tree=null;
		Object char_literal148_tree=null;
		Object char_literal151_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:275:2: ( '(' ! '=' term term ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:275:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal147=(Token)match(input,59,FOLLOW_59_in_equality1598); if (state.failed) return retval;
			char_literal148=(Token)match(input,88,FOLLOW_88_in_equality1601); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal148_tree = (Object)adaptor.create(char_literal148);
			adaptor.addChild(root_0, char_literal148_tree);
			}

			pushFollow(FOLLOW_term_in_equality1603);
			term149=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term149.getTree());

			pushFollow(FOLLOW_term_in_equality1605);
			term150=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term150.getTree());

			char_literal151=(Token)match(input,60,FOLLOW_60_in_equality1607); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:277:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws RecognitionException {
		PddlParser.fComp_return retval = new PddlParser.fComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal152=null;
		Token char_literal156=null;
		ParserRuleReturnScope binaryComp153 =null;
		ParserRuleReturnScope fExp154 =null;
		ParserRuleReturnScope fExp155 =null;

		Object char_literal152_tree=null;
		Object char_literal156_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:278:2: ( '(' ! binaryComp fExp fExp ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:278:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal152=(Token)match(input,59,FOLLOW_59_in_fComp1618); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1621);
			binaryComp153=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp153.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1623);
			fExp154=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp154.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1625);
			fExp155=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp155.getTree());

			char_literal156=(Token)match(input,60,FOLLOW_60_in_fComp1627); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal157=null;
		Token char_literal160=null;
		ParserRuleReturnScope predicate158 =null;
		ParserRuleReturnScope term159 =null;

		Object char_literal157_tree=null;
		Object char_literal160_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:4: '(' predicate ( term )* ')'
			{
			char_literal157=(Token)match(input,59,FOLLOW_59_in_atomicTermFormula1639); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal157);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1641);
			predicate158=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate158.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:18: ( term )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==NAME||LA37_0==VARIABLE) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1643);
					term159=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_term.add(term159.getTree());
					}
					break;

				default :
					break loop37;
				}
			}

			char_literal160=(Token)match(input,60,FOLLOW_60_in_atomicTermFormula1646); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal160);

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
			// 282:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:282:53: ( term )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:285:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set161=null;

		Object set161_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:285:6: ( NAME | VARIABLE )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set161=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set161));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:289:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
		PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal162=null;
		Token string_literal163=null;
		Token string_literal165=null;
		Token char_literal166=null;
		Token char_literal168=null;
		Token char_literal170=null;
		ParserRuleReturnScope actionSymbol164 =null;
		ParserRuleReturnScope typedVariableList167 =null;
		ParserRuleReturnScope daDefBody169 =null;

		Object char_literal162_tree=null;
		Object string_literal163_tree=null;
		Object string_literal165_tree=null;
		Object char_literal166_tree=null;
		Object char_literal168_tree=null;
		Object char_literal170_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:290:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:290:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal162=(Token)match(input,59,FOLLOW_59_in_durativeActionDef1684); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal162);

			string_literal163=(Token)match(input,73,FOLLOW_73_in_durativeActionDef1686); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(string_literal163);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1688);
			actionSymbol164=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol164.getTree());
			string_literal165=(Token)match(input,81,FOLLOW_81_in_durativeActionDef1697); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal165);

			char_literal166=(Token)match(input,59,FOLLOW_59_in_durativeActionDef1700); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal166);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:27: ( typedVariableList )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==VARIABLE) ) {
				alt38=1;
			}
			else if ( (LA38_0==60) ) {
				int LA38_2 = input.LA(2);
				if ( (synpred48_Pddl()) ) {
					alt38=1;
				}
			}
			switch (alt38) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1703);
					typedVariableList167=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList167.getTree());
					}
					break;

			}

			char_literal168=(Token)match(input,60,FOLLOW_60_in_durativeActionDef1707); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal168);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1720);
			daDefBody169=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody169.getTree());
			char_literal170=(Token)match(input,60,FOLLOW_60_in_durativeActionDef1722); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal170);

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
			// 293:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:293:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:296:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
		PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal171=null;
		Token string_literal173=null;
		Token char_literal174=null;
		Token char_literal175=null;
		Token string_literal177=null;
		Token char_literal178=null;
		Token char_literal179=null;
		ParserRuleReturnScope durationConstraint172 =null;
		ParserRuleReturnScope daGD176 =null;
		ParserRuleReturnScope daEffect180 =null;

		Object string_literal171_tree=null;
		Object string_literal173_tree=null;
		Object char_literal174_tree=null;
		Object char_literal175_tree=null;
		Object string_literal177_tree=null;
		Object char_literal178_tree=null;
		Object char_literal179_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:297:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt41=3;
			switch ( input.LA(1) ) {
			case 72:
				{
				alt41=1;
				}
				break;
			case 66:
				{
				alt41=2;
				}
				break;
			case 74:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:297:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal171=(Token)match(input,72,FOLLOW_72_in_daDefBody1755); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal171_tree = (Object)adaptor.create(string_literal171);
					adaptor.addChild(root_0, string_literal171_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody1757);
					durationConstraint172=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint172.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal173=(Token)match(input,66,FOLLOW_66_in_daDefBody1762); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal173_tree = (Object)adaptor.create(string_literal173);
					adaptor.addChild(root_0, string_literal173_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:17: ( ( '(' ')' ) | daGD )
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==59) ) {
						int LA39_1 = input.LA(2);
						if ( (LA39_1==60) ) {
							alt39=1;
						}
						else if ( (LA39_1==95||LA39_1==97||LA39_1==105||(LA39_1 >= 116 && LA39_1 <= 117)) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:18: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:18: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:19: '(' ')'
							{
							char_literal174=(Token)match(input,59,FOLLOW_59_in_daDefBody1766); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal174_tree = (Object)adaptor.create(char_literal174);
							adaptor.addChild(root_0, char_literal174_tree);
							}

							char_literal175=(Token)match(input,60,FOLLOW_60_in_daDefBody1768); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal175_tree = (Object)adaptor.create(char_literal175);
							adaptor.addChild(root_0, char_literal175_tree);
							}

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:298:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody1773);
							daGD176=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD176.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal177=(Token)match(input,74,FOLLOW_74_in_daDefBody1782); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal177_tree = (Object)adaptor.create(string_literal177);
					adaptor.addChild(root_0, string_literal177_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:17: ( ( '(' ')' ) | daEffect )
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==59) ) {
						int LA40_1 = input.LA(2);
						if ( (LA40_1==60) ) {
							alt40=1;
						}
						else if ( ((LA40_1 >= 95 && LA40_1 <= 97)||LA40_1==99||LA40_1==105||LA40_1==109||(LA40_1 >= 119 && LA40_1 <= 120)||LA40_1==125) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:18: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:18: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:19: '(' ')'
							{
							char_literal178=(Token)match(input,59,FOLLOW_59_in_daDefBody1786); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal178_tree = (Object)adaptor.create(char_literal178);
							adaptor.addChild(root_0, char_literal178_tree);
							}

							char_literal179=(Token)match(input,60,FOLLOW_60_in_daDefBody1788); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal179_tree = (Object)adaptor.create(char_literal179);
							adaptor.addChild(root_0, char_literal179_tree);
							}

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:299:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody1793);
							daEffect180=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect180.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:302:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws RecognitionException {
		PddlParser.daGD_return retval = new PddlParser.daGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal182=null;
		Token string_literal183=null;
		Token char_literal185=null;
		Token char_literal186=null;
		Token string_literal187=null;
		Token char_literal188=null;
		Token char_literal190=null;
		Token char_literal192=null;
		ParserRuleReturnScope prefTimedGD181 =null;
		ParserRuleReturnScope daGD184 =null;
		ParserRuleReturnScope typedVariableList189 =null;
		ParserRuleReturnScope daGD191 =null;

		Object char_literal182_tree=null;
		Object string_literal183_tree=null;
		Object char_literal185_tree=null;
		Object char_literal186_tree=null;
		Object string_literal187_tree=null;
		Object char_literal188_tree=null;
		Object char_literal190_tree=null;
		Object char_literal192_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:303:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt43=3;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==59) ) {
				switch ( input.LA(2) ) {
				case 97:
				case 116:
				case 117:
					{
					alt43=1;
					}
					break;
				case 95:
					{
					alt43=2;
					}
					break;
				case 105:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:303:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD1808);
					prefTimedGD181=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD181.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:304:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal182=(Token)match(input,59,FOLLOW_59_in_daGD1813); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal182_tree = (Object)adaptor.create(char_literal182);
					adaptor.addChild(root_0, char_literal182_tree);
					}

					string_literal183=(Token)match(input,95,FOLLOW_95_in_daGD1815); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal183_tree = (Object)adaptor.create(string_literal183);
					adaptor.addChild(root_0, string_literal183_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:304:14: ( daGD )*
					loop42:
					while (true) {
						int alt42=2;
						int LA42_0 = input.LA(1);
						if ( (LA42_0==59) ) {
							alt42=1;
						}

						switch (alt42) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:304:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD1817);
							daGD184=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD184.getTree());

							}
							break;

						default :
							break loop42;
						}
					}

					char_literal185=(Token)match(input,60,FOLLOW_60_in_daGD1820); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal185_tree = (Object)adaptor.create(char_literal185);
					adaptor.addChild(root_0, char_literal185_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:305:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal186=(Token)match(input,59,FOLLOW_59_in_daGD1825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal186_tree = (Object)adaptor.create(char_literal186);
					adaptor.addChild(root_0, char_literal186_tree);
					}

					string_literal187=(Token)match(input,105,FOLLOW_105_in_daGD1827); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal187_tree = (Object)adaptor.create(string_literal187);
					adaptor.addChild(root_0, string_literal187_tree);
					}

					char_literal188=(Token)match(input,59,FOLLOW_59_in_daGD1829); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal188_tree = (Object)adaptor.create(char_literal188);
					adaptor.addChild(root_0, char_literal188_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD1831);
					typedVariableList189=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList189.getTree());

					char_literal190=(Token)match(input,60,FOLLOW_60_in_daGD1833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal190_tree = (Object)adaptor.create(char_literal190);
					adaptor.addChild(root_0, char_literal190_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD1835);
					daGD191=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD191.getTree());

					char_literal192=(Token)match(input,60,FOLLOW_60_in_daGD1837); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal192_tree = (Object)adaptor.create(char_literal192);
					adaptor.addChild(root_0, char_literal192_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:308:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
		PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal194=null;
		Token string_literal195=null;
		Token NAME196=null;
		Token char_literal198=null;
		ParserRuleReturnScope timedGD193 =null;
		ParserRuleReturnScope timedGD197 =null;

		Object char_literal194_tree=null;
		Object string_literal195_tree=null;
		Object NAME196_tree=null;
		Object char_literal198_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:309:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==59) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==97||LA45_1==116) ) {
					alt45=1;
				}
				else if ( (LA45_1==117) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:309:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD1848);
					timedGD193=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD193.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:310:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal194=(Token)match(input,59,FOLLOW_59_in_prefTimedGD1853); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal194_tree = (Object)adaptor.create(char_literal194);
					adaptor.addChild(root_0, char_literal194_tree);
					}

					string_literal195=(Token)match(input,117,FOLLOW_117_in_prefTimedGD1855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal195_tree = (Object)adaptor.create(string_literal195);
					adaptor.addChild(root_0, string_literal195_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:310:21: ( NAME )?
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==NAME) ) {
						alt44=1;
					}
					switch (alt44) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:310:21: NAME
							{
							NAME196=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD1857); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME196_tree = (Object)adaptor.create(NAME196);
							adaptor.addChild(root_0, NAME196_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD1860);
					timedGD197=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD197.getTree());

					char_literal198=(Token)match(input,60,FOLLOW_60_in_prefTimedGD1862); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal198_tree = (Object)adaptor.create(char_literal198);
					adaptor.addChild(root_0, char_literal198_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:313:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws RecognitionException {
		PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal199=null;
		Token string_literal200=null;
		Token char_literal203=null;
		Token char_literal204=null;
		Token string_literal205=null;
		Token char_literal208=null;
		ParserRuleReturnScope timeSpecifier201 =null;
		ParserRuleReturnScope goalDesc202 =null;
		ParserRuleReturnScope interval206 =null;
		ParserRuleReturnScope goalDesc207 =null;

		Object char_literal199_tree=null;
		Object string_literal200_tree=null;
		Object char_literal203_tree=null;
		Object char_literal204_tree=null;
		Object string_literal205_tree=null;
		Object char_literal208_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==59) ) {
				int LA46_1 = input.LA(2);
				if ( (LA46_1==97) ) {
					alt46=1;
				}
				else if ( (LA46_1==116) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal199=(Token)match(input,59,FOLLOW_59_in_timedGD1873); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal199_tree = (Object)adaptor.create(char_literal199);
					adaptor.addChild(root_0, char_literal199_tree);
					}

					string_literal200=(Token)match(input,97,FOLLOW_97_in_timedGD1875); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal200_tree = (Object)adaptor.create(string_literal200);
					adaptor.addChild(root_0, string_literal200_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD1877);
					timeSpecifier201=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier201.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1879);
					goalDesc202=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc202.getTree());

					char_literal203=(Token)match(input,60,FOLLOW_60_in_timedGD1881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal203_tree = (Object)adaptor.create(char_literal203);
					adaptor.addChild(root_0, char_literal203_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:315:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal204=(Token)match(input,59,FOLLOW_59_in_timedGD1886); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal204_tree = (Object)adaptor.create(char_literal204);
					adaptor.addChild(root_0, char_literal204_tree);
					}

					string_literal205=(Token)match(input,116,FOLLOW_116_in_timedGD1888); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal205_tree = (Object)adaptor.create(string_literal205);
					adaptor.addChild(root_0, string_literal205_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD1890);
					interval206=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval206.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1892);
					goalDesc207=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc207.getTree());

					char_literal208=(Token)match(input,60,FOLLOW_60_in_timedGD1894); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal208_tree = (Object)adaptor.create(char_literal208);
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
	// $ANTLR end "timedGD"


	public static class timeSpecifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timeSpecifier"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:318:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set209=null;

		Object set209_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:318:15: ( 'start' | 'end' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set209=input.LT(1);
			if ( input.LA(1)==103||input.LA(1)==124 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set209));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:319:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal210=null;

		Object string_literal210_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:319:10: ( 'all' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:319:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal210=(Token)match(input,92,FOLLOW_92_in_interval1916); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal210_tree = (Object)adaptor.create(string_literal210);
			adaptor.addChild(root_0, string_literal210_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
		PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal211=null;
		Token string_literal212=null;
		Token char_literal215=null;
		ParserRuleReturnScope typedVariableList213 =null;
		ParserRuleReturnScope goalDesc214 =null;

		Object char_literal211_tree=null;
		Object string_literal212_tree=null;
		Object char_literal215_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:324:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:324:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal211=(Token)match(input,59,FOLLOW_59_in_derivedDef1929); if (state.failed) return retval;
			string_literal212=(Token)match(input,70,FOLLOW_70_in_derivedDef1932); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal212_tree = (Object)adaptor.create(string_literal212);
			root_0 = (Object)adaptor.becomeRoot(string_literal212_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef1935);
			typedVariableList213=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList213.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef1937);
			goalDesc214=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc214.getTree());

			char_literal215=(Token)match(input,60,FOLLOW_60_in_derivedDef1939); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:329:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws RecognitionException {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER216=null;
		Token char_literal217=null;
		Token char_literal221=null;
		Token char_literal222=null;
		Token char_literal223=null;
		Token char_literal225=null;
		ParserRuleReturnScope binaryOp218 =null;
		ParserRuleReturnScope fExp219 =null;
		ParserRuleReturnScope fExp2220 =null;
		ParserRuleReturnScope fExp224 =null;
		ParserRuleReturnScope fHead226 =null;

		Object NUMBER216_tree=null;
		Object char_literal217_tree=null;
		Object char_literal221_tree=null;
		Object char_literal222_tree=null;
		Object char_literal223_tree=null;
		Object char_literal225_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:330:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
			int alt47=4;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt47=1;
				}
				break;
			case 59:
				{
				int LA47_2 = input.LA(2);
				if ( (synpred61_Pddl()) ) {
					alt47=2;
				}
				else if ( (synpred62_Pddl()) ) {
					alt47=3;
				}
				else if ( (true) ) {
					alt47=4;
				}

				}
				break;
			case NAME:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:330:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER216=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp1954); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER216_tree = (Object)adaptor.create(NUMBER216);
					adaptor.addChild(root_0, NUMBER216_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:331:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal217=(Token)match(input,59,FOLLOW_59_in_fExp1959); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal217);

					pushFollow(FOLLOW_binaryOp_in_fExp1961);
					binaryOp218=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp218.getTree());
					pushFollow(FOLLOW_fExp_in_fExp1963);
					fExp219=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp219.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp1965);
					fExp2220=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2220.getTree());
					char_literal221=(Token)match(input,60,FOLLOW_60_in_fExp1967); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal221);

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
					// 331:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:331:35: ^( BINARY_OP binaryOp fExp fExp2 )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:332:4: '(' '-' fExp ')'
					{
					char_literal222=(Token)match(input,59,FOLLOW_59_in_fExp1984); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal222);

					char_literal223=(Token)match(input,63,FOLLOW_63_in_fExp1986); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal223);

					pushFollow(FOLLOW_fExp_in_fExp1988);
					fExp224=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp224.getTree());
					char_literal225=(Token)match(input,60,FOLLOW_60_in_fExp1990); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal225);

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
					// 332:21: -> ^( UNARY_MINUS fExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:332:24: ^( UNARY_MINUS fExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:333:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp2003);
					fHead226=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead226.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:338:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fExp227 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:338:7: ( fExp )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:338:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp22015);
			fExp227=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp227.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:340:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal228=null;
		Token char_literal231=null;
		ParserRuleReturnScope functionSymbol229 =null;
		ParserRuleReturnScope term230 =null;
		ParserRuleReturnScope functionSymbol232 =null;

		Object char_literal228_tree=null;
		Object char_literal231_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==59) ) {
				alt49=1;
			}
			else if ( (LA49_0==NAME) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:4: '(' functionSymbol ( term )* ')'
					{
					char_literal228=(Token)match(input,59,FOLLOW_59_in_fHead2025); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal228);

					pushFollow(FOLLOW_functionSymbol_in_fHead2027);
					functionSymbol229=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol229.getTree());
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:23: ( term )*
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==NAME||LA48_0==VARIABLE) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:23: term
							{
							pushFollow(FOLLOW_term_in_fHead2029);
							term230=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term230.getTree());
							}
							break;

						default :
							break loop48;
						}
					}

					char_literal231=(Token)match(input,60,FOLLOW_60_in_fHead2032); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal231);

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
					// 341:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:63: ( term )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:342:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead2048);
					functionSymbol232=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol232.getTree());
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
					// 342:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:342:22: ^( FUNC_HEAD functionSymbol )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:345:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal233=null;
		Token string_literal234=null;
		Token char_literal236=null;
		ParserRuleReturnScope cEffect235 =null;
		ParserRuleReturnScope cEffect237 =null;

		Object char_literal233_tree=null;
		Object string_literal234_tree=null;
		Object char_literal236_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==59) ) {
				int LA51_1 = input.LA(2);
				if ( (LA51_1==95) ) {
					alt51=1;
				}
				else if ( (LA51_1==NAME||LA51_1==96||LA51_1==99||LA51_1==105||LA51_1==109||LA51_1==113||(LA51_1 >= 119 && LA51_1 <= 120)||LA51_1==125) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal233=(Token)match(input,59,FOLLOW_59_in_effect2067); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal233);

					string_literal234=(Token)match(input,95,FOLLOW_95_in_effect2069); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_95.add(string_literal234);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:14: ( cEffect )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==59) ) {
							alt50=1;
						}

						switch (alt50) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect2071);
							cEffect235=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect235.getTree());
							}
							break;

						default :
							break loop50;
						}
					}

					char_literal236=(Token)match(input,60,FOLLOW_60_in_effect2074); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal236);

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
					// 346:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:346:43: ( cEffect )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:347:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect2088);
					cEffect237=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect237.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:350:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal238=null;
		Token string_literal239=null;
		Token char_literal240=null;
		Token char_literal242=null;
		Token char_literal244=null;
		Token char_literal245=null;
		Token string_literal246=null;
		Token char_literal249=null;
		ParserRuleReturnScope typedVariableList241 =null;
		ParserRuleReturnScope effect243 =null;
		ParserRuleReturnScope goalDesc247 =null;
		ParserRuleReturnScope condEffect248 =null;
		ParserRuleReturnScope pEffect250 =null;

		Object char_literal238_tree=null;
		Object string_literal239_tree=null;
		Object char_literal240_tree=null;
		Object char_literal242_tree=null;
		Object char_literal244_tree=null;
		Object char_literal245_tree=null;
		Object string_literal246_tree=null;
		Object char_literal249_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
		RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt52=3;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==59) ) {
				switch ( input.LA(2) ) {
				case 105:
					{
					alt52=1;
					}
					break;
				case 125:
					{
					alt52=2;
					}
					break;
				case NAME:
				case 96:
				case 99:
				case 109:
				case 113:
				case 119:
				case 120:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal238=(Token)match(input,59,FOLLOW_59_in_cEffect2099); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal238);

					string_literal239=(Token)match(input,105,FOLLOW_105_in_cEffect2101); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_105.add(string_literal239);

					char_literal240=(Token)match(input,59,FOLLOW_59_in_cEffect2103); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal240);

					pushFollow(FOLLOW_typedVariableList_in_cEffect2105);
					typedVariableList241=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList241.getTree());
					char_literal242=(Token)match(input,60,FOLLOW_60_in_cEffect2107); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal242);

					pushFollow(FOLLOW_effect_in_cEffect2109);
					effect243=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect243.getTree());
					char_literal244=(Token)match(input,60,FOLLOW_60_in_cEffect2111); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal244);

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
					// 352:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:352:7: ^( FORALL_EFFECT typedVariableList effect )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:353:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal245=(Token)match(input,59,FOLLOW_59_in_cEffect2129); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal245);

					string_literal246=(Token)match(input,125,FOLLOW_125_in_cEffect2131); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_125.add(string_literal246);

					pushFollow(FOLLOW_goalDesc_in_cEffect2133);
					goalDesc247=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc247.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect2135);
					condEffect248=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect248.getTree());
					char_literal249=(Token)match(input,60,FOLLOW_60_in_cEffect2137); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal249);

					// AST REWRITE
					// elements: condEffect, goalDesc
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 354:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:354:7: ^( WHEN_EFFECT goalDesc condEffect )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:355:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect2155);
					pEffect250=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect250.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:358:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal251=null;
		Token char_literal255=null;
		Token char_literal256=null;
		Token string_literal257=null;
		Token char_literal259=null;
		ParserRuleReturnScope assignOp252 =null;
		ParserRuleReturnScope fHead253 =null;
		ParserRuleReturnScope fExp254 =null;
		ParserRuleReturnScope atomicTermFormula258 =null;
		ParserRuleReturnScope atomicTermFormula260 =null;

		Object char_literal251_tree=null;
		Object char_literal255_tree=null;
		Object char_literal256_tree=null;
		Object string_literal257_tree=null;
		Object char_literal259_tree=null;
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:359:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt53=3;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==59) ) {
				switch ( input.LA(2) ) {
				case 113:
					{
					alt53=2;
					}
					break;
				case 96:
				case 99:
				case 109:
				case 119:
				case 120:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:359:4: '(' assignOp fHead fExp ')'
					{
					char_literal251=(Token)match(input,59,FOLLOW_59_in_pEffect2166); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal251);

					pushFollow(FOLLOW_assignOp_in_pEffect2168);
					assignOp252=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp252.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect2170);
					fHead253=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead253.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect2172);
					fExp254=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp254.getTree());
					char_literal255=(Token)match(input,60,FOLLOW_60_in_pEffect2174); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal255);

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
					// 360:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:360:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:361:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal256=(Token)match(input,59,FOLLOW_59_in_pEffect2194); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal256);

					string_literal257=(Token)match(input,113,FOLLOW_113_in_pEffect2196); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal257);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2198);
					atomicTermFormula258=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula258.getTree());
					char_literal259=(Token)match(input,60,FOLLOW_60_in_pEffect2200); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal259);

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
					// 362:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:362:7: ^( NOT_EFFECT atomicTermFormula )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:363:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2216);
					atomicTermFormula260=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula260.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:368:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal261=null;
		Token string_literal262=null;
		Token char_literal264=null;
		ParserRuleReturnScope pEffect263 =null;
		ParserRuleReturnScope pEffect265 =null;

		Object char_literal261_tree=null;
		Object string_literal262_tree=null;
		Object char_literal264_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==59) ) {
				int LA55_1 = input.LA(2);
				if ( (LA55_1==95) ) {
					alt55=1;
				}
				else if ( (LA55_1==NAME||LA55_1==96||LA55_1==99||LA55_1==109||LA55_1==113||(LA55_1 >= 119 && LA55_1 <= 120)) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal261=(Token)match(input,59,FOLLOW_59_in_condEffect2229); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal261);

					string_literal262=(Token)match(input,95,FOLLOW_95_in_condEffect2231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_95.add(string_literal262);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:14: ( pEffect )*
					loop54:
					while (true) {
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==59) ) {
							alt54=1;
						}

						switch (alt54) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2233);
							pEffect263=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect263.getTree());
							}
							break;

						default :
							break loop54;
						}
					}

					char_literal264=(Token)match(input,60,FOLLOW_60_in_condEffect2236); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal264);

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
					// 369:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:43: ( pEffect )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:370:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2250);
					pEffect265=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect265.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:374:1: binaryOp : ( '*' | '+' | '-' | '/' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set266=null;

		Object set266_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:374:10: ( '*' | '+' | '-' | '/' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set266=input.LT(1);
			if ( (input.LA(1) >= 61 && input.LA(1) <= 64) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set266));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:376:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set267=null;

		Object set267_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:376:9: ( '*' | '+' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set267=input.LT(1);
			if ( (input.LA(1) >= 61 && input.LA(1) <= 62) ) {
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
	// $ANTLR end "multiOp"


	public static class binaryComp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryComp"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:378:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set268=null;

		Object set268_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:378:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set268=input.LT(1);
			if ( (input.LA(1) >= 86 && input.LA(1) <= 90) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set268));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set269=null;

		Object set269_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set269=input.LT(1);
			if ( input.LA(1)==96||input.LA(1)==99||input.LA(1)==109||(input.LA(1) >= 119 && input.LA(1) <= 120) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set269));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:385:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal270=null;
		Token string_literal271=null;
		Token char_literal273=null;
		Token char_literal274=null;
		Token char_literal275=null;
		ParserRuleReturnScope simpleDurationConstraint272 =null;
		ParserRuleReturnScope simpleDurationConstraint276 =null;

		Object char_literal270_tree=null;
		Object string_literal271_tree=null;
		Object char_literal273_tree=null;
		Object char_literal274_tree=null;
		Object char_literal275_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt57=3;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==59) ) {
				switch ( input.LA(2) ) {
				case 95:
					{
					alt57=1;
					}
					break;
				case 60:
					{
					alt57=2;
					}
					break;
				case 87:
				case 88:
				case 90:
				case 97:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal270=(Token)match(input,59,FOLLOW_59_in_durationConstraint2351); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal270_tree = (Object)adaptor.create(char_literal270);
					adaptor.addChild(root_0, char_literal270_tree);
					}

					string_literal271=(Token)match(input,95,FOLLOW_95_in_durationConstraint2353); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal271_tree = (Object)adaptor.create(string_literal271);
					adaptor.addChild(root_0, string_literal271_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:14: ( simpleDurationConstraint )+
					int cnt56=0;
					loop56:
					while (true) {
						int alt56=2;
						int LA56_0 = input.LA(1);
						if ( (LA56_0==59) ) {
							alt56=1;
						}

						switch (alt56) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2355);
							simpleDurationConstraint272=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint272.getTree());

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

					char_literal273=(Token)match(input,60,FOLLOW_60_in_durationConstraint2358); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal273_tree = (Object)adaptor.create(char_literal273);
					adaptor.addChild(root_0, char_literal273_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:387:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal274=(Token)match(input,59,FOLLOW_59_in_durationConstraint2363); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal274_tree = (Object)adaptor.create(char_literal274);
					adaptor.addChild(root_0, char_literal274_tree);
					}

					char_literal275=(Token)match(input,60,FOLLOW_60_in_durationConstraint2365); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal275_tree = (Object)adaptor.create(char_literal275);
					adaptor.addChild(root_0, char_literal275_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:388:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2370);
					simpleDurationConstraint276=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint276.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:391:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal277=null;
		Token string_literal279=null;
		Token char_literal281=null;
		Token char_literal282=null;
		Token string_literal283=null;
		Token char_literal286=null;
		ParserRuleReturnScope durOp278 =null;
		ParserRuleReturnScope durValue280 =null;
		ParserRuleReturnScope timeSpecifier284 =null;
		ParserRuleReturnScope simpleDurationConstraint285 =null;

		Object char_literal277_tree=null;
		Object string_literal279_tree=null;
		Object char_literal281_tree=null;
		Object char_literal282_tree=null;
		Object string_literal283_tree=null;
		Object char_literal286_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:392:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==59) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==97) ) {
					alt58=2;
				}
				else if ( ((LA58_1 >= 87 && LA58_1 <= 88)||LA58_1==90) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:392:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal277=(Token)match(input,59,FOLLOW_59_in_simpleDurationConstraint2381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal277_tree = (Object)adaptor.create(char_literal277);
					adaptor.addChild(root_0, char_literal277_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2383);
					durOp278=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp278.getTree());

					string_literal279=(Token)match(input,91,FOLLOW_91_in_simpleDurationConstraint2385); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal279_tree = (Object)adaptor.create(string_literal279);
					adaptor.addChild(root_0, string_literal279_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2387);
					durValue280=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue280.getTree());

					char_literal281=(Token)match(input,60,FOLLOW_60_in_simpleDurationConstraint2389); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal281_tree = (Object)adaptor.create(char_literal281);
					adaptor.addChild(root_0, char_literal281_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:393:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal282=(Token)match(input,59,FOLLOW_59_in_simpleDurationConstraint2394); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal282_tree = (Object)adaptor.create(char_literal282);
					adaptor.addChild(root_0, char_literal282_tree);
					}

					string_literal283=(Token)match(input,97,FOLLOW_97_in_simpleDurationConstraint2396); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal283_tree = (Object)adaptor.create(string_literal283);
					adaptor.addChild(root_0, string_literal283_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2398);
					timeSpecifier284=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier284.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2400);
					simpleDurationConstraint285=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint285.getTree());

					char_literal286=(Token)match(input,60,FOLLOW_60_in_simpleDurationConstraint2402); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal286_tree = (Object)adaptor.create(char_literal286);
					adaptor.addChild(root_0, char_literal286_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:396:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set287=null;

		Object set287_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:396:7: ( '<=' | '>=' | '=' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set287=input.LT(1);
			if ( (input.LA(1) >= 87 && input.LA(1) <= 88)||input.LA(1)==90 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set287));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER288=null;
		ParserRuleReturnScope fExp289 =null;

		Object NUMBER288_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:10: ( NUMBER | fExp )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==NUMBER) ) {
				int LA59_1 = input.LA(2);
				if ( (synpred91_Pddl()) ) {
					alt59=1;
				}
				else if ( (true) ) {
					alt59=2;
				}

			}
			else if ( (LA59_0==NAME||LA59_0==59) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER288=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2429); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER288_tree = (Object)adaptor.create(NUMBER288);
					adaptor.addChild(root_0, NUMBER288_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2433);
					fExp289=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp289.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:400:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal290=null;
		Token string_literal291=null;
		Token char_literal293=null;
		Token char_literal295=null;
		Token string_literal296=null;
		Token char_literal297=null;
		Token char_literal299=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token string_literal303=null;
		Token char_literal306=null;
		Token char_literal307=null;
		Token char_literal311=null;
		ParserRuleReturnScope daEffect292 =null;
		ParserRuleReturnScope timedEffect294 =null;
		ParserRuleReturnScope typedVariableList298 =null;
		ParserRuleReturnScope daEffect300 =null;
		ParserRuleReturnScope daGD304 =null;
		ParserRuleReturnScope timedEffect305 =null;
		ParserRuleReturnScope assignOp308 =null;
		ParserRuleReturnScope fHead309 =null;
		ParserRuleReturnScope fExpDA310 =null;

		Object char_literal290_tree=null;
		Object string_literal291_tree=null;
		Object char_literal293_tree=null;
		Object char_literal295_tree=null;
		Object string_literal296_tree=null;
		Object char_literal297_tree=null;
		Object char_literal299_tree=null;
		Object char_literal301_tree=null;
		Object char_literal302_tree=null;
		Object string_literal303_tree=null;
		Object char_literal306_tree=null;
		Object char_literal307_tree=null;
		Object char_literal311_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt61=5;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==59) ) {
				int LA61_1 = input.LA(2);
				if ( (synpred93_Pddl()) ) {
					alt61=1;
				}
				else if ( (synpred94_Pddl()) ) {
					alt61=2;
				}
				else if ( (synpred95_Pddl()) ) {
					alt61=3;
				}
				else if ( (synpred96_Pddl()) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal290=(Token)match(input,59,FOLLOW_59_in_daEffect2443); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal290_tree = (Object)adaptor.create(char_literal290);
					adaptor.addChild(root_0, char_literal290_tree);
					}

					string_literal291=(Token)match(input,95,FOLLOW_95_in_daEffect2445); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal291_tree = (Object)adaptor.create(string_literal291);
					adaptor.addChild(root_0, string_literal291_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:14: ( daEffect )*
					loop60:
					while (true) {
						int alt60=2;
						int LA60_0 = input.LA(1);
						if ( (LA60_0==59) ) {
							alt60=1;
						}

						switch (alt60) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2447);
							daEffect292=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect292.getTree());

							}
							break;

						default :
							break loop60;
						}
					}

					char_literal293=(Token)match(input,60,FOLLOW_60_in_daEffect2450); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal293_tree = (Object)adaptor.create(char_literal293);
					adaptor.addChild(root_0, char_literal293_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:402:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2455);
					timedEffect294=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect294.getTree());

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:403:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal295=(Token)match(input,59,FOLLOW_59_in_daEffect2460); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal295_tree = (Object)adaptor.create(char_literal295);
					adaptor.addChild(root_0, char_literal295_tree);
					}

					string_literal296=(Token)match(input,105,FOLLOW_105_in_daEffect2462); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal296_tree = (Object)adaptor.create(string_literal296);
					adaptor.addChild(root_0, string_literal296_tree);
					}

					char_literal297=(Token)match(input,59,FOLLOW_59_in_daEffect2464); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal297_tree = (Object)adaptor.create(char_literal297);
					adaptor.addChild(root_0, char_literal297_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2466);
					typedVariableList298=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList298.getTree());

					char_literal299=(Token)match(input,60,FOLLOW_60_in_daEffect2468); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal299_tree = (Object)adaptor.create(char_literal299);
					adaptor.addChild(root_0, char_literal299_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2470);
					daEffect300=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect300.getTree());

					char_literal301=(Token)match(input,60,FOLLOW_60_in_daEffect2472); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:404:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal302=(Token)match(input,59,FOLLOW_59_in_daEffect2477); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal302_tree = (Object)adaptor.create(char_literal302);
					adaptor.addChild(root_0, char_literal302_tree);
					}

					string_literal303=(Token)match(input,125,FOLLOW_125_in_daEffect2479); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal303_tree = (Object)adaptor.create(string_literal303);
					adaptor.addChild(root_0, string_literal303_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2481);
					daGD304=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD304.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2483);
					timedEffect305=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect305.getTree());

					char_literal306=(Token)match(input,60,FOLLOW_60_in_daEffect2485); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal306_tree = (Object)adaptor.create(char_literal306);
					adaptor.addChild(root_0, char_literal306_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:405:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal307=(Token)match(input,59,FOLLOW_59_in_daEffect2490); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal307_tree = (Object)adaptor.create(char_literal307);
					adaptor.addChild(root_0, char_literal307_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2492);
					assignOp308=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp308.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2494);
					fHead309=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead309.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2496);
					fExpDA310=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA310.getTree());

					char_literal311=(Token)match(input,60,FOLLOW_60_in_daEffect2498); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal311_tree = (Object)adaptor.create(char_literal311);
					adaptor.addChild(root_0, char_literal311_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:408:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal312=null;
		Token string_literal313=null;
		Token char_literal316=null;
		Token char_literal317=null;
		Token string_literal318=null;
		Token char_literal321=null;
		Token char_literal322=null;
		Token char_literal326=null;
		ParserRuleReturnScope timeSpecifier314 =null;
		ParserRuleReturnScope daEffect315 =null;
		ParserRuleReturnScope timeSpecifier319 =null;
		ParserRuleReturnScope fAssignDA320 =null;
		ParserRuleReturnScope assignOp323 =null;
		ParserRuleReturnScope fHead324 =null;
		ParserRuleReturnScope fExp325 =null;

		Object char_literal312_tree=null;
		Object string_literal313_tree=null;
		Object char_literal316_tree=null;
		Object char_literal317_tree=null;
		Object string_literal318_tree=null;
		Object char_literal321_tree=null;
		Object char_literal322_tree=null;
		Object char_literal326_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt62=3;
			int LA62_0 = input.LA(1);
			if ( (LA62_0==59) ) {
				int LA62_1 = input.LA(2);
				if ( (synpred97_Pddl()) ) {
					alt62=1;
				}
				else if ( (synpred98_Pddl()) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal312=(Token)match(input,59,FOLLOW_59_in_timedEffect2509); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal312_tree = (Object)adaptor.create(char_literal312);
					adaptor.addChild(root_0, char_literal312_tree);
					}

					string_literal313=(Token)match(input,97,FOLLOW_97_in_timedEffect2511); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal313_tree = (Object)adaptor.create(string_literal313);
					adaptor.addChild(root_0, string_literal313_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2513);
					timeSpecifier314=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier314.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2515);
					daEffect315=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect315.getTree());

					char_literal316=(Token)match(input,60,FOLLOW_60_in_timedEffect2517); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal316_tree = (Object)adaptor.create(char_literal316);
					adaptor.addChild(root_0, char_literal316_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:410:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal317=(Token)match(input,59,FOLLOW_59_in_timedEffect2527); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal317_tree = (Object)adaptor.create(char_literal317);
					adaptor.addChild(root_0, char_literal317_tree);
					}

					string_literal318=(Token)match(input,97,FOLLOW_97_in_timedEffect2529); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal318_tree = (Object)adaptor.create(string_literal318);
					adaptor.addChild(root_0, string_literal318_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2531);
					timeSpecifier319=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier319.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2533);
					fAssignDA320=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA320.getTree());

					char_literal321=(Token)match(input,60,FOLLOW_60_in_timedEffect2535); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal321_tree = (Object)adaptor.create(char_literal321);
					adaptor.addChild(root_0, char_literal321_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:411:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal322=(Token)match(input,59,FOLLOW_59_in_timedEffect2540); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal322_tree = (Object)adaptor.create(char_literal322);
					adaptor.addChild(root_0, char_literal322_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2542);
					assignOp323=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp323.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2544);
					fHead324=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead324.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2546);
					fExp325=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp325.getTree());

					char_literal326=(Token)match(input,60,FOLLOW_60_in_timedEffect2548); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal326_tree = (Object)adaptor.create(char_literal326);
					adaptor.addChild(root_0, char_literal326_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:414:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal327=null;
		Token char_literal331=null;
		ParserRuleReturnScope assignOp328 =null;
		ParserRuleReturnScope fHead329 =null;
		ParserRuleReturnScope fExpDA330 =null;

		Object char_literal327_tree=null;
		Object char_literal331_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:415:2: ( '(' assignOp fHead fExpDA ')' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:415:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal327=(Token)match(input,59,FOLLOW_59_in_fAssignDA2568); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal327_tree = (Object)adaptor.create(char_literal327);
			adaptor.addChild(root_0, char_literal327_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2570);
			assignOp328=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp328.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2572);
			fHead329=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead329.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2574);
			fExpDA330=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA330.getTree());

			char_literal331=(Token)match(input,60,FOLLOW_60_in_fAssignDA2576); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal331_tree = (Object)adaptor.create(char_literal331);
			adaptor.addChild(root_0, char_literal331_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:418:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal332=null;
		Token char_literal336=null;
		Token char_literal338=null;
		Token string_literal339=null;
		ParserRuleReturnScope binaryOp333 =null;
		ParserRuleReturnScope fExpDA334 =null;
		ParserRuleReturnScope fExpDA335 =null;
		ParserRuleReturnScope fExpDA337 =null;
		ParserRuleReturnScope fExp340 =null;

		Object char_literal332_tree=null;
		Object char_literal336_tree=null;
		Object char_literal338_tree=null;
		Object string_literal339_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt64=3;
			switch ( input.LA(1) ) {
			case 59:
				{
				int LA64_1 = input.LA(2);
				if ( (synpred100_Pddl()) ) {
					alt64=1;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case 91:
				{
				alt64=2;
				}
				break;
			case NAME:
			case NUMBER:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal332=(Token)match(input,59,FOLLOW_59_in_fExpDA2587); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal332_tree = (Object)adaptor.create(char_literal332);
					adaptor.addChild(root_0, char_literal332_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==63) ) {
						int LA63_1 = input.LA(2);
						if ( (synpred99_Pddl()) ) {
							alt63=1;
						}
						else if ( (true) ) {
							alt63=2;
						}

					}
					else if ( ((LA63_0 >= 61 && LA63_0 <= 62)||LA63_0==64) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2591);
							binaryOp333=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp333.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2593);
							fExpDA334=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA334.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2595);
							fExpDA335=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA335.getTree());

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:36: ( '-' fExpDA )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:36: ( '-' fExpDA )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:37: '-' fExpDA
							{
							char_literal336=(Token)match(input,63,FOLLOW_63_in_fExpDA2601); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal336_tree = (Object)adaptor.create(char_literal336);
							adaptor.addChild(root_0, char_literal336_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2603);
							fExpDA337=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA337.getTree());

							}

							}
							break;

					}

					char_literal338=(Token)match(input,60,FOLLOW_60_in_fExpDA2607); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal338_tree = (Object)adaptor.create(char_literal338);
					adaptor.addChild(root_0, char_literal338_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:420:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal339=(Token)match(input,91,FOLLOW_91_in_fExpDA2612); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal339_tree = (Object)adaptor.create(string_literal339);
					adaptor.addChild(root_0, string_literal339_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:421:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA2617);
					fExp340=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp340.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:426:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal341=null;
		Token string_literal342=null;
		Token char_literal351=null;
		ParserRuleReturnScope problemDecl343 =null;
		ParserRuleReturnScope problemDomain344 =null;
		ParserRuleReturnScope requireDef345 =null;
		ParserRuleReturnScope objectDecl346 =null;
		ParserRuleReturnScope init347 =null;
		ParserRuleReturnScope goal348 =null;
		ParserRuleReturnScope probConstraints349 =null;
		ParserRuleReturnScope metricSpec350 =null;

		Object char_literal341_tree=null;
		Object string_literal342_tree=null;
		Object char_literal351_tree=null;
		RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:427:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:427:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal341=(Token)match(input,59,FOLLOW_59_in_problem2631); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal341);

			string_literal342=(Token)match(input,100,FOLLOW_100_in_problem2633); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_100.add(string_literal342);

			pushFollow(FOLLOW_problemDecl_in_problem2635);
			problemDecl343=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl343.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem2640);
			problemDomain344=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain344.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:429:7: ( requireDef )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==59) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==84) ) {
					alt65=1;
				}
			}
			switch (alt65) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:429:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem2648);
					requireDef345=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef345.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:430:7: ( objectDecl )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==59) ) {
				int LA66_1 = input.LA(2);
				if ( (LA66_1==80) ) {
					alt66=1;
				}
			}
			switch (alt66) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:430:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem2657);
					objectDecl346=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl346.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem2666);
			init347=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init347.getTree());
			pushFollow(FOLLOW_goal_in_problem2674);
			goal348=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal348.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:433:7: ( probConstraints )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==59) ) {
				int LA67_1 = input.LA(2);
				if ( (LA67_1==69) ) {
					alt67=1;
				}
			}
			switch (alt67) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:433:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem2682);
					probConstraints349=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints349.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:434:7: ( metricSpec )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==59) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:434:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem2691);
					metricSpec350=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec350.getTree());
					}
					break;

			}

			char_literal351=(Token)match(input,60,FOLLOW_60_in_problem2707); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal351);

			// AST REWRITE
			// elements: problemDecl, problemDomain, objectDecl, probConstraints, requireDef, init, metricSpec, goal
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 437:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:437:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:437:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:437:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:438:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:438:36: ( metricSpec )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:441:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal352=null;
		Token string_literal353=null;
		Token NAME354=null;
		Token char_literal355=null;

		Object char_literal352_tree=null;
		Object string_literal353_tree=null;
		Object NAME354_tree=null;
		Object char_literal355_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:442:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:442:7: '(' 'problem' NAME ')'
			{
			char_literal352=(Token)match(input,59,FOLLOW_59_in_problemDecl2764); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal352);

			string_literal353=(Token)match(input,118,FOLLOW_118_in_problemDecl2766); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_118.add(string_literal353);

			NAME354=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2768); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME354);

			char_literal355=(Token)match(input,60,FOLLOW_60_in_problemDecl2770); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal355);

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
			// 443:5: -> ^( PROBLEM_NAME NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:443:8: ^( PROBLEM_NAME NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:446:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal356=null;
		Token string_literal357=null;
		Token NAME358=null;
		Token char_literal359=null;

		Object char_literal356_tree=null;
		Object string_literal357_tree=null;
		Object NAME358_tree=null;
		Object char_literal359_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:447:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:447:4: '(' ':domain' NAME ')'
			{
			char_literal356=(Token)match(input,59,FOLLOW_59_in_problemDomain2796); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal356);

			string_literal357=(Token)match(input,71,FOLLOW_71_in_problemDomain2798); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_71.add(string_literal357);

			NAME358=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain2800); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME358);

			char_literal359=(Token)match(input,60,FOLLOW_60_in_problemDomain2802); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal359);

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
			// 448:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:448:5: ^( PROBLEM_DOMAIN NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:451:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal360=null;
		Token string_literal361=null;
		Token char_literal363=null;
		ParserRuleReturnScope typedNameList362 =null;

		Object char_literal360_tree=null;
		Object string_literal361_tree=null;
		Object char_literal363_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:452:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:452:4: '(' ':objects' typedNameList ')'
			{
			char_literal360=(Token)match(input,59,FOLLOW_59_in_objectDecl2822); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal360);

			string_literal361=(Token)match(input,80,FOLLOW_80_in_objectDecl2824); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal361);

			pushFollow(FOLLOW_typedNameList_in_objectDecl2826);
			typedNameList362=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList362.getTree());
			char_literal363=(Token)match(input,60,FOLLOW_60_in_objectDecl2828); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal363);

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
			// 453:2: -> ^( OBJECTS typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:453:5: ^( OBJECTS typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:456:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal364=null;
		Token string_literal365=null;
		Token char_literal367=null;
		ParserRuleReturnScope initEl366 =null;

		Object char_literal364_tree=null;
		Object string_literal365_tree=null;
		Object char_literal367_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:457:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:457:4: '(' ':init' ( initEl )* ')'
			{
			char_literal364=(Token)match(input,59,FOLLOW_59_in_init2848); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal364);

			string_literal365=(Token)match(input,78,FOLLOW_78_in_init2850); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal365);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:457:16: ( initEl )*
			loop69:
			while (true) {
				int alt69=2;
				int LA69_0 = input.LA(1);
				if ( (LA69_0==59) ) {
					alt69=1;
				}

				switch (alt69) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:457:16: initEl
					{
					pushFollow(FOLLOW_initEl_in_init2852);
					initEl366=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl366.getTree());
					}
					break;

				default :
					break loop69;
				}
			}

			char_literal367=(Token)match(input,60,FOLLOW_60_in_init2855); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal367);

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
			// 458:2: -> ^( INIT ( initEl )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:458:5: ^( INIT ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:458:12: ( initEl )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:461:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal369=null;
		Token char_literal370=null;
		Token NUMBER372=null;
		Token char_literal373=null;
		Token char_literal374=null;
		Token string_literal375=null;
		Token NUMBER376=null;
		Token char_literal378=null;
		ParserRuleReturnScope nameLiteral368 =null;
		ParserRuleReturnScope fHead371 =null;
		ParserRuleReturnScope nameLiteral377 =null;

		Object char_literal369_tree=null;
		Object char_literal370_tree=null;
		Object NUMBER372_tree=null;
		Object char_literal373_tree=null;
		Object char_literal374_tree=null;
		Object string_literal375_tree=null;
		Object NUMBER376_tree=null;
		Object char_literal378_tree=null;
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
			int alt70=3;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==59) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 113:
					{
					alt70=1;
					}
					break;
				case 88:
					{
					alt70=2;
					}
					break;
				case 97:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl2876);
					nameLiteral368=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral368.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:463:4: '(' '=' fHead NUMBER ')'
					{
					char_literal369=(Token)match(input,59,FOLLOW_59_in_initEl2881); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal369);

					char_literal370=(Token)match(input,88,FOLLOW_88_in_initEl2883); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_88.add(char_literal370);

					pushFollow(FOLLOW_fHead_in_initEl2885);
					fHead371=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead371.getTree());
					NUMBER372=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2887); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER372);

					char_literal373=(Token)match(input,60,FOLLOW_60_in_initEl2889); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal373);

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
					// 463:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:463:40: ^( INIT_EQ fHead NUMBER )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:464:4: '(' 'at' NUMBER nameLiteral ')'
					{
					char_literal374=(Token)match(input,59,FOLLOW_59_in_initEl2912); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal374);

					string_literal375=(Token)match(input,97,FOLLOW_97_in_initEl2914); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_97.add(string_literal375);

					NUMBER376=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2916); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER376);

					pushFollow(FOLLOW_nameLiteral_in_initEl2918);
					nameLiteral377=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral377.getTree());
					char_literal378=(Token)match(input,60,FOLLOW_60_in_initEl2920); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal378);

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
					// 464:37: -> ^( INIT_AT NUMBER nameLiteral )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:464:40: ^( INIT_AT NUMBER nameLiteral )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:467:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal380=null;
		Token string_literal381=null;
		Token char_literal383=null;
		ParserRuleReturnScope atomicNameFormula379 =null;
		ParserRuleReturnScope atomicNameFormula382 =null;

		Object char_literal380_tree=null;
		Object string_literal381_tree=null;
		Object char_literal383_tree=null;
		RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:468:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==59) ) {
				int LA71_1 = input.LA(2);
				if ( (LA71_1==113) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:468:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2942);
					atomicNameFormula379=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula379.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:469:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal380=(Token)match(input,59,FOLLOW_59_in_nameLiteral2947); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal380);

					string_literal381=(Token)match(input,113,FOLLOW_113_in_nameLiteral2949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_113.add(string_literal381);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2951);
					atomicNameFormula382=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula382.getTree());
					char_literal383=(Token)match(input,60,FOLLOW_60_in_nameLiteral2953); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal383);

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
					// 469:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:469:39: ^( NOT_PRED_INIT atomicNameFormula )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal384=null;
		Token NAME386=null;
		Token char_literal387=null;
		ParserRuleReturnScope predicate385 =null;

		Object char_literal384_tree=null;
		Object NAME386_tree=null;
		Object char_literal387_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:4: '(' predicate ( NAME )* ')'
			{
			char_literal384=(Token)match(input,59,FOLLOW_59_in_atomicNameFormula2972); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal384);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula2974);
			predicate385=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate385.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:18: ( NAME )*
			loop72:
			while (true) {
				int alt72=2;
				int LA72_0 = input.LA(1);
				if ( (LA72_0==NAME) ) {
					alt72=1;
				}

				switch (alt72) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:18: NAME
					{
					NAME386=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula2976); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME386);

					}
					break;

				default :
					break loop72;
				}
			}

			char_literal387=(Token)match(input,60,FOLLOW_60_in_atomicNameFormula2979); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal387);

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
			// 473:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:53: ( NAME )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:480:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal388=null;
		Token string_literal389=null;
		Token char_literal391=null;
		ParserRuleReturnScope goalDesc390 =null;

		Object char_literal388_tree=null;
		Object string_literal389_tree=null;
		Object char_literal391_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:480:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:480:8: '(' ':goal' goalDesc ')'
			{
			char_literal388=(Token)match(input,59,FOLLOW_59_in_goal3004); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal388);

			string_literal389=(Token)match(input,77,FOLLOW_77_in_goal3006); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_77.add(string_literal389);

			pushFollow(FOLLOW_goalDesc_in_goal3008);
			goalDesc390=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc390.getTree());
			char_literal391=(Token)match(input,60,FOLLOW_60_in_goal3010); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal391);

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
			// 480:33: -> ^( GOAL goalDesc )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:480:36: ^( GOAL goalDesc )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:482:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal392=null;
		Token string_literal393=null;
		Token char_literal395=null;
		ParserRuleReturnScope prefConGD394 =null;

		Object char_literal392_tree=null;
		Object string_literal393_tree=null;
		Object char_literal395_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:483:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:483:4: '(' ':constraints' prefConGD ')'
			{
			char_literal392=(Token)match(input,59,FOLLOW_59_in_probConstraints3028); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal392);

			string_literal393=(Token)match(input,69,FOLLOW_69_in_probConstraints3030); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_69.add(string_literal393);

			pushFollow(FOLLOW_prefConGD_in_probConstraints3033);
			prefConGD394=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD394.getTree());
			char_literal395=(Token)match(input,60,FOLLOW_60_in_probConstraints3035); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal395);

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
			// 484:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:484:7: ^( PROBLEM_CONSTRAINT prefConGD )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:487:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal396=null;
		Token string_literal397=null;
		Token char_literal399=null;
		Token char_literal400=null;
		Token string_literal401=null;
		Token char_literal402=null;
		Token char_literal404=null;
		Token char_literal406=null;
		Token char_literal407=null;
		Token string_literal408=null;
		Token NAME409=null;
		Token char_literal411=null;
		ParserRuleReturnScope prefConGD398 =null;
		ParserRuleReturnScope typedVariableList403 =null;
		ParserRuleReturnScope prefConGD405 =null;
		ParserRuleReturnScope conGD410 =null;
		ParserRuleReturnScope conGD412 =null;

		Object char_literal396_tree=null;
		Object string_literal397_tree=null;
		Object char_literal399_tree=null;
		Object char_literal400_tree=null;
		Object string_literal401_tree=null;
		Object char_literal402_tree=null;
		Object char_literal404_tree=null;
		Object char_literal406_tree=null;
		Object char_literal407_tree=null;
		Object string_literal408_tree=null;
		Object NAME409_tree=null;
		Object char_literal411_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt75=4;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==59) ) {
				int LA75_1 = input.LA(2);
				if ( (synpred112_Pddl()) ) {
					alt75=1;
				}
				else if ( (synpred113_Pddl()) ) {
					alt75=2;
				}
				else if ( (synpred115_Pddl()) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal396=(Token)match(input,59,FOLLOW_59_in_prefConGD3057); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal396_tree = (Object)adaptor.create(char_literal396);
					adaptor.addChild(root_0, char_literal396_tree);
					}

					string_literal397=(Token)match(input,95,FOLLOW_95_in_prefConGD3059); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal397_tree = (Object)adaptor.create(string_literal397);
					adaptor.addChild(root_0, string_literal397_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:14: ( prefConGD )*
					loop73:
					while (true) {
						int alt73=2;
						int LA73_0 = input.LA(1);
						if ( (LA73_0==59) ) {
							alt73=1;
						}

						switch (alt73) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD3061);
							prefConGD398=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD398.getTree());

							}
							break;

						default :
							break loop73;
						}
					}

					char_literal399=(Token)match(input,60,FOLLOW_60_in_prefConGD3064); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal399_tree = (Object)adaptor.create(char_literal399);
					adaptor.addChild(root_0, char_literal399_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:489:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal400=(Token)match(input,59,FOLLOW_59_in_prefConGD3069); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal400_tree = (Object)adaptor.create(char_literal400);
					adaptor.addChild(root_0, char_literal400_tree);
					}

					string_literal401=(Token)match(input,105,FOLLOW_105_in_prefConGD3071); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal401_tree = (Object)adaptor.create(string_literal401);
					adaptor.addChild(root_0, string_literal401_tree);
					}

					char_literal402=(Token)match(input,59,FOLLOW_59_in_prefConGD3073); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal402_tree = (Object)adaptor.create(char_literal402);
					adaptor.addChild(root_0, char_literal402_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD3075);
					typedVariableList403=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList403.getTree());

					char_literal404=(Token)match(input,60,FOLLOW_60_in_prefConGD3077); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal404_tree = (Object)adaptor.create(char_literal404);
					adaptor.addChild(root_0, char_literal404_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD3079);
					prefConGD405=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD405.getTree());

					char_literal406=(Token)match(input,60,FOLLOW_60_in_prefConGD3081); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal406_tree = (Object)adaptor.create(char_literal406);
					adaptor.addChild(root_0, char_literal406_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal407=(Token)match(input,59,FOLLOW_59_in_prefConGD3086); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal407_tree = (Object)adaptor.create(char_literal407);
					adaptor.addChild(root_0, char_literal407_tree);
					}

					string_literal408=(Token)match(input,117,FOLLOW_117_in_prefConGD3088); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal408_tree = (Object)adaptor.create(string_literal408);
					adaptor.addChild(root_0, string_literal408_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:21: ( NAME )?
					int alt74=2;
					int LA74_0 = input.LA(1);
					if ( (LA74_0==NAME) ) {
						alt74=1;
					}
					switch (alt74) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:21: NAME
							{
							NAME409=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3090); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME409_tree = (Object)adaptor.create(NAME409);
							adaptor.addChild(root_0, NAME409_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD3093);
					conGD410=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD410.getTree());

					char_literal411=(Token)match(input,60,FOLLOW_60_in_prefConGD3095); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal411_tree = (Object)adaptor.create(char_literal411);
					adaptor.addChild(root_0, char_literal411_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:491:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD3100);
					conGD412=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD412.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:494:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal413=null;
		Token string_literal414=null;
		Token char_literal417=null;
		ParserRuleReturnScope optimization415 =null;
		ParserRuleReturnScope metricFExp416 =null;

		Object char_literal413_tree=null;
		Object string_literal414_tree=null;
		Object char_literal417_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:495:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:495:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal413=(Token)match(input,59,FOLLOW_59_in_metricSpec3111); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(char_literal413);

			string_literal414=(Token)match(input,79,FOLLOW_79_in_metricSpec3113); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_79.add(string_literal414);

			pushFollow(FOLLOW_optimization_in_metricSpec3115);
			optimization415=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization415.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec3117);
			metricFExp416=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp416.getTree());
			char_literal417=(Token)match(input,60,FOLLOW_60_in_metricSpec3119); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_60.add(char_literal417);

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
			// 496:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:496:7: ^( PROBLEM_METRIC optimization metricFExp )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set418=null;

		Object set418_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:14: ( 'minimize' | 'maximize' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set418=input.LT(1);
			if ( (input.LA(1) >= 111 && input.LA(1) <= 112) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set418));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:501:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal419=null;
		Token char_literal423=null;
		Token char_literal424=null;
		Token char_literal428=null;
		Token char_literal429=null;
		Token char_literal430=null;
		Token char_literal432=null;
		Token NUMBER433=null;
		Token char_literal435=null;
		Token string_literal436=null;
		Token NAME437=null;
		Token char_literal438=null;
		ParserRuleReturnScope binaryOp420 =null;
		ParserRuleReturnScope metricFExp421 =null;
		ParserRuleReturnScope metricFExp422 =null;
		ParserRuleReturnScope multiOp425 =null;
		ParserRuleReturnScope metricFExp426 =null;
		ParserRuleReturnScope metricFExp427 =null;
		ParserRuleReturnScope metricFExp431 =null;
		ParserRuleReturnScope fHead434 =null;

		Object char_literal419_tree=null;
		Object char_literal423_tree=null;
		Object char_literal424_tree=null;
		Object char_literal428_tree=null;
		Object char_literal429_tree=null;
		Object char_literal430_tree=null;
		Object char_literal432_tree=null;
		Object NUMBER433_tree=null;
		Object char_literal435_tree=null;
		Object string_literal436_tree=null;
		Object NAME437_tree=null;
		Object char_literal438_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:502:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt77=6;
			switch ( input.LA(1) ) {
			case 59:
				{
				int LA77_1 = input.LA(2);
				if ( (synpred117_Pddl()) ) {
					alt77=1;
				}
				else if ( (synpred119_Pddl()) ) {
					alt77=2;
				}
				else if ( (synpred120_Pddl()) ) {
					alt77=3;
				}
				else if ( (synpred122_Pddl()) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:502:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal419=(Token)match(input,59,FOLLOW_59_in_metricFExp3156); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal419);

					pushFollow(FOLLOW_binaryOp_in_metricFExp3158);
					binaryOp420=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp420.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3160);
					metricFExp421=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp421.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3162);
					metricFExp422=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp422.getTree());
					char_literal423=(Token)match(input,60,FOLLOW_60_in_metricFExp3164); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal423);

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
					// 503:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:503:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal424=(Token)match(input,59,FOLLOW_59_in_metricFExp3186); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal424);

					pushFollow(FOLLOW_multiOp_in_metricFExp3188);
					multiOp425=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp425.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3190);
					metricFExp426=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp426.getTree());
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:27: ( metricFExp )+
					int cnt76=0;
					loop76:
					while (true) {
						int alt76=2;
						int LA76_0 = input.LA(1);
						if ( (LA76_0==NAME||LA76_0==NUMBER||LA76_0==59) ) {
							alt76=1;
						}

						switch (alt76) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3192);
							metricFExp427=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp427.getTree());
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

					char_literal428=(Token)match(input,60,FOLLOW_60_in_metricFExp3195); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal428);

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
					// 505:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:505:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:506:4: '(' '-' metricFExp ')'
					{
					char_literal429=(Token)match(input,59,FOLLOW_59_in_metricFExp3219); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_59.add(char_literal429);

					char_literal430=(Token)match(input,63,FOLLOW_63_in_metricFExp3221); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal430);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3223);
					metricFExp431=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp431.getTree());
					char_literal432=(Token)match(input,60,FOLLOW_60_in_metricFExp3225); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_60.add(char_literal432);

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
					// 507:4: -> ^( MINUS_OP metricFExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:507:7: ^( MINUS_OP metricFExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:508:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER433=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3242); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER433_tree = (Object)adaptor.create(NUMBER433);
					adaptor.addChild(root_0, NUMBER433_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:509:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3247);
					fHead434=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead434.getTree());

					}
					break;
				case 6 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:511:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal435=(Token)match(input,59,FOLLOW_59_in_metricFExp3262); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal435_tree = (Object)adaptor.create(char_literal435);
					adaptor.addChild(root_0, char_literal435_tree);
					}

					string_literal436=(Token)match(input,110,FOLLOW_110_in_metricFExp3264); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal436_tree = (Object)adaptor.create(string_literal436);
					adaptor.addChild(root_0, string_literal436_tree);
					}

					NAME437=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3266); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME437_tree = (Object)adaptor.create(NAME437);
					adaptor.addChild(root_0, NAME437_tree);
					}

					char_literal438=(Token)match(input,60,FOLLOW_60_in_metricFExp3268); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal438_tree = (Object)adaptor.create(char_literal438);
					adaptor.addChild(root_0, char_literal438_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:516:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal439=null;
		Token string_literal440=null;
		Token char_literal442=null;
		Token char_literal443=null;
		Token string_literal444=null;
		Token char_literal445=null;
		Token char_literal447=null;
		Token char_literal449=null;
		Token char_literal450=null;
		Token string_literal451=null;
		Token string_literal452=null;
		Token char_literal454=null;
		Token char_literal455=null;
		Token string_literal456=null;
		Token char_literal458=null;
		Token char_literal459=null;
		Token string_literal460=null;
		Token char_literal462=null;
		Token char_literal463=null;
		Token string_literal464=null;
		Token NUMBER465=null;
		Token char_literal467=null;
		Token char_literal468=null;
		Token string_literal469=null;
		Token char_literal471=null;
		Token char_literal472=null;
		Token string_literal473=null;
		Token char_literal476=null;
		Token char_literal477=null;
		Token string_literal478=null;
		Token char_literal481=null;
		Token char_literal482=null;
		Token string_literal483=null;
		Token NUMBER484=null;
		Token char_literal487=null;
		Token char_literal488=null;
		Token string_literal489=null;
		Token NUMBER490=null;
		Token NUMBER491=null;
		Token char_literal493=null;
		Token char_literal494=null;
		Token string_literal495=null;
		Token NUMBER496=null;
		Token char_literal498=null;
		ParserRuleReturnScope conGD441 =null;
		ParserRuleReturnScope typedVariableList446 =null;
		ParserRuleReturnScope conGD448 =null;
		ParserRuleReturnScope goalDesc453 =null;
		ParserRuleReturnScope goalDesc457 =null;
		ParserRuleReturnScope goalDesc461 =null;
		ParserRuleReturnScope goalDesc466 =null;
		ParserRuleReturnScope goalDesc470 =null;
		ParserRuleReturnScope goalDesc474 =null;
		ParserRuleReturnScope goalDesc475 =null;
		ParserRuleReturnScope goalDesc479 =null;
		ParserRuleReturnScope goalDesc480 =null;
		ParserRuleReturnScope goalDesc485 =null;
		ParserRuleReturnScope goalDesc486 =null;
		ParserRuleReturnScope goalDesc492 =null;
		ParserRuleReturnScope goalDesc497 =null;

		Object char_literal439_tree=null;
		Object string_literal440_tree=null;
		Object char_literal442_tree=null;
		Object char_literal443_tree=null;
		Object string_literal444_tree=null;
		Object char_literal445_tree=null;
		Object char_literal447_tree=null;
		Object char_literal449_tree=null;
		Object char_literal450_tree=null;
		Object string_literal451_tree=null;
		Object string_literal452_tree=null;
		Object char_literal454_tree=null;
		Object char_literal455_tree=null;
		Object string_literal456_tree=null;
		Object char_literal458_tree=null;
		Object char_literal459_tree=null;
		Object string_literal460_tree=null;
		Object char_literal462_tree=null;
		Object char_literal463_tree=null;
		Object string_literal464_tree=null;
		Object NUMBER465_tree=null;
		Object char_literal467_tree=null;
		Object char_literal468_tree=null;
		Object string_literal469_tree=null;
		Object char_literal471_tree=null;
		Object char_literal472_tree=null;
		Object string_literal473_tree=null;
		Object char_literal476_tree=null;
		Object char_literal477_tree=null;
		Object string_literal478_tree=null;
		Object char_literal481_tree=null;
		Object char_literal482_tree=null;
		Object string_literal483_tree=null;
		Object NUMBER484_tree=null;
		Object char_literal487_tree=null;
		Object char_literal488_tree=null;
		Object string_literal489_tree=null;
		Object NUMBER490_tree=null;
		Object NUMBER491_tree=null;
		Object char_literal493_tree=null;
		Object char_literal494_tree=null;
		Object string_literal495_tree=null;
		Object NUMBER496_tree=null;
		Object char_literal498_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:517:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt79=12;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==59) ) {
				switch ( input.LA(2) ) {
				case 95:
					{
					alt79=1;
					}
					break;
				case 105:
					{
					alt79=2;
					}
					break;
				case 97:
					{
					alt79=3;
					}
					break;
				case 93:
					{
					alt79=4;
					}
					break;
				case 121:
					{
					alt79=5;
					}
					break;
				case 126:
					{
					alt79=6;
					}
					break;
				case 98:
					{
					alt79=7;
					}
					break;
				case 122:
					{
					alt79=8;
					}
					break;
				case 123:
					{
					alt79=9;
					}
					break;
				case 94:
					{
					alt79=10;
					}
					break;
				case 107:
					{
					alt79=11;
					}
					break;
				case 106:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:517:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal439=(Token)match(input,59,FOLLOW_59_in_conGD3282); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal439_tree = (Object)adaptor.create(char_literal439);
					adaptor.addChild(root_0, char_literal439_tree);
					}

					string_literal440=(Token)match(input,95,FOLLOW_95_in_conGD3284); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal440_tree = (Object)adaptor.create(string_literal440);
					adaptor.addChild(root_0, string_literal440_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:517:14: ( conGD )*
					loop78:
					while (true) {
						int alt78=2;
						int LA78_0 = input.LA(1);
						if ( (LA78_0==59) ) {
							alt78=1;
						}

						switch (alt78) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:517:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3286);
							conGD441=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD441.getTree());

							}
							break;

						default :
							break loop78;
						}
					}

					char_literal442=(Token)match(input,60,FOLLOW_60_in_conGD3289); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal442_tree = (Object)adaptor.create(char_literal442);
					adaptor.addChild(root_0, char_literal442_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:518:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal443=(Token)match(input,59,FOLLOW_59_in_conGD3294); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal443_tree = (Object)adaptor.create(char_literal443);
					adaptor.addChild(root_0, char_literal443_tree);
					}

					string_literal444=(Token)match(input,105,FOLLOW_105_in_conGD3296); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal444_tree = (Object)adaptor.create(string_literal444);
					adaptor.addChild(root_0, string_literal444_tree);
					}

					char_literal445=(Token)match(input,59,FOLLOW_59_in_conGD3298); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal445_tree = (Object)adaptor.create(char_literal445);
					adaptor.addChild(root_0, char_literal445_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3300);
					typedVariableList446=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList446.getTree());

					char_literal447=(Token)match(input,60,FOLLOW_60_in_conGD3302); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal447_tree = (Object)adaptor.create(char_literal447);
					adaptor.addChild(root_0, char_literal447_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3304);
					conGD448=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD448.getTree());

					char_literal449=(Token)match(input,60,FOLLOW_60_in_conGD3306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal449_tree = (Object)adaptor.create(char_literal449);
					adaptor.addChild(root_0, char_literal449_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:519:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal450=(Token)match(input,59,FOLLOW_59_in_conGD3311); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal450_tree = (Object)adaptor.create(char_literal450);
					adaptor.addChild(root_0, char_literal450_tree);
					}

					string_literal451=(Token)match(input,97,FOLLOW_97_in_conGD3313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal451_tree = (Object)adaptor.create(string_literal451);
					adaptor.addChild(root_0, string_literal451_tree);
					}

					string_literal452=(Token)match(input,103,FOLLOW_103_in_conGD3315); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal452_tree = (Object)adaptor.create(string_literal452);
					adaptor.addChild(root_0, string_literal452_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3317);
					goalDesc453=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc453.getTree());

					char_literal454=(Token)match(input,60,FOLLOW_60_in_conGD3319); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal454_tree = (Object)adaptor.create(char_literal454);
					adaptor.addChild(root_0, char_literal454_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:520:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal455=(Token)match(input,59,FOLLOW_59_in_conGD3345); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal455_tree = (Object)adaptor.create(char_literal455);
					adaptor.addChild(root_0, char_literal455_tree);
					}

					string_literal456=(Token)match(input,93,FOLLOW_93_in_conGD3347); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal456_tree = (Object)adaptor.create(string_literal456);
					adaptor.addChild(root_0, string_literal456_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3349);
					goalDesc457=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc457.getTree());

					char_literal458=(Token)match(input,60,FOLLOW_60_in_conGD3351); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal458_tree = (Object)adaptor.create(char_literal458);
					adaptor.addChild(root_0, char_literal458_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:521:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal459=(Token)match(input,59,FOLLOW_59_in_conGD3356); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal459_tree = (Object)adaptor.create(char_literal459);
					adaptor.addChild(root_0, char_literal459_tree);
					}

					string_literal460=(Token)match(input,121,FOLLOW_121_in_conGD3358); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal460_tree = (Object)adaptor.create(string_literal460);
					adaptor.addChild(root_0, string_literal460_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3360);
					goalDesc461=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc461.getTree());

					char_literal462=(Token)match(input,60,FOLLOW_60_in_conGD3362); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal462_tree = (Object)adaptor.create(char_literal462);
					adaptor.addChild(root_0, char_literal462_tree);
					}

					}
					break;
				case 6 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:522:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal463=(Token)match(input,59,FOLLOW_59_in_conGD3368); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal463_tree = (Object)adaptor.create(char_literal463);
					adaptor.addChild(root_0, char_literal463_tree);
					}

					string_literal464=(Token)match(input,126,FOLLOW_126_in_conGD3370); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal464_tree = (Object)adaptor.create(string_literal464);
					adaptor.addChild(root_0, string_literal464_tree);
					}

					NUMBER465=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3372); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER465_tree = (Object)adaptor.create(NUMBER465);
					adaptor.addChild(root_0, NUMBER465_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3374);
					goalDesc466=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc466.getTree());

					char_literal467=(Token)match(input,60,FOLLOW_60_in_conGD3376); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}

					}
					break;
				case 7 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:523:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal468=(Token)match(input,59,FOLLOW_59_in_conGD3381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal468_tree = (Object)adaptor.create(char_literal468);
					adaptor.addChild(root_0, char_literal468_tree);
					}

					string_literal469=(Token)match(input,98,FOLLOW_98_in_conGD3383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal469_tree = (Object)adaptor.create(string_literal469);
					adaptor.addChild(root_0, string_literal469_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3385);
					goalDesc470=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc470.getTree());

					char_literal471=(Token)match(input,60,FOLLOW_60_in_conGD3387); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal471_tree = (Object)adaptor.create(char_literal471);
					adaptor.addChild(root_0, char_literal471_tree);
					}

					}
					break;
				case 8 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:524:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal472=(Token)match(input,59,FOLLOW_59_in_conGD3392); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal472_tree = (Object)adaptor.create(char_literal472);
					adaptor.addChild(root_0, char_literal472_tree);
					}

					string_literal473=(Token)match(input,122,FOLLOW_122_in_conGD3394); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal473_tree = (Object)adaptor.create(string_literal473);
					adaptor.addChild(root_0, string_literal473_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3396);
					goalDesc474=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc474.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3398);
					goalDesc475=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc475.getTree());

					char_literal476=(Token)match(input,60,FOLLOW_60_in_conGD3400); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal476_tree = (Object)adaptor.create(char_literal476);
					adaptor.addChild(root_0, char_literal476_tree);
					}

					}
					break;
				case 9 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:525:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal477=(Token)match(input,59,FOLLOW_59_in_conGD3405); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal477_tree = (Object)adaptor.create(char_literal477);
					adaptor.addChild(root_0, char_literal477_tree);
					}

					string_literal478=(Token)match(input,123,FOLLOW_123_in_conGD3407); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal478_tree = (Object)adaptor.create(string_literal478);
					adaptor.addChild(root_0, string_literal478_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3409);
					goalDesc479=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc479.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3411);
					goalDesc480=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc480.getTree());

					char_literal481=(Token)match(input,60,FOLLOW_60_in_conGD3413); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal481_tree = (Object)adaptor.create(char_literal481);
					adaptor.addChild(root_0, char_literal481_tree);
					}

					}
					break;
				case 10 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:526:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal482=(Token)match(input,59,FOLLOW_59_in_conGD3418); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal482_tree = (Object)adaptor.create(char_literal482);
					adaptor.addChild(root_0, char_literal482_tree);
					}

					string_literal483=(Token)match(input,94,FOLLOW_94_in_conGD3420); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal483_tree = (Object)adaptor.create(string_literal483);
					adaptor.addChild(root_0, string_literal483_tree);
					}

					NUMBER484=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3422); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER484_tree = (Object)adaptor.create(NUMBER484);
					adaptor.addChild(root_0, NUMBER484_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3424);
					goalDesc485=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc485.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3426);
					goalDesc486=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc486.getTree());

					char_literal487=(Token)match(input,60,FOLLOW_60_in_conGD3428); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal487_tree = (Object)adaptor.create(char_literal487);
					adaptor.addChild(root_0, char_literal487_tree);
					}

					}
					break;
				case 11 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:527:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal488=(Token)match(input,59,FOLLOW_59_in_conGD3433); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal488_tree = (Object)adaptor.create(char_literal488);
					adaptor.addChild(root_0, char_literal488_tree);
					}

					string_literal489=(Token)match(input,107,FOLLOW_107_in_conGD3435); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal489_tree = (Object)adaptor.create(string_literal489);
					adaptor.addChild(root_0, string_literal489_tree);
					}

					NUMBER490=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3437); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER490_tree = (Object)adaptor.create(NUMBER490);
					adaptor.addChild(root_0, NUMBER490_tree);
					}

					NUMBER491=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3439); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER491_tree = (Object)adaptor.create(NUMBER491);
					adaptor.addChild(root_0, NUMBER491_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3441);
					goalDesc492=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc492.getTree());

					char_literal493=(Token)match(input,60,FOLLOW_60_in_conGD3443); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal493_tree = (Object)adaptor.create(char_literal493);
					adaptor.addChild(root_0, char_literal493_tree);
					}

					}
					break;
				case 12 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:528:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal494=(Token)match(input,59,FOLLOW_59_in_conGD3448); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal494_tree = (Object)adaptor.create(char_literal494);
					adaptor.addChild(root_0, char_literal494_tree);
					}

					string_literal495=(Token)match(input,106,FOLLOW_106_in_conGD3450); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal495_tree = (Object)adaptor.create(string_literal495);
					adaptor.addChild(root_0, string_literal495_tree);
					}

					NUMBER496=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3452); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER496_tree = (Object)adaptor.create(NUMBER496);
					adaptor.addChild(root_0, NUMBER496_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3454);
					goalDesc497=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc497.getTree());

					char_literal498=(Token)match(input,60,FOLLOW_60_in_conGD3456); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal498_tree = (Object)adaptor.create(char_literal498);
					adaptor.addChild(root_0, char_literal498_tree);
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
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:5: ( atomicFunctionSkeleton )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:158:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl788);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred45_Pddl
	public final void synpred45_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:268:7: ( fComp )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:268:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred45_Pddl1543);
		fComp();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred45_Pddl

	// $ANTLR start synpred48_Pddl
	public final void synpred48_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:28: ( typedVariableList )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred48_Pddl1703);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred48_Pddl

	// $ANTLR start synpred61_Pddl
	public final void synpred61_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:331:4: ( '(' binaryOp fExp fExp2 ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:331:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,59,FOLLOW_59_in_synpred61_Pddl1959); if (state.failed) return;
		pushFollow(FOLLOW_binaryOp_in_synpred61_Pddl1961);
		binaryOp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_fExp_in_synpred61_Pddl1963);
		fExp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_fExp2_in_synpred61_Pddl1965);
		fExp2();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred61_Pddl1967); if (state.failed) return;
		}

	}
	// $ANTLR end synpred61_Pddl

	// $ANTLR start synpred62_Pddl
	public final void synpred62_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:332:4: ( '(' '-' fExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:332:4: '(' '-' fExp ')'
		{
		match(input,59,FOLLOW_59_in_synpred62_Pddl1984); if (state.failed) return;
		match(input,63,FOLLOW_63_in_synpred62_Pddl1986); if (state.failed) return;
		pushFollow(FOLLOW_fExp_in_synpred62_Pddl1988);
		fExp();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred62_Pddl1990); if (state.failed) return;
		}

	}
	// $ANTLR end synpred62_Pddl

	// $ANTLR start synpred91_Pddl
	public final void synpred91_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:12: ( NUMBER )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:398:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred91_Pddl2429); if (state.failed) return;
		}

	}
	// $ANTLR end synpred91_Pddl

	// $ANTLR start synpred93_Pddl
	public final void synpred93_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: ( '(' 'and' ( daEffect )* ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,59,FOLLOW_59_in_synpred93_Pddl2443); if (state.failed) return;
		match(input,95,FOLLOW_95_in_synpred93_Pddl2445); if (state.failed) return;
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:14: ( daEffect )*
		loop96:
		while (true) {
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==59) ) {
				alt96=1;
			}

			switch (alt96) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred93_Pddl2447);
				daEffect();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop96;
			}
		}

		match(input,60,FOLLOW_60_in_synpred93_Pddl2450); if (state.failed) return;
		}

	}
	// $ANTLR end synpred93_Pddl

	// $ANTLR start synpred94_Pddl
	public final void synpred94_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:402:4: ( timedEffect )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:402:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred94_Pddl2455);
		timedEffect();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred94_Pddl

	// $ANTLR start synpred95_Pddl
	public final void synpred95_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:403:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:403:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,59,FOLLOW_59_in_synpred95_Pddl2460); if (state.failed) return;
		match(input,105,FOLLOW_105_in_synpred95_Pddl2462); if (state.failed) return;
		match(input,59,FOLLOW_59_in_synpred95_Pddl2464); if (state.failed) return;
		pushFollow(FOLLOW_typedVariableList_in_synpred95_Pddl2466);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred95_Pddl2468); if (state.failed) return;
		pushFollow(FOLLOW_daEffect_in_synpred95_Pddl2470);
		daEffect();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred95_Pddl2472); if (state.failed) return;
		}

	}
	// $ANTLR end synpred95_Pddl

	// $ANTLR start synpred96_Pddl
	public final void synpred96_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:404:4: ( '(' 'when' daGD timedEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:404:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,59,FOLLOW_59_in_synpred96_Pddl2477); if (state.failed) return;
		match(input,125,FOLLOW_125_in_synpred96_Pddl2479); if (state.failed) return;
		pushFollow(FOLLOW_daGD_in_synpred96_Pddl2481);
		daGD();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_timedEffect_in_synpred96_Pddl2483);
		timedEffect();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred96_Pddl2485); if (state.failed) return;
		}

	}
	// $ANTLR end synpred96_Pddl

	// $ANTLR start synpred97_Pddl
	public final void synpred97_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:4: ( '(' 'at' timeSpecifier daEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:4: '(' 'at' timeSpecifier daEffect ')'
		{
		match(input,59,FOLLOW_59_in_synpred97_Pddl2509); if (state.failed) return;
		match(input,97,FOLLOW_97_in_synpred97_Pddl2511); if (state.failed) return;
		pushFollow(FOLLOW_timeSpecifier_in_synpred97_Pddl2513);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_daEffect_in_synpred97_Pddl2515);
		daEffect();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred97_Pddl2517); if (state.failed) return;
		}

	}
	// $ANTLR end synpred97_Pddl

	// $ANTLR start synpred98_Pddl
	public final void synpred98_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:410:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:410:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		match(input,59,FOLLOW_59_in_synpred98_Pddl2527); if (state.failed) return;
		match(input,97,FOLLOW_97_in_synpred98_Pddl2529); if (state.failed) return;
		pushFollow(FOLLOW_timeSpecifier_in_synpred98_Pddl2531);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_fAssignDA_in_synpred98_Pddl2533);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred98_Pddl2535); if (state.failed) return;
		}

	}
	// $ANTLR end synpred98_Pddl

	// $ANTLR start synpred99_Pddl
	public final void synpred99_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( ( binaryOp fExpDA fExpDA ) )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
		{
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred99_Pddl2591);
		binaryOp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_fExpDA_in_synpred99_Pddl2593);
		fExpDA();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_fExpDA_in_synpred99_Pddl2595);
		fExpDA();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred99_Pddl

	// $ANTLR start synpred100_Pddl
	public final void synpred100_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,59,FOLLOW_59_in_synpred100_Pddl2587); if (state.failed) return;
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt97=2;
		int LA97_0 = input.LA(1);
		if ( (LA97_0==63) ) {
			int LA97_1 = input.LA(2);
			if ( (synpred99_Pddl()) ) {
				alt97=1;
			}
			else if ( (true) ) {
				alt97=2;
			}

		}
		else if ( ((LA97_0 >= 61 && LA97_0 <= 62)||LA97_0==64) ) {
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
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
				{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:9: ( binaryOp fExpDA fExpDA )
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred100_Pddl2591);
				binaryOp();
				state._fsp--;
				if (state.failed) return;
				pushFollow(FOLLOW_fExpDA_in_synpred100_Pddl2593);
				fExpDA();
				state._fsp--;
				if (state.failed) return;
				pushFollow(FOLLOW_fExpDA_in_synpred100_Pddl2595);
				fExpDA();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;
			case 2 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:36: ( '-' fExpDA )
				{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:36: ( '-' fExpDA )
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:37: '-' fExpDA
				{
				match(input,63,FOLLOW_63_in_synpred100_Pddl2601); if (state.failed) return;
				pushFollow(FOLLOW_fExpDA_in_synpred100_Pddl2603);
				fExpDA();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;

		}

		match(input,60,FOLLOW_60_in_synpred100_Pddl2607); if (state.failed) return;
		}

	}
	// $ANTLR end synpred100_Pddl

	// $ANTLR start synpred112_Pddl
	public final void synpred112_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: ( '(' 'and' ( prefConGD )* ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,59,FOLLOW_59_in_synpred112_Pddl3057); if (state.failed) return;
		match(input,95,FOLLOW_95_in_synpred112_Pddl3059); if (state.failed) return;
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:14: ( prefConGD )*
		loop98:
		while (true) {
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==59) ) {
				alt98=1;
			}

			switch (alt98) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred112_Pddl3061);
				prefConGD();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop98;
			}
		}

		match(input,60,FOLLOW_60_in_synpred112_Pddl3064); if (state.failed) return;
		}

	}
	// $ANTLR end synpred112_Pddl

	// $ANTLR start synpred113_Pddl
	public final void synpred113_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:489:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:489:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,59,FOLLOW_59_in_synpred113_Pddl3069); if (state.failed) return;
		match(input,105,FOLLOW_105_in_synpred113_Pddl3071); if (state.failed) return;
		match(input,59,FOLLOW_59_in_synpred113_Pddl3073); if (state.failed) return;
		pushFollow(FOLLOW_typedVariableList_in_synpred113_Pddl3075);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred113_Pddl3077); if (state.failed) return;
		pushFollow(FOLLOW_prefConGD_in_synpred113_Pddl3079);
		prefConGD();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred113_Pddl3081); if (state.failed) return;
		}

	}
	// $ANTLR end synpred113_Pddl

	// $ANTLR start synpred115_Pddl
	public final void synpred115_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,59,FOLLOW_59_in_synpred115_Pddl3086); if (state.failed) return;
		match(input,117,FOLLOW_117_in_synpred115_Pddl3088); if (state.failed) return;
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:21: ( NAME )?
		int alt99=2;
		int LA99_0 = input.LA(1);
		if ( (LA99_0==NAME) ) {
			alt99=1;
		}
		switch (alt99) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred115_Pddl3090); if (state.failed) return;
				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred115_Pddl3093);
		conGD();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred115_Pddl3095); if (state.failed) return;
		}

	}
	// $ANTLR end synpred115_Pddl

	// $ANTLR start synpred117_Pddl
	public final void synpred117_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:502:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:502:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,59,FOLLOW_59_in_synpred117_Pddl3156); if (state.failed) return;
		pushFollow(FOLLOW_binaryOp_in_synpred117_Pddl3158);
		binaryOp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_metricFExp_in_synpred117_Pddl3160);
		metricFExp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_metricFExp_in_synpred117_Pddl3162);
		metricFExp();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred117_Pddl3164); if (state.failed) return;
		}

	}
	// $ANTLR end synpred117_Pddl

	// $ANTLR start synpred119_Pddl
	public final void synpred119_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,59,FOLLOW_59_in_synpred119_Pddl3186); if (state.failed) return;
		pushFollow(FOLLOW_multiOp_in_synpred119_Pddl3188);
		multiOp();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_metricFExp_in_synpred119_Pddl3190);
		metricFExp();
		state._fsp--;
		if (state.failed) return;
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:27: ( metricFExp )+
		int cnt100=0;
		loop100:
		while (true) {
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==NAME||LA100_0==NUMBER||LA100_0==59) ) {
				alt100=1;
			}

			switch (alt100) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred119_Pddl3192);
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

		match(input,60,FOLLOW_60_in_synpred119_Pddl3195); if (state.failed) return;
		}

	}
	// $ANTLR end synpred119_Pddl

	// $ANTLR start synpred120_Pddl
	public final void synpred120_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:506:4: ( '(' '-' metricFExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:506:4: '(' '-' metricFExp ')'
		{
		match(input,59,FOLLOW_59_in_synpred120_Pddl3219); if (state.failed) return;
		match(input,63,FOLLOW_63_in_synpred120_Pddl3221); if (state.failed) return;
		pushFollow(FOLLOW_metricFExp_in_synpred120_Pddl3223);
		metricFExp();
		state._fsp--;
		if (state.failed) return;
		match(input,60,FOLLOW_60_in_synpred120_Pddl3225); if (state.failed) return;
		}

	}
	// $ANTLR end synpred120_Pddl

	// $ANTLR start synpred122_Pddl
	public final void synpred122_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:509:4: ( fHead )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:509:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred122_Pddl3247);
		fHead();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred122_Pddl

	// Delegated rules

	public final boolean synpred45_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred45_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred120_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred120_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
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
	public final boolean synpred62_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred62_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred61_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred61_Pddl_fragment(); // can never throw exception
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
		"\1\74\1\77\2\uffff";
	static final String DFA14_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA14_specialS =
		"\4\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\27\uffff\1\2",
			"\1\1\27\uffff\1\2\2\uffff\1\3",
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
			return "136:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\44\2\uffff";
	static final String DFA12_maxS =
		"\1\74\1\77\2\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA12_specialS =
		"\4\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\1\27\uffff\1\2",
			"\1\1\27\uffff\1\2\2\uffff\1\3",
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
			return "()+ loopback of 136:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\70\2\uffff";
	static final String DFA25_maxS =
		"\1\74\1\77\2\uffff";
	static final String DFA25_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA25_specialS =
		"\4\uffff}>";
	static final String[] DFA25_transitionS = {
			"\1\1\2\uffff\2\2",
			"\1\1\2\uffff\2\2\2\uffff\1\3",
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
			return "187:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\70\2\uffff";
	static final String DFA23_maxS =
		"\1\74\1\77\2\uffff";
	static final String DFA23_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA23_specialS =
		"\4\uffff}>";
	static final String[] DFA23_transitionS = {
			"\1\1\2\uffff\2\2",
			"\1\1\2\uffff\2\2\2\uffff\1\3",
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
			return "()+ loopback of 187:20: ( singleTypeVarList )+";
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_domain360 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_domain362 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_domainName_in_domain364 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_requireDef_in_domain372 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_typesDef_in_domain381 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_constantsDef_in_domain390 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_predicatesDef_in_domain399 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_functionsDef_in_domain408 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain417 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_constraints_in_domain426 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_structureDef_in_domain435 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_domain444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_free_functionsDef528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_free_functionsDef530 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef532 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_free_functionsDef534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_domainName557 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_domainName559 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NAME_in_domainName561 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_domainName563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_requireDef590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_requireDef592 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef594 = new BitSet(new long[]{0x1020000000000000L});
	public static final BitSet FOLLOW_60_in_requireDef597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_typesDef618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_typesDef620 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef622 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_typesDef624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList651 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList656 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList659 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList679 = new BitSet(new long[]{0x8000001000000000L});
	public static final BitSet FOLLOW_63_in_singleTypeNameList682 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_type713 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_type715 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_primType_in_type717 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_60_in_type720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_functionsDef761 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_functionsDef763 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_functionList_in_functionsDef765 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_functionsDef767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList788 = new BitSet(new long[]{0x8800000000000002L});
	public static final BitSet FOLLOW_63_in_functionList792 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_functionType_in_functionList794 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_59_in_atomicFunctionSkeleton810 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton813 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton816 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_atomicFunctionSkeleton818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_functionSymbol829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_114_in_functionType838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_constantsDef849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_constantsDef851 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef853 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_constantsDef855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_predicatesDef875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_predicatesDef877 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef879 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_predicatesDef882 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_atomicFormulaSkeleton903 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton906 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton909 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_atomicFormulaSkeleton911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList937 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList942 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList945 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList965 = new BitSet(new long[]{0x8100000000000000L});
	public static final BitSet FOLLOW_63_in_singleTypeVarList968 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_constraints1003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_constraints1006 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_conGD_in_constraints1009 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_constraints1011 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraintDef_in_structureDef1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_actionDef1053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_actionDef1055 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_actionDef1066 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_actionDef1069 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1071 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_actionDef1073 = new BitSet(new long[]{0x1000000000000000L,0x0000000000040400L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1086 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_actionDef1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_constraintDef1122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_constraintDef1124 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_constraintDef1135 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_constraintDef1138 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_constraintDef1140 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_constraintDef1142 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1155 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_constraintDef1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_constraintSymbol1200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_actionDefBody1215 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_actionDefBody1219 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_actionDefBody1221 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1226 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_actionDefBody1236 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_actionDefBody1240 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_actionDefBody1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_constraintDefBody1282 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_constraintDefBody1286 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_constraintDefBody1288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1336 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_goalDesc1338 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1340 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1368 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_goalDesc1370 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1372 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1400 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_goalDesc1402 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1404 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1430 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_goalDesc1432 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1434 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1436 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1464 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_goalDesc1466 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_goalDesc1468 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1470 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1472 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1474 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goalDesc1502 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_goalDesc1504 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_goalDesc1506 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1508 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1510 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1512 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goalDesc1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_equality1598 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_equality1601 = new BitSet(new long[]{0x0100001000000000L});
	public static final BitSet FOLLOW_term_in_equality1603 = new BitSet(new long[]{0x0100001000000000L});
	public static final BitSet FOLLOW_term_in_equality1605 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_equality1607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fComp1618 = new BitSet(new long[]{0x0000000000000000L,0x0000000007C00000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1621 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1623 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1625 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fComp1627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_atomicTermFormula1639 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1641 = new BitSet(new long[]{0x1100001000000000L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1643 = new BitSet(new long[]{0x1100001000000000L});
	public static final BitSet FOLLOW_60_in_atomicTermFormula1646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_durativeActionDef1684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_durativeActionDef1686 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_durativeActionDef1697 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_durativeActionDef1700 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1703 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_durativeActionDef1707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000504L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1720 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_durativeActionDef1722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_daDefBody1755 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_daDefBody1762 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_daDefBody1766 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daDefBody1768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody1773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_daDefBody1782 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_daDefBody1786 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daDefBody1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody1793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daGD1813 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_daGD1815 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1817 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_daGD1820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daGD1825 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_daGD1827 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_daGD1829 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD1831 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daGD1833 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1835 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daGD1837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_prefTimedGD1853 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_prefTimedGD1855 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD1857 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1860 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_prefTimedGD1862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_timedGD1873 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_timedGD1875 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD1877 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1879 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_timedGD1881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_timedGD1886 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_timedGD1888 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_interval_in_timedGD1890 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1892 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_timedGD1894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_interval1916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_derivedDef1929 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_derivedDef1932 = new BitSet(new long[]{0x0900000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef1935 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef1937 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_derivedDef1939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp1954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fExp1959 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_fExp1961 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1963 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp2_in_fExp1965 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fExp1967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fExp1984 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fExp1986 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1988 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fExp1990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp2003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp22015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fHead2025 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2027 = new BitSet(new long[]{0x1100001000000000L});
	public static final BitSet FOLLOW_term_in_fHead2029 = new BitSet(new long[]{0x1100001000000000L});
	public static final BitSet FOLLOW_60_in_fHead2032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_effect2067 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_effect2069 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_cEffect_in_effect2071 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_effect2074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect2088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_cEffect2099 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_cEffect2101 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_cEffect2103 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect2105 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_cEffect2107 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_effect_in_cEffect2109 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_cEffect2111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_cEffect2129 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_cEffect2131 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect2133 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_condEffect_in_cEffect2135 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_cEffect2137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_pEffect2166 = new BitSet(new long[]{0x0000000000000000L,0x0180200900000000L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2168 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_fHead_in_pEffect2170 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_pEffect2172 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_pEffect2174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_pEffect2194 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_pEffect2196 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2198 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_pEffect2200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_condEffect2229 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_condEffect2231 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2233 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_condEffect2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_durationConstraint2351 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_durationConstraint2353 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2355 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_durationConstraint2358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_durationConstraint2363 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_durationConstraint2365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_simpleDurationConstraint2381 = new BitSet(new long[]{0x0000000000000000L,0x0000000005800000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2383 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_simpleDurationConstraint2385 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2387 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_simpleDurationConstraint2389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_simpleDurationConstraint2394 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_simpleDurationConstraint2396 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2398 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2400 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_simpleDurationConstraint2402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daEffect2443 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_daEffect2445 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2447 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_daEffect2450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daEffect2460 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_daEffect2462 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_daEffect2464 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2466 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daEffect2468 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2470 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daEffect2472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daEffect2477 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_daEffect2479 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daGD_in_daEffect2481 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2483 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daEffect2485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_daEffect2490 = new BitSet(new long[]{0x0000000000000000L,0x0180200900000000L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2492 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_fHead_in_daEffect2494 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2496 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_daEffect2498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_timedEffect2509 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_timedEffect2511 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2513 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2515 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_timedEffect2517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_timedEffect2527 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_timedEffect2529 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2531 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2533 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_timedEffect2535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_timedEffect2540 = new BitSet(new long[]{0x0000000000000000L,0x0180200900000000L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2542 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2544 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2546 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_timedEffect2548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fAssignDA2568 = new BitSet(new long[]{0x0000000000000000L,0x0180200900000000L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2570 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2572 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2574 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fAssignDA2576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_fExpDA2587 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2591 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2593 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2595 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_63_in_fExpDA2601 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2603 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_fExpDA2607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_fExpDA2612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_problem2631 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_problem2633 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_problemDecl_in_problem2635 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_problemDomain_in_problem2640 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_requireDef_in_problem2648 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_objectDecl_in_problem2657 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_init_in_problem2666 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goal_in_problem2674 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_probConstraints_in_problem2682 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_metricSpec_in_problem2691 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_problem2707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_problemDecl2764 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_problemDecl2766 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl2768 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_problemDecl2770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_problemDomain2796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_problemDomain2798 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain2800 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_problemDomain2802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_objectDecl2822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_objectDecl2824 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl2826 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_objectDecl2828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_init2848 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_init2850 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_initEl_in_init2852 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_init2855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_initEl2881 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_initEl2883 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_fHead_in_initEl2885 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2887 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_initEl2889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_initEl2912 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_initEl2914 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2916 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2918 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_initEl2920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_nameLiteral2947 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_nameLiteral2949 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2951 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_nameLiteral2953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_atomicNameFormula2972 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula2974 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula2976 = new BitSet(new long[]{0x1000001000000000L});
	public static final BitSet FOLLOW_60_in_atomicNameFormula2979 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_goal3004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_goal3006 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goal3008 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_goal3010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_probConstraints3028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_69_in_probConstraints3030 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints3033 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_probConstraints3035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_prefConGD3057 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_prefConGD3059 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3061 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_prefConGD3064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_prefConGD3069 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_prefConGD3071 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_prefConGD3073 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD3075 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_prefConGD3077 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3079 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_prefConGD3081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_prefConGD3086 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_prefConGD3088 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_NAME_in_prefConGD3090 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3093 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_prefConGD3095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_metricSpec3111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_metricSpec3113 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec3115 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec3117 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_metricSpec3119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_metricFExp3156 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3158 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3160 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3162 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_metricFExp3164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_metricFExp3186 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3188 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3190 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3192 = new BitSet(new long[]{0x1800011000000000L});
	public static final BitSet FOLLOW_60_in_metricFExp3195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_metricFExp3219 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_metricFExp3221 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3223 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_metricFExp3225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_metricFExp3262 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_metricFExp3264 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3266 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_metricFExp3268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3282 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_conGD3284 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3286 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3294 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_conGD3296 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_conGD3298 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3300 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3302 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3304 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3311 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_conGD3313 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_conGD3315 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3317 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3345 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_93_in_conGD3347 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3349 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3356 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_121_in_conGD3358 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3360 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3368 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_conGD3370 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3372 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3374 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3381 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_conGD3383 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3385 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3392 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_conGD3394 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3396 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3398 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3405 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_conGD3407 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3409 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3411 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3418 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_conGD3420 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3422 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3424 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3426 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3433 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_conGD3435 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3437 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3439 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3441 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_conGD3448 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_106_in_conGD3450 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3452 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3454 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_conGD3456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred45_Pddl1543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred48_Pddl1703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred61_Pddl1959 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_synpred61_Pddl1961 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_synpred61_Pddl1963 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp2_in_synpred61_Pddl1965 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred61_Pddl1967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred62_Pddl1984 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred62_Pddl1986 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_fExp_in_synpred62_Pddl1988 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred62_Pddl1990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred91_Pddl2429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred93_Pddl2443 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_synpred93_Pddl2445 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred93_Pddl2447 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_synpred93_Pddl2450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred94_Pddl2455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred95_Pddl2460 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_synpred95_Pddl2462 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_synpred95_Pddl2464 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred95_Pddl2466 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred95_Pddl2468 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred95_Pddl2470 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred95_Pddl2472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred96_Pddl2477 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_synpred96_Pddl2479 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daGD_in_synpred96_Pddl2481 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_synpred96_Pddl2483 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred96_Pddl2485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred97_Pddl2509 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_synpred97_Pddl2511 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred97_Pddl2513 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred97_Pddl2515 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred97_Pddl2517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred98_Pddl2527 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_synpred98_Pddl2529 = new BitSet(new long[]{0x0000000000000000L,0x1000008000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred98_Pddl2531 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred98_Pddl2533 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred98_Pddl2535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred99_Pddl2591 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred99_Pddl2593 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred99_Pddl2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred100_Pddl2587 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_synpred100_Pddl2591 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred100_Pddl2593 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred100_Pddl2595 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred100_Pddl2601 = new BitSet(new long[]{0x0800011000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred100_Pddl2603 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred100_Pddl2607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred112_Pddl3057 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_synpred112_Pddl3059 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred112_Pddl3061 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_60_in_synpred112_Pddl3064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred113_Pddl3069 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_synpred113_Pddl3071 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_synpred113_Pddl3073 = new BitSet(new long[]{0x1100000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred113_Pddl3075 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred113_Pddl3077 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred113_Pddl3079 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred113_Pddl3081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred115_Pddl3086 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_synpred115_Pddl3088 = new BitSet(new long[]{0x0800001000000000L});
	public static final BitSet FOLLOW_NAME_in_synpred115_Pddl3090 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_conGD_in_synpred115_Pddl3093 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred115_Pddl3095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred117_Pddl3156 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_binaryOp_in_synpred117_Pddl3158 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred117_Pddl3160 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred117_Pddl3162 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred117_Pddl3164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred119_Pddl3186 = new BitSet(new long[]{0x6000000000000000L});
	public static final BitSet FOLLOW_multiOp_in_synpred119_Pddl3188 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred119_Pddl3190 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred119_Pddl3192 = new BitSet(new long[]{0x1800011000000000L});
	public static final BitSet FOLLOW_60_in_synpred119_Pddl3195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_synpred120_Pddl3219 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred120_Pddl3221 = new BitSet(new long[]{0x0800011000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred120_Pddl3223 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_synpred120_Pddl3225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred122_Pddl3247 = new BitSet(new long[]{0x0000000000000002L});
}
