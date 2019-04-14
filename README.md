# Elemental
Elemental is an esoteric language for exploring elemental properties of program language features.

## Lineage
The Elemental language was inspired by [Brainfuck](https://en.wikipedia.org/wiki/Brainfuck), which is a variation on [Corrado Böhm](https://en.wikipedia.org/wiki/Corrado_Böhm)'s [P''](https://esolangs.org/wiki/P%E2%80%B2%E2%80%B2). Elemental is backwards compatible with Brainfuck and can execute standard Brainfuck programs verbatim.

## Key Differences
- Elemental has native comments
- Elemental seperates branching from looping
- Elemental has gotos and labels
- Elemental has [computed gotos](http://gcc.gnu.org/onlinedocs/gcc/Labels-as-Values.html)
- Elemental has callsites and functions
- Elemental has function pointers
- Elemental has assignments

## Language Overview

| Instruction | Type | Description                                                                                                                                                                                            |
|:-----------:|:----:|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|      #      |  T0  | A one line comment                                                                                                                                                                                     |
|      +      |  T1  | Increment the byte at the current tape cell by 1                                                                                                                                                       |
|      -      |  T1  | Decrement the byte at the current tape cell by 1                                                                                                                                                       |
|      <      |  T1  | Move the tape one cell to the left                                                                                                                                                                     |
|      >      |  T1  | Move the tape one cell to the right                                                                                                                                                                    |
|      (      |  T2  | (Branch) If the byte value at the current cell is 0 then jump to the instruction following the matching ), else execute the next instruction                                                           |
|      [      |  T3  | (While Loop) If the byte value at the current cell is 0 then jump to the instruction following the matching ], else execute instructions until the matching ] and then unconditionally return to the [ |
|  *[0-9]+*:  |  T3  | (Function) Declares a uniquely named function (named [0-9]+ within range 0-255)                                                                                                                        |
|  {*[0-9]+*} |  T3  | (Static Dispatch) Jump to a named function                                                                                                                                                             |
|      ?      |  T4  | (Dynamic Dispatch/Function Pointer) Jumps to a named function with the value of the current cell                                                                                                       |
|  "*[0-9]+*" |  T3  | (Label) Sets a unique label (named [0-9]+ within range 0-255) within a function                                                                                                                        |
|  '*[0-9]+*' |  T3  | (GOTO) Jumps to a named label within the current function                                                                                                                                              |
|      &      |  T4  | (Computed GOTO) Jumps to the named label within the current function with the value of the current cell                                                                                                |
|      .      |  T1  | (Recall) Write byte value to output from current tape cell                                                                                                                                             |
|      ,      |  T5  | (Store) Read byte value from input into current tape cell                                                                                                                                              |
|      =      |  T6  | (Assignment) Replace the value of the current cell with the value of the cell at the address indicated by the current cell                                                                             |

Each Elemental instruction can be group into a type where each type adds a new challenge to program analysis.

| Type | Description                                                                                                                                                                                                                       |
|:----:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|   0  | Type 0 is language convenience and does not add any analysis challenges                                                                                                                                                           |
|   1  | Type 1 provides the basic architecture for a Turing machine (update tape cell and move tape cell). Programs limited to type 1 and lower instruction types are sub-Turing machines will always halt and have a single program behavior. |
|   2  | Programs limited to type 2 and lower instructions are sub-Turing machines, which must halt but can contain an exponential number of program behaviors.                                                                            |
|   3  | Programs limited to type 3 and lower instructions are Turing complete programs. While type 4+ programs introduce new analysis challenges, they do not increase in computing power.                                                |
|   4  | Type 4+ instructions obscure control flow with data                                                                                                                                                                               |
|   5  | Type 5 instructions allow for the formation of unstructured code                                                                                                                                                                  |
|   6  | Type 6 introduces program inputs at runtime                                                                                                                                                                                       |
|   7  | Type 7 introduces explicit data flow, where all previous data flow was implicit                                                                                                                                                   |
