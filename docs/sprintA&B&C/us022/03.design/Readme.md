# US022 - Add a entry in the Agenda 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for... | Answer                   | Justification (with patterns)                                                                                 |
|:---------------|:--------------------------------------------|:-------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?            | AddEntryAgendaUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                   | AddEntryAgendaController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?      | AuthenticationRepository | Information Expert: cf. A&A component documentation.                                                          |
| 			  		        | 							                                     | GreenSpaceManager        | IE: knows its own data (e.g. email)                                                                           |
| Step 2 		      | 	... knowing the to-do list to show?        | ToDoList                 | Information Expert: owns all tasks                                                                            |
| Step 3 		      | 	... saving the selected task?              | Entry                    | Information Expert: object created has a task                                                                 |
| Step 4 		      | 	                                            |                          |                                                                                                               |
| Step 5 		      | 	... saving the inputted data?                  | Entry                    | Information Expert: object created has its own data                                                           |
| Step 6 		      | 	                                               |                          |                                                                                                               |
| Step 7 		      | 	... validating all data (local validation)?    | Entry                    | Information Expert: owns its data                                                                             |
| 		             | 	... validating all data (global validation)?   | Agenda                   | Information Expert: knows all entries                                                                         |
| 		             | 	... saving the registered collaborator?        | Agenda                   | Information Expert: owns all entries                                                                    |
| Step 8 		      | 	... informing operation success?               | AddEntryAgendaUI   | Information Expert: is responsible for user interactions.                                                     |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Agenda
* Entry
* ToDoList
* GreenSpaceManager
* Task

Other software classes (i.e. Pure Fabrication) identified: 

* AddEntryAgendaUI  
* AddEntryAgendaController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us022-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us022-sequence-diagram-split.svg)

**Get Task Dto List**

![Sequence Diagram - Partial - Get Task Dto List](svg/us022-sequence-diagram-partial-get-tasks-dto-list.svg)

**Get Task Object**

![Sequence Diagram - Partial - Get Task Object](svg/us022-sequence-diagram-partial-get-task-object.svg)

**Get GSM Email**

![Sequence Diagram - Partial - Get GSM Email](svg/us022-sequence-diagram-partial-get-gsm-email.svg)

**Create Entry**

![Sequence Diagram - Partial - Create Entry](svg/us022-sequence-diagram-partial-create-entry.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us022-class-diagram.svg)