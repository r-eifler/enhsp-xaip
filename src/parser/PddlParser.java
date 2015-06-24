// $ANTLR 3.5.1 /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g 2015-06-18 09:21:20

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
		"EQUALITY_CON", "EXISTS_GD", "FORALL_EFFECT", "FORALL_GD", "FREE_FUNCTIONS", 
		"FUNCTIONS", "FUNC_HEAD", "GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", 
		"LETTER", "LINE_COMMENT", "MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", 
		"NOT_GD", "NOT_PRED_INIT", "NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", 
		"PREDICATES", "PRED_HEAD", "PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", 
		"PROBLEM_DOMAIN", "PROBLEM_METRIC", "PROBLEM_NAME", "REQUIREMENTS", "REQUIRE_KEY", 
		"TYPES", "UNARY_MINUS", "VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", 
		"':constraints'", "':derived'", "':domain'", "':duration'", "':durative-action'", 
		"':effect'", "':free_functions'", "':functions'", "':goal'", "':init'", 
		"':metric'", "':objects'", "':parameters'", "':precondition'", "':predicates'", 
		"':requirements'", "':types'", "'<'", "'<='", "'='", "'>'", "'>='", "'?duration'", 
		"'all'", "'always'", "'always-within'", "'and'", "'assign'", "'at'", "'at-most-once'", 
		"'decrease'", "'define'", "'domain'", "'either'", "'end'", "'exists'", 
		"'forall'", "'hold-after'", "'hold-during'", "'imply'", "'increase'", 
		"'is-violated'", "'maximize'", "'minimize'", "'not'", "'number'", "'or'", 
		"'over'", "'preference'", "'problem'", "'scale-down'", "'scale-up'", "'sometime'", 
		"'sometime-after'", "'sometime-before'", "'start'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int T__122=122;
	public static final int T__123=123;
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
	public static final int FREE_FUNCTIONS=22;
	public static final int FUNCTIONS=23;
	public static final int FUNC_HEAD=24;
	public static final int GOAL=25;
	public static final int IMPLY_GD=26;
	public static final int INIT=27;
	public static final int INIT_AT=28;
	public static final int INIT_EQ=29;
	public static final int LETTER=30;
	public static final int LINE_COMMENT=31;
	public static final int MINUS_OP=32;
	public static final int MULTI_OP=33;
	public static final int NAME=34;
	public static final int NOT_EFFECT=35;
	public static final int NOT_GD=36;
	public static final int NOT_PRED_INIT=37;
	public static final int NUMBER=38;
	public static final int OBJECTS=39;
	public static final int OR_GD=40;
	public static final int PRECONDITION=41;
	public static final int PREDICATES=42;
	public static final int PRED_HEAD=43;
	public static final int PRED_INST=44;
	public static final int PROBLEM=45;
	public static final int PROBLEM_CONSTRAINT=46;
	public static final int PROBLEM_DOMAIN=47;
	public static final int PROBLEM_METRIC=48;
	public static final int PROBLEM_NAME=49;
	public static final int REQUIREMENTS=50;
	public static final int REQUIRE_KEY=51;
	public static final int TYPES=52;
	public static final int UNARY_MINUS=53;
	public static final int VARIABLE=54;
	public static final int WHEN_EFFECT=55;
	public static final int WHITESPACE=56;

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:92:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws RecognitionException {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:92:9: ( domain | problem )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==57) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==97) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==57) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==98) ) {
							alt1=1;
						}
						else if ( (LA1_3==115) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:92:11: domain
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_domain_in_pddlDoc327);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:92:20: problem
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_problem_in_pddlDoc331);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:96:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
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
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_free_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule free_functionsDef");
		RewriteRuleSubtreeStream stream_constantsDef=new RewriteRuleSubtreeStream(adaptor,"rule constantsDef");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_predicatesDef=new RewriteRuleSubtreeStream(adaptor,"rule predicatesDef");
		RewriteRuleSubtreeStream stream_constraints=new RewriteRuleSubtreeStream(adaptor,"rule constraints");
		RewriteRuleSubtreeStream stream_structureDef=new RewriteRuleSubtreeStream(adaptor,"rule structureDef");
		RewriteRuleSubtreeStream stream_domainName=new RewriteRuleSubtreeStream(adaptor,"rule domainName");
		RewriteRuleSubtreeStream stream_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule functionsDef");
		RewriteRuleSubtreeStream stream_typesDef=new RewriteRuleSubtreeStream(adaptor,"rule typesDef");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:97:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:97:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			char_literal3=(Token)match(input,57,FOLLOW_57_in_domain346); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal3);

			string_literal4=(Token)match(input,97,FOLLOW_97_in_domain348); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_97.add(string_literal4);

			pushFollow(FOLLOW_domainName_in_domain350);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:98:7: ( requireDef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==57) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==81) ) {
					alt2=1;
				}
			}
			switch (alt2) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:98:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_domain358);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:99:7: ( typesDef )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==57) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==82) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:99:7: typesDef
					{
					pushFollow(FOLLOW_typesDef_in_domain367);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:100:7: ( constantsDef )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==57) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==65) ) {
					alt4=1;
				}
			}
			switch (alt4) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:100:7: constantsDef
					{
					pushFollow(FOLLOW_constantsDef_in_domain376);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:101:7: ( predicatesDef )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==57) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==80) ) {
					alt5=1;
				}
			}
			switch (alt5) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:101:7: predicatesDef
					{
					pushFollow(FOLLOW_predicatesDef_in_domain385);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:102:7: ( functionsDef )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==57) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==73) ) {
					alt6=1;
				}
			}
			switch (alt6) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:102:7: functionsDef
					{
					pushFollow(FOLLOW_functionsDef_in_domain394);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:103:7: ( free_functionsDef )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==57) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==72) ) {
					alt7=1;
				}
			}
			switch (alt7) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:103:7: free_functionsDef
					{
					pushFollow(FOLLOW_free_functionsDef_in_domain403);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:104:7: ( constraints )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==57) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==66) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:104:7: constraints
					{
					pushFollow(FOLLOW_constraints_in_domain412);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:105:7: ( structureDef )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==57) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:105:7: structureDef
					{
					pushFollow(FOLLOW_structureDef_in_domain421);
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

			char_literal14=(Token)match(input,58,FOLLOW_58_in_domain430); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal14);

			// AST REWRITE
			// elements: functionsDef, typesDef, constraints, domainName, free_functionsDef, predicatesDef, requireDef, structureDef, constantsDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 107:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:107:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				adaptor.addChild(root_1, stream_domainName.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:107:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:107:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:108:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:108:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:108:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:108:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:109:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:109:30: ( structureDef )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:112:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:113:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:113:4: '(' ':free_functions' functionList ')'
			{
			char_literal15=(Token)match(input,57,FOLLOW_57_in_free_functionsDef514); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal15);

			string_literal16=(Token)match(input,72,FOLLOW_72_in_free_functionsDef516); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(string_literal16);

			pushFollow(FOLLOW_functionList_in_free_functionsDef518);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());
			char_literal18=(Token)match(input,58,FOLLOW_58_in_free_functionsDef520); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal18);

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
			// 114:2: -> ^( FREE_FUNCTIONS functionList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:114:5: ^( FREE_FUNCTIONS functionList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:117:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
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
		RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:118:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:118:7: '(' 'domain' NAME ')'
			{
			char_literal19=(Token)match(input,57,FOLLOW_57_in_domainName543); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal19);

			string_literal20=(Token)match(input,98,FOLLOW_98_in_domainName545); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_98.add(string_literal20);

			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName547); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);

			char_literal22=(Token)match(input,58,FOLLOW_58_in_domainName549); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal22);

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
			// 119:6: -> ^( DOMAIN_NAME NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:119:9: ^( DOMAIN_NAME NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:122:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:123:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:123:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			char_literal23=(Token)match(input,57,FOLLOW_57_in_requireDef576); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal23);

			string_literal24=(Token)match(input,81,FOLLOW_81_in_requireDef578); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal24);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:123:24: ( REQUIRE_KEY )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:123:24: REQUIRE_KEY
					{
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef580); if (state.failed) return retval; 
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

			char_literal26=(Token)match(input,58,FOLLOW_58_in_requireDef583); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal26);

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
			// 124:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:124:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:127:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:128:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:128:4: '(' ':types' typedNameList ')'
			{
			char_literal27=(Token)match(input,57,FOLLOW_57_in_typesDef604); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal27);

			string_literal28=(Token)match(input,82,FOLLOW_82_in_typesDef606); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_82.add(string_literal28);

			pushFollow(FOLLOW_typedNameList_in_typesDef608);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());
			char_literal30=(Token)match(input,58,FOLLOW_58_in_typesDef610); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal30);

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
			// 129:4: -> ^( TYPES typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:129:7: ^( TYPES typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:133:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:8: ( NAME )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:8: ( NAME )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:8: NAME
							{
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList637); if (state.failed) return retval;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:16: ( singleTypeNameList )+ ( NAME )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:16: ( singleTypeNameList )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						alt12 = dfa12.predict(input);
						switch (alt12) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:16: singleTypeNameList
							{
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList642);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:36: ( NAME )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:134:36: NAME
							{
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList645); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:137:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws RecognitionException {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME34=null;
		Token char_literal35=null;
		ParserRuleReturnScope t =null;

		Object NAME34_tree=null;
		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:7: ( ( NAME )+ '-' t= type )
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:7: ( ( NAME )+ '-' t= type )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:8: ( NAME )+ '-' t= type
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:8: ( NAME )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:138:8: NAME
					{
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList665); if (state.failed) return retval; 
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

			char_literal35=(Token)match(input,61,FOLLOW_61_in_singleTypeNameList668); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_61.add(char_literal35);

			pushFollow(FOLLOW_type_in_singleTypeNameList672);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: t, NAME
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
			// 139:4: -> ( ^( NAME $t) )+
			{
				if ( !(stream_t.hasNext()||stream_NAME.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_t.hasNext()||stream_NAME.hasNext() ) {
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:139:7: ^( NAME $t)
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:142:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==57) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:4: ( '(' 'either' ( primType )+ ')' )
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:4: ( '(' 'either' ( primType )+ ')' )
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:6: '(' 'either' ( primType )+ ')'
					{
					char_literal36=(Token)match(input,57,FOLLOW_57_in_type699); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal36);

					string_literal37=(Token)match(input,99,FOLLOW_99_in_type701); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_99.add(string_literal37);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:19: ( primType )+
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:143:19: primType
							{
							pushFollow(FOLLOW_primType_in_type703);
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

					char_literal39=(Token)match(input,58,FOLLOW_58_in_type706); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal39);

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
					// 144:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:144:7: ^( EITHER_TYPE ( primType )+ )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:145:4: primType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primType_in_type727);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:148:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws RecognitionException {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:148:10: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:148:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType737); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:150:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:151:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:151:4: '(' ':functions' functionList ')'
			{
			char_literal42=(Token)match(input,57,FOLLOW_57_in_functionsDef747); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal42);

			string_literal43=(Token)match(input,73,FOLLOW_73_in_functionsDef749); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_73.add(string_literal43);

			pushFollow(FOLLOW_functionList_in_functionsDef751);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());
			char_literal45=(Token)match(input,58,FOLLOW_58_in_functionsDef753); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal45);

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
			// 152:2: -> ^( FUNCTIONS functionList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:152:5: ^( FUNCTIONS functionList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:155:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws RecognitionException {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal47=null;
		ParserRuleReturnScope atomicFunctionSkeleton46 =null;
		ParserRuleReturnScope functionType48 =null;

		Object char_literal47_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==57) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==57) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						switch (alt18) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:5: atomicFunctionSkeleton
							{
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList774);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:29: ( '-' functionType )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==61) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:30: '-' functionType
							{
							char_literal47=(Token)match(input,61,FOLLOW_61_in_functionList778); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}

							pushFollow(FOLLOW_functionType_in_functionList780);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:159:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:160:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:160:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal49=(Token)match(input,57,FOLLOW_57_in_atomicFunctionSkeleton796); if (state.failed) return retval;
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton799);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton802);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());

			char_literal52=(Token)match(input,58,FOLLOW_58_in_atomicFunctionSkeleton804); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:163:1: functionSymbol : NAME ;
	public final PddlParser.functionSymbol_return functionSymbol() throws RecognitionException {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME53=null;

		Object NAME53_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:163:16: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:163:18: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME53=(Token)match(input,NAME,FOLLOW_NAME_in_functionSymbol815); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws RecognitionException {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:14: ( 'number' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:165:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			string_literal54=(Token)match(input,111,FOLLOW_111_in_functionType824); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:167:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:168:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:168:4: '(' ':constants' typedNameList ')'
			{
			char_literal55=(Token)match(input,57,FOLLOW_57_in_constantsDef835); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal55);

			string_literal56=(Token)match(input,65,FOLLOW_65_in_constantsDef837); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_65.add(string_literal56);

			pushFollow(FOLLOW_typedNameList_in_constantsDef839);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());
			char_literal58=(Token)match(input,58,FOLLOW_58_in_constantsDef841); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal58);

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
			// 169:2: -> ^( CONSTANTS typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:169:5: ^( CONSTANTS typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:172:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:173:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:173:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			char_literal59=(Token)match(input,57,FOLLOW_57_in_predicatesDef861); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal59);

			string_literal60=(Token)match(input,80,FOLLOW_80_in_predicatesDef863); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal60);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:173:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==57) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:173:22: atomicFormulaSkeleton
					{
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef865);
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

			char_literal62=(Token)match(input,58,FOLLOW_58_in_predicatesDef868); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal62);

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
			// 174:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:174:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:177:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:178:2: ( '(' ! predicate ^ typedVariableList ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:178:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal63=(Token)match(input,57,FOLLOW_57_in_atomicFormulaSkeleton889); if (state.failed) return retval;
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton892);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton895);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());

			char_literal66=(Token)match(input,58,FOLLOW_58_in_atomicFormulaSkeleton897); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:181:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws RecognitionException {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:181:11: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:181:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate908); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:184:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:8: ( VARIABLE )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:8: ( VARIABLE )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:8: VARIABLE
							{
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList923); if (state.failed) return retval;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:20: ( singleTypeVarList )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						alt23 = dfa23.predict(input);
						switch (alt23) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:20: singleTypeVarList
							{
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList928);
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

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:39: ( VARIABLE )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:185:39: VARIABLE
							{
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList931); if (state.failed) return retval;
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:188:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
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
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:7: ( ( VARIABLE )+ '-' t= type )
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:7: ( ( VARIABLE )+ '-' t= type )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:8: ( VARIABLE )+ '-' t= type
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:8: ( VARIABLE )+
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:189:8: VARIABLE
					{
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList951); if (state.failed) return retval; 
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

			char_literal72=(Token)match(input,61,FOLLOW_61_in_singleTypeVarList954); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_61.add(char_literal72);

			pushFollow(FOLLOW_type_in_singleTypeVarList958);
			t=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(t.getTree());
			}

			// AST REWRITE
			// elements: VARIABLE, t
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
			// 190:7: -> ( ^( VARIABLE $t) )+
			{
				if ( !(stream_VARIABLE.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_VARIABLE.hasNext()||stream_t.hasNext() ) {
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:190:10: ^( VARIABLE $t)
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:193:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
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
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:194:2: ( '(' ! ':constraints' ^ conGD ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:194:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal73=(Token)match(input,57,FOLLOW_57_in_constraints989); if (state.failed) return retval;
			string_literal74=(Token)match(input,66,FOLLOW_66_in_constraints992); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}

			pushFollow(FOLLOW_conGD_in_constraints995);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());

			char_literal76=(Token)match(input,58,FOLLOW_58_in_constraints997); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:197:1: structureDef : ( actionDef | durativeActionDef | derivedDef );
	public final PddlParser.structureDef_return structureDef() throws RecognitionException {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope actionDef77 =null;
		ParserRuleReturnScope durativeActionDef78 =null;
		ParserRuleReturnScope derivedDef79 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:198:2: ( actionDef | durativeActionDef | derivedDef )
			int alt27=3;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==57) ) {
				switch ( input.LA(2) ) {
				case 63:
					{
					alt27=1;
					}
					break;
				case 70:
					{
					alt27=2;
					}
					break;
				case 67:
					{
					alt27=3;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:198:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_actionDef_in_structureDef1009);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:199:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_durativeActionDef_in_structureDef1014);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:200:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_derivedDef_in_structureDef1019);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:206:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws RecognitionException {
		PddlParser.actionDef_return retval = new PddlParser.actionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal80=null;
		Token string_literal81=null;
		Token string_literal83=null;
		Token char_literal84=null;
		Token char_literal86=null;
		Token char_literal88=null;
		ParserRuleReturnScope actionSymbol82 =null;
		ParserRuleReturnScope typedVariableList85 =null;
		ParserRuleReturnScope actionDefBody87 =null;

		Object char_literal80_tree=null;
		Object string_literal81_tree=null;
		Object string_literal83_tree=null;
		Object char_literal84_tree=null;
		Object char_literal86_tree=null;
		Object char_literal88_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:207:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:207:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			char_literal80=(Token)match(input,57,FOLLOW_57_in_actionDef1034); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal80);

			string_literal81=(Token)match(input,63,FOLLOW_63_in_actionDef1036); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(string_literal81);

			pushFollow(FOLLOW_actionSymbol_in_actionDef1038);
			actionSymbol82=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol82.getTree());
			string_literal83=(Token)match(input,78,FOLLOW_78_in_actionDef1047); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal83);

			char_literal84=(Token)match(input,57,FOLLOW_57_in_actionDef1050); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal84);

			pushFollow(FOLLOW_typedVariableList_in_actionDef1052);
			typedVariableList85=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList85.getTree());
			char_literal86=(Token)match(input,58,FOLLOW_58_in_actionDef1054); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal86);

			pushFollow(FOLLOW_actionDefBody_in_actionDef1067);
			actionDefBody87=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody87.getTree());
			char_literal88=(Token)match(input,58,FOLLOW_58_in_actionDef1069); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal88);

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
			// 210:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:210:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:210:33: ( typedVariableList )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:213:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws RecognitionException {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME89=null;

		Object NAME89_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:213:14: ( NAME )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:213:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			NAME89=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1102); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NAME89_tree = (Object)adaptor.create(NAME89);
			adaptor.addChild(root_0, NAME89_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:219:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws RecognitionException {
		PddlParser.actionDefBody_return retval = new PddlParser.actionDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal90=null;
		Token char_literal91=null;
		Token char_literal92=null;
		Token string_literal94=null;
		Token char_literal95=null;
		Token char_literal96=null;
		ParserRuleReturnScope goalDesc93 =null;
		ParserRuleReturnScope effect97 =null;

		Object string_literal90_tree=null;
		Object char_literal91_tree=null;
		Object char_literal92_tree=null;
		Object string_literal94_tree=null;
		Object char_literal95_tree=null;
		Object char_literal96_tree=null;
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==79) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					string_literal90=(Token)match(input,79,FOLLOW_79_in_actionDefBody1118); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_79.add(string_literal90);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:22: ( ( '(' ')' ) | goalDesc )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==57) ) {
						int LA28_1 = input.LA(2);
						if ( (LA28_1==58) ) {
							alt28=1;
						}
						else if ( (LA28_1==NAME||(LA28_1 >= 83 && LA28_1 <= 87)||LA28_1==92||(LA28_1 >= 101 && LA28_1 <= 102)||LA28_1==105||LA28_1==110||LA28_1==112) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:23: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:23: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:24: '(' ')'
							{
							char_literal91=(Token)match(input,57,FOLLOW_57_in_actionDefBody1122); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_57.add(char_literal91);

							char_literal92=(Token)match(input,58,FOLLOW_58_in_actionDefBody1124); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_58.add(char_literal92);

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:220:35: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1129);
							goalDesc93=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc93.getTree());
							}
							break;

					}

					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==71) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:6: ':effect' ( ( '(' ')' ) | effect )
					{
					string_literal94=(Token)match(input,71,FOLLOW_71_in_actionDefBody1139); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_71.add(string_literal94);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:16: ( ( '(' ')' ) | effect )
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==57) ) {
						int LA30_1 = input.LA(2);
						if ( (LA30_1==58) ) {
							alt30=1;
						}
						else if ( (LA30_1==NAME||(LA30_1 >= 92 && LA30_1 <= 93)||LA30_1==96||LA30_1==102||LA30_1==106||LA30_1==110||(LA30_1 >= 116 && LA30_1 <= 117)||LA30_1==122) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:17: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:17: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:18: '(' ')'
							{
							char_literal95=(Token)match(input,57,FOLLOW_57_in_actionDefBody1143); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_57.add(char_literal95);

							char_literal96=(Token)match(input,58,FOLLOW_58_in_actionDefBody1145); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_58.add(char_literal96);

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:221:29: effect
							{
							pushFollow(FOLLOW_effect_in_actionDefBody1150);
							effect97=effect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_effect.add(effect97.getTree());
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
			// 222:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:222:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:222:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:222:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:222:42: ( effect )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:236:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws RecognitionException {
		PddlParser.goalDesc_return retval = new PddlParser.goalDesc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal99=null;
		Token string_literal100=null;
		Token char_literal102=null;
		Token char_literal103=null;
		Token string_literal104=null;
		Token char_literal106=null;
		Token char_literal107=null;
		Token string_literal108=null;
		Token char_literal110=null;
		Token char_literal111=null;
		Token string_literal112=null;
		Token char_literal115=null;
		Token char_literal116=null;
		Token string_literal117=null;
		Token char_literal118=null;
		Token char_literal120=null;
		Token char_literal122=null;
		Token char_literal123=null;
		Token string_literal124=null;
		Token char_literal125=null;
		Token char_literal127=null;
		Token char_literal129=null;
		ParserRuleReturnScope atomicTermFormula98 =null;
		ParserRuleReturnScope goalDesc101 =null;
		ParserRuleReturnScope goalDesc105 =null;
		ParserRuleReturnScope goalDesc109 =null;
		ParserRuleReturnScope goalDesc113 =null;
		ParserRuleReturnScope goalDesc114 =null;
		ParserRuleReturnScope typedVariableList119 =null;
		ParserRuleReturnScope goalDesc121 =null;
		ParserRuleReturnScope typedVariableList126 =null;
		ParserRuleReturnScope goalDesc128 =null;
		ParserRuleReturnScope fComp130 =null;
		ParserRuleReturnScope equality131 =null;

		Object char_literal99_tree=null;
		Object string_literal100_tree=null;
		Object char_literal102_tree=null;
		Object char_literal103_tree=null;
		Object string_literal104_tree=null;
		Object char_literal106_tree=null;
		Object char_literal107_tree=null;
		Object string_literal108_tree=null;
		Object char_literal110_tree=null;
		Object char_literal111_tree=null;
		Object string_literal112_tree=null;
		Object char_literal115_tree=null;
		Object char_literal116_tree=null;
		Object string_literal117_tree=null;
		Object char_literal118_tree=null;
		Object char_literal120_tree=null;
		Object char_literal122_tree=null;
		Object char_literal123_tree=null;
		Object string_literal124_tree=null;
		Object char_literal125_tree=null;
		Object char_literal127_tree=null;
		Object char_literal129_tree=null;
		RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
		RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
		RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:237:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt34=9;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==57) ) {
				switch ( input.LA(2) ) {
				case 92:
					{
					alt34=2;
					}
					break;
				case 112:
					{
					alt34=3;
					}
					break;
				case 110:
					{
					alt34=4;
					}
					break;
				case 105:
					{
					alt34=5;
					}
					break;
				case 101:
					{
					alt34=6;
					}
					break;
				case 102:
					{
					alt34=7;
					}
					break;
				case 85:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA34_13 = input.LA(5);
							if ( (LA34_13==58) ) {
								int LA34_14 = input.LA(6);
								if ( (synpred42_Pddl()) ) {
									alt34=8;
								}
								else if ( (true) ) {
									alt34=9;
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
										new NoViableAltException("", 34, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case NUMBER:
						case 57:
							{
							alt34=8;
							}
							break;
						case VARIABLE:
							{
							alt34=9;
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
									new NoViableAltException("", 34, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case NUMBER:
					case 57:
						{
						alt34=8;
						}
						break;
					case VARIABLE:
						{
						alt34=9;
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
								new NoViableAltException("", 34, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case NAME:
					{
					alt34=1;
					}
					break;
				case 83:
				case 84:
				case 86:
				case 87:
					{
					alt34=8;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:237:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1194);
					atomicTermFormula98=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula98.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:4: '(' 'and' ( goalDesc )* ')'
					{
					char_literal99=(Token)match(input,57,FOLLOW_57_in_goalDesc1199); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal99);

					string_literal100=(Token)match(input,92,FOLLOW_92_in_goalDesc1201); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal100);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:14: ( goalDesc )*
					loop32:
					while (true) {
						int alt32=2;
						int LA32_0 = input.LA(1);
						if ( (LA32_0==57) ) {
							alt32=1;
						}

						switch (alt32) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:238:14: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1203);
							goalDesc101=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc101.getTree());
							}
							break;

						default :
							break loop32;
						}
					}

					char_literal102=(Token)match(input,58,FOLLOW_58_in_goalDesc1206); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal102);

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
					// 239:12: -> ^( AND_GD ( goalDesc )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:239:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:239:24: ( goalDesc )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:240:4: '(' 'or' ( goalDesc )* ')'
					{
					char_literal103=(Token)match(input,57,FOLLOW_57_in_goalDesc1231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal103);

					string_literal104=(Token)match(input,112,FOLLOW_112_in_goalDesc1233); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_112.add(string_literal104);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:240:13: ( goalDesc )*
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==57) ) {
							alt33=1;
						}

						switch (alt33) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:240:13: goalDesc
							{
							pushFollow(FOLLOW_goalDesc_in_goalDesc1235);
							goalDesc105=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc105.getTree());
							}
							break;

						default :
							break loop33;
						}
					}

					char_literal106=(Token)match(input,58,FOLLOW_58_in_goalDesc1238); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal106);

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
					// 241:12: -> ^( OR_GD ( goalDesc )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:241:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:241:23: ( goalDesc )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:242:4: '(' 'not' goalDesc ')'
					{
					char_literal107=(Token)match(input,57,FOLLOW_57_in_goalDesc1263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal107);

					string_literal108=(Token)match(input,110,FOLLOW_110_in_goalDesc1265); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_110.add(string_literal108);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1267);
					goalDesc109=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc109.getTree());
					char_literal110=(Token)match(input,58,FOLLOW_58_in_goalDesc1269); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal110);

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
					// 243:12: -> ^( NOT_GD goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:243:15: ^( NOT_GD goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:244:4: '(' 'imply' goalDesc goalDesc ')'
					{
					char_literal111=(Token)match(input,57,FOLLOW_57_in_goalDesc1293); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal111);

					string_literal112=(Token)match(input,105,FOLLOW_105_in_goalDesc1295); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_105.add(string_literal112);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1297);
					goalDesc113=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc113.getTree());
					pushFollow(FOLLOW_goalDesc_in_goalDesc1299);
					goalDesc114=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc114.getTree());
					char_literal115=(Token)match(input,58,FOLLOW_58_in_goalDesc1301); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal115);

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
					// 245:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:245:15: ^( IMPLY_GD goalDesc goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:246:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal116=(Token)match(input,57,FOLLOW_57_in_goalDesc1327); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal116);

					string_literal117=(Token)match(input,101,FOLLOW_101_in_goalDesc1329); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_101.add(string_literal117);

					char_literal118=(Token)match(input,57,FOLLOW_57_in_goalDesc1331); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal118);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1333);
					typedVariableList119=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList119.getTree());
					char_literal120=(Token)match(input,58,FOLLOW_58_in_goalDesc1335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal120);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1337);
					goalDesc121=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc121.getTree());
					char_literal122=(Token)match(input,58,FOLLOW_58_in_goalDesc1339); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal122);

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
					// 247:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:247:15: ^( EXISTS_GD typedVariableList goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:248:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					char_literal123=(Token)match(input,57,FOLLOW_57_in_goalDesc1365); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal123);

					string_literal124=(Token)match(input,102,FOLLOW_102_in_goalDesc1367); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_102.add(string_literal124);

					char_literal125=(Token)match(input,57,FOLLOW_57_in_goalDesc1369); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal125);

					pushFollow(FOLLOW_typedVariableList_in_goalDesc1371);
					typedVariableList126=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList126.getTree());
					char_literal127=(Token)match(input,58,FOLLOW_58_in_goalDesc1373); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal127);

					pushFollow(FOLLOW_goalDesc_in_goalDesc1375);
					goalDesc128=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc128.getTree());
					char_literal129=(Token)match(input,58,FOLLOW_58_in_goalDesc1377); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal129);

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
					// 249:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:249:15: ^( FORALL_GD typedVariableList goalDesc )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:250:7: fComp
					{
					pushFollow(FOLLOW_fComp_in_goalDesc1406);
					fComp130=fComp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fComp.add(fComp130.getTree());
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
					// 251:15: -> ^( COMPARISON_GD fComp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:251:18: ^( COMPARISON_GD fComp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:252:4: equality
					{
					pushFollow(FOLLOW_equality_in_goalDesc1433);
					equality131=equality();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_equality.add(equality131.getTree());
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
					// 253:6: -> ^( EQUALITY_CON equality )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:253:9: ^( EQUALITY_CON equality )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:256:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws RecognitionException {
		PddlParser.equality_return retval = new PddlParser.equality_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal132=null;
		Token char_literal133=null;
		Token char_literal136=null;
		ParserRuleReturnScope term134 =null;
		ParserRuleReturnScope term135 =null;

		Object char_literal132_tree=null;
		Object char_literal133_tree=null;
		Object char_literal136_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:257:2: ( '(' ! '=' term term ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:257:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal132=(Token)match(input,57,FOLLOW_57_in_equality1461); if (state.failed) return retval;
			char_literal133=(Token)match(input,85,FOLLOW_85_in_equality1464); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal133_tree = (Object)adaptor.create(char_literal133);
			adaptor.addChild(root_0, char_literal133_tree);
			}

			pushFollow(FOLLOW_term_in_equality1466);
			term134=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term134.getTree());

			pushFollow(FOLLOW_term_in_equality1468);
			term135=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term135.getTree());

			char_literal136=(Token)match(input,58,FOLLOW_58_in_equality1470); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:259:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws RecognitionException {
		PddlParser.fComp_return retval = new PddlParser.fComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal137=null;
		Token char_literal141=null;
		ParserRuleReturnScope binaryComp138 =null;
		ParserRuleReturnScope fExp139 =null;
		ParserRuleReturnScope fExp140 =null;

		Object char_literal137_tree=null;
		Object char_literal141_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:260:2: ( '(' ! binaryComp fExp fExp ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:260:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal137=(Token)match(input,57,FOLLOW_57_in_fComp1481); if (state.failed) return retval;
			pushFollow(FOLLOW_binaryComp_in_fComp1484);
			binaryComp138=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp138.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1486);
			fExp139=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp139.getTree());

			pushFollow(FOLLOW_fExp_in_fComp1488);
			fExp140=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp140.getTree());

			char_literal141=(Token)match(input,58,FOLLOW_58_in_fComp1490); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:263:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws RecognitionException {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal142=null;
		Token char_literal145=null;
		ParserRuleReturnScope predicate143 =null;
		ParserRuleReturnScope term144 =null;

		Object char_literal142_tree=null;
		Object char_literal145_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:4: '(' predicate ( term )* ')'
			{
			char_literal142=(Token)match(input,57,FOLLOW_57_in_atomicTermFormula1502); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal142);

			pushFollow(FOLLOW_predicate_in_atomicTermFormula1504);
			predicate143=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate143.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:18: ( term )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==NAME||LA35_0==VARIABLE) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:18: term
					{
					pushFollow(FOLLOW_term_in_atomicTermFormula1506);
					term144=term();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_term.add(term144.getTree());
					}
					break;

				default :
					break loop35;
				}
			}

			char_literal145=(Token)match(input,58,FOLLOW_58_in_atomicTermFormula1509); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal145);

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
			// 264:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:264:53: ( term )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:267:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws RecognitionException {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set146=null;

		Object set146_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:267:6: ( NAME | VARIABLE )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set146=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set146));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:271:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws RecognitionException {
		PddlParser.durativeActionDef_return retval = new PddlParser.durativeActionDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal147=null;
		Token string_literal148=null;
		Token string_literal150=null;
		Token char_literal151=null;
		Token char_literal153=null;
		Token char_literal155=null;
		ParserRuleReturnScope actionSymbol149 =null;
		ParserRuleReturnScope typedVariableList152 =null;
		ParserRuleReturnScope daDefBody154 =null;

		Object char_literal147_tree=null;
		Object string_literal148_tree=null;
		Object string_literal150_tree=null;
		Object char_literal151_tree=null;
		Object char_literal153_tree=null;
		Object char_literal155_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:272:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:272:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			char_literal147=(Token)match(input,57,FOLLOW_57_in_durativeActionDef1547); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal147);

			string_literal148=(Token)match(input,70,FOLLOW_70_in_durativeActionDef1549); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(string_literal148);

			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1551);
			actionSymbol149=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol149.getTree());
			string_literal150=(Token)match(input,78,FOLLOW_78_in_durativeActionDef1560); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal150);

			char_literal151=(Token)match(input,57,FOLLOW_57_in_durativeActionDef1563); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal151);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:273:27: ( typedVariableList )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==VARIABLE) ) {
				alt36=1;
			}
			else if ( (LA36_0==58) ) {
				int LA36_2 = input.LA(2);
				if ( (synpred45_Pddl()) ) {
					alt36=1;
				}
			}
			switch (alt36) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:273:28: typedVariableList
					{
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1566);
					typedVariableList152=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList152.getTree());
					}
					break;

			}

			char_literal153=(Token)match(input,58,FOLLOW_58_in_durativeActionDef1570); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal153);

			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1583);
			daDefBody154=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody154.getTree());
			char_literal155=(Token)match(input,58,FOLLOW_58_in_durativeActionDef1585); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal155);

			// AST REWRITE
			// elements: daDefBody, actionSymbol, typedVariableList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 275:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:275:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:278:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws RecognitionException {
		PddlParser.daDefBody_return retval = new PddlParser.daDefBody_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal156=null;
		Token string_literal158=null;
		Token char_literal159=null;
		Token char_literal160=null;
		Token string_literal162=null;
		Token char_literal163=null;
		Token char_literal164=null;
		ParserRuleReturnScope durationConstraint157 =null;
		ParserRuleReturnScope daGD161 =null;
		ParserRuleReturnScope daEffect165 =null;

		Object string_literal156_tree=null;
		Object string_literal158_tree=null;
		Object char_literal159_tree=null;
		Object char_literal160_tree=null;
		Object string_literal162_tree=null;
		Object char_literal163_tree=null;
		Object char_literal164_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:279:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt39=3;
			switch ( input.LA(1) ) {
			case 69:
				{
				alt39=1;
				}
				break;
			case 64:
				{
				alt39=2;
				}
				break;
			case 71:
				{
				alt39=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}
			switch (alt39) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:279:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					string_literal156=(Token)match(input,69,FOLLOW_69_in_daDefBody1618); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal156_tree = (Object)adaptor.create(string_literal156);
					adaptor.addChild(root_0, string_literal156_tree);
					}

					pushFollow(FOLLOW_durationConstraint_in_daDefBody1620);
					durationConstraint157=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint157.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					string_literal158=(Token)match(input,64,FOLLOW_64_in_daDefBody1625); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal158_tree = (Object)adaptor.create(string_literal158);
					adaptor.addChild(root_0, string_literal158_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:17: ( ( '(' ')' ) | daGD )
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==57) ) {
						int LA37_1 = input.LA(2);
						if ( (LA37_1==58) ) {
							alt37=1;
						}
						else if ( (LA37_1==92||LA37_1==94||LA37_1==102||(LA37_1 >= 113 && LA37_1 <= 114)) ) {
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
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:18: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:18: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:19: '(' ')'
							{
							char_literal159=(Token)match(input,57,FOLLOW_57_in_daDefBody1629); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal159_tree = (Object)adaptor.create(char_literal159);
							adaptor.addChild(root_0, char_literal159_tree);
							}

							char_literal160=(Token)match(input,58,FOLLOW_58_in_daDefBody1631); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal160_tree = (Object)adaptor.create(char_literal160);
							adaptor.addChild(root_0, char_literal160_tree);
							}

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:280:30: daGD
							{
							pushFollow(FOLLOW_daGD_in_daDefBody1636);
							daGD161=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD161.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					string_literal162=(Token)match(input,71,FOLLOW_71_in_daDefBody1645); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal162_tree = (Object)adaptor.create(string_literal162);
					adaptor.addChild(root_0, string_literal162_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:17: ( ( '(' ')' ) | daEffect )
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==57) ) {
						int LA38_1 = input.LA(2);
						if ( (LA38_1==58) ) {
							alt38=1;
						}
						else if ( ((LA38_1 >= 92 && LA38_1 <= 94)||LA38_1==96||LA38_1==102||LA38_1==106||(LA38_1 >= 116 && LA38_1 <= 117)||LA38_1==122) ) {
							alt38=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 38, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 38, 0, input);
						throw nvae;
					}

					switch (alt38) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:18: ( '(' ')' )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:18: ( '(' ')' )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:19: '(' ')'
							{
							char_literal163=(Token)match(input,57,FOLLOW_57_in_daDefBody1649); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal163_tree = (Object)adaptor.create(char_literal163);
							adaptor.addChild(root_0, char_literal163_tree);
							}

							char_literal164=(Token)match(input,58,FOLLOW_58_in_daDefBody1651); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal164_tree = (Object)adaptor.create(char_literal164);
							adaptor.addChild(root_0, char_literal164_tree);
							}

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:281:30: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daDefBody1656);
							daEffect165=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect165.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:284:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws RecognitionException {
		PddlParser.daGD_return retval = new PddlParser.daGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal167=null;
		Token string_literal168=null;
		Token char_literal170=null;
		Token char_literal171=null;
		Token string_literal172=null;
		Token char_literal173=null;
		Token char_literal175=null;
		Token char_literal177=null;
		ParserRuleReturnScope prefTimedGD166 =null;
		ParserRuleReturnScope daGD169 =null;
		ParserRuleReturnScope typedVariableList174 =null;
		ParserRuleReturnScope daGD176 =null;

		Object char_literal167_tree=null;
		Object string_literal168_tree=null;
		Object char_literal170_tree=null;
		Object char_literal171_tree=null;
		Object string_literal172_tree=null;
		Object char_literal173_tree=null;
		Object char_literal175_tree=null;
		Object char_literal177_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:285:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt41=3;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==57) ) {
				switch ( input.LA(2) ) {
				case 94:
				case 113:
				case 114:
					{
					alt41=1;
					}
					break;
				case 92:
					{
					alt41=2;
					}
					break;
				case 102:
					{
					alt41=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 41, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:285:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_prefTimedGD_in_daGD1671);
					prefTimedGD166=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD166.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:286:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal167=(Token)match(input,57,FOLLOW_57_in_daGD1676); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal167_tree = (Object)adaptor.create(char_literal167);
					adaptor.addChild(root_0, char_literal167_tree);
					}

					string_literal168=(Token)match(input,92,FOLLOW_92_in_daGD1678); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal168_tree = (Object)adaptor.create(string_literal168);
					adaptor.addChild(root_0, string_literal168_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:286:14: ( daGD )*
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==57) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:286:14: daGD
							{
							pushFollow(FOLLOW_daGD_in_daGD1680);
							daGD169=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD169.getTree());

							}
							break;

						default :
							break loop40;
						}
					}

					char_literal170=(Token)match(input,58,FOLLOW_58_in_daGD1683); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal170_tree = (Object)adaptor.create(char_literal170);
					adaptor.addChild(root_0, char_literal170_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:287:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal171=(Token)match(input,57,FOLLOW_57_in_daGD1688); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal171_tree = (Object)adaptor.create(char_literal171);
					adaptor.addChild(root_0, char_literal171_tree);
					}

					string_literal172=(Token)match(input,102,FOLLOW_102_in_daGD1690); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal172_tree = (Object)adaptor.create(string_literal172);
					adaptor.addChild(root_0, string_literal172_tree);
					}

					char_literal173=(Token)match(input,57,FOLLOW_57_in_daGD1692); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal173_tree = (Object)adaptor.create(char_literal173);
					adaptor.addChild(root_0, char_literal173_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daGD1694);
					typedVariableList174=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList174.getTree());

					char_literal175=(Token)match(input,58,FOLLOW_58_in_daGD1696); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal175_tree = (Object)adaptor.create(char_literal175);
					adaptor.addChild(root_0, char_literal175_tree);
					}

					pushFollow(FOLLOW_daGD_in_daGD1698);
					daGD176=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD176.getTree());

					char_literal177=(Token)match(input,58,FOLLOW_58_in_daGD1700); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal177_tree = (Object)adaptor.create(char_literal177);
					adaptor.addChild(root_0, char_literal177_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:290:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws RecognitionException {
		PddlParser.prefTimedGD_return retval = new PddlParser.prefTimedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal179=null;
		Token string_literal180=null;
		Token NAME181=null;
		Token char_literal183=null;
		ParserRuleReturnScope timedGD178 =null;
		ParserRuleReturnScope timedGD182 =null;

		Object char_literal179_tree=null;
		Object string_literal180_tree=null;
		Object NAME181_tree=null;
		Object char_literal183_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==57) ) {
				int LA43_1 = input.LA(2);
				if ( (LA43_1==94||LA43_1==113) ) {
					alt43=1;
				}
				else if ( (LA43_1==114) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:291:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedGD_in_prefTimedGD1711);
					timedGD178=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD178.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:292:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal179=(Token)match(input,57,FOLLOW_57_in_prefTimedGD1716); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal179_tree = (Object)adaptor.create(char_literal179);
					adaptor.addChild(root_0, char_literal179_tree);
					}

					string_literal180=(Token)match(input,114,FOLLOW_114_in_prefTimedGD1718); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal180_tree = (Object)adaptor.create(string_literal180);
					adaptor.addChild(root_0, string_literal180_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:292:21: ( NAME )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==NAME) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:292:21: NAME
							{
							NAME181=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD1720); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME181_tree = (Object)adaptor.create(NAME181);
							adaptor.addChild(root_0, NAME181_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_timedGD_in_prefTimedGD1723);
					timedGD182=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD182.getTree());

					char_literal183=(Token)match(input,58,FOLLOW_58_in_prefTimedGD1725); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal183_tree = (Object)adaptor.create(char_literal183);
					adaptor.addChild(root_0, char_literal183_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:295:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws RecognitionException {
		PddlParser.timedGD_return retval = new PddlParser.timedGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal184=null;
		Token string_literal185=null;
		Token char_literal188=null;
		Token char_literal189=null;
		Token string_literal190=null;
		Token char_literal193=null;
		ParserRuleReturnScope timeSpecifier186 =null;
		ParserRuleReturnScope goalDesc187 =null;
		ParserRuleReturnScope interval191 =null;
		ParserRuleReturnScope goalDesc192 =null;

		Object char_literal184_tree=null;
		Object string_literal185_tree=null;
		Object char_literal188_tree=null;
		Object char_literal189_tree=null;
		Object string_literal190_tree=null;
		Object char_literal193_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:296:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==57) ) {
				int LA44_1 = input.LA(2);
				if ( (LA44_1==94) ) {
					alt44=1;
				}
				else if ( (LA44_1==113) ) {
					alt44=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 44, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:296:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal184=(Token)match(input,57,FOLLOW_57_in_timedGD1736); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal184_tree = (Object)adaptor.create(char_literal184);
					adaptor.addChild(root_0, char_literal184_tree);
					}

					string_literal185=(Token)match(input,94,FOLLOW_94_in_timedGD1738); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal185_tree = (Object)adaptor.create(string_literal185);
					adaptor.addChild(root_0, string_literal185_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedGD1740);
					timeSpecifier186=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier186.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1742);
					goalDesc187=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc187.getTree());

					char_literal188=(Token)match(input,58,FOLLOW_58_in_timedGD1744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal188_tree = (Object)adaptor.create(char_literal188);
					adaptor.addChild(root_0, char_literal188_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:297:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal189=(Token)match(input,57,FOLLOW_57_in_timedGD1749); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal189_tree = (Object)adaptor.create(char_literal189);
					adaptor.addChild(root_0, char_literal189_tree);
					}

					string_literal190=(Token)match(input,113,FOLLOW_113_in_timedGD1751); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal190_tree = (Object)adaptor.create(string_literal190);
					adaptor.addChild(root_0, string_literal190_tree);
					}

					pushFollow(FOLLOW_interval_in_timedGD1753);
					interval191=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval191.getTree());

					pushFollow(FOLLOW_goalDesc_in_timedGD1755);
					goalDesc192=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc192.getTree());

					char_literal193=(Token)match(input,58,FOLLOW_58_in_timedGD1757); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal193_tree = (Object)adaptor.create(char_literal193);
					adaptor.addChild(root_0, char_literal193_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:300:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws RecognitionException {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set194=null;

		Object set194_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:300:15: ( 'start' | 'end' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set194=input.LT(1);
			if ( input.LA(1)==100||input.LA(1)==121 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set194));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:301:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws RecognitionException {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal195=null;

		Object string_literal195_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:301:10: ( 'all' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:301:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			string_literal195=(Token)match(input,89,FOLLOW_89_in_interval1779); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal195_tree = (Object)adaptor.create(string_literal195);
			adaptor.addChild(root_0, string_literal195_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:305:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws RecognitionException {
		PddlParser.derivedDef_return retval = new PddlParser.derivedDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal196=null;
		Token string_literal197=null;
		Token char_literal200=null;
		ParserRuleReturnScope typedVariableList198 =null;
		ParserRuleReturnScope goalDesc199 =null;

		Object char_literal196_tree=null;
		Object string_literal197_tree=null;
		Object char_literal200_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:306:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:306:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			char_literal196=(Token)match(input,57,FOLLOW_57_in_derivedDef1792); if (state.failed) return retval;
			string_literal197=(Token)match(input,67,FOLLOW_67_in_derivedDef1795); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal197_tree = (Object)adaptor.create(string_literal197);
			root_0 = (Object)adaptor.becomeRoot(string_literal197_tree, root_0);
			}

			pushFollow(FOLLOW_typedVariableList_in_derivedDef1798);
			typedVariableList198=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList198.getTree());

			pushFollow(FOLLOW_goalDesc_in_derivedDef1800);
			goalDesc199=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc199.getTree());

			char_literal200=(Token)match(input,58,FOLLOW_58_in_derivedDef1802); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:311:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws RecognitionException {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER201=null;
		Token char_literal202=null;
		Token char_literal206=null;
		Token char_literal207=null;
		Token char_literal208=null;
		Token char_literal210=null;
		ParserRuleReturnScope binaryOp203 =null;
		ParserRuleReturnScope fExp204 =null;
		ParserRuleReturnScope fExp2205 =null;
		ParserRuleReturnScope fExp209 =null;
		ParserRuleReturnScope fHead211 =null;

		Object NUMBER201_tree=null;
		Object char_literal202_tree=null;
		Object char_literal206_tree=null;
		Object char_literal207_tree=null;
		Object char_literal208_tree=null;
		Object char_literal210_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:312:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
			int alt45=4;
			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt45=1;
				}
				break;
			case 57:
				{
				int LA45_2 = input.LA(2);
				if ( (synpred58_Pddl()) ) {
					alt45=2;
				}
				else if ( (synpred59_Pddl()) ) {
					alt45=3;
				}
				else if ( (true) ) {
					alt45=4;
				}

				}
				break;
			case NAME:
				{
				alt45=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:312:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER201=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp1817); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER201_tree = (Object)adaptor.create(NUMBER201);
					adaptor.addChild(root_0, NUMBER201_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:313:4: '(' binaryOp fExp fExp2 ')'
					{
					char_literal202=(Token)match(input,57,FOLLOW_57_in_fExp1822); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal202);

					pushFollow(FOLLOW_binaryOp_in_fExp1824);
					binaryOp203=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp203.getTree());
					pushFollow(FOLLOW_fExp_in_fExp1826);
					fExp204=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp204.getTree());
					pushFollow(FOLLOW_fExp2_in_fExp1828);
					fExp2205=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2205.getTree());
					char_literal206=(Token)match(input,58,FOLLOW_58_in_fExp1830); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal206);

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
					// 313:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:313:35: ^( BINARY_OP binaryOp fExp fExp2 )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:4: '(' '-' fExp ')'
					{
					char_literal207=(Token)match(input,57,FOLLOW_57_in_fExp1847); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal207);

					char_literal208=(Token)match(input,61,FOLLOW_61_in_fExp1849); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_61.add(char_literal208);

					pushFollow(FOLLOW_fExp_in_fExp1851);
					fExp209=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp209.getTree());
					char_literal210=(Token)match(input,58,FOLLOW_58_in_fExp1853); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal210);

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
					// 314:21: -> ^( UNARY_MINUS fExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:24: ^( UNARY_MINUS fExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:315:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_fExp1866);
					fHead211=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead211.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:320:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws RecognitionException {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fExp212 =null;


		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:320:7: ( fExp )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:320:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_fExp_in_fExp21878);
			fExp212=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp212.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:322:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws RecognitionException {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal213=null;
		Token char_literal216=null;
		ParserRuleReturnScope functionSymbol214 =null;
		ParserRuleReturnScope term215 =null;
		ParserRuleReturnScope functionSymbol217 =null;

		Object char_literal213_tree=null;
		Object char_literal216_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==57) ) {
				alt47=1;
			}
			else if ( (LA47_0==NAME) ) {
				alt47=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:4: '(' functionSymbol ( term )* ')'
					{
					char_literal213=(Token)match(input,57,FOLLOW_57_in_fHead1888); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal213);

					pushFollow(FOLLOW_functionSymbol_in_fHead1890);
					functionSymbol214=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol214.getTree());
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:23: ( term )*
					loop46:
					while (true) {
						int alt46=2;
						int LA46_0 = input.LA(1);
						if ( (LA46_0==NAME||LA46_0==VARIABLE) ) {
							alt46=1;
						}

						switch (alt46) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:23: term
							{
							pushFollow(FOLLOW_term_in_fHead1892);
							term215=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term215.getTree());
							}
							break;

						default :
							break loop46;
						}
					}

					char_literal216=(Token)match(input,58,FOLLOW_58_in_fHead1895); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal216);

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
					// 323:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:323:63: ( term )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:324:4: functionSymbol
					{
					pushFollow(FOLLOW_functionSymbol_in_fHead1911);
					functionSymbol217=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol217.getTree());
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
					// 324:19: -> ^( FUNC_HEAD functionSymbol )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:324:22: ^( FUNC_HEAD functionSymbol )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:327:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws RecognitionException {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal218=null;
		Token string_literal219=null;
		Token char_literal221=null;
		ParserRuleReturnScope cEffect220 =null;
		ParserRuleReturnScope cEffect222 =null;

		Object char_literal218_tree=null;
		Object string_literal219_tree=null;
		Object char_literal221_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==57) ) {
				int LA49_1 = input.LA(2);
				if ( (LA49_1==92) ) {
					alt49=1;
				}
				else if ( (LA49_1==NAME||LA49_1==93||LA49_1==96||LA49_1==102||LA49_1==106||LA49_1==110||(LA49_1 >= 116 && LA49_1 <= 117)||LA49_1==122) ) {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:4: '(' 'and' ( cEffect )* ')'
					{
					char_literal218=(Token)match(input,57,FOLLOW_57_in_effect1930); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal218);

					string_literal219=(Token)match(input,92,FOLLOW_92_in_effect1932); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal219);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:14: ( cEffect )*
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==57) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:14: cEffect
							{
							pushFollow(FOLLOW_cEffect_in_effect1934);
							cEffect220=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect220.getTree());
							}
							break;

						default :
							break loop48;
						}
					}

					char_literal221=(Token)match(input,58,FOLLOW_58_in_effect1937); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal221);

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
					// 328:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:328:43: ( cEffect )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:329:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cEffect_in_effect1951);
					cEffect222=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect222.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:332:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws RecognitionException {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal223=null;
		Token string_literal224=null;
		Token char_literal225=null;
		Token char_literal227=null;
		Token char_literal229=null;
		Token char_literal230=null;
		Token string_literal231=null;
		Token char_literal234=null;
		ParserRuleReturnScope typedVariableList226 =null;
		ParserRuleReturnScope effect228 =null;
		ParserRuleReturnScope goalDesc232 =null;
		ParserRuleReturnScope condEffect233 =null;
		ParserRuleReturnScope pEffect235 =null;

		Object char_literal223_tree=null;
		Object string_literal224_tree=null;
		Object char_literal225_tree=null;
		Object char_literal227_tree=null;
		Object char_literal229_tree=null;
		Object char_literal230_tree=null;
		Object string_literal231_tree=null;
		Object char_literal234_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:333:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt50=3;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==57) ) {
				switch ( input.LA(2) ) {
				case 102:
					{
					alt50=1;
					}
					break;
				case 122:
					{
					alt50=2;
					}
					break;
				case NAME:
				case 93:
				case 96:
				case 106:
				case 110:
				case 116:
				case 117:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:333:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					char_literal223=(Token)match(input,57,FOLLOW_57_in_cEffect1962); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal223);

					string_literal224=(Token)match(input,102,FOLLOW_102_in_cEffect1964); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_102.add(string_literal224);

					char_literal225=(Token)match(input,57,FOLLOW_57_in_cEffect1966); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal225);

					pushFollow(FOLLOW_typedVariableList_in_cEffect1968);
					typedVariableList226=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList226.getTree());
					char_literal227=(Token)match(input,58,FOLLOW_58_in_cEffect1970); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal227);

					pushFollow(FOLLOW_effect_in_cEffect1972);
					effect228=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect228.getTree());
					char_literal229=(Token)match(input,58,FOLLOW_58_in_cEffect1974); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal229);

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
					// 334:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:334:7: ^( FORALL_EFFECT typedVariableList effect )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:335:4: '(' 'when' goalDesc condEffect ')'
					{
					char_literal230=(Token)match(input,57,FOLLOW_57_in_cEffect1992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal230);

					string_literal231=(Token)match(input,122,FOLLOW_122_in_cEffect1994); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_122.add(string_literal231);

					pushFollow(FOLLOW_goalDesc_in_cEffect1996);
					goalDesc232=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc232.getTree());
					pushFollow(FOLLOW_condEffect_in_cEffect1998);
					condEffect233=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect233.getTree());
					char_literal234=(Token)match(input,58,FOLLOW_58_in_cEffect2000); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal234);

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
					// 336:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:336:7: ^( WHEN_EFFECT goalDesc condEffect )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:337:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_cEffect2018);
					pEffect235=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect235.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:340:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws RecognitionException {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal236=null;
		Token char_literal240=null;
		Token char_literal241=null;
		Token string_literal242=null;
		Token char_literal244=null;
		ParserRuleReturnScope assignOp237 =null;
		ParserRuleReturnScope fHead238 =null;
		ParserRuleReturnScope fExp239 =null;
		ParserRuleReturnScope atomicTermFormula243 =null;
		ParserRuleReturnScope atomicTermFormula245 =null;

		Object char_literal236_tree=null;
		Object char_literal240_tree=null;
		Object char_literal241_tree=null;
		Object string_literal242_tree=null;
		Object char_literal244_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt51=3;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==57) ) {
				switch ( input.LA(2) ) {
				case 110:
					{
					alt51=2;
					}
					break;
				case 93:
				case 96:
				case 106:
				case 116:
				case 117:
					{
					alt51=1;
					}
					break;
				case NAME:
					{
					alt51=3;
					}
					break;
				default:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:341:4: '(' assignOp fHead fExp ')'
					{
					char_literal236=(Token)match(input,57,FOLLOW_57_in_pEffect2029); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal236);

					pushFollow(FOLLOW_assignOp_in_pEffect2031);
					assignOp237=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp237.getTree());
					pushFollow(FOLLOW_fHead_in_pEffect2033);
					fHead238=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead238.getTree());
					pushFollow(FOLLOW_fExp_in_pEffect2035);
					fExp239=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp239.getTree());
					char_literal240=(Token)match(input,58,FOLLOW_58_in_pEffect2037); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal240);

					// AST REWRITE
					// elements: assignOp, fHead, fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 342:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:342:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:343:4: '(' 'not' atomicTermFormula ')'
					{
					char_literal241=(Token)match(input,57,FOLLOW_57_in_pEffect2057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal241);

					string_literal242=(Token)match(input,110,FOLLOW_110_in_pEffect2059); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_110.add(string_literal242);

					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2061);
					atomicTermFormula243=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula243.getTree());
					char_literal244=(Token)match(input,58,FOLLOW_58_in_pEffect2063); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal244);

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
					// 344:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:344:7: ^( NOT_EFFECT atomicTermFormula )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:345:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2079);
					atomicTermFormula245=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula245.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:350:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws RecognitionException {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal246=null;
		Token string_literal247=null;
		Token char_literal249=null;
		ParserRuleReturnScope pEffect248 =null;
		ParserRuleReturnScope pEffect250 =null;

		Object char_literal246_tree=null;
		Object string_literal247_tree=null;
		Object char_literal249_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==57) ) {
				int LA53_1 = input.LA(2);
				if ( (LA53_1==92) ) {
					alt53=1;
				}
				else if ( (LA53_1==NAME||LA53_1==93||LA53_1==96||LA53_1==106||LA53_1==110||(LA53_1 >= 116 && LA53_1 <= 117)) ) {
					alt53=2;
				}

				else {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:4: '(' 'and' ( pEffect )* ')'
					{
					char_literal246=(Token)match(input,57,FOLLOW_57_in_condEffect2092); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal246);

					string_literal247=(Token)match(input,92,FOLLOW_92_in_condEffect2094); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_92.add(string_literal247);

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:14: ( pEffect )*
					loop52:
					while (true) {
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( (LA52_0==57) ) {
							alt52=1;
						}

						switch (alt52) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:14: pEffect
							{
							pushFollow(FOLLOW_pEffect_in_condEffect2096);
							pEffect248=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect248.getTree());
							}
							break;

						default :
							break loop52;
						}
					}

					char_literal249=(Token)match(input,58,FOLLOW_58_in_condEffect2099); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal249);

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
					// 351:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:351:43: ( pEffect )*
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:352:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pEffect_in_condEffect2113);
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
	// $ANTLR end "condEffect"


	public static class binaryOp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binaryOp"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:356:1: binaryOp : ( '*' | '+' | '-' | '/' );
	public final PddlParser.binaryOp_return binaryOp() throws RecognitionException {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set251=null;

		Object set251_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:356:10: ( '*' | '+' | '-' | '/' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set251=input.LT(1);
			if ( (input.LA(1) >= 59 && input.LA(1) <= 62) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set251));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:358:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws RecognitionException {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set252=null;

		Object set252_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:358:9: ( '*' | '+' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set252=input.LT(1);
			if ( (input.LA(1) >= 59 && input.LA(1) <= 60) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set252));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:360:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws RecognitionException {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set253=null;

		Object set253_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:360:12: ( '>' | '<' | '=' | '>=' | '<=' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set253=input.LT(1);
			if ( (input.LA(1) >= 83 && input.LA(1) <= 87) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set253));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:362:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws RecognitionException {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set254=null;

		Object set254_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:362:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set254=input.LT(1);
			if ( input.LA(1)==93||input.LA(1)==96||input.LA(1)==106||(input.LA(1) >= 116 && input.LA(1) <= 117) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set254));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:367:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws RecognitionException {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal255=null;
		Token string_literal256=null;
		Token char_literal258=null;
		Token char_literal259=null;
		Token char_literal260=null;
		ParserRuleReturnScope simpleDurationConstraint257 =null;
		ParserRuleReturnScope simpleDurationConstraint261 =null;

		Object char_literal255_tree=null;
		Object string_literal256_tree=null;
		Object char_literal258_tree=null;
		Object char_literal259_tree=null;
		Object char_literal260_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:368:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt55=3;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==57) ) {
				switch ( input.LA(2) ) {
				case 92:
					{
					alt55=1;
					}
					break;
				case 58:
					{
					alt55=2;
					}
					break;
				case 84:
				case 85:
				case 87:
				case 94:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:368:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal255=(Token)match(input,57,FOLLOW_57_in_durationConstraint2214); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal255_tree = (Object)adaptor.create(char_literal255);
					adaptor.addChild(root_0, char_literal255_tree);
					}

					string_literal256=(Token)match(input,92,FOLLOW_92_in_durationConstraint2216); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal256_tree = (Object)adaptor.create(string_literal256);
					adaptor.addChild(root_0, string_literal256_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:368:14: ( simpleDurationConstraint )+
					int cnt54=0;
					loop54:
					while (true) {
						int alt54=2;
						int LA54_0 = input.LA(1);
						if ( (LA54_0==57) ) {
							alt54=1;
						}

						switch (alt54) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:368:14: simpleDurationConstraint
							{
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2218);
							simpleDurationConstraint257=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint257.getTree());

							}
							break;

						default :
							if ( cnt54 >= 1 ) break loop54;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(54, input);
							throw eee;
						}
						cnt54++;
					}

					char_literal258=(Token)match(input,58,FOLLOW_58_in_durationConstraint2221); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal258_tree = (Object)adaptor.create(char_literal258);
					adaptor.addChild(root_0, char_literal258_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:369:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal259=(Token)match(input,57,FOLLOW_57_in_durationConstraint2226); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal259_tree = (Object)adaptor.create(char_literal259);
					adaptor.addChild(root_0, char_literal259_tree);
					}

					char_literal260=(Token)match(input,58,FOLLOW_58_in_durationConstraint2228); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal260_tree = (Object)adaptor.create(char_literal260);
					adaptor.addChild(root_0, char_literal260_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:370:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2233);
					simpleDurationConstraint261=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint261.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:373:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws RecognitionException {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal262=null;
		Token string_literal264=null;
		Token char_literal266=null;
		Token char_literal267=null;
		Token string_literal268=null;
		Token char_literal271=null;
		ParserRuleReturnScope durOp263 =null;
		ParserRuleReturnScope durValue265 =null;
		ParserRuleReturnScope timeSpecifier269 =null;
		ParserRuleReturnScope simpleDurationConstraint270 =null;

		Object char_literal262_tree=null;
		Object string_literal264_tree=null;
		Object char_literal266_tree=null;
		Object char_literal267_tree=null;
		Object string_literal268_tree=null;
		Object char_literal271_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:374:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==57) ) {
				int LA56_1 = input.LA(2);
				if ( (LA56_1==94) ) {
					alt56=2;
				}
				else if ( ((LA56_1 >= 84 && LA56_1 <= 85)||LA56_1==87) ) {
					alt56=1;
				}

				else {
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:374:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal262=(Token)match(input,57,FOLLOW_57_in_simpleDurationConstraint2244); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal262_tree = (Object)adaptor.create(char_literal262);
					adaptor.addChild(root_0, char_literal262_tree);
					}

					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2246);
					durOp263=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp263.getTree());

					string_literal264=(Token)match(input,88,FOLLOW_88_in_simpleDurationConstraint2248); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal264_tree = (Object)adaptor.create(string_literal264);
					adaptor.addChild(root_0, string_literal264_tree);
					}

					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2250);
					durValue265=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue265.getTree());

					char_literal266=(Token)match(input,58,FOLLOW_58_in_simpleDurationConstraint2252); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal266_tree = (Object)adaptor.create(char_literal266);
					adaptor.addChild(root_0, char_literal266_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:375:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal267=(Token)match(input,57,FOLLOW_57_in_simpleDurationConstraint2257); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal267_tree = (Object)adaptor.create(char_literal267);
					adaptor.addChild(root_0, char_literal267_tree);
					}

					string_literal268=(Token)match(input,94,FOLLOW_94_in_simpleDurationConstraint2259); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal268_tree = (Object)adaptor.create(string_literal268);
					adaptor.addChild(root_0, string_literal268_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2261);
					timeSpecifier269=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier269.getTree());

					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2263);
					simpleDurationConstraint270=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint270.getTree());

					char_literal271=(Token)match(input,58,FOLLOW_58_in_simpleDurationConstraint2265); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal271_tree = (Object)adaptor.create(char_literal271);
					adaptor.addChild(root_0, char_literal271_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:378:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws RecognitionException {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set272=null;

		Object set272_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:378:7: ( '<=' | '>=' | '=' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set272=input.LT(1);
			if ( (input.LA(1) >= 84 && input.LA(1) <= 85)||input.LA(1)==87 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set272));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws RecognitionException {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER273=null;
		ParserRuleReturnScope fExp274 =null;

		Object NUMBER273_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:10: ( NUMBER | fExp )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==NUMBER) ) {
				int LA57_1 = input.LA(2);
				if ( (synpred88_Pddl()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

			}
			else if ( (LA57_0==NAME||LA57_0==57) ) {
				alt57=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER273=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2292); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER273_tree = (Object)adaptor.create(NUMBER273);
					adaptor.addChild(root_0, NUMBER273_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_durValue2296);
					fExp274=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp274.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:382:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws RecognitionException {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal275=null;
		Token string_literal276=null;
		Token char_literal278=null;
		Token char_literal280=null;
		Token string_literal281=null;
		Token char_literal282=null;
		Token char_literal284=null;
		Token char_literal286=null;
		Token char_literal287=null;
		Token string_literal288=null;
		Token char_literal291=null;
		Token char_literal292=null;
		Token char_literal296=null;
		ParserRuleReturnScope daEffect277 =null;
		ParserRuleReturnScope timedEffect279 =null;
		ParserRuleReturnScope typedVariableList283 =null;
		ParserRuleReturnScope daEffect285 =null;
		ParserRuleReturnScope daGD289 =null;
		ParserRuleReturnScope timedEffect290 =null;
		ParserRuleReturnScope assignOp293 =null;
		ParserRuleReturnScope fHead294 =null;
		ParserRuleReturnScope fExpDA295 =null;

		Object char_literal275_tree=null;
		Object string_literal276_tree=null;
		Object char_literal278_tree=null;
		Object char_literal280_tree=null;
		Object string_literal281_tree=null;
		Object char_literal282_tree=null;
		Object char_literal284_tree=null;
		Object char_literal286_tree=null;
		Object char_literal287_tree=null;
		Object string_literal288_tree=null;
		Object char_literal291_tree=null;
		Object char_literal292_tree=null;
		Object char_literal296_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt59=5;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==57) ) {
				int LA59_1 = input.LA(2);
				if ( (synpred90_Pddl()) ) {
					alt59=1;
				}
				else if ( (synpred91_Pddl()) ) {
					alt59=2;
				}
				else if ( (synpred92_Pddl()) ) {
					alt59=3;
				}
				else if ( (synpred93_Pddl()) ) {
					alt59=4;
				}
				else if ( (true) ) {
					alt59=5;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal275=(Token)match(input,57,FOLLOW_57_in_daEffect2306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal275_tree = (Object)adaptor.create(char_literal275);
					adaptor.addChild(root_0, char_literal275_tree);
					}

					string_literal276=(Token)match(input,92,FOLLOW_92_in_daEffect2308); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal276_tree = (Object)adaptor.create(string_literal276);
					adaptor.addChild(root_0, string_literal276_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:14: ( daEffect )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==57) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:14: daEffect
							{
							pushFollow(FOLLOW_daEffect_in_daEffect2310);
							daEffect277=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect277.getTree());

							}
							break;

						default :
							break loop58;
						}
					}

					char_literal278=(Token)match(input,58,FOLLOW_58_in_daEffect2313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal278_tree = (Object)adaptor.create(char_literal278);
					adaptor.addChild(root_0, char_literal278_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:384:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_timedEffect_in_daEffect2318);
					timedEffect279=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect279.getTree());

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:385:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal280=(Token)match(input,57,FOLLOW_57_in_daEffect2323); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal280_tree = (Object)adaptor.create(char_literal280);
					adaptor.addChild(root_0, char_literal280_tree);
					}

					string_literal281=(Token)match(input,102,FOLLOW_102_in_daEffect2325); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal281_tree = (Object)adaptor.create(string_literal281);
					adaptor.addChild(root_0, string_literal281_tree);
					}

					char_literal282=(Token)match(input,57,FOLLOW_57_in_daEffect2327); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal282_tree = (Object)adaptor.create(char_literal282);
					adaptor.addChild(root_0, char_literal282_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_daEffect2329);
					typedVariableList283=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList283.getTree());

					char_literal284=(Token)match(input,58,FOLLOW_58_in_daEffect2331); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal284_tree = (Object)adaptor.create(char_literal284);
					adaptor.addChild(root_0, char_literal284_tree);
					}

					pushFollow(FOLLOW_daEffect_in_daEffect2333);
					daEffect285=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect285.getTree());

					char_literal286=(Token)match(input,58,FOLLOW_58_in_daEffect2335); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal286_tree = (Object)adaptor.create(char_literal286);
					adaptor.addChild(root_0, char_literal286_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal287=(Token)match(input,57,FOLLOW_57_in_daEffect2340); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal287_tree = (Object)adaptor.create(char_literal287);
					adaptor.addChild(root_0, char_literal287_tree);
					}

					string_literal288=(Token)match(input,122,FOLLOW_122_in_daEffect2342); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal288_tree = (Object)adaptor.create(string_literal288);
					adaptor.addChild(root_0, string_literal288_tree);
					}

					pushFollow(FOLLOW_daGD_in_daEffect2344);
					daGD289=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD289.getTree());

					pushFollow(FOLLOW_timedEffect_in_daEffect2346);
					timedEffect290=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect290.getTree());

					char_literal291=(Token)match(input,58,FOLLOW_58_in_daEffect2348); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal291_tree = (Object)adaptor.create(char_literal291);
					adaptor.addChild(root_0, char_literal291_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:387:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal292=(Token)match(input,57,FOLLOW_57_in_daEffect2353); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal292_tree = (Object)adaptor.create(char_literal292);
					adaptor.addChild(root_0, char_literal292_tree);
					}

					pushFollow(FOLLOW_assignOp_in_daEffect2355);
					assignOp293=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp293.getTree());

					pushFollow(FOLLOW_fHead_in_daEffect2357);
					fHead294=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead294.getTree());

					pushFollow(FOLLOW_fExpDA_in_daEffect2359);
					fExpDA295=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA295.getTree());

					char_literal296=(Token)match(input,58,FOLLOW_58_in_daEffect2361); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal296_tree = (Object)adaptor.create(char_literal296);
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
	// $ANTLR end "daEffect"


	public static class timedEffect_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "timedEffect"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:390:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws RecognitionException {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal297=null;
		Token string_literal298=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token string_literal303=null;
		Token char_literal306=null;
		Token char_literal307=null;
		Token char_literal311=null;
		ParserRuleReturnScope timeSpecifier299 =null;
		ParserRuleReturnScope daEffect300 =null;
		ParserRuleReturnScope timeSpecifier304 =null;
		ParserRuleReturnScope fAssignDA305 =null;
		ParserRuleReturnScope assignOp308 =null;
		ParserRuleReturnScope fHead309 =null;
		ParserRuleReturnScope fExp310 =null;

		Object char_literal297_tree=null;
		Object string_literal298_tree=null;
		Object char_literal301_tree=null;
		Object char_literal302_tree=null;
		Object string_literal303_tree=null;
		Object char_literal306_tree=null;
		Object char_literal307_tree=null;
		Object char_literal311_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:391:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt60=3;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==57) ) {
				int LA60_1 = input.LA(2);
				if ( (synpred94_Pddl()) ) {
					alt60=1;
				}
				else if ( (synpred95_Pddl()) ) {
					alt60=2;
				}
				else if ( (true) ) {
					alt60=3;
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:391:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal297=(Token)match(input,57,FOLLOW_57_in_timedEffect2372); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal297_tree = (Object)adaptor.create(char_literal297);
					adaptor.addChild(root_0, char_literal297_tree);
					}

					string_literal298=(Token)match(input,94,FOLLOW_94_in_timedEffect2374); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal298_tree = (Object)adaptor.create(string_literal298);
					adaptor.addChild(root_0, string_literal298_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2376);
					timeSpecifier299=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier299.getTree());

					pushFollow(FOLLOW_daEffect_in_timedEffect2378);
					daEffect300=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect300.getTree());

					char_literal301=(Token)match(input,58,FOLLOW_58_in_timedEffect2380); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:392:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal302=(Token)match(input,57,FOLLOW_57_in_timedEffect2390); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal302_tree = (Object)adaptor.create(char_literal302);
					adaptor.addChild(root_0, char_literal302_tree);
					}

					string_literal303=(Token)match(input,94,FOLLOW_94_in_timedEffect2392); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal303_tree = (Object)adaptor.create(string_literal303);
					adaptor.addChild(root_0, string_literal303_tree);
					}

					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2394);
					timeSpecifier304=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier304.getTree());

					pushFollow(FOLLOW_fAssignDA_in_timedEffect2396);
					fAssignDA305=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA305.getTree());

					char_literal306=(Token)match(input,58,FOLLOW_58_in_timedEffect2398); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal306_tree = (Object)adaptor.create(char_literal306);
					adaptor.addChild(root_0, char_literal306_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:393:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal307=(Token)match(input,57,FOLLOW_57_in_timedEffect2403); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal307_tree = (Object)adaptor.create(char_literal307);
					adaptor.addChild(root_0, char_literal307_tree);
					}

					pushFollow(FOLLOW_assignOp_in_timedEffect2405);
					assignOp308=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp308.getTree());

					pushFollow(FOLLOW_fHead_in_timedEffect2407);
					fHead309=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead309.getTree());

					pushFollow(FOLLOW_fExp_in_timedEffect2409);
					fExp310=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp310.getTree());

					char_literal311=(Token)match(input,58,FOLLOW_58_in_timedEffect2411); if (state.failed) return retval;
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
	// $ANTLR end "timedEffect"


	public static class fAssignDA_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fAssignDA"
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:396:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws RecognitionException {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal312=null;
		Token char_literal316=null;
		ParserRuleReturnScope assignOp313 =null;
		ParserRuleReturnScope fHead314 =null;
		ParserRuleReturnScope fExpDA315 =null;

		Object char_literal312_tree=null;
		Object char_literal316_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:397:2: ( '(' assignOp fHead fExpDA ')' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:397:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			char_literal312=(Token)match(input,57,FOLLOW_57_in_fAssignDA2431); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal312_tree = (Object)adaptor.create(char_literal312);
			adaptor.addChild(root_0, char_literal312_tree);
			}

			pushFollow(FOLLOW_assignOp_in_fAssignDA2433);
			assignOp313=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp313.getTree());

			pushFollow(FOLLOW_fHead_in_fAssignDA2435);
			fHead314=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead314.getTree());

			pushFollow(FOLLOW_fExpDA_in_fAssignDA2437);
			fExpDA315=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA315.getTree());

			char_literal316=(Token)match(input,58,FOLLOW_58_in_fAssignDA2439); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal316_tree = (Object)adaptor.create(char_literal316);
			adaptor.addChild(root_0, char_literal316_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:400:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws RecognitionException {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal317=null;
		Token char_literal321=null;
		Token char_literal323=null;
		Token string_literal324=null;
		ParserRuleReturnScope binaryOp318 =null;
		ParserRuleReturnScope fExpDA319 =null;
		ParserRuleReturnScope fExpDA320 =null;
		ParserRuleReturnScope fExpDA322 =null;
		ParserRuleReturnScope fExp325 =null;

		Object char_literal317_tree=null;
		Object char_literal321_tree=null;
		Object char_literal323_tree=null;
		Object string_literal324_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt62=3;
			switch ( input.LA(1) ) {
			case 57:
				{
				int LA62_1 = input.LA(2);
				if ( (synpred97_Pddl()) ) {
					alt62=1;
				}
				else if ( (true) ) {
					alt62=3;
				}

				}
				break;
			case 88:
				{
				alt62=2;
				}
				break;
			case NAME:
			case NUMBER:
				{
				alt62=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}
			switch (alt62) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal317=(Token)match(input,57,FOLLOW_57_in_fExpDA2450); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal317_tree = (Object)adaptor.create(char_literal317);
					adaptor.addChild(root_0, char_literal317_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt61=2;
					int LA61_0 = input.LA(1);
					if ( (LA61_0==61) ) {
						int LA61_1 = input.LA(2);
						if ( (synpred96_Pddl()) ) {
							alt61=1;
						}
						else if ( (true) ) {
							alt61=2;
						}

					}
					else if ( ((LA61_0 >= 59 && LA61_0 <= 60)||LA61_0==62) ) {
						alt61=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 61, 0, input);
						throw nvae;
					}

					switch (alt61) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:10: binaryOp fExpDA fExpDA
							{
							pushFollow(FOLLOW_binaryOp_in_fExpDA2454);
							binaryOp318=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp318.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2456);
							fExpDA319=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA319.getTree());

							pushFollow(FOLLOW_fExpDA_in_fExpDA2458);
							fExpDA320=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA320.getTree());

							}

							}
							break;
						case 2 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:36: ( '-' fExpDA )
							{
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:36: ( '-' fExpDA )
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:37: '-' fExpDA
							{
							char_literal321=(Token)match(input,61,FOLLOW_61_in_fExpDA2464); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal321_tree = (Object)adaptor.create(char_literal321);
							adaptor.addChild(root_0, char_literal321_tree);
							}

							pushFollow(FOLLOW_fExpDA_in_fExpDA2466);
							fExpDA322=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA322.getTree());

							}

							}
							break;

					}

					char_literal323=(Token)match(input,58,FOLLOW_58_in_fExpDA2470); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal323_tree = (Object)adaptor.create(char_literal323);
					adaptor.addChild(root_0, char_literal323_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:402:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					string_literal324=(Token)match(input,88,FOLLOW_88_in_fExpDA2475); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal324_tree = (Object)adaptor.create(string_literal324);
					adaptor.addChild(root_0, string_literal324_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:403:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fExp_in_fExpDA2480);
					fExp325=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp325.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:408:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws RecognitionException {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal326=null;
		Token string_literal327=null;
		Token char_literal336=null;
		ParserRuleReturnScope problemDecl328 =null;
		ParserRuleReturnScope problemDomain329 =null;
		ParserRuleReturnScope requireDef330 =null;
		ParserRuleReturnScope objectDecl331 =null;
		ParserRuleReturnScope init332 =null;
		ParserRuleReturnScope goal333 =null;
		ParserRuleReturnScope probConstraints334 =null;
		ParserRuleReturnScope metricSpec335 =null;

		Object char_literal326_tree=null;
		Object string_literal327_tree=null;
		Object char_literal336_tree=null;
		RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:409:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			char_literal326=(Token)match(input,57,FOLLOW_57_in_problem2494); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal326);

			string_literal327=(Token)match(input,97,FOLLOW_97_in_problem2496); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_97.add(string_literal327);

			pushFollow(FOLLOW_problemDecl_in_problem2498);
			problemDecl328=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl328.getTree());
			pushFollow(FOLLOW_problemDomain_in_problem2503);
			problemDomain329=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain329.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:411:7: ( requireDef )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==57) ) {
				int LA63_1 = input.LA(2);
				if ( (LA63_1==81) ) {
					alt63=1;
				}
			}
			switch (alt63) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:411:7: requireDef
					{
					pushFollow(FOLLOW_requireDef_in_problem2511);
					requireDef330=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef330.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:412:7: ( objectDecl )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==57) ) {
				int LA64_1 = input.LA(2);
				if ( (LA64_1==77) ) {
					alt64=1;
				}
			}
			switch (alt64) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:412:7: objectDecl
					{
					pushFollow(FOLLOW_objectDecl_in_problem2520);
					objectDecl331=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl331.getTree());
					}
					break;

			}

			pushFollow(FOLLOW_init_in_problem2529);
			init332=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init332.getTree());
			pushFollow(FOLLOW_goal_in_problem2537);
			goal333=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal333.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:415:7: ( probConstraints )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==57) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==66) ) {
					alt65=1;
				}
			}
			switch (alt65) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:415:7: probConstraints
					{
					pushFollow(FOLLOW_probConstraints_in_problem2545);
					probConstraints334=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints334.getTree());
					}
					break;

			}

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:416:7: ( metricSpec )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==57) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:416:7: metricSpec
					{
					pushFollow(FOLLOW_metricSpec_in_problem2554);
					metricSpec335=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec335.getTree());
					}
					break;

			}

			char_literal336=(Token)match(input,58,FOLLOW_58_in_problem2570); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal336);

			// AST REWRITE
			// elements: problemDecl, goal, problemDomain, probConstraints, requireDef, metricSpec, init, objectDecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 419:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());
				adaptor.addChild(root_1, stream_problemDomain.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:419:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();

				adaptor.addChild(root_1, stream_init.nextTree());
				adaptor.addChild(root_1, stream_goal.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:420:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();

				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:420:36: ( metricSpec )?
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:423:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws RecognitionException {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal337=null;
		Token string_literal338=null;
		Token NAME339=null;
		Token char_literal340=null;

		Object char_literal337_tree=null;
		Object string_literal338_tree=null;
		Object NAME339_tree=null;
		Object char_literal340_tree=null;
		RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:424:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:424:7: '(' 'problem' NAME ')'
			{
			char_literal337=(Token)match(input,57,FOLLOW_57_in_problemDecl2627); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal337);

			string_literal338=(Token)match(input,115,FOLLOW_115_in_problemDecl2629); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_115.add(string_literal338);

			NAME339=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2631); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME339);

			char_literal340=(Token)match(input,58,FOLLOW_58_in_problemDecl2633); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal340);

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
			// 425:5: -> ^( PROBLEM_NAME NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:425:8: ^( PROBLEM_NAME NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:428:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws RecognitionException {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal341=null;
		Token string_literal342=null;
		Token NAME343=null;
		Token char_literal344=null;

		Object char_literal341_tree=null;
		Object string_literal342_tree=null;
		Object NAME343_tree=null;
		Object char_literal344_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:429:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:429:4: '(' ':domain' NAME ')'
			{
			char_literal341=(Token)match(input,57,FOLLOW_57_in_problemDomain2659); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal341);

			string_literal342=(Token)match(input,68,FOLLOW_68_in_problemDomain2661); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(string_literal342);

			NAME343=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain2663); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME343);

			char_literal344=(Token)match(input,58,FOLLOW_58_in_problemDomain2665); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal344);

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
			// 430:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:430:5: ^( PROBLEM_DOMAIN NAME )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:433:1: objectDecl : '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) ;
	public final PddlParser.objectDecl_return objectDecl() throws RecognitionException {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal345=null;
		Token string_literal346=null;
		Token char_literal348=null;
		ParserRuleReturnScope typedNameList347 =null;

		Object char_literal345_tree=null;
		Object string_literal346_tree=null;
		Object char_literal348_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:434:2: ( '(' ':objects' typedNameList ')' -> ^( OBJECTS typedNameList ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:434:4: '(' ':objects' typedNameList ')'
			{
			char_literal345=(Token)match(input,57,FOLLOW_57_in_objectDecl2685); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal345);

			string_literal346=(Token)match(input,77,FOLLOW_77_in_objectDecl2687); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_77.add(string_literal346);

			pushFollow(FOLLOW_typedNameList_in_objectDecl2689);
			typedNameList347=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList347.getTree());
			char_literal348=(Token)match(input,58,FOLLOW_58_in_objectDecl2691); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal348);

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
			// 435:2: -> ^( OBJECTS typedNameList )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:435:5: ^( OBJECTS typedNameList )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:438:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
	public final PddlParser.init_return init() throws RecognitionException {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal349=null;
		Token string_literal350=null;
		Token char_literal352=null;
		ParserRuleReturnScope initEl351 =null;

		Object char_literal349_tree=null;
		Object string_literal350_tree=null;
		Object char_literal352_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:439:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:439:4: '(' ':init' ( initEl )* ')'
			{
			char_literal349=(Token)match(input,57,FOLLOW_57_in_init2711); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal349);

			string_literal350=(Token)match(input,75,FOLLOW_75_in_init2713); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_75.add(string_literal350);

			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:439:16: ( initEl )*
			loop67:
			while (true) {
				int alt67=2;
				int LA67_0 = input.LA(1);
				if ( (LA67_0==57) ) {
					alt67=1;
				}

				switch (alt67) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:439:16: initEl
					{
					pushFollow(FOLLOW_initEl_in_init2715);
					initEl351=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl351.getTree());
					}
					break;

				default :
					break loop67;
				}
			}

			char_literal352=(Token)match(input,58,FOLLOW_58_in_init2718); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal352);

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
			// 440:2: -> ^( INIT ( initEl )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:440:5: ^( INIT ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:440:12: ( initEl )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:443:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
	public final PddlParser.initEl_return initEl() throws RecognitionException {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal354=null;
		Token char_literal355=null;
		Token NUMBER357=null;
		Token char_literal358=null;
		Token char_literal359=null;
		Token string_literal360=null;
		Token NUMBER361=null;
		Token char_literal363=null;
		ParserRuleReturnScope nameLiteral353 =null;
		ParserRuleReturnScope fHead356 =null;
		ParserRuleReturnScope nameLiteral362 =null;

		Object char_literal354_tree=null;
		Object char_literal355_tree=null;
		Object NUMBER357_tree=null;
		Object char_literal358_tree=null;
		Object char_literal359_tree=null;
		Object string_literal360_tree=null;
		Object NUMBER361_tree=null;
		Object char_literal363_tree=null;
		RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:444:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
			int alt68=3;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==57) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 110:
					{
					alt68=1;
					}
					break;
				case 85:
					{
					alt68=2;
					}
					break;
				case 94:
					{
					alt68=3;
					}
					break;
				default:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:444:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nameLiteral_in_initEl2739);
					nameLiteral353=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral353.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:445:4: '(' '=' fHead NUMBER ')'
					{
					char_literal354=(Token)match(input,57,FOLLOW_57_in_initEl2744); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal354);

					char_literal355=(Token)match(input,85,FOLLOW_85_in_initEl2746); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_85.add(char_literal355);

					pushFollow(FOLLOW_fHead_in_initEl2748);
					fHead356=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead356.getTree());
					NUMBER357=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2750); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER357);

					char_literal358=(Token)match(input,58,FOLLOW_58_in_initEl2752); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal358);

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
					// 445:37: -> ^( INIT_EQ fHead NUMBER )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:445:40: ^( INIT_EQ fHead NUMBER )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:446:4: '(' 'at' NUMBER nameLiteral ')'
					{
					char_literal359=(Token)match(input,57,FOLLOW_57_in_initEl2775); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal359);

					string_literal360=(Token)match(input,94,FOLLOW_94_in_initEl2777); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_94.add(string_literal360);

					NUMBER361=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl2779); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER361);

					pushFollow(FOLLOW_nameLiteral_in_initEl2781);
					nameLiteral362=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral362.getTree());
					char_literal363=(Token)match(input,58,FOLLOW_58_in_initEl2783); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal363);

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
					// 446:37: -> ^( INIT_AT NUMBER nameLiteral )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:446:40: ^( INIT_AT NUMBER nameLiteral )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:449:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws RecognitionException {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal365=null;
		Token string_literal366=null;
		Token char_literal368=null;
		ParserRuleReturnScope atomicNameFormula364 =null;
		ParserRuleReturnScope atomicNameFormula367 =null;

		Object char_literal365_tree=null;
		Object string_literal366_tree=null;
		Object char_literal368_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:450:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==57) ) {
				int LA69_1 = input.LA(2);
				if ( (LA69_1==110) ) {
					alt69=2;
				}
				else if ( (LA69_1==NAME) ) {
					alt69=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 69, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}

			switch (alt69) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:450:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2805);
					atomicNameFormula364=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula364.getTree());

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:451:4: '(' 'not' atomicNameFormula ')'
					{
					char_literal365=(Token)match(input,57,FOLLOW_57_in_nameLiteral2810); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal365);

					string_literal366=(Token)match(input,110,FOLLOW_110_in_nameLiteral2812); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_110.add(string_literal366);

					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral2814);
					atomicNameFormula367=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula367.getTree());
					char_literal368=(Token)match(input,58,FOLLOW_58_in_nameLiteral2816); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal368);

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
					// 451:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:451:39: ^( NOT_PRED_INIT atomicNameFormula )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:454:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws RecognitionException {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal369=null;
		Token NAME371=null;
		Token char_literal372=null;
		ParserRuleReturnScope predicate370 =null;

		Object char_literal369_tree=null;
		Object NAME371_tree=null;
		Object char_literal372_tree=null;
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:4: '(' predicate ( NAME )* ')'
			{
			char_literal369=(Token)match(input,57,FOLLOW_57_in_atomicNameFormula2835); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal369);

			pushFollow(FOLLOW_predicate_in_atomicNameFormula2837);
			predicate370=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate370.getTree());
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:18: ( NAME )*
			loop70:
			while (true) {
				int alt70=2;
				int LA70_0 = input.LA(1);
				if ( (LA70_0==NAME) ) {
					alt70=1;
				}

				switch (alt70) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:18: NAME
					{
					NAME371=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula2839); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME371);

					}
					break;

				default :
					break loop70;
				}
			}

			char_literal372=(Token)match(input,58,FOLLOW_58_in_atomicNameFormula2842); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal372);

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
			// 455:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				adaptor.addChild(root_1, stream_predicate.nextTree());
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:455:53: ( NAME )*
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws RecognitionException {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal373=null;
		Token string_literal374=null;
		Token char_literal376=null;
		ParserRuleReturnScope goalDesc375 =null;

		Object char_literal373_tree=null;
		Object string_literal374_tree=null;
		Object char_literal376_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:8: '(' ':goal' goalDesc ')'
			{
			char_literal373=(Token)match(input,57,FOLLOW_57_in_goal2867); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal373);

			string_literal374=(Token)match(input,74,FOLLOW_74_in_goal2869); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_74.add(string_literal374);

			pushFollow(FOLLOW_goalDesc_in_goal2871);
			goalDesc375=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc375.getTree());
			char_literal376=(Token)match(input,58,FOLLOW_58_in_goal2873); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal376);

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
			// 462:33: -> ^( GOAL goalDesc )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:462:36: ^( GOAL goalDesc )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:464:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws RecognitionException {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal377=null;
		Token string_literal378=null;
		Token char_literal380=null;
		ParserRuleReturnScope prefConGD379 =null;

		Object char_literal377_tree=null;
		Object string_literal378_tree=null;
		Object char_literal380_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:465:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:465:4: '(' ':constraints' prefConGD ')'
			{
			char_literal377=(Token)match(input,57,FOLLOW_57_in_probConstraints2891); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal377);

			string_literal378=(Token)match(input,66,FOLLOW_66_in_probConstraints2893); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_66.add(string_literal378);

			pushFollow(FOLLOW_prefConGD_in_probConstraints2896);
			prefConGD379=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD379.getTree());
			char_literal380=(Token)match(input,58,FOLLOW_58_in_probConstraints2898); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal380);

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
			// 466:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:466:7: ^( PROBLEM_CONSTRAINT prefConGD )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:469:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws RecognitionException {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal381=null;
		Token string_literal382=null;
		Token char_literal384=null;
		Token char_literal385=null;
		Token string_literal386=null;
		Token char_literal387=null;
		Token char_literal389=null;
		Token char_literal391=null;
		Token char_literal392=null;
		Token string_literal393=null;
		Token NAME394=null;
		Token char_literal396=null;
		ParserRuleReturnScope prefConGD383 =null;
		ParserRuleReturnScope typedVariableList388 =null;
		ParserRuleReturnScope prefConGD390 =null;
		ParserRuleReturnScope conGD395 =null;
		ParserRuleReturnScope conGD397 =null;

		Object char_literal381_tree=null;
		Object string_literal382_tree=null;
		Object char_literal384_tree=null;
		Object char_literal385_tree=null;
		Object string_literal386_tree=null;
		Object char_literal387_tree=null;
		Object char_literal389_tree=null;
		Object char_literal391_tree=null;
		Object char_literal392_tree=null;
		Object string_literal393_tree=null;
		Object NAME394_tree=null;
		Object char_literal396_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt73=4;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==57) ) {
				int LA73_1 = input.LA(2);
				if ( (synpred109_Pddl()) ) {
					alt73=1;
				}
				else if ( (synpred110_Pddl()) ) {
					alt73=2;
				}
				else if ( (synpred112_Pddl()) ) {
					alt73=3;
				}
				else if ( (true) ) {
					alt73=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}

			switch (alt73) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal381=(Token)match(input,57,FOLLOW_57_in_prefConGD2920); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal381_tree = (Object)adaptor.create(char_literal381);
					adaptor.addChild(root_0, char_literal381_tree);
					}

					string_literal382=(Token)match(input,92,FOLLOW_92_in_prefConGD2922); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal382_tree = (Object)adaptor.create(string_literal382);
					adaptor.addChild(root_0, string_literal382_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:14: ( prefConGD )*
					loop71:
					while (true) {
						int alt71=2;
						int LA71_0 = input.LA(1);
						if ( (LA71_0==57) ) {
							alt71=1;
						}

						switch (alt71) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:14: prefConGD
							{
							pushFollow(FOLLOW_prefConGD_in_prefConGD2924);
							prefConGD383=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD383.getTree());

							}
							break;

						default :
							break loop71;
						}
					}

					char_literal384=(Token)match(input,58,FOLLOW_58_in_prefConGD2927); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal384_tree = (Object)adaptor.create(char_literal384);
					adaptor.addChild(root_0, char_literal384_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:471:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal385=(Token)match(input,57,FOLLOW_57_in_prefConGD2932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal385_tree = (Object)adaptor.create(char_literal385);
					adaptor.addChild(root_0, char_literal385_tree);
					}

					string_literal386=(Token)match(input,102,FOLLOW_102_in_prefConGD2934); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal386_tree = (Object)adaptor.create(string_literal386);
					adaptor.addChild(root_0, string_literal386_tree);
					}

					char_literal387=(Token)match(input,57,FOLLOW_57_in_prefConGD2936); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal387_tree = (Object)adaptor.create(char_literal387);
					adaptor.addChild(root_0, char_literal387_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_prefConGD2938);
					typedVariableList388=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList388.getTree());

					char_literal389=(Token)match(input,58,FOLLOW_58_in_prefConGD2940); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal389_tree = (Object)adaptor.create(char_literal389);
					adaptor.addChild(root_0, char_literal389_tree);
					}

					pushFollow(FOLLOW_prefConGD_in_prefConGD2942);
					prefConGD390=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD390.getTree());

					char_literal391=(Token)match(input,58,FOLLOW_58_in_prefConGD2944); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal391_tree = (Object)adaptor.create(char_literal391);
					adaptor.addChild(root_0, char_literal391_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal392=(Token)match(input,57,FOLLOW_57_in_prefConGD2949); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal392_tree = (Object)adaptor.create(char_literal392);
					adaptor.addChild(root_0, char_literal392_tree);
					}

					string_literal393=(Token)match(input,114,FOLLOW_114_in_prefConGD2951); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal393_tree = (Object)adaptor.create(string_literal393);
					adaptor.addChild(root_0, string_literal393_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:21: ( NAME )?
					int alt72=2;
					int LA72_0 = input.LA(1);
					if ( (LA72_0==NAME) ) {
						alt72=1;
					}
					switch (alt72) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:21: NAME
							{
							NAME394=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD2953); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME394_tree = (Object)adaptor.create(NAME394);
							adaptor.addChild(root_0, NAME394_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_conGD_in_prefConGD2956);
					conGD395=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD395.getTree());

					char_literal396=(Token)match(input,58,FOLLOW_58_in_prefConGD2958); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal396_tree = (Object)adaptor.create(char_literal396);
					adaptor.addChild(root_0, char_literal396_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:473:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conGD_in_prefConGD2963);
					conGD397=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD397.getTree());

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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:476:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws RecognitionException {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal398=null;
		Token string_literal399=null;
		Token char_literal402=null;
		ParserRuleReturnScope optimization400 =null;
		ParserRuleReturnScope metricFExp401 =null;

		Object char_literal398_tree=null;
		Object string_literal399_tree=null;
		Object char_literal402_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:477:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:477:4: '(' ':metric' optimization metricFExp ')'
			{
			char_literal398=(Token)match(input,57,FOLLOW_57_in_metricSpec2974); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_57.add(char_literal398);

			string_literal399=(Token)match(input,76,FOLLOW_76_in_metricSpec2976); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal399);

			pushFollow(FOLLOW_optimization_in_metricSpec2978);
			optimization400=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization400.getTree());
			pushFollow(FOLLOW_metricFExp_in_metricSpec2980);
			metricFExp401=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp401.getTree());
			char_literal402=(Token)match(input,58,FOLLOW_58_in_metricSpec2982); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_58.add(char_literal402);

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
			// 478:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:478:7: ^( PROBLEM_METRIC optimization metricFExp )
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:481:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws RecognitionException {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set403=null;

		Object set403_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:481:14: ( 'minimize' | 'maximize' )
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			set403=input.LT(1);
			if ( (input.LA(1) >= 108 && input.LA(1) <= 109) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set403));
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:483:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws RecognitionException {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal404=null;
		Token char_literal408=null;
		Token char_literal409=null;
		Token char_literal413=null;
		Token char_literal414=null;
		Token char_literal415=null;
		Token char_literal417=null;
		Token NUMBER418=null;
		Token char_literal420=null;
		Token string_literal421=null;
		Token NAME422=null;
		Token char_literal423=null;
		ParserRuleReturnScope binaryOp405 =null;
		ParserRuleReturnScope metricFExp406 =null;
		ParserRuleReturnScope metricFExp407 =null;
		ParserRuleReturnScope multiOp410 =null;
		ParserRuleReturnScope metricFExp411 =null;
		ParserRuleReturnScope metricFExp412 =null;
		ParserRuleReturnScope metricFExp416 =null;
		ParserRuleReturnScope fHead419 =null;

		Object char_literal404_tree=null;
		Object char_literal408_tree=null;
		Object char_literal409_tree=null;
		Object char_literal413_tree=null;
		Object char_literal414_tree=null;
		Object char_literal415_tree=null;
		Object char_literal417_tree=null;
		Object NUMBER418_tree=null;
		Object char_literal420_tree=null;
		Object string_literal421_tree=null;
		Object NAME422_tree=null;
		Object char_literal423_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:484:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt75=6;
			switch ( input.LA(1) ) {
			case 57:
				{
				int LA75_1 = input.LA(2);
				if ( (synpred114_Pddl()) ) {
					alt75=1;
				}
				else if ( (synpred116_Pddl()) ) {
					alt75=2;
				}
				else if ( (synpred117_Pddl()) ) {
					alt75=3;
				}
				else if ( (synpred119_Pddl()) ) {
					alt75=5;
				}
				else if ( (true) ) {
					alt75=6;
				}

				}
				break;
			case NUMBER:
				{
				alt75=4;
				}
				break;
			case NAME:
				{
				alt75=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 75, 0, input);
				throw nvae;
			}
			switch (alt75) {
				case 1 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:484:4: '(' binaryOp metricFExp metricFExp ')'
					{
					char_literal404=(Token)match(input,57,FOLLOW_57_in_metricFExp3019); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal404);

					pushFollow(FOLLOW_binaryOp_in_metricFExp3021);
					binaryOp405=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp405.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3023);
					metricFExp406=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp406.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3025);
					metricFExp407=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp407.getTree());
					char_literal408=(Token)match(input,58,FOLLOW_58_in_metricFExp3027); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal408);

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
					// 485:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:485:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					char_literal409=(Token)match(input,57,FOLLOW_57_in_metricFExp3049); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal409);

					pushFollow(FOLLOW_multiOp_in_metricFExp3051);
					multiOp410=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp410.getTree());
					pushFollow(FOLLOW_metricFExp_in_metricFExp3053);
					metricFExp411=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp411.getTree());
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:27: ( metricFExp )+
					int cnt74=0;
					loop74:
					while (true) {
						int alt74=2;
						int LA74_0 = input.LA(1);
						if ( (LA74_0==NAME||LA74_0==NUMBER||LA74_0==57) ) {
							alt74=1;
						}

						switch (alt74) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:27: metricFExp
							{
							pushFollow(FOLLOW_metricFExp_in_metricFExp3055);
							metricFExp412=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp412.getTree());
							}
							break;

						default :
							if ( cnt74 >= 1 ) break loop74;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(74, input);
							throw eee;
						}
						cnt74++;
					}

					char_literal413=(Token)match(input,58,FOLLOW_58_in_metricFExp3058); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal413);

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
					// 487:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:487:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: '(' '-' metricFExp ')'
					{
					char_literal414=(Token)match(input,57,FOLLOW_57_in_metricFExp3082); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(char_literal414);

					char_literal415=(Token)match(input,61,FOLLOW_61_in_metricFExp3084); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_61.add(char_literal415);

					pushFollow(FOLLOW_metricFExp_in_metricFExp3086);
					metricFExp416=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp416.getTree());
					char_literal417=(Token)match(input,58,FOLLOW_58_in_metricFExp3088); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(char_literal417);

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
					// 489:4: -> ^( MINUS_OP metricFExp )
					{
						// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:489:7: ^( MINUS_OP metricFExp )
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:490:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER418=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3105); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER418_tree = (Object)adaptor.create(NUMBER418);
					adaptor.addChild(root_0, NUMBER418_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:491:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_fHead_in_metricFExp3110);
					fHead419=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead419.getTree());

					}
					break;
				case 6 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:493:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal420=(Token)match(input,57,FOLLOW_57_in_metricFExp3125); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal420_tree = (Object)adaptor.create(char_literal420);
					adaptor.addChild(root_0, char_literal420_tree);
					}

					string_literal421=(Token)match(input,107,FOLLOW_107_in_metricFExp3127); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal421_tree = (Object)adaptor.create(string_literal421);
					adaptor.addChild(root_0, string_literal421_tree);
					}

					NAME422=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3129); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME422_tree = (Object)adaptor.create(NAME422);
					adaptor.addChild(root_0, NAME422_tree);
					}

					char_literal423=(Token)match(input,58,FOLLOW_58_in_metricFExp3131); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal423_tree = (Object)adaptor.create(char_literal423);
					adaptor.addChild(root_0, char_literal423_tree);
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
	// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:498:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws RecognitionException {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
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
		Token string_literal437=null;
		Token char_literal439=null;
		Token char_literal440=null;
		Token string_literal441=null;
		Token char_literal443=null;
		Token char_literal444=null;
		Token string_literal445=null;
		Token char_literal447=null;
		Token char_literal448=null;
		Token string_literal449=null;
		Token NUMBER450=null;
		Token char_literal452=null;
		Token char_literal453=null;
		Token string_literal454=null;
		Token char_literal456=null;
		Token char_literal457=null;
		Token string_literal458=null;
		Token char_literal461=null;
		Token char_literal462=null;
		Token string_literal463=null;
		Token char_literal466=null;
		Token char_literal467=null;
		Token string_literal468=null;
		Token NUMBER469=null;
		Token char_literal472=null;
		Token char_literal473=null;
		Token string_literal474=null;
		Token NUMBER475=null;
		Token NUMBER476=null;
		Token char_literal478=null;
		Token char_literal479=null;
		Token string_literal480=null;
		Token NUMBER481=null;
		Token char_literal483=null;
		ParserRuleReturnScope conGD426 =null;
		ParserRuleReturnScope typedVariableList431 =null;
		ParserRuleReturnScope conGD433 =null;
		ParserRuleReturnScope goalDesc438 =null;
		ParserRuleReturnScope goalDesc442 =null;
		ParserRuleReturnScope goalDesc446 =null;
		ParserRuleReturnScope goalDesc451 =null;
		ParserRuleReturnScope goalDesc455 =null;
		ParserRuleReturnScope goalDesc459 =null;
		ParserRuleReturnScope goalDesc460 =null;
		ParserRuleReturnScope goalDesc464 =null;
		ParserRuleReturnScope goalDesc465 =null;
		ParserRuleReturnScope goalDesc470 =null;
		ParserRuleReturnScope goalDesc471 =null;
		ParserRuleReturnScope goalDesc477 =null;
		ParserRuleReturnScope goalDesc482 =null;

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
		Object string_literal437_tree=null;
		Object char_literal439_tree=null;
		Object char_literal440_tree=null;
		Object string_literal441_tree=null;
		Object char_literal443_tree=null;
		Object char_literal444_tree=null;
		Object string_literal445_tree=null;
		Object char_literal447_tree=null;
		Object char_literal448_tree=null;
		Object string_literal449_tree=null;
		Object NUMBER450_tree=null;
		Object char_literal452_tree=null;
		Object char_literal453_tree=null;
		Object string_literal454_tree=null;
		Object char_literal456_tree=null;
		Object char_literal457_tree=null;
		Object string_literal458_tree=null;
		Object char_literal461_tree=null;
		Object char_literal462_tree=null;
		Object string_literal463_tree=null;
		Object char_literal466_tree=null;
		Object char_literal467_tree=null;
		Object string_literal468_tree=null;
		Object NUMBER469_tree=null;
		Object char_literal472_tree=null;
		Object char_literal473_tree=null;
		Object string_literal474_tree=null;
		Object NUMBER475_tree=null;
		Object NUMBER476_tree=null;
		Object char_literal478_tree=null;
		Object char_literal479_tree=null;
		Object string_literal480_tree=null;
		Object NUMBER481_tree=null;
		Object char_literal483_tree=null;

		try {
			// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt77=12;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==57) ) {
				switch ( input.LA(2) ) {
				case 92:
					{
					alt77=1;
					}
					break;
				case 102:
					{
					alt77=2;
					}
					break;
				case 94:
					{
					alt77=3;
					}
					break;
				case 90:
					{
					alt77=4;
					}
					break;
				case 118:
					{
					alt77=5;
					}
					break;
				case 123:
					{
					alt77=6;
					}
					break;
				case 95:
					{
					alt77=7;
					}
					break;
				case 119:
					{
					alt77=8;
					}
					break;
				case 120:
					{
					alt77=9;
					}
					break;
				case 91:
					{
					alt77=10;
					}
					break;
				case 104:
					{
					alt77=11;
					}
					break;
				case 103:
					{
					alt77=12;
					}
					break;
				default:
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
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal424=(Token)match(input,57,FOLLOW_57_in_conGD3145); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal424_tree = (Object)adaptor.create(char_literal424);
					adaptor.addChild(root_0, char_literal424_tree);
					}

					string_literal425=(Token)match(input,92,FOLLOW_92_in_conGD3147); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal425_tree = (Object)adaptor.create(string_literal425);
					adaptor.addChild(root_0, string_literal425_tree);
					}

					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:14: ( conGD )*
					loop76:
					while (true) {
						int alt76=2;
						int LA76_0 = input.LA(1);
						if ( (LA76_0==57) ) {
							alt76=1;
						}

						switch (alt76) {
						case 1 :
							// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:499:14: conGD
							{
							pushFollow(FOLLOW_conGD_in_conGD3149);
							conGD426=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD426.getTree());

							}
							break;

						default :
							break loop76;
						}
					}

					char_literal427=(Token)match(input,58,FOLLOW_58_in_conGD3152); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal427_tree = (Object)adaptor.create(char_literal427);
					adaptor.addChild(root_0, char_literal427_tree);
					}

					}
					break;
				case 2 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:500:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal428=(Token)match(input,57,FOLLOW_57_in_conGD3157); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal428_tree = (Object)adaptor.create(char_literal428);
					adaptor.addChild(root_0, char_literal428_tree);
					}

					string_literal429=(Token)match(input,102,FOLLOW_102_in_conGD3159); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal429_tree = (Object)adaptor.create(string_literal429);
					adaptor.addChild(root_0, string_literal429_tree);
					}

					char_literal430=(Token)match(input,57,FOLLOW_57_in_conGD3161); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal430_tree = (Object)adaptor.create(char_literal430);
					adaptor.addChild(root_0, char_literal430_tree);
					}

					pushFollow(FOLLOW_typedVariableList_in_conGD3163);
					typedVariableList431=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList431.getTree());

					char_literal432=(Token)match(input,58,FOLLOW_58_in_conGD3165); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal432_tree = (Object)adaptor.create(char_literal432);
					adaptor.addChild(root_0, char_literal432_tree);
					}

					pushFollow(FOLLOW_conGD_in_conGD3167);
					conGD433=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD433.getTree());

					char_literal434=(Token)match(input,58,FOLLOW_58_in_conGD3169); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal434_tree = (Object)adaptor.create(char_literal434);
					adaptor.addChild(root_0, char_literal434_tree);
					}

					}
					break;
				case 3 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:501:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal435=(Token)match(input,57,FOLLOW_57_in_conGD3174); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal435_tree = (Object)adaptor.create(char_literal435);
					adaptor.addChild(root_0, char_literal435_tree);
					}

					string_literal436=(Token)match(input,94,FOLLOW_94_in_conGD3176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal436_tree = (Object)adaptor.create(string_literal436);
					adaptor.addChild(root_0, string_literal436_tree);
					}

					string_literal437=(Token)match(input,100,FOLLOW_100_in_conGD3178); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal437_tree = (Object)adaptor.create(string_literal437);
					adaptor.addChild(root_0, string_literal437_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3180);
					goalDesc438=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc438.getTree());

					char_literal439=(Token)match(input,58,FOLLOW_58_in_conGD3182); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal439_tree = (Object)adaptor.create(char_literal439);
					adaptor.addChild(root_0, char_literal439_tree);
					}

					}
					break;
				case 4 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:502:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal440=(Token)match(input,57,FOLLOW_57_in_conGD3208); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal440_tree = (Object)adaptor.create(char_literal440);
					adaptor.addChild(root_0, char_literal440_tree);
					}

					string_literal441=(Token)match(input,90,FOLLOW_90_in_conGD3210); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal441_tree = (Object)adaptor.create(string_literal441);
					adaptor.addChild(root_0, string_literal441_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3212);
					goalDesc442=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc442.getTree());

					char_literal443=(Token)match(input,58,FOLLOW_58_in_conGD3214); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal443_tree = (Object)adaptor.create(char_literal443);
					adaptor.addChild(root_0, char_literal443_tree);
					}

					}
					break;
				case 5 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:503:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal444=(Token)match(input,57,FOLLOW_57_in_conGD3219); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal444_tree = (Object)adaptor.create(char_literal444);
					adaptor.addChild(root_0, char_literal444_tree);
					}

					string_literal445=(Token)match(input,118,FOLLOW_118_in_conGD3221); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal445_tree = (Object)adaptor.create(string_literal445);
					adaptor.addChild(root_0, string_literal445_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3223);
					goalDesc446=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc446.getTree());

					char_literal447=(Token)match(input,58,FOLLOW_58_in_conGD3225); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal447_tree = (Object)adaptor.create(char_literal447);
					adaptor.addChild(root_0, char_literal447_tree);
					}

					}
					break;
				case 6 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:504:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal448=(Token)match(input,57,FOLLOW_57_in_conGD3231); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal448_tree = (Object)adaptor.create(char_literal448);
					adaptor.addChild(root_0, char_literal448_tree);
					}

					string_literal449=(Token)match(input,123,FOLLOW_123_in_conGD3233); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal449_tree = (Object)adaptor.create(string_literal449);
					adaptor.addChild(root_0, string_literal449_tree);
					}

					NUMBER450=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3235); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER450_tree = (Object)adaptor.create(NUMBER450);
					adaptor.addChild(root_0, NUMBER450_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3237);
					goalDesc451=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc451.getTree());

					char_literal452=(Token)match(input,58,FOLLOW_58_in_conGD3239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal452_tree = (Object)adaptor.create(char_literal452);
					adaptor.addChild(root_0, char_literal452_tree);
					}

					}
					break;
				case 7 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:505:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal453=(Token)match(input,57,FOLLOW_57_in_conGD3244); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal453_tree = (Object)adaptor.create(char_literal453);
					adaptor.addChild(root_0, char_literal453_tree);
					}

					string_literal454=(Token)match(input,95,FOLLOW_95_in_conGD3246); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal454_tree = (Object)adaptor.create(string_literal454);
					adaptor.addChild(root_0, string_literal454_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3248);
					goalDesc455=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc455.getTree());

					char_literal456=(Token)match(input,58,FOLLOW_58_in_conGD3250); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal456_tree = (Object)adaptor.create(char_literal456);
					adaptor.addChild(root_0, char_literal456_tree);
					}

					}
					break;
				case 8 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:506:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal457=(Token)match(input,57,FOLLOW_57_in_conGD3255); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal457_tree = (Object)adaptor.create(char_literal457);
					adaptor.addChild(root_0, char_literal457_tree);
					}

					string_literal458=(Token)match(input,119,FOLLOW_119_in_conGD3257); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal458_tree = (Object)adaptor.create(string_literal458);
					adaptor.addChild(root_0, string_literal458_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3259);
					goalDesc459=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc459.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3261);
					goalDesc460=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc460.getTree());

					char_literal461=(Token)match(input,58,FOLLOW_58_in_conGD3263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal461_tree = (Object)adaptor.create(char_literal461);
					adaptor.addChild(root_0, char_literal461_tree);
					}

					}
					break;
				case 9 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:507:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal462=(Token)match(input,57,FOLLOW_57_in_conGD3268); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal462_tree = (Object)adaptor.create(char_literal462);
					adaptor.addChild(root_0, char_literal462_tree);
					}

					string_literal463=(Token)match(input,120,FOLLOW_120_in_conGD3270); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal463_tree = (Object)adaptor.create(string_literal463);
					adaptor.addChild(root_0, string_literal463_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3272);
					goalDesc464=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc464.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3274);
					goalDesc465=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc465.getTree());

					char_literal466=(Token)match(input,58,FOLLOW_58_in_conGD3276); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal466_tree = (Object)adaptor.create(char_literal466);
					adaptor.addChild(root_0, char_literal466_tree);
					}

					}
					break;
				case 10 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:508:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal467=(Token)match(input,57,FOLLOW_57_in_conGD3281); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}

					string_literal468=(Token)match(input,91,FOLLOW_91_in_conGD3283); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal468_tree = (Object)adaptor.create(string_literal468);
					adaptor.addChild(root_0, string_literal468_tree);
					}

					NUMBER469=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3285); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER469_tree = (Object)adaptor.create(NUMBER469);
					adaptor.addChild(root_0, NUMBER469_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3287);
					goalDesc470=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc470.getTree());

					pushFollow(FOLLOW_goalDesc_in_conGD3289);
					goalDesc471=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc471.getTree());

					char_literal472=(Token)match(input,58,FOLLOW_58_in_conGD3291); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal472_tree = (Object)adaptor.create(char_literal472);
					adaptor.addChild(root_0, char_literal472_tree);
					}

					}
					break;
				case 11 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:509:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal473=(Token)match(input,57,FOLLOW_57_in_conGD3296); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal473_tree = (Object)adaptor.create(char_literal473);
					adaptor.addChild(root_0, char_literal473_tree);
					}

					string_literal474=(Token)match(input,104,FOLLOW_104_in_conGD3298); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal474_tree = (Object)adaptor.create(string_literal474);
					adaptor.addChild(root_0, string_literal474_tree);
					}

					NUMBER475=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3300); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER475_tree = (Object)adaptor.create(NUMBER475);
					adaptor.addChild(root_0, NUMBER475_tree);
					}

					NUMBER476=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3302); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER476_tree = (Object)adaptor.create(NUMBER476);
					adaptor.addChild(root_0, NUMBER476_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3304);
					goalDesc477=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc477.getTree());

					char_literal478=(Token)match(input,58,FOLLOW_58_in_conGD3306); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal478_tree = (Object)adaptor.create(char_literal478);
					adaptor.addChild(root_0, char_literal478_tree);
					}

					}
					break;
				case 12 :
					// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:510:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal479=(Token)match(input,57,FOLLOW_57_in_conGD3311); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal479_tree = (Object)adaptor.create(char_literal479);
					adaptor.addChild(root_0, char_literal479_tree);
					}

					string_literal480=(Token)match(input,103,FOLLOW_103_in_conGD3313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal480_tree = (Object)adaptor.create(string_literal480);
					adaptor.addChild(root_0, string_literal480_tree);
					}

					NUMBER481=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3315); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER481_tree = (Object)adaptor.create(NUMBER481);
					adaptor.addChild(root_0, NUMBER481_tree);
					}

					pushFollow(FOLLOW_goalDesc_in_conGD3317);
					goalDesc482=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc482.getTree());

					char_literal483=(Token)match(input,58,FOLLOW_58_in_conGD3319); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal483_tree = (Object)adaptor.create(char_literal483);
					adaptor.addChild(root_0, char_literal483_tree);
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
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:5: ( atomicFunctionSkeleton )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:156:5: atomicFunctionSkeleton
		{
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl774);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred42_Pddl
	public final void synpred42_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:250:7: ( fComp )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:250:7: fComp
		{
		pushFollow(FOLLOW_fComp_in_synpred42_Pddl1406);
		fComp();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred42_Pddl

	// $ANTLR start synpred45_Pddl
	public final void synpred45_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:273:28: ( typedVariableList )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:273:28: typedVariableList
		{
		pushFollow(FOLLOW_typedVariableList_in_synpred45_Pddl1566);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred45_Pddl

	// $ANTLR start synpred58_Pddl
	public final void synpred58_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:313:4: ( '(' binaryOp fExp fExp2 ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:313:4: '(' binaryOp fExp fExp2 ')'
		{
		match(input,57,FOLLOW_57_in_synpred58_Pddl1822); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred58_Pddl1824);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred58_Pddl1826);
		fExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExp2_in_synpred58_Pddl1828);
		fExp2();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred58_Pddl1830); if (state.failed) return;

		}

	}
	// $ANTLR end synpred58_Pddl

	// $ANTLR start synpred59_Pddl
	public final void synpred59_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:4: ( '(' '-' fExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:314:4: '(' '-' fExp ')'
		{
		match(input,57,FOLLOW_57_in_synpred59_Pddl1847); if (state.failed) return;

		match(input,61,FOLLOW_61_in_synpred59_Pddl1849); if (state.failed) return;

		pushFollow(FOLLOW_fExp_in_synpred59_Pddl1851);
		fExp();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred59_Pddl1853); if (state.failed) return;

		}

	}
	// $ANTLR end synpred59_Pddl

	// $ANTLR start synpred88_Pddl
	public final void synpred88_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:12: ( NUMBER )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:380:12: NUMBER
		{
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred88_Pddl2292); if (state.failed) return;

		}

	}
	// $ANTLR end synpred88_Pddl

	// $ANTLR start synpred90_Pddl
	public final void synpred90_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:4: ( '(' 'and' ( daEffect )* ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:4: '(' 'and' ( daEffect )* ')'
		{
		match(input,57,FOLLOW_57_in_synpred90_Pddl2306); if (state.failed) return;

		match(input,92,FOLLOW_92_in_synpred90_Pddl2308); if (state.failed) return;

		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:14: ( daEffect )*
		loop93:
		while (true) {
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==57) ) {
				alt93=1;
			}

			switch (alt93) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:383:14: daEffect
				{
				pushFollow(FOLLOW_daEffect_in_synpred90_Pddl2310);
				daEffect();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop93;
			}
		}

		match(input,58,FOLLOW_58_in_synpred90_Pddl2313); if (state.failed) return;

		}

	}
	// $ANTLR end synpred90_Pddl

	// $ANTLR start synpred91_Pddl
	public final void synpred91_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:384:4: ( timedEffect )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:384:4: timedEffect
		{
		pushFollow(FOLLOW_timedEffect_in_synpred91_Pddl2318);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred91_Pddl

	// $ANTLR start synpred92_Pddl
	public final void synpred92_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:385:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:385:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		match(input,57,FOLLOW_57_in_synpred92_Pddl2323); if (state.failed) return;

		match(input,102,FOLLOW_102_in_synpred92_Pddl2325); if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred92_Pddl2327); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred92_Pddl2329);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred92_Pddl2331); if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred92_Pddl2333);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred92_Pddl2335); if (state.failed) return;

		}

	}
	// $ANTLR end synpred92_Pddl

	// $ANTLR start synpred93_Pddl
	public final void synpred93_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:4: ( '(' 'when' daGD timedEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:386:4: '(' 'when' daGD timedEffect ')'
		{
		match(input,57,FOLLOW_57_in_synpred93_Pddl2340); if (state.failed) return;

		match(input,122,FOLLOW_122_in_synpred93_Pddl2342); if (state.failed) return;

		pushFollow(FOLLOW_daGD_in_synpred93_Pddl2344);
		daGD();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_timedEffect_in_synpred93_Pddl2346);
		timedEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred93_Pddl2348); if (state.failed) return;

		}

	}
	// $ANTLR end synpred93_Pddl

	// $ANTLR start synpred94_Pddl
	public final void synpred94_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:391:4: ( '(' 'at' timeSpecifier daEffect ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:391:4: '(' 'at' timeSpecifier daEffect ')'
		{
		match(input,57,FOLLOW_57_in_synpred94_Pddl2372); if (state.failed) return;

		match(input,94,FOLLOW_94_in_synpred94_Pddl2374); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred94_Pddl2376);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_daEffect_in_synpred94_Pddl2378);
		daEffect();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred94_Pddl2380); if (state.failed) return;

		}

	}
	// $ANTLR end synpred94_Pddl

	// $ANTLR start synpred95_Pddl
	public final void synpred95_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:392:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:392:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		match(input,57,FOLLOW_57_in_synpred95_Pddl2390); if (state.failed) return;

		match(input,94,FOLLOW_94_in_synpred95_Pddl2392); if (state.failed) return;

		pushFollow(FOLLOW_timeSpecifier_in_synpred95_Pddl2394);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fAssignDA_in_synpred95_Pddl2396);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred95_Pddl2398); if (state.failed) return;

		}

	}
	// $ANTLR end synpred95_Pddl

	// $ANTLR start synpred96_Pddl
	public final void synpred96_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( ( binaryOp fExpDA fExpDA ) )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
		{
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:10: binaryOp fExpDA fExpDA
		{
		pushFollow(FOLLOW_binaryOp_in_synpred96_Pddl2454);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred96_Pddl2456);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_fExpDA_in_synpred96_Pddl2458);
		fExpDA();
		state._fsp--;
		if (state.failed) return;

		}

		}

	}
	// $ANTLR end synpred96_Pddl

	// $ANTLR start synpred97_Pddl
	public final void synpred97_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		match(input,57,FOLLOW_57_in_synpred97_Pddl2450); if (state.failed) return;

		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt94=2;
		int LA94_0 = input.LA(1);
		if ( (LA94_0==61) ) {
			int LA94_1 = input.LA(2);
			if ( (synpred96_Pddl()) ) {
				alt94=1;
			}
			else if ( (true) ) {
				alt94=2;
			}

		}
		else if ( ((LA94_0 >= 59 && LA94_0 <= 60)||LA94_0==62) ) {
			alt94=1;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 94, 0, input);
			throw nvae;
		}

		switch (alt94) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
				{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:9: ( binaryOp fExpDA fExpDA )
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:10: binaryOp fExpDA fExpDA
				{
				pushFollow(FOLLOW_binaryOp_in_synpred97_Pddl2454);
				binaryOp();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred97_Pddl2456);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred97_Pddl2458);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;
			case 2 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:36: ( '-' fExpDA )
				{
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:36: ( '-' fExpDA )
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:401:37: '-' fExpDA
				{
				match(input,61,FOLLOW_61_in_synpred97_Pddl2464); if (state.failed) return;

				pushFollow(FOLLOW_fExpDA_in_synpred97_Pddl2466);
				fExpDA();
				state._fsp--;
				if (state.failed) return;

				}

				}
				break;

		}

		match(input,58,FOLLOW_58_in_synpred97_Pddl2470); if (state.failed) return;

		}

	}
	// $ANTLR end synpred97_Pddl

	// $ANTLR start synpred109_Pddl
	public final void synpred109_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:4: ( '(' 'and' ( prefConGD )* ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:4: '(' 'and' ( prefConGD )* ')'
		{
		match(input,57,FOLLOW_57_in_synpred109_Pddl2920); if (state.failed) return;

		match(input,92,FOLLOW_92_in_synpred109_Pddl2922); if (state.failed) return;

		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:14: ( prefConGD )*
		loop95:
		while (true) {
			int alt95=2;
			int LA95_0 = input.LA(1);
			if ( (LA95_0==57) ) {
				alt95=1;
			}

			switch (alt95) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:470:14: prefConGD
				{
				pushFollow(FOLLOW_prefConGD_in_synpred109_Pddl2924);
				prefConGD();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop95;
			}
		}

		match(input,58,FOLLOW_58_in_synpred109_Pddl2927); if (state.failed) return;

		}

	}
	// $ANTLR end synpred109_Pddl

	// $ANTLR start synpred110_Pddl
	public final void synpred110_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:471:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:471:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		match(input,57,FOLLOW_57_in_synpred110_Pddl2932); if (state.failed) return;

		match(input,102,FOLLOW_102_in_synpred110_Pddl2934); if (state.failed) return;

		match(input,57,FOLLOW_57_in_synpred110_Pddl2936); if (state.failed) return;

		pushFollow(FOLLOW_typedVariableList_in_synpred110_Pddl2938);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred110_Pddl2940); if (state.failed) return;

		pushFollow(FOLLOW_prefConGD_in_synpred110_Pddl2942);
		prefConGD();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred110_Pddl2944); if (state.failed) return;

		}

	}
	// $ANTLR end synpred110_Pddl

	// $ANTLR start synpred112_Pddl
	public final void synpred112_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:4: ( '(' 'preference' ( NAME )? conGD ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:4: '(' 'preference' ( NAME )? conGD ')'
		{
		match(input,57,FOLLOW_57_in_synpred112_Pddl2949); if (state.failed) return;

		match(input,114,FOLLOW_114_in_synpred112_Pddl2951); if (state.failed) return;

		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:21: ( NAME )?
		int alt96=2;
		int LA96_0 = input.LA(1);
		if ( (LA96_0==NAME) ) {
			alt96=1;
		}
		switch (alt96) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:472:21: NAME
				{
				match(input,NAME,FOLLOW_NAME_in_synpred112_Pddl2953); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_conGD_in_synpred112_Pddl2956);
		conGD();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred112_Pddl2958); if (state.failed) return;

		}

	}
	// $ANTLR end synpred112_Pddl

	// $ANTLR start synpred114_Pddl
	public final void synpred114_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:484:4: ( '(' binaryOp metricFExp metricFExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:484:4: '(' binaryOp metricFExp metricFExp ')'
		{
		match(input,57,FOLLOW_57_in_synpred114_Pddl3019); if (state.failed) return;

		pushFollow(FOLLOW_binaryOp_in_synpred114_Pddl3021);
		binaryOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred114_Pddl3023);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred114_Pddl3025);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred114_Pddl3027); if (state.failed) return;

		}

	}
	// $ANTLR end synpred114_Pddl

	// $ANTLR start synpred116_Pddl
	public final void synpred116_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		match(input,57,FOLLOW_57_in_synpred116_Pddl3049); if (state.failed) return;

		pushFollow(FOLLOW_multiOp_in_synpred116_Pddl3051);
		multiOp();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred116_Pddl3053);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:27: ( metricFExp )+
		int cnt97=0;
		loop97:
		while (true) {
			int alt97=2;
			int LA97_0 = input.LA(1);
			if ( (LA97_0==NAME||LA97_0==NUMBER||LA97_0==57) ) {
				alt97=1;
			}

			switch (alt97) {
			case 1 :
				// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:486:27: metricFExp
				{
				pushFollow(FOLLOW_metricFExp_in_synpred116_Pddl3055);
				metricFExp();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt97 >= 1 ) break loop97;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(97, input);
				throw eee;
			}
			cnt97++;
		}

		match(input,58,FOLLOW_58_in_synpred116_Pddl3058); if (state.failed) return;

		}

	}
	// $ANTLR end synpred116_Pddl

	// $ANTLR start synpred117_Pddl
	public final void synpred117_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: ( '(' '-' metricFExp ')' )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:488:4: '(' '-' metricFExp ')'
		{
		match(input,57,FOLLOW_57_in_synpred117_Pddl3082); if (state.failed) return;

		match(input,61,FOLLOW_61_in_synpred117_Pddl3084); if (state.failed) return;

		pushFollow(FOLLOW_metricFExp_in_synpred117_Pddl3086);
		metricFExp();
		state._fsp--;
		if (state.failed) return;

		match(input,58,FOLLOW_58_in_synpred117_Pddl3088); if (state.failed) return;

		}

	}
	// $ANTLR end synpred117_Pddl

	// $ANTLR start synpred119_Pddl
	public final void synpred119_Pddl_fragment() throws RecognitionException {
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:491:4: ( fHead )
		// /home/enrico/Scrivania/Dropbox/Planning and execution v-2.0/PPMajal/grammar/Pddl.g:491:4: fHead
		{
		pushFollow(FOLLOW_fHead_in_synpred119_Pddl3110);
		fHead();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred119_Pddl

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
	public final boolean synpred88_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred88_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred59_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred59_Pddl_fragment(); // can never throw exception
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
	public final boolean synpred42_Pddl() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred42_Pddl_fragment(); // can never throw exception
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


	protected DFA14 dfa14 = new DFA14(this);
	protected DFA12 dfa12 = new DFA12(this);
	protected DFA25 dfa25 = new DFA25(this);
	protected DFA23 dfa23 = new DFA23(this);
	static final String DFA14_eotS =
		"\4\uffff";
	static final String DFA14_eofS =
		"\4\uffff";
	static final String DFA14_minS =
		"\2\42\2\uffff";
	static final String DFA14_maxS =
		"\1\72\1\75\2\uffff";
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
			return "134:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )";
		}
	}

	static final String DFA12_eotS =
		"\4\uffff";
	static final String DFA12_eofS =
		"\4\uffff";
	static final String DFA12_minS =
		"\2\42\2\uffff";
	static final String DFA12_maxS =
		"\1\72\1\75\2\uffff";
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
			return "()+ loopback of 134:16: ( singleTypeNameList )+";
		}
	}

	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\66\2\uffff";
	static final String DFA25_maxS =
		"\1\72\1\75\2\uffff";
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
			return "185:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\66\2\uffff";
	static final String DFA23_maxS =
		"\1\72\1\75\2\uffff";
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
			return "()+ loopback of 185:20: ( singleTypeVarList )+";
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_domain346 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_domain348 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_domainName_in_domain350 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_requireDef_in_domain358 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_typesDef_in_domain367 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_constantsDef_in_domain376 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_predicatesDef_in_domain385 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_functionsDef_in_domain394 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain403 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_constraints_in_domain412 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_structureDef_in_domain421 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_domain430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_free_functionsDef514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_free_functionsDef516 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef518 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_free_functionsDef520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_domainName543 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_domainName545 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_NAME_in_domainName547 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_domainName549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_requireDef576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_requireDef578 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef580 = new BitSet(new long[]{0x0408000000000000L});
	public static final BitSet FOLLOW_58_in_requireDef583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_typesDef604 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_typesDef606 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef608 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_typesDef610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList637 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList642 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList645 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList665 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_61_in_singleTypeNameList668 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_type699 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_type701 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_primType_in_type703 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_58_in_type706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_functionsDef747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_functionsDef749 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_functionList_in_functionsDef751 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_functionsDef753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList774 = new BitSet(new long[]{0x2200000000000002L});
	public static final BitSet FOLLOW_61_in_functionList778 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_functionType_in_functionList780 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_57_in_atomicFunctionSkeleton796 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton799 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton802 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_atomicFunctionSkeleton804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_functionSymbol815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_111_in_functionType824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_constantsDef835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_constantsDef837 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef839 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_constantsDef841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_predicatesDef861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_predicatesDef863 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef865 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_predicatesDef868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_atomicFormulaSkeleton889 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton892 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton895 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_atomicFormulaSkeleton897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList923 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList928 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList931 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList951 = new BitSet(new long[]{0x2040000000000000L});
	public static final BitSet FOLLOW_61_in_singleTypeVarList954 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_constraints989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_constraints992 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_conGD_in_constraints995 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_constraints997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_actionDef1034 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_actionDef1036 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_actionDef1047 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDef1050 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1052 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_actionDef1054 = new BitSet(new long[]{0x0400000000000000L,0x0000000000008080L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1067 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_actionDef1069 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_actionDefBody1118 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDefBody1122 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_actionDefBody1124 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_actionDefBody1139 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_actionDefBody1143 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_actionDefBody1145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_goalDesc1201 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1203 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1231 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_goalDesc1233 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1235 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1263 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_goalDesc1265 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1267 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1293 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_105_in_goalDesc1295 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1297 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1299 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1327 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_goalDesc1329 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1331 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1333 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1335 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1337 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goalDesc1365 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_goalDesc1367 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_goalDesc1369 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1371 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1373 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1375 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goalDesc1377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_equality1461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_equality1464 = new BitSet(new long[]{0x0040000400000000L});
	public static final BitSet FOLLOW_term_in_equality1466 = new BitSet(new long[]{0x0040000400000000L});
	public static final BitSet FOLLOW_term_in_equality1468 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_equality1470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fComp1481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000F80000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1484 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1486 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1488 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_fComp1490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_atomicTermFormula1502 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1504 = new BitSet(new long[]{0x0440000400000000L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1506 = new BitSet(new long[]{0x0440000400000000L});
	public static final BitSet FOLLOW_58_in_atomicTermFormula1509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_durativeActionDef1547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_durativeActionDef1549 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_durativeActionDef1560 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_durativeActionDef1563 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1566 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_durativeActionDef1570 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A1L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1583 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_durativeActionDef1585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daDefBody1618 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody1620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_daDefBody1625 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daDefBody1629 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daDefBody1631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody1636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_daDefBody1645 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daDefBody1649 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daDefBody1651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody1656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD1671 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daGD1676 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_daGD1678 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1680 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_daGD1683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daGD1688 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_daGD1690 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daGD1692 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD1694 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daGD1696 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1698 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daGD1700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_prefTimedGD1716 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_prefTimedGD1718 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD1720 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD1723 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_prefTimedGD1725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_timedGD1736 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_timedGD1738 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD1740 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1742 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_timedGD1744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_timedGD1749 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_timedGD1751 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_interval_in_timedGD1753 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD1755 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_timedGD1757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_interval1779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_derivedDef1792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_derivedDef1795 = new BitSet(new long[]{0x0240000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef1798 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef1800 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_derivedDef1802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp1817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fExp1822 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_fExp1824 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1826 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp2_in_fExp1828 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_fExp1830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fExp1847 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_fExp1849 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_fExp1851 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_fExp1853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp1866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp21878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fHead1888 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead1890 = new BitSet(new long[]{0x0440000400000000L});
	public static final BitSet FOLLOW_term_in_fHead1892 = new BitSet(new long[]{0x0440000400000000L});
	public static final BitSet FOLLOW_58_in_fHead1895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead1911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_effect1930 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_effect1932 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_cEffect_in_effect1934 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_effect1937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect1951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_cEffect1962 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_cEffect1964 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_cEffect1966 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect1968 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_cEffect1970 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_effect_in_cEffect1972 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_cEffect1974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_cEffect1992 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_cEffect1994 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect1996 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_condEffect_in_cEffect1998 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_cEffect2000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_pEffect2029 = new BitSet(new long[]{0x0000000000000000L,0x0030040120000000L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2031 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_fHead_in_pEffect2033 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_pEffect2035 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_pEffect2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_pEffect2057 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_pEffect2059 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2061 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_pEffect2063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2079 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_condEffect2092 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_condEffect2094 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2096 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_condEffect2099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_durationConstraint2214 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_durationConstraint2216 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2218 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_durationConstraint2221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_durationConstraint2226 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_durationConstraint2228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_simpleDurationConstraint2244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000B00000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2246 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_simpleDurationConstraint2248 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2250 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_simpleDurationConstraint2252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_simpleDurationConstraint2257 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_simpleDurationConstraint2259 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2261 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2263 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_simpleDurationConstraint2265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daEffect2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_daEffect2308 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2310 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_daEffect2313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daEffect2323 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_daEffect2325 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_daEffect2327 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2329 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daEffect2331 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2333 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daEffect2335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daEffect2340 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_daEffect2342 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daGD_in_daEffect2344 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2346 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daEffect2348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_daEffect2353 = new BitSet(new long[]{0x0000000000000000L,0x0030040120000000L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2355 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_fHead_in_daEffect2357 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2359 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_daEffect2361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_timedEffect2372 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_timedEffect2374 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2376 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2378 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_timedEffect2380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_timedEffect2390 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_timedEffect2392 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2394 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2396 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_timedEffect2398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_timedEffect2403 = new BitSet(new long[]{0x0000000000000000L,0x0030040120000000L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2405 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2407 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2409 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_timedEffect2411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fAssignDA2431 = new BitSet(new long[]{0x0000000000000000L,0x0030040120000000L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2433 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2435 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2437 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_fAssignDA2439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_fExpDA2450 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2454 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2456 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2458 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_61_in_fExpDA2464 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2466 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_fExpDA2470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_fExpDA2475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_problem2494 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_97_in_problem2496 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_problemDecl_in_problem2498 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_problemDomain_in_problem2503 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_requireDef_in_problem2511 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_objectDecl_in_problem2520 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_init_in_problem2529 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goal_in_problem2537 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_probConstraints_in_problem2545 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_metricSpec_in_problem2554 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_problem2570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_problemDecl2627 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_problemDecl2629 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl2631 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_problemDecl2633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_problemDomain2659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_problemDomain2661 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain2663 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_problemDomain2665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_objectDecl2685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_objectDecl2687 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl2689 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_objectDecl2691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_init2711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_init2713 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_initEl_in_init2715 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_init2718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_initEl2744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_initEl2746 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_fHead_in_initEl2748 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2750 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_initEl2752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_initEl2775 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_initEl2777 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl2779 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl2781 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_initEl2783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_nameLiteral2810 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_nameLiteral2812 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral2814 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_nameLiteral2816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_atomicNameFormula2835 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula2837 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula2839 = new BitSet(new long[]{0x0400000400000000L});
	public static final BitSet FOLLOW_58_in_atomicNameFormula2842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_goal2867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_goal2869 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goal2871 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_goal2873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_probConstraints2891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_probConstraints2893 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints2896 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_probConstraints2898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_prefConGD2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_prefConGD2922 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD2924 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_prefConGD2927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_prefConGD2932 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_prefConGD2934 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_prefConGD2936 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD2938 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_prefConGD2940 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD2942 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_prefConGD2944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_prefConGD2949 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_prefConGD2951 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_NAME_in_prefConGD2953 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_conGD_in_prefConGD2956 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_prefConGD2958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD2963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_metricSpec2974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_metricSpec2976 = new BitSet(new long[]{0x0000000000000000L,0x0000300000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec2978 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec2980 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_metricSpec2982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_metricFExp3019 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3021 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3023 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3025 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_metricFExp3027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_metricFExp3049 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3051 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3053 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3055 = new BitSet(new long[]{0x0600004400000000L});
	public static final BitSet FOLLOW_58_in_metricFExp3058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_metricFExp3082 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_metricFExp3084 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3086 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_metricFExp3088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_metricFExp3125 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_metricFExp3127 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3129 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_metricFExp3131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3145 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_conGD3147 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3149 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3157 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_conGD3159 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_conGD3161 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3163 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3165 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3167 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_conGD3176 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_conGD3178 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3180 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3208 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_conGD3210 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3212 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3219 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_118_in_conGD3221 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3223 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3231 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_conGD3233 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3235 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3237 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3244 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_conGD3246 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3248 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3255 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_conGD3257 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3259 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3261 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3268 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_conGD3270 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3272 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3274 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3281 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_conGD3283 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3285 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3287 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3289 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3296 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_conGD3298 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3300 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3302 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3304 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_conGD3311 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_conGD3313 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3315 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3317 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_conGD3319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred42_Pddl1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred45_Pddl1566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred58_Pddl1822 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred58_Pddl1824 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_synpred58_Pddl1826 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp2_in_synpred58_Pddl1828 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred58_Pddl1830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred59_Pddl1847 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_synpred59_Pddl1849 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_fExp_in_synpred59_Pddl1851 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred59_Pddl1853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred88_Pddl2292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred90_Pddl2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_synpred90_Pddl2308 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred90_Pddl2310 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_synpred90_Pddl2313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred91_Pddl2318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred92_Pddl2323 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_synpred92_Pddl2325 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred92_Pddl2327 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred92_Pddl2329 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred92_Pddl2331 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred92_Pddl2333 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred92_Pddl2335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred93_Pddl2340 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_synpred93_Pddl2342 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daGD_in_synpred93_Pddl2344 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_synpred93_Pddl2346 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred93_Pddl2348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred94_Pddl2372 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_synpred94_Pddl2374 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred94_Pddl2376 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred94_Pddl2378 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred94_Pddl2380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred95_Pddl2390 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_synpred95_Pddl2392 = new BitSet(new long[]{0x0000000000000000L,0x0200001000000000L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred95_Pddl2394 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred95_Pddl2396 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred95_Pddl2398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred96_Pddl2454 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred96_Pddl2456 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred96_Pddl2458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred97_Pddl2450 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred97_Pddl2454 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred97_Pddl2456 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred97_Pddl2458 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_61_in_synpred97_Pddl2464 = new BitSet(new long[]{0x0200004400000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred97_Pddl2466 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred97_Pddl2470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred109_Pddl2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_synpred109_Pddl2922 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred109_Pddl2924 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_58_in_synpred109_Pddl2927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred110_Pddl2932 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_synpred110_Pddl2934 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_synpred110_Pddl2936 = new BitSet(new long[]{0x0440000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred110_Pddl2938 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred110_Pddl2940 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred110_Pddl2942 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred110_Pddl2944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred112_Pddl2949 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_synpred112_Pddl2951 = new BitSet(new long[]{0x0200000400000000L});
	public static final BitSet FOLLOW_NAME_in_synpred112_Pddl2953 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_conGD_in_synpred112_Pddl2956 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred112_Pddl2958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred114_Pddl3019 = new BitSet(new long[]{0x7800000000000000L});
	public static final BitSet FOLLOW_binaryOp_in_synpred114_Pddl3021 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred114_Pddl3023 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred114_Pddl3025 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred114_Pddl3027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred116_Pddl3049 = new BitSet(new long[]{0x1800000000000000L});
	public static final BitSet FOLLOW_multiOp_in_synpred116_Pddl3051 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred116_Pddl3053 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred116_Pddl3055 = new BitSet(new long[]{0x0600004400000000L});
	public static final BitSet FOLLOW_58_in_synpred116_Pddl3058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_synpred117_Pddl3082 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_synpred117_Pddl3084 = new BitSet(new long[]{0x0200004400000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred117_Pddl3086 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_synpred117_Pddl3088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred119_Pddl3110 = new BitSet(new long[]{0x0000000000000002L});
}
