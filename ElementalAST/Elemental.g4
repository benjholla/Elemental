grammar Elemental;

@header{
	package com.benjholla.elemental.parser; 
	
	import com.benjholla.elemental.parser.support.*;
	import com.benjholla.elemental.ast.*;
	import java.util.List;
	import java.io.File;
}

@members{
	private File file;
	
	public void setFile(File file){
		this.file = file;
	}
	
	public File getFile(){
		return file;
	}
}

program returns [Program prog]
   : functions=function_list eof=EOF
   {
   	  ParserSourceCorrespondence sc;
   	  if($functions.list.isEmpty()){
   	     sc = new ParserSourceCorrespondence(file, 0, 0, 0, 0);
   	  } else {
   	     ParserSourceCorrespondence firstFunctionSC = $functions.list.get(0).getParserSourceCorrespondence();
   	     sc = new ParserSourceCorrespondence(file, firstFunctionSC.getOffset(), ((int) $eof.getStartIndex()- (int) firstFunctionSC.getOffset()), firstFunctionSC.getStartLine(), $eof.getLine()); 
   	  }
      $prog = new Program(sc, $functions.list);
   }
   ;
   
function_list returns [ArrayList<Function> list]
   @init
   {
      $list = new ArrayList<Function>();
   }
   : (f = function {$list.add($f.value);})*
   ;

function returns [Function value]
   : id=ID ':' instructions=instruction_list
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $id.getStartIndex(), $id.getText().length()+1, $id.getLine(), $id.getLine());
      $value = new Function(sc, $id.getText(), $instructions.list);
   }
   ;

instruction_list returns [ArrayList<Instruction> list]
   @init
   {
      $list = new ArrayList<Instruction>();
   }
   : (c = instruction {$list.add($c.value);})*
   ;

instruction returns [Instruction value] 
   : g=go2
   {
   	 $value = $g.value;
   } 
   | lbl=label
   {
   	 $value = $lbl.value;
   }
   | c=callsite
   {
      $value = $c.value;
   }
   | cgo2=computed_goto
   {
      $value = $cgo2.value;
   }
   | fpc=function_pointer_callsite
   {
      $value = $fpc.value;
   }
   | l=loop
   {
      $value = $l.value;
   }
   | b=branch
   {
      $value = $b.value;
   } 
   | tape_increment=TAPE_INCREMENT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $tape_increment.getStartIndex(), $tape_increment.getText().length(), $tape_increment.getLine(), $tape_increment.getLine());
      $value = new IncrementInstruction(sc);
   }
   | tape_decrement=TAPE_DECREMENT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $tape_decrement.getStartIndex(), $tape_decrement.getText().length(), $tape_decrement.getLine(), $tape_decrement.getLine());
      $value = new DecrementInstruction(sc);
   }
   | tape_left=TAPE_LEFT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $tape_left.getStartIndex(), $tape_left.getText().length(), $tape_left.getLine(), $tape_left.getLine());
      $value = new MoveLeftInstruction(sc);
   }
   | tape_right=TAPE_RIGHT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $tape_right.getStartIndex(), $tape_right.getText().length(), $tape_right.getLine(), $tape_right.getLine());
      $value = new MoveRightInstruction(sc);
   }
   | input=INPUT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $input.getStartIndex(), $input.getText().length(), $input.getLine(), $input.getLine());
      $value = new ReadInputInstruction(sc);
   }
   | output=OUTPUT
   {
      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $output.getStartIndex(), $output.getText().length(), $output.getLine(), $output.getLine());
      $value = new WriteOutputInstruction(sc);
   }
   ;

computed_goto returns [ComputedGOTOInstruction value]
   : address='&'
   {
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $address.getStartIndex(), $address.getText().length(), $address.getLine(), $address.getLine());
      $value = new ComputedGOTOInstruction(sc);
   }
   ;

function_pointer_callsite returns [FunctionPointerCallsiteInstruction value]
   : func_address='?'
   {
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $func_address.getStartIndex(), $func_address.getText().length(), $func_address.getLine(), $func_address.getLine());
      $value = new FunctionPointerCallsiteInstruction(sc);
   }
   ;

go2 returns [GOTOInstruction value]
   : lquote='\'' id=ID rquote='\''
   {
   	  int length = ($rquote.getStartIndex() - $lquote.getStartIndex()) + 1;
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $lquote.getStartIndex(), length, $lquote.getLine(), $rquote.getLine());
      $value = new GOTOInstruction(sc, $id.getText());
   }
   ;

label returns [LabelInstruction value]
   : lquote='"' id=ID rquote='"'
   {
   	  int length = ($rquote.getStartIndex() - $lquote.getStartIndex()) + 1;
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $lquote.getStartIndex(), length, $lquote.getLine(), $rquote.getLine());
      $value = new LabelInstruction(sc, $id.getText());
   }
   ;

callsite returns [CallsiteInstruction value]
   : lbracket='{' id=ID rbracket='}'
   {
   	  int length = ($rbracket.getStartIndex() - $lbracket.getStartIndex()) + 1;
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $lbracket.getStartIndex(), length, $lbracket.getLine(), $rbracket.getLine());
      $value = new CallsiteInstruction(sc, $id.getText());
   }
   ;
         
loop returns [LoopInstruction value]
   : lbrace='[' instructions=instruction_list rbrace=']'
   {
   	  int length = ($rbrace.getStartIndex() - $lbrace.getStartIndex()) + 1;
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $lbrace.getStartIndex(), length, $lbrace.getLine(), $rbrace.getLine());
      $value = new LoopInstruction(sc, $instructions.list);
   }
   ;

branch returns [BranchInstruction value]
   : lparen='(' instructions=instruction_list rparen=')'
   {
   	  int length = ($rparen.getStartIndex() - $lparen.getStartIndex()) + 1;
   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, $lparen.getStartIndex(), length, $lparen.getLine(), $rparen.getLine());
      $value = new BranchInstruction(sc, $instructions.list);
   }
   ;

ONE_LINE_COMMENT
   : '#' (~ '\n')* '\n'? -> skip
   ;
   
ID         : [0-9]+;
TAPE_INCREMENT : '+';
TAPE_DECREMENT : '-';
TAPE_LEFT      : '<';
TAPE_RIGHT     : '>';
INPUT          : ',';
OUTPUT         : '.';

WHITESPACE : . -> skip;