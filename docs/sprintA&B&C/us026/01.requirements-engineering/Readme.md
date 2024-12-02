# US026 - Assign Vehicles to an entry in the Agenda


## 1. Requirements Engineering

### 1.1. User Story Description

As a GSM, I want to assign one or more vehicles to an entry in the Agenda.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	Vehicles are needed to carry out the tasks assigned to the teams and to transport machines and equipment.

>	The Agenda is made set of entries related to a task where each one had vehicles/equipment assigned to the task.

>   The Green Spaces Manager is responsible for assigning the vehicles to the entry in the Agenda.

**From the client clarifications:**

> **Question:** Should all company vehicles be available to receive a agenda entry, or only vehicles with up-to-date maintenance?
>
> **Answer:** All vehicles that are not assigned to a task in the same period.
In a real context we also need to manage (un)availability of vehicles due to overhauls or breakdowns, but it is not necessary in this proof of concept.

> **Question:** Is the number of vehicles to be assigned provided by the Green Spaces Manager?
>
> **Answer:** There is no specification concerning the number of vehicles, is upt to GSM decide what vehicles the task needs.

> **Question:** How will the Green Spaces Manager choose the vehicle to assign? By its plate?
>
> **Answer:** Assuming you mean assingning to a Task/Agenda Entry, the data related with vehicle should be provided in order to ease the selection.

### 1.3. Acceptance Criteria

* **AC1:** The vehicles available to assign must not be assigned to a task in the same period.
* **AC2:** GSM will select one or more vehicles from the list of vehicles registered in US06.
* **AC3:** GSM will select an entry from those contained in the Agenda.
* **AC4:** System must ensure that only GSM assigns one or more vehicles to an Agenda entry.

### 1.4. Found out Dependencies

* There is a dependency on "US006 - Register a vehicle" as there must be at least one registered vehicle to be able to assign.
* There is a dependency on "US022 - Add a entry in the Agenda" as there must be at least one entry in the agenda.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
  * List of Vehicles
  * Entry in the Agenda

**Output Data:**

* All vehicles data
* Entry in the Agenda
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us026-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us026-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* n/a