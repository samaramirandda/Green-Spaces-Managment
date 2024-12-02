# US021 - Add a new entry to the To-Do List 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                    | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:--------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | AddTaskToDoListUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | AddTaskToDoListController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?        | AuthenticationRepository  | IE: cf. A&A component documentation.                                                                          |
| 			  		        | 							                                       | GreenSpaceManager         | IE: knows its own data (e.g. email)                                                                           |
| Step 2  		     | 	...knowing the green list to show?           | GreenSpaceRepository      | Information Expert: owns all green spaces.                                                                    |
| Step 3  		     | 	...saving the selected green space?          | Task                      | IE: Object created has a green space.                                                                         |
| Step 4  		     | 	... saving the inputted data?                | Task                      | IE: Object created has its own data.                                                                          |           
| Step 7  		     | 	... validating all data (local validation)?  | Task                      | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | ToDoList                  | IE: knows all tasks.                                                                                          | 
| 			  		        | 	... saving the created task?                 | ToDoList                  | IE: owns all tasks.                                                                                           | 
| Step 8  		     | 	... informing operation success?             | AddTaskToDoListUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* ToDoList
* Task
* GreenSpaceRepository
* GreenSpace

Other software classes (i.e. Pure Fabrication) identified: 

* AddEntryToDoListUI  
* AddEntryToDoListController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us021-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us021-sequence-diagram-split.svg)

**Get Green Spaces DTO List**

![Sequence Diagram - Partial - Get Green Spaces DTO List](svg/us021-sequence-diagram-partial-get-green-spaces-dto-list.svg)

**Get Green Space By Name**

![Sequence Diagram - Partial - Get Green Space By Name](svg/us021-sequence-diagram-partial-get-green-space-by-name.svg)

**Get GSM email**

![Sequence Diagram - Partial - Get GSM Email](svg/us021-sequence-diagram-partial-get-gsm-email.svg)

**Create Task**

![Sequence Diagram - Partial - Create Task](svg/us021-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us021-class-diagram.svg)