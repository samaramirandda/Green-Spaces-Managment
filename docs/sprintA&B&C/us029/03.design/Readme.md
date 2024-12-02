# US029 - Record the completion of a task 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                        | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | CompleteEntryAgendaUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | CompleteEntryAgendaController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?        | AuthenticationRepository      | IE: cf. A&A component documentation.                                                                          |
| 			  		        | 							                                       | Collaborator                  | IE: knows its own data (e.g. email)                                                                           |
| Step 2  		     | 	...knowing the entry list to show?           | Agenda                        | Information Expert: owns all entries.                                                                         |
| Step 3  		     | 	...saving the selected entry?                | Entry                         | IE: Object created has a entry.                                                                               |
| Step 4  		     | 	... saving the inputted data?                | Entry                         | IE: Object created has its own data.                                                                          |           
| Step 7  		     | 	... validating all data (local validation)?  | Entry                         | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | Agenda                        | IE: knows all tasks.                                                                                          | 
| 			  		        | 	... saving the created task?                 | Agenda                        | IE: owns all tasks.                                                                                           | 
| Step 8  		     | 	... informing operation success?             | CompleteEntryAgendaUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Agenda
* Entry

Other software classes (i.e. Pure Fabrication) identified: 

* CompleteEntryAgendaUI  
* CompleteEntryAgendaController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us029-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us029-sequence-diagram-split.svg)

**Get Entries Dto List**

![Sequence Diagram - Partial - Get Entries Dto List](svg/us029-sequence-diagram-partial-get-entries-dto-list.svg)

**Get Collaborator Email**

![Sequence Diagram - Partial - Get Collaborator Email](svg/us029-sequence-diagram-partial-get-collaborator-email.svg)

**Get Entry By Index**

![Sequence Diagram - Partial - Get Entry By Index](svg/us029-sequence-diagram-partial-get-entry-by-index.svg)

**Complete Entry**

![Sequence Diagram - Partial - Complete Entry](svg/us029-sequence-diagram-partial-complete-entry.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us029-class-diagram.svg)