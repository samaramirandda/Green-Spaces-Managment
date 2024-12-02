# US007 - Register a Check-Up

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                    | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:--------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | RegisterCheckUpUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | RegisterCheckUpController | Controller                                                                                                    |
| 			  		        | 	... instantiating a new Task?                | RegisterCheckUp           | Creator (Rule 1): in the DM Organization has a Task.                                                          |
| Step 2  		     | 							                                       |                           |                                                                                                               |
| Step 3  		     | 	...saving the inputted data?                 | CheckUp                   | IE: object created in step 1 has its own data.                                                                |
| Step 4  		     | 	...knowing the check-up's to date?           | CheckUpRespository        | IE: owns all its check-up's.                                                                      |
| Step 5  		     | 							                                       |                           |                                                                                                               |              
| Step 6  		     | 	... validating all data (local validation)?  | CheckUp                   | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | CheckUpRepository         | IE: knows all its check-ups.                                                                                  | 
| 			  		        | 	... saving the created task?                 | CheckUpRepository         | IE: owns all its check-up's.                                                                                  | 
| Step 7  		     | 	... informing operation success?             | RegisterCheckUpUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Check-Up

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterCheckUpUI  
* RegisterCheckUpController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us007-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us007-sequence-diagram-split.svg)

**Register Check-Up**

![Sequence Diagram - Partial - Create Task](svg/us007-sequence-diagram-partial-create-checkup.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us007-class-diagram.svg)