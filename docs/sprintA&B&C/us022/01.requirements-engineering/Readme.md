# US022 - Add a entry in the Agenda 


## 1. Requirements Engineering

### 1.1. User Story Description

As a GSM, I want to add a new entry in the Agenda.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	The Agenda is made up of entries that relate to a task (which was previously in the To-Do List).

>	Each entry in the Agenda has an expected duration and its status (Planned, Postponed, Canceled, Done).

>	The Green Spaces Manager fills in all the fields to add it to the Agenda.

**From the client clarifications:**

> **Question:** We also know that an Agenda entry has a target date, but is this target date supposed to be inputted upon transferring a task from the to-do list to the agenda, or is it supposed to be inputted upon creating the task in the to-do list?
>
> **Answer:** To-do list entries doesn't have dates!

> **Question:**
When a new entry is added to the ToDo list, the default status of that task will be "pending" or no status at all is considered on ToDo list?
Similarly, when a new entry is added to the Agenda, the status of that task will be, by default, set to "planned", right?
>
> **Answer:** "Pending" as default for to-do list entries and "Planned" as default for Agenda entries, sounds good;

> **Question:** When the GSM plans a task (that was previously in To-Do) into the Agenda, what aditional data/information does he need to input when planning?
>
> **Answer:** The starting date for the task.
Later the GSM will be able to add the Team and vehicles (if required).

### 1.3. Acceptance Criteria

* **AC1:** The new entry must be associated with a green space managed by the GSM.
* **AC2:** The new entry must exist in the To-Do list.
* **AC3:** The new entry added must have the status of Planned.
* **AC4:** Starting Date can only contain numbers and follow the format xx/xx/xxxx.
* **AC5:** Entry must not already be contained in the Agenda.
* **AC6:** System must ensure that only GSM adds a new entry in the Agenda.

### 1.4. Found out Dependencies

* There is a dependency on "US020 - Register a Green Space" as there must be at least one green space to be associated with the new entry in the agenda.
* There is a dependency on "US021 - Add a new entry to the To-Do List" because the new entry in the Agenda must exist in the To-Do List.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * Starting Date
	
* Selected data:
    * Task

**Output Data:**

* All data of the new entry in the Agenda
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us022-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* n/a