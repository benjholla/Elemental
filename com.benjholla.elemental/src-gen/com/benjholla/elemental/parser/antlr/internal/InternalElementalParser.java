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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_COMMENT", "RULE_WHITESPACE", "RULE_ANY_OTHER", "'\"'", "':'", "'+'", "'-'", "'<'", "'>'", "','", "'.'", "'='", "'('", "')'", "'['", "']'", "'\\''", "'&'", "'{'", "'}'", "'?'"
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
    public static final int T__25=25;
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

                if ( (LA2_0==8||(LA2_0>=10 && LA2_0<=17)||LA2_0==19||(LA2_0>=21 && LA2_0<=23)||LA2_0==25) ) {
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


    // $ANTLR start "entryRuleLabel"
    // InternalElemental.g:166:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // InternalElemental.g:166:46: (iv_ruleLabel= ruleLabel EOF )
            // InternalElemental.g:167:2: iv_ruleLabel= ruleLabel EOF
            {
             newCompositeNode(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabel=ruleLabel();

            state._fsp--;

             current =iv_ruleLabel; 
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
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // InternalElemental.g:173:1: ruleLabel returns [EObject current=null] : (otherlv_0= '\"' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '\"' ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalElemental.g:179:2: ( (otherlv_0= '\"' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '\"' ) )
            // InternalElemental.g:180:2: (otherlv_0= '\"' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '\"' )
            {
            // InternalElemental.g:180:2: (otherlv_0= '\"' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '\"' )
            // InternalElemental.g:181:3: otherlv_0= '\"' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '\"'
            {
            otherlv_0=(Token)match(input,8,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getLabelAccess().getQuotationMarkKeyword_0());
            		
            // InternalElemental.g:185:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalElemental.g:186:4: (lv_name_1_0= RULE_ID )
            {
            // InternalElemental.g:186:4: (lv_name_1_0= RULE_ID )
            // InternalElemental.g:187:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.benjholla.elemental.Elemental.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,8,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getLabelAccess().getQuotationMarkKeyword_2());
            		

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
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleFunction"
    // InternalElemental.g:211:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalElemental.g:211:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalElemental.g:212:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalElemental.g:218:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:224:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) ) )
            // InternalElemental.g:225:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) )
            {
            // InternalElemental.g:225:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) ) )
            // InternalElemental.g:226:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_body_2_0= ruleBlock ) )
            {
            // InternalElemental.g:226:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalElemental.g:227:4: (lv_name_0_0= RULE_ID )
            {
            // InternalElemental.g:227:4: (lv_name_0_0= RULE_ID )
            // InternalElemental.g:228:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

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

            otherlv_1=(Token)match(input,9,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getColonKeyword_1());
            		
            // InternalElemental.g:248:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:249:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:249:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:250:5: lv_body_2_0= ruleBlock
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
    // InternalElemental.g:271:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalElemental.g:271:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalElemental.g:272:2: iv_ruleInstruction= ruleInstruction EOF
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
    // InternalElemental.g:278:1: ruleInstruction returns [EObject current=null] : ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) ) ) ;
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

        EObject lv_type_0_14 = null;



        	enterRule();

        try {
            // InternalElemental.g:284:2: ( ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) ) ) )
            // InternalElemental.g:285:2: ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) ) )
            {
            // InternalElemental.g:285:2: ( ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) ) )
            // InternalElemental.g:286:3: ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) )
            {
            // InternalElemental.g:286:3: ( (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch ) )
            // InternalElemental.g:287:4: (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch )
            {
            // InternalElemental.g:287:4: (lv_type_0_1= ruleIncrement | lv_type_0_2= ruleDecrement | lv_type_0_3= ruleMoveLeft | lv_type_0_4= ruleMoveRight | lv_type_0_5= ruleStore | lv_type_0_6= ruleRecall | lv_type_0_7= ruleAssignment | lv_type_0_8= ruleBranch | lv_type_0_9= ruleLoop | lv_type_0_10= ruleLabel | lv_type_0_11= ruleGOTO | lv_type_0_12= ruleComputedGOTO | lv_type_0_13= ruleStaticDispatch | lv_type_0_14= ruleDynamicDispatch )
            int alt3=14;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt3=1;
                }
                break;
            case 11:
                {
                alt3=2;
                }
                break;
            case 12:
                {
                alt3=3;
                }
                break;
            case 13:
                {
                alt3=4;
                }
                break;
            case 14:
                {
                alt3=5;
                }
                break;
            case 15:
                {
                alt3=6;
                }
                break;
            case 16:
                {
                alt3=7;
                }
                break;
            case 17:
                {
                alt3=8;
                }
                break;
            case 19:
                {
                alt3=9;
                }
                break;
            case 8:
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
            case 23:
                {
                alt3=13;
                }
                break;
            case 25:
                {
                alt3=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalElemental.g:288:5: lv_type_0_1= ruleIncrement
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
                    // InternalElemental.g:304:5: lv_type_0_2= ruleDecrement
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
                    // InternalElemental.g:320:5: lv_type_0_3= ruleMoveLeft
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
                    // InternalElemental.g:336:5: lv_type_0_4= ruleMoveRight
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
                    // InternalElemental.g:352:5: lv_type_0_5= ruleStore
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
                    // InternalElemental.g:368:5: lv_type_0_6= ruleRecall
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
                    // InternalElemental.g:384:5: lv_type_0_7= ruleAssignment
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
                    // InternalElemental.g:400:5: lv_type_0_8= ruleBranch
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
                    // InternalElemental.g:416:5: lv_type_0_9= ruleLoop
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
                    // InternalElemental.g:432:5: lv_type_0_10= ruleLabel
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeLabelParserRuleCall_0_9());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_10=ruleLabel();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_10,
                    						"com.benjholla.elemental.Elemental.Label");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 11 :
                    // InternalElemental.g:448:5: lv_type_0_11= ruleGOTO
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeGOTOParserRuleCall_0_10());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_11=ruleGOTO();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_11,
                    						"com.benjholla.elemental.Elemental.GOTO");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 12 :
                    // InternalElemental.g:464:5: lv_type_0_12= ruleComputedGOTO
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeComputedGOTOParserRuleCall_0_11());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_12=ruleComputedGOTO();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_12,
                    						"com.benjholla.elemental.Elemental.ComputedGOTO");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 13 :
                    // InternalElemental.g:480:5: lv_type_0_13= ruleStaticDispatch
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeStaticDispatchParserRuleCall_0_12());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_13=ruleStaticDispatch();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_13,
                    						"com.benjholla.elemental.Elemental.StaticDispatch");
                    					afterParserOrEnumRuleCall();
                    				

                    }
                    break;
                case 14 :
                    // InternalElemental.g:496:5: lv_type_0_14= ruleDynamicDispatch
                    {

                    					newCompositeNode(grammarAccess.getInstructionAccess().getTypeDynamicDispatchParserRuleCall_0_13());
                    				
                    pushFollow(FOLLOW_2);
                    lv_type_0_14=ruleDynamicDispatch();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getInstructionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_14,
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
    // InternalElemental.g:517:1: entryRuleIncrement returns [EObject current=null] : iv_ruleIncrement= ruleIncrement EOF ;
    public final EObject entryRuleIncrement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncrement = null;


        try {
            // InternalElemental.g:517:50: (iv_ruleIncrement= ruleIncrement EOF )
            // InternalElemental.g:518:2: iv_ruleIncrement= ruleIncrement EOF
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
    // InternalElemental.g:524:1: ruleIncrement returns [EObject current=null] : ( () otherlv_1= '+' ) ;
    public final EObject ruleIncrement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:530:2: ( ( () otherlv_1= '+' ) )
            // InternalElemental.g:531:2: ( () otherlv_1= '+' )
            {
            // InternalElemental.g:531:2: ( () otherlv_1= '+' )
            // InternalElemental.g:532:3: () otherlv_1= '+'
            {
            // InternalElemental.g:532:3: ()
            // InternalElemental.g:533:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIncrementAccess().getIncrementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,10,FOLLOW_2); 

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
    // InternalElemental.g:547:1: entryRuleDecrement returns [EObject current=null] : iv_ruleDecrement= ruleDecrement EOF ;
    public final EObject entryRuleDecrement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecrement = null;


        try {
            // InternalElemental.g:547:50: (iv_ruleDecrement= ruleDecrement EOF )
            // InternalElemental.g:548:2: iv_ruleDecrement= ruleDecrement EOF
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
    // InternalElemental.g:554:1: ruleDecrement returns [EObject current=null] : ( () otherlv_1= '-' ) ;
    public final EObject ruleDecrement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:560:2: ( ( () otherlv_1= '-' ) )
            // InternalElemental.g:561:2: ( () otherlv_1= '-' )
            {
            // InternalElemental.g:561:2: ( () otherlv_1= '-' )
            // InternalElemental.g:562:3: () otherlv_1= '-'
            {
            // InternalElemental.g:562:3: ()
            // InternalElemental.g:563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDecrementAccess().getDecrementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_2); 

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
    // InternalElemental.g:577:1: entryRuleMoveLeft returns [EObject current=null] : iv_ruleMoveLeft= ruleMoveLeft EOF ;
    public final EObject entryRuleMoveLeft() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoveLeft = null;


        try {
            // InternalElemental.g:577:49: (iv_ruleMoveLeft= ruleMoveLeft EOF )
            // InternalElemental.g:578:2: iv_ruleMoveLeft= ruleMoveLeft EOF
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
    // InternalElemental.g:584:1: ruleMoveLeft returns [EObject current=null] : ( () otherlv_1= '<' ) ;
    public final EObject ruleMoveLeft() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:590:2: ( ( () otherlv_1= '<' ) )
            // InternalElemental.g:591:2: ( () otherlv_1= '<' )
            {
            // InternalElemental.g:591:2: ( () otherlv_1= '<' )
            // InternalElemental.g:592:3: () otherlv_1= '<'
            {
            // InternalElemental.g:592:3: ()
            // InternalElemental.g:593:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMoveLeftAccess().getMoveLeftAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_2); 

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
    // InternalElemental.g:607:1: entryRuleMoveRight returns [EObject current=null] : iv_ruleMoveRight= ruleMoveRight EOF ;
    public final EObject entryRuleMoveRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMoveRight = null;


        try {
            // InternalElemental.g:607:50: (iv_ruleMoveRight= ruleMoveRight EOF )
            // InternalElemental.g:608:2: iv_ruleMoveRight= ruleMoveRight EOF
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
    // InternalElemental.g:614:1: ruleMoveRight returns [EObject current=null] : ( () otherlv_1= '>' ) ;
    public final EObject ruleMoveRight() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:620:2: ( ( () otherlv_1= '>' ) )
            // InternalElemental.g:621:2: ( () otherlv_1= '>' )
            {
            // InternalElemental.g:621:2: ( () otherlv_1= '>' )
            // InternalElemental.g:622:3: () otherlv_1= '>'
            {
            // InternalElemental.g:622:3: ()
            // InternalElemental.g:623:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMoveRightAccess().getMoveRightAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_2); 

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
    // InternalElemental.g:637:1: entryRuleStore returns [EObject current=null] : iv_ruleStore= ruleStore EOF ;
    public final EObject entryRuleStore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStore = null;


        try {
            // InternalElemental.g:637:46: (iv_ruleStore= ruleStore EOF )
            // InternalElemental.g:638:2: iv_ruleStore= ruleStore EOF
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
    // InternalElemental.g:644:1: ruleStore returns [EObject current=null] : ( () otherlv_1= ',' ) ;
    public final EObject ruleStore() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:650:2: ( ( () otherlv_1= ',' ) )
            // InternalElemental.g:651:2: ( () otherlv_1= ',' )
            {
            // InternalElemental.g:651:2: ( () otherlv_1= ',' )
            // InternalElemental.g:652:3: () otherlv_1= ','
            {
            // InternalElemental.g:652:3: ()
            // InternalElemental.g:653:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStoreAccess().getStoreAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_2); 

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
    // InternalElemental.g:667:1: entryRuleRecall returns [EObject current=null] : iv_ruleRecall= ruleRecall EOF ;
    public final EObject entryRuleRecall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecall = null;


        try {
            // InternalElemental.g:667:47: (iv_ruleRecall= ruleRecall EOF )
            // InternalElemental.g:668:2: iv_ruleRecall= ruleRecall EOF
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
    // InternalElemental.g:674:1: ruleRecall returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleRecall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:680:2: ( ( () otherlv_1= '.' ) )
            // InternalElemental.g:681:2: ( () otherlv_1= '.' )
            {
            // InternalElemental.g:681:2: ( () otherlv_1= '.' )
            // InternalElemental.g:682:3: () otherlv_1= '.'
            {
            // InternalElemental.g:682:3: ()
            // InternalElemental.g:683:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRecallAccess().getRecallAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_2); 

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
    // InternalElemental.g:697:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalElemental.g:697:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalElemental.g:698:2: iv_ruleAssignment= ruleAssignment EOF
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
    // InternalElemental.g:704:1: ruleAssignment returns [EObject current=null] : ( () otherlv_1= '=' ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:710:2: ( ( () otherlv_1= '=' ) )
            // InternalElemental.g:711:2: ( () otherlv_1= '=' )
            {
            // InternalElemental.g:711:2: ( () otherlv_1= '=' )
            // InternalElemental.g:712:3: () otherlv_1= '='
            {
            // InternalElemental.g:712:3: ()
            // InternalElemental.g:713:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssignmentAccess().getAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_2); 

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
    // InternalElemental.g:727:1: entryRuleBranch returns [EObject current=null] : iv_ruleBranch= ruleBranch EOF ;
    public final EObject entryRuleBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranch = null;


        try {
            // InternalElemental.g:727:47: (iv_ruleBranch= ruleBranch EOF )
            // InternalElemental.g:728:2: iv_ruleBranch= ruleBranch EOF
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
    // InternalElemental.g:734:1: ruleBranch returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) ;
    public final EObject ruleBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:740:2: ( ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' ) )
            // InternalElemental.g:741:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            {
            // InternalElemental.g:741:2: ( () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')' )
            // InternalElemental.g:742:3: () otherlv_1= '(' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ')'
            {
            // InternalElemental.g:742:3: ()
            // InternalElemental.g:743:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBranchAccess().getBranchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBranchAccess().getLeftParenthesisKeyword_1());
            		
            // InternalElemental.g:753:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:754:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:754:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:755:5: lv_body_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getBranchAccess().getBodyBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
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

            otherlv_3=(Token)match(input,18,FOLLOW_2); 

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
    // InternalElemental.g:780:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalElemental.g:780:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalElemental.g:781:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalElemental.g:787:1: ruleLoop returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalElemental.g:793:2: ( ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' ) )
            // InternalElemental.g:794:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            {
            // InternalElemental.g:794:2: ( () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']' )
            // InternalElemental.g:795:3: () otherlv_1= '[' ( (lv_body_2_0= ruleBlock ) ) otherlv_3= ']'
            {
            // InternalElemental.g:795:3: ()
            // InternalElemental.g:796:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoopAccess().getLoopAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalElemental.g:806:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalElemental.g:807:4: (lv_body_2_0= ruleBlock )
            {
            // InternalElemental.g:807:4: (lv_body_2_0= ruleBlock )
            // InternalElemental.g:808:5: lv_body_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getBodyBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
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

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

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
    // InternalElemental.g:833:1: entryRuleGOTO returns [EObject current=null] : iv_ruleGOTO= ruleGOTO EOF ;
    public final EObject entryRuleGOTO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGOTO = null;


        try {
            // InternalElemental.g:833:45: (iv_ruleGOTO= ruleGOTO EOF )
            // InternalElemental.g:834:2: iv_ruleGOTO= ruleGOTO EOF
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
    // InternalElemental.g:840:1: ruleGOTO returns [EObject current=null] : ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' ) ;
    public final EObject ruleGOTO() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalElemental.g:846:2: ( ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' ) )
            // InternalElemental.g:847:2: ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' )
            {
            // InternalElemental.g:847:2: ( () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\'' )
            // InternalElemental.g:848:3: () otherlv_1= '\\'' ( (otherlv_2= RULE_ID ) ) otherlv_3= '\\''
            {
            // InternalElemental.g:848:3: ()
            // InternalElemental.g:849:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGOTOAccess().getGOTOAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getGOTOAccess().getApostropheKeyword_1());
            		
            // InternalElemental.g:859:3: ( (otherlv_2= RULE_ID ) )
            // InternalElemental.g:860:4: (otherlv_2= RULE_ID )
            {
            // InternalElemental.g:860:4: (otherlv_2= RULE_ID )
            // InternalElemental.g:861:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGOTORule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_2, grammarAccess.getGOTOAccess().getLabelLabelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); 

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
    // InternalElemental.g:880:1: entryRuleComputedGOTO returns [EObject current=null] : iv_ruleComputedGOTO= ruleComputedGOTO EOF ;
    public final EObject entryRuleComputedGOTO() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedGOTO = null;


        try {
            // InternalElemental.g:880:53: (iv_ruleComputedGOTO= ruleComputedGOTO EOF )
            // InternalElemental.g:881:2: iv_ruleComputedGOTO= ruleComputedGOTO EOF
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
    // InternalElemental.g:887:1: ruleComputedGOTO returns [EObject current=null] : ( () otherlv_1= '&' ) ;
    public final EObject ruleComputedGOTO() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:893:2: ( ( () otherlv_1= '&' ) )
            // InternalElemental.g:894:2: ( () otherlv_1= '&' )
            {
            // InternalElemental.g:894:2: ( () otherlv_1= '&' )
            // InternalElemental.g:895:3: () otherlv_1= '&'
            {
            // InternalElemental.g:895:3: ()
            // InternalElemental.g:896:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getComputedGOTOAccess().getComputedGOTOAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_2); 

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
    // InternalElemental.g:910:1: entryRuleStaticDispatch returns [EObject current=null] : iv_ruleStaticDispatch= ruleStaticDispatch EOF ;
    public final EObject entryRuleStaticDispatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticDispatch = null;


        try {
            // InternalElemental.g:910:55: (iv_ruleStaticDispatch= ruleStaticDispatch EOF )
            // InternalElemental.g:911:2: iv_ruleStaticDispatch= ruleStaticDispatch EOF
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
    // InternalElemental.g:917:1: ruleStaticDispatch returns [EObject current=null] : ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' ) ;
    public final EObject ruleStaticDispatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalElemental.g:923:2: ( ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' ) )
            // InternalElemental.g:924:2: ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' )
            {
            // InternalElemental.g:924:2: ( () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}' )
            // InternalElemental.g:925:3: () otherlv_1= '{' ( (otherlv_2= RULE_ID ) ) otherlv_3= '}'
            {
            // InternalElemental.g:925:3: ()
            // InternalElemental.g:926:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStaticDispatchAccess().getStaticDispatchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getStaticDispatchAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalElemental.g:936:3: ( (otherlv_2= RULE_ID ) )
            // InternalElemental.g:937:4: (otherlv_2= RULE_ID )
            {
            // InternalElemental.g:937:4: (otherlv_2= RULE_ID )
            // InternalElemental.g:938:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStaticDispatchRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_2, grammarAccess.getStaticDispatchAccess().getTargetFunctionCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

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
    // InternalElemental.g:957:1: entryRuleDynamicDispatch returns [EObject current=null] : iv_ruleDynamicDispatch= ruleDynamicDispatch EOF ;
    public final EObject entryRuleDynamicDispatch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDynamicDispatch = null;


        try {
            // InternalElemental.g:957:56: (iv_ruleDynamicDispatch= ruleDynamicDispatch EOF )
            // InternalElemental.g:958:2: iv_ruleDynamicDispatch= ruleDynamicDispatch EOF
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
    // InternalElemental.g:964:1: ruleDynamicDispatch returns [EObject current=null] : ( () otherlv_1= '?' ) ;
    public final EObject ruleDynamicDispatch() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalElemental.g:970:2: ( ( () otherlv_1= '?' ) )
            // InternalElemental.g:971:2: ( () otherlv_1= '?' )
            {
            // InternalElemental.g:971:2: ( () otherlv_1= '?' )
            // InternalElemental.g:972:3: () otherlv_1= '?'
            {
            // InternalElemental.g:972:3: ()
            // InternalElemental.g:973:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDynamicDispatchAccess().getDynamicDispatchAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_2); 

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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000002EBFD02L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002EBFD00L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});

}