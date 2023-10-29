

## Code Review: Defect List
> Reviwer: Zoe Shortman
> 
> GH Repo : Blackboard branch on ser316-fall23-zshortma repo.

| ID #  | Location ( File/Line # )  |Problem Description   | Problem Category | Problem Severity |
|---|---|---|---|--|
| 1 |Game.java 19 |This string should be made private.|CG|LOW|
| 2 |Main.java 1-27 |This class does too little. More functionality should be added.|CS|LOW|
| 3 |Game.java 11-220|There is no error handling, if an error occurs the functionality of game will not work correctly. ie null/empty is entered.|FD|BR|
| 4 |Game.java 14|A magic number is used here. It needs to be defined properly.|CG|LOW|
| 5 |Game.java 166|Missing bracket on loop.|CG|MJ|
| 6 |Game.java 16|Identifier is too short, it is hard to understand what "name" it is referring to.| CS|LOW|
| 7 | Main.java 1|Missing a file banner -this is required for all public/src code files.|CG|MJ|
| 8 | Mina.java 1-27|Needs proper comments. Current comments are unhelpful.|MD|LOW|


> Category: CS – Code Smell defect. CG – Violation of a coding guideline. Provide the
guideline number. FD – Functional defect. Code will not produce the expected
result. MD – Miscellaneous defect, for all other defects.
> 
> Severity: BR - Blocker, must be fixed asap. MJ – Major, of high importance but not a Blocker LOW – Low.
