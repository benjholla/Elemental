package com.benjholla.elemental.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import com.benjholla.elemental.services.ElementalGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalElementalParser extends AbstractInternalContentAssistParser {
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

    	public void setGrammarAccess(ElementalGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProgram"
    // InternalElemental.g:53:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // InternalElemental.g:54:1: ( ruleProgram EOF )
            // InternalElemental.g:55:1: ruleProgram EOF
            {
             before(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            ruleProgram();

            state._fsp--;

             after(grammarAccess.getProgramRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalElemental.g:62:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:66:2: ( ( ( rule__Program__Group__0 ) ) )
            // InternalElemental.g:67:2: ( ( rule__Program__Group__0 ) )
            {
            // InternalElemental.g:67:2: ( ( rule__Program__Group__0 ) )
            // InternalElemental.g:68:3: ( rule__Program__Group__0 )
            {
             before(grammarAccess.getProgramAccess().getGroup()); 
            // InternalElemental.g:69:3: ( rule__Program__Group__0 )
            // InternalElemental.g:69:4: rule__Program__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleBlock"
    // InternalElemental.g:78:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // InternalElemental.g:79:1: ( ruleBlock EOF )
            // InternalElemental.g:80:1: ruleBlock EOF
            {
             before(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalElemental.g:87:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:91:2: ( ( ( rule__Block__Group__0 ) ) )
            // InternalElemental.g:92:2: ( ( rule__Block__Group__0 ) )
            {
            // InternalElemental.g:92:2: ( ( rule__Block__Group__0 ) )
            // InternalElemental.g:93:3: ( rule__Block__Group__0 )
            {
             before(grammarAccess.getBlockAccess().getGroup()); 
            // InternalElemental.g:94:3: ( rule__Block__Group__0 )
            // InternalElemental.g:94:4: rule__Block__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleLabel"
    // InternalElemental.g:103:1: entryRuleLabel : ruleLabel EOF ;
    public final void entryRuleLabel() throws RecognitionException {
        try {
            // InternalElemental.g:104:1: ( ruleLabel EOF )
            // InternalElemental.g:105:1: ruleLabel EOF
            {
             before(grammarAccess.getLabelRule()); 
            pushFollow(FOLLOW_1);
            ruleLabel();

            state._fsp--;

             after(grammarAccess.getLabelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLabel"


    // $ANTLR start "ruleLabel"
    // InternalElemental.g:112:1: ruleLabel : ( ( rule__Label__Group__0 ) ) ;
    public final void ruleLabel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:116:2: ( ( ( rule__Label__Group__0 ) ) )
            // InternalElemental.g:117:2: ( ( rule__Label__Group__0 ) )
            {
            // InternalElemental.g:117:2: ( ( rule__Label__Group__0 ) )
            // InternalElemental.g:118:3: ( rule__Label__Group__0 )
            {
             before(grammarAccess.getLabelAccess().getGroup()); 
            // InternalElemental.g:119:3: ( rule__Label__Group__0 )
            // InternalElemental.g:119:4: rule__Label__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Label__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLabel"


    // $ANTLR start "entryRuleFunction"
    // InternalElemental.g:128:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // InternalElemental.g:129:1: ( ruleFunction EOF )
            // InternalElemental.g:130:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalElemental.g:137:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:141:2: ( ( ( rule__Function__Group__0 ) ) )
            // InternalElemental.g:142:2: ( ( rule__Function__Group__0 ) )
            {
            // InternalElemental.g:142:2: ( ( rule__Function__Group__0 ) )
            // InternalElemental.g:143:3: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // InternalElemental.g:144:3: ( rule__Function__Group__0 )
            // InternalElemental.g:144:4: rule__Function__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Function__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleInstruction"
    // InternalElemental.g:153:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // InternalElemental.g:154:1: ( ruleInstruction EOF )
            // InternalElemental.g:155:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalElemental.g:162:1: ruleInstruction : ( ( rule__Instruction__TypeAssignment ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:166:2: ( ( ( rule__Instruction__TypeAssignment ) ) )
            // InternalElemental.g:167:2: ( ( rule__Instruction__TypeAssignment ) )
            {
            // InternalElemental.g:167:2: ( ( rule__Instruction__TypeAssignment ) )
            // InternalElemental.g:168:3: ( rule__Instruction__TypeAssignment )
            {
             before(grammarAccess.getInstructionAccess().getTypeAssignment()); 
            // InternalElemental.g:169:3: ( rule__Instruction__TypeAssignment )
            // InternalElemental.g:169:4: rule__Instruction__TypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Instruction__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleIncrement"
    // InternalElemental.g:178:1: entryRuleIncrement : ruleIncrement EOF ;
    public final void entryRuleIncrement() throws RecognitionException {
        try {
            // InternalElemental.g:179:1: ( ruleIncrement EOF )
            // InternalElemental.g:180:1: ruleIncrement EOF
            {
             before(grammarAccess.getIncrementRule()); 
            pushFollow(FOLLOW_1);
            ruleIncrement();

            state._fsp--;

             after(grammarAccess.getIncrementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIncrement"


    // $ANTLR start "ruleIncrement"
    // InternalElemental.g:187:1: ruleIncrement : ( ( rule__Increment__Group__0 ) ) ;
    public final void ruleIncrement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:191:2: ( ( ( rule__Increment__Group__0 ) ) )
            // InternalElemental.g:192:2: ( ( rule__Increment__Group__0 ) )
            {
            // InternalElemental.g:192:2: ( ( rule__Increment__Group__0 ) )
            // InternalElemental.g:193:3: ( rule__Increment__Group__0 )
            {
             before(grammarAccess.getIncrementAccess().getGroup()); 
            // InternalElemental.g:194:3: ( rule__Increment__Group__0 )
            // InternalElemental.g:194:4: rule__Increment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Increment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIncrementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIncrement"


    // $ANTLR start "entryRuleDecrement"
    // InternalElemental.g:203:1: entryRuleDecrement : ruleDecrement EOF ;
    public final void entryRuleDecrement() throws RecognitionException {
        try {
            // InternalElemental.g:204:1: ( ruleDecrement EOF )
            // InternalElemental.g:205:1: ruleDecrement EOF
            {
             before(grammarAccess.getDecrementRule()); 
            pushFollow(FOLLOW_1);
            ruleDecrement();

            state._fsp--;

             after(grammarAccess.getDecrementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecrement"


    // $ANTLR start "ruleDecrement"
    // InternalElemental.g:212:1: ruleDecrement : ( ( rule__Decrement__Group__0 ) ) ;
    public final void ruleDecrement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:216:2: ( ( ( rule__Decrement__Group__0 ) ) )
            // InternalElemental.g:217:2: ( ( rule__Decrement__Group__0 ) )
            {
            // InternalElemental.g:217:2: ( ( rule__Decrement__Group__0 ) )
            // InternalElemental.g:218:3: ( rule__Decrement__Group__0 )
            {
             before(grammarAccess.getDecrementAccess().getGroup()); 
            // InternalElemental.g:219:3: ( rule__Decrement__Group__0 )
            // InternalElemental.g:219:4: rule__Decrement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Decrement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecrementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecrement"


    // $ANTLR start "entryRuleMoveLeft"
    // InternalElemental.g:228:1: entryRuleMoveLeft : ruleMoveLeft EOF ;
    public final void entryRuleMoveLeft() throws RecognitionException {
        try {
            // InternalElemental.g:229:1: ( ruleMoveLeft EOF )
            // InternalElemental.g:230:1: ruleMoveLeft EOF
            {
             before(grammarAccess.getMoveLeftRule()); 
            pushFollow(FOLLOW_1);
            ruleMoveLeft();

            state._fsp--;

             after(grammarAccess.getMoveLeftRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMoveLeft"


    // $ANTLR start "ruleMoveLeft"
    // InternalElemental.g:237:1: ruleMoveLeft : ( ( rule__MoveLeft__Group__0 ) ) ;
    public final void ruleMoveLeft() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:241:2: ( ( ( rule__MoveLeft__Group__0 ) ) )
            // InternalElemental.g:242:2: ( ( rule__MoveLeft__Group__0 ) )
            {
            // InternalElemental.g:242:2: ( ( rule__MoveLeft__Group__0 ) )
            // InternalElemental.g:243:3: ( rule__MoveLeft__Group__0 )
            {
             before(grammarAccess.getMoveLeftAccess().getGroup()); 
            // InternalElemental.g:244:3: ( rule__MoveLeft__Group__0 )
            // InternalElemental.g:244:4: rule__MoveLeft__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MoveLeft__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMoveLeftAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMoveLeft"


    // $ANTLR start "entryRuleMoveRight"
    // InternalElemental.g:253:1: entryRuleMoveRight : ruleMoveRight EOF ;
    public final void entryRuleMoveRight() throws RecognitionException {
        try {
            // InternalElemental.g:254:1: ( ruleMoveRight EOF )
            // InternalElemental.g:255:1: ruleMoveRight EOF
            {
             before(grammarAccess.getMoveRightRule()); 
            pushFollow(FOLLOW_1);
            ruleMoveRight();

            state._fsp--;

             after(grammarAccess.getMoveRightRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMoveRight"


    // $ANTLR start "ruleMoveRight"
    // InternalElemental.g:262:1: ruleMoveRight : ( ( rule__MoveRight__Group__0 ) ) ;
    public final void ruleMoveRight() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:266:2: ( ( ( rule__MoveRight__Group__0 ) ) )
            // InternalElemental.g:267:2: ( ( rule__MoveRight__Group__0 ) )
            {
            // InternalElemental.g:267:2: ( ( rule__MoveRight__Group__0 ) )
            // InternalElemental.g:268:3: ( rule__MoveRight__Group__0 )
            {
             before(grammarAccess.getMoveRightAccess().getGroup()); 
            // InternalElemental.g:269:3: ( rule__MoveRight__Group__0 )
            // InternalElemental.g:269:4: rule__MoveRight__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MoveRight__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMoveRightAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMoveRight"


    // $ANTLR start "entryRuleStore"
    // InternalElemental.g:278:1: entryRuleStore : ruleStore EOF ;
    public final void entryRuleStore() throws RecognitionException {
        try {
            // InternalElemental.g:279:1: ( ruleStore EOF )
            // InternalElemental.g:280:1: ruleStore EOF
            {
             before(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_1);
            ruleStore();

            state._fsp--;

             after(grammarAccess.getStoreRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStore"


    // $ANTLR start "ruleStore"
    // InternalElemental.g:287:1: ruleStore : ( ( rule__Store__Group__0 ) ) ;
    public final void ruleStore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:291:2: ( ( ( rule__Store__Group__0 ) ) )
            // InternalElemental.g:292:2: ( ( rule__Store__Group__0 ) )
            {
            // InternalElemental.g:292:2: ( ( rule__Store__Group__0 ) )
            // InternalElemental.g:293:3: ( rule__Store__Group__0 )
            {
             before(grammarAccess.getStoreAccess().getGroup()); 
            // InternalElemental.g:294:3: ( rule__Store__Group__0 )
            // InternalElemental.g:294:4: rule__Store__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Store__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStoreAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleRecall"
    // InternalElemental.g:303:1: entryRuleRecall : ruleRecall EOF ;
    public final void entryRuleRecall() throws RecognitionException {
        try {
            // InternalElemental.g:304:1: ( ruleRecall EOF )
            // InternalElemental.g:305:1: ruleRecall EOF
            {
             before(grammarAccess.getRecallRule()); 
            pushFollow(FOLLOW_1);
            ruleRecall();

            state._fsp--;

             after(grammarAccess.getRecallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRecall"


    // $ANTLR start "ruleRecall"
    // InternalElemental.g:312:1: ruleRecall : ( ( rule__Recall__Group__0 ) ) ;
    public final void ruleRecall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:316:2: ( ( ( rule__Recall__Group__0 ) ) )
            // InternalElemental.g:317:2: ( ( rule__Recall__Group__0 ) )
            {
            // InternalElemental.g:317:2: ( ( rule__Recall__Group__0 ) )
            // InternalElemental.g:318:3: ( rule__Recall__Group__0 )
            {
             before(grammarAccess.getRecallAccess().getGroup()); 
            // InternalElemental.g:319:3: ( rule__Recall__Group__0 )
            // InternalElemental.g:319:4: rule__Recall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Recall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecall"


    // $ANTLR start "entryRuleAssignment"
    // InternalElemental.g:328:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalElemental.g:329:1: ( ruleAssignment EOF )
            // InternalElemental.g:330:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalElemental.g:337:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:341:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalElemental.g:342:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalElemental.g:342:2: ( ( rule__Assignment__Group__0 ) )
            // InternalElemental.g:343:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalElemental.g:344:3: ( rule__Assignment__Group__0 )
            // InternalElemental.g:344:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleBranch"
    // InternalElemental.g:353:1: entryRuleBranch : ruleBranch EOF ;
    public final void entryRuleBranch() throws RecognitionException {
        try {
            // InternalElemental.g:354:1: ( ruleBranch EOF )
            // InternalElemental.g:355:1: ruleBranch EOF
            {
             before(grammarAccess.getBranchRule()); 
            pushFollow(FOLLOW_1);
            ruleBranch();

            state._fsp--;

             after(grammarAccess.getBranchRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBranch"


    // $ANTLR start "ruleBranch"
    // InternalElemental.g:362:1: ruleBranch : ( ( rule__Branch__Group__0 ) ) ;
    public final void ruleBranch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:366:2: ( ( ( rule__Branch__Group__0 ) ) )
            // InternalElemental.g:367:2: ( ( rule__Branch__Group__0 ) )
            {
            // InternalElemental.g:367:2: ( ( rule__Branch__Group__0 ) )
            // InternalElemental.g:368:3: ( rule__Branch__Group__0 )
            {
             before(grammarAccess.getBranchAccess().getGroup()); 
            // InternalElemental.g:369:3: ( rule__Branch__Group__0 )
            // InternalElemental.g:369:4: rule__Branch__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Branch__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBranchAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBranch"


    // $ANTLR start "entryRuleLoop"
    // InternalElemental.g:378:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // InternalElemental.g:379:1: ( ruleLoop EOF )
            // InternalElemental.g:380:1: ruleLoop EOF
            {
             before(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            ruleLoop();

            state._fsp--;

             after(grammarAccess.getLoopRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalElemental.g:387:1: ruleLoop : ( ( rule__Loop__Group__0 ) ) ;
    public final void ruleLoop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:391:2: ( ( ( rule__Loop__Group__0 ) ) )
            // InternalElemental.g:392:2: ( ( rule__Loop__Group__0 ) )
            {
            // InternalElemental.g:392:2: ( ( rule__Loop__Group__0 ) )
            // InternalElemental.g:393:3: ( rule__Loop__Group__0 )
            {
             before(grammarAccess.getLoopAccess().getGroup()); 
            // InternalElemental.g:394:3: ( rule__Loop__Group__0 )
            // InternalElemental.g:394:4: rule__Loop__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleGOTO"
    // InternalElemental.g:403:1: entryRuleGOTO : ruleGOTO EOF ;
    public final void entryRuleGOTO() throws RecognitionException {
        try {
            // InternalElemental.g:404:1: ( ruleGOTO EOF )
            // InternalElemental.g:405:1: ruleGOTO EOF
            {
             before(grammarAccess.getGOTORule()); 
            pushFollow(FOLLOW_1);
            ruleGOTO();

            state._fsp--;

             after(grammarAccess.getGOTORule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGOTO"


    // $ANTLR start "ruleGOTO"
    // InternalElemental.g:412:1: ruleGOTO : ( ( rule__GOTO__Group__0 ) ) ;
    public final void ruleGOTO() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:416:2: ( ( ( rule__GOTO__Group__0 ) ) )
            // InternalElemental.g:417:2: ( ( rule__GOTO__Group__0 ) )
            {
            // InternalElemental.g:417:2: ( ( rule__GOTO__Group__0 ) )
            // InternalElemental.g:418:3: ( rule__GOTO__Group__0 )
            {
             before(grammarAccess.getGOTOAccess().getGroup()); 
            // InternalElemental.g:419:3: ( rule__GOTO__Group__0 )
            // InternalElemental.g:419:4: rule__GOTO__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GOTO__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGOTOAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGOTO"


    // $ANTLR start "entryRuleComputedGOTO"
    // InternalElemental.g:428:1: entryRuleComputedGOTO : ruleComputedGOTO EOF ;
    public final void entryRuleComputedGOTO() throws RecognitionException {
        try {
            // InternalElemental.g:429:1: ( ruleComputedGOTO EOF )
            // InternalElemental.g:430:1: ruleComputedGOTO EOF
            {
             before(grammarAccess.getComputedGOTORule()); 
            pushFollow(FOLLOW_1);
            ruleComputedGOTO();

            state._fsp--;

             after(grammarAccess.getComputedGOTORule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComputedGOTO"


    // $ANTLR start "ruleComputedGOTO"
    // InternalElemental.g:437:1: ruleComputedGOTO : ( ( rule__ComputedGOTO__Group__0 ) ) ;
    public final void ruleComputedGOTO() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:441:2: ( ( ( rule__ComputedGOTO__Group__0 ) ) )
            // InternalElemental.g:442:2: ( ( rule__ComputedGOTO__Group__0 ) )
            {
            // InternalElemental.g:442:2: ( ( rule__ComputedGOTO__Group__0 ) )
            // InternalElemental.g:443:3: ( rule__ComputedGOTO__Group__0 )
            {
             before(grammarAccess.getComputedGOTOAccess().getGroup()); 
            // InternalElemental.g:444:3: ( rule__ComputedGOTO__Group__0 )
            // InternalElemental.g:444:4: rule__ComputedGOTO__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComputedGOTO__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComputedGOTOAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComputedGOTO"


    // $ANTLR start "entryRuleStaticDispatch"
    // InternalElemental.g:453:1: entryRuleStaticDispatch : ruleStaticDispatch EOF ;
    public final void entryRuleStaticDispatch() throws RecognitionException {
        try {
            // InternalElemental.g:454:1: ( ruleStaticDispatch EOF )
            // InternalElemental.g:455:1: ruleStaticDispatch EOF
            {
             before(grammarAccess.getStaticDispatchRule()); 
            pushFollow(FOLLOW_1);
            ruleStaticDispatch();

            state._fsp--;

             after(grammarAccess.getStaticDispatchRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStaticDispatch"


    // $ANTLR start "ruleStaticDispatch"
    // InternalElemental.g:462:1: ruleStaticDispatch : ( ( rule__StaticDispatch__Group__0 ) ) ;
    public final void ruleStaticDispatch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:466:2: ( ( ( rule__StaticDispatch__Group__0 ) ) )
            // InternalElemental.g:467:2: ( ( rule__StaticDispatch__Group__0 ) )
            {
            // InternalElemental.g:467:2: ( ( rule__StaticDispatch__Group__0 ) )
            // InternalElemental.g:468:3: ( rule__StaticDispatch__Group__0 )
            {
             before(grammarAccess.getStaticDispatchAccess().getGroup()); 
            // InternalElemental.g:469:3: ( rule__StaticDispatch__Group__0 )
            // InternalElemental.g:469:4: rule__StaticDispatch__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StaticDispatch__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStaticDispatchAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStaticDispatch"


    // $ANTLR start "entryRuleDynamicDispatch"
    // InternalElemental.g:478:1: entryRuleDynamicDispatch : ruleDynamicDispatch EOF ;
    public final void entryRuleDynamicDispatch() throws RecognitionException {
        try {
            // InternalElemental.g:479:1: ( ruleDynamicDispatch EOF )
            // InternalElemental.g:480:1: ruleDynamicDispatch EOF
            {
             before(grammarAccess.getDynamicDispatchRule()); 
            pushFollow(FOLLOW_1);
            ruleDynamicDispatch();

            state._fsp--;

             after(grammarAccess.getDynamicDispatchRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDynamicDispatch"


    // $ANTLR start "ruleDynamicDispatch"
    // InternalElemental.g:487:1: ruleDynamicDispatch : ( ( rule__DynamicDispatch__Group__0 ) ) ;
    public final void ruleDynamicDispatch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:491:2: ( ( ( rule__DynamicDispatch__Group__0 ) ) )
            // InternalElemental.g:492:2: ( ( rule__DynamicDispatch__Group__0 ) )
            {
            // InternalElemental.g:492:2: ( ( rule__DynamicDispatch__Group__0 ) )
            // InternalElemental.g:493:3: ( rule__DynamicDispatch__Group__0 )
            {
             before(grammarAccess.getDynamicDispatchAccess().getGroup()); 
            // InternalElemental.g:494:3: ( rule__DynamicDispatch__Group__0 )
            // InternalElemental.g:494:4: rule__DynamicDispatch__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DynamicDispatch__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDynamicDispatchAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDynamicDispatch"


    // $ANTLR start "rule__Instruction__TypeAlternatives_0"
    // InternalElemental.g:502:1: rule__Instruction__TypeAlternatives_0 : ( ( ruleIncrement ) | ( ruleDecrement ) | ( ruleMoveLeft ) | ( ruleMoveRight ) | ( ruleStore ) | ( ruleRecall ) | ( ruleAssignment ) | ( ruleBranch ) | ( ruleLoop ) | ( ruleLabel ) | ( ruleGOTO ) | ( ruleComputedGOTO ) | ( ruleStaticDispatch ) | ( ruleDynamicDispatch ) );
    public final void rule__Instruction__TypeAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:506:1: ( ( ruleIncrement ) | ( ruleDecrement ) | ( ruleMoveLeft ) | ( ruleMoveRight ) | ( ruleStore ) | ( ruleRecall ) | ( ruleAssignment ) | ( ruleBranch ) | ( ruleLoop ) | ( ruleLabel ) | ( ruleGOTO ) | ( ruleComputedGOTO ) | ( ruleStaticDispatch ) | ( ruleDynamicDispatch ) )
            int alt1=14;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 13:
                {
                alt1=4;
                }
                break;
            case 14:
                {
                alt1=5;
                }
                break;
            case 15:
                {
                alt1=6;
                }
                break;
            case 16:
                {
                alt1=7;
                }
                break;
            case 17:
                {
                alt1=8;
                }
                break;
            case 19:
                {
                alt1=9;
                }
                break;
            case 8:
                {
                alt1=10;
                }
                break;
            case 21:
                {
                alt1=11;
                }
                break;
            case 22:
                {
                alt1=12;
                }
                break;
            case 23:
                {
                alt1=13;
                }
                break;
            case 25:
                {
                alt1=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalElemental.g:507:2: ( ruleIncrement )
                    {
                    // InternalElemental.g:507:2: ( ruleIncrement )
                    // InternalElemental.g:508:3: ruleIncrement
                    {
                     before(grammarAccess.getInstructionAccess().getTypeIncrementParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIncrement();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeIncrementParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalElemental.g:513:2: ( ruleDecrement )
                    {
                    // InternalElemental.g:513:2: ( ruleDecrement )
                    // InternalElemental.g:514:3: ruleDecrement
                    {
                     before(grammarAccess.getInstructionAccess().getTypeDecrementParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDecrement();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeDecrementParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalElemental.g:519:2: ( ruleMoveLeft )
                    {
                    // InternalElemental.g:519:2: ( ruleMoveLeft )
                    // InternalElemental.g:520:3: ruleMoveLeft
                    {
                     before(grammarAccess.getInstructionAccess().getTypeMoveLeftParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleMoveLeft();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeMoveLeftParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalElemental.g:525:2: ( ruleMoveRight )
                    {
                    // InternalElemental.g:525:2: ( ruleMoveRight )
                    // InternalElemental.g:526:3: ruleMoveRight
                    {
                     before(grammarAccess.getInstructionAccess().getTypeMoveRightParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleMoveRight();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeMoveRightParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalElemental.g:531:2: ( ruleStore )
                    {
                    // InternalElemental.g:531:2: ( ruleStore )
                    // InternalElemental.g:532:3: ruleStore
                    {
                     before(grammarAccess.getInstructionAccess().getTypeStoreParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_2);
                    ruleStore();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeStoreParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalElemental.g:537:2: ( ruleRecall )
                    {
                    // InternalElemental.g:537:2: ( ruleRecall )
                    // InternalElemental.g:538:3: ruleRecall
                    {
                     before(grammarAccess.getInstructionAccess().getTypeRecallParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_2);
                    ruleRecall();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeRecallParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalElemental.g:543:2: ( ruleAssignment )
                    {
                    // InternalElemental.g:543:2: ( ruleAssignment )
                    // InternalElemental.g:544:3: ruleAssignment
                    {
                     before(grammarAccess.getInstructionAccess().getTypeAssignmentParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeAssignmentParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalElemental.g:549:2: ( ruleBranch )
                    {
                    // InternalElemental.g:549:2: ( ruleBranch )
                    // InternalElemental.g:550:3: ruleBranch
                    {
                     before(grammarAccess.getInstructionAccess().getTypeBranchParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_2);
                    ruleBranch();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeBranchParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalElemental.g:555:2: ( ruleLoop )
                    {
                    // InternalElemental.g:555:2: ( ruleLoop )
                    // InternalElemental.g:556:3: ruleLoop
                    {
                     before(grammarAccess.getInstructionAccess().getTypeLoopParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_2);
                    ruleLoop();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeLoopParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalElemental.g:561:2: ( ruleLabel )
                    {
                    // InternalElemental.g:561:2: ( ruleLabel )
                    // InternalElemental.g:562:3: ruleLabel
                    {
                     before(grammarAccess.getInstructionAccess().getTypeLabelParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_2);
                    ruleLabel();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeLabelParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalElemental.g:567:2: ( ruleGOTO )
                    {
                    // InternalElemental.g:567:2: ( ruleGOTO )
                    // InternalElemental.g:568:3: ruleGOTO
                    {
                     before(grammarAccess.getInstructionAccess().getTypeGOTOParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_2);
                    ruleGOTO();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeGOTOParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalElemental.g:573:2: ( ruleComputedGOTO )
                    {
                    // InternalElemental.g:573:2: ( ruleComputedGOTO )
                    // InternalElemental.g:574:3: ruleComputedGOTO
                    {
                     before(grammarAccess.getInstructionAccess().getTypeComputedGOTOParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_2);
                    ruleComputedGOTO();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeComputedGOTOParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalElemental.g:579:2: ( ruleStaticDispatch )
                    {
                    // InternalElemental.g:579:2: ( ruleStaticDispatch )
                    // InternalElemental.g:580:3: ruleStaticDispatch
                    {
                     before(grammarAccess.getInstructionAccess().getTypeStaticDispatchParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_2);
                    ruleStaticDispatch();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeStaticDispatchParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalElemental.g:585:2: ( ruleDynamicDispatch )
                    {
                    // InternalElemental.g:585:2: ( ruleDynamicDispatch )
                    // InternalElemental.g:586:3: ruleDynamicDispatch
                    {
                     before(grammarAccess.getInstructionAccess().getTypeDynamicDispatchParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_2);
                    ruleDynamicDispatch();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTypeDynamicDispatchParserRuleCall_0_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__TypeAlternatives_0"


    // $ANTLR start "rule__Program__Group__0"
    // InternalElemental.g:595:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:599:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalElemental.g:600:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Program__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0"


    // $ANTLR start "rule__Program__Group__0__Impl"
    // InternalElemental.g:607:1: rule__Program__Group__0__Impl : ( ( rule__Program__ImplicitFunctionAssignment_0 ) ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:611:1: ( ( ( rule__Program__ImplicitFunctionAssignment_0 ) ) )
            // InternalElemental.g:612:1: ( ( rule__Program__ImplicitFunctionAssignment_0 ) )
            {
            // InternalElemental.g:612:1: ( ( rule__Program__ImplicitFunctionAssignment_0 ) )
            // InternalElemental.g:613:2: ( rule__Program__ImplicitFunctionAssignment_0 )
            {
             before(grammarAccess.getProgramAccess().getImplicitFunctionAssignment_0()); 
            // InternalElemental.g:614:2: ( rule__Program__ImplicitFunctionAssignment_0 )
            // InternalElemental.g:614:3: rule__Program__ImplicitFunctionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Program__ImplicitFunctionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getImplicitFunctionAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0__Impl"


    // $ANTLR start "rule__Program__Group__1"
    // InternalElemental.g:622:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:626:1: ( rule__Program__Group__1__Impl )
            // InternalElemental.g:627:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1"


    // $ANTLR start "rule__Program__Group__1__Impl"
    // InternalElemental.g:633:1: rule__Program__Group__1__Impl : ( ( rule__Program__ExplicitFunctionsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:637:1: ( ( ( rule__Program__ExplicitFunctionsAssignment_1 )* ) )
            // InternalElemental.g:638:1: ( ( rule__Program__ExplicitFunctionsAssignment_1 )* )
            {
            // InternalElemental.g:638:1: ( ( rule__Program__ExplicitFunctionsAssignment_1 )* )
            // InternalElemental.g:639:2: ( rule__Program__ExplicitFunctionsAssignment_1 )*
            {
             before(grammarAccess.getProgramAccess().getExplicitFunctionsAssignment_1()); 
            // InternalElemental.g:640:2: ( rule__Program__ExplicitFunctionsAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalElemental.g:640:3: rule__Program__ExplicitFunctionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Program__ExplicitFunctionsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getExplicitFunctionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1__Impl"


    // $ANTLR start "rule__Block__Group__0"
    // InternalElemental.g:649:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:653:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalElemental.g:654:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Block__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0"


    // $ANTLR start "rule__Block__Group__0__Impl"
    // InternalElemental.g:661:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:665:1: ( ( () ) )
            // InternalElemental.g:666:1: ( () )
            {
            // InternalElemental.g:666:1: ( () )
            // InternalElemental.g:667:2: ()
            {
             before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            // InternalElemental.g:668:2: ()
            // InternalElemental.g:668:3: 
            {
            }

             after(grammarAccess.getBlockAccess().getBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0__Impl"


    // $ANTLR start "rule__Block__Group__1"
    // InternalElemental.g:676:1: rule__Block__Group__1 : rule__Block__Group__1__Impl ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:680:1: ( rule__Block__Group__1__Impl )
            // InternalElemental.g:681:2: rule__Block__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1"


    // $ANTLR start "rule__Block__Group__1__Impl"
    // InternalElemental.g:687:1: rule__Block__Group__1__Impl : ( ( rule__Block__InstructionsAssignment_1 )* ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:691:1: ( ( ( rule__Block__InstructionsAssignment_1 )* ) )
            // InternalElemental.g:692:1: ( ( rule__Block__InstructionsAssignment_1 )* )
            {
            // InternalElemental.g:692:1: ( ( rule__Block__InstructionsAssignment_1 )* )
            // InternalElemental.g:693:2: ( rule__Block__InstructionsAssignment_1 )*
            {
             before(grammarAccess.getBlockAccess().getInstructionsAssignment_1()); 
            // InternalElemental.g:694:2: ( rule__Block__InstructionsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==8||(LA3_0>=10 && LA3_0<=17)||LA3_0==19||(LA3_0>=21 && LA3_0<=23)||LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalElemental.g:694:3: rule__Block__InstructionsAssignment_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Block__InstructionsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getBlockAccess().getInstructionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1__Impl"


    // $ANTLR start "rule__Label__Group__0"
    // InternalElemental.g:703:1: rule__Label__Group__0 : rule__Label__Group__0__Impl rule__Label__Group__1 ;
    public final void rule__Label__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:707:1: ( rule__Label__Group__0__Impl rule__Label__Group__1 )
            // InternalElemental.g:708:2: rule__Label__Group__0__Impl rule__Label__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Label__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Label__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0"


    // $ANTLR start "rule__Label__Group__0__Impl"
    // InternalElemental.g:715:1: rule__Label__Group__0__Impl : ( '\"' ) ;
    public final void rule__Label__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:719:1: ( ( '\"' ) )
            // InternalElemental.g:720:1: ( '\"' )
            {
            // InternalElemental.g:720:1: ( '\"' )
            // InternalElemental.g:721:2: '\"'
            {
             before(grammarAccess.getLabelAccess().getQuotationMarkKeyword_0()); 
            match(input,8,FOLLOW_2); 
             after(grammarAccess.getLabelAccess().getQuotationMarkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__0__Impl"


    // $ANTLR start "rule__Label__Group__1"
    // InternalElemental.g:730:1: rule__Label__Group__1 : rule__Label__Group__1__Impl rule__Label__Group__2 ;
    public final void rule__Label__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:734:1: ( rule__Label__Group__1__Impl rule__Label__Group__2 )
            // InternalElemental.g:735:2: rule__Label__Group__1__Impl rule__Label__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Label__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Label__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1"


    // $ANTLR start "rule__Label__Group__1__Impl"
    // InternalElemental.g:742:1: rule__Label__Group__1__Impl : ( ( rule__Label__NameAssignment_1 ) ) ;
    public final void rule__Label__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:746:1: ( ( ( rule__Label__NameAssignment_1 ) ) )
            // InternalElemental.g:747:1: ( ( rule__Label__NameAssignment_1 ) )
            {
            // InternalElemental.g:747:1: ( ( rule__Label__NameAssignment_1 ) )
            // InternalElemental.g:748:2: ( rule__Label__NameAssignment_1 )
            {
             before(grammarAccess.getLabelAccess().getNameAssignment_1()); 
            // InternalElemental.g:749:2: ( rule__Label__NameAssignment_1 )
            // InternalElemental.g:749:3: rule__Label__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Label__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLabelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__1__Impl"


    // $ANTLR start "rule__Label__Group__2"
    // InternalElemental.g:757:1: rule__Label__Group__2 : rule__Label__Group__2__Impl ;
    public final void rule__Label__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:761:1: ( rule__Label__Group__2__Impl )
            // InternalElemental.g:762:2: rule__Label__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Label__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__2"


    // $ANTLR start "rule__Label__Group__2__Impl"
    // InternalElemental.g:768:1: rule__Label__Group__2__Impl : ( '\"' ) ;
    public final void rule__Label__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:772:1: ( ( '\"' ) )
            // InternalElemental.g:773:1: ( '\"' )
            {
            // InternalElemental.g:773:1: ( '\"' )
            // InternalElemental.g:774:2: '\"'
            {
             before(grammarAccess.getLabelAccess().getQuotationMarkKeyword_2()); 
            match(input,8,FOLLOW_2); 
             after(grammarAccess.getLabelAccess().getQuotationMarkKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__Group__2__Impl"


    // $ANTLR start "rule__Function__Group__0"
    // InternalElemental.g:784:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:788:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // InternalElemental.g:789:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Function__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0"


    // $ANTLR start "rule__Function__Group__0__Impl"
    // InternalElemental.g:796:1: rule__Function__Group__0__Impl : ( ( rule__Function__NameAssignment_0 ) ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:800:1: ( ( ( rule__Function__NameAssignment_0 ) ) )
            // InternalElemental.g:801:1: ( ( rule__Function__NameAssignment_0 ) )
            {
            // InternalElemental.g:801:1: ( ( rule__Function__NameAssignment_0 ) )
            // InternalElemental.g:802:2: ( rule__Function__NameAssignment_0 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_0()); 
            // InternalElemental.g:803:2: ( rule__Function__NameAssignment_0 )
            // InternalElemental.g:803:3: rule__Function__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Function__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0__Impl"


    // $ANTLR start "rule__Function__Group__1"
    // InternalElemental.g:811:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:815:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // InternalElemental.g:816:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Function__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1"


    // $ANTLR start "rule__Function__Group__1__Impl"
    // InternalElemental.g:823:1: rule__Function__Group__1__Impl : ( ':' ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:827:1: ( ( ':' ) )
            // InternalElemental.g:828:1: ( ':' )
            {
            // InternalElemental.g:828:1: ( ':' )
            // InternalElemental.g:829:2: ':'
            {
             before(grammarAccess.getFunctionAccess().getColonKeyword_1()); 
            match(input,9,FOLLOW_2); 
             after(grammarAccess.getFunctionAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1__Impl"


    // $ANTLR start "rule__Function__Group__2"
    // InternalElemental.g:838:1: rule__Function__Group__2 : rule__Function__Group__2__Impl ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:842:1: ( rule__Function__Group__2__Impl )
            // InternalElemental.g:843:2: rule__Function__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Function__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__2"


    // $ANTLR start "rule__Function__Group__2__Impl"
    // InternalElemental.g:849:1: rule__Function__Group__2__Impl : ( ( rule__Function__BodyAssignment_2 ) ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:853:1: ( ( ( rule__Function__BodyAssignment_2 ) ) )
            // InternalElemental.g:854:1: ( ( rule__Function__BodyAssignment_2 ) )
            {
            // InternalElemental.g:854:1: ( ( rule__Function__BodyAssignment_2 ) )
            // InternalElemental.g:855:2: ( rule__Function__BodyAssignment_2 )
            {
             before(grammarAccess.getFunctionAccess().getBodyAssignment_2()); 
            // InternalElemental.g:856:2: ( rule__Function__BodyAssignment_2 )
            // InternalElemental.g:856:3: rule__Function__BodyAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Function__BodyAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getBodyAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__2__Impl"


    // $ANTLR start "rule__Increment__Group__0"
    // InternalElemental.g:865:1: rule__Increment__Group__0 : rule__Increment__Group__0__Impl rule__Increment__Group__1 ;
    public final void rule__Increment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:869:1: ( rule__Increment__Group__0__Impl rule__Increment__Group__1 )
            // InternalElemental.g:870:2: rule__Increment__Group__0__Impl rule__Increment__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Increment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Increment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Increment__Group__0"


    // $ANTLR start "rule__Increment__Group__0__Impl"
    // InternalElemental.g:877:1: rule__Increment__Group__0__Impl : ( () ) ;
    public final void rule__Increment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:881:1: ( ( () ) )
            // InternalElemental.g:882:1: ( () )
            {
            // InternalElemental.g:882:1: ( () )
            // InternalElemental.g:883:2: ()
            {
             before(grammarAccess.getIncrementAccess().getIncrementAction_0()); 
            // InternalElemental.g:884:2: ()
            // InternalElemental.g:884:3: 
            {
            }

             after(grammarAccess.getIncrementAccess().getIncrementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Increment__Group__0__Impl"


    // $ANTLR start "rule__Increment__Group__1"
    // InternalElemental.g:892:1: rule__Increment__Group__1 : rule__Increment__Group__1__Impl ;
    public final void rule__Increment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:896:1: ( rule__Increment__Group__1__Impl )
            // InternalElemental.g:897:2: rule__Increment__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Increment__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Increment__Group__1"


    // $ANTLR start "rule__Increment__Group__1__Impl"
    // InternalElemental.g:903:1: rule__Increment__Group__1__Impl : ( '+' ) ;
    public final void rule__Increment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:907:1: ( ( '+' ) )
            // InternalElemental.g:908:1: ( '+' )
            {
            // InternalElemental.g:908:1: ( '+' )
            // InternalElemental.g:909:2: '+'
            {
             before(grammarAccess.getIncrementAccess().getPlusSignKeyword_1()); 
            match(input,10,FOLLOW_2); 
             after(grammarAccess.getIncrementAccess().getPlusSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Increment__Group__1__Impl"


    // $ANTLR start "rule__Decrement__Group__0"
    // InternalElemental.g:919:1: rule__Decrement__Group__0 : rule__Decrement__Group__0__Impl rule__Decrement__Group__1 ;
    public final void rule__Decrement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:923:1: ( rule__Decrement__Group__0__Impl rule__Decrement__Group__1 )
            // InternalElemental.g:924:2: rule__Decrement__Group__0__Impl rule__Decrement__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Decrement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decrement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decrement__Group__0"


    // $ANTLR start "rule__Decrement__Group__0__Impl"
    // InternalElemental.g:931:1: rule__Decrement__Group__0__Impl : ( () ) ;
    public final void rule__Decrement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:935:1: ( ( () ) )
            // InternalElemental.g:936:1: ( () )
            {
            // InternalElemental.g:936:1: ( () )
            // InternalElemental.g:937:2: ()
            {
             before(grammarAccess.getDecrementAccess().getDecrementAction_0()); 
            // InternalElemental.g:938:2: ()
            // InternalElemental.g:938:3: 
            {
            }

             after(grammarAccess.getDecrementAccess().getDecrementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decrement__Group__0__Impl"


    // $ANTLR start "rule__Decrement__Group__1"
    // InternalElemental.g:946:1: rule__Decrement__Group__1 : rule__Decrement__Group__1__Impl ;
    public final void rule__Decrement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:950:1: ( rule__Decrement__Group__1__Impl )
            // InternalElemental.g:951:2: rule__Decrement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Decrement__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decrement__Group__1"


    // $ANTLR start "rule__Decrement__Group__1__Impl"
    // InternalElemental.g:957:1: rule__Decrement__Group__1__Impl : ( '-' ) ;
    public final void rule__Decrement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:961:1: ( ( '-' ) )
            // InternalElemental.g:962:1: ( '-' )
            {
            // InternalElemental.g:962:1: ( '-' )
            // InternalElemental.g:963:2: '-'
            {
             before(grammarAccess.getDecrementAccess().getHyphenMinusKeyword_1()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getDecrementAccess().getHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decrement__Group__1__Impl"


    // $ANTLR start "rule__MoveLeft__Group__0"
    // InternalElemental.g:973:1: rule__MoveLeft__Group__0 : rule__MoveLeft__Group__0__Impl rule__MoveLeft__Group__1 ;
    public final void rule__MoveLeft__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:977:1: ( rule__MoveLeft__Group__0__Impl rule__MoveLeft__Group__1 )
            // InternalElemental.g:978:2: rule__MoveLeft__Group__0__Impl rule__MoveLeft__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__MoveLeft__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MoveLeft__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveLeft__Group__0"


    // $ANTLR start "rule__MoveLeft__Group__0__Impl"
    // InternalElemental.g:985:1: rule__MoveLeft__Group__0__Impl : ( () ) ;
    public final void rule__MoveLeft__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:989:1: ( ( () ) )
            // InternalElemental.g:990:1: ( () )
            {
            // InternalElemental.g:990:1: ( () )
            // InternalElemental.g:991:2: ()
            {
             before(grammarAccess.getMoveLeftAccess().getMoveLeftAction_0()); 
            // InternalElemental.g:992:2: ()
            // InternalElemental.g:992:3: 
            {
            }

             after(grammarAccess.getMoveLeftAccess().getMoveLeftAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveLeft__Group__0__Impl"


    // $ANTLR start "rule__MoveLeft__Group__1"
    // InternalElemental.g:1000:1: rule__MoveLeft__Group__1 : rule__MoveLeft__Group__1__Impl ;
    public final void rule__MoveLeft__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1004:1: ( rule__MoveLeft__Group__1__Impl )
            // InternalElemental.g:1005:2: rule__MoveLeft__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MoveLeft__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveLeft__Group__1"


    // $ANTLR start "rule__MoveLeft__Group__1__Impl"
    // InternalElemental.g:1011:1: rule__MoveLeft__Group__1__Impl : ( '<' ) ;
    public final void rule__MoveLeft__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1015:1: ( ( '<' ) )
            // InternalElemental.g:1016:1: ( '<' )
            {
            // InternalElemental.g:1016:1: ( '<' )
            // InternalElemental.g:1017:2: '<'
            {
             before(grammarAccess.getMoveLeftAccess().getLessThanSignKeyword_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getMoveLeftAccess().getLessThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveLeft__Group__1__Impl"


    // $ANTLR start "rule__MoveRight__Group__0"
    // InternalElemental.g:1027:1: rule__MoveRight__Group__0 : rule__MoveRight__Group__0__Impl rule__MoveRight__Group__1 ;
    public final void rule__MoveRight__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1031:1: ( rule__MoveRight__Group__0__Impl rule__MoveRight__Group__1 )
            // InternalElemental.g:1032:2: rule__MoveRight__Group__0__Impl rule__MoveRight__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__MoveRight__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MoveRight__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveRight__Group__0"


    // $ANTLR start "rule__MoveRight__Group__0__Impl"
    // InternalElemental.g:1039:1: rule__MoveRight__Group__0__Impl : ( () ) ;
    public final void rule__MoveRight__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1043:1: ( ( () ) )
            // InternalElemental.g:1044:1: ( () )
            {
            // InternalElemental.g:1044:1: ( () )
            // InternalElemental.g:1045:2: ()
            {
             before(grammarAccess.getMoveRightAccess().getMoveRightAction_0()); 
            // InternalElemental.g:1046:2: ()
            // InternalElemental.g:1046:3: 
            {
            }

             after(grammarAccess.getMoveRightAccess().getMoveRightAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveRight__Group__0__Impl"


    // $ANTLR start "rule__MoveRight__Group__1"
    // InternalElemental.g:1054:1: rule__MoveRight__Group__1 : rule__MoveRight__Group__1__Impl ;
    public final void rule__MoveRight__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1058:1: ( rule__MoveRight__Group__1__Impl )
            // InternalElemental.g:1059:2: rule__MoveRight__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MoveRight__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveRight__Group__1"


    // $ANTLR start "rule__MoveRight__Group__1__Impl"
    // InternalElemental.g:1065:1: rule__MoveRight__Group__1__Impl : ( '>' ) ;
    public final void rule__MoveRight__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1069:1: ( ( '>' ) )
            // InternalElemental.g:1070:1: ( '>' )
            {
            // InternalElemental.g:1070:1: ( '>' )
            // InternalElemental.g:1071:2: '>'
            {
             before(grammarAccess.getMoveRightAccess().getGreaterThanSignKeyword_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getMoveRightAccess().getGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MoveRight__Group__1__Impl"


    // $ANTLR start "rule__Store__Group__0"
    // InternalElemental.g:1081:1: rule__Store__Group__0 : rule__Store__Group__0__Impl rule__Store__Group__1 ;
    public final void rule__Store__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1085:1: ( rule__Store__Group__0__Impl rule__Store__Group__1 )
            // InternalElemental.g:1086:2: rule__Store__Group__0__Impl rule__Store__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Store__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Store__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Store__Group__0"


    // $ANTLR start "rule__Store__Group__0__Impl"
    // InternalElemental.g:1093:1: rule__Store__Group__0__Impl : ( () ) ;
    public final void rule__Store__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1097:1: ( ( () ) )
            // InternalElemental.g:1098:1: ( () )
            {
            // InternalElemental.g:1098:1: ( () )
            // InternalElemental.g:1099:2: ()
            {
             before(grammarAccess.getStoreAccess().getStoreAction_0()); 
            // InternalElemental.g:1100:2: ()
            // InternalElemental.g:1100:3: 
            {
            }

             after(grammarAccess.getStoreAccess().getStoreAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Store__Group__0__Impl"


    // $ANTLR start "rule__Store__Group__1"
    // InternalElemental.g:1108:1: rule__Store__Group__1 : rule__Store__Group__1__Impl ;
    public final void rule__Store__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1112:1: ( rule__Store__Group__1__Impl )
            // InternalElemental.g:1113:2: rule__Store__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Store__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Store__Group__1"


    // $ANTLR start "rule__Store__Group__1__Impl"
    // InternalElemental.g:1119:1: rule__Store__Group__1__Impl : ( ',' ) ;
    public final void rule__Store__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1123:1: ( ( ',' ) )
            // InternalElemental.g:1124:1: ( ',' )
            {
            // InternalElemental.g:1124:1: ( ',' )
            // InternalElemental.g:1125:2: ','
            {
             before(grammarAccess.getStoreAccess().getCommaKeyword_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getStoreAccess().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Store__Group__1__Impl"


    // $ANTLR start "rule__Recall__Group__0"
    // InternalElemental.g:1135:1: rule__Recall__Group__0 : rule__Recall__Group__0__Impl rule__Recall__Group__1 ;
    public final void rule__Recall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1139:1: ( rule__Recall__Group__0__Impl rule__Recall__Group__1 )
            // InternalElemental.g:1140:2: rule__Recall__Group__0__Impl rule__Recall__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Recall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recall__Group__0"


    // $ANTLR start "rule__Recall__Group__0__Impl"
    // InternalElemental.g:1147:1: rule__Recall__Group__0__Impl : ( () ) ;
    public final void rule__Recall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1151:1: ( ( () ) )
            // InternalElemental.g:1152:1: ( () )
            {
            // InternalElemental.g:1152:1: ( () )
            // InternalElemental.g:1153:2: ()
            {
             before(grammarAccess.getRecallAccess().getRecallAction_0()); 
            // InternalElemental.g:1154:2: ()
            // InternalElemental.g:1154:3: 
            {
            }

             after(grammarAccess.getRecallAccess().getRecallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recall__Group__0__Impl"


    // $ANTLR start "rule__Recall__Group__1"
    // InternalElemental.g:1162:1: rule__Recall__Group__1 : rule__Recall__Group__1__Impl ;
    public final void rule__Recall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1166:1: ( rule__Recall__Group__1__Impl )
            // InternalElemental.g:1167:2: rule__Recall__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Recall__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recall__Group__1"


    // $ANTLR start "rule__Recall__Group__1__Impl"
    // InternalElemental.g:1173:1: rule__Recall__Group__1__Impl : ( '.' ) ;
    public final void rule__Recall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1177:1: ( ( '.' ) )
            // InternalElemental.g:1178:1: ( '.' )
            {
            // InternalElemental.g:1178:1: ( '.' )
            // InternalElemental.g:1179:2: '.'
            {
             before(grammarAccess.getRecallAccess().getFullStopKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getRecallAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recall__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalElemental.g:1189:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1193:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalElemental.g:1194:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalElemental.g:1201:1: rule__Assignment__Group__0__Impl : ( () ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1205:1: ( ( () ) )
            // InternalElemental.g:1206:1: ( () )
            {
            // InternalElemental.g:1206:1: ( () )
            // InternalElemental.g:1207:2: ()
            {
             before(grammarAccess.getAssignmentAccess().getAssignmentAction_0()); 
            // InternalElemental.g:1208:2: ()
            // InternalElemental.g:1208:3: 
            {
            }

             after(grammarAccess.getAssignmentAccess().getAssignmentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalElemental.g:1216:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1220:1: ( rule__Assignment__Group__1__Impl )
            // InternalElemental.g:1221:2: rule__Assignment__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalElemental.g:1227:1: rule__Assignment__Group__1__Impl : ( '=' ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1231:1: ( ( '=' ) )
            // InternalElemental.g:1232:1: ( '=' )
            {
            // InternalElemental.g:1232:1: ( '=' )
            // InternalElemental.g:1233:2: '='
            {
             before(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Branch__Group__0"
    // InternalElemental.g:1243:1: rule__Branch__Group__0 : rule__Branch__Group__0__Impl rule__Branch__Group__1 ;
    public final void rule__Branch__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1247:1: ( rule__Branch__Group__0__Impl rule__Branch__Group__1 )
            // InternalElemental.g:1248:2: rule__Branch__Group__0__Impl rule__Branch__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Branch__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Branch__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__0"


    // $ANTLR start "rule__Branch__Group__0__Impl"
    // InternalElemental.g:1255:1: rule__Branch__Group__0__Impl : ( () ) ;
    public final void rule__Branch__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1259:1: ( ( () ) )
            // InternalElemental.g:1260:1: ( () )
            {
            // InternalElemental.g:1260:1: ( () )
            // InternalElemental.g:1261:2: ()
            {
             before(grammarAccess.getBranchAccess().getBranchAction_0()); 
            // InternalElemental.g:1262:2: ()
            // InternalElemental.g:1262:3: 
            {
            }

             after(grammarAccess.getBranchAccess().getBranchAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__0__Impl"


    // $ANTLR start "rule__Branch__Group__1"
    // InternalElemental.g:1270:1: rule__Branch__Group__1 : rule__Branch__Group__1__Impl rule__Branch__Group__2 ;
    public final void rule__Branch__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1274:1: ( rule__Branch__Group__1__Impl rule__Branch__Group__2 )
            // InternalElemental.g:1275:2: rule__Branch__Group__1__Impl rule__Branch__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Branch__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Branch__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__1"


    // $ANTLR start "rule__Branch__Group__1__Impl"
    // InternalElemental.g:1282:1: rule__Branch__Group__1__Impl : ( '(' ) ;
    public final void rule__Branch__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1286:1: ( ( '(' ) )
            // InternalElemental.g:1287:1: ( '(' )
            {
            // InternalElemental.g:1287:1: ( '(' )
            // InternalElemental.g:1288:2: '('
            {
             before(grammarAccess.getBranchAccess().getLeftParenthesisKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getBranchAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__1__Impl"


    // $ANTLR start "rule__Branch__Group__2"
    // InternalElemental.g:1297:1: rule__Branch__Group__2 : rule__Branch__Group__2__Impl rule__Branch__Group__3 ;
    public final void rule__Branch__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1301:1: ( rule__Branch__Group__2__Impl rule__Branch__Group__3 )
            // InternalElemental.g:1302:2: rule__Branch__Group__2__Impl rule__Branch__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Branch__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Branch__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__2"


    // $ANTLR start "rule__Branch__Group__2__Impl"
    // InternalElemental.g:1309:1: rule__Branch__Group__2__Impl : ( ( rule__Branch__BodyAssignment_2 ) ) ;
    public final void rule__Branch__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1313:1: ( ( ( rule__Branch__BodyAssignment_2 ) ) )
            // InternalElemental.g:1314:1: ( ( rule__Branch__BodyAssignment_2 ) )
            {
            // InternalElemental.g:1314:1: ( ( rule__Branch__BodyAssignment_2 ) )
            // InternalElemental.g:1315:2: ( rule__Branch__BodyAssignment_2 )
            {
             before(grammarAccess.getBranchAccess().getBodyAssignment_2()); 
            // InternalElemental.g:1316:2: ( rule__Branch__BodyAssignment_2 )
            // InternalElemental.g:1316:3: rule__Branch__BodyAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Branch__BodyAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBranchAccess().getBodyAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__2__Impl"


    // $ANTLR start "rule__Branch__Group__3"
    // InternalElemental.g:1324:1: rule__Branch__Group__3 : rule__Branch__Group__3__Impl ;
    public final void rule__Branch__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1328:1: ( rule__Branch__Group__3__Impl )
            // InternalElemental.g:1329:2: rule__Branch__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Branch__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__3"


    // $ANTLR start "rule__Branch__Group__3__Impl"
    // InternalElemental.g:1335:1: rule__Branch__Group__3__Impl : ( ')' ) ;
    public final void rule__Branch__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1339:1: ( ( ')' ) )
            // InternalElemental.g:1340:1: ( ')' )
            {
            // InternalElemental.g:1340:1: ( ')' )
            // InternalElemental.g:1341:2: ')'
            {
             before(grammarAccess.getBranchAccess().getRightParenthesisKeyword_3()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getBranchAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__Group__3__Impl"


    // $ANTLR start "rule__Loop__Group__0"
    // InternalElemental.g:1351:1: rule__Loop__Group__0 : rule__Loop__Group__0__Impl rule__Loop__Group__1 ;
    public final void rule__Loop__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1355:1: ( rule__Loop__Group__0__Impl rule__Loop__Group__1 )
            // InternalElemental.g:1356:2: rule__Loop__Group__0__Impl rule__Loop__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Loop__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0"


    // $ANTLR start "rule__Loop__Group__0__Impl"
    // InternalElemental.g:1363:1: rule__Loop__Group__0__Impl : ( () ) ;
    public final void rule__Loop__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1367:1: ( ( () ) )
            // InternalElemental.g:1368:1: ( () )
            {
            // InternalElemental.g:1368:1: ( () )
            // InternalElemental.g:1369:2: ()
            {
             before(grammarAccess.getLoopAccess().getLoopAction_0()); 
            // InternalElemental.g:1370:2: ()
            // InternalElemental.g:1370:3: 
            {
            }

             after(grammarAccess.getLoopAccess().getLoopAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0__Impl"


    // $ANTLR start "rule__Loop__Group__1"
    // InternalElemental.g:1378:1: rule__Loop__Group__1 : rule__Loop__Group__1__Impl rule__Loop__Group__2 ;
    public final void rule__Loop__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1382:1: ( rule__Loop__Group__1__Impl rule__Loop__Group__2 )
            // InternalElemental.g:1383:2: rule__Loop__Group__1__Impl rule__Loop__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Loop__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1"


    // $ANTLR start "rule__Loop__Group__1__Impl"
    // InternalElemental.g:1390:1: rule__Loop__Group__1__Impl : ( '[' ) ;
    public final void rule__Loop__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1394:1: ( ( '[' ) )
            // InternalElemental.g:1395:1: ( '[' )
            {
            // InternalElemental.g:1395:1: ( '[' )
            // InternalElemental.g:1396:2: '['
            {
             before(grammarAccess.getLoopAccess().getLeftSquareBracketKeyword_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1__Impl"


    // $ANTLR start "rule__Loop__Group__2"
    // InternalElemental.g:1405:1: rule__Loop__Group__2 : rule__Loop__Group__2__Impl rule__Loop__Group__3 ;
    public final void rule__Loop__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1409:1: ( rule__Loop__Group__2__Impl rule__Loop__Group__3 )
            // InternalElemental.g:1410:2: rule__Loop__Group__2__Impl rule__Loop__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__Loop__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2"


    // $ANTLR start "rule__Loop__Group__2__Impl"
    // InternalElemental.g:1417:1: rule__Loop__Group__2__Impl : ( ( rule__Loop__BodyAssignment_2 ) ) ;
    public final void rule__Loop__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1421:1: ( ( ( rule__Loop__BodyAssignment_2 ) ) )
            // InternalElemental.g:1422:1: ( ( rule__Loop__BodyAssignment_2 ) )
            {
            // InternalElemental.g:1422:1: ( ( rule__Loop__BodyAssignment_2 ) )
            // InternalElemental.g:1423:2: ( rule__Loop__BodyAssignment_2 )
            {
             before(grammarAccess.getLoopAccess().getBodyAssignment_2()); 
            // InternalElemental.g:1424:2: ( rule__Loop__BodyAssignment_2 )
            // InternalElemental.g:1424:3: rule__Loop__BodyAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Loop__BodyAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getBodyAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2__Impl"


    // $ANTLR start "rule__Loop__Group__3"
    // InternalElemental.g:1432:1: rule__Loop__Group__3 : rule__Loop__Group__3__Impl ;
    public final void rule__Loop__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1436:1: ( rule__Loop__Group__3__Impl )
            // InternalElemental.g:1437:2: rule__Loop__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3"


    // $ANTLR start "rule__Loop__Group__3__Impl"
    // InternalElemental.g:1443:1: rule__Loop__Group__3__Impl : ( ']' ) ;
    public final void rule__Loop__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1447:1: ( ( ']' ) )
            // InternalElemental.g:1448:1: ( ']' )
            {
            // InternalElemental.g:1448:1: ( ']' )
            // InternalElemental.g:1449:2: ']'
            {
             before(grammarAccess.getLoopAccess().getRightSquareBracketKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3__Impl"


    // $ANTLR start "rule__GOTO__Group__0"
    // InternalElemental.g:1459:1: rule__GOTO__Group__0 : rule__GOTO__Group__0__Impl rule__GOTO__Group__1 ;
    public final void rule__GOTO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1463:1: ( rule__GOTO__Group__0__Impl rule__GOTO__Group__1 )
            // InternalElemental.g:1464:2: rule__GOTO__Group__0__Impl rule__GOTO__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__GOTO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GOTO__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__0"


    // $ANTLR start "rule__GOTO__Group__0__Impl"
    // InternalElemental.g:1471:1: rule__GOTO__Group__0__Impl : ( () ) ;
    public final void rule__GOTO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1475:1: ( ( () ) )
            // InternalElemental.g:1476:1: ( () )
            {
            // InternalElemental.g:1476:1: ( () )
            // InternalElemental.g:1477:2: ()
            {
             before(grammarAccess.getGOTOAccess().getGOTOAction_0()); 
            // InternalElemental.g:1478:2: ()
            // InternalElemental.g:1478:3: 
            {
            }

             after(grammarAccess.getGOTOAccess().getGOTOAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__0__Impl"


    // $ANTLR start "rule__GOTO__Group__1"
    // InternalElemental.g:1486:1: rule__GOTO__Group__1 : rule__GOTO__Group__1__Impl rule__GOTO__Group__2 ;
    public final void rule__GOTO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1490:1: ( rule__GOTO__Group__1__Impl rule__GOTO__Group__2 )
            // InternalElemental.g:1491:2: rule__GOTO__Group__1__Impl rule__GOTO__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__GOTO__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GOTO__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__1"


    // $ANTLR start "rule__GOTO__Group__1__Impl"
    // InternalElemental.g:1498:1: rule__GOTO__Group__1__Impl : ( '\\'' ) ;
    public final void rule__GOTO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1502:1: ( ( '\\'' ) )
            // InternalElemental.g:1503:1: ( '\\'' )
            {
            // InternalElemental.g:1503:1: ( '\\'' )
            // InternalElemental.g:1504:2: '\\''
            {
             before(grammarAccess.getGOTOAccess().getApostropheKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getGOTOAccess().getApostropheKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__1__Impl"


    // $ANTLR start "rule__GOTO__Group__2"
    // InternalElemental.g:1513:1: rule__GOTO__Group__2 : rule__GOTO__Group__2__Impl rule__GOTO__Group__3 ;
    public final void rule__GOTO__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1517:1: ( rule__GOTO__Group__2__Impl rule__GOTO__Group__3 )
            // InternalElemental.g:1518:2: rule__GOTO__Group__2__Impl rule__GOTO__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__GOTO__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GOTO__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__2"


    // $ANTLR start "rule__GOTO__Group__2__Impl"
    // InternalElemental.g:1525:1: rule__GOTO__Group__2__Impl : ( ( rule__GOTO__LabelAssignment_2 ) ) ;
    public final void rule__GOTO__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1529:1: ( ( ( rule__GOTO__LabelAssignment_2 ) ) )
            // InternalElemental.g:1530:1: ( ( rule__GOTO__LabelAssignment_2 ) )
            {
            // InternalElemental.g:1530:1: ( ( rule__GOTO__LabelAssignment_2 ) )
            // InternalElemental.g:1531:2: ( rule__GOTO__LabelAssignment_2 )
            {
             before(grammarAccess.getGOTOAccess().getLabelAssignment_2()); 
            // InternalElemental.g:1532:2: ( rule__GOTO__LabelAssignment_2 )
            // InternalElemental.g:1532:3: rule__GOTO__LabelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__GOTO__LabelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGOTOAccess().getLabelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__2__Impl"


    // $ANTLR start "rule__GOTO__Group__3"
    // InternalElemental.g:1540:1: rule__GOTO__Group__3 : rule__GOTO__Group__3__Impl ;
    public final void rule__GOTO__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1544:1: ( rule__GOTO__Group__3__Impl )
            // InternalElemental.g:1545:2: rule__GOTO__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GOTO__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__3"


    // $ANTLR start "rule__GOTO__Group__3__Impl"
    // InternalElemental.g:1551:1: rule__GOTO__Group__3__Impl : ( '\\'' ) ;
    public final void rule__GOTO__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1555:1: ( ( '\\'' ) )
            // InternalElemental.g:1556:1: ( '\\'' )
            {
            // InternalElemental.g:1556:1: ( '\\'' )
            // InternalElemental.g:1557:2: '\\''
            {
             before(grammarAccess.getGOTOAccess().getApostropheKeyword_3()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getGOTOAccess().getApostropheKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__Group__3__Impl"


    // $ANTLR start "rule__ComputedGOTO__Group__0"
    // InternalElemental.g:1567:1: rule__ComputedGOTO__Group__0 : rule__ComputedGOTO__Group__0__Impl rule__ComputedGOTO__Group__1 ;
    public final void rule__ComputedGOTO__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1571:1: ( rule__ComputedGOTO__Group__0__Impl rule__ComputedGOTO__Group__1 )
            // InternalElemental.g:1572:2: rule__ComputedGOTO__Group__0__Impl rule__ComputedGOTO__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__ComputedGOTO__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComputedGOTO__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComputedGOTO__Group__0"


    // $ANTLR start "rule__ComputedGOTO__Group__0__Impl"
    // InternalElemental.g:1579:1: rule__ComputedGOTO__Group__0__Impl : ( () ) ;
    public final void rule__ComputedGOTO__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1583:1: ( ( () ) )
            // InternalElemental.g:1584:1: ( () )
            {
            // InternalElemental.g:1584:1: ( () )
            // InternalElemental.g:1585:2: ()
            {
             before(grammarAccess.getComputedGOTOAccess().getComputedGOTOAction_0()); 
            // InternalElemental.g:1586:2: ()
            // InternalElemental.g:1586:3: 
            {
            }

             after(grammarAccess.getComputedGOTOAccess().getComputedGOTOAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComputedGOTO__Group__0__Impl"


    // $ANTLR start "rule__ComputedGOTO__Group__1"
    // InternalElemental.g:1594:1: rule__ComputedGOTO__Group__1 : rule__ComputedGOTO__Group__1__Impl ;
    public final void rule__ComputedGOTO__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1598:1: ( rule__ComputedGOTO__Group__1__Impl )
            // InternalElemental.g:1599:2: rule__ComputedGOTO__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComputedGOTO__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComputedGOTO__Group__1"


    // $ANTLR start "rule__ComputedGOTO__Group__1__Impl"
    // InternalElemental.g:1605:1: rule__ComputedGOTO__Group__1__Impl : ( '&' ) ;
    public final void rule__ComputedGOTO__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1609:1: ( ( '&' ) )
            // InternalElemental.g:1610:1: ( '&' )
            {
            // InternalElemental.g:1610:1: ( '&' )
            // InternalElemental.g:1611:2: '&'
            {
             before(grammarAccess.getComputedGOTOAccess().getAmpersandKeyword_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getComputedGOTOAccess().getAmpersandKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComputedGOTO__Group__1__Impl"


    // $ANTLR start "rule__StaticDispatch__Group__0"
    // InternalElemental.g:1621:1: rule__StaticDispatch__Group__0 : rule__StaticDispatch__Group__0__Impl rule__StaticDispatch__Group__1 ;
    public final void rule__StaticDispatch__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1625:1: ( rule__StaticDispatch__Group__0__Impl rule__StaticDispatch__Group__1 )
            // InternalElemental.g:1626:2: rule__StaticDispatch__Group__0__Impl rule__StaticDispatch__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__StaticDispatch__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StaticDispatch__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__0"


    // $ANTLR start "rule__StaticDispatch__Group__0__Impl"
    // InternalElemental.g:1633:1: rule__StaticDispatch__Group__0__Impl : ( () ) ;
    public final void rule__StaticDispatch__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1637:1: ( ( () ) )
            // InternalElemental.g:1638:1: ( () )
            {
            // InternalElemental.g:1638:1: ( () )
            // InternalElemental.g:1639:2: ()
            {
             before(grammarAccess.getStaticDispatchAccess().getStaticDispatchAction_0()); 
            // InternalElemental.g:1640:2: ()
            // InternalElemental.g:1640:3: 
            {
            }

             after(grammarAccess.getStaticDispatchAccess().getStaticDispatchAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__0__Impl"


    // $ANTLR start "rule__StaticDispatch__Group__1"
    // InternalElemental.g:1648:1: rule__StaticDispatch__Group__1 : rule__StaticDispatch__Group__1__Impl rule__StaticDispatch__Group__2 ;
    public final void rule__StaticDispatch__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1652:1: ( rule__StaticDispatch__Group__1__Impl rule__StaticDispatch__Group__2 )
            // InternalElemental.g:1653:2: rule__StaticDispatch__Group__1__Impl rule__StaticDispatch__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__StaticDispatch__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StaticDispatch__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__1"


    // $ANTLR start "rule__StaticDispatch__Group__1__Impl"
    // InternalElemental.g:1660:1: rule__StaticDispatch__Group__1__Impl : ( '{' ) ;
    public final void rule__StaticDispatch__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1664:1: ( ( '{' ) )
            // InternalElemental.g:1665:1: ( '{' )
            {
            // InternalElemental.g:1665:1: ( '{' )
            // InternalElemental.g:1666:2: '{'
            {
             before(grammarAccess.getStaticDispatchAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getStaticDispatchAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__1__Impl"


    // $ANTLR start "rule__StaticDispatch__Group__2"
    // InternalElemental.g:1675:1: rule__StaticDispatch__Group__2 : rule__StaticDispatch__Group__2__Impl rule__StaticDispatch__Group__3 ;
    public final void rule__StaticDispatch__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1679:1: ( rule__StaticDispatch__Group__2__Impl rule__StaticDispatch__Group__3 )
            // InternalElemental.g:1680:2: rule__StaticDispatch__Group__2__Impl rule__StaticDispatch__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__StaticDispatch__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StaticDispatch__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__2"


    // $ANTLR start "rule__StaticDispatch__Group__2__Impl"
    // InternalElemental.g:1687:1: rule__StaticDispatch__Group__2__Impl : ( ( rule__StaticDispatch__TargetAssignment_2 ) ) ;
    public final void rule__StaticDispatch__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1691:1: ( ( ( rule__StaticDispatch__TargetAssignment_2 ) ) )
            // InternalElemental.g:1692:1: ( ( rule__StaticDispatch__TargetAssignment_2 ) )
            {
            // InternalElemental.g:1692:1: ( ( rule__StaticDispatch__TargetAssignment_2 ) )
            // InternalElemental.g:1693:2: ( rule__StaticDispatch__TargetAssignment_2 )
            {
             before(grammarAccess.getStaticDispatchAccess().getTargetAssignment_2()); 
            // InternalElemental.g:1694:2: ( rule__StaticDispatch__TargetAssignment_2 )
            // InternalElemental.g:1694:3: rule__StaticDispatch__TargetAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StaticDispatch__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStaticDispatchAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__2__Impl"


    // $ANTLR start "rule__StaticDispatch__Group__3"
    // InternalElemental.g:1702:1: rule__StaticDispatch__Group__3 : rule__StaticDispatch__Group__3__Impl ;
    public final void rule__StaticDispatch__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1706:1: ( rule__StaticDispatch__Group__3__Impl )
            // InternalElemental.g:1707:2: rule__StaticDispatch__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StaticDispatch__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__3"


    // $ANTLR start "rule__StaticDispatch__Group__3__Impl"
    // InternalElemental.g:1713:1: rule__StaticDispatch__Group__3__Impl : ( '}' ) ;
    public final void rule__StaticDispatch__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1717:1: ( ( '}' ) )
            // InternalElemental.g:1718:1: ( '}' )
            {
            // InternalElemental.g:1718:1: ( '}' )
            // InternalElemental.g:1719:2: '}'
            {
             before(grammarAccess.getStaticDispatchAccess().getRightCurlyBracketKeyword_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getStaticDispatchAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__Group__3__Impl"


    // $ANTLR start "rule__DynamicDispatch__Group__0"
    // InternalElemental.g:1729:1: rule__DynamicDispatch__Group__0 : rule__DynamicDispatch__Group__0__Impl rule__DynamicDispatch__Group__1 ;
    public final void rule__DynamicDispatch__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1733:1: ( rule__DynamicDispatch__Group__0__Impl rule__DynamicDispatch__Group__1 )
            // InternalElemental.g:1734:2: rule__DynamicDispatch__Group__0__Impl rule__DynamicDispatch__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__DynamicDispatch__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DynamicDispatch__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicDispatch__Group__0"


    // $ANTLR start "rule__DynamicDispatch__Group__0__Impl"
    // InternalElemental.g:1741:1: rule__DynamicDispatch__Group__0__Impl : ( () ) ;
    public final void rule__DynamicDispatch__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1745:1: ( ( () ) )
            // InternalElemental.g:1746:1: ( () )
            {
            // InternalElemental.g:1746:1: ( () )
            // InternalElemental.g:1747:2: ()
            {
             before(grammarAccess.getDynamicDispatchAccess().getDynamicDispatchAction_0()); 
            // InternalElemental.g:1748:2: ()
            // InternalElemental.g:1748:3: 
            {
            }

             after(grammarAccess.getDynamicDispatchAccess().getDynamicDispatchAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicDispatch__Group__0__Impl"


    // $ANTLR start "rule__DynamicDispatch__Group__1"
    // InternalElemental.g:1756:1: rule__DynamicDispatch__Group__1 : rule__DynamicDispatch__Group__1__Impl ;
    public final void rule__DynamicDispatch__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1760:1: ( rule__DynamicDispatch__Group__1__Impl )
            // InternalElemental.g:1761:2: rule__DynamicDispatch__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DynamicDispatch__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicDispatch__Group__1"


    // $ANTLR start "rule__DynamicDispatch__Group__1__Impl"
    // InternalElemental.g:1767:1: rule__DynamicDispatch__Group__1__Impl : ( '?' ) ;
    public final void rule__DynamicDispatch__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1771:1: ( ( '?' ) )
            // InternalElemental.g:1772:1: ( '?' )
            {
            // InternalElemental.g:1772:1: ( '?' )
            // InternalElemental.g:1773:2: '?'
            {
             before(grammarAccess.getDynamicDispatchAccess().getQuestionMarkKeyword_1()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getDynamicDispatchAccess().getQuestionMarkKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DynamicDispatch__Group__1__Impl"


    // $ANTLR start "rule__Program__ImplicitFunctionAssignment_0"
    // InternalElemental.g:1783:1: rule__Program__ImplicitFunctionAssignment_0 : ( ruleBlock ) ;
    public final void rule__Program__ImplicitFunctionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1787:1: ( ( ruleBlock ) )
            // InternalElemental.g:1788:2: ( ruleBlock )
            {
            // InternalElemental.g:1788:2: ( ruleBlock )
            // InternalElemental.g:1789:3: ruleBlock
            {
             before(grammarAccess.getProgramAccess().getImplicitFunctionBlockParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getImplicitFunctionBlockParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ImplicitFunctionAssignment_0"


    // $ANTLR start "rule__Program__ExplicitFunctionsAssignment_1"
    // InternalElemental.g:1798:1: rule__Program__ExplicitFunctionsAssignment_1 : ( ruleFunction ) ;
    public final void rule__Program__ExplicitFunctionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1802:1: ( ( ruleFunction ) )
            // InternalElemental.g:1803:2: ( ruleFunction )
            {
            // InternalElemental.g:1803:2: ( ruleFunction )
            // InternalElemental.g:1804:3: ruleFunction
            {
             before(grammarAccess.getProgramAccess().getExplicitFunctionsFunctionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getExplicitFunctionsFunctionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ExplicitFunctionsAssignment_1"


    // $ANTLR start "rule__Block__InstructionsAssignment_1"
    // InternalElemental.g:1813:1: rule__Block__InstructionsAssignment_1 : ( ruleInstruction ) ;
    public final void rule__Block__InstructionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1817:1: ( ( ruleInstruction ) )
            // InternalElemental.g:1818:2: ( ruleInstruction )
            {
            // InternalElemental.g:1818:2: ( ruleInstruction )
            // InternalElemental.g:1819:3: ruleInstruction
            {
             before(grammarAccess.getBlockAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getInstructionsInstructionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__InstructionsAssignment_1"


    // $ANTLR start "rule__Label__NameAssignment_1"
    // InternalElemental.g:1828:1: rule__Label__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Label__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1832:1: ( ( RULE_ID ) )
            // InternalElemental.g:1833:2: ( RULE_ID )
            {
            // InternalElemental.g:1833:2: ( RULE_ID )
            // InternalElemental.g:1834:3: RULE_ID
            {
             before(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Label__NameAssignment_1"


    // $ANTLR start "rule__Function__NameAssignment_0"
    // InternalElemental.g:1843:1: rule__Function__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1847:1: ( ( RULE_ID ) )
            // InternalElemental.g:1848:2: ( RULE_ID )
            {
            // InternalElemental.g:1848:2: ( RULE_ID )
            // InternalElemental.g:1849:3: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__NameAssignment_0"


    // $ANTLR start "rule__Function__BodyAssignment_2"
    // InternalElemental.g:1858:1: rule__Function__BodyAssignment_2 : ( ruleBlock ) ;
    public final void rule__Function__BodyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1862:1: ( ( ruleBlock ) )
            // InternalElemental.g:1863:2: ( ruleBlock )
            {
            // InternalElemental.g:1863:2: ( ruleBlock )
            // InternalElemental.g:1864:3: ruleBlock
            {
             before(grammarAccess.getFunctionAccess().getBodyBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getBodyBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__BodyAssignment_2"


    // $ANTLR start "rule__Instruction__TypeAssignment"
    // InternalElemental.g:1873:1: rule__Instruction__TypeAssignment : ( ( rule__Instruction__TypeAlternatives_0 ) ) ;
    public final void rule__Instruction__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1877:1: ( ( ( rule__Instruction__TypeAlternatives_0 ) ) )
            // InternalElemental.g:1878:2: ( ( rule__Instruction__TypeAlternatives_0 ) )
            {
            // InternalElemental.g:1878:2: ( ( rule__Instruction__TypeAlternatives_0 ) )
            // InternalElemental.g:1879:3: ( rule__Instruction__TypeAlternatives_0 )
            {
             before(grammarAccess.getInstructionAccess().getTypeAlternatives_0()); 
            // InternalElemental.g:1880:3: ( rule__Instruction__TypeAlternatives_0 )
            // InternalElemental.g:1880:4: rule__Instruction__TypeAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Instruction__TypeAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getTypeAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__TypeAssignment"


    // $ANTLR start "rule__Branch__BodyAssignment_2"
    // InternalElemental.g:1888:1: rule__Branch__BodyAssignment_2 : ( ruleBlock ) ;
    public final void rule__Branch__BodyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1892:1: ( ( ruleBlock ) )
            // InternalElemental.g:1893:2: ( ruleBlock )
            {
            // InternalElemental.g:1893:2: ( ruleBlock )
            // InternalElemental.g:1894:3: ruleBlock
            {
             before(grammarAccess.getBranchAccess().getBodyBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getBranchAccess().getBodyBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Branch__BodyAssignment_2"


    // $ANTLR start "rule__Loop__BodyAssignment_2"
    // InternalElemental.g:1903:1: rule__Loop__BodyAssignment_2 : ( ruleBlock ) ;
    public final void rule__Loop__BodyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1907:1: ( ( ruleBlock ) )
            // InternalElemental.g:1908:2: ( ruleBlock )
            {
            // InternalElemental.g:1908:2: ( ruleBlock )
            // InternalElemental.g:1909:3: ruleBlock
            {
             before(grammarAccess.getLoopAccess().getBodyBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getBodyBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__BodyAssignment_2"


    // $ANTLR start "rule__GOTO__LabelAssignment_2"
    // InternalElemental.g:1918:1: rule__GOTO__LabelAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__GOTO__LabelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1922:1: ( ( ( RULE_ID ) ) )
            // InternalElemental.g:1923:2: ( ( RULE_ID ) )
            {
            // InternalElemental.g:1923:2: ( ( RULE_ID ) )
            // InternalElemental.g:1924:3: ( RULE_ID )
            {
             before(grammarAccess.getGOTOAccess().getLabelLabelCrossReference_2_0()); 
            // InternalElemental.g:1925:3: ( RULE_ID )
            // InternalElemental.g:1926:4: RULE_ID
            {
             before(grammarAccess.getGOTOAccess().getLabelLabelIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGOTOAccess().getLabelLabelIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGOTOAccess().getLabelLabelCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GOTO__LabelAssignment_2"


    // $ANTLR start "rule__StaticDispatch__TargetAssignment_2"
    // InternalElemental.g:1937:1: rule__StaticDispatch__TargetAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StaticDispatch__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalElemental.g:1941:1: ( ( ( RULE_ID ) ) )
            // InternalElemental.g:1942:2: ( ( RULE_ID ) )
            {
            // InternalElemental.g:1942:2: ( ( RULE_ID ) )
            // InternalElemental.g:1943:3: ( RULE_ID )
            {
             before(grammarAccess.getStaticDispatchAccess().getTargetFunctionCrossReference_2_0()); 
            // InternalElemental.g:1944:3: ( RULE_ID )
            // InternalElemental.g:1945:4: RULE_ID
            {
             before(grammarAccess.getStaticDispatchAccess().getTargetFunctionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStaticDispatchAccess().getTargetFunctionIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStaticDispatchAccess().getTargetFunctionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StaticDispatch__TargetAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002EBFD00L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002EBFD02L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000000L});

}