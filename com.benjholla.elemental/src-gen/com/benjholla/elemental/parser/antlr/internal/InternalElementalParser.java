package com.benjholla.elemental.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.benjholla.elemental.services.ElementalGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalElementalParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_COMMENT", "RULE_WHITESPACE", "RULE_ANY_OTHER", "':'", "'+'", "'-'", "'<'", "'>'", "','", "'.'", "'='", "'('", "')'", "'['", "']'", "'\\''", "'&'", "'{'", "'}'", "'?'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_WHITESPACE=6;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ID=4;
    public static final int RULE_COMMENT=5;
    public static final int RULE_ANY_OTHER=7;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalElementalParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalElementalParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalElementalParser.tokenNames; }
    public String getGrammarFileName() { return "InternalElemental.g"; }



     	private ElementalGrammarAccess grammarAccess;

        public InternalElementalParser(TokenStream input, ElementalGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ElementalGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalElemental.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalElemental.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalElemental.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalElemental.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_implicitFunction_0_0= ruleBlock ) ) ( (lv_explicitFunctions_1_0= ruleFunction ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_implicitFunction_0_0 = null;

        EObject lv_explicitFunctions_1_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:77:2: ( ( ( (lv_implicitFunction_0_0= ruleBlock ) ) ( (lv_explicitFunctions_1_0= ruleFunction ) )* ) )
            // InternalElemental.g:78:2: ( ( (lv_implicitFunction_0_0= ruleBlock ) ) ( (lv_explicitFunctions_1_0= ruleFunction ) )* )
            {
            // InternalElemental.g:78:2: ( ( (lv_implicitFunction_0_0= ruleBlock ) ) ( (lv_explicitFunctions_1_0= ruleFunction ) )* )
            // InternalElemental.g:79:3: ( (lv_implicitFunction_0_0= ruleBlock ) ) ( (lv_explicitFunctions_1_0= ruleFunction ) )*
            {
            // InternalElemental.g:79:3: ( (lv_implicitFunction_0_0= ruleBlock ) )
            // InternalElemental.g:80:4: (lv_implicitFunction_0_0= ruleBlock )
            {
            // InternalElemental.g:80:4: (lv_implicitFunction_0_0= ruleBlock )
            // InternalElemental.g:81:5: lv_implicitFunction_0_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getModelAccess().getImplicitFunctionBlockParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_implicitFunction_0_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"implicitFunction",
            						lv_implicitFunction_0_0,
            						"com.benjholla.elemental.Elemental.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalElemental.g:98:3: ( (lv_explicitFunctions_1_0= ruleFunction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalElemental.g:99:4: (lv_explicitFunctions_1_0= ruleFunction )
            	    {
            	    // InternalElemental.g:99:4: (lv_explicitFunctions_1_0= ruleFunction )
            	    // InternalElemental.g:100:5: lv_explicitFunctions_1_0= ruleFunction
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getExplicitFunctionsFunctionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_explicitFunctions_1_0=ruleFunction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"explicitFunctions",
            	    						lv_explicitFunctions_1_0,
            	    						"com.benjholla.elemental.Elemental.Function");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBlock"
    // InternalElemental.g:121:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalElemental.g:121:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalElemental.g:122:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalElemental.g:128:1: ruleBlock returns [EObject current=null] : ( () ( (lv_instructions_1_0= ruleInstruction ) )* ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_instructions_1_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:134:2: ( ( () ( (lv_instructions_1_0= ruleInstruction ) )* ) )
            // InternalElemental.g:135:2: ( () ( (lv_instructions_1_0= ruleInstruction ) )* )
            {
            // InternalElemental.g:135:2: ( () ( (lv_instructions_1_0= ruleInstruction ) )* )
            // InternalElemental.g:136:3: () ( (lv_instructions_1_0= ruleInstruction ) )*
            {
            // InternalElemental.g:136:3: ()
            // InternalElemental.g:137:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlockAccess().getBlockAction_0(),
            					current);
            			

            }

            // InternalElemental.g:143:3: ( (lv_instructions_1_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=9 && LA2_0<=16)||LA2_0==18||(LA2_0>=20 && LA2_0<=22)||LA2_0==24) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalElemental.g:144:4: (lv_instructions_1_0= ruleInstruction )
            	    {
            	    // InternalElemental.g:144:4: (lv_instructions_1_0= ruleInstruction )
            	    // InternalElemental.g:145:5: lv_instructions_1_0= ruleInstruction
            	    {

            	    					newCompositeNode(grammarAccess.getBlockAccess().getInstructionsInstructionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_instructions_1_0=ruleInstruction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instructions",
            	    						lv_instructions_1_0,
            	    						"com.benjholla.elemental.Elemental.Instruction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleFunction"
    // InternalElemental.g:166:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalElemental.g:166:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalElemental.g:167:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalElemental.g:173:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:179:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) ) )
            // InternalElemental.g:180:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) )
            {
            // InternalElemental.g:180:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) )
            // InternalElemental.g:181:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) )
            {
            // InternalElemental.g:181:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalElemental.g:182:4: (lv_name_0_0= RULE_ID )
            {
            // InternalElemental.g:182:4: (lv_name_0_0= RULE_ID )
            // InternalElemental.g:183:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"com.benjholla.elemental.Elemental.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,8,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getColonKeyword_1());
            		
            // InternalElemental.g:203:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:204:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:204:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:205:5: lv_body_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getFunctionAccess().getBodyBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_2_0,
            						"com.benjholla.elemental.Elemental.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleInstruction"
    // InternalElemental.g:226:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalElemental.g:226:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalElemental.g:227:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalElemental.g:233:1: ruleInstruction returns [EObject current=null] : ( ( () ruleIncrement ) | ( () ruleDecrement ) | ( () ruleMoveLeft ) | ( () ruleMoveRight ) | ( () ruleStore ) | ( () ruleRecall ) | ( () ruleAssignment ) | this_Branch_14= ruleBranch | this_Loop_15= ruleLoop | this_GOTO_16= ruleGOTO | ( () ruleComputedGOTO ) | this_StaticDispatch_19= ruleStaticDispatch | ( () ruleDynamicDispatch ) ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Branch_14 = null;

        EObject this_Loop_15 = null;

        EObject this_GOTO_16 = null;

        EObject this_StaticDispatch_19 = null;



        	enterRule();

        try {
            // InternalElemental.g:239:2: ( ( ( () ruleIncrement ) | ( () ruleDecrement ) | ( () ruleMoveLeft ) | ( () ruleMoveRight ) | ( () ruleStore ) | ( () ruleRecall ) | ( () ruleAssignment ) | this_Branch_14= ruleBranch | this_Loop_15= ruleLoop | this_GOTO_16= ruleGOTO | ( () ruleComputedGOTO ) | this_StaticDispatch_19= ruleStaticDispatch | ( () ruleDynamicDispatch ) ) )
            // InternalElemental.g:240:2: ( ( () ruleIncrement ) | ( () ruleDecrement ) | ( () ruleMoveLeft ) | ( () ruleMoveRight ) | ( () ruleStore ) | ( () ruleRecall ) | ( () ruleAssignment ) | this_Branch_14= ruleBranch | this_Loop_15= ruleLoop | this_GOTO_16= ruleGOTO | ( () ruleComputedGOTO ) | this_StaticDispatch_19= ruleStaticDispatch | ( () ruleDynamicDispatch ) )
            {
            // InternalElemental.g:240:2: ( ( () ruleIncrement ) | ( () ruleDecrement ) | ( () ruleMoveLeft ) | ( () ruleMoveRight ) | ( () ruleStore ) | ( () ruleRecall ) | ( () ruleAssignment ) | this_Branch_14= ruleBranch | this_Loop_15= ruleLoop | this_GOTO_16= ruleGOTO | ( () ruleComputedGOTO ) | this_StaticDispatch_19= ruleStaticDispatch | ( () ruleDynamicDispatch ) )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 9:
                {
                alt3=1;
                }
                break;
            case 10:
                {
                alt3=2;
                }
                break;
            case 11:
                {
                alt3=3;
                }
                break;
            case 12:
                {
                alt3=4;
                }
                break;
            case 13:
                {
                alt3=5;
                }
                break;
            case 14:
                {
                alt3=6;
                }
                break;
            case 15:
                {
                alt3=7;
                }
                break;
            case 16:
                {
                alt3=8;
                }
                break;
            case 18:
                {
                alt3=9;
                }
                break;
            case 20:
                {
                alt3=10;
                }
                break;
            case 21:
                {
                alt3=11;
                }
                break;
            case 22:
                {
                alt3=12;
                }
                break;
            case 24:
                {
                alt3=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalElemental.g:241:3: ( () ruleIncrement )
                    {
                    // InternalElemental.g:241:3: ( () ruleIncrement )
                    // InternalElemental.g:242:4: () ruleIncrement
                    {
                    // InternalElemental.g:242:4: ()
                    // InternalElemental.g:243:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_0_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getIncrementParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleIncrement();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalElemental.g:258:3: ( () ruleDecrement )
                    {
                    // InternalElemental.g:258:3: ( () ruleDecrement )
                    // InternalElemental.g:259:4: () ruleDecrement
                    {
                    // InternalElemental.g:259:4: ()
                    // InternalElemental.g:260:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_1_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getDecrementParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleDecrement();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalElemental.g:275:3: ( () ruleMoveLeft )
                    {
                    // InternalElemental.g:275:3: ( () ruleMoveLeft )
                    // InternalElemental.g:276:4: () ruleMoveLeft
                    {
                    // InternalElemental.g:276:4: ()
                    // InternalElemental.g:277:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_2_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getMoveLeftParserRuleCall_2_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleMoveLeft();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalElemental.g:292:3: ( () ruleMoveRight )
                    {
                    // InternalElemental.g:292:3: ( () ruleMoveRight )
                    // InternalElemental.g:293:4: () ruleMoveRight
                    {
                    // InternalElemental.g:293:4: ()
                    // InternalElemental.g:294:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_3_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getMoveRightParserRuleCall_3_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleMoveRight();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalElemental.g:309:3: ( () ruleStore )
                    {
                    // InternalElemental.g:309:3: ( () ruleStore )
                    // InternalElemental.g:310:4: () ruleStore
                    {
                    // InternalElemental.g:310:4: ()
                    // InternalElemental.g:311:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_4_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getStoreParserRuleCall_4_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleStore();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalElemental.g:326:3: ( () ruleRecall )
                    {
                    // InternalElemental.g:326:3: ( () ruleRecall )
                    // InternalElemental.g:327:4: () ruleRecall
                    {
                    // InternalElemental.g:327:4: ()
                    // InternalElemental.g:328:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_5_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getRecallParserRuleCall_5_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleRecall();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalElemental.g:343:3: ( () ruleAssignment )
                    {
                    // InternalElemental.g:343:3: ( () ruleAssignment )
                    // InternalElemental.g:344:4: () ruleAssignment
                    {
                    // InternalElemental.g:344:4: ()
                    // InternalElemental.g:345:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_6_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getAssignmentParserRuleCall_6_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalElemental.g:360:3: this_Branch_14= ruleBranch
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getBranchParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Branch_14=ruleBranch();

                    state._fsp--;


                    			current = this_Branch_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalElemental.g:369:3: this_Loop_15= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getLoopParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_15=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalElemental.g:378:3: this_GOTO_16= ruleGOTO
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getGOTOParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_GOTO_16=ruleGOTO();

                    state._fsp--;


                    			current = this_GOTO_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalElemental.g:387:3: ( () ruleComputedGOTO )
                    {
                    // InternalElemental.g:387:3: ( () ruleComputedGOTO )
                    // InternalElemental.g:388:4: () ruleComputedGOTO
                    {
                    // InternalElemental.g:388:4: ()
                    // InternalElemental.g:389:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_10_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getComputedGOTOParserRuleCall_10_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleComputedGOTO();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalElemental.g:404:3: this_StaticDispatch_19= ruleStaticDispatch
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getStaticDispatchParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_StaticDispatch_19=ruleStaticDispatch();

                    state._fsp--;


                    			current = this_StaticDispatch_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalElemental.g:413:3: ( () ruleDynamicDispatch )
                    {
                    // InternalElemental.g:413:3: ( () ruleDynamicDispatch )
                    // InternalElemental.g:414:4: () ruleDynamicDispatch
                    {
                    // InternalElemental.g:414:4: ()
                    // InternalElemental.g:415:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getInstructionAccess().getInstructionAction_12_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getInstructionAccess().getDynamicDispatchParserRuleCall_12_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleDynamicDispatch();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleIncrement"
    // InternalElemental.g:433:1: entryRuleIncrement returns [String current=null] : iv_ruleIncrement= ruleIncrement EOF ;
    public final String entryRuleIncrement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncrement = null;


        try {
            // InternalElemental.g:433:49: (iv_ruleIncrement= ruleIncrement EOF )
            // InternalElemental.g:434:2: iv_ruleIncrement= ruleIncrement EOF
            {
             newCompositeNode(grammarAccess.getIncrementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncrement=ruleIncrement();

            state._fsp--;

             current =iv_ruleIncrement.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncrement"


    // $ANTLR start "ruleIncrement"
    // InternalElemental.g:440:1: ruleIncrement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+' ;
    public final AntlrDatatypeRuleToken ruleIncrement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:446:2: (kw= '+' )
            // InternalElemental.g:447:2: kw= '+'
            {
            kw=(Token)match(input,9,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getIncrementAccess().getPlusSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncrement"


    // $ANTLR start "entryRuleDecrement"
    // InternalElemental.g:455:1: entryRuleDecrement returns [String current=null] : iv_ruleDecrement= ruleDecrement EOF ;
    public final String entryRuleDecrement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecrement = null;


        try {
            // InternalElemental.g:455:49: (iv_ruleDecrement= ruleDecrement EOF )
            // InternalElemental.g:456:2: iv_ruleDecrement= ruleDecrement EOF
            {
             newCompositeNode(grammarAccess.getDecrementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecrement=ruleDecrement();

            state._fsp--;

             current =iv_ruleDecrement.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecrement"


    // $ANTLR start "ruleDecrement"
    // InternalElemental.g:462:1: ruleDecrement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '-' ;
    public final AntlrDatatypeRuleToken ruleDecrement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:468:2: (kw= '-' )
            // InternalElemental.g:469:2: kw= '-'
            {
            kw=(Token)match(input,10,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getDecrementAccess().getHyphenMinusKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecrement"


    // $ANTLR start "entryRuleMoveLeft"
    // InternalElemental.g:477:1: entryRuleMoveLeft returns [String current=null] : iv_ruleMoveLeft= ruleMoveLeft EOF ;
    public final String entryRuleMoveLeft() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMoveLeft = null;


        try {
            // InternalElemental.g:477:48: (iv_ruleMoveLeft= ruleMoveLeft EOF )
            // InternalElemental.g:478:2: iv_ruleMoveLeft= ruleMoveLeft EOF
            {
             newCompositeNode(grammarAccess.getMoveLeftRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoveLeft=ruleMoveLeft();

            state._fsp--;

             current =iv_ruleMoveLeft.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMoveLeft"


    // $ANTLR start "ruleMoveLeft"
    // InternalElemental.g:484:1: ruleMoveLeft returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '<' ;
    public final AntlrDatatypeRuleToken ruleMoveLeft() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:490:2: (kw= '<' )
            // InternalElemental.g:491:2: kw= '<'
            {
            kw=(Token)match(input,11,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getMoveLeftAccess().getLessThanSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMoveLeft"


    // $ANTLR start "entryRuleMoveRight"
    // InternalElemental.g:499:1: entryRuleMoveRight returns [String current=null] : iv_ruleMoveRight= ruleMoveRight EOF ;
    public final String entryRuleMoveRight() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMoveRight = null;


        try {
            // InternalElemental.g:499:49: (iv_ruleMoveRight= ruleMoveRight EOF )
            // InternalElemental.g:500:2: iv_ruleMoveRight= ruleMoveRight EOF
            {
             newCompositeNode(grammarAccess.getMoveRightRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoveRight=ruleMoveRight();

            state._fsp--;

             current =iv_ruleMoveRight.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMoveRight"


    // $ANTLR start "ruleMoveRight"
    // InternalElemental.g:506:1: ruleMoveRight returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '>' ;
    public final AntlrDatatypeRuleToken ruleMoveRight() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:512:2: (kw= '>' )
            // InternalElemental.g:513:2: kw= '>'
            {
            kw=(Token)match(input,12,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getMoveRightAccess().getGreaterThanSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMoveRight"


    // $ANTLR start "entryRuleStore"
    // InternalElemental.g:521:1: entryRuleStore returns [String current=null] : iv_ruleStore= ruleStore EOF ;
    public final String entryRuleStore() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStore = null;


        try {
            // InternalElemental.g:521:45: (iv_ruleStore= ruleStore EOF )
            // InternalElemental.g:522:2: iv_ruleStore= ruleStore EOF
            {
             newCompositeNode(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStore=ruleStore();

            state._fsp--;

             current =iv_ruleStore.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStore"


    // $ANTLR start "ruleStore"
    // InternalElemental.g:528:1: ruleStore returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= ',' ;
    public final AntlrDatatypeRuleToken ruleStore() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:534:2: (kw= ',' )
            // InternalElemental.g:535:2: kw= ','
            {
            kw=(Token)match(input,13,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getStoreAccess().getCommaKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleRecall"
    // InternalElemental.g:543:1: entryRuleRecall returns [String current=null] : iv_ruleRecall= ruleRecall EOF ;
    public final String entryRuleRecall() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRecall = null;


        try {
            // InternalElemental.g:543:46: (iv_ruleRecall= ruleRecall EOF )
            // InternalElemental.g:544:2: iv_ruleRecall= ruleRecall EOF
            {
             newCompositeNode(grammarAccess.getRecallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecall=ruleRecall();

            state._fsp--;

             current =iv_ruleRecall.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecall"


    // $ANTLR start "ruleRecall"
    // InternalElemental.g:550:1: ruleRecall returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '.' ;
    public final AntlrDatatypeRuleToken ruleRecall() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:556:2: (kw= '.' )
            // InternalElemental.g:557:2: kw= '.'
            {
            kw=(Token)match(input,14,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getRecallAccess().getFullStopKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecall"


    // $ANTLR start "entryRuleAssignment"
    // InternalElemental.g:565:1: entryRuleAssignment returns [String current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final String entryRuleAssignment() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignment = null;


        try {
            // InternalElemental.g:565:50: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalElemental.g:566:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalElemental.g:572:1: ruleAssignment returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignment() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:578:2: (kw= '=' )
            // InternalElemental.g:579:2: kw= '='
            {
            kw=(Token)match(input,15,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getAssignmentAccess().getEqualsSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleBranch"
    // InternalElemental.g:587:1: entryRuleBranch returns [EObject current=null] : iv_ruleBranch= ruleBranch EOF ;
    public final EObject entryRuleBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranch = null;


        try {
            // InternalElemental.g:587:47: (iv_ruleBranch= ruleBranch EOF )
            // InternalElemental.g:588:2: iv_ruleBranch= ruleBranch EOF
            {
             newCompositeNode(grammarAccess.getBranchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBranch=ruleBranch();

            state._fsp--;

             current =iv_ruleBranch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranch"


    // $ANTLR start "ruleBranch"
    // InternalElemental.g:594:1: ruleBranch returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) ;
    public final EObject ruleBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:600:2: ( ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) )
            // InternalElemental.g:601:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            {
            // InternalElemental.g:601:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            // InternalElemental.g:602:3: () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')'
            {
            // InternalElemental.g:602:3: ()
            // InternalElemental.g:603:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBranchAccess().getBranchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBranchAccess().getLeftParenthesisKeyword_1());
            		
            // InternalElemental.g:613:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:614:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:614:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:615:5: lv_body_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getBranchAccess().getBodyBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_body_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBranchRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_2_0,
            						"com.benjholla.elemental.Elemental.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getBranchAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBranch"


    // $ANTLR start "entryRuleLoop"
    // InternalElemental.g:640:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalElemental.g:640:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalElemental.g:641:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalElemental.g:647:1: ruleLoop returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:653:2: ( ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) )
            // InternalElemental.g:654:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            {
            // InternalElemental.g:654:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            // InternalElemental.g:655:3: () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']'
            {
            // InternalElemental.g:655:3: ()
            // InternalElemental.g:656:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoopAccess().getLoopAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalElemental.g:666:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:667:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:667:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:668:5: lv_body_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getBodyBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_body_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoopRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_2_0,
            						"com.benjholla.elemental.Elemental.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getLoopAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleGOTO"
    // InternalElemental.g:693:1: entryRuleGOTO returns [EObject current=null] : iv_ruleGOTO= ruleGOTO EOF ;
    public final EObject entryRuleGOTO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGOTO = null;


        try {
            // InternalElemental.g:693:45: (iv_ruleGOTO= ruleGOTO EOF )
            // InternalElemental.g:694:2: iv_ruleGOTO= ruleGOTO EOF
            {
             newCompositeNode(grammarAccess.getGOTORule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGOTO=ruleGOTO();

            state._fsp--;

             current =iv_ruleGOTO; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGOTO"


    // $ANTLR start "ruleGOTO"
    // InternalElemental.g:700:1: ruleGOTO returns [EObject current=null] : (otherlv_0= '\\'' ( (otherlv_1= RULE_ID ) ) otherlv_2= '\\'' ) ;
    public final EObject ruleGOTO() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalElemental.g:706:2: ( (otherlv_0= '\\'' ( (otherlv_1= RULE_ID ) ) otherlv_2= '\\'' ) )
            // InternalElemental.g:707:2: (otherlv_0= '\\'' ( (otherlv_1= RULE_ID ) ) otherlv_2= '\\'' )
            {
            // InternalElemental.g:707:2: (otherlv_0= '\\'' ( (otherlv_1= RULE_ID ) ) otherlv_2= '\\'' )
            // InternalElemental.g:708:3: otherlv_0= '\\'' ( (otherlv_1= RULE_ID ) ) otherlv_2= '\\''
            {
            otherlv_0=(Token)match(input,20,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getGOTOAccess().getApostropheKeyword_0());
            		
            // InternalElemental.g:712:3: ( (otherlv_1= RULE_ID ) )
            // InternalElemental.g:713:4: (otherlv_1= RULE_ID )
            {
            // InternalElemental.g:713:4: (otherlv_1= RULE_ID )
            // InternalElemental.g:714:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGOTORule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_1, grammarAccess.getGOTOAccess().getLabelLabelCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getGOTOAccess().getApostropheKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGOTO"


    // $ANTLR start "entryRuleComputedGOTO"
    // InternalElemental.g:733:1: entryRuleComputedGOTO returns [String current=null] : iv_ruleComputedGOTO= ruleComputedGOTO EOF ;
    public final String entryRuleComputedGOTO() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComputedGOTO = null;


        try {
            // InternalElemental.g:733:52: (iv_ruleComputedGOTO= ruleComputedGOTO EOF )
            // InternalElemental.g:734:2: iv_ruleComputedGOTO= ruleComputedGOTO EOF
            {
             newCompositeNode(grammarAccess.getComputedGOTORule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComputedGOTO=ruleComputedGOTO();

            state._fsp--;

             current =iv_ruleComputedGOTO.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedGOTO"


    // $ANTLR start "ruleComputedGOTO"
    // InternalElemental.g:740:1: ruleComputedGOTO returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&' ;
    public final AntlrDatatypeRuleToken ruleComputedGOTO() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:746:2: (kw= '&' )
            // InternalElemental.g:747:2: kw= '&'
            {
            kw=(Token)match(input,21,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getComputedGOTOAccess().getAmpersandKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputedGOTO"


    // $ANTLR start "entryRuleStaticDispatch"
    // InternalElemental.g:755:1: entryRuleStaticDispatch returns [EObject current=null] : iv_ruleStaticDispatch= ruleStaticDispatch EOF ;
    public final EObject entryRuleStaticDispatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticDispatch = null;


        try {
            // InternalElemental.g:755:55: (iv_ruleStaticDispatch= ruleStaticDispatch EOF )
            // InternalElemental.g:756:2: iv_ruleStaticDispatch= ruleStaticDispatch EOF
            {
             newCompositeNode(grammarAccess.getStaticDispatchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStaticDispatch=ruleStaticDispatch();

            state._fsp--;

             current =iv_ruleStaticDispatch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticDispatch"


    // $ANTLR start "ruleStaticDispatch"
    // InternalElemental.g:762:1: ruleStaticDispatch returns [EObject current=null] : (otherlv_0= '{' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleStaticDispatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalElemental.g:768:2: ( (otherlv_0= '{' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' ) )
            // InternalElemental.g:769:2: (otherlv_0= '{' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' )
            {
            // InternalElemental.g:769:2: (otherlv_0= '{' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}' )
            // InternalElemental.g:770:3: otherlv_0= '{' ( (otherlv_1= RULE_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getStaticDispatchAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalElemental.g:774:3: ( (otherlv_1= RULE_ID ) )
            // InternalElemental.g:775:4: (otherlv_1= RULE_ID )
            {
            // InternalElemental.g:775:4: (otherlv_1= RULE_ID )
            // InternalElemental.g:776:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStaticDispatchRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_1, grammarAccess.getStaticDispatchAccess().getTargetFunctionCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getStaticDispatchAccess().getRightCurlyBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStaticDispatch"


    // $ANTLR start "entryRuleDynamicDispatch"
    // InternalElemental.g:795:1: entryRuleDynamicDispatch returns [String current=null] : iv_ruleDynamicDispatch= ruleDynamicDispatch EOF ;
    public final String entryRuleDynamicDispatch() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDynamicDispatch = null;


        try {
            // InternalElemental.g:795:55: (iv_ruleDynamicDispatch= ruleDynamicDispatch EOF )
            // InternalElemental.g:796:2: iv_ruleDynamicDispatch= ruleDynamicDispatch EOF
            {
             newCompositeNode(grammarAccess.getDynamicDispatchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDynamicDispatch=ruleDynamicDispatch();

            state._fsp--;

             current =iv_ruleDynamicDispatch.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDynamicDispatch"


    // $ANTLR start "ruleDynamicDispatch"
    // InternalElemental.g:802:1: ruleDynamicDispatch returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '?' ;
    public final AntlrDatatypeRuleToken ruleDynamicDispatch() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalElemental.g:808:2: (kw= '?' )
            // InternalElemental.g:809:2: kw= '?'
            {
            kw=(Token)match(input,24,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getDynamicDispatchAccess().getQuestionMarkKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDynamicDispatch"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000175FE02L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000175FE00L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});

}