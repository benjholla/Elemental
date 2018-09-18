# Elemental
An esoteric language for exploring elemental properties of program language features

## Lineage
This language was inspired by [Brainfuck](https://en.wikipedia.org/wiki/Brainfuck), which is a variation on [Corrado Böhm](https://en.wikipedia.org/wiki/Corrado_Böhm)'s [P''](https://esolangs.org/wiki/P%E2%80%B2%E2%80%B2). Both languages however implement branching as a type of loop. 

## Differences
- Elemental seperates branching from looping
- Elemental has gotos and labels
- Element has [computed gotos](http://gcc.gnu.org/onlinedocs/gcc/Labels-as-Values.html)
- Elemental has callsites and functions
- Element has function pointers
- Element has native comments

## Language

| Instruction | Description                                                                                                                                                                                            |
|:-----------:|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|      +      | Increment the byte at the current tape cell by 1                                                                                                                                                       |
|      -      | Decrement the byte at the current tape cell by 1                                                                                                                                                       |
|      <      | Move the tape one cell to the left                                                                                                                                                                     |
|      >      | Move the tape one cell to the right                                                                                                                                                                    |
|      ,      | (Store) Read byte value from input into current tape cell                                                                                                                                              |
|      .      | (Recall) Write byte value to output from current tape cell                                                                                                                                             |
|      (      | (Branch) If the byte value at the current cell is 0 then jump to the instruction following the matching ), else execute the next instruction                                                           |
|      [      | (While Loop) If the byte value at the current cell is 0 then jump to the instruction following the matching ], else execute instructions until the matching ] and then unconditionally return to the [ |
|  *[0-9]+*:  | (Function) Declares a uniquely named function (named [0-9]+ within range 0-255)                                                                                                                        |
|  {*[0-9]+*} | (Static Dispatch) Jump to a named function                                                                                                                                                             |
|      ?      | (Dynamic Dispatch/Function Pointer) Jumps to a named function with the value of the current cell                                                                                                       |
|  "*[0-9]+*" | (Label) Sets a unique label (named [0-9]+ within range 0-255) within a function                                                                                                                        |
|  '*[0-9]+*' | (GOTO) Jumps to a named label within the current function                                                                                                                                              |
|      &      | (Computed GOTO) Jumps to the named label within the current function with the value of the current cell                                                                                                |
|      #      | A one line comment                                                                                                                                                                                     |
