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
    // InternalElemental.g:233:1: ruleInstruction returns [EObject current=null] : ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) ) ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_1 = null;

        EObject lv_type_0_2 = null;

        EObject lv_type_0_3 = null;

        EObject lv_type_0_4 = null;

        EObject lv_type_0_5 = null;

        EObject lv_type_0_6 = null;

        EObject lv_type_0_7 = null;

        EObject lv_type_0_8 = null;

        EObject lv_type_0_9 = null;

        EObject lv_type_0_10 = null;

        EObject lv_type_0_11 = null;

        EObject lv_type_0_12 = null;

        EObject lv_type_0_13 = null;



        	enterRule();

        try {
            // InternalElemental.g:239:2: ( ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) ) ) )
            // InternalElemental.g:240:2: ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) ) )
            {
            // InternalElemental.g:240:2: ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) ) )
            // InternalElemental.g:241:3: ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) )
            {
            // InternalElemental.g:241:3: ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch ) )
            // InternalElemental.g:242:4: (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch )
            {
            // InternalElemental.g:242:4: (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleGOTO | lv_type_0_11= ruleComputedGOTO | lv_type_0_12= ruleStaticDispatch | lv_type_0_13= ruleDynamicDispatch )
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
                    // InternalElemental.g:243:5: lv_type_0_1= ruleIncrement
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeIncrementParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_1=ruleIncrement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_1,
                    						"com.benjholla.elemental.Elemental.Increment");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 2 :
                    // InternalElemental.g:259:5: lv_type_0_2= ruleDecrement
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeDecrementParserRuleCall_0_1());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_2=ruleDecrement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_2,
                    						"com.benjholla.elemental.Elemental.Decrement");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 3 :
                    // InternalElemental.g:275:5: lv_type_0_3= ruleMoveLeft
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeMoveLeftParserRuleCall_0_2());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_3=ruleMoveLeft();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_3,
                    						"com.benjholla.elemental.Elemental.MoveLeft");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 4 :
                    // InternalElemental.g:291:5: lv_type_0_4= ruleMoveRight
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeMoveRightParserRuleCall_0_3());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_4=ruleMoveRight();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_4,
                    						"com.benjholla.elemental.Elemental.MoveRight");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 5 :
                    // InternalElemental.g:307:5: lv_type_0_5= ruleStore
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeStoreParserRuleCall_0_4());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_5=ruleStore();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_5,
                    						"com.benjholla.elemental.Elemental.Store");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 6 :
                    // InternalElemental.g:323:5: lv_type_0_6= ruleRecall
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeRecallParserRuleCall_0_5());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_6=ruleRecall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_6,
                    						"com.benjholla.elemental.Elemental.Recall");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 7 :
                    // InternalElemental.g:339:5: lv_type_0_7= ruleAssignment
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeAssignmentParserRuleCall_0_6());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_7=ruleAssignment();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_7,
                    						"com.benjholla.elemental.Elemental.Assignment");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 8 :
                    // InternalElemental.g:355:5: lv_type_0_8= ruleBranch
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeBranchParserRuleCall_0_7());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_8=ruleBranch();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_8,
                    						"com.benjholla.elemental.Elemental.Branch");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 9 :
                    // InternalElemental.g:371:5: lv_type_0_9= ruleLoop
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeLoopParserRuleCall_0_8());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_9=ruleLoop();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_9,
                    						"com.benjholla.elemental.Elemental.Loop");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 10 :
                    // InternalElemental.g:387:5: lv_type_0_10= ruleGOTO
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeGOTOParserRuleCall_0_9());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_10=ruleGOTO();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_10,
                    						"com.benjholla.elemental.Elemental.GOTO");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 11 :
                    // InternalElemental.g:403:5: lv_type_0_11= ruleComputedGOTO
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeComputedGOTOParserRuleCall_0_10());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_11=ruleComputedGOTO();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_11,
                    						"com.benjholla.elemental.Elemental.ComputedGOTO");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 12 :
                    // InternalElemental.g:419:5: lv_type_0_12= ruleStaticDispatch
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeStaticDispatchParserRuleCall_0_11());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_12=ruleStaticDispatch();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_12,
                    						"com.benjholla.elemental.Elemental.StaticDispatch");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 13 :
                    // InternalElemental.g:435:5: lv_type_0_13= ruleDynamicDispatch
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeDynamicDispatchParserRuleCall_0_12());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_13=ruleDynamicDispatch();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_13,
                    						"com.benjholla.elemental.Elemental.DynamicDispatch");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;

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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleIncrement"
    // InternalElemental.g:456:1: entryRuleIncrement returns [EObject current=null] : iv_ruleIncrement= ruleIncrement EOF ;
    public final EObject entryRuleIncrement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncrement = null;


        try {
            // InternalElemental.g:456:50: (iv_ruleIncrement= ruleIncrement EOF )
            // InternalElemental.g:457:2: iv_ruleIncrement= ruleIncrement EOF
            {
             newCompositeNode(grammarAccess.getIncrementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIncrement=ruleIncrement();

            state._fsp--;

             current =iv_ruleIncrement; 
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
    // InternalElemental.g:463:1: ruleIncrement returns [EObject current=null] : ( () otherlv_1= '+' ) ;
    public final EObject ruleIncrement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:469:2: ( ( () otherlv_1= '+' ) )
            // InternalElemental.g:470:2: ( () otherlv_1= '+' )
            {
            // InternalElemental.g:470:2: ( () otherlv_1= '+' )
            // InternalElemental.g:471:3: () otherlv_1= '+'
            {
            // InternalElemental.g:471:3: ()
            // InternalElemental.g:472:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIncrementAccess().getIncrementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,9,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getIncrementAccess().getPlusSignKeyword_1());
            		

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
    // $ANTLR end "ruleIncrement"


    // $ANTLR start "entryRuleDecrement"
    // InternalElemental.g:486:1: entryRuleDecrement returns [EObject current=null] : iv_ruleDecrement= ruleDecrement EOF ;
    public final EObject entryRuleDecrement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecrement = null;


        try {
            // InternalElemental.g:486:50: (iv_ruleDecrement= ruleDecrement EOF )
            // InternalElemental.g:487:2: iv_ruleDecrement= ruleDecrement EOF
            {
             newCompositeNode(grammarAccess.getDecrementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecrement=ruleDecrement();

            state._fsp--;

             current =iv_ruleDecrement; 
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
    // InternalElemental.g:493:1: ruleDecrement returns [EObject current=null] : ( () otherlv_1= '-' ) ;
    public final EObject ruleDecrement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:499:2: ( ( () otherlv_1= '-' ) )
            // InternalElemental.g:500:2: ( () otherlv_1= '-' )
            {
            // InternalElemental.g:500:2: ( () otherlv_1= '-' )
            // InternalElemental.g:501:3: () otherlv_1= '-'
            {
            // InternalElemental.g:501:3: ()
            // InternalElemental.g:502:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDecrementAccess().getDecrementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,10,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDecrementAccess().getHyphenMinusKeyword_1());
            		

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
    // $ANTLR end "ruleDecrement"


    // $ANTLR start "entryRuleMoveLeft"
    // InternalElemental.g:516:1: entryRuleMoveLeft returns [EObject current=null] : iv_ruleMoveLeft= ruleMoveLeft EOF ;
    public final EObject entryRuleMoveLeft() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoveLeft = null;


        try {
            // InternalElemental.g:516:49: (iv_ruleMoveLeft= ruleMoveLeft EOF )
            // InternalElemental.g:517:2: iv_ruleMoveLeft= ruleMoveLeft EOF
            {
             newCompositeNode(grammarAccess.getMoveLeftRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoveLeft=ruleMoveLeft();

            state._fsp--;

             current =iv_ruleMoveLeft; 
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
    // InternalElemental.g:523:1: ruleMoveLeft returns [EObject current=null] : ( () otherlv_1= '<' ) ;
    public final EObject ruleMoveLeft() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:529:2: ( ( () otherlv_1= '<' ) )
            // InternalElemental.g:530:2: ( () otherlv_1= '<' )
            {
            // InternalElemental.g:530:2: ( () otherlv_1= '<' )
            // InternalElemental.g:531:3: () otherlv_1= '<'
            {
            // InternalElemental.g:531:3: ()
            // InternalElemental.g:532:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMoveLeftAccess().getMoveLeftAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getMoveLeftAccess().getLessThanSignKeyword_1());
            		

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
    // $ANTLR end "ruleMoveLeft"


    // $ANTLR start "entryRuleMoveRight"
    // InternalElemental.g:546:1: entryRuleMoveRight returns [EObject current=null] : iv_ruleMoveRight= ruleMoveRight EOF ;
    public final EObject entryRuleMoveRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoveRight = null;


        try {
            // InternalElemental.g:546:50: (iv_ruleMoveRight= ruleMoveRight EOF )
            // InternalElemental.g:547:2: iv_ruleMoveRight= ruleMoveRight EOF
            {
             newCompositeNode(grammarAccess.getMoveRightRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMoveRight=ruleMoveRight();

            state._fsp--;

             current =iv_ruleMoveRight; 
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
    // InternalElemental.g:553:1: ruleMoveRight returns [EObject current=null] : ( () otherlv_1= '>' ) ;
    public final EObject ruleMoveRight() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:559:2: ( ( () otherlv_1= '>' ) )
            // InternalElemental.g:560:2: ( () otherlv_1= '>' )
            {
            // InternalElemental.g:560:2: ( () otherlv_1= '>' )
            // InternalElemental.g:561:3: () otherlv_1= '>'
            {
            // InternalElemental.g:561:3: ()
            // InternalElemental.g:562:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMoveRightAccess().getMoveRightAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getMoveRightAccess().getGreaterThanSignKeyword_1());
            		

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
    // $ANTLR end "ruleMoveRight"


    // $ANTLR start "entryRuleStore"
    // InternalElemental.g:576:1: entryRuleStore returns [EObject current=null] : iv_ruleStore= ruleStore EOF ;
    public final EObject entryRuleStore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStore = null;


        try {
            // InternalElemental.g:576:46: (iv_ruleStore= ruleStore EOF )
            // InternalElemental.g:577:2: iv_ruleStore= ruleStore EOF
            {
             newCompositeNode(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStore=ruleStore();

            state._fsp--;

             current =iv_ruleStore; 
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
    // InternalElemental.g:583:1: ruleStore returns [EObject current=null] : ( () otherlv_1= ',' ) ;
    public final EObject ruleStore() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:589:2: ( ( () otherlv_1= ',' ) )
            // InternalElemental.g:590:2: ( () otherlv_1= ',' )
            {
            // InternalElemental.g:590:2: ( () otherlv_1= ',' )
            // InternalElemental.g:591:3: () otherlv_1= ','
            {
            // InternalElemental.g:591:3: ()
            // InternalElemental.g:592:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStoreAccess().getStoreAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getStoreAccess().getCommaKeyword_1());
            		

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
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleRecall"
    // InternalElemental.g:606:1: entryRuleRecall returns [EObject current=null] : iv_ruleRecall= ruleRecall EOF ;
    public final EObject entryRuleRecall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecall = null;


        try {
            // InternalElemental.g:606:47: (iv_ruleRecall= ruleRecall EOF )
            // InternalElemental.g:607:2: iv_ruleRecall= ruleRecall EOF
            {
             newCompositeNode(grammarAccess.getRecallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecall=ruleRecall();

            state._fsp--;

             current =iv_ruleRecall; 
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
    // InternalElemental.g:613:1: ruleRecall returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleRecall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:619:2: ( ( () otherlv_1= '.' ) )
            // InternalElemental.g:620:2: ( () otherlv_1= '.' )
            {
            // InternalElemental.g:620:2: ( () otherlv_1= '.' )
            // InternalElemental.g:621:3: () otherlv_1= '.'
            {
            // InternalElemental.g:621:3: ()
            // InternalElemental.g:622:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRecallAccess().getRecallAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getRecallAccess().getFullStopKeyword_1());
            		

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
    // $ANTLR end "ruleRecall"


    // $ANTLR start "entryRuleAssignment"
    // InternalElemental.g:636:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalElemental.g:636:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalElemental.g:637:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
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
    // InternalElemental.g:643:1: ruleAssignment returns [EObject current=null] : ( () otherlv_1= '=' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:649:2: ( ( () otherlv_1= '=' ) )
            // InternalElemental.g:650:2: ( () otherlv_1= '=' )
            {
            // InternalElemental.g:650:2: ( () otherlv_1= '=' )
            // InternalElemental.g:651:3: () otherlv_1= '='
            {
            // InternalElemental.g:651:3: ()
            // InternalElemental.g:652:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssignmentAccess().getAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
            		

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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleBranch"
    // InternalElemental.g:666:1: entryRuleBranch returns [EObject current=null] : iv_ruleBranch= ruleBranch EOF ;
    public final EObject entryRuleBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranch = null;


        try {
            // InternalElemental.g:666:47: (iv_ruleBranch= ruleBranch EOF )
            // InternalElemental.g:667:2: iv_ruleBranch= ruleBranch EOF
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
    // InternalElemental.g:673:1: ruleBranch returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) ;
    public final EObject ruleBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:679:2: ( ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) )
            // InternalElemental.g:680:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            {
            // InternalElemental.g:680:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            // InternalElemental.g:681:3: () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')'
            {
            // InternalElemental.g:681:3: ()
            // InternalElemental.g:682:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBranchAccess().getBranchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBranchAccess().getLeftParenthesisKeyword_1());
            		
            // InternalElemental.g:692:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:693:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:693:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:694:5: lv_body_2_0= ruleBlock
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
    // InternalElemental.g:719:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalElemental.g:719:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalElemental.g:720:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalElemental.g:726:1: ruleLoop returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:732:2: ( ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) )
            // InternalElemental.g:733:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            {
            // InternalElemental.g:733:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            // InternalElemental.g:734:3: () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']'
            {
            // InternalElemental.g:734:3: ()
            // InternalElemental.g:735:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoopAccess().getLoopAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalElemental.g:745:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:746:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:746:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:747:5: lv_body_2_0= ruleBlock
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
    // InternalElemental.g:772:1: entryRuleGOTO returns [EObject current=null] : iv_ruleGOTO= ruleGOTO EOF ;
    public final EObject entryRuleGOTO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGOTO = null;


        try {
            // InternalElemental.g:772:45: (iv_ruleGOTO= ruleGOTO EOF )
            // InternalElemental.g:773:2: iv_ruleGOTO= ruleGOTO EOF
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
    // InternalElemental.g:779:1: ruleGOTO returns [EObject current=null] : ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' ) ;
    public final EObject ruleGOTO() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalElemental.g:785:2: ( ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' ) )
            // InternalElemental.g:786:2: ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' )
            {
            // InternalElemental.g:786:2: ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' )
            // InternalElemental.g:787:3: () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\''
            {
            // InternalElemental.g:787:3: ()
            // InternalElemental.g:788:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGOTOAccess().getGOTOAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getGOTOAccess().getApostropheKeyword_1());
            		
            // InternalElemental.g:798:3: ( (otherlv_2= RULE_ID ) )
            // InternalElemental.g:799:4: (otherlv_2= RULE_ID )
            {
            // InternalElemental.g:799:4: (otherlv_2= RULE_ID )
            // InternalElemental.g:800:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGOTORule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_2, grammarAccess.getGOTOAccess().getLabelLabelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getGOTOAccess().getApostropheKeyword_3());
            		

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
    // InternalElemental.g:819:1: entryRuleComputedGOTO returns [EObject current=null] : iv_ruleComputedGOTO= ruleComputedGOTO EOF ;
    public final EObject entryRuleComputedGOTO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedGOTO = null;


        try {
            // InternalElemental.g:819:53: (iv_ruleComputedGOTO= ruleComputedGOTO EOF )
            // InternalElemental.g:820:2: iv_ruleComputedGOTO= ruleComputedGOTO EOF
            {
             newCompositeNode(grammarAccess.getComputedGOTORule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComputedGOTO=ruleComputedGOTO();

            state._fsp--;

             current =iv_ruleComputedGOTO; 
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
    // InternalElemental.g:826:1: ruleComputedGOTO returns [EObject current=null] : ( () otherlv_1= '&' ) ;
    public final EObject ruleComputedGOTO() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:832:2: ( ( () otherlv_1= '&' ) )
            // InternalElemental.g:833:2: ( () otherlv_1= '&' )
            {
            // InternalElemental.g:833:2: ( () otherlv_1= '&' )
            // InternalElemental.g:834:3: () otherlv_1= '&'
            {
            // InternalElemental.g:834:3: ()
            // InternalElemental.g:835:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getComputedGOTOAccess().getComputedGOTOAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getComputedGOTOAccess().getAmpersandKeyword_1());
            		

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
    // $ANTLR end "ruleComputedGOTO"


    // $ANTLR start "entryRuleStaticDispatch"
    // InternalElemental.g:849:1: entryRuleStaticDispatch returns [EObject current=null] : iv_ruleStaticDispatch= ruleStaticDispatch EOF ;
    public final EObject entryRuleStaticDispatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticDispatch = null;


        try {
            // InternalElemental.g:849:55: (iv_ruleStaticDispatch= ruleStaticDispatch EOF )
            // InternalElemental.g:850:2: iv_ruleStaticDispatch= ruleStaticDispatch EOF
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
    // InternalElemental.g:856:1: ruleStaticDispatch returns [EObject current=null] : ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' ) ;
    public final EObject ruleStaticDispatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalElemental.g:862:2: ( ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' ) )
            // InternalElemental.g:863:2: ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' )
            {
            // InternalElemental.g:863:2: ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' )
            // InternalElemental.g:864:3: () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}'
            {
            // InternalElemental.g:864:3: ()
            // InternalElemental.g:865:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStaticDispatchAccess().getStaticDispatchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getStaticDispatchAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalElemental.g:875:3: ( (otherlv_2= RULE_ID ) )
            // InternalElemental.g:876:4: (otherlv_2= RULE_ID )
            {
            // InternalElemental.g:876:4: (otherlv_2= RULE_ID )
            // InternalElemental.g:877:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStaticDispatchRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_2, grammarAccess.getStaticDispatchAccess().getTargetFunctionCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getStaticDispatchAccess().getRightCurlyBracketKeyword_3());
            		

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
    // InternalElemental.g:896:1: entryRuleDynamicDispatch returns [EObject current=null] : iv_ruleDynamicDispatch= ruleDynamicDispatch EOF ;
    public final EObject entryRuleDynamicDispatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDynamicDispatch = null;


        try {
            // InternalElemental.g:896:56: (iv_ruleDynamicDispatch= ruleDynamicDispatch EOF )
            // InternalElemental.g:897:2: iv_ruleDynamicDispatch= ruleDynamicDispatch EOF
            {
             newCompositeNode(grammarAccess.getDynamicDispatchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDynamicDispatch=ruleDynamicDispatch();

            state._fsp--;

             current =iv_ruleDynamicDispatch; 
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
    // InternalElemental.g:903:1: ruleDynamicDispatch returns [EObject current=null] : ( () otherlv_1= '?' ) ;
    public final EObject ruleDynamicDispatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:909:2: ( ( () otherlv_1= '?' ) )
            // InternalElemental.g:910:2: ( () otherlv_1= '?' )
            {
            // InternalElemental.g:910:2: ( () otherlv_1= '?' )
            // InternalElemental.g:911:3: () otherlv_1= '?'
            {
            // InternalElemental.g:911:3: ()
            // InternalElemental.g:912:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDynamicDispatchAccess().getDynamicDispatchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDynamicDispatchAccess().getQuestionMarkKeyword_1());
            		

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