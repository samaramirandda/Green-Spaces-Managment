# US003 - Register collaborator with job and fundamental characteristics

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...     | Answer                          | Justification (with patterns)                                                                                                      |
|:---------------|:------------------------------------------------|:--------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?                | RegisterCollaboratorUI          | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model                       |
|   		           | 	... coordinating the US?                       | RegisterCollaboratorControlller | Controller                                                                                                                         |
| Step 2 		      | 	                                            |                              |                                                                                                                                    |
| Step 3 		      | 	... saving the inputted data?                  | Collaborator                    | Information Expert: object created in step 1 has its own data                                                                      |
| Step 4 		      | 	... knowing the job list to show?              | JobRepository                   | Information Expert: owns all jobs                                                                                                  |
| Step 5 		      | 	... saving the selected job?                   | Collaborator                    | Information Expert: object created has a job                                                                                       |
| Step 6 		      | 	                                               |                                 |                                                                                                                                    |
| Step 7 		      | 	... validating all data (local validation)?    | Collaborator                    | Information Expert: owns its data                                                                                                  |
| 		             | 	... validating all data (global validation)?   | CollaboratorRepository                    | Information Expert: knows all collaborators                                                                                        |
| 		             | 	... saving the registered collaborator?        | CollaboratorRepository          | Information Expert: owns all collaborators                                                                                         |
| Step 8 		      | 	... informing operation success?               | RegisterCollaboratorUI          | Information Expert: is responsible for user interactions.                                                                          |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Collaborator

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterCollaboratorUI  
* RegisterCollaboratorControlller


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us003-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us003-sequence-diagram-split.svg)

**Get Jobs List**

![Sequence Diagram - Partial - Get Jobs List](svg/us003-sequence-diagram-partial-get-jobs-list.svg)

**Get Job Object**

![Sequence Diagram - Partial - Get Job Object](svg/us003-sequence-diagram-partial-get-job-object.svg)

**Register Collaborator**

![Sequence Diagram - Partial - Get Register Collaborator](svg/us003-sequence-diagram-partial-register-collaborator.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us003-class-diagram.svg)