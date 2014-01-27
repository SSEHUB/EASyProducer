grammar PLugin;

options {
output = AST;
}

//*********************************************************
// Lexer
//*********************************************************

// $<operator

// $<compare
GREATER	: '>'	;

EQUALS	: '=='	;

LESS	: '<'	;
	
G_OR_EQ	: '>='	;
	
L_OR_EQ	: '<='	;
	
NOT_EQ	: '!='	;
// $>

// $<deduction
IMPLICATION : '->'	;

EQUIVALENT  : '<->';
// $>	


// $<logical
AND : '&' | 'and'	;
	
OR  : '|' | 'or'	;
	
XOR : 'xor'	;

NOT : '!' | 'not';
// $>

// $<sets	
ELEMENT 	 : 'in'		;

NOT_ELEMENT	 : '!in'	;	

SUBSET		 : 'sub'	;	

SUBSET_EQUAL	 : 'subeq'	;

CARD		 : '#'		;	

// $>

// $>

// $<var

NULL   : ('null') ;

ID     : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ('[' INT ']')? ;

INT    : '0'..'9'+ ;

REAL   : ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
       | '.' ('0'..'9')+ EXPONENT?
       | ('0'..'9')+ EXPONENT
       ;

STRING : '"' ( ESC_SEQ | ~('\\'|'"') )* '"' ;

CHAR   : '\'' ( ESC_SEQ | ~('\''|'\\') ) '\'' ;

SET_OF_INT    : '{' ( (INT | ID) (',' (INT | ID))* )? '}';

SET_OF_REAL   : '{' ( (REAL | ID) (',' (REAL | ID))* )? '}';

SET_OF_STRING : '{' ( (STRING | ID) (',' (STRING | ID))* )? '}';

SET_OF_ENUM   : '{' ( (ID) (',' (ID))* )? '}';

// $>

// <?misc

GROUP	  : ID ('.' ID)+ ;

NAMESPACE : ID ':' (ID | GROUP) ;

// ?>


fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;

/*

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
*/

//*********************************************************
// Parser
//*********************************************************

operator
  :  GREATER
  |  EQUALS
  |  LESS 
  |  G_OR_EQ 
  |  L_OR_EQ 
  |  NOT_EQ
  ;
  
set_operator
  :	
  | ELEMENT
  | NOT_ELEMENT
  | SUBSET
  | SUBSET_EQUAL
  ;
    
var
  :  ID
  |  GROUP	
  |  NAMESPACE	
  ;
    
constant
  :  ID	
  |  INT
  |  REAL
  |  STRING  
  |  NULL
  |  SET_OF_INT
  |  SET_OF_STRING
  |  SET_OF_REAL
  ;
  
// first element must be a decision (except for set-operations)
// for set-operations first element can be a value (example: 10 in x)
term
  : ((CARD)? var  	operator       (constant | var)	) 
  | ((constant | var)   set_operator   (constant | var)	)		
  ;
  
  
connector
  : ( AND | OR | XOR | IMPLICATION | EQUIVALENT )
  ;
  
greatTerm
  : term ( connector term )*
  ;
  
nestedTerm
  : (NOT)? '(' (nestedTerm | greatTerm) (connector (nestedTerm | greatTerm))* ')'	
  ;
  
expression
  : (greatTerm | nestedTerm) (connector (greatTerm | nestedTerm))*
  ;
  
  
  
  
  