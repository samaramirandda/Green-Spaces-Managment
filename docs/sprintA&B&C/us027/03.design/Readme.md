# US027 - List of Green Spaces managed by me 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for...   | Answer                        | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | ListGreenSpacesByGSMUI        | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | ListGreenSpaceByGSMController | Controller                                                                                                    |
| 			  		        | ... knowing the user using the system?        | AuthenticationRepository      | IE: cf. A&A component documentation.                                                                          |
| 			  		        | 							                                       | GreenSpaceManager             | IE: knows its own data (e.g. email)                                                                           |
| Step 4  		     | 	... saving the inputted data?                | GreenSpace                    | IE: Object created has its own data.                                                                          |           
| Step 7  		     | 	... validating all data (local validation)?  | GreenSpace                    | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | GreenSpaceRepository          | IE: knows all tasks.                                                                                          | 
| 			  		        | 	... saving the created task?                 | GreenSpaceRepository          | IE: owns all tasks.                                                                                           | 
| Step 8  		     | 	... informing operation success?             | ListGreenSpacesByGSMUI        | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* GreenSpace
* GreenSpaceRepository

Other software classes (i.e. Pure Fabrication) identified: 

* ListGreenSpacesByGSMUI  
* ListGreenSpaceByGSMController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative One is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us027-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us027-sequence-diagram-split.svg)

**Get Sorted Green Space By GSM dto List**

![Sequence Diagram - Partial - Get Sorted Green Space By GSM dto List](svg/us027-sequence-diagram-partial-get-sorted-green-spaces-by-gsm-dto-list.svg)

**Sort List By Algorithm**

![Sequence Diagram - Partial - Sort List By Algorithm](svg/us027-sequence-diagram-partial-sort-list-by-algorithm.svg)

**Get GSM From Session**

![Sequence Diagram - Partial - Get GSM From Session](svg/us027-sequence-diagram-partial-get-gsm-from-session.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us027-class-diagram.svg)