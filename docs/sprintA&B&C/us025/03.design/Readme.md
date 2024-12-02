# US025 - Cancel an entry in the Agenda

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                      | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:----------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | CancelEntryAgendaUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | CancelEntryAgendaController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?        | AuthenticationRepository    | IE: cf. A&A component documentation.                                                                          |
| 			  		        | 							                                       | GreenSpaceManager           | IE: knows its own data (e.g. email)                                                                           |
| Step 2  		     | 	...knowing the entry list to show?           | Agenda                      | Information Expert: owns all entries.                                                                         |
| Step 3  		     | 	...saving the selected entry?                | Entry                       | IE: Object created has a entry.                                                                               |
| Step 4  		     | 	... saving the inputted data?                | Entry                       | IE: Object created has its own data.                                                                          |           
| Step 7  		     | 	... validating all data (local validation)?  | Entry                       | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | Agenda                      | IE: knows all tasks.                                                                                          | 
| 			  		        | 	... saving the created task?                 | Agenda                      | IE: owns all tasks.                                                                                           | 
| Step 8  		     | 	... informing operation success?             | CancelEntryAgendaUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Agenda
* Entry

Other software classes (i.e. Pure Fabrication) identified: 

* CancelEntryAgendaUI  
* CancelEntryAgendaController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us025-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us025-sequence-diagram-split.svg)

**Get Entries Dto List**

![Sequence Diagram - Partial - Get Entries Dto List](svg/us025-sequence-diagram-partial-get-entries-dto-list.svg)

**Get Entry By Index**

![Sequence Diagram - Partial - Get Entry By Index](svg/us025-sequence-diagram-partial-get-entry-by-index.svg)

**Get GSM email**

![Sequence Diagram - Partial - Get GSM email](svg/us025-sequence-diagram-partial-get-gsm-email.svg)

**Cancel Entry**

![Sequence Diagram - Partial - Cancel Entry](svg/us025-sequence-diagram-partial-cancel-entry.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us025-class-diagram.svg)