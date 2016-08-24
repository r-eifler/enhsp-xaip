// $ANTLR 3.5 /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g 2016-08-24 13:56:27

package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class PddlParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "AND_EFFECT", "AND_GD", 
		"ANY_CHAR", "ASSIGN_EFFECT", "BINARY_OP", "COMPARISON_GD", "CONSTANTS", 
		"CONSTRAINT", "DIGIT", "DOMAIN", "DOMAIN_NAME", "DURATIVE_ACTION", "EFFECT", 
		"EITHER_TYPE", "EQUALITY_CON", "EVENT", "EXISTS_GD", "FORALL_EFFECT", 
		"FORALL_GD", "FREE_FUNCTIONS", "FUNCTIONS", "FUNC_HEAD", "GLOBAL_CONSTRAINT", 
		"GOAL", "IMPLY_GD", "INIT", "INIT_AT", "INIT_EQ", "LETTER", "LINE_COMMENT", 
		"MINUS_OP", "MULTI_OP", "NAME", "NOT_EFFECT", "NOT_GD", "NOT_PRED_INIT", 
		"NUMBER", "OBJECTS", "OR_GD", "PRECONDITION", "PREDICATES", "PRED_HEAD", 
		"PRED_INST", "PROBLEM", "PROBLEM_CONSTRAINT", "PROBLEM_DOMAIN", "PROBLEM_METRIC", 
		"PROBLEM_NAME", "PROCESS", "REQUIREMENTS", "REQUIRE_KEY", "TYPES", "UNARY_MINUS", 
		"VARIABLE", "WHEN_EFFECT", "WHITESPACE", "'#t'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "':action'", "':condition'", "':constants'", "':constraint'", 
		"':constraints'", "':derived'", "':domain'", "':duration'", "':durative-action'", 
		"':effect'", "':event'", "':free_functions'", "':functions'", "':goal'", 
		"':init'", "':metric'", "':objects'", "':parameters'", "':precondition'", 
		"':predicates'", "':process'", "':requirements'", "':types'", "'<'", "'<='", 
		"'='", "'>'", "'>='", "'?duration'", "'^'", "'all'", "'always'", "'always-within'", 
		"'and'", "'assign'", "'at'", "'at-most-once'", "'decrease'", "'define'", 
		"'domain'", "'either'", "'end'", "'exists'", "'forall'", "'hold-after'", 
		"'hold-during'", "'imply'", "'increase'", "'is-violated'", "'maximize'", 
		"'minimize'", "'not'", "'number'", "'or'", "'over'", "'preference'", "'problem'", 
		"'scale-down'", "'scale-up'", "'sometime'", "'sometime-after'", "'sometime-before'", 
		"'start'", "'when'", "'within'"
	};
	public static final int EOF=-1;
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
	public static final int T__130=130;
	public static final int T__131=131;
	public static final int T__132=132;
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
	public static final int EVENT=20;
	public static final int EXISTS_GD=21;
	public static final int FORALL_EFFECT=22;
	public static final int FORALL_GD=23;
	public static final int FREE_FUNCTIONS=24;
	public static final int FUNCTIONS=25;
	public static final int FUNC_HEAD=26;
	public static final int GLOBAL_CONSTRAINT=27;
	public static final int GOAL=28;
	public static final int IMPLY_GD=29;
	public static final int INIT=30;
	public static final int INIT_AT=31;
	public static final int INIT_EQ=32;
	public static final int LETTER=33;
	public static final int LINE_COMMENT=34;
	public static final int MINUS_OP=35;
	public static final int MULTI_OP=36;
	public static final int NAME=37;
	public static final int NOT_EFFECT=38;
	public static final int NOT_GD=39;
	public static final int NOT_PRED_INIT=40;
	public static final int NUMBER=41;
	public static final int OBJECTS=42;
	public static final int OR_GD=43;
	public static final int PRECONDITION=44;
	public static final int PREDICATES=45;
	public static final int PRED_HEAD=46;
	public static final int PRED_INST=47;
	public static final int PROBLEM=48;
	public static final int PROBLEM_CONSTRAINT=49;
	public static final int PROBLEM_DOMAIN=50;
	public static final int PROBLEM_METRIC=51;
	public static final int PROBLEM_NAME=52;
	public static final int PROCESS=53;
	public static final int REQUIREMENTS=54;
	public static final int REQUIRE_KEY=55;
	public static final int TYPES=56;
	public static final int UNARY_MINUS=57;
	public static final int VARIABLE=58;
	public static final int WHEN_EFFECT=59;
	public static final int WHITESPACE=60;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred133_Pddl", "synpred97_Pddl", "nameLiteral", "synpred130_Pddl", 
		"daEffect", "fHead", "singleTypeVarList", "synpred3_Pddl", "goalDesc", 
		"constraints", "synpred37_Pddl", "synpred36_Pddl", "term", "synpred131_Pddl", 
		"synpred106_Pddl", "synpred31_Pddl", "synpred88_Pddl", "conGD", "synpred83_Pddl", 
		"structureDef", "synpred74_Pddl", "prefTimedGD", "fExp", "synpred32_Pddl", 
		"daDefBody", "durValue", "synpred109_Pddl", "synpred16_Pddl", "equality", 
		"synpred15_Pddl", "requireDef", "synpred4_Pddl", "synpred27_Pddl", "synpred101_Pddl", 
		"synpred8_Pddl", "synpred81_Pddl", "daGD", "timedGD", "synpred57_Pddl", 
		"synpred52_Pddl", "synpred73_Pddl", "synpred20_Pddl", "type", "synpred79_Pddl", 
		"synpred89_Pddl", "metricSpec", "initEl", "synpred14_Pddl", "synpred67_Pddl", 
		"synpred123_Pddl", "constraintDefBody", "synpred105_Pddl", "synpred53_Pddl", 
		"processDef", "synpred19_Pddl", "synpred64_Pddl", "synpred137_Pddl", "synpred29_Pddl", 
		"actionDefBody", "synpred17_Pddl", "synpred43_Pddl", "synpred85_Pddl", 
		"functionList", "constraintSymbol", "synpred94_Pddl", "synpred35_Pddl", 
		"synpred70_Pddl", "synpred110_Pddl", "synpred112_Pddl", "synpred42_Pddl", 
		"synpred86_Pddl", "synpred48_Pddl", "synpred114_Pddl", "goal", "synpred113_Pddl", 
		"problemDomain", "predicatesDef", "synpred78_Pddl", "functionType", "synpred96_Pddl", 
		"synpred139_Pddl", "binaryComp", "probConstraints", "synpred58_Pddl", 
		"synpred38_Pddl", "functionsDef", "synpred21_Pddl", "synpred111_Pddl", 
		"synpred2_Pddl", "typedNameList", "synpred46_Pddl", "synpred93_Pddl", 
		"synpred13_Pddl", "interval", "synpred100_Pddl", "synpred24_Pddl", "synpred50_Pddl", 
		"atomicFormulaSkeleton", "synpred26_Pddl", "derivedDef", "synpred63_Pddl", 
		"synpred129_Pddl", "synpred104_Pddl", "actionDef", "synpred59_Pddl", "synpred84_Pddl", 
		"problemDecl", "atomicFunctionSkeleton", "synpred132_Pddl", "synpred136_Pddl", 
		"simpleDurationConstraint", "synpred1_Pddl", "synpred90_Pddl", "effect", 
		"synpred138_Pddl", "durOp", "metricFExp", "synpred76_Pddl", "synpred117_Pddl", 
		"synpred25_Pddl", "synpred65_Pddl", "pddlDoc", "synpred22_Pddl", "assignOp", 
		"synpred66_Pddl", "synpred7_Pddl", "durationConstraint", "synpred135_Pddl", 
		"synpred71_Pddl", "synpred41_Pddl", "fExp2", "synpred11_Pddl", "synpred54_Pddl", 
		"singleTypeNameList", "synpred45_Pddl", "synpred49_Pddl", "atomicNameFormula", 
		"synpred68_Pddl", "synpred128_Pddl", "binaryOp", "synpred124_Pddl", "synpred119_Pddl", 
		"functionSymbol", "constraintDef", "synpred60_Pddl", "actionSymbol", "domain", 
		"init", "synpred55_Pddl", "synpred62_Pddl", "synpred72_Pddl", "fComp", 
		"domainName", "typedVariableList", "optimization", "synpred121_Pddl", 
		"synpred108_Pddl", "primType", "fAssignDA", "prefConGD", "synpred82_Pddl", 
		"timeSpecifier", "fExpDA", "synpred34_Pddl", "synpred120_Pddl", "synpred95_Pddl", 
		"synpred122_Pddl", "synpred80_Pddl", "synpred87_Pddl", "synpred12_Pddl", 
		"constantsDef", "synpred10_Pddl", "synpred44_Pddl", "synpred9_Pddl", "synpred115_Pddl", 
		"synpred118_Pddl", "synpred126_Pddl", "atomicTermFormula", "cEffect", 
		"synpred5_Pddl", "synpred33_Pddl", "synpred99_Pddl", "synpred61_Pddl", 
		"synpred18_Pddl", "synpred92_Pddl", "objectDecl", "synpred6_Pddl", "pEffect", 
		"synpred51_Pddl", "eventDef", "synpred125_Pddl", "synpred69_Pddl", "durativeActionDef", 
		"problem", "synpred23_Pddl", "typesDef", "synpred116_Pddl", "free_functionsDef", 
		"synpred28_Pddl", "synpred47_Pddl", "synpred56_Pddl", "condEffect", "synpred30_Pddl", 
		"synpred40_Pddl", "synpred91_Pddl", "multiOp", "synpred103_Pddl", "predicate", 
		"synpred98_Pddl", "synpred39_Pddl", "synpred107_Pddl", "synpred77_Pddl", 
		"synpred134_Pddl", "synpred75_Pddl", "synpred102_Pddl", "synpred127_Pddl", 
		"timedEffect"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    true, true, true, true, false, false, false, true, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, true, false, true, false, false, false, 
		    false, false, false, false, false, true, false, false, false, false, 
		    false, false, false, false, false, false, false, true, false, true, 
		    true, true, true, false, false, false, false, true, false, false, 
		    false, false, false, false, true, false, true, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, true, false, false, false, 
		    false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public PddlParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public PddlParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public PddlParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return PddlParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g"; }


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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:96:1: pddlDoc : ( domain | problem );
	public final PddlParser.pddlDoc_return pddlDoc() throws  {
		PddlParser.pddlDoc_return retval = new PddlParser.pddlDoc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope domain1 =null;
		ParserRuleReturnScope problem2 =null;


		try { dbg.enterRule(getGrammarFileName(), "pddlDoc");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(96, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:96:9: ( domain | problem )
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==62) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==106) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==62) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==107) ) {
							alt1=1;
						}
						else if ( (LA1_3==124) ) {
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
								dbg.recognitionException(nvae);
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
							dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:96:11: domain
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(96,11);
					pushFollow(FOLLOW_domain_in_pddlDoc355);
					domain1=domain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, domain1.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:96:20: problem
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(96,20);
					pushFollow(FOLLOW_problem_in_pddlDoc359);
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
		dbg.location(96, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "pddlDoc");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:100:1: domain : '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) ;
	public final PddlParser.domain_return domain() throws  {
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
		RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_typesDef=new RewriteRuleSubtreeStream(adaptor,"rule typesDef");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_free_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule free_functionsDef");
		RewriteRuleSubtreeStream stream_domainName=new RewriteRuleSubtreeStream(adaptor,"rule domainName");
		RewriteRuleSubtreeStream stream_predicatesDef=new RewriteRuleSubtreeStream(adaptor,"rule predicatesDef");
		RewriteRuleSubtreeStream stream_constantsDef=new RewriteRuleSubtreeStream(adaptor,"rule constantsDef");
		RewriteRuleSubtreeStream stream_functionsDef=new RewriteRuleSubtreeStream(adaptor,"rule functionsDef");
		RewriteRuleSubtreeStream stream_constraints=new RewriteRuleSubtreeStream(adaptor,"rule constraints");
		RewriteRuleSubtreeStream stream_structureDef=new RewriteRuleSubtreeStream(adaptor,"rule structureDef");

		try { dbg.enterRule(getGrammarFileName(), "domain");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(100, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:101:5: ( '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')' -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:101:7: '(' 'define' domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* ')'
			{
			dbg.location(101,7);
			char_literal3=(Token)match(input,62,FOLLOW_62_in_domain374); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal3);
			dbg.location(101,11);
			string_literal4=(Token)match(input,106,FOLLOW_106_in_domain376); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_106.add(string_literal4);
			dbg.location(101,20);
			pushFollow(FOLLOW_domainName_in_domain378);
			domainName5=domainName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_domainName.add(domainName5.getTree());dbg.location(102,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:102:7: ( requireDef )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==62) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==89) ) {
					alt2=1;
				}
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:102:7: requireDef
					{
					dbg.location(102,7);
					pushFollow(FOLLOW_requireDef_in_domain386);
					requireDef6=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef6.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}
			dbg.location(103,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:103:7: ( typesDef )?
			int alt3=2;
			try { dbg.enterSubRule(3);
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==62) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==90) ) {
					alt3=1;
				}
			}
			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:103:7: typesDef
					{
					dbg.location(103,7);
					pushFollow(FOLLOW_typesDef_in_domain395);
					typesDef7=typesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typesDef.add(typesDef7.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(104,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:104:7: ( constantsDef )?
			int alt4=2;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==62) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==70) ) {
					alt4=1;
				}
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:104:7: constantsDef
					{
					dbg.location(104,7);
					pushFollow(FOLLOW_constantsDef_in_domain404);
					constantsDef8=constantsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constantsDef.add(constantsDef8.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(4);}
			dbg.location(105,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:105:7: ( predicatesDef )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==62) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==87) ) {
					alt5=1;
				}
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:105:7: predicatesDef
					{
					dbg.location(105,7);
					pushFollow(FOLLOW_predicatesDef_in_domain413);
					predicatesDef9=predicatesDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_predicatesDef.add(predicatesDef9.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}
			dbg.location(106,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:106:7: ( functionsDef )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==62) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==80) ) {
					alt6=1;
				}
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:106:7: functionsDef
					{
					dbg.location(106,7);
					pushFollow(FOLLOW_functionsDef_in_domain422);
					functionsDef10=functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionsDef.add(functionsDef10.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(107,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:107:7: ( free_functionsDef )?
			int alt7=2;
			try { dbg.enterSubRule(7);
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==62) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==79) ) {
					alt7=1;
				}
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:107:7: free_functionsDef
					{
					dbg.location(107,7);
					pushFollow(FOLLOW_free_functionsDef_in_domain431);
					free_functionsDef11=free_functionsDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_free_functionsDef.add(free_functionsDef11.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(108,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:108:7: ( constraints )?
			int alt8=2;
			try { dbg.enterSubRule(8);
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==62) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==72) ) {
					alt8=1;
				}
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:108:7: constraints
					{
					dbg.location(108,7);
					pushFollow(FOLLOW_constraints_in_domain440);
					constraints12=constraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constraints.add(constraints12.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(8);}
			dbg.location(109,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:109:7: ( structureDef )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==62) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:109:7: structureDef
					{
					dbg.location(109,7);
					pushFollow(FOLLOW_structureDef_in_domain449);
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
			} finally {dbg.exitSubRule(9);}
			dbg.location(110,7);
			char_literal14=(Token)match(input,63,FOLLOW_63_in_domain458); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal14);

			// AST REWRITE
			// elements: structureDef, constantsDef, free_functionsDef, domainName, requireDef, typesDef, functionsDef, constraints, predicatesDef
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 111:7: -> ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
			{
				dbg.location(111,10);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:111:10: ^( DOMAIN domainName ( requireDef )? ( typesDef )? ( constantsDef )? ( predicatesDef )? ( functionsDef )? ( free_functionsDef )? ( constraints )? ( structureDef )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(111,12);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN, "DOMAIN"), root_1);
				dbg.location(111,19);
				adaptor.addChild(root_1, stream_domainName.nextTree());dbg.location(111,30);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:111:30: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					dbg.location(111,30);
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();
				dbg.location(111,42);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:111:42: ( typesDef )?
				if ( stream_typesDef.hasNext() ) {
					dbg.location(111,42);
					adaptor.addChild(root_1, stream_typesDef.nextTree());
				}
				stream_typesDef.reset();
				dbg.location(112,17);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:112:17: ( constantsDef )?
				if ( stream_constantsDef.hasNext() ) {
					dbg.location(112,17);
					adaptor.addChild(root_1, stream_constantsDef.nextTree());
				}
				stream_constantsDef.reset();
				dbg.location(112,31);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:112:31: ( predicatesDef )?
				if ( stream_predicatesDef.hasNext() ) {
					dbg.location(112,31);
					adaptor.addChild(root_1, stream_predicatesDef.nextTree());
				}
				stream_predicatesDef.reset();
				dbg.location(112,46);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:112:46: ( functionsDef )?
				if ( stream_functionsDef.hasNext() ) {
					dbg.location(112,46);
					adaptor.addChild(root_1, stream_functionsDef.nextTree());
				}
				stream_functionsDef.reset();
				dbg.location(112,60);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:112:60: ( free_functionsDef )?
				if ( stream_free_functionsDef.hasNext() ) {
					dbg.location(112,60);
					adaptor.addChild(root_1, stream_free_functionsDef.nextTree());
				}
				stream_free_functionsDef.reset();
				dbg.location(113,17);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:113:17: ( constraints )?
				if ( stream_constraints.hasNext() ) {
					dbg.location(113,17);
					adaptor.addChild(root_1, stream_constraints.nextTree());
				}
				stream_constraints.reset();
				dbg.location(113,30);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:113:30: ( structureDef )*
				while ( stream_structureDef.hasNext() ) {
					dbg.location(113,30);
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
		dbg.location(114, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "domain");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:116:1: free_functionsDef : '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) ;
	public final PddlParser.free_functionsDef_return free_functionsDef() throws  {
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
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try { dbg.enterRule(getGrammarFileName(), "free_functionsDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(116, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:117:2: ( '(' ':free_functions' functionList ')' -> ^( FREE_FUNCTIONS functionList ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:117:4: '(' ':free_functions' functionList ')'
			{
			dbg.location(117,4);
			char_literal15=(Token)match(input,62,FOLLOW_62_in_free_functionsDef542); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal15);
			dbg.location(117,8);
			string_literal16=(Token)match(input,79,FOLLOW_79_in_free_functionsDef544); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_79.add(string_literal16);
			dbg.location(117,26);
			pushFollow(FOLLOW_functionList_in_free_functionsDef546);
			functionList17=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList17.getTree());dbg.location(117,39);
			char_literal18=(Token)match(input,63,FOLLOW_63_in_free_functionsDef548); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal18);

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
			// 118:2: -> ^( FREE_FUNCTIONS functionList )
			{
				dbg.location(118,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:118:5: ^( FREE_FUNCTIONS functionList )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(118,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FREE_FUNCTIONS, "FREE_FUNCTIONS"), root_1);
				dbg.location(118,22);
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
		dbg.location(119, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "free_functionsDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:121:1: domainName : '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) ;
	public final PddlParser.domainName_return domainName() throws  {
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
		RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try { dbg.enterRule(getGrammarFileName(), "domainName");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(121, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:122:5: ( '(' 'domain' NAME ')' -> ^( DOMAIN_NAME NAME ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:122:7: '(' 'domain' NAME ')'
			{
			dbg.location(122,7);
			char_literal19=(Token)match(input,62,FOLLOW_62_in_domainName571); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal19);
			dbg.location(122,11);
			string_literal20=(Token)match(input,107,FOLLOW_107_in_domainName573); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_107.add(string_literal20);
			dbg.location(122,20);
			NAME21=(Token)match(input,NAME,FOLLOW_NAME_in_domainName575); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME21);
			dbg.location(122,25);
			char_literal22=(Token)match(input,63,FOLLOW_63_in_domainName577); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal22);

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
			// 123:6: -> ^( DOMAIN_NAME NAME )
			{
				dbg.location(123,9);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:123:9: ^( DOMAIN_NAME NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(123,11);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOMAIN_NAME, "DOMAIN_NAME"), root_1);
				dbg.location(123,23);
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
		dbg.location(124, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "domainName");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:126:1: requireDef : '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) ;
	public final PddlParser.requireDef_return requireDef() throws  {
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
		RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");

		try { dbg.enterRule(getGrammarFileName(), "requireDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(126, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:127:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' -> ^( REQUIREMENTS ( REQUIRE_KEY )+ ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:127:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			dbg.location(127,4);
			char_literal23=(Token)match(input,62,FOLLOW_62_in_requireDef604); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal23);
			dbg.location(127,8);
			string_literal24=(Token)match(input,89,FOLLOW_89_in_requireDef606); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_89.add(string_literal24);
			dbg.location(127,24);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:127:24: ( REQUIRE_KEY )+
			int cnt10=0;
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( (LA10_0==REQUIRE_KEY) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:127:24: REQUIRE_KEY
					{
					dbg.location(127,24);
					REQUIRE_KEY25=(Token)match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_requireDef608); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_REQUIRE_KEY.add(REQUIRE_KEY25);

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(10, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt10++;
			}
			} finally {dbg.exitSubRule(10);}
			dbg.location(127,37);
			char_literal26=(Token)match(input,63,FOLLOW_63_in_requireDef611); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal26);

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
			// 128:2: -> ^( REQUIREMENTS ( REQUIRE_KEY )+ )
			{
				dbg.location(128,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:128:5: ^( REQUIREMENTS ( REQUIRE_KEY )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(128,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REQUIREMENTS, "REQUIREMENTS"), root_1);
				dbg.location(128,20);
				if ( !(stream_REQUIRE_KEY.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_REQUIRE_KEY.hasNext() ) {
					dbg.location(128,20);
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
		dbg.location(129, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "requireDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:131:1: typesDef : '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) ;
	public final PddlParser.typesDef_return typesDef() throws  {
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
		RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try { dbg.enterRule(getGrammarFileName(), "typesDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(131, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:132:2: ( '(' ':types' typedNameList ')' -> ^( TYPES typedNameList ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:132:4: '(' ':types' typedNameList ')'
			{
			dbg.location(132,4);
			char_literal27=(Token)match(input,62,FOLLOW_62_in_typesDef632); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal27);
			dbg.location(132,8);
			string_literal28=(Token)match(input,90,FOLLOW_90_in_typesDef634); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_90.add(string_literal28);
			dbg.location(132,17);
			pushFollow(FOLLOW_typedNameList_in_typesDef636);
			typedNameList29=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList29.getTree());dbg.location(132,31);
			char_literal30=(Token)match(input,63,FOLLOW_63_in_typesDef638); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal30);

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
			// 133:4: -> ^( TYPES typedNameList )
			{
				dbg.location(133,7);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:133:7: ^( TYPES typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(133,9);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPES, "TYPES"), root_1);
				dbg.location(133,15);
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
		dbg.location(134, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "typesDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:137:1: typedNameList : ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) ;
	public final PddlParser.typedNameList_return typedNameList() throws  {
		PddlParser.typedNameList_return retval = new PddlParser.typedNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME31=null;
		Token NAME33=null;
		ParserRuleReturnScope singleTypeNameList32 =null;

		Object NAME31_tree=null;
		Object NAME33_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "typedNameList");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(137, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:5: ( ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(138,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:7: ( ( NAME )* | ( singleTypeNameList )+ ( NAME )* )
			int alt14=2;
			try { dbg.enterSubRule(14);
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			int LA14_0 = input.LA(1);
			if ( (LA14_0==NAME) ) {
				int LA14_1 = input.LA(2);
				if ( (synpred12_Pddl()) ) {
					alt14=1;
				}
				else if ( (true) ) {
					alt14=2;
				}

			}
			else if ( (LA14_0==EOF||LA14_0==63) ) {
				alt14=1;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( NAME )*
					{
					dbg.location(138,8);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( NAME )*
					try { dbg.enterSubRule(11);

					loop11:
					while (true) {
						int alt11=2;
						try { dbg.enterDecision(11, decisionCanBacktrack[11]);

						int LA11_0 = input.LA(1);
						if ( (LA11_0==NAME) ) {
							int LA11_2 = input.LA(2);
							if ( (synpred11_Pddl()) ) {
								alt11=1;
							}

						}

						} finally {dbg.exitDecision(11);}

						switch (alt11) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: NAME
							{
							dbg.location(138,8);
							NAME31=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList665); if (state.failed) return retval;
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
					} finally {dbg.exitSubRule(11);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:16: ( singleTypeNameList )+ ( NAME )*
					{
					dbg.location(138,16);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:16: ( singleTypeNameList )+
					int cnt12=0;
					try { dbg.enterSubRule(12);

					loop12:
					while (true) {
						int alt12=2;
						try { dbg.enterDecision(12, decisionCanBacktrack[12]);

						int LA12_0 = input.LA(1);
						if ( (LA12_0==NAME) ) {
							int LA12_1 = input.LA(2);
							if ( (synpred13_Pddl()) ) {
								alt12=1;
							}

						}

						} finally {dbg.exitDecision(12);}

						switch (alt12) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:16: singleTypeNameList
							{
							dbg.location(138,16);
							pushFollow(FOLLOW_singleTypeNameList_in_typedNameList670);
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
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt12++;
					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(138,36);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:36: ( NAME )*
					try { dbg.enterSubRule(13);

					loop13:
					while (true) {
						int alt13=2;
						try { dbg.enterDecision(13, decisionCanBacktrack[13]);

						int LA13_0 = input.LA(1);
						if ( (LA13_0==NAME) ) {
							int LA13_2 = input.LA(2);
							if ( (synpred14_Pddl()) ) {
								alt13=1;
							}

						}

						} finally {dbg.exitDecision(13);}

						switch (alt13) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:36: NAME
							{
							dbg.location(138,36);
							NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_typedNameList673); if (state.failed) return retval;
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
					} finally {dbg.exitSubRule(13);}

					}
					break;

			}
			} finally {dbg.exitSubRule(14);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(139, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "typedNameList");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:141:1: singleTypeNameList : ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ ;
	public final PddlParser.singleTypeNameList_return singleTypeNameList() throws  {
		PddlParser.singleTypeNameList_return retval = new PddlParser.singleTypeNameList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME34=null;
		Token char_literal35=null;
		ParserRuleReturnScope t =null;

		Object NAME34_tree=null;
		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try { dbg.enterRule(getGrammarFileName(), "singleTypeNameList");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(141, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:5: ( ( ( NAME )+ '-' t= type ) -> ( ^( NAME $t) )+ )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:7: ( ( NAME )+ '-' t= type )
			{
			dbg.location(142,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:7: ( ( NAME )+ '-' t= type )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:8: ( NAME )+ '-' t= type
			{
			dbg.location(142,8);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:8: ( NAME )+
			int cnt15=0;
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==NAME) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:142:8: NAME
					{
					dbg.location(142,8);
					NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_singleTypeNameList693); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME34);

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(15, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt15++;
			}
			} finally {dbg.exitSubRule(15);}
			dbg.location(142,14);
			char_literal35=(Token)match(input,66,FOLLOW_66_in_singleTypeNameList696); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_66.add(char_literal35);
			dbg.location(142,19);
			pushFollow(FOLLOW_type_in_singleTypeNameList700);
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
			// 143:4: -> ( ^( NAME $t) )+
			{
				dbg.location(143,7);
				if ( !(stream_NAME.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_NAME.hasNext()||stream_t.hasNext() ) {
					dbg.location(143,7);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:143:7: ^( NAME $t)
					{
					Object root_1 = (Object)adaptor.nil();
					dbg.location(143,9);
					root_1 = (Object)adaptor.becomeRoot(stream_NAME.nextNode(), root_1);
					dbg.location(143,15);
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
		dbg.location(144, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "singleTypeNameList");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:146:1: type : ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType );
	public final PddlParser.type_return type() throws  {
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
		RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_primType=new RewriteRuleSubtreeStream(adaptor,"rule primType");

		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(146, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:2: ( ( '(' 'either' ( primType )+ ')' ) -> ^( EITHER_TYPE ( primType )+ ) | primType )
			int alt17=2;
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( (LA17_0==62) ) {
				alt17=1;
			}
			else if ( (LA17_0==NAME) ) {
				alt17=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:4: ( '(' 'either' ( primType )+ ')' )
					{
					dbg.location(147,4);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:4: ( '(' 'either' ( primType )+ ')' )
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:6: '(' 'either' ( primType )+ ')'
					{
					dbg.location(147,6);
					char_literal36=(Token)match(input,62,FOLLOW_62_in_type727); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal36);
					dbg.location(147,10);
					string_literal37=(Token)match(input,108,FOLLOW_108_in_type729); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_108.add(string_literal37);
					dbg.location(147,19);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:19: ( primType )+
					int cnt16=0;
					try { dbg.enterSubRule(16);

					loop16:
					while (true) {
						int alt16=2;
						try { dbg.enterDecision(16, decisionCanBacktrack[16]);

						int LA16_0 = input.LA(1);
						if ( (LA16_0==NAME) ) {
							alt16=1;
						}

						} finally {dbg.exitDecision(16);}

						switch (alt16) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:147:19: primType
							{
							dbg.location(147,19);
							pushFollow(FOLLOW_primType_in_type731);
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
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt16++;
					}
					} finally {dbg.exitSubRule(16);}
					dbg.location(147,29);
					char_literal39=(Token)match(input,63,FOLLOW_63_in_type734); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal39);

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
					// 148:4: -> ^( EITHER_TYPE ( primType )+ )
					{
						dbg.location(148,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:148:7: ^( EITHER_TYPE ( primType )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(148,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EITHER_TYPE, "EITHER_TYPE"), root_1);
						dbg.location(148,21);
						if ( !(stream_primType.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_primType.hasNext() ) {
							dbg.location(148,21);
							adaptor.addChild(root_1, stream_primType.nextTree());
						}
						stream_primType.reset();

						adaptor.addChild(root_0, root_1);
						}
						dbg.location(148,32);
						adaptor.addChild(root_0, new String("debug"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:149:4: primType
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(149,4);
					pushFollow(FOLLOW_primType_in_type755);
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
		dbg.location(150, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:152:1: primType : NAME ;
	public final PddlParser.primType_return primType() throws  {
		PddlParser.primType_return retval = new PddlParser.primType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME41=null;

		Object NAME41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "primType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(152, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:152:10: ( NAME )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:152:12: NAME
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(152,12);
			NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_primType765); if (state.failed) return retval;
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
		dbg.location(152, 16);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "primType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:154:1: functionsDef : '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) ;
	public final PddlParser.functionsDef_return functionsDef() throws  {
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
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");

		try { dbg.enterRule(getGrammarFileName(), "functionsDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(154, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:155:2: ( '(' ':functions' functionList ')' -> ^( FUNCTIONS functionList ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:155:4: '(' ':functions' functionList ')'
			{
			dbg.location(155,4);
			char_literal42=(Token)match(input,62,FOLLOW_62_in_functionsDef775); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal42);
			dbg.location(155,8);
			string_literal43=(Token)match(input,80,FOLLOW_80_in_functionsDef777); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_80.add(string_literal43);
			dbg.location(155,21);
			pushFollow(FOLLOW_functionList_in_functionsDef779);
			functionList44=functionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_functionList.add(functionList44.getTree());dbg.location(155,34);
			char_literal45=(Token)match(input,63,FOLLOW_63_in_functionsDef781); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal45);

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
			// 156:2: -> ^( FUNCTIONS functionList )
			{
				dbg.location(156,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:156:5: ^( FUNCTIONS functionList )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(156,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONS, "FUNCTIONS"), root_1);
				dbg.location(156,17);
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
		dbg.location(157, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "functionsDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:159:1: functionList : ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* ;
	public final PddlParser.functionList_return functionList() throws  {
		PddlParser.functionList_return retval = new PddlParser.functionList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal47=null;
		ParserRuleReturnScope atomicFunctionSkeleton46 =null;
		ParserRuleReturnScope functionType48 =null;

		Object char_literal47_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "functionList");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(159, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:2: ( ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )* )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(160,4);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:4: ( ( atomicFunctionSkeleton )+ ( '-' functionType )? )*
			try { dbg.enterSubRule(20);

			loop20:
			while (true) {
				int alt20=2;
				try { dbg.enterDecision(20, decisionCanBacktrack[20]);

				int LA20_0 = input.LA(1);
				if ( (LA20_0==62) ) {
					alt20=1;
				}

				} finally {dbg.exitDecision(20);}

				switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:5: ( atomicFunctionSkeleton )+ ( '-' functionType )?
					{
					dbg.location(160,5);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:5: ( atomicFunctionSkeleton )+
					int cnt18=0;
					try { dbg.enterSubRule(18);

					loop18:
					while (true) {
						int alt18=2;
						try { dbg.enterDecision(18, decisionCanBacktrack[18]);

						int LA18_0 = input.LA(1);
						if ( (LA18_0==62) ) {
							int LA18_2 = input.LA(2);
							if ( (synpred18_Pddl()) ) {
								alt18=1;
							}

						}

						} finally {dbg.exitDecision(18);}

						switch (alt18) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:5: atomicFunctionSkeleton
							{
							dbg.location(160,5);
							pushFollow(FOLLOW_atomicFunctionSkeleton_in_functionList802);
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
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt18++;
					}
					} finally {dbg.exitSubRule(18);}
					dbg.location(160,29);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:29: ( '-' functionType )?
					int alt19=2;
					try { dbg.enterSubRule(19);
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==66) ) {
						alt19=1;
					}
					} finally {dbg.exitDecision(19);}

					switch (alt19) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:30: '-' functionType
							{
							dbg.location(160,30);
							char_literal47=(Token)match(input,66,FOLLOW_66_in_functionList806); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal47_tree = (Object)adaptor.create(char_literal47);
							adaptor.addChild(root_0, char_literal47_tree);
							}
							dbg.location(160,34);
							pushFollow(FOLLOW_functionType_in_functionList808);
							functionType48=functionType();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, functionType48.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(19);}

					}
					break;

				default :
					break loop20;
				}
			}
			} finally {dbg.exitSubRule(20);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(161, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "functionList");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:163:1: atomicFunctionSkeleton : '(' ! functionSymbol ^ typedVariableList ')' !;
	public final PddlParser.atomicFunctionSkeleton_return atomicFunctionSkeleton() throws  {
		PddlParser.atomicFunctionSkeleton_return retval = new PddlParser.atomicFunctionSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal49=null;
		Token char_literal52=null;
		ParserRuleReturnScope functionSymbol50 =null;
		ParserRuleReturnScope typedVariableList51 =null;

		Object char_literal49_tree=null;
		Object char_literal52_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atomicFunctionSkeleton");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(163, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:164:2: ( '(' ! functionSymbol ^ typedVariableList ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:164:4: '(' ! functionSymbol ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(164,7);
			char_literal49=(Token)match(input,62,FOLLOW_62_in_atomicFunctionSkeleton824); if (state.failed) return retval;dbg.location(164,23);
			pushFollow(FOLLOW_functionSymbol_in_atomicFunctionSkeleton827);
			functionSymbol50=functionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(functionSymbol50.getTree(), root_0);dbg.location(164,25);
			pushFollow(FOLLOW_typedVariableList_in_atomicFunctionSkeleton830);
			typedVariableList51=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList51.getTree());
			dbg.location(164,46);
			char_literal52=(Token)match(input,63,FOLLOW_63_in_atomicFunctionSkeleton832); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(165, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atomicFunctionSkeleton");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:167:1: functionSymbol : ( NAME | '#t' );
	public final PddlParser.functionSymbol_return functionSymbol() throws  {
		PddlParser.functionSymbol_return retval = new PddlParser.functionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set53=null;

		Object set53_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "functionSymbol");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(167, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:167:16: ( NAME | '#t' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(167,16);
			set53=input.LT(1);
			if ( input.LA(1)==NAME||input.LA(1)==61 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set53));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(167, 28);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "functionSymbol");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:169:1: functionType : 'number' ;
	public final PddlParser.functionType_return functionType() throws  {
		PddlParser.functionType_return retval = new PddlParser.functionType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal54=null;

		Object string_literal54_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "functionType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(169, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:169:14: ( 'number' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:169:16: 'number'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(169,16);
			string_literal54=(Token)match(input,120,FOLLOW_120_in_functionType855); if (state.failed) return retval;
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
		dbg.location(169, 24);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "functionType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:171:1: constantsDef : '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) ;
	public final PddlParser.constantsDef_return constantsDef() throws  {
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
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try { dbg.enterRule(getGrammarFileName(), "constantsDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(171, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:172:2: ( '(' ':constants' typedNameList ')' -> ^( CONSTANTS typedNameList ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:172:4: '(' ':constants' typedNameList ')'
			{
			dbg.location(172,4);
			char_literal55=(Token)match(input,62,FOLLOW_62_in_constantsDef866); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal55);
			dbg.location(172,8);
			string_literal56=(Token)match(input,70,FOLLOW_70_in_constantsDef868); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_70.add(string_literal56);
			dbg.location(172,21);
			pushFollow(FOLLOW_typedNameList_in_constantsDef870);
			typedNameList57=typedNameList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList57.getTree());dbg.location(172,35);
			char_literal58=(Token)match(input,63,FOLLOW_63_in_constantsDef872); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal58);

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
			// 173:2: -> ^( CONSTANTS typedNameList )
			{
				dbg.location(173,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:173:5: ^( CONSTANTS typedNameList )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(173,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONSTANTS, "CONSTANTS"), root_1);
				dbg.location(173,17);
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
		dbg.location(174, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constantsDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:176:1: predicatesDef : '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) ;
	public final PddlParser.predicatesDef_return predicatesDef() throws  {
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
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_atomicFormulaSkeleton=new RewriteRuleSubtreeStream(adaptor,"rule atomicFormulaSkeleton");

		try { dbg.enterRule(getGrammarFileName(), "predicatesDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(176, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:177:2: ( '(' ':predicates' ( atomicFormulaSkeleton )+ ')' -> ^( PREDICATES ( atomicFormulaSkeleton )+ ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:177:4: '(' ':predicates' ( atomicFormulaSkeleton )+ ')'
			{
			dbg.location(177,4);
			char_literal59=(Token)match(input,62,FOLLOW_62_in_predicatesDef892); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal59);
			dbg.location(177,8);
			string_literal60=(Token)match(input,87,FOLLOW_87_in_predicatesDef894); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_87.add(string_literal60);
			dbg.location(177,22);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:177:22: ( atomicFormulaSkeleton )+
			int cnt21=0;
			try { dbg.enterSubRule(21);

			loop21:
			while (true) {
				int alt21=2;
				try { dbg.enterDecision(21, decisionCanBacktrack[21]);

				int LA21_0 = input.LA(1);
				if ( (LA21_0==62) ) {
					alt21=1;
				}

				} finally {dbg.exitDecision(21);}

				switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:177:22: atomicFormulaSkeleton
					{
					dbg.location(177,22);
					pushFollow(FOLLOW_atomicFormulaSkeleton_in_predicatesDef896);
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
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt21++;
			}
			} finally {dbg.exitSubRule(21);}
			dbg.location(177,45);
			char_literal62=(Token)match(input,63,FOLLOW_63_in_predicatesDef899); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal62);

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
			// 178:2: -> ^( PREDICATES ( atomicFormulaSkeleton )+ )
			{
				dbg.location(178,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:178:5: ^( PREDICATES ( atomicFormulaSkeleton )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(178,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PREDICATES, "PREDICATES"), root_1);
				dbg.location(178,18);
				if ( !(stream_atomicFormulaSkeleton.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_atomicFormulaSkeleton.hasNext() ) {
					dbg.location(178,18);
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
		dbg.location(179, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "predicatesDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:181:1: atomicFormulaSkeleton : '(' ! predicate ^ typedVariableList ')' !;
	public final PddlParser.atomicFormulaSkeleton_return atomicFormulaSkeleton() throws  {
		PddlParser.atomicFormulaSkeleton_return retval = new PddlParser.atomicFormulaSkeleton_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal63=null;
		Token char_literal66=null;
		ParserRuleReturnScope predicate64 =null;
		ParserRuleReturnScope typedVariableList65 =null;

		Object char_literal63_tree=null;
		Object char_literal66_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atomicFormulaSkeleton");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(181, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:182:2: ( '(' ! predicate ^ typedVariableList ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:182:4: '(' ! predicate ^ typedVariableList ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(182,7);
			char_literal63=(Token)match(input,62,FOLLOW_62_in_atomicFormulaSkeleton920); if (state.failed) return retval;dbg.location(182,18);
			pushFollow(FOLLOW_predicate_in_atomicFormulaSkeleton923);
			predicate64=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(predicate64.getTree(), root_0);dbg.location(182,20);
			pushFollow(FOLLOW_typedVariableList_in_atomicFormulaSkeleton926);
			typedVariableList65=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList65.getTree());
			dbg.location(182,41);
			char_literal66=(Token)match(input,63,FOLLOW_63_in_atomicFormulaSkeleton928); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(183, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atomicFormulaSkeleton");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:185:1: predicate : NAME ;
	public final PddlParser.predicate_return predicate() throws  {
		PddlParser.predicate_return retval = new PddlParser.predicate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME67=null;

		Object NAME67_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "predicate");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(185, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:185:11: ( NAME )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:185:13: NAME
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(185,13);
			NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_predicate939); if (state.failed) return retval;
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
		dbg.location(185, 17);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "predicate");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:188:1: typedVariableList : ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) ;
	public final PddlParser.typedVariableList_return typedVariableList() throws  {
		PddlParser.typedVariableList_return retval = new PddlParser.typedVariableList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE68=null;
		Token VARIABLE70=null;
		ParserRuleReturnScope singleTypeVarList69 =null;

		Object VARIABLE68_tree=null;
		Object VARIABLE70_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "typedVariableList");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(188, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:5: ( ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(189,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )
			int alt25=2;
			try { dbg.enterSubRule(25);
			try { dbg.enterDecision(25, decisionCanBacktrack[25]);

			try {
				isCyclicDecision = true;
				alt25 = dfa25.predict(input);
			}
			catch (NoViableAltException nvae) {
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(25);}

			switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:8: ( VARIABLE )*
					{
					dbg.location(189,8);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:8: ( VARIABLE )*
					try { dbg.enterSubRule(22);

					loop22:
					while (true) {
						int alt22=2;
						try { dbg.enterDecision(22, decisionCanBacktrack[22]);

						int LA22_0 = input.LA(1);
						if ( (LA22_0==VARIABLE) ) {
							alt22=1;
						}

						} finally {dbg.exitDecision(22);}

						switch (alt22) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:8: VARIABLE
							{
							dbg.location(189,8);
							VARIABLE68=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList954); if (state.failed) return retval;
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
					} finally {dbg.exitSubRule(22);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:20: ( singleTypeVarList )+ ( VARIABLE )*
					{
					dbg.location(189,20);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:20: ( singleTypeVarList )+
					int cnt23=0;
					try { dbg.enterSubRule(23);

					loop23:
					while (true) {
						int alt23=2;
						try { dbg.enterDecision(23, decisionCanBacktrack[23]);

						try {
							isCyclicDecision = true;
							alt23 = dfa23.predict(input);
						}
						catch (NoViableAltException nvae) {
							dbg.recognitionException(nvae);
							throw nvae;
						}
						} finally {dbg.exitDecision(23);}

						switch (alt23) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:20: singleTypeVarList
							{
							dbg.location(189,20);
							pushFollow(FOLLOW_singleTypeVarList_in_typedVariableList959);
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
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt23++;
					}
					} finally {dbg.exitSubRule(23);}
					dbg.location(189,39);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:39: ( VARIABLE )*
					try { dbg.enterSubRule(24);

					loop24:
					while (true) {
						int alt24=2;
						try { dbg.enterDecision(24, decisionCanBacktrack[24]);

						int LA24_0 = input.LA(1);
						if ( (LA24_0==VARIABLE) ) {
							alt24=1;
						}

						} finally {dbg.exitDecision(24);}

						switch (alt24) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:189:39: VARIABLE
							{
							dbg.location(189,39);
							VARIABLE70=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_typedVariableList962); if (state.failed) return retval;
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
					} finally {dbg.exitSubRule(24);}

					}
					break;

			}
			} finally {dbg.exitSubRule(25);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(190, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "typedVariableList");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:192:1: singleTypeVarList : ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ ;
	public final PddlParser.singleTypeVarList_return singleTypeVarList() throws  {
		PddlParser.singleTypeVarList_return retval = new PddlParser.singleTypeVarList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VARIABLE71=null;
		Token char_literal72=null;
		ParserRuleReturnScope t =null;

		Object VARIABLE71_tree=null;
		Object char_literal72_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_VARIABLE=new RewriteRuleTokenStream(adaptor,"token VARIABLE");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try { dbg.enterRule(getGrammarFileName(), "singleTypeVarList");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(192, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:5: ( ( ( VARIABLE )+ '-' t= type ) -> ( ^( VARIABLE $t) )+ )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:7: ( ( VARIABLE )+ '-' t= type )
			{
			dbg.location(193,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:7: ( ( VARIABLE )+ '-' t= type )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:8: ( VARIABLE )+ '-' t= type
			{
			dbg.location(193,8);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:8: ( VARIABLE )+
			int cnt26=0;
			try { dbg.enterSubRule(26);

			loop26:
			while (true) {
				int alt26=2;
				try { dbg.enterDecision(26, decisionCanBacktrack[26]);

				int LA26_0 = input.LA(1);
				if ( (LA26_0==VARIABLE) ) {
					alt26=1;
				}

				} finally {dbg.exitDecision(26);}

				switch (alt26) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:193:8: VARIABLE
					{
					dbg.location(193,8);
					VARIABLE71=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_singleTypeVarList982); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VARIABLE.add(VARIABLE71);

					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(26, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt26++;
			}
			} finally {dbg.exitSubRule(26);}
			dbg.location(193,18);
			char_literal72=(Token)match(input,66,FOLLOW_66_in_singleTypeVarList985); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_66.add(char_literal72);
			dbg.location(193,23);
			pushFollow(FOLLOW_type_in_singleTypeVarList989);
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
			// 194:7: -> ( ^( VARIABLE $t) )+
			{
				dbg.location(194,10);
				if ( !(stream_VARIABLE.hasNext()||stream_t.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_VARIABLE.hasNext()||stream_t.hasNext() ) {
					dbg.location(194,10);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:194:10: ^( VARIABLE $t)
					{
					Object root_1 = (Object)adaptor.nil();
					dbg.location(194,12);
					root_1 = (Object)adaptor.becomeRoot(stream_VARIABLE.nextNode(), root_1);
					dbg.location(194,22);
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
		dbg.location(195, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "singleTypeVarList");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:197:1: constraints : '(' ! ':constraints' ^ conGD ')' !;
	public final PddlParser.constraints_return constraints() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "constraints");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(197, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:198:2: ( '(' ! ':constraints' ^ conGD ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:198:4: '(' ! ':constraints' ^ conGD ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(198,7);
			char_literal73=(Token)match(input,62,FOLLOW_62_in_constraints1020); if (state.failed) return retval;dbg.location(198,23);
			string_literal74=(Token)match(input,72,FOLLOW_72_in_constraints1023); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal74_tree = (Object)adaptor.create(string_literal74);
			root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
			}
			dbg.location(198,25);
			pushFollow(FOLLOW_conGD_in_constraints1026);
			conGD75=conGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD75.getTree());
			dbg.location(198,34);
			char_literal76=(Token)match(input,63,FOLLOW_63_in_constraints1028); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(199, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constraints");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:201:1: structureDef : ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef );
	public final PddlParser.structureDef_return structureDef() throws  {
		PddlParser.structureDef_return retval = new PddlParser.structureDef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope actionDef77 =null;
		ParserRuleReturnScope durativeActionDef78 =null;
		ParserRuleReturnScope derivedDef79 =null;
		ParserRuleReturnScope constraintDef80 =null;
		ParserRuleReturnScope processDef81 =null;
		ParserRuleReturnScope eventDef82 =null;


		try { dbg.enterRule(getGrammarFileName(), "structureDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(201, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:202:2: ( actionDef | durativeActionDef | derivedDef | constraintDef | processDef | eventDef )
			int alt27=6;
			try { dbg.enterDecision(27, decisionCanBacktrack[27]);

			int LA27_0 = input.LA(1);
			if ( (LA27_0==62) ) {
				switch ( input.LA(2) ) {
				case 68:
					{
					alt27=1;
					}
					break;
				case 76:
					{
					alt27=2;
					}
					break;
				case 73:
					{
					alt27=3;
					}
					break;
				case 71:
					{
					alt27=4;
					}
					break;
				case 88:
					{
					alt27=5;
					}
					break;
				case 78:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(27);}

			switch (alt27) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:202:4: actionDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(202,4);
					pushFollow(FOLLOW_actionDef_in_structureDef1040);
					actionDef77=actionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, actionDef77.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:203:4: durativeActionDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(203,4);
					pushFollow(FOLLOW_durativeActionDef_in_structureDef1045);
					durativeActionDef78=durativeActionDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durativeActionDef78.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:204:4: derivedDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(204,4);
					pushFollow(FOLLOW_derivedDef_in_structureDef1050);
					derivedDef79=derivedDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, derivedDef79.getTree());

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:205:4: constraintDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(205,4);
					pushFollow(FOLLOW_constraintDef_in_structureDef1055);
					constraintDef80=constraintDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constraintDef80.getTree());

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:206:4: processDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(206,4);
					pushFollow(FOLLOW_processDef_in_structureDef1060);
					processDef81=processDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, processDef81.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:207:4: eventDef
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(207,4);
					pushFollow(FOLLOW_eventDef_in_structureDef1065);
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
		dbg.location(208, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "structureDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:213:1: actionDef : '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.actionDef_return actionDef() throws  {
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
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try { dbg.enterRule(getGrammarFileName(), "actionDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(213, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:214:2: ( '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:214:4: '(' ':action' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			dbg.location(214,4);
			char_literal83=(Token)match(input,62,FOLLOW_62_in_actionDef1080); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal83);
			dbg.location(214,8);
			string_literal84=(Token)match(input,68,FOLLOW_68_in_actionDef1082); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_68.add(string_literal84);
			dbg.location(214,18);
			pushFollow(FOLLOW_actionSymbol_in_actionDef1084);
			actionSymbol85=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol85.getTree());dbg.location(215,8);
			string_literal86=(Token)match(input,85,FOLLOW_85_in_actionDef1093); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal86);
			dbg.location(215,23);
			char_literal87=(Token)match(input,62,FOLLOW_62_in_actionDef1096); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal87);
			dbg.location(215,27);
			pushFollow(FOLLOW_typedVariableList_in_actionDef1098);
			typedVariableList88=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList88.getTree());dbg.location(215,45);
			char_literal89=(Token)match(input,63,FOLLOW_63_in_actionDef1100); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal89);
			dbg.location(216,12);
			pushFollow(FOLLOW_actionDefBody_in_actionDef1113);
			actionDefBody90=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody90.getTree());dbg.location(216,26);
			char_literal91=(Token)match(input,63,FOLLOW_63_in_actionDef1115); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal91);

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
			// 217:8: -> ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
			{
				dbg.location(217,11);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:217:11: ^( ACTION actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(217,13);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACTION, "ACTION"), root_1);
				dbg.location(217,20);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());dbg.location(217,33);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:217:33: ( typedVariableList )?
				if ( stream_typedVariableList.hasNext() ) {
					dbg.location(217,33);
					adaptor.addChild(root_1, stream_typedVariableList.nextTree());
				}
				stream_typedVariableList.reset();
				dbg.location(217,52);
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
		dbg.location(218, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "actionDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:219:1: eventDef : '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.eventDef_return eventDef() throws  {
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
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try { dbg.enterRule(getGrammarFileName(), "eventDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(219, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:220:2: ( '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:220:4: '(' ':event' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			dbg.location(220,4);
			char_literal92=(Token)match(input,62,FOLLOW_62_in_eventDef1148); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal92);
			dbg.location(220,8);
			string_literal93=(Token)match(input,78,FOLLOW_78_in_eventDef1150); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_78.add(string_literal93);
			dbg.location(220,17);
			pushFollow(FOLLOW_actionSymbol_in_eventDef1152);
			actionSymbol94=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol94.getTree());dbg.location(221,8);
			string_literal95=(Token)match(input,85,FOLLOW_85_in_eventDef1161); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal95);
			dbg.location(221,23);
			char_literal96=(Token)match(input,62,FOLLOW_62_in_eventDef1164); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal96);
			dbg.location(221,27);
			pushFollow(FOLLOW_typedVariableList_in_eventDef1166);
			typedVariableList97=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList97.getTree());dbg.location(221,45);
			char_literal98=(Token)match(input,63,FOLLOW_63_in_eventDef1168); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal98);
			dbg.location(222,12);
			pushFollow(FOLLOW_actionDefBody_in_eventDef1181);
			actionDefBody99=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody99.getTree());dbg.location(222,26);
			char_literal100=(Token)match(input,63,FOLLOW_63_in_eventDef1183); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal100);

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
			// 223:8: -> ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
			{
				dbg.location(223,11);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:223:11: ^( EVENT actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(223,13);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EVENT, "EVENT"), root_1);
				dbg.location(223,19);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());dbg.location(223,32);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:223:32: ( typedVariableList )?
				if ( stream_typedVariableList.hasNext() ) {
					dbg.location(223,32);
					adaptor.addChild(root_1, stream_typedVariableList.nextTree());
				}
				stream_typedVariableList.reset();
				dbg.location(223,51);
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
		dbg.location(224, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "eventDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:225:1: processDef : '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) ;
	public final PddlParser.processDef_return processDef() throws  {
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
		RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionDefBody=new RewriteRuleSubtreeStream(adaptor,"rule actionDefBody");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try { dbg.enterRule(getGrammarFileName(), "processDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(225, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:226:2: ( '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')' -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:226:4: '(' ':process' actionSymbol ':parameters' '(' typedVariableList ')' actionDefBody ')'
			{
			dbg.location(226,4);
			char_literal101=(Token)match(input,62,FOLLOW_62_in_processDef1216); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal101);
			dbg.location(226,8);
			string_literal102=(Token)match(input,88,FOLLOW_88_in_processDef1218); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_88.add(string_literal102);
			dbg.location(226,19);
			pushFollow(FOLLOW_actionSymbol_in_processDef1220);
			actionSymbol103=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol103.getTree());dbg.location(227,8);
			string_literal104=(Token)match(input,85,FOLLOW_85_in_processDef1229); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal104);
			dbg.location(227,23);
			char_literal105=(Token)match(input,62,FOLLOW_62_in_processDef1232); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal105);
			dbg.location(227,27);
			pushFollow(FOLLOW_typedVariableList_in_processDef1234);
			typedVariableList106=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList106.getTree());dbg.location(227,45);
			char_literal107=(Token)match(input,63,FOLLOW_63_in_processDef1236); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal107);
			dbg.location(228,12);
			pushFollow(FOLLOW_actionDefBody_in_processDef1249);
			actionDefBody108=actionDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionDefBody.add(actionDefBody108.getTree());dbg.location(228,26);
			char_literal109=(Token)match(input,63,FOLLOW_63_in_processDef1251); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal109);

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
			// 229:8: -> ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
			{
				dbg.location(229,11);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:229:11: ^( PROCESS actionSymbol ( typedVariableList )? actionDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(229,13);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROCESS, "PROCESS"), root_1);
				dbg.location(229,21);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());dbg.location(229,34);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:229:34: ( typedVariableList )?
				if ( stream_typedVariableList.hasNext() ) {
					dbg.location(229,34);
					adaptor.addChild(root_1, stream_typedVariableList.nextTree());
				}
				stream_typedVariableList.reset();
				dbg.location(229,53);
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
		dbg.location(230, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "processDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:232:1: constraintDef : '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) ;
	public final PddlParser.constraintDef_return constraintDef() throws  {
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
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_constraintDefBody=new RewriteRuleSubtreeStream(adaptor,"rule constraintDefBody");
		RewriteRuleSubtreeStream stream_constraintSymbol=new RewriteRuleSubtreeStream(adaptor,"rule constraintSymbol");

		try { dbg.enterRule(getGrammarFileName(), "constraintDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(232, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:233:2: ( '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')' -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:233:4: '(' ':constraint' constraintSymbol ':parameters' '(' typedVariableList ')' constraintDefBody ')'
			{
			dbg.location(233,4);
			char_literal110=(Token)match(input,62,FOLLOW_62_in_constraintDef1285); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal110);
			dbg.location(233,8);
			string_literal111=(Token)match(input,71,FOLLOW_71_in_constraintDef1287); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_71.add(string_literal111);
			dbg.location(233,22);
			pushFollow(FOLLOW_constraintSymbol_in_constraintDef1289);
			constraintSymbol112=constraintSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintSymbol.add(constraintSymbol112.getTree());dbg.location(234,8);
			string_literal113=(Token)match(input,85,FOLLOW_85_in_constraintDef1298); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal113);
			dbg.location(234,23);
			char_literal114=(Token)match(input,62,FOLLOW_62_in_constraintDef1301); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal114);
			dbg.location(234,27);
			pushFollow(FOLLOW_typedVariableList_in_constraintDef1303);
			typedVariableList115=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList115.getTree());dbg.location(234,45);
			char_literal116=(Token)match(input,63,FOLLOW_63_in_constraintDef1305); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal116);
			dbg.location(235,12);
			pushFollow(FOLLOW_constraintDefBody_in_constraintDef1318);
			constraintDefBody117=constraintDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraintDefBody.add(constraintDefBody117.getTree());dbg.location(235,30);
			char_literal118=(Token)match(input,63,FOLLOW_63_in_constraintDef1320); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal118);

			// AST REWRITE
			// elements: constraintDefBody, constraintSymbol, typedVariableList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 236:8: -> ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
			{
				dbg.location(236,11);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:236:11: ^( GLOBAL_CONSTRAINT constraintSymbol ( typedVariableList )? constraintDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(236,13);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GLOBAL_CONSTRAINT, "GLOBAL_CONSTRAINT"), root_1);
				dbg.location(236,31);
				adaptor.addChild(root_1, stream_constraintSymbol.nextTree());dbg.location(236,48);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:236:48: ( typedVariableList )?
				if ( stream_typedVariableList.hasNext() ) {
					dbg.location(236,48);
					adaptor.addChild(root_1, stream_typedVariableList.nextTree());
				}
				stream_typedVariableList.reset();
				dbg.location(236,67);
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
		dbg.location(237, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constraintDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:240:1: actionSymbol : NAME ;
	public final PddlParser.actionSymbol_return actionSymbol() throws  {
		PddlParser.actionSymbol_return retval = new PddlParser.actionSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME119=null;

		Object NAME119_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "actionSymbol");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(240, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:240:14: ( NAME )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:240:16: NAME
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(240,16);
			NAME119=(Token)match(input,NAME,FOLLOW_NAME_in_actionSymbol1354); if (state.failed) return retval;
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
		dbg.location(240, 20);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "actionSymbol");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:242:1: constraintSymbol : NAME ;
	public final PddlParser.constraintSymbol_return constraintSymbol() throws  {
		PddlParser.constraintSymbol_return retval = new PddlParser.constraintSymbol_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NAME120=null;

		Object NAME120_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "constraintSymbol");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(242, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:242:18: ( NAME )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:242:20: NAME
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(242,20);
			NAME120=(Token)match(input,NAME,FOLLOW_NAME_in_constraintSymbol1363); if (state.failed) return retval;
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
		dbg.location(242, 24);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constraintSymbol");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:247:1: actionDefBody : ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) ;
	public final PddlParser.actionDefBody_return actionDefBody() throws  {
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
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");

		try { dbg.enterRule(getGrammarFileName(), "actionDefBody");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(247, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:2: ( ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )? -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )? ( ':effect' ( ( '(' ')' ) | effect ) )?
			{
			dbg.location(248,4);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:4: ( ':precondition' ( ( '(' ')' ) | goalDesc ) )?
			int alt29=2;
			try { dbg.enterSubRule(29);
			try { dbg.enterDecision(29, decisionCanBacktrack[29]);

			int LA29_0 = input.LA(1);
			if ( (LA29_0==86) ) {
				alt29=1;
			}
			} finally {dbg.exitDecision(29);}

			switch (alt29) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:6: ':precondition' ( ( '(' ')' ) | goalDesc )
					{
					dbg.location(248,6);
					string_literal121=(Token)match(input,86,FOLLOW_86_in_actionDefBody1378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_86.add(string_literal121);
					dbg.location(248,22);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:22: ( ( '(' ')' ) | goalDesc )
					int alt28=2;
					try { dbg.enterSubRule(28);
					try { dbg.enterDecision(28, decisionCanBacktrack[28]);

					int LA28_0 = input.LA(1);
					if ( (LA28_0==62) ) {
						int LA28_1 = input.LA(2);
						if ( (LA28_1==63) ) {
							alt28=1;
						}
						else if ( (LA28_1==NAME||(LA28_1 >= 91 && LA28_1 <= 95)||LA28_1==101||(LA28_1 >= 110 && LA28_1 <= 111)||LA28_1==114||LA28_1==119||LA28_1==121) ) {
							alt28=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 28, 1, input);
								dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(28);}

					switch (alt28) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:23: ( '(' ')' )
							{
							dbg.location(248,23);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:23: ( '(' ')' )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:24: '(' ')'
							{
							dbg.location(248,24);
							char_literal122=(Token)match(input,62,FOLLOW_62_in_actionDefBody1382); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_62.add(char_literal122);
							dbg.location(248,28);
							char_literal123=(Token)match(input,63,FOLLOW_63_in_actionDefBody1384); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_63.add(char_literal123);

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:248:35: goalDesc
							{
							dbg.location(248,35);
							pushFollow(FOLLOW_goalDesc_in_actionDefBody1389);
							goalDesc124=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc124.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(28);}

					}
					break;

			}
			} finally {dbg.exitSubRule(29);}
			dbg.location(249,4);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:4: ( ':effect' ( ( '(' ')' ) | effect ) )?
			int alt31=2;
			try { dbg.enterSubRule(31);
			try { dbg.enterDecision(31, decisionCanBacktrack[31]);

			int LA31_0 = input.LA(1);
			if ( (LA31_0==77) ) {
				alt31=1;
			}
			} finally {dbg.exitDecision(31);}

			switch (alt31) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:6: ':effect' ( ( '(' ')' ) | effect )
					{
					dbg.location(249,6);
					string_literal125=(Token)match(input,77,FOLLOW_77_in_actionDefBody1399); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_77.add(string_literal125);
					dbg.location(249,16);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:16: ( ( '(' ')' ) | effect )
					int alt30=2;
					try { dbg.enterSubRule(30);
					try { dbg.enterDecision(30, decisionCanBacktrack[30]);

					int LA30_0 = input.LA(1);
					if ( (LA30_0==62) ) {
						int LA30_1 = input.LA(2);
						if ( (LA30_1==63) ) {
							alt30=1;
						}
						else if ( (LA30_1==NAME||(LA30_1 >= 101 && LA30_1 <= 102)||LA30_1==105||LA30_1==111||LA30_1==115||LA30_1==119||(LA30_1 >= 125 && LA30_1 <= 126)||LA30_1==131) ) {
							alt30=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 30, 1, input);
								dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(30);}

					switch (alt30) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:17: ( '(' ')' )
							{
							dbg.location(249,17);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:17: ( '(' ')' )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:18: '(' ')'
							{
							dbg.location(249,18);
							char_literal126=(Token)match(input,62,FOLLOW_62_in_actionDefBody1403); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_62.add(char_literal126);
							dbg.location(249,22);
							char_literal127=(Token)match(input,63,FOLLOW_63_in_actionDefBody1405); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_63.add(char_literal127);

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:249:29: effect
							{
							dbg.location(249,29);
							pushFollow(FOLLOW_effect_in_actionDefBody1410);
							effect128=effect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_effect.add(effect128.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(30);}

					}
					break;

			}
			} finally {dbg.exitSubRule(31);}

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
			// 250:4: -> ^( PRECONDITION ( goalDesc )? ) ^( EFFECT ( effect )? )
			{
				dbg.location(250,7);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:250:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(250,9);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				dbg.location(250,22);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:250:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					dbg.location(250,22);
					adaptor.addChild(root_1, stream_goalDesc.nextTree());
				}
				stream_goalDesc.reset();

				adaptor.addChild(root_0, root_1);
				}
				dbg.location(250,33);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:250:33: ^( EFFECT ( effect )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(250,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EFFECT, "EFFECT"), root_1);
				dbg.location(250,42);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:250:42: ( effect )?
				if ( stream_effect.hasNext() ) {
					dbg.location(250,42);
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
		dbg.location(251, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "actionDefBody");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:253:1: constraintDefBody : ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) ;
	public final PddlParser.constraintDefBody_return constraintDefBody() throws  {
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try { dbg.enterRule(getGrammarFileName(), "constraintDefBody");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(253, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:2: ( ( ':condition' ( ( '(' ')' ) | goalDesc ) )? -> ^( PRECONDITION ( goalDesc )? ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			{
			dbg.location(254,4);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:4: ( ':condition' ( ( '(' ')' ) | goalDesc ) )?
			int alt33=2;
			try { dbg.enterSubRule(33);
			try { dbg.enterDecision(33, decisionCanBacktrack[33]);

			int LA33_0 = input.LA(1);
			if ( (LA33_0==69) ) {
				alt33=1;
			}
			} finally {dbg.exitDecision(33);}

			switch (alt33) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:6: ':condition' ( ( '(' ')' ) | goalDesc )
					{
					dbg.location(254,6);
					string_literal129=(Token)match(input,69,FOLLOW_69_in_constraintDefBody1445); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_69.add(string_literal129);
					dbg.location(254,19);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:19: ( ( '(' ')' ) | goalDesc )
					int alt32=2;
					try { dbg.enterSubRule(32);
					try { dbg.enterDecision(32, decisionCanBacktrack[32]);

					int LA32_0 = input.LA(1);
					if ( (LA32_0==62) ) {
						int LA32_1 = input.LA(2);
						if ( (LA32_1==63) ) {
							alt32=1;
						}
						else if ( (LA32_1==NAME||(LA32_1 >= 91 && LA32_1 <= 95)||LA32_1==101||(LA32_1 >= 110 && LA32_1 <= 111)||LA32_1==114||LA32_1==119||LA32_1==121) ) {
							alt32=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 32, 1, input);
								dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(32);}

					switch (alt32) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:20: ( '(' ')' )
							{
							dbg.location(254,20);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:20: ( '(' ')' )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:21: '(' ')'
							{
							dbg.location(254,21);
							char_literal130=(Token)match(input,62,FOLLOW_62_in_constraintDefBody1449); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_62.add(char_literal130);
							dbg.location(254,25);
							char_literal131=(Token)match(input,63,FOLLOW_63_in_constraintDefBody1451); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_63.add(char_literal131);

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:254:32: goalDesc
							{
							dbg.location(254,32);
							pushFollow(FOLLOW_goalDesc_in_constraintDefBody1456);
							goalDesc132=goalDesc();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc132.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(32);}

					}
					break;

			}
			} finally {dbg.exitSubRule(33);}

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
			// 255:4: -> ^( PRECONDITION ( goalDesc )? )
			{
				dbg.location(255,7);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:255:7: ^( PRECONDITION ( goalDesc )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(255,9);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRECONDITION, "PRECONDITION"), root_1);
				dbg.location(255,22);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:255:22: ( goalDesc )?
				if ( stream_goalDesc.hasNext() ) {
					dbg.location(255,22);
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
		dbg.location(256, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constraintDefBody");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:270:1: goalDesc : ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) );
	public final PddlParser.goalDesc_return goalDesc() throws  {
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
		RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
		RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
		RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
		RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
		RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
		RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_fComp=new RewriteRuleSubtreeStream(adaptor,"rule fComp");
		RewriteRuleSubtreeStream stream_equality=new RewriteRuleSubtreeStream(adaptor,"rule equality");

		try { dbg.enterRule(getGrammarFileName(), "goalDesc");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(270, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:271:2: ( atomicTermFormula | '(' 'and' ( goalDesc )* ')' -> ^( AND_GD ( goalDesc )* ) | '(' 'or' ( goalDesc )* ')' -> ^( OR_GD ( goalDesc )* ) | '(' 'not' goalDesc ')' -> ^( NOT_GD goalDesc ) | '(' 'imply' goalDesc goalDesc ')' -> ^( IMPLY_GD goalDesc goalDesc ) | '(' 'exists' '(' typedVariableList ')' goalDesc ')' -> ^( EXISTS_GD typedVariableList goalDesc ) | '(' 'forall' '(' typedVariableList ')' goalDesc ')' -> ^( FORALL_GD typedVariableList goalDesc ) | fComp -> ^( COMPARISON_GD fComp ) | equality -> ^( EQUALITY_CON equality ) )
			int alt36=9;
			try { dbg.enterDecision(36, decisionCanBacktrack[36]);

			int LA36_0 = input.LA(1);
			if ( (LA36_0==62) ) {
				switch ( input.LA(2) ) {
				case 101:
					{
					alt36=2;
					}
					break;
				case 121:
					{
					alt36=3;
					}
					break;
				case 119:
					{
					alt36=4;
					}
					break;
				case 114:
					{
					alt36=5;
					}
					break;
				case 110:
					{
					alt36=6;
					}
					break;
				case 111:
					{
					alt36=7;
					}
					break;
				case 93:
					{
					switch ( input.LA(3) ) {
					case NAME:
						{
						switch ( input.LA(4) ) {
						case NAME:
							{
							int LA36_13 = input.LA(5);
							if ( (LA36_13==63) ) {
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
									dbg.recognitionException(nvae);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case NUMBER:
						case 61:
						case 62:
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
								dbg.recognitionException(nvae);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case NUMBER:
					case 61:
					case 62:
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
							dbg.recognitionException(nvae);
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
				case 91:
				case 92:
				case 94:
				case 95:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(36);}

			switch (alt36) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:271:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(271,4);
					pushFollow(FOLLOW_atomicTermFormula_in_goalDesc1494);
					atomicTermFormula133=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula133.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:272:4: '(' 'and' ( goalDesc )* ')'
					{
					dbg.location(272,4);
					char_literal134=(Token)match(input,62,FOLLOW_62_in_goalDesc1499); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal134);
					dbg.location(272,8);
					string_literal135=(Token)match(input,101,FOLLOW_101_in_goalDesc1501); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_101.add(string_literal135);
					dbg.location(272,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:272:14: ( goalDesc )*
					try { dbg.enterSubRule(34);

					loop34:
					while (true) {
						int alt34=2;
						try { dbg.enterDecision(34, decisionCanBacktrack[34]);

						int LA34_0 = input.LA(1);
						if ( (LA34_0==62) ) {
							alt34=1;
						}

						} finally {dbg.exitDecision(34);}

						switch (alt34) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:272:14: goalDesc
							{
							dbg.location(272,14);
							pushFollow(FOLLOW_goalDesc_in_goalDesc1503);
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
					} finally {dbg.exitSubRule(34);}
					dbg.location(272,24);
					char_literal137=(Token)match(input,63,FOLLOW_63_in_goalDesc1506); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal137);

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
					// 273:12: -> ^( AND_GD ( goalDesc )* )
					{
						dbg.location(273,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:273:15: ^( AND_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(273,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_GD, "AND_GD"), root_1);
						dbg.location(273,24);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:273:24: ( goalDesc )*
						while ( stream_goalDesc.hasNext() ) {
							dbg.location(273,24);
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
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:274:4: '(' 'or' ( goalDesc )* ')'
					{
					dbg.location(274,4);
					char_literal138=(Token)match(input,62,FOLLOW_62_in_goalDesc1531); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal138);
					dbg.location(274,8);
					string_literal139=(Token)match(input,121,FOLLOW_121_in_goalDesc1533); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_121.add(string_literal139);
					dbg.location(274,13);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:274:13: ( goalDesc )*
					try { dbg.enterSubRule(35);

					loop35:
					while (true) {
						int alt35=2;
						try { dbg.enterDecision(35, decisionCanBacktrack[35]);

						int LA35_0 = input.LA(1);
						if ( (LA35_0==62) ) {
							alt35=1;
						}

						} finally {dbg.exitDecision(35);}

						switch (alt35) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:274:13: goalDesc
							{
							dbg.location(274,13);
							pushFollow(FOLLOW_goalDesc_in_goalDesc1535);
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
					} finally {dbg.exitSubRule(35);}
					dbg.location(274,23);
					char_literal141=(Token)match(input,63,FOLLOW_63_in_goalDesc1538); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal141);

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
					// 275:12: -> ^( OR_GD ( goalDesc )* )
					{
						dbg.location(275,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:275:15: ^( OR_GD ( goalDesc )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(275,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR_GD, "OR_GD"), root_1);
						dbg.location(275,23);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:275:23: ( goalDesc )*
						while ( stream_goalDesc.hasNext() ) {
							dbg.location(275,23);
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
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:276:4: '(' 'not' goalDesc ')'
					{
					dbg.location(276,4);
					char_literal142=(Token)match(input,62,FOLLOW_62_in_goalDesc1563); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal142);
					dbg.location(276,8);
					string_literal143=(Token)match(input,119,FOLLOW_119_in_goalDesc1565); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_119.add(string_literal143);
					dbg.location(276,14);
					pushFollow(FOLLOW_goalDesc_in_goalDesc1567);
					goalDesc144=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc144.getTree());dbg.location(276,23);
					char_literal145=(Token)match(input,63,FOLLOW_63_in_goalDesc1569); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal145);

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
					// 277:12: -> ^( NOT_GD goalDesc )
					{
						dbg.location(277,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:277:15: ^( NOT_GD goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(277,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_GD, "NOT_GD"), root_1);
						dbg.location(277,24);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:278:4: '(' 'imply' goalDesc goalDesc ')'
					{
					dbg.location(278,4);
					char_literal146=(Token)match(input,62,FOLLOW_62_in_goalDesc1593); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal146);
					dbg.location(278,8);
					string_literal147=(Token)match(input,114,FOLLOW_114_in_goalDesc1595); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_114.add(string_literal147);
					dbg.location(278,16);
					pushFollow(FOLLOW_goalDesc_in_goalDesc1597);
					goalDesc148=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc148.getTree());dbg.location(278,25);
					pushFollow(FOLLOW_goalDesc_in_goalDesc1599);
					goalDesc149=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc149.getTree());dbg.location(278,34);
					char_literal150=(Token)match(input,63,FOLLOW_63_in_goalDesc1601); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal150);

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
					// 279:12: -> ^( IMPLY_GD goalDesc goalDesc )
					{
						dbg.location(279,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:279:15: ^( IMPLY_GD goalDesc goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(279,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IMPLY_GD, "IMPLY_GD"), root_1);
						dbg.location(279,26);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());dbg.location(279,35);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:280:4: '(' 'exists' '(' typedVariableList ')' goalDesc ')'
					{
					dbg.location(280,4);
					char_literal151=(Token)match(input,62,FOLLOW_62_in_goalDesc1627); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal151);
					dbg.location(280,8);
					string_literal152=(Token)match(input,110,FOLLOW_110_in_goalDesc1629); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_110.add(string_literal152);
					dbg.location(280,17);
					char_literal153=(Token)match(input,62,FOLLOW_62_in_goalDesc1631); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal153);
					dbg.location(280,21);
					pushFollow(FOLLOW_typedVariableList_in_goalDesc1633);
					typedVariableList154=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList154.getTree());dbg.location(280,39);
					char_literal155=(Token)match(input,63,FOLLOW_63_in_goalDesc1635); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal155);
					dbg.location(280,43);
					pushFollow(FOLLOW_goalDesc_in_goalDesc1637);
					goalDesc156=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc156.getTree());dbg.location(280,52);
					char_literal157=(Token)match(input,63,FOLLOW_63_in_goalDesc1639); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal157);

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
					// 281:12: -> ^( EXISTS_GD typedVariableList goalDesc )
					{
						dbg.location(281,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:281:15: ^( EXISTS_GD typedVariableList goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(281,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXISTS_GD, "EXISTS_GD"), root_1);
						dbg.location(281,27);
						adaptor.addChild(root_1, stream_typedVariableList.nextTree());dbg.location(281,45);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:282:4: '(' 'forall' '(' typedVariableList ')' goalDesc ')'
					{
					dbg.location(282,4);
					char_literal158=(Token)match(input,62,FOLLOW_62_in_goalDesc1665); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal158);
					dbg.location(282,8);
					string_literal159=(Token)match(input,111,FOLLOW_111_in_goalDesc1667); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_111.add(string_literal159);
					dbg.location(282,17);
					char_literal160=(Token)match(input,62,FOLLOW_62_in_goalDesc1669); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal160);
					dbg.location(282,21);
					pushFollow(FOLLOW_typedVariableList_in_goalDesc1671);
					typedVariableList161=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList161.getTree());dbg.location(282,39);
					char_literal162=(Token)match(input,63,FOLLOW_63_in_goalDesc1673); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal162);
					dbg.location(282,43);
					pushFollow(FOLLOW_goalDesc_in_goalDesc1675);
					goalDesc163=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc163.getTree());dbg.location(282,52);
					char_literal164=(Token)match(input,63,FOLLOW_63_in_goalDesc1677); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal164);

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
					// 283:12: -> ^( FORALL_GD typedVariableList goalDesc )
					{
						dbg.location(283,15);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:283:15: ^( FORALL_GD typedVariableList goalDesc )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(283,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORALL_GD, "FORALL_GD"), root_1);
						dbg.location(283,27);
						adaptor.addChild(root_1, stream_typedVariableList.nextTree());dbg.location(283,45);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:284:7: fComp
					{
					dbg.location(284,7);
					pushFollow(FOLLOW_fComp_in_goalDesc1706);
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
					// 285:15: -> ^( COMPARISON_GD fComp )
					{
						dbg.location(285,18);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:285:18: ^( COMPARISON_GD fComp )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(285,20);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPARISON_GD, "COMPARISON_GD"), root_1);
						dbg.location(285,34);
						adaptor.addChild(root_1, stream_fComp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 9 :
					dbg.enterAlt(9);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:286:4: equality
					{
					dbg.location(286,4);
					pushFollow(FOLLOW_equality_in_goalDesc1733);
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
					// 287:6: -> ^( EQUALITY_CON equality )
					{
						dbg.location(287,9);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:287:9: ^( EQUALITY_CON equality )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(287,11);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EQUALITY_CON, "EQUALITY_CON"), root_1);
						dbg.location(287,24);
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
		dbg.location(288, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "goalDesc");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:290:1: equality : '(' ! '=' term term ')' !;
	public final PddlParser.equality_return equality() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "equality");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(290, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:291:2: ( '(' ! '=' term term ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:291:4: '(' ! '=' term term ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(291,7);
			char_literal167=(Token)match(input,62,FOLLOW_62_in_equality1761); if (state.failed) return retval;dbg.location(291,9);
			char_literal168=(Token)match(input,93,FOLLOW_93_in_equality1764); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal168_tree = (Object)adaptor.create(char_literal168);
			adaptor.addChild(root_0, char_literal168_tree);
			}
			dbg.location(291,13);
			pushFollow(FOLLOW_term_in_equality1766);
			term169=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term169.getTree());
			dbg.location(291,18);
			pushFollow(FOLLOW_term_in_equality1768);
			term170=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term170.getTree());
			dbg.location(291,26);
			char_literal171=(Token)match(input,63,FOLLOW_63_in_equality1770); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(292, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "equality");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:293:1: fComp : '(' ! binaryComp fExp fExp ')' !;
	public final PddlParser.fComp_return fComp() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "fComp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(293, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:294:2: ( '(' ! binaryComp fExp fExp ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:294:4: '(' ! binaryComp fExp fExp ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(294,7);
			char_literal172=(Token)match(input,62,FOLLOW_62_in_fComp1781); if (state.failed) return retval;dbg.location(294,9);
			pushFollow(FOLLOW_binaryComp_in_fComp1784);
			binaryComp173=binaryComp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryComp173.getTree());
			dbg.location(294,20);
			pushFollow(FOLLOW_fExp_in_fComp1786);
			fExp174=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp174.getTree());
			dbg.location(294,25);
			pushFollow(FOLLOW_fExp_in_fComp1788);
			fExp175=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp175.getTree());
			dbg.location(294,33);
			char_literal176=(Token)match(input,63,FOLLOW_63_in_fComp1790); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(295, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fComp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:297:1: atomicTermFormula : '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) ;
	public final PddlParser.atomicTermFormula_return atomicTermFormula() throws  {
		PddlParser.atomicTermFormula_return retval = new PddlParser.atomicTermFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal177=null;
		Token char_literal180=null;
		ParserRuleReturnScope predicate178 =null;
		ParserRuleReturnScope term179 =null;

		Object char_literal177_tree=null;
		Object char_literal180_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try { dbg.enterRule(getGrammarFileName(), "atomicTermFormula");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(297, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:2: ( '(' predicate ( term )* ')' -> ^( PRED_HEAD predicate ( term )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:4: '(' predicate ( term )* ')'
			{
			dbg.location(298,4);
			char_literal177=(Token)match(input,62,FOLLOW_62_in_atomicTermFormula1802); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal177);
			dbg.location(298,8);
			pushFollow(FOLLOW_predicate_in_atomicTermFormula1804);
			predicate178=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate178.getTree());dbg.location(298,18);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:18: ( term )*
			try { dbg.enterSubRule(37);

			loop37:
			while (true) {
				int alt37=2;
				try { dbg.enterDecision(37, decisionCanBacktrack[37]);

				int LA37_0 = input.LA(1);
				if ( (LA37_0==NAME||LA37_0==VARIABLE) ) {
					alt37=1;
				}

				} finally {dbg.exitDecision(37);}

				switch (alt37) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:18: term
					{
					dbg.location(298,18);
					pushFollow(FOLLOW_term_in_atomicTermFormula1806);
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
			} finally {dbg.exitSubRule(37);}
			dbg.location(298,24);
			char_literal180=(Token)match(input,63,FOLLOW_63_in_atomicTermFormula1809); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal180);

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
			// 298:28: -> ^( PRED_HEAD predicate ( term )* )
			{
				dbg.location(298,31);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:31: ^( PRED_HEAD predicate ( term )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(298,33);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_HEAD, "PRED_HEAD"), root_1);
				dbg.location(298,43);
				adaptor.addChild(root_1, stream_predicate.nextTree());dbg.location(298,53);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:298:53: ( term )*
				while ( stream_term.hasNext() ) {
					dbg.location(298,53);
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
		dbg.location(299, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atomicTermFormula");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:301:1: term : ( NAME | VARIABLE );
	public final PddlParser.term_return term() throws  {
		PddlParser.term_return retval = new PddlParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set181=null;

		Object set181_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(301, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:301:6: ( NAME | VARIABLE )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(301,6);
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
				dbg.recognitionException(mse);
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
		dbg.location(301, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:305:1: durativeActionDef : '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) ;
	public final PddlParser.durativeActionDef_return durativeActionDef() throws  {
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
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_daDefBody=new RewriteRuleSubtreeStream(adaptor,"rule daDefBody");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_actionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule actionSymbol");

		try { dbg.enterRule(getGrammarFileName(), "durativeActionDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(305, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:306:2: ( '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')' -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:306:4: '(' ':durative-action' actionSymbol ':parameters' '(' ( typedVariableList )? ')' daDefBody ')'
			{
			dbg.location(306,4);
			char_literal182=(Token)match(input,62,FOLLOW_62_in_durativeActionDef1846); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal182);
			dbg.location(306,8);
			string_literal183=(Token)match(input,76,FOLLOW_76_in_durativeActionDef1848); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_76.add(string_literal183);
			dbg.location(306,27);
			pushFollow(FOLLOW_actionSymbol_in_durativeActionDef1850);
			actionSymbol184=actionSymbol();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_actionSymbol.add(actionSymbol184.getTree());dbg.location(307,8);
			string_literal185=(Token)match(input,85,FOLLOW_85_in_durativeActionDef1859); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_85.add(string_literal185);
			dbg.location(307,23);
			char_literal186=(Token)match(input,62,FOLLOW_62_in_durativeActionDef1862); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal186);
			dbg.location(307,27);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:307:27: ( typedVariableList )?
			int alt38=2;
			try { dbg.enterSubRule(38);
			try { dbg.enterDecision(38, decisionCanBacktrack[38]);

			int LA38_0 = input.LA(1);
			if ( (LA38_0==VARIABLE) ) {
				alt38=1;
			}
			else if ( (LA38_0==63) ) {
				int LA38_2 = input.LA(2);
				if ( (synpred51_Pddl()) ) {
					alt38=1;
				}
			}
			} finally {dbg.exitDecision(38);}

			switch (alt38) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:307:28: typedVariableList
					{
					dbg.location(307,28);
					pushFollow(FOLLOW_typedVariableList_in_durativeActionDef1865);
					typedVariableList187=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList187.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(38);}
			dbg.location(307,48);
			char_literal188=(Token)match(input,63,FOLLOW_63_in_durativeActionDef1869); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal188);
			dbg.location(308,12);
			pushFollow(FOLLOW_daDefBody_in_durativeActionDef1882);
			daDefBody189=daDefBody();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_daDefBody.add(daDefBody189.getTree());dbg.location(308,22);
			char_literal190=(Token)match(input,63,FOLLOW_63_in_durativeActionDef1884); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal190);

			// AST REWRITE
			// elements: typedVariableList, daDefBody, actionSymbol
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 309:8: -> ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
			{
				dbg.location(309,11);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:309:11: ^( DURATIVE_ACTION actionSymbol typedVariableList daDefBody )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(309,13);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DURATIVE_ACTION, "DURATIVE_ACTION"), root_1);
				dbg.location(309,29);
				adaptor.addChild(root_1, stream_actionSymbol.nextTree());dbg.location(309,42);
				adaptor.addChild(root_1, stream_typedVariableList.nextTree());dbg.location(309,60);
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
		dbg.location(310, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "durativeActionDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:312:1: daDefBody : ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) );
	public final PddlParser.daDefBody_return daDefBody() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "daDefBody");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(312, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:313:2: ( ':duration' durationConstraint | ':condition' ( ( '(' ')' ) | daGD ) | ':effect' ( ( '(' ')' ) | daEffect ) )
			int alt41=3;
			try { dbg.enterDecision(41, decisionCanBacktrack[41]);

			switch ( input.LA(1) ) {
			case 75:
				{
				alt41=1;
				}
				break;
			case 69:
				{
				alt41=2;
				}
				break;
			case 77:
				{
				alt41=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(41);}

			switch (alt41) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:313:4: ':duration' durationConstraint
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(313,4);
					string_literal191=(Token)match(input,75,FOLLOW_75_in_daDefBody1917); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal191_tree = (Object)adaptor.create(string_literal191);
					adaptor.addChild(root_0, string_literal191_tree);
					}
					dbg.location(313,16);
					pushFollow(FOLLOW_durationConstraint_in_daDefBody1919);
					durationConstraint192=durationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durationConstraint192.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:4: ':condition' ( ( '(' ')' ) | daGD )
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(314,4);
					string_literal193=(Token)match(input,69,FOLLOW_69_in_daDefBody1924); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal193_tree = (Object)adaptor.create(string_literal193);
					adaptor.addChild(root_0, string_literal193_tree);
					}
					dbg.location(314,17);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:17: ( ( '(' ')' ) | daGD )
					int alt39=2;
					try { dbg.enterSubRule(39);
					try { dbg.enterDecision(39, decisionCanBacktrack[39]);

					int LA39_0 = input.LA(1);
					if ( (LA39_0==62) ) {
						int LA39_1 = input.LA(2);
						if ( (LA39_1==63) ) {
							alt39=1;
						}
						else if ( (LA39_1==101||LA39_1==103||LA39_1==111||(LA39_1 >= 122 && LA39_1 <= 123)) ) {
							alt39=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 39, 1, input);
								dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(39);}

					switch (alt39) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:18: ( '(' ')' )
							{
							dbg.location(314,18);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:18: ( '(' ')' )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:19: '(' ')'
							{
							dbg.location(314,19);
							char_literal194=(Token)match(input,62,FOLLOW_62_in_daDefBody1928); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal194_tree = (Object)adaptor.create(char_literal194);
							adaptor.addChild(root_0, char_literal194_tree);
							}
							dbg.location(314,23);
							char_literal195=(Token)match(input,63,FOLLOW_63_in_daDefBody1930); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal195_tree = (Object)adaptor.create(char_literal195);
							adaptor.addChild(root_0, char_literal195_tree);
							}

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:314:30: daGD
							{
							dbg.location(314,30);
							pushFollow(FOLLOW_daGD_in_daDefBody1935);
							daGD196=daGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD196.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(39);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:7: ':effect' ( ( '(' ')' ) | daEffect )
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(315,7);
					string_literal197=(Token)match(input,77,FOLLOW_77_in_daDefBody1944); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal197_tree = (Object)adaptor.create(string_literal197);
					adaptor.addChild(root_0, string_literal197_tree);
					}
					dbg.location(315,17);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:17: ( ( '(' ')' ) | daEffect )
					int alt40=2;
					try { dbg.enterSubRule(40);
					try { dbg.enterDecision(40, decisionCanBacktrack[40]);

					int LA40_0 = input.LA(1);
					if ( (LA40_0==62) ) {
						int LA40_1 = input.LA(2);
						if ( (LA40_1==63) ) {
							alt40=1;
						}
						else if ( ((LA40_1 >= 101 && LA40_1 <= 103)||LA40_1==105||LA40_1==111||LA40_1==115||(LA40_1 >= 125 && LA40_1 <= 126)||LA40_1==131) ) {
							alt40=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 40, 1, input);
								dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(40);}

					switch (alt40) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:18: ( '(' ')' )
							{
							dbg.location(315,18);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:18: ( '(' ')' )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:19: '(' ')'
							{
							dbg.location(315,19);
							char_literal198=(Token)match(input,62,FOLLOW_62_in_daDefBody1948); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal198_tree = (Object)adaptor.create(char_literal198);
							adaptor.addChild(root_0, char_literal198_tree);
							}
							dbg.location(315,23);
							char_literal199=(Token)match(input,63,FOLLOW_63_in_daDefBody1950); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal199_tree = (Object)adaptor.create(char_literal199);
							adaptor.addChild(root_0, char_literal199_tree);
							}

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:315:30: daEffect
							{
							dbg.location(315,30);
							pushFollow(FOLLOW_daEffect_in_daDefBody1955);
							daEffect200=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect200.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(40);}

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
		dbg.location(316, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "daDefBody");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:318:1: daGD : ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' );
	public final PddlParser.daGD_return daGD() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "daGD");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(318, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:319:2: ( prefTimedGD | '(' 'and' ( daGD )* ')' | '(' 'forall' '(' typedVariableList ')' daGD ')' )
			int alt43=3;
			try { dbg.enterDecision(43, decisionCanBacktrack[43]);

			int LA43_0 = input.LA(1);
			if ( (LA43_0==62) ) {
				switch ( input.LA(2) ) {
				case 103:
				case 122:
				case 123:
					{
					alt43=1;
					}
					break;
				case 101:
					{
					alt43=2;
					}
					break;
				case 111:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(43);}

			switch (alt43) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:319:4: prefTimedGD
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(319,4);
					pushFollow(FOLLOW_prefTimedGD_in_daGD1970);
					prefTimedGD201=prefTimedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefTimedGD201.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:320:4: '(' 'and' ( daGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(320,4);
					char_literal202=(Token)match(input,62,FOLLOW_62_in_daGD1975); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal202_tree = (Object)adaptor.create(char_literal202);
					adaptor.addChild(root_0, char_literal202_tree);
					}
					dbg.location(320,8);
					string_literal203=(Token)match(input,101,FOLLOW_101_in_daGD1977); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal203_tree = (Object)adaptor.create(string_literal203);
					adaptor.addChild(root_0, string_literal203_tree);
					}
					dbg.location(320,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:320:14: ( daGD )*
					try { dbg.enterSubRule(42);

					loop42:
					while (true) {
						int alt42=2;
						try { dbg.enterDecision(42, decisionCanBacktrack[42]);

						int LA42_0 = input.LA(1);
						if ( (LA42_0==62) ) {
							alt42=1;
						}

						} finally {dbg.exitDecision(42);}

						switch (alt42) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:320:14: daGD
							{
							dbg.location(320,14);
							pushFollow(FOLLOW_daGD_in_daGD1979);
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
					} finally {dbg.exitSubRule(42);}
					dbg.location(320,20);
					char_literal205=(Token)match(input,63,FOLLOW_63_in_daGD1982); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal205_tree = (Object)adaptor.create(char_literal205);
					adaptor.addChild(root_0, char_literal205_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:321:4: '(' 'forall' '(' typedVariableList ')' daGD ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(321,4);
					char_literal206=(Token)match(input,62,FOLLOW_62_in_daGD1987); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal206_tree = (Object)adaptor.create(char_literal206);
					adaptor.addChild(root_0, char_literal206_tree);
					}
					dbg.location(321,8);
					string_literal207=(Token)match(input,111,FOLLOW_111_in_daGD1989); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal207_tree = (Object)adaptor.create(string_literal207);
					adaptor.addChild(root_0, string_literal207_tree);
					}
					dbg.location(321,17);
					char_literal208=(Token)match(input,62,FOLLOW_62_in_daGD1991); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal208_tree = (Object)adaptor.create(char_literal208);
					adaptor.addChild(root_0, char_literal208_tree);
					}
					dbg.location(321,21);
					pushFollow(FOLLOW_typedVariableList_in_daGD1993);
					typedVariableList209=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList209.getTree());
					dbg.location(321,39);
					char_literal210=(Token)match(input,63,FOLLOW_63_in_daGD1995); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal210_tree = (Object)adaptor.create(char_literal210);
					adaptor.addChild(root_0, char_literal210_tree);
					}
					dbg.location(321,43);
					pushFollow(FOLLOW_daGD_in_daGD1997);
					daGD211=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD211.getTree());
					dbg.location(321,48);
					char_literal212=(Token)match(input,63,FOLLOW_63_in_daGD1999); if (state.failed) return retval;
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
		dbg.location(322, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "daGD");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:324:1: prefTimedGD : ( timedGD | '(' 'preference' ( NAME )? timedGD ')' );
	public final PddlParser.prefTimedGD_return prefTimedGD() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "prefTimedGD");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(324, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:325:2: ( timedGD | '(' 'preference' ( NAME )? timedGD ')' )
			int alt45=2;
			try { dbg.enterDecision(45, decisionCanBacktrack[45]);

			int LA45_0 = input.LA(1);
			if ( (LA45_0==62) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==103||LA45_1==122) ) {
					alt45=1;
				}
				else if ( (LA45_1==123) ) {
					alt45=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(45);}

			switch (alt45) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:325:4: timedGD
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(325,4);
					pushFollow(FOLLOW_timedGD_in_prefTimedGD2010);
					timedGD213=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD213.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:326:4: '(' 'preference' ( NAME )? timedGD ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(326,4);
					char_literal214=(Token)match(input,62,FOLLOW_62_in_prefTimedGD2015); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (Object)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}
					dbg.location(326,8);
					string_literal215=(Token)match(input,123,FOLLOW_123_in_prefTimedGD2017); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal215_tree = (Object)adaptor.create(string_literal215);
					adaptor.addChild(root_0, string_literal215_tree);
					}
					dbg.location(326,21);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:326:21: ( NAME )?
					int alt44=2;
					try { dbg.enterSubRule(44);
					try { dbg.enterDecision(44, decisionCanBacktrack[44]);

					int LA44_0 = input.LA(1);
					if ( (LA44_0==NAME) ) {
						alt44=1;
					}
					} finally {dbg.exitDecision(44);}

					switch (alt44) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:326:21: NAME
							{
							dbg.location(326,21);
							NAME216=(Token)match(input,NAME,FOLLOW_NAME_in_prefTimedGD2019); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME216_tree = (Object)adaptor.create(NAME216);
							adaptor.addChild(root_0, NAME216_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(44);}
					dbg.location(326,27);
					pushFollow(FOLLOW_timedGD_in_prefTimedGD2022);
					timedGD217=timedGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedGD217.getTree());
					dbg.location(326,35);
					char_literal218=(Token)match(input,63,FOLLOW_63_in_prefTimedGD2024); if (state.failed) return retval;
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
		dbg.location(327, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prefTimedGD");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:329:1: timedGD : ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' );
	public final PddlParser.timedGD_return timedGD() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "timedGD");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(329, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:330:2: ( '(' 'at' timeSpecifier goalDesc ')' | '(' 'over' interval goalDesc ')' )
			int alt46=2;
			try { dbg.enterDecision(46, decisionCanBacktrack[46]);

			int LA46_0 = input.LA(1);
			if ( (LA46_0==62) ) {
				int LA46_1 = input.LA(2);
				if ( (LA46_1==103) ) {
					alt46=1;
				}
				else if ( (LA46_1==122) ) {
					alt46=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(46);}

			switch (alt46) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:330:4: '(' 'at' timeSpecifier goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(330,4);
					char_literal219=(Token)match(input,62,FOLLOW_62_in_timedGD2035); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal219_tree = (Object)adaptor.create(char_literal219);
					adaptor.addChild(root_0, char_literal219_tree);
					}
					dbg.location(330,8);
					string_literal220=(Token)match(input,103,FOLLOW_103_in_timedGD2037); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal220_tree = (Object)adaptor.create(string_literal220);
					adaptor.addChild(root_0, string_literal220_tree);
					}
					dbg.location(330,13);
					pushFollow(FOLLOW_timeSpecifier_in_timedGD2039);
					timeSpecifier221=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier221.getTree());
					dbg.location(330,27);
					pushFollow(FOLLOW_goalDesc_in_timedGD2041);
					goalDesc222=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc222.getTree());
					dbg.location(330,36);
					char_literal223=(Token)match(input,63,FOLLOW_63_in_timedGD2043); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal223_tree = (Object)adaptor.create(char_literal223);
					adaptor.addChild(root_0, char_literal223_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:331:4: '(' 'over' interval goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(331,4);
					char_literal224=(Token)match(input,62,FOLLOW_62_in_timedGD2048); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal224_tree = (Object)adaptor.create(char_literal224);
					adaptor.addChild(root_0, char_literal224_tree);
					}
					dbg.location(331,8);
					string_literal225=(Token)match(input,122,FOLLOW_122_in_timedGD2050); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal225_tree = (Object)adaptor.create(string_literal225);
					adaptor.addChild(root_0, string_literal225_tree);
					}
					dbg.location(331,15);
					pushFollow(FOLLOW_interval_in_timedGD2052);
					interval226=interval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, interval226.getTree());
					dbg.location(331,24);
					pushFollow(FOLLOW_goalDesc_in_timedGD2054);
					goalDesc227=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc227.getTree());
					dbg.location(331,33);
					char_literal228=(Token)match(input,63,FOLLOW_63_in_timedGD2056); if (state.failed) return retval;
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
		dbg.location(332, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "timedGD");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:334:1: timeSpecifier : ( 'start' | 'end' );
	public final PddlParser.timeSpecifier_return timeSpecifier() throws  {
		PddlParser.timeSpecifier_return retval = new PddlParser.timeSpecifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set229=null;

		Object set229_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "timeSpecifier");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(334, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:334:15: ( 'start' | 'end' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(334,15);
			set229=input.LT(1);
			if ( input.LA(1)==109||input.LA(1)==130 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set229));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(334, 32);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "timeSpecifier");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:335:1: interval : 'all' ;
	public final PddlParser.interval_return interval() throws  {
		PddlParser.interval_return retval = new PddlParser.interval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal230=null;

		Object string_literal230_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "interval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(335, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:335:10: ( 'all' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:335:12: 'all'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(335,12);
			string_literal230=(Token)match(input,98,FOLLOW_98_in_interval2078); if (state.failed) return retval;
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
		dbg.location(335, 17);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "interval");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:339:1: derivedDef : '(' ! ':derived' ^ typedVariableList goalDesc ')' !;
	public final PddlParser.derivedDef_return derivedDef() throws  {
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

		try { dbg.enterRule(getGrammarFileName(), "derivedDef");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(339, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:340:2: ( '(' ! ':derived' ^ typedVariableList goalDesc ')' !)
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:340:4: '(' ! ':derived' ^ typedVariableList goalDesc ')' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(340,7);
			char_literal231=(Token)match(input,62,FOLLOW_62_in_derivedDef2091); if (state.failed) return retval;dbg.location(340,19);
			string_literal232=(Token)match(input,73,FOLLOW_73_in_derivedDef2094); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal232_tree = (Object)adaptor.create(string_literal232);
			root_0 = (Object)adaptor.becomeRoot(string_literal232_tree, root_0);
			}
			dbg.location(340,21);
			pushFollow(FOLLOW_typedVariableList_in_derivedDef2097);
			typedVariableList233=typedVariableList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList233.getTree());
			dbg.location(340,39);
			pushFollow(FOLLOW_goalDesc_in_derivedDef2099);
			goalDesc234=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc234.getTree());
			dbg.location(340,51);
			char_literal235=(Token)match(input,63,FOLLOW_63_in_derivedDef2101); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(341, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "derivedDef");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:345:1: fExp : ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead );
	public final PddlParser.fExp_return fExp() throws  {
		PddlParser.fExp_return retval = new PddlParser.fExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER236=null;
		Token char_literal237=null;
		Token char_literal241=null;
		Token char_literal242=null;
		Token char_literal243=null;
		Token char_literal245=null;
		ParserRuleReturnScope binaryOp238 =null;
		ParserRuleReturnScope fExp239 =null;
		ParserRuleReturnScope fExp2240 =null;
		ParserRuleReturnScope fExp244 =null;
		ParserRuleReturnScope fHead246 =null;

		Object NUMBER236_tree=null;
		Object char_literal237_tree=null;
		Object char_literal241_tree=null;
		Object char_literal242_tree=null;
		Object char_literal243_tree=null;
		Object char_literal245_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_fExp2=new RewriteRuleSubtreeStream(adaptor,"rule fExp2");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");

		try { dbg.enterRule(getGrammarFileName(), "fExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(345, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:346:2: ( NUMBER | '(' binaryOp fExp fExp2 ')' -> ^( BINARY_OP binaryOp fExp fExp2 ) | '(' '-' fExp ')' -> ^( UNARY_MINUS fExp ) | fHead )
			int alt47=4;
			try { dbg.enterDecision(47, decisionCanBacktrack[47]);

			switch ( input.LA(1) ) {
			case NUMBER:
				{
				alt47=1;
				}
				break;
			case 62:
				{
				int LA47_2 = input.LA(2);
				if ( (synpred64_Pddl()) ) {
					alt47=2;
				}
				else if ( (synpred65_Pddl()) ) {
					alt47=3;
				}
				else if ( (true) ) {
					alt47=4;
				}

				}
				break;
			case NAME:
			case 61:
				{
				alt47=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(47);}

			switch (alt47) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:346:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(346,4);
					NUMBER236=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_fExp2116); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER236_tree = (Object)adaptor.create(NUMBER236);
					adaptor.addChild(root_0, NUMBER236_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:347:4: '(' binaryOp fExp fExp2 ')'
					{
					dbg.location(347,4);
					char_literal237=(Token)match(input,62,FOLLOW_62_in_fExp2121); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal237);
					dbg.location(347,8);
					pushFollow(FOLLOW_binaryOp_in_fExp2123);
					binaryOp238=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp238.getTree());dbg.location(347,17);
					pushFollow(FOLLOW_fExp_in_fExp2125);
					fExp239=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp239.getTree());dbg.location(347,22);
					pushFollow(FOLLOW_fExp2_in_fExp2127);
					fExp2240=fExp2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp2.add(fExp2240.getTree());dbg.location(347,28);
					char_literal241=(Token)match(input,63,FOLLOW_63_in_fExp2129); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal241);

					// AST REWRITE
					// elements: binaryOp, fExp2, fExp
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 347:32: -> ^( BINARY_OP binaryOp fExp fExp2 )
					{
						dbg.location(347,35);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:347:35: ^( BINARY_OP binaryOp fExp fExp2 )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(347,37);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BINARY_OP, "BINARY_OP"), root_1);
						dbg.location(347,47);
						adaptor.addChild(root_1, stream_binaryOp.nextTree());dbg.location(347,56);
						adaptor.addChild(root_1, stream_fExp.nextTree());dbg.location(347,61);
						adaptor.addChild(root_1, stream_fExp2.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:348:4: '(' '-' fExp ')'
					{
					dbg.location(348,4);
					char_literal242=(Token)match(input,62,FOLLOW_62_in_fExp2146); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal242);
					dbg.location(348,8);
					char_literal243=(Token)match(input,66,FOLLOW_66_in_fExp2148); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_66.add(char_literal243);
					dbg.location(348,12);
					pushFollow(FOLLOW_fExp_in_fExp2150);
					fExp244=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp244.getTree());dbg.location(348,17);
					char_literal245=(Token)match(input,63,FOLLOW_63_in_fExp2152); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal245);

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
					// 348:21: -> ^( UNARY_MINUS fExp )
					{
						dbg.location(348,24);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:348:24: ^( UNARY_MINUS fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(348,26);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						dbg.location(348,38);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:349:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(349,4);
					pushFollow(FOLLOW_fHead_in_fExp2165);
					fHead246=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead246.getTree());

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
		dbg.location(350, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:354:1: fExp2 : fExp ;
	public final PddlParser.fExp2_return fExp2() throws  {
		PddlParser.fExp2_return retval = new PddlParser.fExp2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope fExp247 =null;


		try { dbg.enterRule(getGrammarFileName(), "fExp2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(354, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:354:7: ( fExp )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:354:9: fExp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(354,9);
			pushFollow(FOLLOW_fExp_in_fExp22177);
			fExp247=fExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp247.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(354, 13);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fExp2");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:356:1: fHead : ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) );
	public final PddlParser.fHead_return fHead() throws  {
		PddlParser.fHead_return retval = new PddlParser.fHead_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal248=null;
		Token char_literal251=null;
		ParserRuleReturnScope functionSymbol249 =null;
		ParserRuleReturnScope term250 =null;
		ParserRuleReturnScope functionSymbol252 =null;

		Object char_literal248_tree=null;
		Object char_literal251_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
		RewriteRuleSubtreeStream stream_functionSymbol=new RewriteRuleSubtreeStream(adaptor,"rule functionSymbol");

		try { dbg.enterRule(getGrammarFileName(), "fHead");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(356, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:2: ( '(' functionSymbol ( term )* ')' -> ^( FUNC_HEAD functionSymbol ( term )* ) | functionSymbol -> ^( FUNC_HEAD functionSymbol ) )
			int alt49=2;
			try { dbg.enterDecision(49, decisionCanBacktrack[49]);

			int LA49_0 = input.LA(1);
			if ( (LA49_0==62) ) {
				alt49=1;
			}
			else if ( (LA49_0==NAME||LA49_0==61) ) {
				alt49=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(49);}

			switch (alt49) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:4: '(' functionSymbol ( term )* ')'
					{
					dbg.location(357,4);
					char_literal248=(Token)match(input,62,FOLLOW_62_in_fHead2187); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal248);
					dbg.location(357,8);
					pushFollow(FOLLOW_functionSymbol_in_fHead2189);
					functionSymbol249=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol249.getTree());dbg.location(357,23);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:23: ( term )*
					try { dbg.enterSubRule(48);

					loop48:
					while (true) {
						int alt48=2;
						try { dbg.enterDecision(48, decisionCanBacktrack[48]);

						int LA48_0 = input.LA(1);
						if ( (LA48_0==NAME||LA48_0==VARIABLE) ) {
							alt48=1;
						}

						} finally {dbg.exitDecision(48);}

						switch (alt48) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:23: term
							{
							dbg.location(357,23);
							pushFollow(FOLLOW_term_in_fHead2191);
							term250=term();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_term.add(term250.getTree());
							}
							break;

						default :
							break loop48;
						}
					}
					} finally {dbg.exitSubRule(48);}
					dbg.location(357,29);
					char_literal251=(Token)match(input,63,FOLLOW_63_in_fHead2194); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal251);

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
					// 357:33: -> ^( FUNC_HEAD functionSymbol ( term )* )
					{
						dbg.location(357,36);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:36: ^( FUNC_HEAD functionSymbol ( term )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(357,38);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						dbg.location(357,48);
						adaptor.addChild(root_1, stream_functionSymbol.nextTree());dbg.location(357,63);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:357:63: ( term )*
						while ( stream_term.hasNext() ) {
							dbg.location(357,63);
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
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:358:4: functionSymbol
					{
					dbg.location(358,4);
					pushFollow(FOLLOW_functionSymbol_in_fHead2210);
					functionSymbol252=functionSymbol();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_functionSymbol.add(functionSymbol252.getTree());
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
					// 358:19: -> ^( FUNC_HEAD functionSymbol )
					{
						dbg.location(358,22);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:358:22: ^( FUNC_HEAD functionSymbol )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(358,24);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_HEAD, "FUNC_HEAD"), root_1);
						dbg.location(358,34);
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
		dbg.location(359, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fHead");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:361:1: effect : ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect );
	public final PddlParser.effect_return effect() throws  {
		PddlParser.effect_return retval = new PddlParser.effect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal253=null;
		Token string_literal254=null;
		Token char_literal256=null;
		ParserRuleReturnScope cEffect255 =null;
		ParserRuleReturnScope cEffect257 =null;

		Object char_literal253_tree=null;
		Object string_literal254_tree=null;
		Object char_literal256_tree=null;
		RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_cEffect=new RewriteRuleSubtreeStream(adaptor,"rule cEffect");

		try { dbg.enterRule(getGrammarFileName(), "effect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(361, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:2: ( '(' 'and' ( cEffect )* ')' -> ^( AND_EFFECT ( cEffect )* ) | cEffect )
			int alt51=2;
			try { dbg.enterDecision(51, decisionCanBacktrack[51]);

			int LA51_0 = input.LA(1);
			if ( (LA51_0==62) ) {
				int LA51_1 = input.LA(2);
				if ( (LA51_1==101) ) {
					alt51=1;
				}
				else if ( (LA51_1==NAME||LA51_1==102||LA51_1==105||LA51_1==111||LA51_1==115||LA51_1==119||(LA51_1 >= 125 && LA51_1 <= 126)||LA51_1==131) ) {
					alt51=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 51, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(51);}

			switch (alt51) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:4: '(' 'and' ( cEffect )* ')'
					{
					dbg.location(362,4);
					char_literal253=(Token)match(input,62,FOLLOW_62_in_effect2229); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal253);
					dbg.location(362,8);
					string_literal254=(Token)match(input,101,FOLLOW_101_in_effect2231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_101.add(string_literal254);
					dbg.location(362,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:14: ( cEffect )*
					try { dbg.enterSubRule(50);

					loop50:
					while (true) {
						int alt50=2;
						try { dbg.enterDecision(50, decisionCanBacktrack[50]);

						int LA50_0 = input.LA(1);
						if ( (LA50_0==62) ) {
							alt50=1;
						}

						} finally {dbg.exitDecision(50);}

						switch (alt50) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:14: cEffect
							{
							dbg.location(362,14);
							pushFollow(FOLLOW_cEffect_in_effect2233);
							cEffect255=cEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cEffect.add(cEffect255.getTree());
							}
							break;

						default :
							break loop50;
						}
					}
					} finally {dbg.exitSubRule(50);}
					dbg.location(362,23);
					char_literal256=(Token)match(input,63,FOLLOW_63_in_effect2236); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal256);

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
					// 362:27: -> ^( AND_EFFECT ( cEffect )* )
					{
						dbg.location(362,30);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:30: ^( AND_EFFECT ( cEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(362,32);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						dbg.location(362,43);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:362:43: ( cEffect )*
						while ( stream_cEffect.hasNext() ) {
							dbg.location(362,43);
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
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:363:4: cEffect
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(363,4);
					pushFollow(FOLLOW_cEffect_in_effect2250);
					cEffect257=cEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cEffect257.getTree());

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
		dbg.location(364, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "effect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:366:1: cEffect : ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect );
	public final PddlParser.cEffect_return cEffect() throws  {
		PddlParser.cEffect_return retval = new PddlParser.cEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal258=null;
		Token string_literal259=null;
		Token char_literal260=null;
		Token char_literal262=null;
		Token char_literal264=null;
		Token char_literal265=null;
		Token string_literal266=null;
		Token char_literal269=null;
		ParserRuleReturnScope typedVariableList261 =null;
		ParserRuleReturnScope effect263 =null;
		ParserRuleReturnScope goalDesc267 =null;
		ParserRuleReturnScope condEffect268 =null;
		ParserRuleReturnScope pEffect270 =null;

		Object char_literal258_tree=null;
		Object string_literal259_tree=null;
		Object char_literal260_tree=null;
		Object char_literal262_tree=null;
		Object char_literal264_tree=null;
		Object char_literal265_tree=null;
		Object string_literal266_tree=null;
		Object char_literal269_tree=null;
		RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");
		RewriteRuleSubtreeStream stream_typedVariableList=new RewriteRuleSubtreeStream(adaptor,"rule typedVariableList");
		RewriteRuleSubtreeStream stream_effect=new RewriteRuleSubtreeStream(adaptor,"rule effect");
		RewriteRuleSubtreeStream stream_condEffect=new RewriteRuleSubtreeStream(adaptor,"rule condEffect");

		try { dbg.enterRule(getGrammarFileName(), "cEffect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(366, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:367:2: ( '(' 'forall' '(' typedVariableList ')' effect ')' -> ^( FORALL_EFFECT typedVariableList effect ) | '(' 'when' goalDesc condEffect ')' -> ^( WHEN_EFFECT goalDesc condEffect ) | pEffect )
			int alt52=3;
			try { dbg.enterDecision(52, decisionCanBacktrack[52]);

			int LA52_0 = input.LA(1);
			if ( (LA52_0==62) ) {
				switch ( input.LA(2) ) {
				case 111:
					{
					alt52=1;
					}
					break;
				case 131:
					{
					alt52=2;
					}
					break;
				case NAME:
				case 102:
				case 105:
				case 115:
				case 119:
				case 125:
				case 126:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(52);}

			switch (alt52) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:367:4: '(' 'forall' '(' typedVariableList ')' effect ')'
					{
					dbg.location(367,4);
					char_literal258=(Token)match(input,62,FOLLOW_62_in_cEffect2261); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal258);
					dbg.location(367,8);
					string_literal259=(Token)match(input,111,FOLLOW_111_in_cEffect2263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_111.add(string_literal259);
					dbg.location(367,17);
					char_literal260=(Token)match(input,62,FOLLOW_62_in_cEffect2265); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal260);
					dbg.location(367,21);
					pushFollow(FOLLOW_typedVariableList_in_cEffect2267);
					typedVariableList261=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedVariableList.add(typedVariableList261.getTree());dbg.location(367,39);
					char_literal262=(Token)match(input,63,FOLLOW_63_in_cEffect2269); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal262);
					dbg.location(367,43);
					pushFollow(FOLLOW_effect_in_cEffect2271);
					effect263=effect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_effect.add(effect263.getTree());dbg.location(367,50);
					char_literal264=(Token)match(input,63,FOLLOW_63_in_cEffect2273); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal264);

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
					// 368:4: -> ^( FORALL_EFFECT typedVariableList effect )
					{
						dbg.location(368,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:368:7: ^( FORALL_EFFECT typedVariableList effect )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(368,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORALL_EFFECT, "FORALL_EFFECT"), root_1);
						dbg.location(368,23);
						adaptor.addChild(root_1, stream_typedVariableList.nextTree());dbg.location(368,41);
						adaptor.addChild(root_1, stream_effect.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:369:4: '(' 'when' goalDesc condEffect ')'
					{
					dbg.location(369,4);
					char_literal265=(Token)match(input,62,FOLLOW_62_in_cEffect2291); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal265);
					dbg.location(369,8);
					string_literal266=(Token)match(input,131,FOLLOW_131_in_cEffect2293); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_131.add(string_literal266);
					dbg.location(369,15);
					pushFollow(FOLLOW_goalDesc_in_cEffect2295);
					goalDesc267=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc267.getTree());dbg.location(369,24);
					pushFollow(FOLLOW_condEffect_in_cEffect2297);
					condEffect268=condEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condEffect.add(condEffect268.getTree());dbg.location(369,35);
					char_literal269=(Token)match(input,63,FOLLOW_63_in_cEffect2299); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal269);

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
					// 370:4: -> ^( WHEN_EFFECT goalDesc condEffect )
					{
						dbg.location(370,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:370:7: ^( WHEN_EFFECT goalDesc condEffect )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(370,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHEN_EFFECT, "WHEN_EFFECT"), root_1);
						dbg.location(370,21);
						adaptor.addChild(root_1, stream_goalDesc.nextTree());dbg.location(370,30);
						adaptor.addChild(root_1, stream_condEffect.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:371:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(371,4);
					pushFollow(FOLLOW_pEffect_in_cEffect2317);
					pEffect270=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect270.getTree());

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
		dbg.location(372, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "cEffect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:374:1: pEffect : ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula );
	public final PddlParser.pEffect_return pEffect() throws  {
		PddlParser.pEffect_return retval = new PddlParser.pEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal271=null;
		Token char_literal275=null;
		Token char_literal276=null;
		Token string_literal277=null;
		Token char_literal279=null;
		ParserRuleReturnScope assignOp272 =null;
		ParserRuleReturnScope fHead273 =null;
		ParserRuleReturnScope fExp274 =null;
		ParserRuleReturnScope atomicTermFormula278 =null;
		ParserRuleReturnScope atomicTermFormula280 =null;

		Object char_literal271_tree=null;
		Object char_literal275_tree=null;
		Object char_literal276_tree=null;
		Object string_literal277_tree=null;
		Object char_literal279_tree=null;
		RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_atomicTermFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicTermFormula");
		RewriteRuleSubtreeStream stream_assignOp=new RewriteRuleSubtreeStream(adaptor,"rule assignOp");
		RewriteRuleSubtreeStream stream_fExp=new RewriteRuleSubtreeStream(adaptor,"rule fExp");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");

		try { dbg.enterRule(getGrammarFileName(), "pEffect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(374, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:375:2: ( '(' assignOp fHead fExp ')' -> ^( ASSIGN_EFFECT assignOp fHead fExp ) | '(' 'not' atomicTermFormula ')' -> ^( NOT_EFFECT atomicTermFormula ) | atomicTermFormula )
			int alt53=3;
			try { dbg.enterDecision(53, decisionCanBacktrack[53]);

			int LA53_0 = input.LA(1);
			if ( (LA53_0==62) ) {
				switch ( input.LA(2) ) {
				case 119:
					{
					alt53=2;
					}
					break;
				case 102:
				case 105:
				case 115:
				case 125:
				case 126:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(53);}

			switch (alt53) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:375:4: '(' assignOp fHead fExp ')'
					{
					dbg.location(375,4);
					char_literal271=(Token)match(input,62,FOLLOW_62_in_pEffect2328); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal271);
					dbg.location(375,8);
					pushFollow(FOLLOW_assignOp_in_pEffect2330);
					assignOp272=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignOp.add(assignOp272.getTree());dbg.location(375,17);
					pushFollow(FOLLOW_fHead_in_pEffect2332);
					fHead273=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead273.getTree());dbg.location(375,23);
					pushFollow(FOLLOW_fExp_in_pEffect2334);
					fExp274=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fExp.add(fExp274.getTree());dbg.location(375,28);
					char_literal275=(Token)match(input,63,FOLLOW_63_in_pEffect2336); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal275);

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
					// 376:4: -> ^( ASSIGN_EFFECT assignOp fHead fExp )
					{
						dbg.location(376,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:376:7: ^( ASSIGN_EFFECT assignOp fHead fExp )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(376,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_EFFECT, "ASSIGN_EFFECT"), root_1);
						dbg.location(376,23);
						adaptor.addChild(root_1, stream_assignOp.nextTree());dbg.location(376,32);
						adaptor.addChild(root_1, stream_fHead.nextTree());dbg.location(376,38);
						adaptor.addChild(root_1, stream_fExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:377:4: '(' 'not' atomicTermFormula ')'
					{
					dbg.location(377,4);
					char_literal276=(Token)match(input,62,FOLLOW_62_in_pEffect2356); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal276);
					dbg.location(377,8);
					string_literal277=(Token)match(input,119,FOLLOW_119_in_pEffect2358); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_119.add(string_literal277);
					dbg.location(377,14);
					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2360);
					atomicTermFormula278=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicTermFormula.add(atomicTermFormula278.getTree());dbg.location(377,32);
					char_literal279=(Token)match(input,63,FOLLOW_63_in_pEffect2362); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal279);

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
					// 378:4: -> ^( NOT_EFFECT atomicTermFormula )
					{
						dbg.location(378,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:378:7: ^( NOT_EFFECT atomicTermFormula )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(378,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_EFFECT, "NOT_EFFECT"), root_1);
						dbg.location(378,20);
						adaptor.addChild(root_1, stream_atomicTermFormula.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:379:4: atomicTermFormula
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(379,4);
					pushFollow(FOLLOW_atomicTermFormula_in_pEffect2378);
					atomicTermFormula280=atomicTermFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicTermFormula280.getTree());

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
		dbg.location(380, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "pEffect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:384:1: condEffect : ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect );
	public final PddlParser.condEffect_return condEffect() throws  {
		PddlParser.condEffect_return retval = new PddlParser.condEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal281=null;
		Token string_literal282=null;
		Token char_literal284=null;
		ParserRuleReturnScope pEffect283 =null;
		ParserRuleReturnScope pEffect285 =null;

		Object char_literal281_tree=null;
		Object string_literal282_tree=null;
		Object char_literal284_tree=null;
		RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_pEffect=new RewriteRuleSubtreeStream(adaptor,"rule pEffect");

		try { dbg.enterRule(getGrammarFileName(), "condEffect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(384, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:2: ( '(' 'and' ( pEffect )* ')' -> ^( AND_EFFECT ( pEffect )* ) | pEffect )
			int alt55=2;
			try { dbg.enterDecision(55, decisionCanBacktrack[55]);

			int LA55_0 = input.LA(1);
			if ( (LA55_0==62) ) {
				int LA55_1 = input.LA(2);
				if ( (LA55_1==101) ) {
					alt55=1;
				}
				else if ( (LA55_1==NAME||LA55_1==102||LA55_1==105||LA55_1==115||LA55_1==119||(LA55_1 >= 125 && LA55_1 <= 126)) ) {
					alt55=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 55, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(55);}

			switch (alt55) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:4: '(' 'and' ( pEffect )* ')'
					{
					dbg.location(385,4);
					char_literal281=(Token)match(input,62,FOLLOW_62_in_condEffect2391); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal281);
					dbg.location(385,8);
					string_literal282=(Token)match(input,101,FOLLOW_101_in_condEffect2393); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_101.add(string_literal282);
					dbg.location(385,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:14: ( pEffect )*
					try { dbg.enterSubRule(54);

					loop54:
					while (true) {
						int alt54=2;
						try { dbg.enterDecision(54, decisionCanBacktrack[54]);

						int LA54_0 = input.LA(1);
						if ( (LA54_0==62) ) {
							alt54=1;
						}

						} finally {dbg.exitDecision(54);}

						switch (alt54) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:14: pEffect
							{
							dbg.location(385,14);
							pushFollow(FOLLOW_pEffect_in_condEffect2395);
							pEffect283=pEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_pEffect.add(pEffect283.getTree());
							}
							break;

						default :
							break loop54;
						}
					}
					} finally {dbg.exitSubRule(54);}
					dbg.location(385,23);
					char_literal284=(Token)match(input,63,FOLLOW_63_in_condEffect2398); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal284);

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
					// 385:27: -> ^( AND_EFFECT ( pEffect )* )
					{
						dbg.location(385,30);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:30: ^( AND_EFFECT ( pEffect )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(385,32);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AND_EFFECT, "AND_EFFECT"), root_1);
						dbg.location(385,43);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:385:43: ( pEffect )*
						while ( stream_pEffect.hasNext() ) {
							dbg.location(385,43);
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
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:386:4: pEffect
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(386,4);
					pushFollow(FOLLOW_pEffect_in_condEffect2412);
					pEffect285=pEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pEffect285.getTree());

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
		dbg.location(387, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "condEffect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:391:1: binaryOp : ( '*' | '+' | '-' | '/' | '^' );
	public final PddlParser.binaryOp_return binaryOp() throws  {
		PddlParser.binaryOp_return retval = new PddlParser.binaryOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set286=null;

		Object set286_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binaryOp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(391, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:391:10: ( '*' | '+' | '-' | '/' | '^' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(391,10);
			set286=input.LT(1);
			if ( (input.LA(1) >= 64 && input.LA(1) <= 67)||input.LA(1)==97 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set286));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(391, 38);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binaryOp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:393:1: multiOp : ( '*' | '+' );
	public final PddlParser.multiOp_return multiOp() throws  {
		PddlParser.multiOp_return retval = new PddlParser.multiOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set287=null;

		Object set287_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "multiOp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(393, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:393:9: ( '*' | '+' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(393,9);
			set287=input.LT(1);
			if ( (input.LA(1) >= 64 && input.LA(1) <= 65) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set287));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(393, 20);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "multiOp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:395:1: binaryComp : ( '>' | '<' | '=' | '>=' | '<=' );
	public final PddlParser.binaryComp_return binaryComp() throws  {
		PddlParser.binaryComp_return retval = new PddlParser.binaryComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set288=null;

		Object set288_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binaryComp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(395, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:395:12: ( '>' | '<' | '=' | '>=' | '<=' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(395,12);
			set288=input.LT(1);
			if ( (input.LA(1) >= 91 && input.LA(1) <= 95) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set288));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(395, 43);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binaryComp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:397:1: assignOp : ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' );
	public final PddlParser.assignOp_return assignOp() throws  {
		PddlParser.assignOp_return retval = new PddlParser.assignOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set289=null;

		Object set289_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "assignOp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(397, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:397:10: ( 'assign' | 'scale-up' | 'scale-down' | 'increase' | 'decrease' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(397,10);
			set289=input.LT(1);
			if ( input.LA(1)==102||input.LA(1)==105||input.LA(1)==115||(input.LA(1) >= 125 && input.LA(1) <= 126) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set289));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(397, 74);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assignOp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:402:1: durationConstraint : ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint );
	public final PddlParser.durationConstraint_return durationConstraint() throws  {
		PddlParser.durationConstraint_return retval = new PddlParser.durationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal290=null;
		Token string_literal291=null;
		Token char_literal293=null;
		Token char_literal294=null;
		Token char_literal295=null;
		ParserRuleReturnScope simpleDurationConstraint292 =null;
		ParserRuleReturnScope simpleDurationConstraint296 =null;

		Object char_literal290_tree=null;
		Object string_literal291_tree=null;
		Object char_literal293_tree=null;
		Object char_literal294_tree=null;
		Object char_literal295_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "durationConstraint");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(402, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:403:2: ( '(' 'and' ( simpleDurationConstraint )+ ')' | '(' ')' | simpleDurationConstraint )
			int alt57=3;
			try { dbg.enterDecision(57, decisionCanBacktrack[57]);

			int LA57_0 = input.LA(1);
			if ( (LA57_0==62) ) {
				switch ( input.LA(2) ) {
				case 101:
					{
					alt57=1;
					}
					break;
				case 63:
					{
					alt57=2;
					}
					break;
				case 92:
				case 93:
				case 95:
				case 103:
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
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(57);}

			switch (alt57) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:403:4: '(' 'and' ( simpleDurationConstraint )+ ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(403,4);
					char_literal290=(Token)match(input,62,FOLLOW_62_in_durationConstraint2517); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal290_tree = (Object)adaptor.create(char_literal290);
					adaptor.addChild(root_0, char_literal290_tree);
					}
					dbg.location(403,8);
					string_literal291=(Token)match(input,101,FOLLOW_101_in_durationConstraint2519); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal291_tree = (Object)adaptor.create(string_literal291);
					adaptor.addChild(root_0, string_literal291_tree);
					}
					dbg.location(403,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:403:14: ( simpleDurationConstraint )+
					int cnt56=0;
					try { dbg.enterSubRule(56);

					loop56:
					while (true) {
						int alt56=2;
						try { dbg.enterDecision(56, decisionCanBacktrack[56]);

						int LA56_0 = input.LA(1);
						if ( (LA56_0==62) ) {
							alt56=1;
						}

						} finally {dbg.exitDecision(56);}

						switch (alt56) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:403:14: simpleDurationConstraint
							{
							dbg.location(403,14);
							pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2521);
							simpleDurationConstraint292=simpleDurationConstraint();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint292.getTree());

							}
							break;

						default :
							if ( cnt56 >= 1 ) break loop56;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(56, input);
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt56++;
					}
					} finally {dbg.exitSubRule(56);}
					dbg.location(403,40);
					char_literal293=(Token)match(input,63,FOLLOW_63_in_durationConstraint2524); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal293_tree = (Object)adaptor.create(char_literal293);
					adaptor.addChild(root_0, char_literal293_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:404:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(404,4);
					char_literal294=(Token)match(input,62,FOLLOW_62_in_durationConstraint2529); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal294_tree = (Object)adaptor.create(char_literal294);
					adaptor.addChild(root_0, char_literal294_tree);
					}
					dbg.location(404,8);
					char_literal295=(Token)match(input,63,FOLLOW_63_in_durationConstraint2531); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal295_tree = (Object)adaptor.create(char_literal295);
					adaptor.addChild(root_0, char_literal295_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:405:4: simpleDurationConstraint
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(405,4);
					pushFollow(FOLLOW_simpleDurationConstraint_in_durationConstraint2536);
					simpleDurationConstraint296=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint296.getTree());

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
		dbg.location(406, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "durationConstraint");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:408:1: simpleDurationConstraint : ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' );
	public final PddlParser.simpleDurationConstraint_return simpleDurationConstraint() throws  {
		PddlParser.simpleDurationConstraint_return retval = new PddlParser.simpleDurationConstraint_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal297=null;
		Token string_literal299=null;
		Token char_literal301=null;
		Token char_literal302=null;
		Token string_literal303=null;
		Token char_literal306=null;
		ParserRuleReturnScope durOp298 =null;
		ParserRuleReturnScope durValue300 =null;
		ParserRuleReturnScope timeSpecifier304 =null;
		ParserRuleReturnScope simpleDurationConstraint305 =null;

		Object char_literal297_tree=null;
		Object string_literal299_tree=null;
		Object char_literal301_tree=null;
		Object char_literal302_tree=null;
		Object string_literal303_tree=null;
		Object char_literal306_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "simpleDurationConstraint");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(408, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:409:2: ( '(' durOp '?duration' durValue ')' | '(' 'at' timeSpecifier simpleDurationConstraint ')' )
			int alt58=2;
			try { dbg.enterDecision(58, decisionCanBacktrack[58]);

			int LA58_0 = input.LA(1);
			if ( (LA58_0==62) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==103) ) {
					alt58=2;
				}
				else if ( ((LA58_1 >= 92 && LA58_1 <= 93)||LA58_1==95) ) {
					alt58=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 58, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(58);}

			switch (alt58) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:409:4: '(' durOp '?duration' durValue ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(409,4);
					char_literal297=(Token)match(input,62,FOLLOW_62_in_simpleDurationConstraint2547); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal297_tree = (Object)adaptor.create(char_literal297);
					adaptor.addChild(root_0, char_literal297_tree);
					}
					dbg.location(409,8);
					pushFollow(FOLLOW_durOp_in_simpleDurationConstraint2549);
					durOp298=durOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durOp298.getTree());
					dbg.location(409,14);
					string_literal299=(Token)match(input,96,FOLLOW_96_in_simpleDurationConstraint2551); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal299_tree = (Object)adaptor.create(string_literal299);
					adaptor.addChild(root_0, string_literal299_tree);
					}
					dbg.location(409,26);
					pushFollow(FOLLOW_durValue_in_simpleDurationConstraint2553);
					durValue300=durValue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, durValue300.getTree());
					dbg.location(409,35);
					char_literal301=(Token)match(input,63,FOLLOW_63_in_simpleDurationConstraint2555); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:410:4: '(' 'at' timeSpecifier simpleDurationConstraint ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(410,4);
					char_literal302=(Token)match(input,62,FOLLOW_62_in_simpleDurationConstraint2560); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal302_tree = (Object)adaptor.create(char_literal302);
					adaptor.addChild(root_0, char_literal302_tree);
					}
					dbg.location(410,8);
					string_literal303=(Token)match(input,103,FOLLOW_103_in_simpleDurationConstraint2562); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal303_tree = (Object)adaptor.create(string_literal303);
					adaptor.addChild(root_0, string_literal303_tree);
					}
					dbg.location(410,13);
					pushFollow(FOLLOW_timeSpecifier_in_simpleDurationConstraint2564);
					timeSpecifier304=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier304.getTree());
					dbg.location(410,27);
					pushFollow(FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2566);
					simpleDurationConstraint305=simpleDurationConstraint();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleDurationConstraint305.getTree());
					dbg.location(410,52);
					char_literal306=(Token)match(input,63,FOLLOW_63_in_simpleDurationConstraint2568); if (state.failed) return retval;
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
		dbg.location(411, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "simpleDurationConstraint");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:413:1: durOp : ( '<=' | '>=' | '=' );
	public final PddlParser.durOp_return durOp() throws  {
		PddlParser.durOp_return retval = new PddlParser.durOp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set307=null;

		Object set307_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "durOp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(413, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:413:7: ( '<=' | '>=' | '=' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(413,7);
			set307=input.LT(1);
			if ( (input.LA(1) >= 92 && input.LA(1) <= 93)||input.LA(1)==95 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set307));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(413, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "durOp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:1: durValue : ( NUMBER | fExp );
	public final PddlParser.durValue_return durValue() throws  {
		PddlParser.durValue_return retval = new PddlParser.durValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER308=null;
		ParserRuleReturnScope fExp309 =null;

		Object NUMBER308_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "durValue");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(415, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:10: ( NUMBER | fExp )
			int alt59=2;
			try { dbg.enterDecision(59, decisionCanBacktrack[59]);

			int LA59_0 = input.LA(1);
			if ( (LA59_0==NUMBER) ) {
				int LA59_1 = input.LA(2);
				if ( (synpred95_Pddl()) ) {
					alt59=1;
				}
				else if ( (true) ) {
					alt59=2;
				}

			}
			else if ( (LA59_0==NAME||(LA59_0 >= 61 && LA59_0 <= 62)) ) {
				alt59=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(59);}

			switch (alt59) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:12: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(415,12);
					NUMBER308=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_durValue2595); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER308_tree = (Object)adaptor.create(NUMBER308);
					adaptor.addChild(root_0, NUMBER308_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:21: fExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(415,21);
					pushFollow(FOLLOW_fExp_in_durValue2599);
					fExp309=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp309.getTree());

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
		dbg.location(415, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "durValue");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:417:1: daEffect : ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' );
	public final PddlParser.daEffect_return daEffect() throws  {
		PddlParser.daEffect_return retval = new PddlParser.daEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal310=null;
		Token string_literal311=null;
		Token char_literal313=null;
		Token char_literal315=null;
		Token string_literal316=null;
		Token char_literal317=null;
		Token char_literal319=null;
		Token char_literal321=null;
		Token char_literal322=null;
		Token string_literal323=null;
		Token char_literal326=null;
		Token char_literal327=null;
		Token char_literal331=null;
		ParserRuleReturnScope daEffect312 =null;
		ParserRuleReturnScope timedEffect314 =null;
		ParserRuleReturnScope typedVariableList318 =null;
		ParserRuleReturnScope daEffect320 =null;
		ParserRuleReturnScope daGD324 =null;
		ParserRuleReturnScope timedEffect325 =null;
		ParserRuleReturnScope assignOp328 =null;
		ParserRuleReturnScope fHead329 =null;
		ParserRuleReturnScope fExpDA330 =null;

		Object char_literal310_tree=null;
		Object string_literal311_tree=null;
		Object char_literal313_tree=null;
		Object char_literal315_tree=null;
		Object string_literal316_tree=null;
		Object char_literal317_tree=null;
		Object char_literal319_tree=null;
		Object char_literal321_tree=null;
		Object char_literal322_tree=null;
		Object string_literal323_tree=null;
		Object char_literal326_tree=null;
		Object char_literal327_tree=null;
		Object char_literal331_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "daEffect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(417, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:2: ( '(' 'and' ( daEffect )* ')' | timedEffect | '(' 'forall' '(' typedVariableList ')' daEffect ')' | '(' 'when' daGD timedEffect ')' | '(' assignOp fHead fExpDA ')' )
			int alt61=5;
			try { dbg.enterDecision(61, decisionCanBacktrack[61]);

			int LA61_0 = input.LA(1);
			if ( (LA61_0==62) ) {
				int LA61_1 = input.LA(2);
				if ( (synpred97_Pddl()) ) {
					alt61=1;
				}
				else if ( (synpred98_Pddl()) ) {
					alt61=2;
				}
				else if ( (synpred99_Pddl()) ) {
					alt61=3;
				}
				else if ( (synpred100_Pddl()) ) {
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(61);}

			switch (alt61) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:4: '(' 'and' ( daEffect )* ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(418,4);
					char_literal310=(Token)match(input,62,FOLLOW_62_in_daEffect2609); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal310_tree = (Object)adaptor.create(char_literal310);
					adaptor.addChild(root_0, char_literal310_tree);
					}
					dbg.location(418,8);
					string_literal311=(Token)match(input,101,FOLLOW_101_in_daEffect2611); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal311_tree = (Object)adaptor.create(string_literal311);
					adaptor.addChild(root_0, string_literal311_tree);
					}
					dbg.location(418,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:14: ( daEffect )*
					try { dbg.enterSubRule(60);

					loop60:
					while (true) {
						int alt60=2;
						try { dbg.enterDecision(60, decisionCanBacktrack[60]);

						int LA60_0 = input.LA(1);
						if ( (LA60_0==62) ) {
							alt60=1;
						}

						} finally {dbg.exitDecision(60);}

						switch (alt60) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:14: daEffect
							{
							dbg.location(418,14);
							pushFollow(FOLLOW_daEffect_in_daEffect2613);
							daEffect312=daEffect();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect312.getTree());

							}
							break;

						default :
							break loop60;
						}
					}
					} finally {dbg.exitSubRule(60);}
					dbg.location(418,24);
					char_literal313=(Token)match(input,63,FOLLOW_63_in_daEffect2616); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal313_tree = (Object)adaptor.create(char_literal313);
					adaptor.addChild(root_0, char_literal313_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:419:4: timedEffect
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(419,4);
					pushFollow(FOLLOW_timedEffect_in_daEffect2621);
					timedEffect314=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect314.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:420:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(420,4);
					char_literal315=(Token)match(input,62,FOLLOW_62_in_daEffect2626); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal315_tree = (Object)adaptor.create(char_literal315);
					adaptor.addChild(root_0, char_literal315_tree);
					}
					dbg.location(420,8);
					string_literal316=(Token)match(input,111,FOLLOW_111_in_daEffect2628); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal316_tree = (Object)adaptor.create(string_literal316);
					adaptor.addChild(root_0, string_literal316_tree);
					}
					dbg.location(420,17);
					char_literal317=(Token)match(input,62,FOLLOW_62_in_daEffect2630); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal317_tree = (Object)adaptor.create(char_literal317);
					adaptor.addChild(root_0, char_literal317_tree);
					}
					dbg.location(420,21);
					pushFollow(FOLLOW_typedVariableList_in_daEffect2632);
					typedVariableList318=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList318.getTree());
					dbg.location(420,39);
					char_literal319=(Token)match(input,63,FOLLOW_63_in_daEffect2634); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal319_tree = (Object)adaptor.create(char_literal319);
					adaptor.addChild(root_0, char_literal319_tree);
					}
					dbg.location(420,43);
					pushFollow(FOLLOW_daEffect_in_daEffect2636);
					daEffect320=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect320.getTree());
					dbg.location(420,52);
					char_literal321=(Token)match(input,63,FOLLOW_63_in_daEffect2638); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal321_tree = (Object)adaptor.create(char_literal321);
					adaptor.addChild(root_0, char_literal321_tree);
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:421:4: '(' 'when' daGD timedEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(421,4);
					char_literal322=(Token)match(input,62,FOLLOW_62_in_daEffect2643); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal322_tree = (Object)adaptor.create(char_literal322);
					adaptor.addChild(root_0, char_literal322_tree);
					}
					dbg.location(421,8);
					string_literal323=(Token)match(input,131,FOLLOW_131_in_daEffect2645); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal323_tree = (Object)adaptor.create(string_literal323);
					adaptor.addChild(root_0, string_literal323_tree);
					}
					dbg.location(421,15);
					pushFollow(FOLLOW_daGD_in_daEffect2647);
					daGD324=daGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daGD324.getTree());
					dbg.location(421,20);
					pushFollow(FOLLOW_timedEffect_in_daEffect2649);
					timedEffect325=timedEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timedEffect325.getTree());
					dbg.location(421,32);
					char_literal326=(Token)match(input,63,FOLLOW_63_in_daEffect2651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal326_tree = (Object)adaptor.create(char_literal326);
					adaptor.addChild(root_0, char_literal326_tree);
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:422:4: '(' assignOp fHead fExpDA ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(422,4);
					char_literal327=(Token)match(input,62,FOLLOW_62_in_daEffect2656); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal327_tree = (Object)adaptor.create(char_literal327);
					adaptor.addChild(root_0, char_literal327_tree);
					}
					dbg.location(422,8);
					pushFollow(FOLLOW_assignOp_in_daEffect2658);
					assignOp328=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp328.getTree());
					dbg.location(422,17);
					pushFollow(FOLLOW_fHead_in_daEffect2660);
					fHead329=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead329.getTree());
					dbg.location(422,23);
					pushFollow(FOLLOW_fExpDA_in_daEffect2662);
					fExpDA330=fExpDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA330.getTree());
					dbg.location(422,30);
					char_literal331=(Token)match(input,63,FOLLOW_63_in_daEffect2664); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal331_tree = (Object)adaptor.create(char_literal331);
					adaptor.addChild(root_0, char_literal331_tree);
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
		dbg.location(423, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "daEffect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:425:1: timedEffect : ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' );
	public final PddlParser.timedEffect_return timedEffect() throws  {
		PddlParser.timedEffect_return retval = new PddlParser.timedEffect_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal332=null;
		Token string_literal333=null;
		Token char_literal336=null;
		Token char_literal337=null;
		Token string_literal338=null;
		Token char_literal341=null;
		Token char_literal342=null;
		Token char_literal346=null;
		ParserRuleReturnScope timeSpecifier334 =null;
		ParserRuleReturnScope daEffect335 =null;
		ParserRuleReturnScope timeSpecifier339 =null;
		ParserRuleReturnScope fAssignDA340 =null;
		ParserRuleReturnScope assignOp343 =null;
		ParserRuleReturnScope fHead344 =null;
		ParserRuleReturnScope fExp345 =null;

		Object char_literal332_tree=null;
		Object string_literal333_tree=null;
		Object char_literal336_tree=null;
		Object char_literal337_tree=null;
		Object string_literal338_tree=null;
		Object char_literal341_tree=null;
		Object char_literal342_tree=null;
		Object char_literal346_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "timedEffect");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(425, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:426:2: ( '(' 'at' timeSpecifier daEffect ')' | '(' 'at' timeSpecifier fAssignDA ')' | '(' assignOp fHead fExp ')' )
			int alt62=3;
			try { dbg.enterDecision(62, decisionCanBacktrack[62]);

			int LA62_0 = input.LA(1);
			if ( (LA62_0==62) ) {
				int LA62_1 = input.LA(2);
				if ( (synpred101_Pddl()) ) {
					alt62=1;
				}
				else if ( (synpred102_Pddl()) ) {
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(62);}

			switch (alt62) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:426:4: '(' 'at' timeSpecifier daEffect ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(426,4);
					char_literal332=(Token)match(input,62,FOLLOW_62_in_timedEffect2675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal332_tree = (Object)adaptor.create(char_literal332);
					adaptor.addChild(root_0, char_literal332_tree);
					}
					dbg.location(426,8);
					string_literal333=(Token)match(input,103,FOLLOW_103_in_timedEffect2677); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal333_tree = (Object)adaptor.create(string_literal333);
					adaptor.addChild(root_0, string_literal333_tree);
					}
					dbg.location(426,13);
					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2679);
					timeSpecifier334=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier334.getTree());
					dbg.location(426,27);
					pushFollow(FOLLOW_daEffect_in_timedEffect2681);
					daEffect335=daEffect();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, daEffect335.getTree());
					dbg.location(426,36);
					char_literal336=(Token)match(input,63,FOLLOW_63_in_timedEffect2683); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal336_tree = (Object)adaptor.create(char_literal336);
					adaptor.addChild(root_0, char_literal336_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:427:4: '(' 'at' timeSpecifier fAssignDA ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(427,4);
					char_literal337=(Token)match(input,62,FOLLOW_62_in_timedEffect2693); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal337_tree = (Object)adaptor.create(char_literal337);
					adaptor.addChild(root_0, char_literal337_tree);
					}
					dbg.location(427,8);
					string_literal338=(Token)match(input,103,FOLLOW_103_in_timedEffect2695); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal338_tree = (Object)adaptor.create(string_literal338);
					adaptor.addChild(root_0, string_literal338_tree);
					}
					dbg.location(427,13);
					pushFollow(FOLLOW_timeSpecifier_in_timedEffect2697);
					timeSpecifier339=timeSpecifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeSpecifier339.getTree());
					dbg.location(427,27);
					pushFollow(FOLLOW_fAssignDA_in_timedEffect2699);
					fAssignDA340=fAssignDA();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fAssignDA340.getTree());
					dbg.location(427,37);
					char_literal341=(Token)match(input,63,FOLLOW_63_in_timedEffect2701); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal341_tree = (Object)adaptor.create(char_literal341);
					adaptor.addChild(root_0, char_literal341_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:428:4: '(' assignOp fHead fExp ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(428,4);
					char_literal342=(Token)match(input,62,FOLLOW_62_in_timedEffect2706); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal342_tree = (Object)adaptor.create(char_literal342);
					adaptor.addChild(root_0, char_literal342_tree);
					}
					dbg.location(428,8);
					pushFollow(FOLLOW_assignOp_in_timedEffect2708);
					assignOp343=assignOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp343.getTree());
					dbg.location(428,17);
					pushFollow(FOLLOW_fHead_in_timedEffect2710);
					fHead344=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead344.getTree());
					dbg.location(428,23);
					pushFollow(FOLLOW_fExp_in_timedEffect2712);
					fExp345=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp345.getTree());
					dbg.location(428,28);
					char_literal346=(Token)match(input,63,FOLLOW_63_in_timedEffect2714); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal346_tree = (Object)adaptor.create(char_literal346);
					adaptor.addChild(root_0, char_literal346_tree);
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
		dbg.location(429, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "timedEffect");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:431:1: fAssignDA : '(' assignOp fHead fExpDA ')' ;
	public final PddlParser.fAssignDA_return fAssignDA() throws  {
		PddlParser.fAssignDA_return retval = new PddlParser.fAssignDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal347=null;
		Token char_literal351=null;
		ParserRuleReturnScope assignOp348 =null;
		ParserRuleReturnScope fHead349 =null;
		ParserRuleReturnScope fExpDA350 =null;

		Object char_literal347_tree=null;
		Object char_literal351_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "fAssignDA");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(431, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:432:2: ( '(' assignOp fHead fExpDA ')' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:432:4: '(' assignOp fHead fExpDA ')'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(432,4);
			char_literal347=(Token)match(input,62,FOLLOW_62_in_fAssignDA2734); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal347_tree = (Object)adaptor.create(char_literal347);
			adaptor.addChild(root_0, char_literal347_tree);
			}
			dbg.location(432,8);
			pushFollow(FOLLOW_assignOp_in_fAssignDA2736);
			assignOp348=assignOp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp348.getTree());
			dbg.location(432,17);
			pushFollow(FOLLOW_fHead_in_fAssignDA2738);
			fHead349=fHead();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead349.getTree());
			dbg.location(432,23);
			pushFollow(FOLLOW_fExpDA_in_fAssignDA2740);
			fExpDA350=fExpDA();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA350.getTree());
			dbg.location(432,30);
			char_literal351=(Token)match(input,63,FOLLOW_63_in_fAssignDA2742); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal351_tree = (Object)adaptor.create(char_literal351);
			adaptor.addChild(root_0, char_literal351_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(433, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fAssignDA");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:435:1: fExpDA : ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp );
	public final PddlParser.fExpDA_return fExpDA() throws  {
		PddlParser.fExpDA_return retval = new PddlParser.fExpDA_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal352=null;
		Token char_literal356=null;
		Token char_literal358=null;
		Token string_literal359=null;
		ParserRuleReturnScope binaryOp353 =null;
		ParserRuleReturnScope fExpDA354 =null;
		ParserRuleReturnScope fExpDA355 =null;
		ParserRuleReturnScope fExpDA357 =null;
		ParserRuleReturnScope fExp360 =null;

		Object char_literal352_tree=null;
		Object char_literal356_tree=null;
		Object char_literal358_tree=null;
		Object string_literal359_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "fExpDA");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(435, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:2: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' | '?duration' | fExp )
			int alt64=3;
			try { dbg.enterDecision(64, decisionCanBacktrack[64]);

			switch ( input.LA(1) ) {
			case 62:
				{
				int LA64_1 = input.LA(2);
				if ( (synpred104_Pddl()) ) {
					alt64=1;
				}
				else if ( (true) ) {
					alt64=3;
				}

				}
				break;
			case 96:
				{
				alt64=2;
				}
				break;
			case NAME:
			case NUMBER:
			case 61:
				{
				alt64=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(64);}

			switch (alt64) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(436,4);
					char_literal352=(Token)match(input,62,FOLLOW_62_in_fExpDA2753); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal352_tree = (Object)adaptor.create(char_literal352);
					adaptor.addChild(root_0, char_literal352_tree);
					}
					dbg.location(436,8);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
					int alt63=2;
					try { dbg.enterSubRule(63);
					try { dbg.enterDecision(63, decisionCanBacktrack[63]);

					int LA63_0 = input.LA(1);
					if ( (LA63_0==66) ) {
						int LA63_1 = input.LA(2);
						if ( (synpred103_Pddl()) ) {
							alt63=1;
						}
						else if ( (true) ) {
							alt63=2;
						}

					}
					else if ( ((LA63_0 >= 64 && LA63_0 <= 65)||LA63_0==67||LA63_0==97) ) {
						alt63=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 63, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(63);}

					switch (alt63) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
							{
							dbg.location(436,9);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:10: binaryOp fExpDA fExpDA
							{
							dbg.location(436,10);
							pushFollow(FOLLOW_binaryOp_in_fExpDA2757);
							binaryOp353=binaryOp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp353.getTree());
							dbg.location(436,19);
							pushFollow(FOLLOW_fExpDA_in_fExpDA2759);
							fExpDA354=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA354.getTree());
							dbg.location(436,26);
							pushFollow(FOLLOW_fExpDA_in_fExpDA2761);
							fExpDA355=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA355.getTree());

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:36: ( '-' fExpDA )
							{
							dbg.location(436,36);
							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:36: ( '-' fExpDA )
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:37: '-' fExpDA
							{
							dbg.location(436,37);
							char_literal356=(Token)match(input,66,FOLLOW_66_in_fExpDA2767); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal356_tree = (Object)adaptor.create(char_literal356);
							adaptor.addChild(root_0, char_literal356_tree);
							}
							dbg.location(436,41);
							pushFollow(FOLLOW_fExpDA_in_fExpDA2769);
							fExpDA357=fExpDA();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, fExpDA357.getTree());

							}

							}
							break;

					}
					} finally {dbg.exitSubRule(63);}
					dbg.location(436,50);
					char_literal358=(Token)match(input,63,FOLLOW_63_in_fExpDA2773); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal358_tree = (Object)adaptor.create(char_literal358);
					adaptor.addChild(root_0, char_literal358_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:437:4: '?duration'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(437,4);
					string_literal359=(Token)match(input,96,FOLLOW_96_in_fExpDA2778); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal359_tree = (Object)adaptor.create(string_literal359);
					adaptor.addChild(root_0, string_literal359_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:438:4: fExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(438,4);
					pushFollow(FOLLOW_fExp_in_fExpDA2783);
					fExp360=fExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fExp360.getTree());

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
		dbg.location(439, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fExpDA");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:443:1: problem : '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) ;
	public final PddlParser.problem_return problem() throws  {
		PddlParser.problem_return retval = new PddlParser.problem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal361=null;
		Token string_literal362=null;
		Token char_literal371=null;
		ParserRuleReturnScope problemDecl363 =null;
		ParserRuleReturnScope problemDomain364 =null;
		ParserRuleReturnScope requireDef365 =null;
		ParserRuleReturnScope objectDecl366 =null;
		ParserRuleReturnScope init367 =null;
		ParserRuleReturnScope goal368 =null;
		ParserRuleReturnScope probConstraints369 =null;
		ParserRuleReturnScope metricSpec370 =null;

		Object char_literal361_tree=null;
		Object string_literal362_tree=null;
		Object char_literal371_tree=null;
		RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_metricSpec=new RewriteRuleSubtreeStream(adaptor,"rule metricSpec");
		RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
		RewriteRuleSubtreeStream stream_goal=new RewriteRuleSubtreeStream(adaptor,"rule goal");
		RewriteRuleSubtreeStream stream_requireDef=new RewriteRuleSubtreeStream(adaptor,"rule requireDef");
		RewriteRuleSubtreeStream stream_problemDecl=new RewriteRuleSubtreeStream(adaptor,"rule problemDecl");
		RewriteRuleSubtreeStream stream_objectDecl=new RewriteRuleSubtreeStream(adaptor,"rule objectDecl");
		RewriteRuleSubtreeStream stream_problemDomain=new RewriteRuleSubtreeStream(adaptor,"rule problemDomain");
		RewriteRuleSubtreeStream stream_probConstraints=new RewriteRuleSubtreeStream(adaptor,"rule probConstraints");

		try { dbg.enterRule(getGrammarFileName(), "problem");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(443, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:444:2: ( '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')' -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:444:4: '(' 'define' problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? ')'
			{
			dbg.location(444,4);
			char_literal361=(Token)match(input,62,FOLLOW_62_in_problem2797); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal361);
			dbg.location(444,8);
			string_literal362=(Token)match(input,106,FOLLOW_106_in_problem2799); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_106.add(string_literal362);
			dbg.location(444,17);
			pushFollow(FOLLOW_problemDecl_in_problem2801);
			problemDecl363=problemDecl();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDecl.add(problemDecl363.getTree());dbg.location(445,4);
			pushFollow(FOLLOW_problemDomain_in_problem2806);
			problemDomain364=problemDomain();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_problemDomain.add(problemDomain364.getTree());dbg.location(446,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:446:7: ( requireDef )?
			int alt65=2;
			try { dbg.enterSubRule(65);
			try { dbg.enterDecision(65, decisionCanBacktrack[65]);

			int LA65_0 = input.LA(1);
			if ( (LA65_0==62) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==89) ) {
					alt65=1;
				}
			}
			} finally {dbg.exitDecision(65);}

			switch (alt65) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:446:7: requireDef
					{
					dbg.location(446,7);
					pushFollow(FOLLOW_requireDef_in_problem2814);
					requireDef365=requireDef();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_requireDef.add(requireDef365.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(65);}
			dbg.location(447,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:447:7: ( objectDecl )?
			int alt66=2;
			try { dbg.enterSubRule(66);
			try { dbg.enterDecision(66, decisionCanBacktrack[66]);

			int LA66_0 = input.LA(1);
			if ( (LA66_0==62) ) {
				int LA66_1 = input.LA(2);
				if ( (LA66_1==84) ) {
					alt66=1;
				}
			}
			} finally {dbg.exitDecision(66);}

			switch (alt66) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:447:7: objectDecl
					{
					dbg.location(447,7);
					pushFollow(FOLLOW_objectDecl_in_problem2823);
					objectDecl366=objectDecl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_objectDecl.add(objectDecl366.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(66);}
			dbg.location(448,7);
			pushFollow(FOLLOW_init_in_problem2832);
			init367=init();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_init.add(init367.getTree());dbg.location(449,7);
			pushFollow(FOLLOW_goal_in_problem2840);
			goal368=goal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goal.add(goal368.getTree());dbg.location(450,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:450:7: ( probConstraints )?
			int alt67=2;
			try { dbg.enterSubRule(67);
			try { dbg.enterDecision(67, decisionCanBacktrack[67]);

			int LA67_0 = input.LA(1);
			if ( (LA67_0==62) ) {
				int LA67_1 = input.LA(2);
				if ( (LA67_1==72) ) {
					alt67=1;
				}
			}
			} finally {dbg.exitDecision(67);}

			switch (alt67) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:450:7: probConstraints
					{
					dbg.location(450,7);
					pushFollow(FOLLOW_probConstraints_in_problem2848);
					probConstraints369=probConstraints();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_probConstraints.add(probConstraints369.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(67);}
			dbg.location(451,7);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:451:7: ( metricSpec )?
			int alt68=2;
			try { dbg.enterSubRule(68);
			try { dbg.enterDecision(68, decisionCanBacktrack[68]);

			int LA68_0 = input.LA(1);
			if ( (LA68_0==62) ) {
				alt68=1;
			}
			} finally {dbg.exitDecision(68);}

			switch (alt68) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:451:7: metricSpec
					{
					dbg.location(451,7);
					pushFollow(FOLLOW_metricSpec_in_problem2857);
					metricSpec370=metricSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricSpec.add(metricSpec370.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(68);}
			dbg.location(453,7);
			char_literal371=(Token)match(input,63,FOLLOW_63_in_problem2873); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal371);

			// AST REWRITE
			// elements: problemDomain, init, probConstraints, requireDef, metricSpec, objectDecl, problemDecl, goal
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 454:7: -> ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
			{
				dbg.location(454,10);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:454:10: ^( PROBLEM problemDecl problemDomain ( requireDef )? ( objectDecl )? init goal ( probConstraints )? ( metricSpec )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(454,12);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM, "PROBLEM"), root_1);
				dbg.location(454,20);
				adaptor.addChild(root_1, stream_problemDecl.nextTree());dbg.location(454,32);
				adaptor.addChild(root_1, stream_problemDomain.nextTree());dbg.location(454,46);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:454:46: ( requireDef )?
				if ( stream_requireDef.hasNext() ) {
					dbg.location(454,46);
					adaptor.addChild(root_1, stream_requireDef.nextTree());
				}
				stream_requireDef.reset();
				dbg.location(454,58);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:454:58: ( objectDecl )?
				if ( stream_objectDecl.hasNext() ) {
					dbg.location(454,58);
					adaptor.addChild(root_1, stream_objectDecl.nextTree());
				}
				stream_objectDecl.reset();
				dbg.location(455,9);
				adaptor.addChild(root_1, stream_init.nextTree());dbg.location(455,14);
				adaptor.addChild(root_1, stream_goal.nextTree());dbg.location(455,19);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:455:19: ( probConstraints )?
				if ( stream_probConstraints.hasNext() ) {
					dbg.location(455,19);
					adaptor.addChild(root_1, stream_probConstraints.nextTree());
				}
				stream_probConstraints.reset();
				dbg.location(455,36);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:455:36: ( metricSpec )?
				if ( stream_metricSpec.hasNext() ) {
					dbg.location(455,36);
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
		dbg.location(456, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "problem");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:458:1: problemDecl : '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) ;
	public final PddlParser.problemDecl_return problemDecl() throws  {
		PddlParser.problemDecl_return retval = new PddlParser.problemDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal372=null;
		Token string_literal373=null;
		Token NAME374=null;
		Token char_literal375=null;

		Object char_literal372_tree=null;
		Object string_literal373_tree=null;
		Object NAME374_tree=null;
		Object char_literal375_tree=null;
		RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try { dbg.enterRule(getGrammarFileName(), "problemDecl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(458, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:459:5: ( '(' 'problem' NAME ')' -> ^( PROBLEM_NAME NAME ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:459:7: '(' 'problem' NAME ')'
			{
			dbg.location(459,7);
			char_literal372=(Token)match(input,62,FOLLOW_62_in_problemDecl2930); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal372);
			dbg.location(459,11);
			string_literal373=(Token)match(input,124,FOLLOW_124_in_problemDecl2932); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_124.add(string_literal373);
			dbg.location(459,21);
			NAME374=(Token)match(input,NAME,FOLLOW_NAME_in_problemDecl2934); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME374);
			dbg.location(459,26);
			char_literal375=(Token)match(input,63,FOLLOW_63_in_problemDecl2936); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal375);

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
			// 460:5: -> ^( PROBLEM_NAME NAME )
			{
				dbg.location(460,8);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:460:8: ^( PROBLEM_NAME NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(460,10);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_NAME, "PROBLEM_NAME"), root_1);
				dbg.location(460,23);
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
		dbg.location(461, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "problemDecl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:463:1: problemDomain : '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) ;
	public final PddlParser.problemDomain_return problemDomain() throws  {
		PddlParser.problemDomain_return retval = new PddlParser.problemDomain_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal376=null;
		Token string_literal377=null;
		Token NAME378=null;
		Token char_literal379=null;

		Object char_literal376_tree=null;
		Object string_literal377_tree=null;
		Object NAME378_tree=null;
		Object char_literal379_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

		try { dbg.enterRule(getGrammarFileName(), "problemDomain");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(463, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:464:2: ( '(' ':domain' NAME ')' -> ^( PROBLEM_DOMAIN NAME ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:464:4: '(' ':domain' NAME ')'
			{
			dbg.location(464,4);
			char_literal376=(Token)match(input,62,FOLLOW_62_in_problemDomain2962); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal376);
			dbg.location(464,8);
			string_literal377=(Token)match(input,74,FOLLOW_74_in_problemDomain2964); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_74.add(string_literal377);
			dbg.location(464,18);
			NAME378=(Token)match(input,NAME,FOLLOW_NAME_in_problemDomain2966); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NAME.add(NAME378);
			dbg.location(464,23);
			char_literal379=(Token)match(input,63,FOLLOW_63_in_problemDomain2968); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal379);

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
			// 465:2: -> ^( PROBLEM_DOMAIN NAME )
			{
				dbg.location(465,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:465:5: ^( PROBLEM_DOMAIN NAME )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(465,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_DOMAIN, "PROBLEM_DOMAIN"), root_1);
				dbg.location(465,22);
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
		dbg.location(466, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "problemDomain");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:468:1: objectDecl : '(' ':objects' ( typedNameList )* ')' -> ^( OBJECTS ( typedNameList )* ) ;
	public final PddlParser.objectDecl_return objectDecl() throws  {
		PddlParser.objectDecl_return retval = new PddlParser.objectDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal380=null;
		Token string_literal381=null;
		Token char_literal383=null;
		ParserRuleReturnScope typedNameList382 =null;

		Object char_literal380_tree=null;
		Object string_literal381_tree=null;
		Object char_literal383_tree=null;
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_typedNameList=new RewriteRuleSubtreeStream(adaptor,"rule typedNameList");

		try { dbg.enterRule(getGrammarFileName(), "objectDecl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(468, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:2: ( '(' ':objects' ( typedNameList )* ')' -> ^( OBJECTS ( typedNameList )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:4: '(' ':objects' ( typedNameList )* ')'
			{
			dbg.location(469,4);
			char_literal380=(Token)match(input,62,FOLLOW_62_in_objectDecl2988); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal380);
			dbg.location(469,8);
			string_literal381=(Token)match(input,84,FOLLOW_84_in_objectDecl2990); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_84.add(string_literal381);
			dbg.location(469,20);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:20: ( typedNameList )*
			try { dbg.enterSubRule(69);

			loop69:
			while (true) {
				int alt69=2;
				try { dbg.enterDecision(69, decisionCanBacktrack[69]);

				int LA69_0 = input.LA(1);
				if ( (LA69_0==63) ) {
					int LA69_1 = input.LA(2);
					if ( (synpred110_Pddl()) ) {
						alt69=1;
					}

				}
				else if ( (LA69_0==NAME) ) {
					alt69=1;
				}

				} finally {dbg.exitDecision(69);}

				switch (alt69) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:20: typedNameList
					{
					dbg.location(469,20);
					pushFollow(FOLLOW_typedNameList_in_objectDecl2993);
					typedNameList382=typedNameList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_typedNameList.add(typedNameList382.getTree());
					}
					break;

				default :
					break loop69;
				}
			}
			} finally {dbg.exitSubRule(69);}
			dbg.location(469,35);
			char_literal383=(Token)match(input,63,FOLLOW_63_in_objectDecl2996); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal383);

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
			// 469:39: -> ^( OBJECTS ( typedNameList )* )
			{
				dbg.location(469,42);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:42: ^( OBJECTS ( typedNameList )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(469,44);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECTS, "OBJECTS"), root_1);
				dbg.location(469,52);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:52: ( typedNameList )*
				while ( stream_typedNameList.hasNext() ) {
					dbg.location(469,52);
					adaptor.addChild(root_1, stream_typedNameList.nextTree());
				}
				stream_typedNameList.reset();

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
		dbg.location(470, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "objectDecl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:472:1: init : '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) ;
	public final PddlParser.init_return init() throws  {
		PddlParser.init_return retval = new PddlParser.init_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal384=null;
		Token string_literal385=null;
		Token char_literal387=null;
		ParserRuleReturnScope initEl386 =null;

		Object char_literal384_tree=null;
		Object string_literal385_tree=null;
		Object char_literal387_tree=null;
		RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_initEl=new RewriteRuleSubtreeStream(adaptor,"rule initEl");

		try { dbg.enterRule(getGrammarFileName(), "init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(472, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:473:2: ( '(' ':init' ( initEl )* ')' -> ^( INIT ( initEl )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:473:4: '(' ':init' ( initEl )* ')'
			{
			dbg.location(473,4);
			char_literal384=(Token)match(input,62,FOLLOW_62_in_init3016); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal384);
			dbg.location(473,8);
			string_literal385=(Token)match(input,82,FOLLOW_82_in_init3018); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_82.add(string_literal385);
			dbg.location(473,16);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:473:16: ( initEl )*
			try { dbg.enterSubRule(70);

			loop70:
			while (true) {
				int alt70=2;
				try { dbg.enterDecision(70, decisionCanBacktrack[70]);

				int LA70_0 = input.LA(1);
				if ( (LA70_0==62) ) {
					alt70=1;
				}

				} finally {dbg.exitDecision(70);}

				switch (alt70) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:473:16: initEl
					{
					dbg.location(473,16);
					pushFollow(FOLLOW_initEl_in_init3020);
					initEl386=initEl();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_initEl.add(initEl386.getTree());
					}
					break;

				default :
					break loop70;
				}
			}
			} finally {dbg.exitSubRule(70);}
			dbg.location(473,24);
			char_literal387=(Token)match(input,63,FOLLOW_63_in_init3023); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal387);

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
			// 474:2: -> ^( INIT ( initEl )* )
			{
				dbg.location(474,5);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:474:5: ^( INIT ( initEl )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(474,7);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT, "INIT"), root_1);
				dbg.location(474,12);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:474:12: ( initEl )*
				while ( stream_initEl.hasNext() ) {
					dbg.location(474,12);
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
		dbg.location(475, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:477:1: initEl : ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) );
	public final PddlParser.initEl_return initEl() throws  {
		PddlParser.initEl_return retval = new PddlParser.initEl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal389=null;
		Token char_literal390=null;
		Token NUMBER392=null;
		Token char_literal393=null;
		Token char_literal394=null;
		Token string_literal395=null;
		Token NUMBER396=null;
		Token char_literal398=null;
		ParserRuleReturnScope nameLiteral388 =null;
		ParserRuleReturnScope fHead391 =null;
		ParserRuleReturnScope nameLiteral397 =null;

		Object char_literal389_tree=null;
		Object char_literal390_tree=null;
		Object NUMBER392_tree=null;
		Object char_literal393_tree=null;
		Object char_literal394_tree=null;
		Object string_literal395_tree=null;
		Object NUMBER396_tree=null;
		Object char_literal398_tree=null;
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");
		RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_fHead=new RewriteRuleSubtreeStream(adaptor,"rule fHead");
		RewriteRuleSubtreeStream stream_nameLiteral=new RewriteRuleSubtreeStream(adaptor,"rule nameLiteral");

		try { dbg.enterRule(getGrammarFileName(), "initEl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(477, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:478:2: ( nameLiteral | '(' '=' fHead NUMBER ')' -> ^( INIT_EQ fHead NUMBER ) | '(' 'at' NUMBER nameLiteral ')' -> ^( INIT_AT NUMBER nameLiteral ) )
			int alt71=3;
			try { dbg.enterDecision(71, decisionCanBacktrack[71]);

			int LA71_0 = input.LA(1);
			if ( (LA71_0==62) ) {
				switch ( input.LA(2) ) {
				case NAME:
				case 119:
					{
					alt71=1;
					}
					break;
				case 93:
					{
					alt71=2;
					}
					break;
				case 103:
					{
					alt71=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 71, 1, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(71);}

			switch (alt71) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:478:4: nameLiteral
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(478,4);
					pushFollow(FOLLOW_nameLiteral_in_initEl3044);
					nameLiteral388=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nameLiteral388.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:479:4: '(' '=' fHead NUMBER ')'
					{
					dbg.location(479,4);
					char_literal389=(Token)match(input,62,FOLLOW_62_in_initEl3049); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal389);
					dbg.location(479,8);
					char_literal390=(Token)match(input,93,FOLLOW_93_in_initEl3051); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_93.add(char_literal390);
					dbg.location(479,12);
					pushFollow(FOLLOW_fHead_in_initEl3053);
					fHead391=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fHead.add(fHead391.getTree());dbg.location(479,18);
					NUMBER392=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3055); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER392);
					dbg.location(479,25);
					char_literal393=(Token)match(input,63,FOLLOW_63_in_initEl3057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal393);

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
					// 479:37: -> ^( INIT_EQ fHead NUMBER )
					{
						dbg.location(479,40);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:479:40: ^( INIT_EQ fHead NUMBER )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(479,42);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT_EQ, "INIT_EQ"), root_1);
						dbg.location(479,50);
						adaptor.addChild(root_1, stream_fHead.nextTree());dbg.location(479,56);
						adaptor.addChild(root_1, stream_NUMBER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:480:4: '(' 'at' NUMBER nameLiteral ')'
					{
					dbg.location(480,4);
					char_literal394=(Token)match(input,62,FOLLOW_62_in_initEl3080); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal394);
					dbg.location(480,8);
					string_literal395=(Token)match(input,103,FOLLOW_103_in_initEl3082); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_103.add(string_literal395);
					dbg.location(480,13);
					NUMBER396=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_initEl3084); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER396);
					dbg.location(480,20);
					pushFollow(FOLLOW_nameLiteral_in_initEl3086);
					nameLiteral397=nameLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nameLiteral.add(nameLiteral397.getTree());dbg.location(480,32);
					char_literal398=(Token)match(input,63,FOLLOW_63_in_initEl3088); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal398);

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
					// 480:37: -> ^( INIT_AT NUMBER nameLiteral )
					{
						dbg.location(480,40);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:480:40: ^( INIT_AT NUMBER nameLiteral )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(480,42);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INIT_AT, "INIT_AT"), root_1);
						dbg.location(480,50);
						adaptor.addChild(root_1, stream_NUMBER.nextNode());dbg.location(480,57);
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
		dbg.location(481, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "initEl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:483:1: nameLiteral : ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) );
	public final PddlParser.nameLiteral_return nameLiteral() throws  {
		PddlParser.nameLiteral_return retval = new PddlParser.nameLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal400=null;
		Token string_literal401=null;
		Token char_literal403=null;
		ParserRuleReturnScope atomicNameFormula399 =null;
		ParserRuleReturnScope atomicNameFormula402 =null;

		Object char_literal400_tree=null;
		Object string_literal401_tree=null;
		Object char_literal403_tree=null;
		RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_atomicNameFormula=new RewriteRuleSubtreeStream(adaptor,"rule atomicNameFormula");

		try { dbg.enterRule(getGrammarFileName(), "nameLiteral");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(483, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:484:2: ( atomicNameFormula | '(' 'not' atomicNameFormula ')' -> ^( NOT_PRED_INIT atomicNameFormula ) )
			int alt72=2;
			try { dbg.enterDecision(72, decisionCanBacktrack[72]);

			int LA72_0 = input.LA(1);
			if ( (LA72_0==62) ) {
				int LA72_1 = input.LA(2);
				if ( (LA72_1==119) ) {
					alt72=2;
				}
				else if ( (LA72_1==NAME) ) {
					alt72=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 72, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(72);}

			switch (alt72) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:484:4: atomicNameFormula
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(484,4);
					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3110);
					atomicNameFormula399=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atomicNameFormula399.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:485:4: '(' 'not' atomicNameFormula ')'
					{
					dbg.location(485,4);
					char_literal400=(Token)match(input,62,FOLLOW_62_in_nameLiteral3115); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal400);
					dbg.location(485,8);
					string_literal401=(Token)match(input,119,FOLLOW_119_in_nameLiteral3117); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_119.add(string_literal401);
					dbg.location(485,14);
					pushFollow(FOLLOW_atomicNameFormula_in_nameLiteral3119);
					atomicNameFormula402=atomicNameFormula();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atomicNameFormula.add(atomicNameFormula402.getTree());dbg.location(485,32);
					char_literal403=(Token)match(input,63,FOLLOW_63_in_nameLiteral3121); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal403);

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
					// 485:36: -> ^( NOT_PRED_INIT atomicNameFormula )
					{
						dbg.location(485,39);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:485:39: ^( NOT_PRED_INIT atomicNameFormula )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(485,41);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOT_PRED_INIT, "NOT_PRED_INIT"), root_1);
						dbg.location(485,55);
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
		dbg.location(486, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "nameLiteral");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:488:1: atomicNameFormula : '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) ;
	public final PddlParser.atomicNameFormula_return atomicNameFormula() throws  {
		PddlParser.atomicNameFormula_return retval = new PddlParser.atomicNameFormula_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal404=null;
		Token NAME406=null;
		Token char_literal407=null;
		ParserRuleReturnScope predicate405 =null;

		Object char_literal404_tree=null;
		Object NAME406_tree=null;
		Object char_literal407_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
		RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");

		try { dbg.enterRule(getGrammarFileName(), "atomicNameFormula");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(488, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:2: ( '(' predicate ( NAME )* ')' -> ^( PRED_INST predicate ( NAME )* ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:4: '(' predicate ( NAME )* ')'
			{
			dbg.location(489,4);
			char_literal404=(Token)match(input,62,FOLLOW_62_in_atomicNameFormula3140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal404);
			dbg.location(489,8);
			pushFollow(FOLLOW_predicate_in_atomicNameFormula3142);
			predicate405=predicate();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_predicate.add(predicate405.getTree());dbg.location(489,18);
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:18: ( NAME )*
			try { dbg.enterSubRule(73);

			loop73:
			while (true) {
				int alt73=2;
				try { dbg.enterDecision(73, decisionCanBacktrack[73]);

				int LA73_0 = input.LA(1);
				if ( (LA73_0==NAME) ) {
					alt73=1;
				}

				} finally {dbg.exitDecision(73);}

				switch (alt73) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:18: NAME
					{
					dbg.location(489,18);
					NAME406=(Token)match(input,NAME,FOLLOW_NAME_in_atomicNameFormula3144); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NAME.add(NAME406);

					}
					break;

				default :
					break loop73;
				}
			}
			} finally {dbg.exitSubRule(73);}
			dbg.location(489,24);
			char_literal407=(Token)match(input,63,FOLLOW_63_in_atomicNameFormula3147); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal407);

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
			// 489:28: -> ^( PRED_INST predicate ( NAME )* )
			{
				dbg.location(489,31);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:31: ^( PRED_INST predicate ( NAME )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(489,33);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRED_INST, "PRED_INST"), root_1);
				dbg.location(489,43);
				adaptor.addChild(root_1, stream_predicate.nextTree());dbg.location(489,53);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:489:53: ( NAME )*
				while ( stream_NAME.hasNext() ) {
					dbg.location(489,53);
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
		dbg.location(490, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atomicNameFormula");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:496:1: goal : '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) ;
	public final PddlParser.goal_return goal() throws  {
		PddlParser.goal_return retval = new PddlParser.goal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal408=null;
		Token string_literal409=null;
		Token char_literal411=null;
		ParserRuleReturnScope goalDesc410 =null;

		Object char_literal408_tree=null;
		Object string_literal409_tree=null;
		Object char_literal411_tree=null;
		RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_goalDesc=new RewriteRuleSubtreeStream(adaptor,"rule goalDesc");

		try { dbg.enterRule(getGrammarFileName(), "goal");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(496, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:496:6: ( '(' ':goal' goalDesc ')' -> ^( GOAL goalDesc ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:496:8: '(' ':goal' goalDesc ')'
			{
			dbg.location(496,8);
			char_literal408=(Token)match(input,62,FOLLOW_62_in_goal3172); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal408);
			dbg.location(496,12);
			string_literal409=(Token)match(input,81,FOLLOW_81_in_goal3174); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_81.add(string_literal409);
			dbg.location(496,20);
			pushFollow(FOLLOW_goalDesc_in_goal3176);
			goalDesc410=goalDesc();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_goalDesc.add(goalDesc410.getTree());dbg.location(496,29);
			char_literal411=(Token)match(input,63,FOLLOW_63_in_goal3178); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal411);

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
			// 496:33: -> ^( GOAL goalDesc )
			{
				dbg.location(496,36);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:496:36: ^( GOAL goalDesc )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(496,38);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GOAL, "GOAL"), root_1);
				dbg.location(496,43);
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
		dbg.location(496, 52);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "goal");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:498:1: probConstraints : '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) ;
	public final PddlParser.probConstraints_return probConstraints() throws  {
		PddlParser.probConstraints_return retval = new PddlParser.probConstraints_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal412=null;
		Token string_literal413=null;
		Token char_literal415=null;
		ParserRuleReturnScope prefConGD414 =null;

		Object char_literal412_tree=null;
		Object string_literal413_tree=null;
		Object char_literal415_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_prefConGD=new RewriteRuleSubtreeStream(adaptor,"rule prefConGD");

		try { dbg.enterRule(getGrammarFileName(), "probConstraints");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(498, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:499:2: ( '(' ':constraints' prefConGD ')' -> ^( PROBLEM_CONSTRAINT prefConGD ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:499:4: '(' ':constraints' prefConGD ')'
			{
			dbg.location(499,4);
			char_literal412=(Token)match(input,62,FOLLOW_62_in_probConstraints3196); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal412);
			dbg.location(499,8);
			string_literal413=(Token)match(input,72,FOLLOW_72_in_probConstraints3198); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_72.add(string_literal413);
			dbg.location(499,24);
			pushFollow(FOLLOW_prefConGD_in_probConstraints3201);
			prefConGD414=prefConGD();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_prefConGD.add(prefConGD414.getTree());dbg.location(499,34);
			char_literal415=(Token)match(input,63,FOLLOW_63_in_probConstraints3203); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal415);

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
			// 500:4: -> ^( PROBLEM_CONSTRAINT prefConGD )
			{
				dbg.location(500,7);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:500:7: ^( PROBLEM_CONSTRAINT prefConGD )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(500,9);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_CONSTRAINT, "PROBLEM_CONSTRAINT"), root_1);
				dbg.location(500,28);
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
		dbg.location(501, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "probConstraints");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:503:1: prefConGD : ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD );
	public final PddlParser.prefConGD_return prefConGD() throws  {
		PddlParser.prefConGD_return retval = new PddlParser.prefConGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal416=null;
		Token string_literal417=null;
		Token char_literal419=null;
		Token char_literal420=null;
		Token string_literal421=null;
		Token char_literal422=null;
		Token char_literal424=null;
		Token char_literal426=null;
		Token char_literal427=null;
		Token string_literal428=null;
		Token NAME429=null;
		Token char_literal431=null;
		ParserRuleReturnScope prefConGD418 =null;
		ParserRuleReturnScope typedVariableList423 =null;
		ParserRuleReturnScope prefConGD425 =null;
		ParserRuleReturnScope conGD430 =null;
		ParserRuleReturnScope conGD432 =null;

		Object char_literal416_tree=null;
		Object string_literal417_tree=null;
		Object char_literal419_tree=null;
		Object char_literal420_tree=null;
		Object string_literal421_tree=null;
		Object char_literal422_tree=null;
		Object char_literal424_tree=null;
		Object char_literal426_tree=null;
		Object char_literal427_tree=null;
		Object string_literal428_tree=null;
		Object NAME429_tree=null;
		Object char_literal431_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "prefConGD");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(503, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:2: ( '(' 'and' ( prefConGD )* ')' | '(' 'forall' '(' typedVariableList ')' prefConGD ')' | '(' 'preference' ( NAME )? conGD ')' | conGD )
			int alt76=4;
			try { dbg.enterDecision(76, decisionCanBacktrack[76]);

			int LA76_0 = input.LA(1);
			if ( (LA76_0==62) ) {
				int LA76_1 = input.LA(2);
				if ( (synpred117_Pddl()) ) {
					alt76=1;
				}
				else if ( (synpred118_Pddl()) ) {
					alt76=2;
				}
				else if ( (synpred120_Pddl()) ) {
					alt76=3;
				}
				else if ( (true) ) {
					alt76=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(76);}

			switch (alt76) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:4: '(' 'and' ( prefConGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(504,4);
					char_literal416=(Token)match(input,62,FOLLOW_62_in_prefConGD3225); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal416_tree = (Object)adaptor.create(char_literal416);
					adaptor.addChild(root_0, char_literal416_tree);
					}
					dbg.location(504,8);
					string_literal417=(Token)match(input,101,FOLLOW_101_in_prefConGD3227); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal417_tree = (Object)adaptor.create(string_literal417);
					adaptor.addChild(root_0, string_literal417_tree);
					}
					dbg.location(504,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:14: ( prefConGD )*
					try { dbg.enterSubRule(74);

					loop74:
					while (true) {
						int alt74=2;
						try { dbg.enterDecision(74, decisionCanBacktrack[74]);

						int LA74_0 = input.LA(1);
						if ( (LA74_0==62) ) {
							alt74=1;
						}

						} finally {dbg.exitDecision(74);}

						switch (alt74) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:14: prefConGD
							{
							dbg.location(504,14);
							pushFollow(FOLLOW_prefConGD_in_prefConGD3229);
							prefConGD418=prefConGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD418.getTree());

							}
							break;

						default :
							break loop74;
						}
					}
					} finally {dbg.exitSubRule(74);}
					dbg.location(504,25);
					char_literal419=(Token)match(input,63,FOLLOW_63_in_prefConGD3232); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal419_tree = (Object)adaptor.create(char_literal419);
					adaptor.addChild(root_0, char_literal419_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:505:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(505,4);
					char_literal420=(Token)match(input,62,FOLLOW_62_in_prefConGD3237); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal420_tree = (Object)adaptor.create(char_literal420);
					adaptor.addChild(root_0, char_literal420_tree);
					}
					dbg.location(505,8);
					string_literal421=(Token)match(input,111,FOLLOW_111_in_prefConGD3239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal421_tree = (Object)adaptor.create(string_literal421);
					adaptor.addChild(root_0, string_literal421_tree);
					}
					dbg.location(505,17);
					char_literal422=(Token)match(input,62,FOLLOW_62_in_prefConGD3241); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal422_tree = (Object)adaptor.create(char_literal422);
					adaptor.addChild(root_0, char_literal422_tree);
					}
					dbg.location(505,21);
					pushFollow(FOLLOW_typedVariableList_in_prefConGD3243);
					typedVariableList423=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList423.getTree());
					dbg.location(505,39);
					char_literal424=(Token)match(input,63,FOLLOW_63_in_prefConGD3245); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal424_tree = (Object)adaptor.create(char_literal424);
					adaptor.addChild(root_0, char_literal424_tree);
					}
					dbg.location(505,43);
					pushFollow(FOLLOW_prefConGD_in_prefConGD3247);
					prefConGD425=prefConGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, prefConGD425.getTree());
					dbg.location(505,53);
					char_literal426=(Token)match(input,63,FOLLOW_63_in_prefConGD3249); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal426_tree = (Object)adaptor.create(char_literal426);
					adaptor.addChild(root_0, char_literal426_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:4: '(' 'preference' ( NAME )? conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(506,4);
					char_literal427=(Token)match(input,62,FOLLOW_62_in_prefConGD3254); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal427_tree = (Object)adaptor.create(char_literal427);
					adaptor.addChild(root_0, char_literal427_tree);
					}
					dbg.location(506,8);
					string_literal428=(Token)match(input,123,FOLLOW_123_in_prefConGD3256); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal428_tree = (Object)adaptor.create(string_literal428);
					adaptor.addChild(root_0, string_literal428_tree);
					}
					dbg.location(506,21);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:21: ( NAME )?
					int alt75=2;
					try { dbg.enterSubRule(75);
					try { dbg.enterDecision(75, decisionCanBacktrack[75]);

					int LA75_0 = input.LA(1);
					if ( (LA75_0==NAME) ) {
						alt75=1;
					}
					} finally {dbg.exitDecision(75);}

					switch (alt75) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:21: NAME
							{
							dbg.location(506,21);
							NAME429=(Token)match(input,NAME,FOLLOW_NAME_in_prefConGD3258); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NAME429_tree = (Object)adaptor.create(NAME429);
							adaptor.addChild(root_0, NAME429_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(75);}
					dbg.location(506,27);
					pushFollow(FOLLOW_conGD_in_prefConGD3261);
					conGD430=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD430.getTree());
					dbg.location(506,33);
					char_literal431=(Token)match(input,63,FOLLOW_63_in_prefConGD3263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal431_tree = (Object)adaptor.create(char_literal431);
					adaptor.addChild(root_0, char_literal431_tree);
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:507:4: conGD
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(507,4);
					pushFollow(FOLLOW_conGD_in_prefConGD3268);
					conGD432=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD432.getTree());

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
		dbg.location(508, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prefConGD");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:510:1: metricSpec : '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) ;
	public final PddlParser.metricSpec_return metricSpec() throws  {
		PddlParser.metricSpec_return retval = new PddlParser.metricSpec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal433=null;
		Token string_literal434=null;
		Token char_literal437=null;
		ParserRuleReturnScope optimization435 =null;
		ParserRuleReturnScope metricFExp436 =null;

		Object char_literal433_tree=null;
		Object string_literal434_tree=null;
		Object char_literal437_tree=null;
		RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_optimization=new RewriteRuleSubtreeStream(adaptor,"rule optimization");

		try { dbg.enterRule(getGrammarFileName(), "metricSpec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(510, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:511:2: ( '(' ':metric' optimization metricFExp ')' -> ^( PROBLEM_METRIC optimization metricFExp ) )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:511:4: '(' ':metric' optimization metricFExp ')'
			{
			dbg.location(511,4);
			char_literal433=(Token)match(input,62,FOLLOW_62_in_metricSpec3279); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_62.add(char_literal433);
			dbg.location(511,8);
			string_literal434=(Token)match(input,83,FOLLOW_83_in_metricSpec3281); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_83.add(string_literal434);
			dbg.location(511,18);
			pushFollow(FOLLOW_optimization_in_metricSpec3283);
			optimization435=optimization();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_optimization.add(optimization435.getTree());dbg.location(511,31);
			pushFollow(FOLLOW_metricFExp_in_metricSpec3285);
			metricFExp436=metricFExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp436.getTree());dbg.location(511,42);
			char_literal437=(Token)match(input,63,FOLLOW_63_in_metricSpec3287); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_63.add(char_literal437);

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
			// 512:4: -> ^( PROBLEM_METRIC optimization metricFExp )
			{
				dbg.location(512,7);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:512:7: ^( PROBLEM_METRIC optimization metricFExp )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(512,9);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROBLEM_METRIC, "PROBLEM_METRIC"), root_1);
				dbg.location(512,24);
				adaptor.addChild(root_1, stream_optimization.nextTree());dbg.location(512,37);
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
		dbg.location(513, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "metricSpec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:515:1: optimization : ( 'minimize' | 'maximize' );
	public final PddlParser.optimization_return optimization() throws  {
		PddlParser.optimization_return retval = new PddlParser.optimization_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set438=null;

		Object set438_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "optimization");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(515, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:515:14: ( 'minimize' | 'maximize' )
			dbg.enterAlt(1);

			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(515,14);
			set438=input.LT(1);
			if ( (input.LA(1) >= 117 && input.LA(1) <= 118) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set438));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
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
		dbg.location(515, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "optimization");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:517:1: metricFExp : ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' );
	public final PddlParser.metricFExp_return metricFExp() throws  {
		PddlParser.metricFExp_return retval = new PddlParser.metricFExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal439=null;
		Token char_literal443=null;
		Token char_literal444=null;
		Token char_literal448=null;
		Token char_literal449=null;
		Token char_literal450=null;
		Token char_literal452=null;
		Token NUMBER453=null;
		Token char_literal455=null;
		Token string_literal456=null;
		Token NAME457=null;
		Token char_literal458=null;
		ParserRuleReturnScope binaryOp440 =null;
		ParserRuleReturnScope metricFExp441 =null;
		ParserRuleReturnScope metricFExp442 =null;
		ParserRuleReturnScope multiOp445 =null;
		ParserRuleReturnScope metricFExp446 =null;
		ParserRuleReturnScope metricFExp447 =null;
		ParserRuleReturnScope metricFExp451 =null;
		ParserRuleReturnScope fHead454 =null;

		Object char_literal439_tree=null;
		Object char_literal443_tree=null;
		Object char_literal444_tree=null;
		Object char_literal448_tree=null;
		Object char_literal449_tree=null;
		Object char_literal450_tree=null;
		Object char_literal452_tree=null;
		Object NUMBER453_tree=null;
		Object char_literal455_tree=null;
		Object string_literal456_tree=null;
		Object NAME457_tree=null;
		Object char_literal458_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_binaryOp=new RewriteRuleSubtreeStream(adaptor,"rule binaryOp");
		RewriteRuleSubtreeStream stream_metricFExp=new RewriteRuleSubtreeStream(adaptor,"rule metricFExp");
		RewriteRuleSubtreeStream stream_multiOp=new RewriteRuleSubtreeStream(adaptor,"rule multiOp");

		try { dbg.enterRule(getGrammarFileName(), "metricFExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(517, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:518:2: ( '(' binaryOp metricFExp metricFExp ')' -> ^( BINARY_OP binaryOp metricFExp metricFExp ) | '(' multiOp metricFExp ( metricFExp )+ ')' -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ ) | '(' '-' metricFExp ')' -> ^( MINUS_OP metricFExp ) | NUMBER | fHead | '(' 'is-violated' NAME ')' )
			int alt78=6;
			try { dbg.enterDecision(78, decisionCanBacktrack[78]);

			switch ( input.LA(1) ) {
			case 62:
				{
				int LA78_1 = input.LA(2);
				if ( (synpred122_Pddl()) ) {
					alt78=1;
				}
				else if ( (synpred124_Pddl()) ) {
					alt78=2;
				}
				else if ( (synpred125_Pddl()) ) {
					alt78=3;
				}
				else if ( (synpred127_Pddl()) ) {
					alt78=5;
				}
				else if ( (true) ) {
					alt78=6;
				}

				}
				break;
			case NUMBER:
				{
				alt78=4;
				}
				break;
			case NAME:
			case 61:
				{
				alt78=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(78);}

			switch (alt78) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:518:4: '(' binaryOp metricFExp metricFExp ')'
					{
					dbg.location(518,4);
					char_literal439=(Token)match(input,62,FOLLOW_62_in_metricFExp3324); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal439);
					dbg.location(518,8);
					pushFollow(FOLLOW_binaryOp_in_metricFExp3326);
					binaryOp440=binaryOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binaryOp.add(binaryOp440.getTree());dbg.location(518,17);
					pushFollow(FOLLOW_metricFExp_in_metricFExp3328);
					metricFExp441=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp441.getTree());dbg.location(518,28);
					pushFollow(FOLLOW_metricFExp_in_metricFExp3330);
					metricFExp442=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp442.getTree());dbg.location(518,39);
					char_literal443=(Token)match(input,63,FOLLOW_63_in_metricFExp3332); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal443);

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
					// 519:6: -> ^( BINARY_OP binaryOp metricFExp metricFExp )
					{
						dbg.location(519,9);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:519:9: ^( BINARY_OP binaryOp metricFExp metricFExp )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(519,11);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BINARY_OP, "BINARY_OP"), root_1);
						dbg.location(519,21);
						adaptor.addChild(root_1, stream_binaryOp.nextTree());dbg.location(519,30);
						adaptor.addChild(root_1, stream_metricFExp.nextTree());dbg.location(519,41);
						adaptor.addChild(root_1, stream_metricFExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:4: '(' multiOp metricFExp ( metricFExp )+ ')'
					{
					dbg.location(520,4);
					char_literal444=(Token)match(input,62,FOLLOW_62_in_metricFExp3354); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal444);
					dbg.location(520,8);
					pushFollow(FOLLOW_multiOp_in_metricFExp3356);
					multiOp445=multiOp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_multiOp.add(multiOp445.getTree());dbg.location(520,16);
					pushFollow(FOLLOW_metricFExp_in_metricFExp3358);
					metricFExp446=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp446.getTree());dbg.location(520,27);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:27: ( metricFExp )+
					int cnt77=0;
					try { dbg.enterSubRule(77);

					loop77:
					while (true) {
						int alt77=2;
						try { dbg.enterDecision(77, decisionCanBacktrack[77]);

						int LA77_0 = input.LA(1);
						if ( (LA77_0==NAME||LA77_0==NUMBER||(LA77_0 >= 61 && LA77_0 <= 62)) ) {
							alt77=1;
						}

						} finally {dbg.exitDecision(77);}

						switch (alt77) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:27: metricFExp
							{
							dbg.location(520,27);
							pushFollow(FOLLOW_metricFExp_in_metricFExp3360);
							metricFExp447=metricFExp();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp447.getTree());
							}
							break;

						default :
							if ( cnt77 >= 1 ) break loop77;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(77, input);
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt77++;
					}
					} finally {dbg.exitSubRule(77);}
					dbg.location(520,39);
					char_literal448=(Token)match(input,63,FOLLOW_63_in_metricFExp3363); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal448);

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
					// 521:7: -> ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
					{
						dbg.location(521,10);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:521:10: ^( MULTI_OP multiOp metricFExp ( metricFExp )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(521,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MULTI_OP, "MULTI_OP"), root_1);
						dbg.location(521,21);
						adaptor.addChild(root_1, stream_multiOp.nextTree());dbg.location(521,29);
						adaptor.addChild(root_1, stream_metricFExp.nextTree());dbg.location(521,40);
						if ( !(stream_metricFExp.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_metricFExp.hasNext() ) {
							dbg.location(521,40);
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
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:522:4: '(' '-' metricFExp ')'
					{
					dbg.location(522,4);
					char_literal449=(Token)match(input,62,FOLLOW_62_in_metricFExp3387); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_62.add(char_literal449);
					dbg.location(522,8);
					char_literal450=(Token)match(input,66,FOLLOW_66_in_metricFExp3389); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_66.add(char_literal450);
					dbg.location(522,12);
					pushFollow(FOLLOW_metricFExp_in_metricFExp3391);
					metricFExp451=metricFExp();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_metricFExp.add(metricFExp451.getTree());dbg.location(522,23);
					char_literal452=(Token)match(input,63,FOLLOW_63_in_metricFExp3393); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_63.add(char_literal452);

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
					// 523:4: -> ^( MINUS_OP metricFExp )
					{
						dbg.location(523,7);
						// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:523:7: ^( MINUS_OP metricFExp )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(523,9);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MINUS_OP, "MINUS_OP"), root_1);
						dbg.location(523,18);
						adaptor.addChild(root_1, stream_metricFExp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:524:4: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(524,4);
					NUMBER453=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_metricFExp3410); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER453_tree = (Object)adaptor.create(NUMBER453);
					adaptor.addChild(root_0, NUMBER453_tree);
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:525:4: fHead
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(525,4);
					pushFollow(FOLLOW_fHead_in_metricFExp3415);
					fHead454=fHead();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fHead454.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:527:4: '(' 'is-violated' NAME ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(527,4);
					char_literal455=(Token)match(input,62,FOLLOW_62_in_metricFExp3430); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal455_tree = (Object)adaptor.create(char_literal455);
					adaptor.addChild(root_0, char_literal455_tree);
					}
					dbg.location(527,8);
					string_literal456=(Token)match(input,116,FOLLOW_116_in_metricFExp3432); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal456_tree = (Object)adaptor.create(string_literal456);
					adaptor.addChild(root_0, string_literal456_tree);
					}
					dbg.location(527,22);
					NAME457=(Token)match(input,NAME,FOLLOW_NAME_in_metricFExp3434); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME457_tree = (Object)adaptor.create(NAME457);
					adaptor.addChild(root_0, NAME457_tree);
					}
					dbg.location(527,27);
					char_literal458=(Token)match(input,63,FOLLOW_63_in_metricFExp3436); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal458_tree = (Object)adaptor.create(char_literal458);
					adaptor.addChild(root_0, char_literal458_tree);
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
		dbg.location(528, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "metricFExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:532:1: conGD : ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' );
	public final PddlParser.conGD_return conGD() throws  {
		PddlParser.conGD_return retval = new PddlParser.conGD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal459=null;
		Token string_literal460=null;
		Token char_literal462=null;
		Token char_literal463=null;
		Token string_literal464=null;
		Token char_literal465=null;
		Token char_literal467=null;
		Token char_literal469=null;
		Token char_literal470=null;
		Token string_literal471=null;
		Token string_literal472=null;
		Token char_literal474=null;
		Token char_literal475=null;
		Token string_literal476=null;
		Token char_literal478=null;
		Token char_literal479=null;
		Token string_literal480=null;
		Token char_literal482=null;
		Token char_literal483=null;
		Token string_literal484=null;
		Token NUMBER485=null;
		Token char_literal487=null;
		Token char_literal488=null;
		Token string_literal489=null;
		Token char_literal491=null;
		Token char_literal492=null;
		Token string_literal493=null;
		Token char_literal496=null;
		Token char_literal497=null;
		Token string_literal498=null;
		Token char_literal501=null;
		Token char_literal502=null;
		Token string_literal503=null;
		Token NUMBER504=null;
		Token char_literal507=null;
		Token char_literal508=null;
		Token string_literal509=null;
		Token NUMBER510=null;
		Token NUMBER511=null;
		Token char_literal513=null;
		Token char_literal514=null;
		Token string_literal515=null;
		Token NUMBER516=null;
		Token char_literal518=null;
		ParserRuleReturnScope conGD461 =null;
		ParserRuleReturnScope typedVariableList466 =null;
		ParserRuleReturnScope conGD468 =null;
		ParserRuleReturnScope goalDesc473 =null;
		ParserRuleReturnScope goalDesc477 =null;
		ParserRuleReturnScope goalDesc481 =null;
		ParserRuleReturnScope goalDesc486 =null;
		ParserRuleReturnScope goalDesc490 =null;
		ParserRuleReturnScope goalDesc494 =null;
		ParserRuleReturnScope goalDesc495 =null;
		ParserRuleReturnScope goalDesc499 =null;
		ParserRuleReturnScope goalDesc500 =null;
		ParserRuleReturnScope goalDesc505 =null;
		ParserRuleReturnScope goalDesc506 =null;
		ParserRuleReturnScope goalDesc512 =null;
		ParserRuleReturnScope goalDesc517 =null;

		Object char_literal459_tree=null;
		Object string_literal460_tree=null;
		Object char_literal462_tree=null;
		Object char_literal463_tree=null;
		Object string_literal464_tree=null;
		Object char_literal465_tree=null;
		Object char_literal467_tree=null;
		Object char_literal469_tree=null;
		Object char_literal470_tree=null;
		Object string_literal471_tree=null;
		Object string_literal472_tree=null;
		Object char_literal474_tree=null;
		Object char_literal475_tree=null;
		Object string_literal476_tree=null;
		Object char_literal478_tree=null;
		Object char_literal479_tree=null;
		Object string_literal480_tree=null;
		Object char_literal482_tree=null;
		Object char_literal483_tree=null;
		Object string_literal484_tree=null;
		Object NUMBER485_tree=null;
		Object char_literal487_tree=null;
		Object char_literal488_tree=null;
		Object string_literal489_tree=null;
		Object char_literal491_tree=null;
		Object char_literal492_tree=null;
		Object string_literal493_tree=null;
		Object char_literal496_tree=null;
		Object char_literal497_tree=null;
		Object string_literal498_tree=null;
		Object char_literal501_tree=null;
		Object char_literal502_tree=null;
		Object string_literal503_tree=null;
		Object NUMBER504_tree=null;
		Object char_literal507_tree=null;
		Object char_literal508_tree=null;
		Object string_literal509_tree=null;
		Object NUMBER510_tree=null;
		Object NUMBER511_tree=null;
		Object char_literal513_tree=null;
		Object char_literal514_tree=null;
		Object string_literal515_tree=null;
		Object NUMBER516_tree=null;
		Object char_literal518_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "conGD");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(532, 0);

		try {
			// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:533:2: ( '(' 'and' ( conGD )* ')' | '(' 'forall' '(' typedVariableList ')' conGD ')' | '(' 'at' 'end' goalDesc ')' | '(' 'always' goalDesc ')' | '(' 'sometime' goalDesc ')' | '(' 'within' NUMBER goalDesc ')' | '(' 'at-most-once' goalDesc ')' | '(' 'sometime-after' goalDesc goalDesc ')' | '(' 'sometime-before' goalDesc goalDesc ')' | '(' 'always-within' NUMBER goalDesc goalDesc ')' | '(' 'hold-during' NUMBER NUMBER goalDesc ')' | '(' 'hold-after' NUMBER goalDesc ')' )
			int alt80=12;
			try { dbg.enterDecision(80, decisionCanBacktrack[80]);

			int LA80_0 = input.LA(1);
			if ( (LA80_0==62) ) {
				switch ( input.LA(2) ) {
				case 101:
					{
					alt80=1;
					}
					break;
				case 111:
					{
					alt80=2;
					}
					break;
				case 103:
					{
					alt80=3;
					}
					break;
				case 99:
					{
					alt80=4;
					}
					break;
				case 127:
					{
					alt80=5;
					}
					break;
				case 132:
					{
					alt80=6;
					}
					break;
				case 104:
					{
					alt80=7;
					}
					break;
				case 128:
					{
					alt80=8;
					}
					break;
				case 129:
					{
					alt80=9;
					}
					break;
				case 100:
					{
					alt80=10;
					}
					break;
				case 113:
					{
					alt80=11;
					}
					break;
				case 112:
					{
					alt80=12;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 80, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 80, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(80);}

			switch (alt80) {
				case 1 :
					dbg.enterAlt(1);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:533:4: '(' 'and' ( conGD )* ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(533,4);
					char_literal459=(Token)match(input,62,FOLLOW_62_in_conGD3450); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal459_tree = (Object)adaptor.create(char_literal459);
					adaptor.addChild(root_0, char_literal459_tree);
					}
					dbg.location(533,8);
					string_literal460=(Token)match(input,101,FOLLOW_101_in_conGD3452); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal460_tree = (Object)adaptor.create(string_literal460);
					adaptor.addChild(root_0, string_literal460_tree);
					}
					dbg.location(533,14);
					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:533:14: ( conGD )*
					try { dbg.enterSubRule(79);

					loop79:
					while (true) {
						int alt79=2;
						try { dbg.enterDecision(79, decisionCanBacktrack[79]);

						int LA79_0 = input.LA(1);
						if ( (LA79_0==62) ) {
							alt79=1;
						}

						} finally {dbg.exitDecision(79);}

						switch (alt79) {
						case 1 :
							dbg.enterAlt(1);

							// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:533:14: conGD
							{
							dbg.location(533,14);
							pushFollow(FOLLOW_conGD_in_conGD3454);
							conGD461=conGD();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD461.getTree());

							}
							break;

						default :
							break loop79;
						}
					}
					} finally {dbg.exitSubRule(79);}
					dbg.location(533,21);
					char_literal462=(Token)match(input,63,FOLLOW_63_in_conGD3457); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal462_tree = (Object)adaptor.create(char_literal462);
					adaptor.addChild(root_0, char_literal462_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:534:4: '(' 'forall' '(' typedVariableList ')' conGD ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(534,4);
					char_literal463=(Token)match(input,62,FOLLOW_62_in_conGD3462); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal463_tree = (Object)adaptor.create(char_literal463);
					adaptor.addChild(root_0, char_literal463_tree);
					}
					dbg.location(534,8);
					string_literal464=(Token)match(input,111,FOLLOW_111_in_conGD3464); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal464_tree = (Object)adaptor.create(string_literal464);
					adaptor.addChild(root_0, string_literal464_tree);
					}
					dbg.location(534,17);
					char_literal465=(Token)match(input,62,FOLLOW_62_in_conGD3466); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal465_tree = (Object)adaptor.create(char_literal465);
					adaptor.addChild(root_0, char_literal465_tree);
					}
					dbg.location(534,21);
					pushFollow(FOLLOW_typedVariableList_in_conGD3468);
					typedVariableList466=typedVariableList();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, typedVariableList466.getTree());
					dbg.location(534,39);
					char_literal467=(Token)match(input,63,FOLLOW_63_in_conGD3470); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal467_tree = (Object)adaptor.create(char_literal467);
					adaptor.addChild(root_0, char_literal467_tree);
					}
					dbg.location(534,43);
					pushFollow(FOLLOW_conGD_in_conGD3472);
					conGD468=conGD();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conGD468.getTree());
					dbg.location(534,49);
					char_literal469=(Token)match(input,63,FOLLOW_63_in_conGD3474); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal469_tree = (Object)adaptor.create(char_literal469);
					adaptor.addChild(root_0, char_literal469_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:535:4: '(' 'at' 'end' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(535,4);
					char_literal470=(Token)match(input,62,FOLLOW_62_in_conGD3479); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal470_tree = (Object)adaptor.create(char_literal470);
					adaptor.addChild(root_0, char_literal470_tree);
					}
					dbg.location(535,8);
					string_literal471=(Token)match(input,103,FOLLOW_103_in_conGD3481); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal471_tree = (Object)adaptor.create(string_literal471);
					adaptor.addChild(root_0, string_literal471_tree);
					}
					dbg.location(535,13);
					string_literal472=(Token)match(input,109,FOLLOW_109_in_conGD3483); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal472_tree = (Object)adaptor.create(string_literal472);
					adaptor.addChild(root_0, string_literal472_tree);
					}
					dbg.location(535,19);
					pushFollow(FOLLOW_goalDesc_in_conGD3485);
					goalDesc473=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc473.getTree());
					dbg.location(535,28);
					char_literal474=(Token)match(input,63,FOLLOW_63_in_conGD3487); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal474_tree = (Object)adaptor.create(char_literal474);
					adaptor.addChild(root_0, char_literal474_tree);
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:536:25: '(' 'always' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(536,25);
					char_literal475=(Token)match(input,62,FOLLOW_62_in_conGD3513); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal475_tree = (Object)adaptor.create(char_literal475);
					adaptor.addChild(root_0, char_literal475_tree);
					}
					dbg.location(536,29);
					string_literal476=(Token)match(input,99,FOLLOW_99_in_conGD3515); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal476_tree = (Object)adaptor.create(string_literal476);
					adaptor.addChild(root_0, string_literal476_tree);
					}
					dbg.location(536,38);
					pushFollow(FOLLOW_goalDesc_in_conGD3517);
					goalDesc477=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc477.getTree());
					dbg.location(536,47);
					char_literal478=(Token)match(input,63,FOLLOW_63_in_conGD3519); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal478_tree = (Object)adaptor.create(char_literal478);
					adaptor.addChild(root_0, char_literal478_tree);
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:537:4: '(' 'sometime' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(537,4);
					char_literal479=(Token)match(input,62,FOLLOW_62_in_conGD3524); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal479_tree = (Object)adaptor.create(char_literal479);
					adaptor.addChild(root_0, char_literal479_tree);
					}
					dbg.location(537,8);
					string_literal480=(Token)match(input,127,FOLLOW_127_in_conGD3526); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal480_tree = (Object)adaptor.create(string_literal480);
					adaptor.addChild(root_0, string_literal480_tree);
					}
					dbg.location(537,19);
					pushFollow(FOLLOW_goalDesc_in_conGD3528);
					goalDesc481=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc481.getTree());
					dbg.location(537,28);
					char_literal482=(Token)match(input,63,FOLLOW_63_in_conGD3530); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal482_tree = (Object)adaptor.create(char_literal482);
					adaptor.addChild(root_0, char_literal482_tree);
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:538:5: '(' 'within' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(538,5);
					char_literal483=(Token)match(input,62,FOLLOW_62_in_conGD3536); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal483_tree = (Object)adaptor.create(char_literal483);
					adaptor.addChild(root_0, char_literal483_tree);
					}
					dbg.location(538,9);
					string_literal484=(Token)match(input,132,FOLLOW_132_in_conGD3538); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal484_tree = (Object)adaptor.create(string_literal484);
					adaptor.addChild(root_0, string_literal484_tree);
					}
					dbg.location(538,18);
					NUMBER485=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3540); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER485_tree = (Object)adaptor.create(NUMBER485);
					adaptor.addChild(root_0, NUMBER485_tree);
					}
					dbg.location(538,25);
					pushFollow(FOLLOW_goalDesc_in_conGD3542);
					goalDesc486=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc486.getTree());
					dbg.location(538,34);
					char_literal487=(Token)match(input,63,FOLLOW_63_in_conGD3544); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal487_tree = (Object)adaptor.create(char_literal487);
					adaptor.addChild(root_0, char_literal487_tree);
					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:539:4: '(' 'at-most-once' goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(539,4);
					char_literal488=(Token)match(input,62,FOLLOW_62_in_conGD3549); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal488_tree = (Object)adaptor.create(char_literal488);
					adaptor.addChild(root_0, char_literal488_tree);
					}
					dbg.location(539,8);
					string_literal489=(Token)match(input,104,FOLLOW_104_in_conGD3551); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal489_tree = (Object)adaptor.create(string_literal489);
					adaptor.addChild(root_0, string_literal489_tree);
					}
					dbg.location(539,23);
					pushFollow(FOLLOW_goalDesc_in_conGD3553);
					goalDesc490=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc490.getTree());
					dbg.location(539,32);
					char_literal491=(Token)match(input,63,FOLLOW_63_in_conGD3555); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal491_tree = (Object)adaptor.create(char_literal491);
					adaptor.addChild(root_0, char_literal491_tree);
					}

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:540:4: '(' 'sometime-after' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(540,4);
					char_literal492=(Token)match(input,62,FOLLOW_62_in_conGD3560); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal492_tree = (Object)adaptor.create(char_literal492);
					adaptor.addChild(root_0, char_literal492_tree);
					}
					dbg.location(540,8);
					string_literal493=(Token)match(input,128,FOLLOW_128_in_conGD3562); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal493_tree = (Object)adaptor.create(string_literal493);
					adaptor.addChild(root_0, string_literal493_tree);
					}
					dbg.location(540,25);
					pushFollow(FOLLOW_goalDesc_in_conGD3564);
					goalDesc494=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc494.getTree());
					dbg.location(540,34);
					pushFollow(FOLLOW_goalDesc_in_conGD3566);
					goalDesc495=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc495.getTree());
					dbg.location(540,43);
					char_literal496=(Token)match(input,63,FOLLOW_63_in_conGD3568); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal496_tree = (Object)adaptor.create(char_literal496);
					adaptor.addChild(root_0, char_literal496_tree);
					}

					}
					break;
				case 9 :
					dbg.enterAlt(9);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:541:4: '(' 'sometime-before' goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(541,4);
					char_literal497=(Token)match(input,62,FOLLOW_62_in_conGD3573); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal497_tree = (Object)adaptor.create(char_literal497);
					adaptor.addChild(root_0, char_literal497_tree);
					}
					dbg.location(541,8);
					string_literal498=(Token)match(input,129,FOLLOW_129_in_conGD3575); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal498_tree = (Object)adaptor.create(string_literal498);
					adaptor.addChild(root_0, string_literal498_tree);
					}
					dbg.location(541,26);
					pushFollow(FOLLOW_goalDesc_in_conGD3577);
					goalDesc499=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc499.getTree());
					dbg.location(541,35);
					pushFollow(FOLLOW_goalDesc_in_conGD3579);
					goalDesc500=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc500.getTree());
					dbg.location(541,44);
					char_literal501=(Token)match(input,63,FOLLOW_63_in_conGD3581); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal501_tree = (Object)adaptor.create(char_literal501);
					adaptor.addChild(root_0, char_literal501_tree);
					}

					}
					break;
				case 10 :
					dbg.enterAlt(10);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:542:4: '(' 'always-within' NUMBER goalDesc goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(542,4);
					char_literal502=(Token)match(input,62,FOLLOW_62_in_conGD3586); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal502_tree = (Object)adaptor.create(char_literal502);
					adaptor.addChild(root_0, char_literal502_tree);
					}
					dbg.location(542,8);
					string_literal503=(Token)match(input,100,FOLLOW_100_in_conGD3588); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal503_tree = (Object)adaptor.create(string_literal503);
					adaptor.addChild(root_0, string_literal503_tree);
					}
					dbg.location(542,24);
					NUMBER504=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3590); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER504_tree = (Object)adaptor.create(NUMBER504);
					adaptor.addChild(root_0, NUMBER504_tree);
					}
					dbg.location(542,31);
					pushFollow(FOLLOW_goalDesc_in_conGD3592);
					goalDesc505=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc505.getTree());
					dbg.location(542,40);
					pushFollow(FOLLOW_goalDesc_in_conGD3594);
					goalDesc506=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc506.getTree());
					dbg.location(542,49);
					char_literal507=(Token)match(input,63,FOLLOW_63_in_conGD3596); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal507_tree = (Object)adaptor.create(char_literal507);
					adaptor.addChild(root_0, char_literal507_tree);
					}

					}
					break;
				case 11 :
					dbg.enterAlt(11);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:543:4: '(' 'hold-during' NUMBER NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(543,4);
					char_literal508=(Token)match(input,62,FOLLOW_62_in_conGD3601); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal508_tree = (Object)adaptor.create(char_literal508);
					adaptor.addChild(root_0, char_literal508_tree);
					}
					dbg.location(543,8);
					string_literal509=(Token)match(input,113,FOLLOW_113_in_conGD3603); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal509_tree = (Object)adaptor.create(string_literal509);
					adaptor.addChild(root_0, string_literal509_tree);
					}
					dbg.location(543,22);
					NUMBER510=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3605); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER510_tree = (Object)adaptor.create(NUMBER510);
					adaptor.addChild(root_0, NUMBER510_tree);
					}
					dbg.location(543,29);
					NUMBER511=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3607); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER511_tree = (Object)adaptor.create(NUMBER511);
					adaptor.addChild(root_0, NUMBER511_tree);
					}
					dbg.location(543,36);
					pushFollow(FOLLOW_goalDesc_in_conGD3609);
					goalDesc512=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc512.getTree());
					dbg.location(543,45);
					char_literal513=(Token)match(input,63,FOLLOW_63_in_conGD3611); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal513_tree = (Object)adaptor.create(char_literal513);
					adaptor.addChild(root_0, char_literal513_tree);
					}

					}
					break;
				case 12 :
					dbg.enterAlt(12);

					// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:544:4: '(' 'hold-after' NUMBER goalDesc ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(544,4);
					char_literal514=(Token)match(input,62,FOLLOW_62_in_conGD3616); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal514_tree = (Object)adaptor.create(char_literal514);
					adaptor.addChild(root_0, char_literal514_tree);
					}
					dbg.location(544,8);
					string_literal515=(Token)match(input,112,FOLLOW_112_in_conGD3618); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal515_tree = (Object)adaptor.create(string_literal515);
					adaptor.addChild(root_0, string_literal515_tree);
					}
					dbg.location(544,21);
					NUMBER516=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_conGD3620); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUMBER516_tree = (Object)adaptor.create(NUMBER516);
					adaptor.addChild(root_0, NUMBER516_tree);
					}
					dbg.location(544,28);
					pushFollow(FOLLOW_goalDesc_in_conGD3622);
					goalDesc517=goalDesc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalDesc517.getTree());
					dbg.location(544,37);
					char_literal518=(Token)match(input,63,FOLLOW_63_in_conGD3624); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal518_tree = (Object)adaptor.create(char_literal518);
					adaptor.addChild(root_0, char_literal518_tree);
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
		dbg.location(545, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "conGD");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "conGD"

	// $ANTLR start synpred11_Pddl
	public final void synpred11_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( NAME )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: NAME
		{
		dbg.location(138,8);
		match(input,NAME,FOLLOW_NAME_in_synpred11_Pddl665); if (state.failed) return;
		}

	}
	// $ANTLR end synpred11_Pddl

	// $ANTLR start synpred12_Pddl
	public final void synpred12_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( ( NAME )* )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( NAME )*
		{
		dbg.location(138,8);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: ( NAME )*
		try { dbg.enterSubRule(81);

		loop81:
		while (true) {
			int alt81=2;
			try { dbg.enterDecision(81, decisionCanBacktrack[81]);

			int LA81_0 = input.LA(1);
			if ( (LA81_0==NAME) ) {
				alt81=1;
			}

			} finally {dbg.exitDecision(81);}

			switch (alt81) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:8: NAME
				{
				dbg.location(138,8);
				match(input,NAME,FOLLOW_NAME_in_synpred12_Pddl665); if (state.failed) return;
				}
				break;

			default :
				break loop81;
			}
		}
		} finally {dbg.exitSubRule(81);}

		}

	}
	// $ANTLR end synpred12_Pddl

	// $ANTLR start synpred13_Pddl
	public final void synpred13_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:16: ( singleTypeNameList )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:16: singleTypeNameList
		{
		dbg.location(138,16);
		pushFollow(FOLLOW_singleTypeNameList_in_synpred13_Pddl670);
		singleTypeNameList();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred13_Pddl

	// $ANTLR start synpred14_Pddl
	public final void synpred14_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:36: ( NAME )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:138:36: NAME
		{
		dbg.location(138,36);
		match(input,NAME,FOLLOW_NAME_in_synpred14_Pddl673); if (state.failed) return;
		}

	}
	// $ANTLR end synpred14_Pddl

	// $ANTLR start synpred18_Pddl
	public final void synpred18_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:5: ( atomicFunctionSkeleton )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:160:5: atomicFunctionSkeleton
		{
		dbg.location(160,5);
		pushFollow(FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl802);
		atomicFunctionSkeleton();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred18_Pddl

	// $ANTLR start synpred48_Pddl
	public final void synpred48_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:284:7: ( fComp )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:284:7: fComp
		{
		dbg.location(284,7);
		pushFollow(FOLLOW_fComp_in_synpred48_Pddl1706);
		fComp();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred48_Pddl

	// $ANTLR start synpred51_Pddl
	public final void synpred51_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:307:28: ( typedVariableList )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:307:28: typedVariableList
		{
		dbg.location(307,28);
		pushFollow(FOLLOW_typedVariableList_in_synpred51_Pddl1865);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred51_Pddl

	// $ANTLR start synpred64_Pddl
	public final void synpred64_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:347:4: ( '(' binaryOp fExp fExp2 ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:347:4: '(' binaryOp fExp fExp2 ')'
		{
		dbg.location(347,4);
		match(input,62,FOLLOW_62_in_synpred64_Pddl2121); if (state.failed) return;dbg.location(347,8);
		pushFollow(FOLLOW_binaryOp_in_synpred64_Pddl2123);
		binaryOp();
		state._fsp--;
		if (state.failed) return;dbg.location(347,17);
		pushFollow(FOLLOW_fExp_in_synpred64_Pddl2125);
		fExp();
		state._fsp--;
		if (state.failed) return;dbg.location(347,22);
		pushFollow(FOLLOW_fExp2_in_synpred64_Pddl2127);
		fExp2();
		state._fsp--;
		if (state.failed) return;dbg.location(347,28);
		match(input,63,FOLLOW_63_in_synpred64_Pddl2129); if (state.failed) return;
		}

	}
	// $ANTLR end synpred64_Pddl

	// $ANTLR start synpred65_Pddl
	public final void synpred65_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:348:4: ( '(' '-' fExp ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:348:4: '(' '-' fExp ')'
		{
		dbg.location(348,4);
		match(input,62,FOLLOW_62_in_synpred65_Pddl2146); if (state.failed) return;dbg.location(348,8);
		match(input,66,FOLLOW_66_in_synpred65_Pddl2148); if (state.failed) return;dbg.location(348,12);
		pushFollow(FOLLOW_fExp_in_synpred65_Pddl2150);
		fExp();
		state._fsp--;
		if (state.failed) return;dbg.location(348,17);
		match(input,63,FOLLOW_63_in_synpred65_Pddl2152); if (state.failed) return;
		}

	}
	// $ANTLR end synpred65_Pddl

	// $ANTLR start synpred95_Pddl
	public final void synpred95_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:12: ( NUMBER )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:415:12: NUMBER
		{
		dbg.location(415,12);
		match(input,NUMBER,FOLLOW_NUMBER_in_synpred95_Pddl2595); if (state.failed) return;
		}

	}
	// $ANTLR end synpred95_Pddl

	// $ANTLR start synpred97_Pddl
	public final void synpred97_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:4: ( '(' 'and' ( daEffect )* ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:4: '(' 'and' ( daEffect )* ')'
		{
		dbg.location(418,4);
		match(input,62,FOLLOW_62_in_synpred97_Pddl2609); if (state.failed) return;dbg.location(418,8);
		match(input,101,FOLLOW_101_in_synpred97_Pddl2611); if (state.failed) return;dbg.location(418,14);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:14: ( daEffect )*
		try { dbg.enterSubRule(97);

		loop97:
		while (true) {
			int alt97=2;
			try { dbg.enterDecision(97, decisionCanBacktrack[97]);

			int LA97_0 = input.LA(1);
			if ( (LA97_0==62) ) {
				alt97=1;
			}

			} finally {dbg.exitDecision(97);}

			switch (alt97) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:418:14: daEffect
				{
				dbg.location(418,14);
				pushFollow(FOLLOW_daEffect_in_synpred97_Pddl2613);
				daEffect();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop97;
			}
		}
		} finally {dbg.exitSubRule(97);}
		dbg.location(418,24);
		match(input,63,FOLLOW_63_in_synpred97_Pddl2616); if (state.failed) return;
		}

	}
	// $ANTLR end synpred97_Pddl

	// $ANTLR start synpred98_Pddl
	public final void synpred98_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:419:4: ( timedEffect )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:419:4: timedEffect
		{
		dbg.location(419,4);
		pushFollow(FOLLOW_timedEffect_in_synpred98_Pddl2621);
		timedEffect();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred98_Pddl

	// $ANTLR start synpred99_Pddl
	public final void synpred99_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:420:4: ( '(' 'forall' '(' typedVariableList ')' daEffect ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:420:4: '(' 'forall' '(' typedVariableList ')' daEffect ')'
		{
		dbg.location(420,4);
		match(input,62,FOLLOW_62_in_synpred99_Pddl2626); if (state.failed) return;dbg.location(420,8);
		match(input,111,FOLLOW_111_in_synpred99_Pddl2628); if (state.failed) return;dbg.location(420,17);
		match(input,62,FOLLOW_62_in_synpred99_Pddl2630); if (state.failed) return;dbg.location(420,21);
		pushFollow(FOLLOW_typedVariableList_in_synpred99_Pddl2632);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;dbg.location(420,39);
		match(input,63,FOLLOW_63_in_synpred99_Pddl2634); if (state.failed) return;dbg.location(420,43);
		pushFollow(FOLLOW_daEffect_in_synpred99_Pddl2636);
		daEffect();
		state._fsp--;
		if (state.failed) return;dbg.location(420,52);
		match(input,63,FOLLOW_63_in_synpred99_Pddl2638); if (state.failed) return;
		}

	}
	// $ANTLR end synpred99_Pddl

	// $ANTLR start synpred100_Pddl
	public final void synpred100_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:421:4: ( '(' 'when' daGD timedEffect ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:421:4: '(' 'when' daGD timedEffect ')'
		{
		dbg.location(421,4);
		match(input,62,FOLLOW_62_in_synpred100_Pddl2643); if (state.failed) return;dbg.location(421,8);
		match(input,131,FOLLOW_131_in_synpred100_Pddl2645); if (state.failed) return;dbg.location(421,15);
		pushFollow(FOLLOW_daGD_in_synpred100_Pddl2647);
		daGD();
		state._fsp--;
		if (state.failed) return;dbg.location(421,20);
		pushFollow(FOLLOW_timedEffect_in_synpred100_Pddl2649);
		timedEffect();
		state._fsp--;
		if (state.failed) return;dbg.location(421,32);
		match(input,63,FOLLOW_63_in_synpred100_Pddl2651); if (state.failed) return;
		}

	}
	// $ANTLR end synpred100_Pddl

	// $ANTLR start synpred101_Pddl
	public final void synpred101_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:426:4: ( '(' 'at' timeSpecifier daEffect ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:426:4: '(' 'at' timeSpecifier daEffect ')'
		{
		dbg.location(426,4);
		match(input,62,FOLLOW_62_in_synpred101_Pddl2675); if (state.failed) return;dbg.location(426,8);
		match(input,103,FOLLOW_103_in_synpred101_Pddl2677); if (state.failed) return;dbg.location(426,13);
		pushFollow(FOLLOW_timeSpecifier_in_synpred101_Pddl2679);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;dbg.location(426,27);
		pushFollow(FOLLOW_daEffect_in_synpred101_Pddl2681);
		daEffect();
		state._fsp--;
		if (state.failed) return;dbg.location(426,36);
		match(input,63,FOLLOW_63_in_synpred101_Pddl2683); if (state.failed) return;
		}

	}
	// $ANTLR end synpred101_Pddl

	// $ANTLR start synpred102_Pddl
	public final void synpred102_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:427:4: ( '(' 'at' timeSpecifier fAssignDA ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:427:4: '(' 'at' timeSpecifier fAssignDA ')'
		{
		dbg.location(427,4);
		match(input,62,FOLLOW_62_in_synpred102_Pddl2693); if (state.failed) return;dbg.location(427,8);
		match(input,103,FOLLOW_103_in_synpred102_Pddl2695); if (state.failed) return;dbg.location(427,13);
		pushFollow(FOLLOW_timeSpecifier_in_synpred102_Pddl2697);
		timeSpecifier();
		state._fsp--;
		if (state.failed) return;dbg.location(427,27);
		pushFollow(FOLLOW_fAssignDA_in_synpred102_Pddl2699);
		fAssignDA();
		state._fsp--;
		if (state.failed) return;dbg.location(427,37);
		match(input,63,FOLLOW_63_in_synpred102_Pddl2701); if (state.failed) return;
		}

	}
	// $ANTLR end synpred102_Pddl

	// $ANTLR start synpred103_Pddl
	public final void synpred103_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( ( binaryOp fExpDA fExpDA ) )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
		{
		dbg.location(436,9);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:10: binaryOp fExpDA fExpDA
		{
		dbg.location(436,10);
		pushFollow(FOLLOW_binaryOp_in_synpred103_Pddl2757);
		binaryOp();
		state._fsp--;
		if (state.failed) return;dbg.location(436,19);
		pushFollow(FOLLOW_fExpDA_in_synpred103_Pddl2759);
		fExpDA();
		state._fsp--;
		if (state.failed) return;dbg.location(436,26);
		pushFollow(FOLLOW_fExpDA_in_synpred103_Pddl2761);
		fExpDA();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred103_Pddl

	// $ANTLR start synpred104_Pddl
	public final void synpred104_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:4: ( '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:4: '(' ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) ) ')'
		{
		dbg.location(436,4);
		match(input,62,FOLLOW_62_in_synpred104_Pddl2753); if (state.failed) return;dbg.location(436,8);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:8: ( ( binaryOp fExpDA fExpDA ) | ( '-' fExpDA ) )
		int alt98=2;
		try { dbg.enterSubRule(98);
		try { dbg.enterDecision(98, decisionCanBacktrack[98]);

		int LA98_0 = input.LA(1);
		if ( (LA98_0==66) ) {
			int LA98_1 = input.LA(2);
			if ( (synpred103_Pddl()) ) {
				alt98=1;
			}
			else if ( (true) ) {
				alt98=2;
			}

		}
		else if ( ((LA98_0 >= 64 && LA98_0 <= 65)||LA98_0==67||LA98_0==97) ) {
			alt98=1;
		}

		else {
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 98, 0, input);
			dbg.recognitionException(nvae);
			throw nvae;
		}

		} finally {dbg.exitDecision(98);}

		switch (alt98) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
				{
				dbg.location(436,9);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:9: ( binaryOp fExpDA fExpDA )
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:10: binaryOp fExpDA fExpDA
				{
				dbg.location(436,10);
				pushFollow(FOLLOW_binaryOp_in_synpred104_Pddl2757);
				binaryOp();
				state._fsp--;
				if (state.failed) return;dbg.location(436,19);
				pushFollow(FOLLOW_fExpDA_in_synpred104_Pddl2759);
				fExpDA();
				state._fsp--;
				if (state.failed) return;dbg.location(436,26);
				pushFollow(FOLLOW_fExpDA_in_synpred104_Pddl2761);
				fExpDA();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;
			case 2 :
				dbg.enterAlt(2);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:36: ( '-' fExpDA )
				{
				dbg.location(436,36);
				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:36: ( '-' fExpDA )
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:436:37: '-' fExpDA
				{
				dbg.location(436,37);
				match(input,66,FOLLOW_66_in_synpred104_Pddl2767); if (state.failed) return;dbg.location(436,41);
				pushFollow(FOLLOW_fExpDA_in_synpred104_Pddl2769);
				fExpDA();
				state._fsp--;
				if (state.failed) return;
				}

				}
				break;

		}
		} finally {dbg.exitSubRule(98);}
		dbg.location(436,50);
		match(input,63,FOLLOW_63_in_synpred104_Pddl2773); if (state.failed) return;
		}

	}
	// $ANTLR end synpred104_Pddl

	// $ANTLR start synpred110_Pddl
	public final void synpred110_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:20: ( typedNameList )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:469:20: typedNameList
		{
		dbg.location(469,20);
		pushFollow(FOLLOW_typedNameList_in_synpred110_Pddl2993);
		typedNameList();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred110_Pddl

	// $ANTLR start synpred117_Pddl
	public final void synpred117_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:4: ( '(' 'and' ( prefConGD )* ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:4: '(' 'and' ( prefConGD )* ')'
		{
		dbg.location(504,4);
		match(input,62,FOLLOW_62_in_synpred117_Pddl3225); if (state.failed) return;dbg.location(504,8);
		match(input,101,FOLLOW_101_in_synpred117_Pddl3227); if (state.failed) return;dbg.location(504,14);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:14: ( prefConGD )*
		try { dbg.enterSubRule(99);

		loop99:
		while (true) {
			int alt99=2;
			try { dbg.enterDecision(99, decisionCanBacktrack[99]);

			int LA99_0 = input.LA(1);
			if ( (LA99_0==62) ) {
				alt99=1;
			}

			} finally {dbg.exitDecision(99);}

			switch (alt99) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:504:14: prefConGD
				{
				dbg.location(504,14);
				pushFollow(FOLLOW_prefConGD_in_synpred117_Pddl3229);
				prefConGD();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				break loop99;
			}
		}
		} finally {dbg.exitSubRule(99);}
		dbg.location(504,25);
		match(input,63,FOLLOW_63_in_synpred117_Pddl3232); if (state.failed) return;
		}

	}
	// $ANTLR end synpred117_Pddl

	// $ANTLR start synpred118_Pddl
	public final void synpred118_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:505:4: ( '(' 'forall' '(' typedVariableList ')' prefConGD ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:505:4: '(' 'forall' '(' typedVariableList ')' prefConGD ')'
		{
		dbg.location(505,4);
		match(input,62,FOLLOW_62_in_synpred118_Pddl3237); if (state.failed) return;dbg.location(505,8);
		match(input,111,FOLLOW_111_in_synpred118_Pddl3239); if (state.failed) return;dbg.location(505,17);
		match(input,62,FOLLOW_62_in_synpred118_Pddl3241); if (state.failed) return;dbg.location(505,21);
		pushFollow(FOLLOW_typedVariableList_in_synpred118_Pddl3243);
		typedVariableList();
		state._fsp--;
		if (state.failed) return;dbg.location(505,39);
		match(input,63,FOLLOW_63_in_synpred118_Pddl3245); if (state.failed) return;dbg.location(505,43);
		pushFollow(FOLLOW_prefConGD_in_synpred118_Pddl3247);
		prefConGD();
		state._fsp--;
		if (state.failed) return;dbg.location(505,53);
		match(input,63,FOLLOW_63_in_synpred118_Pddl3249); if (state.failed) return;
		}

	}
	// $ANTLR end synpred118_Pddl

	// $ANTLR start synpred120_Pddl
	public final void synpred120_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:4: ( '(' 'preference' ( NAME )? conGD ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:4: '(' 'preference' ( NAME )? conGD ')'
		{
		dbg.location(506,4);
		match(input,62,FOLLOW_62_in_synpred120_Pddl3254); if (state.failed) return;dbg.location(506,8);
		match(input,123,FOLLOW_123_in_synpred120_Pddl3256); if (state.failed) return;dbg.location(506,21);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:21: ( NAME )?
		int alt100=2;
		try { dbg.enterSubRule(100);
		try { dbg.enterDecision(100, decisionCanBacktrack[100]);

		int LA100_0 = input.LA(1);
		if ( (LA100_0==NAME) ) {
			alt100=1;
		}
		} finally {dbg.exitDecision(100);}

		switch (alt100) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:506:21: NAME
				{
				dbg.location(506,21);
				match(input,NAME,FOLLOW_NAME_in_synpred120_Pddl3258); if (state.failed) return;
				}
				break;

		}
		} finally {dbg.exitSubRule(100);}
		dbg.location(506,27);
		pushFollow(FOLLOW_conGD_in_synpred120_Pddl3261);
		conGD();
		state._fsp--;
		if (state.failed) return;dbg.location(506,33);
		match(input,63,FOLLOW_63_in_synpred120_Pddl3263); if (state.failed) return;
		}

	}
	// $ANTLR end synpred120_Pddl

	// $ANTLR start synpred122_Pddl
	public final void synpred122_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:518:4: ( '(' binaryOp metricFExp metricFExp ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:518:4: '(' binaryOp metricFExp metricFExp ')'
		{
		dbg.location(518,4);
		match(input,62,FOLLOW_62_in_synpred122_Pddl3324); if (state.failed) return;dbg.location(518,8);
		pushFollow(FOLLOW_binaryOp_in_synpred122_Pddl3326);
		binaryOp();
		state._fsp--;
		if (state.failed) return;dbg.location(518,17);
		pushFollow(FOLLOW_metricFExp_in_synpred122_Pddl3328);
		metricFExp();
		state._fsp--;
		if (state.failed) return;dbg.location(518,28);
		pushFollow(FOLLOW_metricFExp_in_synpred122_Pddl3330);
		metricFExp();
		state._fsp--;
		if (state.failed) return;dbg.location(518,39);
		match(input,63,FOLLOW_63_in_synpred122_Pddl3332); if (state.failed) return;
		}

	}
	// $ANTLR end synpred122_Pddl

	// $ANTLR start synpred124_Pddl
	public final void synpred124_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:4: ( '(' multiOp metricFExp ( metricFExp )+ ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:4: '(' multiOp metricFExp ( metricFExp )+ ')'
		{
		dbg.location(520,4);
		match(input,62,FOLLOW_62_in_synpred124_Pddl3354); if (state.failed) return;dbg.location(520,8);
		pushFollow(FOLLOW_multiOp_in_synpred124_Pddl3356);
		multiOp();
		state._fsp--;
		if (state.failed) return;dbg.location(520,16);
		pushFollow(FOLLOW_metricFExp_in_synpred124_Pddl3358);
		metricFExp();
		state._fsp--;
		if (state.failed) return;dbg.location(520,27);
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:27: ( metricFExp )+
		int cnt101=0;
		try { dbg.enterSubRule(101);

		loop101:
		while (true) {
			int alt101=2;
			try { dbg.enterDecision(101, decisionCanBacktrack[101]);

			int LA101_0 = input.LA(1);
			if ( (LA101_0==NAME||LA101_0==NUMBER||(LA101_0 >= 61 && LA101_0 <= 62)) ) {
				alt101=1;
			}

			} finally {dbg.exitDecision(101);}

			switch (alt101) {
			case 1 :
				dbg.enterAlt(1);

				// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:520:27: metricFExp
				{
				dbg.location(520,27);
				pushFollow(FOLLOW_metricFExp_in_synpred124_Pddl3360);
				metricFExp();
				state._fsp--;
				if (state.failed) return;
				}
				break;

			default :
				if ( cnt101 >= 1 ) break loop101;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(101, input);
				dbg.recognitionException(eee);

				throw eee;
			}
			cnt101++;
		}
		} finally {dbg.exitSubRule(101);}
		dbg.location(520,39);
		match(input,63,FOLLOW_63_in_synpred124_Pddl3363); if (state.failed) return;
		}

	}
	// $ANTLR end synpred124_Pddl

	// $ANTLR start synpred125_Pddl
	public final void synpred125_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:522:4: ( '(' '-' metricFExp ')' )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:522:4: '(' '-' metricFExp ')'
		{
		dbg.location(522,4);
		match(input,62,FOLLOW_62_in_synpred125_Pddl3387); if (state.failed) return;dbg.location(522,8);
		match(input,66,FOLLOW_66_in_synpred125_Pddl3389); if (state.failed) return;dbg.location(522,12);
		pushFollow(FOLLOW_metricFExp_in_synpred125_Pddl3391);
		metricFExp();
		state._fsp--;
		if (state.failed) return;dbg.location(522,23);
		match(input,63,FOLLOW_63_in_synpred125_Pddl3393); if (state.failed) return;
		}

	}
	// $ANTLR end synpred125_Pddl

	// $ANTLR start synpred127_Pddl
	public final void synpred127_Pddl_fragment() throws  {
		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:525:4: ( fHead )
		dbg.enterAlt(1);

		// /home/enrico/Scrivania/Dropbox/plan_exec_2_0/ppmajal2/grammar/Pddl.g:525:4: fHead
		{
		dbg.location(525,4);
		pushFollow(FOLLOW_fHead_in_synpred127_Pddl3415);
		fHead();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred127_Pddl

	// Delegated rules

	public final boolean synpred120_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred120_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred13_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred101_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred101_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred97_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred97_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred12_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred51_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred51_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred103_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred103_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred99_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred99_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred100_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred100_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred104_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred104_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred118_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred118_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred14_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred95_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred95_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred122_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred122_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred125_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred125_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred65_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred65_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred127_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred127_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred117_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred117_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred124_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred124_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred18_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred18_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred98_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred98_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred64_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred64_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred11_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred48_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred48_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred110_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred110_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred102_Pddl() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred102_Pddl_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA25 dfa25 = new DFA25(this);
	protected DFA23 dfa23 = new DFA23(this);
	static final String DFA25_eotS =
		"\4\uffff";
	static final String DFA25_eofS =
		"\2\2\2\uffff";
	static final String DFA25_minS =
		"\2\72\2\uffff";
	static final String DFA25_maxS =
		"\1\77\1\102\2\uffff";
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
			return "189:7: ( ( VARIABLE )* | ( singleTypeVarList )+ ( VARIABLE )* )";
		}
		public void error(NoViableAltException nvae) {
			dbg.recognitionException(nvae);
		}
	}

	static final String DFA23_eotS =
		"\4\uffff";
	static final String DFA23_eofS =
		"\2\2\2\uffff";
	static final String DFA23_minS =
		"\2\72\2\uffff";
	static final String DFA23_maxS =
		"\1\77\1\102\2\uffff";
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
			return "()+ loopback of 189:20: ( singleTypeVarList )+";
		}
		public void error(NoViableAltException nvae) {
			dbg.recognitionException(nvae);
		}
	}

	public static final BitSet FOLLOW_domain_in_pddlDoc355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_problem_in_pddlDoc359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_domain374 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_106_in_domain376 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_domainName_in_domain378 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_requireDef_in_domain386 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_typesDef_in_domain395 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_constantsDef_in_domain404 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_predicatesDef_in_domain413 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_functionsDef_in_domain422 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_free_functionsDef_in_domain431 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_constraints_in_domain440 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_structureDef_in_domain449 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_domain458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_free_functionsDef542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_free_functionsDef544 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_functionList_in_free_functionsDef546 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_free_functionsDef548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_domainName571 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_domainName573 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NAME_in_domainName575 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_domainName577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_requireDef604 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_requireDef606 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_requireDef608 = new BitSet(new long[]{0x8080000000000000L});
	public static final BitSet FOLLOW_63_in_requireDef611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_typesDef632 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_typesDef634 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_typedNameList_in_typesDef636 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_typesDef638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList665 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_typedNameList670 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_NAME_in_typedNameList673 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_NAME_in_singleTypeNameList693 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_singleTypeNameList696 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_type_in_singleTypeNameList700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_type727 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_type729 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_primType_in_type731 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_63_in_type734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primType_in_type755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_primType765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_functionsDef775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_functionsDef777 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_functionList_in_functionsDef779 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_functionsDef781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_functionList802 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_functionList806 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_functionType_in_functionList808 = new BitSet(new long[]{0x4000000000000002L});
	public static final BitSet FOLLOW_62_in_atomicFunctionSkeleton824 = new BitSet(new long[]{0x2000002000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_atomicFunctionSkeleton827 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFunctionSkeleton830 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_atomicFunctionSkeleton832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_120_in_functionType855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_constantsDef866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_constantsDef868 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_typedNameList_in_constantsDef870 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_constantsDef872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_predicatesDef892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_87_in_predicatesDef894 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_atomicFormulaSkeleton_in_predicatesDef896 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_predicatesDef899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_atomicFormulaSkeleton920 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicFormulaSkeleton923 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_atomicFormulaSkeleton926 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_atomicFormulaSkeleton928 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList954 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_singleTypeVarList_in_typedVariableList959 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typedVariableList962 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_singleTypeVarList982 = new BitSet(new long[]{0x0400000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_singleTypeVarList985 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_type_in_singleTypeVarList989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_constraints1020 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_constraints1023 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_conGD_in_constraints1026 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_constraints1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actionDef_in_structureDef1040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_durativeActionDef_in_structureDef1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_derivedDef_in_structureDef1050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraintDef_in_structureDef1055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_processDef_in_structureDef1060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eventDef_in_structureDef1065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_actionDef1080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_actionDef1082 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_actionDef1084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_actionDef1093 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_actionDef1096 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_actionDef1098 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_actionDef1100 = new BitSet(new long[]{0x8000000000000000L,0x0000000000402000L});
	public static final BitSet FOLLOW_actionDefBody_in_actionDef1113 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_actionDef1115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_eventDef1148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_eventDef1150 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_eventDef1152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_eventDef1161 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_eventDef1164 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_eventDef1166 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_eventDef1168 = new BitSet(new long[]{0x8000000000000000L,0x0000000000402000L});
	public static final BitSet FOLLOW_actionDefBody_in_eventDef1181 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_eventDef1183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_processDef1216 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_processDef1218 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_processDef1220 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_processDef1229 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_processDef1232 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_processDef1234 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_processDef1236 = new BitSet(new long[]{0x8000000000000000L,0x0000000000402000L});
	public static final BitSet FOLLOW_actionDefBody_in_processDef1249 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_processDef1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_constraintDef1285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_constraintDef1287 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_constraintSymbol_in_constraintDef1289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_constraintDef1298 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_constraintDef1301 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_constraintDef1303 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_constraintDef1305 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_constraintDefBody_in_constraintDef1318 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_constraintDef1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_actionSymbol1354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_constraintSymbol1363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_actionDefBody1378 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_actionDefBody1382 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_actionDefBody1384 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_goalDesc_in_actionDefBody1389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_actionDefBody1399 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_actionDefBody1403 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_actionDefBody1405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effect_in_actionDefBody1410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_constraintDefBody1445 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_constraintDefBody1449 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_constraintDefBody1451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goalDesc_in_constraintDefBody1456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_goalDesc1494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1499 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_goalDesc1501 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1503 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1531 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
	public static final BitSet FOLLOW_121_in_goalDesc1533 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1535 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1563 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_goalDesc1565 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1567 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1593 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_114_in_goalDesc1595 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1597 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1599 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1627 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_110_in_goalDesc1629 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_goalDesc1631 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1633 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1635 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1637 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goalDesc1665 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_goalDesc1667 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_goalDesc1669 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_goalDesc1671 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1673 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goalDesc1675 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goalDesc1677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_goalDesc1706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equality_in_goalDesc1733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_equality1761 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_93_in_equality1764 = new BitSet(new long[]{0x0400002000000000L});
	public static final BitSet FOLLOW_term_in_equality1766 = new BitSet(new long[]{0x0400002000000000L});
	public static final BitSet FOLLOW_term_in_equality1768 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_equality1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fComp1781 = new BitSet(new long[]{0x0000000000000000L,0x00000000F8000000L});
	public static final BitSet FOLLOW_binaryComp_in_fComp1784 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1786 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_fComp1788 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fComp1790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_atomicTermFormula1802 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicTermFormula1804 = new BitSet(new long[]{0x8400002000000000L});
	public static final BitSet FOLLOW_term_in_atomicTermFormula1806 = new BitSet(new long[]{0x8400002000000000L});
	public static final BitSet FOLLOW_63_in_atomicTermFormula1809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_durativeActionDef1846 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_76_in_durativeActionDef1848 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_actionSymbol_in_durativeActionDef1850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_durativeActionDef1859 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_durativeActionDef1862 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_durativeActionDef1865 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_durativeActionDef1869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002820L});
	public static final BitSet FOLLOW_daDefBody_in_durativeActionDef1882 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_durativeActionDef1884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_daDefBody1917 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_durationConstraint_in_daDefBody1919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_daDefBody1924 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_daDefBody1928 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daDefBody1930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daGD_in_daDefBody1935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_daDefBody1944 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_daDefBody1948 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daDefBody1950 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_daEffect_in_daDefBody1955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prefTimedGD_in_daGD1970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daGD1975 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_daGD1977 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1979 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_daGD1982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daGD1987 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_daGD1989 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_daGD1991 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daGD1993 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daGD1995 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daGD_in_daGD1997 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daGD1999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_prefTimedGD2015 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_prefTimedGD2017 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_NAME_in_prefTimedGD2019 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_timedGD_in_prefTimedGD2022 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_prefTimedGD2024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_timedGD2035 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_timedGD2037 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedGD2039 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2041 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_timedGD2043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_timedGD2048 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_122_in_timedGD2050 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_interval_in_timedGD2052 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_timedGD2054 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_timedGD2056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_98_in_interval2078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_derivedDef2091 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_derivedDef2094 = new BitSet(new long[]{0x4400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_derivedDef2097 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_derivedDef2099 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_derivedDef2101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_fExp2116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fExp2121 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_fExp2123 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_fExp2125 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp2_in_fExp2127 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fExp2129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fExp2146 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_fExp2148 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_fExp2150 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fExp2152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_fExp2165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExp22177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fHead2187 = new BitSet(new long[]{0x2000002000000000L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2189 = new BitSet(new long[]{0x8400002000000000L});
	public static final BitSet FOLLOW_term_in_fHead2191 = new BitSet(new long[]{0x8400002000000000L});
	public static final BitSet FOLLOW_63_in_fHead2194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionSymbol_in_fHead2210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_effect2229 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_effect2231 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_cEffect_in_effect2233 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_effect2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cEffect_in_effect2250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_cEffect2261 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_cEffect2263 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_cEffect2265 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_cEffect2267 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_cEffect2269 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_effect_in_cEffect2271 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_cEffect2273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_cEffect2291 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_cEffect2293 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_cEffect2295 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_condEffect_in_cEffect2297 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_cEffect2299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_cEffect2317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_pEffect2328 = new BitSet(new long[]{0x0000000000000000L,0x6008024000000000L});
	public static final BitSet FOLLOW_assignOp_in_pEffect2330 = new BitSet(new long[]{0x6000002000000000L});
	public static final BitSet FOLLOW_fHead_in_pEffect2332 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_pEffect2334 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_pEffect2336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_pEffect2356 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_pEffect2358 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2360 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_pEffect2362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicTermFormula_in_pEffect2378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_condEffect2391 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_condEffect2393 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2395 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_condEffect2398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pEffect_in_condEffect2412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_durationConstraint2517 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_durationConstraint2519 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2521 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_durationConstraint2524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_durationConstraint2529 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_durationConstraint2531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_durationConstraint2536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_simpleDurationConstraint2547 = new BitSet(new long[]{0x0000000000000000L,0x00000000B0000000L});
	public static final BitSet FOLLOW_durOp_in_simpleDurationConstraint2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_96_in_simpleDurationConstraint2551 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_durValue_in_simpleDurationConstraint2553 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_simpleDurationConstraint2555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_simpleDurationConstraint2560 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_simpleDurationConstraint2562 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_simpleDurationConstraint2564 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_simpleDurationConstraint_in_simpleDurationConstraint2566 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_simpleDurationConstraint2568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_durValue2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_durValue2599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daEffect2609 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_daEffect2611 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2613 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_daEffect2616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daEffect2626 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_daEffect2628 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_daEffect2630 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_daEffect2632 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daEffect2634 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_daEffect2636 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daEffect2638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daEffect2643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_daEffect2645 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daGD_in_daEffect2647 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_daEffect2649 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daEffect2651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_daEffect2656 = new BitSet(new long[]{0x0000000000000000L,0x6008024000000000L});
	public static final BitSet FOLLOW_assignOp_in_daEffect2658 = new BitSet(new long[]{0x6000002000000000L});
	public static final BitSet FOLLOW_fHead_in_daEffect2660 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_daEffect2662 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_daEffect2664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_timedEffect2675 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_timedEffect2677 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2679 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_timedEffect2681 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_timedEffect2683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_timedEffect2693 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_timedEffect2695 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_timedEffect2697 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_timedEffect2699 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_timedEffect2701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_timedEffect2706 = new BitSet(new long[]{0x0000000000000000L,0x6008024000000000L});
	public static final BitSet FOLLOW_assignOp_in_timedEffect2708 = new BitSet(new long[]{0x6000002000000000L});
	public static final BitSet FOLLOW_fHead_in_timedEffect2710 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_timedEffect2712 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_timedEffect2714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fAssignDA2734 = new BitSet(new long[]{0x0000000000000000L,0x6008024000000000L});
	public static final BitSet FOLLOW_assignOp_in_fAssignDA2736 = new BitSet(new long[]{0x6000002000000000L});
	public static final BitSet FOLLOW_fHead_in_fAssignDA2738 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_fAssignDA2740 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fAssignDA2742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_fExpDA2753 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_fExpDA2757 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2759 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2761 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_66_in_fExpDA2767 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_fExpDA2769 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_fExpDA2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_96_in_fExpDA2778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fExp_in_fExpDA2783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_problem2797 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_106_in_problem2799 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_problemDecl_in_problem2801 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_problemDomain_in_problem2806 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_requireDef_in_problem2814 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_objectDecl_in_problem2823 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_init_in_problem2832 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goal_in_problem2840 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_probConstraints_in_problem2848 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_metricSpec_in_problem2857 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_problem2873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_problemDecl2930 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_124_in_problemDecl2932 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDecl2934 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_problemDecl2936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_problemDomain2962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_74_in_problemDomain2964 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NAME_in_problemDomain2966 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_problemDomain2968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_objectDecl2988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_objectDecl2990 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_typedNameList_in_objectDecl2993 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_63_in_objectDecl2996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_init3016 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_init3018 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_initEl_in_init3020 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_init3023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_initEl3049 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_93_in_initEl3051 = new BitSet(new long[]{0x6000002000000000L});
	public static final BitSet FOLLOW_fHead_in_initEl3053 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3055 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_initEl3057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_initEl3080 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_initEl3082 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_initEl3084 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_nameLiteral_in_initEl3086 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_initEl3088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_nameLiteral3115 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_nameLiteral3117 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_atomicNameFormula_in_nameLiteral3119 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_nameLiteral3121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_atomicNameFormula3140 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_predicate_in_atomicNameFormula3142 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_NAME_in_atomicNameFormula3144 = new BitSet(new long[]{0x8000002000000000L});
	public static final BitSet FOLLOW_63_in_atomicNameFormula3147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_goal3172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_81_in_goal3174 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_goal3176 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_goal3178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_probConstraints3196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_probConstraints3198 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_probConstraints3201 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_probConstraints3203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_prefConGD3225 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_prefConGD3227 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3229 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_prefConGD3232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_prefConGD3237 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_prefConGD3239 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_prefConGD3241 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_prefConGD3243 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_prefConGD3245 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_prefConGD3247 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_prefConGD3249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_prefConGD3254 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_prefConGD3256 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_NAME_in_prefConGD3258 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3261 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_prefConGD3263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conGD_in_prefConGD3268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_metricSpec3279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_83_in_metricSpec3281 = new BitSet(new long[]{0x0000000000000000L,0x0060000000000000L});
	public static final BitSet FOLLOW_optimization_in_metricSpec3283 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricSpec3285 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_metricSpec3287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_metricFExp3324 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_metricFExp3326 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3328 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3330 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_metricFExp3332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_metricFExp3354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_multiOp_in_metricFExp3356 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3358 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3360 = new BitSet(new long[]{0xE000022000000000L});
	public static final BitSet FOLLOW_63_in_metricFExp3363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_metricFExp3387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_metricFExp3389 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_metricFExp3391 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_metricFExp3393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_metricFExp3410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_metricFExp3415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_metricFExp3430 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_116_in_metricFExp3432 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_NAME_in_metricFExp3434 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_metricFExp3436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3450 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_conGD3452 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3454 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3462 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_conGD3464 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_conGD3466 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_conGD3468 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3470 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_conGD_in_conGD3472 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3479 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_conGD3481 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_conGD3483 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3485 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3513 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_conGD3515 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3517 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3524 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_127_in_conGD3526 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3528 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_132_in_conGD3538 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3540 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3542 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3549 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_conGD3551 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3553 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_128_in_conGD3562 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3564 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3566 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3573 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_129_in_conGD3575 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3577 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3579 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3586 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_conGD3588 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3590 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3592 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3594 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3601 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_conGD3603 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3605 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3607 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3609 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_conGD3616 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_conGD3618 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_NUMBER_in_conGD3620 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_goalDesc_in_conGD3622 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_conGD3624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_synpred11_Pddl665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_synpred12_Pddl665 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_singleTypeNameList_in_synpred13_Pddl670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_synpred14_Pddl673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomicFunctionSkeleton_in_synpred18_Pddl802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fComp_in_synpred48_Pddl1706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred51_Pddl1865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred64_Pddl2121 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_synpred64_Pddl2123 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_synpred64_Pddl2125 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp2_in_synpred64_Pddl2127 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred64_Pddl2129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred65_Pddl2146 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_synpred65_Pddl2148 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_fExp_in_synpred65_Pddl2150 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred65_Pddl2152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_synpred95_Pddl2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred97_Pddl2609 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_synpred97_Pddl2611 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred97_Pddl2613 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred97_Pddl2616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timedEffect_in_synpred98_Pddl2621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred99_Pddl2626 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_synpred99_Pddl2628 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_synpred99_Pddl2630 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred99_Pddl2632 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred99_Pddl2634 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred99_Pddl2636 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred99_Pddl2638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred100_Pddl2643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_131_in_synpred100_Pddl2645 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daGD_in_synpred100_Pddl2647 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_timedEffect_in_synpred100_Pddl2649 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred100_Pddl2651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred101_Pddl2675 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_synpred101_Pddl2677 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred101_Pddl2679 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_daEffect_in_synpred101_Pddl2681 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred101_Pddl2683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred102_Pddl2693 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_synpred102_Pddl2695 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_timeSpecifier_in_synpred102_Pddl2697 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_fAssignDA_in_synpred102_Pddl2699 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred102_Pddl2701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binaryOp_in_synpred103_Pddl2757 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred103_Pddl2759 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred103_Pddl2761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred104_Pddl2753 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_synpred104_Pddl2757 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred104_Pddl2759 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred104_Pddl2761 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_66_in_synpred104_Pddl2767 = new BitSet(new long[]{0x6000022000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_fExpDA_in_synpred104_Pddl2769 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred104_Pddl2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_typedNameList_in_synpred110_Pddl2993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred117_Pddl3225 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_101_in_synpred117_Pddl3227 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred117_Pddl3229 = new BitSet(new long[]{0xC000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred117_Pddl3232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred118_Pddl3237 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_111_in_synpred118_Pddl3239 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_synpred118_Pddl3241 = new BitSet(new long[]{0x8400000000000000L});
	public static final BitSet FOLLOW_typedVariableList_in_synpred118_Pddl3243 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred118_Pddl3245 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_prefConGD_in_synpred118_Pddl3247 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred118_Pddl3249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred120_Pddl3254 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_synpred120_Pddl3256 = new BitSet(new long[]{0x4000002000000000L});
	public static final BitSet FOLLOW_NAME_in_synpred120_Pddl3258 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_conGD_in_synpred120_Pddl3261 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred120_Pddl3263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred122_Pddl3324 = new BitSet(new long[]{0x0000000000000000L,0x000000020000000FL});
	public static final BitSet FOLLOW_binaryOp_in_synpred122_Pddl3326 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred122_Pddl3328 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred122_Pddl3330 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred122_Pddl3332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred124_Pddl3354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
	public static final BitSet FOLLOW_multiOp_in_synpred124_Pddl3356 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred124_Pddl3358 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred124_Pddl3360 = new BitSet(new long[]{0xE000022000000000L});
	public static final BitSet FOLLOW_63_in_synpred124_Pddl3363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_synpred125_Pddl3387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_synpred125_Pddl3389 = new BitSet(new long[]{0x6000022000000000L});
	public static final BitSet FOLLOW_metricFExp_in_synpred125_Pddl3391 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_synpred125_Pddl3393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fHead_in_synpred127_Pddl3415 = new BitSet(new long[]{0x0000000000000002L});
}
