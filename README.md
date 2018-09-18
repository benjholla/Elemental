# Elemental
An esoteric language for exploring elemental properties program language features

## Lineage
This language was inspired by [Brainfuck](https://en.wikipedia.org/wiki/Brainfuck), which is a variation on [Corrado Böhm](https://en.wikipedia.org/wiki/Corrado_Böhm)'s [P''](https://esolangs.org/wiki/P%E2%80%B2%E2%80%B2). Both languages however implement branching as a type of loop. 

## Differences
- Elemental seperates branching from looping
- Elemental has gotos and labels
- Element has [computed gotos](http://gcc.gnu.org/onlinedocs/gcc/Labels-as-Values.html)
- Elemental has callsites and functions
- Element has function pointers

## Language

| Instruction | Description                                                                                                                                                                             |
|:-----------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|      +      | Increment the byte at the current tape cell by 1                                                                                                                                        |
|      -      | Decrement the byte at the current tape cell by 1                                                                                                                                        |
|      <      | Move the tape one cell to the left                                                                                                                                                      |
|      >      | Move the tape one cell to the right                                                                                                                                                     |
|      ,      | Read byte value from input into current tape cell                                                                                                                                       |
|      .      | Write byte value to output from current tape cell                                                                                                                                       |
|      (      | If the byte value at the current cell is 0 then jump to the instruction following the matching ), else execute the next instruction                                                     |
|      [      | While the byte value at the current cell is 0 then jump to the instruction following the matching ], else execute instructions until the matching ] and unconditionally return to the [ |
|  "*[0-9]+*" | Sets a label (named [0-9]+ within range 0-255)                                                                                                                                          |
|  '*[0-9]+*' | Jumps (GOTO) to a named label                                                                                                                                                           |
|  *[0-9]+*:  | Declares a named function                                                                                                                                                               |
|  {*[0-9]+*} | Callsite to a named function                                                                                                                                                            |
|      &      | Jumps to the named label with the value of the current cell                                                                                                                             |
|      ?      | Jumps to a named function with the value of the current cell                                                                                                                            |
