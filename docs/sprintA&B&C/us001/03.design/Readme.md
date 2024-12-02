# US001 - Register Skills of a Collaborator 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                  | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | RegisterSkillUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | RegisterSkillController | Controller                                                                                                    |
| Step 2  		     | 							                                       |                         |                                                                                                               |
| Step 3  		     | 	...saving the inputted data?                 | Skill                   | IE: object created in step 1 has its own data.                                                                |
| Step 4  		     | 							                                       |                         |                                                                                                               |              
| Step 5  		     | 	... validating all data (local validation)?  | Skill                   | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | SkillRepository         | IE: knows all skills.                                                                                         | 
| 			  		        | 	... saving the registered skill?             | SkillRepository         | IE: owns all skills.                                                                                          | 
| Step 6  		     | 	... informing operation success?             | RegisterSkillUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Skill

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterSkillUI  
* CRegisterSkillController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us001-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us001-sequence-diagram-split.svg)

**Register Skill**

![Sequence Diagram - Partial - Get Task Category List](svg/us001-sequence-diagram-partial-register-skill.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us001-class-diagram.svg)